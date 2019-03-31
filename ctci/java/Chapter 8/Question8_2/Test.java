package Question8_2;

/**
 * 员工分为三个等级：接线员、主管和经理，客户来电会先分配给有空的接线员。若接线员处理不了，就必须将来电往上转给主管。
 * 若主管没空或无法处理，则将来电往上转给经理。请设计这个问题的类和数据结构，并实现一个dispatchCall()方法，将客户来电分配
 * 给第一个有空的员工
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CallHandler ch = CallHandler.getInstance();
	}

}
