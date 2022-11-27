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

public class ECElGamalEncryptor
  implements ECEncryptor
{
  private ECPublicKeyParameters key;
  private SecureRandom random;
  
  protected ECMultiplier createBasePointMultiplier()
  {
    return new FixedPointCombMultiplier();
  }
  
  public ECPair encrypt(ECPoint paramECPoint)
  {
    Object localObject = this.key;
    if (localObject != null)
    {
      localObject = ((ECPublicKeyParameters)localObject).getParameters();
      BigInteger localBigInteger = ECUtil.generateK(((ECDomainParameters)localObject).getN(), this.random);
      ECMultiplier localECMultiplier = createBasePointMultiplier();
      ECPoint[] arrayOfECPoint = new ECPoint[2];
      arrayOfECPoint[0] = localECMultiplier.multiply(((ECDomainParameters)localObject).getG(), localBigInteger);
      arrayOfECPoint[1] = this.key.getQ().multiply(localBigInteger).add(paramECPoint);
      ((ECDomainParameters)localObject).getCurve().normalizeAll(arrayOfECPoint);
      return new ECPair(arrayOfECPoint[0], arrayOfECPoint[1]);
    }
    throw new IllegalStateException("ECElGamalEncryptor not initialised");
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
        throw new IllegalArgumentException("ECPublicKeyParameters are required for encryption.");
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
    throw new IllegalArgumentException("ECPublicKeyParameters are required for encryption.");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\ec\ECElGamalEncryptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */