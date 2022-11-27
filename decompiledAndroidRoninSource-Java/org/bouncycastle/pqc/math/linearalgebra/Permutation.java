package org.bouncycastle.pqc.math.linearalgebra;

import java.security.SecureRandom;

public class Permutation
{
  private int[] perm;
  
  public Permutation(int paramInt)
  {
    if (paramInt > 0)
    {
      this.perm = new int[paramInt];
      paramInt -= 1;
      while (paramInt >= 0)
      {
        this.perm[paramInt] = paramInt;
        paramInt -= 1;
      }
      return;
    }
    throw new IllegalArgumentException("invalid length");
  }
  
  public Permutation(int paramInt, SecureRandom paramSecureRandom)
  {
    if (paramInt > 0)
    {
      this.perm = new int[paramInt];
      int[] arrayOfInt = new int[paramInt];
      int k = 0;
      int i = 0;
      while (i < paramInt)
      {
        arrayOfInt[i] = i;
        i += 1;
      }
      int j = paramInt;
      i = k;
      while (i < paramInt)
      {
        k = RandUtils.nextInt(paramSecureRandom, j);
        j -= 1;
        this.perm[i] = arrayOfInt[k];
        arrayOfInt[k] = arrayOfInt[j];
        i += 1;
      }
      return;
    }
    throw new IllegalArgumentException("invalid length");
  }
  
  public Permutation(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length > 4)
    {
      int i = 0;
      int j = LittleEndianConversions.OS2IP(paramArrayOfByte, 0);
      int k = IntegerFunctions.ceilLog256(j - 1);
      if (paramArrayOfByte.length == j * k + 4)
      {
        this.perm = new int[j];
        while (i < j)
        {
          this.perm[i] = LittleEndianConversions.OS2IP(paramArrayOfByte, i * k + 4, k);
          i += 1;
        }
        if (isPermutation(this.perm)) {
          return;
        }
        throw new IllegalArgumentException("invalid encoding");
      }
      throw new IllegalArgumentException("invalid encoding");
    }
    throw new IllegalArgumentException("invalid encoding");
  }
  
  public Permutation(int[] paramArrayOfInt)
  {
    if (isPermutation(paramArrayOfInt))
    {
      this.perm = IntUtils.clone(paramArrayOfInt);
      return;
    }
    throw new IllegalArgumentException("array is not a permutation vector");
  }
  
  private boolean isPermutation(int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    boolean[] arrayOfBoolean = new boolean[j];
    int i = 0;
    while (i < j) {
      if ((paramArrayOfInt[i] >= 0) && (paramArrayOfInt[i] < j))
      {
        if (arrayOfBoolean[paramArrayOfInt[i]] != 0) {
          return false;
        }
        arrayOfBoolean[paramArrayOfInt[i]] = true;
        i += 1;
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public Permutation computeInverse()
  {
    Permutation localPermutation = new Permutation(this.perm.length);
    int i = this.perm.length - 1;
    while (i >= 0)
    {
      localPermutation.perm[this.perm[i]] = i;
      i -= 1;
    }
    return localPermutation;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Permutation)) {
      return false;
    }
    paramObject = (Permutation)paramObject;
    return IntUtils.equals(this.perm, ((Permutation)paramObject).perm);
  }
  
  public byte[] getEncoded()
  {
    int j = this.perm.length;
    int k = IntegerFunctions.ceilLog256(j - 1);
    byte[] arrayOfByte = new byte[j * k + 4];
    int i = 0;
    LittleEndianConversions.I2OSP(j, arrayOfByte, 0);
    while (i < j)
    {
      LittleEndianConversions.I2OSP(this.perm[i], arrayOfByte, i * k + 4, k);
      i += 1;
    }
    return arrayOfByte;
  }
  
  public int[] getVector()
  {
    return IntUtils.clone(this.perm);
  }
  
  public int hashCode()
  {
    return this.perm.hashCode();
  }
  
  public Permutation rightMultiply(Permutation paramPermutation)
  {
    int i = paramPermutation.perm.length;
    Object localObject = this.perm;
    if (i == localObject.length)
    {
      localObject = new Permutation(localObject.length);
      i = this.perm.length - 1;
      while (i >= 0)
      {
        ((Permutation)localObject).perm[i] = this.perm[paramPermutation.perm[i]];
        i -= 1;
      }
      return (Permutation)localObject;
    }
    throw new IllegalArgumentException("length mismatch");
  }
  
  public String toString()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.perm[0]);
    localObject = ((StringBuilder)localObject).toString();
    int i = 1;
    while (i < this.perm.length)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.perm[i]);
      localObject = localStringBuilder.toString();
      i += 1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\math\linearalgebra\Permutation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */