package org.bouncycastle.jce.provider;

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
import org.bouncycastle.asn1.x9.DHDomainParameters;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHPrivateKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;

public class JCEDHPrivateKey
  implements DHPrivateKey, PKCS12BagAttributeCarrier
{
  static final long serialVersionUID = 311058815616901812L;
  private PKCS12BagAttributeCarrier attrCarrier = new PKCS12BagAttributeCarrierImpl();
  private DHParameterSpec dhSpec;
  private PrivateKeyInfo info;
  BigInteger x;
  
  protected JCEDHPrivateKey() {}
  
  JCEDHPrivateKey(DHPrivateKey paramDHPrivateKey)
  {
    this.x = paramDHPrivateKey.getX();
    this.dhSpec = paramDHPrivateKey.getParams();
  }
  
  JCEDHPrivateKey(DHPrivateKeySpec paramDHPrivateKeySpec)
  {
    this.x = paramDHPrivateKeySpec.getX();
    this.dhSpec = new DHParameterSpec(paramDHPrivateKeySpec.getP(), paramDHPrivateKeySpec.getG());
  }
  
  JCEDHPrivateKey(PrivateKeyInfo paramPrivateKeyInfo)
    throws IOException
  {
    ASN1Sequence localASN1Sequence = ASN1Sequence.getInstance(paramPrivateKeyInfo.getAlgorithmId().getParameters());
    ASN1Integer localASN1Integer = ASN1Integer.getInstance(paramPrivateKeyInfo.parsePrivateKey());
    ASN1ObjectIdentifier localASN1ObjectIdentifier = paramPrivateKeyInfo.getAlgorithmId().getAlgorithm();
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
        break label167;
      }
      paramPrivateKeyInfo = DHDomainParameters.getInstance(localASN1Sequence);
      paramPrivateKeyInfo = new DHParameterSpec(paramPrivateKeyInfo.getP().getValue(), paramPrivateKeyInfo.getG().getValue());
    }
    this.dhSpec = paramPrivateKeyInfo;
    return;
    label167:
    paramPrivateKeyInfo = new StringBuilder();
    paramPrivateKeyInfo.append("unknown algorithm type: ");
    paramPrivateKeyInfo.append(localASN1ObjectIdentifier);
    throw new IllegalArgumentException(paramPrivateKeyInfo.toString());
  }
  
  JCEDHPrivateKey(DHPrivateKeyParameters paramDHPrivateKeyParameters)
  {
    this.x = paramDHPrivateKeyParameters.getX();
    this.dhSpec = new DHParameterSpec(paramDHPrivateKeyParameters.getParameters().getP(), paramDHPrivateKeyParameters.getParameters().getG(), paramDHPrivateKeyParameters.getParameters().getL());
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    this.x = ((BigInteger)paramObjectInputStream.readObject());
    this.dhSpec = new DHParameterSpec((BigInteger)paramObjectInputStream.readObject(), (BigInteger)paramObjectInputStream.readObject(), paramObjectInputStream.readInt());
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeObject(getX());
    paramObjectOutputStream.writeObject(this.dhSpec.getP());
    paramObjectOutputStream.writeObject(this.dhSpec.getG());
    paramObjectOutputStream.writeInt(this.dhSpec.getL());
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
      localObject = new PrivateKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.dhKeyAgreement, new DHParameter(this.dhSpec.getP(), this.dhSpec.getG(), this.dhSpec.getL())), new ASN1Integer(getX())).getEncoded("DER");
      return (byte[])localObject;
    }
    catch (IOException localIOException)
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
  
  public void setBagAttribute(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Encodable paramASN1Encodable)
  {
    this.attrCarrier.setBagAttribute(paramASN1ObjectIdentifier, paramASN1Encodable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\provider\JCEDHPrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */