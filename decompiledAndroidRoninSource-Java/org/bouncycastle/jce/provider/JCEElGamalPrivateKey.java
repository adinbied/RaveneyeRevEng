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
import org.bouncycastle.asn1.oiw.ElGamalParameter;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.params.ElGamalParameters;
import org.bouncycastle.crypto.params.ElGamalPrivateKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.bouncycastle.jce.interfaces.ElGamalPrivateKey;
import org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.bouncycastle.jce.spec.ElGamalParameterSpec;
import org.bouncycastle.jce.spec.ElGamalPrivateKeySpec;

public class JCEElGamalPrivateKey
  implements ElGamalPrivateKey, DHPrivateKey, PKCS12BagAttributeCarrier
{
  static final long serialVersionUID = 4819350091141529678L;
  private PKCS12BagAttributeCarrierImpl attrCarrier = new PKCS12BagAttributeCarrierImpl();
  ElGamalParameterSpec elSpec;
  BigInteger x;
  
  protected JCEElGamalPrivateKey() {}
  
  JCEElGamalPrivateKey(DHPrivateKey paramDHPrivateKey)
  {
    this.x = paramDHPrivateKey.getX();
    this.elSpec = new ElGamalParameterSpec(paramDHPrivateKey.getParams().getP(), paramDHPrivateKey.getParams().getG());
  }
  
  JCEElGamalPrivateKey(DHPrivateKeySpec paramDHPrivateKeySpec)
  {
    this.x = paramDHPrivateKeySpec.getX();
    this.elSpec = new ElGamalParameterSpec(paramDHPrivateKeySpec.getP(), paramDHPrivateKeySpec.getG());
  }
  
  JCEElGamalPrivateKey(PrivateKeyInfo paramPrivateKeyInfo)
    throws IOException
  {
    ElGamalParameter localElGamalParameter = ElGamalParameter.getInstance(paramPrivateKeyInfo.getPrivateKeyAlgorithm().getParameters());
    this.x = ASN1Integer.getInstance(paramPrivateKeyInfo.parsePrivateKey()).getValue();
    this.elSpec = new ElGamalParameterSpec(localElGamalParameter.getP(), localElGamalParameter.getG());
  }
  
  JCEElGamalPrivateKey(ElGamalPrivateKeyParameters paramElGamalPrivateKeyParameters)
  {
    this.x = paramElGamalPrivateKeyParameters.getX();
    this.elSpec = new ElGamalParameterSpec(paramElGamalPrivateKeyParameters.getParameters().getP(), paramElGamalPrivateKeyParameters.getParameters().getG());
  }
  
  JCEElGamalPrivateKey(ElGamalPrivateKey paramElGamalPrivateKey)
  {
    this.x = paramElGamalPrivateKey.getX();
    this.elSpec = paramElGamalPrivateKey.getParameters();
  }
  
  JCEElGamalPrivateKey(ElGamalPrivateKeySpec paramElGamalPrivateKeySpec)
  {
    this.x = paramElGamalPrivateKeySpec.getX();
    this.elSpec = new ElGamalParameterSpec(paramElGamalPrivateKeySpec.getParams().getP(), paramElGamalPrivateKeySpec.getParams().getG());
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    this.x = ((BigInteger)paramObjectInputStream.readObject());
    this.elSpec = new ElGamalParameterSpec((BigInteger)paramObjectInputStream.readObject(), (BigInteger)paramObjectInputStream.readObject());
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeObject(getX());
    paramObjectOutputStream.writeObject(this.elSpec.getP());
    paramObjectOutputStream.writeObject(this.elSpec.getG());
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
    return KeyUtil.getEncodedPrivateKeyInfo(new AlgorithmIdentifier(OIWObjectIdentifiers.elGamalAlgorithm, new ElGamalParameter(this.elSpec.getP(), this.elSpec.getG())), new ASN1Integer(getX()));
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
  
  public void setBagAttribute(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Encodable paramASN1Encodable)
  {
    this.attrCarrier.setBagAttribute(paramASN1ObjectIdentifier, paramASN1Encodable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\provider\JCEElGamalPrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */