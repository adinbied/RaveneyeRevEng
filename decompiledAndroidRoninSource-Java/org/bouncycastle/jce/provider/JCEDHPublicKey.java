package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.pkcs.DHParameter;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.DHDomainParameters;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHPublicKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;

public class JCEDHPublicKey
  implements DHPublicKey
{
  static final long serialVersionUID = -216691575254424324L;
  private DHParameterSpec dhSpec;
  private SubjectPublicKeyInfo info;
  private BigInteger y;
  
  JCEDHPublicKey(BigInteger paramBigInteger, DHParameterSpec paramDHParameterSpec)
  {
    this.y = paramBigInteger;
    this.dhSpec = paramDHParameterSpec;
  }
  
  JCEDHPublicKey(DHPublicKey paramDHPublicKey)
  {
    this.y = paramDHPublicKey.getY();
    this.dhSpec = paramDHPublicKey.getParams();
  }
  
  JCEDHPublicKey(DHPublicKeySpec paramDHPublicKeySpec)
  {
    this.y = paramDHPublicKeySpec.getY();
    this.dhSpec = new DHParameterSpec(paramDHPublicKeySpec.getP(), paramDHPublicKeySpec.getG());
  }
  
  JCEDHPublicKey(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
  {
    this.info = paramSubjectPublicKeyInfo;
    try
    {
      Object localObject = (ASN1Integer)paramSubjectPublicKeyInfo.parsePublicKey();
      this.y = ((ASN1Integer)localObject).getValue();
      localObject = ASN1Sequence.getInstance(paramSubjectPublicKeyInfo.getAlgorithmId().getParameters());
      paramSubjectPublicKeyInfo = paramSubjectPublicKeyInfo.getAlgorithmId().getAlgorithm();
      if ((!paramSubjectPublicKeyInfo.equals(PKCSObjectIdentifiers.dhKeyAgreement)) && (!isPKCSParam((ASN1Sequence)localObject))) {
        if (paramSubjectPublicKeyInfo.equals(X9ObjectIdentifiers.dhpublicnumber))
        {
          paramSubjectPublicKeyInfo = DHDomainParameters.getInstance(localObject);
          paramSubjectPublicKeyInfo = new DHParameterSpec(paramSubjectPublicKeyInfo.getP().getValue(), paramSubjectPublicKeyInfo.getG().getValue());
        }
      }
      for (;;)
      {
        this.dhSpec = paramSubjectPublicKeyInfo;
        return;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("unknown algorithm type: ");
        ((StringBuilder)localObject).append(paramSubjectPublicKeyInfo);
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        paramSubjectPublicKeyInfo = DHParameter.getInstance(localObject);
        if (paramSubjectPublicKeyInfo.getL() != null) {
          paramSubjectPublicKeyInfo = new DHParameterSpec(paramSubjectPublicKeyInfo.getP(), paramSubjectPublicKeyInfo.getG(), paramSubjectPublicKeyInfo.getL().intValue());
        } else {
          paramSubjectPublicKeyInfo = new DHParameterSpec(paramSubjectPublicKeyInfo.getP(), paramSubjectPublicKeyInfo.getG());
        }
      }
    }
    catch (IOException paramSubjectPublicKeyInfo)
    {
      for (;;) {}
    }
    throw new IllegalArgumentException("invalid info structure in DH public key");
  }
  
  JCEDHPublicKey(DHPublicKeyParameters paramDHPublicKeyParameters)
  {
    this.y = paramDHPublicKeyParameters.getY();
    this.dhSpec = new DHParameterSpec(paramDHPublicKeyParameters.getParameters().getP(), paramDHPublicKeyParameters.getParameters().getG(), paramDHPublicKeyParameters.getParameters().getL());
  }
  
  private boolean isPKCSParam(ASN1Sequence paramASN1Sequence)
  {
    if (paramASN1Sequence.size() == 2) {
      return true;
    }
    if (paramASN1Sequence.size() > 3) {
      return false;
    }
    ASN1Integer localASN1Integer = ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(2));
    paramASN1Sequence = ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(0));
    return localASN1Integer.getValue().compareTo(BigInteger.valueOf(paramASN1Sequence.getValue().bitLength())) <= 0;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    this.y = ((BigInteger)paramObjectInputStream.readObject());
    this.dhSpec = new DHParameterSpec((BigInteger)paramObjectInputStream.readObject(), (BigInteger)paramObjectInputStream.readObject(), paramObjectInputStream.readInt());
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeObject(getY());
    paramObjectOutputStream.writeObject(this.dhSpec.getP());
    paramObjectOutputStream.writeObject(this.dhSpec.getG());
    paramObjectOutputStream.writeInt(this.dhSpec.getL());
  }
  
  public String getAlgorithm()
  {
    return "DH";
  }
  
  public byte[] getEncoded()
  {
    SubjectPublicKeyInfo localSubjectPublicKeyInfo = this.info;
    if (localSubjectPublicKeyInfo != null) {
      return KeyUtil.getEncodedSubjectPublicKeyInfo(localSubjectPublicKeyInfo);
    }
    return KeyUtil.getEncodedSubjectPublicKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.dhKeyAgreement, new DHParameter(this.dhSpec.getP(), this.dhSpec.getG(), this.dhSpec.getL())), new ASN1Integer(this.y));
  }
  
  public String getFormat()
  {
    return "X.509";
  }
  
  public DHParameterSpec getParams()
  {
    return this.dhSpec;
  }
  
  public BigInteger getY()
  {
    return this.y;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\provider\JCEDHPublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */