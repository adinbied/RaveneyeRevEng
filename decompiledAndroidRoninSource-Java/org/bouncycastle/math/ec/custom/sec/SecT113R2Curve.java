package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECCurve.AbstractF2m;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.encoders.Hex;

public class SecT113R2Curve
  extends ECCurve.AbstractF2m
{
  private static final int SecT113R2_DEFAULT_COORDS = 6;
  protected SecT113R2Point infinity = new SecT113R2Point(this, null, null);
  
  public SecT113R2Curve()
  {
    super(113, 9, 0, 0);
    this.a = fromBigInteger(new BigInteger(1, Hex.decode("00689918DBEC7E5A0DD6DFC0AA55C7")));
    this.b = fromBigInteger(new BigInteger(1, Hex.decode("0095E9A9EC9B297BD4BF36E059184F")));
    this.order = new BigInteger(1, Hex.decode("010000000000000108789B2496AF93"));
    this.cofactor = BigInteger.valueOf(2L);
    this.coord = 6;
  }
  
  protected ECCurve cloneCurve()
  {
    return new SecT113R2Curve();
  }
  
  protected ECPoint createRawPoint(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, boolean paramBoolean)
  {
    return new SecT113R2Point(this, paramECFieldElement1, paramECFieldElement2, paramBoolean);
  }
  
  protected ECPoint createRawPoint(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement[] paramArrayOfECFieldElement, boolean paramBoolean)
  {
    return new SecT113R2Point(this, paramECFieldElement1, paramECFieldElement2, paramArrayOfECFieldElement, paramBoolean);
  }
  
  public ECFieldElement fromBigInteger(BigInteger paramBigInteger)
  {
    return new SecT113FieldElement(paramBigInteger);
  }
  
  public int getFieldSize()
  {
    return 113;
  }
  
  public ECPoint getInfinity()
  {
    return this.infinity;
  }
  
  public int getK1()
  {
    return 9;
  }
  
  public int getK2()
  {
    return 0;
  }
  
  public int getK3()
  {
    return 0;
  }
  
  public int getM()
  {
    return 113;
  }
  
  public boolean isKoblitz()
  {
    return false;
  }
  
  public boolean isTrinomial()
  {
    return true;
  }
  
  public boolean supportsCoordinateSystem(int paramInt)
  {
    return paramInt == 6;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecT113R2Curve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */