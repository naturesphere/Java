package com.IT18Zhang.www;

import java.util.Scanner;

public class transpose {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		//get input n m
		System.out.println("input matrix row and culomn:");
		int r = Integer.parseInt( scanner.next());
		int c = Integer.parseInt( scanner.next());
		float farr[][]=new float [r][c];
		//get input elements
		System.out.println("input the elements:");
		for(int i=0;i<r;i++)
			for(int j=0;j<c;j++)	
				farr[i][j]=Float.parseFloat(scanner.next());
		//transpose
		float Tfarr[][] = ArrayTranspose(farr);
		//output result
		System.out.println("the transpose matrix:");
		for(int i=0;i<c;i++)
		{
			for(int j=0;j<r;j++)	
				System.out.print(Tfarr[i][j]+" ");
			System.out.println(" ");
		}
	}
	
	public static float[][] ArrayTranspose(float[][] farr)
	{
		int r = farr.length;
		int c = farr[0].length;
		float Tfarr[][]=new float [c][r];
		
		System.out.println("matrix transposing ...");
		for(int i=0;i<r;i++)
			for(int j=0;j<c;j++)	
				Tfarr[j][i]=farr[i][j];
		System.out.println("transpose finish");
		return Tfarr;
	}
}
