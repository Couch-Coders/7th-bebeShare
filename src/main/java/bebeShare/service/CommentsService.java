package bebeShare.service;

import bebeShare.domain.comment.CommentRepository;
import bebeShare.domain.product.Product;
import bebeShare.domain.product.ProductRepository;
import bebeShare.domain.user.User;
import bebeShare.domain.user.UserRepository;
import bebeShare.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentsService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public CommentResponseDto save(CommentSaveRequestsDto requestsDto) {

        User user = userRepository.findById(requestsDto.getMemberId()).orElseThrow(
                () -> new IllegalArgumentException("해당하는 사용자가 없습니다. " + requestsDto.getMemberId())
        );
        Product product = productRepository.findById(requestsDto.getProductId()).orElseThrow(
                () -> new IllegalArgumentException("해당하는 상품이 없습니다. " + requestsDto.getProductId())
        );

        commentRepository.save(requestsDto.toEntity(user, product));

        return new CommentResponseDto(requestsDto.getProductId());
    }

    public CommentUpdateResponseDto update(Long productId, Long commentId, CommentUpdateRequestsDto updateRequestsDto) {
        commentRepository.findById(commentId).ifPresent(c -> {
            if (updateRequestsDto.getCommentContent() != null) {
                c.setCommentContent(updateRequestsDto.getCommentContent());
            }
            commentRepository.save(c);
        });
        return new CommentUpdateResponseDto(productId);
    }

    public CommentDeleteResponseDto delete(Long productId, Long commentId) {
        commentRepository.deleteById(commentId);
        return new CommentDeleteResponseDto(productId);
    }
}
