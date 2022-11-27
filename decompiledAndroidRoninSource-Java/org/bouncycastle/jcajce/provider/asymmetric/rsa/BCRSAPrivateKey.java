package org.bouncycastle.jcajce.provider.asymmetric.rsa;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.spec.RSAPrivateKeySpec;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;

public class BCRSAPrivateKey
  implements java.security.interfaces.RSAPrivateKey, PKCS12BagAttributeCarrier
{
  private static BigInteger ZERO = BigInteger.valueOf(0L);
  static final long serialVersionUID = 5110188922551353628L;
  private transient PKCS12BagAttributeCarrierImpl attrCarrier = new PKCS12BagAttributeCarrierImpl();
  protected BigInteger modulus;
  protected BigInteger privateExponent;
  
  protected BCRSAPrivateKey() {}
  
  BCRSAPrivateKey(java.security.interfaces.RSAPrivateKey paramRSAPrivateKey)
  {
    this.modulus = paramRSAPrivateKey.getModulus();
    this.privateExponent = paramRSAPrivateKey.getPrivateExponent();
  }
  
  BCRSAPrivateKey(RSAPrivateKeySpec paramRSAPrivateKeySpec)
  {
    this.modulus = paramRSAPrivateKeySpec.getModulus();
    this.privateExponent = paramRSAPrivateKeySpec.getPrivateExponent();
  }
  
  BCRSAPrivateKey(org.bouncycastle.asn1.pkcs.RSAPrivateKey paramRSAPrivateKey)
  {
    this.modulus = paramRSAPrivateKey.getModulus();
    this.privateExponent = paramRSAPrivateKey.getPrivateExponent();
  }
  
  BCRSAPrivateKey(RSAKeyParameters paramRSAKeyParameters)
  {
    this.modulus = paramRSAKeyParameters.getModulus();
    this.privateExponent = paramRSAKeyParameters.getExponent();
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof java.security.interfaces.RSAPrivateKey;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    if (paramObject == this) {
      return true;
    }
    paramObject = (java.security.interfaces.RSAPrivateKey)paramObject;
    bool1 = bool2;
    if (getModulus().equals(((java.security.interfaces.RSAPrivateKey)paramObject).getModulus()))
    {
      bool1 = bool2;
      if (getPrivateExponent().equals(((java.security.interfaces.RSAPrivateKey)paramObject).getPrivateExponent())) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String getAlgorithm()
  {
    return "RSA";
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
    AlgorithmIdentifier localAlgorithmIdentifier = new AlgorithmIdentifier(PKCSObjectIdentifiers.rsaEncryption, DERNull.INSTANCE);
    BigInteger localBigInteger1 = getModulus();
    BigInteger localBigInteger2 = ZERO;
    BigInteger localBigInteger3 = getPrivateExponent();
    BigInteger localBigInteger4 = ZERO;
    return KeyUtil.getEncodedPrivateKeyInfo(localAlgorithmIdentifier, new org.bouncycastle.asn1.pkcs.RSAPrivateKey(localBigInteger1, localBigInteger2, localBigInteger3, localBigInteger4, localBigInteger4, localBigInteger4, localBigInteger4, localBigInteger4));
  }
  
  public String getFormat()
  {
    return "PKCS#8";
  }
  
  public BigInteger getModulus()
  {
    return this.modulus;
  }
  
  public BigInteger getPrivateExponent()
  {
    return this.privateExponent;
  }
  
  public int hashCode()
  {
    return getModulus().hashCode() ^ getPrivateExponent().hashCode();
  }
  
  public void setBagAttribute(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Encodable paramASN1Encodable)
  {
    this.attrCarrier.setBagAttribute(paramASN1ObjectIdentifier, paramASN1Encodable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\rsa\BCRSAPrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */