public class Buffertest{
	public static void main(String[] args) {
		RingBuffer testrb = new RingBuffer(7);
		testrb.addToBuffer(4);
		testrb.addToBuffer(7);
		testrb.addToBuffer(8);
		testrb.getFromBuffer();
		testrb.addToBuffer(4);
		testrb.addToBuffer(7);
		testrb.addToBuffer(8);

		testrb.getFromBuffer();		
		testrb.addToBuffer(4);
		testrb.addToBuffer(4);
		testrb.getFromBuffer();		

		
		
		
		
		System.out.println(testrb);

	}
}