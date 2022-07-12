package bebeShare.web;

import bebeShare.config.auth.LoginUser;
import bebeShare.config.auth.dto.SessionUser;
import bebeShare.domain.like.Dibs;
import bebeShare.domain.user.User;
import bebeShare.service.LikeService;
import bebeShare.web.dto.likeDto.SaveLikeDto;
import bebeShare.web.dto.productDto.ProductCreateRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/like")
public class LikeApiController {

    private final LikeService likeService;

    // 상품 게시글 좋아요 생성
    @PostMapping("/{productId}")
    public Long save(@PathVariable Long  productId, @LoginUser SessionUser user) {
        SaveLikeDto saveLikeDto = new SaveLikeDto();
        saveLikeDto.setProductId(productId);
        saveLikeDto.setUserId(user.getId());
        likeService.addLike(saveLikeDto);
        return saveLikeDto.getUserId();
    }

    // 상품 게시글 좋아요 해제
    @DeleteMapping("/{likeId}")
    public Long delete(@PathVariable Long likeId){
        likeService.delete(likeId);
        return likeId;
    }
}
