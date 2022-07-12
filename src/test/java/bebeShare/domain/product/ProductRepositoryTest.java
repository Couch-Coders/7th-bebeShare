package bebeShare.domain.product;

import bebeShare.Application;
import bebeShare.domain.posts.Posts;
import bebeShare.domain.user.Role;
import bebeShare.domain.user.User;
import bebeShare.domain.user.UserRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

// 상품 게시글 crud

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTest {


    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    public void save() {

        User testUser = userRepository.save(User.builder()
                .name("test1")
                .picture("/fake/path")
                .email("test1@naver.com")
                .role(Role.USER)
                .build()
        );

        // 1. 상품 게시글 파라미터 생성
        Product product = Product.builder()
                .user(testUser)
                .productName("product0")
                .productCategory("100")
                .productContent("content0")
                .productImage1("1")
                .productImage2("2")
                .productImage3("3")
                .productStatus("S")
                .deleteYn("N")
                .build();

        // 2. 게시글 저장
        productRepository.save(product);

        // 3. 1번 상품 게시글 정보 조회
        List<Product> pro = productRepository.findAll();
        assertThat(pro.get(0).getProductContent()).isEqualTo("content0");
        assertThat(pro.get(0).getProductName()).isEqualTo("product0");

//        Product entity = productRepository.findById((long) 1).get();
//        assertThat(entity.getProductName()).isEqualTo("product0");
//        assertThat(entity.getProductContent()).isEqualTo("content0");
    }

    @Test
    public void findAll() {

        // 1. 전체 게시글 수 조회
        long productsCount = productRepository.count();

        // 2. 전체 게시글 리스트 조회
        List<Product> products = productRepository.findAll();

    }

    @Test
    public void delete() {

        User testUser = userRepository.save(User.builder()
                .name("test1")
                .picture("/fake/path")
                .email("test1@naver.com")
                .role(Role.USER)
                .build()
        );

        // 1. 상품 게시글 파라미터 생성
        Product product = Product.builder()
                .user(testUser)
                .productName("product0")
                .productCategory("100")
                .productContent("content0")
                .productImage1("1")
                .productImage2("2")
                .productImage3("3")
                .productStatus("S")
                .deleteYn("N")
                .build();

        // 2. 게시글 저장
        productRepository.save(product);


        // 1. 게시글 조회
        Product entity = productRepository.findById((long) 1).get();

        // 2. 게시글 삭제
        productRepository.delete(entity);
    }
}