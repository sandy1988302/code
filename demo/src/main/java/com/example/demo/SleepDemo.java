package com.example.demo;
import java.util.*;
  
public class SleepDemo {
   public static void main(final String args[]) {
      try { 
         System.out.println(new Date( ) + "\n"); 
         Thread.sleep(1000*3);   // 休眠3秒
         System.out.println(new Date( ) + "\n"); 
      } catch (final Exception e) { 
          System.out.println("Got an exception!"); 
      }
   }
}
