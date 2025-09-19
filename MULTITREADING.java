class Racer extends Thread { 
  private String racerName; 
  private int sleepTime; 
  Racer(String name, int sleepTime) { 
      this.racerName = name; 
      this.sleepTime = sleepTime; 
  } 
  @Override 
  public void run() { 
      try { 
          for (int step = 1; step <= 5; step++) { 
              Thread.sleep(sleepTime); // simulate running delay 
          } 
          System.out.println(racerName + " has finished the race!"); 
      } catch (InterruptedException e) { 
          System.out.println(racerName + " was interrupted!"); 
      } 
  } 
} 
public class RaceSimulation { 
 public static void main(String[] args) { 
      System.out.println("Mukesh P\n2117240070193\n"); 
      System.out.println("TC1:"); 
      Racer t1 = new Racer("Thread A", 500); 
      Racer t2 = new Racer("Thread B", 500); 
      t1.start(); 
      t2.start(); 
      try { t1.join(); t2.join(); } catch (Exception e) {} 
      System.out.println("TC2:"); 
      Racer t3 = new Racer("Thread A", 400); 
      Racer t4 = new Racer("Thread B", 800); 
      t3.start(); 
      t4.start(); 
      try { t3.join(); t4.join(); } catch (Exception e) {} 
      System.out.println("TC3:"); 
      Racer t5 = new Racer("Thread A", 600); 
      Racer t6 = new Racer("Thread B", 600); 
      t5.start(); 
      t6.start(); 
      try { t5.join(); t6.join(); } catch (Exception e) {} 
      System.out.println("TC4:"); 
      Racer t7 = new Racer("Thread A", 500); 
      Racer t8 = new Racer("Thread B", 700); 
      Racer t9 = new Racer("Thread C", 600); 
      t7.start(); 
      t8.start(); 
      t9.start(); 
      try { t7.join(); t8.join(); t9.join(); } catch (Exception e) {} 
      System.out.println("TC5:"); 
      Racer t10 = new Racer("Thread A", 500); 
      Racer t11 = new Racer("Thread B", 500); 
      t10.start(); 
      t11.start(); 
      try { t10.join(); t11.join(); } catch (Exception e) {} 
  } 
} 
