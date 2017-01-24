package com.IT18Zhang.www.IOStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

public class FileArchiveDemo 
{
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception 
	{
	
		MyArchive("num_des.myzip","C:/Users/xiebi/Pictures/PROFILE.jpg",
								"D:/Download/Explorer/test.doc",
								"number.txt");	
		MyArchive("num_apha.myzip","number.txt","alpha.txt");
		
		System.out.println("archive finish");
		
		MyUnArch("num_apha.myzip","filena");
		
		MyUnArch("num_des.myzip","filend");
		
		System.out.println("unarchive finish");
		
	}
	
	
	public static void MyUnArch(String des, String filename) throws Exception
	{
		FileInputStream fin = new FileInputStream(des);
		FileOutputStream fout = null;
		int len=-1;
		String suffixs[] = {"txt","jpg","png","doc","docx"};
		int sufidx=-1;
		for(int j=0;((sufidx=fin.read())!=-1);j++)
		{
			fout=new FileOutputStream(filename+j+"."+suffixs[sufidx]);
			byte[] bts = new byte [4];
			if(fin.read(bts)!=4)
				return;
			int fileLen=0;
			for(int i=0;i<4;i++)
			{
				fileLen<<=8;
				fileLen |= (bts[3-i]&0x00ff);
			}
			int Len=-1;
			
			if(fileLen<=1024)
			{
				byte[] bts1=new byte[fileLen];
				fin.read(bts1);
				fout.write(bts1);
				continue;
			}
			else
			{
				byte[] bts2=new byte[1024];
				while(1024==fin.read(bts2))
				{
					fout.write(bts2);
					fileLen-=1024;
					if(fileLen<1024)
					{
						byte[] bts3 = new byte [fileLen];
						fin.read(bts3);
						fout.write(bts3);
						break;
					}
					
				}
				
			}
			fout.close();
		}
		fin.close();
	}
	
	public static void MyArchive(String des, String... srcs) throws Exception
	{
		Map<String,Byte> suffixmap=new HashMap();
		FileInputStream fin;
		FileOutputStream fout;
		
		suffixmap.put("txt",(byte)0);
		suffixmap.put("jpg",(byte)1);
		suffixmap.put("png",(byte)2);
		suffixmap.put("doc",(byte)3);
		suffixmap.put("docx",(byte)4);
		
		fout=new FileOutputStream(des);
		for(String s:srcs)
		{
			String suffex = s.substring(s.lastIndexOf('.')+1);
			fin=new FileInputStream(s);
			int fileLength = fin.available();
			fout.write(suffixmap.get(suffex));

			for(int j=0;j<4;j++)
				fout.write((byte)(fileLength>>8*j));
			byte[] bts = new byte [1024];
			int len;
			while((len=fin.read(bts))!=-1)
			{
				fout.write(bts,0,len);
			}
			fin.close();
		}
		fout.close();
	}
	
}
