package dji.thirdparty.sanselan.common;

public class RationalNumber
  extends Number
{
  private static final long serialVersionUID = -1L;
  public final int divisor;
  public final int numerator;
  
  public RationalNumber(int paramInt1, int paramInt2)
  {
    this.numerator = paramInt1;
    this.divisor = paramInt2;
  }
  
  public static final RationalNumber factoryMethod(long paramLong1, long paramLong2)
  {
    long l1 = paramLong1;
    long l2 = paramLong2;
    if (paramLong1 <= 2147483647L)
    {
      l1 = paramLong1;
      l2 = paramLong2;
      if (paramLong1 >= -2147483648L)
      {
        l1 = paramLong1;
        l2 = paramLong2;
        if (paramLong2 <= 2147483647L)
        {
          l1 = paramLong1;
          l2 = paramLong2;
          if (paramLong2 >= -2147483648L) {
            break label140;
          }
          l2 = paramLong2;
          l1 = paramLong1;
        }
      }
    }
    while (((l1 > 2147483647L) || (l1 < -2147483648L) || (l2 > 2147483647L) || (l2 < -2147483648L)) && (Math.abs(l1) > 1L) && (Math.abs(l2) > 1L))
    {
      l1 >>= 1;
      l2 >>= 1;
    }
    if (l2 != 0L)
    {
      label140:
      paramLong1 = gcd(l1, l2);
      paramLong2 = l2 / paramLong1;
      return new RationalNumber((int)(l1 / paramLong1), (int)paramLong2);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Invalid value, numerator: ");
    localStringBuilder.append(l1);
    localStringBuilder.append(", divisor: ");
    localStringBuilder.append(l2);
    throw new NumberFormatException(localStringBuilder.toString());
  }
  
  private static long gcd(long paramLong1, long paramLong2)
  {
    if (paramLong2 == 0L) {
      return paramLong1;
    }
    return gcd(paramLong2, paramLong1 % paramLong2);
  }
  
  public double doubleValue()
  {
    return this.numerator / this.divisor;
  }
  
  public float floatValue()
  {
    return this.numerator / this.divisor;
  }
  
  public int intValue()
  {
    return this.numerator / this.divisor;
  }
  
  public boolean isValid()
  {
    return this.divisor != 0;
  }
  
  public long longValue()
  {
    return this.numerator / this.divisor;
  }
  
  public RationalNumber negate()
  {
    return null;
  }
  
  public String toDisplayString()
  {
    return null;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\common\RationalNumber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */