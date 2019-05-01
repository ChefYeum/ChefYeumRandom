import static org.junit.Assert.assertEquals;

import org.junit.Test;

@SuppressWarnings("unused")
public class ScalableCarItemBasicTest {

	@Test
    public void testConstructor() {
        ScalableCarItem item = new ScalableCarItem("VW", "Polo", 3000.43);
    }

    @Test
	public void testUpdateSales() {
        ScalableCarItem item = new ScalableCarItem("VW", "Polo", 3000.43);
        item.updateSales(10);
	}

    @Test
	public void testGetPrice() {
	    ScalableCarItem item = new ScalableCarItem("VW", "Polo", 3000.43);

        double result = item.getPrice();
    }

    @Test
	public void testToString() {
        ScalableCarItem item = new ScalableCarItem("VW", "Polo", 3000.43);

        String output = item.toString();
	}
    
    @Test
    public void testD() {
    	ScalableCarItem item = new ScalableCarItem("Kia", "Dee", 2000.50);
    	item.updateSales(10);
    	assertEquals(220055,(int)(item.getPrice()*100));
    	item.updateSales(15);
    	assertEquals(250063,(int)(item.getPrice()*100));
    }
    
}
