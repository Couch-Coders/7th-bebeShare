package bebeShare.web.dto;

import bebeShare.domain.product.Product;
import bebeShare.domain.user.User;
import lombok.Getter;

@Getter
public class ProductResponseDto {
    private User user;
    private String productName;
    private String productContent;
    private String productImage1;
    private String productImage2;
    private String productImage3;
    private String productCategory;
    private String productStatus;
    private String deleteYn;


    public ProductResponseDto(Product entity) {
        this.user = entity.getUser();
        this.productName = entity.getProductName();
        this.productContent = entity.getProductContent();
        this.productImage1 = entity.getProductImage1();
        this.productImage2 = entity.getProductImage2();
        this.productImage3 = entity.getProductImage3();
        this.productCategory = entity.getProductCategory();
        this.productStatus = entity.getProductStatus();
        this.deleteYn = entity.getDeleteYn();
    }
}
