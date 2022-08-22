package petfriends.walk.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import petfriends.walk.model.SmsStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WalkEndRequestView {

	private Long id;				// 산책ID
	private Long reservedId;		// 예약ID
    private String userId;			// 회원ID
    private Long dogwalkerScheduleId;		// 도그워커스케줄ID
	
}
