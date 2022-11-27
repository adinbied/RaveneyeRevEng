package org.bouncycastle.jcajce.provider.asymmetric.dh;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.Enumeration;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPrivateKeySpec;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.pkcs.DHParameter;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x9.DomainParameters;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHPrivateKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;

public class BCDHPrivateKey
  implements DHPrivateKey, PKCS12BagAttributeCarrier
{
  static final long serialVersionUID = 311058815616901812L;
  private transient PKCS12BagAttributeCarrierImpl attrCarrier = new PKCS12BagAttributeCarrierImpl();
  private transient DHParameterSpec dhSpec;
  private transient PrivateKeyInfo info;
  private BigInteger x;
  
  protected BCDHPrivateKey() {}
  
  BCDHPrivateKey(DHPrivateKey paramDHPrivateKey)
  {
    this.x = paramDHPrivateKey.getX();
    this.dhSpec = paramDHPrivateKey.getParams();
  }
  
  BCDHPrivateKey(DHPrivateKeySpec paramDHPrivateKeySpec)
  {
    this.x = paramDHPrivateKeySpec.getX();
    this.dhSpec = new DHParameterSpec(paramDHPrivateKeySpec.getP(), paramDHPrivateKeySpec.getG());
  }
  
  public BCDHPrivateKey(PrivateKeyInfo paramPrivateKeyInfo)
    throws IOException
  {
    ASN1Sequence localASN1Sequence = ASN1Sequence.getInstance(paramPrivateKeyInfo.getPrivateKeyAlgorithm().getParameters());
    ASN1Integer localASN1Integer = (ASN1Integer)paramPrivateKeyInfo.parsePrivateKey();
    ASN1ObjectIdentifier localASN1ObjectIdentifier = paramPrivateKeyInfo.getPrivateKeyAlgorithm().getAlgorithm();
    this.info = paramPrivateKeyInfo;
    this.x = localASN1Integer.getValue();
    if (localASN1ObjectIdentifier.equals(PKCSObjectIdentifiers.dhKeyAgreement))
    {
      paramPrivateKeyInfo = DHParameter.getInstance(localASN1Sequence);
      if (paramPrivateKeyInfo.getL() != null) {
        paramPrivateKeyInfo = new DHParameterSpec(paramPrivateKeyInfo.getP(), paramPrivateKeyInfo.getG(), paramPrivateKeyInfo.getL().intValue());
      } else {
        paramPrivateKeyInfo = new DHParameterSpec(paramPrivateKeyInfo.getP(), paramPrivateKeyInfo.getG());
      }
    }
    else
    {
      if (!localASN1ObjectIdentifier.equals(X9ObjectIdentifiers.dhpublicnumber)) {
        break label161;
      }
      paramPrivateKeyInfo = DomainParameters.getInstance(localASN1Sequence);
      paramPrivateKeyInfo = new DHParameterSpec(paramPrivateKeyInfo.getP(), paramPrivateKeyInfo.getG());
    }
    this.dhSpec = paramPrivateKeyInfo;
    return;
    label161:
    paramPrivateKeyInfo = new StringBuilder();
    paramPrivateKeyInfo.append("unknown algorithm type: ");
    paramPrivateKeyInfo.append(localASN1ObjectIdentifier);
    throw new IllegalArgumentException(paramPrivateKeyInfo.toString());
  }
  
  BCDHPrivateKey(DHPrivateKeyParameters paramDHPrivateKeyParameters)
  {
    this.x = paramDHPrivateKeyParameters.getX();
    this.dhSpec = new DHParameterSpec(paramDHPrivateKeyParameters.getParameters().getP(), paramDHPrivateKeyParameters.getParameters().getG(), paramDHPrivateKeyParameters.getParameters().getL());
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    this.dhSpec = new DHParameterSpec((BigInteger)paramObjectInputStream.readObject(), (BigInteger)paramObjectInputStream.readObject(), paramObjectInputStream.readInt());
    this.info = null;
    this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeObject(this.dhSpec.getP());
    paramObjectOutputStream.writeObject(this.dhSpec.getG());
    paramObjectOutputStream.writeInt(this.dhSpec.getL());
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof DHPrivateKey;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (DHPrivateKey)paramObject;
    bool1 = bool2;
    if (getX().equals(((DHPrivateKey)paramObject).getX()))
    {
      bool1 = bool2;
      if (getParams().getG().equals(((DHPrivateKey)paramObject).getParams().getG()))
      {
        bool1 = bool2;
        if (getParams().getP().equals(((DHPrivateKey)paramObject).getParams().getP()))
        {
          bool1 = bool2;
          if (getParams().getL() == ((DHPrivateKey)paramObject).getParams().getL()) {
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
  
  public ASN1Encodable getBagAttribute(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    return this.attrCarrier.getBagAttribute(paramASN1ObjectIdentifier);
  }
  
  public Enumeration getBagAttributeKeys()
  {
    return this.attrCarrier.getBagAttributeKeys();
  }
  
  public byte[] getEncoded()
  {
    try
    {
      Object localObject = this.info;
      if (localObject != null) {
        return this.info.getEncoded("DER");
      }
      localObject = new PrivateKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.dhKeyAgreement, new DHParameter(this.dhSpec.getP(), this.dhSpec.getG(), this.dhSpec.getL()).toASN1Primitive()), new ASN1Integer(getX())).getEncoded("DER");
      return (byte[])localObject;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return null;
  }
  
  public String getFormat()
  {
    return "PKCS#8";
  }
  
  public DHParameterSpec getParams()
  {
    return this.dhSpec;
  }
  
  public BigInteger getX()
  {
    return this.x;
  }
  
  public int hashCode()
  {
    return getX().hashCode() ^ getParams().getG().hashCode() ^ getParams().getP().hashCode() ^ getParams().getL();
  }
  
  public void setBagAttribute(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Encodable paramASN1Encodable)
  {
    this.attrCarrier.setBagAttribute(paramASN1ObjectIdentifier, paramASN1Encodable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\dh\BCDHPrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */