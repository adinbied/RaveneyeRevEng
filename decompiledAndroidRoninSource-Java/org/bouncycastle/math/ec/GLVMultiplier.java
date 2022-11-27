package org.bouncycastle.math.ec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.endo.GLVEndomorphism;

public class GLVMultiplier
  extends AbstractECMultiplier
{
  protected final ECCurve curve;
  protected final GLVEndomorphism glvEndomorphism;
  
  public GLVMultiplier(ECCurve paramECCurve, GLVEndomorphism paramGLVEndomorphism)
  {
    if ((paramECCurve != null) && (paramECCurve.getOrder() != null))
    {
      this.curve = paramECCurve;
      this.glvEndomorphism = paramGLVEndomorphism;
      return;
    }
    throw new IllegalArgumentException("Need curve with known group order");
  }
  
  protected ECPoint multiplyPositive(ECPoint paramECPoint, BigInteger paramBigInteger)
  {
    if (this.curve.equals(paramECPoint.getCurve()))
    {
      Object localObject = paramECPoint.getCurve().getOrder();
      localObject = this.glvEndomorphism.decomposeScalar(paramBigInteger.mod((BigInteger)localObject));
      paramBigInteger = localObject[0];
      localObject = localObject[1];
      ECPointMap localECPointMap = this.glvEndomorphism.getPointMap();
      if (this.glvEndomorphism.hasEfficientPointMap()) {
        return ECAlgorithms.implShamirsTrickWNaf(paramECPoint, paramBigInteger, localECPointMap, (BigInteger)localObject);
      }
      return ECAlgorithms.implShamirsTrickWNaf(paramECPoint, paramBigInteger, localECPointMap.map(paramECPoint), (BigInteger)localObject);
    }
    throw new IllegalStateException();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\GLVMultiplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */