import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=677 lang=java
 *
 * [677] 键值映射
 * 实现一个 MapSum 类，支持两个方法，insert 和 sum：
 * MapSum() 初始化 MapSum 对象
 * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
 * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
 * 
 * 说明；
 * key 和 prefix 仅由小写英文字母组成
 */

// @lc code=start
class MapSum {
    private TrieNode root;
    private HashMap<String, Integer> map = new HashMap<>();
    /** Initialize your data structure here. */
    public MapSum() {
        root = new TrieNode();
    }
    
    public void insert(String key, int val) {
        TrieNode cur = root;
        int diff = val - map.getOrDefault(key, 0);
        for (char c : key.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            } 
            cur.children[c - 'a'].count += diff;
            cur = cur.children[c - 'a'];
        }
        map.put(key, val);
    }
    
    public int sum(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.children[c -'a'] == null) {
                return 0;
            }
            cur = cur.children[c - 'a'];
        }
        return cur.count;
    }

    class TrieNode {
        TrieNode[] children;
        int count;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
// @lc code=end

