package chapter02.item05.singletonutility;

import chapter02.item05.Lexicon;

import java.util.List;

/**
 * 싱글턴을 잘못 사용한 예 - 유연하지 않고 테스트하기 어렵다.
 */
public class SpellChecker {
    private final Lexicon dictionary = new Lexicon();

    private SpellChecker() { }
    public static SpellChecker INSTANCE = new SpellChecker();

    public boolean isValid(String word) { return true; }
    public List<String> suggestioins(String typo) { return null; }
}
