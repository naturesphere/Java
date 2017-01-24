package com.IT18Zhang.www.collection;

import java.util.Scanner;

public class IntHexDemo 
{
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("input a int:");
		int n = Integer.parseInt( scanner.next());
		System.out.println("the hex is: ");
		System.out.println(IntToHex(n));
		
	}
	
	static String mByteToHex(Byte b)
	{
		char[] cHex={'0','1','2','3','4','5','6','7',
					 '8','9','A','B','C','D','E','F'};
		
		StringBuffer strbuf = new StringBuffer("");
		
		strbuf.append(cHex[(b>>4)&0x0f]);
		strbuf.append(cHex[b&0x0f]);
		System.out.println(strbuf);
		
		return strbuf.toString();
	}
	
	static String IntToHex(int n)
	{
		StringBuffer strbuf = new StringBuffer("");
		for(int i=0;i<4;i++)
		{
			strbuf.insert(0, mByteToHex((byte)(n&0x000000ff)));
			n>>=8;
		}
		return "0x"+strbuf.toString();
	}
	
}
