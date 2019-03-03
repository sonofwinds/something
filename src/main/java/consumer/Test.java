package consumer;

public class Test {

	public static void main(String[] args) {
		new Thread(new Cosumer()).start();
		new Thread(new Cosumer()).start();
		new Thread(new Producer()).start();
		new Thread(new Producer()).start();
	}

}
