package bebeShare.web.dto.userDto.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.Generated;

/**
 * bebeShare.web.dto.userDto.dto.QShareInfoResponseDto is a Querydsl Projection type for ShareInfoResponseDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QShareInfoResponseDto extends ConstructorExpression<ShareInfoResponseDto> {

    private static final long serialVersionUID = -220659464L;

    public QShareInfoResponseDto(com.querydsl.core.types.Expression<Long> productId, com.querydsl.core.types.Expression<String> productName, com.querydsl.core.types.Expression<String> productImage1, com.querydsl.core.types.Expression<java.time.LocalDateTime> insertDt) {
        super(ShareInfoResponseDto.class, new Class<?>[]{long.class, String.class, String.class, java.time.LocalDateTime.class}, productId, productName, productImage1, insertDt);
    }

}

