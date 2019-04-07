package Question10_2;

import java.util.HashMap;

/**
 * 设计像Facebook的大型社交网站，展示两个人之间的连接关系。eg.我->XXXX->YYY->ZZZ->你
 * 考虑广度优先搜索
 */
public class Server {
	HashMap<Integer, Machine> machines = new HashMap<Integer, Machine>();
	HashMap<Integer, Integer> personToMachineMap = new HashMap<Integer, Integer>();
	
	public Machine getMachineWithId(int machineID) {
		return machines.get(machineID);
	}
	
	public int getMachineIDForUser(int personID) {
		Integer machineID = personToMachineMap.get(personID);
		return machineID == null ? -1 : machineID;
	}
	
	public Person getPersonWithID(int personID) {
		Integer machineID = personToMachineMap.get(personID);
		if (machineID == null) {
			return null;
		}
		Machine machine = getMachineWithId(machineID);
		if (machine == null) {
			return null;
		}
		return machine.getPersonWithID(personID);
	}
}
