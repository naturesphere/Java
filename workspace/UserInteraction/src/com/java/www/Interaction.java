package com.java.www;

import java.util.Scanner;

public class Interaction {
	public static void main(String[] args) {
		System.out.println("Input something please:");
		Scanner scanner=new Scanner(System.in);
		while(scanner.hasNext())
			System.out.println("output:"+scanner.next());
	}
}
