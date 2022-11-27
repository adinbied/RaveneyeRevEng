package org.bouncycastle.pqc.math.linearalgebra;

import java.security.SecureRandom;
import java.util.Vector;

public abstract class GF2nField
{
  protected GF2Polynomial fieldPolynomial;
  protected Vector fields;
  protected int mDegree;
  protected Vector matrices;
  protected final SecureRandom random;
  
  protected GF2nField(SecureRandom paramSecureRandom)
  {
    this.random = paramSecureRandom;
  }
  
  protected abstract void computeCOBMatrix(GF2nField paramGF2nField);
  
  protected abstract void computeFieldPolynomial();
  
  public final GF2nElement convert(GF2nElement paramGF2nElement, GF2nField paramGF2nField)
    throws RuntimeException
  {
    if (paramGF2nField == this) {}
    while (this.fieldPolynomial.equals(paramGF2nField.fieldPolynomial)) {
      return (GF2nElement)paramGF2nElement.clone();
    }
    if (this.mDegree == paramGF2nField.mDegree)
    {
      int j = this.fields.indexOf(paramGF2nField);
      int i = j;
      if (j == -1)
      {
        computeCOBMatrix(paramGF2nField);
        i = this.fields.indexOf(paramGF2nField);
      }
      GF2Polynomial[] arrayOfGF2Polynomial = (GF2Polynomial[])this.matrices.elementAt(i);
      paramGF2nElement = (GF2nElement)paramGF2nElement.clone();
      if ((paramGF2nElement instanceof GF2nONBElement)) {
        ((GF2nONBElement)paramGF2nElement).reverseOrder();
      }
      paramGF2nElement = new GF2Polynomial(this.mDegree, paramGF2nElement.toFlexiBigInt());
      paramGF2nElement.expandN(this.mDegree);
      GF2Polynomial localGF2Polynomial = new GF2Polynomial(this.mDegree);
      i = 0;
      while (i < this.mDegree)
      {
        if (paramGF2nElement.vectorMult(arrayOfGF2Polynomial[i])) {
          localGF2Polynomial.setBit(this.mDegree - 1 - i);
        }
        i += 1;
      }
      if ((paramGF2nField instanceof GF2nPolynomialField)) {
        return new GF2nPolynomialElement((GF2nPolynomialField)paramGF2nField, localGF2Polynomial);
      }
      if ((paramGF2nField instanceof GF2nONBField))
      {
        paramGF2nElement = new GF2nONBElement((GF2nONBField)paramGF2nField, localGF2Polynomial.toFlexiBigInt());
        paramGF2nElement.reverseOrder();
        return paramGF2nElement;
      }
      throw new RuntimeException("GF2nField.convert: B1 must be an instance of GF2nPolynomialField or GF2nONBField!");
    }
    throw new RuntimeException("GF2nField.convert: B1 has a different degree and thus cannot be coverted to!");
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof GF2nField)) {
        return false;
      }
      paramObject = (GF2nField)paramObject;
      if (((GF2nField)paramObject).mDegree != this.mDegree) {
        return false;
      }
      if (!this.fieldPolynomial.equals(((GF2nField)paramObject).fieldPolynomial)) {
        return false;
      }
      if (((this instanceof GF2nPolynomialField)) && (!(paramObject instanceof GF2nPolynomialField))) {
        return false;
      }
      return (!(this instanceof GF2nONBField)) || ((paramObject instanceof GF2nONBField));
    }
    return false;
  }
  
  public final int getDegree()
  {
    return this.mDegree;
  }
  
  public final GF2Polynomial getFieldPolynomial()
  {
    if (this.fieldPolynomial == null) {
      computeFieldPolynomial();
    }
    return new GF2Polynomial(this.fieldPolynomial);
  }
  
  protected abstract GF2nElement getRandomRoot(GF2Polynomial paramGF2Polynomial);
  
  public int hashCode()
  {
    return this.mDegree + this.fieldPolynomial.hashCode();
  }
  
  protected final GF2Polynomial[] invertMatrix(GF2Polynomial[] paramArrayOfGF2Polynomial)
  {
    GF2Polynomial[] arrayOfGF2Polynomial1 = new GF2Polynomial[paramArrayOfGF2Polynomial.length];
    GF2Polynomial[] arrayOfGF2Polynomial2 = new GF2Polynomial[paramArrayOfGF2Polynomial.length];
    int k = 0;
    int j = 0;
    for (;;)
    {
      i = k;
      if (j >= this.mDegree) {
        break;
      }
      try
      {
        arrayOfGF2Polynomial1[j] = new GF2Polynomial(paramArrayOfGF2Polynomial[j]);
        arrayOfGF2Polynomial2[j] = new GF2Polynomial(this.mDegree);
        arrayOfGF2Polynomial2[j].setBit(this.mDegree - 1 - j);
      }
      catch (RuntimeException localRuntimeException)
      {
        localRuntimeException.printStackTrace();
      }
      j += 1;
    }
    for (;;)
    {
      j = this.mDegree;
      if (i >= j - 1) {
        break label274;
      }
      j = i;
      for (;;)
      {
        k = this.mDegree;
        if ((j >= k) || (arrayOfGF2Polynomial1[j].testBit(k - 1 - i))) {
          break;
        }
        j += 1;
      }
      if (j >= this.mDegree) {
        break;
      }
      if (i != j)
      {
        paramArrayOfGF2Polynomial = arrayOfGF2Polynomial1[i];
        arrayOfGF2Polynomial1[i] = arrayOfGF2Polynomial1[j];
        arrayOfGF2Polynomial1[j] = paramArrayOfGF2Polynomial;
        paramArrayOfGF2Polynomial = arrayOfGF2Polynomial2[i];
        arrayOfGF2Polynomial2[i] = arrayOfGF2Polynomial2[j];
        arrayOfGF2Polynomial2[j] = paramArrayOfGF2Polynomial;
      }
      j = i + 1;
      k = j;
      for (;;)
      {
        int m = this.mDegree;
        if (k >= m) {
          break;
        }
        if (arrayOfGF2Polynomial1[k].testBit(m - 1 - i))
        {
          arrayOfGF2Polynomial1[k].addToThis(arrayOfGF2Polynomial1[i]);
          arrayOfGF2Polynomial2[k].addToThis(arrayOfGF2Polynomial2[i]);
        }
        k += 1;
      }
      i = j;
    }
    throw new RuntimeException("GF2nField.invertMatrix: Matrix cannot be inverted!");
    label274:
    int i = j - 1;
    while (i > 0)
    {
      j = i - 1;
      while (j >= 0)
      {
        if (arrayOfGF2Polynomial1[j].testBit(this.mDegree - 1 - i))
        {
          arrayOfGF2Polynomial1[j].addToThis(arrayOfGF2Polynomial1[i]);
          arrayOfGF2Polynomial2[j].addToThis(arrayOfGF2Polynomial2[i]);
        }
        j -= 1;
      }
      i -= 1;
    }
    return arrayOfGF2Polynomial2;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\math\linearalgebra\GF2nField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */