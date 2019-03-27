package Question7_3;

/**
 * 给定直角坐标系上的两条线，确定这两条线会不会相交
 */
public class Question {	
	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Line line1 = new Line(randomInt(5), randomInt(1));
			Line line2 = new Line(randomInt(5), randomInt(2));
			line1.print();
			System.out.print(", ");
			line2.print();
			if (line1.intersect(line2)) {
				System.out.println("  YES");
			} else {
				System.out.println("  NO");
			}
		}
	}

}
