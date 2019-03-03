package linked;

public class MyLinkList<T>{
	private Node<T> firstNode;
	private Node<T> lastNode;
	private int size;
    private class Node<T> {
		private Node<T> nextNode;
		private T value;
		public Node(Node<T> nextNode, T value) {
			super();
			this.nextNode = nextNode;
			this.value = value;
		}

	}
 public void add(T value) {
	Node<T> currentNode = new Node<T>(null, value);
	if(lastNode == null) {
		firstNode = currentNode;
		lastNode = firstNode;
	}else {
		lastNode.nextNode = currentNode;
		lastNode = currentNode;
	}
	size ++;
 }

 public int size() {
	 return size;
 }
 
 public T get(int index) {
	 checkIndex(index);
	 Node<T> currentNode = firstNode;
	 if(index == 0) {
		 return currentNode.value;
	 }
	 for(int i = 1;i <= index ; i++) {
		 currentNode = currentNode.nextNode;
	 }
	return currentNode.value;
 }
 
 //查找单链表中的倒数第k个结点的值，不能采取获取链表长度的方式
 public T findLastNode(int k) {
	 checkIndex(k);
	 if(k == 1) {
	     return lastNode.value; 
	 }
	 Node<T> firstN = firstNode;
	 Node<T> secondN = firstNode;
	 for(int i = 0 ;i < k-1; i ++) {
		 secondN = secondN.nextNode;
	 }
	 while(secondN.nextNode != null) {
		 secondN = secondN.nextNode;
		 firstN = firstN.nextNode;
	 }
	return firstN.value;
 }
 
 //查到中间节点
 public T findMindleNode() {
	 Node<T> first = firstNode;
	 Node<T> second= firstNode;
	 int index = 0;
	 while(second.nextNode != null) {
		 second = second.nextNode;
		 index ++;
		 if(index%2 == 0) {
			 first = first.nextNode;
		 }
	 }
	 return first.value;
 }
 
 public MyLinkList<Integer> hebing(Node<Integer> linkhead1, Node<Integer> linkhead2){
	Node<Integer> indexNode = linkhead1;
	//以linkhead1为蓝本
	while(linkhead2 != null) {
		if(linkhead2.value >= indexNode.value) {
			indexNode.nextNode = linkhead2;
			linkhead2 = linkhead2.nextNode;
			indexNode = linkhead2;
		}else {
			
		}
	}
	
	return null;
 }
 public boolean checkIndex(int index) {
	 if(size == 0 || index > size-1) {
		 throw new RuntimeException("链表长度越界");
	 }
	 return true;
 }
 
 public void reverse() {
	 Node<T> temp = firstNode;
	 Node<T> head = null;
	 while (temp != null) {
		Node<T> nextNode = temp.nextNode;
		temp.nextNode = head;
		head = temp;
		temp = nextNode;
	 }
	  firstNode = head;
 }

}

