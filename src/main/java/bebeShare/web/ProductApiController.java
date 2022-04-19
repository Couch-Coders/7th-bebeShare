package bebeShare.web;

import bebeShare.config.auth.LoginUser;
import bebeShare.config.auth.dto.SessionUser;
import bebeShare.domain.like.Dibs;
import bebeShare.domain.like.DibsRepository;
import bebeShare.service.ProductService;
import bebeShare.web.dto.productDto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductApiController {

    private final ProductService productService;
    private final DibsRepository repository;

    // 상품 게시글 등록
    @PostMapping("/product")
    public Long save(@RequestBody final ProductCreateRequestDto params) {
        return productService.save(params);
    }

    // 상품 게시글 목록 조회
    @PostMapping(value = "/products")
    public List<ProductInfoResponseDto> findAllProducts(@RequestBody ProductRequest productRequest, @LoginUser SessionUser sessionUser) {
        return productService.findAllProducts(productRequest);
    }


    // 상품 게시글 상세 조회
    @ResponseBody
    @GetMapping("/products/{productId}")
    public ProductResponseDto findById(@PathVariable Long productId) {
        return productService.findById(productId);
    }

    // 상품 게시글 수정
    @PatchMapping("/products")
    public Long update(@RequestBody final ProductCreateRequestDto params) {
        return productService.update(params);
    }

    // 상품 게시글 삭제
    @DeleteMapping("/products")
    public void delete(@RequestBody ProductDeleteDto params) {
        productService.delete(params);
    }

}
