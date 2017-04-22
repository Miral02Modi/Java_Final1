package com.bridgelabz.programs;

import java.util.NoSuchElementException;

class Node {
	int data;
	Node link;

	public Node(int data, Node link) {
		this.data = data;
		this.link = link;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLink() {
		return link;
	}

	public void setLink(Node link) {
		this.link = link;
	}
}

public class LinkedListDemo1 {

	int size;
	Node start;

	void addLast(int val) {
		Node nptr = new Node(val, null);
		Node ptr;
		if (start == null) {
			start = nptr;
			size++;
			return;
		}
		ptr = start;
		while (ptr.getLink() != null)
			ptr = ptr.getLink();
		ptr.setLink(nptr);
		size++;
	}

	boolean conatains(int val) {
		Node ptr = start;
		if (start == null) {
			return false;
		}
		ptr = start;
		while (ptr.getLink() != null) {
			if (ptr.getData() == val) {
				return true;
			}
			ptr = ptr.getLink();
		}
		if (ptr.getData() == val) {
			return true;
		}
		return false;
	}

	int size() {
		return size;
	}

	void display() {
		Node ptr;
		if (start == null) {
			System.out.println("No Data is found");
			return;
		}
		ptr = start;

		while (ptr.getLink() != null) {
			System.out.println("Data is::" + ptr.getData());
			ptr = ptr.getLink();
		}
		System.out.println("Data is::" + ptr.getData());
	}

	void removeLast() {
		Node ptr, tmp;
		if (start == null) {
			System.out.println("No data is available");
		}
		tmp = start;
		ptr = start.getLink();
		while (ptr.getLink() != null) {
			if (ptr.getLink() == null) {
				System.out.println(ptr.getData());
				return;
			}
			ptr = ptr.getLink();
			tmp = tmp.getLink();
		}
		tmp.setLink(null);
	}

	int pop() {
		Node ptr, tmp;
		if (start == null) {
			System.out.println("No data is available");
		}
		tmp = start;
		ptr = start.getLink();
		while (ptr.getLink() != null) {
			if (ptr.getLink() == null) {
				System.out.println(ptr.getData());
				return 0;
			}
			ptr = ptr.getLink();
			tmp = tmp.getLink();
		}

		tmp.setLink(null);
		return ptr.getData();
	}

	void pop(int pos) {
		Node ptr, tmp;
		if (pos > 0 && pos > size)
			throw new NoSuchElementException();
		if (pos == 1) {
			start = start.getLink();
			return;
		}
		tmp = start;
		ptr = start.getLink();
		for (int i = 1; i < pos - 1; i++) {
			ptr = ptr.getLink();
			tmp = tmp.getLink();
		}
		tmp.setLink(ptr.getLink());
	}

	void insertPos(int pos, int val) {
		Node nptr = new Node(val, null);
		System.out.println(start);
		if (pos == 1) {
			nptr.setLink(start);
			start = nptr;
			return;
		}

		Node ptr, tmp;
		ptr = start.getLink();
		tmp = start;
		System.out.println(tmp);
		for (int i = 0; i < pos - 2; i++) {
			ptr = ptr.getLink();
			tmp = tmp.getLink();
		}
		tmp.link = nptr;
		nptr.link = ptr;
	}

	int index(int val) {

		Node ptr = start;
		int idx = 0;
		if (start == null) {
			System.out.println("List is Empty");
			return -1;
		}
		ptr = start;
		while (ptr.getLink() != null) {
			if (ptr.getData() == val) {
				idx++;
				return idx;
			}
			idx++;
			ptr = ptr.getLink();
		}
		idx++;
		if (ptr.getData() == val)
			System.out.println("Prsent at index number::" + idx);
		return idx -1;
	}

	boolean isEmpty() {
		return size == 0;
	}

	public static void main(String[] args) {
		LinkedListDemo1 li = new LinkedListDemo1();
		li.addLast(30);
		li.addLast(40);
		li.addLast(50);
		li.insertPos(4, 10);
		li.display();
		
		System.out.println(li.index(10));
	}
}
