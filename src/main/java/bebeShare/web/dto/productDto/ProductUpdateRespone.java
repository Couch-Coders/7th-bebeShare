package bebeShare.web.dto.productDto;

import bebeShare.domain.product.Product;
import bebeShare.domain.user.User;
import lombok.Data;
import lombok.Getter;

import static bebeShare.domain.common.CommonContants.COMMENT_UPDATE_FAIL;
import static bebeShare.domain.common.CommonContants.COMMENT_UPDATE_OK;
import static bebeShare.domain.common.ResponeMsgEnum.RESPONES_FAIL;
import static bebeShare.domain.common.ResponeMsgEnum.RESPONES_SUCCESS;

@Data
public class ProductUpdateRespone {

    private static final String PROUDCT_UPDATE_OK = "상품 수정 성공";
    private static final String PROUDCT_UPDATE_FAIL ="상품 수정 실패" ;
    private Long productId;
    private String resultCode;
    private String resultMsg;



    public ProductUpdateRespone(Long productId) {
        this.setResultCode(RESPONES_SUCCESS.getValue());
        this.setResultMsg(PROUDCT_UPDATE_OK);
        this.productId = productId;
    }

    public  ProductUpdateRespone() {
        this.setResultCode(RESPONES_FAIL.getValue());
        this.setResultMsg(PROUDCT_UPDATE_FAIL);
        this.productId = 0L;
    }
}
