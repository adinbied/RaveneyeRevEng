package org.bouncycastle.jcajce.provider.asymmetric.dh;

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
import org.bouncycastle.asn1.x9.DomainParameters;
import org.bouncycastle.asn1.x9.ValidationParams;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHPublicKeyParameters;
import org.bouncycastle.crypto.params.DHValidationParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;

public class BCDHPublicKey
  implements DHPublicKey
{
  static final long serialVersionUID = -216691575254424324L;
  private transient DHPublicKeyParameters dhPublicKey;
  private transient DHParameterSpec dhSpec;
  private transient SubjectPublicKeyInfo info;
  private BigInteger y;
  
  BCDHPublicKey(BigInteger paramBigInteger, DHParameterSpec paramDHParameterSpec)
  {
    this.y = paramBigInteger;
    this.dhSpec = paramDHParameterSpec;
    this.dhPublicKey = new DHPublicKeyParameters(paramBigInteger, new DHParameters(paramDHParameterSpec.getP(), paramDHParameterSpec.getG()));
  }
  
  BCDHPublicKey(DHPublicKey paramDHPublicKey)
  {
    this.y = paramDHPublicKey.getY();
    paramDHPublicKey = paramDHPublicKey.getParams();
    this.dhSpec = paramDHPublicKey;
    this.dhPublicKey = new DHPublicKeyParameters(this.y, new DHParameters(paramDHPublicKey.getP(), this.dhSpec.getG()));
  }
  
  BCDHPublicKey(DHPublicKeySpec paramDHPublicKeySpec)
  {
    this.y = paramDHPublicKeySpec.getY();
    this.dhSpec = new DHParameterSpec(paramDHPublicKeySpec.getP(), paramDHPublicKeySpec.getG());
    this.dhPublicKey = new DHPublicKeyParameters(this.y, new DHParameters(paramDHPublicKeySpec.getP(), paramDHPublicKeySpec.getG()));
  }
  
  public BCDHPublicKey(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
  {
    this.info = paramSubjectPublicKeyInfo;
    try
    {
      Object localObject = (ASN1Integer)paramSubjectPublicKeyInfo.parsePublicKey();
      this.y = ((ASN1Integer)localObject).getValue();
      localObject = ASN1Sequence.getInstance(paramSubjectPublicKeyInfo.getAlgorithm().getParameters());
      paramSubjectPublicKeyInfo = paramSubjectPublicKeyInfo.getAlgorithm().getAlgorithm();
      if ((!paramSubjectPublicKeyInfo.equals(PKCSObjectIdentifiers.dhKeyAgreement)) && (!isPKCSParam((ASN1Sequence)localObject)))
      {
        if (paramSubjectPublicKeyInfo.equals(X9ObjectIdentifiers.dhpublicnumber))
        {
          paramSubjectPublicKeyInfo = DomainParameters.getInstance(localObject);
          this.dhSpec = new DHParameterSpec(paramSubjectPublicKeyInfo.getP(), paramSubjectPublicKeyInfo.getG());
          localObject = paramSubjectPublicKeyInfo.getValidationParams();
          if (localObject != null)
          {
            this.dhPublicKey = new DHPublicKeyParameters(this.y, new DHParameters(paramSubjectPublicKeyInfo.getP(), paramSubjectPublicKeyInfo.getG(), paramSubjectPublicKeyInfo.getQ(), paramSubjectPublicKeyInfo.getJ(), new DHValidationParameters(((ValidationParams)localObject).getSeed(), ((ValidationParams)localObject).getPgenCounter().intValue())));
            return;
          }
          this.dhPublicKey = new DHPublicKeyParameters(this.y, new DHParameters(paramSubjectPublicKeyInfo.getP(), paramSubjectPublicKeyInfo.getG(), paramSubjectPublicKeyInfo.getQ(), paramSubjectPublicKeyInfo.getJ(), null));
          return;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("unknown algorithm type: ");
        ((StringBuilder)localObject).append(paramSubjectPublicKeyInfo);
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
      paramSubjectPublicKeyInfo = DHParameter.getInstance(localObject);
      if (paramSubjectPublicKeyInfo.getL() != null) {
        paramSubjectPublicKeyInfo = new DHParameterSpec(paramSubjectPublicKeyInfo.getP(), paramSubjectPublicKeyInfo.getG(), paramSubjectPublicKeyInfo.getL().intValue());
      } else {
        paramSubjectPublicKeyInfo = new DHParameterSpec(paramSubjectPublicKeyInfo.getP(), paramSubjectPublicKeyInfo.getG());
      }
      this.dhSpec = paramSubjectPublicKeyInfo;
      this.dhPublicKey = new DHPublicKeyParameters(this.y, new DHParameters(this.dhSpec.getP(), this.dhSpec.getG()));
      return;
    }
    catch (IOException paramSubjectPublicKeyInfo)
    {
      for (;;) {}
    }
    throw new IllegalArgumentException("invalid info structure in DH public key");
  }
  
  BCDHPublicKey(DHPublicKeyParameters paramDHPublicKeyParameters)
  {
    this.y = paramDHPublicKeyParameters.getY();
    this.dhSpec = new DHParameterSpec(paramDHPublicKeyParameters.getParameters().getP(), paramDHPublicKeyParameters.getParameters().getG(), paramDHPublicKeyParameters.getParameters().getL());
    this.dhPublicKey = paramDHPublicKeyParameters;
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
    paramObjectInputStream.defaultReadObject();
    this.dhSpec = new DHParameterSpec((BigInteger)paramObjectInputStream.readObject(), (BigInteger)paramObjectInputStream.readObject(), paramObjectInputStream.readInt());
    this.info = null;
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeObject(this.dhSpec.getP());
    paramObjectOutputStream.writeObject(this.dhSpec.getG());
    paramObjectOutputStream.writeInt(this.dhSpec.getL());
  }
  
  public DHPublicKeyParameters engineGetKeyParameters()
  {
    return this.dhPublicKey;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof DHPublicKey;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (DHPublicKey)paramObject;
    bool1 = bool2;
    if (getY().equals(((DHPublicKey)paramObject).getY()))
    {
      bool1 = bool2;
      if (getParams().getG().equals(((DHPublicKey)paramObject).getParams().getG()))
      {
        bool1 = bool2;
        if (getParams().getP().equals(((DHPublicKey)paramObject).getParams().getP()))
        {
          bool1 = bool2;
          if (getParams().getL() == ((DHPublicKey)paramObject).getParams().getL()) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
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
    return KeyUtil.getEncodedSubjectPublicKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.dhKeyAgreement, new DHParameter(this.dhSpec.getP(), this.dhSpec.getG(), this.dhSpec.getL()).toASN1Primitive()), new ASN1Integer(this.y));
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
  
  public int hashCode()
  {
    return getY().hashCode() ^ getParams().getG().hashCode() ^ getParams().getP().hashCode() ^ getParams().getL();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\dh\BCDHPublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */