package kr.co.sample.sampleapi.common.enums;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

// Enum class를 활용하여 custom 한 오류 메시지 선언.
@Getter
@ToString
public enum ExceptionEnum {
    RUNTIME_EXCEPTION(HttpStatus.BAD_REQUEST, "E0001"),
    ACCESS_DENIED_EXCEPTION(HttpStatus.UNAUTHORIZED, "E0002"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR , "E0003"),

    SECURITY_01(HttpStatus.UNAUTHORIZED , "S0001" , "권한이 없습니다.");

    private final HttpStatus status;
    private final String code;
    private String message;

    ExceptionEnum(HttpStatus status , String code){
        this.status = status;
        this.code = code;
    }

    ExceptionEnum(HttpStatus status, String code , String message){
         this.status = status;
         this.code = code;
         this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
