package org.bouncycastle.jcajce.provider.asymmetric.ec;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jce.interfaces.ECPointEncoder;
import org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.util.Strings;

public class BCECPrivateKey
  implements java.security.interfaces.ECPrivateKey, org.bouncycastle.jce.interfaces.ECPrivateKey, PKCS12BagAttributeCarrier, ECPointEncoder
{
  static final long serialVersionUID = 994553197664784084L;
  private String algorithm = "EC";
  private transient PKCS12BagAttributeCarrierImpl attrCarrier = new PKCS12BagAttributeCarrierImpl();
  private transient ProviderConfiguration configuration;
  private transient BigInteger d;
  private transient java.security.spec.ECParameterSpec ecSpec;
  private transient DERBitString publicKey;
  private boolean withCompression;
  
  protected BCECPrivateKey() {}
  
  public BCECPrivateKey(String paramString, java.security.spec.ECPrivateKeySpec paramECPrivateKeySpec, ProviderConfiguration paramProviderConfiguration)
  {
    this.algorithm = paramString;
    this.d = paramECPrivateKeySpec.getS();
    this.ecSpec = paramECPrivateKeySpec.getParams();
    this.configuration = paramProviderConfiguration;
  }
  
  BCECPrivateKey(String paramString, PrivateKeyInfo paramPrivateKeyInfo, ProviderConfiguration paramProviderConfiguration)
    throws IOException
  {
    this.algorithm = paramString;
    this.configuration = paramProviderConfiguration;
    populateFromPrivKeyInfo(paramPrivateKeyInfo);
  }
  
  public BCECPrivateKey(String paramString, ECPrivateKeyParameters paramECPrivateKeyParameters, BCECPublicKey paramBCECPublicKey, java.security.spec.ECParameterSpec paramECParameterSpec, ProviderConfiguration paramProviderConfiguration)
  {
    ECDomainParameters localECDomainParameters = paramECPrivateKeyParameters.getParameters();
    this.algorithm = paramString;
    this.d = paramECPrivateKeyParameters.getD();
    this.configuration = paramProviderConfiguration;
    if (paramECParameterSpec == null) {
      this.ecSpec = new java.security.spec.ECParameterSpec(EC5Util.convertCurve(localECDomainParameters.getCurve(), localECDomainParameters.getSeed()), new java.security.spec.ECPoint(localECDomainParameters.getG().getAffineXCoord().toBigInteger(), localECDomainParameters.getG().getAffineYCoord().toBigInteger()), localECDomainParameters.getN(), localECDomainParameters.getH().intValue());
    } else {
      this.ecSpec = paramECParameterSpec;
    }
    this.publicKey = getPublicKeyDetails(paramBCECPublicKey);
  }
  
  public BCECPrivateKey(String paramString, ECPrivateKeyParameters paramECPrivateKeyParameters, BCECPublicKey paramBCECPublicKey, org.bouncycastle.jce.spec.ECParameterSpec paramECParameterSpec, ProviderConfiguration paramProviderConfiguration)
  {
    ECDomainParameters localECDomainParameters = paramECPrivateKeyParameters.getParameters();
    this.algorithm = paramString;
    this.d = paramECPrivateKeyParameters.getD();
    this.configuration = paramProviderConfiguration;
    if (paramECParameterSpec == null) {
      this.ecSpec = new java.security.spec.ECParameterSpec(EC5Util.convertCurve(localECDomainParameters.getCurve(), localECDomainParameters.getSeed()), new java.security.spec.ECPoint(localECDomainParameters.getG().getAffineXCoord().toBigInteger(), localECDomainParameters.getG().getAffineYCoord().toBigInteger()), localECDomainParameters.getN(), localECDomainParameters.getH().intValue());
    } else {
      this.ecSpec = EC5Util.convertSpec(EC5Util.convertCurve(paramECParameterSpec.getCurve(), paramECParameterSpec.getSeed()), paramECParameterSpec);
    }
    try
    {
      this.publicKey = getPublicKeyDetails(paramBCECPublicKey);
      return;
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
    this.publicKey = null;
  }
  
  public BCECPrivateKey(String paramString, ECPrivateKeyParameters paramECPrivateKeyParameters, ProviderConfiguration paramProviderConfiguration)
  {
    this.algorithm = paramString;
    this.d = paramECPrivateKeyParameters.getD();
    this.ecSpec = null;
    this.configuration = paramProviderConfiguration;
  }
  
  public BCECPrivateKey(String paramString, BCECPrivateKey paramBCECPrivateKey)
  {
    this.algorithm = paramString;
    this.d = paramBCECPrivateKey.d;
    this.ecSpec = paramBCECPrivateKey.ecSpec;
    this.withCompression = paramBCECPrivateKey.withCompression;
    this.attrCarrier = paramBCECPrivateKey.attrCarrier;
    this.publicKey = paramBCECPrivateKey.publicKey;
    this.configuration = paramBCECPrivateKey.configuration;
  }
  
  public BCECPrivateKey(String paramString, org.bouncycastle.jce.spec.ECPrivateKeySpec paramECPrivateKeySpec, ProviderConfiguration paramProviderConfiguration)
  {
    this.algorithm = paramString;
    this.d = paramECPrivateKeySpec.getD();
    if (paramECPrivateKeySpec.getParams() != null) {
      paramString = EC5Util.convertSpec(EC5Util.convertCurve(paramECPrivateKeySpec.getParams().getCurve(), paramECPrivateKeySpec.getParams().getSeed()), paramECPrivateKeySpec.getParams());
    } else {
      paramString = null;
    }
    this.ecSpec = paramString;
    this.configuration = paramProviderConfiguration;
  }
  
  public BCECPrivateKey(java.security.interfaces.ECPrivateKey paramECPrivateKey, ProviderConfiguration paramProviderConfiguration)
  {
    this.d = paramECPrivateKey.getS();
    this.algorithm = paramECPrivateKey.getAlgorithm();
    this.ecSpec = paramECPrivateKey.getParams();
    this.configuration = paramProviderConfiguration;
  }
  
  private DERBitString getPublicKeyDetails(BCECPublicKey paramBCECPublicKey)
  {
    try
    {
      paramBCECPublicKey = SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray(paramBCECPublicKey.getEncoded())).getPublicKeyData();
      return paramBCECPublicKey;
    }
    catch (IOException paramBCECPublicKey)
    {
      for (;;) {}
    }
    return null;
  }
  
  private void populateFromPrivKeyInfo(PrivateKeyInfo paramPrivateKeyInfo)
    throws IOException
  {
    X962Parameters localX962Parameters = X962Parameters.getInstance(paramPrivateKeyInfo.getPrivateKeyAlgorithm().getParameters());
    this.ecSpec = EC5Util.convertToSpec(localX962Parameters, EC5Util.getCurve(this.configuration, localX962Parameters));
    paramPrivateKeyInfo = paramPrivateKeyInfo.parsePrivateKey();
    if ((paramPrivateKeyInfo instanceof ASN1Integer))
    {
      this.d = ASN1Integer.getInstance(paramPrivateKeyInfo).getValue();
      return;
    }
    paramPrivateKeyInfo = org.bouncycastle.asn1.sec.ECPrivateKey.getInstance(paramPrivateKeyInfo);
    this.d = paramPrivateKeyInfo.getKey();
    this.publicKey = paramPrivateKeyInfo.getPublicKey();
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    paramObjectInputStream = (byte[])paramObjectInputStream.readObject();
    this.configuration = BouncyCastleProvider.CONFIGURATION;
    populateFromPrivKeyInfo(PrivateKeyInfo.getInstance(ASN1Primitive.fromByteArray(paramObjectInputStream)));
    this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeObject(getEncoded());
  }
  
  org.bouncycastle.jce.spec.ECParameterSpec engineGetSpec()
  {
    java.security.spec.ECParameterSpec localECParameterSpec = this.ecSpec;
    if (localECParameterSpec != null) {
      return EC5Util.convertSpec(localECParameterSpec, this.withCompression);
    }
    return this.configuration.getEcImplicitlyCa();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof BCECPrivateKey;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (BCECPrivateKey)paramObject;
    bool1 = bool2;
    if (getD().equals(((BCECPrivateKey)paramObject).getD()))
    {
      bool1 = bool2;
      if (engineGetSpec().equals(((BCECPrivateKey)paramObject).engineGetSpec())) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String getAlgorithm()
  {
    return this.algorithm;
  }
  
  public ASN1Encodable getBagAttribute(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    return this.attrCarrier.getBagAttribute(paramASN1ObjectIdentifier);
  }
  
  public Enumeration getBagAttributeKeys()
  {
    return this.attrCarrier.getBagAttributeKeys();
  }
  
  public BigInteger getD()
  {
    return this.d;
  }
  
  public byte[] getEncoded()
  {
    X962Parameters localX962Parameters = ECUtils.getDomainParametersFromName(this.ecSpec, this.withCompression);
    Object localObject = this.ecSpec;
    int i;
    if (localObject == null) {
      i = ECUtil.getOrderBitLength(this.configuration, null, getS());
    } else {
      i = ECUtil.getOrderBitLength(this.configuration, ((java.security.spec.ECParameterSpec)localObject).getOrder(), getS());
    }
    if (this.publicKey != null) {
      localObject = new org.bouncycastle.asn1.sec.ECPrivateKey(i, getS(), this.publicKey, localX962Parameters);
    } else {
      localObject = new org.bouncycastle.asn1.sec.ECPrivateKey(i, getS(), localX962Parameters);
    }
    try
    {
      localObject = new PrivateKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, localX962Parameters), (ASN1Encodable)localObject).getEncoded("DER");
      return (byte[])localObject;
    }
    catch (IOException localIOException) {}
    return null;
  }
  
  public String getFormat()
  {
    return "PKCS#8";
  }
  
  public org.bouncycastle.jce.spec.ECParameterSpec getParameters()
  {
    java.security.spec.ECParameterSpec localECParameterSpec = this.ecSpec;
    if (localECParameterSpec == null) {
      return null;
    }
    return EC5Util.convertSpec(localECParameterSpec, this.withCompression);
  }
  
  public java.security.spec.ECParameterSpec getParams()
  {
    return this.ecSpec;
  }
  
  public BigInteger getS()
  {
    return this.d;
  }
  
  public int hashCode()
  {
    return getD().hashCode() ^ engineGetSpec().hashCode();
  }
  
  public void setBagAttribute(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Encodable paramASN1Encodable)
  {
    this.attrCarrier.setBagAttribute(paramASN1ObjectIdentifier, paramASN1Encodable);
  }
  
  public void setPointFormat(String paramString)
  {
    this.withCompression = ("UNCOMPRESSED".equalsIgnoreCase(paramString) ^ true);
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str = Strings.lineSeparator();
    localStringBuffer.append("EC Private Key");
    localStringBuffer.append(str);
    localStringBuffer.append("             S: ");
    localStringBuffer.append(this.d.toString(16));
    localStringBuffer.append(str);
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\ec\BCECPrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */