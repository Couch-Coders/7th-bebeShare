package bebeShare.domain.user;

import bebeShare.web.dto.userDto.GiveInfoResponseDto;
import bebeShare.web.dto.userDto.LikeInfoResponseDto;
import bebeShare.web.dto.userDto.MemberCommentResponseDto;
import bebeShare.web.dto.userDto.ShareInfoResponseDto;
import bebeShare.web.dto.userDto.req.CommentRequest;
import bebeShare.web.dto.userDto.req.GiveRequest;
import bebeShare.web.dto.userDto.req.LikeRequest;
import bebeShare.web.dto.userDto.req.ShareRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserRepositoryCustom {

    Page<ShareInfoResponseDto> shareInfo(ShareRequest shareRequest, Pageable pageable);

    Page<GiveInfoResponseDto> giveInfo(GiveRequest giveRequest, Pageable pageable);

    Page<LikeInfoResponseDto> likeInfo(LikeRequest likeRequest, Pageable pageable);

    Page<MemberCommentResponseDto> comments(CommentRequest commentRequest, Pageable pageable);


}
