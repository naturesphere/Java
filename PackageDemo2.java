package com.it18zhang.java;
import com.it18zhang.java.PackageDemo;
 public class PackageDemo2
 {
   public static void main(String[] args) {
     System.out.println("Hello World 2 !");
     PackageDemo.sayHello("Hello");
   }

   public static void sayHi(String msg)
   {
     System.out.println(msg);
   }
 }
