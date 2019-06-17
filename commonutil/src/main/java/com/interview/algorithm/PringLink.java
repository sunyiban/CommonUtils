package com.interview.algorithm;

/**
 * @author sunyiban
 * @version V 1.0
 * @Title PringLink -> Class
 * @Package CommonUtils -> com.interview.algorithm
 * @Description
 * @date 2019/2/28 16:00 
 */
public class PringLink {

	public static void main(String[] args) {
		Node<String> node4 = new Node<>("4",null) ;
		Node<String> node3 = new Node<>("3",node4);
		Node<String> node2 = new Node<>("2",node3);
		Node<String> node1 = new Node("1",node2) ;

		Node node = node1;
		while(node != null) {
			System.out.print(node.value+"===>");
			node = node.next;
		}


		recNode(node1);
	}

	public static void recNode(Node node){

		if (node == null){
			return ;
		}

		if (node.next != null){
			recNode(node.next) ;
		}
		System.out.print(node.value+"===>");
	}


	public static class Node<T>{
		public T value;
		public Node<T> next ;


		public Node(T value, Node<T> next ) {
			this.next = next;
			this.value = value;
		}
	}

}
