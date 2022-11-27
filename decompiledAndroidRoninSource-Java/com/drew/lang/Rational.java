package com.drew.lang;

import java.io.Serializable;

public class Rational
  extends Number
  implements Comparable<Rational>, Serializable
{
  private static final long serialVersionUID = 510688928138848770L;
  private final long _denominator;
  private final long _numerator;
  
  public Rational(long paramLong1, long paramLong2)
  {
    this._numerator = paramLong1;
    this._denominator = paramLong2;
  }
  
  private static long GCD(long paramLong1, long paramLong2)
  {
    long l1 = paramLong1;
    if (paramLong1 < 0L) {
      l1 = -paramLong1;
    }
    long l2 = l1;
    paramLong1 = paramLong2;
    if (paramLong2 < 0L)
    {
      paramLong1 = -paramLong2;
      l2 = l1;
    }
    boolean bool;
    for (;;)
    {
      bool = l2 < 0L;
      if ((!bool) || (paramLong1 == 0L)) {
        break;
      }
      if (l2 > paramLong1) {
        l2 %= paramLong1;
      } else {
        paramLong1 %= l2;
      }
    }
    if (!bool) {
      l2 = paramLong1;
    }
    return l2;
  }
  
  public final byte byteValue()
  {
    return (byte)(int)doubleValue();
  }
  
  public int compareTo(Rational paramRational)
  {
    return 0;
  }
  
  public double doubleValue()
  {
    return 1.0428345E-315D;
  }
  
  public boolean equals(Rational paramRational)
  {
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public boolean equalsExact(Rational paramRational)
  {
    return false;
  }
  
  public float floatValue()
  {
    return 0.0F;
  }
  
  public final long getDenominator()
  {
    return this._denominator;
  }
  
  public final long getNumerator()
  {
    return this._numerator;
  }
  
  public Rational getReciprocal()
  {
    return null;
  }
  
  public Rational getSimplifiedInstance()
  {
    return null;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public final int intValue()
  {
    return (int)doubleValue();
  }
  
  public boolean isInteger()
  {
    return false;
  }
  
  public boolean isZero()
  {
    return false;
  }
  
  public final long longValue()
  {
    return doubleValue();
  }
  
  public final short shortValue()
  {
    return (short)(int)doubleValue();
  }
  
  public String toSimpleString(boolean paramBoolean)
  {
    return null;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\lang\Rational.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */