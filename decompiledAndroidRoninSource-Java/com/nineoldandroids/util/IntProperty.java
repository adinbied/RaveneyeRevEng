package com.nineoldandroids.util;

public abstract class IntProperty<T>
  extends Property<T, Integer>
{
  public IntProperty(String paramString)
  {
    super(Integer.class, paramString);
  }
  
  public final void set(T paramT, Integer paramInteger)
  {
    set(paramT, Integer.valueOf(paramInteger.intValue()));
  }
  
  public abstract void setValue(T paramT, int paramInt);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\nineoldandroid\\util\IntProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */