package bebeShare.web.dto.productDto;

import bebeShare.domain.product.Product;
import bebeShare.domain.user.User;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class ProductInfoResponseDto {


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
    private Long dibsId;
    private LocalDateTime insertDt;

    @QueryProjection
    public ProductInfoResponseDto(Long ProductId , String Productname, String ProductImage1,long dibsId, LocalDateTime InsertDt) {
        this.productId = ProductId;
        this.productName = Productname;
        this.productImage1 = ProductImage1;
        this.dibsId = dibsId;
        this.insertDt = InsertDt;

    }

}
