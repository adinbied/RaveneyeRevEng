package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECCurve.AbstractF2m;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECMultiplier;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.WTauNafMultiplier;
import org.bouncycastle.util.encoders.Hex;

public class SecT233K1Curve
  extends ECCurve.AbstractF2m
{
  private static final int SecT233K1_DEFAULT_COORDS = 6;
  protected SecT233K1Point infinity = new SecT233K1Point(this, null, null);
  
  public SecT233K1Curve()
  {
    super(233, 74, 0, 0);
    this.a = fromBigInteger(BigInteger.valueOf(0L));
    this.b = fromBigInteger(BigInteger.valueOf(1L));
    this.order = new BigInteger(1, Hex.decode("8000000000000000000000000000069D5BB915BCD46EFB1AD5F173ABDF"));
    this.cofactor = BigInteger.valueOf(4L);
    this.coord = 6;
  }
  
  protected ECCurve cloneCurve()
  {
    return new SecT233K1Curve();
  }
  
  protected ECMultiplier createDefaultMultiplier()
  {
    return new WTauNafMultiplier();
  }
  
  protected ECPoint createRawPoint(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, boolean paramBoolean)
  {
    return new SecT233K1Point(this, paramECFieldElement1, paramECFieldElement2, paramBoolean);
  }
  
  protected ECPoint createRawPoint(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement[] paramArrayOfECFieldElement, boolean paramBoolean)
  {
    return new SecT233K1Point(this, paramECFieldElement1, paramECFieldElement2, paramArrayOfECFieldElement, paramBoolean);
  }
  
  public ECFieldElement fromBigInteger(BigInteger paramBigInteger)
  {
    return new SecT233FieldElement(paramBigInteger);
  }
  
  public int getFieldSize()
  {
    return 233;
  }
  
  public ECPoint getInfinity()
  {
    return this.infinity;
  }
  
  public int getK1()
  {
    return 74;
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
    return 233;
  }
  
  public boolean isKoblitz()
  {
    return true;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecT233K1Curve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */