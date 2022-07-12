package bebeShare.web;

import bebeShare.config.auth.LoginUser;
import bebeShare.config.auth.dto.SessionUser;
import bebeShare.service.CommentsService;
import bebeShare.web.dto.commentDto.*;
import bebeShare.web.dto.userDto.req.CommentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/comments")
public class CommentApiController {

    private final CommentsService commentsService;

    // 상품 댓글 등록
    @PostMapping("/{productId}")
    public CommentResponseDto save( @RequestBody CommentSaveRequestsDto requestsDto) {
        return commentsService.save(requestsDto);
    }

    //상품 댓글 조회
    @PostMapping("")
    public Page<CommentInfoResponseDto> findByProductId(@RequestBody CommentsRequest commentsRequest){
        Pageable pageable = PageRequest.of(commentsRequest.getPage(), commentsRequest.getSize());
        return commentsService.findByProductId(commentsRequest, pageable);
    }

    // 상품 댓글 수정
    @PatchMapping("")
    public CommentUpdateResponseDto update(@RequestBody CommentUpdateRequestsDto updateRequestsDto) {

        Long updateCnt = commentsService.updateByCommentId(updateRequestsDto);

        if(updateCnt != 0){
            return new CommentUpdateResponseDto(updateRequestsDto.getCommentId());
        }

        return new CommentUpdateResponseDto();
    }

    // 상품 댓글 삭제
    @DeleteMapping("")
    public CommentDeleteResponseDto delete(@RequestBody CommentDeleteRequestDto params) {
        return commentsService.delete(params);
    }
}
