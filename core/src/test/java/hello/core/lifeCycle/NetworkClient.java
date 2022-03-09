package hello.core.lifeCycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, Url =  " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect(){
        System.out.println("connect: " + url);
    }

    public void call(String message){
        System.out.println("call: +" + url + " message = " + message);
    }

    @PostConstruct
    public void init(){
        System.out.println("init 메소드 실행");
        connect();
        call("초기화 연결 메시지");
    }
    //서비스 종료시 호출
    @PreDestroy
    public void disconnect(){
        System.out.println("close " + url);
        disconnect();
    }

}
