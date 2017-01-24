import java.util.Random;

class MantouDemo
{
  public static void main(String[] args)
  {
    Steamer stm=new Steamer(100);
    Worker[] workArr=new Worker [40];

    for(int i=0;i<workArr.length;i++)
    {
      workArr[i]=new Worker(stm,"Work"+i);
      workArr[i].start();
    }
  }
}

class Worker extends Thread
{
  private Steamer stm;
  private String name;

  public Worker(){};
  public Worker(Steamer stm, String name)
  {
    this.stm=stm;
    this.name=name;
  }

  int eatMantou()
  {
    int n=new Random().nextInt(4);
    if(n==stm.getMantous(n))
    {
      System.out.println(name+":eats "+n+" Mantous");
      return n;
    }
    else
    {
      System.out.println(name+":less than "+n+" Mantous");
      return -1;
    }
  }

  public void run()
  {
    while(stm.hasMantous())
    {
      eatMantou();
      try
      {
          Thread.sleep(500);
      }
      catch(Exception e)
      {}
    }
  }
}

class Steamer
{
  private int mantouTotal;

  public Steamer(){mantouTotal=100;}
  public Steamer(int mantouTotal)
  {
    if(mantouTotal>=0)
      this.mantouTotal=mantouTotal;
  }

/*
*return the number of mantou you get, -1 is get failure
*/
  public synchronized int getMantous(int num)
  {
    if(mantouTotal>=num)
    {
      mantouTotal-=num;
      return num;
    }
    else
      return -1;
  }

  public synchronized boolean hasMantous()
  {
    return mantouTotal>0?true:false;
  }

}
