package Question17_2;

/**
 * 设计一种算法，判断玩家是否赢了井字游戏
 */
public class Question {

	//要将一个棋盘转出int，可以用3进位表示法。至此，要判断谁是赢家，只需要查询散列表。优点是查询效率高。
	public static int convertBoardToInt(char[][] board) {
		int factor = 1;
		int sum = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				int v = 0;
				if (board[i][j] == 'x') {
					v = 1;
				} else if (board[i][j] == 'o') {
					v = 2;
				}
				sum += v * factor;
				factor *= 3;
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		char[][] board = { 
				{'x', 'x', 'o'},
				{' ', 'x', ' '},
				{' ', ' ', 'x'}};
		
		int v = convertBoardToInt(board);
		System.out.println(v);
	}

}
