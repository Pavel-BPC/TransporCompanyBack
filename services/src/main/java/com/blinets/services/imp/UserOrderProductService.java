package com.blinets.services.imp;


import com.blinets.dto.GeneralMapsDto;
import com.blinets.dto.ProductDto;
import com.blinets.dto.UserOrderDto;
import com.blinets.dto.UserOrderProductDto;
import com.blinets.entity.Maps;
import com.blinets.entity.Product;
import com.blinets.entity.Route;
import com.blinets.entity.Transport;
import com.blinets.entity.UserOrder;
import com.blinets.exceptions.DontExistsObjectInDatabaseException;
import com.blinets.exceptions.UniqueObjectException;
import com.blinets.repository.MapsRepository;
import com.blinets.repository.PointRepository;
import com.blinets.repository.ProductRepository;
import com.blinets.repository.UserOrderRepository;
import com.blinets.repository.UserRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserOrderProductService {

  @Autowired
  private ProductRepository productRepository;
  @Autowired
  private UserOrderRepository userOrderRepository;
  @Autowired
  private PointRepository pointRepository;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private MapsRepository mapsRepository;


  public String createUserOrderProduct(UserOrderProductDto userOrderProductDto)
      throws DontExistsObjectInDatabaseException, UniqueObjectException {
    Product product = new Product();
    UserOrder userOrder = new UserOrder();

    userOrder.setIdOrder(UUID.randomUUID().toString());
    userOrder.setPrice(0);
    userOrder.setStatus("processing");
    userOrder.setFullTime(null);
    userOrder.setStartDate(null);
    userOrder.setEndDate(null);

    userOrder.setUser(userRepository.findByIdUser(userOrderProductDto.getIdUser()));

    userOrder.setMaps(null);

    userOrder
        .setStartIdPointOfRoute(pointRepository.findByIdPoint(userOrderProductDto.getStartPoint()));
    userOrder
        .setEndIdPointOfRoute(pointRepository.findByIdPoint(userOrderProductDto.getEndPoint()));

    userOrderRepository.save(userOrder);

    product.setIdProduct(UUID.randomUUID().toString());
    product.setIdUser(null);
    product.setNameProduct(userOrderProductDto.getName());
    product.setTypeProduct(userOrderProductDto.getTypeProduct());
    product.setWeightProduct(userOrderProductDto.getWeightProduct());
    product.setUserOrder(userOrder);

    productRepository.save(product);

    return userOrder.getIdOrder();
  }

  public List get() {
    return null;
  }

  public List<UserOrderDto> getUserOrder(String idUser) {
    List<UserOrder> userOrders = userOrderRepository
        .findByUser(userRepository.findByIdUser(idUser));
    List<UserOrderDto> userOrderDtos = new ArrayList<>();
    for (UserOrder userOrder : userOrders
    ) {
      UserOrderDto userOrderDto = new UserOrderDto();
      userOrderDto.setIdOrder(userOrder.getIdOrder());
      userOrderDto.setStatus(userOrder.getStatus());
      userOrderDto.setEnd_date(userOrder.getEndDate());
      userOrderDto.setStart_date(userOrder.getStartDate());
      userOrderDto.setPrice(userOrder.getPrice());
      userOrderDto.setName(productRepository.findByUserOrder(userOrder).get(0).getNameProduct());
      userOrderDtos.add(userOrderDto);
    }
    return userOrderDtos;
  }

  public Map<String, ProductDto> getProductByIdMaps(String idMap) {
    Maps map = mapsRepository.findByIdMaps(idMap);
    List<UserOrder> userOrders = userOrderRepository
        .findByStartIdPointOfRouteAndEndIdPointOfRoute(map.getStartIdPointOfRoute(),
            map.getEndIdPointOfRoute());

    Map<String, ProductDto> productDtos = new HashMap<>();
    for (UserOrder userOrder : userOrders
    ) {
      for (Product product : productRepository.findByUserOrder(userOrder)
      ) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getIdProduct());
        productDto.setName(product.getNameProduct());
        productDto.setWeight(product.getWeightProduct());
        if (product.getTypeProduct().equals("1")) {
          productDto.setPrice(product.getWeightProduct() * 75);
        } else {
          productDto.setPrice(product.getWeightProduct() * 50);
        }
        productDtos.put(productDto.getId(), productDto);
      }
    }
    return productDtos;

  }

  public List<ProductDto> getOptimalProduct(String idMap) {
    Map<String, ProductDto> productByIdMaps = getProductByIdMaps(idMap);
    Maps byIdMaps = mapsRepository.findByIdMaps(idMap);
    Route idNextRoute = byIdMaps.getIdNextRoute();
    Transport idTransport = idNextRoute.getIdTransport();

    BackpackService<ProductDto> backpackService = new BackpackService<ProductDto>(
        idTransport.getMaxWeight());
    List<ProductDto> resultForOptimalWeight = backpackService
        .getResultForOptimalWeight(new ArrayList<>(productByIdMaps.values()));
    return resultForOptimalWeight;

  }



  public void remove(String id) {

  }

  public void update(Object object) throws DontExistsObjectInDatabaseException {

  }
}
