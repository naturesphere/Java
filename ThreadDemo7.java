class ThreadDemo7
{
  public static void main(String[] args)
  {
    TicketPool pool=new TicketPool();
    Saler s1=new Saler("S-1",pool);
    Saler s2=new Saler("S-2",pool);
    Saler s3=new Saler("S-3",pool);
    Saler s4=new Saler("S-4",pool);
    Master m=new Master("S-5",pool);

    m.start();
    // try
    // {
    //   m.join();
    // }
    // catch(Exception e)
    // {
    //
    // }
    s1.start();
    s2.start();
    s3.start();
    s4.start();
  }
}

class Saler extends Thread
{
  private String name;
  private TicketPool pool;
  public Saler(String name, TicketPool pool)
  {
    this.name=name;
    this.pool=pool;
  }

  public void run()
  {
    while(true)
    {
      int no=pool.getTicket(true);
      try
      {
        Thread.sleep(500);
      }
      catch(Exception e)
      {

      }
      if(no==0)
        return;
      else
        System.out.println(name+":"+no);
    }
  }
}

class Master extends Thread
{
  private String name;
  private TicketPool pool;

  public Master(String name, TicketPool pool)
  {
    this.name=name;
    this.pool=pool;
  }

  public void run()
  {
    while(true)
    {
      //pool.setTicket(0);
      //pool.getTicket(false);
      try
      {
        //Thread.sleep(100);
      }
      catch(Exception e)
      {

      }
      //System.out.println("set Tickets");
    }
  }
}

class TicketPool
{
  private int tickets = 10;

  public synchronized int getTicket(boolean b)
  {
    if(b)
    {
      int temp=tickets;
      tickets-=1;
      return temp>0?temp:0;
    }
    else
      return 0;
  }

  public synchronized boolean setTicket(int n)
  {
    if(n>0)
    {
      tickets+=n;
      return true;
    }
    else
      return false;
  }
}
