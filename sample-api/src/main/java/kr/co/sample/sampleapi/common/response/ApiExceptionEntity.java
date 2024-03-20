package kr.co.sample.sampleapi.common.response;

import com.sun.nio.sctp.SendFailedNotification;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

//일관된 오류 메시지 형식으로 응답.
@Getter
@ToString
public class ApiExceptionEntity {
    private String errorCode;
    private String errorMessage;

    @Builder
    public ApiExceptionEntity(HttpStatus status, String errorCode , String errorMessage) {
        this.errorCode = errorCode; //200,300등
        this.errorMessage = errorMessage;
    }




    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }


}
