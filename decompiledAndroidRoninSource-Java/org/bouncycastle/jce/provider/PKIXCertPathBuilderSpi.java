package org.bouncycastle.jce.provider;

import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathBuilderResult;
import java.security.cert.CertPathBuilderSpi;
import java.security.cert.CertPathParameters;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.PKIXParameters;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.jcajce.PKIXCertStore;
import org.bouncycastle.jcajce.PKIXCertStoreSelector;
import org.bouncycastle.jcajce.PKIXExtendedBuilderParameters;
import org.bouncycastle.jcajce.PKIXExtendedBuilderParameters.Builder;
import org.bouncycastle.jcajce.PKIXExtendedParameters;
import org.bouncycastle.jcajce.PKIXExtendedParameters.Builder;
import org.bouncycastle.jce.exception.ExtCertPathBuilderException;
import org.bouncycastle.x509.ExtendedPKIXBuilderParameters;
import org.bouncycastle.x509.ExtendedPKIXParameters;

public class PKIXCertPathBuilderSpi
  extends CertPathBuilderSpi
{
  private Exception certPathException;
  
  /* Error */
  protected CertPathBuilderResult build(X509Certificate paramX509Certificate, PKIXExtendedBuilderParameters paramPKIXExtendedBuilderParameters, List paramList)
  {
    // Byte code:
    //   0: aload_3
    //   1: aload_1
    //   2: invokeinterface 25 2 0
    //   7: istore 4
    //   9: aconst_null
    //   10: astore 5
    //   12: aconst_null
    //   13: astore 7
    //   15: iload 4
    //   17: ifeq +5 -> 22
    //   20: aconst_null
    //   21: areturn
    //   22: aload_2
    //   23: invokevirtual 31	org/bouncycastle/jcajce/PKIXExtendedBuilderParameters:getExcludedCerts	()Ljava/util/Set;
    //   26: aload_1
    //   27: invokeinterface 34 2 0
    //   32: ifeq +5 -> 37
    //   35: aconst_null
    //   36: areturn
    //   37: aload_2
    //   38: invokevirtual 38	org/bouncycastle/jcajce/PKIXExtendedBuilderParameters:getMaxPathLength	()I
    //   41: iconst_m1
    //   42: if_icmpeq +20 -> 62
    //   45: aload_3
    //   46: invokeinterface 41 1 0
    //   51: iconst_1
    //   52: isub
    //   53: aload_2
    //   54: invokevirtual 38	org/bouncycastle/jcajce/PKIXExtendedBuilderParameters:getMaxPathLength	()I
    //   57: if_icmple +5 -> 62
    //   60: aconst_null
    //   61: areturn
    //   62: aload_3
    //   63: aload_1
    //   64: invokeinterface 44 2 0
    //   69: pop
    //   70: new 46	org/bouncycastle/jcajce/provider/asymmetric/x509/CertificateFactory
    //   73: dup
    //   74: invokespecial 47	org/bouncycastle/jcajce/provider/asymmetric/x509/CertificateFactory:<init>	()V
    //   77: astore 9
    //   79: new 49	org/bouncycastle/jce/provider/PKIXCertPathValidatorSpi
    //   82: dup
    //   83: invokespecial 50	org/bouncycastle/jce/provider/PKIXCertPathValidatorSpi:<init>	()V
    //   86: astore 8
    //   88: aload 5
    //   90: astore 6
    //   92: aload_1
    //   93: aload_2
    //   94: invokevirtual 54	org/bouncycastle/jcajce/PKIXExtendedBuilderParameters:getBaseParameters	()Lorg/bouncycastle/jcajce/PKIXExtendedParameters;
    //   97: invokevirtual 59	org/bouncycastle/jcajce/PKIXExtendedParameters:getTrustAnchors	()Ljava/util/Set;
    //   100: aload_2
    //   101: invokevirtual 54	org/bouncycastle/jcajce/PKIXExtendedBuilderParameters:getBaseParameters	()Lorg/bouncycastle/jcajce/PKIXExtendedParameters;
    //   104: invokevirtual 63	org/bouncycastle/jcajce/PKIXExtendedParameters:getSigProvider	()Ljava/lang/String;
    //   107: invokestatic 69	org/bouncycastle/jce/provider/CertPathValidatorUtilities:findTrustAnchor	(Ljava/security/cert/X509Certificate;Ljava/util/Set;Ljava/lang/String;)Ljava/security/cert/TrustAnchor;
    //   110: astore 10
    //   112: aload 10
    //   114: ifnull +89 -> 203
    //   117: aload 5
    //   119: astore 6
    //   121: aload 9
    //   123: aload_3
    //   124: invokevirtual 73	org/bouncycastle/jcajce/provider/asymmetric/x509/CertificateFactory:engineGenerateCertPath	(Ljava/util/List;)Ljava/security/cert/CertPath;
    //   127: astore 7
    //   129: aload 5
    //   131: astore 6
    //   133: aload 8
    //   135: aload 7
    //   137: aload_2
    //   138: invokevirtual 77	org/bouncycastle/jce/provider/PKIXCertPathValidatorSpi:engineValidate	(Ljava/security/cert/CertPath;Ljava/security/cert/CertPathParameters;)Ljava/security/cert/CertPathValidatorResult;
    //   141: checkcast 79	java/security/cert/PKIXCertPathValidatorResult
    //   144: astore_2
    //   145: aload 5
    //   147: astore 6
    //   149: new 81	java/security/cert/PKIXCertPathBuilderResult
    //   152: dup
    //   153: aload 7
    //   155: aload_2
    //   156: invokevirtual 85	java/security/cert/PKIXCertPathValidatorResult:getTrustAnchor	()Ljava/security/cert/TrustAnchor;
    //   159: aload_2
    //   160: invokevirtual 89	java/security/cert/PKIXCertPathValidatorResult:getPolicyTree	()Ljava/security/cert/PolicyNode;
    //   163: aload_2
    //   164: invokevirtual 93	java/security/cert/PKIXCertPathValidatorResult:getPublicKey	()Ljava/security/PublicKey;
    //   167: invokespecial 96	java/security/cert/PKIXCertPathBuilderResult:<init>	(Ljava/security/cert/CertPath;Ljava/security/cert/TrustAnchor;Ljava/security/cert/PolicyNode;Ljava/security/PublicKey;)V
    //   170: areturn
    //   171: astore_2
    //   172: aload 5
    //   174: astore 6
    //   176: new 17	org/bouncycastle/jce/provider/AnnotatedException
    //   179: dup
    //   180: ldc 98
    //   182: aload_2
    //   183: invokespecial 101	org/bouncycastle/jce/provider/AnnotatedException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   186: athrow
    //   187: astore_2
    //   188: aload 5
    //   190: astore 6
    //   192: new 17	org/bouncycastle/jce/provider/AnnotatedException
    //   195: dup
    //   196: ldc 103
    //   198: aload_2
    //   199: invokespecial 101	org/bouncycastle/jce/provider/AnnotatedException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   202: athrow
    //   203: aload 5
    //   205: astore 6
    //   207: new 105	java/util/ArrayList
    //   210: dup
    //   211: invokespecial 106	java/util/ArrayList:<init>	()V
    //   214: astore 8
    //   216: aload 5
    //   218: astore 6
    //   220: aload 8
    //   222: aload_2
    //   223: invokevirtual 54	org/bouncycastle/jcajce/PKIXExtendedBuilderParameters:getBaseParameters	()Lorg/bouncycastle/jcajce/PKIXExtendedParameters;
    //   226: invokevirtual 110	org/bouncycastle/jcajce/PKIXExtendedParameters:getCertificateStores	()Ljava/util/List;
    //   229: invokeinterface 114 2 0
    //   234: pop
    //   235: aload 5
    //   237: astore 6
    //   239: aload 8
    //   241: aload_1
    //   242: getstatic 120	org/bouncycastle/asn1/x509/Extension:issuerAlternativeName	Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;
    //   245: invokevirtual 125	org/bouncycastle/asn1/ASN1ObjectIdentifier:getId	()Ljava/lang/String;
    //   248: invokevirtual 131	java/security/cert/X509Certificate:getExtensionValue	(Ljava/lang/String;)[B
    //   251: aload_2
    //   252: invokevirtual 54	org/bouncycastle/jcajce/PKIXExtendedBuilderParameters:getBaseParameters	()Lorg/bouncycastle/jcajce/PKIXExtendedParameters;
    //   255: invokevirtual 135	org/bouncycastle/jcajce/PKIXExtendedParameters:getNamedCertificateStoreMap	()Ljava/util/Map;
    //   258: invokestatic 139	org/bouncycastle/jce/provider/CertPathValidatorUtilities:getAdditionalStoresFromAltNames	([BLjava/util/Map;)Ljava/util/List;
    //   261: invokeinterface 114 2 0
    //   266: pop
    //   267: aload 5
    //   269: astore 6
    //   271: new 141	java/util/HashSet
    //   274: dup
    //   275: invokespecial 142	java/util/HashSet:<init>	()V
    //   278: astore 9
    //   280: aload 9
    //   282: aload_1
    //   283: aload_2
    //   284: invokevirtual 54	org/bouncycastle/jcajce/PKIXExtendedBuilderParameters:getBaseParameters	()Lorg/bouncycastle/jcajce/PKIXExtendedParameters;
    //   287: invokevirtual 145	org/bouncycastle/jcajce/PKIXExtendedParameters:getCertStores	()Ljava/util/List;
    //   290: aload 8
    //   292: invokestatic 149	org/bouncycastle/jce/provider/CertPathValidatorUtilities:findIssuerCerts	(Ljava/security/cert/X509Certificate;Ljava/util/List;Ljava/util/List;)Ljava/util/Collection;
    //   295: invokeinterface 152 2 0
    //   300: pop
    //   301: aload 5
    //   303: astore 6
    //   305: aload 9
    //   307: invokeinterface 156 1 0
    //   312: ifne +72 -> 384
    //   315: aload 5
    //   317: astore 6
    //   319: aload 9
    //   321: invokeinterface 160 1 0
    //   326: astore 8
    //   328: aload 7
    //   330: astore 5
    //   332: aload 5
    //   334: astore 6
    //   336: aload 5
    //   338: astore 7
    //   340: aload 8
    //   342: invokeinterface 165 1 0
    //   347: ifeq +93 -> 440
    //   350: aload 5
    //   352: astore 7
    //   354: aload 5
    //   356: ifnonnull +84 -> 440
    //   359: aload 5
    //   361: astore 6
    //   363: aload_0
    //   364: aload 8
    //   366: invokeinterface 169 1 0
    //   371: checkcast 127	java/security/cert/X509Certificate
    //   374: aload_2
    //   375: aload_3
    //   376: invokevirtual 171	org/bouncycastle/jce/provider/PKIXCertPathBuilderSpi:build	(Ljava/security/cert/X509Certificate;Lorg/bouncycastle/jcajce/PKIXExtendedBuilderParameters;Ljava/util/List;)Ljava/security/cert/CertPathBuilderResult;
    //   379: astore 5
    //   381: goto -49 -> 332
    //   384: aload 5
    //   386: astore 6
    //   388: new 17	org/bouncycastle/jce/provider/AnnotatedException
    //   391: dup
    //   392: ldc -83
    //   394: invokespecial 176	org/bouncycastle/jce/provider/AnnotatedException:<init>	(Ljava/lang/String;)V
    //   397: athrow
    //   398: astore_2
    //   399: aload 5
    //   401: astore 6
    //   403: new 17	org/bouncycastle/jce/provider/AnnotatedException
    //   406: dup
    //   407: ldc -78
    //   409: aload_2
    //   410: invokespecial 101	org/bouncycastle/jce/provider/AnnotatedException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   413: athrow
    //   414: astore_2
    //   415: aload 5
    //   417: astore 6
    //   419: new 17	org/bouncycastle/jce/provider/AnnotatedException
    //   422: dup
    //   423: ldc -76
    //   425: aload_2
    //   426: invokespecial 101	org/bouncycastle/jce/provider/AnnotatedException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   429: athrow
    //   430: astore_2
    //   431: aload_0
    //   432: aload_2
    //   433: putfield 182	org/bouncycastle/jce/provider/PKIXCertPathBuilderSpi:certPathException	Ljava/lang/Exception;
    //   436: aload 6
    //   438: astore 7
    //   440: aload 7
    //   442: ifnonnull +11 -> 453
    //   445: aload_3
    //   446: aload_1
    //   447: invokeinterface 185 2 0
    //   452: pop
    //   453: aload 7
    //   455: areturn
    //   456: new 187	java/lang/RuntimeException
    //   459: dup
    //   460: ldc -67
    //   462: invokespecial 190	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   465: athrow
    //   466: astore_1
    //   467: goto -11 -> 456
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	470	0	this	PKIXCertPathBuilderSpi
    //   0	470	1	paramX509Certificate	X509Certificate
    //   0	470	2	paramPKIXExtendedBuilderParameters	PKIXExtendedBuilderParameters
    //   0	470	3	paramList	List
    //   7	9	4	bool	boolean
    //   10	406	5	localObject1	Object
    //   90	347	6	localObject2	Object
    //   13	441	7	localObject3	Object
    //   86	279	8	localObject4	Object
    //   77	243	9	localObject5	Object
    //   110	3	10	localTrustAnchor	java.security.cert.TrustAnchor
    // Exception table:
    //   from	to	target	type
    //   133	145	171	java/lang/Exception
    //   121	129	187	java/lang/Exception
    //   280	301	398	org/bouncycastle/jce/provider/AnnotatedException
    //   239	267	414	java/security/cert/CertificateParsingException
    //   92	112	430	org/bouncycastle/jce/provider/AnnotatedException
    //   121	129	430	org/bouncycastle/jce/provider/AnnotatedException
    //   133	145	430	org/bouncycastle/jce/provider/AnnotatedException
    //   149	171	430	org/bouncycastle/jce/provider/AnnotatedException
    //   176	187	430	org/bouncycastle/jce/provider/AnnotatedException
    //   192	203	430	org/bouncycastle/jce/provider/AnnotatedException
    //   207	216	430	org/bouncycastle/jce/provider/AnnotatedException
    //   220	235	430	org/bouncycastle/jce/provider/AnnotatedException
    //   239	267	430	org/bouncycastle/jce/provider/AnnotatedException
    //   271	280	430	org/bouncycastle/jce/provider/AnnotatedException
    //   305	315	430	org/bouncycastle/jce/provider/AnnotatedException
    //   319	328	430	org/bouncycastle/jce/provider/AnnotatedException
    //   340	350	430	org/bouncycastle/jce/provider/AnnotatedException
    //   363	381	430	org/bouncycastle/jce/provider/AnnotatedException
    //   388	398	430	org/bouncycastle/jce/provider/AnnotatedException
    //   403	414	430	org/bouncycastle/jce/provider/AnnotatedException
    //   419	430	430	org/bouncycastle/jce/provider/AnnotatedException
    //   70	88	466	java/lang/Exception
  }
  
  public CertPathBuilderResult engineBuild(CertPathParameters paramCertPathParameters)
    throws CertPathBuilderException, InvalidAlgorithmParameterException
  {
    if ((paramCertPathParameters instanceof PKIXBuilderParameters))
    {
      localObject2 = (PKIXBuilderParameters)paramCertPathParameters;
      localObject1 = new PKIXExtendedParameters.Builder((PKIXParameters)localObject2);
      if ((paramCertPathParameters instanceof ExtendedPKIXParameters))
      {
        localObject2 = (ExtendedPKIXBuilderParameters)paramCertPathParameters;
        paramCertPathParameters = ((ExtendedPKIXBuilderParameters)localObject2).getAdditionalStores().iterator();
        while (paramCertPathParameters.hasNext()) {
          ((PKIXExtendedParameters.Builder)localObject1).addCertificateStore((PKIXCertStore)paramCertPathParameters.next());
        }
        paramCertPathParameters = new PKIXExtendedBuilderParameters.Builder(((PKIXExtendedParameters.Builder)localObject1).build());
        paramCertPathParameters.addExcludedCerts(((ExtendedPKIXBuilderParameters)localObject2).getExcludedCerts());
        paramCertPathParameters.setMaxPathLength(((ExtendedPKIXBuilderParameters)localObject2).getMaxPathLength());
      }
      else
      {
        paramCertPathParameters = new PKIXExtendedBuilderParameters.Builder((PKIXBuilderParameters)localObject2);
      }
      paramCertPathParameters = paramCertPathParameters.build();
    }
    else
    {
      if (!(paramCertPathParameters instanceof PKIXExtendedBuilderParameters)) {
        break label341;
      }
      paramCertPathParameters = (PKIXExtendedBuilderParameters)paramCertPathParameters;
    }
    Object localObject2 = new ArrayList();
    Object localObject1 = paramCertPathParameters.getBaseParameters().getTargetConstraints();
    try
    {
      Object localObject3 = CertPathValidatorUtilities.findCertificates((PKIXCertStoreSelector)localObject1, paramCertPathParameters.getBaseParameters().getCertificateStores());
      ((Collection)localObject3).addAll(CertPathValidatorUtilities.findCertificates((PKIXCertStoreSelector)localObject1, paramCertPathParameters.getBaseParameters().getCertStores()));
      if (!((Collection)localObject3).isEmpty())
      {
        localObject1 = null;
        localObject3 = ((Collection)localObject3).iterator();
        while ((((Iterator)localObject3).hasNext()) && (localObject1 == null)) {
          localObject1 = build((X509Certificate)((Iterator)localObject3).next(), paramCertPathParameters, (List)localObject2);
        }
        if (localObject1 == null)
        {
          paramCertPathParameters = this.certPathException;
          if (paramCertPathParameters != null)
          {
            if ((paramCertPathParameters instanceof AnnotatedException)) {
              throw new CertPathBuilderException(this.certPathException.getMessage(), this.certPathException.getCause());
            }
            throw new CertPathBuilderException("Possible certificate chain could not be validated.", this.certPathException);
          }
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
      throw new CertPathBuilderException("No certificate found matching targetContraints.");
    }
    catch (AnnotatedException paramCertPathParameters)
    {
      throw new ExtCertPathBuilderException("Error finding target certificate.", paramCertPathParameters);
    }
    label341:
    paramCertPathParameters = new StringBuilder();
    paramCertPathParameters.append("Parameters must be an instance of ");
    paramCertPathParameters.append(PKIXBuilderParameters.class.getName());
    paramCertPathParameters.append(" or ");
    paramCertPathParameters.append(PKIXExtendedBuilderParameters.class.getName());
    paramCertPathParameters.append(".");
    throw new InvalidAlgorithmParameterException(paramCertPathParameters.toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\provider\PKIXCertPathBuilderSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */