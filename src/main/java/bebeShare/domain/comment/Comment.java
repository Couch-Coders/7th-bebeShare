package bebeShare.domain.comment;


import bebeShare.BaseEntity;
import bebeShare.domain.product.Product;
import bebeShare.domain.user.User;
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
    private Long Id;



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

}
