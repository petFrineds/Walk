---------------------------------------------------
1. 사용 테이블
---------------------------------------------------
테이블스페이스 : petfriends

테이블생성 Script: 

CREATE TABLE `walk` (
	`walk_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`dog_walker_id` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`reserved_id` BIGINT(20) NULL DEFAULT NULL,
	`sms_status` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`user_id` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`walk_end_date` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`walk_start_date` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	PRIMARY KEY (`walk_id`) USING BTREE
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB;

INSERT INTO walk (dog_walker_id, reserved_id, sms_status, user_id, walk_end_date, walk_start_date) 
VALUES ('hisover', 1, 'START', 'ShinSeokHyeon', '2022-08-28 08:00', '2022-08-28 10:00');

---------------------------------------------------  
2. kafka설치  
---------------------------------------------------  
참고사이트 : http://www.msaschool.io/operation/implementation/implementation-seven/  

--------------------------------------------------  
3. API
--------------------------------------------------  
1) walk 에서 아래와 같이 api 통해 데이터 생성하면, mariadb[walk테이블]에 데이터 저장되고, message publish.
    - 산책 시작 (생성) : POST http://localhost:8082/walks/start 
                    { "reservedId": 1, 
                      "userId": "ShinSeokHyeon", 
                      "dogWalkerId": "hisover" }  

    - 산책 종료 (업데이트) : PUT http://localhost:8080/walks/end
    						  { "id": 1,
  								"reservedId": 1, 
  								"userId": "ShinSeoikHyeon", 
  								"dogWalkerId": "hisover"}
  	- 산책 단건 조회 (예약번호 기준) : GET http://localhost:8080/walks/{reservationId}

--------------------------------------------------  
4. 구조   
   -controller  
   -service  
   -repository  
   -dto  
   -model
   -view : Request 파라미터  
   -config : KafkaProcessor.java, WebConfig.java(CORS적용)  
--------------------------------------------------  
5. swagger추가 : http://localhost:8080/swagger-ui.html  
--------------------------------------------------  
