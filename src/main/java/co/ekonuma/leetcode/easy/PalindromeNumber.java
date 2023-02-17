package co.ekonuma.leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(1456));
        System.out.println(isPalindrome(1441));
        System.out.println(isPalindrome(15551));
        System.out.println(isPalindrome(-15651));
        System.out.println(isPalindrome(1576751));
    }

    public static boolean isPalindrome(int x) {
        List<Integer> integers = new ArrayList<>();
        if (x < 11)
            return false;

        while (x % 10 != 0) {
            integers.add(x % 10);
            x = integers.get(0) < 0 && integers.size() > 1 ? x / 10 * -1 : x / 10;
        }
        int lastIndex = integers.size() - 1;
        int firstIndex = 0;
        while (lastIndex - firstIndex > 1 || integers.size() == 2) {
            if (!Objects.equals(integers.get(firstIndex), integers.get(lastIndex)))
                return false;
            firstIndex++;
            lastIndex--;
        }
        return true;
    }
}
