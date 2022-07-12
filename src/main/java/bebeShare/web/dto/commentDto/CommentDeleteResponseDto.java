package bebeShare.web.dto.commentDto;

import bebeShare.domain.common.entity.ResEntity;
import lombok.Getter;

import static bebeShare.domain.common.CommonContants.COMMENT_DELETE_OK;
import static bebeShare.domain.common.ResponeMsgEnum.RESPONES_SUCCESS;

@Getter
public class CommentDeleteResponseDto extends ResEntity {

    private Long commentId;

    public CommentDeleteResponseDto(Long commentId) {
        this.setResultCode(RESPONES_SUCCESS.getValue());
        this.setResultMsg(COMMENT_DELETE_OK);
        this.commentId = commentId;
    }
}
