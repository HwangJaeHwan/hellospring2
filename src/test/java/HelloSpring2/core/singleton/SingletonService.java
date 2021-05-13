package HelloSpring2.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {//외부에서 해당 클래스 객체 생성을 막음

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
