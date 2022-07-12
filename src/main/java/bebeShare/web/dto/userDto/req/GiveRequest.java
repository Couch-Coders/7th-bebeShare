package bebeShare.web.dto.userDto.req;

import bebeShare.domain.common.entity.PageEntity;
import lombok.Data;

@Data
public class GiveRequest extends PageEntity {

    private Long shareId;
    private String productStatus;
}
