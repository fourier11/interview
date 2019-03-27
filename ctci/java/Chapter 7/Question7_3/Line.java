package Question7_3;


public class Line {
	static double epsilon = 0.000001;
	public double slope;
	public double yintercept;
	
	public Line(double s, double y) {
		slope = s;
		yintercept = y;
	}
	
	public void print() {
		System.out.print("y = " + slope + "x + " + yintercept);
	}
	
	// 判断两条线是否相交，只需检查两者的斜率是否相同，或是否为同一条
	public boolean intersect(Line line2) {
		// 注意：double类型的数据判断相等不能用 == ，而是通过做差，然后与一个小数作比较
		return Math.abs(slope - line2.slope) > epsilon ||
			   Math.abs(yintercept - line2.yintercept) < epsilon;
	}
};