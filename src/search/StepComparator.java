package search;

import java.util.Comparator;

import tree.Step;

public class StepComparator<T> implements Comparator<Step> {

	@Override
	public int compare(Step o1, Step o2) {
		if (o1.getCost() < o2.getCost()) {
			return -1;
		} else if(o1.getCost() > o2.getCost()) {
			return +1;
		} else {
			return 0;
		}
	}

}
