package com.code.practise.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class FrequenceLst {

	public static void main(String[] args) {
		ArrayList<Integer> nos = new ArrayList<Integer>(Arrays.asList(new Integer[] { 4, 4, 3, 2, 4, 1, 3 }));
		FrequenceLst example  = new FrequenceLst();
		example.process(nos, 2);
	}

	public  void process(ArrayList<Integer> nos, int count) {

		class MyMap extends TreeMap<MyKey, Integer> {

			/**
			 * 
			 */
			private static final long serialVersionUID = 4233235244932924391L;

			@Override
			public Integer put(MyKey key, Integer value) {
				Integer result = 0;
				if (null == get(key)) {
					result = super.put(key, 1);
				} else {
					int count = get(key) + 1;
					result = super.put(key, count);
				}
				return result;
			}
		}

		MyMap map = new MyMap();
		for (Integer key : nos) {
			map.put(new MyKey(key), 0);
		}

		for (Map.Entry<MyKey, Integer> entry : map.entrySet()) {
			if (entry.getValue() >= count) {
				System.out.println(entry.getKey().getKey() + " " + entry.getValue());
			}
		}

	}

	class MyKey implements Comparable<MyKey> {

		private Integer key;

		public MyKey(Integer key) {
			this.key = key;
		}

		public Integer getKey() {
			return key;
		}

		public void setKey(Integer key) {
			this.key = key;
		}

		@Override
		public int compareTo(MyKey o) {
			return o.getKey() - key;
		}

	}
	
}

