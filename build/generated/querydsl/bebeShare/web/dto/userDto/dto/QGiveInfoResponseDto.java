package bebeShare.web.dto.userDto.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.Generated;

/**
 * bebeShare.web.dto.userDto.dto.QGiveInfoResponseDto is a Querydsl Projection type for GiveInfoResponseDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QGiveInfoResponseDto extends ConstructorExpression<GiveInfoResponseDto> {

    private static final long serialVersionUID = 1355540888L;

    public QGiveInfoResponseDto(com.querydsl.core.types.Expression<Long> productId, com.querydsl.core.types.Expression<String> productName, com.querydsl.core.types.Expression<String> productImage1, com.querydsl.core.types.Expression<java.time.LocalDateTime> insertDt) {
        super(GiveInfoResponseDto.class, new Class<?>[]{long.class, String.class, String.class, java.time.LocalDateTime.class}, productId, productName, productImage1, insertDt);
    }

}

