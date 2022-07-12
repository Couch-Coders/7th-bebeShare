package bebeShare.web.dto.userDto.dto;

import com.querydsl.core.annotations.QueryProjection;
import com.querydsl.core.types.dsl.StringPath;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter
public class MemberCommentResponseDto {

    private Long commentId;
    private String productName;
    private String commentContent;
    //private StringPath productImage1;
    private LocalDateTime insertDt;



    @QueryProjection //의존적이게 되 단점
    public MemberCommentResponseDto(Long commentId, String productName, String commentContent, LocalDateTime insertDt) {
        this.commentId = commentId;
        this.productName   = productName;
        this.commentContent = commentContent;
        //this.productImage1 = productImage1;
        this.insertDt = insertDt;

    }

}
