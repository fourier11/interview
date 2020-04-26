package snowflake;

/**
 * Created by again on 2018/3/5.
 */
public class FakeSnowFlake {
    private static long IP_NUM = 52356513615613L;
    private static long sequence = 0L;
    private static long twepoch = 1288834974657L;
    private static long workerIdBits = 5L;
    private static long sequenceBits = 12L;
    private static long workerIdShift = sequenceBits;
    private static long timestampLeftShift = sequenceBits + workerIdBits;
    private static long sequenceMask = -1L ^ (-1L << (int) sequenceBits);

    private static long lastTimestamp = -1L;
    private static Object syncRoot = new Object();

    public static long nextId() {
        synchronized (syncRoot) {
            long timestamp = System.currentTimeMillis();

            if (timestamp < lastTimestamp) {
                // throw new Exception(String.format("Clock moved backwards. Refusing to
                // generate id for %d milliseconds", lastTimestamp - timestamp));
                timestamp = lastTimestamp;
            }

            if (lastTimestamp == timestamp) {
                sequence = (sequence + 1) & sequenceMask;
                if (sequence == 0) {
                    timestamp = tilNextMillis(lastTimestamp);
                }
            } else {
                sequence = 0L;
            }

            lastTimestamp = timestamp;

            return ((timestamp - twepoch) << (int) timestampLeftShift) | (IP_NUM << (int) workerIdShift) | sequence;
        }
    }

    protected static long tilNextMillis(long lastTimestamp) {
        long timestamp = System.currentTimeMillis();
        while (timestamp <= lastTimestamp) {
            timestamp = System.currentTimeMillis();
        }
        return timestamp;
    }

    public static void main(String[] args) {
        for(int i = 0; i<100; i++) {
            System.out.println(nextId());
        }
        System.out.println("test");
    }
}
