package org.bouncycastle.math.ec;

import java.math.BigInteger;

class SimpleBigDecimal
{
  private static final long serialVersionUID = 1L;
  private final BigInteger bigInt;
  private final int scale;
  
  public SimpleBigDecimal(BigInteger paramBigInteger, int paramInt)
  {
    if (paramInt >= 0)
    {
      this.bigInt = paramBigInteger;
      this.scale = paramInt;
      return;
    }
    throw new IllegalArgumentException("scale may not be negative");
  }
  
  private void checkScale(SimpleBigDecimal paramSimpleBigDecimal)
  {
    if (this.scale == paramSimpleBigDecimal.scale) {
      return;
    }
    throw new IllegalArgumentException("Only SimpleBigDecimal of same scale allowed in arithmetic operations");
  }
  
  public static SimpleBigDecimal getInstance(BigInteger paramBigInteger, int paramInt)
  {
    return new SimpleBigDecimal(paramBigInteger.shiftLeft(paramInt), paramInt);
  }
  
  public SimpleBigDecimal add(BigInteger paramBigInteger)
  {
    return new SimpleBigDecimal(this.bigInt.add(paramBigInteger.shiftLeft(this.scale)), this.scale);
  }
  
  public SimpleBigDecimal add(SimpleBigDecimal paramSimpleBigDecimal)
  {
    checkScale(paramSimpleBigDecimal);
    return new SimpleBigDecimal(this.bigInt.add(paramSimpleBigDecimal.bigInt), this.scale);
  }
  
  public SimpleBigDecimal adjustScale(int paramInt)
  {
    if (paramInt >= 0)
    {
      int i = this.scale;
      if (paramInt == i) {
        return this;
      }
      return new SimpleBigDecimal(this.bigInt.shiftLeft(paramInt - i), paramInt);
    }
    throw new IllegalArgumentException("scale may not be negative");
  }
  
  public int compareTo(BigInteger paramBigInteger)
  {
    return this.bigInt.compareTo(paramBigInteger.shiftLeft(this.scale));
  }
  
  public int compareTo(SimpleBigDecimal paramSimpleBigDecimal)
  {
    checkScale(paramSimpleBigDecimal);
    return this.bigInt.compareTo(paramSimpleBigDecimal.bigInt);
  }
  
  public SimpleBigDecimal divide(BigInteger paramBigInteger)
  {
    return new SimpleBigDecimal(this.bigInt.divide(paramBigInteger), this.scale);
  }
  
  public SimpleBigDecimal divide(SimpleBigDecimal paramSimpleBigDecimal)
  {
    checkScale(paramSimpleBigDecimal);
    return new SimpleBigDecimal(this.bigInt.shiftLeft(this.scale).divide(paramSimpleBigDecimal.bigInt), this.scale);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof SimpleBigDecimal)) {
      return false;
    }
    paramObject = (SimpleBigDecimal)paramObject;
    return (this.bigInt.equals(((SimpleBigDecimal)paramObject).bigInt)) && (this.scale == ((SimpleBigDecimal)paramObject).scale);
  }
  
  public BigInteger floor()
  {
    return this.bigInt.shiftRight(this.scale);
  }
  
  public int getScale()
  {
    return this.scale;
  }
  
  public int hashCode()
  {
    return this.bigInt.hashCode() ^ this.scale;
  }
  
  public int intValue()
  {
    return floor().intValue();
  }
  
  public long longValue()
  {
    return floor().longValue();
  }
  
  public SimpleBigDecimal multiply(BigInteger paramBigInteger)
  {
    return new SimpleBigDecimal(this.bigInt.multiply(paramBigInteger), this.scale);
  }
  
  public SimpleBigDecimal multiply(SimpleBigDecimal paramSimpleBigDecimal)
  {
    checkScale(paramSimpleBigDecimal);
    paramSimpleBigDecimal = this.bigInt.multiply(paramSimpleBigDecimal.bigInt);
    int i = this.scale;
    return new SimpleBigDecimal(paramSimpleBigDecimal, i + i);
  }
  
  public SimpleBigDecimal negate()
  {
    return new SimpleBigDecimal(this.bigInt.negate(), this.scale);
  }
  
  public BigInteger round()
  {
    return add(new SimpleBigDecimal(ECConstants.ONE, 1).adjustScale(this.scale)).floor();
  }
  
  public SimpleBigDecimal shiftLeft(int paramInt)
  {
    return new SimpleBigDecimal(this.bigInt.shiftLeft(paramInt), this.scale);
  }
  
  public SimpleBigDecimal subtract(BigInteger paramBigInteger)
  {
    return new SimpleBigDecimal(this.bigInt.subtract(paramBigInteger.shiftLeft(this.scale)), this.scale);
  }
  
  public SimpleBigDecimal subtract(SimpleBigDecimal paramSimpleBigDecimal)
  {
    return add(paramSimpleBigDecimal.negate());
  }
  
  public String toString()
  {
    if (this.scale == 0) {
      return this.bigInt.toString();
    }
    Object localObject3 = floor();
    Object localObject2 = this.bigInt.subtract(((BigInteger)localObject3).shiftLeft(this.scale));
    Object localObject1 = localObject2;
    if (this.bigInt.signum() == -1) {
      localObject1 = ECConstants.ONE.shiftLeft(this.scale).subtract((BigInteger)localObject2);
    }
    localObject2 = localObject3;
    if (((BigInteger)localObject3).signum() == -1)
    {
      localObject2 = localObject3;
      if (!((BigInteger)localObject1).equals(ECConstants.ZERO)) {
        localObject2 = ((BigInteger)localObject3).add(ECConstants.ONE);
      }
    }
    localObject2 = ((BigInteger)localObject2).toString();
    localObject3 = new char[this.scale];
    localObject1 = ((BigInteger)localObject1).toString(2);
    int m = ((String)localObject1).length();
    int n = this.scale - m;
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= n) {
        break;
      }
      localObject3[i] = 48;
      i += 1;
    }
    while (j < m)
    {
      localObject3[(n + j)] = ((String)localObject1).charAt(j);
      j += 1;
    }
    localObject1 = new String((char[])localObject3);
    localObject2 = new StringBuffer((String)localObject2);
    ((StringBuffer)localObject2).append(".");
    ((StringBuffer)localObject2).append((String)localObject1);
    return ((StringBuffer)localObject2).toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\SimpleBigDecimal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */