package playground;

import java.util.PriorityQueue;

public class Playground{
   public static void main(String[] args){
       PriorityQueue<Integer> queue=new PriorityQueue<>();
       queue.add(3);
       queue.add(7);
       queue.add(1);
       queue.add(2);
       System.out.println(queue.poll());
       System.out.println(queue.poll());
       System.out.println(queue.poll());
       System.out.println(queue.poll());
       System.out.println(queue.poll());

   }
}