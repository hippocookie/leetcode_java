import java.util.HashSet;
import java.util.Set;

public class N3_LongestSubstringWithoutRepeatingCharacters {
    
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> exist = new HashSet<>();
        int max = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                exist.remove(s.charAt(i - 1));
            }
            while (right < s.length() && !exist.contains(s.charAt(right))) {
                exist.add(s.charAt(right));
                right++;
            }
            max = Math.max(max, right - i);
        }
        return max;
    }
}
