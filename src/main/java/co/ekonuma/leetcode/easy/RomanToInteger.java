package co.ekonuma.leetcode.easy;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(romanToInt("LVIII"));
    }

    public static int romanToInt(String s) {
        int sum = 0;
        AtomicReference<Integer> i = new AtomicReference<>();
        i.set(0);
        var symbols = s.split("");
        while (i.get() < symbols.length) {
            var symbol = Symbol.valueOf(symbols[i.get()]);
            sum += i.get() == symbols.length - 1 || symbol.getAfter().isEmpty() ? symbol.getValue() : symbol.getAfter()
                    .stream()
                    .filter(after -> after.equals(symbols[i.get() + 1]))
                    .map(after -> {
                        var value = Symbol.valueOf(symbols[i.get() + 1]).getValue() - symbol.getValue();
                        i.set(i.get() + 1);
                        return value;
                    })
                    .findFirst()
                    .orElseGet(() -> symbol.getValue());
            i.set(i.get() + 1);
        }
        return sum;
    }

    enum Symbol {
        I(1, List.of("V", "X")),
        V(5, List.of()),
        X(10, List.of("L", "C")),
        L(50, List.of()),
        C(100, List.of("D", "M")),
        D(500, List.of()),
        M(1000, List.of());

        private final int value;

        private final List<String> after;

        public int getValue() {
            return value;
        }

        public List<String> getAfter() {
            return after;
        }

        Symbol(int value, List<String> after) {
            this.value = value;
            this.after = after;
        }
    }
}
