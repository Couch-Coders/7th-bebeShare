package bebeShare.web.dto.commentDto;

import bebeShare.domain.common.entity.ResEntity;
import lombok.Data;
import lombok.Setter;

import static bebeShare.domain.common.CommonContants.COMMENT_UPDATE_FAIL;
import static bebeShare.domain.common.CommonContants.COMMENT_UPDATE_OK;
import static bebeShare.domain.common.ResponeMsgEnum.RESPONES_FAIL;
import static bebeShare.domain.common.ResponeMsgEnum.RESPONES_SUCCESS;

@Data
public class CommentUpdateResponseDto extends ResEntity {

    private String resultCode;
    private String resultMsg;
    private Long commentId;

    public CommentUpdateResponseDto(Long commentId) {
        this.setResultCode(RESPONES_SUCCESS.getValue());
        this.setResultMsg(COMMENT_UPDATE_OK);
        this.commentId = commentId;
    }

    public  CommentUpdateResponseDto() {
        this.setResultCode(RESPONES_FAIL.getValue());
        this.setResultMsg(COMMENT_UPDATE_FAIL);
        this.commentId = 0L;
    }
}