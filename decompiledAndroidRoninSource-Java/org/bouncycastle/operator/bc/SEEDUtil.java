package org.bouncycastle.operator.bc;

import org.bouncycastle.asn1.kisa.KISAObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

class SEEDUtil
{
  static AlgorithmIdentifier determineKeyEncAlg()
  {
    return new AlgorithmIdentifier(KISAObjectIdentifiers.id_npki_app_cmsSeed_wrap);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\operator\bc\SEEDUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */