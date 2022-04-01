package bebeShare.service;

import bebeShare.domain.product.Product;
import bebeShare.domain.product.ProductRepository;
import bebeShare.domain.user.UserRepository;
import bebeShare.exception.CustomException;
import bebeShare.exception.ErrorCode;
import bebeShare.web.dto.ProductCreateRequestDto;
import bebeShare.web.dto.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // 롬북 초기화 되지 않은 필드 생성 -> 의존성 주입 가능
public class ProductService {

    private final ProductRepository productRepository;



     //상품 게시글 생성
    @Transactional
    public Long save(final ProductCreateRequestDto params) {

        Product entity = productRepository.save(params.toEntity());
        return entity.getId();
    }

    // 게시글 목록 조회
    public List<ProductResponseDto> findAll() {

        Sort sort = Sort.by(Sort.Direction.DESC, "id", "createdDate");
        List<Product> list = productRepository.findAll(sort);
        return list.stream().map(ProductResponseDto::new).collect(Collectors.toList());
    }

    // 상품 게시글 수정
    @Transactional
    public Long update(final Long id, final ProductCreateRequestDto params) {

        Product entity = productRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));

        entity.update( params.getUser(), params.getProductName(), params.getProductContent(), params.getProductCategory(),
                params.getProductImage1(), params.getProductImage2(), params.getProductImage3(), params.getDeleteYn(), params.getProductStatus());
        return id;
    }

    // 상품 게시글 삭제
    @DeleteMapping("/products/{productId}")
    public void delete(@PathVariable Long id){
        productRepository.deleteById(id);
    }
}
