package HelloSpring2.core.singleton;

public class statefulService {

    //private int price;//상태 유지 필드

    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
//        this.price = price;
        return price;
    }


}
