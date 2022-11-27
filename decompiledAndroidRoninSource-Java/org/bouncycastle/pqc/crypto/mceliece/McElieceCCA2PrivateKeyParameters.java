package org.bouncycastle.pqc.crypto.mceliece;

import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;
import org.bouncycastle.pqc.math.linearalgebra.GF2mField;
import org.bouncycastle.pqc.math.linearalgebra.GoppaCode;
import org.bouncycastle.pqc.math.linearalgebra.Permutation;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialRingGF2m;

public class McElieceCCA2PrivateKeyParameters
  extends McElieceCCA2KeyParameters
{
  private GF2mField field;
  private PolynomialGF2mSmallM goppaPoly;
  private GF2Matrix h;
  private int k;
  private int n;
  private Permutation p;
  private PolynomialGF2mSmallM[] qInv;
  
  public McElieceCCA2PrivateKeyParameters(int paramInt1, int paramInt2, GF2mField paramGF2mField, PolynomialGF2mSmallM paramPolynomialGF2mSmallM, GF2Matrix paramGF2Matrix, Permutation paramPermutation, String paramString)
  {
    super(true, paramString);
    this.n = paramInt1;
    this.k = paramInt2;
    this.field = paramGF2mField;
    this.goppaPoly = paramPolynomialGF2mSmallM;
    this.h = paramGF2Matrix;
    this.p = paramPermutation;
    this.qInv = new PolynomialRingGF2m(paramGF2mField, paramPolynomialGF2mSmallM).getSquareRootMatrix();
  }
  
  public McElieceCCA2PrivateKeyParameters(int paramInt1, int paramInt2, GF2mField paramGF2mField, PolynomialGF2mSmallM paramPolynomialGF2mSmallM, Permutation paramPermutation, String paramString)
  {
    this(paramInt1, paramInt2, paramGF2mField, paramPolynomialGF2mSmallM, GoppaCode.createCanonicalCheckMatrix(paramGF2mField, paramPolynomialGF2mSmallM), paramPermutation, paramString);
  }
  
  public GF2mField getField()
  {
    return this.field;
  }
  
  public PolynomialGF2mSmallM getGoppaPoly()
  {
    return this.goppaPoly;
  }
  
  public GF2Matrix getH()
  {
    return this.h;
  }
  
  public int getK()
  {
    return this.k;
  }
  
  public int getN()
  {
    return this.n;
  }
  
  public Permutation getP()
  {
    return this.p;
  }
  
  public PolynomialGF2mSmallM[] getQInv()
  {
    return this.qInv;
  }
  
  public int getT()
  {
    return this.goppaPoly.getDegree();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\mceliece\McElieceCCA2PrivateKeyParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */