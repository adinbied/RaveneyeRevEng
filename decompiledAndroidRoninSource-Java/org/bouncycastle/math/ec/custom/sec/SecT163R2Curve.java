package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECCurve.AbstractF2m;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.encoders.Hex;

public class SecT163R2Curve
  extends ECCurve.AbstractF2m
{
  private static final int SecT163R2_DEFAULT_COORDS = 6;
  protected SecT163R2Point infinity = new SecT163R2Point(this, null, null);
  
  public SecT163R2Curve()
  {
    super(163, 3, 6, 7);
    this.a = fromBigInteger(BigInteger.valueOf(1L));
    this.b = fromBigInteger(new BigInteger(1, Hex.decode("020A601907B8C953CA1481EB10512F78744A3205FD")));
    this.order = new BigInteger(1, Hex.decode("040000000000000000000292FE77E70C12A4234C33"));
    this.cofactor = BigInteger.valueOf(2L);
    this.coord = 6;
  }
  
  protected ECCurve cloneCurve()
  {
    return new SecT163R2Curve();
  }
  
  protected ECPoint createRawPoint(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, boolean paramBoolean)
  {
    return new SecT163R2Point(this, paramECFieldElement1, paramECFieldElement2, paramBoolean);
  }
  
  protected ECPoint createRawPoint(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement[] paramArrayOfECFieldElement, boolean paramBoolean)
  {
    return new SecT163R2Point(this, paramECFieldElement1, paramECFieldElement2, paramArrayOfECFieldElement, paramBoolean);
  }
  
  public ECFieldElement fromBigInteger(BigInteger paramBigInteger)
  {
    return new SecT163FieldElement(paramBigInteger);
  }
  
  public int getFieldSize()
  {
    return 163;
  }
  
  public ECPoint getInfinity()
  {
    return this.infinity;
  }
  
  public int getK1()
  {
    return 3;
  }
  
  public int getK2()
  {
    return 6;
  }
  
  public int getK3()
  {
    return 7;
  }
  
  public int getM()
  {
    return 163;
  }
  
  public boolean isKoblitz()
  {
    return false;
  }
  
  public boolean isTrinomial()
  {
    return false;
  }
  
  public boolean supportsCoordinateSystem(int paramInt)
  {
    return paramInt == 6;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecT163R2Curve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */