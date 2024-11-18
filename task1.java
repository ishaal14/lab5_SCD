import java.util.Random;

public class AlphabetThread extends Thread {
    private volatile boolean running = true; 

    public void run() {
        Random random = new Random();
        for (int i = 0; i < 26 && running; i++) {  
            char randomChar = (char) (random.nextInt(26) + 'A'); 
            System.out.print(randomChar + " ");
            
            try {
                
                Thread.sleep(random.nextInt(500) + 200);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    
    public void stopThread() {
        running = false;
    }

    public static void main(String[] args) {
        
        AlphabetThread t1 = new AlphabetThread();
        AlphabetThread t2 = new AlphabetThread();

        
        t1.start();
        t2.start();

        try {
            
            Thread.sleep(3000); 
            t1.stopThread(); 
            System.out.println("\nThread t1 is stopped");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}