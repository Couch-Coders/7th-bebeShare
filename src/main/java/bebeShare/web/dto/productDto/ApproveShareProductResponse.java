package bebeShare.web.dto.productDto;

import bebeShare.domain.common.entity.ResEntity;
import lombok.Data;

import static bebeShare.domain.common.CommonContants.COMMENT_UPDATE_FAIL;
import static bebeShare.domain.common.CommonContants.COMMENT_UPDATE_OK;
import static bebeShare.domain.common.ResponeMsgEnum.RESPONES_FAIL;
import static bebeShare.domain.common.ResponeMsgEnum.RESPONES_SUCCESS;

@Data
public class ApproveShareProductResponse extends ResEntity {

    private static final String SHARRE_UPDATE_OK = "나눔 아이디 없데이트 성공";
    private static final String SHARRE_UPDATE_FAIL = "나눔 아이디 없데이트 실패";
    private String resultCode;
    private String resultMsg;
    private Long productid;

    public ApproveShareProductResponse(Long productid) {
        this.setResultCode(RESPONES_SUCCESS.getValue());
        this.setResultMsg(SHARRE_UPDATE_OK);
        this.productid = productid;
    }

    public ApproveShareProductResponse() {
        this.setResultCode(RESPONES_FAIL.getValue());
        this.setResultMsg(SHARRE_UPDATE_FAIL);
        this.productid = 0L;
    }
}