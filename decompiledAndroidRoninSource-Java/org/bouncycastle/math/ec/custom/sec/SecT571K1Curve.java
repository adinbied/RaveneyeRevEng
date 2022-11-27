package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECCurve.AbstractF2m;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECMultiplier;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.WTauNafMultiplier;
import org.bouncycastle.util.encoders.Hex;

public class SecT571K1Curve
  extends ECCurve.AbstractF2m
{
  private static final int SecT571K1_DEFAULT_COORDS = 6;
  protected SecT571K1Point infinity = new SecT571K1Point(this, null, null);
  
  public SecT571K1Curve()
  {
    super(571, 2, 5, 10);
    this.a = fromBigInteger(BigInteger.valueOf(0L));
    this.b = fromBigInteger(BigInteger.valueOf(1L));
    this.order = new BigInteger(1, Hex.decode("020000000000000000000000000000000000000000000000000000000000000000000000131850E1F19A63E4B391A8DB917F4138B630D84BE5D639381E91DEB45CFE778F637C1001"));
    this.cofactor = BigInteger.valueOf(4L);
    this.coord = 6;
  }
  
  protected ECCurve cloneCurve()
  {
    return new SecT571K1Curve();
  }
  
  protected ECMultiplier createDefaultMultiplier()
  {
    return new WTauNafMultiplier();
  }
  
  protected ECPoint createRawPoint(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, boolean paramBoolean)
  {
    return new SecT571K1Point(this, paramECFieldElement1, paramECFieldElement2, paramBoolean);
  }
  
  protected ECPoint createRawPoint(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement[] paramArrayOfECFieldElement, boolean paramBoolean)
  {
    return new SecT571K1Point(this, paramECFieldElement1, paramECFieldElement2, paramArrayOfECFieldElement, paramBoolean);
  }
  
  public ECFieldElement fromBigInteger(BigInteger paramBigInteger)
  {
    return new SecT571FieldElement(paramBigInteger);
  }
  
  public int getFieldSize()
  {
    return 571;
  }
  
  public ECPoint getInfinity()
  {
    return this.infinity;
  }
  
  public int getK1()
  {
    return 2;
  }
  
  public int getK2()
  {
    return 5;
  }
  
  public int getK3()
  {
    return 10;
  }
  
  public int getM()
  {
    return 571;
  }
  
  public boolean isKoblitz()
  {
    return true;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecT571K1Curve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */