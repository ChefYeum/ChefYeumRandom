


public class AbsolutePath{
	public static String ensureAbsolute(String path){
		if (path[0] != '/') path = System.getProperty("user.dir")+"/"+path;
	}
	
	public static String[] absoluteSplitPath(String s){
		String[] components = SplitPathName.splitPath(s);
		ensureAbsolute(components[0])
	}
}
