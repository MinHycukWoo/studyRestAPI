package kr.co.sample.sampleapi.common.response;


import kr.co.sample.sampleapi.common.enums.ExceptionEnum;
import lombok.Getter;

import javax.servlet.http.HttpServletResponse;

@Getter
public class ApiException extends RuntimeException{
    private ExceptionEnum error;

    public ApiException(ExceptionEnum e){
        super(e.getMessage());
        this.error = e;
    }

    public ExceptionEnum getError() {
        return error;
    }

    //사용
    //ApiException(ExceptionEnum.SECURITY_01)

}
