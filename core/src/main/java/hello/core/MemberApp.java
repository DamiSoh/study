package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderService;

public class MemberApp {
    public static void main(String[] args) {

// Section 02 --
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Member member001 = new Member(1L, "member001", Grade.VIP);
        memberService.join(member001);
        Member findMember = memberService.findMember(1L);

        System.out.println("findMember= " + findMember.getName());
        System.out.println("new member= " + member001.getName());

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
