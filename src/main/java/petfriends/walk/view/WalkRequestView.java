package petfriends.walk.view;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WalkRequestView {
	private Long reservedId;		// 예약ID
    private String userId;			// 회원ID
    private Long dogwalkerScheduleId;		// 도그워커스케줄ID
}
