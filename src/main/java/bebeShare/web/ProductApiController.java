package bebeShare.web;

import bebeShare.service.ProductService;
import bebeShare.web.dto.PostsResponseDto;
import bebeShare.web.dto.ProductCreateRequestDto;
import bebeShare.web.dto.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductApiController {

    private final ProductService productService;

    // 상품 게시글 등록
    @PostMapping("/products")
    public Long save(@RequestBody final ProductCreateRequestDto params) {
        return productService.save(params);
    }

    // 상품 게시글 조회
    @GetMapping("/products")
    public List<ProductResponseDto> findAll() {
        return productService.findAll();
    }

    // 상품 게시글 수정
    @PatchMapping("/Products/{productId}")
    public Long save(@PathVariable final Long id, @RequestBody final ProductCreateRequestDto params) {
        return productService.update(id, params);
    }
}
