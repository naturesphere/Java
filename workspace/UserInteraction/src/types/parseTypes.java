package types;

import java.util.Scanner;

public class parseTypes {
	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		byte b;
		char c;
		int n;
		float f;
		
		System.out.println("Input byte please:");
		b=Byte.parseByte( scanner.next());
		System.out.println("Output: byte :"+b);
		
		System.out.println("Input int please:");
		n=Integer.parseInt(scanner.next());
		System.out.println("Output: int :"+n);
		
		System.out.println("Input float please:");
		f=Float.parseFloat(scanner.next());
		System.out.println("Output: float :"+f);
		
		System.out.println("b+n="+(b+n));
		System.out.println("b+n+f="+(b+n+f));
		
	}

}
