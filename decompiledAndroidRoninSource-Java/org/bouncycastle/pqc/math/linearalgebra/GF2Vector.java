package org.bouncycastle.pqc.math.linearalgebra;

import java.security.SecureRandom;

public class GF2Vector
  extends Vector
{
  private int[] v;
  
  public GF2Vector(int paramInt)
  {
    if (paramInt >= 0)
    {
      this.length = paramInt;
      this.v = new int[paramInt + 31 >> 5];
      return;
    }
    throw new ArithmeticException("Negative length.");
  }
  
  public GF2Vector(int paramInt1, int paramInt2, SecureRandom paramSecureRandom)
  {
    if (paramInt2 <= paramInt1)
    {
      this.length = paramInt1;
      this.v = new int[paramInt1 + 31 >> 5];
      int[] arrayOfInt = new int[paramInt1];
      int m = 0;
      int k = 0;
      int i;
      int j;
      for (;;)
      {
        i = m;
        j = paramInt1;
        if (k >= paramInt1) {
          break;
        }
        arrayOfInt[k] = k;
        k += 1;
      }
      while (i < paramInt2)
      {
        paramInt1 = RandUtils.nextInt(paramSecureRandom, j);
        setBit(arrayOfInt[paramInt1]);
        j -= 1;
        arrayOfInt[paramInt1] = arrayOfInt[j];
        i += 1;
      }
      return;
    }
    throw new ArithmeticException("The hamming weight is greater than the length of vector.");
  }
  
  public GF2Vector(int paramInt, SecureRandom paramSecureRandom)
  {
    this.length = paramInt;
    int i = paramInt + 31 >> 5;
    this.v = new int[i];
    int j = i - 1;
    i = j;
    while (i >= 0)
    {
      this.v[i] = paramSecureRandom.nextInt();
      i -= 1;
    }
    paramInt &= 0x1F;
    if (paramInt != 0)
    {
      paramSecureRandom = this.v;
      paramSecureRandom[j] = ((1 << paramInt) - 1 & paramSecureRandom[j]);
    }
  }
  
  public GF2Vector(int paramInt, int[] paramArrayOfInt)
  {
    if (paramInt >= 0)
    {
      this.length = paramInt;
      int i = paramInt + 31 >> 5;
      if (paramArrayOfInt.length == i)
      {
        paramArrayOfInt = IntUtils.clone(paramArrayOfInt);
        this.v = paramArrayOfInt;
        paramInt &= 0x1F;
        if (paramInt != 0)
        {
          i -= 1;
          paramArrayOfInt[i] = ((1 << paramInt) - 1 & paramArrayOfInt[i]);
        }
        return;
      }
      throw new ArithmeticException("length mismatch");
    }
    throw new ArithmeticException("negative length");
  }
  
  public GF2Vector(GF2Vector paramGF2Vector)
  {
    this.length = paramGF2Vector.length;
    this.v = IntUtils.clone(paramGF2Vector.v);
  }
  
  protected GF2Vector(int[] paramArrayOfInt, int paramInt)
  {
    this.v = paramArrayOfInt;
    this.length = paramInt;
  }
  
  public static GF2Vector OS2VP(int paramInt, byte[] paramArrayOfByte)
  {
    if (paramInt >= 0)
    {
      if (paramArrayOfByte.length <= paramInt + 7 >> 3) {
        return new GF2Vector(paramInt, LittleEndianConversions.toIntArray(paramArrayOfByte));
      }
      throw new ArithmeticException("length mismatch");
    }
    throw new ArithmeticException("negative length");
  }
  
  public Vector add(Vector paramVector)
  {
    if ((paramVector instanceof GF2Vector))
    {
      paramVector = (GF2Vector)paramVector;
      if (this.length == paramVector.length)
      {
        paramVector = IntUtils.clone(paramVector.v);
        int i = paramVector.length - 1;
        while (i >= 0)
        {
          paramVector[i] ^= this.v[i];
          i -= 1;
        }
        return new GF2Vector(this.length, paramVector);
      }
      throw new ArithmeticException("length mismatch");
    }
    throw new ArithmeticException("vector is not defined over GF(2)");
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof GF2Vector;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (GF2Vector)paramObject;
    bool1 = bool2;
    if (this.length == ((GF2Vector)paramObject).length)
    {
      bool1 = bool2;
      if (IntUtils.equals(this.v, ((GF2Vector)paramObject).v)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public GF2Vector extractLeftVector(int paramInt)
  {
    if (paramInt <= this.length)
    {
      if (paramInt == this.length) {
        return new GF2Vector(this);
      }
      GF2Vector localGF2Vector = new GF2Vector(paramInt);
      int i = paramInt >> 5;
      paramInt &= 0x1F;
      System.arraycopy(this.v, 0, localGF2Vector.v, 0, i);
      if (paramInt != 0) {
        localGF2Vector.v[i] = ((1 << paramInt) - 1 & this.v[i]);
      }
      return localGF2Vector;
    }
    throw new ArithmeticException("invalid length");
  }
  
  public GF2Vector extractRightVector(int paramInt)
  {
    if (paramInt <= this.length)
    {
      if (paramInt == this.length) {
        return new GF2Vector(this);
      }
      GF2Vector localGF2Vector = new GF2Vector(paramInt);
      int j = this.length - paramInt >> 5;
      int k = this.length - paramInt & 0x1F;
      int m = paramInt + 31 >> 5;
      int i = 0;
      if (k != 0)
      {
        for (paramInt = j;; paramInt = j)
        {
          j = m - 1;
          if (i >= j) {
            break;
          }
          arrayOfInt1 = localGF2Vector.v;
          arrayOfInt2 = this.v;
          j = paramInt + 1;
          arrayOfInt1[i] = (arrayOfInt2[paramInt] >>> k | arrayOfInt2[j] << 32 - k);
          i += 1;
        }
        int[] arrayOfInt1 = localGF2Vector.v;
        int[] arrayOfInt2 = this.v;
        i = paramInt + 1;
        arrayOfInt2[paramInt] >>>= k;
        if (i < arrayOfInt2.length)
        {
          arrayOfInt1[j] |= arrayOfInt2[i] << 32 - k;
          return localGF2Vector;
        }
      }
      else
      {
        System.arraycopy(this.v, j, localGF2Vector.v, 0, m);
      }
      return localGF2Vector;
    }
    throw new ArithmeticException("invalid length");
  }
  
  public GF2Vector extractVector(int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    if (paramArrayOfInt[(j - 1)] <= this.length)
    {
      GF2Vector localGF2Vector = new GF2Vector(j);
      int i = 0;
      while (i < j)
      {
        if ((this.v[(paramArrayOfInt[i] >> 5)] & 1 << (paramArrayOfInt[i] & 0x1F)) != 0)
        {
          int[] arrayOfInt = localGF2Vector.v;
          int k = i >> 5;
          arrayOfInt[k] = (1 << (i & 0x1F) | arrayOfInt[k]);
        }
        i += 1;
      }
      return localGF2Vector;
    }
    throw new ArithmeticException("invalid index set");
  }
  
  public int getBit(int paramInt)
  {
    if (paramInt < this.length)
    {
      int i = paramInt & 0x1F;
      return (this.v[(paramInt >> 5)] & 1 << i) >>> i;
    }
    throw new IndexOutOfBoundsException();
  }
  
  public byte[] getEncoded()
  {
    int i = this.length;
    return LittleEndianConversions.toByteArray(this.v, i + 7 >> 3);
  }
  
  public int getHammingWeight()
  {
    int i = 0;
    int k = 0;
    for (;;)
    {
      int[] arrayOfInt = this.v;
      if (i >= arrayOfInt.length) {
        break;
      }
      int m = arrayOfInt[i];
      int j = 0;
      while (j < 32)
      {
        int n = k;
        if ((m & 0x1) != 0) {
          n = k + 1;
        }
        m >>>= 1;
        j += 1;
        k = n;
      }
      i += 1;
    }
    return k;
  }
  
  public int[] getVecArray()
  {
    return this.v;
  }
  
  public int hashCode()
  {
    return this.length * 31 + this.v.hashCode();
  }
  
  public boolean isZero()
  {
    int i = this.v.length - 1;
    while (i >= 0)
    {
      if (this.v[i] != 0) {
        return false;
      }
      i -= 1;
    }
    return true;
  }
  
  public Vector multiply(Permutation paramPermutation)
  {
    paramPermutation = paramPermutation.getVector();
    if (this.length == paramPermutation.length)
    {
      GF2Vector localGF2Vector = new GF2Vector(this.length);
      int i = 0;
      while (i < paramPermutation.length)
      {
        if ((this.v[(paramPermutation[i] >> 5)] & 1 << (paramPermutation[i] & 0x1F)) != 0)
        {
          int[] arrayOfInt = localGF2Vector.v;
          int j = i >> 5;
          arrayOfInt[j] = (1 << (i & 0x1F) | arrayOfInt[j]);
        }
        i += 1;
      }
      return localGF2Vector;
    }
    throw new ArithmeticException("length mismatch");
  }
  
  public void setBit(int paramInt)
  {
    if (paramInt < this.length)
    {
      int[] arrayOfInt = this.v;
      int i = paramInt >> 5;
      arrayOfInt[i] = (1 << (paramInt & 0x1F) | arrayOfInt[i]);
      return;
    }
    throw new IndexOutOfBoundsException();
  }
  
  public GF2mVector toExtensionFieldVector(GF2mField paramGF2mField)
  {
    int i = paramGF2mField.getDegree();
    if (this.length % i == 0)
    {
      i = this.length / i;
      int[] arrayOfInt = new int[i];
      int j = 0;
      i -= 1;
      while (i >= 0)
      {
        int k = paramGF2mField.getDegree() - 1;
        while (k >= 0)
        {
          if ((this.v[(j >>> 5)] >>> (j & 0x1F) & 0x1) == 1) {
            arrayOfInt[i] ^= 1 << k;
          }
          j += 1;
          k -= 1;
        }
        i -= 1;
      }
      return new GF2mVector(paramGF2mField, arrayOfInt);
    }
    throw new ArithmeticException("conversion is impossible");
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < this.length)
    {
      if ((i != 0) && ((i & 0x1F) == 0)) {
        localStringBuffer.append(' ');
      }
      char c;
      if ((this.v[(i >> 5)] & 1 << (i & 0x1F)) == 0) {
        c = '0';
      } else {
        c = '1';
      }
      localStringBuffer.append(c);
      i += 1;
    }
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\math\linearalgebra\GF2Vector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */