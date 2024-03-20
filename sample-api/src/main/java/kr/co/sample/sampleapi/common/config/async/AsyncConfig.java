package kr.co.sample.sampleapi.common.config.async;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;


//비동기 처리
@Configuration
@EnableAsync
public class AsyncConfig extends AsyncConfigurerSupport {
    @Autowired
    private AsyncUncaughtExceptionHandler asyncExceptionHandler;

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler(){
        return asyncExceptionHandler;
    }
}
