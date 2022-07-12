package bebeShare.web.dto.productDto;

import bebeShare.domain.product.Product;
import bebeShare.domain.user.User;
import lombok.Getter;

@Getter
public class ProductCreateRequestDto {
    private Long productId;
    private User user;
    private String productName;
    private String productContent;
    private String productCategory;
    private String productStatus;
    private String deleteYn;

    public ProductCreateRequestDto() {
        this.productId = productId;
        this.user = user;
        this.productName = productName;
        this.productContent = productContent;
        this.productCategory = productCategory;
        this.productStatus = productStatus;
        this.deleteYn = deleteYn;
    }


    public Product toEntity() {
        return Product.builder()
                .user(user)
                .productName(productName)
                .productCategory(productCategory)
                .productContent(productContent)
                .productStatus(productStatus)
                .deleteYn(deleteYn)
                .build();
    }
}
