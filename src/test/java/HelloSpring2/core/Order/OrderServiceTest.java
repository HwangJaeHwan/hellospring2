package HelloSpring2.core.Order;

import HelloSpring2.core.AppConfig;
import HelloSpring2.core.Member.Grade;
import HelloSpring2.core.Member.Member;
import HelloSpring2.core.Member.MemberService;
import HelloSpring2.core.Member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        //given
        Long memberId = 1L;
        Member member = new Member((memberId), "memberA", Grade.VIP);
        memberService.join(member);
        //when
        Order order = orderService.createOrder(memberId, "tiemA", 10000);

        //then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
