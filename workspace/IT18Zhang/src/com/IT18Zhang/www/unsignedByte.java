package com.IT18Zhang.www;

import java.util.Scanner;

public class unsignedByte {
	public static void main(String[] args) {
		byte b;
		int n=0;
		Scanner scanner=new Scanner(System.in);
		
		while(true)
		{
			//����һ��byte
			System.out.println("Input a byte:");
			try
			{
				b=Byte.parseByte( scanner.next());
				//תΪ0~255֮�����
				n=((int)b)&0xff;
				System.out.println("Output unsigned byte:"+n);			
			}
			catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("wrong number format");
			}

		}
	}
}
