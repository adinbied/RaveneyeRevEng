package org.bouncycastle.pqc.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialRingGF2;

public class McElieceCCA2KeyGenParameterSpec
  implements AlgorithmParameterSpec
{
  public static final int DEFAULT_M = 11;
  public static final int DEFAULT_T = 50;
  public static final String SHA1 = "SHA-1";
  public static final String SHA224 = "SHA-224";
  public static final String SHA256 = "SHA-256";
  public static final String SHA384 = "SHA-384";
  public static final String SHA512 = "SHA-512";
  private final String digest;
  private int fieldPoly;
  private final int m;
  private final int n;
  private final int t;
  
  public McElieceCCA2KeyGenParameterSpec()
  {
    this(11, 50, "SHA-256");
  }
  
  public McElieceCCA2KeyGenParameterSpec(int paramInt)
  {
    this(paramInt, "SHA-256");
  }
  
  public McElieceCCA2KeyGenParameterSpec(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, "SHA-256");
  }
  
  public McElieceCCA2KeyGenParameterSpec(int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramInt1, paramInt2, paramInt3, "SHA-256");
  }
  
  public McElieceCCA2KeyGenParameterSpec(int paramInt1, int paramInt2, int paramInt3, String paramString)
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
              this.digest = paramString;
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
  
  public McElieceCCA2KeyGenParameterSpec(int paramInt1, int paramInt2, String paramString)
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
            this.digest = paramString;
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
  
  public McElieceCCA2KeyGenParameterSpec(int paramInt, String paramString)
  {
    int j = 1;
    if (paramInt >= 1)
    {
      int i = 0;
      while (j < paramInt)
      {
        j <<= 1;
        i += 1;
      }
      this.t = ((j >>> 1) / i);
      this.m = i;
      this.n = j;
      this.fieldPoly = PolynomialRingGF2.getIrreduciblePolynomial(i);
      this.digest = paramString;
      return;
    }
    throw new IllegalArgumentException("key size must be positive");
  }
  
  public String getDigest()
  {
    return this.digest;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\jcajce\spec\McElieceCCA2KeyGenParameterSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */