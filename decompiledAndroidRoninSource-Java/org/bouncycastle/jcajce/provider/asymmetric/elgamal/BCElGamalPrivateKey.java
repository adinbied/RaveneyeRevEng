package org.bouncycastle.jcajce.provider.asymmetric.elgamal;

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
import org.bouncycastle.asn1.oiw.ElGamalParameter;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.params.ElGamalParameters;
import org.bouncycastle.crypto.params.ElGamalPrivateKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.bouncycastle.jce.interfaces.ElGamalPrivateKey;
import org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.bouncycastle.jce.spec.ElGamalParameterSpec;
import org.bouncycastle.jce.spec.ElGamalPrivateKeySpec;

public class BCElGamalPrivateKey
  implements ElGamalPrivateKey, DHPrivateKey, PKCS12BagAttributeCarrier
{
  static final long serialVersionUID = 4819350091141529678L;
  private transient PKCS12BagAttributeCarrierImpl attrCarrier = new PKCS12BagAttributeCarrierImpl();
  private transient ElGamalParameterSpec elSpec;
  private BigInteger x;
  
  protected BCElGamalPrivateKey() {}
  
  BCElGamalPrivateKey(DHPrivateKey paramDHPrivateKey)
  {
    this.x = paramDHPrivateKey.getX();
    this.elSpec = new ElGamalParameterSpec(paramDHPrivateKey.getParams().getP(), paramDHPrivateKey.getParams().getG());
  }
  
  BCElGamalPrivateKey(DHPrivateKeySpec paramDHPrivateKeySpec)
  {
    this.x = paramDHPrivateKeySpec.getX();
    this.elSpec = new ElGamalParameterSpec(paramDHPrivateKeySpec.getP(), paramDHPrivateKeySpec.getG());
  }
  
  BCElGamalPrivateKey(PrivateKeyInfo paramPrivateKeyInfo)
    throws IOException
  {
    ElGamalParameter localElGamalParameter = ElGamalParameter.getInstance(paramPrivateKeyInfo.getPrivateKeyAlgorithm().getParameters());
    this.x = ASN1Integer.getInstance(paramPrivateKeyInfo.parsePrivateKey()).getValue();
    this.elSpec = new ElGamalParameterSpec(localElGamalParameter.getP(), localElGamalParameter.getG());
  }
  
  BCElGamalPrivateKey(ElGamalPrivateKeyParameters paramElGamalPrivateKeyParameters)
  {
    this.x = paramElGamalPrivateKeyParameters.getX();
    this.elSpec = new ElGamalParameterSpec(paramElGamalPrivateKeyParameters.getParameters().getP(), paramElGamalPrivateKeyParameters.getParameters().getG());
  }
  
  BCElGamalPrivateKey(ElGamalPrivateKey paramElGamalPrivateKey)
  {
    this.x = paramElGamalPrivateKey.getX();
    this.elSpec = paramElGamalPrivateKey.getParameters();
  }
  
  BCElGamalPrivateKey(ElGamalPrivateKeySpec paramElGamalPrivateKeySpec)
  {
    this.x = paramElGamalPrivateKeySpec.getX();
    this.elSpec = new ElGamalParameterSpec(paramElGamalPrivateKeySpec.getParams().getP(), paramElGamalPrivateKeySpec.getParams().getG());
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    this.elSpec = new ElGamalParameterSpec((BigInteger)paramObjectInputStream.readObject(), (BigInteger)paramObjectInputStream.readObject());
    this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeObject(this.elSpec.getP());
    paramObjectOutputStream.writeObject(this.elSpec.getG());
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
    return "ElGamal";
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
      byte[] arrayOfByte = new PrivateKeyInfo(new AlgorithmIdentifier(OIWObjectIdentifiers.elGamalAlgorithm, new ElGamalParameter(this.elSpec.getP(), this.elSpec.getG())), new ASN1Integer(getX())).getEncoded("DER");
      return arrayOfByte;
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
  
  public ElGamalParameterSpec getParameters()
  {
    return this.elSpec;
  }
  
  public DHParameterSpec getParams()
  {
    return new DHParameterSpec(this.elSpec.getP(), this.elSpec.getG());
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\elgamal\BCElGamalPrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */