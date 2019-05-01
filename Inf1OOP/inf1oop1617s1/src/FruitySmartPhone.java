
import java.util.HashMap;
import java.util.Objects;

import javax.swing.event.ListSelectionEvent;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FruitySmartPhone extends Phone {	
	public FruitySmartPhone(String ownerName, int freeMemory, int cpuSpeed) {
		super(ownerName);
		this.freeMemory = freeMemory;
		this.cpuSpeed = cpuSpeed;
	}
	//Stores the names of apps and the total memory used by each app
	private HashMap<String, Integer> installedApps = new HashMap<>();
	private int cpuSpeed;
	private int freeMemory;
	
	public boolean installApp(App app) {
		
		/*It should do nothing and return false if:
			- the app is already installed,
			- insufficient memory is available
			- the app’s required CPU speed is greater than the phone’s CPU speed
		*/
		if (installedApps.containsKey(app.getName()) || app.getMemoryReq() > this.freeMemory || app.getCpuReq() > this.cpuSpeed) {
			return false;
		} else {/* 
			If all three conditions are met:
			 - add the app and its space used to the HashMap installedApps
			 - reduce freeMemory appropriately
			 - return true
		 	*/
			this.installedApps.put(app.getName(), app.getMemoryReq());
			this.freeMemory -= app.getMemoryReq();
			return true;
		}
	}
	
	public boolean uninstallApp(App app) {
		if (!this.installedApps.containsKey(app.getName())) return false;
		else {
			/* otherwise do:
			 * 	-remove the app from the installedApps HashMap
			 *  -update the instance variable freeMemory to reflect the increased available memory after uninstalling the app
			 *  -return true
			 */
			this.freeMemory += this.installedApps.get(app.getName());
			this.installedApps.remove(app.getName());
			return true;
		}
	}
	
	public boolean useApp(String appName) {
		if (this.installedApps.containsKey(appName) && this.freeMemory >= 1) {
			this.installedApps.replace(appName,this.installedApps.get(appName)+1);
			this.freeMemory -= 1;
			return true;
		} else {
			return false;
		}
	}
	
	public ArrayList<String> getInstalledApps(){
		ArrayList<String> outputList = new ArrayList<>();
		outputList.addAll(installedApps.keySet());
		outputList.sort((x1, x2) -> installedApps.get(x1) < installedApps.get(x2) ? -1 : 1);
		
//		while (!this.installedApps.isEmpty()) {
//			String[] keys = this.installedApps.keySet().toArray(new String[0]);
//			int max = 0; //this way, the first element of keys will always be the max initially
//			String maxKey = null;
//			for (String key: keys) {
//				if (max < this.installedApps.get(key)) {
//					maxKey = key;
//					max = this.installedApps.get(maxKey);
//				}
//			}
//			outputList.add(maxKey);
//			this.installedApps.remove(maxKey);
//		}
//		
		return outputList;
	}
	
	public int getCpuSpeed() {return this.cpuSpeed;}
	public int getFreeMemory() {return this.freeMemory;}
	
	public static void main(String[] args) {
		FruitySmartPhone p = new FruitySmartPhone("John Smith",100,10);
		p.installApp(new App("Camera",1,2));
		p.installApp(new App("Music",2,3));
		p.installApp(new App("Podcast",2,11));
		p.useApp("Music");
		System.out.println(p.getInstalledApps());
	}
	
	
}
