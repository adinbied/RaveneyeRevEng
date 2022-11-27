package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECCurve.AbstractFp;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.encoders.Hex;

public class SecP256K1Curve
  extends ECCurve.AbstractFp
{
  private static final int SECP256K1_DEFAULT_COORDS = 2;
  public static final BigInteger q = new BigInteger(1, Hex.decode("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F"));
  protected SecP256K1Point infinity = new SecP256K1Point(this, null, null);
  
  public SecP256K1Curve()
  {
    super(q);
    this.a = fromBigInteger(ECConstants.ZERO);
    this.b = fromBigInteger(BigInteger.valueOf(7L));
    this.order = new BigInteger(1, Hex.decode("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141"));
    this.cofactor = BigInteger.valueOf(1L);
    this.coord = 2;
  }
  
  protected ECCurve cloneCurve()
  {
    return new SecP256K1Curve();
  }
  
  protected ECPoint createRawPoint(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, boolean paramBoolean)
  {
    return new SecP256K1Point(this, paramECFieldElement1, paramECFieldElement2, paramBoolean);
  }
  
  protected ECPoint createRawPoint(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement[] paramArrayOfECFieldElement, boolean paramBoolean)
  {
    return new SecP256K1Point(this, paramECFieldElement1, paramECFieldElement2, paramArrayOfECFieldElement, paramBoolean);
  }
  
  public ECFieldElement fromBigInteger(BigInteger paramBigInteger)
  {
    return new SecP256K1FieldElement(paramBigInteger);
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
    return paramInt == 2;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecP256K1Curve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */