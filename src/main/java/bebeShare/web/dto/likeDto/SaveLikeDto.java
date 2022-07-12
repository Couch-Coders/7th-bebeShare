package bebeShare.web.dto.likeDto;


import bebeShare.domain.like.Dibs;
import bebeShare.domain.product.Product;
import bebeShare.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveLikeDto {

    private long productId;
    private long userId;

    public SaveLikeDto() {
        this.userId = userId;
        this.productId = productId;
    }

    public Dibs toEntity(Product product , User user){
        return Dibs.builder()
                .product(product)
                .user(user)
                .build();
    }

    @Builder
    public SaveLikeDto(Long product , Long user) {
        this.productId = product;
        this.userId = user;
    }
}
