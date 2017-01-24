import java.util.Date;
import java.text.SimpleDateFormat;


class HoneyDemo
{
  public static void main(String[] args)
  {
    HoneyComb hc = new HoneyComb(0);
    Bear br=new Bear("Bear", hc);
    Bee[] bees=new Bee [20];
    // Bee b1=new Bee("bee"+1,hc);

    hc.start();
    br.start();
    // b1.start();
    for(int i=0;i<bees.length;i++)
    {
      bees[i]=new Bee("bee"+i,hc);
      bees[i].start();
    }

  }
}

class HoneyComb extends Thread
{
  private int honeyWeight=0;
  private int capacity=20;
  private int upLine = 20;

  HoneyComb()
  {
  }

  HoneyComb(int honeyWeight)
  {
    this.honeyWeight = honeyWeight;
  }

  public synchronized boolean addHoney(int weight)
  {
    if(weight<0)
      return false;
    else
    {
      while(honeyWeight+weight>capacity)
      {
        try
        {
          System.out.print(".");
          this.wait();
        }
        catch(Exception e)
        {

        }
      }
      honeyWeight+=weight;
      if(honeyWeight>=upLine)
      {
        try
        {
          //this.notifyAll();
          notify();
          System.out.println("upline meet !");
        }
        catch(Exception e)
        {

        }
      }
      return true;
    }
  }

  public synchronized boolean takeHoney(int weight)
  {
    if(weight<0)
    {
      return false;
    }
    else
    {
      while(weight>honeyWeight)
      {
        try
        {
          System.out.println("takeHoney waiting ... ");
          this.wait();
        }
        catch(Exception e)
        {

        }
      }
      honeyWeight-=weight;
      try
      {
        //this.notifyAll();
        notify();
      }
      catch(Exception e)
      {

      }
      return true;
    }
  }

  public void run()
  {
    while(true)
    {
     System.out.println(new Date()+" : "+ honeyWeight);
     try
     {
       Thread.sleep(1000);
     }
     catch(Exception e)
     {

     }
    }
  }

}

class Bee extends Thread
{
  private String id;
  private HoneyComb hc;
  private int pWeight=1;

  Bee(String id, HoneyComb hc)
  {
    this.id=id;
    this.hc=hc;
  }

  private void produceHoney()
  {
    hc.addHoney(pWeight);
    System.out.print("-");
    try
    {
      //Thread.sleep(500);
    }
    catch(Exception e)
    {

    }
  }

  public void run()
  {
    while(true)
    {
      produceHoney();
    }
  }
}

class Bear extends Thread
{
  private String id;
  private HoneyComb hc;
  private int sWeight=20;

  Bear(String id, HoneyComb hc)
  {
    this.id=id;
    this.hc=hc;
  }

  private void consumeHoney()
  {
    hc.takeHoney(sWeight);
    System.out.println(id+"consumed !");
  }

  public void run()
  {
    while(true)
    {
      consumeHoney();
    }
  }
}
