package com.code.practise.questions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class PairDiff {

	public static void main(String[] args) {
		ArrayList<Integer> nos = new ArrayList<Integer>();
		Random random = new Random();
		for (int i = 0; i < 50; i++) {
			nos.add(random.nextInt(100));
		}
		PairDiff diff = new PairDiff();
		diff.process(nos, 5);
	}

	public void process(ArrayList<Integer> nos, int diff) {
		HashMap<Integer, Integer> values = new HashMap<Integer, Integer>();

		for (Integer no : nos) {
			values.put(no, null);
		}

		for (Iterator<Integer> iterator = values.keySet().iterator(); iterator.hasNext();) {
			Integer key = (Integer) iterator.next();
			if (values.containsKey(key - diff)) {
				values.put(key, key - diff);
			} else if (values.containsKey(key + diff)) {
				values.put(key, key + diff);
			}
		}
		for (Map.Entry<Integer, Integer> entry : values.entrySet()) {
			if (null != entry.getValue()) {
				System.out.println(entry.getKey() + "=" + entry.getValue());
			} else {
				System.out.println(" " + entry.getKey() + "=" + entry.getValue());
			}
		}

	}

}
