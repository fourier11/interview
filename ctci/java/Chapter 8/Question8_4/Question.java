package Question8_4;

import CtCILibrary.AssortedMethods;

/**
 * 运用面向对象原则，设计一个停车场
 * 停车场是多层的，每一层有好几排停车位
 * 停车场可以停放摩托车，轿车，大巴。车位有摩托车位，小车位，大车位
 * 摩托车可以停在任意车位上
 * 轿车可以停在单个小车位，或大车位
 * 大巴可以停在同一排五个连续的大车位上，但不能停在小车位
 */
public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ParkingLot lot = new ParkingLot();
		
		Vehicle v = null;
		while (v == null || lot.parkVehicle(v)) {
			lot.print();
			int r = AssortedMethods.randomIntInRange(0, 10);
			if (r < 2) {
				v = new Bus();
			} else if (r < 4) {
				v = new Motorcycle();
			} else {
				v = new Car();
			}
			System.out.print("\nParking a ");
			v.print();
			System.out.println("");
		}
		System.out.println("Parking Failed. Final state: ");
		lot.print();
	}

}
