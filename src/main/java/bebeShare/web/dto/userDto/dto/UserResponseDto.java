package bebeShare.web.dto.userDto.dto;

import bebeShare.domain.user.User;
import lombok.Getter;

@Getter
public class UserResponseDto {

    private Long memberId;
    private Integer shareCnt;
    private Integer giveCnt;
    private Integer shareChanceCnt;


    public UserResponseDto(User user) {
        this.memberId = user.getId();
        this.shareCnt = user.getShareCnt();
        this.giveCnt = user.getGiveCnt();
        this.shareChanceCnt = user.getShareChanceCnt();
    }

}
