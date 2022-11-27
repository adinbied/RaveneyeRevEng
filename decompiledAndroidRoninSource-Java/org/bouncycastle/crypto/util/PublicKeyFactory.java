package org.bouncycastle.crypto.util;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.oiw.ElGamalParameter;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.DHParameter;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.RSAPublicKey;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.DSAParameter;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import org.bouncycastle.asn1.x9.DHPublicKey;
import org.bouncycastle.asn1.x9.DomainParameters;
import org.bouncycastle.asn1.x9.ECNamedCurveTable;
import org.bouncycastle.asn1.x9.ValidationParams;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ECPoint;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.ec.CustomNamedCurves;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHPublicKeyParameters;
import org.bouncycastle.crypto.params.DHValidationParameters;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.crypto.params.DSAPublicKeyParameters;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECNamedDomainParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.ElGamalParameters;
import org.bouncycastle.crypto.params.ElGamalPublicKeyParameters;
import org.bouncycastle.crypto.params.RSAKeyParameters;

public class PublicKeyFactory
{
  public static AsymmetricKeyParameter createKey(InputStream paramInputStream)
    throws IOException
  {
    return createKey(SubjectPublicKeyInfo.getInstance(new ASN1InputStream(paramInputStream).readObject()));
  }
  
  public static AsymmetricKeyParameter createKey(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
    throws IOException
  {
    Object localObject3 = paramSubjectPublicKeyInfo.getAlgorithm();
    boolean bool = ((AlgorithmIdentifier)localObject3).getAlgorithm().equals(PKCSObjectIdentifiers.rsaEncryption);
    int i = 0;
    if ((!bool) && (!((AlgorithmIdentifier)localObject3).getAlgorithm().equals(X509ObjectIdentifiers.id_ea_rsa)))
    {
      bool = ((AlgorithmIdentifier)localObject3).getAlgorithm().equals(X9ObjectIdentifiers.dhpublicnumber);
      Object localObject2 = null;
      Object localObject1 = null;
      if (bool)
      {
        localObject2 = DHPublicKey.getInstance(paramSubjectPublicKeyInfo.parsePublicKey()).getY();
        Object localObject4 = DomainParameters.getInstance(((AlgorithmIdentifier)localObject3).getParameters());
        localObject3 = ((DomainParameters)localObject4).getP();
        BigInteger localBigInteger1 = ((DomainParameters)localObject4).getG();
        BigInteger localBigInteger2 = ((DomainParameters)localObject4).getQ();
        if (((DomainParameters)localObject4).getJ() != null) {
          paramSubjectPublicKeyInfo = ((DomainParameters)localObject4).getJ();
        } else {
          paramSubjectPublicKeyInfo = null;
        }
        localObject4 = ((DomainParameters)localObject4).getValidationParams();
        if (localObject4 != null) {
          localObject1 = new DHValidationParameters(((ValidationParams)localObject4).getSeed(), ((ValidationParams)localObject4).getPgenCounter().intValue());
        }
        return new DHPublicKeyParameters((BigInteger)localObject2, new DHParameters((BigInteger)localObject3, localBigInteger1, localBigInteger2, paramSubjectPublicKeyInfo, (DHValidationParameters)localObject1));
      }
      if (((AlgorithmIdentifier)localObject3).getAlgorithm().equals(PKCSObjectIdentifiers.dhKeyAgreement))
      {
        localObject1 = DHParameter.getInstance(((AlgorithmIdentifier)localObject3).getParameters());
        paramSubjectPublicKeyInfo = (ASN1Integer)paramSubjectPublicKeyInfo.parsePublicKey();
        localObject2 = ((DHParameter)localObject1).getL();
        if (localObject2 != null) {
          i = ((BigInteger)localObject2).intValue();
        }
        localObject1 = new DHParameters(((DHParameter)localObject1).getP(), ((DHParameter)localObject1).getG(), null, i);
        return new DHPublicKeyParameters(paramSubjectPublicKeyInfo.getValue(), (DHParameters)localObject1);
      }
      if (((AlgorithmIdentifier)localObject3).getAlgorithm().equals(OIWObjectIdentifiers.elGamalAlgorithm))
      {
        localObject1 = ElGamalParameter.getInstance(((AlgorithmIdentifier)localObject3).getParameters());
        return new ElGamalPublicKeyParameters(((ASN1Integer)paramSubjectPublicKeyInfo.parsePublicKey()).getValue(), new ElGamalParameters(((ElGamalParameter)localObject1).getP(), ((ElGamalParameter)localObject1).getG()));
      }
      if ((!((AlgorithmIdentifier)localObject3).getAlgorithm().equals(X9ObjectIdentifiers.id_dsa)) && (!((AlgorithmIdentifier)localObject3).getAlgorithm().equals(OIWObjectIdentifiers.dsaWithSHA1)))
      {
        if (((AlgorithmIdentifier)localObject3).getAlgorithm().equals(X9ObjectIdentifiers.id_ecPublicKey))
        {
          localObject1 = X962Parameters.getInstance(((AlgorithmIdentifier)localObject3).getParameters());
          bool = ((X962Parameters)localObject1).isNamedCurve();
          localObject1 = ((X962Parameters)localObject1).getParameters();
          if (bool)
          {
            localObject3 = (ASN1ObjectIdentifier)localObject1;
            localObject2 = CustomNamedCurves.getByOID((ASN1ObjectIdentifier)localObject3);
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = ECNamedCurveTable.getByOID((ASN1ObjectIdentifier)localObject3);
            }
            localObject2 = new ECNamedDomainParameters((ASN1ObjectIdentifier)localObject3, ((X9ECParameters)localObject1).getCurve(), ((X9ECParameters)localObject1).getG(), ((X9ECParameters)localObject1).getN(), ((X9ECParameters)localObject1).getH(), ((X9ECParameters)localObject1).getSeed());
          }
          else
          {
            localObject1 = X9ECParameters.getInstance(localObject1);
            localObject2 = new ECDomainParameters(((X9ECParameters)localObject1).getCurve(), ((X9ECParameters)localObject1).getG(), ((X9ECParameters)localObject1).getN(), ((X9ECParameters)localObject1).getH(), ((X9ECParameters)localObject1).getSeed());
          }
          paramSubjectPublicKeyInfo = new DEROctetString(paramSubjectPublicKeyInfo.getPublicKeyData().getBytes());
          return new ECPublicKeyParameters(new X9ECPoint(((X9ECParameters)localObject1).getCurve(), paramSubjectPublicKeyInfo).getPoint(), (ECDomainParameters)localObject2);
        }
        throw new RuntimeException("algorithm identifier in key not recognised");
      }
      localObject1 = (ASN1Integer)paramSubjectPublicKeyInfo.parsePublicKey();
      localObject3 = ((AlgorithmIdentifier)localObject3).getParameters();
      paramSubjectPublicKeyInfo = (SubjectPublicKeyInfo)localObject2;
      if (localObject3 != null)
      {
        paramSubjectPublicKeyInfo = DSAParameter.getInstance(((ASN1Encodable)localObject3).toASN1Primitive());
        paramSubjectPublicKeyInfo = new DSAParameters(paramSubjectPublicKeyInfo.getP(), paramSubjectPublicKeyInfo.getQ(), paramSubjectPublicKeyInfo.getG());
      }
      return new DSAPublicKeyParameters(((ASN1Integer)localObject1).getValue(), paramSubjectPublicKeyInfo);
    }
    paramSubjectPublicKeyInfo = RSAPublicKey.getInstance(paramSubjectPublicKeyInfo.parsePublicKey());
    return new RSAKeyParameters(false, paramSubjectPublicKeyInfo.getModulus(), paramSubjectPublicKeyInfo.getPublicExponent());
  }
  
  public static AsymmetricKeyParameter createKey(byte[] paramArrayOfByte)
    throws IOException
  {
    return createKey(SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray(paramArrayOfByte)));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypt\\util\PublicKeyFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */