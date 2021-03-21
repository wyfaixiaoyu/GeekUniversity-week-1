package com.wyfaixiaoyu.week1;

import java.lang.Integer;
import java.util.*;
import java.util.stream.Collectors;

public class HelloByteCode {
	private static int static_int = 0;

	private List<Integer> intList = new ArrayList();

	public static void add(int num) {
		if (num <= 0) {
			static_int = 1;
		} else if (num >= 20) {
			static_int = 20;
		} else if (num < 10) {
			static_int = num + 10;
		} else {
			static_int = num;
		}
		for (int j = 0; j < static_int; ) {
			if (j % 2 == 0) {
				j = j / 2;
				j = j + 3;
			} else {
				j = j * 4;
			}
		}
	}

	public List<Integer> sum() {
		intList.add(1);
		intList.add(2);
		List<Integer> result = intList.stream()
				.map(it -> it * it)
				.collect(Collectors.toList());
		return result;
	}
}
