package org.bouncycastle.x509;

import java.io.IOException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXParameters;
import java.security.cert.PolicyNode;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CRL;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.security.cert.X509Extension;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.x509.AccessDescription;
import org.bouncycastle.asn1.x509.AuthorityInformationAccess;
import org.bouncycastle.asn1.x509.AuthorityKeyIdentifier;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.asn1.x509.CRLDistPoint;
import org.bouncycastle.asn1.x509.DistributionPoint;
import org.bouncycastle.asn1.x509.DistributionPointName;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.PolicyInformation;
import org.bouncycastle.asn1.x509.X509Extensions;
import org.bouncycastle.asn1.x509.qualified.Iso4217CurrencyCode;
import org.bouncycastle.asn1.x509.qualified.MonetaryValue;
import org.bouncycastle.asn1.x509.qualified.QCStatement;
import org.bouncycastle.i18n.ErrorBundle;
import org.bouncycastle.i18n.filter.TrustedInput;
import org.bouncycastle.i18n.filter.UntrustedInput;
import org.bouncycastle.jce.provider.AnnotatedException;
import org.bouncycastle.jce.provider.PKIXPolicyNode;
import org.bouncycastle.util.Integers;

public class PKIXCertPathReviewer
  extends CertPathValidatorUtilities
{
  private static final String AUTH_INFO_ACCESS = X509Extensions.AuthorityInfoAccess.getId();
  private static final String CRL_DIST_POINTS;
  private static final String QC_STATEMENT = X509Extensions.QCStatements.getId();
  private static final String RESOURCE_NAME = "org.bouncycastle.x509.CertPathReviewerMessages";
  protected CertPath certPath;
  protected List certs;
  protected List[] errors;
  private boolean initialized;
  protected int n;
  protected List[] notifications;
  protected PKIXParameters pkixParams;
  protected PolicyNode policyTree;
  protected PublicKey subjectPublicKey;
  protected TrustAnchor trustAnchor;
  protected Date validDate;
  
  static
  {
    CRL_DIST_POINTS = X509Extensions.CRLDistributionPoints.getId();
  }
  
  public PKIXCertPathReviewer() {}
  
  public PKIXCertPathReviewer(CertPath paramCertPath, PKIXParameters paramPKIXParameters)
    throws CertPathReviewerException
  {
    init(paramCertPath, paramPKIXParameters);
  }
  
  private String IPtoString(byte[] paramArrayOfByte)
  {
    try
    {
      localObject = InetAddress.getByAddress(paramArrayOfByte).getHostAddress();
      return (String)localObject;
    }
    catch (Exception localException)
    {
      Object localObject;
      int i;
      for (;;) {}
    }
    localObject = new StringBuffer();
    i = 0;
    while (i != paramArrayOfByte.length)
    {
      ((StringBuffer)localObject).append(Integer.toHexString(paramArrayOfByte[i] & 0xFF));
      ((StringBuffer)localObject).append(' ');
      i += 1;
    }
    return ((StringBuffer)localObject).toString();
  }
  
  private void checkCriticalExtensions()
  {
    List localList = this.pkixParams.getCertPathCheckers();
    Object localObject = localList.iterator();
    try
    {
      while (((Iterator)localObject).hasNext()) {
        ((PKIXCertPathChecker)((Iterator)localObject).next()).init(false);
      }
      i = this.certs.size() - 1;
    }
    catch (CertPathValidatorException localCertPathValidatorException2)
    {
      for (;;)
      {
        int i;
        Set localSet;
        Iterator localIterator;
        throw new CertPathReviewerException(new ErrorBundle("org.bouncycastle.x509.CertPathReviewerMessages", "CertPathReviewer.certPathCheckerError", new Object[] { localCertPathValidatorException2.getMessage(), localCertPathValidatorException2, localCertPathValidatorException2.getClass().getName() }), localCertPathValidatorException2);
        addError(localCertPathValidatorException2.getErrorMessage(), localCertPathValidatorException2.getIndex());
        return;
        i -= 1;
      }
    }
    catch (CertPathReviewerException localCertPathReviewerException)
    {
      for (;;) {}
    }
    if (i >= 0)
    {
      localObject = (X509Certificate)this.certs.get(i);
      localSet = ((X509Certificate)localObject).getCriticalExtensionOIDs();
      if ((localSet == null) || (localSet.isEmpty())) {
        break label468;
      }
      localSet.remove(KEY_USAGE);
      localSet.remove(CERTIFICATE_POLICIES);
      localSet.remove(POLICY_MAPPINGS);
      localSet.remove(INHIBIT_ANY_POLICY);
      localSet.remove(ISSUING_DISTRIBUTION_POINT);
      localSet.remove(DELTA_CRL_INDICATOR);
      localSet.remove(POLICY_CONSTRAINTS);
      localSet.remove(BASIC_CONSTRAINTS);
      localSet.remove(SUBJECT_ALTERNATIVE_NAME);
      localSet.remove(NAME_CONSTRAINTS);
      if ((localSet.contains(QC_STATEMENT)) && (processQcStatements((X509Certificate)localObject, i))) {
        localSet.remove(QC_STATEMENT);
      }
      localIterator = localList.iterator();
      for (;;)
      {
        boolean bool = localIterator.hasNext();
        if (bool) {
          try
          {
            ((PKIXCertPathChecker)localIterator.next()).check((Certificate)localObject, localSet);
          }
          catch (CertPathValidatorException localCertPathValidatorException1)
          {
            throw new CertPathReviewerException(new ErrorBundle("org.bouncycastle.x509.CertPathReviewerMessages", "CertPathReviewer.criticalExtensionError", new Object[] { localCertPathValidatorException1.getMessage(), localCertPathValidatorException1, localCertPathValidatorException1.getClass().getName() }), localCertPathValidatorException1.getCause(), this.certPath, i);
          }
        }
      }
      if (localSet.isEmpty()) {
        break label468;
      }
      localObject = localSet.iterator();
      while (((Iterator)localObject).hasNext()) {
        addError(new ErrorBundle("org.bouncycastle.x509.CertPathReviewerMessages", "CertPathReviewer.unknownCriticalExt", new Object[] { new ASN1ObjectIdentifier((String)((Iterator)localObject).next()) }), i);
      }
    }
  }
  
  /* Error */
  private void checkNameConstraints()
  {
    // Byte code:
    //   0: new 262	org/bouncycastle/jce/provider/PKIXNameConstraintValidator
    //   3: dup
    //   4: invokespecial 263	org/bouncycastle/jce/provider/PKIXNameConstraintValidator:<init>	()V
    //   7: astore 5
    //   9: aload_0
    //   10: getfield 135	org/bouncycastle/x509/PKIXCertPathReviewer:certs	Ljava/util/List;
    //   13: invokeinterface 139 1 0
    //   18: iconst_1
    //   19: isub
    //   20: istore_1
    //   21: iload_1
    //   22: ifle +486 -> 508
    //   25: aload_0
    //   26: getfield 135	org/bouncycastle/x509/PKIXCertPathReviewer:certs	Ljava/util/List;
    //   29: iload_1
    //   30: invokeinterface 143 2 0
    //   35: checkcast 145	java/security/cert/X509Certificate
    //   38: astore 7
    //   40: aload 7
    //   42: invokestatic 267	org/bouncycastle/x509/PKIXCertPathReviewer:isSelfIssued	(Ljava/security/cert/X509Certificate;)Z
    //   45: istore 4
    //   47: iconst_0
    //   48: istore_3
    //   49: iload 4
    //   51: ifne +331 -> 382
    //   54: aload 7
    //   56: invokestatic 271	org/bouncycastle/x509/PKIXCertPathReviewer:getSubjectPrincipal	(Ljava/security/cert/X509Certificate;)Ljavax/security/auth/x500/X500Principal;
    //   59: astore 6
    //   61: new 273	org/bouncycastle/asn1/ASN1InputStream
    //   64: dup
    //   65: new 275	java/io/ByteArrayInputStream
    //   68: dup
    //   69: aload 6
    //   71: invokevirtual 281	javax/security/auth/x500/X500Principal:getEncoded	()[B
    //   74: invokespecial 284	java/io/ByteArrayInputStream:<init>	([B)V
    //   77: invokespecial 287	org/bouncycastle/asn1/ASN1InputStream:<init>	(Ljava/io/InputStream;)V
    //   80: astore 8
    //   82: aload 8
    //   84: invokevirtual 291	org/bouncycastle/asn1/ASN1InputStream:readObject	()Lorg/bouncycastle/asn1/ASN1Primitive;
    //   87: checkcast 293	org/bouncycastle/asn1/ASN1Sequence
    //   90: astore 8
    //   92: aload 5
    //   94: aload 8
    //   96: invokevirtual 297	org/bouncycastle/jce/provider/PKIXNameConstraintValidator:checkPermittedDN	(Lorg/bouncycastle/asn1/ASN1Sequence;)V
    //   99: aload 5
    //   101: aload 8
    //   103: invokevirtual 300	org/bouncycastle/jce/provider/PKIXNameConstraintValidator:checkExcludedDN	(Lorg/bouncycastle/asn1/ASN1Sequence;)V
    //   106: aload 7
    //   108: getstatic 185	org/bouncycastle/x509/PKIXCertPathReviewer:SUBJECT_ALTERNATIVE_NAME	Ljava/lang/String;
    //   111: invokestatic 304	org/bouncycastle/x509/PKIXCertPathReviewer:getExtensionValue	(Ljava/security/cert/X509Extension;Ljava/lang/String;)Lorg/bouncycastle/asn1/ASN1Primitive;
    //   114: checkcast 293	org/bouncycastle/asn1/ASN1Sequence
    //   117: astore 8
    //   119: aload 8
    //   121: ifnull +261 -> 382
    //   124: iconst_0
    //   125: istore_2
    //   126: iload_2
    //   127: aload 8
    //   129: invokevirtual 305	org/bouncycastle/asn1/ASN1Sequence:size	()I
    //   132: if_icmpge +250 -> 382
    //   135: aload 8
    //   137: iload_2
    //   138: invokevirtual 309	org/bouncycastle/asn1/ASN1Sequence:getObjectAt	(I)Lorg/bouncycastle/asn1/ASN1Encodable;
    //   141: invokestatic 315	org/bouncycastle/asn1/x509/GeneralName:getInstance	(Ljava/lang/Object;)Lorg/bouncycastle/asn1/x509/GeneralName;
    //   144: astore 6
    //   146: aload 5
    //   148: aload 6
    //   150: invokevirtual 319	org/bouncycastle/jce/provider/PKIXNameConstraintValidator:checkPermitted	(Lorg/bouncycastle/asn1/x509/GeneralName;)V
    //   153: aload 5
    //   155: aload 6
    //   157: invokevirtual 322	org/bouncycastle/jce/provider/PKIXNameConstraintValidator:checkExcluded	(Lorg/bouncycastle/asn1/x509/GeneralName;)V
    //   160: iload_2
    //   161: iconst_1
    //   162: iadd
    //   163: istore_2
    //   164: goto -38 -> 126
    //   167: astore 5
    //   169: new 65	org/bouncycastle/x509/CertPathReviewerException
    //   172: dup
    //   173: new 201	org/bouncycastle/i18n/ErrorBundle
    //   176: dup
    //   177: ldc 11
    //   179: ldc_w 324
    //   182: iconst_1
    //   183: anewarray 205	java/lang/Object
    //   186: dup
    //   187: iconst_0
    //   188: new 326	org/bouncycastle/i18n/filter/UntrustedInput
    //   191: dup
    //   192: aload 6
    //   194: invokespecial 329	org/bouncycastle/i18n/filter/UntrustedInput:<init>	(Ljava/lang/Object;)V
    //   197: aastore
    //   198: invokespecial 220	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   201: aload 5
    //   203: aload_0
    //   204: getfield 226	org/bouncycastle/x509/PKIXCertPathReviewer:certPath	Ljava/security/cert/CertPath;
    //   207: iload_1
    //   208: invokespecial 229	org/bouncycastle/x509/CertPathReviewerException:<init>	(Lorg/bouncycastle/i18n/ErrorBundle;Ljava/lang/Throwable;Ljava/security/cert/CertPath;I)V
    //   211: athrow
    //   212: astore 5
    //   214: new 65	org/bouncycastle/x509/CertPathReviewerException
    //   217: dup
    //   218: new 201	org/bouncycastle/i18n/ErrorBundle
    //   221: dup
    //   222: ldc 11
    //   224: ldc_w 331
    //   227: invokespecial 334	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   230: aload 5
    //   232: aload_0
    //   233: getfield 226	org/bouncycastle/x509/PKIXCertPathReviewer:certPath	Ljava/security/cert/CertPath;
    //   236: iload_1
    //   237: invokespecial 229	org/bouncycastle/x509/CertPathReviewerException:<init>	(Lorg/bouncycastle/i18n/ErrorBundle;Ljava/lang/Throwable;Ljava/security/cert/CertPath;I)V
    //   240: athrow
    //   241: astore 5
    //   243: new 65	org/bouncycastle/x509/CertPathReviewerException
    //   246: dup
    //   247: new 201	org/bouncycastle/i18n/ErrorBundle
    //   250: dup
    //   251: ldc 11
    //   253: ldc_w 336
    //   256: iconst_1
    //   257: anewarray 205	java/lang/Object
    //   260: dup
    //   261: iconst_0
    //   262: new 326	org/bouncycastle/i18n/filter/UntrustedInput
    //   265: dup
    //   266: aload 6
    //   268: invokevirtual 337	javax/security/auth/x500/X500Principal:getName	()Ljava/lang/String;
    //   271: invokespecial 329	org/bouncycastle/i18n/filter/UntrustedInput:<init>	(Ljava/lang/Object;)V
    //   274: aastore
    //   275: invokespecial 220	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   278: aload 5
    //   280: aload_0
    //   281: getfield 226	org/bouncycastle/x509/PKIXCertPathReviewer:certPath	Ljava/security/cert/CertPath;
    //   284: iload_1
    //   285: invokespecial 229	org/bouncycastle/x509/CertPathReviewerException:<init>	(Lorg/bouncycastle/i18n/ErrorBundle;Ljava/lang/Throwable;Ljava/security/cert/CertPath;I)V
    //   288: athrow
    //   289: astore 5
    //   291: new 65	org/bouncycastle/x509/CertPathReviewerException
    //   294: dup
    //   295: new 201	org/bouncycastle/i18n/ErrorBundle
    //   298: dup
    //   299: ldc 11
    //   301: ldc_w 339
    //   304: iconst_1
    //   305: anewarray 205	java/lang/Object
    //   308: dup
    //   309: iconst_0
    //   310: new 326	org/bouncycastle/i18n/filter/UntrustedInput
    //   313: dup
    //   314: aload 6
    //   316: invokevirtual 337	javax/security/auth/x500/X500Principal:getName	()Ljava/lang/String;
    //   319: invokespecial 329	org/bouncycastle/i18n/filter/UntrustedInput:<init>	(Ljava/lang/Object;)V
    //   322: aastore
    //   323: invokespecial 220	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   326: aload 5
    //   328: aload_0
    //   329: getfield 226	org/bouncycastle/x509/PKIXCertPathReviewer:certPath	Ljava/security/cert/CertPath;
    //   332: iload_1
    //   333: invokespecial 229	org/bouncycastle/x509/CertPathReviewerException:<init>	(Lorg/bouncycastle/i18n/ErrorBundle;Ljava/lang/Throwable;Ljava/security/cert/CertPath;I)V
    //   336: athrow
    //   337: astore 5
    //   339: new 65	org/bouncycastle/x509/CertPathReviewerException
    //   342: dup
    //   343: new 201	org/bouncycastle/i18n/ErrorBundle
    //   346: dup
    //   347: ldc 11
    //   349: ldc_w 341
    //   352: iconst_1
    //   353: anewarray 205	java/lang/Object
    //   356: dup
    //   357: iconst_0
    //   358: new 326	org/bouncycastle/i18n/filter/UntrustedInput
    //   361: dup
    //   362: aload 6
    //   364: invokespecial 329	org/bouncycastle/i18n/filter/UntrustedInput:<init>	(Ljava/lang/Object;)V
    //   367: aastore
    //   368: invokespecial 220	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   371: aload 5
    //   373: aload_0
    //   374: getfield 226	org/bouncycastle/x509/PKIXCertPathReviewer:certPath	Ljava/security/cert/CertPath;
    //   377: iload_1
    //   378: invokespecial 229	org/bouncycastle/x509/CertPathReviewerException:<init>	(Lorg/bouncycastle/i18n/ErrorBundle;Ljava/lang/Throwable;Ljava/security/cert/CertPath;I)V
    //   381: athrow
    //   382: aload 7
    //   384: getstatic 188	org/bouncycastle/x509/PKIXCertPathReviewer:NAME_CONSTRAINTS	Ljava/lang/String;
    //   387: invokestatic 304	org/bouncycastle/x509/PKIXCertPathReviewer:getExtensionValue	(Ljava/security/cert/X509Extension;Ljava/lang/String;)Lorg/bouncycastle/asn1/ASN1Primitive;
    //   390: checkcast 293	org/bouncycastle/asn1/ASN1Sequence
    //   393: astore 6
    //   395: aload 6
    //   397: ifnull +112 -> 509
    //   400: aload 6
    //   402: invokestatic 346	org/bouncycastle/asn1/x509/NameConstraints:getInstance	(Ljava/lang/Object;)Lorg/bouncycastle/asn1/x509/NameConstraints;
    //   405: astore 6
    //   407: aload 6
    //   409: invokevirtual 350	org/bouncycastle/asn1/x509/NameConstraints:getPermittedSubtrees	()[Lorg/bouncycastle/asn1/x509/GeneralSubtree;
    //   412: astore 7
    //   414: aload 7
    //   416: ifnull +10 -> 426
    //   419: aload 5
    //   421: aload 7
    //   423: invokevirtual 354	org/bouncycastle/jce/provider/PKIXNameConstraintValidator:intersectPermittedSubtree	([Lorg/bouncycastle/asn1/x509/GeneralSubtree;)V
    //   426: aload 6
    //   428: invokevirtual 357	org/bouncycastle/asn1/x509/NameConstraints:getExcludedSubtrees	()[Lorg/bouncycastle/asn1/x509/GeneralSubtree;
    //   431: astore 6
    //   433: aload 6
    //   435: ifnull +74 -> 509
    //   438: iload_3
    //   439: istore_2
    //   440: iload_2
    //   441: aload 6
    //   443: arraylength
    //   444: if_icmpeq +65 -> 509
    //   447: aload 5
    //   449: aload 6
    //   451: iload_2
    //   452: aaload
    //   453: invokevirtual 361	org/bouncycastle/jce/provider/PKIXNameConstraintValidator:addExcludedSubtree	(Lorg/bouncycastle/asn1/x509/GeneralSubtree;)V
    //   456: iload_2
    //   457: iconst_1
    //   458: iadd
    //   459: istore_2
    //   460: goto -20 -> 440
    //   463: astore 5
    //   465: new 65	org/bouncycastle/x509/CertPathReviewerException
    //   468: dup
    //   469: new 201	org/bouncycastle/i18n/ErrorBundle
    //   472: dup
    //   473: ldc 11
    //   475: ldc_w 363
    //   478: invokespecial 334	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   481: aload 5
    //   483: aload_0
    //   484: getfield 226	org/bouncycastle/x509/PKIXCertPathReviewer:certPath	Ljava/security/cert/CertPath;
    //   487: iload_1
    //   488: invokespecial 229	org/bouncycastle/x509/CertPathReviewerException:<init>	(Lorg/bouncycastle/i18n/ErrorBundle;Ljava/lang/Throwable;Ljava/security/cert/CertPath;I)V
    //   491: athrow
    //   492: astore 5
    //   494: aload_0
    //   495: aload 5
    //   497: invokevirtual 250	org/bouncycastle/x509/CertPathReviewerException:getErrorMessage	()Lorg/bouncycastle/i18n/ErrorBundle;
    //   500: aload 5
    //   502: invokevirtual 253	org/bouncycastle/x509/CertPathReviewerException:getIndex	()I
    //   505: invokevirtual 241	org/bouncycastle/x509/PKIXCertPathReviewer:addError	(Lorg/bouncycastle/i18n/ErrorBundle;I)V
    //   508: return
    //   509: iload_1
    //   510: iconst_1
    //   511: isub
    //   512: istore_1
    //   513: goto -492 -> 21
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	516	0	this	PKIXCertPathReviewer
    //   20	493	1	i	int
    //   125	335	2	j	int
    //   48	391	3	k	int
    //   45	5	4	bool	boolean
    //   7	147	5	localPKIXNameConstraintValidator	org.bouncycastle.jce.provider.PKIXNameConstraintValidator
    //   167	35	5	localPKIXNameConstraintValidatorException1	org.bouncycastle.jce.provider.PKIXNameConstraintValidatorException
    //   212	19	5	localAnnotatedException1	AnnotatedException
    //   241	38	5	localPKIXNameConstraintValidatorException2	org.bouncycastle.jce.provider.PKIXNameConstraintValidatorException
    //   289	38	5	localPKIXNameConstraintValidatorException3	org.bouncycastle.jce.provider.PKIXNameConstraintValidatorException
    //   337	111	5	localIOException	IOException
    //   463	19	5	localAnnotatedException2	AnnotatedException
    //   492	9	5	localCertPathReviewerException	CertPathReviewerException
    //   59	391	6	localObject1	Object
    //   38	384	7	localObject2	Object
    //   80	56	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   146	160	167	org/bouncycastle/jce/provider/PKIXNameConstraintValidatorException
    //   106	119	212	org/bouncycastle/jce/provider/AnnotatedException
    //   99	106	241	org/bouncycastle/jce/provider/PKIXNameConstraintValidatorException
    //   92	99	289	org/bouncycastle/jce/provider/PKIXNameConstraintValidatorException
    //   82	92	337	java/io/IOException
    //   382	395	463	org/bouncycastle/jce/provider/AnnotatedException
    //   9	21	492	org/bouncycastle/x509/CertPathReviewerException
    //   25	47	492	org/bouncycastle/x509/CertPathReviewerException
    //   54	82	492	org/bouncycastle/x509/CertPathReviewerException
    //   82	92	492	org/bouncycastle/x509/CertPathReviewerException
    //   92	99	492	org/bouncycastle/x509/CertPathReviewerException
    //   99	106	492	org/bouncycastle/x509/CertPathReviewerException
    //   106	119	492	org/bouncycastle/x509/CertPathReviewerException
    //   126	146	492	org/bouncycastle/x509/CertPathReviewerException
    //   146	160	492	org/bouncycastle/x509/CertPathReviewerException
    //   169	212	492	org/bouncycastle/x509/CertPathReviewerException
    //   214	241	492	org/bouncycastle/x509/CertPathReviewerException
    //   243	289	492	org/bouncycastle/x509/CertPathReviewerException
    //   291	337	492	org/bouncycastle/x509/CertPathReviewerException
    //   339	382	492	org/bouncycastle/x509/CertPathReviewerException
    //   382	395	492	org/bouncycastle/x509/CertPathReviewerException
    //   400	414	492	org/bouncycastle/x509/CertPathReviewerException
    //   419	426	492	org/bouncycastle/x509/CertPathReviewerException
    //   426	433	492	org/bouncycastle/x509/CertPathReviewerException
    //   440	456	492	org/bouncycastle/x509/CertPathReviewerException
    //   465	492	492	org/bouncycastle/x509/CertPathReviewerException
  }
  
  private void checkPathLength()
  {
    int j = this.n;
    int k = this.certs.size() - 1;
    int m;
    for (int i1 = 0; k > 0; i1 = m)
    {
      Object localObject = (X509Certificate)this.certs.get(k);
      int i = j;
      m = i1;
      if (!isSelfIssued((X509Certificate)localObject))
      {
        if (j <= 0) {
          addError(new ErrorBundle("org.bouncycastle.x509.CertPathReviewerMessages", "CertPathReviewer.pathLengthExtended"));
        }
        i = j - 1;
        m = i1 + 1;
      }
      try
      {
        localObject = BasicConstraints.getInstance(getExtensionValue((X509Extension)localObject, BASIC_CONSTRAINTS));
      }
      catch (AnnotatedException localAnnotatedException)
      {
        for (;;) {}
      }
      addError(new ErrorBundle("org.bouncycastle.x509.CertPathReviewerMessages", "CertPathReviewer.processLengthConstError"), k);
      localObject = null;
      j = i;
      if (localObject != null)
      {
        localObject = ((BasicConstraints)localObject).getPathLenConstraint();
        j = i;
        if (localObject != null)
        {
          i1 = ((BigInteger)localObject).intValue();
          j = i;
          if (i1 < i) {
            j = i1;
          }
        }
      }
      k -= 1;
    }
    addNotification(new ErrorBundle("org.bouncycastle.x509.CertPathReviewerMessages", "CertPathReviewer.totalPathLength", new Object[] { Integers.valueOf(i1) }));
  }
  
  private void checkPolicy()
  {
    Object localObject6 = "CertPathReviewer.policyExtError";
    Object localObject9 = this.pkixParams.getInitialPolicies();
    int m = this.n + 1;
    ArrayList[] arrayOfArrayList = new ArrayList[m];
    int i = 0;
    while (i < m)
    {
      arrayOfArrayList[i] = new ArrayList();
      i += 1;
    }
    Object localObject1 = new HashSet();
    ((Set)localObject1).add("2.5.29.32.0");
    localObject1 = new PKIXPolicyNode(new ArrayList(), 0, (Set)localObject1, null, new HashSet(), "2.5.29.32.0", false);
    arrayOfArrayList[0].add(localObject1);
    if (this.pkixParams.isExplicitPolicyRequired()) {
      i = 0;
    } else {
      i = this.n + 1;
    }
    int k;
    if (this.pkixParams.isAnyPolicyInhibited()) {
      k = 0;
    } else {
      k = this.n + 1;
    }
    if (this.pkixParams.isPolicyMappingInhibited()) {
      j = 0;
    } else {
      j = this.n + 1;
    }
    int i1;
    int i4;
    Object localObject10;
    Object localObject8;
    int i3;
    X509Certificate localX509Certificate;
    Object localObject13;
    Object localObject11;
    label276:
    Object localObject12;
    label495:
    label591:
    int i2;
    label634:
    label698:
    label910:
    label982:
    label1002:
    label1210:
    label1356:
    Object localObject7;
    for (;;)
    {
      try
      {
        i1 = this.certs.size();
        i4 = i1 - 1;
        localObject10 = null;
        localObject8 = null;
        if (i4 >= 0)
        {
          i3 = this.n - i4;
          localX509Certificate = (X509Certificate)this.certs.get(i4);
          try
          {
            localObject13 = (ASN1Sequence)getExtensionValue(localX509Certificate, CERTIFICATE_POLICIES);
            if ((localObject13 == null) || (localObject1 == null)) {
              break label2761;
            }
            localObject10 = ((ASN1Sequence)localObject13).getObjects();
            localObject11 = new HashSet();
            if (((Enumeration)localObject10).hasMoreElements())
            {
              localObject14 = PolicyInformation.getInstance(((Enumeration)localObject10).nextElement());
              localObject12 = ((PolicyInformation)localObject14).getPolicyIdentifier();
              ((Set)localObject11).add(((ASN1ObjectIdentifier)localObject12).getId());
              bool = "2.5.29.32.0".equals(((ASN1ObjectIdentifier)localObject12).getId());
              if (bool) {
                break label2644;
              }
              try
              {
                localObject14 = getQualifierSet(((PolicyInformation)localObject14).getPolicyQualifiers());
                if (processCertD1i(i3, arrayOfArrayList, (ASN1ObjectIdentifier)localObject12, (Set)localObject14)) {
                  break label2644;
                }
                processCertD1ii(i3, arrayOfArrayList, (ASN1ObjectIdentifier)localObject12, (Set)localObject14);
              }
              catch (CertPathValidatorException localCertPathValidatorException1)
              {
                throw new CertPathReviewerException(new ErrorBundle("org.bouncycastle.x509.CertPathReviewerMessages", "CertPathReviewer.policyQualifierError"), localCertPathValidatorException1, this.certPath, i4);
              }
            }
            localObject10 = localObject6;
            if ((localObject8 == null) || (((Set)localObject8).contains("2.5.29.32.0"))) {
              break label2647;
            }
            localObject12 = ((Set)localObject8).iterator();
            localObject8 = new HashSet();
            localObject6 = localObject8;
            if (((Iterator)localObject12).hasNext())
            {
              localObject6 = ((Iterator)localObject12).next();
              if (!((Set)localObject11).contains(localObject6)) {
                continue;
              }
              ((Set)localObject8).add(localObject6);
              continue;
            }
            if (k <= 0) {
              if ((i3 >= this.n) || (!isSelfIssued(localX509Certificate))) {
                break label2654;
              }
            }
            localObject8 = ((ASN1Sequence)localObject13).getObjects();
            if (!((Enumeration)localObject8).hasMoreElements()) {
              break label2654;
            }
            localObject11 = PolicyInformation.getInstance(((Enumeration)localObject8).nextElement());
            bool = "2.5.29.32.0".equals(((PolicyInformation)localObject11).getPolicyIdentifier().getId());
            if (!bool) {
              continue;
            }
            try
            {
              localObject14 = getQualifierSet(((PolicyInformation)localObject11).getPolicyQualifiers());
              localObject8 = arrayOfArrayList[(i3 - 1)];
              i1 = 0;
              if (i1 >= ((List)localObject8).size()) {
                break label2688;
              }
              localObject15 = (PKIXPolicyNode)((List)localObject8).get(i1);
              Iterator localIterator = ((PKIXPolicyNode)localObject15).getExpectedPolicies().iterator();
              i2 = j;
              j = k;
              if (!localIterator.hasNext()) {
                break label2674;
              }
              localObject11 = localIterator.next();
              if ((localObject11 instanceof String))
              {
                localObject11 = (String)localObject11;
              }
              else
              {
                if (!(localObject11 instanceof ASN1ObjectIdentifier)) {
                  break label2671;
                }
                localObject11 = ((ASN1ObjectIdentifier)localObject11).getId();
              }
              localObject12 = ((PKIXPolicyNode)localObject15).getChildren();
              k = 0;
              if (((Iterator)localObject12).hasNext())
              {
                if (!((String)localObject11).equals(((PKIXPolicyNode)((Iterator)localObject12).next()).getValidPolicy())) {
                  break label2665;
                }
                k = 1;
                break label2665;
              }
              if (k != 0) {
                break label2668;
              }
              localObject12 = new HashSet();
              ((Set)localObject12).add(localObject11);
              localObject11 = new PKIXPolicyNode(new ArrayList(), i3, (Set)localObject12, (PolicyNode)localObject15, (Set)localObject14, (String)localObject11, false);
              ((PKIXPolicyNode)localObject15).addChild((PKIXPolicyNode)localObject11);
              arrayOfArrayList[i3].add(localObject11);
            }
            catch (CertPathValidatorException localCertPathValidatorException2)
            {
              throw new CertPathReviewerException(new ErrorBundle("org.bouncycastle.x509.CertPathReviewerMessages", "CertPathReviewer.policyQualifierError"), localCertPathValidatorException2, this.certPath, i4);
            }
            localObject8 = localCertPathValidatorException2;
            if (i2 >= ((List)localObject12).size()) {
              break label2733;
            }
            localObject11 = (PKIXPolicyNode)((List)localObject12).get(i2);
            localObject8 = localCertPathValidatorException2;
            if (((PKIXPolicyNode)localObject11).hasChildren()) {
              break label2720;
            }
            localObject11 = removePolicyNode(localCertPathValidatorException2, arrayOfArrayList, (PKIXPolicyNode)localObject11);
            localObject2 = localObject11;
            localObject8 = localObject2;
            if (localObject11 != null) {
              break label2720;
            }
            localObject8 = localObject2;
          }
          catch (AnnotatedException localAnnotatedException2)
          {
            Object localObject14;
            Object localObject15;
            Object localObject2;
            throw new CertPathReviewerException(new ErrorBundle("org.bouncycastle.x509.CertPathReviewerMessages", (String)localObject7), localAnnotatedException2, this.certPath, i4);
          }
          localObject8 = localX509Certificate.getCriticalExtensionOIDs();
          if (localObject8 == null) {
            break label2746;
          }
          bool = ((Set)localObject8).contains(CERTIFICATE_POLICIES);
          localObject8 = arrayOfArrayList[i3];
          i1 = 0;
          if (i1 >= ((List)localObject8).size()) {
            break label2746;
          }
          ((PKIXPolicyNode)((List)localObject8).get(i1)).setCritical(bool);
          i1 += 1;
          continue;
          throw new CertPathReviewerException(new ErrorBundle("org.bouncycastle.x509.CertPathReviewerMessages", "CertPathReviewer.noValidPolicyTree"));
          i1 = this.n;
          if (i3 == i1) {
            break label2824;
          }
          try
          {
            localObject11 = getExtensionValue(localX509Certificate, POLICY_MAPPINGS);
            if (localObject11 != null)
            {
              localObject10 = (ASN1Sequence)localObject11;
              i1 = 0;
              if (i1 < ((ASN1Sequence)localObject10).size())
              {
                localObject13 = (ASN1Sequence)((ASN1Sequence)localObject10).getObjectAt(i1);
                localObject12 = (ASN1ObjectIdentifier)((ASN1Sequence)localObject13).getObjectAt(0);
                localObject13 = (ASN1ObjectIdentifier)((ASN1Sequence)localObject13).getObjectAt(1);
                bool = "2.5.29.32.0".equals(((ASN1ObjectIdentifier)localObject12).getId());
                if (!bool)
                {
                  if (!"2.5.29.32.0".equals(((ASN1ObjectIdentifier)localObject13).getId()))
                  {
                    i1 += 1;
                    continue;
                  }
                  throw new CertPathReviewerException(new ErrorBundle("org.bouncycastle.x509.CertPathReviewerMessages", "CertPathReviewer.invalidPolicyMapping"), this.certPath, i4);
                }
                throw new CertPathReviewerException(new ErrorBundle("org.bouncycastle.x509.CertPathReviewerMessages", "CertPathReviewer.invalidPolicyMapping"), this.certPath, i4);
              }
            }
            if (localObject11 == null) {
              break label2817;
            }
            localObject10 = (ASN1Sequence)localObject11;
            localObject13 = new HashMap();
            localObject11 = new HashSet();
            i1 = 0;
            if (i1 < ((ASN1Sequence)localObject10).size())
            {
              localObject14 = (ASN1Sequence)((ASN1Sequence)localObject10).getObjectAt(i1);
              localObject12 = ((ASN1ObjectIdentifier)((ASN1Sequence)localObject14).getObjectAt(0)).getId();
              localObject14 = ((ASN1ObjectIdentifier)((ASN1Sequence)localObject14).getObjectAt(1)).getId();
              if (!((Map)localObject13).containsKey(localObject12))
              {
                localObject15 = new HashSet();
                ((Set)localObject15).add(localObject14);
                ((Map)localObject13).put(localObject12, localObject15);
                ((Set)localObject11).add(localObject12);
                break label2801;
              }
              ((Set)((Map)localObject13).get(localObject12)).add(localObject14);
              break label2801;
            }
            localObject12 = localObject8;
            localObject14 = ((Set)localObject11).iterator();
            localObject10 = localObject6;
            localObject6 = localObject10;
            localObject8 = localObject12;
            localObject11 = localObject2;
            if (((Iterator)localObject14).hasNext())
            {
              localObject8 = (String)((Iterator)localObject14).next();
              if (k > 0) {
                try
                {
                  prepareNextCertB1(i3, arrayOfArrayList, (String)localObject8, (Map)localObject13, localX509Certificate);
                  localObject6 = localObject10;
                }
                catch (CertPathValidatorException localCertPathValidatorException3)
                {
                  throw new CertPathReviewerException(new ErrorBundle("org.bouncycastle.x509.CertPathReviewerMessages", "CertPathReviewer.policyQualifierError"), localCertPathValidatorException3, this.certPath, i4);
                }
                catch (AnnotatedException localAnnotatedException6)
                {
                  throw new CertPathReviewerException(new ErrorBundle("org.bouncycastle.x509.CertPathReviewerMessages", localCertPathValidatorException3), localAnnotatedException6, this.certPath, i4);
                }
              }
              localObject7 = localObject10;
              if (k > 0) {
                break label2810;
              }
              localObject7 = prepareNextCertB2(i3, arrayOfArrayList, (String)localObject8, (PKIXPolicyNode)localObject10);
              break label2810;
            }
            label1497:
            localObject12 = localObject11;
            bool = isSelfIssued(localX509Certificate);
            if (!bool)
            {
              i1 = i;
              if (i != 0) {
                i1 = i - 1;
              }
              if (k != 0) {
                k -= 1;
              }
              if (j != 0)
              {
                i = j - 1;
                j = i1;
              }
              else
              {
                i = j;
                j = i1;
              }
            }
            else
            {
              i1 = j;
              j = i;
              i = i1;
            }
          }
          catch (AnnotatedException localAnnotatedException1)
          {
            Object localObject3;
            int i5;
            label1799:
            throw new CertPathReviewerException(new ErrorBundle("org.bouncycastle.x509.CertPathReviewerMessages", "CertPathReviewer.policyMapExtError"), localAnnotatedException1, this.certPath, i4);
          }
        }
      }
      catch (CertPathReviewerException localCertPathReviewerException)
      {
        boolean bool;
        Object localObject4;
        addError(localCertPathReviewerException.getErrorMessage(), localCertPathReviewerException.getIndex());
        return;
      }
      try
      {
        localObject3 = (ASN1Sequence)getExtensionValue(localX509Certificate, POLICY_CONSTRAINTS);
        i2 = j;
        i3 = k;
        if (localObject3 != null)
        {
          localObject3 = ((ASN1Sequence)localObject3).getObjects();
          i2 = j;
          i3 = k;
          if (((Enumeration)localObject3).hasMoreElements())
          {
            localObject10 = (ASN1TaggedObject)((Enumeration)localObject3).nextElement();
            i1 = ((ASN1TaggedObject)localObject10).getTagNo();
            if (i1 != 0)
            {
              if (i1 != 1) {
                continue;
              }
              i1 = ASN1Integer.getInstance((ASN1TaggedObject)localObject10, false).getValue().intValue();
              if (i1 >= k) {
                continue;
              }
              k = i1;
              continue;
            }
            i1 = ASN1Integer.getInstance((ASN1TaggedObject)localObject10, false).getValue().intValue();
            if (i1 >= j) {
              continue;
            }
            j = i1;
            continue;
          }
        }
      }
      catch (AnnotatedException localAnnotatedException3) {}
    }
    try
    {
      localObject13 = (ASN1Integer)getExtensionValue(localX509Certificate, INHIBIT_ANY_POLICY);
      j = i;
      k = i2;
      localObject11 = localObject12;
      i1 = i3;
      localObject3 = localObject7;
      localObject10 = localObject8;
      if (localObject13 == null) {
        break label2841;
      }
      i5 = ((ASN1Integer)localObject13).getValue().intValue();
      j = i;
      k = i2;
      localObject11 = localObject12;
      i1 = i3;
      localObject3 = localObject7;
      localObject10 = localObject8;
      if (i5 >= i) {
        break label2841;
      }
      j = i5;
      k = i2;
      localObject11 = localObject12;
      i1 = i3;
      localObject3 = localObject7;
      localObject10 = localObject8;
    }
    catch (AnnotatedException localAnnotatedException4)
    {
      break label1799;
    }
    throw new CertPathReviewerException(new ErrorBundle("org.bouncycastle.x509.CertPathReviewerMessages", "CertPathReviewer.policyInhibitExtError"), this.certPath, i4);
    throw new CertPathReviewerException(new ErrorBundle("org.bouncycastle.x509.CertPathReviewerMessages", "CertPathReviewer.policyConstExtError"), this.certPath, i4);
    bool = isSelfIssued((X509Certificate)localObject10);
    int j = i;
    if (!bool)
    {
      j = i;
      if (i > 0) {
        j = i - 1;
      }
    }
    try
    {
      localObject7 = (ASN1Sequence)getExtensionValue((X509Extension)localObject10, POLICY_CONSTRAINTS);
      if (localObject7 != null)
      {
        localObject7 = ((ASN1Sequence)localObject7).getObjects();
        i = j;
        while (((Enumeration)localObject7).hasMoreElements())
        {
          localObject10 = (ASN1TaggedObject)((Enumeration)localObject7).nextElement();
          if (((ASN1TaggedObject)localObject10).getTagNo() == 0)
          {
            j = ASN1Integer.getInstance((ASN1TaggedObject)localObject10, false).getValue().intValue();
            if (j == 0) {
              i = 0;
            }
          }
        }
        j = i;
      }
      if (localAnnotatedException2 == null)
      {
        if (!this.pkixParams.isExplicitPolicyRequired())
        {
          localObject4 = null;
          break label3023;
        }
        throw new CertPathReviewerException(new ErrorBundle("org.bouncycastle.x509.CertPathReviewerMessages", "CertPathReviewer.explicitPolicy"), this.certPath, i4);
      }
      if (isAnyPolicy((Set)localObject9))
      {
        if (!this.pkixParams.isExplicitPolicyRequired()) {
          break label2945;
        }
        if (!((Set)localObject8).isEmpty())
        {
          localObject7 = new HashSet();
          i = 0;
          break label2877;
          if (k >= ((List)localObject9).size()) {
            break label2901;
          }
          localObject10 = (PKIXPolicyNode)((List)localObject9).get(k);
          if (!"2.5.29.32.0".equals(((PKIXPolicyNode)localObject10).getValidPolicy())) {
            break label2894;
          }
          localObject10 = ((PKIXPolicyNode)localObject10).getChildren();
          while (((Iterator)localObject10).hasNext()) {
            ((Set)localObject7).add(((Iterator)localObject10).next());
          }
          label2183:
          localObject7 = ((Set)localObject7).iterator();
          while (((Iterator)localObject7).hasNext()) {
            ((Set)localObject8).contains(((PKIXPolicyNode)((Iterator)localObject7).next()).getValidPolicy());
          }
          if (localObject4 == null) {
            break label2945;
          }
          i = this.n - 1;
          localObject7 = localObject4;
          break label2908;
          if (k >= ((List)localObject8).size()) {
            break label2938;
          }
          localObject9 = (PKIXPolicyNode)((List)localObject8).get(k);
          localObject4 = localObject7;
          if (((PKIXPolicyNode)localObject9).hasChildren()) {
            break label2927;
          }
          localObject4 = removePolicyNode((PKIXPolicyNode)localObject7, arrayOfArrayList, (PKIXPolicyNode)localObject9);
          break label2927;
        }
        throw new CertPathReviewerException(new ErrorBundle("org.bouncycastle.x509.CertPathReviewerMessages", "CertPathReviewer.explicitPolicy"), this.certPath, i4);
      }
      localObject7 = new HashSet();
      i = 0;
    }
    catch (AnnotatedException localAnnotatedException5)
    {
      label2429:
      label2442:
      for (;;) {}
    }
    if (k < ((List)localObject8).size())
    {
      localObject10 = (PKIXPolicyNode)((List)localObject8).get(k);
      if ("2.5.29.32.0".equals(((PKIXPolicyNode)localObject10).getValidPolicy()))
      {
        localObject10 = ((PKIXPolicyNode)localObject10).getChildren();
        while (((Iterator)localObject10).hasNext())
        {
          localObject11 = (PKIXPolicyNode)((Iterator)localObject10).next();
          if (!"2.5.29.32.0".equals(((PKIXPolicyNode)localObject11).getValidPolicy()))
          {
            ((Set)localObject7).add(localObject11);
            continue;
            localObject8 = ((Set)localObject7).iterator();
            localObject7 = localObject4;
            if (((Iterator)localObject8).hasNext())
            {
              localObject10 = (PKIXPolicyNode)((Iterator)localObject8).next();
              localObject4 = localObject7;
              if (((Set)localObject9).contains(((PKIXPolicyNode)localObject10).getValidPolicy())) {
                break label2979;
              }
              localObject4 = removePolicyNode((PKIXPolicyNode)localObject7, arrayOfArrayList, (PKIXPolicyNode)localObject10);
              break label2979;
            }
            localObject4 = localObject7;
            if (localObject7 == null) {
              break label3023;
            }
            i = this.n - 1;
            break label2986;
            if (k >= ((List)localObject8).size()) {
              break label3016;
            }
            localObject9 = (PKIXPolicyNode)((List)localObject8).get(k);
            localObject4 = localObject7;
            if (((PKIXPolicyNode)localObject9).hasChildren()) {
              break label3005;
            }
            localObject4 = removePolicyNode((PKIXPolicyNode)localObject7, arrayOfArrayList, (PKIXPolicyNode)localObject9);
            break label3005;
          }
        }
      }
    }
    label2644:
    label2647:
    label2654:
    label2665:
    label2668:
    label2671:
    label2674:
    label2688:
    label2696:
    label2720:
    Object localObject5;
    label2733:
    label2744:
    label2746:
    label2761:
    label2781:
    label2801:
    label2810:
    label2817:
    label2824:
    label2841:
    label2877:
    label2894:
    label2901:
    label2906:
    label2908:
    label2927:
    label2938:
    label2945:
    label2977:
    label2979:
    label2986:
    label3005:
    label3016:
    label3023:
    do
    {
      throw new CertPathReviewerException(new ErrorBundle("org.bouncycastle.x509.CertPathReviewerMessages", "CertPathReviewer.invalidPolicy"));
      throw new CertPathReviewerException(new ErrorBundle("org.bouncycastle.x509.CertPathReviewerMessages", "CertPathReviewer.policyConstExtError"), this.certPath, i4);
      do
      {
        break label276;
        localObject7 = localObject11;
        break label495;
        i1 = j;
        j = k;
        k = i1;
        break label2696;
        break label698;
        break label634;
        break label634;
        i1 += 1;
        k = j;
        j = i2;
        break label591;
        i1 = k;
        k = j;
        j = i1;
        i1 = i3 - 1;
        for (;;)
        {
          if (i1 < 0) {
            break label2744;
          }
          localObject12 = arrayOfArrayList[i1];
          i2 = 0;
          break;
          i2 += 1;
          localObject5 = localObject8;
          break;
          i1 -= 1;
          localObject5 = localObject8;
        }
        break label910;
        localObject8 = localObject7;
        localObject7 = localObject5;
        localObject5 = localObject10;
        break label2781;
        i1 = k;
        localObject10 = localObject5;
        k = j;
        j = i1;
        localObject5 = localObject7;
        localObject7 = localObject10;
        if (localObject13 == null) {
          localObject7 = null;
        }
        if (i > 0) {
          break label1002;
        }
        if (localObject7 == null) {
          break label982;
        }
        break label1002;
        i1 += 1;
        break label1210;
        localObject10 = localObject7;
        break label1356;
        localObject11 = localObject5;
        break label1497;
        localObject11 = localObject5;
        localObject10 = localObject8;
        localObject5 = localObject7;
        i1 = k;
        k = i;
        i4 -= 1;
        localObject8 = localX509Certificate;
        localObject7 = localObject11;
        localObject11 = localObject10;
        localObject10 = localObject8;
        i = k;
        k = j;
        j = i1;
        localObject8 = localObject11;
        break;
        for (;;)
        {
          if (i >= m) {
            break label2906;
          }
          localObject9 = arrayOfArrayList[i];
          k = 0;
          break;
          k += 1;
          break;
          i += 1;
        }
        break label2183;
        for (;;)
        {
          localObject5 = localObject7;
          if (i < 0) {
            break label3023;
          }
          localObject8 = arrayOfArrayList[i];
          k = 0;
          break;
          k += 1;
          localObject7 = localObject5;
          break;
          i -= 1;
        }
        continue;
        for (;;)
        {
          if (i >= m) {
            break label2977;
          }
          localObject8 = arrayOfArrayList[i];
          k = 0;
          break;
          k += 1;
          break;
          i += 1;
        }
        break label2429;
        localObject7 = localObject5;
        break label2442;
        for (;;)
        {
          localObject5 = localObject7;
          if (i < 0) {
            break label3023;
          }
          localObject8 = arrayOfArrayList[i];
          k = 0;
          break;
          k += 1;
          localObject7 = localObject5;
          break;
          i -= 1;
        }
      } while (j > 0);
    } while (localObject5 == null);
  }
  
  /* Error */
  private void checkSignatures()
  {
    // Byte code:
    //   0: aload_0
    //   1: new 201	org/bouncycastle/i18n/ErrorBundle
    //   4: dup
    //   5: ldc 11
    //   7: ldc_w 567
    //   10: iconst_2
    //   11: anewarray 205	java/lang/Object
    //   14: dup
    //   15: iconst_0
    //   16: new 569	org/bouncycastle/i18n/filter/TrustedInput
    //   19: dup
    //   20: aload_0
    //   21: getfield 571	org/bouncycastle/x509/PKIXCertPathReviewer:validDate	Ljava/util/Date;
    //   24: invokespecial 572	org/bouncycastle/i18n/filter/TrustedInput:<init>	(Ljava/lang/Object;)V
    //   27: aastore
    //   28: dup
    //   29: iconst_1
    //   30: new 569	org/bouncycastle/i18n/filter/TrustedInput
    //   33: dup
    //   34: new 574	java/util/Date
    //   37: dup
    //   38: invokespecial 575	java/util/Date:<init>	()V
    //   41: invokespecial 572	org/bouncycastle/i18n/filter/TrustedInput:<init>	(Ljava/lang/Object;)V
    //   44: aastore
    //   45: invokespecial 220	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   48: invokevirtual 398	org/bouncycastle/x509/PKIXCertPathReviewer:addNotification	(Lorg/bouncycastle/i18n/ErrorBundle;)V
    //   51: aload_0
    //   52: getfield 135	org/bouncycastle/x509/PKIXCertPathReviewer:certs	Ljava/util/List;
    //   55: aload_0
    //   56: getfield 135	org/bouncycastle/x509/PKIXCertPathReviewer:certs	Ljava/util/List;
    //   59: invokeinterface 139 1 0
    //   64: iconst_1
    //   65: isub
    //   66: invokeinterface 143 2 0
    //   71: checkcast 145	java/security/cert/X509Certificate
    //   74: astore 5
    //   76: aload_0
    //   77: aload 5
    //   79: aload_0
    //   80: getfield 106	org/bouncycastle/x509/PKIXCertPathReviewer:pkixParams	Ljava/security/cert/PKIXParameters;
    //   83: invokevirtual 578	java/security/cert/PKIXParameters:getTrustAnchors	()Ljava/util/Set;
    //   86: invokevirtual 581	org/bouncycastle/x509/PKIXCertPathReviewer:getTrustAnchors	(Ljava/security/cert/X509Certificate;Ljava/util/Set;)Ljava/util/Collection;
    //   89: astore_3
    //   90: aload_3
    //   91: invokeinterface 584 1 0
    //   96: iconst_1
    //   97: if_icmple +53 -> 150
    //   100: aload_0
    //   101: new 201	org/bouncycastle/i18n/ErrorBundle
    //   104: dup
    //   105: ldc 11
    //   107: ldc_w 586
    //   110: iconst_2
    //   111: anewarray 205	java/lang/Object
    //   114: dup
    //   115: iconst_0
    //   116: aload_3
    //   117: invokeinterface 584 1 0
    //   122: invokestatic 395	org/bouncycastle/util/Integers:valueOf	(I)Ljava/lang/Integer;
    //   125: aastore
    //   126: dup
    //   127: iconst_1
    //   128: new 326	org/bouncycastle/i18n/filter/UntrustedInput
    //   131: dup
    //   132: aload 5
    //   134: invokevirtual 590	java/security/cert/X509Certificate:getIssuerX500Principal	()Ljavax/security/auth/x500/X500Principal;
    //   137: invokespecial 329	org/bouncycastle/i18n/filter/UntrustedInput:<init>	(Ljava/lang/Object;)V
    //   140: aastore
    //   141: invokespecial 220	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   144: invokevirtual 371	org/bouncycastle/x509/PKIXCertPathReviewer:addError	(Lorg/bouncycastle/i18n/ErrorBundle;)V
    //   147: goto +1551 -> 1698
    //   150: aload_3
    //   151: invokeinterface 591 1 0
    //   156: ifeq +59 -> 215
    //   159: aload_0
    //   160: new 201	org/bouncycastle/i18n/ErrorBundle
    //   163: dup
    //   164: ldc 11
    //   166: ldc_w 593
    //   169: iconst_2
    //   170: anewarray 205	java/lang/Object
    //   173: dup
    //   174: iconst_0
    //   175: new 326	org/bouncycastle/i18n/filter/UntrustedInput
    //   178: dup
    //   179: aload 5
    //   181: invokevirtual 590	java/security/cert/X509Certificate:getIssuerX500Principal	()Ljavax/security/auth/x500/X500Principal;
    //   184: invokespecial 329	org/bouncycastle/i18n/filter/UntrustedInput:<init>	(Ljava/lang/Object;)V
    //   187: aastore
    //   188: dup
    //   189: iconst_1
    //   190: aload_0
    //   191: getfield 106	org/bouncycastle/x509/PKIXCertPathReviewer:pkixParams	Ljava/security/cert/PKIXParameters;
    //   194: invokevirtual 578	java/security/cert/PKIXParameters:getTrustAnchors	()Ljava/util/Set;
    //   197: invokeinterface 594 1 0
    //   202: invokestatic 395	org/bouncycastle/util/Integers:valueOf	(I)Ljava/lang/Integer;
    //   205: aastore
    //   206: invokespecial 220	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   209: invokevirtual 371	org/bouncycastle/x509/PKIXCertPathReviewer:addError	(Lorg/bouncycastle/i18n/ErrorBundle;)V
    //   212: goto +1486 -> 1698
    //   215: aload_3
    //   216: invokeinterface 595 1 0
    //   221: invokeinterface 128 1 0
    //   226: checkcast 597	java/security/cert/TrustAnchor
    //   229: astore_3
    //   230: aload_3
    //   231: invokevirtual 601	java/security/cert/TrustAnchor:getTrustedCert	()Ljava/security/cert/X509Certificate;
    //   234: ifnull +15 -> 249
    //   237: aload_3
    //   238: invokevirtual 601	java/security/cert/TrustAnchor:getTrustedCert	()Ljava/security/cert/X509Certificate;
    //   241: invokevirtual 605	java/security/cert/X509Certificate:getPublicKey	()Ljava/security/PublicKey;
    //   244: astore 4
    //   246: goto +9 -> 255
    //   249: aload_3
    //   250: invokevirtual 608	java/security/cert/TrustAnchor:getCAPublicKey	()Ljava/security/PublicKey;
    //   253: astore 4
    //   255: aload 5
    //   257: aload 4
    //   259: aload_0
    //   260: getfield 106	org/bouncycastle/x509/PKIXCertPathReviewer:pkixParams	Ljava/security/cert/PKIXParameters;
    //   263: invokevirtual 611	java/security/cert/PKIXParameters:getSigProvider	()Ljava/lang/String;
    //   266: invokestatic 615	org/bouncycastle/x509/CertPathValidatorUtilities:verifyX509Certificate	(Ljava/security/cert/X509Certificate;Ljava/security/PublicKey;Ljava/lang/String;)V
    //   269: goto +99 -> 368
    //   272: aload_0
    //   273: new 201	org/bouncycastle/i18n/ErrorBundle
    //   276: dup
    //   277: ldc 11
    //   279: ldc_w 617
    //   282: invokespecial 334	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   285: invokevirtual 371	org/bouncycastle/x509/PKIXCertPathReviewer:addError	(Lorg/bouncycastle/i18n/ErrorBundle;)V
    //   288: goto +80 -> 368
    //   291: astore 4
    //   293: goto +12 -> 305
    //   296: astore 4
    //   298: goto +61 -> 359
    //   301: astore 4
    //   303: aconst_null
    //   304: astore_3
    //   305: aload_0
    //   306: new 201	org/bouncycastle/i18n/ErrorBundle
    //   309: dup
    //   310: ldc 11
    //   312: ldc_w 619
    //   315: iconst_2
    //   316: anewarray 205	java/lang/Object
    //   319: dup
    //   320: iconst_0
    //   321: new 326	org/bouncycastle/i18n/filter/UntrustedInput
    //   324: dup
    //   325: aload 4
    //   327: invokevirtual 622	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   330: invokespecial 329	org/bouncycastle/i18n/filter/UntrustedInput:<init>	(Ljava/lang/Object;)V
    //   333: aastore
    //   334: dup
    //   335: iconst_1
    //   336: new 326	org/bouncycastle/i18n/filter/UntrustedInput
    //   339: dup
    //   340: aload 4
    //   342: invokespecial 329	org/bouncycastle/i18n/filter/UntrustedInput:<init>	(Ljava/lang/Object;)V
    //   345: aastore
    //   346: invokespecial 220	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   349: invokevirtual 371	org/bouncycastle/x509/PKIXCertPathReviewer:addError	(Lorg/bouncycastle/i18n/ErrorBundle;)V
    //   352: goto +16 -> 368
    //   355: astore 4
    //   357: aconst_null
    //   358: astore_3
    //   359: aload_0
    //   360: aload 4
    //   362: invokevirtual 250	org/bouncycastle/x509/CertPathReviewerException:getErrorMessage	()Lorg/bouncycastle/i18n/ErrorBundle;
    //   365: invokevirtual 371	org/bouncycastle/x509/PKIXCertPathReviewer:addError	(Lorg/bouncycastle/i18n/ErrorBundle;)V
    //   368: aload_3
    //   369: astore 6
    //   371: aload 6
    //   373: ifnull +132 -> 505
    //   376: aload 6
    //   378: invokevirtual 601	java/security/cert/TrustAnchor:getTrustedCert	()Ljava/security/cert/X509Certificate;
    //   381: astore 5
    //   383: aload 5
    //   385: ifnull +12 -> 397
    //   388: aload 5
    //   390: invokestatic 271	org/bouncycastle/x509/PKIXCertPathReviewer:getSubjectPrincipal	(Ljava/security/cert/X509Certificate;)Ljavax/security/auth/x500/X500Principal;
    //   393: astore_3
    //   394: goto +56 -> 450
    //   397: new 277	javax/security/auth/x500/X500Principal
    //   400: dup
    //   401: aload 6
    //   403: invokevirtual 625	java/security/cert/TrustAnchor:getCAName	()Ljava/lang/String;
    //   406: invokespecial 626	javax/security/auth/x500/X500Principal:<init>	(Ljava/lang/String;)V
    //   409: astore_3
    //   410: goto +40 -> 450
    //   413: aload_0
    //   414: new 201	org/bouncycastle/i18n/ErrorBundle
    //   417: dup
    //   418: ldc 11
    //   420: ldc_w 628
    //   423: iconst_1
    //   424: anewarray 205	java/lang/Object
    //   427: dup
    //   428: iconst_0
    //   429: new 326	org/bouncycastle/i18n/filter/UntrustedInput
    //   432: dup
    //   433: aload 6
    //   435: invokevirtual 625	java/security/cert/TrustAnchor:getCAName	()Ljava/lang/String;
    //   438: invokespecial 329	org/bouncycastle/i18n/filter/UntrustedInput:<init>	(Ljava/lang/Object;)V
    //   441: aastore
    //   442: invokespecial 220	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   445: invokevirtual 371	org/bouncycastle/x509/PKIXCertPathReviewer:addError	(Lorg/bouncycastle/i18n/ErrorBundle;)V
    //   448: aconst_null
    //   449: astore_3
    //   450: aload_3
    //   451: astore 4
    //   453: aload 5
    //   455: ifnull +53 -> 508
    //   458: aload 5
    //   460: invokevirtual 632	java/security/cert/X509Certificate:getKeyUsage	()[Z
    //   463: astore 5
    //   465: aload_3
    //   466: astore 4
    //   468: aload 5
    //   470: ifnull +38 -> 508
    //   473: aload_3
    //   474: astore 4
    //   476: aload 5
    //   478: iconst_5
    //   479: baload
    //   480: ifne +28 -> 508
    //   483: aload_0
    //   484: new 201	org/bouncycastle/i18n/ErrorBundle
    //   487: dup
    //   488: ldc 11
    //   490: ldc_w 634
    //   493: invokespecial 334	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   496: invokevirtual 398	org/bouncycastle/x509/PKIXCertPathReviewer:addNotification	(Lorg/bouncycastle/i18n/ErrorBundle;)V
    //   499: aload_3
    //   500: astore 4
    //   502: goto +6 -> 508
    //   505: aconst_null
    //   506: astore 4
    //   508: aload 6
    //   510: ifnull +70 -> 580
    //   513: aload 6
    //   515: invokevirtual 601	java/security/cert/TrustAnchor:getTrustedCert	()Ljava/security/cert/X509Certificate;
    //   518: astore 5
    //   520: aload 5
    //   522: ifnull +12 -> 534
    //   525: aload 5
    //   527: invokevirtual 605	java/security/cert/X509Certificate:getPublicKey	()Ljava/security/PublicKey;
    //   530: astore_3
    //   531: goto +9 -> 540
    //   534: aload 6
    //   536: invokevirtual 608	java/security/cert/TrustAnchor:getCAPublicKey	()Ljava/security/PublicKey;
    //   539: astore_3
    //   540: aload_3
    //   541: invokestatic 638	org/bouncycastle/x509/PKIXCertPathReviewer:getAlgorithmIdentifier	(Ljava/security/PublicKey;)Lorg/bouncycastle/asn1/x509/AlgorithmIdentifier;
    //   544: astore 7
    //   546: aload 7
    //   548: invokevirtual 643	org/bouncycastle/asn1/x509/AlgorithmIdentifier:getAlgorithm	()Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;
    //   551: pop
    //   552: aload 7
    //   554: invokevirtual 647	org/bouncycastle/asn1/x509/AlgorithmIdentifier:getParameters	()Lorg/bouncycastle/asn1/ASN1Encodable;
    //   557: pop
    //   558: goto +27 -> 585
    //   561: aload_0
    //   562: new 201	org/bouncycastle/i18n/ErrorBundle
    //   565: dup
    //   566: ldc 11
    //   568: ldc_w 649
    //   571: invokespecial 334	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   574: invokevirtual 371	org/bouncycastle/x509/PKIXCertPathReviewer:addError	(Lorg/bouncycastle/i18n/ErrorBundle;)V
    //   577: goto +8 -> 585
    //   580: aconst_null
    //   581: astore 5
    //   583: aconst_null
    //   584: astore_3
    //   585: aload_0
    //   586: getfield 135	org/bouncycastle/x509/PKIXCertPathReviewer:certs	Ljava/util/List;
    //   589: invokeinterface 139 1 0
    //   594: istore_1
    //   595: aload 5
    //   597: astore 7
    //   599: iload_1
    //   600: iconst_1
    //   601: isub
    //   602: istore_1
    //   603: aload 4
    //   605: astore 5
    //   607: aload_3
    //   608: astore 4
    //   610: iload_1
    //   611: iflt +1011 -> 1622
    //   614: aload_0
    //   615: getfield 366	org/bouncycastle/x509/PKIXCertPathReviewer:n	I
    //   618: iload_1
    //   619: isub
    //   620: istore_2
    //   621: aload_0
    //   622: getfield 135	org/bouncycastle/x509/PKIXCertPathReviewer:certs	Ljava/util/List;
    //   625: iload_1
    //   626: invokeinterface 143 2 0
    //   631: checkcast 145	java/security/cert/X509Certificate
    //   634: astore_3
    //   635: aload 4
    //   637: ifnull +73 -> 710
    //   640: aload_3
    //   641: aload 4
    //   643: aload_0
    //   644: getfield 106	org/bouncycastle/x509/PKIXCertPathReviewer:pkixParams	Ljava/security/cert/PKIXParameters;
    //   647: invokevirtual 611	java/security/cert/PKIXParameters:getSigProvider	()Ljava/lang/String;
    //   650: invokestatic 615	org/bouncycastle/x509/CertPathValidatorUtilities:verifyX509Certificate	(Ljava/security/cert/X509Certificate;Ljava/security/PublicKey;Ljava/lang/String;)V
    //   653: goto +296 -> 949
    //   656: astore 8
    //   658: new 201	org/bouncycastle/i18n/ErrorBundle
    //   661: dup
    //   662: ldc 11
    //   664: ldc_w 651
    //   667: iconst_3
    //   668: anewarray 205	java/lang/Object
    //   671: dup
    //   672: iconst_0
    //   673: aload 8
    //   675: invokevirtual 652	java/security/GeneralSecurityException:getMessage	()Ljava/lang/String;
    //   678: aastore
    //   679: dup
    //   680: iconst_1
    //   681: aload 8
    //   683: aastore
    //   684: dup
    //   685: iconst_2
    //   686: aload 8
    //   688: invokevirtual 212	java/lang/Object:getClass	()Ljava/lang/Class;
    //   691: invokevirtual 217	java/lang/Class:getName	()Ljava/lang/String;
    //   694: aastore
    //   695: invokespecial 220	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   698: astore 8
    //   700: aload_0
    //   701: aload 8
    //   703: iload_1
    //   704: invokevirtual 241	org/bouncycastle/x509/PKIXCertPathReviewer:addError	(Lorg/bouncycastle/i18n/ErrorBundle;I)V
    //   707: goto +242 -> 949
    //   710: aload_3
    //   711: invokestatic 267	org/bouncycastle/x509/PKIXCertPathReviewer:isSelfIssued	(Ljava/security/cert/X509Certificate;)Z
    //   714: ifeq +85 -> 799
    //   717: aload_3
    //   718: aload_3
    //   719: invokevirtual 605	java/security/cert/X509Certificate:getPublicKey	()Ljava/security/PublicKey;
    //   722: aload_0
    //   723: getfield 106	org/bouncycastle/x509/PKIXCertPathReviewer:pkixParams	Ljava/security/cert/PKIXParameters;
    //   726: invokevirtual 611	java/security/cert/PKIXParameters:getSigProvider	()Ljava/lang/String;
    //   729: invokestatic 615	org/bouncycastle/x509/CertPathValidatorUtilities:verifyX509Certificate	(Ljava/security/cert/X509Certificate;Ljava/security/PublicKey;Ljava/lang/String;)V
    //   732: aload_0
    //   733: new 201	org/bouncycastle/i18n/ErrorBundle
    //   736: dup
    //   737: ldc 11
    //   739: ldc_w 654
    //   742: invokespecial 334	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   745: iload_1
    //   746: invokevirtual 241	org/bouncycastle/x509/PKIXCertPathReviewer:addError	(Lorg/bouncycastle/i18n/ErrorBundle;I)V
    //   749: goto +200 -> 949
    //   752: astore 8
    //   754: new 201	org/bouncycastle/i18n/ErrorBundle
    //   757: dup
    //   758: ldc 11
    //   760: ldc_w 651
    //   763: iconst_3
    //   764: anewarray 205	java/lang/Object
    //   767: dup
    //   768: iconst_0
    //   769: aload 8
    //   771: invokevirtual 652	java/security/GeneralSecurityException:getMessage	()Ljava/lang/String;
    //   774: aastore
    //   775: dup
    //   776: iconst_1
    //   777: aload 8
    //   779: aastore
    //   780: dup
    //   781: iconst_2
    //   782: aload 8
    //   784: invokevirtual 212	java/lang/Object:getClass	()Ljava/lang/Class;
    //   787: invokevirtual 217	java/lang/Class:getName	()Ljava/lang/String;
    //   790: aastore
    //   791: invokespecial 220	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   794: astore 8
    //   796: goto -96 -> 700
    //   799: new 201	org/bouncycastle/i18n/ErrorBundle
    //   802: dup
    //   803: ldc 11
    //   805: ldc_w 656
    //   808: invokespecial 334	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   811: astore 8
    //   813: aload_3
    //   814: getstatic 659	org/bouncycastle/asn1/x509/X509Extensions:AuthorityKeyIdentifier	Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;
    //   817: invokevirtual 46	org/bouncycastle/asn1/ASN1ObjectIdentifier:getId	()Ljava/lang/String;
    //   820: invokevirtual 662	java/security/cert/X509Certificate:getExtensionValue	(Ljava/lang/String;)[B
    //   823: astore 9
    //   825: aload 9
    //   827: ifnull +115 -> 942
    //   830: aload 9
    //   832: invokestatic 668	org/bouncycastle/x509/extension/X509ExtensionUtil:fromExtensionValue	([B)Lorg/bouncycastle/asn1/ASN1Primitive;
    //   835: invokestatic 673	org/bouncycastle/asn1/x509/AuthorityKeyIdentifier:getInstance	(Ljava/lang/Object;)Lorg/bouncycastle/asn1/x509/AuthorityKeyIdentifier;
    //   838: astore 9
    //   840: aload 9
    //   842: invokevirtual 677	org/bouncycastle/asn1/x509/AuthorityKeyIdentifier:getAuthorityCertIssuer	()Lorg/bouncycastle/asn1/x509/GeneralNames;
    //   845: astore 10
    //   847: aload 10
    //   849: ifnull +93 -> 942
    //   852: aload 10
    //   854: invokevirtual 683	org/bouncycastle/asn1/x509/GeneralNames:getNames	()[Lorg/bouncycastle/asn1/x509/GeneralName;
    //   857: iconst_0
    //   858: aaload
    //   859: astore 10
    //   861: aload 9
    //   863: invokevirtual 686	org/bouncycastle/asn1/x509/AuthorityKeyIdentifier:getAuthorityCertSerialNumber	()Ljava/math/BigInteger;
    //   866: astore 9
    //   868: aload 9
    //   870: ifnull +72 -> 942
    //   873: aload 8
    //   875: bipush 7
    //   877: anewarray 205	java/lang/Object
    //   880: dup
    //   881: iconst_0
    //   882: new 688	org/bouncycastle/i18n/LocaleString
    //   885: dup
    //   886: ldc 11
    //   888: ldc_w 690
    //   891: invokespecial 691	org/bouncycastle/i18n/LocaleString:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   894: aastore
    //   895: dup
    //   896: iconst_1
    //   897: ldc_w 693
    //   900: aastore
    //   901: dup
    //   902: iconst_2
    //   903: aload 10
    //   905: aastore
    //   906: dup
    //   907: iconst_3
    //   908: ldc_w 695
    //   911: aastore
    //   912: dup
    //   913: iconst_4
    //   914: new 688	org/bouncycastle/i18n/LocaleString
    //   917: dup
    //   918: ldc 11
    //   920: ldc_w 697
    //   923: invokespecial 691	org/bouncycastle/i18n/LocaleString:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   926: aastore
    //   927: dup
    //   928: iconst_5
    //   929: ldc_w 699
    //   932: aastore
    //   933: dup
    //   934: bipush 6
    //   936: aload 9
    //   938: aastore
    //   939: invokevirtual 703	org/bouncycastle/i18n/ErrorBundle:setExtraArguments	([Ljava/lang/Object;)V
    //   942: aload_0
    //   943: aload 8
    //   945: iload_1
    //   946: invokevirtual 241	org/bouncycastle/x509/PKIXCertPathReviewer:addError	(Lorg/bouncycastle/i18n/ErrorBundle;I)V
    //   949: aload_3
    //   950: aload_0
    //   951: getfield 571	org/bouncycastle/x509/PKIXCertPathReviewer:validDate	Ljava/util/Date;
    //   954: invokevirtual 707	java/security/cert/X509Certificate:checkValidity	(Ljava/util/Date;)V
    //   957: goto +77 -> 1034
    //   960: new 201	org/bouncycastle/i18n/ErrorBundle
    //   963: dup
    //   964: ldc 11
    //   966: ldc_w 709
    //   969: iconst_1
    //   970: anewarray 205	java/lang/Object
    //   973: dup
    //   974: iconst_0
    //   975: new 569	org/bouncycastle/i18n/filter/TrustedInput
    //   978: dup
    //   979: aload_3
    //   980: invokevirtual 713	java/security/cert/X509Certificate:getNotAfter	()Ljava/util/Date;
    //   983: invokespecial 572	org/bouncycastle/i18n/filter/TrustedInput:<init>	(Ljava/lang/Object;)V
    //   986: aastore
    //   987: invokespecial 220	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   990: astore 8
    //   992: goto +35 -> 1027
    //   995: new 201	org/bouncycastle/i18n/ErrorBundle
    //   998: dup
    //   999: ldc 11
    //   1001: ldc_w 715
    //   1004: iconst_1
    //   1005: anewarray 205	java/lang/Object
    //   1008: dup
    //   1009: iconst_0
    //   1010: new 569	org/bouncycastle/i18n/filter/TrustedInput
    //   1013: dup
    //   1014: aload_3
    //   1015: invokevirtual 718	java/security/cert/X509Certificate:getNotBefore	()Ljava/util/Date;
    //   1018: invokespecial 572	org/bouncycastle/i18n/filter/TrustedInput:<init>	(Ljava/lang/Object;)V
    //   1021: aastore
    //   1022: invokespecial 220	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1025: astore 8
    //   1027: aload_0
    //   1028: aload 8
    //   1030: iload_1
    //   1031: invokevirtual 241	org/bouncycastle/x509/PKIXCertPathReviewer:addError	(Lorg/bouncycastle/i18n/ErrorBundle;I)V
    //   1034: aload_0
    //   1035: getfield 106	org/bouncycastle/x509/PKIXCertPathReviewer:pkixParams	Ljava/security/cert/PKIXParameters;
    //   1038: invokevirtual 721	java/security/cert/PKIXParameters:isRevocationEnabled	()Z
    //   1041: ifeq +289 -> 1330
    //   1044: aload_3
    //   1045: getstatic 53	org/bouncycastle/x509/PKIXCertPathReviewer:CRL_DIST_POINTS	Ljava/lang/String;
    //   1048: invokestatic 304	org/bouncycastle/x509/PKIXCertPathReviewer:getExtensionValue	(Ljava/security/cert/X509Extension;Ljava/lang/String;)Lorg/bouncycastle/asn1/ASN1Primitive;
    //   1051: astore 8
    //   1053: aload 8
    //   1055: ifnull +13 -> 1068
    //   1058: aload 8
    //   1060: invokestatic 726	org/bouncycastle/asn1/x509/CRLDistPoint:getInstance	(Ljava/lang/Object;)Lorg/bouncycastle/asn1/x509/CRLDistPoint;
    //   1063: astore 8
    //   1065: goto +29 -> 1094
    //   1068: aconst_null
    //   1069: astore 8
    //   1071: goto +23 -> 1094
    //   1074: aload_0
    //   1075: new 201	org/bouncycastle/i18n/ErrorBundle
    //   1078: dup
    //   1079: ldc 11
    //   1081: ldc_w 728
    //   1084: invokespecial 334	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1087: iload_1
    //   1088: invokevirtual 241	org/bouncycastle/x509/PKIXCertPathReviewer:addError	(Lorg/bouncycastle/i18n/ErrorBundle;I)V
    //   1091: goto -23 -> 1068
    //   1094: aload_3
    //   1095: getstatic 58	org/bouncycastle/x509/PKIXCertPathReviewer:AUTH_INFO_ACCESS	Ljava/lang/String;
    //   1098: invokestatic 304	org/bouncycastle/x509/PKIXCertPathReviewer:getExtensionValue	(Ljava/security/cert/X509Extension;Ljava/lang/String;)Lorg/bouncycastle/asn1/ASN1Primitive;
    //   1101: astore 9
    //   1103: aload 9
    //   1105: ifnull +30 -> 1135
    //   1108: aload 9
    //   1110: invokestatic 733	org/bouncycastle/asn1/x509/AuthorityInformationAccess:getInstance	(Ljava/lang/Object;)Lorg/bouncycastle/asn1/x509/AuthorityInformationAccess;
    //   1113: astore 9
    //   1115: goto +23 -> 1138
    //   1118: aload_0
    //   1119: new 201	org/bouncycastle/i18n/ErrorBundle
    //   1122: dup
    //   1123: ldc 11
    //   1125: ldc_w 735
    //   1128: invokespecial 334	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1131: iload_1
    //   1132: invokevirtual 241	org/bouncycastle/x509/PKIXCertPathReviewer:addError	(Lorg/bouncycastle/i18n/ErrorBundle;I)V
    //   1135: aconst_null
    //   1136: astore 9
    //   1138: aload_0
    //   1139: aload 8
    //   1141: invokevirtual 739	org/bouncycastle/x509/PKIXCertPathReviewer:getCRLDistUrls	(Lorg/bouncycastle/asn1/x509/CRLDistPoint;)Ljava/util/Vector;
    //   1144: astore 10
    //   1146: aload_0
    //   1147: aload 9
    //   1149: invokevirtual 743	org/bouncycastle/x509/PKIXCertPathReviewer:getOCSPUrls	(Lorg/bouncycastle/asn1/x509/AuthorityInformationAccess;)Ljava/util/Vector;
    //   1152: astore 9
    //   1154: aload 10
    //   1156: invokevirtual 746	java/util/Vector:iterator	()Ljava/util/Iterator;
    //   1159: astore 8
    //   1161: aload 8
    //   1163: invokeinterface 124 1 0
    //   1168: ifeq +44 -> 1212
    //   1171: aload_0
    //   1172: new 201	org/bouncycastle/i18n/ErrorBundle
    //   1175: dup
    //   1176: ldc 11
    //   1178: ldc_w 748
    //   1181: iconst_1
    //   1182: anewarray 205	java/lang/Object
    //   1185: dup
    //   1186: iconst_0
    //   1187: new 750	org/bouncycastle/i18n/filter/UntrustedUrlInput
    //   1190: dup
    //   1191: aload 8
    //   1193: invokeinterface 128 1 0
    //   1198: invokespecial 751	org/bouncycastle/i18n/filter/UntrustedUrlInput:<init>	(Ljava/lang/Object;)V
    //   1201: aastore
    //   1202: invokespecial 220	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1205: iload_1
    //   1206: invokevirtual 753	org/bouncycastle/x509/PKIXCertPathReviewer:addNotification	(Lorg/bouncycastle/i18n/ErrorBundle;I)V
    //   1209: goto -48 -> 1161
    //   1212: aload 9
    //   1214: invokevirtual 746	java/util/Vector:iterator	()Ljava/util/Iterator;
    //   1217: astore 8
    //   1219: aload 8
    //   1221: invokeinterface 124 1 0
    //   1226: ifeq +44 -> 1270
    //   1229: aload_0
    //   1230: new 201	org/bouncycastle/i18n/ErrorBundle
    //   1233: dup
    //   1234: ldc 11
    //   1236: ldc_w 755
    //   1239: iconst_1
    //   1240: anewarray 205	java/lang/Object
    //   1243: dup
    //   1244: iconst_0
    //   1245: new 750	org/bouncycastle/i18n/filter/UntrustedUrlInput
    //   1248: dup
    //   1249: aload 8
    //   1251: invokeinterface 128 1 0
    //   1256: invokespecial 751	org/bouncycastle/i18n/filter/UntrustedUrlInput:<init>	(Ljava/lang/Object;)V
    //   1259: aastore
    //   1260: invokespecial 220	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1263: iload_1
    //   1264: invokevirtual 753	org/bouncycastle/x509/PKIXCertPathReviewer:addNotification	(Lorg/bouncycastle/i18n/ErrorBundle;I)V
    //   1267: goto -48 -> 1219
    //   1270: aload_0
    //   1271: getfield 106	org/bouncycastle/x509/PKIXCertPathReviewer:pkixParams	Ljava/security/cert/PKIXParameters;
    //   1274: astore 11
    //   1276: aload_0
    //   1277: getfield 571	org/bouncycastle/x509/PKIXCertPathReviewer:validDate	Ljava/util/Date;
    //   1280: astore 12
    //   1282: aload_3
    //   1283: astore 8
    //   1285: aload_0
    //   1286: aload 11
    //   1288: aload 8
    //   1290: aload 12
    //   1292: aload 7
    //   1294: aload 4
    //   1296: aload 10
    //   1298: aload 9
    //   1300: iload_1
    //   1301: invokevirtual 759	org/bouncycastle/x509/PKIXCertPathReviewer:checkRevocation	(Ljava/security/cert/PKIXParameters;Ljava/security/cert/X509Certificate;Ljava/util/Date;Ljava/security/cert/X509Certificate;Ljava/security/PublicKey;Ljava/util/Vector;Ljava/util/Vector;I)V
    //   1304: aload 8
    //   1306: astore_3
    //   1307: goto +23 -> 1330
    //   1310: astore 7
    //   1312: goto +5 -> 1317
    //   1315: astore 7
    //   1317: aload_0
    //   1318: aload 7
    //   1320: invokevirtual 250	org/bouncycastle/x509/CertPathReviewerException:getErrorMessage	()Lorg/bouncycastle/i18n/ErrorBundle;
    //   1323: iload_1
    //   1324: invokevirtual 241	org/bouncycastle/x509/PKIXCertPathReviewer:addError	(Lorg/bouncycastle/i18n/ErrorBundle;I)V
    //   1327: goto +3 -> 1330
    //   1330: aload 5
    //   1332: ifnull +57 -> 1389
    //   1335: aload_3
    //   1336: invokevirtual 590	java/security/cert/X509Certificate:getIssuerX500Principal	()Ljavax/security/auth/x500/X500Principal;
    //   1339: aload 5
    //   1341: invokevirtual 760	javax/security/auth/x500/X500Principal:equals	(Ljava/lang/Object;)Z
    //   1344: ifne +45 -> 1389
    //   1347: aload_0
    //   1348: new 201	org/bouncycastle/i18n/ErrorBundle
    //   1351: dup
    //   1352: ldc 11
    //   1354: ldc_w 762
    //   1357: iconst_2
    //   1358: anewarray 205	java/lang/Object
    //   1361: dup
    //   1362: iconst_0
    //   1363: aload 5
    //   1365: invokevirtual 337	javax/security/auth/x500/X500Principal:getName	()Ljava/lang/String;
    //   1368: aastore
    //   1369: dup
    //   1370: iconst_1
    //   1371: aload_3
    //   1372: invokevirtual 590	java/security/cert/X509Certificate:getIssuerX500Principal	()Ljavax/security/auth/x500/X500Principal;
    //   1375: invokevirtual 337	javax/security/auth/x500/X500Principal:getName	()Ljava/lang/String;
    //   1378: aastore
    //   1379: invokespecial 220	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1382: iload_1
    //   1383: invokevirtual 241	org/bouncycastle/x509/PKIXCertPathReviewer:addError	(Lorg/bouncycastle/i18n/ErrorBundle;I)V
    //   1386: goto +3 -> 1389
    //   1389: iload_2
    //   1390: aload_0
    //   1391: getfield 366	org/bouncycastle/x509/PKIXCertPathReviewer:n	I
    //   1394: if_icmpeq +155 -> 1549
    //   1397: aload_3
    //   1398: ifnull +31 -> 1429
    //   1401: aload_3
    //   1402: invokevirtual 765	java/security/cert/X509Certificate:getVersion	()I
    //   1405: iconst_1
    //   1406: if_icmpne +23 -> 1429
    //   1409: aload_0
    //   1410: new 201	org/bouncycastle/i18n/ErrorBundle
    //   1413: dup
    //   1414: ldc 11
    //   1416: ldc_w 767
    //   1419: invokespecial 334	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1422: iload_1
    //   1423: invokevirtual 241	org/bouncycastle/x509/PKIXCertPathReviewer:addError	(Lorg/bouncycastle/i18n/ErrorBundle;I)V
    //   1426: goto +3 -> 1429
    //   1429: aload_3
    //   1430: getstatic 182	org/bouncycastle/x509/PKIXCertPathReviewer:BASIC_CONSTRAINTS	Ljava/lang/String;
    //   1433: invokestatic 304	org/bouncycastle/x509/PKIXCertPathReviewer:getExtensionValue	(Ljava/security/cert/X509Extension;Ljava/lang/String;)Lorg/bouncycastle/asn1/ASN1Primitive;
    //   1436: invokestatic 376	org/bouncycastle/asn1/x509/BasicConstraints:getInstance	(Ljava/lang/Object;)Lorg/bouncycastle/asn1/x509/BasicConstraints;
    //   1439: astore 5
    //   1441: aload 5
    //   1443: ifnull +31 -> 1474
    //   1446: aload 5
    //   1448: invokevirtual 770	org/bouncycastle/asn1/x509/BasicConstraints:isCA	()Z
    //   1451: ifne +60 -> 1511
    //   1454: aload_0
    //   1455: new 201	org/bouncycastle/i18n/ErrorBundle
    //   1458: dup
    //   1459: ldc 11
    //   1461: ldc_w 767
    //   1464: invokespecial 334	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1467: iload_1
    //   1468: invokevirtual 241	org/bouncycastle/x509/PKIXCertPathReviewer:addError	(Lorg/bouncycastle/i18n/ErrorBundle;I)V
    //   1471: goto +40 -> 1511
    //   1474: aload_0
    //   1475: new 201	org/bouncycastle/i18n/ErrorBundle
    //   1478: dup
    //   1479: ldc 11
    //   1481: ldc_w 772
    //   1484: invokespecial 334	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1487: iload_1
    //   1488: invokevirtual 241	org/bouncycastle/x509/PKIXCertPathReviewer:addError	(Lorg/bouncycastle/i18n/ErrorBundle;I)V
    //   1491: goto +20 -> 1511
    //   1494: aload_0
    //   1495: new 201	org/bouncycastle/i18n/ErrorBundle
    //   1498: dup
    //   1499: ldc 11
    //   1501: ldc_w 774
    //   1504: invokespecial 334	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1507: iload_1
    //   1508: invokevirtual 241	org/bouncycastle/x509/PKIXCertPathReviewer:addError	(Lorg/bouncycastle/i18n/ErrorBundle;I)V
    //   1511: aload_3
    //   1512: invokevirtual 632	java/security/cert/X509Certificate:getKeyUsage	()[Z
    //   1515: astore 5
    //   1517: aload 5
    //   1519: ifnull +30 -> 1549
    //   1522: aload 5
    //   1524: iconst_5
    //   1525: baload
    //   1526: ifne +23 -> 1549
    //   1529: aload_0
    //   1530: new 201	org/bouncycastle/i18n/ErrorBundle
    //   1533: dup
    //   1534: ldc 11
    //   1536: ldc_w 776
    //   1539: invokespecial 334	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1542: iload_1
    //   1543: invokevirtual 241	org/bouncycastle/x509/PKIXCertPathReviewer:addError	(Lorg/bouncycastle/i18n/ErrorBundle;I)V
    //   1546: goto +3 -> 1549
    //   1549: aload_3
    //   1550: invokevirtual 779	java/security/cert/X509Certificate:getSubjectX500Principal	()Ljavax/security/auth/x500/X500Principal;
    //   1553: astore 8
    //   1555: aload_0
    //   1556: getfield 135	org/bouncycastle/x509/PKIXCertPathReviewer:certs	Ljava/util/List;
    //   1559: iload_1
    //   1560: invokestatic 783	org/bouncycastle/x509/PKIXCertPathReviewer:getNextWorkingKey	(Ljava/util/List;I)Ljava/security/PublicKey;
    //   1563: astore 5
    //   1565: aload 5
    //   1567: invokestatic 638	org/bouncycastle/x509/PKIXCertPathReviewer:getAlgorithmIdentifier	(Ljava/security/PublicKey;)Lorg/bouncycastle/asn1/x509/AlgorithmIdentifier;
    //   1570: astore 4
    //   1572: aload 4
    //   1574: invokevirtual 643	org/bouncycastle/asn1/x509/AlgorithmIdentifier:getAlgorithm	()Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;
    //   1577: pop
    //   1578: aload 4
    //   1580: invokevirtual 647	org/bouncycastle/asn1/x509/AlgorithmIdentifier:getParameters	()Lorg/bouncycastle/asn1/ASN1Encodable;
    //   1583: pop
    //   1584: aload 5
    //   1586: astore 4
    //   1588: goto +20 -> 1608
    //   1591: aload_0
    //   1592: new 201	org/bouncycastle/i18n/ErrorBundle
    //   1595: dup
    //   1596: ldc 11
    //   1598: ldc_w 785
    //   1601: invokespecial 334	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1604: iload_1
    //   1605: invokevirtual 241	org/bouncycastle/x509/PKIXCertPathReviewer:addError	(Lorg/bouncycastle/i18n/ErrorBundle;I)V
    //   1608: iload_1
    //   1609: iconst_1
    //   1610: isub
    //   1611: istore_1
    //   1612: aload_3
    //   1613: astore 7
    //   1615: aload 8
    //   1617: astore 5
    //   1619: goto -1009 -> 610
    //   1622: aload_0
    //   1623: aload 6
    //   1625: putfield 787	org/bouncycastle/x509/PKIXCertPathReviewer:trustAnchor	Ljava/security/cert/TrustAnchor;
    //   1628: aload_0
    //   1629: aload 4
    //   1631: putfield 789	org/bouncycastle/x509/PKIXCertPathReviewer:subjectPublicKey	Ljava/security/PublicKey;
    //   1634: return
    //   1635: astore 4
    //   1637: goto -1365 -> 272
    //   1640: astore 4
    //   1642: goto -1274 -> 368
    //   1645: astore_3
    //   1646: goto -1233 -> 413
    //   1649: astore 7
    //   1651: goto -1090 -> 561
    //   1654: astore 9
    //   1656: goto -714 -> 942
    //   1659: astore 8
    //   1661: goto -666 -> 995
    //   1664: astore 8
    //   1666: goto -706 -> 960
    //   1669: astore 8
    //   1671: goto -597 -> 1074
    //   1674: astore 9
    //   1676: goto -558 -> 1118
    //   1679: astore 5
    //   1681: goto -187 -> 1494
    //   1684: astore 5
    //   1686: goto -95 -> 1591
    //   1689: astore 4
    //   1691: aload 5
    //   1693: astore 4
    //   1695: goto -104 -> 1591
    //   1698: aconst_null
    //   1699: astore_3
    //   1700: goto -1332 -> 368
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1703	0	this	PKIXCertPathReviewer
    //   594	1018	1	i	int
    //   620	775	2	j	int
    //   89	1524	3	localObject1	Object
    //   1645	1	3	localIllegalArgumentException	IllegalArgumentException
    //   1699	1	3	localObject2	Object
    //   244	14	4	localPublicKey	PublicKey
    //   291	1	4	localObject3	Object
    //   296	1	4	localCertPathReviewerException1	CertPathReviewerException
    //   301	40	4	localObject4	Object
    //   355	6	4	localCertPathReviewerException2	CertPathReviewerException
    //   451	1179	4	localObject5	Object
    //   1635	1	4	localSignatureException	java.security.SignatureException
    //   1640	1	4	localException	Exception
    //   1689	1	4	localCertPathValidatorException1	CertPathValidatorException
    //   1693	1	4	localCertPathValidatorException2	CertPathValidatorException
    //   74	1544	5	localObject6	Object
    //   1679	1	5	localAnnotatedException1	AnnotatedException
    //   1684	8	5	localCertPathValidatorException3	CertPathValidatorException
    //   369	1255	6	localObject7	Object
    //   544	749	7	localObject8	Object
    //   1310	1	7	localCertPathReviewerException3	CertPathReviewerException
    //   1315	4	7	localCertPathReviewerException4	CertPathReviewerException
    //   1613	1	7	localObject9	Object
    //   1649	1	7	localCertPathValidatorException4	CertPathValidatorException
    //   656	31	8	localGeneralSecurityException1	java.security.GeneralSecurityException
    //   698	4	8	localErrorBundle	ErrorBundle
    //   752	31	8	localGeneralSecurityException2	java.security.GeneralSecurityException
    //   794	822	8	localObject10	Object
    //   1659	1	8	localCertificateNotYetValidException	java.security.cert.CertificateNotYetValidException
    //   1664	1	8	localCertificateExpiredException	java.security.cert.CertificateExpiredException
    //   1669	1	8	localAnnotatedException2	AnnotatedException
    //   823	476	9	localObject11	Object
    //   1654	1	9	localIOException	IOException
    //   1674	1	9	localAnnotatedException3	AnnotatedException
    //   845	452	10	localObject12	Object
    //   1274	13	11	localPKIXParameters	PKIXParameters
    //   1280	11	12	localDate	Date
    // Exception table:
    //   from	to	target	type
    //   230	246	291	finally
    //   249	255	291	finally
    //   255	269	291	finally
    //   272	288	291	finally
    //   230	246	296	org/bouncycastle/x509/CertPathReviewerException
    //   249	255	296	org/bouncycastle/x509/CertPathReviewerException
    //   255	269	296	org/bouncycastle/x509/CertPathReviewerException
    //   272	288	296	org/bouncycastle/x509/CertPathReviewerException
    //   51	147	301	finally
    //   150	212	301	finally
    //   215	230	301	finally
    //   51	147	355	org/bouncycastle/x509/CertPathReviewerException
    //   150	212	355	org/bouncycastle/x509/CertPathReviewerException
    //   215	230	355	org/bouncycastle/x509/CertPathReviewerException
    //   640	653	656	java/security/GeneralSecurityException
    //   717	749	752	java/security/GeneralSecurityException
    //   1285	1304	1310	org/bouncycastle/x509/CertPathReviewerException
    //   1270	1282	1315	org/bouncycastle/x509/CertPathReviewerException
    //   255	269	1635	java/security/SignatureException
    //   255	269	1640	java/lang/Exception
    //   388	394	1645	java/lang/IllegalArgumentException
    //   397	410	1645	java/lang/IllegalArgumentException
    //   540	558	1649	java/security/cert/CertPathValidatorException
    //   830	847	1654	java/io/IOException
    //   852	868	1654	java/io/IOException
    //   873	942	1654	java/io/IOException
    //   949	957	1659	java/security/cert/CertificateNotYetValidException
    //   949	957	1664	java/security/cert/CertificateExpiredException
    //   1044	1053	1669	org/bouncycastle/jce/provider/AnnotatedException
    //   1058	1065	1669	org/bouncycastle/jce/provider/AnnotatedException
    //   1094	1103	1674	org/bouncycastle/jce/provider/AnnotatedException
    //   1108	1115	1674	org/bouncycastle/jce/provider/AnnotatedException
    //   1429	1441	1679	org/bouncycastle/jce/provider/AnnotatedException
    //   1446	1471	1679	org/bouncycastle/jce/provider/AnnotatedException
    //   1474	1491	1679	org/bouncycastle/jce/provider/AnnotatedException
    //   1555	1565	1684	java/security/cert/CertPathValidatorException
    //   1565	1584	1689	java/security/cert/CertPathValidatorException
  }
  
  private X509CRL getCRL(String paramString)
    throws CertPathReviewerException
  {
    try
    {
      Object localObject = new URL(paramString);
      if (!((URL)localObject).getProtocol().equals("http")) {
        if (!((URL)localObject).getProtocol().equals("https")) {
          break label159;
        }
      }
      localObject = (HttpURLConnection)((URL)localObject).openConnection();
      ((HttpURLConnection)localObject).setUseCaches(false);
      ((HttpURLConnection)localObject).setDoInput(true);
      ((HttpURLConnection)localObject).connect();
      if (((HttpURLConnection)localObject).getResponseCode() == 200) {
        return (X509CRL)CertificateFactory.getInstance("X.509", "BC").generateCRL(((HttpURLConnection)localObject).getInputStream());
      }
      throw new Exception(((HttpURLConnection)localObject).getResponseMessage());
    }
    catch (Exception localException)
    {
      throw new CertPathReviewerException(new ErrorBundle("org.bouncycastle.x509.CertPathReviewerMessages", "CertPathReviewer.loadCrlDistPointError", new Object[] { new UntrustedInput(paramString), localException.getMessage(), localException, localException.getClass().getName() }));
    }
    label159:
    return null;
  }
  
  private boolean processQcStatements(X509Certificate paramX509Certificate, int paramInt)
  {
    try
    {
      ASN1Sequence localASN1Sequence = (ASN1Sequence)getExtensionValue(paramX509Certificate, QC_STATEMENT);
      int i = 0;
      int j = 0;
      while (i < localASN1Sequence.size())
      {
        paramX509Certificate = QCStatement.getInstance(localASN1Sequence.getObjectAt(i));
        if (QCStatement.id_etsi_qcs_QcCompliance.equals(paramX509Certificate.getStatementId())) {}
        for (paramX509Certificate = new ErrorBundle("org.bouncycastle.x509.CertPathReviewerMessages", "CertPathReviewer.QcEuCompliance");; paramX509Certificate = new ErrorBundle("org.bouncycastle.x509.CertPathReviewerMessages", "CertPathReviewer.QcSSCD"))
        {
          addNotification(paramX509Certificate, paramInt);
          break label332;
          if (QCStatement.id_qcs_pkixQCSyntax_v1.equals(paramX509Certificate.getStatementId())) {
            break label332;
          }
          if (!QCStatement.id_etsi_qcs_QcSSCD.equals(paramX509Certificate.getStatementId())) {
            break;
          }
        }
        if (QCStatement.id_etsi_qcs_LimiteValue.equals(paramX509Certificate.getStatementId()))
        {
          paramX509Certificate = MonetaryValue.getInstance(paramX509Certificate.getStatementInfo());
          paramX509Certificate.getCurrency();
          double d = paramX509Certificate.getAmount().doubleValue() * Math.pow(10.0D, paramX509Certificate.getExponent().doubleValue());
          if (paramX509Certificate.getCurrency().isAlphabetic()) {
            paramX509Certificate = new ErrorBundle("org.bouncycastle.x509.CertPathReviewerMessages", "CertPathReviewer.QcLimitValueAlpha", new Object[] { paramX509Certificate.getCurrency().getAlphabetic(), new TrustedInput(new Double(d)), paramX509Certificate });
          } else {
            paramX509Certificate = new ErrorBundle("org.bouncycastle.x509.CertPathReviewerMessages", "CertPathReviewer.QcLimitValueNum", new Object[] { Integers.valueOf(paramX509Certificate.getCurrency().getNumeric()), new TrustedInput(new Double(d)), paramX509Certificate });
          }
          addNotification(paramX509Certificate, paramInt);
        }
        else
        {
          addNotification(new ErrorBundle("org.bouncycastle.x509.CertPathReviewerMessages", "CertPathReviewer.QcUnknownStatement", new Object[] { paramX509Certificate.getStatementId(), new UntrustedInput(paramX509Certificate) }), paramInt);
          j = 1;
        }
        label332:
        i += 1;
      }
      return 0x1 ^ j;
    }
    catch (AnnotatedException paramX509Certificate)
    {
      for (;;) {}
    }
    addError(new ErrorBundle("org.bouncycastle.x509.CertPathReviewerMessages", "CertPathReviewer.QcStatementExtError"), paramInt);
    return false;
  }
  
  protected void addError(ErrorBundle paramErrorBundle)
  {
    this.errors[0].add(paramErrorBundle);
  }
  
  protected void addError(ErrorBundle paramErrorBundle, int paramInt)
  {
    if ((paramInt >= -1) && (paramInt < this.n))
    {
      this.errors[(paramInt + 1)].add(paramErrorBundle);
      return;
    }
    throw new IndexOutOfBoundsException();
  }
  
  protected void addNotification(ErrorBundle paramErrorBundle)
  {
    this.notifications[0].add(paramErrorBundle);
  }
  
  protected void addNotification(ErrorBundle paramErrorBundle, int paramInt)
  {
    if ((paramInt >= -1) && (paramInt < this.n))
    {
      this.notifications[(paramInt + 1)].add(paramErrorBundle);
      return;
    }
    throw new IndexOutOfBoundsException();
  }
  
  /* Error */
  protected void checkCRLs(PKIXParameters arg1, X509Certificate arg2, Date arg3, X509Certificate arg4, PublicKey arg5, Vector arg6, int arg7)
    throws CertPathReviewerException
  {
    // Byte code:
    //   0: new 935	org/bouncycastle/x509/X509CRLStoreSelector
    //   3: dup
    //   4: invokespecial 936	org/bouncycastle/x509/X509CRLStoreSelector:<init>	()V
    //   7: astore 10
    //   9: aload 10
    //   11: aload_2
    //   12: invokestatic 940	org/bouncycastle/x509/PKIXCertPathReviewer:getEncodedIssuerPrincipal	(Ljava/lang/Object;)Ljavax/security/auth/x500/X500Principal;
    //   15: invokevirtual 281	javax/security/auth/x500/X500Principal:getEncoded	()[B
    //   18: invokevirtual 943	org/bouncycastle/x509/X509CRLStoreSelector:addIssuerName	([B)V
    //   21: aload 10
    //   23: aload_2
    //   24: invokevirtual 947	org/bouncycastle/x509/X509CRLStoreSelector:setCertificateChecking	(Ljava/security/cert/X509Certificate;)V
    //   27: getstatic 951	org/bouncycastle/x509/PKIXCertPathReviewer:CRL_UTIL	Lorg/bouncycastle/x509/PKIXCRLUtil;
    //   30: aload 10
    //   32: aload_1
    //   33: invokevirtual 957	org/bouncycastle/x509/PKIXCRLUtil:findCRLs	(Lorg/bouncycastle/x509/X509CRLStoreSelector;Ljava/security/cert/PKIXParameters;)Ljava/util/Set;
    //   36: astore 12
    //   38: aload 12
    //   40: invokeinterface 595 1 0
    //   45: astore 11
    //   47: aload 12
    //   49: invokeinterface 591 1 0
    //   54: ifeq +136 -> 190
    //   57: getstatic 951	org/bouncycastle/x509/PKIXCertPathReviewer:CRL_UTIL	Lorg/bouncycastle/x509/PKIXCRLUtil;
    //   60: new 935	org/bouncycastle/x509/X509CRLStoreSelector
    //   63: dup
    //   64: invokespecial 936	org/bouncycastle/x509/X509CRLStoreSelector:<init>	()V
    //   67: aload_1
    //   68: invokevirtual 957	org/bouncycastle/x509/PKIXCRLUtil:findCRLs	(Lorg/bouncycastle/x509/X509CRLStoreSelector;Ljava/security/cert/PKIXParameters;)Ljava/util/Set;
    //   71: invokeinterface 595 1 0
    //   76: astore 12
    //   78: new 406	java/util/ArrayList
    //   81: dup
    //   82: invokespecial 407	java/util/ArrayList:<init>	()V
    //   85: astore 13
    //   87: aload 12
    //   89: invokeinterface 124 1 0
    //   94: ifeq +27 -> 121
    //   97: aload 13
    //   99: aload 12
    //   101: invokeinterface 128 1 0
    //   106: checkcast 838	java/security/cert/X509CRL
    //   109: invokevirtual 958	java/security/cert/X509CRL:getIssuerX500Principal	()Ljavax/security/auth/x500/X500Principal;
    //   112: invokeinterface 421 2 0
    //   117: pop
    //   118: goto -31 -> 87
    //   121: aload 13
    //   123: invokeinterface 139 1 0
    //   128: istore 8
    //   130: aload_0
    //   131: new 201	org/bouncycastle/i18n/ErrorBundle
    //   134: dup
    //   135: ldc 11
    //   137: ldc_w 960
    //   140: iconst_3
    //   141: anewarray 205	java/lang/Object
    //   144: dup
    //   145: iconst_0
    //   146: new 326	org/bouncycastle/i18n/filter/UntrustedInput
    //   149: dup
    //   150: aload 10
    //   152: invokevirtual 964	org/bouncycastle/x509/X509CRLStoreSelector:getIssuerNames	()Ljava/util/Collection;
    //   155: invokespecial 329	org/bouncycastle/i18n/filter/UntrustedInput:<init>	(Ljava/lang/Object;)V
    //   158: aastore
    //   159: dup
    //   160: iconst_1
    //   161: new 326	org/bouncycastle/i18n/filter/UntrustedInput
    //   164: dup
    //   165: aload 13
    //   167: invokespecial 329	org/bouncycastle/i18n/filter/UntrustedInput:<init>	(Ljava/lang/Object;)V
    //   170: aastore
    //   171: dup
    //   172: iconst_2
    //   173: iload 8
    //   175: invokestatic 395	org/bouncycastle/util/Integers:valueOf	(I)Ljava/lang/Integer;
    //   178: aastore
    //   179: invokespecial 220	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   182: iload 7
    //   184: invokevirtual 753	org/bouncycastle/x509/PKIXCertPathReviewer:addNotification	(Lorg/bouncycastle/i18n/ErrorBundle;I)V
    //   187: goto +3 -> 190
    //   190: goto +72 -> 262
    //   193: astore 10
    //   195: aload_0
    //   196: new 201	org/bouncycastle/i18n/ErrorBundle
    //   199: dup
    //   200: ldc 11
    //   202: ldc_w 966
    //   205: iconst_3
    //   206: anewarray 205	java/lang/Object
    //   209: dup
    //   210: iconst_0
    //   211: aload 10
    //   213: invokevirtual 967	org/bouncycastle/jce/provider/AnnotatedException:getCause	()Ljava/lang/Throwable;
    //   216: invokevirtual 622	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   219: aastore
    //   220: dup
    //   221: iconst_1
    //   222: aload 10
    //   224: invokevirtual 967	org/bouncycastle/jce/provider/AnnotatedException:getCause	()Ljava/lang/Throwable;
    //   227: aastore
    //   228: dup
    //   229: iconst_2
    //   230: aload 10
    //   232: invokevirtual 967	org/bouncycastle/jce/provider/AnnotatedException:getCause	()Ljava/lang/Throwable;
    //   235: invokevirtual 212	java/lang/Object:getClass	()Ljava/lang/Class;
    //   238: invokevirtual 217	java/lang/Class:getName	()Ljava/lang/String;
    //   241: aastore
    //   242: invokespecial 220	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   245: iload 7
    //   247: invokevirtual 241	org/bouncycastle/x509/PKIXCertPathReviewer:addError	(Lorg/bouncycastle/i18n/ErrorBundle;I)V
    //   250: new 406	java/util/ArrayList
    //   253: dup
    //   254: invokespecial 407	java/util/ArrayList:<init>	()V
    //   257: invokevirtual 968	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   260: astore 11
    //   262: aconst_null
    //   263: astore 10
    //   265: aload 11
    //   267: invokeinterface 124 1 0
    //   272: ifeq +154 -> 426
    //   275: aload 11
    //   277: invokeinterface 128 1 0
    //   282: checkcast 838	java/security/cert/X509CRL
    //   285: astore 10
    //   287: aload 10
    //   289: invokevirtual 971	java/security/cert/X509CRL:getNextUpdate	()Ljava/util/Date;
    //   292: ifnull +76 -> 368
    //   295: aload_1
    //   296: invokevirtual 974	java/security/cert/PKIXParameters:getDate	()Ljava/util/Date;
    //   299: aload 10
    //   301: invokevirtual 971	java/security/cert/X509CRL:getNextUpdate	()Ljava/util/Date;
    //   304: invokevirtual 978	java/util/Date:before	(Ljava/util/Date;)Z
    //   307: ifeq +6 -> 313
    //   310: goto +58 -> 368
    //   313: aload_0
    //   314: new 201	org/bouncycastle/i18n/ErrorBundle
    //   317: dup
    //   318: ldc 11
    //   320: ldc_w 980
    //   323: iconst_2
    //   324: anewarray 205	java/lang/Object
    //   327: dup
    //   328: iconst_0
    //   329: new 569	org/bouncycastle/i18n/filter/TrustedInput
    //   332: dup
    //   333: aload 10
    //   335: invokevirtual 983	java/security/cert/X509CRL:getThisUpdate	()Ljava/util/Date;
    //   338: invokespecial 572	org/bouncycastle/i18n/filter/TrustedInput:<init>	(Ljava/lang/Object;)V
    //   341: aastore
    //   342: dup
    //   343: iconst_1
    //   344: new 569	org/bouncycastle/i18n/filter/TrustedInput
    //   347: dup
    //   348: aload 10
    //   350: invokevirtual 971	java/security/cert/X509CRL:getNextUpdate	()Ljava/util/Date;
    //   353: invokespecial 572	org/bouncycastle/i18n/filter/TrustedInput:<init>	(Ljava/lang/Object;)V
    //   356: aastore
    //   357: invokespecial 220	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   360: iload 7
    //   362: invokevirtual 753	org/bouncycastle/x509/PKIXCertPathReviewer:addNotification	(Lorg/bouncycastle/i18n/ErrorBundle;I)V
    //   365: goto -100 -> 265
    //   368: aload_0
    //   369: new 201	org/bouncycastle/i18n/ErrorBundle
    //   372: dup
    //   373: ldc 11
    //   375: ldc_w 985
    //   378: iconst_2
    //   379: anewarray 205	java/lang/Object
    //   382: dup
    //   383: iconst_0
    //   384: new 569	org/bouncycastle/i18n/filter/TrustedInput
    //   387: dup
    //   388: aload 10
    //   390: invokevirtual 983	java/security/cert/X509CRL:getThisUpdate	()Ljava/util/Date;
    //   393: invokespecial 572	org/bouncycastle/i18n/filter/TrustedInput:<init>	(Ljava/lang/Object;)V
    //   396: aastore
    //   397: dup
    //   398: iconst_1
    //   399: new 569	org/bouncycastle/i18n/filter/TrustedInput
    //   402: dup
    //   403: aload 10
    //   405: invokevirtual 971	java/security/cert/X509CRL:getNextUpdate	()Ljava/util/Date;
    //   408: invokespecial 572	org/bouncycastle/i18n/filter/TrustedInput:<init>	(Ljava/lang/Object;)V
    //   411: aastore
    //   412: invokespecial 220	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   415: iload 7
    //   417: invokevirtual 753	org/bouncycastle/x509/PKIXCertPathReviewer:addNotification	(Lorg/bouncycastle/i18n/ErrorBundle;I)V
    //   420: iconst_1
    //   421: istore 8
    //   423: goto +6 -> 429
    //   426: iconst_0
    //   427: istore 8
    //   429: iload 8
    //   431: ifne +362 -> 793
    //   434: aload 6
    //   436: invokevirtual 746	java/util/Vector:iterator	()Ljava/util/Iterator;
    //   439: astore 11
    //   441: aload 10
    //   443: astore 6
    //   445: aload 11
    //   447: invokeinterface 124 1 0
    //   452: ifeq +338 -> 790
    //   455: aload 11
    //   457: invokeinterface 128 1 0
    //   462: checkcast 234	java/lang/String
    //   465: astore 12
    //   467: aload_0
    //   468: aload 12
    //   470: invokespecial 987	org/bouncycastle/x509/PKIXCertPathReviewer:getCRL	(Ljava/lang/String;)Ljava/security/cert/X509CRL;
    //   473: astore 10
    //   475: aload 10
    //   477: ifnull +291 -> 768
    //   480: aload_2
    //   481: invokevirtual 590	java/security/cert/X509Certificate:getIssuerX500Principal	()Ljavax/security/auth/x500/X500Principal;
    //   484: aload 10
    //   486: invokevirtual 958	java/security/cert/X509CRL:getIssuerX500Principal	()Ljavax/security/auth/x500/X500Principal;
    //   489: invokevirtual 760	javax/security/auth/x500/X500Principal:equals	(Ljava/lang/Object;)Z
    //   492: istore 9
    //   494: iload 9
    //   496: ifne +84 -> 580
    //   499: aload_0
    //   500: new 201	org/bouncycastle/i18n/ErrorBundle
    //   503: dup
    //   504: ldc 11
    //   506: ldc_w 989
    //   509: iconst_3
    //   510: anewarray 205	java/lang/Object
    //   513: dup
    //   514: iconst_0
    //   515: new 326	org/bouncycastle/i18n/filter/UntrustedInput
    //   518: dup
    //   519: aload 10
    //   521: invokevirtual 958	java/security/cert/X509CRL:getIssuerX500Principal	()Ljavax/security/auth/x500/X500Principal;
    //   524: invokevirtual 337	javax/security/auth/x500/X500Principal:getName	()Ljava/lang/String;
    //   527: invokespecial 329	org/bouncycastle/i18n/filter/UntrustedInput:<init>	(Ljava/lang/Object;)V
    //   530: aastore
    //   531: dup
    //   532: iconst_1
    //   533: new 326	org/bouncycastle/i18n/filter/UntrustedInput
    //   536: dup
    //   537: aload_2
    //   538: invokevirtual 590	java/security/cert/X509Certificate:getIssuerX500Principal	()Ljavax/security/auth/x500/X500Principal;
    //   541: invokevirtual 337	javax/security/auth/x500/X500Principal:getName	()Ljava/lang/String;
    //   544: invokespecial 329	org/bouncycastle/i18n/filter/UntrustedInput:<init>	(Ljava/lang/Object;)V
    //   547: aastore
    //   548: dup
    //   549: iconst_2
    //   550: new 750	org/bouncycastle/i18n/filter/UntrustedUrlInput
    //   553: dup
    //   554: aload 12
    //   556: invokespecial 751	org/bouncycastle/i18n/filter/UntrustedUrlInput:<init>	(Ljava/lang/Object;)V
    //   559: aastore
    //   560: invokespecial 220	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   563: iload 7
    //   565: invokevirtual 753	org/bouncycastle/x509/PKIXCertPathReviewer:addNotification	(Lorg/bouncycastle/i18n/ErrorBundle;I)V
    //   568: goto +203 -> 771
    //   571: astore 10
    //   573: goto +203 -> 776
    //   576: astore_1
    //   577: goto +199 -> 776
    //   580: aload 10
    //   582: invokevirtual 971	java/security/cert/X509CRL:getNextUpdate	()Ljava/util/Date;
    //   585: ifnull +96 -> 681
    //   588: aload_0
    //   589: getfield 106	org/bouncycastle/x509/PKIXCertPathReviewer:pkixParams	Ljava/security/cert/PKIXParameters;
    //   592: invokevirtual 974	java/security/cert/PKIXParameters:getDate	()Ljava/util/Date;
    //   595: aload 10
    //   597: invokevirtual 971	java/security/cert/X509CRL:getNextUpdate	()Ljava/util/Date;
    //   600: invokevirtual 978	java/util/Date:before	(Ljava/util/Date;)Z
    //   603: ifeq +6 -> 609
    //   606: goto +75 -> 681
    //   609: aload_0
    //   610: new 201	org/bouncycastle/i18n/ErrorBundle
    //   613: dup
    //   614: ldc 11
    //   616: ldc_w 991
    //   619: iconst_3
    //   620: anewarray 205	java/lang/Object
    //   623: dup
    //   624: iconst_0
    //   625: new 569	org/bouncycastle/i18n/filter/TrustedInput
    //   628: dup
    //   629: aload 10
    //   631: invokevirtual 983	java/security/cert/X509CRL:getThisUpdate	()Ljava/util/Date;
    //   634: invokespecial 572	org/bouncycastle/i18n/filter/TrustedInput:<init>	(Ljava/lang/Object;)V
    //   637: aastore
    //   638: dup
    //   639: iconst_1
    //   640: new 569	org/bouncycastle/i18n/filter/TrustedInput
    //   643: dup
    //   644: aload 10
    //   646: invokevirtual 971	java/security/cert/X509CRL:getNextUpdate	()Ljava/util/Date;
    //   649: invokespecial 572	org/bouncycastle/i18n/filter/TrustedInput:<init>	(Ljava/lang/Object;)V
    //   652: aastore
    //   653: dup
    //   654: iconst_2
    //   655: new 750	org/bouncycastle/i18n/filter/UntrustedUrlInput
    //   658: dup
    //   659: aload 12
    //   661: invokespecial 751	org/bouncycastle/i18n/filter/UntrustedUrlInput:<init>	(Ljava/lang/Object;)V
    //   664: aastore
    //   665: invokespecial 220	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   668: iload 7
    //   670: invokevirtual 753	org/bouncycastle/x509/PKIXCertPathReviewer:addNotification	(Lorg/bouncycastle/i18n/ErrorBundle;I)V
    //   673: goto +98 -> 771
    //   676: astore 10
    //   678: goto +98 -> 776
    //   681: aload_0
    //   682: new 201	org/bouncycastle/i18n/ErrorBundle
    //   685: dup
    //   686: ldc 11
    //   688: ldc_w 993
    //   691: iconst_3
    //   692: anewarray 205	java/lang/Object
    //   695: dup
    //   696: iconst_0
    //   697: new 569	org/bouncycastle/i18n/filter/TrustedInput
    //   700: dup
    //   701: aload 10
    //   703: invokevirtual 983	java/security/cert/X509CRL:getThisUpdate	()Ljava/util/Date;
    //   706: invokespecial 572	org/bouncycastle/i18n/filter/TrustedInput:<init>	(Ljava/lang/Object;)V
    //   709: aastore
    //   710: dup
    //   711: iconst_1
    //   712: new 569	org/bouncycastle/i18n/filter/TrustedInput
    //   715: dup
    //   716: aload 10
    //   718: invokevirtual 971	java/security/cert/X509CRL:getNextUpdate	()Ljava/util/Date;
    //   721: invokespecial 572	org/bouncycastle/i18n/filter/TrustedInput:<init>	(Ljava/lang/Object;)V
    //   724: aastore
    //   725: dup
    //   726: iconst_2
    //   727: new 750	org/bouncycastle/i18n/filter/UntrustedUrlInput
    //   730: dup
    //   731: aload 12
    //   733: invokespecial 751	org/bouncycastle/i18n/filter/UntrustedUrlInput:<init>	(Ljava/lang/Object;)V
    //   736: aastore
    //   737: invokespecial 220	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   740: iload 7
    //   742: invokevirtual 753	org/bouncycastle/x509/PKIXCertPathReviewer:addNotification	(Lorg/bouncycastle/i18n/ErrorBundle;I)V
    //   745: aload 10
    //   747: astore 6
    //   749: iconst_1
    //   750: istore 8
    //   752: goto +45 -> 797
    //   755: astore 10
    //   757: iconst_1
    //   758: istore 8
    //   760: goto +16 -> 776
    //   763: astore 10
    //   765: goto +11 -> 776
    //   768: goto -200 -> 568
    //   771: goto -326 -> 445
    //   774: astore 10
    //   776: aload_0
    //   777: aload 10
    //   779: invokevirtual 250	org/bouncycastle/x509/CertPathReviewerException:getErrorMessage	()Lorg/bouncycastle/i18n/ErrorBundle;
    //   782: iload 7
    //   784: invokevirtual 753	org/bouncycastle/x509/PKIXCertPathReviewer:addNotification	(Lorg/bouncycastle/i18n/ErrorBundle;I)V
    //   787: goto -342 -> 445
    //   790: goto +7 -> 797
    //   793: aload 10
    //   795: astore 6
    //   797: aload 6
    //   799: ifnull +888 -> 1687
    //   802: aload 4
    //   804: ifnull +54 -> 858
    //   807: aload 4
    //   809: invokevirtual 632	java/security/cert/X509Certificate:getKeyUsage	()[Z
    //   812: astore 4
    //   814: aload 4
    //   816: ifnull +42 -> 858
    //   819: aload 4
    //   821: arraylength
    //   822: bipush 7
    //   824: if_icmplt +14 -> 838
    //   827: aload 4
    //   829: bipush 6
    //   831: baload
    //   832: ifeq +6 -> 838
    //   835: goto +23 -> 858
    //   838: new 65	org/bouncycastle/x509/CertPathReviewerException
    //   841: dup
    //   842: new 201	org/bouncycastle/i18n/ErrorBundle
    //   845: dup
    //   846: ldc 11
    //   848: ldc_w 995
    //   851: invokespecial 334	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   854: invokespecial 499	org/bouncycastle/x509/CertPathReviewerException:<init>	(Lorg/bouncycastle/i18n/ErrorBundle;)V
    //   857: athrow
    //   858: aload 5
    //   860: ifnull +807 -> 1667
    //   863: aload 6
    //   865: aload 5
    //   867: ldc_w 823
    //   870: invokevirtual 999	java/security/cert/X509CRL:verify	(Ljava/security/PublicKey;Ljava/lang/String;)V
    //   873: aload 6
    //   875: aload_2
    //   876: invokevirtual 1002	java/security/cert/X509Certificate:getSerialNumber	()Ljava/math/BigInteger;
    //   879: invokevirtual 1006	java/security/cert/X509CRL:getRevokedCertificate	(Ljava/math/BigInteger;)Ljava/security/cert/X509CRLEntry;
    //   882: astore 10
    //   884: aload 10
    //   886: ifnull +205 -> 1091
    //   889: aload 10
    //   891: invokevirtual 1011	java/security/cert/X509CRLEntry:hasExtensions	()Z
    //   894: ifeq +63 -> 957
    //   897: aload 10
    //   899: getstatic 1014	org/bouncycastle/asn1/x509/X509Extensions:ReasonCode	Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;
    //   902: invokevirtual 46	org/bouncycastle/asn1/ASN1ObjectIdentifier:getId	()Ljava/lang/String;
    //   905: invokestatic 304	org/bouncycastle/x509/PKIXCertPathReviewer:getExtensionValue	(Ljava/security/cert/X509Extension;Ljava/lang/String;)Lorg/bouncycastle/asn1/ASN1Primitive;
    //   908: invokestatic 1019	org/bouncycastle/asn1/ASN1Enumerated:getInstance	(Ljava/lang/Object;)Lorg/bouncycastle/asn1/ASN1Enumerated;
    //   911: astore 4
    //   913: aload 4
    //   915: ifnull +42 -> 957
    //   918: getstatic 1023	org/bouncycastle/x509/PKIXCertPathReviewer:crlReasons	[Ljava/lang/String;
    //   921: aload 4
    //   923: invokevirtual 1024	org/bouncycastle/asn1/ASN1Enumerated:getValue	()Ljava/math/BigInteger;
    //   926: invokevirtual 387	java/math/BigInteger:intValue	()I
    //   929: aaload
    //   930: astore 4
    //   932: goto +28 -> 960
    //   935: astore_1
    //   936: new 65	org/bouncycastle/x509/CertPathReviewerException
    //   939: dup
    //   940: new 201	org/bouncycastle/i18n/ErrorBundle
    //   943: dup
    //   944: ldc 11
    //   946: ldc_w 1026
    //   949: invokespecial 334	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   952: aload_1
    //   953: invokespecial 246	org/bouncycastle/x509/CertPathReviewerException:<init>	(Lorg/bouncycastle/i18n/ErrorBundle;Ljava/lang/Throwable;)V
    //   956: athrow
    //   957: aconst_null
    //   958: astore 4
    //   960: aload 4
    //   962: astore 5
    //   964: aload 4
    //   966: ifnonnull +11 -> 977
    //   969: getstatic 1023	org/bouncycastle/x509/PKIXCertPathReviewer:crlReasons	[Ljava/lang/String;
    //   972: bipush 7
    //   974: aaload
    //   975: astore 5
    //   977: new 688	org/bouncycastle/i18n/LocaleString
    //   980: dup
    //   981: ldc 11
    //   983: aload 5
    //   985: invokespecial 691	org/bouncycastle/i18n/LocaleString:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   988: astore 4
    //   990: aload_3
    //   991: aload 10
    //   993: invokevirtual 1029	java/security/cert/X509CRLEntry:getRevocationDate	()Ljava/util/Date;
    //   996: invokevirtual 978	java/util/Date:before	(Ljava/util/Date;)Z
    //   999: ifeq +48 -> 1047
    //   1002: aload_0
    //   1003: new 201	org/bouncycastle/i18n/ErrorBundle
    //   1006: dup
    //   1007: ldc 11
    //   1009: ldc_w 1031
    //   1012: iconst_2
    //   1013: anewarray 205	java/lang/Object
    //   1016: dup
    //   1017: iconst_0
    //   1018: new 569	org/bouncycastle/i18n/filter/TrustedInput
    //   1021: dup
    //   1022: aload 10
    //   1024: invokevirtual 1029	java/security/cert/X509CRLEntry:getRevocationDate	()Ljava/util/Date;
    //   1027: invokespecial 572	org/bouncycastle/i18n/filter/TrustedInput:<init>	(Ljava/lang/Object;)V
    //   1030: aastore
    //   1031: dup
    //   1032: iconst_1
    //   1033: aload 4
    //   1035: aastore
    //   1036: invokespecial 220	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1039: iload 7
    //   1041: invokevirtual 753	org/bouncycastle/x509/PKIXCertPathReviewer:addNotification	(Lorg/bouncycastle/i18n/ErrorBundle;I)V
    //   1044: goto +65 -> 1109
    //   1047: new 65	org/bouncycastle/x509/CertPathReviewerException
    //   1050: dup
    //   1051: new 201	org/bouncycastle/i18n/ErrorBundle
    //   1054: dup
    //   1055: ldc 11
    //   1057: ldc_w 1033
    //   1060: iconst_2
    //   1061: anewarray 205	java/lang/Object
    //   1064: dup
    //   1065: iconst_0
    //   1066: new 569	org/bouncycastle/i18n/filter/TrustedInput
    //   1069: dup
    //   1070: aload 10
    //   1072: invokevirtual 1029	java/security/cert/X509CRLEntry:getRevocationDate	()Ljava/util/Date;
    //   1075: invokespecial 572	org/bouncycastle/i18n/filter/TrustedInput:<init>	(Ljava/lang/Object;)V
    //   1078: aastore
    //   1079: dup
    //   1080: iconst_1
    //   1081: aload 4
    //   1083: aastore
    //   1084: invokespecial 220	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1087: invokespecial 499	org/bouncycastle/x509/CertPathReviewerException:<init>	(Lorg/bouncycastle/i18n/ErrorBundle;)V
    //   1090: athrow
    //   1091: aload_0
    //   1092: new 201	org/bouncycastle/i18n/ErrorBundle
    //   1095: dup
    //   1096: ldc 11
    //   1098: ldc_w 1035
    //   1101: invokespecial 334	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1104: iload 7
    //   1106: invokevirtual 753	org/bouncycastle/x509/PKIXCertPathReviewer:addNotification	(Lorg/bouncycastle/i18n/ErrorBundle;I)V
    //   1109: aload 6
    //   1111: invokevirtual 971	java/security/cert/X509CRL:getNextUpdate	()Ljava/util/Date;
    //   1114: ifnull +61 -> 1175
    //   1117: aload 6
    //   1119: invokevirtual 971	java/security/cert/X509CRL:getNextUpdate	()Ljava/util/Date;
    //   1122: aload_0
    //   1123: getfield 106	org/bouncycastle/x509/PKIXCertPathReviewer:pkixParams	Ljava/security/cert/PKIXParameters;
    //   1126: invokevirtual 974	java/security/cert/PKIXParameters:getDate	()Ljava/util/Date;
    //   1129: invokevirtual 978	java/util/Date:before	(Ljava/util/Date;)Z
    //   1132: ifeq +43 -> 1175
    //   1135: aload_0
    //   1136: new 201	org/bouncycastle/i18n/ErrorBundle
    //   1139: dup
    //   1140: ldc 11
    //   1142: ldc_w 1037
    //   1145: iconst_1
    //   1146: anewarray 205	java/lang/Object
    //   1149: dup
    //   1150: iconst_0
    //   1151: new 569	org/bouncycastle/i18n/filter/TrustedInput
    //   1154: dup
    //   1155: aload 6
    //   1157: invokevirtual 971	java/security/cert/X509CRL:getNextUpdate	()Ljava/util/Date;
    //   1160: invokespecial 572	org/bouncycastle/i18n/filter/TrustedInput:<init>	(Ljava/lang/Object;)V
    //   1163: aastore
    //   1164: invokespecial 220	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1167: iload 7
    //   1169: invokevirtual 753	org/bouncycastle/x509/PKIXCertPathReviewer:addNotification	(Lorg/bouncycastle/i18n/ErrorBundle;I)V
    //   1172: goto +3 -> 1175
    //   1175: aload 6
    //   1177: getstatic 173	org/bouncycastle/x509/PKIXCertPathReviewer:ISSUING_DISTRIBUTION_POINT	Ljava/lang/String;
    //   1180: invokestatic 304	org/bouncycastle/x509/PKIXCertPathReviewer:getExtensionValue	(Ljava/security/cert/X509Extension;Ljava/lang/String;)Lorg/bouncycastle/asn1/ASN1Primitive;
    //   1183: astore_3
    //   1184: aload 6
    //   1186: getstatic 176	org/bouncycastle/x509/PKIXCertPathReviewer:DELTA_CRL_INDICATOR	Ljava/lang/String;
    //   1189: invokestatic 304	org/bouncycastle/x509/PKIXCertPathReviewer:getExtensionValue	(Ljava/security/cert/X509Extension;Ljava/lang/String;)Lorg/bouncycastle/asn1/ASN1Primitive;
    //   1192: astore 4
    //   1194: aload 4
    //   1196: ifnull +255 -> 1451
    //   1199: new 935	org/bouncycastle/x509/X509CRLStoreSelector
    //   1202: dup
    //   1203: invokespecial 936	org/bouncycastle/x509/X509CRLStoreSelector:<init>	()V
    //   1206: astore 5
    //   1208: aload 5
    //   1210: aload 6
    //   1212: invokestatic 1041	org/bouncycastle/x509/PKIXCertPathReviewer:getIssuerPrincipal	(Ljava/security/cert/X509CRL;)Ljavax/security/auth/x500/X500Principal;
    //   1215: invokevirtual 281	javax/security/auth/x500/X500Principal:getEncoded	()[B
    //   1218: invokevirtual 943	org/bouncycastle/x509/X509CRLStoreSelector:addIssuerName	([B)V
    //   1221: aload 5
    //   1223: aload 4
    //   1225: checkcast 534	org/bouncycastle/asn1/ASN1Integer
    //   1228: invokevirtual 1044	org/bouncycastle/asn1/ASN1Integer:getPositiveValue	()Ljava/math/BigInteger;
    //   1231: invokevirtual 1048	org/bouncycastle/x509/X509CRLStoreSelector:setMinCRLNumber	(Ljava/math/BigInteger;)V
    //   1234: aload 5
    //   1236: aload 6
    //   1238: getstatic 1051	org/bouncycastle/x509/PKIXCertPathReviewer:CRL_NUMBER	Ljava/lang/String;
    //   1241: invokestatic 304	org/bouncycastle/x509/PKIXCertPathReviewer:getExtensionValue	(Ljava/security/cert/X509Extension;Ljava/lang/String;)Lorg/bouncycastle/asn1/ASN1Primitive;
    //   1244: checkcast 534	org/bouncycastle/asn1/ASN1Integer
    //   1247: invokevirtual 1044	org/bouncycastle/asn1/ASN1Integer:getPositiveValue	()Ljava/math/BigInteger;
    //   1250: lconst_1
    //   1251: invokestatic 1054	java/math/BigInteger:valueOf	(J)Ljava/math/BigInteger;
    //   1254: invokevirtual 1058	java/math/BigInteger:subtract	(Ljava/math/BigInteger;)Ljava/math/BigInteger;
    //   1257: invokevirtual 1061	org/bouncycastle/x509/X509CRLStoreSelector:setMaxCRLNumber	(Ljava/math/BigInteger;)V
    //   1260: getstatic 951	org/bouncycastle/x509/PKIXCertPathReviewer:CRL_UTIL	Lorg/bouncycastle/x509/PKIXCRLUtil;
    //   1263: aload 5
    //   1265: aload_1
    //   1266: invokevirtual 957	org/bouncycastle/x509/PKIXCRLUtil:findCRLs	(Lorg/bouncycastle/x509/X509CRLStoreSelector;Ljava/security/cert/PKIXParameters;)Ljava/util/Set;
    //   1269: invokeinterface 230 1 0
    //   1274: astore_1
    //   1275: aload_1
    //   1276: invokeinterface 124 1 0
    //   1281: ifeq +73 -> 1354
    //   1284: aload_1
    //   1285: invokeinterface 128 1 0
    //   1290: checkcast 838	java/security/cert/X509CRL
    //   1293: astore 4
    //   1295: aload 4
    //   1297: getstatic 173	org/bouncycastle/x509/PKIXCertPathReviewer:ISSUING_DISTRIBUTION_POINT	Ljava/lang/String;
    //   1300: invokestatic 304	org/bouncycastle/x509/PKIXCertPathReviewer:getExtensionValue	(Ljava/security/cert/X509Extension;Ljava/lang/String;)Lorg/bouncycastle/asn1/ASN1Primitive;
    //   1303: astore 4
    //   1305: aload_3
    //   1306: ifnonnull +11 -> 1317
    //   1309: aload 4
    //   1311: ifnonnull -36 -> 1275
    //   1314: goto +12 -> 1326
    //   1317: aload_3
    //   1318: aload 4
    //   1320: invokevirtual 1064	org/bouncycastle/asn1/ASN1Primitive:equals	(Ljava/lang/Object;)Z
    //   1323: ifeq -48 -> 1275
    //   1326: iconst_1
    //   1327: istore 7
    //   1329: goto +28 -> 1357
    //   1332: astore_1
    //   1333: new 65	org/bouncycastle/x509/CertPathReviewerException
    //   1336: dup
    //   1337: new 201	org/bouncycastle/i18n/ErrorBundle
    //   1340: dup
    //   1341: ldc 11
    //   1343: ldc_w 1066
    //   1346: invokespecial 334	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1349: aload_1
    //   1350: invokespecial 246	org/bouncycastle/x509/CertPathReviewerException:<init>	(Lorg/bouncycastle/i18n/ErrorBundle;Ljava/lang/Throwable;)V
    //   1353: athrow
    //   1354: iconst_0
    //   1355: istore 7
    //   1357: iload 7
    //   1359: ifeq +6 -> 1365
    //   1362: goto +89 -> 1451
    //   1365: new 65	org/bouncycastle/x509/CertPathReviewerException
    //   1368: dup
    //   1369: new 201	org/bouncycastle/i18n/ErrorBundle
    //   1372: dup
    //   1373: ldc 11
    //   1375: ldc_w 1068
    //   1378: invokespecial 334	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1381: invokespecial 499	org/bouncycastle/x509/CertPathReviewerException:<init>	(Lorg/bouncycastle/i18n/ErrorBundle;)V
    //   1384: athrow
    //   1385: astore_1
    //   1386: new 65	org/bouncycastle/x509/CertPathReviewerException
    //   1389: dup
    //   1390: new 201	org/bouncycastle/i18n/ErrorBundle
    //   1393: dup
    //   1394: ldc 11
    //   1396: ldc_w 966
    //   1399: invokespecial 334	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1402: aload_1
    //   1403: invokespecial 246	org/bouncycastle/x509/CertPathReviewerException:<init>	(Lorg/bouncycastle/i18n/ErrorBundle;Ljava/lang/Throwable;)V
    //   1406: athrow
    //   1407: astore_1
    //   1408: new 65	org/bouncycastle/x509/CertPathReviewerException
    //   1411: dup
    //   1412: new 201	org/bouncycastle/i18n/ErrorBundle
    //   1415: dup
    //   1416: ldc 11
    //   1418: ldc_w 1070
    //   1421: invokespecial 334	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1424: aload_1
    //   1425: invokespecial 246	org/bouncycastle/x509/CertPathReviewerException:<init>	(Lorg/bouncycastle/i18n/ErrorBundle;Ljava/lang/Throwable;)V
    //   1428: athrow
    //   1429: astore_1
    //   1430: new 65	org/bouncycastle/x509/CertPathReviewerException
    //   1433: dup
    //   1434: new 201	org/bouncycastle/i18n/ErrorBundle
    //   1437: dup
    //   1438: ldc 11
    //   1440: ldc_w 1072
    //   1443: invokespecial 334	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1446: aload_1
    //   1447: invokespecial 246	org/bouncycastle/x509/CertPathReviewerException:<init>	(Lorg/bouncycastle/i18n/ErrorBundle;Ljava/lang/Throwable;)V
    //   1450: athrow
    //   1451: aload_3
    //   1452: ifnull +235 -> 1687
    //   1455: aload_3
    //   1456: invokestatic 1077	org/bouncycastle/asn1/x509/IssuingDistributionPoint:getInstance	(Ljava/lang/Object;)Lorg/bouncycastle/asn1/x509/IssuingDistributionPoint;
    //   1459: astore_1
    //   1460: aload_2
    //   1461: getstatic 182	org/bouncycastle/x509/PKIXCertPathReviewer:BASIC_CONSTRAINTS	Ljava/lang/String;
    //   1464: invokestatic 304	org/bouncycastle/x509/PKIXCertPathReviewer:getExtensionValue	(Ljava/security/cert/X509Extension;Ljava/lang/String;)Lorg/bouncycastle/asn1/ASN1Primitive;
    //   1467: invokestatic 376	org/bouncycastle/asn1/x509/BasicConstraints:getInstance	(Ljava/lang/Object;)Lorg/bouncycastle/asn1/x509/BasicConstraints;
    //   1470: astore_2
    //   1471: aload_1
    //   1472: invokevirtual 1080	org/bouncycastle/asn1/x509/IssuingDistributionPoint:onlyContainsUserCerts	()Z
    //   1475: ifeq +37 -> 1512
    //   1478: aload_2
    //   1479: ifnull +33 -> 1512
    //   1482: aload_2
    //   1483: invokevirtual 770	org/bouncycastle/asn1/x509/BasicConstraints:isCA	()Z
    //   1486: ifne +6 -> 1492
    //   1489: goto +23 -> 1512
    //   1492: new 65	org/bouncycastle/x509/CertPathReviewerException
    //   1495: dup
    //   1496: new 201	org/bouncycastle/i18n/ErrorBundle
    //   1499: dup
    //   1500: ldc 11
    //   1502: ldc_w 1082
    //   1505: invokespecial 334	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1508: invokespecial 499	org/bouncycastle/x509/CertPathReviewerException:<init>	(Lorg/bouncycastle/i18n/ErrorBundle;)V
    //   1511: athrow
    //   1512: aload_1
    //   1513: invokevirtual 1085	org/bouncycastle/asn1/x509/IssuingDistributionPoint:onlyContainsCACerts	()Z
    //   1516: ifeq +37 -> 1553
    //   1519: aload_2
    //   1520: ifnull +13 -> 1533
    //   1523: aload_2
    //   1524: invokevirtual 770	org/bouncycastle/asn1/x509/BasicConstraints:isCA	()Z
    //   1527: ifeq +6 -> 1533
    //   1530: goto +23 -> 1553
    //   1533: new 65	org/bouncycastle/x509/CertPathReviewerException
    //   1536: dup
    //   1537: new 201	org/bouncycastle/i18n/ErrorBundle
    //   1540: dup
    //   1541: ldc 11
    //   1543: ldc_w 1087
    //   1546: invokespecial 334	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1549: invokespecial 499	org/bouncycastle/x509/CertPathReviewerException:<init>	(Lorg/bouncycastle/i18n/ErrorBundle;)V
    //   1552: athrow
    //   1553: aload_1
    //   1554: invokevirtual 1090	org/bouncycastle/asn1/x509/IssuingDistributionPoint:onlyContainsAttributeCerts	()Z
    //   1557: ifne +6 -> 1563
    //   1560: goto +127 -> 1687
    //   1563: new 65	org/bouncycastle/x509/CertPathReviewerException
    //   1566: dup
    //   1567: new 201	org/bouncycastle/i18n/ErrorBundle
    //   1570: dup
    //   1571: ldc 11
    //   1573: ldc_w 1092
    //   1576: invokespecial 334	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1579: invokespecial 499	org/bouncycastle/x509/CertPathReviewerException:<init>	(Lorg/bouncycastle/i18n/ErrorBundle;)V
    //   1582: athrow
    //   1583: astore_1
    //   1584: new 65	org/bouncycastle/x509/CertPathReviewerException
    //   1587: dup
    //   1588: new 201	org/bouncycastle/i18n/ErrorBundle
    //   1591: dup
    //   1592: ldc 11
    //   1594: ldc_w 1094
    //   1597: invokespecial 334	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1600: aload_1
    //   1601: invokespecial 246	org/bouncycastle/x509/CertPathReviewerException:<init>	(Lorg/bouncycastle/i18n/ErrorBundle;Ljava/lang/Throwable;)V
    //   1604: athrow
    //   1605: new 65	org/bouncycastle/x509/CertPathReviewerException
    //   1608: dup
    //   1609: new 201	org/bouncycastle/i18n/ErrorBundle
    //   1612: dup
    //   1613: ldc 11
    //   1615: ldc_w 1096
    //   1618: invokespecial 334	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1621: invokespecial 499	org/bouncycastle/x509/CertPathReviewerException:<init>	(Lorg/bouncycastle/i18n/ErrorBundle;)V
    //   1624: athrow
    //   1625: new 65	org/bouncycastle/x509/CertPathReviewerException
    //   1628: dup
    //   1629: new 201	org/bouncycastle/i18n/ErrorBundle
    //   1632: dup
    //   1633: ldc 11
    //   1635: ldc_w 1066
    //   1638: invokespecial 334	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1641: invokespecial 499	org/bouncycastle/x509/CertPathReviewerException:<init>	(Lorg/bouncycastle/i18n/ErrorBundle;)V
    //   1644: athrow
    //   1645: astore_1
    //   1646: new 65	org/bouncycastle/x509/CertPathReviewerException
    //   1649: dup
    //   1650: new 201	org/bouncycastle/i18n/ErrorBundle
    //   1653: dup
    //   1654: ldc 11
    //   1656: ldc_w 1098
    //   1659: invokespecial 334	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1662: aload_1
    //   1663: invokespecial 246	org/bouncycastle/x509/CertPathReviewerException:<init>	(Lorg/bouncycastle/i18n/ErrorBundle;Ljava/lang/Throwable;)V
    //   1666: athrow
    //   1667: new 65	org/bouncycastle/x509/CertPathReviewerException
    //   1670: dup
    //   1671: new 201	org/bouncycastle/i18n/ErrorBundle
    //   1674: dup
    //   1675: ldc 11
    //   1677: ldc_w 1100
    //   1680: invokespecial 334	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1683: invokespecial 499	org/bouncycastle/x509/CertPathReviewerException:<init>	(Lorg/bouncycastle/i18n/ErrorBundle;)V
    //   1686: athrow
    //   1687: iload 8
    //   1689: ifeq +4 -> 1693
    //   1692: return
    //   1693: new 65	org/bouncycastle/x509/CertPathReviewerException
    //   1696: dup
    //   1697: new 201	org/bouncycastle/i18n/ErrorBundle
    //   1700: dup
    //   1701: ldc 11
    //   1703: ldc_w 1102
    //   1706: invokespecial 334	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1709: invokespecial 499	org/bouncycastle/x509/CertPathReviewerException:<init>	(Lorg/bouncycastle/i18n/ErrorBundle;)V
    //   1712: athrow
    //   1713: astore_1
    //   1714: new 65	org/bouncycastle/x509/CertPathReviewerException
    //   1717: dup
    //   1718: new 201	org/bouncycastle/i18n/ErrorBundle
    //   1721: dup
    //   1722: ldc 11
    //   1724: ldc_w 1072
    //   1727: invokespecial 334	org/bouncycastle/i18n/ErrorBundle:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1730: aload_1
    //   1731: invokespecial 246	org/bouncycastle/x509/CertPathReviewerException:<init>	(Lorg/bouncycastle/i18n/ErrorBundle;Ljava/lang/Throwable;)V
    //   1734: athrow
    //   1735: astore_1
    //   1736: goto -111 -> 1625
    //   1739: astore_1
    //   1740: goto -135 -> 1605
    // Exception table:
    //   from	to	target	type
    //   27	87	193	org/bouncycastle/jce/provider/AnnotatedException
    //   87	118	193	org/bouncycastle/jce/provider/AnnotatedException
    //   121	187	193	org/bouncycastle/jce/provider/AnnotatedException
    //   499	568	571	org/bouncycastle/x509/CertPathReviewerException
    //   609	673	676	org/bouncycastle/x509/CertPathReviewerException
    //   681	745	755	org/bouncycastle/x509/CertPathReviewerException
    //   580	606	763	org/bouncycastle/x509/CertPathReviewerException
    //   455	475	774	org/bouncycastle/x509/CertPathReviewerException
    //   480	494	774	org/bouncycastle/x509/CertPathReviewerException
    //   897	913	935	org/bouncycastle/jce/provider/AnnotatedException
    //   1295	1305	1332	org/bouncycastle/jce/provider/AnnotatedException
    //   1260	1275	1385	org/bouncycastle/jce/provider/AnnotatedException
    //   1234	1260	1407	org/bouncycastle/jce/provider/AnnotatedException
    //   1208	1221	1429	java/io/IOException
    //   1460	1471	1583	org/bouncycastle/jce/provider/AnnotatedException
    //   863	873	1645	java/lang/Exception
    //   9	21	1713	java/io/IOException
    //   1175	1184	1735	org/bouncycastle/jce/provider/AnnotatedException
    //   1184	1194	1739	org/bouncycastle/jce/provider/AnnotatedException
  }
  
  protected void checkRevocation(PKIXParameters paramPKIXParameters, X509Certificate paramX509Certificate1, Date paramDate, X509Certificate paramX509Certificate2, PublicKey paramPublicKey, Vector paramVector1, Vector paramVector2, int paramInt)
    throws CertPathReviewerException
  {
    checkCRLs(paramPKIXParameters, paramX509Certificate1, paramDate, paramX509Certificate2, paramPublicKey, paramVector1, paramInt);
  }
  
  protected void doChecks()
  {
    if (this.initialized)
    {
      if (this.notifications == null)
      {
        int i = this.n;
        this.notifications = new List[i + 1];
        this.errors = new List[i + 1];
        i = 0;
        for (;;)
        {
          List[] arrayOfList = this.notifications;
          if (i >= arrayOfList.length) {
            break;
          }
          arrayOfList[i] = new ArrayList();
          this.errors[i] = new ArrayList();
          i += 1;
        }
        checkSignatures();
        checkNameConstraints();
        checkPathLength();
        checkPolicy();
        checkCriticalExtensions();
      }
      return;
    }
    throw new IllegalStateException("Object not initialized. Call init() first.");
  }
  
  protected Vector getCRLDistUrls(CRLDistPoint paramCRLDistPoint)
  {
    Vector localVector = new Vector();
    if (paramCRLDistPoint != null)
    {
      paramCRLDistPoint = paramCRLDistPoint.getDistributionPoints();
      int i = 0;
      while (i < paramCRLDistPoint.length)
      {
        Object localObject = paramCRLDistPoint[i].getDistributionPoint();
        if (((DistributionPointName)localObject).getType() == 0)
        {
          localObject = GeneralNames.getInstance(((DistributionPointName)localObject).getName()).getNames();
          int j = 0;
          while (j < localObject.length)
          {
            if (localObject[j].getTagNo() == 6) {
              localVector.add(((DERIA5String)localObject[j].getName()).getString());
            }
            j += 1;
          }
        }
        i += 1;
      }
    }
    return localVector;
  }
  
  public CertPath getCertPath()
  {
    return this.certPath;
  }
  
  public int getCertPathSize()
  {
    return this.n;
  }
  
  public List getErrors(int paramInt)
  {
    doChecks();
    return this.errors[(paramInt + 1)];
  }
  
  public List[] getErrors()
  {
    doChecks();
    return this.errors;
  }
  
  public List getNotifications(int paramInt)
  {
    doChecks();
    return this.notifications[(paramInt + 1)];
  }
  
  public List[] getNotifications()
  {
    doChecks();
    return this.notifications;
  }
  
  protected Vector getOCSPUrls(AuthorityInformationAccess paramAuthorityInformationAccess)
  {
    Vector localVector = new Vector();
    if (paramAuthorityInformationAccess != null)
    {
      paramAuthorityInformationAccess = paramAuthorityInformationAccess.getAccessDescriptions();
      int i = 0;
      while (i < paramAuthorityInformationAccess.length)
      {
        if (paramAuthorityInformationAccess[i].getAccessMethod().equals(AccessDescription.id_ad_ocsp))
        {
          GeneralName localGeneralName = paramAuthorityInformationAccess[i].getAccessLocation();
          if (localGeneralName.getTagNo() == 6) {
            localVector.add(((DERIA5String)localGeneralName.getName()).getString());
          }
        }
        i += 1;
      }
    }
    return localVector;
  }
  
  public PolicyNode getPolicyTree()
  {
    doChecks();
    return this.policyTree;
  }
  
  public PublicKey getSubjectPublicKey()
  {
    doChecks();
    return this.subjectPublicKey;
  }
  
  public TrustAnchor getTrustAnchor()
  {
    doChecks();
    return this.trustAnchor;
  }
  
  protected Collection getTrustAnchors(X509Certificate paramX509Certificate, Set paramSet)
    throws CertPathReviewerException
  {
    ArrayList localArrayList = new ArrayList();
    paramSet = paramSet.iterator();
    X509CertSelector localX509CertSelector = new X509CertSelector();
    try
    {
      localX509CertSelector.setSubject(getEncodedIssuerPrincipal(paramX509Certificate).getEncoded());
      Object localObject = paramX509Certificate.getExtensionValue(X509Extensions.AuthorityKeyIdentifier.getId());
      if (localObject != null)
      {
        localObject = AuthorityKeyIdentifier.getInstance(ASN1Primitive.fromByteArray(((ASN1OctetString)ASN1Primitive.fromByteArray((byte[])localObject)).getOctets()));
        localX509CertSelector.setSerialNumber(((AuthorityKeyIdentifier)localObject).getAuthorityCertSerialNumber());
        localObject = ((AuthorityKeyIdentifier)localObject).getKeyIdentifier();
        if (localObject != null) {
          localX509CertSelector.setSubjectKeyIdentifier(new DEROctetString((byte[])localObject).getEncoded());
        }
      }
      while (paramSet.hasNext())
      {
        localObject = (TrustAnchor)paramSet.next();
        if (((TrustAnchor)localObject).getTrustedCert() != null) {
          if (!localX509CertSelector.match(((TrustAnchor)localObject).getTrustedCert())) {
            break;
          }
        } else {
          for (;;)
          {
            localArrayList.add(localObject);
            break;
            if ((((TrustAnchor)localObject).getCAName() == null) || (((TrustAnchor)localObject).getCAPublicKey() == null) || (!getEncodedIssuerPrincipal(paramX509Certificate).equals(new X500Principal(((TrustAnchor)localObject).getCAName())))) {
              break;
            }
          }
        }
      }
      return localArrayList;
    }
    catch (IOException paramX509Certificate)
    {
      for (;;) {}
    }
    throw new CertPathReviewerException(new ErrorBundle("org.bouncycastle.x509.CertPathReviewerMessages", "CertPathReviewer.trustAnchorIssuerError"));
  }
  
  public void init(CertPath paramCertPath, PKIXParameters paramPKIXParameters)
    throws CertPathReviewerException
  {
    if (!this.initialized)
    {
      this.initialized = true;
      if (paramCertPath != null)
      {
        this.certPath = paramCertPath;
        paramCertPath = paramCertPath.getCertificates();
        this.certs = paramCertPath;
        this.n = paramCertPath.size();
        if (!this.certs.isEmpty())
        {
          paramCertPath = (PKIXParameters)paramPKIXParameters.clone();
          this.pkixParams = paramCertPath;
          this.validDate = getValidDate(paramCertPath);
          this.notifications = null;
          this.errors = null;
          this.trustAnchor = null;
          this.subjectPublicKey = null;
          this.policyTree = null;
          return;
        }
        throw new CertPathReviewerException(new ErrorBundle("org.bouncycastle.x509.CertPathReviewerMessages", "CertPathReviewer.emptyCertPath"));
      }
      throw new NullPointerException("certPath was null");
    }
    throw new IllegalStateException("object is already initialized!");
  }
  
  public boolean isValidCertPath()
  {
    doChecks();
    int i = 0;
    for (;;)
    {
      List[] arrayOfList = this.errors;
      if (i >= arrayOfList.length) {
        break;
      }
      if (!arrayOfList[i].isEmpty()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\x509\PKIXCertPathReviewer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */