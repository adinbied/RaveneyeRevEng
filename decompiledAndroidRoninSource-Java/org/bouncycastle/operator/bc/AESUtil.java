package org.bouncycastle.operator.bc;

import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.params.KeyParameter;

class AESUtil
{
  static AlgorithmIdentifier determineKeyEncAlg(KeyParameter paramKeyParameter)
  {
    int i = paramKeyParameter.getKey().length * 8;
    if (i == 128)
    {
      paramKeyParameter = NISTObjectIdentifiers.id_aes128_wrap;
    }
    else if (i == 192)
    {
      paramKeyParameter = NISTObjectIdentifiers.id_aes192_wrap;
    }
    else
    {
      if (i != 256) {
        break label57;
      }
      paramKeyParameter = NISTObjectIdentifiers.id_aes256_wrap;
    }
    return new AlgorithmIdentifier(paramKeyParameter);
    label57:
    throw new IllegalArgumentException("illegal keysize in AES");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\operator\bc\AESUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */