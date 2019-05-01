import java.util.Objects;
import java.util.List;
import java.util.Map;
import java.util.Hashtable;

public class CarSalesAnalysis {

    protected static Map<String, Integer> countByBrand(List<CarItem> soldCars) {
    	Hashtable<String,Integer> countBrand = new Hashtable<>();
    	if (Objects.isNull(soldCars) || soldCars.size() <= 0) {
    		return countBrand;
    	} else {
			for (CarItem car: soldCars) {
				countBrand.put(car.getBrand(), countBrand.getOrDefault(car.getBrand(),0)+1);
			}
    	}
        return countBrand;
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please execute this program by"
                    + " providing the path to a car sales file,"
                    + " e.g. java CarSalesAnalysis ./carSales01.txt");
            System.exit(1);
        }

        System.out.println("\nParsing expense items ...");
	    List<CarItem> carData = CarSalesUtils.readDataFromFile(args[0]);

        System.out.println(carData.size() + " entries found in " + args[0]);
        CarSalesUtils.printCarItemList(carData);

	    System.out.println("\nCounting car sales for each car brand...");
        Map<String, Integer> carCounts = countByBrand(carData);
	    if (!Objects.isNull(carCounts)) {
	    	System.out.println("Car Counts per Brand:\n");
            CarSalesUtils.printCarMappings(carCounts);
	    }
    }
}
