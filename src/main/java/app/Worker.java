package app;


public class Worker {

    public static void main(String[] args) throws InterruptedException {
        while(true){
            System.out.println("Tick!");
            Thread.sleep(1000);
        }
    }
}
