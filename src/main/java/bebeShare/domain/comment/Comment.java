package bebeShare.domain.comment;


import bebeShare.BaseEntity;
import bebeShare.domain.product.Product;
import bebeShare.domain.user.User;
import bebeShare.web.dto.commentDto.CommentDeleteRequestDto;
import bebeShare.web.dto.commentDto.CommentUpdateRequestsDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentId")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;


    @ManyToOne
    @JoinColumn(name = "memberId")
    private User user;

    private String commentContent;

    private String deleteYn;

    private String commentStatus;


    @Builder
    public Comment(User user , Product product ,String commentContent ,String deleteYn , String commentStatus) {
        this.user = user;
        this.product = product;
        this.commentContent = commentContent;
        this.deleteYn = deleteYn;
        this.commentStatus = commentStatus;
    }

    public void update(CommentUpdateRequestsDto c) {
        this.id = c.getCommentId();
        this.commentContent = c.getCommentContent();
        this.deleteYn = c.getDeleteYn();
        this.commentStatus = c.getCommentStatus();
    }
    public void delete(){
        this.deleteYn = "Y";
    }
}
