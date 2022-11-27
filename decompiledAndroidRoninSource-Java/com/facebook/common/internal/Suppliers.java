package com.facebook.common.internal;

public class Suppliers
{
  public static final Supplier<Boolean> BOOLEAN_FALSE = new Supplier()
  {
    public Boolean get()
    {
      return Boolean.valueOf(false);
    }
  };
  public static final Supplier<Boolean> BOOLEAN_TRUE = new Supplier()
  {
    public Boolean get()
    {
      return Boolean.valueOf(true);
    }
  };
  
  public static <T> Supplier<T> of(T paramT)
  {
    new Supplier()
    {
      public T get()
      {
        return (T)this.val$instance;
      }
    };
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\common\internal\Suppliers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */