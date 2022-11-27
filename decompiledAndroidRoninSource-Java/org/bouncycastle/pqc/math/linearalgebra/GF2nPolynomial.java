package org.bouncycastle.pqc.math.linearalgebra;

public class GF2nPolynomial
{
  private GF2nElement[] coeff;
  private int size;
  
  private GF2nPolynomial(int paramInt)
  {
    this.size = paramInt;
    this.coeff = new GF2nElement[paramInt];
  }
  
  public GF2nPolynomial(int paramInt, GF2nElement paramGF2nElement)
  {
    this.size = paramInt;
    this.coeff = new GF2nElement[paramInt];
    paramInt = 0;
    while (paramInt < this.size)
    {
      this.coeff[paramInt] = ((GF2nElement)paramGF2nElement.clone());
      paramInt += 1;
    }
  }
  
  public GF2nPolynomial(GF2Polynomial paramGF2Polynomial, GF2nField paramGF2nField)
  {
    int i = paramGF2nField.getDegree() + 1;
    this.size = i;
    this.coeff = new GF2nElement[i];
    boolean bool = paramGF2nField instanceof GF2nONBField;
    int j = 0;
    i = 0;
    if (bool) {
      while (i < this.size)
      {
        if (paramGF2Polynomial.testBit(i)) {
          this.coeff[i] = GF2nONBElement.ONE((GF2nONBField)paramGF2nField);
        } else {
          this.coeff[i] = GF2nONBElement.ZERO((GF2nONBField)paramGF2nField);
        }
        i += 1;
      }
    }
    if ((paramGF2nField instanceof GF2nPolynomialField))
    {
      i = j;
      while (i < this.size)
      {
        if (paramGF2Polynomial.testBit(i)) {
          this.coeff[i] = GF2nPolynomialElement.ONE((GF2nPolynomialField)paramGF2nField);
        } else {
          this.coeff[i] = GF2nPolynomialElement.ZERO((GF2nPolynomialField)paramGF2nField);
        }
        i += 1;
      }
      return;
    }
    throw new IllegalArgumentException("PolynomialGF2n(Bitstring, GF2nField): B1 must be an instance of GF2nONBField or GF2nPolynomialField!");
  }
  
  public GF2nPolynomial(GF2nPolynomial paramGF2nPolynomial)
  {
    int i = paramGF2nPolynomial.size;
    this.coeff = new GF2nElement[i];
    this.size = i;
    i = 0;
    while (i < this.size)
    {
      this.coeff[i] = ((GF2nElement)paramGF2nPolynomial.coeff[i].clone());
      i += 1;
    }
  }
  
  public final GF2nPolynomial add(GF2nPolynomial paramGF2nPolynomial)
    throws RuntimeException
  {
    int k = size();
    int m = paramGF2nPolynomial.size();
    int j = 0;
    int i = 0;
    GF2nPolynomial localGF2nPolynomial1;
    if (k >= m)
    {
      localGF2nPolynomial2 = new GF2nPolynomial(size());
      for (;;)
      {
        j = i;
        if (i >= paramGF2nPolynomial.size()) {
          break;
        }
        localGF2nPolynomial2.coeff[i] = ((GF2nElement)this.coeff[i].add(paramGF2nPolynomial.coeff[i]));
        i += 1;
      }
      for (;;)
      {
        localGF2nPolynomial1 = localGF2nPolynomial2;
        if (j >= size()) {
          break;
        }
        localGF2nPolynomial2.coeff[j] = this.coeff[j];
        j += 1;
      }
    }
    GF2nPolynomial localGF2nPolynomial2 = new GF2nPolynomial(paramGF2nPolynomial.size());
    i = j;
    for (;;)
    {
      j = i;
      if (i >= size()) {
        break;
      }
      localGF2nPolynomial2.coeff[i] = ((GF2nElement)this.coeff[i].add(paramGF2nPolynomial.coeff[i]));
      i += 1;
    }
    for (;;)
    {
      localGF2nPolynomial1 = localGF2nPolynomial2;
      if (j >= paramGF2nPolynomial.size()) {
        break;
      }
      localGF2nPolynomial2.coeff[j] = paramGF2nPolynomial.coeff[j];
      j += 1;
    }
    return localGF2nPolynomial1;
  }
  
  public final void assignZeroToElements()
  {
    int i = 0;
    while (i < this.size)
    {
      this.coeff[i].assignZero();
      i += 1;
    }
  }
  
  public final GF2nElement at(int paramInt)
  {
    return this.coeff[paramInt];
  }
  
  public final GF2nPolynomial[] divide(GF2nPolynomial paramGF2nPolynomial)
    throws RuntimeException, ArithmeticException
  {
    GF2nPolynomial[] arrayOfGF2nPolynomial = new GF2nPolynomial[2];
    GF2nPolynomial localGF2nPolynomial1 = new GF2nPolynomial(this);
    localGF2nPolynomial1.shrink();
    int i = paramGF2nPolynomial.getDegree();
    GF2nElement localGF2nElement1 = (GF2nElement)paramGF2nPolynomial.coeff[i].invert();
    if (localGF2nPolynomial1.getDegree() < i)
    {
      arrayOfGF2nPolynomial[0] = new GF2nPolynomial(this);
      arrayOfGF2nPolynomial[0].assignZeroToElements();
      arrayOfGF2nPolynomial[0].shrink();
      arrayOfGF2nPolynomial[1] = new GF2nPolynomial(this);
    }
    for (paramGF2nPolynomial = arrayOfGF2nPolynomial[1];; paramGF2nPolynomial = arrayOfGF2nPolynomial[0])
    {
      paramGF2nPolynomial.shrink();
      return arrayOfGF2nPolynomial;
      arrayOfGF2nPolynomial[0] = new GF2nPolynomial(this);
      arrayOfGF2nPolynomial[0].assignZeroToElements();
      for (;;)
      {
        int j = localGF2nPolynomial1.getDegree() - i;
        if (j < 0) {
          break;
        }
        GF2nElement localGF2nElement2 = (GF2nElement)localGF2nPolynomial1.coeff[localGF2nPolynomial1.getDegree()].multiply(localGF2nElement1);
        GF2nPolynomial localGF2nPolynomial2 = paramGF2nPolynomial.scalarMultiply(localGF2nElement2);
        localGF2nPolynomial2.shiftThisLeft(j);
        localGF2nPolynomial1 = localGF2nPolynomial1.add(localGF2nPolynomial2);
        localGF2nPolynomial1.shrink();
        arrayOfGF2nPolynomial[0].coeff[j] = ((GF2nElement)localGF2nElement2.clone());
      }
      arrayOfGF2nPolynomial[1] = localGF2nPolynomial1;
    }
  }
  
  public final void enlarge(int paramInt)
  {
    int i = this.size;
    if (paramInt <= i) {
      return;
    }
    GF2nElement[] arrayOfGF2nElement1 = new GF2nElement[paramInt];
    System.arraycopy(this.coeff, 0, arrayOfGF2nElement1, 0, i);
    GF2nField localGF2nField = this.coeff[0].getField();
    GF2nElement[] arrayOfGF2nElement2 = this.coeff;
    if ((arrayOfGF2nElement2[0] instanceof GF2nPolynomialElement))
    {
      i = this.size;
      while (i < paramInt)
      {
        arrayOfGF2nElement1[i] = GF2nPolynomialElement.ZERO((GF2nPolynomialField)localGF2nField);
        i += 1;
      }
    }
    if ((arrayOfGF2nElement2[0] instanceof GF2nONBElement))
    {
      i = this.size;
      while (i < paramInt)
      {
        arrayOfGF2nElement1[i] = GF2nONBElement.ZERO((GF2nONBField)localGF2nField);
        i += 1;
      }
    }
    this.size = paramInt;
    this.coeff = arrayOfGF2nElement1;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof GF2nPolynomial)) {
        return false;
      }
      paramObject = (GF2nPolynomial)paramObject;
      if (getDegree() != ((GF2nPolynomial)paramObject).getDegree()) {
        return false;
      }
      int i = 0;
      while (i < this.size)
      {
        if (!this.coeff[i].equals(paramObject.coeff[i])) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public final GF2nPolynomial gcd(GF2nPolynomial paramGF2nPolynomial)
    throws RuntimeException, ArithmeticException
  {
    GF2nPolynomial localGF2nPolynomial1 = new GF2nPolynomial(this);
    paramGF2nPolynomial = new GF2nPolynomial(paramGF2nPolynomial);
    localGF2nPolynomial1.shrink();
    paramGF2nPolynomial.shrink();
    while (!paramGF2nPolynomial.isZero())
    {
      GF2nPolynomial localGF2nPolynomial2 = localGF2nPolynomial1.remainder(paramGF2nPolynomial);
      localGF2nPolynomial1 = paramGF2nPolynomial;
      paramGF2nPolynomial = localGF2nPolynomial2;
    }
    return localGF2nPolynomial1.scalarMultiply((GF2nElement)localGF2nPolynomial1.coeff[localGF2nPolynomial1.getDegree()].invert());
  }
  
  public final int getDegree()
  {
    int i = this.size - 1;
    while (i >= 0)
    {
      if (!this.coeff[i].isZero()) {
        return i;
      }
      i -= 1;
    }
    return -1;
  }
  
  public int hashCode()
  {
    return getDegree() + this.coeff.hashCode();
  }
  
  public final boolean isZero()
  {
    int i = 0;
    while (i < this.size)
    {
      GF2nElement[] arrayOfGF2nElement = this.coeff;
      if ((arrayOfGF2nElement[i] != null) && (!arrayOfGF2nElement[i].isZero())) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public final GF2nPolynomial multiply(GF2nPolynomial paramGF2nPolynomial)
    throws RuntimeException
  {
    int i = size();
    if (i == paramGF2nPolynomial.size())
    {
      GF2nPolynomial localGF2nPolynomial = new GF2nPolynomial((i << 1) - 1);
      i = 0;
      while (i < size())
      {
        int j = 0;
        while (j < paramGF2nPolynomial.size())
        {
          GF2nElement[] arrayOfGF2nElement = localGF2nPolynomial.coeff;
          int k = i + j;
          if (arrayOfGF2nElement[k] == null) {
            arrayOfGF2nElement[k] = ((GF2nElement)this.coeff[i].multiply(paramGF2nPolynomial.coeff[j]));
          } else {
            arrayOfGF2nElement[k] = ((GF2nElement)arrayOfGF2nElement[k].add(this.coeff[i].multiply(paramGF2nPolynomial.coeff[j])));
          }
          j += 1;
        }
        i += 1;
      }
      return localGF2nPolynomial;
    }
    throw new IllegalArgumentException("PolynomialGF2n.multiply: this and b must have the same size!");
  }
  
  public final GF2nPolynomial multiplyAndReduce(GF2nPolynomial paramGF2nPolynomial1, GF2nPolynomial paramGF2nPolynomial2)
    throws RuntimeException, ArithmeticException
  {
    return multiply(paramGF2nPolynomial1).reduce(paramGF2nPolynomial2);
  }
  
  public final GF2nPolynomial quotient(GF2nPolynomial paramGF2nPolynomial)
    throws RuntimeException, ArithmeticException
  {
    return divide(paramGF2nPolynomial)[0];
  }
  
  public final GF2nPolynomial reduce(GF2nPolynomial paramGF2nPolynomial)
    throws RuntimeException, ArithmeticException
  {
    return remainder(paramGF2nPolynomial);
  }
  
  public final GF2nPolynomial remainder(GF2nPolynomial paramGF2nPolynomial)
    throws RuntimeException, ArithmeticException
  {
    return divide(paramGF2nPolynomial)[1];
  }
  
  public final GF2nPolynomial scalarMultiply(GF2nElement paramGF2nElement)
    throws RuntimeException
  {
    GF2nPolynomial localGF2nPolynomial = new GF2nPolynomial(size());
    int i = 0;
    while (i < size())
    {
      localGF2nPolynomial.coeff[i] = ((GF2nElement)this.coeff[i].multiply(paramGF2nElement));
      i += 1;
    }
    return localGF2nPolynomial;
  }
  
  public final void set(int paramInt, GF2nElement paramGF2nElement)
  {
    if ((!(paramGF2nElement instanceof GF2nPolynomialElement)) && (!(paramGF2nElement instanceof GF2nONBElement))) {
      throw new IllegalArgumentException("PolynomialGF2n.set f must be an instance of either GF2nPolynomialElement or GF2nONBElement!");
    }
    this.coeff[paramInt] = ((GF2nElement)paramGF2nElement.clone());
  }
  
  public final GF2nPolynomial shiftLeft(int paramInt)
  {
    if (paramInt <= 0) {
      return new GF2nPolynomial(this);
    }
    int j = this.size;
    Object localObject = this.coeff;
    int i = 0;
    localObject = new GF2nPolynomial(j + paramInt, localObject[0]);
    ((GF2nPolynomial)localObject).assignZeroToElements();
    while (i < this.size)
    {
      ((GF2nPolynomial)localObject).coeff[(i + paramInt)] = this.coeff[i];
      i += 1;
    }
    return (GF2nPolynomial)localObject;
  }
  
  public final void shiftThisLeft(int paramInt)
  {
    if (paramInt > 0)
    {
      int i = this.size;
      GF2nField localGF2nField = this.coeff[0].getField();
      enlarge(this.size + paramInt);
      i -= 1;
      while (i >= 0)
      {
        arrayOfGF2nElement = this.coeff;
        arrayOfGF2nElement[(i + paramInt)] = arrayOfGF2nElement[i];
        i -= 1;
      }
      GF2nElement[] arrayOfGF2nElement = this.coeff;
      if ((arrayOfGF2nElement[0] instanceof GF2nPolynomialElement))
      {
        paramInt -= 1;
        while (paramInt >= 0)
        {
          this.coeff[paramInt] = GF2nPolynomialElement.ZERO((GF2nPolynomialField)localGF2nField);
          paramInt -= 1;
        }
      }
      if ((arrayOfGF2nElement[0] instanceof GF2nONBElement))
      {
        paramInt -= 1;
        while (paramInt >= 0)
        {
          this.coeff[paramInt] = GF2nONBElement.ZERO((GF2nONBField)localGF2nField);
          paramInt -= 1;
        }
      }
    }
  }
  
  public final void shrink()
  {
    int i = this.size - 1;
    while ((this.coeff[i].isZero()) && (i > 0)) {
      i -= 1;
    }
    i += 1;
    if (i < this.size)
    {
      GF2nElement[] arrayOfGF2nElement = new GF2nElement[i];
      System.arraycopy(this.coeff, 0, arrayOfGF2nElement, 0, i);
      this.coeff = arrayOfGF2nElement;
      this.size = i;
    }
  }
  
  public final int size()
  {
    return this.size;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\math\linearalgebra\GF2nPolynomial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */