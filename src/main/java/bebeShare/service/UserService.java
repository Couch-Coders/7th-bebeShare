package bebeShare.service;

import bebeShare.domain.user.User;
import bebeShare.domain.user.UserRepository;
import bebeShare.web.dto.userDto.*;
import bebeShare.web.dto.userDto.dto.*;
import bebeShare.web.dto.userDto.req.CommentRequest;
import bebeShare.web.dto.userDto.req.GiveRequest;
import bebeShare.web.dto.userDto.req.LikeRequest;
import bebeShare.web.dto.userDto.req.ShareRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDto findById(Long id) {
        User entity = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        return new UserResponseDto(entity);
    }

    public Page<ShareInfoResponseDto> shareInfo(ShareRequest shareRequest, Pageable pageable) {
        try {
            return userRepository.shareInfo(shareRequest, pageable);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Page<GiveInfoResponseDto> giveInfo(GiveRequest giveRequest, Pageable pageable) {
        try {
            return userRepository.giveInfo(giveRequest, pageable);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Page<LikeInfoResponseDto> likeInfo(LikeRequest likeRequest, Pageable pageable) {
        try {
            return userRepository.likeInfo(likeRequest, pageable);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Page<MemberCommentResponseDto> comments(CommentRequest commentRequest, Pageable pageable) {
        try {
            return userRepository.comments(commentRequest, pageable);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
    }
}
