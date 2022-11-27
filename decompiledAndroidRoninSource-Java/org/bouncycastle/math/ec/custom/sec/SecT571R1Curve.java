package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECCurve.AbstractF2m;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.encoders.Hex;

public class SecT571R1Curve
  extends ECCurve.AbstractF2m
{
  static final SecT571FieldElement SecT571R1_B;
  static final SecT571FieldElement SecT571R1_B_SQRT;
  private static final int SecT571R1_DEFAULT_COORDS = 6;
  protected SecT571R1Point infinity = new SecT571R1Point(this, null, null);
  
  static
  {
    SecT571FieldElement localSecT571FieldElement = new SecT571FieldElement(new BigInteger(1, Hex.decode("02F40E7E2221F295DE297117B7F3D62F5C6A97FFCB8CEFF1CD6BA8CE4A9A18AD84FFABBD8EFA59332BE7AD6756A66E294AFD185A78FF12AA520E4DE739BACA0C7FFEFF7F2955727A")));
    SecT571R1_B = localSecT571FieldElement;
    SecT571R1_B_SQRT = (SecT571FieldElement)localSecT571FieldElement.sqrt();
  }
  
  public SecT571R1Curve()
  {
    super(571, 2, 5, 10);
    this.a = fromBigInteger(BigInteger.valueOf(1L));
    this.b = SecT571R1_B;
    this.order = new BigInteger(1, Hex.decode("03FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE661CE18FF55987308059B186823851EC7DD9CA1161DE93D5174D66E8382E9BB2FE84E47"));
    this.cofactor = BigInteger.valueOf(2L);
    this.coord = 6;
  }
  
  protected ECCurve cloneCurve()
  {
    return new SecT571R1Curve();
  }
  
  protected ECPoint createRawPoint(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, boolean paramBoolean)
  {
    return new SecT571R1Point(this, paramECFieldElement1, paramECFieldElement2, paramBoolean);
  }
  
  protected ECPoint createRawPoint(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement[] paramArrayOfECFieldElement, boolean paramBoolean)
  {
    return new SecT571R1Point(this, paramECFieldElement1, paramECFieldElement2, paramArrayOfECFieldElement, paramBoolean);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecT571R1Curve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */