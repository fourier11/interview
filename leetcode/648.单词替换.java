/*
 * @lc app=leetcode.cn id=648 lang=java
 *
 * [648] 单词替换
 * 
 * 在英语中，我们有一个叫做 词根(root)的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
 * 现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 * 你需要输出替换之后的句子。
 */

// @lc code=start
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode tri = new TrieNode();
        for (String root : dictionary) {
            TrieNode cur = tri;
            for (char c : root.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.word = root;
        }

        StringBuilder res = new StringBuilder();
        for (String word : sentence.split("\\s+")) {
            // 如果res里有单词了，需要用空格分隔
            if (res.length() > 0 ) {
                res.append(" ");
            }
            TrieNode cur = tri;
            for (char c : word.toCharArray()) {
                // cur.word != null 表明cur是叶子节点了
                if (cur.children[c - 'a'] == null || cur.word != null) {
                    break;
                }
                cur = cur.children[c - 'a'];
            }
            res.append(cur.word != null ? cur.word : word);
        }
        return res.toString();
    }

    class TrieNode {
        private TrieNode[] children;
        private String word;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }
}


// @lc code=end

