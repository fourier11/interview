
class Solution {

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> counts = new HashMap<>();

        int n = s.length();
        char[] sArr = s.toCharArray();
        int[] hash = new int[26];

        int l = 0, result = 0, unique = 0;
        for (int r = 0; r < n; ++r) {
            if (hash[sArr[r] - 'a']++ == 0) {
                unique++;
            }

            // 如果条件不满足，移动左指针，缩小窗口，使条件满足
            while (unique > maxLetters || r - l + 1 > minSize) {
                if (hash[sArr[l++] - 'a']-- == 1) {
                    unique--;
                }
            }

            // 条件满足，更新答案，这里只考虑 minSize
            if (r - l + 1 == minSize) {
                String cur = s.substring(l, r + 1);
                counts.put(cur, counts.getOrDefault(cur, 0) + 1);
                result = Math.max(result, counts.get(cur));
            }
        }

        return result;
    }
}
