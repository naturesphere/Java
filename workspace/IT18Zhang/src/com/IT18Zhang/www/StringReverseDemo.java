package com.IT18Zhang.www;

public class StringReverseDemo {
	
	public static void main(String[] args) {
		String str = "0123456789";
		
		System.out.println(StrRev(""));
	}
	
	static String StrRev(String str){
		String str2 = "";
		
		if(str!=null)
		{
			for(int i=str.length()-1;i>=0;i--)
				str2+=str.charAt(i);
			return str2;
		}
		return null;
	}
}
