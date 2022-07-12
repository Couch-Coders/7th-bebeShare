package bebeShare.web.dto.commentDto;

import bebeShare.domain.common.entity.PageEntity;
import lombok.Data;

@Data
public class CommentsRequest extends PageEntity {
    private Long productId;
}
