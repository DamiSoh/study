package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

// -- Session03 - Spring의 시작
// AppConfig 같이 설정(구성)환경 파일에 @Configuration 애너테이션을 붙여준다.
// Main 메소드로 이동하여 AppConfig.class를 연결(Context)해준다.
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy(); 정률정책으로 바꾸려면 여기만 바꾸면 된다.
        return new RateDiscountPolicy();
    }

// -- Session 02
// 기존 Session 01은 어떤 인터페이스를 어떤 구현체로 설정하는지 굉장히 모호하기 때문에 바꾸어 주었다.
// 가령 return new MemberServiceImpl(new MemoryMemberRepository());는 MemoryMemberRepository();가 어떤 인터페이스의 구현체인지 알 수 없다.

//    public MemberService memberService(){
//        return new MemberServiceImpl(memberRepository());
//    }
//
//    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//    }
//
//    public OrderService orderService(){
//        return new OrderServiceImpl(memberRepository(), discountPolicy());
//    }
//
//    public DiscountPolicy discountPolicy(){
////        return new FixDiscountPolicy(); 정률정책으로 바꾸려면 여기만 바꾸면 된다.
//        return new RateDiscountPolicy();
//    }




//  -- Session 01
//    public MemberService memberService(){                               //1. 종속 인터페이스
//        return new MemberServiceImpl(new MemoryMemberRepository());     //2. 구현체 - 3. 구현체가 종속하는 도메인
//    }
//
//    public OrderService orderService(){
//        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
//    }
}
