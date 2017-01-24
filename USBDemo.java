
class USBDemo
{
  public static void main(String[] args) {
    PC myComputer = new PC();
    MP3 myMp3 = new MP3();
    FAN myFan = new FAN();
    UPan myUpan = new UPan();

    myComputer.playUSBdevice();
    myComputer.plugUSBdevice(myMp3);
    myComputer.playUSBdevice();
    myComputer.plugUSBdevice(myFan);

    myComputer.pullUSBdevice();
    myComputer.plugUSBdevice(myFan);
    myComputer.playUSBdevice();

    myComputer.pullUSBdevice();
    myComputer.plugUSBdevice(myUpan);
    myComputer.playUSBdevice();

    myComputer.pullUSBdevice();
    myComputer.plugUSBdevice(new USB()
    {
      public void play()
      {
        System.out.println("Vedio recording ...");
      }
    });
    myComputer.playUSBdevice();

  }
}

interface USB
{
  void play();
}

class PC
{
  USB dev=null;
  public void plugUSBdevice(USB dev)
  {
    if(this.dev==null)
      this.dev=dev;
    else
      System.out.println("interface occupied, pull old one out to plug new one");
  }

  public void pullUSBdevice()
  {
    dev=null;
  }

  public void playUSBdevice()
  {
    if(dev==null)
      System.out.println("no device");
    else
      dev.play();
  }

}

class MP3 implements USB
{
  public void play()
  {
    System.out.println("Music playing ...");
  }
}

class FAN implements USB
{
  public void play()
  {
    System.out.println("Wind producing ...");
  }
}

class UPan implements USB
{
  public void play()
  {
    System.out.println("Data reading ...");
  }
}
