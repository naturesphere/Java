package com.IT18Zhang.www;

public class ThreeDimeMatrix {
	public static void main(String[] args) {
		//init a three dimention matrix
		float farr[][][]=new float [2][3][4];
		int nCnt=0;
		
		for(int i=0;i<farr.length;i++)
			for(int j=0;j<farr[0].length;j++)
				for(int k=0;k<farr[0][0].length;k++)
				{
					farr[i][j][k]=++nCnt;
				}
		//cross output it's elements
		for(int i=0;i<farr.length;i++)
		{
			for(int j=0;j<farr[0].length;j++)
			{
				for(int k=0;k<farr[0][0].length;k++)
					System.out.print(farr[i][j][k]+" ");
				System.out.println(" ");
			}
			System.out.println("----------");
		}
		System.out.println("cross output:");
		for(int i=0;i<farr.length;i++)
			for(int j=0;j<farr[0].length;j++)
				for(int k=0;k<farr[0][0].length;k++)
					System.out.print(farr[i][j][k]+" ");
		
	}
}
