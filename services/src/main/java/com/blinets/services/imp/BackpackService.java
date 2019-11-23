package com.blinets.services.imp;

import com.blinets.dto.Item;
import java.util.ArrayList;
import java.util.List;

public class BackpackService<T extends Item> {

  private List<T> bestItems;

  private double maxW;

  private double bestPrice;

  public BackpackService(double _maxW) {
    maxW = _maxW;
  }


  //вычисляет общий вес набора предметов
  private double calcWeight(List<T> items) {
    double sumW = 0;

    for (T i : items
    ) {

      sumW += i.getWeight();
    }

    return sumW;
  }

  //вычисляет общую стоимость набора предметов
  private double calcPrice(List<T> items) {
    double sumPrice = 0;

    for (T i : items
    ) {
      sumPrice += i.getPrice();
    }

    return sumPrice;
  }


  private void checkSet(List<T> items) {
    if (bestItems == null) {
      if (calcWeight(items) <= maxW) {
        bestItems = items;
        bestPrice = calcPrice(items);
      }
    } else {
      if (calcWeight(items) <= maxW && calcPrice(items) > bestPrice) {
        bestItems = items;
        bestPrice = calcPrice(items);
      }
    }
  }

  public void makeAllSets(List<T> items) {
    if (items.size() > 0) {
      checkSet(items);
    }

    for (int i = 0; i < items.size(); i++) {
      List<T> newSet = new ArrayList<>(items);

      newSet.remove(i);

      makeAllSets(newSet);
    }


  }

  //возвращает решение задачи (набор предметов)
  public List<T> getResultForOptimalWeight(List<T> items) {
    makeAllSets(items);
    return bestItems;
  }


}