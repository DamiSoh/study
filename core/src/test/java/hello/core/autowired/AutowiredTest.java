package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean{
        @Autowired(required = false)
        public void setNoBean1(Member noBean1){
            System.out.println("nobean1 = " + noBean1);
        }
        //만약 @Autowired or @Autowired(required = true) 했다면 Member 빈 설정을 해두지 않기 때문에 스프링 올라오면서 바로 에러 터진다.
        //false설정해두면 빈이 없다면 아예 메소드 자체가 호출되지 않는다.

        @Autowired
        public void setNoBean2(@Nullable Member noBean2){
            System.out.println("nobean2 = " + noBean2);
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3){
            System.out.println("nobean3 = " + noBean3);
        }
    }
}
