package linked;

public class AlgorithmMain {

	public static void main(String[] args) {
		MyLinkList<Integer> linkedList = new MyLinkList<Integer>();
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(4);
		linkedList.add(5);
		linkedList.add(7);
		linkedList.add(8);
//		linkedList.reverse();
//		print(linkedList);
//		linkedList.reverseDigui(null);
	}
	public static void print(MyLinkList<Integer> linkedList) {
		for(int i = 0;i < linkedList.size();i ++) {
			System.out.println(linkedList.get(i));
		}
	}
	
}
