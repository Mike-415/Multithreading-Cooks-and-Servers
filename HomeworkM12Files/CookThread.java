package HomeworkM12Files;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CookThread implements Runnable {
    private static final int ONE_THOUSAND = 1000;
    private BlockingQueue<Food> orderQueue;
    private List<Food> foodList = new ArrayList<>();
    public CookThread(BlockingQueue<Food> orderQueue, List<Food> foodList) {
        this.orderQueue = orderQueue;
        this.foodList = foodList;
    }

    @Override
    public void run(){
        for(Food food: foodList)
        {
            try
            {
                System.out.println("COOK READY");
                System.out.println("COOK STARTING: " + food);
                Thread.sleep(food.getCookTime() * ONE_THOUSAND);
                orderQueue.put(food);
                System.out.println("ORDER QUEUE CAPACITY: " + orderQueue.remainingCapacity());
                System.out.println("COOK ENDING: " + food);
            }
            catch (InterruptedException e)
            {
                System.err.println("Interruption occured in CookThread");
                return;
            }
        }
        System.out.println("COOK CLOCKING OUT");
        return;
    }
}
