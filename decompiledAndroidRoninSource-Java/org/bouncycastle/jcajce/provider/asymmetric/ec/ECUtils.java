package org.bouncycastle.jcajce.provider.asymmetric.ec;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.PublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.EllipticCurve;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.bouncycastle.jce.spec.ECNamedCurveSpec;
import org.bouncycastle.math.ec.ECCurve;

class ECUtils
{
  static AsymmetricKeyParameter generatePublicKeyParameter(PublicKey paramPublicKey)
    throws InvalidKeyException
  {
    if ((paramPublicKey instanceof BCECPublicKey)) {
      return ((BCECPublicKey)paramPublicKey).engineGetKeyParameters();
    }
    return ECUtil.generatePublicKeyParameter(paramPublicKey);
  }
  
  static X9ECParameters getDomainParametersFromGenSpec(ECGenParameterSpec paramECGenParameterSpec)
  {
    return getDomainParametersFromName(paramECGenParameterSpec.getName());
  }
  
  static X962Parameters getDomainParametersFromName(ECParameterSpec paramECParameterSpec, boolean paramBoolean)
  {
    if ((paramECParameterSpec instanceof ECNamedCurveSpec))
    {
      ECNamedCurveSpec localECNamedCurveSpec = (ECNamedCurveSpec)paramECParameterSpec;
      localObject = ECUtil.getNamedCurveOid(localECNamedCurveSpec.getName());
      paramECParameterSpec = (ECParameterSpec)localObject;
      if (localObject == null) {
        paramECParameterSpec = new ASN1ObjectIdentifier(localECNamedCurveSpec.getName());
      }
      return new X962Parameters(paramECParameterSpec);
    }
    if (paramECParameterSpec == null) {
      return new X962Parameters(DERNull.INSTANCE);
    }
    Object localObject = EC5Util.convertCurve(paramECParameterSpec.getCurve());
    return new X962Parameters(new X9ECParameters((ECCurve)localObject, EC5Util.convertPoint((ECCurve)localObject, paramECParameterSpec.getGenerator(), paramBoolean), paramECParameterSpec.getOrder(), BigInteger.valueOf(paramECParameterSpec.getCofactor()), paramECParameterSpec.getCurve().getSeed()));
  }
  
  static X9ECParameters getDomainParametersFromName(String paramString)
  {
    Object localObject = paramString;
    try
    {
      if (paramString.charAt(0) >= '0')
      {
        localObject = paramString;
        if (paramString.charAt(0) <= '2')
        {
          localObject = paramString;
          return ECUtil.getNamedCurveByOid(new ASN1ObjectIdentifier(paramString));
        }
      }
      String str = paramString;
      localObject = paramString;
      if (paramString.indexOf(' ') > 0)
      {
        localObject = paramString;
        str = paramString.substring(paramString.indexOf(' ') + 1);
      }
      localObject = str;
      paramString = ECUtil.getNamedCurveByName(str);
      return paramString;
    }
    catch (IllegalArgumentException paramString)
    {
      for (;;) {}
    }
    return ECUtil.getNamedCurveByName((String)localObject);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\ec\ECUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */