package bebeShare.domain.like;

import bebeShare.domain.product.Product;
import bebeShare.domain.product.ProductRepository;
import bebeShare.domain.user.Role;
import bebeShare.domain.user.User;
import bebeShare.domain.user.UserRepository;
import bebeShare.web.dto.likeDto.SaveLikeDto;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DibsRepositoryTest {

    @Autowired
    private DibsRepository dibsRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    private User testUser = new User();
    private Product testProduct = new Product();

    @BeforeEach
    public void setUp() {
        // 1. 유저 생성
        testUser = userRepository.save(User.builder()
                .name("test1")
                .picture("/fake/path")
                .email("test1@naver.com")
                .role(Role.USER)
                .build()
        );
        userRepository.save(testUser);

        // 2. 상품 게시글 파라미터 생성
        testProduct = productRepository.save(Product.builder()
                .user(testUser)
                .productName("product0")
                .productCategory("100")
                .productContent("content0")
                .productImage1("1")
                .productImage2("2")
                .productImage3("3")
                .productStatus("S")
                .deleteYn("N")
                .build()
        );
        productRepository.save(testProduct);
    }

    @AfterEach
    public void tearDown() {
        dibsRepository.deleteAll();
        productRepository.deleteAll();
        userRepository.deleteAll();
    }


    // 상품 게시글 좋아요 생성
    @Test
    public void 좋아요등록() throws Exception {
        // given
        SaveLikeDto saveLikeDto = SaveLikeDto.builder().product(testProduct.getId())
                .user(testUser.getId()).build();

        // when
        dibsRepository.save(saveLikeDto.toEntity(testProduct, testUser));

        //then
        assertThat(dibsRepository.findAll().size()).isEqualTo(1);
        assertThat(dibsRepository.findAll().get(0).getProduct().getId()).isEqualTo(testProduct.getId());
        assertThat(dibsRepository.findAll().get(0).getUser().getId()).isEqualTo(testUser.getId());
    }

    // 상품 게시글 좋아요 해제
    @Test
    public void 좋아요해제() throws Exception {
        // given
        SaveLikeDto saveLikeDto = SaveLikeDto.builder().product(testProduct.getId())
                .user(testUser.getId()).build();
        dibsRepository.save(saveLikeDto.toEntity(testProduct, testUser));
        //dibsRepository.findAll().get(0);

        // when
        dibsRepository.delete(dibsRepository.findAll().get(0));

        // then
        assertThat(dibsRepository.findAll().size()).isEqualTo(0);
    }
}
