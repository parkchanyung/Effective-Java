package chapter02.item08;

/**
 * cleaner 안전망을 갖춘 자원을 제대로 활용하지 못하는 클라이언트
 */
public class Teenager {
    public static void main(String[] args) {
        new Room(99);
        System.out.println("아무렴!");

        // 가비지 컬렉터를 강제로 호출하는 이런 방식에 의존해서는 절대 안 된다!
        System.gc();
    }
}
