package bebeShare.domain.user;

import bebeShare.domain.product.ProductRepository;
import bebeShare.web.dto.userDto.dto.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class UserRepositoryTest {
//
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    ProductRepository productRepository;
//
//    private final Integer page = 0;
//
//
//    @Test
//    public void id조회() {
//        Optional<User> byId = userRepository.findById(1L);
//        System.out.println("user:" + byId);
//        assertThat(byId.get().getName()).isEqualTo("test");
//
//    }
//
//    @Test
//    public void 나눔한내역조회() {
//        UserRequest userRequest = new UserRequest();
//        userRequest.setMemberId(1L);
//        userRequest.setProductStatus("S");
//        userRequest.setPage(0);
//        userRequest.setSize(5);
//
//        List<ShareInfoResponseDto> products = userRepository.shareInfo(userRequest);
//        for (ShareInfoResponseDto shareInfo : products) {
//            System.out.println("shareInfo:" +shareInfo.toString());
//        }
//    }
//
//    @Test
//    public void 나눔받은내역조회() {
//
//        UserRequest userRequest = new UserRequest();
//        userRequest.setMemberId(1L);
//        userRequest.setProductStatus("C");
//        userRequest.setPage(0);
//        userRequest.setSize(5);
//
//        List<GiveInfoResponseDto> products = userRepository.giveInfo(userRequest);
//        for (GiveInfoResponseDto giveInfo : products) {
//            System.out.println("giveInfo:" +giveInfo.toString());
//        }
//    }
//
//    @Test
//    public void 찜목록조회() {
//
//        UserRequest userRequest = new UserRequest();
//        userRequest.setMemberId(1L);
//        userRequest.setPage(0);
//        userRequest.setSize(5);
//        List<LikeInfoResponseDto> products = userRepository.likeInfo(userRequest);
//        for (LikeInfoResponseDto likeInfo : products) {
//            System.out.println("likeInfo:" +likeInfo.toString());
//        }
//    }
//
//    @Test
//    public void 댓글목록조회() {
//        UserRequest userRequest = new UserRequest();
//        userRequest.setMemberId(1L);
//        userRequest.setPage(0);
//        userRequest.setSize(5);
//        List<MemberCommentResponseDto> products = userRepository.comments(userRequest);
//        for (MemberCommentResponseDto comment : products) {
//            System.out.println("comment:" +comment.toString());
//        }
//    }
//}