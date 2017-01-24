
import java.util.Scanner;

class TriangleDemo
{
  public static void main(String[] args)
  {
    	Scanner scanner=new Scanner(System.in);

      while(true)
      {
            System.out.println("Input the three Edges of Triangle");
            int a = Integer.parseInt( scanner.next());
            int b = Integer.parseInt( scanner.next());
            int c = Integer.parseInt( scanner.next());

            try
            {
              Triangle tri=new Triangle(a,b,c);
              System.out.println("A new Triangel!");
            }
            catch (EdgeInvalidException e)
            {
              System.out.println("I catch it !");
              e.printStackTrace();
            }
            finally
            {
              System.out.println("Once more!");
            }
      }
  }
}

class Triangle
{
  int a,b,c;

  Triangle(){}

  Triangle(int a, int b, int c) throws EdgeInvalidException
  {
    if(a+b<=c||a+c<=b||b+c<=a)
    {
      throw new EdgeInvalidException("invalid edge length");
    }
  }
}

class EdgeInvalidException extends Exception
{
  EdgeInvalidException(){}
  EdgeInvalidException(String msg)
  {
    super(msg);
  }
}
