package Question8_4;

/**
 * ParkingLot类本质上就是Level数组的包裹类（TODO：怎么理解的？），以这种方式实现，将空车位和泊车的处理逻辑从 ParkingLot 
 * 抽取出来。
 * 实现了将 ParkingLot 与 Level 分离开来，整个设计更显得清晰
 */
public class ParkingLot {
	private Level[] levels;
	private final int NUM_LEVELS = 5;
	
	public ParkingLot() {
		levels = new Level[NUM_LEVELS];
		for (int i = 0; i < NUM_LEVELS; i++) {
			levels[i] = new Level(i, 30);
		}
	}
	
	/* Park the vehicle in a spot (or multiple spots). Return false if failed. */
	public boolean parkVehicle(Vehicle vehicle) {
		for (int i = 0; i < levels.length; i++) {
			if (levels[i].parkVehicle(vehicle)) {
				return true;
			}
		}
		return false;
	}
	
	public void print() {
		for (int i = 0; i < levels.length; i++) {
			System.out.print("Level" + i + ": ");
			levels[i].print();
			System.out.println("");
		}
		System.out.println("");
	}
}
