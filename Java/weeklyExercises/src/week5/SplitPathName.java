
public class SplitPathName{
	public static String[] splitPath(String s){
		String[] components = new String[4];
		int lastSlashPos = s.lastIndexOf('/');
		components[0] = s.substring(0,lastSlashPos)+"/";//The directory path of the file			
		components[1] = s.substring(lastSlashPos+1);
		int dotPos = components[1].lastIndexOf('.');
		components[2] = components[1].substring(0,dotPos+1);
		components[3] = components[1].substring(dotPos);
		return components;
	}
	public static void main(String[] args){
		for (String path: args){
			String[] components = splitPath(path);
			System.out.printf("File: %s Type: %s [%s]\n", components[1], components[3], components[0]);
		}
	}
}
