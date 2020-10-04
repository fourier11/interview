
/**
 * 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
 * 
 * 说明：解集不能包含重复的子集。
 * 
 * 集合的规律非常明显，只可能是1~n的整数
 * 
 * 递归法
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int n : nums) {
            int length = res.size();
            for (int i = 0; i < length; i++) {
                List<Integer> lists = new ArrayList<>();
                lists.addAll(res.get(i));
                lists.add(n);
                res.add(lists);
            }
        }
        return res;
    }
}