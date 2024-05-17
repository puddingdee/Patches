import java.util.*;
public class Patch {
	protected int connectionCount;
	protected String name;
	ArrayList<Jack> globalJacks = new ArrayList<Jack>();
	protected ArrayList<Module> modulesUsed = new ArrayList<Module>();
	
	public Patch(String name) {
		this.name = name;
		connectionCount = 0;
		
		//this is whacked out
		WEATHER_DRONES WEATHER_DRONES = new WEATHER_DRONES();
		modulesUsed.add(WEATHER_DRONES);
		/*
		for (int g = 0; g < modulesUsed.size(); g++) {
			for (int h = 0; h < modulesUsed.get(g).getAllJacks().length; h++) {
				globalJacks.add(modulesUsed.get(g).allJacks[h]);
			}
		}
		
		*/
		for (int i = 0; i < WEATHER_DRONES.allJacks.length; i++) {
			globalJacks.add(WEATHER_DRONES.allJacks[i]);
		}
		
		
		
	}
	
	public void makeConnection(String out, String in) {
		connectionCount++;

		
		for (int i = 0; i < globalJacks.size(); i ++) {
			if (out.equals(globalJacks.get(i).name)) {
				globalJacks.get(i).setConnection(connectionCount);

			}
		}

		for (int i = 0; i < globalJacks.size(); i ++) {
			if (in.equals(globalJacks.get(i).name)) {
				globalJacks.get(i).setConnection(connectionCount);
			}
		}
	}
	
	public String toString() {
		String pic = "";
		pic += name + " // ";
		for (int i = 0; i < modulesUsed.size(); i++) {
			pic += modulesUsed.get(i).toString();
		}
		
		return pic;
	}
}
