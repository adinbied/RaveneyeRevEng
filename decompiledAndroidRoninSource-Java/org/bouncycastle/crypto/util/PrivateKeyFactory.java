package org.bouncycastle.crypto.util;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.oiw.ElGamalParameter;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.DHParameter;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.pkcs.RSAPrivateKey;
import org.bouncycastle.asn1.sec.ECPrivateKey;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.DSAParameter;
import org.bouncycastle.asn1.x9.ECNamedCurveTable;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.ec.CustomNamedCurves;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHPrivateKeyParameters;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.crypto.params.DSAPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECNamedDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ElGamalParameters;
import org.bouncycastle.crypto.params.ElGamalPrivateKeyParameters;
import org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;

public class PrivateKeyFactory
{
  public static AsymmetricKeyParameter createKey(InputStream paramInputStream)
    throws IOException
  {
    return createKey(PrivateKeyInfo.getInstance(new ASN1InputStream(paramInputStream).readObject()));
  }
  
  public static AsymmetricKeyParameter createKey(PrivateKeyInfo paramPrivateKeyInfo)
    throws IOException
  {
    Object localObject3 = paramPrivateKeyInfo.getPrivateKeyAlgorithm();
    if (((AlgorithmIdentifier)localObject3).getAlgorithm().equals(PKCSObjectIdentifiers.rsaEncryption))
    {
      paramPrivateKeyInfo = RSAPrivateKey.getInstance(paramPrivateKeyInfo.parsePrivateKey());
      return new RSAPrivateCrtKeyParameters(paramPrivateKeyInfo.getModulus(), paramPrivateKeyInfo.getPublicExponent(), paramPrivateKeyInfo.getPrivateExponent(), paramPrivateKeyInfo.getPrime1(), paramPrivateKeyInfo.getPrime2(), paramPrivateKeyInfo.getExponent1(), paramPrivateKeyInfo.getExponent2(), paramPrivateKeyInfo.getCoefficient());
    }
    boolean bool = ((AlgorithmIdentifier)localObject3).getAlgorithm().equals(PKCSObjectIdentifiers.dhKeyAgreement);
    Object localObject1 = null;
    Object localObject2;
    if (bool)
    {
      localObject1 = DHParameter.getInstance(((AlgorithmIdentifier)localObject3).getParameters());
      paramPrivateKeyInfo = (ASN1Integer)paramPrivateKeyInfo.parsePrivateKey();
      localObject2 = ((DHParameter)localObject1).getL();
      int i;
      if (localObject2 == null) {
        i = 0;
      } else {
        i = ((BigInteger)localObject2).intValue();
      }
      localObject1 = new DHParameters(((DHParameter)localObject1).getP(), ((DHParameter)localObject1).getG(), null, i);
      return new DHPrivateKeyParameters(paramPrivateKeyInfo.getValue(), (DHParameters)localObject1);
    }
    if (((AlgorithmIdentifier)localObject3).getAlgorithm().equals(OIWObjectIdentifiers.elGamalAlgorithm))
    {
      localObject1 = ElGamalParameter.getInstance(((AlgorithmIdentifier)localObject3).getParameters());
      return new ElGamalPrivateKeyParameters(((ASN1Integer)paramPrivateKeyInfo.parsePrivateKey()).getValue(), new ElGamalParameters(((ElGamalParameter)localObject1).getP(), ((ElGamalParameter)localObject1).getG()));
    }
    if (((AlgorithmIdentifier)localObject3).getAlgorithm().equals(X9ObjectIdentifiers.id_dsa))
    {
      localObject2 = (ASN1Integer)paramPrivateKeyInfo.parsePrivateKey();
      localObject3 = ((AlgorithmIdentifier)localObject3).getParameters();
      paramPrivateKeyInfo = (PrivateKeyInfo)localObject1;
      if (localObject3 != null)
      {
        paramPrivateKeyInfo = DSAParameter.getInstance(((ASN1Encodable)localObject3).toASN1Primitive());
        paramPrivateKeyInfo = new DSAParameters(paramPrivateKeyInfo.getP(), paramPrivateKeyInfo.getQ(), paramPrivateKeyInfo.getG());
      }
      return new DSAPrivateKeyParameters(((ASN1Integer)localObject2).getValue(), paramPrivateKeyInfo);
    }
    if (((AlgorithmIdentifier)localObject3).getAlgorithm().equals(X9ObjectIdentifiers.id_ecPublicKey))
    {
      localObject1 = new X962Parameters((ASN1Primitive)((AlgorithmIdentifier)localObject3).getParameters());
      if (((X962Parameters)localObject1).isNamedCurve())
      {
        localObject3 = (ASN1ObjectIdentifier)((X962Parameters)localObject1).getParameters();
        localObject2 = CustomNamedCurves.getByOID((ASN1ObjectIdentifier)localObject3);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = ECNamedCurveTable.getByOID((ASN1ObjectIdentifier)localObject3);
        }
        localObject1 = new ECNamedDomainParameters((ASN1ObjectIdentifier)localObject3, ((X9ECParameters)localObject1).getCurve(), ((X9ECParameters)localObject1).getG(), ((X9ECParameters)localObject1).getN(), ((X9ECParameters)localObject1).getH(), ((X9ECParameters)localObject1).getSeed());
      }
      else
      {
        localObject1 = X9ECParameters.getInstance(((X962Parameters)localObject1).getParameters());
        localObject1 = new ECDomainParameters(((X9ECParameters)localObject1).getCurve(), ((X9ECParameters)localObject1).getG(), ((X9ECParameters)localObject1).getN(), ((X9ECParameters)localObject1).getH(), ((X9ECParameters)localObject1).getSeed());
      }
      return new ECPrivateKeyParameters(ECPrivateKey.getInstance(paramPrivateKeyInfo.parsePrivateKey()).getKey(), (ECDomainParameters)localObject1);
    }
    throw new RuntimeException("algorithm identifier in key not recognised");
  }
  
  public static AsymmetricKeyParameter createKey(byte[] paramArrayOfByte)
    throws IOException
  {
    return createKey(PrivateKeyInfo.getInstance(ASN1Primitive.fromByteArray(paramArrayOfByte)));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypt\\util\PrivateKeyFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */