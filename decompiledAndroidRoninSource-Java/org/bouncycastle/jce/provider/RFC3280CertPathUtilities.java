package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PolicyNode;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLSelector;
import java.security.cert.X509Certificate;
import java.security.cert.X509Extension;
import java.text.SimpleDateFormat;
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
import java.util.TimeZone;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.asn1.x509.CRLDistPoint;
import org.bouncycastle.asn1.x509.DistributionPoint;
import org.bouncycastle.asn1.x509.DistributionPointName;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.GeneralSubtree;
import org.bouncycastle.asn1.x509.IssuingDistributionPoint;
import org.bouncycastle.asn1.x509.NameConstraints;
import org.bouncycastle.asn1.x509.PolicyInformation;
import org.bouncycastle.jcajce.PKIXCRLStore;
import org.bouncycastle.jcajce.PKIXCRLStoreSelector.Builder;
import org.bouncycastle.jcajce.PKIXExtendedParameters;
import org.bouncycastle.jcajce.PKIXExtendedParameters.Builder;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.exception.ExtCertPathValidatorException;
import org.bouncycastle.util.Arrays;

class RFC3280CertPathUtilities
{
  public static final String ANY_POLICY = "2.5.29.32.0";
  public static final String AUTHORITY_KEY_IDENTIFIER;
  public static final String BASIC_CONSTRAINTS;
  public static final String CERTIFICATE_POLICIES;
  public static final String CRL_DISTRIBUTION_POINTS;
  public static final String CRL_NUMBER = Extension.cRLNumber.getId();
  protected static final int CRL_SIGN = 6;
  private static final PKIXCRLUtil CRL_UTIL = new PKIXCRLUtil();
  public static final String DELTA_CRL_INDICATOR;
  public static final String FRESHEST_CRL;
  public static final String INHIBIT_ANY_POLICY;
  public static final String ISSUING_DISTRIBUTION_POINT;
  protected static final int KEY_CERT_SIGN = 5;
  public static final String KEY_USAGE;
  public static final String NAME_CONSTRAINTS;
  public static final String POLICY_CONSTRAINTS;
  public static final String POLICY_MAPPINGS;
  public static final String SUBJECT_ALTERNATIVE_NAME;
  protected static final String[] crlReasons = { "unspecified", "keyCompromise", "cACompromise", "affiliationChanged", "superseded", "cessationOfOperation", "certificateHold", "unknown", "removeFromCRL", "privilegeWithdrawn", "aACompromise" };
  
  static
  {
    CERTIFICATE_POLICIES = Extension.certificatePolicies.getId();
    POLICY_MAPPINGS = Extension.policyMappings.getId();
    INHIBIT_ANY_POLICY = Extension.inhibitAnyPolicy.getId();
    ISSUING_DISTRIBUTION_POINT = Extension.issuingDistributionPoint.getId();
    FRESHEST_CRL = Extension.freshestCRL.getId();
    DELTA_CRL_INDICATOR = Extension.deltaCRLIndicator.getId();
    POLICY_CONSTRAINTS = Extension.policyConstraints.getId();
    BASIC_CONSTRAINTS = Extension.basicConstraints.getId();
    CRL_DISTRIBUTION_POINTS = Extension.cRLDistributionPoints.getId();
    SUBJECT_ALTERNATIVE_NAME = Extension.subjectAlternativeName.getId();
    NAME_CONSTRAINTS = Extension.nameConstraints.getId();
    AUTHORITY_KEY_IDENTIFIER = Extension.authorityKeyIdentifier.getId();
    KEY_USAGE = Extension.keyUsage.getId();
  }
  
  /* Error */
  private static void checkCRL(DistributionPoint paramDistributionPoint, PKIXExtendedParameters paramPKIXExtendedParameters, X509Certificate paramX509Certificate1, Date paramDate, X509Certificate paramX509Certificate2, PublicKey paramPublicKey, CertStatus paramCertStatus, ReasonsMask paramReasonsMask, List paramList, JcaJceHelper paramJcaJceHelper)
    throws AnnotatedException
  {
    // Byte code:
    //   0: aload 7
    //   2: astore 13
    //   4: new 153	java/util/Date
    //   7: dup
    //   8: invokestatic 159	java/lang/System:currentTimeMillis	()J
    //   11: invokespecial 162	java/util/Date:<init>	(J)V
    //   14: astore 12
    //   16: aload_3
    //   17: invokevirtual 165	java/util/Date:getTime	()J
    //   20: aload 12
    //   22: invokevirtual 165	java/util/Date:getTime	()J
    //   25: lcmp
    //   26: ifgt +473 -> 499
    //   29: aload_0
    //   30: aload_2
    //   31: aload 12
    //   33: aload_1
    //   34: invokestatic 171	org/bouncycastle/jce/provider/CertPathValidatorUtilities:getCompleteCRLs	(Lorg/bouncycastle/asn1/x509/DistributionPoint;Ljava/lang/Object;Ljava/util/Date;Lorg/bouncycastle/jcajce/PKIXExtendedParameters;)Ljava/util/Set;
    //   37: invokeinterface 177 1 0
    //   42: astore 14
    //   44: aconst_null
    //   45: astore 15
    //   47: iconst_0
    //   48: istore 10
    //   50: aload 14
    //   52: invokeinterface 183 1 0
    //   57: ifeq +433 -> 490
    //   60: aload 6
    //   62: invokevirtual 189	org/bouncycastle/jce/provider/CertStatus:getCertStatus	()I
    //   65: bipush 11
    //   67: if_icmpne +423 -> 490
    //   70: aload 7
    //   72: invokevirtual 194	org/bouncycastle/jce/provider/ReasonsMask:isAllReasons	()Z
    //   75: ifne +415 -> 490
    //   78: aload 14
    //   80: invokeinterface 198 1 0
    //   85: checkcast 200	java/security/cert/X509CRL
    //   88: astore 18
    //   90: aload 18
    //   92: aload_0
    //   93: invokestatic 204	org/bouncycastle/jce/provider/RFC3280CertPathUtilities:processCRLD	(Ljava/security/cert/X509CRL;Lorg/bouncycastle/asn1/x509/DistributionPoint;)Lorg/bouncycastle/jce/provider/ReasonsMask;
    //   96: astore 19
    //   98: aload 19
    //   100: aload 13
    //   102: invokevirtual 208	org/bouncycastle/jce/provider/ReasonsMask:hasNewReasons	(Lorg/bouncycastle/jce/provider/ReasonsMask;)Z
    //   105: istore 11
    //   107: iload 11
    //   109: ifne +6 -> 115
    //   112: goto -62 -> 50
    //   115: aload 12
    //   117: astore 13
    //   119: aload 18
    //   121: aload 18
    //   123: aload_2
    //   124: aload 4
    //   126: aload 5
    //   128: aload_1
    //   129: aload 8
    //   131: aload 9
    //   133: invokestatic 212	org/bouncycastle/jce/provider/RFC3280CertPathUtilities:processCRLF	(Ljava/security/cert/X509CRL;Ljava/lang/Object;Ljava/security/cert/X509Certificate;Ljava/security/PublicKey;Lorg/bouncycastle/jcajce/PKIXExtendedParameters;Ljava/util/List;Lorg/bouncycastle/jcajce/util/JcaJceHelper;)Ljava/util/Set;
    //   136: invokestatic 216	org/bouncycastle/jce/provider/RFC3280CertPathUtilities:processCRLG	(Ljava/security/cert/X509CRL;Ljava/util/Set;)Ljava/security/PublicKey;
    //   139: astore 17
    //   141: aload_1
    //   142: invokevirtual 222	org/bouncycastle/jcajce/PKIXExtendedParameters:getDate	()Ljava/util/Date;
    //   145: ifnull +365 -> 510
    //   148: aload_1
    //   149: invokevirtual 222	org/bouncycastle/jcajce/PKIXExtendedParameters:getDate	()Ljava/util/Date;
    //   152: astore 16
    //   154: goto +3 -> 157
    //   157: aload_1
    //   158: invokevirtual 225	org/bouncycastle/jcajce/PKIXExtendedParameters:isUseDeltasEnabled	()Z
    //   161: ifeq +356 -> 517
    //   164: aload 16
    //   166: aload 18
    //   168: aload_1
    //   169: invokevirtual 229	org/bouncycastle/jcajce/PKIXExtendedParameters:getCertStores	()Ljava/util/List;
    //   172: aload_1
    //   173: invokevirtual 232	org/bouncycastle/jcajce/PKIXExtendedParameters:getCRLStores	()Ljava/util/List;
    //   176: invokestatic 236	org/bouncycastle/jce/provider/CertPathValidatorUtilities:getDeltaCRLs	(Ljava/util/Date;Ljava/security/cert/X509CRL;Ljava/util/List;Ljava/util/List;)Ljava/util/Set;
    //   179: aload 17
    //   181: invokestatic 240	org/bouncycastle/jce/provider/RFC3280CertPathUtilities:processCRLH	(Ljava/util/Set;Ljava/security/PublicKey;)Ljava/security/cert/X509CRL;
    //   184: astore 17
    //   186: goto +3 -> 189
    //   189: aload_1
    //   190: invokevirtual 243	org/bouncycastle/jcajce/PKIXExtendedParameters:getValidityModel	()I
    //   193: iconst_1
    //   194: if_icmpeq +35 -> 229
    //   197: aload_2
    //   198: invokevirtual 248	java/security/cert/X509Certificate:getNotAfter	()Ljava/util/Date;
    //   201: invokevirtual 165	java/util/Date:getTime	()J
    //   204: aload 18
    //   206: invokevirtual 251	java/security/cert/X509CRL:getThisUpdate	()Ljava/util/Date;
    //   209: invokevirtual 165	java/util/Date:getTime	()J
    //   212: lcmp
    //   213: iflt +6 -> 219
    //   216: goto +13 -> 229
    //   219: new 151	org/bouncycastle/jce/provider/AnnotatedException
    //   222: dup
    //   223: ldc -3
    //   225: invokespecial 256	org/bouncycastle/jce/provider/AnnotatedException:<init>	(Ljava/lang/String;)V
    //   228: athrow
    //   229: aload_0
    //   230: aload_2
    //   231: aload 18
    //   233: invokestatic 260	org/bouncycastle/jce/provider/RFC3280CertPathUtilities:processCRLB1	(Lorg/bouncycastle/asn1/x509/DistributionPoint;Ljava/lang/Object;Ljava/security/cert/X509CRL;)V
    //   236: aload_0
    //   237: aload_2
    //   238: aload 18
    //   240: invokestatic 263	org/bouncycastle/jce/provider/RFC3280CertPathUtilities:processCRLB2	(Lorg/bouncycastle/asn1/x509/DistributionPoint;Ljava/lang/Object;Ljava/security/cert/X509CRL;)V
    //   243: aload 17
    //   245: aload 18
    //   247: aload_1
    //   248: invokestatic 267	org/bouncycastle/jce/provider/RFC3280CertPathUtilities:processCRLC	(Ljava/security/cert/X509CRL;Ljava/security/cert/X509CRL;Lorg/bouncycastle/jcajce/PKIXExtendedParameters;)V
    //   251: aload_3
    //   252: aload 17
    //   254: aload_2
    //   255: aload 6
    //   257: aload_1
    //   258: invokestatic 271	org/bouncycastle/jce/provider/RFC3280CertPathUtilities:processCRLI	(Ljava/util/Date;Ljava/security/cert/X509CRL;Ljava/lang/Object;Lorg/bouncycastle/jce/provider/CertStatus;Lorg/bouncycastle/jcajce/PKIXExtendedParameters;)V
    //   261: aload_3
    //   262: aload 18
    //   264: aload_2
    //   265: aload 6
    //   267: invokestatic 275	org/bouncycastle/jce/provider/RFC3280CertPathUtilities:processCRLJ	(Ljava/util/Date;Ljava/security/cert/X509CRL;Ljava/lang/Object;Lorg/bouncycastle/jce/provider/CertStatus;)V
    //   270: aload 6
    //   272: invokevirtual 189	org/bouncycastle/jce/provider/CertStatus:getCertStatus	()I
    //   275: bipush 8
    //   277: if_icmpne +10 -> 287
    //   280: aload 6
    //   282: bipush 11
    //   284: invokevirtual 279	org/bouncycastle/jce/provider/CertStatus:setCertStatus	(I)V
    //   287: aload 7
    //   289: astore 16
    //   291: aload 16
    //   293: aload 19
    //   295: invokevirtual 283	org/bouncycastle/jce/provider/ReasonsMask:addReasons	(Lorg/bouncycastle/jce/provider/ReasonsMask;)V
    //   298: aload 18
    //   300: invokevirtual 287	java/security/cert/X509CRL:getCriticalExtensionOIDs	()Ljava/util/Set;
    //   303: astore 18
    //   305: aload 18
    //   307: ifnull +66 -> 373
    //   310: new 289	java/util/HashSet
    //   313: dup
    //   314: aload 18
    //   316: invokespecial 292	java/util/HashSet:<init>	(Ljava/util/Collection;)V
    //   319: astore 18
    //   321: aload 18
    //   323: getstatic 67	org/bouncycastle/asn1/x509/Extension:issuingDistributionPoint	Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;
    //   326: invokevirtual 52	org/bouncycastle/asn1/ASN1ObjectIdentifier:getId	()Ljava/lang/String;
    //   329: invokeinterface 296 2 0
    //   334: pop
    //   335: aload 18
    //   337: getstatic 77	org/bouncycastle/asn1/x509/Extension:deltaCRLIndicator	Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;
    //   340: invokevirtual 52	org/bouncycastle/asn1/ASN1ObjectIdentifier:getId	()Ljava/lang/String;
    //   343: invokeinterface 296 2 0
    //   348: pop
    //   349: aload 18
    //   351: invokeinterface 299 1 0
    //   356: ifeq +6 -> 362
    //   359: goto +14 -> 373
    //   362: new 151	org/bouncycastle/jce/provider/AnnotatedException
    //   365: dup
    //   366: ldc_w 301
    //   369: invokespecial 256	org/bouncycastle/jce/provider/AnnotatedException:<init>	(Ljava/lang/String;)V
    //   372: athrow
    //   373: aload 17
    //   375: ifnull +78 -> 453
    //   378: aload 17
    //   380: invokevirtual 287	java/security/cert/X509CRL:getCriticalExtensionOIDs	()Ljava/util/Set;
    //   383: astore 17
    //   385: aload 17
    //   387: ifnull +66 -> 453
    //   390: new 289	java/util/HashSet
    //   393: dup
    //   394: aload 17
    //   396: invokespecial 292	java/util/HashSet:<init>	(Ljava/util/Collection;)V
    //   399: astore 17
    //   401: aload 17
    //   403: getstatic 67	org/bouncycastle/asn1/x509/Extension:issuingDistributionPoint	Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;
    //   406: invokevirtual 52	org/bouncycastle/asn1/ASN1ObjectIdentifier:getId	()Ljava/lang/String;
    //   409: invokeinterface 296 2 0
    //   414: pop
    //   415: aload 17
    //   417: getstatic 77	org/bouncycastle/asn1/x509/Extension:deltaCRLIndicator	Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;
    //   420: invokevirtual 52	org/bouncycastle/asn1/ASN1ObjectIdentifier:getId	()Ljava/lang/String;
    //   423: invokeinterface 296 2 0
    //   428: pop
    //   429: aload 17
    //   431: invokeinterface 299 1 0
    //   436: ifeq +6 -> 442
    //   439: goto +14 -> 453
    //   442: new 151	org/bouncycastle/jce/provider/AnnotatedException
    //   445: dup
    //   446: ldc_w 303
    //   449: invokespecial 256	org/bouncycastle/jce/provider/AnnotatedException:<init>	(Ljava/lang/String;)V
    //   452: athrow
    //   453: aload 13
    //   455: astore 12
    //   457: iconst_1
    //   458: istore 10
    //   460: aload 16
    //   462: astore 13
    //   464: goto -414 -> 50
    //   467: astore 15
    //   469: aload 16
    //   471: astore 13
    //   473: goto +14 -> 487
    //   476: astore 15
    //   478: aload 7
    //   480: astore 13
    //   482: goto +5 -> 487
    //   485: astore 15
    //   487: goto -437 -> 50
    //   490: iload 10
    //   492: ifeq +4 -> 496
    //   495: return
    //   496: aload 15
    //   498: athrow
    //   499: new 151	org/bouncycastle/jce/provider/AnnotatedException
    //   502: dup
    //   503: ldc_w 305
    //   506: invokespecial 256	org/bouncycastle/jce/provider/AnnotatedException:<init>	(Ljava/lang/String;)V
    //   509: athrow
    //   510: aload 13
    //   512: astore 16
    //   514: goto -357 -> 157
    //   517: aconst_null
    //   518: astore 17
    //   520: goto -331 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	523	0	paramDistributionPoint	DistributionPoint
    //   0	523	1	paramPKIXExtendedParameters	PKIXExtendedParameters
    //   0	523	2	paramX509Certificate1	X509Certificate
    //   0	523	3	paramDate	Date
    //   0	523	4	paramX509Certificate2	X509Certificate
    //   0	523	5	paramPublicKey	PublicKey
    //   0	523	6	paramCertStatus	CertStatus
    //   0	523	7	paramReasonsMask	ReasonsMask
    //   0	523	8	paramList	List
    //   0	523	9	paramJcaJceHelper	JcaJceHelper
    //   48	443	10	i	int
    //   105	3	11	bool	boolean
    //   14	442	12	localObject1	Object
    //   2	509	13	localObject2	Object
    //   42	37	14	localIterator	Iterator
    //   45	1	15	localObject3	Object
    //   467	1	15	localAnnotatedException1	AnnotatedException
    //   476	1	15	localAnnotatedException2	AnnotatedException
    //   485	12	15	localAnnotatedException3	AnnotatedException
    //   152	361	16	localObject4	Object
    //   139	380	17	localObject5	Object
    //   88	262	18	localObject6	Object
    //   96	198	19	localReasonsMask	ReasonsMask
    // Exception table:
    //   from	to	target	type
    //   291	305	467	org/bouncycastle/jce/provider/AnnotatedException
    //   310	359	467	org/bouncycastle/jce/provider/AnnotatedException
    //   362	373	467	org/bouncycastle/jce/provider/AnnotatedException
    //   378	385	467	org/bouncycastle/jce/provider/AnnotatedException
    //   390	439	467	org/bouncycastle/jce/provider/AnnotatedException
    //   442	453	467	org/bouncycastle/jce/provider/AnnotatedException
    //   119	154	476	org/bouncycastle/jce/provider/AnnotatedException
    //   157	186	476	org/bouncycastle/jce/provider/AnnotatedException
    //   189	216	476	org/bouncycastle/jce/provider/AnnotatedException
    //   219	229	476	org/bouncycastle/jce/provider/AnnotatedException
    //   229	287	476	org/bouncycastle/jce/provider/AnnotatedException
    //   78	107	485	org/bouncycastle/jce/provider/AnnotatedException
  }
  
  protected static void checkCRLs(PKIXExtendedParameters paramPKIXExtendedParameters, X509Certificate paramX509Certificate1, Date paramDate, X509Certificate paramX509Certificate2, PublicKey paramPublicKey, List paramList, JcaJceHelper paramJcaJceHelper)
    throws AnnotatedException
  {
    for (;;)
    {
      try
      {
        CRLDistPoint localCRLDistPoint = CRLDistPoint.getInstance(CertPathValidatorUtilities.getExtensionValue(paramX509Certificate1, CRL_DISTRIBUTION_POINTS));
        Object localObject2 = new PKIXExtendedParameters.Builder(paramPKIXExtendedParameters);
        try
        {
          localObject3 = CertPathValidatorUtilities.getAdditionalStoresFromCRLDistributionPoint(localCRLDistPoint, paramPKIXExtendedParameters.getNamedCRLStoreMap()).iterator();
          if (((Iterator)localObject3).hasNext())
          {
            ((PKIXExtendedParameters.Builder)localObject2).addCRLStore((PKIXCRLStore)((Iterator)localObject3).next());
            continue;
          }
          localObject3 = new CertStatus();
          localReasonsMask = new ReasonsMask();
          PKIXExtendedParameters localPKIXExtendedParameters = ((PKIXExtendedParameters.Builder)localObject2).build();
          k = 1;
          if (localCRLDistPoint != null) {
            try
            {
              localObject2 = localCRLDistPoint.getDistributionPoints();
              if (localObject2 != null)
              {
                localCRLDistPoint = null;
                int j = 0;
                i = 0;
                if ((j < localObject2.length) && (((CertStatus)localObject3).getCertStatus() == 11) && (!localReasonsMask.isAllReasons()))
                {
                  DistributionPoint localDistributionPoint = localObject2[j];
                  try
                  {
                    checkCRL(localDistributionPoint, localPKIXExtendedParameters, paramX509Certificate1, paramDate, paramX509Certificate2, paramPublicKey, (CertStatus)localObject3, localReasonsMask, paramList, paramJcaJceHelper);
                    i = 1;
                  }
                  catch (AnnotatedException localAnnotatedException1) {}
                  j += 1;
                  continue;
                }
              }
            }
            catch (Exception paramPKIXExtendedParameters)
            {
              throw new AnnotatedException("Distribution points could not be read.", paramPKIXExtendedParameters);
            }
          }
          localObject1 = null;
          i = 0;
          localObject2 = localObject1;
          if (((CertStatus)localObject3).getCertStatus() == 11)
          {
            localObject2 = localObject1;
            if (localReasonsMask.isAllReasons()) {}
          }
        }
        catch (AnnotatedException paramPKIXExtendedParameters)
        {
          Object localObject3;
          ReasonsMask localReasonsMask;
          int k;
          int i;
          Object localObject1;
          throw new AnnotatedException("No additional CRL locations could be decoded from CRL distribution point extension.", paramPKIXExtendedParameters);
        }
      }
      catch (Exception paramPKIXExtendedParameters)
      {
        throw new AnnotatedException("CRL distribution point extension could not be read.", paramPKIXExtendedParameters);
      }
      try
      {
        try
        {
          localObject2 = new ASN1InputStream(PrincipalUtils.getEncodedIssuerPrincipal(paramX509Certificate1).getEncoded()).readObject();
          checkCRL(new DistributionPoint(new DistributionPointName(0, new GeneralNames(new GeneralName(4, (ASN1Encodable)localObject2))), null, null), (PKIXExtendedParameters)paramPKIXExtendedParameters.clone(), paramX509Certificate1, paramDate, paramX509Certificate2, paramPublicKey, (CertStatus)localObject3, localReasonsMask, paramList, paramJcaJceHelper);
          i = k;
        }
        catch (Exception paramPKIXExtendedParameters)
        {
          throw new AnnotatedException("Issuer from certificate for CRL could not be reencoded.", paramPKIXExtendedParameters);
        }
      }
      catch (AnnotatedException localAnnotatedException2) {}
    }
    localObject1 = localObject2;
    if (i == 0)
    {
      if ((localObject1 instanceof AnnotatedException)) {
        throw ((Throwable)localObject1);
      }
      throw new AnnotatedException("No valid CRL found.", (Throwable)localObject1);
    }
    if (((CertStatus)localObject3).getCertStatus() == 11)
    {
      if ((!localReasonsMask.isAllReasons()) && (((CertStatus)localObject3).getCertStatus() == 11)) {
        ((CertStatus)localObject3).setCertStatus(12);
      }
      if (((CertStatus)localObject3).getCertStatus() != 12) {
        return;
      }
      throw new AnnotatedException("Certificate status could not be determined.");
    }
    paramPKIXExtendedParameters = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
    paramPKIXExtendedParameters.setTimeZone(TimeZone.getTimeZone("UTC"));
    paramX509Certificate1 = new StringBuilder();
    paramX509Certificate1.append("Certificate revocation after ");
    paramX509Certificate1.append(paramPKIXExtendedParameters.format(((CertStatus)localObject3).getRevocationDate()));
    paramPKIXExtendedParameters = paramX509Certificate1.toString();
    paramX509Certificate1 = new StringBuilder();
    paramX509Certificate1.append(paramPKIXExtendedParameters);
    paramX509Certificate1.append(", reason: ");
    paramX509Certificate1.append(crlReasons[localObject3.getCertStatus()]);
    throw new AnnotatedException(paramX509Certificate1.toString());
  }
  
  protected static PKIXPolicyNode prepareCertB(CertPath paramCertPath, int paramInt1, List[] paramArrayOfList, PKIXPolicyNode paramPKIXPolicyNode, int paramInt2)
    throws CertPathValidatorException
  {
    Object localObject1 = paramCertPath.getCertificates();
    X509Certificate localX509Certificate = (X509Certificate)((List)localObject1).get(paramInt1);
    int k = ((List)localObject1).size() - paramInt1;
    try
    {
      localObject1 = DERSequence.getInstance(CertPathValidatorUtilities.getExtensionValue(localX509Certificate, POLICY_MAPPINGS));
      if (localObject1 != null)
      {
        HashMap localHashMap = new HashMap();
        Object localObject2 = new HashSet();
        int i = 0;
        Object localObject4;
        Object localObject5;
        while (i < ((ASN1Sequence)localObject1).size())
        {
          localObject4 = (ASN1Sequence)((ASN1Sequence)localObject1).getObjectAt(i);
          localObject3 = ((ASN1ObjectIdentifier)((ASN1Sequence)localObject4).getObjectAt(0)).getId();
          localObject4 = ((ASN1ObjectIdentifier)((ASN1Sequence)localObject4).getObjectAt(1)).getId();
          if (!localHashMap.containsKey(localObject3))
          {
            localObject5 = new HashSet();
            ((Set)localObject5).add(localObject4);
            localHashMap.put(localObject3, localObject5);
            ((Set)localObject2).add(localObject3);
          }
          else
          {
            ((Set)localHashMap.get(localObject3)).add(localObject4);
          }
          i += 1;
        }
        Object localObject3 = ((Set)localObject2).iterator();
        for (;;)
        {
          localObject1 = paramPKIXPolicyNode;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject4 = (String)((Iterator)localObject3).next();
          label315:
          Object localObject6;
          if (paramInt2 > 0)
          {
            localObject1 = paramArrayOfList[k].iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (PKIXPolicyNode)((Iterator)localObject1).next();
              if (((PKIXPolicyNode)localObject2).getValidPolicy().equals(localObject4))
              {
                ((PKIXPolicyNode)localObject2).expectedPolicies = ((Set)localHashMap.get(localObject4));
                i = 1;
                break label315;
              }
            }
            i = 0;
            localObject2 = paramPKIXPolicyNode;
            if (i == 0)
            {
              localObject1 = paramArrayOfList[k].iterator();
              do
              {
                localObject2 = paramPKIXPolicyNode;
                if (!((Iterator)localObject1).hasNext()) {
                  break;
                }
                localObject5 = (PKIXPolicyNode)((Iterator)localObject1).next();
              } while (!"2.5.29.32.0".equals(((PKIXPolicyNode)localObject5).getValidPolicy()));
              localObject2 = null;
              try
              {
                localObject1 = (ASN1Sequence)CertPathValidatorUtilities.getExtensionValue(localX509Certificate, CERTIFICATE_POLICIES);
                localObject6 = ((ASN1Sequence)localObject1).getObjects();
                for (;;)
                {
                  localObject1 = localObject2;
                  if (((Enumeration)localObject6).hasMoreElements()) {
                    try
                    {
                      localObject1 = PolicyInformation.getInstance(((Enumeration)localObject6).nextElement());
                      if ("2.5.29.32.0".equals(((PolicyInformation)localObject1).getPolicyIdentifier().getId()))
                      {
                        try
                        {
                          localObject1 = CertPathValidatorUtilities.getQualifierSet(((PolicyInformation)localObject1).getPolicyQualifiers());
                        }
                        catch (CertPathValidatorException paramArrayOfList)
                        {
                          throw new ExtCertPathValidatorException("Policy qualifier info set could not be decoded.", paramArrayOfList, paramCertPath, paramInt1);
                        }
                        if (localX509Certificate.getCriticalExtensionOIDs() == null) {
                          break label506;
                        }
                      }
                    }
                    catch (Exception paramArrayOfList)
                    {
                      throw new CertPathValidatorException("Policy information could not be decoded.", paramArrayOfList, paramCertPath, paramInt1);
                    }
                  }
                }
                boolean bool = localX509Certificate.getCriticalExtensionOIDs().contains(CERTIFICATE_POLICIES);
                break label509;
                label506:
                bool = false;
                label509:
                localObject5 = (PKIXPolicyNode)((PKIXPolicyNode)localObject5).getParent();
                localObject2 = paramPKIXPolicyNode;
                if (!"2.5.29.32.0".equals(((PKIXPolicyNode)localObject5).getValidPolicy())) {
                  break label801;
                }
                localObject1 = new PKIXPolicyNode(new ArrayList(), k, (Set)localHashMap.get(localObject4), (PolicyNode)localObject5, (Set)localObject1, (String)localObject4, bool);
                ((PKIXPolicyNode)localObject5).addChild((PKIXPolicyNode)localObject1);
                paramArrayOfList[k].add(localObject1);
                localObject2 = paramPKIXPolicyNode;
              }
              catch (AnnotatedException paramArrayOfList)
              {
                throw new ExtCertPathValidatorException("Certificate policies extension could not be decoded.", paramArrayOfList, paramCertPath, paramInt1);
              }
            }
          }
          else
          {
            localObject2 = paramPKIXPolicyNode;
            if (paramInt2 <= 0)
            {
              localObject5 = paramArrayOfList[k].iterator();
              do
              {
                localObject2 = paramPKIXPolicyNode;
                if (!((Iterator)localObject5).hasNext()) {
                  break;
                }
                localObject1 = (PKIXPolicyNode)((Iterator)localObject5).next();
              } while (!((PKIXPolicyNode)localObject1).getValidPolicy().equals(localObject4));
              ((PKIXPolicyNode)((PKIXPolicyNode)localObject1).getParent()).removeChild((PKIXPolicyNode)localObject1);
              ((Iterator)localObject5).remove();
              i = k - 1;
              localObject1 = paramPKIXPolicyNode;
              for (;;)
              {
                paramPKIXPolicyNode = (PKIXPolicyNode)localObject1;
                if (i < 0) {
                  break;
                }
                localObject2 = paramArrayOfList[i];
                paramPKIXPolicyNode = (PKIXPolicyNode)localObject1;
                int j = 0;
                for (;;)
                {
                  localObject1 = paramPKIXPolicyNode;
                  if (j >= ((List)localObject2).size()) {
                    break;
                  }
                  localObject6 = (PKIXPolicyNode)((List)localObject2).get(j);
                  localObject1 = paramPKIXPolicyNode;
                  if (!((PKIXPolicyNode)localObject6).hasChildren())
                  {
                    paramPKIXPolicyNode = CertPathValidatorUtilities.removePolicyNode(paramPKIXPolicyNode, paramArrayOfList, (PKIXPolicyNode)localObject6);
                    localObject1 = paramPKIXPolicyNode;
                    if (paramPKIXPolicyNode == null)
                    {
                      localObject1 = paramPKIXPolicyNode;
                      break;
                    }
                  }
                  j += 1;
                  paramPKIXPolicyNode = (PKIXPolicyNode)localObject1;
                }
                i -= 1;
              }
            }
          }
          label801:
          paramPKIXPolicyNode = (PKIXPolicyNode)localObject2;
        }
      }
      localObject1 = paramPKIXPolicyNode;
      return (PKIXPolicyNode)localObject1;
    }
    catch (AnnotatedException paramArrayOfList)
    {
      throw new ExtCertPathValidatorException("Policy mappings extension could not be decoded.", paramArrayOfList, paramCertPath, paramInt1);
    }
  }
  
  protected static void prepareNextCertA(CertPath paramCertPath, int paramInt)
    throws CertPathValidatorException
  {
    Object localObject1 = (X509Certificate)paramCertPath.getCertificates().get(paramInt);
    try
    {
      localObject1 = DERSequence.getInstance(CertPathValidatorUtilities.getExtensionValue((X509Extension)localObject1, POLICY_MAPPINGS));
      if (localObject1 != null)
      {
        int i = 0;
        while (i < ((ASN1Sequence)localObject1).size()) {
          try
          {
            Object localObject2 = DERSequence.getInstance(((ASN1Sequence)localObject1).getObjectAt(i));
            ASN1ObjectIdentifier localASN1ObjectIdentifier = ASN1ObjectIdentifier.getInstance(((ASN1Sequence)localObject2).getObjectAt(0));
            localObject2 = ASN1ObjectIdentifier.getInstance(((ASN1Sequence)localObject2).getObjectAt(1));
            if (!"2.5.29.32.0".equals(localASN1ObjectIdentifier.getId()))
            {
              if (!"2.5.29.32.0".equals(((ASN1ObjectIdentifier)localObject2).getId())) {
                i += 1;
              } else {
                throw new CertPathValidatorException("SubjectDomainPolicy is anyPolicy,", null, paramCertPath, paramInt);
              }
            }
            else {
              throw new CertPathValidatorException("IssuerDomainPolicy is anyPolicy", null, paramCertPath, paramInt);
            }
          }
          catch (Exception localException)
          {
            throw new ExtCertPathValidatorException("Policy mappings extension contents could not be decoded.", localException, paramCertPath, paramInt);
          }
        }
      }
      return;
    }
    catch (AnnotatedException localAnnotatedException)
    {
      throw new ExtCertPathValidatorException("Policy mappings extension could not be decoded.", localAnnotatedException, paramCertPath, paramInt);
    }
  }
  
  protected static void prepareNextCertG(CertPath paramCertPath, int paramInt, PKIXNameConstraintValidator paramPKIXNameConstraintValidator)
    throws CertPathValidatorException
  {
    Object localObject = (X509Certificate)paramCertPath.getCertificates().get(paramInt);
    try
    {
      localObject = DERSequence.getInstance(CertPathValidatorUtilities.getExtensionValue((X509Extension)localObject, NAME_CONSTRAINTS));
      if (localObject != null) {
        localObject = NameConstraints.getInstance(localObject);
      } else {
        localObject = null;
      }
      if (localObject != null)
      {
        GeneralSubtree[] arrayOfGeneralSubtree = ((NameConstraints)localObject).getPermittedSubtrees();
        if (arrayOfGeneralSubtree != null) {
          try
          {
            paramPKIXNameConstraintValidator.intersectPermittedSubtree(arrayOfGeneralSubtree);
          }
          catch (Exception paramPKIXNameConstraintValidator)
          {
            throw new ExtCertPathValidatorException("Permitted subtrees cannot be build from name constraints extension.", paramPKIXNameConstraintValidator, paramCertPath, paramInt);
          }
        }
        localObject = ((NameConstraints)localObject).getExcludedSubtrees();
        if (localObject != null)
        {
          int i = 0;
          while (i != localObject.length) {
            try
            {
              paramPKIXNameConstraintValidator.addExcludedSubtree(localObject[i]);
              i += 1;
            }
            catch (Exception paramPKIXNameConstraintValidator)
            {
              throw new ExtCertPathValidatorException("Excluded subtrees cannot be build from name constraints extension.", paramPKIXNameConstraintValidator, paramCertPath, paramInt);
            }
          }
        }
      }
      return;
    }
    catch (Exception paramPKIXNameConstraintValidator)
    {
      throw new ExtCertPathValidatorException("Name constraints extension could not be decoded.", paramPKIXNameConstraintValidator, paramCertPath, paramInt);
    }
  }
  
  protected static int prepareNextCertH1(CertPath paramCertPath, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (!CertPathValidatorUtilities.isSelfIssued((X509Certificate)paramCertPath.getCertificates().get(paramInt1)))
    {
      i = paramInt2;
      if (paramInt2 != 0) {
        i = paramInt2 - 1;
      }
    }
    return i;
  }
  
  protected static int prepareNextCertH2(CertPath paramCertPath, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (!CertPathValidatorUtilities.isSelfIssued((X509Certificate)paramCertPath.getCertificates().get(paramInt1)))
    {
      i = paramInt2;
      if (paramInt2 != 0) {
        i = paramInt2 - 1;
      }
    }
    return i;
  }
  
  protected static int prepareNextCertH3(CertPath paramCertPath, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (!CertPathValidatorUtilities.isSelfIssued((X509Certificate)paramCertPath.getCertificates().get(paramInt1)))
    {
      i = paramInt2;
      if (paramInt2 != 0) {
        i = paramInt2 - 1;
      }
    }
    return i;
  }
  
  protected static int prepareNextCertI1(CertPath paramCertPath, int paramInt1, int paramInt2)
    throws CertPathValidatorException
  {
    Object localObject = (X509Certificate)paramCertPath.getCertificates().get(paramInt1);
    try
    {
      localObject = DERSequence.getInstance(CertPathValidatorUtilities.getExtensionValue((X509Extension)localObject, POLICY_CONSTRAINTS));
      if (localObject != null)
      {
        localObject = ((ASN1Sequence)localObject).getObjects();
        while (((Enumeration)localObject).hasMoreElements()) {
          try
          {
            ASN1TaggedObject localASN1TaggedObject = ASN1TaggedObject.getInstance(((Enumeration)localObject).nextElement());
            if (localASN1TaggedObject.getTagNo() == 0)
            {
              int i = ASN1Integer.getInstance(localASN1TaggedObject, false).getValue().intValue();
              if (i < paramInt2) {
                return i;
              }
            }
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            throw new ExtCertPathValidatorException("Policy constraints extension contents cannot be decoded.", localIllegalArgumentException, paramCertPath, paramInt1);
          }
        }
      }
      return paramInt2;
    }
    catch (Exception localException)
    {
      throw new ExtCertPathValidatorException("Policy constraints extension cannot be decoded.", localException, paramCertPath, paramInt1);
    }
  }
  
  protected static int prepareNextCertI2(CertPath paramCertPath, int paramInt1, int paramInt2)
    throws CertPathValidatorException
  {
    Object localObject = (X509Certificate)paramCertPath.getCertificates().get(paramInt1);
    try
    {
      localObject = DERSequence.getInstance(CertPathValidatorUtilities.getExtensionValue((X509Extension)localObject, POLICY_CONSTRAINTS));
      if (localObject != null)
      {
        localObject = ((ASN1Sequence)localObject).getObjects();
        while (((Enumeration)localObject).hasMoreElements()) {
          try
          {
            ASN1TaggedObject localASN1TaggedObject = ASN1TaggedObject.getInstance(((Enumeration)localObject).nextElement());
            if (localASN1TaggedObject.getTagNo() == 1)
            {
              int i = ASN1Integer.getInstance(localASN1TaggedObject, false).getValue().intValue();
              if (i < paramInt2) {
                return i;
              }
            }
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            throw new ExtCertPathValidatorException("Policy constraints extension contents cannot be decoded.", localIllegalArgumentException, paramCertPath, paramInt1);
          }
        }
      }
      return paramInt2;
    }
    catch (Exception localException)
    {
      throw new ExtCertPathValidatorException("Policy constraints extension cannot be decoded.", localException, paramCertPath, paramInt1);
    }
  }
  
  protected static int prepareNextCertJ(CertPath paramCertPath, int paramInt1, int paramInt2)
    throws CertPathValidatorException
  {
    Object localObject = (X509Certificate)paramCertPath.getCertificates().get(paramInt1);
    try
    {
      localObject = ASN1Integer.getInstance(CertPathValidatorUtilities.getExtensionValue((X509Extension)localObject, INHIBIT_ANY_POLICY));
      if (localObject != null)
      {
        paramInt1 = ((ASN1Integer)localObject).getValue().intValue();
        if (paramInt1 < paramInt2) {
          return paramInt1;
        }
      }
      return paramInt2;
    }
    catch (Exception localException)
    {
      throw new ExtCertPathValidatorException("Inhibit any-policy extension cannot be decoded.", localException, paramCertPath, paramInt1);
    }
  }
  
  protected static void prepareNextCertK(CertPath paramCertPath, int paramInt)
    throws CertPathValidatorException
  {
    Object localObject = (X509Certificate)paramCertPath.getCertificates().get(paramInt);
    try
    {
      localObject = BasicConstraints.getInstance(CertPathValidatorUtilities.getExtensionValue((X509Extension)localObject, BASIC_CONSTRAINTS));
      if (localObject != null)
      {
        if (((BasicConstraints)localObject).isCA()) {
          return;
        }
        throw new CertPathValidatorException("Not a CA certificate");
      }
      throw new CertPathValidatorException("Intermediate certificate lacks BasicConstraints");
    }
    catch (Exception localException)
    {
      throw new ExtCertPathValidatorException("Basic constraints extension cannot be decoded.", localException, paramCertPath, paramInt);
    }
  }
  
  protected static int prepareNextCertL(CertPath paramCertPath, int paramInt1, int paramInt2)
    throws CertPathValidatorException
  {
    if (!CertPathValidatorUtilities.isSelfIssued((X509Certificate)paramCertPath.getCertificates().get(paramInt1)))
    {
      if (paramInt2 > 0) {
        return paramInt2 - 1;
      }
      throw new ExtCertPathValidatorException("Max path length not greater than zero", null, paramCertPath, paramInt1);
    }
    return paramInt2;
  }
  
  protected static int prepareNextCertM(CertPath paramCertPath, int paramInt1, int paramInt2)
    throws CertPathValidatorException
  {
    Object localObject = (X509Certificate)paramCertPath.getCertificates().get(paramInt1);
    try
    {
      localObject = BasicConstraints.getInstance(CertPathValidatorUtilities.getExtensionValue((X509Extension)localObject, BASIC_CONSTRAINTS));
      if (localObject != null)
      {
        paramCertPath = ((BasicConstraints)localObject).getPathLenConstraint();
        if (paramCertPath != null)
        {
          paramInt1 = paramCertPath.intValue();
          if (paramInt1 < paramInt2) {
            return paramInt1;
          }
        }
      }
      return paramInt2;
    }
    catch (Exception localException)
    {
      throw new ExtCertPathValidatorException("Basic constraints extension cannot be decoded.", localException, paramCertPath, paramInt1);
    }
  }
  
  protected static void prepareNextCertN(CertPath paramCertPath, int paramInt)
    throws CertPathValidatorException
  {
    boolean[] arrayOfBoolean = ((X509Certificate)paramCertPath.getCertificates().get(paramInt)).getKeyUsage();
    if (arrayOfBoolean != null)
    {
      if (arrayOfBoolean[5] != 0) {
        return;
      }
      throw new ExtCertPathValidatorException("Issuer certificate keyusage extension is critical and does not permit key signing.", null, paramCertPath, paramInt);
    }
  }
  
  protected static void prepareNextCertO(CertPath paramCertPath, int paramInt, Set paramSet, List paramList)
    throws CertPathValidatorException
  {
    X509Certificate localX509Certificate = (X509Certificate)paramCertPath.getCertificates().get(paramInt);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      try
      {
        ((PKIXCertPathChecker)paramList.next()).check(localX509Certificate, paramSet);
      }
      catch (CertPathValidatorException paramSet)
      {
        throw new CertPathValidatorException(paramSet.getMessage(), paramSet.getCause(), paramCertPath, paramInt);
      }
    }
    if (paramSet.isEmpty()) {
      return;
    }
    paramList = new StringBuilder();
    paramList.append("Certificate has unsupported critical extension: ");
    paramList.append(paramSet);
    throw new ExtCertPathValidatorException(paramList.toString(), null, paramCertPath, paramInt);
  }
  
  /* Error */
  protected static Set processCRLA1i(Date paramDate, PKIXExtendedParameters paramPKIXExtendedParameters, X509Certificate paramX509Certificate, X509CRL paramX509CRL)
    throws AnnotatedException
  {
    // Byte code:
    //   0: new 289	java/util/HashSet
    //   3: dup
    //   4: invokespecial 474	java/util/HashSet:<init>	()V
    //   7: astore 5
    //   9: aload_1
    //   10: invokevirtual 225	org/bouncycastle/jcajce/PKIXExtendedParameters:isUseDeltasEnabled	()Z
    //   13: ifeq +152 -> 165
    //   16: aload_2
    //   17: getstatic 74	org/bouncycastle/jce/provider/RFC3280CertPathUtilities:FRESHEST_CRL	Ljava/lang/String;
    //   20: invokestatic 314	org/bouncycastle/jce/provider/CertPathValidatorUtilities:getExtensionValue	(Ljava/security/cert/X509Extension;Ljava/lang/String;)Lorg/bouncycastle/asn1/ASN1Primitive;
    //   23: invokestatic 320	org/bouncycastle/asn1/x509/CRLDistPoint:getInstance	(Ljava/lang/Object;)Lorg/bouncycastle/asn1/x509/CRLDistPoint;
    //   26: astore 4
    //   28: aload 4
    //   30: astore_2
    //   31: aload 4
    //   33: ifnonnull +30 -> 63
    //   36: aload_3
    //   37: getstatic 74	org/bouncycastle/jce/provider/RFC3280CertPathUtilities:FRESHEST_CRL	Ljava/lang/String;
    //   40: invokestatic 314	org/bouncycastle/jce/provider/CertPathValidatorUtilities:getExtensionValue	(Ljava/security/cert/X509Extension;Ljava/lang/String;)Lorg/bouncycastle/asn1/ASN1Primitive;
    //   43: invokestatic 320	org/bouncycastle/asn1/x509/CRLDistPoint:getInstance	(Ljava/lang/Object;)Lorg/bouncycastle/asn1/x509/CRLDistPoint;
    //   46: astore_2
    //   47: goto +16 -> 63
    //   50: astore_0
    //   51: new 151	org/bouncycastle/jce/provider/AnnotatedException
    //   54: dup
    //   55: ldc_w 721
    //   58: aload_0
    //   59: invokespecial 359	org/bouncycastle/jce/provider/AnnotatedException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   62: athrow
    //   63: aload_2
    //   64: ifnull +101 -> 165
    //   67: new 557	java/util/ArrayList
    //   70: dup
    //   71: invokespecial 558	java/util/ArrayList:<init>	()V
    //   74: astore 4
    //   76: aload 4
    //   78: aload_1
    //   79: invokevirtual 232	org/bouncycastle/jcajce/PKIXExtendedParameters:getCRLStores	()Ljava/util/List;
    //   82: invokeinterface 725 2 0
    //   87: pop
    //   88: aload 4
    //   90: aload_2
    //   91: aload_1
    //   92: invokevirtual 329	org/bouncycastle/jcajce/PKIXExtendedParameters:getNamedCRLStoreMap	()Ljava/util/Map;
    //   95: invokestatic 333	org/bouncycastle/jce/provider/CertPathValidatorUtilities:getAdditionalStoresFromCRLDistributionPoint	(Lorg/bouncycastle/asn1/x509/CRLDistPoint;Ljava/util/Map;)Ljava/util/List;
    //   98: invokeinterface 725 2 0
    //   103: pop
    //   104: aload 5
    //   106: aload_0
    //   107: aload_3
    //   108: aload_1
    //   109: invokevirtual 229	org/bouncycastle/jcajce/PKIXExtendedParameters:getCertStores	()Ljava/util/List;
    //   112: aload 4
    //   114: invokestatic 236	org/bouncycastle/jce/provider/CertPathValidatorUtilities:getDeltaCRLs	(Ljava/util/Date;Ljava/security/cert/X509CRL;Ljava/util/List;Ljava/util/List;)Ljava/util/Set;
    //   117: invokeinterface 726 2 0
    //   122: pop
    //   123: aload 5
    //   125: areturn
    //   126: astore_0
    //   127: new 151	org/bouncycastle/jce/provider/AnnotatedException
    //   130: dup
    //   131: ldc_w 728
    //   134: aload_0
    //   135: invokespecial 359	org/bouncycastle/jce/provider/AnnotatedException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   138: athrow
    //   139: astore_0
    //   140: new 151	org/bouncycastle/jce/provider/AnnotatedException
    //   143: dup
    //   144: ldc_w 730
    //   147: aload_0
    //   148: invokespecial 359	org/bouncycastle/jce/provider/AnnotatedException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   151: athrow
    //   152: astore_0
    //   153: new 151	org/bouncycastle/jce/provider/AnnotatedException
    //   156: dup
    //   157: ldc_w 732
    //   160: aload_0
    //   161: invokespecial 359	org/bouncycastle/jce/provider/AnnotatedException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   164: athrow
    //   165: aload 5
    //   167: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	paramDate	Date
    //   0	168	1	paramPKIXExtendedParameters	PKIXExtendedParameters
    //   0	168	2	paramX509Certificate	X509Certificate
    //   0	168	3	paramX509CRL	X509CRL
    //   26	87	4	localObject	Object
    //   7	159	5	localHashSet	HashSet
    // Exception table:
    //   from	to	target	type
    //   36	47	50	org/bouncycastle/jce/provider/AnnotatedException
    //   104	123	126	org/bouncycastle/jce/provider/AnnotatedException
    //   88	104	139	org/bouncycastle/jce/provider/AnnotatedException
    //   16	28	152	org/bouncycastle/jce/provider/AnnotatedException
  }
  
  protected static Set[] processCRLA1ii(Date paramDate, PKIXExtendedParameters paramPKIXExtendedParameters, X509Certificate paramX509Certificate, X509CRL paramX509CRL)
    throws AnnotatedException
  {
    HashSet localHashSet = new HashSet();
    X509CRLSelector localX509CRLSelector = new X509CRLSelector();
    localX509CRLSelector.setCertificateChecking(paramX509Certificate);
    try
    {
      localX509CRLSelector.addIssuerName(PrincipalUtils.getIssuerPrincipal(paramX509CRL).getEncoded());
      paramX509Certificate = new PKIXCRLStoreSelector.Builder(localX509CRLSelector).setCompleteCRLEnabled(true).build();
      if (paramPKIXExtendedParameters.getDate() != null) {
        paramDate = paramPKIXExtendedParameters.getDate();
      }
      paramX509Certificate = CRL_UTIL.findCRLs(paramX509Certificate, paramDate, paramPKIXExtendedParameters.getCertStores(), paramPKIXExtendedParameters.getCRLStores());
      if (paramPKIXExtendedParameters.isUseDeltasEnabled()) {
        try
        {
          localHashSet.addAll(CertPathValidatorUtilities.getDeltaCRLs(paramDate, paramX509CRL, paramPKIXExtendedParameters.getCertStores(), paramPKIXExtendedParameters.getCRLStores()));
        }
        catch (AnnotatedException paramDate)
        {
          throw new AnnotatedException("Exception obtaining delta CRLs.", paramDate);
        }
      }
      return new Set[] { paramX509Certificate, localHashSet };
    }
    catch (IOException paramDate)
    {
      paramPKIXExtendedParameters = new StringBuilder();
      paramPKIXExtendedParameters.append("Cannot extract issuer from CRL.");
      paramPKIXExtendedParameters.append(paramDate);
      throw new AnnotatedException(paramPKIXExtendedParameters.toString(), paramDate);
    }
  }
  
  protected static void processCRLB1(DistributionPoint paramDistributionPoint, Object paramObject, X509CRL paramX509CRL)
    throws AnnotatedException
  {
    Object localObject = CertPathValidatorUtilities.getExtensionValue(paramX509CRL, ISSUING_DISTRIBUTION_POINT);
    int i = 0;
    int k = 0;
    int j;
    if ((localObject != null) && (IssuingDistributionPoint.getInstance(localObject).isIndirectCRL())) {
      j = 1;
    } else {
      j = 0;
    }
    try
    {
      localObject = PrincipalUtils.getIssuerPrincipal(paramX509CRL).getEncoded();
      if (paramDistributionPoint.getCRLIssuer() != null)
      {
        paramDistributionPoint = paramDistributionPoint.getCRLIssuer().getNames();
        int m;
        for (i = 0; k < paramDistributionPoint.length; i = m)
        {
          m = i;
          if (paramDistributionPoint[k].getTagNo() == 4) {
            try
            {
              boolean bool = Arrays.areEqual(paramDistributionPoint[k].getName().toASN1Primitive().getEncoded(), (byte[])localObject);
              m = i;
              if (bool) {
                m = 1;
              }
            }
            catch (IOException paramDistributionPoint)
            {
              throw new AnnotatedException("CRL issuer information from distribution point cannot be decoded.", paramDistributionPoint);
            }
          }
          k += 1;
        }
        if ((i != 0) && (j == 0)) {
          throw new AnnotatedException("Distribution point contains cRLIssuer field but CRL is not indirect.");
        }
        if (i == 0) {
          throw new AnnotatedException("CRL issuer of CRL does not match CRL issuer of distribution point.");
        }
      }
      else if (PrincipalUtils.getIssuerPrincipal(paramX509CRL).equals(PrincipalUtils.getEncodedIssuerPrincipal(paramObject)))
      {
        i = 1;
      }
      if (i != 0) {
        return;
      }
      throw new AnnotatedException("Cannot find matching CRL issuer for certificate.");
    }
    catch (IOException paramDistributionPoint)
    {
      paramObject = new StringBuilder();
      ((StringBuilder)paramObject).append("Exception encoding CRL issuer: ");
      ((StringBuilder)paramObject).append(paramDistributionPoint.getMessage());
      throw new AnnotatedException(((StringBuilder)paramObject).toString(), paramDistributionPoint);
    }
  }
  
  protected static void processCRLB2(DistributionPoint paramDistributionPoint, Object paramObject, X509CRL paramX509CRL)
    throws AnnotatedException
  {
    try
    {
      IssuingDistributionPoint localIssuingDistributionPoint = IssuingDistributionPoint.getInstance(CertPathValidatorUtilities.getExtensionValue(paramX509CRL, ISSUING_DISTRIBUTION_POINT));
      if (localIssuingDistributionPoint != null)
      {
        if (localIssuingDistributionPoint.getDistributionPoint() != null)
        {
          DistributionPointName localDistributionPointName = IssuingDistributionPoint.getInstance(localIssuingDistributionPoint).getDistributionPoint();
          ArrayList localArrayList = new ArrayList();
          int i = localDistributionPointName.getType();
          int m = 0;
          int k = 0;
          Object localObject;
          if (i == 0)
          {
            localObject = GeneralNames.getInstance(localDistributionPointName.getName()).getNames();
            i = 0;
            while (i < localObject.length)
            {
              localArrayList.add(localObject[i]);
              i += 1;
            }
          }
          if (localDistributionPointName.getType() == 1)
          {
            localObject = new ASN1EncodableVector();
            try
            {
              paramX509CRL = ASN1Sequence.getInstance(PrincipalUtils.getIssuerPrincipal(paramX509CRL)).getObjects();
              while (paramX509CRL.hasMoreElements()) {
                ((ASN1EncodableVector)localObject).add((ASN1Encodable)paramX509CRL.nextElement());
              }
              ((ASN1EncodableVector)localObject).add(localDistributionPointName.getName());
              localArrayList.add(new GeneralName(X500Name.getInstance(new DERSequence((ASN1EncodableVector)localObject))));
            }
            catch (Exception paramDistributionPoint)
            {
              throw new AnnotatedException("Could not read CRL issuer.", paramDistributionPoint);
            }
          }
          label299:
          int j;
          if (paramDistributionPoint.getDistributionPoint() != null)
          {
            localDistributionPointName = paramDistributionPoint.getDistributionPoint();
            paramX509CRL = null;
            if (localDistributionPointName.getType() == 0) {
              paramX509CRL = GeneralNames.getInstance(localDistributionPointName.getName()).getNames();
            }
            if (localDistributionPointName.getType() == 1)
            {
              if (paramDistributionPoint.getCRLIssuer() != null) {
                paramDistributionPoint = paramDistributionPoint.getCRLIssuer().getNames();
              }
              for (;;)
              {
                break label299;
                paramDistributionPoint = new GeneralName[1];
                try
                {
                  paramDistributionPoint[0] = new GeneralName(X500Name.getInstance(PrincipalUtils.getEncodedIssuerPrincipal(paramObject).getEncoded()));
                }
                catch (Exception paramDistributionPoint)
                {
                  throw new AnnotatedException("Could not read certificate issuer.", paramDistributionPoint);
                }
              }
              i = 0;
              for (;;)
              {
                paramX509CRL = paramDistributionPoint;
                if (i >= paramDistributionPoint.length) {
                  break;
                }
                paramX509CRL = ASN1Sequence.getInstance(paramDistributionPoint[i].getName().toASN1Primitive()).getObjects();
                localObject = new ASN1EncodableVector();
                while (paramX509CRL.hasMoreElements()) {
                  ((ASN1EncodableVector)localObject).add((ASN1Encodable)paramX509CRL.nextElement());
                }
                ((ASN1EncodableVector)localObject).add(localDistributionPointName.getName());
                paramDistributionPoint[i] = new GeneralName(X500Name.getInstance(new DERSequence((ASN1EncodableVector)localObject)));
                i += 1;
              }
            }
            j = k;
            if (paramX509CRL != null)
            {
              i = 0;
              for (;;)
              {
                j = k;
                if (i >= paramX509CRL.length) {
                  break;
                }
                if (localArrayList.contains(paramX509CRL[i]))
                {
                  j = 1;
                  break;
                }
                i += 1;
              }
            }
            if (j == 0) {
              throw new AnnotatedException("No match for certificate CRL issuing distribution point name to cRLIssuer CRL distribution point.");
            }
          }
          else if (paramDistributionPoint.getCRLIssuer() != null)
          {
            paramDistributionPoint = paramDistributionPoint.getCRLIssuer().getNames();
            i = 0;
            for (;;)
            {
              j = m;
              if (i >= paramDistributionPoint.length) {
                break;
              }
              if (localArrayList.contains(paramDistributionPoint[i]))
              {
                j = 1;
                break;
              }
              i += 1;
            }
            if (j == 0) {
              throw new AnnotatedException("No match for certificate CRL issuing distribution point name to cRLIssuer CRL distribution point.");
            }
          }
          else
          {
            throw new AnnotatedException("Either the cRLIssuer or the distributionPoint field must be contained in DistributionPoint.");
          }
        }
        try
        {
          paramDistributionPoint = BasicConstraints.getInstance(CertPathValidatorUtilities.getExtensionValue((X509Extension)paramObject, BASIC_CONSTRAINTS));
          if ((paramObject instanceof X509Certificate))
          {
            if ((localIssuingDistributionPoint.onlyContainsUserCerts()) && (paramDistributionPoint != null) && (paramDistributionPoint.isCA())) {
              throw new AnnotatedException("CA Cert CRL only contains user certificates.");
            }
            if ((localIssuingDistributionPoint.onlyContainsCACerts()) && ((paramDistributionPoint == null) || (!paramDistributionPoint.isCA()))) {
              throw new AnnotatedException("End CRL only contains CA certificates.");
            }
          }
          if (!localIssuingDistributionPoint.onlyContainsAttributeCerts()) {
            return;
          }
          throw new AnnotatedException("onlyContainsAttributeCerts boolean is asserted.");
        }
        catch (Exception paramDistributionPoint)
        {
          throw new AnnotatedException("Basic constraints extension could not be decoded.", paramDistributionPoint);
        }
      }
      return;
    }
    catch (Exception paramDistributionPoint)
    {
      throw new AnnotatedException("Issuing distribution point extension could not be decoded.", paramDistributionPoint);
    }
  }
  
  protected static void processCRLC(X509CRL paramX509CRL1, X509CRL paramX509CRL2, PKIXExtendedParameters paramPKIXExtendedParameters)
    throws AnnotatedException
  {
    if (paramX509CRL1 == null) {
      return;
    }
    try
    {
      IssuingDistributionPoint localIssuingDistributionPoint = IssuingDistributionPoint.getInstance(CertPathValidatorUtilities.getExtensionValue(paramX509CRL2, ISSUING_DISTRIBUTION_POINT));
      if (paramPKIXExtendedParameters.isUseDeltasEnabled()) {
        if (PrincipalUtils.getIssuerPrincipal(paramX509CRL1).equals(PrincipalUtils.getIssuerPrincipal(paramX509CRL2))) {
          try
          {
            paramPKIXExtendedParameters = IssuingDistributionPoint.getInstance(CertPathValidatorUtilities.getExtensionValue(paramX509CRL1, ISSUING_DISTRIBUTION_POINT));
            int i = 0;
            if (localIssuingDistributionPoint == null ? paramPKIXExtendedParameters == null : localIssuingDistributionPoint.equals(paramPKIXExtendedParameters)) {
              i = 1;
            }
            if (i != 0) {
              try
              {
                paramX509CRL2 = CertPathValidatorUtilities.getExtensionValue(paramX509CRL2, AUTHORITY_KEY_IDENTIFIER);
                try
                {
                  paramX509CRL1 = CertPathValidatorUtilities.getExtensionValue(paramX509CRL1, AUTHORITY_KEY_IDENTIFIER);
                  if (paramX509CRL2 != null)
                  {
                    if (paramX509CRL1 != null)
                    {
                      if (paramX509CRL2.equals(paramX509CRL1)) {
                        return;
                      }
                      throw new AnnotatedException("Delta CRL authority key identifier does not match complete CRL authority key identifier.");
                    }
                    throw new AnnotatedException("Delta CRL authority key identifier is null.");
                  }
                  throw new AnnotatedException("CRL authority key identifier is null.");
                }
                catch (AnnotatedException paramX509CRL1)
                {
                  throw new AnnotatedException("Authority key identifier extension could not be extracted from delta CRL.", paramX509CRL1);
                }
                throw new AnnotatedException("Issuing distribution point extension from delta CRL and complete CRL does not match.");
              }
              catch (AnnotatedException paramX509CRL1)
              {
                throw new AnnotatedException("Authority key identifier extension could not be extracted from complete CRL.", paramX509CRL1);
              }
            }
            throw new AnnotatedException("Complete CRL issuer does not match delta CRL issuer.");
          }
          catch (Exception paramX509CRL1)
          {
            throw new AnnotatedException("Issuing distribution point extension from delta CRL could not be decoded.", paramX509CRL1);
          }
        }
      }
      return;
    }
    catch (Exception paramX509CRL1)
    {
      throw new AnnotatedException("Issuing distribution point extension could not be decoded.", paramX509CRL1);
    }
  }
  
  protected static ReasonsMask processCRLD(X509CRL paramX509CRL, DistributionPoint paramDistributionPoint)
    throws AnnotatedException
  {
    try
    {
      IssuingDistributionPoint localIssuingDistributionPoint = IssuingDistributionPoint.getInstance(CertPathValidatorUtilities.getExtensionValue(paramX509CRL, ISSUING_DISTRIBUTION_POINT));
      if ((localIssuingDistributionPoint != null) && (localIssuingDistributionPoint.getOnlySomeReasons() != null) && (paramDistributionPoint.getReasons() != null)) {
        return new ReasonsMask(paramDistributionPoint.getReasons()).intersect(new ReasonsMask(localIssuingDistributionPoint.getOnlySomeReasons()));
      }
      if (((localIssuingDistributionPoint == null) || (localIssuingDistributionPoint.getOnlySomeReasons() == null)) && (paramDistributionPoint.getReasons() == null)) {
        return ReasonsMask.allReasons;
      }
      if (paramDistributionPoint.getReasons() == null) {
        paramX509CRL = ReasonsMask.allReasons;
      } else {
        paramX509CRL = new ReasonsMask(paramDistributionPoint.getReasons());
      }
      if (localIssuingDistributionPoint == null) {
        paramDistributionPoint = ReasonsMask.allReasons;
      } else {
        paramDistributionPoint = new ReasonsMask(localIssuingDistributionPoint.getOnlySomeReasons());
      }
      return paramX509CRL.intersect(paramDistributionPoint);
    }
    catch (Exception paramX509CRL)
    {
      throw new AnnotatedException("Issuing distribution point extension could not be decoded.", paramX509CRL);
    }
  }
  
  /* Error */
  protected static Set processCRLF(X509CRL paramX509CRL, Object paramObject, X509Certificate paramX509Certificate, PublicKey paramPublicKey, PKIXExtendedParameters paramPKIXExtendedParameters, List paramList, JcaJceHelper paramJcaJceHelper)
    throws AnnotatedException
  {
    // Byte code:
    //   0: new 912	java/security/cert/X509CertSelector
    //   3: dup
    //   4: invokespecial 913	java/security/cert/X509CertSelector:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: aload_0
    //   10: invokestatic 747	org/bouncycastle/jce/provider/PrincipalUtils:getIssuerPrincipal	(Ljava/security/cert/X509CRL;)Lorg/bouncycastle/asn1/x500/X500Name;
    //   13: invokevirtual 373	org/bouncycastle/asn1/x500/X500Name:getEncoded	()[B
    //   16: invokevirtual 916	java/security/cert/X509CertSelector:setSubject	([B)V
    //   19: new 918	org/bouncycastle/jcajce/PKIXCertStoreSelector$Builder
    //   22: dup
    //   23: aload_1
    //   24: invokespecial 921	org/bouncycastle/jcajce/PKIXCertStoreSelector$Builder:<init>	(Ljava/security/cert/CertSelector;)V
    //   27: invokevirtual 924	org/bouncycastle/jcajce/PKIXCertStoreSelector$Builder:build	()Lorg/bouncycastle/jcajce/PKIXCertStoreSelector;
    //   30: astore_0
    //   31: aload_0
    //   32: aload 4
    //   34: invokevirtual 927	org/bouncycastle/jcajce/PKIXExtendedParameters:getCertificateStores	()Ljava/util/List;
    //   37: invokestatic 931	org/bouncycastle/jce/provider/CertPathValidatorUtilities:findCertificates	(Lorg/bouncycastle/jcajce/PKIXCertStoreSelector;Ljava/util/List;)Ljava/util/Collection;
    //   40: astore_1
    //   41: aload_1
    //   42: aload_0
    //   43: aload 4
    //   45: invokevirtual 229	org/bouncycastle/jcajce/PKIXExtendedParameters:getCertStores	()Ljava/util/List;
    //   48: invokestatic 931	org/bouncycastle/jce/provider/CertPathValidatorUtilities:findCertificates	(Lorg/bouncycastle/jcajce/PKIXCertStoreSelector;Ljava/util/List;)Ljava/util/Collection;
    //   51: invokeinterface 934 2 0
    //   56: pop
    //   57: aload_1
    //   58: aload_2
    //   59: invokeinterface 935 2 0
    //   64: pop
    //   65: aload_1
    //   66: invokeinterface 936 1 0
    //   71: astore_0
    //   72: new 557	java/util/ArrayList
    //   75: dup
    //   76: invokespecial 558	java/util/ArrayList:<init>	()V
    //   79: astore_1
    //   80: new 557	java/util/ArrayList
    //   83: dup
    //   84: invokespecial 558	java/util/ArrayList:<init>	()V
    //   87: astore 9
    //   89: aload_0
    //   90: invokeinterface 183 1 0
    //   95: istore 8
    //   97: iconst_0
    //   98: istore 7
    //   100: iload 8
    //   102: ifeq +219 -> 321
    //   105: aload_0
    //   106: invokeinterface 198 1 0
    //   111: checkcast 245	java/security/cert/X509Certificate
    //   114: astore 10
    //   116: aload 10
    //   118: aload_2
    //   119: invokevirtual 937	java/security/cert/X509Certificate:equals	(Ljava/lang/Object;)Z
    //   122: ifeq +24 -> 146
    //   125: aload_1
    //   126: aload 10
    //   128: invokeinterface 566 2 0
    //   133: pop
    //   134: aload 9
    //   136: aload_3
    //   137: invokeinterface 566 2 0
    //   142: pop
    //   143: goto -54 -> 89
    //   146: new 939	org/bouncycastle/jce/provider/PKIXCertPathBuilderSpi
    //   149: dup
    //   150: invokespecial 940	org/bouncycastle/jce/provider/PKIXCertPathBuilderSpi:<init>	()V
    //   153: astore 11
    //   155: new 912	java/security/cert/X509CertSelector
    //   158: dup
    //   159: invokespecial 913	java/security/cert/X509CertSelector:<init>	()V
    //   162: astore 12
    //   164: aload 12
    //   166: aload 10
    //   168: invokevirtual 943	java/security/cert/X509CertSelector:setCertificate	(Ljava/security/cert/X509Certificate;)V
    //   171: new 322	org/bouncycastle/jcajce/PKIXExtendedParameters$Builder
    //   174: dup
    //   175: aload 4
    //   177: invokespecial 325	org/bouncycastle/jcajce/PKIXExtendedParameters$Builder:<init>	(Lorg/bouncycastle/jcajce/PKIXExtendedParameters;)V
    //   180: new 918	org/bouncycastle/jcajce/PKIXCertStoreSelector$Builder
    //   183: dup
    //   184: aload 12
    //   186: invokespecial 921	org/bouncycastle/jcajce/PKIXCertStoreSelector$Builder:<init>	(Ljava/security/cert/CertSelector;)V
    //   189: invokevirtual 924	org/bouncycastle/jcajce/PKIXCertStoreSelector$Builder:build	()Lorg/bouncycastle/jcajce/PKIXCertStoreSelector;
    //   192: invokevirtual 947	org/bouncycastle/jcajce/PKIXExtendedParameters$Builder:setTargetConstraints	(Lorg/bouncycastle/jcajce/PKIXCertStoreSelector;)Lorg/bouncycastle/jcajce/PKIXExtendedParameters$Builder;
    //   195: astore 12
    //   197: aload 5
    //   199: aload 10
    //   201: invokeinterface 847 2 0
    //   206: ifeq +12 -> 218
    //   209: aload 12
    //   211: iconst_0
    //   212: invokevirtual 951	org/bouncycastle/jcajce/PKIXExtendedParameters$Builder:setRevocationEnabled	(Z)V
    //   215: goto +9 -> 224
    //   218: aload 12
    //   220: iconst_1
    //   221: invokevirtual 951	org/bouncycastle/jcajce/PKIXExtendedParameters$Builder:setRevocationEnabled	(Z)V
    //   224: aload 11
    //   226: new 953	org/bouncycastle/jcajce/PKIXExtendedBuilderParameters$Builder
    //   229: dup
    //   230: aload 12
    //   232: invokevirtual 348	org/bouncycastle/jcajce/PKIXExtendedParameters$Builder:build	()Lorg/bouncycastle/jcajce/PKIXExtendedParameters;
    //   235: invokespecial 954	org/bouncycastle/jcajce/PKIXExtendedBuilderParameters$Builder:<init>	(Lorg/bouncycastle/jcajce/PKIXExtendedParameters;)V
    //   238: invokevirtual 957	org/bouncycastle/jcajce/PKIXExtendedBuilderParameters$Builder:build	()Lorg/bouncycastle/jcajce/PKIXExtendedBuilderParameters;
    //   241: invokevirtual 961	org/bouncycastle/jce/provider/PKIXCertPathBuilderSpi:engineBuild	(Ljava/security/cert/CertPathParameters;)Ljava/security/cert/CertPathBuilderResult;
    //   244: invokeinterface 967 1 0
    //   249: invokevirtual 458	java/security/cert/CertPath:getCertificates	()Ljava/util/List;
    //   252: astore 11
    //   254: aload_1
    //   255: aload 10
    //   257: invokeinterface 566 2 0
    //   262: pop
    //   263: aload 9
    //   265: aload 11
    //   267: iconst_0
    //   268: aload 6
    //   270: invokestatic 971	org/bouncycastle/jce/provider/CertPathValidatorUtilities:getNextWorkingKey	(Ljava/util/List;ILorg/bouncycastle/jcajce/util/JcaJceHelper;)Ljava/security/PublicKey;
    //   273: invokeinterface 566 2 0
    //   278: pop
    //   279: goto -190 -> 89
    //   282: astore_0
    //   283: new 151	org/bouncycastle/jce/provider/AnnotatedException
    //   286: dup
    //   287: aload_0
    //   288: invokevirtual 972	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   291: invokespecial 256	org/bouncycastle/jce/provider/AnnotatedException:<init>	(Ljava/lang/String;)V
    //   294: athrow
    //   295: astore_0
    //   296: new 151	org/bouncycastle/jce/provider/AnnotatedException
    //   299: dup
    //   300: ldc_w 974
    //   303: aload_0
    //   304: invokespecial 359	org/bouncycastle/jce/provider/AnnotatedException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   307: athrow
    //   308: astore_0
    //   309: new 151	org/bouncycastle/jce/provider/AnnotatedException
    //   312: dup
    //   313: ldc_w 976
    //   316: aload_0
    //   317: invokespecial 359	org/bouncycastle/jce/provider/AnnotatedException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   320: athrow
    //   321: new 289	java/util/HashSet
    //   324: dup
    //   325: invokespecial 474	java/util/HashSet:<init>	()V
    //   328: astore_2
    //   329: aconst_null
    //   330: astore_0
    //   331: iload 7
    //   333: aload_1
    //   334: invokeinterface 465 1 0
    //   339: if_icmpge +75 -> 414
    //   342: aload_1
    //   343: iload 7
    //   345: invokeinterface 462 2 0
    //   350: checkcast 245	java/security/cert/X509Certificate
    //   353: invokevirtual 695	java/security/cert/X509Certificate:getKeyUsage	()[Z
    //   356: astore_3
    //   357: aload_3
    //   358: ifnull +31 -> 389
    //   361: aload_3
    //   362: arraylength
    //   363: bipush 7
    //   365: if_icmplt +10 -> 375
    //   368: aload_3
    //   369: bipush 6
    //   371: baload
    //   372: ifne +17 -> 389
    //   375: new 151	org/bouncycastle/jce/provider/AnnotatedException
    //   378: dup
    //   379: ldc_w 978
    //   382: invokespecial 256	org/bouncycastle/jce/provider/AnnotatedException:<init>	(Ljava/lang/String;)V
    //   385: astore_0
    //   386: goto +19 -> 405
    //   389: aload_2
    //   390: aload 9
    //   392: iload 7
    //   394: invokeinterface 462 2 0
    //   399: invokeinterface 489 2 0
    //   404: pop
    //   405: iload 7
    //   407: iconst_1
    //   408: iadd
    //   409: istore 7
    //   411: goto -80 -> 331
    //   414: aload_2
    //   415: invokeinterface 299 1 0
    //   420: ifeq +21 -> 441
    //   423: aload_0
    //   424: ifnull +6 -> 430
    //   427: goto +14 -> 441
    //   430: new 151	org/bouncycastle/jce/provider/AnnotatedException
    //   433: dup
    //   434: ldc_w 980
    //   437: invokespecial 256	org/bouncycastle/jce/provider/AnnotatedException:<init>	(Ljava/lang/String;)V
    //   440: athrow
    //   441: aload_2
    //   442: invokeinterface 299 1 0
    //   447: ifeq +11 -> 458
    //   450: aload_0
    //   451: ifnonnull +5 -> 456
    //   454: aload_2
    //   455: areturn
    //   456: aload_0
    //   457: athrow
    //   458: aload_2
    //   459: areturn
    //   460: astore_0
    //   461: new 151	org/bouncycastle/jce/provider/AnnotatedException
    //   464: dup
    //   465: ldc_w 982
    //   468: aload_0
    //   469: invokespecial 359	org/bouncycastle/jce/provider/AnnotatedException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   472: athrow
    //   473: astore_0
    //   474: new 151	org/bouncycastle/jce/provider/AnnotatedException
    //   477: dup
    //   478: ldc_w 984
    //   481: aload_0
    //   482: invokespecial 359	org/bouncycastle/jce/provider/AnnotatedException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   485: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	486	0	paramX509CRL	X509CRL
    //   0	486	1	paramObject	Object
    //   0	486	2	paramX509Certificate	X509Certificate
    //   0	486	3	paramPublicKey	PublicKey
    //   0	486	4	paramPKIXExtendedParameters	PKIXExtendedParameters
    //   0	486	5	paramList	List
    //   0	486	6	paramJcaJceHelper	JcaJceHelper
    //   98	312	7	i	int
    //   95	6	8	bool	boolean
    //   87	304	9	localArrayList	ArrayList
    //   114	142	10	localX509Certificate	X509Certificate
    //   153	113	11	localObject1	Object
    //   162	69	12	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   146	215	282	java/lang/Exception
    //   218	224	282	java/lang/Exception
    //   224	279	282	java/lang/Exception
    //   146	215	295	java/security/cert/CertPathValidatorException
    //   218	224	295	java/security/cert/CertPathValidatorException
    //   224	279	295	java/security/cert/CertPathValidatorException
    //   146	215	308	java/security/cert/CertPathBuilderException
    //   218	224	308	java/security/cert/CertPathBuilderException
    //   224	279	308	java/security/cert/CertPathBuilderException
    //   31	57	460	org/bouncycastle/jce/provider/AnnotatedException
    //   8	19	473	java/io/IOException
  }
  
  protected static PublicKey processCRLG(X509CRL paramX509CRL, Set paramSet)
    throws AnnotatedException
  {
    Iterator localIterator = paramSet.iterator();
    paramSet = null;
    while (localIterator.hasNext())
    {
      paramSet = (PublicKey)localIterator.next();
      try
      {
        paramX509CRL.verify(paramSet);
        return paramSet;
      }
      catch (Exception paramSet) {}
    }
    throw new AnnotatedException("Cannot verify CRL.", paramSet);
  }
  
  protected static X509CRL processCRLH(Set paramSet, PublicKey paramPublicKey)
    throws AnnotatedException
  {
    Iterator localIterator = paramSet.iterator();
    paramSet = null;
    while (localIterator.hasNext())
    {
      paramSet = (X509CRL)localIterator.next();
      try
      {
        paramSet.verify(paramPublicKey);
        return paramSet;
      }
      catch (Exception paramSet) {}
    }
    if (paramSet == null) {
      return null;
    }
    throw new AnnotatedException("Cannot verify delta CRL.", paramSet);
  }
  
  protected static void processCRLI(Date paramDate, X509CRL paramX509CRL, Object paramObject, CertStatus paramCertStatus, PKIXExtendedParameters paramPKIXExtendedParameters)
    throws AnnotatedException
  {
    if ((paramPKIXExtendedParameters.isUseDeltasEnabled()) && (paramX509CRL != null)) {
      CertPathValidatorUtilities.getCertStatus(paramDate, paramX509CRL, paramObject, paramCertStatus);
    }
  }
  
  protected static void processCRLJ(Date paramDate, X509CRL paramX509CRL, Object paramObject, CertStatus paramCertStatus)
    throws AnnotatedException
  {
    if (paramCertStatus.getCertStatus() == 11) {
      CertPathValidatorUtilities.getCertStatus(paramDate, paramX509CRL, paramObject, paramCertStatus);
    }
  }
  
  protected static void processCertA(CertPath paramCertPath, PKIXExtendedParameters paramPKIXExtendedParameters, int paramInt, PublicKey paramPublicKey, boolean paramBoolean, X500Name paramX500Name, X509Certificate paramX509Certificate, JcaJceHelper paramJcaJceHelper)
    throws ExtCertPathValidatorException
  {
    List localList = paramCertPath.getCertificates();
    X509Certificate localX509Certificate = (X509Certificate)localList.get(paramInt);
    if (!paramBoolean) {
      try
      {
        CertPathValidatorUtilities.verifyX509Certificate(localX509Certificate, paramPublicKey, paramPKIXExtendedParameters.getSigProvider());
      }
      catch (GeneralSecurityException paramPKIXExtendedParameters)
      {
        throw new ExtCertPathValidatorException("Could not validate certificate signature.", paramPKIXExtendedParameters, paramCertPath, paramInt);
      }
    }
    try
    {
      localX509Certificate.checkValidity(CertPathValidatorUtilities.getValidCertDateFromValidityModel(paramPKIXExtendedParameters, paramCertPath, paramInt));
      if (paramPKIXExtendedParameters.isRevocationEnabled()) {
        try
        {
          checkCRLs(paramPKIXExtendedParameters, localX509Certificate, CertPathValidatorUtilities.getValidCertDateFromValidityModel(paramPKIXExtendedParameters, paramCertPath, paramInt), paramX509Certificate, paramPublicKey, localList, paramJcaJceHelper);
        }
        catch (AnnotatedException paramPublicKey)
        {
          if (paramPublicKey.getCause() != null) {
            paramPKIXExtendedParameters = paramPublicKey.getCause();
          } else {
            paramPKIXExtendedParameters = paramPublicKey;
          }
          throw new ExtCertPathValidatorException(paramPublicKey.getMessage(), paramPKIXExtendedParameters, paramCertPath, paramInt);
        }
      }
      if (PrincipalUtils.getEncodedIssuerPrincipal(localX509Certificate).equals(paramX500Name)) {
        return;
      }
      paramPKIXExtendedParameters = new StringBuilder();
      paramPKIXExtendedParameters.append("IssuerName(");
      paramPKIXExtendedParameters.append(PrincipalUtils.getEncodedIssuerPrincipal(localX509Certificate));
      paramPKIXExtendedParameters.append(") does not match SubjectName(");
      paramPKIXExtendedParameters.append(paramX500Name);
      paramPKIXExtendedParameters.append(") of signing certificate.");
      throw new ExtCertPathValidatorException(paramPKIXExtendedParameters.toString(), null, paramCertPath, paramInt);
    }
    catch (AnnotatedException paramPKIXExtendedParameters)
    {
      throw new ExtCertPathValidatorException("Could not validate time of certificate.", paramPKIXExtendedParameters, paramCertPath, paramInt);
    }
    catch (CertificateNotYetValidException paramPKIXExtendedParameters)
    {
      paramPublicKey = new StringBuilder();
      paramPublicKey.append("Could not validate certificate: ");
      paramPublicKey.append(paramPKIXExtendedParameters.getMessage());
      throw new ExtCertPathValidatorException(paramPublicKey.toString(), paramPKIXExtendedParameters, paramCertPath, paramInt);
    }
    catch (CertificateExpiredException paramPKIXExtendedParameters)
    {
      paramPublicKey = new StringBuilder();
      paramPublicKey.append("Could not validate certificate: ");
      paramPublicKey.append(paramPKIXExtendedParameters.getMessage());
      throw new ExtCertPathValidatorException(paramPublicKey.toString(), paramPKIXExtendedParameters, paramCertPath, paramInt);
    }
  }
  
  /* Error */
  protected static void processCertBC(CertPath paramCertPath, int paramInt, PKIXNameConstraintValidator paramPKIXNameConstraintValidator)
    throws CertPathValidatorException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 458	java/security/cert/CertPath:getCertificates	()Ljava/util/List;
    //   4: astore 6
    //   6: aload 6
    //   8: iload_1
    //   9: invokeinterface 462 2 0
    //   14: checkcast 245	java/security/cert/X509Certificate
    //   17: astore 5
    //   19: aload 6
    //   21: invokeinterface 465 1 0
    //   26: istore_3
    //   27: aload 5
    //   29: invokestatic 629	org/bouncycastle/jce/provider/CertPathValidatorUtilities:isSelfIssued	(Ljava/security/cert/X509Certificate;)Z
    //   32: ifeq +10 -> 42
    //   35: iload_3
    //   36: iload_1
    //   37: isub
    //   38: iload_3
    //   39: if_icmplt +207 -> 246
    //   42: aload 5
    //   44: invokestatic 1047	org/bouncycastle/jce/provider/PrincipalUtils:getSubjectPrincipal	(Ljava/security/cert/X509Certificate;)Lorg/bouncycastle/asn1/x500/X500Name;
    //   47: astore 6
    //   49: aload 6
    //   51: invokevirtual 373	org/bouncycastle/asn1/x500/X500Name:getEncoded	()[B
    //   54: invokestatic 470	org/bouncycastle/asn1/DERSequence:getInstance	(Ljava/lang/Object;)Lorg/bouncycastle/asn1/ASN1Sequence;
    //   57: astore 6
    //   59: aload_2
    //   60: aload 6
    //   62: invokevirtual 1051	org/bouncycastle/jce/provider/PKIXNameConstraintValidator:checkPermittedDN	(Lorg/bouncycastle/asn1/ASN1Sequence;)V
    //   65: aload_2
    //   66: aload 6
    //   68: invokevirtual 1054	org/bouncycastle/jce/provider/PKIXNameConstraintValidator:checkExcludedDN	(Lorg/bouncycastle/asn1/ASN1Sequence;)V
    //   71: aload 5
    //   73: getstatic 99	org/bouncycastle/jce/provider/RFC3280CertPathUtilities:SUBJECT_ALTERNATIVE_NAME	Ljava/lang/String;
    //   76: invokestatic 314	org/bouncycastle/jce/provider/CertPathValidatorUtilities:getExtensionValue	(Ljava/security/cert/X509Extension;Ljava/lang/String;)Lorg/bouncycastle/asn1/ASN1Primitive;
    //   79: invokestatic 826	org/bouncycastle/asn1/x509/GeneralNames:getInstance	(Ljava/lang/Object;)Lorg/bouncycastle/asn1/x509/GeneralNames;
    //   82: astore 5
    //   84: aload 6
    //   86: invokestatic 838	org/bouncycastle/asn1/x500/X500Name:getInstance	(Ljava/lang/Object;)Lorg/bouncycastle/asn1/x500/X500Name;
    //   89: getstatic 1059	org/bouncycastle/asn1/x500/style/BCStyle:EmailAddress	Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;
    //   92: invokevirtual 1063	org/bouncycastle/asn1/x500/X500Name:getRDNs	(Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;)[Lorg/bouncycastle/asn1/x500/RDN;
    //   95: astore 6
    //   97: iconst_0
    //   98: istore 4
    //   100: iconst_0
    //   101: istore_3
    //   102: iload_3
    //   103: aload 6
    //   105: arraylength
    //   106: if_icmpeq +65 -> 171
    //   109: new 388	org/bouncycastle/asn1/x509/GeneralName
    //   112: dup
    //   113: iconst_1
    //   114: aload 6
    //   116: iload_3
    //   117: aaload
    //   118: invokevirtual 1069	org/bouncycastle/asn1/x500/RDN:getFirst	()Lorg/bouncycastle/asn1/x500/AttributeTypeAndValue;
    //   121: invokevirtual 1073	org/bouncycastle/asn1/x500/AttributeTypeAndValue:getValue	()Lorg/bouncycastle/asn1/ASN1Encodable;
    //   124: checkcast 1075	org/bouncycastle/asn1/ASN1String
    //   127: invokeinterface 1078 1 0
    //   132: invokespecial 1081	org/bouncycastle/asn1/x509/GeneralName:<init>	(ILjava/lang/String;)V
    //   135: astore 7
    //   137: aload_2
    //   138: aload 7
    //   140: invokevirtual 1084	org/bouncycastle/jce/provider/PKIXNameConstraintValidator:checkPermitted	(Lorg/bouncycastle/asn1/x509/GeneralName;)V
    //   143: aload_2
    //   144: aload 7
    //   146: invokevirtual 1087	org/bouncycastle/jce/provider/PKIXNameConstraintValidator:checkExcluded	(Lorg/bouncycastle/asn1/x509/GeneralName;)V
    //   149: iload_3
    //   150: iconst_1
    //   151: iadd
    //   152: istore_3
    //   153: goto -51 -> 102
    //   156: astore_2
    //   157: new 453	java/security/cert/CertPathValidatorException
    //   160: dup
    //   161: ldc_w 1089
    //   164: aload_2
    //   165: aload_0
    //   166: iload_1
    //   167: invokespecial 547	java/security/cert/CertPathValidatorException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/security/cert/CertPath;I)V
    //   170: athrow
    //   171: aload 5
    //   173: ifnull +73 -> 246
    //   176: aload 5
    //   178: invokevirtual 784	org/bouncycastle/asn1/x509/GeneralNames:getNames	()[Lorg/bouncycastle/asn1/x509/GeneralName;
    //   181: astore 5
    //   183: iload 4
    //   185: istore_3
    //   186: iload_3
    //   187: aload 5
    //   189: arraylength
    //   190: if_icmpge +56 -> 246
    //   193: aload_2
    //   194: aload 5
    //   196: iload_3
    //   197: aaload
    //   198: invokevirtual 1084	org/bouncycastle/jce/provider/PKIXNameConstraintValidator:checkPermitted	(Lorg/bouncycastle/asn1/x509/GeneralName;)V
    //   201: aload_2
    //   202: aload 5
    //   204: iload_3
    //   205: aaload
    //   206: invokevirtual 1087	org/bouncycastle/jce/provider/PKIXNameConstraintValidator:checkExcluded	(Lorg/bouncycastle/asn1/x509/GeneralName;)V
    //   209: iload_3
    //   210: iconst_1
    //   211: iadd
    //   212: istore_3
    //   213: goto -27 -> 186
    //   216: astore_2
    //   217: new 453	java/security/cert/CertPathValidatorException
    //   220: dup
    //   221: ldc_w 1091
    //   224: aload_2
    //   225: aload_0
    //   226: iload_1
    //   227: invokespecial 547	java/security/cert/CertPathValidatorException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/security/cert/CertPath;I)V
    //   230: athrow
    //   231: astore_2
    //   232: new 453	java/security/cert/CertPathValidatorException
    //   235: dup
    //   236: ldc_w 1093
    //   239: aload_2
    //   240: aload_0
    //   241: iload_1
    //   242: invokespecial 547	java/security/cert/CertPathValidatorException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/security/cert/CertPath;I)V
    //   245: athrow
    //   246: return
    //   247: astore_2
    //   248: new 453	java/security/cert/CertPathValidatorException
    //   251: dup
    //   252: ldc_w 1095
    //   255: aload_2
    //   256: aload_0
    //   257: iload_1
    //   258: invokespecial 547	java/security/cert/CertPathValidatorException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/security/cert/CertPath;I)V
    //   261: athrow
    //   262: astore_2
    //   263: new 453	java/security/cert/CertPathValidatorException
    //   266: dup
    //   267: ldc_w 1097
    //   270: aload_2
    //   271: aload_0
    //   272: iload_1
    //   273: invokespecial 547	java/security/cert/CertPathValidatorException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/security/cert/CertPath;I)V
    //   276: athrow
    //   277: astore_2
    //   278: new 453	java/security/cert/CertPathValidatorException
    //   281: dup
    //   282: ldc_w 1099
    //   285: aload_2
    //   286: aload_0
    //   287: iload_1
    //   288: invokespecial 547	java/security/cert/CertPathValidatorException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/security/cert/CertPath;I)V
    //   291: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	paramCertPath	CertPath
    //   0	292	1	paramInt	int
    //   0	292	2	paramPKIXNameConstraintValidator	PKIXNameConstraintValidator
    //   26	187	3	i	int
    //   98	86	4	j	int
    //   17	186	5	localObject1	Object
    //   4	111	6	localObject2	Object
    //   135	10	7	localGeneralName	GeneralName
    // Exception table:
    //   from	to	target	type
    //   137	149	156	org/bouncycastle/jce/provider/PKIXNameConstraintValidatorException
    //   193	209	216	org/bouncycastle/jce/provider/PKIXNameConstraintValidatorException
    //   176	183	231	java/lang/Exception
    //   71	84	247	java/lang/Exception
    //   59	71	262	org/bouncycastle/jce/provider/PKIXNameConstraintValidatorException
    //   49	59	277	java/lang/Exception
  }
  
  protected static PKIXPolicyNode processCertD(CertPath paramCertPath, int paramInt1, Set paramSet, PKIXPolicyNode paramPKIXPolicyNode, List[] paramArrayOfList, int paramInt2)
    throws CertPathValidatorException
  {
    Object localObject1 = paramCertPath.getCertificates();
    X509Certificate localX509Certificate = (X509Certificate)((List)localObject1).get(paramInt1);
    int j = ((List)localObject1).size();
    int i = j - paramInt1;
    try
    {
      localObject1 = DERSequence.getInstance(CertPathValidatorUtilities.getExtensionValue(localX509Certificate, CERTIFICATE_POLICIES));
      if ((localObject1 != null) && (paramPKIXPolicyNode != null))
      {
        Object localObject3 = ((ASN1Sequence)localObject1).getObjects();
        Object localObject2 = new HashSet();
        Object localObject4;
        while (((Enumeration)localObject3).hasMoreElements())
        {
          Object localObject5 = PolicyInformation.getInstance(((Enumeration)localObject3).nextElement());
          localObject4 = ((PolicyInformation)localObject5).getPolicyIdentifier();
          ((Set)localObject2).add(((ASN1ObjectIdentifier)localObject4).getId());
          if (!"2.5.29.32.0".equals(((ASN1ObjectIdentifier)localObject4).getId())) {
            try
            {
              localObject5 = CertPathValidatorUtilities.getQualifierSet(((PolicyInformation)localObject5).getPolicyQualifiers());
              if (!CertPathValidatorUtilities.processCertD1i(i, paramArrayOfList, (ASN1ObjectIdentifier)localObject4, (Set)localObject5)) {
                CertPathValidatorUtilities.processCertD1ii(i, paramArrayOfList, (ASN1ObjectIdentifier)localObject4, (Set)localObject5);
              }
            }
            catch (CertPathValidatorException paramSet)
            {
              throw new ExtCertPathValidatorException("Policy qualifier info set could not be build.", paramSet, paramCertPath, paramInt1);
            }
          }
        }
        if ((!paramSet.isEmpty()) && (!paramSet.contains("2.5.29.32.0")))
        {
          paramCertPath = paramSet.iterator();
          localObject3 = new HashSet();
          while (paramCertPath.hasNext())
          {
            localObject4 = paramCertPath.next();
            if (((Set)localObject2).contains(localObject4)) {
              ((Set)localObject3).add(localObject4);
            }
          }
          paramSet.clear();
          paramSet.addAll((Collection)localObject3);
        }
        else
        {
          paramSet.clear();
          paramSet.addAll((Collection)localObject2);
        }
        if ((paramInt2 > 0) || ((i < j) && (CertPathValidatorUtilities.isSelfIssued(localX509Certificate))))
        {
          paramCertPath = ((ASN1Sequence)localObject1).getObjects();
          while (paramCertPath.hasMoreElements())
          {
            paramSet = PolicyInformation.getInstance(paramCertPath.nextElement());
            if ("2.5.29.32.0".equals(paramSet.getPolicyIdentifier().getId()))
            {
              paramSet = CertPathValidatorUtilities.getQualifierSet(paramSet.getPolicyQualifiers());
              localObject1 = paramArrayOfList[(i - 1)];
              paramInt1 = 0;
              while (paramInt1 < ((List)localObject1).size())
              {
                localObject2 = (PKIXPolicyNode)((List)localObject1).get(paramInt1);
                localObject3 = ((PKIXPolicyNode)localObject2).getExpectedPolicies().iterator();
                while (((Iterator)localObject3).hasNext())
                {
                  paramCertPath = ((Iterator)localObject3).next();
                  if ((paramCertPath instanceof String)) {
                    paramCertPath = (String)paramCertPath;
                  }
                  for (;;)
                  {
                    break label460;
                    if ((paramCertPath instanceof ASN1ObjectIdentifier)) {
                      paramCertPath = ((ASN1ObjectIdentifier)paramCertPath).getId();
                    } else {
                      break;
                    }
                  }
                  label460:
                  localObject4 = ((PKIXPolicyNode)localObject2).getChildren();
                  paramInt2 = 0;
                  while (((Iterator)localObject4).hasNext()) {
                    if (paramCertPath.equals(((PKIXPolicyNode)((Iterator)localObject4).next()).getValidPolicy())) {
                      paramInt2 = 1;
                    }
                  }
                  if (paramInt2 == 0)
                  {
                    localObject4 = new HashSet();
                    ((Set)localObject4).add(paramCertPath);
                    paramCertPath = new PKIXPolicyNode(new ArrayList(), i, (Set)localObject4, (PolicyNode)localObject2, paramSet, paramCertPath, false);
                    ((PKIXPolicyNode)localObject2).addChild(paramCertPath);
                    paramArrayOfList[i].add(paramCertPath);
                  }
                }
                paramInt1 += 1;
              }
            }
          }
        }
        paramInt1 = i - 1;
        for (paramCertPath = paramPKIXPolicyNode; paramInt1 >= 0; paramCertPath = paramSet)
        {
          paramPKIXPolicyNode = paramArrayOfList[paramInt1];
          paramInt2 = 0;
          for (;;)
          {
            paramSet = paramCertPath;
            if (paramInt2 >= paramPKIXPolicyNode.size()) {
              break;
            }
            localObject1 = (PKIXPolicyNode)paramPKIXPolicyNode.get(paramInt2);
            paramSet = paramCertPath;
            if (!((PKIXPolicyNode)localObject1).hasChildren())
            {
              paramCertPath = CertPathValidatorUtilities.removePolicyNode(paramCertPath, paramArrayOfList, (PKIXPolicyNode)localObject1);
              paramSet = paramCertPath;
              if (paramCertPath == null)
              {
                paramSet = paramCertPath;
                break;
              }
            }
            paramInt2 += 1;
            paramCertPath = paramSet;
          }
          paramInt1 -= 1;
        }
        paramSet = localX509Certificate.getCriticalExtensionOIDs();
        if (paramSet != null)
        {
          boolean bool = paramSet.contains(CERTIFICATE_POLICIES);
          paramSet = paramArrayOfList[i];
          paramInt1 = 0;
          while (paramInt1 < paramSet.size())
          {
            ((PKIXPolicyNode)paramSet.get(paramInt1)).setCritical(bool);
            paramInt1 += 1;
          }
        }
        return paramCertPath;
      }
      return null;
    }
    catch (AnnotatedException paramSet)
    {
      throw new ExtCertPathValidatorException("Could not read certificate policies extension from certificate.", paramSet, paramCertPath, paramInt1);
    }
  }
  
  protected static PKIXPolicyNode processCertE(CertPath paramCertPath, int paramInt, PKIXPolicyNode paramPKIXPolicyNode)
    throws CertPathValidatorException
  {
    Object localObject = (X509Certificate)paramCertPath.getCertificates().get(paramInt);
    try
    {
      localObject = DERSequence.getInstance(CertPathValidatorUtilities.getExtensionValue((X509Extension)localObject, CERTIFICATE_POLICIES));
      if (localObject == null) {
        paramPKIXPolicyNode = null;
      }
      return paramPKIXPolicyNode;
    }
    catch (AnnotatedException paramPKIXPolicyNode)
    {
      throw new ExtCertPathValidatorException("Could not read certificate policies extension from certificate.", paramPKIXPolicyNode, paramCertPath, paramInt);
    }
  }
  
  protected static void processCertF(CertPath paramCertPath, int paramInt1, PKIXPolicyNode paramPKIXPolicyNode, int paramInt2)
    throws CertPathValidatorException
  {
    if (paramInt2 <= 0)
    {
      if (paramPKIXPolicyNode != null) {
        return;
      }
      throw new ExtCertPathValidatorException("No valid policy tree found when one expected.", null, paramCertPath, paramInt1);
    }
  }
  
  protected static int wrapupCertA(int paramInt, X509Certificate paramX509Certificate)
  {
    int i = paramInt;
    if (!CertPathValidatorUtilities.isSelfIssued(paramX509Certificate))
    {
      i = paramInt;
      if (paramInt != 0) {
        i = paramInt - 1;
      }
    }
    return i;
  }
  
  protected static int wrapupCertB(CertPath paramCertPath, int paramInt1, int paramInt2)
    throws CertPathValidatorException
  {
    Object localObject = (X509Certificate)paramCertPath.getCertificates().get(paramInt1);
    try
    {
      localObject = DERSequence.getInstance(CertPathValidatorUtilities.getExtensionValue((X509Extension)localObject, POLICY_CONSTRAINTS));
      if (localObject != null)
      {
        localObject = ((ASN1Sequence)localObject).getObjects();
        while (((Enumeration)localObject).hasMoreElements())
        {
          ASN1TaggedObject localASN1TaggedObject = (ASN1TaggedObject)((Enumeration)localObject).nextElement();
          if (localASN1TaggedObject.getTagNo() == 0) {
            try
            {
              int i = ASN1Integer.getInstance(localASN1TaggedObject, false).getValue().intValue();
              if (i == 0) {
                return 0;
              }
            }
            catch (Exception localException)
            {
              throw new ExtCertPathValidatorException("Policy constraints requireExplicitPolicy field could not be decoded.", localException, paramCertPath, paramInt1);
            }
          }
        }
      }
      return paramInt2;
    }
    catch (AnnotatedException localAnnotatedException)
    {
      throw new ExtCertPathValidatorException("Policy constraints could not be decoded.", localAnnotatedException, paramCertPath, paramInt1);
    }
  }
  
  protected static void wrapupCertF(CertPath paramCertPath, int paramInt, List paramList, Set paramSet)
    throws CertPathValidatorException
  {
    X509Certificate localX509Certificate = (X509Certificate)paramCertPath.getCertificates().get(paramInt);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      try
      {
        ((PKIXCertPathChecker)paramList.next()).check(localX509Certificate, paramSet);
      }
      catch (CertPathValidatorException paramList)
      {
        throw new ExtCertPathValidatorException("Additional certificate path checker failed.", paramList, paramCertPath, paramInt);
      }
    }
    if (paramSet.isEmpty()) {
      return;
    }
    paramList = new StringBuilder();
    paramList.append("Certificate has unsupported critical extension: ");
    paramList.append(paramSet);
    throw new ExtCertPathValidatorException(paramList.toString(), null, paramCertPath, paramInt);
  }
  
  protected static PKIXPolicyNode wrapupCertG(CertPath paramCertPath, PKIXExtendedParameters paramPKIXExtendedParameters, Set paramSet1, int paramInt, List[] paramArrayOfList, PKIXPolicyNode paramPKIXPolicyNode, Set paramSet2)
    throws CertPathValidatorException
  {
    int j = paramCertPath.getCertificates().size();
    if (paramPKIXPolicyNode == null)
    {
      if (!paramPKIXExtendedParameters.isExplicitPolicyRequired()) {
        return null;
      }
      throw new ExtCertPathValidatorException("Explicit policy requested but none available.", null, paramCertPath, paramInt);
    }
    int i;
    if (CertPathValidatorUtilities.isAnyPolicy(paramSet1))
    {
      paramSet1 = paramPKIXPolicyNode;
      if (paramPKIXExtendedParameters.isExplicitPolicyRequired()) {
        if (!paramSet2.isEmpty())
        {
          paramCertPath = new HashSet();
          paramInt = 0;
          while (paramInt < paramArrayOfList.length)
          {
            paramPKIXExtendedParameters = paramArrayOfList[paramInt];
            i = 0;
            while (i < paramPKIXExtendedParameters.size())
            {
              paramSet1 = (PKIXPolicyNode)paramPKIXExtendedParameters.get(i);
              if ("2.5.29.32.0".equals(paramSet1.getValidPolicy()))
              {
                paramSet1 = paramSet1.getChildren();
                while (paramSet1.hasNext()) {
                  paramCertPath.add(paramSet1.next());
                }
              }
              i += 1;
            }
            paramInt += 1;
          }
          paramCertPath = paramCertPath.iterator();
          while (paramCertPath.hasNext()) {
            paramSet2.contains(((PKIXPolicyNode)paramCertPath.next()).getValidPolicy());
          }
          paramSet1 = paramPKIXPolicyNode;
          if (paramPKIXPolicyNode != null)
          {
            paramInt = j - 1;
            for (;;)
            {
              paramSet1 = paramPKIXPolicyNode;
              if (paramInt < 0) {
                break;
              }
              paramPKIXExtendedParameters = paramArrayOfList[paramInt];
              i = 0;
              while (i < paramPKIXExtendedParameters.size())
              {
                paramSet1 = (PKIXPolicyNode)paramPKIXExtendedParameters.get(i);
                paramCertPath = paramPKIXPolicyNode;
                if (!paramSet1.hasChildren()) {
                  paramCertPath = CertPathValidatorUtilities.removePolicyNode(paramPKIXPolicyNode, paramArrayOfList, paramSet1);
                }
                i += 1;
                paramPKIXPolicyNode = paramCertPath;
              }
              paramInt -= 1;
            }
          }
        }
        else
        {
          throw new ExtCertPathValidatorException("Explicit policy requested but none available.", null, paramCertPath, paramInt);
        }
      }
    }
    do
    {
      return paramSet1;
      paramCertPath = new HashSet();
      paramInt = 0;
      while (paramInt < paramArrayOfList.length)
      {
        paramPKIXExtendedParameters = paramArrayOfList[paramInt];
        i = 0;
        while (i < paramPKIXExtendedParameters.size())
        {
          paramSet2 = (PKIXPolicyNode)paramPKIXExtendedParameters.get(i);
          if ("2.5.29.32.0".equals(paramSet2.getValidPolicy()))
          {
            paramSet2 = paramSet2.getChildren();
            while (paramSet2.hasNext())
            {
              PKIXPolicyNode localPKIXPolicyNode = (PKIXPolicyNode)paramSet2.next();
              if (!"2.5.29.32.0".equals(localPKIXPolicyNode.getValidPolicy())) {
                paramCertPath.add(localPKIXPolicyNode);
              }
            }
          }
          i += 1;
        }
        paramInt += 1;
      }
      paramCertPath = paramCertPath.iterator();
      while (paramCertPath.hasNext())
      {
        paramPKIXExtendedParameters = (PKIXPolicyNode)paramCertPath.next();
        if (!paramSet1.contains(paramPKIXExtendedParameters.getValidPolicy())) {
          paramPKIXPolicyNode = CertPathValidatorUtilities.removePolicyNode(paramPKIXPolicyNode, paramArrayOfList, paramPKIXExtendedParameters);
        }
      }
      paramSet1 = paramPKIXPolicyNode;
    } while (paramPKIXPolicyNode == null);
    paramInt = j - 1;
    for (;;)
    {
      paramSet1 = paramPKIXPolicyNode;
      if (paramInt < 0) {
        break;
      }
      paramPKIXExtendedParameters = paramArrayOfList[paramInt];
      i = 0;
      while (i < paramPKIXExtendedParameters.size())
      {
        paramSet1 = (PKIXPolicyNode)paramPKIXExtendedParameters.get(i);
        paramCertPath = paramPKIXPolicyNode;
        if (!paramSet1.hasChildren()) {
          paramCertPath = CertPathValidatorUtilities.removePolicyNode(paramPKIXPolicyNode, paramArrayOfList, paramSet1);
        }
        i += 1;
        paramPKIXPolicyNode = paramCertPath;
      }
      paramInt -= 1;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\provider\RFC3280CertPathUtilities.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */