package org.bouncycastle.crypto.ec;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECMultiplier;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.FixedPointCombMultiplier;

public class ECFixedTransform
  implements ECPairFactorTransform
{
  private BigInteger k;
  private ECPublicKeyParameters key;
  
  public ECFixedTransform(BigInteger paramBigInteger)
  {
    this.k = paramBigInteger;
  }
  
  protected ECMultiplier createBasePointMultiplier()
  {
    return new FixedPointCombMultiplier();
  }
  
  public BigInteger getTransformValue()
  {
    return this.k;
  }
  
  public void init(CipherParameters paramCipherParameters)
  {
    if ((paramCipherParameters instanceof ECPublicKeyParameters))
    {
      this.key = ((ECPublicKeyParameters)paramCipherParameters);
      return;
    }
    throw new IllegalArgumentException("ECPublicKeyParameters are required for fixed transform.");
  }
  
  public ECPair transform(ECPair paramECPair)
  {
    Object localObject = this.key;
    if (localObject != null)
    {
      localObject = ((ECPublicKeyParameters)localObject).getParameters();
      BigInteger localBigInteger = ((ECDomainParameters)localObject).getN();
      ECMultiplier localECMultiplier = createBasePointMultiplier();
      localBigInteger = this.k.mod(localBigInteger);
      ECPoint[] arrayOfECPoint = new ECPoint[2];
      arrayOfECPoint[0] = localECMultiplier.multiply(((ECDomainParameters)localObject).getG(), localBigInteger).add(paramECPair.getX());
      arrayOfECPoint[1] = this.key.getQ().multiply(localBigInteger).add(paramECPair.getY());
      ((ECDomainParameters)localObject).getCurve().normalizeAll(arrayOfECPoint);
      return new ECPair(arrayOfECPoint[0], arrayOfECPoint[1]);
    }
    throw new IllegalStateException("ECFixedTransform not initialised");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\ec\ECFixedTransform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */