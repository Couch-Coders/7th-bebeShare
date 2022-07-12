package bebeShare.web.dto.userDto.req;

import bebeShare.domain.common.entity.PageEntity;
import lombok.Data;

@Data
public class CommentRequest extends PageEntity {

    private Long memberId;
}
