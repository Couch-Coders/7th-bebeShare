package bebeShare.web.dto.productDto;

import lombok.Getter;

@Getter
public class ApproveShareProductRequest {
    private Long productId;
    private Long shareId;
}
