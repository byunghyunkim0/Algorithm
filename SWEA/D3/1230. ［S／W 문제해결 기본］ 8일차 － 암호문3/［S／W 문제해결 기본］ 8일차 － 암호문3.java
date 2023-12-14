
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
	public static StringBuilder sb;
	static int NODE_MAX = 5000;
	static class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	static class LinkedList{
		Node head;
		Node tail;
		Node[] nodeArr;
		int nodeCnt;
		
		public LinkedList() {
			head = null;
			nodeArr = new Node[NODE_MAX];
			nodeCnt = 0;
		}
		
		Node getNewNode(int data) {
			nodeArr[nodeCnt] = new Node(data);
			return nodeArr[nodeCnt++];
		}
		
		public void insert(int idx, int[] nums) {
			int st = 0;
			
			if (idx == 0) {
				if (head != null) {
					Node newNode = getNewNode(nums[0]);
					newNode.next = head;
					head = newNode;
				} else {
					head = getNewNode(nums[0]);
				}
				
				idx = 1;
				st = 1;
			}
			
			Node cur = head;
			for (int i = 1; i < idx; i++) {
				cur = cur.next;
			}
			
			for (int i = st; i < nums.length; i++) {
				Node newNode = getNewNode(nums[i]);
				newNode.next = cur.next;
				cur.next = newNode;
				cur = newNode;
			}
			
			if (cur.next == null) {
				tail = cur;
			}
		}
		
		public void delete(int idx, int cnt) {
			Node cur = head;
			if (idx == 0) {
				for (int i = 0; i < cnt; i++) {
					cur = cur.next;
				}
				head = cur;
				return;
			}
			
			for (int i = 0; i < idx; i++) {
				cur = cur.next;
			}
			Node temp = cur;
			
			for (int i = 0; i < cnt; i++) {
				cur = cur.next;
			}
			
			temp.next = cur.next;
			
			if (temp.next == null) {
				tail = temp;
			}
		}
		
		public void add(int data) {
			Node cur = tail;
			Node newNode = getNewNode(data);
			cur.next = newNode;
			tail = newNode;
		}
		
		public void print() {
			Node cur = head;
			for (int i = 0; i < 10; i++) {
				sb.append(" " + cur.data);
				cur = cur.next;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int testCase = 1; testCase <= 10; testCase++) {
			sb = new StringBuilder();
			LinkedList list = new LinkedList();
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			list.insert(0, arr);
			
			int m = sc.nextInt();
			for (int i = 0; i < m; i++) {
				char f = sc.next().charAt(0);
				if (f == 'I') {
					int x = sc.nextInt();
					int y = sc.nextInt();
					int[] temp = new int[y];
					
					for (int j = 0; j < y; j++) {
						temp[j] = sc.nextInt();
					}
					list.insert(x, temp);
				} else if (f == 'D') {
					int x = sc.nextInt();
					int y = sc.nextInt();
					list.delete(x, y);
				} else {
					int y = sc.nextInt();
					for (int j = 0; j < y; j++) {
						list.add(sc.nextInt());
					}
				}
			}
			sb.append("#" + testCase);
			list.print();
			System.out.println(sb);
		}
		sc.close();
	}
}
