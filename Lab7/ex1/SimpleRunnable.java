
public class SimpleRunnable implements Runnable {
	
	Resource resource;
	
	public void run() {
		for (int i = 0; i <10; i++) {
			try {
				System.out.println(resource.increment());
				
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	SimpleRunnable(Resource resource) {
		this.resource = resource;
	}
	
	public static void main(String [] args) {
		Resource resource = new Resource();
		Runnable r = new SimpleRunnable(resource);
		Thread t = new Thread(r);
		Thread s = new Thread(r);
		
		t.start();
		s.start();
	}
}
