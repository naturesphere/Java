package com.IT18Zhang.www;

import java.util.Scanner;

public class SelectSort {

	public static void main(String[] args) {
		//1 user input array		
		//2 select sort		
		//3 output result
		
		Scanner scanner=new Scanner(System.in);
		//获取用户输入数组
		System.out.println("Input the length of array:");
		int nLength = Integer.parseInt( scanner.next());
		float farr[]=new float [nLength];
		System.out.println("Input elements of array:");
		for(int i=0;i<nLength;i++)
		{
			farr[i]=Integer.parseInt( scanner.next());
		}
		System.out.println("Input finish");
		//冒泡排序
		SelectSortMethod(farr);
		//输出数组
		for(float f:farr)
		{
			System.out.print(f+" ");
		}
		
		while(true)
		{
			//user input target element
			System.out.println("\ninput the number you are looking for:");
			float ftar = Float.parseFloat(scanner.next());
			//middle lookup
			int index = MiddleLookup(ftar,farr);
			//output result
			if(index==-1)
				System.out.println("Can't find it");
			else
				System.out.println("The target index is "+index);
		}
	}
	
	public static  boolean SelectSortMethod(float farr[])
	{
	
		float ftmp;
		
		System.out.println("Select Sorting ...");
		
		for(int i=0;i<farr.length;i++)
			for(int j=i+1;j<farr.length;j++)
				if(farr[i]>farr[j])
				{
					ftmp=farr[i];
					farr[i]=farr[j];
					farr[j]=ftmp;
				}
		
		System.out.println("Select Sort finish");
		return true;
	}
	
	/*
	 * input 
	 * float ftar:target to lookup
	 * float farr[]:source array to lookup frome
	 * output
	 * target index in the array, -1 is not found
	 */
	public static int MiddleLookup(float ftar, float farr[])
	{
		
		int left=0;
		int right=farr.length-1;
		int middle=(left+right)/2;
		
		System.out.println("middle looking up ...");
		while(right-left>1)
		{
			if(ftar==farr[middle])
				return middle;
			else if(ftar<farr[middle])
			{
				right=middle;
			}
			else //far>farr[middle] 
			{
				left=middle;
			}
			middle=(left+right)/2;
			System.out.println("left="+left+"right="+right);
		}
		
		if(ftar==farr[left])
			return left;
		if(ftar==farr[right])
			return right;
		
		return -1;
	}
}
