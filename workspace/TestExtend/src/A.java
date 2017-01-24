
public class A {
	A()
	{
		System.out.println("A's no parameter constructor");
	}
	
	A(int i)
	{
		System.out.println("A's parameter: "+i+" constructor");
	}

}

class B extends A
{
	B()
	{
		System.out.println("B's no parameter constructor");
	}
	B(int i1,int i2)
	{
		super(i1);
		System.out.println("B's parameter: "+i2+" constructor");
	
	}
}

class C extends B
{
	C()
	{
		System.out.println("C's no parameter constructor");
	}
	C(int i1,int i2,int i3)
	{
		super(i1,i2);
		System.out.println("C's parameter: "+i3+" constructor");
	}
}

