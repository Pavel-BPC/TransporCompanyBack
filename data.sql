-- Actual parameter values may differ, what you see is a default string representation of values
INSERT INTO public.user_s (id_user,active,login_email,"password","role")
VALUES ('cbd29f42-a5cc-4e9c-a906-8b2e842244db',1,'user','$2a$10$cbQMrzeqnSZrvtU34CIp3u4j1Sg2AvQRzuOfHqRi2yG7xiNby7qcC','USER');
INSERT INTO public.user_s (id_user,active,login_email,"password","role")
VALUES ('f813bf5b-d797-4285-84c5-eabda5154268',1,'admin','$2a$10$heLUJ2pO2GOGqMhAcw0Ux.qtUkjm8B/wd/bjhG98oQ8at1ZZhqthe','ADMIN');
INSERT INTO public.user_s (id_user,active,login_email,"password","role")
VALUES ('9cc3a063-8ba1-4321-9204-5d1bf3b67520',1,'carrier','$2a$10$oEcK7ArCOos1itotIn3bSOokeX0JXDI.AG2tMFbuT0q5lKM7yMZ/q','CARRIER');
INSERT INTO public.user_s (id_user,active,last_name,login_email,"name","password",phone_number,"role")
VALUES ('425cbb54-b788-4d1f-9f75-2a0cfbfc5c8d',0,'Блинец','pavel','Павел','$2a$10$pBlfmLod9bcLBwBHowG4HeBnFbYei7Cf0VtgWRCoYEH7Rs.wROM56','37529-123-45-56','USER');
INSERT INTO public.user_s (id_user,active,last_name,login_email,"name","password",phone_number,"role")
VALUES ('242c5d3e-5c5a-41a9-8a27-a448b37e737b',0,'Клезович','anastasia','Анастасия','$2a$10$pfmxU61daWWFPgBvvz3XQ.jEwq3pwWiZS44FvsVtWA2CtXm.By9.m','37529-123-45-56','CARRIER');


-- Actual parameter values may differ, what you see is a default string representation of values
INSERT INTO public.point (id_point,name_point)
VALUES ('459c7b45-bddc-48af-affd-30f4268aa946','Клецк');
INSERT INTO public.point (id_point,name_point)
VALUES ('cbd29f42-a5cc-4e9c-a906-8b2e842244db','Солигорск');
INSERT INTO public.point (id_point,name_point)
VALUES ('5db17bc6-1bd7-4a0b-b043-604ca718e06f','Минск');
INSERT INTO public.point (id_point,name_point)
VALUES ('8211e92f-ba50-41f1-b99c-c961353d90bf','Гродно');
INSERT INTO public.point (id_point,name_point)
VALUES ('dad7d429-8f2d-4e22-af40-a3cb929cbddc','Орша');
INSERT INTO public.point (id_point,name_point)
VALUES ('45b09dec-323e-4e70-b7f9-ce877efb1616','Речица');
INSERT INTO public.point (id_point,name_point)
VALUES ('a1cd3ad9-a75e-432f-8038-d98dfbbe2c87','Ганцевичи');
INSERT INTO public.point (id_point,name_point)
VALUES ('a842e2e0-0788-470b-ac58-d1fc4fd61ffe','Молодечно');
INSERT INTO public.point (id_point,name_point)
VALUES ('cf10ec65-7ea4-4a27-9311-70660f78a600','Слуцк');
INSERT INTO public.point (id_point,name_point)
VALUES ('c7ce30f8-ac1a-4c16-88b1-e6648b318dca','Несвиж');
INSERT INTO public.point (id_point,name_point)
VALUES ('9556d363-3df1-4f47-a3ce-78554af9ebbd','Витебск');



-- Actual parameter values may differ, what you see is a default string representation of values
INSERT INTO public.company (id_company,description,email_company,name_company,phone_company)
VALUES ('696ea116-8305-4e65-899b-07d27b49cfb2','descript','mail','Blinets','123465');
INSERT INTO public.company (id_company,description,email_company,name_company,phone_company)
VALUES ('de871baf-b12a-4bcb-9915-b303d7f41813','descript','mail','Klezovich','789465');
INSERT INTO public.company (id_company,description,email_company,name_company,phone_company)
VALUES ('cd992266-26b5-425d-9fff-2a8b63c028e4','Grisha is best ','mail@mail.com','Grisha','37529-123-45-56');
INSERT INTO public.company (id_company,description,email_company,name_company,phone_company)
VALUES ('bcd224b8-f5c7-4a4a-824e-af98ff90fc30','Grisha v2 is best ','mail@mail.com','Grisha v2','37529-123-45-56');



-- Actual parameter values may differ, what you see is a default string representation of values
INSERT INTO public.transport (id_transport,max_weight,name_transport,speed,tariff_plan,id_company)
VALUES ('a3ba172f-d772-487e-a820-5e4595e96be5',300,'Трактор',1,45,'de871baf-b12a-4bcb-9915-b303d7f41813');
INSERT INTO public.transport (id_transport,max_weight,name_transport,speed,tariff_plan,id_company)
VALUES ('16995a17-a0fc-46e0-a602-dc54b7dc462c',150,'Маз',3,76,'de871baf-b12a-4bcb-9915-b303d7f41813');
INSERT INTO public.transport (id_transport,max_weight,name_transport,speed,tariff_plan,id_company)
VALUES ('4dbae581-4aae-4018-af66-0520525542d4',250,'Белаз',2,36,'696ea116-8305-4e65-899b-07d27b49cfb2');
INSERT INTO public.transport (id_transport,max_weight,name_transport,speed,tariff_plan,id_company)
VALUES ('0cbce512-9cd3-4cf1-b32a-8cdda4c93065',400,'Камаз',4,90,'696ea116-8305-4e65-899b-07d27b49cfb2');
INSERT INTO public.transport (id_transport,max_weight,name_transport,speed,tariff_plan,id_company)
VALUES ('e00bea41-c597-40fb-9dfd-f4529676cc1d',750,'Tesla',120,35,'cd992266-26b5-425d-9fff-2a8b63c028e4');
INSERT INTO public.transport (id_transport,max_weight,name_transport,speed,tariff_plan,id_company)
VALUES ('be6b4c56-10ff-4b5b-a385-2fa44543224d',900,'Citroën',120,55,'bcd224b8-f5c7-4a4a-824e-af98ff90fc30');

-- Actual parameter values may differ, what you see is a default string representation of values
INSERT INTO public.route (id_route,"cost",distance,next_id_route,"time",end_id_point_route,id_transport,start_id_point_route)
VALUES ('cab7372a-b183-4260-bb1a-609bac8040be',100,100,'9b55998c-7c42-47cd-b222-53f969c6caea',20,'cbd29f42-a5cc-4e9c-a906-8b2e842244db','a3ba172f-d772-487e-a820-5e4595e96be5','459c7b45-bddc-48af-affd-30f4268aa946');
INSERT INTO public.route (id_route,"cost",distance,next_id_route,"time",end_id_point_route,id_transport,start_id_point_route)
VALUES ('9b55998c-7c42-47cd-b222-53f969c6caea',200,100,'97469289-e517-4bb9-b7bf-100f315f5c94',20,'5db17bc6-1bd7-4a0b-b043-604ca718e06f','16995a17-a0fc-46e0-a602-dc54b7dc462c','cbd29f42-a5cc-4e9c-a906-8b2e842244db');
INSERT INTO public.route (id_route,"cost",distance,"time",end_id_point_route,id_transport,start_id_point_route)
VALUES ('97469289-e517-4bb9-b7bf-100f315f5c94',40,200,30,'8211e92f-ba50-41f1-b99c-c961353d90bf','4dbae581-4aae-4018-af66-0520525542d4','5db17bc6-1bd7-4a0b-b043-604ca718e06f');
INSERT INTO public.route (id_route,"cost",distance,next_id_route,"time",end_id_point_route,id_transport,start_id_point_route)
VALUES ('b6020d7a-0f1c-41ce-bac1-394832b94362',100,100,'2e0a8b01-db8e-464f-81df-9302d38e6b6c',20,'cbd29f42-a5cc-4e9c-a906-8b2e842244db','a3ba172f-d772-487e-a820-5e4595e96be5','459c7b45-bddc-48af-affd-30f4268aa946');
INSERT INTO public.route (id_route,"cost",distance,next_id_route,"time",end_id_point_route,id_transport,start_id_point_route)
VALUES ('2e0a8b01-db8e-464f-81df-9302d38e6b6c',200,100,'9fcf56e2-e08a-4db1-9d03-b7ed2ee4d90a',20,'5db17bc6-1bd7-4a0b-b043-604ca718e06f','16995a17-a0fc-46e0-a602-dc54b7dc462c','cbd29f42-a5cc-4e9c-a906-8b2e842244db');
INSERT INTO public.route (id_route,"cost",distance,next_id_route,"time",end_id_point_route,id_transport,start_id_point_route)
VALUES ('9fcf56e2-e08a-4db1-9d03-b7ed2ee4d90a',40,200,'4e7c4269-0290-4784-9e2a-b4747228a43b',30,'8211e92f-ba50-41f1-b99c-c961353d90bf','4dbae581-4aae-4018-af66-0520525542d4','5db17bc6-1bd7-4a0b-b043-604ca718e06f');
INSERT INTO public.route (id_route,"cost",distance,"time",end_id_point_route,id_transport,start_id_point_route)
VALUES ('4e7c4269-0290-4784-9e2a-b4747228a43b',17,321,50,'dad7d429-8f2d-4e22-af40-a3cb929cbddc','4dbae581-4aae-4018-af66-0520525542d4','8211e92f-ba50-41f1-b99c-c961353d90bf');
INSERT INTO public.route (id_route,"cost",distance,next_id_route,"time",end_id_point_route,id_transport,start_id_point_route)
VALUES ('101a51f5-3dfb-43bf-a732-ae4fc501d640',100,100,'2c7bda3c-9e93-451a-b483-86914c633998',20,'cbd29f42-a5cc-4e9c-a906-8b2e842244db','a3ba172f-d772-487e-a820-5e4595e96be5','459c7b45-bddc-48af-affd-30f4268aa946');
INSERT INTO public.route (id_route,"cost",distance,next_id_route,"time",end_id_point_route,id_transport,start_id_point_route)
VALUES ('2c7bda3c-9e93-451a-b483-86914c633998',200,100,'53e08a4d-8df8-4245-b063-a6b501db4343',20,'5db17bc6-1bd7-4a0b-b043-604ca718e06f','16995a17-a0fc-46e0-a602-dc54b7dc462c','cbd29f42-a5cc-4e9c-a906-8b2e842244db');
INSERT INTO public.route (id_route,"cost",distance,next_id_route,"time",end_id_point_route,id_transport,start_id_point_route)
VALUES ('53e08a4d-8df8-4245-b063-a6b501db4343',40,200,'08742024-6ef6-4502-814b-9537a2b0e498',30,'8211e92f-ba50-41f1-b99c-c961353d90bf','4dbae581-4aae-4018-af66-0520525542d4','5db17bc6-1bd7-4a0b-b043-604ca718e06f');
INSERT INTO public.route (id_route,"cost",distance,next_id_route,"time",end_id_point_route,id_transport,start_id_point_route)
VALUES ('08742024-6ef6-4502-814b-9537a2b0e498',17,321,'10d0773a-fba8-41df-86ab-b3d7f971757f',50,'dad7d429-8f2d-4e22-af40-a3cb929cbddc','4dbae581-4aae-4018-af66-0520525542d4','8211e92f-ba50-41f1-b99c-c961353d90bf');
INSERT INTO public.route (id_route,"cost",distance,"time",end_id_point_route,id_transport,start_id_point_route)
VALUES ('10d0773a-fba8-41df-86ab-b3d7f971757f',34,54,65,'45b09dec-323e-4e70-b7f9-ce877efb1616','4dbae581-4aae-4018-af66-0520525542d4','dad7d429-8f2d-4e22-af40-a3cb929cbddc');
INSERT INTO public.route (id_route,"cost",distance,next_id_route,"time",end_id_point_route,id_transport,start_id_point_route)
VALUES ('87b5c720-0098-47fe-b0d9-5d790582ac6b',45,23,'a15827ef-bee5-43ae-8a4b-74a2250782b2',120,'cbd29f42-a5cc-4e9c-a906-8b2e842244db','a3ba172f-d772-487e-a820-5e4595e96be5','459c7b45-bddc-48af-affd-30f4268aa946');
INSERT INTO public.route (id_route,"cost",distance,next_id_route,"time",end_id_point_route,id_transport,start_id_point_route)
VALUES ('a15827ef-bee5-43ae-8a4b-74a2250782b2',36,43,'ccc71215-bdda-4329-9593-4249eed49f00',14,'5db17bc6-1bd7-4a0b-b043-604ca718e06f','16995a17-a0fc-46e0-a602-dc54b7dc462c','cbd29f42-a5cc-4e9c-a906-8b2e842244db');
INSERT INTO public.route (id_route,"cost",distance,next_id_route,"time",end_id_point_route,id_transport,start_id_point_route)
VALUES ('ccc71215-bdda-4329-9593-4249eed49f00',34,45,'2e4d690a-6f83-4992-ab54-3931d3e747f1',14,'8211e92f-ba50-41f1-b99c-c961353d90bf','0cbce512-9cd3-4cf1-b32a-8cdda4c93065','5db17bc6-1bd7-4a0b-b043-604ca718e06f');
INSERT INTO public.route (id_route,"cost",distance,next_id_route,"time",end_id_point_route,id_transport,start_id_point_route)
VALUES ('2e4d690a-6f83-4992-ab54-3931d3e747f1',36,43,'3172cb4f-1792-48d4-8bc8-3648b2291fd3',14,'5db17bc6-1bd7-4a0b-b043-604ca718e06f','16995a17-a0fc-46e0-a602-dc54b7dc462c','cbd29f42-a5cc-4e9c-a906-8b2e842244db');
INSERT INTO public.route (id_route,"cost",distance,"time",end_id_point_route,id_transport,start_id_point_route)
VALUES ('3172cb4f-1792-48d4-8bc8-3648b2291fd3',45,17,52,'a1cd3ad9-a75e-432f-8038-d98dfbbe2c87','16995a17-a0fc-46e0-a602-dc54b7dc462c','8211e92f-ba50-41f1-b99c-c961353d90bf');
INSERT INTO public.route (id_route,"cost",distance,next_id_route,"time",end_id_point_route,id_transport,start_id_point_route)
VALUES ('fa84be08-1ee2-4e2d-827a-03c55c1ba2e2',3,23,'f09bd626-e968-45a0-9809-aab1582f0f8b',43,'9556d363-3df1-4f47-a3ce-78554af9ebbd','a3ba172f-d772-487e-a820-5e4595e96be5','cf10ec65-7ea4-4a27-9311-70660f78a600');
INSERT INTO public.route (id_route,"cost",distance,next_id_route,"time",end_id_point_route,id_transport,start_id_point_route)
VALUES ('f09bd626-e968-45a0-9809-aab1582f0f8b',43,23,'4599c604-6f0d-48bb-b6c4-7b2e181d8263',23,'cf10ec65-7ea4-4a27-9311-70660f78a600','0cbce512-9cd3-4cf1-b32a-8cdda4c93065','dad7d429-8f2d-4e22-af40-a3cb929cbddc');
INSERT INTO public.route (id_route,"cost",distance,"time",end_id_point_route,id_transport,start_id_point_route)
VALUES ('4599c604-6f0d-48bb-b6c4-7b2e181d8263',54,43,34,'dad7d429-8f2d-4e22-af40-a3cb929cbddc','e00bea41-c597-40fb-9dfd-f4529676cc1d','a842e2e0-0788-470b-ac58-d1fc4fd61ffe');


-- Actual parameter values may differ, what you see is a default string representation of values
INSERT INTO public.maps (id_maps,end_id_point,id_next_route,start_id_point)
VALUES ('4c49cadc-b5b4-4c5c-9dfd-c1917ff3f36b','8211e92f-ba50-41f1-b99c-c961353d90bf','cab7372a-b183-4260-bb1a-609bac8040be','459c7b45-bddc-48af-affd-30f4268aa946');
INSERT INTO public.maps (id_maps,end_id_point,id_next_route,start_id_point)
VALUES ('a8db4d2f-1a29-4e7e-bf27-05695ce647b7','dad7d429-8f2d-4e22-af40-a3cb929cbddc','b6020d7a-0f1c-41ce-bac1-394832b94362','459c7b45-bddc-48af-affd-30f4268aa946');
INSERT INTO public.maps (id_maps,end_id_point,id_next_route,start_id_point)
VALUES ('19cdacfa-9515-4bfb-bb0f-434add42cb71','45b09dec-323e-4e70-b7f9-ce877efb1616','101a51f5-3dfb-43bf-a732-ae4fc501d640','459c7b45-bddc-48af-affd-30f4268aa946');
INSERT INTO public.maps (id_maps,end_id_point,id_next_route,start_id_point)
VALUES ('65a7f247-38e2-48ad-9fe4-d0e9ac2b170a','a1cd3ad9-a75e-432f-8038-d98dfbbe2c87','87b5c720-0098-47fe-b0d9-5d790582ac6b','459c7b45-bddc-48af-affd-30f4268aa946');
INSERT INTO public.maps (id_maps,end_id_point,id_next_route,start_id_point)
VALUES ('71443646-583a-4e38-ba1e-1ad52f4c5eef','dad7d429-8f2d-4e22-af40-a3cb929cbddc','fa84be08-1ee2-4e2d-827a-03c55c1ba2e2','cf10ec65-7ea4-4a27-9311-70660f78a600');

-- Actual parameter values may differ, what you see is a default string representation of values
INSERT INTO public.user_order (id_user_order,price,status,end_id_point_route,start_id_point_route,id_user)
VALUES ('eb5d457d-7095-4ea1-bdbc-2abe0af9bc51',0,'processing','8211e92f-ba50-41f1-b99c-c961353d90bf','459c7b45-bddc-48af-affd-30f4268aa946','cbd29f42-a5cc-4e9c-a906-8b2e842244db');
INSERT INTO public.user_order (id_user_order,price,status,end_id_point_route,start_id_point_route,id_user)
VALUES ('e1a5a9a2-584a-4ae6-80d3-a118469646e0',0,'processing','dad7d429-8f2d-4e22-af40-a3cb929cbddc','459c7b45-bddc-48af-affd-30f4268aa946','cbd29f42-a5cc-4e9c-a906-8b2e842244db');
INSERT INTO public.user_order (id_user_order,price,status,end_id_point_route,start_id_point_route,id_user)
VALUES ('cde1e24c-56db-4841-88f0-0833e886e53d',0,'processing','dad7d429-8f2d-4e22-af40-a3cb929cbddc','cf10ec65-7ea4-4a27-9311-70660f78a600','cbd29f42-a5cc-4e9c-a906-8b2e842244db');
INSERT INTO public.user_order (id_user_order,price,status,end_id_point_route,start_id_point_route,id_user)
VALUES ('8641289a-22ef-4513-aaf6-de5ae3086f9c',0,'processing','dad7d429-8f2d-4e22-af40-a3cb929cbddc','cf10ec65-7ea4-4a27-9311-70660f78a600','cbd29f42-a5cc-4e9c-a906-8b2e842244db');
INSERT INTO public.user_order (id_user_order,price,status,end_id_point_route,start_id_point_route,id_user)
VALUES ('7a9eb9b1-64bc-42c6-9855-f27c4b2259fd',0,'processing','a1cd3ad9-a75e-432f-8038-d98dfbbe2c87','459c7b45-bddc-48af-affd-30f4268aa946','cbd29f42-a5cc-4e9c-a906-8b2e842244db');
INSERT INTO public.user_order (id_user_order,price,status,end_id_point_route,start_id_point_route,id_user)
VALUES ('d7f9cd70-e7d4-475c-93e1-d6226e542d24',0,'processing','45b09dec-323e-4e70-b7f9-ce877efb1616','459c7b45-bddc-48af-affd-30f4268aa946','cbd29f42-a5cc-4e9c-a906-8b2e842244db');
INSERT INTO public.user_order (id_user_order,price,status,end_id_point_route,start_id_point_route,id_user)
VALUES ('ba85396f-eddd-4199-87ce-d3d8657c2914',0,'processing','dad7d429-8f2d-4e22-af40-a3cb929cbddc','459c7b45-bddc-48af-affd-30f4268aa946','cbd29f42-a5cc-4e9c-a906-8b2e842244db');
INSERT INTO public.user_order (id_user_order,price,status,end_id_point_route,start_id_point_route,id_user)
VALUES ('fac44171-4011-4e93-934a-ff74908544ad',0,'processing','dad7d429-8f2d-4e22-af40-a3cb929cbddc','459c7b45-bddc-48af-affd-30f4268aa946','cbd29f42-a5cc-4e9c-a906-8b2e842244db');
INSERT INTO public.user_order (id_user_order,price,status,end_id_point_route,start_id_point_route,id_user)
VALUES ('05d02025-5f73-4438-a7f8-1e23b58f25cb',0,'processing','dad7d429-8f2d-4e22-af40-a3cb929cbddc','459c7b45-bddc-48af-affd-30f4268aa946','cbd29f42-a5cc-4e9c-a906-8b2e842244db');
INSERT INTO public.user_order (id_user_order,price,status,end_id_point_route,start_id_point_route,id_user)
VALUES ('873e1bde-dd57-401e-a66e-d87ff60f48fe',0,'processing','dad7d429-8f2d-4e22-af40-a3cb929cbddc','cf10ec65-7ea4-4a27-9311-70660f78a600','cbd29f42-a5cc-4e9c-a906-8b2e842244db');
INSERT INTO public.user_order (id_user_order,price,status,end_id_point_route,start_id_point_route,id_user)
VALUES ('30c1b8f9-ef7d-46e7-85d0-1d8ee946c4d6',0,'processing','dad7d429-8f2d-4e22-af40-a3cb929cbddc','cf10ec65-7ea4-4a27-9311-70660f78a600','cbd29f42-a5cc-4e9c-a906-8b2e842244db');
INSERT INTO public.user_order (id_user_order,price,status,end_id_point_route,start_id_point_route,id_user)
VALUES ('8fc78545-1fe3-45e3-941a-8e08ad3fe543',0,'processing','8211e92f-ba50-41f1-b99c-c961353d90bf','459c7b45-bddc-48af-affd-30f4268aa946','cbd29f42-a5cc-4e9c-a906-8b2e842244db');
INSERT INTO public.user_order (id_user_order,price,status,end_id_point_route,start_id_point_route,id_user)
VALUES ('559d932f-a228-4020-811c-7f4e64c8b97d',0,'processing','8211e92f-ba50-41f1-b99c-c961353d90bf','459c7b45-bddc-48af-affd-30f4268aa946','cbd29f42-a5cc-4e9c-a906-8b2e842244db');
INSERT INTO public.user_order (id_user_order,price,status,end_id_point_route,start_id_point_route,id_user)
VALUES ('4684513a-b6d1-4274-bbec-886e2886cb4b',0,'processing','8211e92f-ba50-41f1-b99c-c961353d90bf','459c7b45-bddc-48af-affd-30f4268aa946','cbd29f42-a5cc-4e9c-a906-8b2e842244db');
INSERT INTO public.user_order (id_user_order,price,status,end_id_point_route,start_id_point_route,id_user)
VALUES ('8bccac13-afc6-474f-a999-5da9df558ce8',0,'processing','8211e92f-ba50-41f1-b99c-c961353d90bf','459c7b45-bddc-48af-affd-30f4268aa946','cbd29f42-a5cc-4e9c-a906-8b2e842244db');
INSERT INTO public.user_order (id_user_order,end_date,price,start_date,status,end_id_point_route,start_id_point_route,id_user)
VALUES ('5a96d15d-aee5-4cba-837d-d432d588baca','2019-12-18',6775,'2019-12-13','In progress','dad7d429-8f2d-4e22-af40-a3cb929cbddc','cf10ec65-7ea4-4a27-9311-70660f78a600','cbd29f42-a5cc-4e9c-a906-8b2e842244db');
INSERT INTO public.user_order (id_user_order,end_date,price,start_date,status,end_id_point_route,start_id_point_route,id_user)
VALUES ('25ce5b0a-d642-43ee-a0fb-61d38f7c4895','2019-12-18',124700,'2019-12-13','In progress','dad7d429-8f2d-4e22-af40-a3cb929cbddc','cf10ec65-7ea4-4a27-9311-70660f78a600','cbd29f42-a5cc-4e9c-a906-8b2e842244db');
INSERT INTO public.user_order (id_user_order,end_date,price,start_date,status,end_id_point_route,start_id_point_route,id_user)
VALUES ('0bb637a0-7237-4e2a-b8c4-c76147c1b7c3','2019-12-18',124700,'2019-12-13','In progress','dad7d429-8f2d-4e22-af40-a3cb929cbddc','cf10ec65-7ea4-4a27-9311-70660f78a600','cbd29f42-a5cc-4e9c-a906-8b2e842244db');
INSERT INTO public.user_order (id_user_order,end_date,price,start_date,status,end_id_point_route,start_id_point_route,id_user)
VALUES ('42d22c73-c990-40b8-bb8d-d4093b0d65a4','2019-12-18',1947057,'2019-12-13','In progress','dad7d429-8f2d-4e22-af40-a3cb929cbddc','459c7b45-bddc-48af-affd-30f4268aa946','cbd29f42-a5cc-4e9c-a906-8b2e842244db');
INSERT INTO public.user_order (id_user_order,end_date,price,start_date,status,end_id_point_route,start_id_point_route,id_user)
VALUES ('369a6017-7ec3-47f8-a75b-c88dd4efd1d5','2019-12-16',200340,'2019-12-13','In progress','8211e92f-ba50-41f1-b99c-c961353d90bf','459c7b45-bddc-48af-affd-30f4268aa946','cbd29f42-a5cc-4e9c-a906-8b2e842244db');
INSERT INTO public.user_order (id_user_order,end_date,price,start_date,status,end_id_point_route,start_id_point_route,id_user)
VALUES ('9fcdc4e1-c003-419b-80a4-35755c472d02','2019-12-16',300340,'2019-12-13','In progress','8211e92f-ba50-41f1-b99c-c961353d90bf','459c7b45-bddc-48af-affd-30f4268aa946','cbd29f42-a5cc-4e9c-a906-8b2e842244db');
INSERT INTO public.user_order (id_user_order,end_date,price,start_date,status,end_id_point_route,start_id_point_route,id_user)
VALUES ('2b22ead5-251b-4c7a-8145-d63bb3c43d4f','2019-12-16',200340,'2019-12-13','In progress','8211e92f-ba50-41f1-b99c-c961353d90bf','459c7b45-bddc-48af-affd-30f4268aa946','cbd29f42-a5cc-4e9c-a906-8b2e842244db');
INSERT INTO public.user_order (id_user_order,end_date,price,start_date,status,end_id_point_route,start_id_point_route,id_user)
VALUES ('f2e5cb90-7cfe-4713-a16d-2153550ec86f','2019-12-21',77891,'2019-12-13','In progress','45b09dec-323e-4e70-b7f9-ce877efb1616','459c7b45-bddc-48af-affd-30f4268aa946','cbd29f42-a5cc-4e9c-a906-8b2e842244db');


-- Actual parameter values may differ, what you see is a default string representation of values
INSERT INTO public.product (id_product,name_product,type_product,weight_product,id_user_order)
VALUES ('9bf19653-c6af-41c7-9b64-77bfab096697','Торф','1',100,'2b22ead5-251b-4c7a-8145-d63bb3c43d4f');
INSERT INTO public.product (id_product,name_product,type_product,weight_product,id_user_order)
VALUES ('651faf11-d411-45ce-943c-8f1629d1aff3','Уголь','1',100,'369a6017-7ec3-47f8-a75b-c88dd4efd1d5');
INSERT INTO public.product (id_product,name_product,type_product,weight_product,id_user_order)
VALUES ('7b345e4d-49e1-4607-b8ee-64b23a77cbaf','Стаканчики','2',50,'eb5d457d-7095-4ea1-bdbc-2abe0af9bc51');
INSERT INTO public.product (id_product,name_product,type_product,weight_product,id_user_order)
VALUES ('a499d35e-5b76-4931-aab2-01023005cf95','Столы','2',75,'9fcdc4e1-c003-419b-80a4-35755c472d02');
INSERT INTO public.product (id_product,name_product,type_product,weight_product,id_user_order)
VALUES ('f18229a2-62cf-4274-84c8-508c323a2e76','Столы','2',75,'e1a5a9a2-584a-4ae6-80d3-a118469646e0');
INSERT INTO public.product (id_product,name_product,type_product,weight_product,id_user_order)
VALUES ('0c5a113a-94f4-4455-8656-2ede7e47dab7','Тумбы','1',20,'f2e5cb90-7cfe-4713-a16d-2153550ec86f');
INSERT INTO public.product (id_product,name_product,type_product,weight_product,id_user_order)
VALUES ('1a474052-379e-4da2-a013-ac8b0a142636','АнтиГрипин','1',15,'5a96d15d-aee5-4cba-837d-d432d588baca');
INSERT INTO public.product (id_product,name_product,type_product,weight_product,id_user_order)
VALUES ('67ed6d9e-1195-41bb-a890-64b297c4de2f','Ракетки','2',36,'cde1e24c-56db-4841-88f0-0833e886e53d');
INSERT INTO public.product (id_product,name_product,type_product,weight_product,id_user_order)
VALUES ('23556051-7a22-4b12-9e37-2d0c139ffa70','Утюг','1',360,'8641289a-22ef-4513-aaf6-de5ae3086f9c');
INSERT INTO public.product (id_product,name_product,type_product,weight_product,id_user_order)
VALUES ('a93934fd-a2e7-4dfb-b28d-24f2e30594e5','Утюг','1',360,'7a9eb9b1-64bc-42c6-9855-f27c4b2259fd');
INSERT INTO public.product (id_product,name_product,type_product,weight_product,id_user_order)
VALUES ('d7ae4e60-8256-407e-99f6-633f3a19b1e2','Утюг','1',360,'d7f9cd70-e7d4-475c-93e1-d6226e542d24');
INSERT INTO public.product (id_product,name_product,type_product,weight_product,id_user_order)
VALUES ('7b44abf7-361e-478e-ae2a-5ef2f87267e3','Утюг','1',360,'ba85396f-eddd-4199-87ce-d3d8657c2914');
INSERT INTO public.product (id_product,name_product,type_product,weight_product,id_user_order)
VALUES ('289ab8da-2ec7-4fbd-b8bd-3ff1f8856c41','Фен','2',270,'42d22c73-c990-40b8-bb8d-d4093b0d65a4');
INSERT INTO public.product (id_product,name_product,type_product,weight_product,id_user_order)
VALUES ('dccc8c4c-0746-4e9c-92d1-621bfd56fe97','Фен','2',270,'fac44171-4011-4e93-934a-ff74908544ad');
INSERT INTO public.product (id_product,name_product,type_product,weight_product,id_user_order)
VALUES ('7cef36cf-761c-4a3d-948d-ae97cb83499b','Фен','2',270,'05d02025-5f73-4438-a7f8-1e23b58f25cb');
INSERT INTO public.product (id_product,name_product,type_product,weight_product,id_user_order)
VALUES ('308acb0c-f500-4294-80b7-d0f44157453b','Фен','2',270,'873e1bde-dd57-401e-a66e-d87ff60f48fe');
INSERT INTO public.product (id_product,name_product,type_product,weight_product,id_user_order)
VALUES ('390c9bfa-0372-4158-9a1e-f797e617d508','Фен','2',270,'30c1b8f9-ef7d-46e7-85d0-1d8ee946c4d6');
INSERT INTO public.product (id_product,name_product,type_product,weight_product,id_user_order)
VALUES ('a4c1b3e8-ae9f-4aab-bc4f-8e55d2f6ee5b','Ножницы','2',140,'0bb637a0-7237-4e2a-b8c4-c76147c1b7c3');
INSERT INTO public.product (id_product,name_product,type_product,weight_product,id_user_order)
VALUES ('712da4df-5799-493d-aa05-ac859401d795','Ножницы','2',140,'25ce5b0a-d642-43ee-a0fb-61d38f7c4895');
INSERT INTO public.product (id_product,name_product,type_product,weight_product,id_user_order)
VALUES ('abf61349-327a-4adc-8beb-b7031d0f4581','Ножницы','2',140,'8fc78545-1fe3-45e3-941a-8e08ad3fe543');
INSERT INTO public.product (id_product,name_product,type_product,weight_product,id_user_order)
VALUES ('b0ad32f0-ccfc-41de-993f-c7d9dbf9e894','Ножницы','2',140,'559d932f-a228-4020-811c-7f4e64c8b97d');
INSERT INTO public.product (id_product,name_product,type_product,weight_product,id_user_order)
VALUES ('7b78da95-492f-4bf1-b987-d363d173f7d8','Ножницы','2',140,'4684513a-b6d1-4274-bbec-886e2886cb4b');
INSERT INTO public.product (id_product,name_product,type_product,weight_product,id_user_order)
VALUES ('03b6473d-79ae-496d-8fe7-d75370b3f119','Ножницы','2',140,'8bccac13-afc6-474f-a999-5da9df558ce8');

