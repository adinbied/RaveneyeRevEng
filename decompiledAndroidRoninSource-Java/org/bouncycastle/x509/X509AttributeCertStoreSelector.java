package org.bouncycastle.x509;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.util.Selector;

public class X509AttributeCertStoreSelector
  implements Selector
{
  private X509AttributeCertificate attributeCert;
  private Date attributeCertificateValid;
  private AttributeCertificateHolder holder;
  private AttributeCertificateIssuer issuer;
  private BigInteger serialNumber;
  private Collection targetGroups = new HashSet();
  private Collection targetNames = new HashSet();
  
  private Set extractGeneralNames(Collection paramCollection)
    throws IOException
  {
    if ((paramCollection != null) && (!paramCollection.isEmpty()))
    {
      HashSet localHashSet = new HashSet();
      Iterator localIterator = paramCollection.iterator();
      while (localIterator.hasNext())
      {
        paramCollection = localIterator.next();
        if (!(paramCollection instanceof GeneralName)) {
          paramCollection = GeneralName.getInstance(ASN1Primitive.fromByteArray((byte[])paramCollection));
        }
        localHashSet.add(paramCollection);
      }
      return localHashSet;
    }
    return new HashSet();
  }
  
  public void addTargetGroup(GeneralName paramGeneralName)
  {
    this.targetGroups.add(paramGeneralName);
  }
  
  public void addTargetGroup(byte[] paramArrayOfByte)
    throws IOException
  {
    addTargetGroup(GeneralName.getInstance(ASN1Primitive.fromByteArray(paramArrayOfByte)));
  }
  
  public void addTargetName(GeneralName paramGeneralName)
  {
    this.targetNames.add(paramGeneralName);
  }
  
  public void addTargetName(byte[] paramArrayOfByte)
    throws IOException
  {
    addTargetName(GeneralName.getInstance(ASN1Primitive.fromByteArray(paramArrayOfByte)));
  }
  
  public Object clone()
  {
    X509AttributeCertStoreSelector localX509AttributeCertStoreSelector = new X509AttributeCertStoreSelector();
    localX509AttributeCertStoreSelector.attributeCert = this.attributeCert;
    localX509AttributeCertStoreSelector.attributeCertificateValid = getAttributeCertificateValid();
    localX509AttributeCertStoreSelector.holder = this.holder;
    localX509AttributeCertStoreSelector.issuer = this.issuer;
    localX509AttributeCertStoreSelector.serialNumber = this.serialNumber;
    localX509AttributeCertStoreSelector.targetGroups = getTargetGroups();
    localX509AttributeCertStoreSelector.targetNames = getTargetNames();
    return localX509AttributeCertStoreSelector;
  }
  
  public X509AttributeCertificate getAttributeCert()
  {
    return this.attributeCert;
  }
  
  public Date getAttributeCertificateValid()
  {
    if (this.attributeCertificateValid != null) {
      return new Date(this.attributeCertificateValid.getTime());
    }
    return null;
  }
  
  public AttributeCertificateHolder getHolder()
  {
    return this.holder;
  }
  
  public AttributeCertificateIssuer getIssuer()
  {
    return this.issuer;
  }
  
  public BigInteger getSerialNumber()
  {
    return this.serialNumber;
  }
  
  public Collection getTargetGroups()
  {
    return Collections.unmodifiableCollection(this.targetGroups);
  }
  
  public Collection getTargetNames()
  {
    return Collections.unmodifiableCollection(this.targetNames);
  }
  
  /* Error */
  public boolean match(Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: instanceof 139
    //   4: ifne +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload_1
    //   10: checkcast 139	org/bouncycastle/x509/X509AttributeCertificate
    //   13: astore_1
    //   14: aload_0
    //   15: getfield 88	org/bouncycastle/x509/X509AttributeCertStoreSelector:attributeCert	Lorg/bouncycastle/x509/X509AttributeCertificate;
    //   18: astore 6
    //   20: aload 6
    //   22: ifnull +14 -> 36
    //   25: aload 6
    //   27: aload_1
    //   28: invokevirtual 142	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   31: ifne +5 -> 36
    //   34: iconst_0
    //   35: ireturn
    //   36: aload_0
    //   37: getfield 100	org/bouncycastle/x509/X509AttributeCertStoreSelector:serialNumber	Ljava/math/BigInteger;
    //   40: ifnull +21 -> 61
    //   43: aload_1
    //   44: invokeinterface 144 1 0
    //   49: aload_0
    //   50: getfield 100	org/bouncycastle/x509/X509AttributeCertStoreSelector:serialNumber	Ljava/math/BigInteger;
    //   53: invokevirtual 147	java/math/BigInteger:equals	(Ljava/lang/Object;)Z
    //   56: ifne +5 -> 61
    //   59: iconst_0
    //   60: ireturn
    //   61: aload_0
    //   62: getfield 96	org/bouncycastle/x509/X509AttributeCertStoreSelector:holder	Lorg/bouncycastle/x509/AttributeCertificateHolder;
    //   65: ifnull +21 -> 86
    //   68: aload_1
    //   69: invokeinterface 149 1 0
    //   74: aload_0
    //   75: getfield 96	org/bouncycastle/x509/X509AttributeCertStoreSelector:holder	Lorg/bouncycastle/x509/AttributeCertificateHolder;
    //   78: invokevirtual 152	org/bouncycastle/x509/AttributeCertificateHolder:equals	(Ljava/lang/Object;)Z
    //   81: ifne +5 -> 86
    //   84: iconst_0
    //   85: ireturn
    //   86: aload_0
    //   87: getfield 98	org/bouncycastle/x509/X509AttributeCertStoreSelector:issuer	Lorg/bouncycastle/x509/AttributeCertificateIssuer;
    //   90: ifnull +21 -> 111
    //   93: aload_1
    //   94: invokeinterface 154 1 0
    //   99: aload_0
    //   100: getfield 98	org/bouncycastle/x509/X509AttributeCertStoreSelector:issuer	Lorg/bouncycastle/x509/AttributeCertificateIssuer;
    //   103: invokevirtual 157	org/bouncycastle/x509/AttributeCertificateIssuer:equals	(Ljava/lang/Object;)Z
    //   106: ifne +5 -> 111
    //   109: iconst_0
    //   110: ireturn
    //   111: aload_0
    //   112: getfield 94	org/bouncycastle/x509/X509AttributeCertStoreSelector:attributeCertificateValid	Ljava/util/Date;
    //   115: astore 6
    //   117: aload 6
    //   119: ifnull +14 -> 133
    //   122: aload_1
    //   123: aload 6
    //   125: invokeinterface 161 2 0
    //   130: goto +3 -> 133
    //   133: aload_0
    //   134: getfield 28	org/bouncycastle/x509/X509AttributeCertStoreSelector:targetNames	Ljava/util/Collection;
    //   137: invokeinterface 41 1 0
    //   142: ifeq +15 -> 157
    //   145: aload_0
    //   146: getfield 30	org/bouncycastle/x509/X509AttributeCertStoreSelector:targetGroups	Ljava/util/Collection;
    //   149: invokeinterface 41 1 0
    //   154: ifne +245 -> 399
    //   157: aload_1
    //   158: getstatic 167	org/bouncycastle/asn1/x509/X509Extensions:TargetInformation	Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;
    //   161: invokevirtual 173	org/bouncycastle/asn1/ASN1ObjectIdentifier:getId	()Ljava/lang/String;
    //   164: invokeinterface 177 2 0
    //   169: astore_1
    //   170: aload_1
    //   171: ifnull +228 -> 399
    //   174: new 179	org/bouncycastle/asn1/ASN1InputStream
    //   177: dup
    //   178: aload_1
    //   179: invokestatic 182	org/bouncycastle/asn1/DEROctetString:fromByteArray	([B)Lorg/bouncycastle/asn1/ASN1Primitive;
    //   182: checkcast 181	org/bouncycastle/asn1/DEROctetString
    //   185: invokevirtual 186	org/bouncycastle/asn1/DEROctetString:getOctets	()[B
    //   188: invokespecial 188	org/bouncycastle/asn1/ASN1InputStream:<init>	([B)V
    //   191: invokevirtual 192	org/bouncycastle/asn1/ASN1InputStream:readObject	()Lorg/bouncycastle/asn1/ASN1Primitive;
    //   194: invokestatic 197	org/bouncycastle/asn1/x509/TargetInformation:getInstance	(Ljava/lang/Object;)Lorg/bouncycastle/asn1/x509/TargetInformation;
    //   197: astore_1
    //   198: aload_1
    //   199: invokevirtual 201	org/bouncycastle/asn1/x509/TargetInformation:getTargetsObjects	()[Lorg/bouncycastle/asn1/x509/Targets;
    //   202: astore_1
    //   203: aload_0
    //   204: getfield 28	org/bouncycastle/x509/X509AttributeCertStoreSelector:targetNames	Ljava/util/Collection;
    //   207: invokeinterface 41 1 0
    //   212: ifne +89 -> 301
    //   215: iconst_0
    //   216: istore_2
    //   217: iconst_0
    //   218: istore_3
    //   219: iload_2
    //   220: aload_1
    //   221: arraylength
    //   222: if_icmpge +73 -> 295
    //   225: aload_1
    //   226: iload_2
    //   227: aaload
    //   228: invokevirtual 207	org/bouncycastle/asn1/x509/Targets:getTargets	()[Lorg/bouncycastle/asn1/x509/Target;
    //   231: astore 6
    //   233: iconst_0
    //   234: istore 5
    //   236: iload_3
    //   237: istore 4
    //   239: iload 5
    //   241: aload 6
    //   243: arraylength
    //   244: if_icmpge +41 -> 285
    //   247: aload_0
    //   248: getfield 28	org/bouncycastle/x509/X509AttributeCertStoreSelector:targetNames	Ljava/util/Collection;
    //   251: aload 6
    //   253: iload 5
    //   255: aaload
    //   256: invokevirtual 213	org/bouncycastle/asn1/x509/Target:getTargetName	()Lorg/bouncycastle/asn1/x509/GeneralName;
    //   259: invokestatic 68	org/bouncycastle/asn1/x509/GeneralName:getInstance	(Ljava/lang/Object;)Lorg/bouncycastle/asn1/x509/GeneralName;
    //   262: invokeinterface 216 2 0
    //   267: ifeq +9 -> 276
    //   270: iconst_1
    //   271: istore 4
    //   273: goto +12 -> 285
    //   276: iload 5
    //   278: iconst_1
    //   279: iadd
    //   280: istore 5
    //   282: goto -46 -> 236
    //   285: iload_2
    //   286: iconst_1
    //   287: iadd
    //   288: istore_2
    //   289: iload 4
    //   291: istore_3
    //   292: goto -73 -> 219
    //   295: iload_3
    //   296: ifne +5 -> 301
    //   299: iconst_0
    //   300: ireturn
    //   301: aload_0
    //   302: getfield 30	org/bouncycastle/x509/X509AttributeCertStoreSelector:targetGroups	Ljava/util/Collection;
    //   305: invokeinterface 41 1 0
    //   310: ifne +89 -> 399
    //   313: iconst_0
    //   314: istore_2
    //   315: iconst_0
    //   316: istore_3
    //   317: iload_2
    //   318: aload_1
    //   319: arraylength
    //   320: if_icmpge +73 -> 393
    //   323: aload_1
    //   324: iload_2
    //   325: aaload
    //   326: invokevirtual 207	org/bouncycastle/asn1/x509/Targets:getTargets	()[Lorg/bouncycastle/asn1/x509/Target;
    //   329: astore 6
    //   331: iconst_0
    //   332: istore 5
    //   334: iload_3
    //   335: istore 4
    //   337: iload 5
    //   339: aload 6
    //   341: arraylength
    //   342: if_icmpge +41 -> 383
    //   345: aload_0
    //   346: getfield 30	org/bouncycastle/x509/X509AttributeCertStoreSelector:targetGroups	Ljava/util/Collection;
    //   349: aload 6
    //   351: iload 5
    //   353: aaload
    //   354: invokevirtual 219	org/bouncycastle/asn1/x509/Target:getTargetGroup	()Lorg/bouncycastle/asn1/x509/GeneralName;
    //   357: invokestatic 68	org/bouncycastle/asn1/x509/GeneralName:getInstance	(Ljava/lang/Object;)Lorg/bouncycastle/asn1/x509/GeneralName;
    //   360: invokeinterface 216 2 0
    //   365: ifeq +9 -> 374
    //   368: iconst_1
    //   369: istore 4
    //   371: goto +12 -> 383
    //   374: iload 5
    //   376: iconst_1
    //   377: iadd
    //   378: istore 5
    //   380: goto -46 -> 334
    //   383: iload_2
    //   384: iconst_1
    //   385: iadd
    //   386: istore_2
    //   387: iload 4
    //   389: istore_3
    //   390: goto -73 -> 317
    //   393: iload_3
    //   394: ifne +5 -> 399
    //   397: iconst_0
    //   398: ireturn
    //   399: iconst_1
    //   400: ireturn
    //   401: astore_1
    //   402: iconst_0
    //   403: ireturn
    //   404: astore_1
    //   405: iconst_0
    //   406: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	407	0	this	X509AttributeCertStoreSelector
    //   0	407	1	paramObject	Object
    //   216	171	2	i	int
    //   218	176	3	j	int
    //   237	151	4	k	int
    //   234	145	5	m	int
    //   18	332	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   122	130	401	java/security/cert/CertificateExpiredException
    //   122	130	401	java/security/cert/CertificateNotYetValidException
    //   174	198	404	java/io/IOException
    //   174	198	404	java/lang/IllegalArgumentException
  }
  
  public void setAttributeCert(X509AttributeCertificate paramX509AttributeCertificate)
  {
    this.attributeCert = paramX509AttributeCertificate;
  }
  
  public void setAttributeCertificateValid(Date paramDate)
  {
    if (paramDate != null)
    {
      this.attributeCertificateValid = new Date(paramDate.getTime());
      return;
    }
    this.attributeCertificateValid = null;
  }
  
  public void setHolder(AttributeCertificateHolder paramAttributeCertificateHolder)
  {
    this.holder = paramAttributeCertificateHolder;
  }
  
  public void setIssuer(AttributeCertificateIssuer paramAttributeCertificateIssuer)
  {
    this.issuer = paramAttributeCertificateIssuer;
  }
  
  public void setSerialNumber(BigInteger paramBigInteger)
  {
    this.serialNumber = paramBigInteger;
  }
  
  public void setTargetGroups(Collection paramCollection)
    throws IOException
  {
    this.targetGroups = extractGeneralNames(paramCollection);
  }
  
  public void setTargetNames(Collection paramCollection)
    throws IOException
  {
    this.targetNames = extractGeneralNames(paramCollection);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\x509\X509AttributeCertStoreSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */