package HelloSpring2.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.*;

class statefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        statefulService statefulService1 = ac.getBean(statefulService.class);
        statefulService statefulService2 = ac.getBean(statefulService.class);

        //ThreadA: A사용자 10000원 주문
        int userAprice = statefulService1.order("userA", 10000);
        //ThreadA: B사용자 20000원 주문
        int userBprice = statefulService2.order("userB", 20000);

//        int price = statefulService1.getPrice();
//        System.out.println("price = " + price);

        org.assertj.core.api.Assertions.assertThat(userAprice).isEqualTo(10000);

    }
    static class TestConfig {

        @Bean
        public statefulService statefulService() {
            return new statefulService();
        }
    }
}