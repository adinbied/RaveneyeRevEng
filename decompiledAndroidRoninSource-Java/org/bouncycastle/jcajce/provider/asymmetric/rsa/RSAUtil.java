package org.bouncycastle.jcajce.provider.asymmetric.rsa;

import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;

public class RSAUtil
{
  public static final ASN1ObjectIdentifier[] rsaOids = { PKCSObjectIdentifiers.rsaEncryption, X509ObjectIdentifiers.id_ea_rsa, PKCSObjectIdentifiers.id_RSAES_OAEP, PKCSObjectIdentifiers.id_RSASSA_PSS };
  
  static RSAKeyParameters generatePrivateKeyParameter(RSAPrivateKey paramRSAPrivateKey)
  {
    if ((paramRSAPrivateKey instanceof RSAPrivateCrtKey))
    {
      paramRSAPrivateKey = (RSAPrivateCrtKey)paramRSAPrivateKey;
      return new RSAPrivateCrtKeyParameters(paramRSAPrivateKey.getModulus(), paramRSAPrivateKey.getPublicExponent(), paramRSAPrivateKey.getPrivateExponent(), paramRSAPrivateKey.getPrimeP(), paramRSAPrivateKey.getPrimeQ(), paramRSAPrivateKey.getPrimeExponentP(), paramRSAPrivateKey.getPrimeExponentQ(), paramRSAPrivateKey.getCrtCoefficient());
    }
    return new RSAKeyParameters(true, paramRSAPrivateKey.getModulus(), paramRSAPrivateKey.getPrivateExponent());
  }
  
  static RSAKeyParameters generatePublicKeyParameter(RSAPublicKey paramRSAPublicKey)
  {
    return new RSAKeyParameters(false, paramRSAPublicKey.getModulus(), paramRSAPublicKey.getPublicExponent());
  }
  
  public static boolean isRsaOid(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    int i = 0;
    for (;;)
    {
      ASN1ObjectIdentifier[] arrayOfASN1ObjectIdentifier = rsaOids;
      if (i == arrayOfASN1ObjectIdentifier.length) {
        break;
      }
      if (paramASN1ObjectIdentifier.equals(arrayOfASN1ObjectIdentifier[i])) {
        return true;
      }
      i += 1;
    }
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\rsa\RSAUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */