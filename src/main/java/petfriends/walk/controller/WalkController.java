package petfriends.walk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import petfriends.walk.model.Walk;
import petfriends.walk.service.WalkService;
import petfriends.walk.view.WalkEndRequestView;
import petfriends.walk.view.WalkRequestView;

 @RestController
 public class WalkController {

	 @Autowired
	 WalkService walkService;
	 
	 
	 // 산책 단건 조회 (산책번호 기준)
//	 @GetMapping("/walks/{id}")
//	 public ResponseEntity<Walk> findById(@PathVariable("id") Long id) throws Exception {
//		 
//		 return ResponseEntity.ok(walkService.findById(id));
//	 
//	 }

	 // 산책 단건 조회 (예약번호 기준)
	 @GetMapping("/walks/{reservedId}")
	 public ResponseEntity<Walk> findByReservedId(@PathVariable("reservedId") Long reservedId) throws Exception {
		 
		 return ResponseEntity.ok(walkService.findByReservedId(reservedId));
	 
	 }
	 
	 // 산책 목록 조회 (도그워커 기준)
	 @GetMapping("/walks/user/{dogWalkerId}")
	 public List<Walk> findByDogWalkerId(@PathVariable("dogWalkerId") String dogWalkerId) throws Exception {
		 return walkService.findByDogWalkerId(dogWalkerId);
	 }
	 
	 // 산책 시작 (생성)
	 @PostMapping("/walks/start")
	 public ResponseEntity<Walk> walkStart(@RequestBody WalkRequestView walkRequest) throws Exception {
		 
		 Walk walkStart = walkService.walkStart(walkRequest);
		 
		 return ResponseEntity.ok(walkStart);
		 
	 }
	 
	 // 산책 종료 (수정: 산책종료일자, SMS발송상태 업데이트)
	 @PutMapping("/walks/end")
	 public ResponseEntity<Walk> walkEnd(@RequestBody WalkEndRequestView walkEndRequest) throws Exception {
		 
		 Walk walkEnd = walkService.walkEnd(walkEndRequest);
		 
		 return ResponseEntity.ok(walkEnd);
		        
	 }
	 

//	 @Autowired
//	 WalkRepository walkRepository;
	 
	 // 산책 단건 조회
//	 @GetMapping("/walks/{id}")
//	 public Walk findById(@PathVariable("id") Long id) {
//		 
//		 return walkService.findById(id);
//	 
//	 }	 
	 
	 
	 // 산책 시작 (생성)
//	 @PostMapping("/walks/start")
//	 public void walkStart(@RequestBody WalkRequestView walkRequest) throws Exception {
//		 
//		 //System.out.println("##### /walk/walkStart  called #####");
//	
//		 walkService.walkStart(walkRequest);
//		 
//	 }	 
	 
	 
	 // 산책 종료 (수정: 산책종료일자, SMS발송상태 업데이트)
//	 @PutMapping("/walks/end/{id}")
//	 public void walkEnd(@PathVariable("id") Long id) throws Exception {
//		 
//		 //System.out.println("##### /walk/walkEnd  called #####");
//		 
//		 walkService.walkEnd(id);
//		        
//	 }
	 
	 
	 // 산책 리스트 조회
//	 @GetMapping("/walks/{id}")
//	 public List<Walk> findAllByUserId(@PathVariable("id") Long id) {
//		 
//		 return walkService.findAllById(id);
//	 
//	 }
	 
	 
	 // Service를 사용하지 않는 경우 (산책 시작 함수)
		/*
		 * @PostMapping("/start") public ResponseEntity<Walk> walkStart2(@RequestBody
		 * Walk walk) {
		 * 
		 * walk.setWalkStartDate(LocalDateTime.now()); walk.setSmsStatus(SmsStatus.END);
		 * 
		 * Walk startWalk = walkRepository.save(walk);
		 * 
		 * return ResponseEntity.ok(startWalk);
		 * 
		 * }
		 */
	 
	 // Service를 사용하지 않는 경우 (산책 종료 함수)
		/*
		 * @PutMapping("/end/{userId}") public ResponseEntity<Walk>
		 * walkEnd2(@PathVariable Long id) {
		 * 
		 * Walk walk = walkRepository.findById(id).orElseThrow(null);
		 * 
		 * walk.setWalkEndDate(LocalDateTime.now());
		 * 
		 * walk.setSmsStatus(SmsStatus.END);
		 * 
		 * Walk endWalk = walkRepository.save(walk);
		 * 
		 * return ResponseEntity.ok(endWalk); }
		 */
	 
 }

 