package org.bouncycastle.crypto.util;

import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.pkcs.RSAPrivateKey;
import org.bouncycastle.asn1.sec.ECPrivateKey;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.DSAParameter;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.crypto.params.DSAPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECNamedDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;

public class PrivateKeyInfoFactory
{
  public static PrivateKeyInfo createPrivateKeyInfo(AsymmetricKeyParameter paramAsymmetricKeyParameter)
    throws IOException
  {
    if ((paramAsymmetricKeyParameter instanceof RSAKeyParameters))
    {
      paramAsymmetricKeyParameter = (RSAPrivateCrtKeyParameters)paramAsymmetricKeyParameter;
      return new PrivateKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.rsaEncryption, DERNull.INSTANCE), new RSAPrivateKey(paramAsymmetricKeyParameter.getModulus(), paramAsymmetricKeyParameter.getPublicExponent(), paramAsymmetricKeyParameter.getExponent(), paramAsymmetricKeyParameter.getP(), paramAsymmetricKeyParameter.getQ(), paramAsymmetricKeyParameter.getDP(), paramAsymmetricKeyParameter.getDQ(), paramAsymmetricKeyParameter.getQInv()));
    }
    Object localObject;
    if ((paramAsymmetricKeyParameter instanceof DSAPrivateKeyParameters))
    {
      paramAsymmetricKeyParameter = (DSAPrivateKeyParameters)paramAsymmetricKeyParameter;
      localObject = paramAsymmetricKeyParameter.getParameters();
      return new PrivateKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_dsa, new DSAParameter(((DSAParameters)localObject).getP(), ((DSAParameters)localObject).getQ(), ((DSAParameters)localObject).getG())), new ASN1Integer(paramAsymmetricKeyParameter.getX()));
    }
    if ((paramAsymmetricKeyParameter instanceof ECPrivateKeyParameters))
    {
      localObject = (ECPrivateKeyParameters)paramAsymmetricKeyParameter;
      ECDomainParameters localECDomainParameters = ((ECPrivateKeyParameters)localObject).getParameters();
      int i;
      if (localECDomainParameters == null)
      {
        paramAsymmetricKeyParameter = new X962Parameters(DERNull.INSTANCE);
        i = ((ECPrivateKeyParameters)localObject).getD().bitLength();
      }
      else if ((localECDomainParameters instanceof ECNamedDomainParameters))
      {
        paramAsymmetricKeyParameter = new X962Parameters(((ECNamedDomainParameters)localECDomainParameters).getName());
        i = localECDomainParameters.getN().bitLength();
      }
      else
      {
        paramAsymmetricKeyParameter = new X962Parameters(new X9ECParameters(localECDomainParameters.getCurve(), localECDomainParameters.getG(), localECDomainParameters.getN(), localECDomainParameters.getH(), localECDomainParameters.getSeed()));
        i = localECDomainParameters.getN().bitLength();
      }
      return new PrivateKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, paramAsymmetricKeyParameter), new ECPrivateKey(i, ((ECPrivateKeyParameters)localObject).getD(), paramAsymmetricKeyParameter));
    }
    throw new IOException("key parameters not recognised.");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypt\\util\PrivateKeyInfoFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */