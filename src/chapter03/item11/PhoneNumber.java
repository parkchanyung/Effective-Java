package chapter03.item11;

import java.util.HashMap;
import java.util.Map;

/**
 * equals를 재정의하면 hashCode로 재정의해야 함을 보여준다.
 */
public class PhoneNumber {
    private final short areaCode, prefix, lineNum;

    public PhoneNumber(short areaCode, short prefix, short lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix   = rangeCheck(prefix, 999, "prefix");
        this.lineNum  = rangeCheck(lineNum, 9999, "line num");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max) {
            throw new IllegalArgumentException(arg + ": " + val);
        }

        return (short) val;
    }

    @Override
    public boolean equals(Object o) {
        if(o == this){
            return true;
        }

        if(!(o instanceof PhoneNumber)){
            return false;
        }

        PhoneNumber pn = (PhoneNumber) o;
        return pn.lineNum == lineNum && pn.prefix == prefix && pn.areaCode == areaCode;
    }

    /*
    최악의 (하지만 적법한) hashCode 구현 - 사용금지!!
    @Override
    public int hashCode() {
        return 42;
    }
     */

    // 전형적인 hashCode 메서드
    @Override
    public int hashCode() {
        int result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);

        return result;
    }

    /*
    한 줄짜리 hashCode 메서드 - 성능이 살짝 아쉽다.
    @Override
    public int hashCode() {
        return Objects.hash(lineNum, prefix, areaCode);
    }
     */

    /*
    해시코드를 지연 초기화하는 hashCode 메서드 - 스레드 안정성까지 고려해야 한다.
    private int hashCode;  // 자동으로 0으로 초기화횐다.

    @Override
    public int hashCode() {
        int result = hashCode;

        if(result == 0) {
            result = Short.hashCode(areaCode);
            result = 31 * result + Short.hashCode(prefix);
            result = 31 * result + Short.hashCode(lineNum);
        }

        return result;
    }
     */

    public static void main(String[] args) {
        Map<PhoneNumber, String> m = new HashMap<>();
        m.put(new PhoneNumber((short) 707, (short) 867, (short) 5309), "제니");

        System.out.println(m.get(new PhoneNumber((short) 707, (short) 867, (short) 5309)));
    }
}
