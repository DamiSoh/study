package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//주입해줘야하는 방법에만 @Component붙여서 빈 등록해주면 된다.
//만일 fixeddiscout로 변경하려면 여기 빈 설정 떼다가 거기다가 붙여주면 된다.
//스프링은 타입으로 찾기때문에 DiscoutPolicy 타입을 찾을 거고, 해당 타입을 구현한 RateDiscountPolicy를 찾아서 주입해줄 거다.
//만일 둘다 빈으로 등록되어있다면, qualifier를 설정해주어, 호출되는 데에서 @Qulifier("mainDiscountPolicy)넣어서 해주면 된다. (--> OrderServiceImpl)


@Component
@Qualifier("mainDiscountPolicy")

public class RateDiscountPolicy implements DiscountPolicy{
    public int discountPercentage = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercentage / 100;
        }else{
            return 0;
        }
    }
}
