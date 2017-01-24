package tst;

public class TestInner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Outer o = new Outer();
		OutI oi=o.eat(10);
		oi.innerEat();
	}
}
	class Outer
	{
		private String name;
		
		public OutI eat(int i)
		{
			int count=5;
			class Inner implements OutI
			{
				
				public void innerEat()
				{
					System.out.println(name);
					System.out.println(i);
					System.out.println(count);
				}
			}
			Inner inn=new Inner();
			//inn.innerEat();
			return inn;
		}
	}
	interface OutI
	{
		void innerEat();
	}
