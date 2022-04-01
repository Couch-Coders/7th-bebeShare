package bebeShare.web;

import bebeShare.config.auth.LoginUser;
import bebeShare.config.auth.dto.SessionUser;
import bebeShare.service.CommentsService;
import bebeShare.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class CommentApiController {

    private final CommentsService commentsService;


    @PostMapping("/{productId}/comments")
    public CommentResponseDto save(@PathVariable Long productId, @RequestBody CommentSaveRequestsDto requestsDto,
                                   @LoginUser SessionUser sessionUser) {
        requestsDto.setProductId(productId);
        requestsDto.setMemberId(sessionUser.getId());
        return commentsService.save(requestsDto);
    }

    @PatchMapping("/{productId}/comments/{commentId}")
    public CommentUpdateResponseDto update(@PathVariable Long productId, @PathVariable Long commentId, @RequestBody CommentUpdateRequestsDto updateRequestsDto) {
        return commentsService.update(productId, commentId, updateRequestsDto);
    }


    @DeleteMapping("/{productId}/comments/{commentId}")
    public CommentDeleteResponseDto delete(@PathVariable Long productId, @PathVariable Long commentId) {
        return commentsService.delete(productId, commentId);
    }
}
