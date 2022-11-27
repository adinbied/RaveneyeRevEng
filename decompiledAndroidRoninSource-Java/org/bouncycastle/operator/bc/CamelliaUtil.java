package org.bouncycastle.operator.bc;

import org.bouncycastle.asn1.ntt.NTTObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.params.KeyParameter;

class CamelliaUtil
{
  static AlgorithmIdentifier determineKeyEncAlg(KeyParameter paramKeyParameter)
  {
    int i = paramKeyParameter.getKey().length * 8;
    if (i == 128)
    {
      paramKeyParameter = NTTObjectIdentifiers.id_camellia128_wrap;
    }
    else if (i == 192)
    {
      paramKeyParameter = NTTObjectIdentifiers.id_camellia192_wrap;
    }
    else
    {
      if (i != 256) {
        break label57;
      }
      paramKeyParameter = NTTObjectIdentifiers.id_camellia256_wrap;
    }
    return new AlgorithmIdentifier(paramKeyParameter);
    label57:
    throw new IllegalArgumentException("illegal keysize in Camellia");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\operator\bc\CamelliaUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */