package Question9_10;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 给你n个箱子，宽高深已知，箱子不能翻转，将箱子堆起来时，下面的箱子的宽度，高度，深度必须大于上面的箱子
 * 实现一个方法，搭出最高的一堆箱子，箱堆的高度为每个箱子高度的总和
 * 解法：
 * 试着用每个箱子作为箱堆底部，并搭出可能的最高高度，就能找出箱堆最高的高度
 */
public class Question {
	
	public static int stackHeight(ArrayList<Box> boxes) {
		if (boxes == null) {
			return 0;
		}
		int h = 0;
		for (Box b : boxes) {
			h += b.height;
		}
		return h;
	}
	
	/**
	 * 这种做法效率偏低，是普通的递归程序
	 */
	public static ArrayList<Box> createStackR(Box[] boxes, Box bottom) {
		int max_height = 0;
		ArrayList<Box> max_stack = null;
		for (int i = 0; i < boxes.length; i++) {
			if (boxes[i].canBeAbove(bottom)) {
				ArrayList<Box> new_stack = createStackR(boxes, boxes[i]);
				int new_height = stackHeight(new_stack);
				if (new_height > max_height) {
					max_stack = new_stack;
					max_height = new_height;
				}
			}
		}
		
		if (max_stack == null) {
			max_stack = new ArrayList<Box>();
		}
		if (bottom != null) {
			max_stack.add(0, bottom);
		}
		
		return max_stack;
	}

	/**
	 * 运用动态规划的方式，效率更高
	 */
	public static ArrayList<Box> createStackDP(Box[] boxes, Box bottom, HashMap<Box, ArrayList<Box>> stack_map) {
		if (bottom != null && stack_map.containsKey(bottom)) {
			// 注意这里的类型强制转换，这个类重写了 clone() 方法，但是该方法仍然会返回Object，因此必须转型
			return (ArrayList<Box>) stack_map.get(bottom).clone();
		}
		
		int max_height = 0;
		ArrayList<Box> max_stack = null;
		for (int i = 0; i < boxes.length; i++) {
			if (boxes[i].canBeAbove(bottom)) {
				ArrayList<Box> new_stack = createStackDP(boxes, boxes[i], stack_map);
				int new_height = stackHeight(new_stack);
				if (new_height > max_height) {
					max_stack = new_stack;
					max_height = new_height;
				}
			}
		}		
		
		if (max_stack == null) {
			max_stack = new ArrayList<Box>();
		}
		if (bottom != null) {
			max_stack.add(0, bottom);
		}
		stack_map.put(bottom, max_stack);
		
		return max_stack;
	}
		
	
	public static void main(String[] args) {
		Box[] boxes = { new Box(3, 4, 1), new Box(8, 6, 2), new Box(7, 8, 3)};

		ArrayList<Box> stack = createStackDP(boxes, null, new HashMap<Box, ArrayList<Box>>());
		//ArrayList<Box> stack = createStackR(boxes, null);		
		for (int i = stack.size() - 1; i >= 0; i--) {
			Box b = stack.get(i);
			System.out.println(b.toString());
		}
	}

}
