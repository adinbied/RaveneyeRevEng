package org.bouncycastle.crypto.engines;

import java.math.BigInteger;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.RSABlindingParameters;
import org.bouncycastle.crypto.params.RSAKeyParameters;

public class RSABlindingEngine
  implements AsymmetricBlockCipher
{
  private BigInteger blindingFactor;
  private RSACoreEngine core = new RSACoreEngine();
  private boolean forEncryption;
  private RSAKeyParameters key;
  
  private BigInteger blindMessage(BigInteger paramBigInteger)
  {
    return paramBigInteger.multiply(this.blindingFactor.modPow(this.key.getExponent(), this.key.getModulus())).mod(this.key.getModulus());
  }
  
  private BigInteger unblindMessage(BigInteger paramBigInteger)
  {
    BigInteger localBigInteger = this.key.getModulus();
    return paramBigInteger.multiply(this.blindingFactor.modInverse(localBigInteger)).mod(localBigInteger);
  }
  
  public int getInputBlockSize()
  {
    return this.core.getInputBlockSize();
  }
  
  public int getOutputBlockSize()
  {
    return this.core.getOutputBlockSize();
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    CipherParameters localCipherParameters = paramCipherParameters;
    if ((paramCipherParameters instanceof ParametersWithRandom)) {
      localCipherParameters = ((ParametersWithRandom)paramCipherParameters).getParameters();
    }
    paramCipherParameters = (RSABlindingParameters)localCipherParameters;
    this.core.init(paramBoolean, paramCipherParameters.getPublicKey());
    this.forEncryption = paramBoolean;
    this.key = paramCipherParameters.getPublicKey();
    this.blindingFactor = paramCipherParameters.getBlindingFactor();
  }
  
  public byte[] processBlock(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte = this.core.convertInput(paramArrayOfByte, paramInt1, paramInt2);
    if (this.forEncryption) {
      paramArrayOfByte = blindMessage(paramArrayOfByte);
    } else {
      paramArrayOfByte = unblindMessage(paramArrayOfByte);
    }
    return this.core.convertOutput(paramArrayOfByte);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\RSABlindingEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */