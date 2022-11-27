package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECCurve.AbstractF2m;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.encoders.Hex;

public class SecT283R1Curve
  extends ECCurve.AbstractF2m
{
  private static final int SecT283R1_DEFAULT_COORDS = 6;
  protected SecT283R1Point infinity = new SecT283R1Point(this, null, null);
  
  public SecT283R1Curve()
  {
    super(283, 5, 7, 12);
    this.a = fromBigInteger(BigInteger.valueOf(1L));
    this.b = fromBigInteger(new BigInteger(1, Hex.decode("027B680AC8B8596DA5A4AF8A19A0303FCA97FD7645309FA2A581485AF6263E313B79A2F5")));
    this.order = new BigInteger(1, Hex.decode("03FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEF90399660FC938A90165B042A7CEFADB307"));
    this.cofactor = BigInteger.valueOf(2L);
    this.coord = 6;
  }
  
  protected ECCurve cloneCurve()
  {
    return new SecT283R1Curve();
  }
  
  protected ECPoint createRawPoint(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, boolean paramBoolean)
  {
    return new SecT283R1Point(this, paramECFieldElement1, paramECFieldElement2, paramBoolean);
  }
  
  protected ECPoint createRawPoint(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement[] paramArrayOfECFieldElement, boolean paramBoolean)
  {
    return new SecT283R1Point(this, paramECFieldElement1, paramECFieldElement2, paramArrayOfECFieldElement, paramBoolean);
  }
  
  public ECFieldElement fromBigInteger(BigInteger paramBigInteger)
  {
    return new SecT283FieldElement(paramBigInteger);
  }
  
  public int getFieldSize()
  {
    return 283;
  }
  
  public ECPoint getInfinity()
  {
    return this.infinity;
  }
  
  public int getK1()
  {
    return 5;
  }
  
  public int getK2()
  {
    return 7;
  }
  
  public int getK3()
  {
    return 12;
  }
  
  public int getM()
  {
    return 283;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecT283R1Curve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */