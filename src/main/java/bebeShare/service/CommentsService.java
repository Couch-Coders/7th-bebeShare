package bebeShare.service;

import bebeShare.domain.comment.Comment;
import bebeShare.domain.comment.CommentRepository;
import bebeShare.domain.product.Product;
import bebeShare.domain.product.ProductRepository;
import bebeShare.domain.user.User;
import bebeShare.domain.user.UserRepository;
import bebeShare.exception.CustomException;
import bebeShare.exception.ErrorCode;
import bebeShare.web.dto.commentDto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CommentsService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;


    @Transactional
    public CommentResponseDto save(CommentSaveRequestsDto requestsDto) {

        User user = userRepository.findById(requestsDto.getMemberId())
                .orElseThrow(() -> new CustomException(ErrorCode.INTERNAL_SERVER_ERROR));
        Product product = productRepository.findById(requestsDto.getProductId())
                .orElseThrow(() -> new CustomException(ErrorCode.INTERNAL_SERVER_ERROR));

        commentRepository.save(requestsDto.toEntity(user, product));

        return new CommentResponseDto(requestsDto.getProductId());
    }

    public List<CommentFindAllResponseDto> findAll() {
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        List<Comment> list = commentRepository.findAll(sort);
        return list.stream().map(CommentFindAllResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public CommentUpdateResponseDto update(CommentUpdateRequestsDto updateRequestsDto) {
        Comment entity = commentRepository.findById(updateRequestsDto.getCommentId()).orElseThrow(
                () -> new CustomException(ErrorCode.INTERNAL_SERVER_ERROR)
        );
        entity.update(updateRequestsDto);
        return new CommentUpdateResponseDto(updateRequestsDto.getCommentId());
    }

    @Transactional
    public CommentDeleteResponseDto delete(CommentDeleteRequestDto params) {
        Comment entity = commentRepository.findById(params.getCommentId()).orElseThrow(()
                -> new CustomException(ErrorCode.COMMENT_NOT_FOUND));
        entity.delete();
        return new CommentDeleteResponseDto(params.getCommentId());
    }

    public Page<CommentInfoResponseDto> findByProductId(CommentsRequest commentsRequest, Pageable pageable) {
        return  commentRepository.findByProductId(commentsRequest, pageable);
    }

    @Transactional
    public Long updateByCommentId(CommentUpdateRequestsDto updateRequestsDto) {
        Comment entity = commentRepository.findById(updateRequestsDto.getCommentId()).orElseThrow(
                () -> new CustomException(ErrorCode.INTERNAL_SERVER_ERROR)
        );
        return  commentRepository.updateByCommentId(updateRequestsDto);
    }
}
