
import java.util.Random;

class RandomDemo
{
  public static void main(String[] args) {
    Random r=new Random();
    while(true)
    {
      System.out.println(r.nextInt(10));
      try{

        Thread.sleep(500);
      }
      catch(Exception e)
      {}
    }
  }
}
