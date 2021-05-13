package HelloSpring2.core.Order;

import HelloSpring2.core.Member.Grade;
import HelloSpring2.core.Member.Member;
import HelloSpring2.core.Member.MemoryMemberRepository;
import HelloSpring2.core.discount.FixDiscountPolicy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
        memoryMemberRepository.save(new Member(1L,"name", Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(memoryMemberRepository,  new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}