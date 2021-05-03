package HelloSpring2.core.discount;

import HelloSpring2.core.Member.Grade;
import HelloSpring2.core.Member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * discountPercent / 100;
        }
        else{
            return 0;
        }

    }
}
