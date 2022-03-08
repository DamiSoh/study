package hello.core.autowired;

import hello.core.AppConfig;
import hello.core.AutoAppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

// 특정 타입(DiscountPolicy.class)의 빈을 모두 조회하여
// 조회 결과를 담은 맵에서 꺼내어 쓰는 것. --> DiscountPolicy.class의 구현타입인 FixDiscount.class 와 Ratediscount.class를 모두 쓸 수 있다.

public class AllBeanTest {

    @Test
    void findAllBean() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(DiscountService.class, AutoAppConfig.class);

        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member(1, "userA", Grade.VIP);
        int fixDiscountPrice = discountService.discount(member, 20000, "fixDiscountPolicy");
        int rateDiscountPrice = discountService.discount(member, 10000, "rateDiscountPolicy");
        Assertions.assertThat(discountService).isInstanceOf(DiscountService.class);
        Assertions.assertThat(fixDiscountPrice).isEqualTo(1000);
        Assertions.assertThat(rateDiscountPrice).isEqualTo(1000);
    }

    static class DiscountService{

        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policyList;

        @Autowired
        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policyList) {
            this.policyMap = policyMap;
            this.policyList = policyList;
            System.out.println("Policy Map = " + policyMap);
            System.out.println("Policy List = "+ policyList);
        }

        public int discount(Member member, int price, String discountCode) {
            DiscountPolicy discountPolicy = policyMap.get(discountCode);
            return discountPolicy.discount(member, price);
        }
    }



//    @Test
//    void findAllBean() {
//        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);
//
//        DiscountService discountService = ac.getBean(DiscountService.class);
//
//        Member member = new Member(1L, "userA", Grade.VIP);
//        int discountPrice = discountService.discount(member, 10000, "fixDiscountPolicy");
//
//        assertThat(discountService).isInstanceOf(DiscountService.class);
//        assertThat(discountPrice).isEqualTo(1000);
//    }
//
//    static class DiscountService {
//        private final Map<String, DiscountPolicy> policyMap;
//        private final List<DiscountPolicy> policies;
//
//        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
//            this.policyMap = policyMap;
//            this.policies = policies;
//            System.out.println("policyMap = " + policyMap);
//            System.out.println("policies = " + policies);
//        }
//
//        public int discount(Member member, int price, String discountCode) {
//            DiscountPolicy discountPolicy = policyMap.get(discountCode);
//            System.out.println("discountCode = " + discountCode);
//            System.out.println("discountPolicy = " + discountPolicy);
//            return discountPolicy.discount(member, price);
//        }
//    }
}
