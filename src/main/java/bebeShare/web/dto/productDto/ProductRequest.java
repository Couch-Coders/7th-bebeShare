package bebeShare.web.dto.productDto;

import bebeShare.domain.common.entity.PageEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class ProductRequest extends PageEntity {
    private String productName;
    private String categoryCode;
    private String orderBy;

//  마이페이지 내역 파라미터값 .
    private Long memberId;
    private String productStatus;
    private Long shareId;
}
