package org.bouncycastle.jcajce.provider.asymmetric.ec;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.spec.EllipticCurve;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.asn1.x9.X9ECPoint;
import org.bouncycastle.asn1.x9.X9IntegerConverter;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jce.interfaces.ECPointEncoder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.util.Strings;

public class BCECPublicKey
  implements java.security.interfaces.ECPublicKey, org.bouncycastle.jce.interfaces.ECPublicKey, ECPointEncoder
{
  static final long serialVersionUID = 2422789860422731812L;
  private String algorithm = "EC";
  private transient ProviderConfiguration configuration;
  private transient ECPublicKeyParameters ecPublicKey;
  private transient java.security.spec.ECParameterSpec ecSpec;
  private boolean withCompression;
  
  public BCECPublicKey(String paramString, java.security.spec.ECPublicKeySpec paramECPublicKeySpec, ProviderConfiguration paramProviderConfiguration)
  {
    this.algorithm = paramString;
    paramString = paramECPublicKeySpec.getParams();
    this.ecSpec = paramString;
    this.ecPublicKey = new ECPublicKeyParameters(EC5Util.convertPoint(paramString, paramECPublicKeySpec.getW(), false), EC5Util.getDomainParameters(paramProviderConfiguration, paramECPublicKeySpec.getParams()));
    this.configuration = paramProviderConfiguration;
  }
  
  BCECPublicKey(String paramString, SubjectPublicKeyInfo paramSubjectPublicKeyInfo, ProviderConfiguration paramProviderConfiguration)
  {
    this.algorithm = paramString;
    this.configuration = paramProviderConfiguration;
    populateFromPubKeyInfo(paramSubjectPublicKeyInfo);
  }
  
  public BCECPublicKey(String paramString, ECPublicKeyParameters paramECPublicKeyParameters, java.security.spec.ECParameterSpec paramECParameterSpec, ProviderConfiguration paramProviderConfiguration)
  {
    ECDomainParameters localECDomainParameters = paramECPublicKeyParameters.getParameters();
    this.algorithm = paramString;
    this.ecPublicKey = paramECPublicKeyParameters;
    if (paramECParameterSpec == null) {
      this.ecSpec = createSpec(EC5Util.convertCurve(localECDomainParameters.getCurve(), localECDomainParameters.getSeed()), localECDomainParameters);
    } else {
      this.ecSpec = paramECParameterSpec;
    }
    this.configuration = paramProviderConfiguration;
  }
  
  public BCECPublicKey(String paramString, ECPublicKeyParameters paramECPublicKeyParameters, ProviderConfiguration paramProviderConfiguration)
  {
    this.algorithm = paramString;
    this.ecPublicKey = paramECPublicKeyParameters;
    this.ecSpec = null;
    this.configuration = paramProviderConfiguration;
  }
  
  public BCECPublicKey(String paramString, ECPublicKeyParameters paramECPublicKeyParameters, org.bouncycastle.jce.spec.ECParameterSpec paramECParameterSpec, ProviderConfiguration paramProviderConfiguration)
  {
    ECDomainParameters localECDomainParameters = paramECPublicKeyParameters.getParameters();
    this.algorithm = paramString;
    if (paramECParameterSpec == null) {
      paramString = createSpec(EC5Util.convertCurve(localECDomainParameters.getCurve(), localECDomainParameters.getSeed()), localECDomainParameters);
    } else {
      paramString = EC5Util.convertSpec(EC5Util.convertCurve(paramECParameterSpec.getCurve(), paramECParameterSpec.getSeed()), paramECParameterSpec);
    }
    this.ecSpec = paramString;
    this.ecPublicKey = paramECPublicKeyParameters;
    this.configuration = paramProviderConfiguration;
  }
  
  public BCECPublicKey(String paramString, BCECPublicKey paramBCECPublicKey)
  {
    this.algorithm = paramString;
    this.ecPublicKey = paramBCECPublicKey.ecPublicKey;
    this.ecSpec = paramBCECPublicKey.ecSpec;
    this.withCompression = paramBCECPublicKey.withCompression;
    this.configuration = paramBCECPublicKey.configuration;
  }
  
  public BCECPublicKey(String paramString, org.bouncycastle.jce.spec.ECPublicKeySpec paramECPublicKeySpec, ProviderConfiguration paramProviderConfiguration)
  {
    this.algorithm = paramString;
    if (paramECPublicKeySpec.getParams() != null)
    {
      paramString = EC5Util.convertCurve(paramECPublicKeySpec.getParams().getCurve(), paramECPublicKeySpec.getParams().getSeed());
      this.ecPublicKey = new ECPublicKeyParameters(paramECPublicKeySpec.getQ(), ECUtil.getDomainParameters(paramProviderConfiguration, paramECPublicKeySpec.getParams()));
      this.ecSpec = EC5Util.convertSpec(paramString, paramECPublicKeySpec.getParams());
    }
    else
    {
      this.ecPublicKey = new ECPublicKeyParameters(paramProviderConfiguration.getEcImplicitlyCa().getCurve().createPoint(paramECPublicKeySpec.getQ().getAffineXCoord().toBigInteger(), paramECPublicKeySpec.getQ().getAffineYCoord().toBigInteger()), EC5Util.getDomainParameters(paramProviderConfiguration, (java.security.spec.ECParameterSpec)null));
      this.ecSpec = null;
    }
    this.configuration = paramProviderConfiguration;
  }
  
  public BCECPublicKey(java.security.interfaces.ECPublicKey paramECPublicKey, ProviderConfiguration paramProviderConfiguration)
  {
    this.algorithm = paramECPublicKey.getAlgorithm();
    java.security.spec.ECParameterSpec localECParameterSpec = paramECPublicKey.getParams();
    this.ecSpec = localECParameterSpec;
    this.ecPublicKey = new ECPublicKeyParameters(EC5Util.convertPoint(localECParameterSpec, paramECPublicKey.getW(), false), EC5Util.getDomainParameters(paramProviderConfiguration, paramECPublicKey.getParams()));
  }
  
  private java.security.spec.ECParameterSpec createSpec(EllipticCurve paramEllipticCurve, ECDomainParameters paramECDomainParameters)
  {
    return new java.security.spec.ECParameterSpec(paramEllipticCurve, new java.security.spec.ECPoint(paramECDomainParameters.getG().getAffineXCoord().toBigInteger(), paramECDomainParameters.getG().getAffineYCoord().toBigInteger()), paramECDomainParameters.getN(), paramECDomainParameters.getH().intValue());
  }
  
  private void populateFromPubKeyInfo(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
  {
    X962Parameters localX962Parameters = X962Parameters.getInstance(paramSubjectPublicKeyInfo.getAlgorithm().getParameters());
    ECCurve localECCurve = EC5Util.getCurve(this.configuration, localX962Parameters);
    this.ecSpec = EC5Util.convertToSpec(localX962Parameters, localECCurve);
    byte[] arrayOfByte = paramSubjectPublicKeyInfo.getPublicKeyData().getBytes();
    DEROctetString localDEROctetString = new DEROctetString(arrayOfByte);
    paramSubjectPublicKeyInfo = localDEROctetString;
    if (arrayOfByte[0] == 4)
    {
      paramSubjectPublicKeyInfo = localDEROctetString;
      if (arrayOfByte[1] == arrayOfByte.length - 2) {
        if (arrayOfByte[2] != 2)
        {
          paramSubjectPublicKeyInfo = localDEROctetString;
          if (arrayOfByte[2] != 3) {}
        }
        else
        {
          paramSubjectPublicKeyInfo = localDEROctetString;
          if (new X9IntegerConverter().getByteLength(localECCurve) < arrayOfByte.length - 3) {}
        }
      }
    }
    try
    {
      paramSubjectPublicKeyInfo = (ASN1OctetString)ASN1Primitive.fromByteArray(arrayOfByte);
    }
    catch (IOException paramSubjectPublicKeyInfo)
    {
      for (;;) {}
    }
    throw new IllegalArgumentException("error recovering public key");
    this.ecPublicKey = new ECPublicKeyParameters(new X9ECPoint(localECCurve, paramSubjectPublicKeyInfo).getPoint(), ECUtil.getDomainParameters(this.configuration, localX962Parameters));
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    paramObjectInputStream = (byte[])paramObjectInputStream.readObject();
    this.configuration = BouncyCastleProvider.CONFIGURATION;
    populateFromPubKeyInfo(SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray(paramObjectInputStream)));
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeObject(getEncoded());
  }
  
  ECPublicKeyParameters engineGetKeyParameters()
  {
    return this.ecPublicKey;
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
    boolean bool1 = paramObject instanceof BCECPublicKey;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (BCECPublicKey)paramObject;
    bool1 = bool2;
    if (this.ecPublicKey.getQ().equals(((BCECPublicKey)paramObject).ecPublicKey.getQ()))
    {
      bool1 = bool2;
      if (engineGetSpec().equals(((BCECPublicKey)paramObject).engineGetSpec())) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String getAlgorithm()
  {
    return this.algorithm;
  }
  
  public byte[] getEncoded()
  {
    X962Parameters localX962Parameters = ECUtils.getDomainParametersFromName(this.ecSpec, this.withCompression);
    ASN1OctetString localASN1OctetString = ASN1OctetString.getInstance(new X9ECPoint(this.ecPublicKey.getQ(), this.withCompression).toASN1Primitive());
    return KeyUtil.getEncodedSubjectPublicKeyInfo(new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, localX962Parameters), localASN1OctetString.getOctets()));
  }
  
  public String getFormat()
  {
    return "X.509";
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
  
  public org.bouncycastle.math.ec.ECPoint getQ()
  {
    org.bouncycastle.math.ec.ECPoint localECPoint2 = this.ecPublicKey.getQ();
    org.bouncycastle.math.ec.ECPoint localECPoint1 = localECPoint2;
    if (this.ecSpec == null) {
      localECPoint1 = localECPoint2.getDetachedPoint();
    }
    return localECPoint1;
  }
  
  public java.security.spec.ECPoint getW()
  {
    org.bouncycastle.math.ec.ECPoint localECPoint = this.ecPublicKey.getQ();
    return new java.security.spec.ECPoint(localECPoint.getAffineXCoord().toBigInteger(), localECPoint.getAffineYCoord().toBigInteger());
  }
  
  public int hashCode()
  {
    return this.ecPublicKey.getQ().hashCode() ^ engineGetSpec().hashCode();
  }
  
  public void setPointFormat(String paramString)
  {
    this.withCompression = ("UNCOMPRESSED".equalsIgnoreCase(paramString) ^ true);
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str = Strings.lineSeparator();
    org.bouncycastle.math.ec.ECPoint localECPoint = this.ecPublicKey.getQ();
    localStringBuffer.append("EC Public Key");
    localStringBuffer.append(str);
    localStringBuffer.append("            X: ");
    localStringBuffer.append(localECPoint.getAffineXCoord().toBigInteger().toString(16));
    localStringBuffer.append(str);
    localStringBuffer.append("            Y: ");
    localStringBuffer.append(localECPoint.getAffineYCoord().toBigInteger().toString(16));
    localStringBuffer.append(str);
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\ec\BCECPublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */