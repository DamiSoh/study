package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {

// Section 03 --
// getBean("name", Name.class); ==> 메소드명이 빈의 디폴트 이름이 된다.
// @Bean("new Name") 으로 설정하면 이름 바뀌긴 하는데, 추천하진 않는다.
// ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
// ApplicationContext : 인터페이스, AnnotationConfigApplicationContext : 인터페이스 구현 클래스이다.
// AppConfig 는 생성자에 들어가는 필수 파라미터다

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member001 = new Member(1L, "member001", Grade.VIP);
        memberService.join(member001);
        Member findMember = memberService.findMember(1L);

        System.out.println("findMember= " + findMember.getName());
        System.out.println("new member= " + member001.getName());

// Section 02 --
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();
//
//        Member member001 = new Member(1L, "member001", Grade.VIP);
//        memberService.join(member001);
//        Member findMember = memberService.findMember(1L);
//
//        System.out.println("findMember= " + findMember.getName());
//        System.out.println("new member= " + member001.getName());

// Section 01 --
//        MemberService memberService = new MemberServiceImpl();
//        Member member001 = new Member(1L, "member001", Grade.VIP);
//
//        memberService.join(member001);
//        Member findMember = memberService.findMember(1L);
//
//        System.out.println("findMember= " + findMember.getName());
//        System.out.println("new member= " + member001.getName());
    }
}
