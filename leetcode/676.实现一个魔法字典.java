/*
 * @lc app=leetcode.cn id=676 lang=java
 *
 * [676] 实现一个魔法字典
 */

// @lc code=start
class MagicDictionary {
    private TrieNode root;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new TrieNode();
    }
    
    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.isWord = true;
        }
    }
    
    public boolean search(String searchWord) {
        char[] chs = searchWord.toCharArray();
        for (int i = 0; i < searchWord.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                // 这里判断的原因是查询字符不能和字典完全一致，参考hello那个用例
                if (chs[i] == c) {
                    continue;
                }
                char tmp = chs[i];
                chs[i] = c;
                if (contains(chs)) {
                    return true;
                }
                chs[i] = tmp;
            }
        }
        return false;
    }

    private boolean contains(char[] chs) {
        TrieNode cur = root;
        for (char c : chs) {
            cur = cur.children[c - 'a'];
            if (cur == null) {
                return false;
            }
        }
        return cur.isWord;
    } 

    class TrieNode {
        private boolean isWord;
        private TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
// @lc code=end

