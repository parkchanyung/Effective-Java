package chapter02.item06;

import java.util.regex.Pattern;

/**
 * 값비싼 객체를 재사용해 성능을 개선한다.
 */
public class RomanNumerals {
    // 성능을 훨씬 더 끌어올릴 수 있다!
    static boolean isRomanNumeralSlow(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})"
                + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    private static final Pattern ROMAN = Pattern.compile(
            "^(?=.)M*(C[MD]|D?C{0,3})"
                    + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    static boolean isRomanNumeralFast(String s) {
        return ROMAN.matcher(s).matches();
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        for(int i=0; i<10; i++) {
            boolean b = isRomanNumeralSlow("MCMLXXVI");
        }
        long end = System.nanoTime();

        System.out.println("slow : " + (end - start) + " μs.");

        start = System.nanoTime();
        for(int i=0; i<10; i++) {
            boolean b = isRomanNumeralFast("MCMLXXVI");
        }
        end = System.nanoTime();

        System.out.println("fast : " + (end - start) + " μs.");
    }
}
