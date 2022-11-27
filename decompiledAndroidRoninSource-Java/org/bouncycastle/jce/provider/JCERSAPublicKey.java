package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.math.BigInteger;
import java.security.spec.RSAPublicKeySpec;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.bouncycastle.util.Strings;

public class JCERSAPublicKey
  implements java.security.interfaces.RSAPublicKey
{
  static final long serialVersionUID = 2675817738516720772L;
  private BigInteger modulus;
  private BigInteger publicExponent;
  
  JCERSAPublicKey(java.security.interfaces.RSAPublicKey paramRSAPublicKey)
  {
    this.modulus = paramRSAPublicKey.getModulus();
    this.publicExponent = paramRSAPublicKey.getPublicExponent();
  }
  
  JCERSAPublicKey(RSAPublicKeySpec paramRSAPublicKeySpec)
  {
    this.modulus = paramRSAPublicKeySpec.getModulus();
    this.publicExponent = paramRSAPublicKeySpec.getPublicExponent();
  }
  
  JCERSAPublicKey(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
  {
    try
    {
      paramSubjectPublicKeyInfo = org.bouncycastle.asn1.pkcs.RSAPublicKey.getInstance(paramSubjectPublicKeyInfo.parsePublicKey());
      this.modulus = paramSubjectPublicKeyInfo.getModulus();
      this.publicExponent = paramSubjectPublicKeyInfo.getPublicExponent();
      return;
    }
    catch (IOException paramSubjectPublicKeyInfo)
    {
      for (;;) {}
    }
    throw new IllegalArgumentException("invalid info structure in RSA public key");
  }
  
  JCERSAPublicKey(RSAKeyParameters paramRSAKeyParameters)
  {
    this.modulus = paramRSAKeyParameters.getModulus();
    this.publicExponent = paramRSAKeyParameters.getExponent();
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof java.security.interfaces.RSAPublicKey)) {
      return false;
    }
    paramObject = (java.security.interfaces.RSAPublicKey)paramObject;
    return (getModulus().equals(((java.security.interfaces.RSAPublicKey)paramObject).getModulus())) && (getPublicExponent().equals(((java.security.interfaces.RSAPublicKey)paramObject).getPublicExponent()));
  }
  
  public String getAlgorithm()
  {
    return "RSA";
  }
  
  public byte[] getEncoded()
  {
    return KeyUtil.getEncodedSubjectPublicKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.rsaEncryption, DERNull.INSTANCE), new org.bouncycastle.asn1.pkcs.RSAPublicKey(getModulus(), getPublicExponent()));
  }
  
  public String getFormat()
  {
    return "X.509";
  }
  
  public BigInteger getModulus()
  {
    return this.modulus;
  }
  
  public BigInteger getPublicExponent()
  {
    return this.publicExponent;
  }
  
  public int hashCode()
  {
    return getModulus().hashCode() ^ getPublicExponent().hashCode();
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str = Strings.lineSeparator();
    localStringBuffer.append("RSA Public Key");
    localStringBuffer.append(str);
    localStringBuffer.append("            modulus: ");
    localStringBuffer.append(getModulus().toString(16));
    localStringBuffer.append(str);
    localStringBuffer.append("    public exponent: ");
    localStringBuffer.append(getPublicExponent().toString(16));
    localStringBuffer.append(str);
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\provider\JCERSAPublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */