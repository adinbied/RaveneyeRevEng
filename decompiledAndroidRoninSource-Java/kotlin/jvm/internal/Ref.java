package kotlin.jvm.internal;

import java.io.Serializable;

public class Ref
{
  public static final class BooleanRef
    implements Serializable
  {
    public boolean element;
    
    public String toString()
    {
      return String.valueOf(this.element);
    }
  }
  
  public static final class ByteRef
    implements Serializable
  {
    public byte element;
    
    public String toString()
    {
      return String.valueOf(this.element);
    }
  }
  
  public static final class CharRef
    implements Serializable
  {
    public char element;
    
    public String toString()
    {
      return String.valueOf(this.element);
    }
  }
  
  public static final class DoubleRef
    implements Serializable
  {
    public double element;
    
    public String toString()
    {
      return String.valueOf(this.element);
    }
  }
  
  public static final class FloatRef
    implements Serializable
  {
    public float element;
    
    public String toString()
    {
      return String.valueOf(this.element);
    }
  }
  
  public static final class IntRef
    implements Serializable
  {
    public int element;
    
    public String toString()
    {
      return String.valueOf(this.element);
    }
  }
  
  public static final class LongRef
    implements Serializable
  {
    public long element;
    
    public String toString()
    {
      return String.valueOf(this.element);
    }
  }
  
  public static final class ObjectRef<T>
    implements Serializable
  {
    public T element;
    
    public String toString()
    {
      return String.valueOf(this.element);
    }
  }
  
  public static final class ShortRef
    implements Serializable
  {
    public short element;
    
    public String toString()
    {
      return String.valueOf(this.element);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\jvm\internal\Ref.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */