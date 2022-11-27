package org.bouncycastle.jcajce.provider.asymmetric.dstu;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.spec.EllipticCurve;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.ua.DSTU4145NamedCurves;
import org.bouncycastle.asn1.ua.UAObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.asn1.x9.X9ECParameters;
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
import org.bouncycastle.jce.spec.ECNamedCurveSpec;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.util.Strings;

public class BCDSTU4145PrivateKey
  implements java.security.interfaces.ECPrivateKey, org.bouncycastle.jce.interfaces.ECPrivateKey, PKCS12BagAttributeCarrier, ECPointEncoder
{
  static final long serialVersionUID = 7245981689601667138L;
  private String algorithm = "DSTU4145";
  private transient PKCS12BagAttributeCarrierImpl attrCarrier = new PKCS12BagAttributeCarrierImpl();
  private transient BigInteger d;
  private transient java.security.spec.ECParameterSpec ecSpec;
  private transient DERBitString publicKey;
  private boolean withCompression;
  
  protected BCDSTU4145PrivateKey() {}
  
  public BCDSTU4145PrivateKey(String paramString, ECPrivateKeyParameters paramECPrivateKeyParameters)
  {
    this.algorithm = paramString;
    this.d = paramECPrivateKeyParameters.getD();
    this.ecSpec = null;
  }
  
  public BCDSTU4145PrivateKey(String paramString, ECPrivateKeyParameters paramECPrivateKeyParameters, BCDSTU4145PublicKey paramBCDSTU4145PublicKey, java.security.spec.ECParameterSpec paramECParameterSpec)
  {
    ECDomainParameters localECDomainParameters = paramECPrivateKeyParameters.getParameters();
    this.algorithm = paramString;
    this.d = paramECPrivateKeyParameters.getD();
    if (paramECParameterSpec == null) {
      this.ecSpec = new java.security.spec.ECParameterSpec(EC5Util.convertCurve(localECDomainParameters.getCurve(), localECDomainParameters.getSeed()), new java.security.spec.ECPoint(localECDomainParameters.getG().getAffineXCoord().toBigInteger(), localECDomainParameters.getG().getAffineYCoord().toBigInteger()), localECDomainParameters.getN(), localECDomainParameters.getH().intValue());
    } else {
      this.ecSpec = paramECParameterSpec;
    }
    this.publicKey = getPublicKeyDetails(paramBCDSTU4145PublicKey);
  }
  
  public BCDSTU4145PrivateKey(String paramString, ECPrivateKeyParameters paramECPrivateKeyParameters, BCDSTU4145PublicKey paramBCDSTU4145PublicKey, org.bouncycastle.jce.spec.ECParameterSpec paramECParameterSpec)
  {
    ECDomainParameters localECDomainParameters = paramECPrivateKeyParameters.getParameters();
    this.algorithm = paramString;
    this.d = paramECPrivateKeyParameters.getD();
    if (paramECParameterSpec == null) {
      paramString = new java.security.spec.ECParameterSpec(EC5Util.convertCurve(localECDomainParameters.getCurve(), localECDomainParameters.getSeed()), new java.security.spec.ECPoint(localECDomainParameters.getG().getAffineXCoord().toBigInteger(), localECDomainParameters.getG().getAffineYCoord().toBigInteger()), localECDomainParameters.getN(), localECDomainParameters.getH().intValue());
    } else {
      paramString = new java.security.spec.ECParameterSpec(EC5Util.convertCurve(paramECParameterSpec.getCurve(), paramECParameterSpec.getSeed()), new java.security.spec.ECPoint(paramECParameterSpec.getG().getAffineXCoord().toBigInteger(), paramECParameterSpec.getG().getAffineYCoord().toBigInteger()), paramECParameterSpec.getN(), paramECParameterSpec.getH().intValue());
    }
    this.ecSpec = paramString;
    this.publicKey = getPublicKeyDetails(paramBCDSTU4145PublicKey);
  }
  
  public BCDSTU4145PrivateKey(java.security.interfaces.ECPrivateKey paramECPrivateKey)
  {
    this.d = paramECPrivateKey.getS();
    this.algorithm = paramECPrivateKey.getAlgorithm();
    this.ecSpec = paramECPrivateKey.getParams();
  }
  
  public BCDSTU4145PrivateKey(java.security.spec.ECPrivateKeySpec paramECPrivateKeySpec)
  {
    this.d = paramECPrivateKeySpec.getS();
    this.ecSpec = paramECPrivateKeySpec.getParams();
  }
  
  BCDSTU4145PrivateKey(PrivateKeyInfo paramPrivateKeyInfo)
    throws IOException
  {
    populateFromPrivKeyInfo(paramPrivateKeyInfo);
  }
  
  public BCDSTU4145PrivateKey(BCDSTU4145PrivateKey paramBCDSTU4145PrivateKey)
  {
    this.d = paramBCDSTU4145PrivateKey.d;
    this.ecSpec = paramBCDSTU4145PrivateKey.ecSpec;
    this.withCompression = paramBCDSTU4145PrivateKey.withCompression;
    this.attrCarrier = paramBCDSTU4145PrivateKey.attrCarrier;
    this.publicKey = paramBCDSTU4145PrivateKey.publicKey;
  }
  
  public BCDSTU4145PrivateKey(org.bouncycastle.jce.spec.ECPrivateKeySpec paramECPrivateKeySpec)
  {
    this.d = paramECPrivateKeySpec.getD();
    if (paramECPrivateKeySpec.getParams() != null) {
      paramECPrivateKeySpec = EC5Util.convertSpec(EC5Util.convertCurve(paramECPrivateKeySpec.getParams().getCurve(), paramECPrivateKeySpec.getParams().getSeed()), paramECPrivateKeySpec.getParams());
    } else {
      paramECPrivateKeySpec = null;
    }
    this.ecSpec = paramECPrivateKeySpec;
  }
  
  private DERBitString getPublicKeyDetails(BCDSTU4145PublicKey paramBCDSTU4145PublicKey)
  {
    try
    {
      paramBCDSTU4145PublicKey = SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray(paramBCDSTU4145PublicKey.getEncoded())).getPublicKeyData();
      return paramBCDSTU4145PublicKey;
    }
    catch (IOException paramBCDSTU4145PublicKey)
    {
      for (;;) {}
    }
    return null;
  }
  
  private void populateFromPrivKeyInfo(PrivateKeyInfo paramPrivateKeyInfo)
    throws IOException
  {
    Object localObject1 = new X962Parameters((ASN1Primitive)paramPrivateKeyInfo.getPrivateKeyAlgorithm().getParameters());
    if (((X962Parameters)localObject1).isNamedCurve())
    {
      localObject1 = ASN1ObjectIdentifier.getInstance(((X962Parameters)localObject1).getParameters());
      Object localObject2 = ECUtil.getNamedCurveByOid((ASN1ObjectIdentifier)localObject1);
      EllipticCurve localEllipticCurve;
      if (localObject2 == null)
      {
        localObject2 = DSTU4145NamedCurves.getByOID((ASN1ObjectIdentifier)localObject1);
        localEllipticCurve = EC5Util.convertCurve(((ECDomainParameters)localObject2).getCurve(), ((ECDomainParameters)localObject2).getSeed());
        localObject1 = new ECNamedCurveSpec(((ASN1ObjectIdentifier)localObject1).getId(), localEllipticCurve, new java.security.spec.ECPoint(((ECDomainParameters)localObject2).getG().getAffineXCoord().toBigInteger(), ((ECDomainParameters)localObject2).getG().getAffineYCoord().toBigInteger()), ((ECDomainParameters)localObject2).getN(), ((ECDomainParameters)localObject2).getH());
      }
      else
      {
        localEllipticCurve = EC5Util.convertCurve(((X9ECParameters)localObject2).getCurve(), ((X9ECParameters)localObject2).getSeed());
        localObject1 = new ECNamedCurveSpec(ECUtil.getCurveName((ASN1ObjectIdentifier)localObject1), localEllipticCurve, new java.security.spec.ECPoint(((X9ECParameters)localObject2).getG().getAffineXCoord().toBigInteger(), ((X9ECParameters)localObject2).getG().getAffineYCoord().toBigInteger()), ((X9ECParameters)localObject2).getN(), ((X9ECParameters)localObject2).getH());
      }
    }
    else
    {
      if (((X962Parameters)localObject1).isImplicitlyCA())
      {
        this.ecSpec = null;
        break label262;
      }
      localObject1 = X9ECParameters.getInstance(((X962Parameters)localObject1).getParameters());
      localObject1 = new java.security.spec.ECParameterSpec(EC5Util.convertCurve(((X9ECParameters)localObject1).getCurve(), ((X9ECParameters)localObject1).getSeed()), new java.security.spec.ECPoint(((X9ECParameters)localObject1).getG().getAffineXCoord().toBigInteger(), ((X9ECParameters)localObject1).getG().getAffineYCoord().toBigInteger()), ((X9ECParameters)localObject1).getN(), ((X9ECParameters)localObject1).getH().intValue());
    }
    this.ecSpec = ((java.security.spec.ECParameterSpec)localObject1);
    label262:
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
    populateFromPrivKeyInfo(PrivateKeyInfo.getInstance(ASN1Primitive.fromByteArray((byte[])paramObjectInputStream.readObject())));
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
    return BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof BCDSTU4145PrivateKey;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (BCDSTU4145PrivateKey)paramObject;
    bool1 = bool2;
    if (getD().equals(((BCDSTU4145PrivateKey)paramObject).getD()))
    {
      bool1 = bool2;
      if (engineGetSpec().equals(((BCDSTU4145PrivateKey)paramObject).engineGetSpec())) {
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
    Object localObject1 = this.ecSpec;
    Object localObject2;
    if ((localObject1 instanceof ECNamedCurveSpec))
    {
      localObject2 = ECUtil.getNamedCurveOid(((ECNamedCurveSpec)localObject1).getName());
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ASN1ObjectIdentifier(((ECNamedCurveSpec)this.ecSpec).getName());
      }
      localObject1 = new X962Parameters((ASN1ObjectIdentifier)localObject1);
    }
    else
    {
      if (localObject1 == null)
      {
        localObject1 = new X962Parameters(DERNull.INSTANCE);
        i = ECUtil.getOrderBitLength(BouncyCastleProvider.CONFIGURATION, null, getS());
        break label174;
      }
      localObject1 = EC5Util.convertCurve(((java.security.spec.ECParameterSpec)localObject1).getCurve());
      localObject1 = new X962Parameters(new X9ECParameters((ECCurve)localObject1, EC5Util.convertPoint((ECCurve)localObject1, this.ecSpec.getGenerator(), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf(this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed()));
    }
    int i = ECUtil.getOrderBitLength(BouncyCastleProvider.CONFIGURATION, this.ecSpec.getOrder(), getS());
    label174:
    if (this.publicKey != null) {
      localObject2 = new org.bouncycastle.asn1.sec.ECPrivateKey(i, getS(), this.publicKey, (ASN1Encodable)localObject1);
    } else {
      localObject2 = new org.bouncycastle.asn1.sec.ECPrivateKey(i, getS(), (ASN1Encodable)localObject1);
    }
    try
    {
      if (this.algorithm.equals("DSTU4145")) {
        localObject1 = new PrivateKeyInfo(new AlgorithmIdentifier(UAObjectIdentifiers.dstu4145be, ((X962Parameters)localObject1).toASN1Primitive()), ((org.bouncycastle.asn1.sec.ECPrivateKey)localObject2).toASN1Primitive());
      } else {
        localObject1 = new PrivateKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, ((X962Parameters)localObject1).toASN1Primitive()), ((org.bouncycastle.asn1.sec.ECPrivateKey)localObject2).toASN1Primitive());
      }
      localObject1 = ((PrivateKeyInfo)localObject1).getEncoded("DER");
      return (byte[])localObject1;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\dstu\BCDSTU4145PrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */