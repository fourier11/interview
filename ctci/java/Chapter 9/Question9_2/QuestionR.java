package Question9_2;

import java.util.ArrayList;
import java.util.Hashtable;
import java.awt.*;

import CtCILibrary.AssortedMethods;
/**
 * 有个机器人在X*Y的左上角，只能向右和向下移动，机器人从（0,0）到（X,Y）有多少种走法
 * 进阶：有些点为禁区，机器人不能踏足。找出路径从左上角移动到右下角。
 */
public class QuestionR {
	public static int[][] maze = new int[10][10];
	
	public static boolean isFree(int x, int y) {
		if (maze[x][y] == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean getPath(int x, int y, ArrayList<Point> path) {
		// If out of bounds or not available, return.
		if (y < 0 || x < 0 || !isFree(x, y)) {
			return false;
		}
		
		boolean isAtOrigin = (x == 0) && (y == 0);
		
		// If there's a path from the start to my current location, add my location.
		if (isAtOrigin || getPath(x, y - 1, path) || getPath(x - 1, y, path)) { 
			Point p = new Point(x, y);
			path.add(p);
			// 表示走成功了
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		int size = 5;
		maze = AssortedMethods.randomMatrix(size, size, 0, 5);
		
		AssortedMethods.printMatrix(maze);
		
		ArrayList<Point> path = new ArrayList<Point>();
		boolean success = getPath(size - 1, size - 1, path);
		if (success) {
			String s = AssortedMethods.listOfPointsToString(path);
			System.out.println(s);
		} else {
			System.out.println("No path found.");
		}
	}

}
