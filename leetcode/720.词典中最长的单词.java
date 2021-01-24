import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=720 lang=java
 *
 * [720] 词典中最长的单词
 * 
 * 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答案中字典序最小的单词。
 * 若无答案，则返回空字符串。
 * 
 * 说明：
 * 所有输入的字符串都只包含小写字母。
 */

// @lc code=start
class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words, (w1, w2) -> {
            if (w1.length() != w2.length()) {
                return w2.length() - w1.length();
            };
            return w1.compareTo(w2);
        });

        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        for (String word : words) {
            if (trie.hasAllPrefixes(word)) {
                return word;
            }
        }
        return "";
    }   
}


class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    public boolean hasAllPrefixes(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                return false;
            }
            cur = cur.children[c - 'a'];
            if (!cur.isWord) {
                return false;
            }
        }
        return true;
    }

    private class TrieNode {
        private TrieNode[] children;
        private boolean isWord;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
}
// @lc code=end

