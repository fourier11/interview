import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU缓存机制, 直接实现底层双向链表
 */

// @lc code=start
class LRUCache {

    private HashMap<Integer, Node> map;
    private DoublieList cache;
    private int cap;


    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoublieList();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return map.get(key).value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            deleteKey(key);
            addRecently(key, value);
            return;
        }
        if (cap == cache.size()) {
            removeLeastRecently();
        }
        addRecently(key, value);
    }

    private void makeRecently(int key) {
        Node x = map.get(key);
        cache.remove(x);
        cache.addLast(x);
    }

    private void addRecently(int key, int value) {
        Node x = new Node(key, value);
        cache.addLast(x);
        map.put(key, x);
    }

    private void deleteKey(int key) {
        Node x = map.get(key);
        cache.remove(x);
        map.remove(key);
    }
    /**
     * 删除最久未使用
     */
    private void removeLeastRecently() {
        Node deleteNode = cache.removeFirst();
        int deletedKey = deleteNode.key;
        map.remove(deletedKey);
    }




    /**
     * 双向链表 
     */
    class DoublieList {
        // 虚拟头节点
        private Node head;
        // 虚拟尾节点
        private Node tail;
        // 链表元素个数
        private int size;
        
        public DoublieList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void addLast(Node x) {
            x.prev = tail.prev;
            x.next = tail;
            tail.prev.next = x;
            tail.prev = x;
            size++;
        }

        public void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        public Node removeFirst() {
            if (head.next == tail) {
                return null;
            }
            Node first = head.next;
            remove(first);
            return first;
        }

        public int size() {
            return size;
        }
    }


    class Node {
        public int key;
        public int value;
        public Node next;
        public Node prev;

        public Node(int k, int v) {
            this.key = k;
            this.value = v;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

