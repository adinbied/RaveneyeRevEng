package org.bouncycastle.math.ec.endo;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPointMap;
import org.bouncycastle.math.ec.ScaleXPointMap;

public class GLVTypeBEndomorphism
  implements GLVEndomorphism
{
  protected final ECCurve curve;
  protected final GLVTypeBParameters parameters;
  protected final ECPointMap pointMap;
  
  public GLVTypeBEndomorphism(ECCurve paramECCurve, GLVTypeBParameters paramGLVTypeBParameters)
  {
    this.curve = paramECCurve;
    this.parameters = paramGLVTypeBParameters;
    this.pointMap = new ScaleXPointMap(paramECCurve.fromBigInteger(paramGLVTypeBParameters.getBeta()));
  }
  
  protected BigInteger calculateB(BigInteger paramBigInteger1, BigInteger paramBigInteger2, int paramInt)
  {
    int i;
    if (paramBigInteger2.signum() < 0) {
      i = 1;
    } else {
      i = 0;
    }
    paramBigInteger1 = paramBigInteger1.multiply(paramBigInteger2.abs());
    boolean bool = paramBigInteger1.testBit(paramInt - 1);
    paramBigInteger2 = paramBigInteger1.shiftRight(paramInt);
    paramBigInteger1 = paramBigInteger2;
    if (bool) {
      paramBigInteger1 = paramBigInteger2.add(ECConstants.ONE);
    }
    paramBigInteger2 = paramBigInteger1;
    if (i != 0) {
      paramBigInteger2 = paramBigInteger1.negate();
    }
    return paramBigInteger2;
  }
  
  public BigInteger[] decomposeScalar(BigInteger paramBigInteger)
  {
    int i = this.parameters.getBits();
    BigInteger localBigInteger1 = calculateB(paramBigInteger, this.parameters.getG1(), i);
    BigInteger localBigInteger2 = calculateB(paramBigInteger, this.parameters.getG2(), i);
    GLVTypeBParameters localGLVTypeBParameters = this.parameters;
    return new BigInteger[] { paramBigInteger.subtract(localBigInteger1.multiply(localGLVTypeBParameters.getV1A()).add(localBigInteger2.multiply(localGLVTypeBParameters.getV2A()))), localBigInteger1.multiply(localGLVTypeBParameters.getV1B()).add(localBigInteger2.multiply(localGLVTypeBParameters.getV2B())).negate() };
  }
  
  public ECPointMap getPointMap()
  {
    return this.pointMap;
  }
  
  public boolean hasEfficientPointMap()
  {
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\endo\GLVTypeBEndomorphism.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */