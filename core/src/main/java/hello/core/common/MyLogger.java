package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value="request")
//@Scope(value="request", proxyMode = ScopedProxyMode.TARGET_CLASS)
//--- 이렇게 하면 ObjectProvider<T>없이 바로 싱글톤 사용하듯 private MyLogger myLogger 해서 사용할 수 있다.
//--- MyLogger를 상속받은 가짜 프록시 객체를 만들어서 주입시켜준다.
public class MyLogger {

    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message){
        System.out.println("[" + uuid + "]" + "[" + requestURL + "] " + message);
    }

    // 초기화 할때 uuid 얹어주기
    @PostConstruct
    public void init(){
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request scope bean created" + this);
    }

    @PreDestroy
    public void close(){
        System.out.println("[" + uuid + "] request scope bean closed" + this);
    }
}
