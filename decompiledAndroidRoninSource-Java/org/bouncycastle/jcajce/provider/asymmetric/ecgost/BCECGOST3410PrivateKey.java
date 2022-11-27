package org.bouncycastle.jcajce.provider.asymmetric.ecgost;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.spec.EllipticCurve;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import org.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jce.ECGOST3410NamedCurveTable;
import org.bouncycastle.jce.interfaces.ECPointEncoder;
import org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.jce.spec.ECNamedCurveSpec;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.util.Strings;

public class BCECGOST3410PrivateKey
  implements java.security.interfaces.ECPrivateKey, org.bouncycastle.jce.interfaces.ECPrivateKey, PKCS12BagAttributeCarrier, ECPointEncoder
{
  static final long serialVersionUID = 7245981689601667138L;
  private String algorithm = "ECGOST3410";
  private transient PKCS12BagAttributeCarrierImpl attrCarrier = new PKCS12BagAttributeCarrierImpl();
  private transient BigInteger d;
  private transient java.security.spec.ECParameterSpec ecSpec;
  private transient GOST3410PublicKeyAlgParameters gostParams;
  private transient DERBitString publicKey;
  private boolean withCompression;
  
  protected BCECGOST3410PrivateKey() {}
  
  public BCECGOST3410PrivateKey(String paramString, ECPrivateKeyParameters paramECPrivateKeyParameters)
  {
    this.algorithm = paramString;
    this.d = paramECPrivateKeyParameters.getD();
    this.ecSpec = null;
  }
  
  public BCECGOST3410PrivateKey(String paramString, ECPrivateKeyParameters paramECPrivateKeyParameters, BCECGOST3410PublicKey paramBCECGOST3410PublicKey, java.security.spec.ECParameterSpec paramECParameterSpec)
  {
    ECDomainParameters localECDomainParameters = paramECPrivateKeyParameters.getParameters();
    this.algorithm = paramString;
    this.d = paramECPrivateKeyParameters.getD();
    if (paramECParameterSpec == null) {
      this.ecSpec = new java.security.spec.ECParameterSpec(EC5Util.convertCurve(localECDomainParameters.getCurve(), localECDomainParameters.getSeed()), new java.security.spec.ECPoint(localECDomainParameters.getG().getAffineXCoord().toBigInteger(), localECDomainParameters.getG().getAffineYCoord().toBigInteger()), localECDomainParameters.getN(), localECDomainParameters.getH().intValue());
    } else {
      this.ecSpec = paramECParameterSpec;
    }
    this.gostParams = paramBCECGOST3410PublicKey.getGostParams();
    this.publicKey = getPublicKeyDetails(paramBCECGOST3410PublicKey);
  }
  
  public BCECGOST3410PrivateKey(String paramString, ECPrivateKeyParameters paramECPrivateKeyParameters, BCECGOST3410PublicKey paramBCECGOST3410PublicKey, org.bouncycastle.jce.spec.ECParameterSpec paramECParameterSpec)
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
    this.gostParams = paramBCECGOST3410PublicKey.getGostParams();
    this.publicKey = getPublicKeyDetails(paramBCECGOST3410PublicKey);
  }
  
  public BCECGOST3410PrivateKey(java.security.interfaces.ECPrivateKey paramECPrivateKey)
  {
    this.d = paramECPrivateKey.getS();
    this.algorithm = paramECPrivateKey.getAlgorithm();
    this.ecSpec = paramECPrivateKey.getParams();
  }
  
  public BCECGOST3410PrivateKey(java.security.spec.ECPrivateKeySpec paramECPrivateKeySpec)
  {
    this.d = paramECPrivateKeySpec.getS();
    this.ecSpec = paramECPrivateKeySpec.getParams();
  }
  
  BCECGOST3410PrivateKey(PrivateKeyInfo paramPrivateKeyInfo)
    throws IOException
  {
    populateFromPrivKeyInfo(paramPrivateKeyInfo);
  }
  
  public BCECGOST3410PrivateKey(BCECGOST3410PrivateKey paramBCECGOST3410PrivateKey)
  {
    this.d = paramBCECGOST3410PrivateKey.d;
    this.ecSpec = paramBCECGOST3410PrivateKey.ecSpec;
    this.withCompression = paramBCECGOST3410PrivateKey.withCompression;
    this.attrCarrier = paramBCECGOST3410PrivateKey.attrCarrier;
    this.publicKey = paramBCECGOST3410PrivateKey.publicKey;
    this.gostParams = paramBCECGOST3410PrivateKey.gostParams;
  }
  
  public BCECGOST3410PrivateKey(org.bouncycastle.jce.spec.ECPrivateKeySpec paramECPrivateKeySpec)
  {
    this.d = paramECPrivateKeySpec.getD();
    if (paramECPrivateKeySpec.getParams() != null) {
      paramECPrivateKeySpec = EC5Util.convertSpec(EC5Util.convertCurve(paramECPrivateKeySpec.getParams().getCurve(), paramECPrivateKeySpec.getParams().getSeed()), paramECPrivateKeySpec.getParams());
    } else {
      paramECPrivateKeySpec = null;
    }
    this.ecSpec = paramECPrivateKeySpec;
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
  
  private DERBitString getPublicKeyDetails(BCECGOST3410PublicKey paramBCECGOST3410PublicKey)
  {
    try
    {
      paramBCECGOST3410PublicKey = SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray(paramBCECGOST3410PublicKey.getEncoded())).getPublicKeyData();
      return paramBCECGOST3410PublicKey;
    }
    catch (IOException paramBCECGOST3410PublicKey)
    {
      for (;;) {}
    }
    return null;
  }
  
  private void populateFromPrivKeyInfo(PrivateKeyInfo paramPrivateKeyInfo)
    throws IOException
  {
    Object localObject1 = paramPrivateKeyInfo.getPrivateKeyAlgorithm().getParameters().toASN1Primitive();
    Object localObject2;
    if (((localObject1 instanceof ASN1Sequence)) && ((ASN1Sequence.getInstance(localObject1).size() == 2) || (ASN1Sequence.getInstance(localObject1).size() == 3)))
    {
      localObject1 = GOST3410PublicKeyAlgParameters.getInstance(paramPrivateKeyInfo.getPrivateKeyAlgorithm().getParameters());
      this.gostParams = ((GOST3410PublicKeyAlgParameters)localObject1);
      localObject1 = ECGOST3410NamedCurveTable.getParameterSpec(ECGOST3410NamedCurves.getName(((GOST3410PublicKeyAlgParameters)localObject1).getPublicKeyParamSet()));
      localObject2 = EC5Util.convertCurve(((ECNamedCurveParameterSpec)localObject1).getCurve(), ((ECNamedCurveParameterSpec)localObject1).getSeed());
      this.ecSpec = new ECNamedCurveSpec(ECGOST3410NamedCurves.getName(this.gostParams.getPublicKeyParamSet()), (EllipticCurve)localObject2, new java.security.spec.ECPoint(((ECNamedCurveParameterSpec)localObject1).getG().getAffineXCoord().toBigInteger(), ((ECNamedCurveParameterSpec)localObject1).getG().getAffineYCoord().toBigInteger()), ((ECNamedCurveParameterSpec)localObject1).getN(), ((ECNamedCurveParameterSpec)localObject1).getH());
      paramPrivateKeyInfo = paramPrivateKeyInfo.parsePrivateKey();
      if ((paramPrivateKeyInfo instanceof ASN1Integer))
      {
        paramPrivateKeyInfo = ASN1Integer.getInstance(paramPrivateKeyInfo).getPositiveValue();
      }
      else
      {
        paramPrivateKeyInfo = ASN1OctetString.getInstance(paramPrivateKeyInfo).getOctets();
        localObject1 = new byte[paramPrivateKeyInfo.length];
        int i = 0;
        while (i != paramPrivateKeyInfo.length)
        {
          localObject1[i] = paramPrivateKeyInfo[(paramPrivateKeyInfo.length - 1 - i)];
          i += 1;
        }
        paramPrivateKeyInfo = new BigInteger(1, (byte[])localObject1);
      }
    }
    else
    {
      localObject1 = X962Parameters.getInstance(paramPrivateKeyInfo.getPrivateKeyAlgorithm().getParameters());
      if (((X962Parameters)localObject1).isNamedCurve())
      {
        localObject1 = ASN1ObjectIdentifier.getInstance(((X962Parameters)localObject1).getParameters());
        localObject2 = ECUtil.getNamedCurveByOid((ASN1ObjectIdentifier)localObject1);
        EllipticCurve localEllipticCurve;
        if (localObject2 == null)
        {
          localObject2 = ECGOST3410NamedCurves.getByOID((ASN1ObjectIdentifier)localObject1);
          localEllipticCurve = EC5Util.convertCurve(((ECDomainParameters)localObject2).getCurve(), ((ECDomainParameters)localObject2).getSeed());
          localObject1 = new ECNamedCurveSpec(ECGOST3410NamedCurves.getName((ASN1ObjectIdentifier)localObject1), localEllipticCurve, new java.security.spec.ECPoint(((ECDomainParameters)localObject2).getG().getAffineXCoord().toBigInteger(), ((ECDomainParameters)localObject2).getG().getAffineYCoord().toBigInteger()), ((ECDomainParameters)localObject2).getN(), ((ECDomainParameters)localObject2).getH());
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
          break label485;
        }
        localObject1 = X9ECParameters.getInstance(((X962Parameters)localObject1).getParameters());
        localObject1 = new java.security.spec.ECParameterSpec(EC5Util.convertCurve(((X9ECParameters)localObject1).getCurve(), ((X9ECParameters)localObject1).getSeed()), new java.security.spec.ECPoint(((X9ECParameters)localObject1).getG().getAffineXCoord().toBigInteger(), ((X9ECParameters)localObject1).getG().getAffineYCoord().toBigInteger()), ((X9ECParameters)localObject1).getN(), ((X9ECParameters)localObject1).getH().intValue());
      }
      this.ecSpec = ((java.security.spec.ECParameterSpec)localObject1);
      label485:
      paramPrivateKeyInfo = paramPrivateKeyInfo.parsePrivateKey();
      if (!(paramPrivateKeyInfo instanceof ASN1Integer)) {
        break label511;
      }
      paramPrivateKeyInfo = ASN1Integer.getInstance(paramPrivateKeyInfo).getValue();
    }
    this.d = paramPrivateKeyInfo;
    return;
    label511:
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
    boolean bool1 = paramObject instanceof BCECGOST3410PrivateKey;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (BCECGOST3410PrivateKey)paramObject;
    bool1 = bool2;
    if (getD().equals(((BCECGOST3410PrivateKey)paramObject).getD()))
    {
      bool1 = bool2;
      if (engineGetSpec().equals(((BCECGOST3410PrivateKey)paramObject).engineGetSpec())) {
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
  
  /* Error */
  public byte[] getEncoded()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 124	org/bouncycastle/jcajce/provider/asymmetric/ecgost/BCECGOST3410PrivateKey:gostParams	Lorg/bouncycastle/asn1/cryptopro/GOST3410PublicKeyAlgParameters;
    //   4: ifnull +56 -> 60
    //   7: bipush 32
    //   9: newarray <illegal type>
    //   11: astore_2
    //   12: aload_0
    //   13: aload_2
    //   14: iconst_0
    //   15: aload_0
    //   16: invokevirtual 402	org/bouncycastle/jcajce/provider/asymmetric/ecgost/BCECGOST3410PrivateKey:getS	()Ljava/math/BigInteger;
    //   19: invokespecial 404	org/bouncycastle/jcajce/provider/asymmetric/ecgost/BCECGOST3410PrivateKey:extractBytes	([BILjava/math/BigInteger;)V
    //   22: new 208	org/bouncycastle/asn1/pkcs/PrivateKeyInfo
    //   25: dup
    //   26: new 214	org/bouncycastle/asn1/x509/AlgorithmIdentifier
    //   29: dup
    //   30: getstatic 410	org/bouncycastle/asn1/cryptopro/CryptoProObjectIdentifiers:gostR3410_2001	Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;
    //   33: aload_0
    //   34: getfield 124	org/bouncycastle/jcajce/provider/asymmetric/ecgost/BCECGOST3410PrivateKey:gostParams	Lorg/bouncycastle/asn1/cryptopro/GOST3410PublicKeyAlgParameters;
    //   37: invokespecial 413	org/bouncycastle/asn1/x509/AlgorithmIdentifier:<init>	(Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;Lorg/bouncycastle/asn1/ASN1Encodable;)V
    //   40: new 415	org/bouncycastle/asn1/DEROctetString
    //   43: dup
    //   44: aload_2
    //   45: invokespecial 418	org/bouncycastle/asn1/DEROctetString:<init>	([B)V
    //   48: invokespecial 421	org/bouncycastle/asn1/pkcs/PrivateKeyInfo:<init>	(Lorg/bouncycastle/asn1/x509/AlgorithmIdentifier;Lorg/bouncycastle/asn1/ASN1Encodable;)V
    //   51: ldc_w 423
    //   54: invokevirtual 426	org/bouncycastle/asn1/pkcs/PrivateKeyInfo:getEncoded	(Ljava/lang/String;)[B
    //   57: astore_2
    //   58: aload_2
    //   59: areturn
    //   60: aload_0
    //   61: getfield 55	org/bouncycastle/jcajce/provider/asymmetric/ecgost/BCECGOST3410PrivateKey:ecSpec	Ljava/security/spec/ECParameterSpec;
    //   64: astore_2
    //   65: aload_2
    //   66: instanceof 258
    //   69: ifeq +50 -> 119
    //   72: aload_2
    //   73: checkcast 258	org/bouncycastle/jce/spec/ECNamedCurveSpec
    //   76: invokevirtual 428	org/bouncycastle/jce/spec/ECNamedCurveSpec:getName	()Ljava/lang/String;
    //   79: invokestatic 432	org/bouncycastle/jcajce/provider/asymmetric/util/ECUtil:getNamedCurveOid	(Ljava/lang/String;)Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;
    //   82: astore_3
    //   83: aload_3
    //   84: astore_2
    //   85: aload_3
    //   86: ifnonnull +21 -> 107
    //   89: new 299	org/bouncycastle/asn1/ASN1ObjectIdentifier
    //   92: dup
    //   93: aload_0
    //   94: getfield 55	org/bouncycastle/jcajce/provider/asymmetric/ecgost/BCECGOST3410PrivateKey:ecSpec	Ljava/security/spec/ECParameterSpec;
    //   97: checkcast 258	org/bouncycastle/jce/spec/ECNamedCurveSpec
    //   100: invokevirtual 428	org/bouncycastle/jce/spec/ECNamedCurveSpec:getName	()Ljava/lang/String;
    //   103: invokespecial 435	org/bouncycastle/asn1/ASN1ObjectIdentifier:<init>	(Ljava/lang/String;)V
    //   106: astore_2
    //   107: new 288	org/bouncycastle/asn1/x9/X962Parameters
    //   110: dup
    //   111: aload_2
    //   112: invokespecial 438	org/bouncycastle/asn1/x9/X962Parameters:<init>	(Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;)V
    //   115: astore_2
    //   116: goto +100 -> 216
    //   119: aload_2
    //   120: ifnonnull +29 -> 149
    //   123: new 288	org/bouncycastle/asn1/x9/X962Parameters
    //   126: dup
    //   127: getstatic 444	org/bouncycastle/asn1/DERNull:INSTANCE	Lorg/bouncycastle/asn1/DERNull;
    //   130: invokespecial 447	org/bouncycastle/asn1/x9/X962Parameters:<init>	(Lorg/bouncycastle/asn1/ASN1Null;)V
    //   133: astore_2
    //   134: getstatic 380	org/bouncycastle/jce/provider/BouncyCastleProvider:CONFIGURATION	Lorg/bouncycastle/jcajce/provider/config/ProviderConfiguration;
    //   137: aconst_null
    //   138: aload_0
    //   139: invokevirtual 402	org/bouncycastle/jcajce/provider/asymmetric/ecgost/BCECGOST3410PrivateKey:getS	()Ljava/math/BigInteger;
    //   142: invokestatic 451	org/bouncycastle/jcajce/provider/asymmetric/util/ECUtil:getOrderBitLength	(Lorg/bouncycastle/jcajce/provider/config/ProviderConfiguration;Ljava/math/BigInteger;Ljava/math/BigInteger;)I
    //   145: istore_1
    //   146: goto +88 -> 234
    //   149: aload_2
    //   150: invokevirtual 454	java/security/spec/ECParameterSpec:getCurve	()Ljava/security/spec/EllipticCurve;
    //   153: invokestatic 457	org/bouncycastle/jcajce/provider/asymmetric/util/EC5Util:convertCurve	(Ljava/security/spec/EllipticCurve;)Lorg/bouncycastle/math/ec/ECCurve;
    //   156: astore_2
    //   157: new 288	org/bouncycastle/asn1/x9/X962Parameters
    //   160: dup
    //   161: new 314	org/bouncycastle/asn1/x9/X9ECParameters
    //   164: dup
    //   165: aload_2
    //   166: aload_2
    //   167: aload_0
    //   168: getfield 55	org/bouncycastle/jcajce/provider/asymmetric/ecgost/BCECGOST3410PrivateKey:ecSpec	Ljava/security/spec/ECParameterSpec;
    //   171: invokevirtual 461	java/security/spec/ECParameterSpec:getGenerator	()Ljava/security/spec/ECPoint;
    //   174: aload_0
    //   175: getfield 165	org/bouncycastle/jcajce/provider/asymmetric/ecgost/BCECGOST3410PrivateKey:withCompression	Z
    //   178: invokestatic 465	org/bouncycastle/jcajce/provider/asymmetric/util/EC5Util:convertPoint	(Lorg/bouncycastle/math/ec/ECCurve;Ljava/security/spec/ECPoint;Z)Lorg/bouncycastle/math/ec/ECPoint;
    //   181: aload_0
    //   182: getfield 55	org/bouncycastle/jcajce/provider/asymmetric/ecgost/BCECGOST3410PrivateKey:ecSpec	Ljava/security/spec/ECParameterSpec;
    //   185: invokevirtual 468	java/security/spec/ECParameterSpec:getOrder	()Ljava/math/BigInteger;
    //   188: aload_0
    //   189: getfield 55	org/bouncycastle/jcajce/provider/asymmetric/ecgost/BCECGOST3410PrivateKey:ecSpec	Ljava/security/spec/ECParameterSpec;
    //   192: invokevirtual 471	java/security/spec/ECParameterSpec:getCofactor	()I
    //   195: i2l
    //   196: invokestatic 475	java/math/BigInteger:valueOf	(J)Ljava/math/BigInteger;
    //   199: aload_0
    //   200: getfield 55	org/bouncycastle/jcajce/provider/asymmetric/ecgost/BCECGOST3410PrivateKey:ecSpec	Ljava/security/spec/ECParameterSpec;
    //   203: invokevirtual 454	java/security/spec/ECParameterSpec:getCurve	()Ljava/security/spec/EllipticCurve;
    //   206: invokevirtual 478	java/security/spec/EllipticCurve:getSeed	()[B
    //   209: invokespecial 481	org/bouncycastle/asn1/x9/X9ECParameters:<init>	(Lorg/bouncycastle/math/ec/ECCurve;Lorg/bouncycastle/math/ec/ECPoint;Ljava/math/BigInteger;Ljava/math/BigInteger;[B)V
    //   212: invokespecial 484	org/bouncycastle/asn1/x9/X962Parameters:<init>	(Lorg/bouncycastle/asn1/x9/X9ECParameters;)V
    //   215: astore_2
    //   216: getstatic 380	org/bouncycastle/jce/provider/BouncyCastleProvider:CONFIGURATION	Lorg/bouncycastle/jcajce/provider/config/ProviderConfiguration;
    //   219: aload_0
    //   220: getfield 55	org/bouncycastle/jcajce/provider/asymmetric/ecgost/BCECGOST3410PrivateKey:ecSpec	Ljava/security/spec/ECParameterSpec;
    //   223: invokevirtual 468	java/security/spec/ECParameterSpec:getOrder	()Ljava/math/BigInteger;
    //   226: aload_0
    //   227: invokevirtual 402	org/bouncycastle/jcajce/provider/asymmetric/ecgost/BCECGOST3410PrivateKey:getS	()Ljava/math/BigInteger;
    //   230: invokestatic 451	org/bouncycastle/jcajce/provider/asymmetric/util/ECUtil:getOrderBitLength	(Lorg/bouncycastle/jcajce/provider/config/ProviderConfiguration;Ljava/math/BigInteger;Ljava/math/BigInteger;)I
    //   233: istore_1
    //   234: aload_0
    //   235: getfield 130	org/bouncycastle/jcajce/provider/asymmetric/ecgost/BCECGOST3410PrivateKey:publicKey	Lorg/bouncycastle/asn1/DERBitString;
    //   238: ifnull +24 -> 262
    //   241: new 333	org/bouncycastle/asn1/sec/ECPrivateKey
    //   244: dup
    //   245: iload_1
    //   246: aload_0
    //   247: invokevirtual 402	org/bouncycastle/jcajce/provider/asymmetric/ecgost/BCECGOST3410PrivateKey:getS	()Ljava/math/BigInteger;
    //   250: aload_0
    //   251: getfield 130	org/bouncycastle/jcajce/provider/asymmetric/ecgost/BCECGOST3410PrivateKey:publicKey	Lorg/bouncycastle/asn1/DERBitString;
    //   254: aload_2
    //   255: invokespecial 487	org/bouncycastle/asn1/sec/ECPrivateKey:<init>	(ILjava/math/BigInteger;Lorg/bouncycastle/asn1/DERBitString;Lorg/bouncycastle/asn1/ASN1Encodable;)V
    //   258: astore_3
    //   259: goto +17 -> 276
    //   262: new 333	org/bouncycastle/asn1/sec/ECPrivateKey
    //   265: dup
    //   266: iload_1
    //   267: aload_0
    //   268: invokevirtual 402	org/bouncycastle/jcajce/provider/asymmetric/ecgost/BCECGOST3410PrivateKey:getS	()Ljava/math/BigInteger;
    //   271: aload_2
    //   272: invokespecial 490	org/bouncycastle/asn1/sec/ECPrivateKey:<init>	(ILjava/math/BigInteger;Lorg/bouncycastle/asn1/ASN1Encodable;)V
    //   275: astore_3
    //   276: new 208	org/bouncycastle/asn1/pkcs/PrivateKeyInfo
    //   279: dup
    //   280: new 214	org/bouncycastle/asn1/x509/AlgorithmIdentifier
    //   283: dup
    //   284: getstatic 410	org/bouncycastle/asn1/cryptopro/CryptoProObjectIdentifiers:gostR3410_2001	Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;
    //   287: aload_2
    //   288: invokevirtual 491	org/bouncycastle/asn1/x9/X962Parameters:toASN1Primitive	()Lorg/bouncycastle/asn1/ASN1Primitive;
    //   291: invokespecial 413	org/bouncycastle/asn1/x509/AlgorithmIdentifier:<init>	(Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;Lorg/bouncycastle/asn1/ASN1Encodable;)V
    //   294: aload_3
    //   295: invokevirtual 492	org/bouncycastle/asn1/sec/ECPrivateKey:toASN1Primitive	()Lorg/bouncycastle/asn1/ASN1Primitive;
    //   298: invokespecial 421	org/bouncycastle/asn1/pkcs/PrivateKeyInfo:<init>	(Lorg/bouncycastle/asn1/x509/AlgorithmIdentifier;Lorg/bouncycastle/asn1/ASN1Encodable;)V
    //   301: ldc_w 423
    //   304: invokevirtual 426	org/bouncycastle/asn1/pkcs/PrivateKeyInfo:getEncoded	(Ljava/lang/String;)[B
    //   307: astore_2
    //   308: aload_2
    //   309: areturn
    //   310: astore_2
    //   311: aconst_null
    //   312: areturn
    //   313: astore_2
    //   314: aconst_null
    //   315: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	316	0	this	BCECGOST3410PrivateKey
    //   145	122	1	i	int
    //   11	298	2	localObject1	Object
    //   310	1	2	localIOException1	IOException
    //   313	1	2	localIOException2	IOException
    //   82	213	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   22	58	310	java/io/IOException
    //   276	308	313	java/io/IOException
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\ecgost\BCECGOST3410PrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */