 class ThreadDemo
 {
   public static void main(String[] args)
   {
     MyThread t1=new MyThread("thread 1");
     MyThread t2=new MyThread("thread 2");

     t1.start();
     t2.start();
   }
 }

 class MyThread extends Thread
 {
   private String name;
   public MyThread(String name)
   {
     this.name=name;
   }

   public void run()
   {
     while(true)
     {
       System.out.println(name);
       Thread.yield();
     }
   }
 }
