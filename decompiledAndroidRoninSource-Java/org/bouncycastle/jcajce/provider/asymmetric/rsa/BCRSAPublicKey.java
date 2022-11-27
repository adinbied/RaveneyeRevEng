package org.bouncycastle.jcajce.provider.asymmetric.rsa;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.spec.RSAPublicKeySpec;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.bouncycastle.util.Strings;

public class BCRSAPublicKey
  implements java.security.interfaces.RSAPublicKey
{
  private static final AlgorithmIdentifier DEFAULT_ALGORITHM_IDENTIFIER = new AlgorithmIdentifier(PKCSObjectIdentifiers.rsaEncryption, DERNull.INSTANCE);
  static final long serialVersionUID = 2675817738516720772L;
  private transient AlgorithmIdentifier algorithmIdentifier;
  private BigInteger modulus;
  private BigInteger publicExponent;
  
  BCRSAPublicKey(java.security.interfaces.RSAPublicKey paramRSAPublicKey)
  {
    this.algorithmIdentifier = DEFAULT_ALGORITHM_IDENTIFIER;
    this.modulus = paramRSAPublicKey.getModulus();
    this.publicExponent = paramRSAPublicKey.getPublicExponent();
  }
  
  BCRSAPublicKey(RSAPublicKeySpec paramRSAPublicKeySpec)
  {
    this.algorithmIdentifier = DEFAULT_ALGORITHM_IDENTIFIER;
    this.modulus = paramRSAPublicKeySpec.getModulus();
    this.publicExponent = paramRSAPublicKeySpec.getPublicExponent();
  }
  
  BCRSAPublicKey(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
  {
    populateFromPublicKeyInfo(paramSubjectPublicKeyInfo);
  }
  
  BCRSAPublicKey(RSAKeyParameters paramRSAKeyParameters)
  {
    this.algorithmIdentifier = DEFAULT_ALGORITHM_IDENTIFIER;
    this.modulus = paramRSAKeyParameters.getModulus();
    this.publicExponent = paramRSAKeyParameters.getExponent();
  }
  
  private void populateFromPublicKeyInfo(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
  {
    try
    {
      org.bouncycastle.asn1.pkcs.RSAPublicKey localRSAPublicKey = org.bouncycastle.asn1.pkcs.RSAPublicKey.getInstance(paramSubjectPublicKeyInfo.parsePublicKey());
      this.algorithmIdentifier = paramSubjectPublicKeyInfo.getAlgorithm();
      this.modulus = localRSAPublicKey.getModulus();
      this.publicExponent = localRSAPublicKey.getPublicExponent();
      return;
    }
    catch (IOException paramSubjectPublicKeyInfo)
    {
      for (;;) {}
    }
    throw new IllegalArgumentException("invalid info structure in RSA public key");
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    try
    {
      this.algorithmIdentifier = AlgorithmIdentifier.getInstance(paramObjectInputStream.readObject());
      return;
    }
    catch (Exception paramObjectInputStream)
    {
      for (;;) {}
    }
    this.algorithmIdentifier = DEFAULT_ALGORITHM_IDENTIFIER;
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    if (!this.algorithmIdentifier.equals(DEFAULT_ALGORITHM_IDENTIFIER)) {
      paramObjectOutputStream.writeObject(this.algorithmIdentifier.getEncoded());
    }
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
    return KeyUtil.getEncodedSubjectPublicKeyInfo(this.algorithmIdentifier, new org.bouncycastle.asn1.pkcs.RSAPublicKey(getModulus(), getPublicExponent()));
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\rsa\BCRSAPublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */