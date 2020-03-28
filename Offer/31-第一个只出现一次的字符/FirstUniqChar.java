import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqChar {

    public char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 0) return " ".charAt(0);
        // 使用 Boolean, 而不是 Integer
        LinkedHashMap<Character, Boolean> linkedHashMap = new LinkedHashMap<>();
        for (Character c : chars) {
            linkedHashMap.put(c, !linkedHashMap.containsKey(c));
        }

        for (Map.Entry<Character, Boolean> entry : linkedHashMap.entrySet()) {
            if (entry.getValue()) return entry.getKey();
        }

        return ' ';
    }

    @Test
    public void test() {
        String s = "abaccdeff";
        System.out.println(firstUniqChar(s));
    }
}
