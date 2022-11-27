package org.bouncycastle.crypto.ec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.ec.ECConstants;

class ECUtil
{
  static BigInteger generateK(BigInteger paramBigInteger, SecureRandom paramSecureRandom)
  {
    int i = paramBigInteger.bitLength();
    BigInteger localBigInteger;
    do
    {
      localBigInteger = new BigInteger(i, paramSecureRandom);
    } while ((localBigInteger.equals(ECConstants.ZERO)) || (localBigInteger.compareTo(paramBigInteger) >= 0));
    return localBigInteger;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\ec\ECUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */