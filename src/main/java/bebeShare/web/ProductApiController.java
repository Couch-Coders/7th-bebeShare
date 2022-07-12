package bebeShare.web;

import bebeShare.domain.like.DibsRepository;
import bebeShare.service.ProductService;
import bebeShare.web.dto.productDto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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
    public Page<ProductInfoResponseDto> findAllProducts(@RequestBody ProductRequest productRequest) {
        Pageable pageable = PageRequest.of(productRequest.getPage(), productRequest.getSize());
        return productService.findAllProducts(productRequest, pageable);
    }


    // 상품 게시글 상세 조회
    @GetMapping("/products/{productId}")
    public ProductResponseDto findById(@PathVariable Long productId) {
        return productService.findById(productId);
    }

    // 상품 게시글 수정
    @PatchMapping("/products")
    public ProductUpdateRespone update(@RequestBody ProductCreateRequestDto params) {
        Long updateCnt = productService.update(params);

        if (updateCnt == 0) {
            return new ProductUpdateRespone();
        }
        return new ProductUpdateRespone(params.getProductId());
    }

    // 상품 게시글 삭제
    @DeleteMapping("/products")
    public Long delete(@RequestBody ProductDeleteDto params) {
        productService.delete(params);

        return params.getProductId();
    }

    // 상품 게시글 상태변경
    @PatchMapping("/products/approveShare")
    public ApproveShareProductResponse approveShare(@RequestBody ApproveShareProductRequest params) {
        Long updateCnt = productService.approveShare(params);

        if (updateCnt == 0) {
            return new ApproveShareProductResponse();
        }
        return new ApproveShareProductResponse(params.getProductId());
    }

    // 나눔 완료
    @PatchMapping("/products/completeShare")
    public ApproveShareProductResponse completeShare(@RequestBody CompleteShareRequest params) {
        Long updateCnt = productService.completeShare(params);

        if (updateCnt == 0) {
            return new ApproveShareProductResponse();
        }
        return new ApproveShareProductResponse(params.getProductId());
    }
    // 나눔 거절
    @PatchMapping("/products/rejectShare")
    public ApproveShareProductResponse rejectShare(@RequestBody RejectShareRequest params) {
        Long updateCnt = productService.rejectShare(params);

        if (updateCnt == 0) {
            return new ApproveShareProductResponse();
        }
        return new ApproveShareProductResponse(params.getProductId());
    }

}
