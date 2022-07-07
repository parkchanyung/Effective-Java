package chapter02.item05.dependencyinjection;

import chapter02.item05.Lexicon;

import java.util.List;
import java.util.Objects;

/**
 * 의존 객체 주입은 유연성과 테스트 용이성을 높여준다.
 */
public class SpellChecker {
    private final Lexicon dictionary;

    public SpellChecker(Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public static boolean isValid(String word) { return true; }
    public static List<String> suggestioins(String typo) { return null; }
}
