package HomeworkM12Files;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ServeThread implements Runnable {
    private static final int ONE_THOUSAND = 1000;
    private BlockingQueue<Food> orderQueue;
    private List<Food> foodList;
    public ServeThread(BlockingQueue<Food> orderQueue, List<Food> foodList){
        this.orderQueue = orderQueue;
        this.foodList = foodList;
    }

    @Override
    public void run() {
        int numberOfOrders = foodList.size();
        while(numberOfOrders > 0)
        {
            try {
                System.out.println("Number of orders: "+numberOfOrders);
                System.out.println("SERVER READY");
                System.out.println("ORDER QUEUE CAPACITY: " + orderQueue.remainingCapacity());
                Food food = orderQueue.take();
                System.out.println("SERVER STARTING: "+food);
                Thread.sleep((food.getServeTime() * ONE_THOUSAND));
                System.out.println("SERVER ENDING: "+food);
                numberOfOrders--;
            }catch (InterruptedException e){
                System.err.println("Interruption occured in ServeThread");
                return;
            }
        }
        System.out.println("SERVER CLOCKING OUT");
        return;
    }
}
