/**
 * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
 * 
 * 注意：本题相对原题稍作修改
 * 
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"], 
 * 输出: [ ["ate","eat","tea"],
 * ["nat","tan"], ["bat"] ]
 * 
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        res.addAll(map.values());
        return res;
    }
}