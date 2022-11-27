package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.math.BigInteger;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.RSAPrivateCrtKeySpec;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.pkcs.RSAPrivateKey;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.bouncycastle.util.Strings;

public class JCERSAPrivateCrtKey
  extends JCERSAPrivateKey
  implements RSAPrivateCrtKey
{
  static final long serialVersionUID = 7834723820638524718L;
  private BigInteger crtCoefficient;
  private BigInteger primeExponentP;
  private BigInteger primeExponentQ;
  private BigInteger primeP;
  private BigInteger primeQ;
  private BigInteger publicExponent;
  
  JCERSAPrivateCrtKey(RSAPrivateCrtKey paramRSAPrivateCrtKey)
  {
    this.modulus = paramRSAPrivateCrtKey.getModulus();
    this.publicExponent = paramRSAPrivateCrtKey.getPublicExponent();
    this.privateExponent = paramRSAPrivateCrtKey.getPrivateExponent();
    this.primeP = paramRSAPrivateCrtKey.getPrimeP();
    this.primeQ = paramRSAPrivateCrtKey.getPrimeQ();
    this.primeExponentP = paramRSAPrivateCrtKey.getPrimeExponentP();
    this.primeExponentQ = paramRSAPrivateCrtKey.getPrimeExponentQ();
    this.crtCoefficient = paramRSAPrivateCrtKey.getCrtCoefficient();
  }
  
  JCERSAPrivateCrtKey(RSAPrivateCrtKeySpec paramRSAPrivateCrtKeySpec)
  {
    this.modulus = paramRSAPrivateCrtKeySpec.getModulus();
    this.publicExponent = paramRSAPrivateCrtKeySpec.getPublicExponent();
    this.privateExponent = paramRSAPrivateCrtKeySpec.getPrivateExponent();
    this.primeP = paramRSAPrivateCrtKeySpec.getPrimeP();
    this.primeQ = paramRSAPrivateCrtKeySpec.getPrimeQ();
    this.primeExponentP = paramRSAPrivateCrtKeySpec.getPrimeExponentP();
    this.primeExponentQ = paramRSAPrivateCrtKeySpec.getPrimeExponentQ();
    this.crtCoefficient = paramRSAPrivateCrtKeySpec.getCrtCoefficient();
  }
  
  JCERSAPrivateCrtKey(PrivateKeyInfo paramPrivateKeyInfo)
    throws IOException
  {
    this(RSAPrivateKey.getInstance(paramPrivateKeyInfo.parsePrivateKey()));
  }
  
  JCERSAPrivateCrtKey(RSAPrivateKey paramRSAPrivateKey)
  {
    this.modulus = paramRSAPrivateKey.getModulus();
    this.publicExponent = paramRSAPrivateKey.getPublicExponent();
    this.privateExponent = paramRSAPrivateKey.getPrivateExponent();
    this.primeP = paramRSAPrivateKey.getPrime1();
    this.primeQ = paramRSAPrivateKey.getPrime2();
    this.primeExponentP = paramRSAPrivateKey.getExponent1();
    this.primeExponentQ = paramRSAPrivateKey.getExponent2();
    this.crtCoefficient = paramRSAPrivateKey.getCoefficient();
  }
  
  JCERSAPrivateCrtKey(RSAPrivateCrtKeyParameters paramRSAPrivateCrtKeyParameters)
  {
    super(paramRSAPrivateCrtKeyParameters);
    this.publicExponent = paramRSAPrivateCrtKeyParameters.getPublicExponent();
    this.primeP = paramRSAPrivateCrtKeyParameters.getP();
    this.primeQ = paramRSAPrivateCrtKeyParameters.getQ();
    this.primeExponentP = paramRSAPrivateCrtKeyParameters.getDP();
    this.primeExponentQ = paramRSAPrivateCrtKeyParameters.getDQ();
    this.crtCoefficient = paramRSAPrivateCrtKeyParameters.getQInv();
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof RSAPrivateCrtKey)) {
      return false;
    }
    paramObject = (RSAPrivateCrtKey)paramObject;
    return (getModulus().equals(((RSAPrivateCrtKey)paramObject).getModulus())) && (getPublicExponent().equals(((RSAPrivateCrtKey)paramObject).getPublicExponent())) && (getPrivateExponent().equals(((RSAPrivateCrtKey)paramObject).getPrivateExponent())) && (getPrimeP().equals(((RSAPrivateCrtKey)paramObject).getPrimeP())) && (getPrimeQ().equals(((RSAPrivateCrtKey)paramObject).getPrimeQ())) && (getPrimeExponentP().equals(((RSAPrivateCrtKey)paramObject).getPrimeExponentP())) && (getPrimeExponentQ().equals(((RSAPrivateCrtKey)paramObject).getPrimeExponentQ())) && (getCrtCoefficient().equals(((RSAPrivateCrtKey)paramObject).getCrtCoefficient()));
  }
  
  public BigInteger getCrtCoefficient()
  {
    return this.crtCoefficient;
  }
  
  public byte[] getEncoded()
  {
    return KeyUtil.getEncodedPrivateKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.rsaEncryption, DERNull.INSTANCE), new RSAPrivateKey(getModulus(), getPublicExponent(), getPrivateExponent(), getPrimeP(), getPrimeQ(), getPrimeExponentP(), getPrimeExponentQ(), getCrtCoefficient()));
  }
  
  public String getFormat()
  {
    return "PKCS#8";
  }
  
  public BigInteger getPrimeExponentP()
  {
    return this.primeExponentP;
  }
  
  public BigInteger getPrimeExponentQ()
  {
    return this.primeExponentQ;
  }
  
  public BigInteger getPrimeP()
  {
    return this.primeP;
  }
  
  public BigInteger getPrimeQ()
  {
    return this.primeQ;
  }
  
  public BigInteger getPublicExponent()
  {
    return this.publicExponent;
  }
  
  public int hashCode()
  {
    return getModulus().hashCode() ^ getPublicExponent().hashCode() ^ getPrivateExponent().hashCode();
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str = Strings.lineSeparator();
    localStringBuffer.append("RSA Private CRT Key");
    localStringBuffer.append(str);
    localStringBuffer.append("            modulus: ");
    localStringBuffer.append(getModulus().toString(16));
    localStringBuffer.append(str);
    localStringBuffer.append("    public exponent: ");
    localStringBuffer.append(getPublicExponent().toString(16));
    localStringBuffer.append(str);
    localStringBuffer.append("   private exponent: ");
    localStringBuffer.append(getPrivateExponent().toString(16));
    localStringBuffer.append(str);
    localStringBuffer.append("             primeP: ");
    localStringBuffer.append(getPrimeP().toString(16));
    localStringBuffer.append(str);
    localStringBuffer.append("             primeQ: ");
    localStringBuffer.append(getPrimeQ().toString(16));
    localStringBuffer.append(str);
    localStringBuffer.append("     primeExponentP: ");
    localStringBuffer.append(getPrimeExponentP().toString(16));
    localStringBuffer.append(str);
    localStringBuffer.append("     primeExponentQ: ");
    localStringBuffer.append(getPrimeExponentQ().toString(16));
    localStringBuffer.append(str);
    localStringBuffer.append("     crtCoefficient: ");
    localStringBuffer.append(getCrtCoefficient().toString(16));
    localStringBuffer.append(str);
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\provider\JCERSAPrivateCrtKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */