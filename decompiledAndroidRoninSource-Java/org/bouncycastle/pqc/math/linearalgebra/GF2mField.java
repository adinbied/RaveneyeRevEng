package org.bouncycastle.pqc.math.linearalgebra;

import java.security.SecureRandom;

public class GF2mField
{
  private int degree = 0;
  private int polynomial;
  
  public GF2mField(int paramInt)
  {
    if (paramInt < 32)
    {
      if (paramInt >= 1)
      {
        this.degree = paramInt;
        this.polynomial = PolynomialRingGF2.getIrreduciblePolynomial(paramInt);
        return;
      }
      throw new IllegalArgumentException(" Error: the degree of field is non-positive ");
    }
    throw new IllegalArgumentException(" Error: the degree of field is too large ");
  }
  
  public GF2mField(int paramInt1, int paramInt2)
  {
    if (paramInt1 == PolynomialRingGF2.degree(paramInt2))
    {
      if (PolynomialRingGF2.isIrreducible(paramInt2))
      {
        this.degree = paramInt1;
        this.polynomial = paramInt2;
        return;
      }
      throw new IllegalArgumentException(" Error: given polynomial is reducible");
    }
    throw new IllegalArgumentException(" Error: the degree is not correct");
  }
  
  public GF2mField(GF2mField paramGF2mField)
  {
    this.degree = paramGF2mField.degree;
    this.polynomial = paramGF2mField.polynomial;
  }
  
  public GF2mField(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length == 4)
    {
      int i = LittleEndianConversions.OS2IP(paramArrayOfByte);
      this.polynomial = i;
      if (PolynomialRingGF2.isIrreducible(i))
      {
        this.degree = PolynomialRingGF2.degree(this.polynomial);
        return;
      }
      throw new IllegalArgumentException("byte array is not an encoded finite field");
    }
    throw new IllegalArgumentException("byte array is not an encoded finite field");
  }
  
  private static String polyToString(int paramInt)
  {
    if (paramInt == 0) {
      return "0";
    }
    Object localObject1;
    if ((byte)(paramInt & 0x1) == 1) {
      localObject1 = "1";
    } else {
      localObject1 = "";
    }
    int i = paramInt >>> 1;
    paramInt = 1;
    while (i != 0)
    {
      Object localObject2 = localObject1;
      if ((byte)(i & 0x1) == 1)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("+x^");
        ((StringBuilder)localObject2).append(paramInt);
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      i >>>= 1;
      paramInt += 1;
      localObject1 = localObject2;
    }
    return (String)localObject1;
  }
  
  public int add(int paramInt1, int paramInt2)
  {
    return paramInt1 ^ paramInt2;
  }
  
  public String elementToStr(int paramInt)
  {
    String str1 = "";
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < this.degree)
    {
      StringBuilder localStringBuilder;
      String str2;
      if (((byte)i & 0x1) == 0)
      {
        localStringBuilder = new StringBuilder();
        str2 = "0";
      }
      else
      {
        localStringBuilder = new StringBuilder();
        str2 = "1";
      }
      localStringBuilder.append(str2);
      localStringBuilder.append(str1);
      str1 = localStringBuilder.toString();
      i >>>= 1;
      paramInt += 1;
    }
    return str1;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof GF2mField)) {
        return false;
      }
      paramObject = (GF2mField)paramObject;
      if ((this.degree == ((GF2mField)paramObject).degree) && (this.polynomial == ((GF2mField)paramObject).polynomial)) {
        return true;
      }
    }
    return false;
  }
  
  public int exp(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return 1;
    }
    if (paramInt1 == 0) {
      return 0;
    }
    if (paramInt1 == 1) {
      return 1;
    }
    int i = paramInt1;
    int j = paramInt2;
    if (paramInt2 < 0)
    {
      i = inverse(paramInt1);
      j = -paramInt2;
    }
    for (paramInt1 = 1; j != 0; paramInt1 = paramInt2)
    {
      paramInt2 = paramInt1;
      if ((j & 0x1) == 1) {
        paramInt2 = mult(paramInt1, i);
      }
      i = mult(i, i);
      j >>>= 1;
    }
    return paramInt1;
  }
  
  public int getDegree()
  {
    return this.degree;
  }
  
  public byte[] getEncoded()
  {
    return LittleEndianConversions.I2OSP(this.polynomial);
  }
  
  public int getPolynomial()
  {
    return this.polynomial;
  }
  
  public int getRandomElement(SecureRandom paramSecureRandom)
  {
    return RandUtils.nextInt(paramSecureRandom, 1 << this.degree);
  }
  
  public int getRandomNonZeroElement()
  {
    return getRandomNonZeroElement(new SecureRandom());
  }
  
  public int getRandomNonZeroElement(SecureRandom paramSecureRandom)
  {
    int j = RandUtils.nextInt(paramSecureRandom, 1 << this.degree);
    int i = 0;
    while ((j == 0) && (i < 1048576))
    {
      j = RandUtils.nextInt(paramSecureRandom, 1 << this.degree);
      i += 1;
    }
    if (i == 1048576) {
      return 1;
    }
    return j;
  }
  
  public int hashCode()
  {
    return this.polynomial;
  }
  
  public int inverse(int paramInt)
  {
    return exp(paramInt, (1 << this.degree) - 2);
  }
  
  public boolean isElementOfThisField(int paramInt)
  {
    int i = this.degree;
    boolean bool2 = false;
    boolean bool1 = false;
    if (i == 31)
    {
      if (paramInt >= 0) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool2;
    if (paramInt >= 0)
    {
      bool1 = bool2;
      if (paramInt < 1 << i) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int mult(int paramInt1, int paramInt2)
  {
    return PolynomialRingGF2.modMultiply(paramInt1, paramInt2, this.polynomial);
  }
  
  public int sqRoot(int paramInt)
  {
    int j = 1;
    int i = paramInt;
    paramInt = j;
    while (paramInt < this.degree)
    {
      i = mult(i, i);
      paramInt += 1;
    }
    return i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Finite Field GF(2^");
    localStringBuilder.append(this.degree);
    localStringBuilder.append(") = ");
    localStringBuilder.append("GF(2)[X]/<");
    localStringBuilder.append(polyToString(this.polynomial));
    localStringBuilder.append("> ");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\math\linearalgebra\GF2mField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */