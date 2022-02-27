package hello.core.singleton;

import hello.core.stateful.StatefulService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class StatefulServiceTest {

    ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    void statefulServiceSingleton(){

        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        statefulService1.order("User-A", 10000);

        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);
        statefulService2.order("User-B", 20000);

        // price라는 공유필드를 클라이언트들이 공유해버리니까, A의 주문 금액이 아닌 그 다음에 요청한 B의 금액이 보이게 된다.
        // 스프링은 항상 무상태(stateless)로 설계해야 한다.

        int price = statefulService1.getPrice();

        Assertions.assertThat(price).isNotEqualTo(10000);

    }

    @Configuration
    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }

    }
}
