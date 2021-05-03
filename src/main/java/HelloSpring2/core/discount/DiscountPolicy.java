package HelloSpring2.core.discount;

import HelloSpring2.core.Member.Member;

public interface DiscountPolicy {
    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
