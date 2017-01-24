
import java.util.Scanner;

class BirthdayExceptDemo
{
  public static void main(String[] args)
  {
    boolean isAgain=false;
    Scanner scanner=new Scanner(System.in);
    do {
          System.out.println("Input the year month and day the person birth in:");
          int year = Integer.parseInt( scanner.next());
          int month = Integer.parseInt( scanner.next());
          int day = Integer.parseInt( scanner.next());

          try
          {
            new Person().SetBirthday(year,month,day);
          }
          catch(YearInvalidException ey)
          {
            System.out.println("catch YearInvalidException");
            ey.printStackTrace();
          }
          catch(MonthInvalidException em)
          {
            System.out.println("catch MonthInvalidException");
            em.printStackTrace();
          }
          catch(DayInvalidException ed)
          {
            System.out.println("catch DayInvalidException");
            ed.printStackTrace();
          }
          catch(BirthdayInvalidException eb)
          {
            System.out.println("catch BirthdayInvalidException");
            eb.printStackTrace();
          }
          finally
          {
            while(true)
            {
              System.out.println("Once again? y/n");
              char c = scanner.next().charAt(0);
              if(c=='y'||c=='Y')
              {
                isAgain=true;
                break;
              }
              else if(c=='n'||c=='N')
              {
                isAgain=false;
                System.out.println("Goodbye");
                break;
              }
              else
                System.out.println("y/n please!");
            }
          }
      } while (isAgain);
  }
}

class Person
{
  private int year,month,day;

  static final int YEAR_MIN=1970;
  // static final int YEAR_MAX= Calendar.getInstance().get(Calendar.YEAR);
  static final int YEAR_MAX= 2017;
  static final int MONTH_MIN=1;
  static final int MONTH_MAX=12;
  static final int DAY_MIN=1;
  static final int DAY_MAX=31;

  public void SetBirthday(int year, int month, int day) throws
  BirthdayInvalidException,YearInvalidException,MonthInvalidException,DayInvalidException
  {
    if(year<=YEAR_MIN)
      throw  new YearInvalidException("Birth year too early");
    else if(year>YEAR_MAX)
      throw  new YearInvalidException("Birth year is not come yeat");
    else
      this.year = year;

    if(month<MONTH_MIN)
      throw  new MonthInvalidException("Birth month too little");
    else if(month>MONTH_MAX)
      throw  new MonthInvalidException("Birth month too big");
    else
      this.month = month;

    if(day<DAY_MIN)
      throw  new MonthInvalidException("Birth day too little");
    else if(day>DAY_MAX)
      throw  new MonthInvalidException("Birth day too big");
    else
    {
        switch(month)
        {
          case 1: case 3: case 5: case 7: case 8: case 10: case 12:
          break;
          case 4: case 6: case 9: case 11:
            if(day>DAY_MAX-1)
              throw  new MonthInvalidException("Birth day too big");
            else
              this.day=day;
          break;
          case 2:
            if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0)//Leap year
            {
              if(day>DAY_MAX-2)
                throw  new MonthInvalidException("Birth day too big");
              else
                this.day=day;
            }
            else
            {
              if(day>DAY_MAX-3)
                throw  new MonthInvalidException("Birth day too big");
              else
                this.day=day;
            }
          break;

          default:
            throw new BirthdayInvalidException("BirthdayInvalid");
        }
    }

    System.out.println("your birthday: "+year+"-"+month+"-"+day);
  }
}

class BirthdayInvalidException extends Exception
{
  BirthdayInvalidException()
  {

  }

  BirthdayInvalidException(String msg)
  {
    super(msg);
  }
}

class YearInvalidException extends BirthdayInvalidException
{
  YearInvalidException(){}
  YearInvalidException(String msg)
  {
    super(msg);
  }
}

class MonthInvalidException extends BirthdayInvalidException
{
  MonthInvalidException(){}
  MonthInvalidException(String msg)
  {
    super(msg);
  }
}

class DayInvalidException extends BirthdayInvalidException
{
  DayInvalidException(){}
  DayInvalidException(String msg)
  {
    super(msg);
  }
}
