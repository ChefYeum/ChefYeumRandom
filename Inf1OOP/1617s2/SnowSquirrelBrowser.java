import java.util.HashMap;
import java.util.Objects;
import java.util.ArrayList;
import java.util.Arrays;

public class SnowSquirrelBrowser extends Browser{
	private HashMap<String,Double> installedPlugins = new HashMap<>(); 
	//storing the names of plugins and the total cloud quota used by each plugin
	
	private String version;
	private double availableQuota;
	
	public SnowSquirrelBrowser(String n, double q, String vr) {
		super(n);
		this.availableQuota = q;
		this.version = vr;
		// TODO Auto-generated constructor stub
	}

	public String getVersion() {return this.version;}
	
	public double getQuota() { return this.availableQuota; }//or super.quota?
	
	public boolean installPlugin(Plugin p) {
		boolean containsKey = this.installedPlugins.containsKey(p.name); 
		boolean quotaAvailable = p.getQuotaReq() > this.availableQuota;
		boolean versionCheck = p.getVersionReq() != this.version;
		if (containsKey || quotaAvailable || versionCheck) {
			return false;
		} else {
			this.installedPlugins.put(p.name, p.getQuotaReq());
			this.availableQuota -= p.getQuotaReq();
			return true;
		}
	}
	
	public boolean uninstallPlugin(Plugin plugin) {
		if (this.installedPlugins.containsKey(plugin.name)) {
			this.availableQuota += this.installedPlugins.get(plugin.name);
			this.installedPlugins.remove(plugin.name);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean usePlugin(String name){
		if (this.installedPlugins.containsKey(name) && this.availableQuota >= 1) {
			this.installedPlugins.replace(name, this.installedPlugins.get(name)+1);
			return true;
		} else {
			return false;
		}
	}
	
	public ArrayList<String> getInstalledPlugins(){
		ArrayList<String> outputArr = new ArrayList<>();
		Object[] values = this.installedPlugins.values().toArray();
		Arrays.sort(values);
		for (Object nextMin: values) { for (Object name: this.installedPlugins.keySet().toArray()) {
				String pluginName = (String) name;
				if (this.installedPlugins.get(pluginName) == (double) nextMin) {
					outputArr.add(0,pluginName);
					this.installedPlugins.remove(pluginName);
				}
			}
		}
		return outputArr;
	}
}
