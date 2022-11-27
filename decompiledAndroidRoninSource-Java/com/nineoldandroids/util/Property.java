package com.nineoldandroids.util;

public abstract class Property<T, V>
{
  private final String mName;
  private final Class<V> mType;
  
  public Property(Class<V> paramClass, String paramString)
  {
    this.mName = paramString;
    this.mType = paramClass;
  }
  
  public static <T, V> Property<T, V> of(Class<T> paramClass, Class<V> paramClass1, String paramString)
  {
    return new ReflectiveProperty(paramClass, paramClass1, paramString);
  }
  
  public abstract V get(T paramT);
  
  public String getName()
  {
    return this.mName;
  }
  
  public Class<V> getType()
  {
    return this.mType;
  }
  
  public boolean isReadOnly()
  {
    return false;
  }
  
  /* Error */
  public void set(T arg1, V arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\nineoldandroid\\util\Property.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */