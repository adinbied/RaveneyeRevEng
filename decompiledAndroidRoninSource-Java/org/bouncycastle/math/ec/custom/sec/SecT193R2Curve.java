package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECCurve.AbstractF2m;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.encoders.Hex;

public class SecT193R2Curve
  extends ECCurve.AbstractF2m
{
  private static final int SecT193R2_DEFAULT_COORDS = 6;
  protected SecT193R2Point infinity = new SecT193R2Point(this, null, null);
  
  public SecT193R2Curve()
  {
    super(193, 15, 0, 0);
    this.a = fromBigInteger(new BigInteger(1, Hex.decode("0163F35A5137C2CE3EA6ED8667190B0BC43ECD69977702709B")));
    this.b = fromBigInteger(new BigInteger(1, Hex.decode("00C9BB9E8927D4D64C377E2AB2856A5B16E3EFB7F61D4316AE")));
    this.order = new BigInteger(1, Hex.decode("010000000000000000000000015AAB561B005413CCD4EE99D5"));
    this.cofactor = BigInteger.valueOf(2L);
    this.coord = 6;
  }
  
  protected ECCurve cloneCurve()
  {
    return new SecT193R2Curve();
  }
  
  protected ECPoint createRawPoint(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, boolean paramBoolean)
  {
    return new SecT193R2Point(this, paramECFieldElement1, paramECFieldElement2, paramBoolean);
  }
  
  protected ECPoint createRawPoint(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement[] paramArrayOfECFieldElement, boolean paramBoolean)
  {
    return new SecT193R2Point(this, paramECFieldElement1, paramECFieldElement2, paramArrayOfECFieldElement, paramBoolean);
  }
  
  public ECFieldElement fromBigInteger(BigInteger paramBigInteger)
  {
    return new SecT193FieldElement(paramBigInteger);
  }
  
  public int getFieldSize()
  {
    return 193;
  }
  
  public ECPoint getInfinity()
  {
    return this.infinity;
  }
  
  public int getK1()
  {
    return 15;
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
    return 193;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecT193R2Curve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */