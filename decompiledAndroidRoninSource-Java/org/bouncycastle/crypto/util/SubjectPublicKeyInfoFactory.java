package org.bouncycastle.crypto.util;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.RSAPublicKey;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.DSAParameter;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ECPoint;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.crypto.params.DSAPublicKeyParameters;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECNamedDomainParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.RSAKeyParameters;

public class SubjectPublicKeyInfoFactory
{
  public static SubjectPublicKeyInfo createSubjectPublicKeyInfo(AsymmetricKeyParameter paramAsymmetricKeyParameter)
    throws IOException
  {
    if ((paramAsymmetricKeyParameter instanceof RSAKeyParameters))
    {
      paramAsymmetricKeyParameter = (RSAKeyParameters)paramAsymmetricKeyParameter;
      return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.rsaEncryption, DERNull.INSTANCE), new RSAPublicKey(paramAsymmetricKeyParameter.getModulus(), paramAsymmetricKeyParameter.getExponent()));
    }
    Object localObject;
    if ((paramAsymmetricKeyParameter instanceof DSAPublicKeyParameters))
    {
      localObject = (DSAPublicKeyParameters)paramAsymmetricKeyParameter;
      paramAsymmetricKeyParameter = null;
      DSAParameters localDSAParameters = ((DSAPublicKeyParameters)localObject).getParameters();
      if (localDSAParameters != null) {
        paramAsymmetricKeyParameter = new DSAParameter(localDSAParameters.getP(), localDSAParameters.getQ(), localDSAParameters.getG());
      }
      return new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_dsa, paramAsymmetricKeyParameter), new ASN1Integer(((DSAPublicKeyParameters)localObject).getY()));
    }
    if ((paramAsymmetricKeyParameter instanceof ECPublicKeyParameters))
    {
      localObject = (ECPublicKeyParameters)paramAsymmetricKeyParameter;
      paramAsymmetricKeyParameter = ((ECPublicKeyParameters)localObject).getParameters();
      if (paramAsymmetricKeyParameter == null) {
        paramAsymmetricKeyParameter = new X962Parameters(DERNull.INSTANCE);
      } else if ((paramAsymmetricKeyParameter instanceof ECNamedDomainParameters)) {
        paramAsymmetricKeyParameter = new X962Parameters(((ECNamedDomainParameters)paramAsymmetricKeyParameter).getName());
      } else {
        paramAsymmetricKeyParameter = new X962Parameters(new X9ECParameters(paramAsymmetricKeyParameter.getCurve(), paramAsymmetricKeyParameter.getG(), paramAsymmetricKeyParameter.getN(), paramAsymmetricKeyParameter.getH(), paramAsymmetricKeyParameter.getSeed()));
      }
      localObject = (ASN1OctetString)new X9ECPoint(((ECPublicKeyParameters)localObject).getQ()).toASN1Primitive();
      return new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, paramAsymmetricKeyParameter), ((ASN1OctetString)localObject).getOctets());
    }
    throw new IOException("key parameters not recognised.");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypt\\util\SubjectPublicKeyInfoFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */