package sand.org;

import java.util.List;

/**
 * @author SFernando
 */
public class Worker implements Runnable
{

  private String name;

  private Thread thread;

  private Store store;

  public Worker(String name, Store store)
  {
    this.name = name;
    this.store = store;
  }

  @Override
  public void run()
  {
    while (true)
    {
      fillBottles(store.getWaterBottles(), this.name);
    }
  }

  private static void fillBottles(List<WaterBottle> waterBottles, String name)
  {
    synchronized (Worker.class)
    {
      for (WaterBottle waterBottle : waterBottles)
      {
        if (waterBottle.getStock() < waterBottle.getLimit())
        {
          while (true)
          {
            if (waterBottle.getValue() % waterBottle.getAmountPerOnce() == 0 && waterBottle.getStock() >= waterBottle
                .getLimit())
            {
              waterBottle.setValue(0);
              break;
            }
            waterBottle.setStock(waterBottle.getStock() + 1);
            waterBottle.setValue(waterBottle.getValue() + 1);
            System.out.println(
                name + " is filling the " + waterBottle.getName() + ", new stock after filling " + waterBottle
                    .getStock());
            try
            {
              Worker.class.wait(2000);
            }
            catch (InterruptedException e)
            {
              e.printStackTrace();
            }
          }
        }
      }
    }
  }

  public void start()
  {
    System.out.println("Starting " + name);
    if (thread == null)
    {
      thread = new Thread(this, name);
      thread.start();
    }
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public Thread getThread()
  {
    return thread;
  }

  public void setThread(Thread thread)
  {
    this.thread = thread;
  }

  public Store getStore()
  {
    return store;
  }

  public void setStore(Store store)
  {
    this.store = store;
  }
}
