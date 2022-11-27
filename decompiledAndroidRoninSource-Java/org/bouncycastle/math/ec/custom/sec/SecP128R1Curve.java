package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECCurve.AbstractFp;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.encoders.Hex;

public class SecP128R1Curve
  extends ECCurve.AbstractFp
{
  private static final int SecP128R1_DEFAULT_COORDS = 2;
  public static final BigInteger q = new BigInteger(1, Hex.decode("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFF"));
  protected SecP128R1Point infinity = new SecP128R1Point(this, null, null);
  
  public SecP128R1Curve()
  {
    super(q);
    this.a = fromBigInteger(new BigInteger(1, Hex.decode("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFC")));
    this.b = fromBigInteger(new BigInteger(1, Hex.decode("E87579C11079F43DD824993C2CEE5ED3")));
    this.order = new BigInteger(1, Hex.decode("FFFFFFFE0000000075A30D1B9038A115"));
    this.cofactor = BigInteger.valueOf(1L);
    this.coord = 2;
  }
  
  protected ECCurve cloneCurve()
  {
    return new SecP128R1Curve();
  }
  
  protected ECPoint createRawPoint(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, boolean paramBoolean)
  {
    return new SecP128R1Point(this, paramECFieldElement1, paramECFieldElement2, paramBoolean);
  }
  
  protected ECPoint createRawPoint(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement[] paramArrayOfECFieldElement, boolean paramBoolean)
  {
    return new SecP128R1Point(this, paramECFieldElement1, paramECFieldElement2, paramArrayOfECFieldElement, paramBoolean);
  }
  
  public ECFieldElement fromBigInteger(BigInteger paramBigInteger)
  {
    return new SecP128R1FieldElement(paramBigInteger);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecP128R1Curve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */