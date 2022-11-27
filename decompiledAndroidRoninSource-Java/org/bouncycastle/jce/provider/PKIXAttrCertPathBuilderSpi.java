package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathBuilderResult;
import java.security.cert.CertPathBuilderSpi;
import java.security.cert.CertPathParameters;
import java.security.cert.CertSelector;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.jcajce.PKIXCertStoreSelector;
import org.bouncycastle.jcajce.PKIXCertStoreSelector.Builder;
import org.bouncycastle.jcajce.PKIXExtendedBuilderParameters;
import org.bouncycastle.jcajce.PKIXExtendedBuilderParameters.Builder;
import org.bouncycastle.jcajce.PKIXExtendedParameters;
import org.bouncycastle.jce.exception.ExtCertPathBuilderException;
import org.bouncycastle.util.Store;
import org.bouncycastle.util.StoreException;
import org.bouncycastle.x509.AttributeCertificateIssuer;
import org.bouncycastle.x509.ExtendedPKIXBuilderParameters;
import org.bouncycastle.x509.ExtendedPKIXParameters;
import org.bouncycastle.x509.X509AttributeCertStoreSelector;
import org.bouncycastle.x509.X509AttributeCertificate;
import org.bouncycastle.x509.X509CertStoreSelector;

public class PKIXAttrCertPathBuilderSpi
  extends CertPathBuilderSpi
{
  private Exception certPathException;
  
  /* Error */
  private CertPathBuilderResult build(X509AttributeCertificate paramX509AttributeCertificate, X509Certificate paramX509Certificate, PKIXExtendedBuilderParameters paramPKIXExtendedBuilderParameters, List paramList)
  {
    // Byte code:
    //   0: aload 4
    //   2: aload_2
    //   3: invokeinterface 25 2 0
    //   8: istore 5
    //   10: aconst_null
    //   11: astore 6
    //   13: aconst_null
    //   14: astore 8
    //   16: iload 5
    //   18: ifeq +5 -> 23
    //   21: aconst_null
    //   22: areturn
    //   23: aload_3
    //   24: invokevirtual 31	org/bouncycastle/jcajce/PKIXExtendedBuilderParameters:getExcludedCerts	()Ljava/util/Set;
    //   27: aload_2
    //   28: invokeinterface 34 2 0
    //   33: ifeq +5 -> 38
    //   36: aconst_null
    //   37: areturn
    //   38: aload_3
    //   39: invokevirtual 38	org/bouncycastle/jcajce/PKIXExtendedBuilderParameters:getMaxPathLength	()I
    //   42: iconst_m1
    //   43: if_icmpeq +21 -> 64
    //   46: aload 4
    //   48: invokeinterface 41 1 0
    //   53: iconst_1
    //   54: isub
    //   55: aload_3
    //   56: invokevirtual 38	org/bouncycastle/jcajce/PKIXExtendedBuilderParameters:getMaxPathLength	()I
    //   59: if_icmple +5 -> 64
    //   62: aconst_null
    //   63: areturn
    //   64: aload 4
    //   66: aload_2
    //   67: invokeinterface 44 2 0
    //   72: pop
    //   73: ldc 46
    //   75: ldc 48
    //   77: invokestatic 54	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   80: astore 10
    //   82: ldc 56
    //   84: ldc 48
    //   86: invokestatic 61	java/security/cert/CertPathValidator:getInstance	(Ljava/lang/String;Ljava/lang/String;)Ljava/security/cert/CertPathValidator;
    //   89: astore 9
    //   91: aload 6
    //   93: astore 7
    //   95: aload_2
    //   96: aload_3
    //   97: invokevirtual 65	org/bouncycastle/jcajce/PKIXExtendedBuilderParameters:getBaseParameters	()Lorg/bouncycastle/jcajce/PKIXExtendedParameters;
    //   100: invokevirtual 70	org/bouncycastle/jcajce/PKIXExtendedParameters:getTrustAnchors	()Ljava/util/Set;
    //   103: aload_3
    //   104: invokevirtual 65	org/bouncycastle/jcajce/PKIXExtendedBuilderParameters:getBaseParameters	()Lorg/bouncycastle/jcajce/PKIXExtendedParameters;
    //   107: invokevirtual 74	org/bouncycastle/jcajce/PKIXExtendedParameters:getSigProvider	()Ljava/lang/String;
    //   110: invokestatic 80	org/bouncycastle/jce/provider/CertPathValidatorUtilities:findTrustAnchor	(Ljava/security/cert/X509Certificate;Ljava/util/Set;Ljava/lang/String;)Ljava/security/cert/TrustAnchor;
    //   113: astore 11
    //   115: aload 11
    //   117: ifnull +87 -> 204
    //   120: aload 6
    //   122: astore 7
    //   124: aload 10
    //   126: aload 4
    //   128: invokevirtual 84	java/security/cert/CertificateFactory:generateCertPath	(Ljava/util/List;)Ljava/security/cert/CertPath;
    //   131: astore_1
    //   132: aload 6
    //   134: astore 7
    //   136: aload 9
    //   138: aload_1
    //   139: aload_3
    //   140: invokevirtual 88	java/security/cert/CertPathValidator:validate	(Ljava/security/cert/CertPath;Ljava/security/cert/CertPathParameters;)Ljava/security/cert/CertPathValidatorResult;
    //   143: checkcast 90	java/security/cert/PKIXCertPathValidatorResult
    //   146: astore_3
    //   147: aload 6
    //   149: astore 7
    //   151: new 92	java/security/cert/PKIXCertPathBuilderResult
    //   154: dup
    //   155: aload_1
    //   156: aload_3
    //   157: invokevirtual 96	java/security/cert/PKIXCertPathValidatorResult:getTrustAnchor	()Ljava/security/cert/TrustAnchor;
    //   160: aload_3
    //   161: invokevirtual 100	java/security/cert/PKIXCertPathValidatorResult:getPolicyTree	()Ljava/security/cert/PolicyNode;
    //   164: aload_3
    //   165: invokevirtual 104	java/security/cert/PKIXCertPathValidatorResult:getPublicKey	()Ljava/security/PublicKey;
    //   168: invokespecial 107	java/security/cert/PKIXCertPathBuilderResult:<init>	(Ljava/security/cert/CertPath;Ljava/security/cert/TrustAnchor;Ljava/security/cert/PolicyNode;Ljava/security/PublicKey;)V
    //   171: areturn
    //   172: astore_1
    //   173: aload 6
    //   175: astore 7
    //   177: new 17	org/bouncycastle/jce/provider/AnnotatedException
    //   180: dup
    //   181: ldc 109
    //   183: aload_1
    //   184: invokespecial 112	org/bouncycastle/jce/provider/AnnotatedException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   187: athrow
    //   188: astore_1
    //   189: aload 6
    //   191: astore 7
    //   193: new 17	org/bouncycastle/jce/provider/AnnotatedException
    //   196: dup
    //   197: ldc 114
    //   199: aload_1
    //   200: invokespecial 112	org/bouncycastle/jce/provider/AnnotatedException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   203: athrow
    //   204: aload 6
    //   206: astore 7
    //   208: new 116	java/util/ArrayList
    //   211: dup
    //   212: invokespecial 117	java/util/ArrayList:<init>	()V
    //   215: astore 9
    //   217: aload 6
    //   219: astore 7
    //   221: aload 9
    //   223: aload_3
    //   224: invokevirtual 65	org/bouncycastle/jcajce/PKIXExtendedBuilderParameters:getBaseParameters	()Lorg/bouncycastle/jcajce/PKIXExtendedParameters;
    //   227: invokevirtual 121	org/bouncycastle/jcajce/PKIXExtendedParameters:getCertificateStores	()Ljava/util/List;
    //   230: invokeinterface 125 2 0
    //   235: pop
    //   236: aload 6
    //   238: astore 7
    //   240: aload 9
    //   242: aload_2
    //   243: getstatic 131	org/bouncycastle/asn1/x509/Extension:issuerAlternativeName	Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;
    //   246: invokevirtual 136	org/bouncycastle/asn1/ASN1ObjectIdentifier:getId	()Ljava/lang/String;
    //   249: invokevirtual 142	java/security/cert/X509Certificate:getExtensionValue	(Ljava/lang/String;)[B
    //   252: aload_3
    //   253: invokevirtual 65	org/bouncycastle/jcajce/PKIXExtendedBuilderParameters:getBaseParameters	()Lorg/bouncycastle/jcajce/PKIXExtendedParameters;
    //   256: invokevirtual 146	org/bouncycastle/jcajce/PKIXExtendedParameters:getNamedCertificateStoreMap	()Ljava/util/Map;
    //   259: invokestatic 150	org/bouncycastle/jce/provider/CertPathValidatorUtilities:getAdditionalStoresFromAltNames	([BLjava/util/Map;)Ljava/util/List;
    //   262: invokeinterface 125 2 0
    //   267: pop
    //   268: aload 6
    //   270: astore 7
    //   272: new 152	java/util/HashSet
    //   275: dup
    //   276: invokespecial 153	java/util/HashSet:<init>	()V
    //   279: astore 10
    //   281: aload 10
    //   283: aload_2
    //   284: aload_3
    //   285: invokevirtual 65	org/bouncycastle/jcajce/PKIXExtendedBuilderParameters:getBaseParameters	()Lorg/bouncycastle/jcajce/PKIXExtendedParameters;
    //   288: invokevirtual 156	org/bouncycastle/jcajce/PKIXExtendedParameters:getCertStores	()Ljava/util/List;
    //   291: aload 9
    //   293: invokestatic 160	org/bouncycastle/jce/provider/CertPathValidatorUtilities:findIssuerCerts	(Ljava/security/cert/X509Certificate;Ljava/util/List;Ljava/util/List;)Ljava/util/Collection;
    //   296: invokeinterface 163 2 0
    //   301: pop
    //   302: aload 6
    //   304: astore 7
    //   306: aload 10
    //   308: invokeinterface 167 1 0
    //   313: ifne +105 -> 418
    //   316: aload 6
    //   318: astore 7
    //   320: aload 10
    //   322: invokeinterface 171 1 0
    //   327: astore 9
    //   329: aload 8
    //   331: astore 6
    //   333: aload 6
    //   335: astore 7
    //   337: aload 6
    //   339: astore 8
    //   341: aload 9
    //   343: invokeinterface 176 1 0
    //   348: ifeq +135 -> 483
    //   351: aload 6
    //   353: astore 8
    //   355: aload 6
    //   357: ifnonnull +126 -> 483
    //   360: aload 6
    //   362: astore 7
    //   364: aload 9
    //   366: invokeinterface 180 1 0
    //   371: checkcast 138	java/security/cert/X509Certificate
    //   374: astore 8
    //   376: aload 6
    //   378: astore 7
    //   380: aload 8
    //   382: invokevirtual 184	java/security/cert/X509Certificate:getIssuerX500Principal	()Ljavax/security/auth/x500/X500Principal;
    //   385: aload 8
    //   387: invokevirtual 187	java/security/cert/X509Certificate:getSubjectX500Principal	()Ljavax/security/auth/x500/X500Principal;
    //   390: invokevirtual 192	javax/security/auth/x500/X500Principal:equals	(Ljava/lang/Object;)Z
    //   393: ifeq +6 -> 399
    //   396: goto -63 -> 333
    //   399: aload 6
    //   401: astore 7
    //   403: aload_0
    //   404: aload_1
    //   405: aload 8
    //   407: aload_3
    //   408: aload 4
    //   410: invokespecial 194	org/bouncycastle/jce/provider/PKIXAttrCertPathBuilderSpi:build	(Lorg/bouncycastle/x509/X509AttributeCertificate;Ljava/security/cert/X509Certificate;Lorg/bouncycastle/jcajce/PKIXExtendedBuilderParameters;Ljava/util/List;)Ljava/security/cert/CertPathBuilderResult;
    //   413: astore 6
    //   415: goto -82 -> 333
    //   418: aload 6
    //   420: astore 7
    //   422: new 17	org/bouncycastle/jce/provider/AnnotatedException
    //   425: dup
    //   426: ldc -60
    //   428: invokespecial 199	org/bouncycastle/jce/provider/AnnotatedException:<init>	(Ljava/lang/String;)V
    //   431: athrow
    //   432: astore_1
    //   433: aload 6
    //   435: astore 7
    //   437: new 17	org/bouncycastle/jce/provider/AnnotatedException
    //   440: dup
    //   441: ldc -55
    //   443: aload_1
    //   444: invokespecial 112	org/bouncycastle/jce/provider/AnnotatedException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   447: athrow
    //   448: astore_1
    //   449: aload 6
    //   451: astore 7
    //   453: new 17	org/bouncycastle/jce/provider/AnnotatedException
    //   456: dup
    //   457: ldc -53
    //   459: aload_1
    //   460: invokespecial 112	org/bouncycastle/jce/provider/AnnotatedException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   463: athrow
    //   464: astore_1
    //   465: aload_0
    //   466: new 17	org/bouncycastle/jce/provider/AnnotatedException
    //   469: dup
    //   470: ldc -51
    //   472: aload_1
    //   473: invokespecial 112	org/bouncycastle/jce/provider/AnnotatedException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   476: putfield 207	org/bouncycastle/jce/provider/PKIXAttrCertPathBuilderSpi:certPathException	Ljava/lang/Exception;
    //   479: aload 7
    //   481: astore 8
    //   483: aload 8
    //   485: ifnonnull +12 -> 497
    //   488: aload 4
    //   490: aload_2
    //   491: invokeinterface 210 2 0
    //   496: pop
    //   497: aload 8
    //   499: areturn
    //   500: new 212	java/lang/RuntimeException
    //   503: dup
    //   504: ldc -42
    //   506: invokespecial 215	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   509: athrow
    //   510: astore_1
    //   511: goto -11 -> 500
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	514	0	this	PKIXAttrCertPathBuilderSpi
    //   0	514	1	paramX509AttributeCertificate	X509AttributeCertificate
    //   0	514	2	paramX509Certificate	X509Certificate
    //   0	514	3	paramPKIXExtendedBuilderParameters	PKIXExtendedBuilderParameters
    //   0	514	4	paramList	List
    //   8	9	5	bool	boolean
    //   11	439	6	localObject1	Object
    //   93	387	7	localObject2	Object
    //   14	484	8	localObject3	Object
    //   89	276	9	localObject4	Object
    //   80	241	10	localObject5	Object
    //   113	3	11	localTrustAnchor	java.security.cert.TrustAnchor
    // Exception table:
    //   from	to	target	type
    //   136	147	172	java/lang/Exception
    //   124	132	188	java/lang/Exception
    //   281	302	432	org/bouncycastle/jce/provider/AnnotatedException
    //   240	268	448	java/security/cert/CertificateParsingException
    //   95	115	464	org/bouncycastle/jce/provider/AnnotatedException
    //   124	132	464	org/bouncycastle/jce/provider/AnnotatedException
    //   136	147	464	org/bouncycastle/jce/provider/AnnotatedException
    //   151	172	464	org/bouncycastle/jce/provider/AnnotatedException
    //   177	188	464	org/bouncycastle/jce/provider/AnnotatedException
    //   193	204	464	org/bouncycastle/jce/provider/AnnotatedException
    //   208	217	464	org/bouncycastle/jce/provider/AnnotatedException
    //   221	236	464	org/bouncycastle/jce/provider/AnnotatedException
    //   240	268	464	org/bouncycastle/jce/provider/AnnotatedException
    //   272	281	464	org/bouncycastle/jce/provider/AnnotatedException
    //   306	316	464	org/bouncycastle/jce/provider/AnnotatedException
    //   320	329	464	org/bouncycastle/jce/provider/AnnotatedException
    //   341	351	464	org/bouncycastle/jce/provider/AnnotatedException
    //   364	376	464	org/bouncycastle/jce/provider/AnnotatedException
    //   380	396	464	org/bouncycastle/jce/provider/AnnotatedException
    //   403	415	464	org/bouncycastle/jce/provider/AnnotatedException
    //   422	432	464	org/bouncycastle/jce/provider/AnnotatedException
    //   437	448	464	org/bouncycastle/jce/provider/AnnotatedException
    //   453	464	464	org/bouncycastle/jce/provider/AnnotatedException
    //   73	91	510	java/lang/Exception
  }
  
  protected static Collection findCertificates(X509AttributeCertStoreSelector paramX509AttributeCertStoreSelector, List paramList)
    throws AnnotatedException
  {
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if ((localObject instanceof Store))
      {
        localObject = (Store)localObject;
        try
        {
          localHashSet.addAll(((Store)localObject).getMatches(paramX509AttributeCertStoreSelector));
        }
        catch (StoreException paramX509AttributeCertStoreSelector)
        {
          throw new AnnotatedException("Problem while picking certificates from X.509 store.", paramX509AttributeCertStoreSelector);
        }
      }
    }
    return localHashSet;
  }
  
  public CertPathBuilderResult engineBuild(CertPathParameters paramCertPathParameters)
    throws CertPathBuilderException, InvalidAlgorithmParameterException
  {
    boolean bool = paramCertPathParameters instanceof PKIXBuilderParameters;
    if ((!bool) && (!(paramCertPathParameters instanceof ExtendedPKIXBuilderParameters)) && (!(paramCertPathParameters instanceof PKIXExtendedBuilderParameters)))
    {
      paramCertPathParameters = new StringBuilder();
      paramCertPathParameters.append("Parameters must be an instance of ");
      paramCertPathParameters.append(PKIXBuilderParameters.class.getName());
      paramCertPathParameters.append(" or ");
      paramCertPathParameters.append(PKIXExtendedBuilderParameters.class.getName());
      paramCertPathParameters.append(".");
      throw new InvalidAlgorithmParameterException(paramCertPathParameters.toString());
    }
    Object localObject1 = new ArrayList();
    if (bool)
    {
      localObject2 = new PKIXExtendedBuilderParameters.Builder((PKIXBuilderParameters)paramCertPathParameters);
      if ((paramCertPathParameters instanceof ExtendedPKIXParameters))
      {
        paramCertPathParameters = (ExtendedPKIXBuilderParameters)paramCertPathParameters;
        ((PKIXExtendedBuilderParameters.Builder)localObject2).addExcludedCerts(paramCertPathParameters.getExcludedCerts());
        ((PKIXExtendedBuilderParameters.Builder)localObject2).setMaxPathLength(paramCertPathParameters.getMaxPathLength());
        localObject1 = paramCertPathParameters.getStores();
      }
      paramCertPathParameters = ((PKIXExtendedBuilderParameters.Builder)localObject2).build();
    }
    else
    {
      paramCertPathParameters = (PKIXExtendedBuilderParameters)paramCertPathParameters;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = paramCertPathParameters.getBaseParameters().getTargetConstraints();
    if ((localObject2 instanceof X509AttributeCertStoreSelector)) {
      try
      {
        localObject2 = findCertificates((X509AttributeCertStoreSelector)localObject2, (List)localObject1);
        if (!((Collection)localObject2).isEmpty())
        {
          localObject1 = null;
          Iterator localIterator = ((Collection)localObject2).iterator();
          if ((localIterator.hasNext()) && (localObject1 == null))
          {
            X509AttributeCertificate localX509AttributeCertificate = (X509AttributeCertificate)localIterator.next();
            localObject2 = new X509CertStoreSelector();
            Object localObject3 = localX509AttributeCertificate.getIssuer().getPrincipals();
            HashSet localHashSet = new HashSet();
            int i = 0;
            while (i < localObject3.length) {
              try
              {
                if ((localObject3[i] instanceof X500Principal)) {
                  ((X509CertStoreSelector)localObject2).setSubject(((X500Principal)localObject3[i]).getEncoded());
                }
                PKIXCertStoreSelector localPKIXCertStoreSelector = new PKIXCertStoreSelector.Builder((CertSelector)localObject2).build();
                localHashSet.addAll(CertPathValidatorUtilities.findCertificates(localPKIXCertStoreSelector, paramCertPathParameters.getBaseParameters().getCertStores()));
                localHashSet.addAll(CertPathValidatorUtilities.findCertificates(localPKIXCertStoreSelector, paramCertPathParameters.getBaseParameters().getCertificateStores()));
                i += 1;
              }
              catch (IOException paramCertPathParameters)
              {
                throw new ExtCertPathBuilderException("cannot encode X500Principal.", paramCertPathParameters);
              }
              catch (AnnotatedException paramCertPathParameters)
              {
                throw new ExtCertPathBuilderException("Public key certificate for attribute certificate cannot be searched.", paramCertPathParameters);
              }
            }
            if (!localHashSet.isEmpty())
            {
              localObject3 = localHashSet.iterator();
              for (localObject2 = localObject1;; localObject2 = build(localX509AttributeCertificate, (X509Certificate)((Iterator)localObject3).next(), paramCertPathParameters, localArrayList))
              {
                localObject1 = localObject2;
                if (!((Iterator)localObject3).hasNext()) {
                  break;
                }
                localObject1 = localObject2;
                if (localObject2 != null) {
                  break;
                }
              }
            }
            throw new CertPathBuilderException("Public key certificate for attribute certificate cannot be found.");
          }
          if ((localObject1 == null) && (this.certPathException != null)) {
            throw new ExtCertPathBuilderException("Possible certificate chain could not be validated.", this.certPathException);
          }
          if (localObject1 == null)
          {
            if (this.certPathException != null) {
              return (CertPathBuilderResult)localObject1;
            }
            throw new CertPathBuilderException("Unable to find certificate chain.");
          }
          return (CertPathBuilderResult)localObject1;
        }
        throw new CertPathBuilderException("No attribute certificate found matching targetContraints.");
      }
      catch (AnnotatedException paramCertPathParameters)
      {
        throw new ExtCertPathBuilderException("Error finding target attribute certificate.", paramCertPathParameters);
      }
    }
    paramCertPathParameters = new StringBuilder();
    paramCertPathParameters.append("TargetConstraints must be an instance of ");
    paramCertPathParameters.append(X509AttributeCertStoreSelector.class.getName());
    paramCertPathParameters.append(" for ");
    paramCertPathParameters.append(getClass().getName());
    paramCertPathParameters.append(" class.");
    throw new CertPathBuilderException(paramCertPathParameters.toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\provider\PKIXAttrCertPathBuilderSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */