
class PolyDemo
{
  public static void main(String[] args) {
    Jing8 jing8=new Jing8();

    jing8.cry();
    System.out.println(jing8.name);

    Dog d1=jing8;
    d1.cry();
    System.out.println(d1.name);

    Dog d2=new Dog();
    d2.cry();

  // 错误代码演示
  //  Jing8 j1=(Jing8)d2;
  //  j1.cry();
  }
}

abstract class Animal
{
  abstract void cry();
}

class Dog extends Animal
{
  public String name = "little white";
  public void cry()
  {
    System.out.println("my name is "+name);
    System.out.println("wang wang...");
  }
}

class Jing8 extends Dog
{
  public String name="big yellow";
  public void cry()
  {
    System.out.println("my name is "+name);
    System.out.println("I'm Jing8, --- ,wang wang...");
  }
}
