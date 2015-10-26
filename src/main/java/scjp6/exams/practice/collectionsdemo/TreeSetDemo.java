package java.scjp6.exams.practice.collectionsdemo;

import java.util.TreeSet;

public class TreeSetDemo {

	public enum Color {
		RED(0xff0000), GREEN(0x00ff00), BLUE(0x0000ff);

		final private int rbg;

		Color(int rbg) {
			this.rbg = rbg;
		}

		public int getRBG() {
			return rbg;
		}
	}

	static final int[] a = new int[] { 1, 3 };

	public static void main(String[] args) {
		TreeSet<Integer> s = new TreeSet<Integer>();
		TreeSet<Integer> subs = new TreeSet<Integer>();
		for (int i = 606; i < 613; i++)
			if (i % 2 == 0)
				s.add(i);
		subs = (TreeSet) s.subSet(608, true, 611, true);
		s.add(609);

		System.out.println(s + " " + subs);
	}
}