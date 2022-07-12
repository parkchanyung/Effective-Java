package chapter03.item10;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point)) {
            return false;
        }

        Point p = (Point)o;
        return p.x == x && p.y == y;
    }

    /*
    잘못된 코드 - 리스코프 치환 원칙 위배!
    @Override public boolean equals(Object o) {
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        Point p = (Point) o;
        return p.x == x && p.y == y;
    }
     */

    // 아이템 11의 내용을 참조해서 hashCode 메서드 재정의
    @Override public int hashCode()  {
        return 31 * x + y;
    }
}
