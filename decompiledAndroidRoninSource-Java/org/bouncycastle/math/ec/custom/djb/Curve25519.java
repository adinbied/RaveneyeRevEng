package org.bouncycastle.math.ec.custom.djb;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECCurve.AbstractFp;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat256;
import org.bouncycastle.util.encoders.Hex;

public class Curve25519
  extends ECCurve.AbstractFp
{
  private static final int Curve25519_DEFAULT_COORDS = 4;
  public static final BigInteger q = Nat256.toBigInteger(Curve25519Field.P);
  protected Curve25519Point infinity = new Curve25519Point(this, null, null);
  
  public Curve25519()
  {
    super(q);
    this.a = fromBigInteger(new BigInteger(1, Hex.decode("2AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA984914A144")));
    this.b = fromBigInteger(new BigInteger(1, Hex.decode("7B425ED097B425ED097B425ED097B425ED097B425ED097B4260B5E9C7710C864")));
    this.order = new BigInteger(1, Hex.decode("1000000000000000000000000000000014DEF9DEA2F79CD65812631A5CF5D3ED"));
    this.cofactor = BigInteger.valueOf(8L);
    this.coord = 4;
  }
  
  protected ECCurve cloneCurve()
  {
    return new Curve25519();
  }
  
  protected ECPoint createRawPoint(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, boolean paramBoolean)
  {
    return new Curve25519Point(this, paramECFieldElement1, paramECFieldElement2, paramBoolean);
  }
  
  protected ECPoint createRawPoint(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement[] paramArrayOfECFieldElement, boolean paramBoolean)
  {
    return new Curve25519Point(this, paramECFieldElement1, paramECFieldElement2, paramArrayOfECFieldElement, paramBoolean);
  }
  
  public ECFieldElement fromBigInteger(BigInteger paramBigInteger)
  {
    return new Curve25519FieldElement(paramBigInteger);
  }
  
  public int getFieldSize()
  {
    return q.bitLength();
  }
  
  public ECPoint getInfinity()
  {
    return this.infinity;
  }
  
  public BigInteger getQ()
  {
    return q;
  }
  
  public boolean supportsCoordinateSystem(int paramInt)
  {
    return paramInt == 4;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\djb\Curve25519.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */