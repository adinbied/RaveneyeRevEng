package org.bouncycastle.jce.provider;

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
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import org.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ECPoint;
import org.bouncycastle.asn1.x9.X9IntegerConverter;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jce.ECGOST3410NamedCurveTable;
import org.bouncycastle.jce.interfaces.ECPointEncoder;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.jce.spec.ECNamedCurveSpec;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.util.Strings;

public class JCEECPublicKey
  implements java.security.interfaces.ECPublicKey, org.bouncycastle.jce.interfaces.ECPublicKey, ECPointEncoder
{
  private String algorithm = "EC";
  private java.security.spec.ECParameterSpec ecSpec;
  private GOST3410PublicKeyAlgParameters gostParams;
  private org.bouncycastle.math.ec.ECPoint q;
  private boolean withCompression;
  
  public JCEECPublicKey(String paramString, java.security.spec.ECPublicKeySpec paramECPublicKeySpec)
  {
    this.algorithm = paramString;
    paramString = paramECPublicKeySpec.getParams();
    this.ecSpec = paramString;
    this.q = EC5Util.convertPoint(paramString, paramECPublicKeySpec.getW(), false);
  }
  
  public JCEECPublicKey(String paramString, ECPublicKeyParameters paramECPublicKeyParameters)
  {
    this.algorithm = paramString;
    this.q = paramECPublicKeyParameters.getQ();
    this.ecSpec = null;
  }
  
  public JCEECPublicKey(String paramString, ECPublicKeyParameters paramECPublicKeyParameters, java.security.spec.ECParameterSpec paramECParameterSpec)
  {
    ECDomainParameters localECDomainParameters = paramECPublicKeyParameters.getParameters();
    this.algorithm = paramString;
    this.q = paramECPublicKeyParameters.getQ();
    if (paramECParameterSpec == null)
    {
      this.ecSpec = createSpec(EC5Util.convertCurve(localECDomainParameters.getCurve(), localECDomainParameters.getSeed()), localECDomainParameters);
      return;
    }
    this.ecSpec = paramECParameterSpec;
  }
  
  public JCEECPublicKey(String paramString, ECPublicKeyParameters paramECPublicKeyParameters, org.bouncycastle.jce.spec.ECParameterSpec paramECParameterSpec)
  {
    ECDomainParameters localECDomainParameters = paramECPublicKeyParameters.getParameters();
    this.algorithm = paramString;
    this.q = paramECPublicKeyParameters.getQ();
    if (paramECParameterSpec == null) {
      paramString = createSpec(EC5Util.convertCurve(localECDomainParameters.getCurve(), localECDomainParameters.getSeed()), localECDomainParameters);
    } else {
      paramString = EC5Util.convertSpec(EC5Util.convertCurve(paramECParameterSpec.getCurve(), paramECParameterSpec.getSeed()), paramECParameterSpec);
    }
    this.ecSpec = paramString;
  }
  
  public JCEECPublicKey(String paramString, JCEECPublicKey paramJCEECPublicKey)
  {
    this.algorithm = paramString;
    this.q = paramJCEECPublicKey.q;
    this.ecSpec = paramJCEECPublicKey.ecSpec;
    this.withCompression = paramJCEECPublicKey.withCompression;
    this.gostParams = paramJCEECPublicKey.gostParams;
  }
  
  public JCEECPublicKey(String paramString, org.bouncycastle.jce.spec.ECPublicKeySpec paramECPublicKeySpec)
  {
    this.algorithm = paramString;
    this.q = paramECPublicKeySpec.getQ();
    if (paramECPublicKeySpec.getParams() != null) {}
    for (paramString = EC5Util.convertSpec(EC5Util.convertCurve(paramECPublicKeySpec.getParams().getCurve(), paramECPublicKeySpec.getParams().getSeed()), paramECPublicKeySpec.getParams());; paramString = null)
    {
      this.ecSpec = paramString;
      return;
      if (this.q.getCurve() == null) {
        this.q = BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa().getCurve().createPoint(this.q.getAffineXCoord().toBigInteger(), this.q.getAffineYCoord().toBigInteger(), false);
      }
    }
  }
  
  public JCEECPublicKey(java.security.interfaces.ECPublicKey paramECPublicKey)
  {
    this.algorithm = paramECPublicKey.getAlgorithm();
    java.security.spec.ECParameterSpec localECParameterSpec = paramECPublicKey.getParams();
    this.ecSpec = localECParameterSpec;
    this.q = EC5Util.convertPoint(localECParameterSpec, paramECPublicKey.getW(), false);
  }
  
  JCEECPublicKey(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
  {
    populateFromPubKeyInfo(paramSubjectPublicKeyInfo);
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
    if (paramSubjectPublicKeyInfo.getAlgorithmId().getAlgorithm().equals(CryptoProObjectIdentifiers.gostR3410_2001))
    {
      localObject1 = paramSubjectPublicKeyInfo.getPublicKeyData();
      this.algorithm = "ECGOST3410";
    }
    try
    {
      localObject1 = (ASN1OctetString)ASN1Primitive.fromByteArray(((DERBitString)localObject1).getBytes());
      localObject3 = ((ASN1OctetString)localObject1).getOctets();
      localObject1 = new byte[32];
      localObject2 = new byte[32];
      int i = 0;
      while (i != 32)
      {
        localObject1[i] = localObject3[(31 - i)];
        i += 1;
      }
      i = 0;
      while (i != 32)
      {
        localObject2[i] = localObject3[(63 - i)];
        i += 1;
      }
      paramSubjectPublicKeyInfo = new GOST3410PublicKeyAlgParameters((ASN1Sequence)paramSubjectPublicKeyInfo.getAlgorithmId().getParameters());
      this.gostParams = paramSubjectPublicKeyInfo;
      paramSubjectPublicKeyInfo = ECGOST3410NamedCurveTable.getParameterSpec(ECGOST3410NamedCurves.getName(paramSubjectPublicKeyInfo.getPublicKeyParamSet()));
      localObject3 = paramSubjectPublicKeyInfo.getCurve();
      localEllipticCurve = EC5Util.convertCurve((ECCurve)localObject3, paramSubjectPublicKeyInfo.getSeed());
      this.q = ((ECCurve)localObject3).createPoint(new BigInteger(1, (byte[])localObject1), new BigInteger(1, (byte[])localObject2), false);
      this.ecSpec = new ECNamedCurveSpec(ECGOST3410NamedCurves.getName(this.gostParams.getPublicKeyParamSet()), localEllipticCurve, new java.security.spec.ECPoint(paramSubjectPublicKeyInfo.getG().getAffineXCoord().toBigInteger(), paramSubjectPublicKeyInfo.getG().getAffineYCoord().toBigInteger()), paramSubjectPublicKeyInfo.getN(), paramSubjectPublicKeyInfo.getH());
      return;
    }
    catch (IOException paramSubjectPublicKeyInfo)
    {
      Object localObject3;
      Object localObject2;
      EllipticCurve localEllipticCurve;
      for (;;) {}
    }
    throw new IllegalArgumentException("error recovering public key");
    Object localObject1 = new X962Parameters((ASN1Primitive)paramSubjectPublicKeyInfo.getAlgorithmId().getParameters());
    if (((X962Parameters)localObject1).isNamedCurve())
    {
      localObject2 = (ASN1ObjectIdentifier)((X962Parameters)localObject1).getParameters();
      localObject3 = ECUtil.getNamedCurveByOid((ASN1ObjectIdentifier)localObject2);
      localObject1 = ((X9ECParameters)localObject3).getCurve();
      localEllipticCurve = EC5Util.convertCurve((ECCurve)localObject1, ((X9ECParameters)localObject3).getSeed());
    }
    for (localObject2 = new ECNamedCurveSpec(ECUtil.getCurveName((ASN1ObjectIdentifier)localObject2), localEllipticCurve, new java.security.spec.ECPoint(((X9ECParameters)localObject3).getG().getAffineXCoord().toBigInteger(), ((X9ECParameters)localObject3).getG().getAffineYCoord().toBigInteger()), ((X9ECParameters)localObject3).getN(), ((X9ECParameters)localObject3).getH());; localObject2 = new java.security.spec.ECParameterSpec(EC5Util.convertCurve((ECCurve)localObject1, ((X9ECParameters)localObject2).getSeed()), new java.security.spec.ECPoint(((X9ECParameters)localObject2).getG().getAffineXCoord().toBigInteger(), ((X9ECParameters)localObject2).getG().getAffineYCoord().toBigInteger()), ((X9ECParameters)localObject2).getN(), ((X9ECParameters)localObject2).getH().intValue()))
    {
      this.ecSpec = ((java.security.spec.ECParameterSpec)localObject2);
      break;
      if (((X962Parameters)localObject1).isImplicitlyCA())
      {
        this.ecSpec = null;
        localObject1 = BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa().getCurve();
        break;
      }
      localObject2 = X9ECParameters.getInstance(((X962Parameters)localObject1).getParameters());
      localObject1 = ((X9ECParameters)localObject2).getCurve();
    }
    localObject3 = paramSubjectPublicKeyInfo.getPublicKeyData().getBytes();
    localObject2 = new DEROctetString((byte[])localObject3);
    paramSubjectPublicKeyInfo = (SubjectPublicKeyInfo)localObject2;
    if (localObject3[0] == 4)
    {
      paramSubjectPublicKeyInfo = (SubjectPublicKeyInfo)localObject2;
      if (localObject3[1] == localObject3.length - 2) {
        if (localObject3[2] != 2)
        {
          paramSubjectPublicKeyInfo = (SubjectPublicKeyInfo)localObject2;
          if (localObject3[2] != 3) {}
        }
        else
        {
          paramSubjectPublicKeyInfo = (SubjectPublicKeyInfo)localObject2;
          if (new X9IntegerConverter().getByteLength((ECCurve)localObject1) < localObject3.length - 3) {}
        }
      }
    }
    try
    {
      paramSubjectPublicKeyInfo = (ASN1OctetString)ASN1Primitive.fromByteArray((byte[])localObject3);
    }
    catch (IOException paramSubjectPublicKeyInfo)
    {
      for (;;) {}
    }
    throw new IllegalArgumentException("error recovering public key");
    this.q = new X9ECPoint((ECCurve)localObject1, paramSubjectPublicKeyInfo).getPoint();
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    populateFromPubKeyInfo(SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray((byte[])paramObjectInputStream.readObject())));
    this.algorithm = ((String)paramObjectInputStream.readObject());
    this.withCompression = paramObjectInputStream.readBoolean();
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeObject(getEncoded());
    paramObjectOutputStream.writeObject(this.algorithm);
    paramObjectOutputStream.writeBoolean(this.withCompression);
  }
  
  public org.bouncycastle.math.ec.ECPoint engineGetQ()
  {
    return this.q;
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
    boolean bool1 = paramObject instanceof JCEECPublicKey;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (JCEECPublicKey)paramObject;
    bool1 = bool2;
    if (engineGetQ().equals(((JCEECPublicKey)paramObject).engineGetQ()))
    {
      bool1 = bool2;
      if (engineGetSpec().equals(((JCEECPublicKey)paramObject).engineGetSpec())) {
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
    byte[] arrayOfByte;
    if (this.algorithm.equals("ECGOST3410"))
    {
      localObject1 = this.gostParams;
      if (localObject1 == null)
      {
        localObject1 = this.ecSpec;
        if ((localObject1 instanceof ECNamedCurveSpec))
        {
          localObject1 = new GOST3410PublicKeyAlgParameters(ECGOST3410NamedCurves.getOID(((ECNamedCurveSpec)localObject1).getName()), CryptoProObjectIdentifiers.gostR3411_94_CryptoProParamSet);
        }
        else
        {
          localObject1 = EC5Util.convertCurve(((java.security.spec.ECParameterSpec)localObject1).getCurve());
          localObject1 = new X962Parameters(new X9ECParameters((ECCurve)localObject1, EC5Util.convertPoint((ECCurve)localObject1, this.ecSpec.getGenerator(), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf(this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed()));
        }
      }
      localObject2 = this.q.getAffineXCoord().toBigInteger();
      BigInteger localBigInteger = this.q.getAffineYCoord().toBigInteger();
      arrayOfByte = new byte[64];
      extractBytes(arrayOfByte, 0, (BigInteger)localObject2);
      extractBytes(arrayOfByte, 32, localBigInteger);
    }
    try
    {
      localObject1 = new SubjectPublicKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_2001, (ASN1Encodable)localObject1), new DEROctetString(arrayOfByte));
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    return null;
    Object localObject1 = this.ecSpec;
    if ((localObject1 instanceof ECNamedCurveSpec))
    {
      localObject2 = ECUtil.getNamedCurveOid(((ECNamedCurveSpec)localObject1).getName());
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ASN1ObjectIdentifier(((ECNamedCurveSpec)this.ecSpec).getName());
      }
      localObject1 = new X962Parameters((ASN1ObjectIdentifier)localObject1);
    }
    else if (localObject1 == null)
    {
      localObject1 = new X962Parameters(DERNull.INSTANCE);
    }
    else
    {
      localObject1 = EC5Util.convertCurve(((java.security.spec.ECParameterSpec)localObject1).getCurve());
      localObject1 = new X962Parameters(new X9ECParameters((ECCurve)localObject1, EC5Util.convertPoint((ECCurve)localObject1, this.ecSpec.getGenerator(), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf(this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed()));
    }
    Object localObject2 = (ASN1OctetString)new X9ECPoint(engineGetQ().getCurve().createPoint(getQ().getAffineXCoord().toBigInteger(), getQ().getAffineYCoord().toBigInteger(), this.withCompression)).toASN1Primitive();
    localObject1 = new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, (ASN1Encodable)localObject1), ((ASN1OctetString)localObject2).getOctets());
    return KeyUtil.getEncodedSubjectPublicKeyInfo((SubjectPublicKeyInfo)localObject1);
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
    if (this.ecSpec == null) {
      return this.q.getDetachedPoint();
    }
    return this.q;
  }
  
  public java.security.spec.ECPoint getW()
  {
    return new java.security.spec.ECPoint(this.q.getAffineXCoord().toBigInteger(), this.q.getAffineYCoord().toBigInteger());
  }
  
  public int hashCode()
  {
    return engineGetQ().hashCode() ^ engineGetSpec().hashCode();
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
    localStringBuffer.append(this.q.getAffineXCoord().toBigInteger().toString(16));
    localStringBuffer.append(str);
    localStringBuffer.append("            Y: ");
    localStringBuffer.append(this.q.getAffineYCoord().toBigInteger().toString(16));
    localStringBuffer.append(str);
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\provider\JCEECPublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */