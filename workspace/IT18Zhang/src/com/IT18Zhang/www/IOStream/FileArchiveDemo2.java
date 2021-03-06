package com.IT18Zhang.www.IOStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileArchiveDemo2 {

}

class Archiver
{
	public static void MyArchive(String des, String... srcs) throws Exception
	{
		FileInputStream fin;
		FileOutputStream fout;
		
		fout=new FileOutputStream(des);
		for(String s:srcs)
		{
			fin=new FileInputStream(s);
			//write name length (4 bytes)
			WriteNameLength(s,fout);
			//write name string (name length bytes)
			fout.write(s.getBytes());
			//write data length (4 bytes)
			WriteDataLength(fin.available(),fout);
			//write data (data length bytes)
			
			
		}
	}
	
	//write length (4 bytes)
	/*
	 * int [0][1][2][3]
	 * to
	 * [0]
	 * [1]
	 * [2]
	 * [3] 
	 */
	private static void WriteNameLength(String str,FileOutputStream fout)
	{
		int nNameLength = str.length();
		final int L = 4;
		byte[] bts=new byte [L];
		
		bts[0] = (byte)(nNameLength>>>24);
		bts[1] = (byte)(nNameLength>>>16); 
		bts[2] = (byte)(nNameLength>>>8);
		bts[3] = (byte)(nNameLength);
		
		try {
			 fout.write(bts);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private int ReadLength(FileInputStream fin)
	{
		final int L = 4;
		byte bts[] = new byte [L];
		int nLength=0;
		try {
			if(L!=fin.read(bts))
				return -1;
		
			nLength|=bts[0];
			nLength<<=8;
			nLength|=bts[1];
			nLength<<=8;
			nLength|=bts[2];
			nLength<<=8;
			nLength|=bts[3];
			return nLength;
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}
	
}