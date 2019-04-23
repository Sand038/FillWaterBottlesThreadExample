import java.util.Arrays;
import java.util.List;

public class Store
{

  private List<WaterBottle> waterBottles = Arrays
      .asList(new WaterBottle("First Bottle", 5, 4), new WaterBottle("Second Bottle", 10, 3));

  public static void main(String[] args)
  {
    Store store = new Store();
    Worker workerOne = new Worker("FirstWorker", store);
    workerOne.start();
    Worker workerTwo = new Worker("SecondWorker", store);
    workerTwo.start();
    Worker workerThree = new Worker("ThirdWorker", store);
    workerThree.start();

  }

  public List<WaterBottle> getWaterBottles()
  {
    return waterBottles;
  }
}
