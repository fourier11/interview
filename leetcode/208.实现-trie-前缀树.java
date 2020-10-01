/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start
class Trie {

    private final int ALPHABET_SIZE = 26;

    private class TrieNode {
        private TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        private boolean isWordOrNot = false;
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode pointer = root;
        for (char c : word.toCharArray()) {
            if (pointer.children[c - 'a'] == null) {
                pointer.children[c - 'a'] = new TrieNode();
            }
            pointer = pointer.children[c - 'a'];
        }
        pointer.isWordOrNot = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode pointer = root;
        for (char c : word.toCharArray()) {
            if (pointer.children[c - 'a'] == null) {
                return false;
            }
            pointer = pointer.children[c - 'a'];
        }
        return pointer.isWordOrNot;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode pointer = root;
        for (char c : prefix.toCharArray()) {
            if (pointer.children[c - 'a'] == null) {
                return false;
            }
            pointer = pointer.children[c - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

