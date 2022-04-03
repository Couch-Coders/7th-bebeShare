package bebeShare.web.userDto;

import bebeShare.domain.product.Product;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Data
@NoArgsConstructor
public class ShareInfoResponseDto {

    private Long productId;
    private String productName;
    private String productImage1;
    private LocalDateTime insertDt;

    public ShareInfoResponseDto(Long productId, String productName,LocalDateTime createDate) {
        this.productId = productId;
        this.productName   = productName;
        this.insertDt      = createDate;
    }

    public ShareInfoResponseDto(Product product) {
        this.productId = product.getId();
        this.productName   = product.getProductName();
        this.productImage1   = product.getProductImage1();
        this.insertDt      = product.getCreatedDate();
    }

    @QueryProjection //의존적이게 되 단점
    public ShareInfoResponseDto(Long productId, String productName, String productImage1, LocalDateTime insertDt) {
        this.productId = productId;
        this.productName = productName;
        this.productImage1 = productImage1;
        this.insertDt = insertDt;
    }
}
