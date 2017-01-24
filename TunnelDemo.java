
class TunnelDemo
{
    public static void main(String[] args)
    {
      Tunnel tn=new Tunnel();

      Vehicle Car1=new Vehicle("Car1",3,tn);
      Vehicle Car2=new Vehicle("Car2",3,tn);
      Vehicle TriCar1=new Vehicle("TriCar1",5,tn);
      Vehicle CowCar1=new Vehicle("CowCar1",10,tn);
      Vehicle CowCar2=new Vehicle("CowCar2",10,tn);

      Car1.start();
      Car2.start();
      TriCar1.start();
      CowCar1.start();
      CowCar2.start();
    }
}

class Tunnel
{
  public synchronized void takeRoad(Vehicle v)
  {
    try
    {
      String Vname=v.getVehicleName();
      System.out.println(Vname+"Passing the tunnel ...");
      for(int i=v.getPassTime();i>0;i--)
      {
        System.out.println(i+"...");
        Thread.sleep(1000);
      }
      System.out.println(Vname+"Passed, next one !");
    }
    catch(Exception e)
    {

    }

  }
}

class Vehicle extends Thread
{
  private int passTime;
  private Tunnel tn;
  private String name;

  Vehicle(String name, int passTime, Tunnel tn)
  {
    this.name=name;
    this.passTime=passTime;
    this.tn=tn;
  }

  public int getPassTime()
  {
    return passTime;
  }

  public String getVehicleName()
  {
    return name;
  }

  public void run()
  {
    tn.takeRoad(this);
  }
}
