package bebeShare.web.dto.commentDto;


import bebeShare.domain.comment.Comment;
import bebeShare.domain.product.Product;
import bebeShare.domain.user.User;
import lombok.*;


@Data
public class CommentUpdateRequestsDto {
    private Long commentId;
    private String commentContent;
    private String deleteYn;
    private String commentStatus;

}
