package org.bouncycastle.asn1.dvcs;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.cmp.PKIStatusInfo;
import org.bouncycastle.asn1.x509.DigestInfo;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.PolicyInformation;

public class DVCSCertInfo
  extends ASN1Object
{
  private static final int DEFAULT_VERSION = 1;
  private static final int TAG_CERTS = 3;
  private static final int TAG_DV_STATUS = 0;
  private static final int TAG_POLICY = 1;
  private static final int TAG_REQ_SIGNATURE = 2;
  private ASN1Sequence certs;
  private DVCSRequestInformation dvReqInfo;
  private PKIStatusInfo dvStatus;
  private Extensions extensions;
  private DigestInfo messageImprint;
  private PolicyInformation policy;
  private ASN1Set reqSignature;
  private DVCSTime responseTime;
  private ASN1Integer serialNumber;
  private int version = 1;
  
  /* Error */
  private DVCSCertInfo(ASN1Sequence paramASN1Sequence)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 40	org/bouncycastle/asn1/ASN1Object:<init>	()V
    //   4: aload_0
    //   5: iconst_1
    //   6: putfield 42	org/bouncycastle/asn1/dvcs/DVCSCertInfo:version	I
    //   9: aload_1
    //   10: iconst_0
    //   11: invokevirtual 48	org/bouncycastle/asn1/ASN1Sequence:getObjectAt	(I)Lorg/bouncycastle/asn1/ASN1Encodable;
    //   14: astore 5
    //   16: aload_0
    //   17: aload 5
    //   19: invokestatic 54	org/bouncycastle/asn1/ASN1Integer:getInstance	(Ljava/lang/Object;)Lorg/bouncycastle/asn1/ASN1Integer;
    //   22: invokevirtual 58	org/bouncycastle/asn1/ASN1Integer:getValue	()Ljava/math/BigInteger;
    //   25: invokevirtual 64	java/math/BigInteger:intValue	()I
    //   28: putfield 42	org/bouncycastle/asn1/dvcs/DVCSCertInfo:version	I
    //   31: aload_1
    //   32: iconst_1
    //   33: invokevirtual 48	org/bouncycastle/asn1/ASN1Sequence:getObjectAt	(I)Lorg/bouncycastle/asn1/ASN1Encodable;
    //   36: astore 6
    //   38: aload 6
    //   40: astore 5
    //   42: iconst_2
    //   43: istore_2
    //   44: goto +5 -> 49
    //   47: iconst_1
    //   48: istore_2
    //   49: aload_0
    //   50: aload 5
    //   52: invokestatic 69	org/bouncycastle/asn1/dvcs/DVCSRequestInformation:getInstance	(Ljava/lang/Object;)Lorg/bouncycastle/asn1/dvcs/DVCSRequestInformation;
    //   55: putfield 71	org/bouncycastle/asn1/dvcs/DVCSCertInfo:dvReqInfo	Lorg/bouncycastle/asn1/dvcs/DVCSRequestInformation;
    //   58: iload_2
    //   59: iconst_1
    //   60: iadd
    //   61: istore_3
    //   62: aload_0
    //   63: aload_1
    //   64: iload_2
    //   65: invokevirtual 48	org/bouncycastle/asn1/ASN1Sequence:getObjectAt	(I)Lorg/bouncycastle/asn1/ASN1Encodable;
    //   68: invokestatic 76	org/bouncycastle/asn1/x509/DigestInfo:getInstance	(Ljava/lang/Object;)Lorg/bouncycastle/asn1/x509/DigestInfo;
    //   71: putfield 78	org/bouncycastle/asn1/dvcs/DVCSCertInfo:messageImprint	Lorg/bouncycastle/asn1/x509/DigestInfo;
    //   74: iload_3
    //   75: iconst_1
    //   76: iadd
    //   77: istore 4
    //   79: aload_0
    //   80: aload_1
    //   81: iload_3
    //   82: invokevirtual 48	org/bouncycastle/asn1/ASN1Sequence:getObjectAt	(I)Lorg/bouncycastle/asn1/ASN1Encodable;
    //   85: invokestatic 54	org/bouncycastle/asn1/ASN1Integer:getInstance	(Ljava/lang/Object;)Lorg/bouncycastle/asn1/ASN1Integer;
    //   88: putfield 80	org/bouncycastle/asn1/dvcs/DVCSCertInfo:serialNumber	Lorg/bouncycastle/asn1/ASN1Integer;
    //   91: iload 4
    //   93: iconst_1
    //   94: iadd
    //   95: istore_2
    //   96: aload_0
    //   97: aload_1
    //   98: iload 4
    //   100: invokevirtual 48	org/bouncycastle/asn1/ASN1Sequence:getObjectAt	(I)Lorg/bouncycastle/asn1/ASN1Encodable;
    //   103: invokestatic 85	org/bouncycastle/asn1/dvcs/DVCSTime:getInstance	(Ljava/lang/Object;)Lorg/bouncycastle/asn1/dvcs/DVCSTime;
    //   106: putfield 87	org/bouncycastle/asn1/dvcs/DVCSCertInfo:responseTime	Lorg/bouncycastle/asn1/dvcs/DVCSTime;
    //   109: iload_2
    //   110: aload_1
    //   111: invokevirtual 90	org/bouncycastle/asn1/ASN1Sequence:size	()I
    //   114: if_icmpge +154 -> 268
    //   117: aload_1
    //   118: iload_2
    //   119: invokevirtual 48	org/bouncycastle/asn1/ASN1Sequence:getObjectAt	(I)Lorg/bouncycastle/asn1/ASN1Encodable;
    //   122: astore 5
    //   124: aload 5
    //   126: instanceof 92
    //   129: ifeq +123 -> 252
    //   132: aload 5
    //   134: invokestatic 95	org/bouncycastle/asn1/ASN1TaggedObject:getInstance	(Ljava/lang/Object;)Lorg/bouncycastle/asn1/ASN1TaggedObject;
    //   137: astore 5
    //   139: aload 5
    //   141: invokevirtual 98	org/bouncycastle/asn1/ASN1TaggedObject:getTagNo	()I
    //   144: istore_3
    //   145: iload_3
    //   146: ifeq +93 -> 239
    //   149: iload_3
    //   150: iconst_1
    //   151: if_icmpeq +72 -> 223
    //   154: iload_3
    //   155: iconst_2
    //   156: if_icmpeq +54 -> 210
    //   159: iload_3
    //   160: iconst_3
    //   161: if_icmpne +16 -> 177
    //   164: aload_0
    //   165: aload 5
    //   167: iconst_0
    //   168: invokestatic 101	org/bouncycastle/asn1/ASN1Sequence:getInstance	(Lorg/bouncycastle/asn1/ASN1TaggedObject;Z)Lorg/bouncycastle/asn1/ASN1Sequence;
    //   171: putfield 103	org/bouncycastle/asn1/dvcs/DVCSCertInfo:certs	Lorg/bouncycastle/asn1/ASN1Sequence;
    //   174: goto +87 -> 261
    //   177: new 105	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   184: astore_1
    //   185: aload_1
    //   186: ldc 108
    //   188: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload_1
    //   193: iload_3
    //   194: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: new 37	java/lang/IllegalArgumentException
    //   201: dup
    //   202: aload_1
    //   203: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokespecial 122	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   209: athrow
    //   210: aload_0
    //   211: aload 5
    //   213: iconst_0
    //   214: invokestatic 127	org/bouncycastle/asn1/ASN1Set:getInstance	(Lorg/bouncycastle/asn1/ASN1TaggedObject;Z)Lorg/bouncycastle/asn1/ASN1Set;
    //   217: putfield 129	org/bouncycastle/asn1/dvcs/DVCSCertInfo:reqSignature	Lorg/bouncycastle/asn1/ASN1Set;
    //   220: goto +41 -> 261
    //   223: aload_0
    //   224: aload 5
    //   226: iconst_0
    //   227: invokestatic 101	org/bouncycastle/asn1/ASN1Sequence:getInstance	(Lorg/bouncycastle/asn1/ASN1TaggedObject;Z)Lorg/bouncycastle/asn1/ASN1Sequence;
    //   230: invokestatic 134	org/bouncycastle/asn1/x509/PolicyInformation:getInstance	(Ljava/lang/Object;)Lorg/bouncycastle/asn1/x509/PolicyInformation;
    //   233: putfield 136	org/bouncycastle/asn1/dvcs/DVCSCertInfo:policy	Lorg/bouncycastle/asn1/x509/PolicyInformation;
    //   236: goto +25 -> 261
    //   239: aload_0
    //   240: aload 5
    //   242: iconst_0
    //   243: invokestatic 141	org/bouncycastle/asn1/cmp/PKIStatusInfo:getInstance	(Lorg/bouncycastle/asn1/ASN1TaggedObject;Z)Lorg/bouncycastle/asn1/cmp/PKIStatusInfo;
    //   246: putfield 143	org/bouncycastle/asn1/dvcs/DVCSCertInfo:dvStatus	Lorg/bouncycastle/asn1/cmp/PKIStatusInfo;
    //   249: goto +12 -> 261
    //   252: aload_0
    //   253: aload 5
    //   255: invokestatic 148	org/bouncycastle/asn1/x509/Extensions:getInstance	(Ljava/lang/Object;)Lorg/bouncycastle/asn1/x509/Extensions;
    //   258: putfield 150	org/bouncycastle/asn1/dvcs/DVCSCertInfo:extensions	Lorg/bouncycastle/asn1/x509/Extensions;
    //   261: iload_2
    //   262: iconst_1
    //   263: iadd
    //   264: istore_2
    //   265: goto -156 -> 109
    //   268: return
    //   269: astore 6
    //   271: goto -224 -> 47
    //   274: astore 6
    //   276: goto -234 -> 42
    //   279: astore 5
    //   281: goto -20 -> 261
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	284	0	this	DVCSCertInfo
    //   0	284	1	paramASN1Sequence	ASN1Sequence
    //   43	222	2	i	int
    //   61	133	3	j	int
    //   77	22	4	k	int
    //   14	240	5	localObject	Object
    //   279	1	5	localIllegalArgumentException1	IllegalArgumentException
    //   36	3	6	localASN1Encodable	ASN1Encodable
    //   269	1	6	localIllegalArgumentException2	IllegalArgumentException
    //   274	1	6	localIllegalArgumentException3	IllegalArgumentException
    // Exception table:
    //   from	to	target	type
    //   16	31	269	java/lang/IllegalArgumentException
    //   31	38	274	java/lang/IllegalArgumentException
    //   252	261	279	java/lang/IllegalArgumentException
  }
  
  public DVCSCertInfo(DVCSRequestInformation paramDVCSRequestInformation, DigestInfo paramDigestInfo, ASN1Integer paramASN1Integer, DVCSTime paramDVCSTime)
  {
    this.dvReqInfo = paramDVCSRequestInformation;
    this.messageImprint = paramDigestInfo;
    this.serialNumber = paramASN1Integer;
    this.responseTime = paramDVCSTime;
  }
  
  public static DVCSCertInfo getInstance(Object paramObject)
  {
    if ((paramObject instanceof DVCSCertInfo)) {
      return (DVCSCertInfo)paramObject;
    }
    if (paramObject != null) {
      return new DVCSCertInfo(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static DVCSCertInfo getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  private void setDvReqInfo(DVCSRequestInformation paramDVCSRequestInformation)
  {
    this.dvReqInfo = paramDVCSRequestInformation;
  }
  
  private void setMessageImprint(DigestInfo paramDigestInfo)
  {
    this.messageImprint = paramDigestInfo;
  }
  
  private void setVersion(int paramInt)
  {
    this.version = paramInt;
  }
  
  public TargetEtcChain[] getCerts()
  {
    ASN1Sequence localASN1Sequence = this.certs;
    if (localASN1Sequence != null) {
      return TargetEtcChain.arrayFromSequence(localASN1Sequence);
    }
    return null;
  }
  
  public DVCSRequestInformation getDvReqInfo()
  {
    return this.dvReqInfo;
  }
  
  public PKIStatusInfo getDvStatus()
  {
    return this.dvStatus;
  }
  
  public Extensions getExtensions()
  {
    return this.extensions;
  }
  
  public DigestInfo getMessageImprint()
  {
    return this.messageImprint;
  }
  
  public PolicyInformation getPolicy()
  {
    return this.policy;
  }
  
  public ASN1Set getReqSignature()
  {
    return this.reqSignature;
  }
  
  public DVCSTime getResponseTime()
  {
    return this.responseTime;
  }
  
  public ASN1Integer getSerialNumber()
  {
    return this.serialNumber;
  }
  
  public int getVersion()
  {
    return this.version;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    int i = this.version;
    if (i != 1) {
      localASN1EncodableVector.add(new ASN1Integer(i));
    }
    localASN1EncodableVector.add(this.dvReqInfo);
    localASN1EncodableVector.add(this.messageImprint);
    localASN1EncodableVector.add(this.serialNumber);
    localASN1EncodableVector.add(this.responseTime);
    Object localObject = this.dvStatus;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 0, (ASN1Encodable)localObject));
    }
    localObject = this.policy;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 1, (ASN1Encodable)localObject));
    }
    localObject = this.reqSignature;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 2, (ASN1Encodable)localObject));
    }
    localObject = this.certs;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 3, (ASN1Encodable)localObject));
    }
    localObject = this.extensions;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    return new DERSequence(localASN1EncodableVector);
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("DVCSCertInfo {\n");
    if (this.version != 1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("version: ");
      localStringBuilder.append(this.version);
      localStringBuilder.append("\n");
      localStringBuffer.append(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dvReqInfo: ");
    localStringBuilder.append(this.dvReqInfo);
    localStringBuilder.append("\n");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("messageImprint: ");
    localStringBuilder.append(this.messageImprint);
    localStringBuilder.append("\n");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("serialNumber: ");
    localStringBuilder.append(this.serialNumber);
    localStringBuilder.append("\n");
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("responseTime: ");
    localStringBuilder.append(this.responseTime);
    localStringBuilder.append("\n");
    localStringBuffer.append(localStringBuilder.toString());
    if (this.dvStatus != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("dvStatus: ");
      localStringBuilder.append(this.dvStatus);
      localStringBuilder.append("\n");
      localStringBuffer.append(localStringBuilder.toString());
    }
    if (this.policy != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("policy: ");
      localStringBuilder.append(this.policy);
      localStringBuilder.append("\n");
      localStringBuffer.append(localStringBuilder.toString());
    }
    if (this.reqSignature != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("reqSignature: ");
      localStringBuilder.append(this.reqSignature);
      localStringBuilder.append("\n");
      localStringBuffer.append(localStringBuilder.toString());
    }
    if (this.certs != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("certs: ");
      localStringBuilder.append(this.certs);
      localStringBuilder.append("\n");
      localStringBuffer.append(localStringBuilder.toString());
    }
    if (this.extensions != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("extensions: ");
      localStringBuilder.append(this.extensions);
      localStringBuilder.append("\n");
      localStringBuffer.append(localStringBuilder.toString());
    }
    localStringBuffer.append("}\n");
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\dvcs\DVCSCertInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */