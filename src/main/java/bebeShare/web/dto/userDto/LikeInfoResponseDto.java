package bebeShare.web.dto.userDto;

import bebeShare.domain.product.Product;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter
public class LikeInfoResponseDto {

    private Long productId;
    private String productName;
    private String productImage1;
    private LocalDateTime insertDt;


    @QueryProjection //의존적이게 되 단점
    public LikeInfoResponseDto(Long productId, String productName, String productImage1, LocalDateTime insertDt) {
        this.productId = productId;
        this.productName = productName;
        this.productImage1 = productImage1;
        this.insertDt = insertDt;

    }

}
