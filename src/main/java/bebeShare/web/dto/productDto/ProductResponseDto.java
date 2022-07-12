package bebeShare.web.dto.productDto;

import bebeShare.domain.product.Product;
import bebeShare.domain.user.User;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
public class ProductResponseDto {
    private Long productId;
    private User user;
    private String productName;
    private String productContent;
    private String productImage1;
    private String productImage2;
    private String productImage3;
    private String productCategory;
    private String productStatus;
    private String deleteYn;
    private Long shareId;


    public ProductResponseDto(Product entity) {
        this.productId = entity.getId();
        this.user = entity.getUser();
        this.productName = entity.getProductName();
        this.productContent = entity.getProductContent();
        this.productImage1 = entity.getProductImage1();
        this.productImage2 = entity.getProductImage2();
        this.productImage3 = entity.getProductImage3();
        this.productCategory = entity.getProductCategory();
        this.productStatus = entity.getProductStatus();
        this.deleteYn = entity.getDeleteYn();
        this.shareId = entity.getShareId();
    }
}
