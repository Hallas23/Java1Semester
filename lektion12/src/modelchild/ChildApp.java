package modelchild;

import java.util.Arrays;

public class ChildApp {

	public static void main(String[] args) {
		Child c1 = new Child(0, true);// boy 4 years old
		Child c2 = new Child(2, false);// girl 2 years old

		System.out.println("Et barn på " + c1.getAge() + c1.isBoy());
		System.out.println("Et barn på " + c2.getAge() + c2.isBoy());
		c1.addWeight(1);
		c1.addWeight(2);
		c1.addWeight(3);
		c1.addWeight(4);
		c1.addWeight(5);
		c1.addWeight(10);
		c1.addWeight(7);
		c1.addWeight(8);
		c1.addWeight(6);
		c1.addWeight(5);
		Institution c3 = new Institution("Simon", "jern");
		Institution c4 = new Institution("ole", "jern");
		Institution c5 = new Institution("børge", "jern");
		Institution c6 = new Institution("egon", "jern");

		System.out.println("Aktuelt  : " + Arrays.toString(c1.getWeights()));
		System.out.println(c1.maxWeight());
		System.out.println(c1.getIncrease());

	}

}
