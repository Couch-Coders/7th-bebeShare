package bebeShare.domain.comment;

import bebeShare.web.dto.commentDto.CommentInfoResponseDto;
import bebeShare.web.dto.commentDto.CommentUpdateRequestsDto;
import bebeShare.web.dto.commentDto.CommentUpdateResponseDto;
import bebeShare.web.dto.commentDto.CommentsRequest;
import bebeShare.web.dto.productDto.RejectShareRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentRepositoryCustom {

    Page<CommentInfoResponseDto> findByProductId(CommentsRequest commentsRequest, Pageable pageable);

    Long updateByCommentId(CommentUpdateRequestsDto updateRequestsDto);

}
