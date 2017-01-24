package com.IT18Zhang.www.collection;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class StringEncodeDecodeDemo {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
//		int j=0;
//		for(int i=0;i<0xffff;i++)
//		{			
//			System.out.print((char)i+" ");
//			if(j++>100)
//			{
//				System.out.println(" ");
//				j=0;
//			}
//		}
//		System.out.println("");
		
		String str="붻뺇뽓싩흞";
		byte[] bts = str.getBytes();
		try {
			String str2 = new String(bts,"UTF8");
			System.out.println(str);
			System.out.println(Arrays.toString(bts));
			System.out.println(str2);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
