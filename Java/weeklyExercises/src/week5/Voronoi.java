import java.awt.Color;

public class Voronoi {

    	public static double pointDist(Point2D point1, Point2D point2) {
    		return (point1.getY()-point2.getY())/(point1.getX()-point2.getX());
	}

	public static int findClosestPoint(Point2D point, Point2D[] sites) {
		//notnullcheck?
		
		//initialise the index 0 as the closest point
		int outputIndex = 0;
		//calculate the cloesest distance
		double currentClosestDistance = Voronoi.pointDist(point, sites[0]);
		for (int i = 1; i < sites.length; i++){
			if (Voronoi.pointDist(sites[i],point) < currentClosestDistance){
				outputIndex = i;
				currentClosestDistance = Voronoi.pointDist(point, sites[0]);
			}
		}
		return outputIndex;
	}

    	public static int[][] buildVoronoiMap(Point2D[] sites, int width, int height) {
        	
   	public static void plotVoronoiMap(Point2D[] sites, Color[] colors, int[][] indexMap) {
        	// ADD CODE HERE
   	 }

    	public static void main(String[] args) {
        	int width = 200;
		int height = 200;

		int nSites = 5;
		Point2D[] sites = new Point2D[nSites];
		sites[0] = new Point2D(50, 50);
		sites[1] = new Point2D(100, 50);
		sites[2] = new Point2D(50, 100);
		sites[3] = new Point2D(125, 50);
		sites[4] = new Point2D(100, 175);

		Color[] colors = new Color[nSites];
		colors[0] = Color.BLUE;
		colors[1] = Color.GREEN;
		colors[2] = Color.YELLOW;
		colors[3] = Color.ORANGE;
		colors[4] = Color.MAGENTA;

		int[][] indexmap = buildVoronoiMap(sites, width, height);
		plotVoronoiMap(sites, colors, indexmap);

    	}
}

