package chapter03.item10.inheritance;

import chapter03.item10.Color;
import chapter03.item10.Point;

public class ColorPoint extends chapter03.item10.Point {
    private final chapter03.item10.Color color;

    public ColorPoint(int x, int y, chapter03.item10.Color color) {
        super(x, y);
        this.color = color;
    }


    /*
    잘못된 코드 - 대칭성 위배!
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof ColorPoint)) {
            return false;
        }
        return super.equals(o) && ((ColorPoint) o).color == color;
    }
     */

    // 잘못된 코드 - 추이성 위배!
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Point)) {
            return false;
        }

        // o가 일반 Point면 색상을 무시하고 비교한다.
        if(!(o instanceof ColorPoint)) {
            return o.equals(this);
        }

        // o가 ColorPoint면 색상까지 비교한다.
        return super.equals(o) && ((ColorPoint) o).color == color;
    }

    public static void main(String[] args) {
        ColorPoint p1 = new ColorPoint(1, 2, chapter03.item10.Color.RED);
        chapter03.item10.Point p2 = new chapter03.item10.Point(1, 2);
        ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);

        System.out.println(p1.equals(p2));
        // 결과 : true
        System.out.println(p2.equals(p3));
        // 결과 : true
        System.out.println(p1.equals(p3));
        // 결과 : false
    }
}
