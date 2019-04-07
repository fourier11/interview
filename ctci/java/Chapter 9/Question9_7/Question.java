package Question9_7;

/**
 * 编写一个函数，实现许多图片编辑软件都支持的“颜色填充”功能，给定一个屏幕（以二维数组表示，元素为颜色值）、一个点
 * 和一个新的颜色值，将新颜色值填入这个点的周围区域，直到原来的颜色值全都改变
 */
public class Question {

	public enum Color {
		Black, White, Red, Yellow, Green
	}
	
	public static String PrintColor(Color c) {
		switch(c) {
		case Black:
			return "B";
		case White:
			return "W";
		case Red:
			return "R";
		case Yellow:
			return "Y";
		case Green:
			return "G";
		}
		return "X";
	}
	
	public static void PrintScreen(Color[][] screen) {
		for (int i = 0; i < screen.length; i++) {
			for (int j = 0; j < screen[0].length; j++) {
				System.out.print(PrintColor(screen[i][j]));
			}
			System.out.println();
		}
	}
	
	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}
	
	public static boolean PaintFill(Color[][] screen, int x, int y, Color ocolor, Color ncolor) {
		if (x < 0 || x >= screen[0].length || y < 0 || y >= screen.length) {
			return false;
		}
		// 注意y和x的顺序，因为x表示水平轴，自左向右，实际上对应于列数而非行数，y的值对应行数
		if (screen[y][x] == ocolor) {
			screen[y][x] = ncolor;
			PaintFill(screen, x - 1, y, ocolor, ncolor); // left
			PaintFill(screen, x + 1, y, ocolor, ncolor); // right
			PaintFill(screen, x, y - 1, ocolor, ncolor); // top
			PaintFill(screen, x, y + 1, ocolor, ncolor); // bottom
		}
		return true;
	}
	
	public static boolean PaintFill(Color[][] screen, int x, int y, Color ncolor) {
		if (screen[y][x] == ncolor) return false;
		return PaintFill(screen, x, y, screen[y][x], ncolor);
	}
	
	public static void main(String[] args) {
		int N = 10;
		Color[][] screen = new Color[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				screen[i][j] = Color.Black;
			}			
		}
		for (int i = 0; i < 100; i++) {
			screen[randomInt(N)][randomInt(N)] = Color.Green;
		}
		PrintScreen(screen);
		PaintFill(screen, 2, 2, Color.White);
		System.out.println();
		PrintScreen(screen);
	}

}
