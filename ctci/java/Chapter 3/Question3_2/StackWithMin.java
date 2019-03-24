package Question3_2;

import java.util.Stack;

/**
 * 解法：放入栈的不是单纯的数字，而是一个对象。包含了数字和当前状态下的最小值。要找到min直接查看栈顶元素就能得到最小值
 * 缺点：当栈很大的时候，每个元素都要记录min，浪费大量空间
 */
public class StackWithMin extends Stack<NodeWithMin> {
    public void push(int value) {
        int newMin = Math.min(value, min());
        super.push(new NodeWithMin(value, newMin));
    }
    
    public int min() {
    	if (this.isEmpty()) {
    		return Integer.MAX_VALUE;
    	} else {
    		return peek().min;
    	}
    }
}
