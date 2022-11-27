package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECCurve.AbstractF2m;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.encoders.Hex;

public class SecT163R1Curve
  extends ECCurve.AbstractF2m
{
  private static final int SecT163R1_DEFAULT_COORDS = 6;
  protected SecT163R1Point infinity = new SecT163R1Point(this, null, null);
  
  public SecT163R1Curve()
  {
    super(163, 3, 6, 7);
    this.a = fromBigInteger(new BigInteger(1, Hex.decode("07B6882CAAEFA84F9554FF8428BD88E246D2782AE2")));
    this.b = fromBigInteger(new BigInteger(1, Hex.decode("0713612DCDDCB40AAB946BDA29CA91F73AF958AFD9")));
    this.order = new BigInteger(1, Hex.decode("03FFFFFFFFFFFFFFFFFFFF48AAB689C29CA710279B"));
    this.cofactor = BigInteger.valueOf(2L);
    this.coord = 6;
  }
  
  protected ECCurve cloneCurve()
  {
    return new SecT163R1Curve();
  }
  
  protected ECPoint createRawPoint(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, boolean paramBoolean)
  {
    return new SecT163R1Point(this, paramECFieldElement1, paramECFieldElement2, paramBoolean);
  }
  
  protected ECPoint createRawPoint(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement[] paramArrayOfECFieldElement, boolean paramBoolean)
  {
    return new SecT163R1Point(this, paramECFieldElement1, paramECFieldElement2, paramArrayOfECFieldElement, paramBoolean);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecT163R1Curve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */