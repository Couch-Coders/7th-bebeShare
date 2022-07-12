package bebeShare.web.dto.userDto.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.Generated;

/**
 * bebeShare.web.dto.userDto.dto.QLikeInfoResponseDto is a Querydsl Projection type for LikeInfoResponseDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QLikeInfoResponseDto extends ConstructorExpression<LikeInfoResponseDto> {

    private static final long serialVersionUID = -573355950L;

    public QLikeInfoResponseDto(com.querydsl.core.types.Expression<Long> productId, com.querydsl.core.types.Expression<String> productName, com.querydsl.core.types.Expression<String> productImage1, com.querydsl.core.types.Expression<java.time.LocalDateTime> insertDt) {
        super(LikeInfoResponseDto.class, new Class<?>[]{long.class, String.class, String.class, java.time.LocalDateTime.class}, productId, productName, productImage1, insertDt);
    }

}

