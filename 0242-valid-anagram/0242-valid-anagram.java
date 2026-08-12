import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {

        // Length different hai to anagram possible nahi
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        // s ke characters ki frequency count karo
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        // t ke characters ki frequency decrease karo
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);

            if (!map.containsKey(ch)) {
                return false;
            }

            map.put(ch, map.get(ch) - 1);

            // Agar frequency negative hui → extra character hai
            if (map.get(ch) < 0) {
                return false;
            }
        }

        return true;
    }
}