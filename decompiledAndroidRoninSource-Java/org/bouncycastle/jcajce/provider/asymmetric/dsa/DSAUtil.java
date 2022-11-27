package org.bouncycastle.jcajce.provider.asymmetric.dsa;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.crypto.params.DSAPrivateKeyParameters;

public class DSAUtil
{
  public static final ASN1ObjectIdentifier[] dsaOids = { X9ObjectIdentifiers.id_dsa, OIWObjectIdentifiers.dsaWithSHA1 };
  
  public static AsymmetricKeyParameter generatePrivateKeyParameter(PrivateKey paramPrivateKey)
    throws InvalidKeyException
  {
    if ((paramPrivateKey instanceof DSAPrivateKey))
    {
      paramPrivateKey = (DSAPrivateKey)paramPrivateKey;
      return new DSAPrivateKeyParameters(paramPrivateKey.getX(), new DSAParameters(paramPrivateKey.getParams().getP(), paramPrivateKey.getParams().getQ(), paramPrivateKey.getParams().getG()));
    }
    throw new InvalidKeyException("can't identify DSA private key.");
  }
  
  public static AsymmetricKeyParameter generatePublicKeyParameter(PublicKey paramPublicKey)
    throws InvalidKeyException
  {
    if ((paramPublicKey instanceof BCDSAPublicKey)) {
      return ((BCDSAPublicKey)paramPublicKey).engineGetKeyParameters();
    }
    if ((paramPublicKey instanceof DSAPublicKey)) {
      return new BCDSAPublicKey((DSAPublicKey)paramPublicKey).engineGetKeyParameters();
    }
    try
    {
      localObject = new BCDSAPublicKey(SubjectPublicKeyInfo.getInstance(paramPublicKey.getEncoded())).engineGetKeyParameters();
      return (AsymmetricKeyParameter)localObject;
    }
    catch (Exception localException)
    {
      Object localObject;
      for (;;) {}
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("can't identify DSA public key: ");
    ((StringBuilder)localObject).append(paramPublicKey.getClass().getName());
    throw new InvalidKeyException(((StringBuilder)localObject).toString());
  }
  
  public static boolean isDsaOid(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    int i = 0;
    for (;;)
    {
      ASN1ObjectIdentifier[] arrayOfASN1ObjectIdentifier = dsaOids;
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
  
  static DSAParameters toDSAParameters(DSAParams paramDSAParams)
  {
    if (paramDSAParams != null) {
      return new DSAParameters(paramDSAParams.getP(), paramDSAParams.getQ(), paramDSAParams.getG());
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\dsa\DSAUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */