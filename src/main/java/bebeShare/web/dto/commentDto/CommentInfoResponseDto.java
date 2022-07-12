package bebeShare.web.dto.commentDto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentInfoResponseDto {

    private Long   commentId;
    private String commentContent;
    private String deleteYn;
    private String commentStatus;
    private String picture;
    private Long userId;
    private Long shareId;
    private LocalDateTime insertDt;


    @QueryProjection
    public CommentInfoResponseDto(Long commentId , String commentContent, String deleteYn,String commentStatus, String picture,Long userId, Long shareId,LocalDateTime InsertDt) {
        this.commentId = commentId;
        this.commentContent = commentContent;
        this.deleteYn = deleteYn;
        this.commentStatus = commentStatus;
        this.picture = picture;
        this.userId = userId;
        this.shareId = shareId;
        this.insertDt = InsertDt;
    }
}
