package com.IT18Zhang.www.IOStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ImageCopy {

	public static void main(String[] args) throws Exception 
	{
		FileInputStream fin = new FileInputStream("C:\\Users\\xiebi\\Pictures\\PROFILE.jpg");
		FileOutputStream fout = new FileOutputStream("C:\\Users\\xiebi\\Pictures\\PROFILE_cpy.jpg");
		
		byte[] bts = new byte [1024];
		int len=-1;
		
		//fin.read(bts);//drop first 1024 byte data
		while((len=fin.read(bts))!=-1)//read all
		//while((len=fin.read(bts))==1024)//drop last 1024 byte data
		{
			fout.write(bts);
		}
		
		fin.close();
		fout.close();
		System.out.println("over!");
	}

}