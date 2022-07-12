package bebeShare.web.dto.productDto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.Generated;

/**
 * bebeShare.web.dto.productDto.QProductInfoResponseDto is a Querydsl Projection type for ProductInfoResponseDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QProductInfoResponseDto extends ConstructorExpression<ProductInfoResponseDto> {

    private static final long serialVersionUID = 248330593L;

    public QProductInfoResponseDto(com.querydsl.core.types.Expression<Long> ProductId, com.querydsl.core.types.Expression<String> Productname, com.querydsl.core.types.Expression<String> ProductImage1, com.querydsl.core.types.Expression<Long> dibsId, com.querydsl.core.types.Expression<java.time.LocalDateTime> InsertDt) {
        super(ProductInfoResponseDto.class, new Class<?>[]{long.class, String.class, String.class, long.class, java.time.LocalDateTime.class}, ProductId, Productname, ProductImage1, dibsId, InsertDt);
    }

}

