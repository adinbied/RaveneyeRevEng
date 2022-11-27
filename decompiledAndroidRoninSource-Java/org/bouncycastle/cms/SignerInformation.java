package org.bouncycastle.cms;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.cms.Attribute;
import org.bouncycastle.asn1.cms.AttributeTable;
import org.bouncycastle.asn1.cms.CMSAttributes;
import org.bouncycastle.asn1.cms.IssuerAndSerialNumber;
import org.bouncycastle.asn1.cms.SignerIdentifier;
import org.bouncycastle.asn1.cms.SignerInfo;
import org.bouncycastle.asn1.cms.Time;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.util.Arrays;

public class SignerInformation
{
  private final CMSProcessable content;
  private final ASN1ObjectIdentifier contentType;
  protected final AlgorithmIdentifier digestAlgorithm;
  protected final AlgorithmIdentifier encryptionAlgorithm;
  protected final SignerInfo info;
  private final boolean isCounterSignature;
  private byte[] resultDigest;
  private final SignerId sid;
  private final byte[] signature;
  protected final ASN1Set signedAttributeSet;
  private AttributeTable signedAttributeValues;
  protected final ASN1Set unsignedAttributeSet;
  private AttributeTable unsignedAttributeValues;
  
  SignerInformation(SignerInfo paramSignerInfo, ASN1ObjectIdentifier paramASN1ObjectIdentifier, CMSProcessable paramCMSProcessable, byte[] paramArrayOfByte)
  {
    this.info = paramSignerInfo;
    this.contentType = paramASN1ObjectIdentifier;
    if (paramASN1ObjectIdentifier == null) {
      bool = true;
    } else {
      bool = false;
    }
    this.isCounterSignature = bool;
    paramASN1ObjectIdentifier = paramSignerInfo.getSID();
    boolean bool = paramASN1ObjectIdentifier.isTagged();
    paramASN1ObjectIdentifier = paramASN1ObjectIdentifier.getId();
    if (bool)
    {
      paramASN1ObjectIdentifier = new SignerId(ASN1OctetString.getInstance(paramASN1ObjectIdentifier).getOctets());
    }
    else
    {
      paramASN1ObjectIdentifier = IssuerAndSerialNumber.getInstance(paramASN1ObjectIdentifier);
      paramASN1ObjectIdentifier = new SignerId(paramASN1ObjectIdentifier.getName(), paramASN1ObjectIdentifier.getSerialNumber().getValue());
    }
    this.sid = paramASN1ObjectIdentifier;
    this.digestAlgorithm = paramSignerInfo.getDigestAlgorithm();
    this.signedAttributeSet = paramSignerInfo.getAuthenticatedAttributes();
    this.unsignedAttributeSet = paramSignerInfo.getUnauthenticatedAttributes();
    this.encryptionAlgorithm = paramSignerInfo.getDigestEncryptionAlgorithm();
    this.signature = paramSignerInfo.getEncryptedDigest().getOctets();
    this.content = paramCMSProcessable;
    this.resultDigest = paramArrayOfByte;
  }
  
  protected SignerInformation(SignerInformation paramSignerInformation)
  {
    this.info = paramSignerInformation.info;
    this.contentType = paramSignerInformation.contentType;
    this.isCounterSignature = paramSignerInformation.isCounterSignature();
    this.sid = paramSignerInformation.getSID();
    this.digestAlgorithm = this.info.getDigestAlgorithm();
    this.signedAttributeSet = this.info.getAuthenticatedAttributes();
    this.unsignedAttributeSet = this.info.getUnauthenticatedAttributes();
    this.encryptionAlgorithm = this.info.getDigestEncryptionAlgorithm();
    this.signature = this.info.getEncryptedDigest().getOctets();
    this.content = paramSignerInformation.content;
    this.resultDigest = paramSignerInformation.resultDigest;
  }
  
  public static SignerInformation addCounterSigners(SignerInformation paramSignerInformation, SignerInformationStore paramSignerInformationStore)
  {
    SignerInfo localSignerInfo = paramSignerInformation.info;
    Object localObject = paramSignerInformation.getUnsignedAttributes();
    if (localObject != null) {
      localObject = ((AttributeTable)localObject).toASN1EncodableVector();
    } else {
      localObject = new ASN1EncodableVector();
    }
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    paramSignerInformationStore = paramSignerInformationStore.getSigners().iterator();
    while (paramSignerInformationStore.hasNext()) {
      localASN1EncodableVector.add(((SignerInformation)paramSignerInformationStore.next()).toASN1Structure());
    }
    ((ASN1EncodableVector)localObject).add(new Attribute(CMSAttributes.counterSignature, new DERSet(localASN1EncodableVector)));
    return new SignerInformation(new SignerInfo(localSignerInfo.getSID(), localSignerInfo.getDigestAlgorithm(), localSignerInfo.getAuthenticatedAttributes(), localSignerInfo.getDigestEncryptionAlgorithm(), localSignerInfo.getEncryptedDigest(), new DERSet((ASN1EncodableVector)localObject)), paramSignerInformation.contentType, paramSignerInformation.content, null);
  }
  
  /* Error */
  private boolean doVerify(SignerInformationVerifier paramSignerInformationVerifier)
    throws CMSException
  {
    // Byte code:
    //   0: getstatic 209	org/bouncycastle/cms/CMSSignedHelper:INSTANCE	Lorg/bouncycastle/cms/CMSSignedHelper;
    //   3: aload_0
    //   4: invokevirtual 213	org/bouncycastle/cms/SignerInformation:getEncryptionAlgOID	()Ljava/lang/String;
    //   7: invokevirtual 217	org/bouncycastle/cms/CMSSignedHelper:getEncryptionAlgName	(Ljava/lang/String;)Ljava/lang/String;
    //   10: astore 4
    //   12: aload_1
    //   13: aload_0
    //   14: getfield 114	org/bouncycastle/cms/SignerInformation:encryptionAlgorithm	Lorg/bouncycastle/asn1/x509/AlgorithmIdentifier;
    //   17: aload_0
    //   18: getfield 33	org/bouncycastle/cms/SignerInformation:info	Lorg/bouncycastle/asn1/cms/SignerInfo;
    //   21: invokevirtual 96	org/bouncycastle/asn1/cms/SignerInfo:getDigestAlgorithm	()Lorg/bouncycastle/asn1/x509/AlgorithmIdentifier;
    //   24: invokevirtual 223	org/bouncycastle/cms/SignerInformationVerifier:getContentVerifier	(Lorg/bouncycastle/asn1/x509/AlgorithmIdentifier;Lorg/bouncycastle/asn1/x509/AlgorithmIdentifier;)Lorg/bouncycastle/operator/ContentVerifier;
    //   27: astore 5
    //   29: aload 5
    //   31: invokeinterface 229 1 0
    //   36: astore 6
    //   38: aload_0
    //   39: getfield 124	org/bouncycastle/cms/SignerInformation:resultDigest	[B
    //   42: ifnonnull +156 -> 198
    //   45: aload_1
    //   46: aload_0
    //   47: invokevirtual 232	org/bouncycastle/cms/SignerInformation:getDigestAlgorithmID	()Lorg/bouncycastle/asn1/x509/AlgorithmIdentifier;
    //   50: invokevirtual 236	org/bouncycastle/cms/SignerInformationVerifier:getDigestCalculator	(Lorg/bouncycastle/asn1/x509/AlgorithmIdentifier;)Lorg/bouncycastle/operator/DigestCalculator;
    //   53: astore_1
    //   54: aload_0
    //   55: getfield 122	org/bouncycastle/cms/SignerInformation:content	Lorg/bouncycastle/cms/CMSProcessable;
    //   58: ifnull +100 -> 158
    //   61: aload_1
    //   62: invokeinterface 239 1 0
    //   67: astore 7
    //   69: aload_0
    //   70: getfield 104	org/bouncycastle/cms/SignerInformation:signedAttributeSet	Lorg/bouncycastle/asn1/ASN1Set;
    //   73: ifnonnull +57 -> 130
    //   76: aload 5
    //   78: instanceof 241
    //   81: ifeq +17 -> 98
    //   84: aload_0
    //   85: getfield 122	org/bouncycastle/cms/SignerInformation:content	Lorg/bouncycastle/cms/CMSProcessable;
    //   88: aload 7
    //   90: invokeinterface 247 2 0
    //   95: goto +55 -> 150
    //   98: new 249	org/bouncycastle/util/io/TeeOutputStream
    //   101: dup
    //   102: aload 7
    //   104: aload 6
    //   106: invokespecial 252	org/bouncycastle/util/io/TeeOutputStream:<init>	(Ljava/io/OutputStream;Ljava/io/OutputStream;)V
    //   109: astore 8
    //   111: aload_0
    //   112: getfield 122	org/bouncycastle/cms/SignerInformation:content	Lorg/bouncycastle/cms/CMSProcessable;
    //   115: aload 8
    //   117: invokeinterface 247 2 0
    //   122: aload 8
    //   124: invokevirtual 257	java/io/OutputStream:close	()V
    //   127: goto +23 -> 150
    //   130: aload_0
    //   131: getfield 122	org/bouncycastle/cms/SignerInformation:content	Lorg/bouncycastle/cms/CMSProcessable;
    //   134: aload 7
    //   136: invokeinterface 247 2 0
    //   141: aload 6
    //   143: aload_0
    //   144: invokevirtual 260	org/bouncycastle/cms/SignerInformation:getEncodedSignedAttributes	()[B
    //   147: invokevirtual 262	java/io/OutputStream:write	([B)V
    //   150: aload 7
    //   152: invokevirtual 257	java/io/OutputStream:close	()V
    //   155: goto +19 -> 174
    //   158: aload_0
    //   159: getfield 104	org/bouncycastle/cms/SignerInformation:signedAttributeSet	Lorg/bouncycastle/asn1/ASN1Set;
    //   162: ifnull +25 -> 187
    //   165: aload 6
    //   167: aload_0
    //   168: invokevirtual 260	org/bouncycastle/cms/SignerInformation:getEncodedSignedAttributes	()[B
    //   171: invokevirtual 262	java/io/OutputStream:write	([B)V
    //   174: aload_0
    //   175: aload_1
    //   176: invokeinterface 265 1 0
    //   181: putfield 124	org/bouncycastle/cms/SignerInformation:resultDigest	[B
    //   184: goto +51 -> 235
    //   187: new 199	org/bouncycastle/cms/CMSException
    //   190: dup
    //   191: ldc_w 267
    //   194: invokespecial 270	org/bouncycastle/cms/CMSException:<init>	(Ljava/lang/String;)V
    //   197: athrow
    //   198: aload_0
    //   199: getfield 104	org/bouncycastle/cms/SignerInformation:signedAttributeSet	Lorg/bouncycastle/asn1/ASN1Set;
    //   202: ifnonnull +24 -> 226
    //   205: aload_0
    //   206: getfield 122	org/bouncycastle/cms/SignerInformation:content	Lorg/bouncycastle/cms/CMSProcessable;
    //   209: ifnull +26 -> 235
    //   212: aload_0
    //   213: getfield 122	org/bouncycastle/cms/SignerInformation:content	Lorg/bouncycastle/cms/CMSProcessable;
    //   216: aload 6
    //   218: invokeinterface 247 2 0
    //   223: goto +12 -> 235
    //   226: aload 6
    //   228: aload_0
    //   229: invokevirtual 260	org/bouncycastle/cms/SignerInformation:getEncodedSignedAttributes	()[B
    //   232: invokevirtual 262	java/io/OutputStream:write	([B)V
    //   235: aload 6
    //   237: invokevirtual 257	java/io/OutputStream:close	()V
    //   240: aload_0
    //   241: getstatic 271	org/bouncycastle/asn1/cms/CMSAttributes:contentType	Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;
    //   244: ldc_w 273
    //   247: invokespecial 277	org/bouncycastle/cms/SignerInformation:getSingleValuedSignedAttribute	(Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;Ljava/lang/String;)Lorg/bouncycastle/asn1/ASN1Primitive;
    //   250: astore_1
    //   251: aload_1
    //   252: ifnonnull +31 -> 283
    //   255: aload_0
    //   256: getfield 37	org/bouncycastle/cms/SignerInformation:isCounterSignature	Z
    //   259: ifne +52 -> 311
    //   262: aload_0
    //   263: getfield 104	org/bouncycastle/cms/SignerInformation:signedAttributeSet	Lorg/bouncycastle/asn1/ASN1Set;
    //   266: ifnonnull +6 -> 272
    //   269: goto +42 -> 311
    //   272: new 199	org/bouncycastle/cms/CMSException
    //   275: dup
    //   276: ldc_w 279
    //   279: invokespecial 270	org/bouncycastle/cms/CMSException:<init>	(Ljava/lang/String;)V
    //   282: athrow
    //   283: aload_0
    //   284: getfield 37	org/bouncycastle/cms/SignerInformation:isCounterSignature	Z
    //   287: ifne +548 -> 835
    //   290: aload_1
    //   291: instanceof 281
    //   294: ifeq +530 -> 824
    //   297: aload_1
    //   298: checkcast 281	org/bouncycastle/asn1/ASN1ObjectIdentifier
    //   301: aload_0
    //   302: getfield 35	org/bouncycastle/cms/SignerInformation:contentType	Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;
    //   305: invokevirtual 285	org/bouncycastle/asn1/ASN1ObjectIdentifier:equals	(Ljava/lang/Object;)Z
    //   308: ifeq +505 -> 813
    //   311: aload_0
    //   312: invokevirtual 288	org/bouncycastle/cms/SignerInformation:getSignedAttributes	()Lorg/bouncycastle/asn1/cms/AttributeTable;
    //   315: astore_1
    //   316: aload_0
    //   317: invokevirtual 137	org/bouncycastle/cms/SignerInformation:getUnsignedAttributes	()Lorg/bouncycastle/asn1/cms/AttributeTable;
    //   320: astore 6
    //   322: aload 6
    //   324: ifnull +31 -> 355
    //   327: aload 6
    //   329: getstatic 291	org/bouncycastle/asn1/cms/CMSAttributes:cmsAlgorithmProtect	Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;
    //   332: invokevirtual 295	org/bouncycastle/asn1/cms/AttributeTable:getAll	(Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;)Lorg/bouncycastle/asn1/ASN1EncodableVector;
    //   335: invokevirtual 299	org/bouncycastle/asn1/ASN1EncodableVector:size	()I
    //   338: ifgt +6 -> 344
    //   341: goto +14 -> 355
    //   344: new 199	org/bouncycastle/cms/CMSException
    //   347: dup
    //   348: ldc_w 301
    //   351: invokespecial 270	org/bouncycastle/cms/CMSException:<init>	(Ljava/lang/String;)V
    //   354: athrow
    //   355: iconst_0
    //   356: istore_2
    //   357: aload_1
    //   358: ifnull +147 -> 505
    //   361: aload_1
    //   362: getstatic 291	org/bouncycastle/asn1/cms/CMSAttributes:cmsAlgorithmProtect	Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;
    //   365: invokevirtual 295	org/bouncycastle/asn1/cms/AttributeTable:getAll	(Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;)Lorg/bouncycastle/asn1/ASN1EncodableVector;
    //   368: astore 6
    //   370: aload 6
    //   372: invokevirtual 299	org/bouncycastle/asn1/ASN1EncodableVector:size	()I
    //   375: iconst_1
    //   376: if_icmpgt +118 -> 494
    //   379: aload 6
    //   381: invokevirtual 299	org/bouncycastle/asn1/ASN1EncodableVector:size	()I
    //   384: ifle +121 -> 505
    //   387: aload 6
    //   389: iconst_0
    //   390: invokevirtual 305	org/bouncycastle/asn1/ASN1EncodableVector:get	(I)Lorg/bouncycastle/asn1/ASN1Encodable;
    //   393: invokestatic 308	org/bouncycastle/asn1/cms/Attribute:getInstance	(Ljava/lang/Object;)Lorg/bouncycastle/asn1/cms/Attribute;
    //   396: astore 6
    //   398: aload 6
    //   400: invokevirtual 311	org/bouncycastle/asn1/cms/Attribute:getAttrValues	()Lorg/bouncycastle/asn1/ASN1Set;
    //   403: invokevirtual 314	org/bouncycastle/asn1/ASN1Set:size	()I
    //   406: iconst_1
    //   407: if_icmpne +76 -> 483
    //   410: aload 6
    //   412: invokevirtual 318	org/bouncycastle/asn1/cms/Attribute:getAttributeValues	()[Lorg/bouncycastle/asn1/ASN1Encodable;
    //   415: iconst_0
    //   416: aaload
    //   417: invokestatic 323	org/bouncycastle/asn1/cms/CMSAlgorithmProtection:getInstance	(Ljava/lang/Object;)Lorg/bouncycastle/asn1/cms/CMSAlgorithmProtection;
    //   420: astore 6
    //   422: aload 6
    //   424: invokevirtual 324	org/bouncycastle/asn1/cms/CMSAlgorithmProtection:getDigestAlgorithm	()Lorg/bouncycastle/asn1/x509/AlgorithmIdentifier;
    //   427: aload_0
    //   428: getfield 33	org/bouncycastle/cms/SignerInformation:info	Lorg/bouncycastle/asn1/cms/SignerInfo;
    //   431: invokevirtual 96	org/bouncycastle/asn1/cms/SignerInfo:getDigestAlgorithm	()Lorg/bouncycastle/asn1/x509/AlgorithmIdentifier;
    //   434: invokestatic 330	org/bouncycastle/cms/CMSUtils:isEquivalent	(Lorg/bouncycastle/asn1/x509/AlgorithmIdentifier;Lorg/bouncycastle/asn1/x509/AlgorithmIdentifier;)Z
    //   437: ifeq +35 -> 472
    //   440: aload 6
    //   442: invokevirtual 333	org/bouncycastle/asn1/cms/CMSAlgorithmProtection:getSignatureAlgorithm	()Lorg/bouncycastle/asn1/x509/AlgorithmIdentifier;
    //   445: aload_0
    //   446: getfield 33	org/bouncycastle/cms/SignerInformation:info	Lorg/bouncycastle/asn1/cms/SignerInfo;
    //   449: invokevirtual 112	org/bouncycastle/asn1/cms/SignerInfo:getDigestEncryptionAlgorithm	()Lorg/bouncycastle/asn1/x509/AlgorithmIdentifier;
    //   452: invokestatic 330	org/bouncycastle/cms/CMSUtils:isEquivalent	(Lorg/bouncycastle/asn1/x509/AlgorithmIdentifier;Lorg/bouncycastle/asn1/x509/AlgorithmIdentifier;)Z
    //   455: ifeq +6 -> 461
    //   458: goto +47 -> 505
    //   461: new 199	org/bouncycastle/cms/CMSException
    //   464: dup
    //   465: ldc_w 335
    //   468: invokespecial 270	org/bouncycastle/cms/CMSException:<init>	(Ljava/lang/String;)V
    //   471: athrow
    //   472: new 199	org/bouncycastle/cms/CMSException
    //   475: dup
    //   476: ldc_w 337
    //   479: invokespecial 270	org/bouncycastle/cms/CMSException:<init>	(Ljava/lang/String;)V
    //   482: athrow
    //   483: new 199	org/bouncycastle/cms/CMSException
    //   486: dup
    //   487: ldc_w 339
    //   490: invokespecial 270	org/bouncycastle/cms/CMSException:<init>	(Ljava/lang/String;)V
    //   493: athrow
    //   494: new 199	org/bouncycastle/cms/CMSException
    //   497: dup
    //   498: ldc_w 341
    //   501: invokespecial 270	org/bouncycastle/cms/CMSException:<init>	(Ljava/lang/String;)V
    //   504: athrow
    //   505: aload_0
    //   506: getstatic 344	org/bouncycastle/asn1/cms/CMSAttributes:messageDigest	Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;
    //   509: ldc_w 346
    //   512: invokespecial 277	org/bouncycastle/cms/SignerInformation:getSingleValuedSignedAttribute	(Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;Ljava/lang/String;)Lorg/bouncycastle/asn1/ASN1Primitive;
    //   515: astore 6
    //   517: aload 6
    //   519: ifnonnull +24 -> 543
    //   522: aload_0
    //   523: getfield 104	org/bouncycastle/cms/SignerInformation:signedAttributeSet	Lorg/bouncycastle/asn1/ASN1Set;
    //   526: ifnonnull +6 -> 532
    //   529: goto +44 -> 573
    //   532: new 199	org/bouncycastle/cms/CMSException
    //   535: dup
    //   536: ldc_w 348
    //   539: invokespecial 270	org/bouncycastle/cms/CMSException:<init>	(Ljava/lang/String;)V
    //   542: athrow
    //   543: aload 6
    //   545: instanceof 57
    //   548: ifeq +254 -> 802
    //   551: aload 6
    //   553: checkcast 57	org/bouncycastle/asn1/ASN1OctetString
    //   556: astore 6
    //   558: aload_0
    //   559: getfield 124	org/bouncycastle/cms/SignerInformation:resultDigest	[B
    //   562: aload 6
    //   564: invokevirtual 65	org/bouncycastle/asn1/ASN1OctetString:getOctets	()[B
    //   567: invokestatic 354	org/bouncycastle/util/Arrays:constantTimeAreEqual	([B[B)Z
    //   570: ifeq +221 -> 791
    //   573: aload_1
    //   574: ifnull +30 -> 604
    //   577: aload_1
    //   578: getstatic 182	org/bouncycastle/asn1/cms/CMSAttributes:counterSignature	Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;
    //   581: invokevirtual 295	org/bouncycastle/asn1/cms/AttributeTable:getAll	(Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;)Lorg/bouncycastle/asn1/ASN1EncodableVector;
    //   584: invokevirtual 299	org/bouncycastle/asn1/ASN1EncodableVector:size	()I
    //   587: ifgt +6 -> 593
    //   590: goto +14 -> 604
    //   593: new 199	org/bouncycastle/cms/CMSException
    //   596: dup
    //   597: ldc_w 356
    //   600: invokespecial 270	org/bouncycastle/cms/CMSException:<init>	(Ljava/lang/String;)V
    //   603: athrow
    //   604: aload_0
    //   605: invokevirtual 137	org/bouncycastle/cms/SignerInformation:getUnsignedAttributes	()Lorg/bouncycastle/asn1/cms/AttributeTable;
    //   608: astore_1
    //   609: aload_1
    //   610: ifnull +55 -> 665
    //   613: aload_1
    //   614: getstatic 182	org/bouncycastle/asn1/cms/CMSAttributes:counterSignature	Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;
    //   617: invokevirtual 295	org/bouncycastle/asn1/cms/AttributeTable:getAll	(Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;)Lorg/bouncycastle/asn1/ASN1EncodableVector;
    //   620: astore_1
    //   621: iload_2
    //   622: aload_1
    //   623: invokevirtual 299	org/bouncycastle/asn1/ASN1EncodableVector:size	()I
    //   626: if_icmpge +39 -> 665
    //   629: aload_1
    //   630: iload_2
    //   631: invokevirtual 305	org/bouncycastle/asn1/ASN1EncodableVector:get	(I)Lorg/bouncycastle/asn1/ASN1Encodable;
    //   634: invokestatic 308	org/bouncycastle/asn1/cms/Attribute:getInstance	(Ljava/lang/Object;)Lorg/bouncycastle/asn1/cms/Attribute;
    //   637: invokevirtual 311	org/bouncycastle/asn1/cms/Attribute:getAttrValues	()Lorg/bouncycastle/asn1/ASN1Set;
    //   640: invokevirtual 314	org/bouncycastle/asn1/ASN1Set:size	()I
    //   643: iconst_1
    //   644: if_icmplt +10 -> 654
    //   647: iload_2
    //   648: iconst_1
    //   649: iadd
    //   650: istore_2
    //   651: goto -30 -> 621
    //   654: new 199	org/bouncycastle/cms/CMSException
    //   657: dup
    //   658: ldc_w 358
    //   661: invokespecial 270	org/bouncycastle/cms/CMSException:<init>	(Ljava/lang/String;)V
    //   664: athrow
    //   665: aload_0
    //   666: getfield 104	org/bouncycastle/cms/SignerInformation:signedAttributeSet	Lorg/bouncycastle/asn1/ASN1Set;
    //   669: ifnonnull +95 -> 764
    //   672: aload_0
    //   673: getfield 124	org/bouncycastle/cms/SignerInformation:resultDigest	[B
    //   676: ifnull +88 -> 764
    //   679: aload 5
    //   681: instanceof 241
    //   684: ifeq +80 -> 764
    //   687: aload 5
    //   689: checkcast 241	org/bouncycastle/operator/RawContentVerifier
    //   692: astore_1
    //   693: aload 4
    //   695: ldc_w 360
    //   698: invokevirtual 363	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   701: ifeq +48 -> 749
    //   704: aload_1
    //   705: new 365	org/bouncycastle/asn1/x509/DigestInfo
    //   708: dup
    //   709: new 367	org/bouncycastle/asn1/x509/AlgorithmIdentifier
    //   712: dup
    //   713: aload_0
    //   714: getfield 98	org/bouncycastle/cms/SignerInformation:digestAlgorithm	Lorg/bouncycastle/asn1/x509/AlgorithmIdentifier;
    //   717: invokevirtual 371	org/bouncycastle/asn1/x509/AlgorithmIdentifier:getAlgorithm	()Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;
    //   720: getstatic 376	org/bouncycastle/asn1/DERNull:INSTANCE	Lorg/bouncycastle/asn1/DERNull;
    //   723: invokespecial 379	org/bouncycastle/asn1/x509/AlgorithmIdentifier:<init>	(Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;Lorg/bouncycastle/asn1/ASN1Encodable;)V
    //   726: aload_0
    //   727: getfield 124	org/bouncycastle/cms/SignerInformation:resultDigest	[B
    //   730: invokespecial 382	org/bouncycastle/asn1/x509/DigestInfo:<init>	(Lorg/bouncycastle/asn1/x509/AlgorithmIdentifier;[B)V
    //   733: ldc_w 384
    //   736: invokevirtual 388	org/bouncycastle/asn1/x509/DigestInfo:getEncoded	(Ljava/lang/String;)[B
    //   739: aload_0
    //   740: invokevirtual 391	org/bouncycastle/cms/SignerInformation:getSignature	()[B
    //   743: invokeinterface 394 3 0
    //   748: ireturn
    //   749: aload_1
    //   750: aload_0
    //   751: getfield 124	org/bouncycastle/cms/SignerInformation:resultDigest	[B
    //   754: aload_0
    //   755: invokevirtual 391	org/bouncycastle/cms/SignerInformation:getSignature	()[B
    //   758: invokeinterface 394 3 0
    //   763: ireturn
    //   764: aload 5
    //   766: aload_0
    //   767: invokevirtual 391	org/bouncycastle/cms/SignerInformation:getSignature	()[B
    //   770: invokeinterface 397 2 0
    //   775: istore_3
    //   776: iload_3
    //   777: ireturn
    //   778: astore_1
    //   779: new 199	org/bouncycastle/cms/CMSException
    //   782: dup
    //   783: ldc_w 399
    //   786: aload_1
    //   787: invokespecial 402	org/bouncycastle/cms/CMSException:<init>	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   790: athrow
    //   791: new 404	org/bouncycastle/cms/CMSSignerDigestMismatchException
    //   794: dup
    //   795: ldc_w 406
    //   798: invokespecial 407	org/bouncycastle/cms/CMSSignerDigestMismatchException:<init>	(Ljava/lang/String;)V
    //   801: athrow
    //   802: new 199	org/bouncycastle/cms/CMSException
    //   805: dup
    //   806: ldc_w 409
    //   809: invokespecial 270	org/bouncycastle/cms/CMSException:<init>	(Ljava/lang/String;)V
    //   812: athrow
    //   813: new 199	org/bouncycastle/cms/CMSException
    //   816: dup
    //   817: ldc_w 411
    //   820: invokespecial 270	org/bouncycastle/cms/CMSException:<init>	(Ljava/lang/String;)V
    //   823: athrow
    //   824: new 199	org/bouncycastle/cms/CMSException
    //   827: dup
    //   828: ldc_w 413
    //   831: invokespecial 270	org/bouncycastle/cms/CMSException:<init>	(Ljava/lang/String;)V
    //   834: athrow
    //   835: new 199	org/bouncycastle/cms/CMSException
    //   838: dup
    //   839: ldc_w 415
    //   842: invokespecial 270	org/bouncycastle/cms/CMSException:<init>	(Ljava/lang/String;)V
    //   845: athrow
    //   846: astore_1
    //   847: new 417	java/lang/StringBuilder
    //   850: dup
    //   851: invokespecial 418	java/lang/StringBuilder:<init>	()V
    //   854: astore 4
    //   856: aload 4
    //   858: ldc_w 420
    //   861: invokevirtual 424	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   864: pop
    //   865: aload 4
    //   867: aload_1
    //   868: invokevirtual 427	org/bouncycastle/operator/OperatorCreationException:getMessage	()Ljava/lang/String;
    //   871: invokevirtual 424	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   874: pop
    //   875: new 199	org/bouncycastle/cms/CMSException
    //   878: dup
    //   879: aload 4
    //   881: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   884: aload_1
    //   885: invokespecial 402	org/bouncycastle/cms/CMSException:<init>	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   888: athrow
    //   889: astore_1
    //   890: new 199	org/bouncycastle/cms/CMSException
    //   893: dup
    //   894: ldc_w 399
    //   897: aload_1
    //   898: invokespecial 402	org/bouncycastle/cms/CMSException:<init>	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   901: athrow
    //   902: astore_1
    //   903: new 417	java/lang/StringBuilder
    //   906: dup
    //   907: invokespecial 418	java/lang/StringBuilder:<init>	()V
    //   910: astore 4
    //   912: aload 4
    //   914: ldc_w 432
    //   917: invokevirtual 424	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   920: pop
    //   921: aload 4
    //   923: aload_1
    //   924: invokevirtual 427	org/bouncycastle/operator/OperatorCreationException:getMessage	()Ljava/lang/String;
    //   927: invokevirtual 424	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   930: pop
    //   931: new 199	org/bouncycastle/cms/CMSException
    //   934: dup
    //   935: aload 4
    //   937: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   940: aload_1
    //   941: invokespecial 402	org/bouncycastle/cms/CMSException:<init>	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   944: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	945	0	this	SignerInformation
    //   0	945	1	paramSignerInformationVerifier	SignerInformationVerifier
    //   356	295	2	i	int
    //   775	2	3	bool	boolean
    //   10	926	4	localObject1	Object
    //   27	738	5	localContentVerifier	org.bouncycastle.operator.ContentVerifier
    //   36	527	6	localObject2	Object
    //   67	84	7	localOutputStream	java.io.OutputStream
    //   109	14	8	localTeeOutputStream	org.bouncycastle.util.io.TeeOutputStream
    // Exception table:
    //   from	to	target	type
    //   665	749	778	java/io/IOException
    //   749	764	778	java/io/IOException
    //   764	776	778	java/io/IOException
    //   29	95	846	org/bouncycastle/operator/OperatorCreationException
    //   98	127	846	org/bouncycastle/operator/OperatorCreationException
    //   130	150	846	org/bouncycastle/operator/OperatorCreationException
    //   150	155	846	org/bouncycastle/operator/OperatorCreationException
    //   158	174	846	org/bouncycastle/operator/OperatorCreationException
    //   174	184	846	org/bouncycastle/operator/OperatorCreationException
    //   187	198	846	org/bouncycastle/operator/OperatorCreationException
    //   198	223	846	org/bouncycastle/operator/OperatorCreationException
    //   226	235	846	org/bouncycastle/operator/OperatorCreationException
    //   235	240	846	org/bouncycastle/operator/OperatorCreationException
    //   29	95	889	java/io/IOException
    //   98	127	889	java/io/IOException
    //   130	150	889	java/io/IOException
    //   150	155	889	java/io/IOException
    //   158	174	889	java/io/IOException
    //   174	184	889	java/io/IOException
    //   187	198	889	java/io/IOException
    //   198	223	889	java/io/IOException
    //   226	235	889	java/io/IOException
    //   235	240	889	java/io/IOException
    //   12	29	902	org/bouncycastle/operator/OperatorCreationException
  }
  
  private byte[] encodeObj(ASN1Encodable paramASN1Encodable)
    throws IOException
  {
    if (paramASN1Encodable != null) {
      return paramASN1Encodable.toASN1Primitive().getEncoded();
    }
    return null;
  }
  
  private Time getSigningTime()
    throws CMSException
  {
    Object localObject = getSingleValuedSignedAttribute(CMSAttributes.signingTime, "signing-time");
    if (localObject == null) {
      return null;
    }
    try
    {
      localObject = Time.getInstance(localObject);
      return (Time)localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
    throw new CMSException("signing-time attribute value not a valid 'Time' structure");
  }
  
  private ASN1Primitive getSingleValuedSignedAttribute(ASN1ObjectIdentifier paramASN1ObjectIdentifier, String paramString)
    throws CMSException
  {
    AttributeTable localAttributeTable = getUnsignedAttributes();
    if ((localAttributeTable != null) && (localAttributeTable.getAll(paramASN1ObjectIdentifier).size() > 0))
    {
      paramASN1ObjectIdentifier = new StringBuilder();
      paramASN1ObjectIdentifier.append("The ");
      paramASN1ObjectIdentifier.append(paramString);
      paramASN1ObjectIdentifier.append(" attribute MUST NOT be an unsigned attribute");
      throw new CMSException(paramASN1ObjectIdentifier.toString());
    }
    localAttributeTable = getSignedAttributes();
    if (localAttributeTable == null) {
      return null;
    }
    paramASN1ObjectIdentifier = localAttributeTable.getAll(paramASN1ObjectIdentifier);
    int i = paramASN1ObjectIdentifier.size();
    if (i != 0)
    {
      if (i == 1)
      {
        paramASN1ObjectIdentifier = ((Attribute)paramASN1ObjectIdentifier.get(0)).getAttrValues();
        if (paramASN1ObjectIdentifier.size() == 1) {
          return paramASN1ObjectIdentifier.getObjectAt(0).toASN1Primitive();
        }
        paramASN1ObjectIdentifier = new StringBuilder();
        paramASN1ObjectIdentifier.append("A ");
        paramASN1ObjectIdentifier.append(paramString);
        paramASN1ObjectIdentifier.append(" attribute MUST have a single attribute value");
        throw new CMSException(paramASN1ObjectIdentifier.toString());
      }
      paramASN1ObjectIdentifier = new StringBuilder();
      paramASN1ObjectIdentifier.append("The SignedAttributes in a signerInfo MUST NOT include multiple instances of the ");
      paramASN1ObjectIdentifier.append(paramString);
      paramASN1ObjectIdentifier.append(" attribute");
      throw new CMSException(paramASN1ObjectIdentifier.toString());
    }
    return null;
  }
  
  public static SignerInformation replaceUnsignedAttributes(SignerInformation paramSignerInformation, AttributeTable paramAttributeTable)
  {
    SignerInfo localSignerInfo = paramSignerInformation.info;
    if (paramAttributeTable != null) {
      paramAttributeTable = new DERSet(paramAttributeTable.toASN1EncodableVector());
    } else {
      paramAttributeTable = null;
    }
    return new SignerInformation(new SignerInfo(localSignerInfo.getSID(), localSignerInfo.getDigestAlgorithm(), localSignerInfo.getAuthenticatedAttributes(), localSignerInfo.getDigestEncryptionAlgorithm(), localSignerInfo.getEncryptedDigest(), paramAttributeTable), paramSignerInformation.contentType, paramSignerInformation.content, null);
  }
  
  public byte[] getContentDigest()
  {
    byte[] arrayOfByte = this.resultDigest;
    if (arrayOfByte != null) {
      return Arrays.clone(arrayOfByte);
    }
    throw new IllegalStateException("method can only be called after verify.");
  }
  
  public ASN1ObjectIdentifier getContentType()
  {
    return this.contentType;
  }
  
  public SignerInformationStore getCounterSignatures()
  {
    Object localObject1 = getUnsignedAttributes();
    int i = 0;
    if (localObject1 == null) {
      return new SignerInformationStore(new ArrayList(0));
    }
    ArrayList localArrayList = new ArrayList();
    localObject1 = ((AttributeTable)localObject1).getAll(CMSAttributes.counterSignature);
    while (i < ((ASN1EncodableVector)localObject1).size())
    {
      Object localObject2 = ((Attribute)((ASN1EncodableVector)localObject1).get(i)).getAttrValues();
      ((ASN1Set)localObject2).size();
      localObject2 = ((ASN1Set)localObject2).getObjects();
      while (((Enumeration)localObject2).hasMoreElements()) {
        localArrayList.add(new SignerInformation(SignerInfo.getInstance(((Enumeration)localObject2).nextElement()), null, new CMSProcessableByteArray(getSignature()), null));
      }
      i += 1;
    }
    return new SignerInformationStore(localArrayList);
  }
  
  public String getDigestAlgOID()
  {
    return this.digestAlgorithm.getAlgorithm().getId();
  }
  
  public byte[] getDigestAlgParams()
  {
    try
    {
      byte[] arrayOfByte = encodeObj(this.digestAlgorithm.getParameters());
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("exception getting digest parameters ");
      localStringBuilder.append(localException);
      throw new RuntimeException(localStringBuilder.toString());
    }
  }
  
  public AlgorithmIdentifier getDigestAlgorithmID()
  {
    return this.digestAlgorithm;
  }
  
  public byte[] getEncodedSignedAttributes()
    throws IOException
  {
    ASN1Set localASN1Set = this.signedAttributeSet;
    if (localASN1Set != null) {
      return localASN1Set.getEncoded("DER");
    }
    return null;
  }
  
  public String getEncryptionAlgOID()
  {
    return this.encryptionAlgorithm.getAlgorithm().getId();
  }
  
  public byte[] getEncryptionAlgParams()
  {
    try
    {
      byte[] arrayOfByte = encodeObj(this.encryptionAlgorithm.getParameters());
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("exception getting encryption parameters ");
      localStringBuilder.append(localException);
      throw new RuntimeException(localStringBuilder.toString());
    }
  }
  
  public SignerId getSID()
  {
    return this.sid;
  }
  
  public byte[] getSignature()
  {
    return Arrays.clone(this.signature);
  }
  
  public AttributeTable getSignedAttributes()
  {
    ASN1Set localASN1Set = this.signedAttributeSet;
    if ((localASN1Set != null) && (this.signedAttributeValues == null)) {
      this.signedAttributeValues = new AttributeTable(localASN1Set);
    }
    return this.signedAttributeValues;
  }
  
  public AttributeTable getUnsignedAttributes()
  {
    ASN1Set localASN1Set = this.unsignedAttributeSet;
    if ((localASN1Set != null) && (this.unsignedAttributeValues == null)) {
      this.unsignedAttributeValues = new AttributeTable(localASN1Set);
    }
    return this.unsignedAttributeValues;
  }
  
  public int getVersion()
  {
    return this.info.getVersion().getValue().intValue();
  }
  
  public boolean isCounterSignature()
  {
    return this.isCounterSignature;
  }
  
  public SignerInfo toASN1Structure()
  {
    return this.info;
  }
  
  public boolean verify(SignerInformationVerifier paramSignerInformationVerifier)
    throws CMSException
  {
    Time localTime = getSigningTime();
    if ((paramSignerInformationVerifier.hasAssociatedCertificate()) && (localTime != null) && (!paramSignerInformationVerifier.getAssociatedCertificate().isValidOn(localTime.getDate()))) {
      throw new CMSVerifierCertificateNotValidException("verifier not valid at signingTime");
    }
    return doVerify(paramSignerInformationVerifier);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\SignerInformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */