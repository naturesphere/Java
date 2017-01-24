
public class TypeSize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n1=2,n2=3;
		float f1=1f,f2=3f;
		float result1,result2;
		
		System.out.println("Integer: "+ Integer.SIZE/8);
		System.out.println("Short: "+ Short.SIZE/8);
		System.out.println("Long: "+ Long.SIZE/8);
		System.out.println("Byte: "+ Byte.SIZE/8);
		System.out.println("Character: "+ Character.SIZE/8);
		System.out.println("Float: "+ Float.SIZE/8);
		System.out.println("Double: "+ Double.SIZE/8);
		
		result1=n2/n1;
		result2=f1/f2;
		
		System.out.println("result1 = "+result1);
		System.out.println("result2 = "+result2);	
		
	}

}
