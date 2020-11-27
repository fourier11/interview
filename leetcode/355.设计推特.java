import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=355 lang=java
 *
 * [355] 设计推特
 */

// @lc code=start
class Twitter {

    private class Node {
        Set<Integer> followee;
        LinkedList<Integer> tweet;

        Node() {
            followee = new HashSet<>();
            tweet = new LinkedList<>();
        }
    }
    private int recentMax;
    private int time;
    private Map<Integer, Integer> tweetTime;
    private Map<Integer, Node> user;

    /** Initialize your data structure here. */
    public Twitter() {
        time = 0;
        recentMax = 10;
        tweetTime = new HashMap<>();
        user = new HashMap<>();
    }

    public void init(int userId) {
        user.put(userId, new Node());
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!user.containsKey(userId)) {
            init(userId);
        }
        if (user.get(userId).tweet.size() == recentMax) {
            user.get(userId).tweet.remove(recentMax - 1);
        }
        user.get(userId).tweet.addFirst(tweetId);
        tweetTime.put(tweetId, ++time);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new LinkedList<>();
        for (int it : user.getOrDefault(userId, new Node()).tweet) {
            ans.add(it);
        }
        for (int followeeId : user.getOrDefault(userId, new Node()).followee) {
            if (followeeId == userId) { // 可能出现自己关注自己的情况
                continue;
            }
            LinkedList<Integer> res = new LinkedList<Integer>();
            int tweetSize = user.get(followeeId).tweet.size();
            Iterator<Integer> it = user.get(followeeId).tweet.iterator();
            int i = 0;
            int j = 0;
            int curr = -1;
            // 线性归并
            if (j < tweetSize) {
                curr = it.next();
                while (i < ans.size() && j < tweetSize) {
                    if (tweetTime.get(curr) > tweetTime.get(ans.get(i))) {
                        res.addLast(curr);
                        ++j;
                        if (it.hasNext()) {
                            curr = it.next();
                        }
                    } else {
                        res.addLast(ans.get(i));
                        ++i;
                    }
                    // 已经找到这两个链表合起来后最近的 recentMax 条推文
                    if (res.size() == recentMax) {
                        break;
                    }
                }
            }
            for (; i < ans.size() && res.size() < recentMax; ++i) {
                res.addLast(ans.get(i));
            }
            if (j < tweetSize && res.size() < recentMax) {
                res.addLast(curr);
                for (; it.hasNext() && res.size() < recentMax;) {
                    res.addLast(it.next());
                }
            }
            ans = new LinkedList<Integer>(res);
        }
        return ans;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!user.containsKey(followerId)) {
            init(followerId);
        }
        if (!user.containsKey(followeeId)) {
            init(followeeId);
        }
        user.get(followerId).followee.add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        user.getOrDefault(followerId, new Node()).followee.remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
// @lc code=end

