package org.bouncycastle.jcajce.provider.asymmetric.dstu;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.spec.EllipticCurve;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.ua.DSTU4145BinaryField;
import org.bouncycastle.asn1.ua.DSTU4145ECBinary;
import org.bouncycastle.asn1.ua.DSTU4145NamedCurves;
import org.bouncycastle.asn1.ua.DSTU4145Params;
import org.bouncycastle.asn1.ua.DSTU4145PointEncoder;
import org.bouncycastle.asn1.ua.UAObjectIdentifiers;
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
import org.bouncycastle.jce.interfaces.ECPointEncoder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.jce.spec.ECNamedCurveSpec;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECCurve.F2m;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.util.Strings;

public class BCDSTU4145PublicKey
  implements java.security.interfaces.ECPublicKey, org.bouncycastle.jce.interfaces.ECPublicKey, ECPointEncoder
{
  static final long serialVersionUID = 7026240464295649314L;
  private String algorithm = "DSTU4145";
  private transient DSTU4145Params dstuParams;
  private transient ECPublicKeyParameters ecPublicKey;
  private transient java.security.spec.ECParameterSpec ecSpec;
  private boolean withCompression;
  
  public BCDSTU4145PublicKey(String paramString, ECPublicKeyParameters paramECPublicKeyParameters)
  {
    this.algorithm = paramString;
    this.ecPublicKey = paramECPublicKeyParameters;
    this.ecSpec = null;
  }
  
  public BCDSTU4145PublicKey(String paramString, ECPublicKeyParameters paramECPublicKeyParameters, java.security.spec.ECParameterSpec paramECParameterSpec)
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
  
  public BCDSTU4145PublicKey(String paramString, ECPublicKeyParameters paramECPublicKeyParameters, org.bouncycastle.jce.spec.ECParameterSpec paramECParameterSpec)
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
  }
  
  public BCDSTU4145PublicKey(java.security.spec.ECPublicKeySpec paramECPublicKeySpec)
  {
    java.security.spec.ECParameterSpec localECParameterSpec = paramECPublicKeySpec.getParams();
    this.ecSpec = localECParameterSpec;
    this.ecPublicKey = new ECPublicKeyParameters(EC5Util.convertPoint(localECParameterSpec, paramECPublicKeySpec.getW(), false), EC5Util.getDomainParameters(null, this.ecSpec));
  }
  
  BCDSTU4145PublicKey(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
  {
    populateFromPubKeyInfo(paramSubjectPublicKeyInfo);
  }
  
  public BCDSTU4145PublicKey(BCDSTU4145PublicKey paramBCDSTU4145PublicKey)
  {
    this.ecPublicKey = paramBCDSTU4145PublicKey.ecPublicKey;
    this.ecSpec = paramBCDSTU4145PublicKey.ecSpec;
    this.withCompression = paramBCDSTU4145PublicKey.withCompression;
    this.dstuParams = paramBCDSTU4145PublicKey.dstuParams;
  }
  
  public BCDSTU4145PublicKey(org.bouncycastle.jce.spec.ECPublicKeySpec paramECPublicKeySpec, ProviderConfiguration paramProviderConfiguration)
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
  
  private void populateFromPubKeyInfo(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
  {
    Object localObject1 = paramSubjectPublicKeyInfo.getPublicKeyData();
    this.algorithm = "DSTU4145";
    try
    {
      localObject1 = (ASN1OctetString)ASN1Primitive.fromByteArray(((DERBitString)localObject1).getBytes());
      localObject1 = ((ASN1OctetString)localObject1).getOctets();
      if (paramSubjectPublicKeyInfo.getAlgorithm().getAlgorithm().equals(UAObjectIdentifiers.dstu4145le)) {
        reverseBytes((byte[])localObject1);
      }
      Object localObject2 = DSTU4145Params.getInstance((ASN1Sequence)paramSubjectPublicKeyInfo.getAlgorithm().getParameters());
      this.dstuParams = ((DSTU4145Params)localObject2);
      if (((DSTU4145Params)localObject2).isNamedCurve())
      {
        paramSubjectPublicKeyInfo = this.dstuParams.getNamedCurve();
        localObject2 = DSTU4145NamedCurves.getByOID(paramSubjectPublicKeyInfo);
        paramSubjectPublicKeyInfo = new ECNamedCurveParameterSpec(paramSubjectPublicKeyInfo.getId(), ((ECDomainParameters)localObject2).getCurve(), ((ECDomainParameters)localObject2).getG(), ((ECDomainParameters)localObject2).getN(), ((ECDomainParameters)localObject2).getH(), ((ECDomainParameters)localObject2).getSeed());
      }
      else
      {
        localObject2 = this.dstuParams.getECBinary();
        localObject3 = ((DSTU4145ECBinary)localObject2).getB();
        if (paramSubjectPublicKeyInfo.getAlgorithm().getAlgorithm().equals(UAObjectIdentifiers.dstu4145le)) {
          reverseBytes((byte[])localObject3);
        }
        Object localObject4 = ((DSTU4145ECBinary)localObject2).getField();
        localObject3 = new ECCurve.F2m(((DSTU4145BinaryField)localObject4).getM(), ((DSTU4145BinaryField)localObject4).getK1(), ((DSTU4145BinaryField)localObject4).getK2(), ((DSTU4145BinaryField)localObject4).getK3(), ((DSTU4145ECBinary)localObject2).getA(), new BigInteger(1, (byte[])localObject3));
        localObject4 = ((DSTU4145ECBinary)localObject2).getG();
        if (paramSubjectPublicKeyInfo.getAlgorithm().getAlgorithm().equals(UAObjectIdentifiers.dstu4145le)) {
          reverseBytes((byte[])localObject4);
        }
        paramSubjectPublicKeyInfo = new org.bouncycastle.jce.spec.ECParameterSpec((ECCurve)localObject3, DSTU4145PointEncoder.decodePoint((ECCurve)localObject3, (byte[])localObject4), ((DSTU4145ECBinary)localObject2).getN());
      }
      localObject2 = paramSubjectPublicKeyInfo.getCurve();
      Object localObject3 = EC5Util.convertCurve((ECCurve)localObject2, paramSubjectPublicKeyInfo.getSeed());
      if (this.dstuParams.isNamedCurve()) {
        paramSubjectPublicKeyInfo = new ECNamedCurveSpec(this.dstuParams.getNamedCurve().getId(), (EllipticCurve)localObject3, new java.security.spec.ECPoint(paramSubjectPublicKeyInfo.getG().getAffineXCoord().toBigInteger(), paramSubjectPublicKeyInfo.getG().getAffineYCoord().toBigInteger()), paramSubjectPublicKeyInfo.getN(), paramSubjectPublicKeyInfo.getH());
      } else {
        paramSubjectPublicKeyInfo = new java.security.spec.ECParameterSpec((EllipticCurve)localObject3, new java.security.spec.ECPoint(paramSubjectPublicKeyInfo.getG().getAffineXCoord().toBigInteger(), paramSubjectPublicKeyInfo.getG().getAffineYCoord().toBigInteger()), paramSubjectPublicKeyInfo.getN(), paramSubjectPublicKeyInfo.getH().intValue());
      }
      this.ecSpec = paramSubjectPublicKeyInfo;
      this.ecPublicKey = new ECPublicKeyParameters(DSTU4145PointEncoder.decodePoint((ECCurve)localObject2, (byte[])localObject1), EC5Util.getDomainParameters(null, this.ecSpec));
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
  
  private void reverseBytes(byte[] paramArrayOfByte)
  {
    int j = 0;
    while (j < paramArrayOfByte.length / 2)
    {
      int i = paramArrayOfByte[j];
      paramArrayOfByte[j] = paramArrayOfByte[(paramArrayOfByte.length - 1 - j)];
      paramArrayOfByte[(paramArrayOfByte.length - 1 - j)] = i;
      j += 1;
    }
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
    boolean bool1 = paramObject instanceof BCDSTU4145PublicKey;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (BCDSTU4145PublicKey)paramObject;
    bool1 = bool2;
    if (this.ecPublicKey.getQ().equals(((BCDSTU4145PublicKey)paramObject).ecPublicKey.getQ()))
    {
      bool1 = bool2;
      if (engineGetSpec().equals(((BCDSTU4145PublicKey)paramObject).engineGetSpec())) {
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
    Object localObject = this.dstuParams;
    if (localObject == null)
    {
      localObject = this.ecSpec;
      if ((localObject instanceof ECNamedCurveSpec))
      {
        localObject = new DSTU4145Params(new ASN1ObjectIdentifier(((ECNamedCurveSpec)localObject).getName()));
      }
      else
      {
        localObject = EC5Util.convertCurve(((java.security.spec.ECParameterSpec)localObject).getCurve());
        localObject = new X962Parameters(new X9ECParameters((ECCurve)localObject, EC5Util.convertPoint((ECCurve)localObject, this.ecSpec.getGenerator(), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf(this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed()));
      }
    }
    byte[] arrayOfByte = DSTU4145PointEncoder.encodePoint(this.ecPublicKey.getQ());
    try
    {
      localObject = new SubjectPublicKeyInfo(new AlgorithmIdentifier(UAObjectIdentifiers.dstu4145be, (ASN1Encodable)localObject), new DEROctetString(arrayOfByte));
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
  
  public byte[] getSbox()
  {
    DSTU4145Params localDSTU4145Params = this.dstuParams;
    if (localDSTU4145Params != null) {
      return localDSTU4145Params.getDKE();
    }
    return DSTU4145Params.getDefaultDKE();
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
    localStringBuffer.append("EC Public Key");
    localStringBuffer.append(str);
    localStringBuffer.append("            X: ");
    localStringBuffer.append(getQ().getAffineXCoord().toBigInteger().toString(16));
    localStringBuffer.append(str);
    localStringBuffer.append("            Y: ");
    localStringBuffer.append(getQ().getAffineYCoord().toBigInteger().toString(16));
    localStringBuffer.append(str);
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\dstu\BCDSTU4145PublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */