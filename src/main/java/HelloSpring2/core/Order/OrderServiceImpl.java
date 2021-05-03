package HelloSpring2.core.Order;

import HelloSpring2.core.Member.Member;
import HelloSpring2.core.Member.MemberRepository;
import HelloSpring2.core.Member.MemoryMemberRepository;
import HelloSpring2.core.discount.DiscountPolicy;
import HelloSpring2.core.discount.FixDiscountPolicy;
import HelloSpring2.core.discount.RateDiscountPolicy;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
