package dataStructure;

import common.ListNode;

public class CircularList {

	/**
	 * 获取成环链表入口
	 */
	public static ListNode getEntrance(ListNode node) {
		ListNode end = getEnd(node); // 得到快慢指针的相遇位置
		if (node != null && end != null) {
			ListNode n1 = node;
			ListNode n2 = end;
			while (n1 != n2) { // 分别从链表头部和相遇终点开始遍历，一定能相遇
				n1 = n1.next;
				n2 = n2.next;
			}
			return n1;
		}
		return null;
	}
	
	/**
	 * 快指针和慢指针相遇的位置
	 * 
	 * 快指针如果能和慢指针相遇，快指针会比慢指针多走n步，这n步正是环中的结点数
	 */
	public static ListNode getEnd(ListNode node) {
		if (node != null) {
			ListNode fast = node;
			ListNode slow = node;
			while (fast.next != null && fast.next.next != null) {
				fast = fast.next.next;
				slow = slow.next;
				if (fast == slow) {
					return fast;
				}
			}
		}
		return null;
	}
	
	/**
	 * the circular linked list:
	 * 
	 * 1 -> 2 -> 3 -> 4 -> 5 -> 6
	 *           |______________|
	 */
	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		ListNode entrance = new ListNode(3);

		node.add(new ListNode(2))
			.add(entrance)
			.add(new ListNode(4))
			.add(new ListNode(5))
			.add(new ListNode(6))
			.add(entrance);

		System.out.println(getEntrance(node).value); // the entrance is 3
	}
	
}
