package bebeShare.web;

import bebeShare.config.auth.LoginUser;
import bebeShare.config.auth.dto.SessionUser;
import bebeShare.service.ProductService;
import bebeShare.service.UserService;
import bebeShare.web.dto.userDto.*;
import bebeShare.web.dto.userDto.dto.*;
import bebeShare.web.dto.userDto.req.CommentRequest;
import bebeShare.web.dto.userDto.req.GiveRequest;
import bebeShare.web.dto.userDto.req.LikeRequest;
import bebeShare.web.dto.userDto.req.ShareRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/members")
@RestController
public class MemberApiController {

    private final UserService userService;
    private final ProductService productService;


    @GetMapping("/{id}")
    public UserResponseDto findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("/shareInfo")
    public Page<ShareInfoResponseDto> shareInfo(@RequestBody ShareRequest shareRequest, @LoginUser SessionUser user) {
        Pageable pageable = PageRequest.of(shareRequest.getPage(), shareRequest.getSize());
        shareRequest.setMemberId(user.getId());
        return userService.shareInfo(shareRequest, pageable);
    }

    @PostMapping("/giveInfo")
    public Page<GiveInfoResponseDto> giveInfo(@RequestBody GiveRequest giveRequest, @LoginUser SessionUser user) {
        Pageable pageable = PageRequest.of(giveRequest.getPage(), giveRequest.getSize());
        giveRequest.setShareId(user.getId());
        return userService.giveInfo(giveRequest, pageable);
    }

    @PostMapping("/likeInfo")
    public Page<LikeInfoResponseDto> likeInfo(@RequestBody LikeRequest likeRequest, @LoginUser SessionUser user) {
        Pageable pageable = PageRequest.of(likeRequest.getPage(), likeRequest.getSize());
        likeRequest.setMemberId(user.getId());
        return userService.likeInfo(likeRequest, pageable);
    }


    @PostMapping("/comments")
    public Page<MemberCommentResponseDto> comments(@RequestBody CommentRequest commentRequest, @LoginUser SessionUser user) {
        Pageable pageable = PageRequest.of(commentRequest.getPage(), commentRequest.getSize());
        commentRequest.setMemberId(user.getId());
        return userService.comments(commentRequest, pageable);


    }
}