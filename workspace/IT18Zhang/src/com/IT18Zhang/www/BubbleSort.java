package com.IT18Zhang.www;

import java.util.Scanner;

public class BubbleSort {
	
	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		BubbleSort bs=new BubbleSort();
		//��ȡ�û���������
		System.out.println("Input the length of array:");
		int nLength = Integer.parseInt( scanner.next());
		float farr[]=new float [nLength];
		System.out.println("Input elements of array:");
		for(int i=0;i<nLength;i++)
		{
			farr[i]=Integer.parseInt( scanner.next());
		}
		System.out.println("Input finish");
		//ð������
		bs.BubbleSortMethod(farr);
		//�������
		for(float f:farr)
		{
			System.out.println(f+" ");
		}
	}
	
	public boolean BubbleSortMethod(float farr[])
	{
		float ftmp;
		System.out.println("Bubble Sorting ...");
		for(int j=farr.length-1;j>0;j--)
			for(int i=0;i<j;i++)
				if(farr[i]>farr[i+1])
				{
					ftmp=farr[i];
					farr[i]=farr[i+1];
					farr[i+1]=ftmp;
				}
		System.out.println("Bubble Sorting finish");
		return true;
	}
	
	

}
