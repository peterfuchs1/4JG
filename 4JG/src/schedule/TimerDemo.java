package schedule;
import java.util.*;

public class TimerDemo extends TimerTask{
	private int i=0;
   public static void main(String[] args) {
   // creating timer task, timer
   TimerTask tasknew = new TimerDemo();
   Timer timer = new Timer();
      
   // scheduling the task at interval
   timer.schedule(tasknew,1000, 1000);      
   }
   // this method performs the task
   public void run() {
   System.out.println("timer working["+(i++)+"]");      
   }    
}