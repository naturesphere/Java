package com.IT18Zhang.www;

import java.util.Scanner;

public class ArrayCopy {
	
	public static void main(String[] args) {
		final int dALength=10;
		Scanner scanner=new Scanner(System.in);
		float desArray[]=new float [dALength];
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
		//拷贝到目标数组
		arrCopy(desArray,farr);
		//输出原数组和目标数组
		System.out.println("source array:");
		for(float f:farr)
		{
			System.out.print(f+" ");
		}
		System.out.println("\ndestination array:");
		for(float f:desArray)
		{
			System.out.print(f+" ");
		}
	}

	static boolean arrCopy(float[] desArray, float sourArr[])
	{
		if(desArray.length==sourArr.length)
		{
			for(int i=0;i<desArray.length;i++)
			{
				desArray[i]=sourArr[i];
			}
		}
		else if(desArray.length<sourArr.length)
		{
			for(int i=0;i<desArray.length;i++)
			{
				desArray[i]=sourArr[i];
			}
		}
		else //desArray.length>sourArr.length
		{
			for(int i=0;i<desArray.length;i++)
			{
				desArray[i]=sourArr[i%sourArr.length];
			}
		}
		return true;
	}
}
