package org.bouncycastle.pqc.math.linearalgebra;

public class GF2mVector
  extends Vector
{
  private GF2mField field;
  private int[] vector;
  
  public GF2mVector(GF2mField paramGF2mField, byte[] paramArrayOfByte)
  {
    this.field = new GF2mField(paramGF2mField);
    int i = 8;
    int j = 1;
    while (paramGF2mField.getDegree() > i)
    {
      j += 1;
      i += 8;
    }
    if (paramArrayOfByte.length % j == 0)
    {
      this.length = (paramArrayOfByte.length / j);
      this.vector = new int[this.length];
      j = 0;
      int k = 0;
      while (j < this.vector.length)
      {
        int m = 0;
        while (m < i)
        {
          int[] arrayOfInt = this.vector;
          int n = arrayOfInt[j];
          arrayOfInt[j] = ((paramArrayOfByte[k] & 0xFF) << m | n);
          m += 8;
          k += 1;
        }
        if (paramGF2mField.isElementOfThisField(this.vector[j])) {
          j += 1;
        } else {
          throw new IllegalArgumentException("Byte array is not an encoded vector over the given finite field.");
        }
      }
      return;
    }
    throw new IllegalArgumentException("Byte array is not an encoded vector over the given finite field.");
  }
  
  public GF2mVector(GF2mField paramGF2mField, int[] paramArrayOfInt)
  {
    this.field = paramGF2mField;
    this.length = paramArrayOfInt.length;
    int i = paramArrayOfInt.length - 1;
    while (i >= 0) {
      if (paramGF2mField.isElementOfThisField(paramArrayOfInt[i])) {
        i -= 1;
      } else {
        throw new ArithmeticException("Element array is not specified over the given finite field.");
      }
    }
    this.vector = IntUtils.clone(paramArrayOfInt);
  }
  
  public GF2mVector(GF2mVector paramGF2mVector)
  {
    this.field = new GF2mField(paramGF2mVector.field);
    this.length = paramGF2mVector.length;
    this.vector = IntUtils.clone(paramGF2mVector.vector);
  }
  
  public Vector add(Vector paramVector)
  {
    throw new RuntimeException("not implemented");
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof GF2mVector)) {
      return false;
    }
    paramObject = (GF2mVector)paramObject;
    if (!this.field.equals(((GF2mVector)paramObject).field)) {
      return false;
    }
    return IntUtils.equals(this.vector, ((GF2mVector)paramObject).vector);
  }
  
  public byte[] getEncoded()
  {
    int i = 8;
    int j = 1;
    while (this.field.getDegree() > i)
    {
      j += 1;
      i += 8;
    }
    byte[] arrayOfByte = new byte[this.vector.length * j];
    j = 0;
    int k = 0;
    while (j < this.vector.length)
    {
      int m = 0;
      while (m < i)
      {
        arrayOfByte[k] = ((byte)(this.vector[j] >>> m));
        m += 8;
        k += 1;
      }
      j += 1;
    }
    return arrayOfByte;
  }
  
  public GF2mField getField()
  {
    return this.field;
  }
  
  public int[] getIntArrayForm()
  {
    return IntUtils.clone(this.vector);
  }
  
  public int hashCode()
  {
    return this.field.hashCode() * 31 + this.vector.hashCode();
  }
  
  public boolean isZero()
  {
    int i = this.vector.length - 1;
    while (i >= 0)
    {
      if (this.vector[i] != 0) {
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
      int[] arrayOfInt = new int[this.length];
      int i = 0;
      while (i < paramPermutation.length)
      {
        arrayOfInt[i] = this.vector[paramPermutation[i]];
        i += 1;
      }
      return new GF2mVector(this.field, arrayOfInt);
    }
    throw new ArithmeticException("permutation size and vector size mismatch");
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < this.vector.length)
    {
      int j = 0;
      while (j < this.field.getDegree())
      {
        char c;
        if ((1 << (j & 0x1F) & this.vector[i]) != 0) {
          c = '1';
        } else {
          c = '0';
        }
        localStringBuffer.append(c);
        j += 1;
      }
      localStringBuffer.append(' ');
      i += 1;
    }
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\math\linearalgebra\GF2mVector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */