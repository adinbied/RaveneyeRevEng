package org.bouncycastle.jcajce.provider.asymmetric.util;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Enumeration;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.anssi.ANSSINamedCurves;
import org.bouncycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import org.bouncycastle.asn1.gm.GMNamedCurves;
import org.bouncycastle.asn1.nist.NISTNamedCurves;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.sec.SECNamedCurves;
import org.bouncycastle.asn1.teletrust.TeleTrusTNamedCurves;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.ECNamedCurveTable;
import org.bouncycastle.asn1.x9.X962NamedCurves;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.ec.CustomNamedCurves;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECNamedDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.jce.spec.ECParameterSpec;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;

public class ECUtil
{
  static int[] convertMidTerms(int[] paramArrayOfInt)
  {
    int[] arrayOfInt = new int[3];
    if (paramArrayOfInt.length == 1)
    {
      arrayOfInt[0] = paramArrayOfInt[0];
      return arrayOfInt;
    }
    if (paramArrayOfInt.length == 3)
    {
      if ((paramArrayOfInt[0] < paramArrayOfInt[1]) && (paramArrayOfInt[0] < paramArrayOfInt[2]))
      {
        arrayOfInt[0] = paramArrayOfInt[0];
        if (paramArrayOfInt[1] < paramArrayOfInt[2])
        {
          arrayOfInt[1] = paramArrayOfInt[1];
          arrayOfInt[2] = paramArrayOfInt[2];
          return arrayOfInt;
        }
        arrayOfInt[1] = paramArrayOfInt[2];
        arrayOfInt[2] = paramArrayOfInt[1];
        return arrayOfInt;
      }
      if (paramArrayOfInt[1] < paramArrayOfInt[2])
      {
        arrayOfInt[0] = paramArrayOfInt[1];
        if (paramArrayOfInt[0] < paramArrayOfInt[2])
        {
          arrayOfInt[1] = paramArrayOfInt[0];
          arrayOfInt[2] = paramArrayOfInt[2];
          return arrayOfInt;
        }
        arrayOfInt[1] = paramArrayOfInt[2];
        arrayOfInt[2] = paramArrayOfInt[0];
        return arrayOfInt;
      }
      arrayOfInt[0] = paramArrayOfInt[2];
      if (paramArrayOfInt[0] < paramArrayOfInt[1])
      {
        arrayOfInt[1] = paramArrayOfInt[0];
        arrayOfInt[2] = paramArrayOfInt[1];
        return arrayOfInt;
      }
      arrayOfInt[1] = paramArrayOfInt[1];
      arrayOfInt[2] = paramArrayOfInt[0];
      return arrayOfInt;
    }
    throw new IllegalArgumentException("Only Trinomials and pentanomials supported");
  }
  
  public static AsymmetricKeyParameter generatePrivateKeyParameter(PrivateKey paramPrivateKey)
    throws InvalidKeyException
  {
    Object localObject;
    if ((paramPrivateKey instanceof org.bouncycastle.jce.interfaces.ECPrivateKey))
    {
      org.bouncycastle.jce.interfaces.ECPrivateKey localECPrivateKey = (org.bouncycastle.jce.interfaces.ECPrivateKey)paramPrivateKey;
      localObject = localECPrivateKey.getParameters();
      paramPrivateKey = (PrivateKey)localObject;
      if (localObject == null) {
        paramPrivateKey = BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
      }
      return new ECPrivateKeyParameters(localECPrivateKey.getD(), new ECDomainParameters(paramPrivateKey.getCurve(), paramPrivateKey.getG(), paramPrivateKey.getN(), paramPrivateKey.getH(), paramPrivateKey.getSeed()));
    }
    if ((paramPrivateKey instanceof java.security.interfaces.ECPrivateKey))
    {
      paramPrivateKey = (java.security.interfaces.ECPrivateKey)paramPrivateKey;
      localObject = EC5Util.convertSpec(paramPrivateKey.getParams(), false);
      return new ECPrivateKeyParameters(paramPrivateKey.getS(), new ECDomainParameters(((ECParameterSpec)localObject).getCurve(), ((ECParameterSpec)localObject).getG(), ((ECParameterSpec)localObject).getN(), ((ECParameterSpec)localObject).getH(), ((ECParameterSpec)localObject).getSeed()));
    }
    try
    {
      paramPrivateKey = paramPrivateKey.getEncoded();
      if (paramPrivateKey != null)
      {
        paramPrivateKey = BouncyCastleProvider.getPrivateKey(PrivateKeyInfo.getInstance(paramPrivateKey));
        if ((paramPrivateKey instanceof java.security.interfaces.ECPrivateKey))
        {
          paramPrivateKey = generatePrivateKeyParameter(paramPrivateKey);
          return paramPrivateKey;
        }
        throw new InvalidKeyException("can't identify EC private key.");
      }
      throw new InvalidKeyException("no encoding for EC private key");
    }
    catch (Exception paramPrivateKey)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cannot identify EC private key: ");
      ((StringBuilder)localObject).append(paramPrivateKey.toString());
      throw new InvalidKeyException(((StringBuilder)localObject).toString());
    }
  }
  
  public static AsymmetricKeyParameter generatePublicKeyParameter(PublicKey paramPublicKey)
    throws InvalidKeyException
  {
    Object localObject;
    if ((paramPublicKey instanceof org.bouncycastle.jce.interfaces.ECPublicKey))
    {
      paramPublicKey = (org.bouncycastle.jce.interfaces.ECPublicKey)paramPublicKey;
      localObject = paramPublicKey.getParameters();
      return new ECPublicKeyParameters(paramPublicKey.getQ(), new ECDomainParameters(((ECParameterSpec)localObject).getCurve(), ((ECParameterSpec)localObject).getG(), ((ECParameterSpec)localObject).getN(), ((ECParameterSpec)localObject).getH(), ((ECParameterSpec)localObject).getSeed()));
    }
    if ((paramPublicKey instanceof java.security.interfaces.ECPublicKey))
    {
      paramPublicKey = (java.security.interfaces.ECPublicKey)paramPublicKey;
      localObject = EC5Util.convertSpec(paramPublicKey.getParams(), false);
      return new ECPublicKeyParameters(EC5Util.convertPoint(paramPublicKey.getParams(), paramPublicKey.getW(), false), new ECDomainParameters(((ECParameterSpec)localObject).getCurve(), ((ECParameterSpec)localObject).getG(), ((ECParameterSpec)localObject).getN(), ((ECParameterSpec)localObject).getH(), ((ECParameterSpec)localObject).getSeed()));
    }
    try
    {
      paramPublicKey = paramPublicKey.getEncoded();
      if (paramPublicKey != null)
      {
        paramPublicKey = BouncyCastleProvider.getPublicKey(SubjectPublicKeyInfo.getInstance(paramPublicKey));
        if ((paramPublicKey instanceof java.security.interfaces.ECPublicKey))
        {
          paramPublicKey = generatePublicKeyParameter(paramPublicKey);
          return paramPublicKey;
        }
        throw new InvalidKeyException("cannot identify EC public key.");
      }
      throw new InvalidKeyException("no encoding for EC public key");
    }
    catch (Exception paramPublicKey)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cannot identify EC public key: ");
      ((StringBuilder)localObject).append(paramPublicKey.toString());
      throw new InvalidKeyException(((StringBuilder)localObject).toString());
    }
  }
  
  public static String getCurveName(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    Object localObject2 = X962NamedCurves.getName(paramASN1ObjectIdentifier);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = SECNamedCurves.getName(paramASN1ObjectIdentifier);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = NISTNamedCurves.getName(paramASN1ObjectIdentifier);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = TeleTrusTNamedCurves.getName(paramASN1ObjectIdentifier);
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = ECGOST3410NamedCurves.getName(paramASN1ObjectIdentifier);
      }
    }
    return (String)localObject1;
  }
  
  public static ECDomainParameters getDomainParameters(ProviderConfiguration paramProviderConfiguration, X962Parameters paramX962Parameters)
  {
    if (paramX962Parameters.isNamedCurve())
    {
      ASN1ObjectIdentifier localASN1ObjectIdentifier = ASN1ObjectIdentifier.getInstance(paramX962Parameters.getParameters());
      X9ECParameters localX9ECParameters = getNamedCurveByOid(localASN1ObjectIdentifier);
      paramX962Parameters = localX9ECParameters;
      if (localX9ECParameters == null) {
        paramX962Parameters = (X9ECParameters)paramProviderConfiguration.getAdditionalECParameters().get(localASN1ObjectIdentifier);
      }
      return new ECNamedDomainParameters(localASN1ObjectIdentifier, paramX962Parameters.getCurve(), paramX962Parameters.getG(), paramX962Parameters.getN(), paramX962Parameters.getH(), paramX962Parameters.getSeed());
    }
    if (paramX962Parameters.isImplicitlyCA())
    {
      paramProviderConfiguration = paramProviderConfiguration.getEcImplicitlyCa();
      paramProviderConfiguration = new ECDomainParameters(paramProviderConfiguration.getCurve(), paramProviderConfiguration.getG(), paramProviderConfiguration.getN(), paramProviderConfiguration.getH(), paramProviderConfiguration.getSeed());
    }
    else
    {
      paramProviderConfiguration = X9ECParameters.getInstance(paramX962Parameters.getParameters());
      paramProviderConfiguration = new ECDomainParameters(paramProviderConfiguration.getCurve(), paramProviderConfiguration.getG(), paramProviderConfiguration.getN(), paramProviderConfiguration.getH(), paramProviderConfiguration.getSeed());
    }
    return paramProviderConfiguration;
  }
  
  public static ECDomainParameters getDomainParameters(ProviderConfiguration paramProviderConfiguration, ECParameterSpec paramECParameterSpec)
  {
    if ((paramECParameterSpec instanceof ECNamedCurveParameterSpec))
    {
      paramProviderConfiguration = (ECNamedCurveParameterSpec)paramECParameterSpec;
      return new ECNamedDomainParameters(getNamedCurveOid(paramProviderConfiguration.getName()), paramProviderConfiguration.getCurve(), paramProviderConfiguration.getG(), paramProviderConfiguration.getN(), paramProviderConfiguration.getH(), paramProviderConfiguration.getSeed());
    }
    if (paramECParameterSpec == null)
    {
      paramProviderConfiguration = paramProviderConfiguration.getEcImplicitlyCa();
      return new ECDomainParameters(paramProviderConfiguration.getCurve(), paramProviderConfiguration.getG(), paramProviderConfiguration.getN(), paramProviderConfiguration.getH(), paramProviderConfiguration.getSeed());
    }
    return new ECDomainParameters(paramECParameterSpec.getCurve(), paramECParameterSpec.getG(), paramECParameterSpec.getN(), paramECParameterSpec.getH(), paramECParameterSpec.getSeed());
  }
  
  public static X9ECParameters getNamedCurveByName(String paramString)
  {
    Object localObject1 = CustomNamedCurves.getByName(paramString);
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = X962NamedCurves.getByName(paramString);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = SECNamedCurves.getByName(paramString);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = NISTNamedCurves.getByName(paramString);
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = TeleTrusTNamedCurves.getByName(paramString);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = GMNamedCurves.getByName(paramString);
      }
    }
    return (X9ECParameters)localObject2;
  }
  
  public static X9ECParameters getNamedCurveByOid(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    Object localObject1 = CustomNamedCurves.getByOID(paramASN1ObjectIdentifier);
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = X962NamedCurves.getByOID(paramASN1ObjectIdentifier);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = SECNamedCurves.getByOID(paramASN1ObjectIdentifier);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = NISTNamedCurves.getByOID(paramASN1ObjectIdentifier);
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = TeleTrusTNamedCurves.getByOID(paramASN1ObjectIdentifier);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = GMNamedCurves.getByOID(paramASN1ObjectIdentifier);
      }
    }
    return (X9ECParameters)localObject2;
  }
  
  public static ASN1ObjectIdentifier getNamedCurveOid(String paramString)
  {
    String str = paramString;
    if (paramString.indexOf(' ') > 0) {
      str = paramString.substring(paramString.indexOf(' ') + 1);
    }
    try
    {
      if ((str.charAt(0) >= '0') && (str.charAt(0) <= '2')) {
        return new ASN1ObjectIdentifier(str);
      }
      paramString = lookupOidByName(str);
      return paramString;
    }
    catch (IllegalArgumentException paramString)
    {
      for (;;) {}
    }
    return lookupOidByName(str);
  }
  
  public static ASN1ObjectIdentifier getNamedCurveOid(ECParameterSpec paramECParameterSpec)
  {
    Enumeration localEnumeration = ECNamedCurveTable.getNames();
    while (localEnumeration.hasMoreElements())
    {
      String str = (String)localEnumeration.nextElement();
      X9ECParameters localX9ECParameters = ECNamedCurveTable.getByName(str);
      if ((localX9ECParameters.getN().equals(paramECParameterSpec.getN())) && (localX9ECParameters.getH().equals(paramECParameterSpec.getH())) && (localX9ECParameters.getCurve().equals(paramECParameterSpec.getCurve())) && (localX9ECParameters.getG().equals(paramECParameterSpec.getG()))) {
        return ECNamedCurveTable.getOID(str);
      }
    }
    return null;
  }
  
  public static int getOrderBitLength(ProviderConfiguration paramProviderConfiguration, BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    if (paramBigInteger1 == null)
    {
      paramProviderConfiguration = paramProviderConfiguration.getEcImplicitlyCa();
      if (paramProviderConfiguration == null) {
        return paramBigInteger2.bitLength();
      }
      return paramProviderConfiguration.getN().bitLength();
    }
    return paramBigInteger1.bitLength();
  }
  
  private static ASN1ObjectIdentifier lookupOidByName(String paramString)
  {
    Object localObject2 = X962NamedCurves.getOID(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = SECNamedCurves.getOID(paramString);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = NISTNamedCurves.getOID(paramString);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = TeleTrusTNamedCurves.getOID(paramString);
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = ECGOST3410NamedCurves.getOID(paramString);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = ANSSINamedCurves.getOID(paramString);
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = GMNamedCurves.getOID(paramString);
      }
    }
    return (ASN1ObjectIdentifier)localObject1;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetri\\util\ECUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */