package com.IT18Zhang.www;

import java.util.Arrays;

public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char c;
		int j=0;
		String str = "http://study.163.com/course/courseLearn.htm?courseId=1003402005#/learn/video?lessonId=1003892021&courseId=1003402005";
		
		for(int i=0;i<0xffff;i++)
		{
			System.out.print((char)i);
			if(j++>80)
			{
				System.out.println(" ");
				j=0;
			}		
		}
		
		char x='谢',b='冰';
		System.out.println(" ");
		System.out.println((char)x+"="+(int)x);
		System.out.println((char)b+"="+(int)b);

		String[] strArr = str.split("/");
		
		System.out.println(Arrays.toString(strArr));
	}

}
