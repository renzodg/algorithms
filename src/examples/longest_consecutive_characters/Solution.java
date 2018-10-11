package examples.longest_consecutive_characters;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

public class Solution {

    public static void main(String[] args) {
        Entry<Character, Integer> response = getLongestConsecutiveCharacters("AAAAAAAAAABBBBBBBBBBBBBBB");
        System.out.println(response);
    }

    static class Response {
        char character;
        int count;

        @Override
        public String toString() {
            return "Response [character=" + character + ", count=" + count + "]";
        }

    }

    public static Entry<Character, Integer> getLongestConsecutiveCharacters(String expression) {
        char[] charArray = expression.toCharArray();

        char previusChar = 'A';
        int count = 1;

        int maxCount = count;
        char maxChar = previusChar;

        for (int i = 1; i < charArray.length; i++) {
            char c = charArray[i];

            if (previusChar == c) {
                count++;
            } else {
                count = 1;
            }

            if (count > maxCount) {
                maxCount = count;
                maxChar = c;
            }

            previusChar = c;
        }
        
        return new SimpleEntry<>(maxChar, maxCount);
    }

}
