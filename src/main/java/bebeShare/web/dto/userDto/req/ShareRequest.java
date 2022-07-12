package bebeShare.web.dto.userDto.req;

import bebeShare.domain.common.entity.PageEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class ShareRequest extends PageEntity {

    private Long memberId;
    private String productStatus;

}
