package bebeShare.domain.product;

import bebeShare.web.dto.productDto.ApproveShareProductRequest;
import bebeShare.web.dto.productDto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductRepositoryCustom {
    Page<ProductInfoResponseDto> findAllProducts(ProductRequest productRequest, Pageable pageable);

    Long approveShare(ApproveShareProductRequest approveShareProductRequest);

    Long completeShare(CompleteShareRequest completeShareRequest);

    Long rejectShare(RejectShareRequest rejectShareRequest);

    Long updateProductDetail(ProductCreateRequestDto productCreateRequestDto);
}
