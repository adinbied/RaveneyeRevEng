package org.bouncycastle.pqc.crypto.mceliece;

import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;
import org.bouncycastle.pqc.math.linearalgebra.GF2mField;
import org.bouncycastle.pqc.math.linearalgebra.GoppaCode;
import org.bouncycastle.pqc.math.linearalgebra.Permutation;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialRingGF2m;

public class McEliecePrivateKeyParameters
  extends McElieceKeyParameters
{
  private GF2mField field;
  private PolynomialGF2mSmallM goppaPoly;
  private GF2Matrix h;
  private int k;
  private int n;
  private String oid;
  private Permutation p1;
  private Permutation p2;
  private PolynomialGF2mSmallM[] qInv;
  private GF2Matrix sInv;
  
  public McEliecePrivateKeyParameters(int paramInt1, int paramInt2, GF2mField paramGF2mField, PolynomialGF2mSmallM paramPolynomialGF2mSmallM, Permutation paramPermutation1, Permutation paramPermutation2, GF2Matrix paramGF2Matrix)
  {
    super(true, null);
    this.k = paramInt2;
    this.n = paramInt1;
    this.field = paramGF2mField;
    this.goppaPoly = paramPolynomialGF2mSmallM;
    this.sInv = paramGF2Matrix;
    this.p1 = paramPermutation1;
    this.p2 = paramPermutation2;
    this.h = GoppaCode.createCanonicalCheckMatrix(paramGF2mField, paramPolynomialGF2mSmallM);
    this.qInv = new PolynomialRingGF2m(paramGF2mField, paramPolynomialGF2mSmallM).getSquareRootMatrix();
  }
  
  public McEliecePrivateKeyParameters(int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[][] paramArrayOfByte)
  {
    super(true, null);
    this.n = paramInt1;
    this.k = paramInt2;
    paramArrayOfByte1 = new GF2mField(paramArrayOfByte1);
    this.field = paramArrayOfByte1;
    this.goppaPoly = new PolynomialGF2mSmallM(paramArrayOfByte1, paramArrayOfByte2);
    this.sInv = new GF2Matrix(paramArrayOfByte3);
    this.p1 = new Permutation(paramArrayOfByte4);
    this.p2 = new Permutation(paramArrayOfByte5);
    this.h = new GF2Matrix(paramArrayOfByte6);
    this.qInv = new PolynomialGF2mSmallM[paramArrayOfByte.length];
    paramInt1 = 0;
    while (paramInt1 < paramArrayOfByte.length)
    {
      this.qInv[paramInt1] = new PolynomialGF2mSmallM(this.field, paramArrayOfByte[paramInt1]);
      paramInt1 += 1;
    }
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
  
  public Permutation getP1()
  {
    return this.p1;
  }
  
  public Permutation getP2()
  {
    return this.p2;
  }
  
  public PolynomialGF2mSmallM[] getQInv()
  {
    return this.qInv;
  }
  
  public GF2Matrix getSInv()
  {
    return this.sInv;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\mceliece\McEliecePrivateKeyParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */