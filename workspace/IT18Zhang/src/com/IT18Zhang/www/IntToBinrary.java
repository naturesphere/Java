package com.IT18Zhang.www;

import java.util.Scanner;

public class IntToBinrary {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		int n;
		while(true)
		{
			//get user input integer
			System.out.println("Input your integer:");
			n = Integer.parseInt( scanner.next());
			//translate to binary
			String str = Integer.toBinaryString(n);
			//output result
			System.out.println(str);
		}
	}
}
