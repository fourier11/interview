import java.util.LinkedHashMap;

/**
 * LRU的简单实现，其中 LinkedHashMap 的 removeEldestEntry 方法本来就设计成protect权限， 说明是给开发者预留的
 * 注意：LinkedHashMap不是线程安全的，否则封装代理，添加synchronized
 * https://coderxing.gitbooks.io/architecture-evolution/content/di-er-pian-ff1a-feng-kuang-yuan-shi-ren/42-xing-neng-zhi-ben-di-huan-cun/421-ying-yong-ceng-ben-di-huan-cun/4211.html
 */
public class LruCache<K, V> extends LinkedHashMap<K, V> {
    private static final long serialVersionUID = 4504158311663914052L;

    private int maxCacheSize;

    public LruCache(int maxCacheSize) {

        // 第三个参数为 accessOrder，默认为false。表示按照按照访问顺序排列元素，最近访问的元素会排雷在队末尾

        super(maxCacheSize, 0.75f, true);

        this.maxCacheSize = maxCacheSize;

    }

    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {

        // 当达到预设缓存上限时删除最老元素
        return this.size() >= maxCacheSize + 1;
    }

    /**
     * 如果需要支持线程安全，加上下面的锁。如果不需要线程安全，可以不用
     * 
     * 另一种方法，初始化的时候：
     * Map<String, String> cache = Collections.synchronizedMap(new LruCache<String, String>(3));
     */
    @Override
    public V put(K key, V value) {
        synchronized {
            return super.put(key, value);
        }
    }
}
