package org.bouncycastle.crypto.ec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECMultiplier;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.FixedPointCombMultiplier;

public class ECNewRandomnessTransform
  implements ECPairFactorTransform
{
  private ECPublicKeyParameters key;
  private BigInteger lastK;
  private SecureRandom random;
  
  protected ECMultiplier createBasePointMultiplier()
  {
    return new FixedPointCombMultiplier();
  }
  
  public BigInteger getTransformValue()
  {
    return this.lastK;
  }
  
  public void init(CipherParameters paramCipherParameters)
  {
    if ((paramCipherParameters instanceof ParametersWithRandom))
    {
      paramCipherParameters = (ParametersWithRandom)paramCipherParameters;
      if ((paramCipherParameters.getParameters() instanceof ECPublicKeyParameters))
      {
        this.key = ((ECPublicKeyParameters)paramCipherParameters.getParameters());
        paramCipherParameters = paramCipherParameters.getRandom();
      }
      else
      {
        throw new IllegalArgumentException("ECPublicKeyParameters are required for new randomness transform.");
      }
    }
    else
    {
      if (!(paramCipherParameters instanceof ECPublicKeyParameters)) {
        break label80;
      }
      this.key = ((ECPublicKeyParameters)paramCipherParameters);
      paramCipherParameters = new SecureRandom();
    }
    this.random = paramCipherParameters;
    return;
    label80:
    throw new IllegalArgumentException("ECPublicKeyParameters are required for new randomness transform.");
  }
  
  public ECPair transform(ECPair paramECPair)
  {
    Object localObject = this.key;
    if (localObject != null)
    {
      localObject = ((ECPublicKeyParameters)localObject).getParameters();
      BigInteger localBigInteger = ((ECDomainParameters)localObject).getN();
      ECMultiplier localECMultiplier = createBasePointMultiplier();
      localBigInteger = ECUtil.generateK(localBigInteger, this.random);
      ECPoint[] arrayOfECPoint = new ECPoint[2];
      arrayOfECPoint[0] = localECMultiplier.multiply(((ECDomainParameters)localObject).getG(), localBigInteger).add(paramECPair.getX());
      arrayOfECPoint[1] = this.key.getQ().multiply(localBigInteger).add(paramECPair.getY());
      ((ECDomainParameters)localObject).getCurve().normalizeAll(arrayOfECPoint);
      this.lastK = localBigInteger;
      return new ECPair(arrayOfECPoint[0], arrayOfECPoint[1]);
    }
    throw new IllegalStateException("ECNewRandomnessTransform not initialised");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\ec\ECNewRandomnessTransform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */