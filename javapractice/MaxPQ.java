/**
 * 二叉堆的实现 （可以用于优先级队列）
 * 
 * https://github.com/labuladong/fucking-algorithm/blob/master/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E7%B3%BB%E5%88%97/%E4%BA%8C%E5%8F%89%E5%A0%86%E8%AF%A6%E8%A7%A3%E5%AE%9E%E7%8E%B0%E4%BC%98%E5%85%88%E7%BA%A7%E9%98%9F%E5%88%97.md
 */
public class MaxPQ<Key extends Comparable<Key>> {
    // 存储元素的数组,第1个元素是根节点
    private Key[] pq;
    // 当前 Priority Queue 中的元素个数
    private int N = 0;

    public MaxPQ(int cap) {
        // 索引 0 不用，所以多分配一个空间
        pq = (Key[]) new Comparable[cap + 1];
    }

    /* 返回当前队列中最大元素 */
    public Key max() {
        return pq[1];
    }

    /* 插入元素 e */
    public void insert(Key e) {
        N++;
        pq[N] = e;
        swim(N);
    }

    /* 删除并返回当前队列中最大元素 */
    public Key delMax() {
        Key max = pq[1];
        exch(1, N);
        pq[N] = null;
        N--;
        sink(1);
        return max;
    }

    /* 上浮第 k 个元素，以维护最大堆性质 */
    private void swim(int k) {
        while (k > 1 && less(parent(k), k)) {
            exch(parent(k), k);
            k = parent(k);
        }

    }

    /* 下沉第 k 个元素，以维护最大堆性质 */
    private void sink(int k) {
        while(left(k) <= N) {
            // 先假设左边节点较大
            int older = left(k);
            // 如果右边节点存在，比一下大小
            if (right(k) <= N && less(older, right(k))) {
                older = right(k);
            }
            // 结点 k 比俩孩子都大，就不必下沉了
            if (less(older, k)) {
                break;
            }
            exch(k, older);
            k = older;
        }
    }

    /* 交换数组的两个元素 */
    private void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    /* pq[i] 是否比 pq[j] 小？ */
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    // 父节点的索引
    private int parent(int root) {
        return root / 2;
    }

    // 左孩子的索引
    private int left(int root) {
        return root * 2;
    }

    // 右孩子的索引
    private int right(int root) {
        return root * 2 + 1;
    }
}
