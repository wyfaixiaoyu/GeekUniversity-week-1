package com.wyfaixiaoyu.week1;

public class HelloByteCode {
	public static void main(String[] args) {
		int a = 1 + 2;
		int b = 5 - 1;
		int c = 10 / 2;
		int d = 2 * 3;
		int e = 0;
		if (d > c) {
			e = d;
		} else {
			e = c;
		}
		int result = 0;
		for (int i = 0; i < 4; i++) {
			result = result + i;
		}
	}
}
