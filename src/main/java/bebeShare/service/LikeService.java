package bebeShare.service;

import bebeShare.domain.like.Dibs;
import bebeShare.domain.like.DibsRepository;
import bebeShare.domain.product.Product;
import bebeShare.domain.product.ProductRepository;
import bebeShare.domain.user.User;
import bebeShare.domain.user.UserRepository;
import bebeShare.exception.CustomException;
import bebeShare.exception.ErrorCode;
import bebeShare.web.dto.ProductLikeDto;
import bebeShare.web.dto.likeDto.SaveLikeDto;
import com.sun.el.parser.AstFalse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class LikeService {
    private final DibsRepository dibsRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    // 상품 게시글 좋아요 생성
    @Transactional
    public void addLike(SaveLikeDto saveLikeDto) {
        System.out.println("saveLikeDto.getProductId(): " + saveLikeDto.getProductId());
        Product product = productRepository.findById(saveLikeDto.getProductId()).orElseThrow(()
                -> new IllegalArgumentException("해당 상품이 없습니다. Id=" + saveLikeDto.getProductId()));

        User user = userRepository.findById(saveLikeDto.getUserId()).orElseThrow(()
                -> new IllegalArgumentException("해당 사용자가 없습니다. Id=" + saveLikeDto.getUserId()));

        Dibs saveDib = dibsRepository.save(saveLikeDto.toEntity(product, user));

    }

    // 상품 게시글 좋아요 해제
    @Transactional
    public void delete(Long likeId) {
        dibsRepository.deleteById(likeId);
    }
}

