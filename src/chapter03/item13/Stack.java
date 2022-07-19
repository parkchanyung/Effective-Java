package chapter03.item13;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Stack의 복제 가능 버전
 */
public class Stack implements Cloneable {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if(elements.length == size){
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    public Object pop() {
        if(size == 0) {
            throw new EmptyStackException();
        }

        Object result = elements[--size];
        elements[size] = null;
        return result;
    }

    /**
     * 가변 상태를 참조하는 클래스 용 clone
     */
    @Override
    public Stack clone() {
        try {
            Stack result = (Stack) super.clone();
            // 배열의 clone은 원본 배열과 똑같은 배열을 반환한다.
            result.elements = elements.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        String[] ss = new String[]{"a", "b", "c", "d", "e"};

        for(String s : ss) {
            stack.push(s);
        }

        Stack copy = stack.clone();

        while (!stack.isEmpty()) {
            System.out.println(stack.pop() + " ");
        }
        System.out.println();
        while (!copy.isEmpty()) {
            System.out.println(copy.pop() + " ");
        }
    }
}
