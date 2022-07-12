package bebeShare.service;

import bebeShare.domain.user.User;
import bebeShare.exception.CustomException;
import bebeShare.exception.ErrorCode;
import com.google.cloud.storage.Bucket;
import com.google.firebase.cloud.StorageClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static bebeShare.domain.product.QProduct.product;
import static java.util.Objects.hash;

@Slf4j
@Service
public class ImageService {
    @Autowired
    private Bucket bucket;

    public String createImage(byte[] image, User user){
        //Image 저장 위치를 선언
        String blob = "products/images/"+user.getId()+"/"+hash(image);
        log.info("blob ={}",blob);
        log.info("bucket ={}",bucket);
        try{
            // 이미 존재하면 파일 삭제
            if(bucket.get(blob) != null){
                bucket.get(blob).delete();
            }
            // 파일을 Bucket에 저장
            bucket.create(blob,image);
        // 상품 Image 위치 리턴
        return blob;
        }catch(Exception e){
            throw new CustomException(ErrorCode.IMAGE_UPLOAD_FAILED);
        }
    }

    public byte[] getImage(String userid,String filename){
        String bucketPath = "products/images/"+userid+"/"+filename;
        return bucket.get(bucketPath).getContent();
    }
}
