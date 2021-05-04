package HelloSpring2.core;

import HelloSpring2.core.Member.Member;
import HelloSpring2.core.Member.MemberService;
import HelloSpring2.core.Member.MemberServiceImpl;
import HelloSpring2.core.Member.MemoryMemberRepository;
import HelloSpring2.core.Order.OrderService;
import HelloSpring2.core.Order.OrderServiceImpl;
import HelloSpring2.core.discount.DiscountPolicy;
import HelloSpring2.core.discount.FixDiscountPolicy;
import HelloSpring2.core.discount.RateDiscountPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {//팩토리 빈을 통해 빈 등록

    @Bean
    public MemberService memberService() {//생성자 주입
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
