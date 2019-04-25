import java.util.HashMap;

public class ShowSquirrelBrowser extends Plugin{

	private HashMap<String,Double> plugins;
	private double totalQuota;
	private String version;
	private double availableQuota;
	
	public ShowSquirrelBrowser(String n, double q, String vr) {
		super(n, q, vr);
		// TODO Auto-generated constructor stub
	}

	public String getVersion(){return this.version;}
	
	public double getQuota() { return this.totalQuota; }//or super.quota?
	
	
}
