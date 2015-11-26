package algorithm.hackertrail;

import java.util.Scanner;

public class Snake {

	enum Direction { UP, DOWN, LEFT, RIGHT };

	public static class Node {
		public int x; //col
		public int y; //row
		public Node next = null;
		public Node(int _x, int _y) {
			x = _x; y = _y;
		}
	}

	public static class LinkedNode {
		Node head = null;
		Node tail = null;
		Direction currentDirection = Direction.UP;

		public LinkedNode() {
			head = new Node(0, 0);
			tail = head;
		}

		public void move(char d) {
			int new_x = head.x, new_y = head.y;
			boolean needRemoveTail = true;
			switch(d) {
				case 'F':
					if (currentDirection == Direction.UP) { new_x = head.x + 1; }
					if (currentDirection == Direction.DOWN) { new_x = head.x - 1; }
					if (currentDirection == Direction.LEFT) { new_y = head.y - 1; }
					if (currentDirection == Direction.RIGHT) { new_y = head.y + 1; }
					break;
				case 'L':
					if (currentDirection == Direction.UP) { new_y = head.y - 1; currentDirection = Direction.LEFT; break; }
					if (currentDirection == Direction.DOWN) { new_y = head.y + 1; currentDirection = Direction.RIGHT; break; }
					if (currentDirection == Direction.LEFT) { new_x = head.x - 1; currentDirection = Direction.DOWN; break; }
					if (currentDirection == Direction.RIGHT) { new_x = head.x + 1; currentDirection = Direction.UP; break; }
				case 'E':
					if (currentDirection == Direction.UP) { new_x = head.x + 1; }
					if (currentDirection == Direction.DOWN) { new_x = head.x - 1; }
					if (currentDirection == Direction.LEFT) { new_y = head.y - 1; }
					if (currentDirection == Direction.RIGHT) { new_y = head.y + 1; }
					needRemoveTail = false;
					break;
				case 'R':
					if (currentDirection == Direction.UP) { new_y = head.y + 1; currentDirection = Direction.RIGHT; break; }
					if (currentDirection == Direction.DOWN) { new_y = head.y - 1; currentDirection = Direction.LEFT; break; }
					if (currentDirection == Direction.LEFT) { new_x = head.x + 1; currentDirection = Direction.UP; break; }
					if (currentDirection == Direction.RIGHT) { new_x = head.x - 1; currentDirection = Direction.DOWN; break; }
					break;
				default:
					throw new RuntimeException("not valid character");
			}
			head.next = new Node(new_x, new_y);
			head = head.next;
			if (needRemoveTail) tail = tail.next;
		}

		public boolean isCollide() {
			Node current = tail;
			while (current.next != null) {
				if (current.x == head.x && current.y == head.y) return true;
				current = current.next;
			}
			return false;
		}

	}

	public static String process(String steps) {
		LinkedNode snake = new LinkedNode();
		int count = 0;
		for (char c: steps.toCharArray()) {
			count++;
			snake.move(c);
			if (snake.isCollide()) return count+"";
		}
		return "YES";
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		while (num > 0) {
			sc.nextInt();
			String line = sc.next();
			System.out.println(process(line));
			num--;
		}
	}

}
