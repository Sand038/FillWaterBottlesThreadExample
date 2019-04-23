/**
 * @author SFernando
 */
public class WaterBottle
{
  private String name;

  private int stock;

  private int amountPerOnce;

  private int value;

  private int limit = 20;

  public WaterBottle(String name, int stock, int amountPerOnce)
  {
    this.name = name;
    this.stock = stock;
    this.amountPerOnce = amountPerOnce;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public int getStock()
  {
    return stock;
  }

  public void setStock(int stock)
  {
    this.stock = stock;
  }

  public int getAmountPerOnce()
  {
    return amountPerOnce;
  }

  public void setAmountPerOnce(int amountPerOnce)
  {
    this.amountPerOnce = amountPerOnce;
  }

  public int getLimit()
  {
    return limit;
  }

  public void setLimit(int limit)
  {
    this.limit = limit;
  }

  public int getValue()
  {
    return value;
  }

  public void setValue(int value)
  {
    this.value = value;
  }
}
