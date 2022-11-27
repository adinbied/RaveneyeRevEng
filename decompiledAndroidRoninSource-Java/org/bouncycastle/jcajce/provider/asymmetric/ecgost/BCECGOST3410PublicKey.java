package org.bouncycastle.jcajce.provider.asymmetric.ecgost;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.spec.EllipticCurve;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import org.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jce.ECGOST3410NamedCurveTable;
import org.bouncycastle.jce.interfaces.ECPointEncoder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.jce.spec.ECNamedCurveSpec;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.util.Strings;

public class BCECGOST3410PublicKey
  implements java.security.interfaces.ECPublicKey, org.bouncycastle.jce.interfaces.ECPublicKey, ECPointEncoder
{
  static final long serialVersionUID = 7026240464295649314L;
  private String algorithm = "ECGOST3410";
  private transient ECPublicKeyParameters ecPublicKey;
  private transient java.security.spec.ECParameterSpec ecSpec;
  private transient GOST3410PublicKeyAlgParameters gostParams;
  private boolean withCompression;
  
  public BCECGOST3410PublicKey(String paramString, ECPublicKeyParameters paramECPublicKeyParameters)
  {
    this.algorithm = paramString;
    this.ecPublicKey = paramECPublicKeyParameters;
    this.ecSpec = null;
  }
  
  public BCECGOST3410PublicKey(String paramString, ECPublicKeyParameters paramECPublicKeyParameters, java.security.spec.ECParameterSpec paramECParameterSpec)
  {
    ECDomainParameters localECDomainParameters = paramECPublicKeyParameters.getParameters();
    this.algorithm = paramString;
    this.ecPublicKey = paramECPublicKeyParameters;
    if (paramECParameterSpec == null)
    {
      this.ecSpec = createSpec(EC5Util.convertCurve(localECDomainParameters.getCurve(), localECDomainParameters.getSeed()), localECDomainParameters);
      return;
    }
    this.ecSpec = paramECParameterSpec;
  }
  
  public BCECGOST3410PublicKey(String paramString, ECPublicKeyParameters paramECPublicKeyParameters, org.bouncycastle.jce.spec.ECParameterSpec paramECParameterSpec)
  {
    ECDomainParameters localECDomainParameters = paramECPublicKeyParameters.getParameters();
    this.algorithm = paramString;
    this.ecPublicKey = paramECPublicKeyParameters;
    if (paramECParameterSpec == null) {
      paramString = createSpec(EC5Util.convertCurve(localECDomainParameters.getCurve(), localECDomainParameters.getSeed()), localECDomainParameters);
    } else {
      paramString = EC5Util.convertSpec(EC5Util.convertCurve(paramECParameterSpec.getCurve(), paramECParameterSpec.getSeed()), paramECParameterSpec);
    }
    this.ecSpec = paramString;
  }
  
  public BCECGOST3410PublicKey(java.security.interfaces.ECPublicKey paramECPublicKey)
  {
    this.algorithm = paramECPublicKey.getAlgorithm();
    java.security.spec.ECParameterSpec localECParameterSpec = paramECPublicKey.getParams();
    this.ecSpec = localECParameterSpec;
    this.ecPublicKey = new ECPublicKeyParameters(EC5Util.convertPoint(localECParameterSpec, paramECPublicKey.getW(), false), EC5Util.getDomainParameters(null, paramECPublicKey.getParams()));
  }
  
  public BCECGOST3410PublicKey(java.security.spec.ECPublicKeySpec paramECPublicKeySpec)
  {
    java.security.spec.ECParameterSpec localECParameterSpec = paramECPublicKeySpec.getParams();
    this.ecSpec = localECParameterSpec;
    this.ecPublicKey = new ECPublicKeyParameters(EC5Util.convertPoint(localECParameterSpec, paramECPublicKeySpec.getW(), false), EC5Util.getDomainParameters(null, paramECPublicKeySpec.getParams()));
  }
  
  BCECGOST3410PublicKey(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
  {
    populateFromPubKeyInfo(paramSubjectPublicKeyInfo);
  }
  
  public BCECGOST3410PublicKey(BCECGOST3410PublicKey paramBCECGOST3410PublicKey)
  {
    this.ecPublicKey = paramBCECGOST3410PublicKey.ecPublicKey;
    this.ecSpec = paramBCECGOST3410PublicKey.ecSpec;
    this.withCompression = paramBCECGOST3410PublicKey.withCompression;
    this.gostParams = paramBCECGOST3410PublicKey.gostParams;
  }
  
  public BCECGOST3410PublicKey(org.bouncycastle.jce.spec.ECPublicKeySpec paramECPublicKeySpec, ProviderConfiguration paramProviderConfiguration)
  {
    if (paramECPublicKeySpec.getParams() != null)
    {
      EllipticCurve localEllipticCurve = EC5Util.convertCurve(paramECPublicKeySpec.getParams().getCurve(), paramECPublicKeySpec.getParams().getSeed());
      this.ecPublicKey = new ECPublicKeyParameters(paramECPublicKeySpec.getQ(), ECUtil.getDomainParameters(paramProviderConfiguration, paramECPublicKeySpec.getParams()));
      this.ecSpec = EC5Util.convertSpec(localEllipticCurve, paramECPublicKeySpec.getParams());
      return;
    }
    this.ecPublicKey = new ECPublicKeyParameters(paramProviderConfiguration.getEcImplicitlyCa().getCurve().createPoint(paramECPublicKeySpec.getQ().getAffineXCoord().toBigInteger(), paramECPublicKeySpec.getQ().getAffineYCoord().toBigInteger()), EC5Util.getDomainParameters(paramProviderConfiguration, (java.security.spec.ECParameterSpec)null));
    this.ecSpec = null;
  }
  
  private java.security.spec.ECParameterSpec createSpec(EllipticCurve paramEllipticCurve, ECDomainParameters paramECDomainParameters)
  {
    return new java.security.spec.ECParameterSpec(paramEllipticCurve, new java.security.spec.ECPoint(paramECDomainParameters.getG().getAffineXCoord().toBigInteger(), paramECDomainParameters.getG().getAffineYCoord().toBigInteger()), paramECDomainParameters.getN(), paramECDomainParameters.getH().intValue());
  }
  
  private void extractBytes(byte[] paramArrayOfByte, int paramInt, BigInteger paramBigInteger)
  {
    byte[] arrayOfByte = paramBigInteger.toByteArray();
    int k = arrayOfByte.length;
    int j = 0;
    int i = j;
    paramBigInteger = arrayOfByte;
    if (k < 32)
    {
      paramBigInteger = new byte[32];
      System.arraycopy(arrayOfByte, 0, paramBigInteger, 32 - arrayOfByte.length, arrayOfByte.length);
      i = j;
    }
    while (i != 32)
    {
      paramArrayOfByte[(paramInt + i)] = paramBigInteger[(paramBigInteger.length - 1 - i)];
      i += 1;
    }
  }
  
  private void populateFromPubKeyInfo(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
  {
    Object localObject1 = paramSubjectPublicKeyInfo.getPublicKeyData();
    this.algorithm = "ECGOST3410";
    try
    {
      localObject1 = (ASN1OctetString)ASN1Primitive.fromByteArray(((DERBitString)localObject1).getBytes());
      Object localObject2 = ((ASN1OctetString)localObject1).getOctets();
      localObject1 = new byte[32];
      byte[] arrayOfByte = new byte[32];
      int k = 0;
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i == 32) {
          break;
        }
        localObject1[i] = localObject2[(31 - i)];
        i += 1;
      }
      while (j != 32)
      {
        arrayOfByte[j] = localObject2[(63 - j)];
        j += 1;
      }
      paramSubjectPublicKeyInfo = GOST3410PublicKeyAlgParameters.getInstance(paramSubjectPublicKeyInfo.getAlgorithm().getParameters());
      this.gostParams = paramSubjectPublicKeyInfo;
      paramSubjectPublicKeyInfo = ECGOST3410NamedCurveTable.getParameterSpec(ECGOST3410NamedCurves.getName(paramSubjectPublicKeyInfo.getPublicKeyParamSet()));
      localObject2 = paramSubjectPublicKeyInfo.getCurve();
      EllipticCurve localEllipticCurve = EC5Util.convertCurve((ECCurve)localObject2, paramSubjectPublicKeyInfo.getSeed());
      this.ecPublicKey = new ECPublicKeyParameters(((ECCurve)localObject2).createPoint(new BigInteger(1, (byte[])localObject1), new BigInteger(1, arrayOfByte)), ECUtil.getDomainParameters(null, paramSubjectPublicKeyInfo));
      this.ecSpec = new ECNamedCurveSpec(ECGOST3410NamedCurves.getName(this.gostParams.getPublicKeyParamSet()), localEllipticCurve, new java.security.spec.ECPoint(paramSubjectPublicKeyInfo.getG().getAffineXCoord().toBigInteger(), paramSubjectPublicKeyInfo.getG().getAffineYCoord().toBigInteger()), paramSubjectPublicKeyInfo.getN(), paramSubjectPublicKeyInfo.getH());
      return;
    }
    catch (IOException paramSubjectPublicKeyInfo)
    {
      for (;;) {}
    }
    throw new IllegalArgumentException("error recovering public key");
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    populateFromPubKeyInfo(SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray((byte[])paramObjectInputStream.readObject())));
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
    return BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof BCECGOST3410PublicKey;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (BCECGOST3410PublicKey)paramObject;
    bool1 = bool2;
    if (this.ecPublicKey.getQ().equals(((BCECGOST3410PublicKey)paramObject).ecPublicKey.getQ()))
    {
      bool1 = bool2;
      if (engineGetSpec().equals(((BCECGOST3410PublicKey)paramObject).engineGetSpec())) {
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
    Object localObject = this.gostParams;
    if (localObject == null)
    {
      localObject = this.ecSpec;
      if ((localObject instanceof ECNamedCurveSpec))
      {
        localObject = new GOST3410PublicKeyAlgParameters(ECGOST3410NamedCurves.getOID(((ECNamedCurveSpec)localObject).getName()), CryptoProObjectIdentifiers.gostR3411_94_CryptoProParamSet);
      }
      else
      {
        localObject = EC5Util.convertCurve(((java.security.spec.ECParameterSpec)localObject).getCurve());
        localObject = new X962Parameters(new X9ECParameters((ECCurve)localObject, EC5Util.convertPoint((ECCurve)localObject, this.ecSpec.getGenerator(), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf(this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed()));
      }
    }
    BigInteger localBigInteger1 = this.ecPublicKey.getQ().getAffineXCoord().toBigInteger();
    BigInteger localBigInteger2 = this.ecPublicKey.getQ().getAffineYCoord().toBigInteger();
    byte[] arrayOfByte = new byte[64];
    extractBytes(arrayOfByte, 0, localBigInteger1);
    extractBytes(arrayOfByte, 32, localBigInteger2);
    try
    {
      localObject = new SubjectPublicKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_2001, (ASN1Encodable)localObject), new DEROctetString(arrayOfByte));
      return KeyUtil.getEncodedSubjectPublicKeyInfo((SubjectPublicKeyInfo)localObject);
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    return null;
  }
  
  public String getFormat()
  {
    return "X.509";
  }
  
  public GOST3410PublicKeyAlgParameters getGostParams()
  {
    return this.gostParams;
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
    if (this.ecSpec == null) {
      return this.ecPublicKey.getQ().getDetachedPoint();
    }
    return this.ecPublicKey.getQ();
  }
  
  public java.security.spec.ECPoint getW()
  {
    return new java.security.spec.ECPoint(this.ecPublicKey.getQ().getAffineXCoord().toBigInteger(), this.ecPublicKey.getQ().getAffineYCoord().toBigInteger());
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\ecgost\BCECGOST3410PublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */