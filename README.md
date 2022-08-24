---------------------------------------------------
1. maria 설치 및 테이블 생성(예제에는 id/passwd : root/1234 , 변경은 application.yml에서 하면 됨. )
---------------------------------------------------
테이블스페이스 : petfriends

테이블생성 Script: 

CREATE TABLE `walk` (
`walk_id` bigint(20) NOT NULL AUTO_INCREMENT,
`dog_walker_id` varchar(255) DEFAULT NULL,
`reserved_id` bigint(20) DEFAULT NULL,
`sms_status` varchar(255) DEFAULT NULL,
`user_id` varchar(255) DEFAULT NULL,
`walk_end_date` varchar(255) DEFAULT NULL,
`walk_start_date` varchar(255) DEFAULT NULL,
PRIMARY KEY (`walk_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4

insert샘플: insert into payment (amount, pay_date, refund_date, reserved_id, user_id) values (10000, '2022-03-10 19:22:33.102', null, '22021','soyapayment95');  

---------------------------------------------------  
2. kafka설치  
---------------------------------------------------  
참고사이트 : http://www.msaschool.io/operation/implementation/implementation-seven/  

--------------------------------------------------  
3. Payment(mariadb), Shop(hsqldb) 실행 및 테스트  
--------------------------------------------------  
1) Payment에서 아래와 같이 api 통해 데이터 생성하면, mariadb[payment테이블]에 데이터 저장되고, message publish.  
    - 데이터생성(postman사용) : POST http://localhost:8082/payments/   
                              { "reservedId": "202203271311", "userId": "soya95", "amount": "10000", "payDate": "2019-03-10 10:22:33.102" }  

    - 조회 : GET http://localhost:8082/payments/1  

3) Shop에서 message 받아와 저장 ( 아래 PloycyHandler.java가 실행됨 )  

--------------------------------------------------  
4. 구조   
   -controller  
   -service  
   -repository  
   -dto  
   -model  
   -config : KafkaProcessor.java, WebConfig.java(CORS적용)  
--------------------------------------------------  
5. API  
   해당ID의 결제내역조회 : GET http://localhost:8082/payments/{userId}   
--------------------------------------------------  
