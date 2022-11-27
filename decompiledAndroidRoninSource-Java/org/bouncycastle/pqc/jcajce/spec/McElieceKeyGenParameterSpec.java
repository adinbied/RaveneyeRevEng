package org.bouncycastle.pqc.jcajce.spec;

import java.security.InvalidParameterException;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialRingGF2;

public class McElieceKeyGenParameterSpec
  implements AlgorithmParameterSpec
{
  public static final int DEFAULT_M = 11;
  public static final int DEFAULT_T = 50;
  private int fieldPoly;
  private int m;
  private int n;
  private int t;
  
  public McElieceKeyGenParameterSpec()
  {
    this(11, 50);
  }
  
  public McElieceKeyGenParameterSpec(int paramInt)
  {
    if (paramInt >= 1)
    {
      this.m = 0;
      this.n = 1;
      for (;;)
      {
        i = this.n;
        if (i >= paramInt) {
          break;
        }
        this.n = (i << 1);
        this.m += 1;
      }
      paramInt = i >>> 1;
      this.t = paramInt;
      int i = this.m;
      this.t = (paramInt / i);
      this.fieldPoly = PolynomialRingGF2.getIrreduciblePolynomial(i);
      return;
    }
    throw new IllegalArgumentException("key size must be positive");
  }
  
  public McElieceKeyGenParameterSpec(int paramInt1, int paramInt2)
    throws InvalidParameterException
  {
    if (paramInt1 >= 1)
    {
      if (paramInt1 <= 32)
      {
        this.m = paramInt1;
        int i = 1 << paramInt1;
        this.n = i;
        if (paramInt2 >= 0)
        {
          if (paramInt2 <= i)
          {
            this.t = paramInt2;
            this.fieldPoly = PolynomialRingGF2.getIrreduciblePolynomial(paramInt1);
            return;
          }
          throw new IllegalArgumentException("t must be less than n = 2^m");
        }
        throw new IllegalArgumentException("t must be positive");
      }
      throw new IllegalArgumentException("m is too large");
    }
    throw new IllegalArgumentException("m must be positive");
  }
  
  public McElieceKeyGenParameterSpec(int paramInt1, int paramInt2, int paramInt3)
  {
    this.m = paramInt1;
    if (paramInt1 >= 1)
    {
      if (paramInt1 <= 32)
      {
        int i = 1 << paramInt1;
        this.n = i;
        this.t = paramInt2;
        if (paramInt2 >= 0)
        {
          if (paramInt2 <= i)
          {
            if ((PolynomialRingGF2.degree(paramInt3) == paramInt1) && (PolynomialRingGF2.isIrreducible(paramInt3)))
            {
              this.fieldPoly = paramInt3;
              return;
            }
            throw new IllegalArgumentException("polynomial is not a field polynomial for GF(2^m)");
          }
          throw new IllegalArgumentException("t must be less than n = 2^m");
        }
        throw new IllegalArgumentException("t must be positive");
      }
      throw new IllegalArgumentException(" m is too large");
    }
    throw new IllegalArgumentException("m must be positive");
  }
  
  public int getFieldPoly()
  {
    return this.fieldPoly;
  }
  
  public int getM()
  {
    return this.m;
  }
  
  public int getN()
  {
    return this.n;
  }
  
  public int getT()
  {
    return this.t;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\jcajce\spec\McElieceKeyGenParameterSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */