package modelchild;

/**
 * Write a description of class Barn here.
 */
public class Child {
	private int age;
	private boolean boy; // true if the child is a boy
	private int[] weights;
	private int numberOfWeights;
	private static final int MAX_NUMBER_OF_WEIGHTS = 10;

	public Child(int age, boolean boy) {
		this.age = age;
		this.boy = boy;
		weights = new int[MAX_NUMBER_OF_WEIGHTS];
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isBoy() {
		return boy;
	}

	public void setBoy(boolean boy) {
		this.boy = boy;
	}

	public void addWeight(int weight) {
		if (numberOfWeights < MAX_NUMBER_OF_WEIGHTS) {
			weights[numberOfWeights] = weight;
			numberOfWeights++;
		}
	}

	public int[] getWeights() {
		return weights;
	}

	public double maxWeight() {
		int maxWeight = weights[0];
		for (int i = 0; i < weights.length; i++) {
			if (weights[i] > maxWeight) {
				maxWeight = weights[i];
			}
		}

		return maxWeight;
	}

	public double getIncrease() {
		double increase = 0;
		for (int i = 1; i < weights.length; i++) {
			if (weights[i] - weights[i - 1] > increase) {
				increase = weights[i] - weights[i - 1];
			}
		}
		return increase;
	}

}
