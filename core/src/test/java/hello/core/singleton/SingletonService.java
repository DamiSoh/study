package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }


    //private 생성자 만들어서 외부에서 맘대로 인스턴스 생성 못하게 막기
    //SingletonService singletonService = new SingletonService(); 못한다는 소리다.
    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱긑톤 객체 로직 호출");
    }


}
