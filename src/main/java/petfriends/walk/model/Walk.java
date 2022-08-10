package petfriends.walk.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import petfriends.walk.dto.WalkEnded;
import petfriends.walk.dto.WalkStarted;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="walk")
public class Walk {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="walk_id")
    private Long id;			    			// 산책ID
	
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	//private LocalDateTime walkStartDate;			// 산책 시작 일시(실제)
	
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    //private LocalDateTime walkEndDate;				// 산책 종료 일시(실제)
	
	private String walkStartDate; 		// 산책 시작 일시분(실제)
	private String walkEndDate;			// 산책 종료 일시분(실제)
    
	@Enumerated(EnumType.STRING)
	private SmsStatus smsStatus;		// SMS 발송 상태 (START, END)
	
    private Long reservedId;			// 예약ID
    private Long userId;				// 회원ID
    private Long dogWalkerId;			// 도그워커ID
	
    @PostPersist
    public void onPostPersist(){
        WalkStarted walkStarted = new WalkStarted();
        BeanUtils.copyProperties(this, walkStarted);
        walkStarted.publishAfterCommit();

    }
    
    @PostUpdate
    public void onPostUpdate(){
    	WalkEnded walkEnded = new WalkEnded();
        BeanUtils.copyProperties(this, walkEnded);
        walkEnded.publishAfterCommit();

    }

    public static Walk of(
    		SmsStatus smsStatus,
    		Long reservedId,
    		Long userId,
    		Long dogWalkerId) {
    	
    	return Walk.builder()
    			.smsStatus(smsStatus)
    			.reservedId(reservedId)
    			.userId(userId)
    			.dogWalkerId(dogWalkerId)
    			.build();
    	
    }
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getReservedId() {
		return reservedId;
	}

	public void setReservedId(Long reservedId) {
		this.reservedId = reservedId;
	}

	public Long getDogWalkerId() {
		return dogWalkerId;
	}

	public void setDogWalkerId(Long dogWalkerId) {
		this.dogWalkerId = dogWalkerId;
	}

	public SmsStatus getSmsStatus() {
		return smsStatus;
	}

	public void setSmsStatus(SmsStatus smsStatus) {
		this.smsStatus = smsStatus;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getWalkStartDate() {
		return walkStartDate;
	}

	public void setWalkStartDate(String walkStartDate) {
		this.walkStartDate = walkStartDate;
	}

	public String getWalkEndDate() {
		return walkEndDate;
	}

	public void setWalkEndDate(String walkEndDate) {
		this.walkEndDate = walkEndDate;
	}

}
