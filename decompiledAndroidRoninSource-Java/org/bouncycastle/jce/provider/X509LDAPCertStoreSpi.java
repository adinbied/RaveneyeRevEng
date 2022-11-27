package org.bouncycastle.jce.provider;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CRL;
import java.security.cert.CRLSelector;
import java.security.cert.CertSelector;
import java.security.cert.CertStoreException;
import java.security.cert.CertStoreParameters;
import java.security.cert.CertStoreSpi;
import java.security.cert.CertificateFactory;
import java.security.cert.X509CRLSelector;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.x509.CertificatePair;
import org.bouncycastle.jce.X509LDAPCertStoreParameters;

public class X509LDAPCertStoreSpi
  extends CertStoreSpi
{
  private static String LDAP_PROVIDER = "com.sun.jndi.ldap.LdapCtxFactory";
  private static String REFERRALS_IGNORE = "ignore";
  private static final String SEARCH_SECURITY_LEVEL = "none";
  private static final String URL_CONTEXT_PREFIX = "com.sun.jndi.url";
  private X509LDAPCertStoreParameters params;
  
  public X509LDAPCertStoreSpi(CertStoreParameters paramCertStoreParameters)
    throws InvalidAlgorithmParameterException
  {
    super(paramCertStoreParameters);
    if ((paramCertStoreParameters instanceof X509LDAPCertStoreParameters))
    {
      this.params = ((X509LDAPCertStoreParameters)paramCertStoreParameters);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(X509LDAPCertStoreSpi.class.getName());
    localStringBuilder.append(": parameter must be a ");
    localStringBuilder.append(X509LDAPCertStoreParameters.class.getName());
    localStringBuilder.append(" object\n");
    localStringBuilder.append(paramCertStoreParameters.toString());
    throw new InvalidAlgorithmParameterException(localStringBuilder.toString());
  }
  
  private Set certSubjectSerialSearch(X509CertSelector paramX509CertSelector, String[] paramArrayOfString, String paramString1, String paramString2)
    throws CertStoreException
  {
    HashSet localHashSet = new HashSet();
    for (;;)
    {
      try
      {
        localObject1 = paramX509CertSelector.getSubjectAsBytes();
        if ((localObject1 == null) && (paramX509CertSelector.getSubjectAsString() == null) && (paramX509CertSelector.getCertificate() == null))
        {
          paramX509CertSelector = search(paramString1, "*", paramArrayOfString);
          localHashSet.addAll(paramX509CertSelector);
          return localHashSet;
        }
        localObject1 = paramX509CertSelector.getCertificate();
        if (localObject1 != null)
        {
          localObject1 = paramX509CertSelector.getCertificate().getSubjectX500Principal().getName("RFC1779");
          paramX509CertSelector = paramX509CertSelector.getCertificate().getSerialNumber().toString();
        }
        else
        {
          if (paramX509CertSelector.getSubjectAsBytes() != null)
          {
            paramX509CertSelector = new X500Principal(paramX509CertSelector.getSubjectAsBytes()).getName("RFC1779");
            break label300;
          }
          paramX509CertSelector = paramX509CertSelector.getSubjectAsString();
          break label300;
        }
        paramString2 = parseDN((String)localObject1, paramString2);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("*");
        ((StringBuilder)localObject1).append(paramString2);
        ((StringBuilder)localObject1).append("*");
        localHashSet.addAll(search(paramString1, ((StringBuilder)localObject1).toString(), paramArrayOfString));
        if ((paramX509CertSelector != null) && (this.params.getSearchForSerialNumberIn() != null))
        {
          paramString1 = this.params.getSearchForSerialNumberIn();
          paramString2 = new StringBuilder();
          paramString2.append("*");
          paramString2.append(paramX509CertSelector);
          paramString2.append("*");
          paramX509CertSelector = search(paramString1, paramString2.toString(), paramArrayOfString);
          continue;
        }
        return localHashSet;
      }
      catch (IOException paramX509CertSelector)
      {
        paramArrayOfString = new StringBuilder();
        paramArrayOfString.append("exception processing selector: ");
        paramArrayOfString.append(paramX509CertSelector);
        throw new CertStoreException(paramArrayOfString.toString());
      }
      label300:
      Object localObject2 = null;
      Object localObject1 = paramX509CertSelector;
      paramX509CertSelector = (X509CertSelector)localObject2;
    }
  }
  
  private DirContext connectLDAP()
    throws NamingException
  {
    Properties localProperties = new Properties();
    localProperties.setProperty("java.naming.factory.initial", LDAP_PROVIDER);
    localProperties.setProperty("java.naming.batchsize", "0");
    localProperties.setProperty("java.naming.provider.url", this.params.getLdapURL());
    localProperties.setProperty("java.naming.factory.url.pkgs", "com.sun.jndi.url");
    localProperties.setProperty("java.naming.referral", REFERRALS_IGNORE);
    localProperties.setProperty("java.naming.security.authentication", "none");
    return new InitialDirContext(localProperties);
  }
  
  private Set getCACertificates(X509CertSelector paramX509CertSelector)
    throws CertStoreException
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = this.params.getCACertificateAttribute();
    paramX509CertSelector = certSubjectSerialSearch(paramX509CertSelector, arrayOfString, this.params.getLdapCACertificateAttributeName(), this.params.getCACertificateSubjectAttributeName());
    if (paramX509CertSelector.isEmpty()) {
      paramX509CertSelector.addAll(search(null, "*", arrayOfString));
    }
    return paramX509CertSelector;
  }
  
  private Set getCrossCertificates(X509CertSelector paramX509CertSelector)
    throws CertStoreException
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = this.params.getCrossCertificateAttribute();
    paramX509CertSelector = certSubjectSerialSearch(paramX509CertSelector, arrayOfString, this.params.getLdapCrossCertificateAttributeName(), this.params.getCrossCertificateSubjectAttributeName());
    if (paramX509CertSelector.isEmpty()) {
      paramX509CertSelector.addAll(search(null, "*", arrayOfString));
    }
    return paramX509CertSelector;
  }
  
  private Set getEndCertificates(X509CertSelector paramX509CertSelector)
    throws CertStoreException
  {
    String str1 = this.params.getUserCertificateAttribute();
    String str2 = this.params.getLdapUserCertificateAttributeName();
    String str3 = this.params.getUserCertificateSubjectAttributeName();
    return certSubjectSerialSearch(paramX509CertSelector, new String[] { str1 }, str2, str3);
  }
  
  private String parseDN(String paramString1, String paramString2)
  {
    paramString1 = paramString1.substring(paramString1.toLowerCase().indexOf(paramString2.toLowerCase()) + paramString2.length());
    int j = paramString1.indexOf(',');
    int i = j;
    if (j == -1) {}
    for (;;)
    {
      i = paramString1.length();
      do
      {
        if (paramString1.charAt(i - 1) != '\\') {
          break;
        }
        j = paramString1.indexOf(',', i + 1);
        i = j;
      } while (j != -1);
    }
    paramString1 = paramString1.substring(0, i);
    paramString2 = paramString1.substring(paramString1.indexOf('=') + 1);
    paramString1 = paramString2;
    if (paramString2.charAt(0) == ' ') {
      paramString1 = paramString2.substring(1);
    }
    paramString2 = paramString1;
    if (paramString1.startsWith("\"")) {
      paramString2 = paramString1.substring(1);
    }
    paramString1 = paramString2;
    if (paramString2.endsWith("\"")) {
      paramString1 = paramString2.substring(0, paramString2.length() - 1);
    }
    return paramString1;
  }
  
  /* Error */
  private Set search(String paramString1, String paramString2, String[] paramArrayOfString)
    throws CertStoreException
  {
    // Byte code:
    //   0: new 34	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: aload_1
    //   12: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload 5
    //   18: ldc -9
    //   20: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 5
    //   26: aload_2
    //   27: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 5
    //   33: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: astore 5
    //   38: aconst_null
    //   39: astore_2
    //   40: aconst_null
    //   41: astore 6
    //   43: aload_1
    //   44: ifnonnull +6 -> 50
    //   47: aconst_null
    //   48: astore 5
    //   50: new 68	java/util/HashSet
    //   53: dup
    //   54: invokespecial 69	java/util/HashSet:<init>	()V
    //   57: astore 8
    //   59: aload 6
    //   61: astore_1
    //   62: aload_0
    //   63: invokespecial 249	org/bouncycastle/jce/provider/X509LDAPCertStoreSpi:connectLDAP	()Ljavax/naming/directory/DirContext;
    //   66: astore 6
    //   68: aload 6
    //   70: astore_1
    //   71: aload 6
    //   73: astore_2
    //   74: new 251	javax/naming/directory/SearchControls
    //   77: dup
    //   78: invokespecial 252	javax/naming/directory/SearchControls:<init>	()V
    //   81: astore 9
    //   83: aload 6
    //   85: astore_1
    //   86: aload 6
    //   88: astore_2
    //   89: aload 9
    //   91: iconst_2
    //   92: invokevirtual 256	javax/naming/directory/SearchControls:setSearchScope	(I)V
    //   95: aload 6
    //   97: astore_1
    //   98: aload 6
    //   100: astore_2
    //   101: aload 9
    //   103: lconst_0
    //   104: invokevirtual 260	javax/naming/directory/SearchControls:setCountLimit	(J)V
    //   107: iconst_0
    //   108: istore 4
    //   110: aload 6
    //   112: astore_1
    //   113: aload 6
    //   115: astore_2
    //   116: iload 4
    //   118: aload_3
    //   119: arraylength
    //   120: if_icmpge +348 -> 468
    //   123: aload 6
    //   125: astore_1
    //   126: aload 6
    //   128: astore_2
    //   129: iconst_1
    //   130: anewarray 171	java/lang/String
    //   133: astore 10
    //   135: aload 10
    //   137: iconst_0
    //   138: aload_3
    //   139: iload 4
    //   141: aaload
    //   142: aastore
    //   143: aload 6
    //   145: astore_1
    //   146: aload 6
    //   148: astore_2
    //   149: aload 9
    //   151: aload 10
    //   153: invokevirtual 264	javax/naming/directory/SearchControls:setReturningAttributes	([Ljava/lang/String;)V
    //   156: aload 6
    //   158: astore_1
    //   159: aload 6
    //   161: astore_2
    //   162: new 34	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   169: astore 7
    //   171: aload 6
    //   173: astore_1
    //   174: aload 6
    //   176: astore_2
    //   177: aload 7
    //   179: ldc_w 266
    //   182: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload 6
    //   188: astore_1
    //   189: aload 6
    //   191: astore_2
    //   192: aload 7
    //   194: aload 5
    //   196: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload 6
    //   202: astore_1
    //   203: aload 6
    //   205: astore_2
    //   206: aload 7
    //   208: ldc_w 268
    //   211: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload 6
    //   217: astore_1
    //   218: aload 6
    //   220: astore_2
    //   221: aload 7
    //   223: aload 10
    //   225: iconst_0
    //   226: aaload
    //   227: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload 6
    //   233: astore_1
    //   234: aload 6
    //   236: astore_2
    //   237: aload 7
    //   239: ldc_w 270
    //   242: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: aload 6
    //   248: astore_1
    //   249: aload 6
    //   251: astore_2
    //   252: aload 7
    //   254: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: astore 7
    //   259: aload 5
    //   261: ifnonnull +77 -> 338
    //   264: aload 6
    //   266: astore_1
    //   267: aload 6
    //   269: astore_2
    //   270: new 34	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   277: astore 7
    //   279: aload 6
    //   281: astore_1
    //   282: aload 6
    //   284: astore_2
    //   285: aload 7
    //   287: ldc_w 272
    //   290: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload 6
    //   296: astore_1
    //   297: aload 6
    //   299: astore_2
    //   300: aload 7
    //   302: aload 10
    //   304: iconst_0
    //   305: aaload
    //   306: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: aload 6
    //   312: astore_1
    //   313: aload 6
    //   315: astore_2
    //   316: aload 7
    //   318: ldc_w 274
    //   321: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: aload 6
    //   327: astore_1
    //   328: aload 6
    //   330: astore_2
    //   331: aload 7
    //   333: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: astore 7
    //   338: aload 6
    //   340: astore_1
    //   341: aload 6
    //   343: astore_2
    //   344: aload 6
    //   346: aload_0
    //   347: getfield 32	org/bouncycastle/jce/provider/X509LDAPCertStoreSpi:params	Lorg/bouncycastle/jce/X509LDAPCertStoreParameters;
    //   350: invokevirtual 277	org/bouncycastle/jce/X509LDAPCertStoreParameters:getBaseDN	()Ljava/lang/String;
    //   353: aload 7
    //   355: aload 9
    //   357: invokeinterface 282 4 0
    //   362: astore 7
    //   364: aload 6
    //   366: astore_1
    //   367: aload 6
    //   369: astore_2
    //   370: aload 7
    //   372: invokeinterface 287 1 0
    //   377: ifeq +82 -> 459
    //   380: aload 6
    //   382: astore_1
    //   383: aload 6
    //   385: astore_2
    //   386: aload 7
    //   388: invokeinterface 291 1 0
    //   393: checkcast 293	javax/naming/directory/SearchResult
    //   396: invokevirtual 297	javax/naming/directory/SearchResult:getAttributes	()Ljavax/naming/directory/Attributes;
    //   399: invokeinterface 303 1 0
    //   404: invokeinterface 291 1 0
    //   409: checkcast 305	javax/naming/directory/Attribute
    //   412: invokeinterface 306 1 0
    //   417: astore 10
    //   419: aload 6
    //   421: astore_1
    //   422: aload 6
    //   424: astore_2
    //   425: aload 10
    //   427: invokeinterface 309 1 0
    //   432: ifeq -68 -> 364
    //   435: aload 6
    //   437: astore_1
    //   438: aload 6
    //   440: astore_2
    //   441: aload 8
    //   443: aload 10
    //   445: invokeinterface 291 1 0
    //   450: invokeinterface 313 2 0
    //   455: pop
    //   456: goto -37 -> 419
    //   459: iload 4
    //   461: iconst_1
    //   462: iadd
    //   463: istore 4
    //   465: goto -355 -> 110
    //   468: aload 6
    //   470: ifnull +10 -> 480
    //   473: aload 6
    //   475: invokeinterface 316 1 0
    //   480: aload 8
    //   482: areturn
    //   483: astore_2
    //   484: goto +50 -> 534
    //   487: astore_3
    //   488: aload_2
    //   489: astore_1
    //   490: new 34	java/lang/StringBuilder
    //   493: dup
    //   494: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   497: astore 5
    //   499: aload_2
    //   500: astore_1
    //   501: aload 5
    //   503: ldc_w 318
    //   506: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: pop
    //   510: aload_2
    //   511: astore_1
    //   512: aload 5
    //   514: aload_3
    //   515: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   518: pop
    //   519: aload_2
    //   520: astore_1
    //   521: new 64	java/security/cert/CertStoreException
    //   524: dup
    //   525: aload 5
    //   527: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   530: invokespecial 130	java/security/cert/CertStoreException:<init>	(Ljava/lang/String;)V
    //   533: athrow
    //   534: aload_1
    //   535: ifnull +9 -> 544
    //   538: aload_1
    //   539: invokeinterface 316 1 0
    //   544: aload_2
    //   545: athrow
    //   546: astore_1
    //   547: aload 8
    //   549: areturn
    //   550: astore_1
    //   551: goto -7 -> 544
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	554	0	this	X509LDAPCertStoreSpi
    //   0	554	1	paramString1	String
    //   0	554	2	paramString2	String
    //   0	554	3	paramArrayOfString	String[]
    //   108	356	4	i	int
    //   7	519	5	localObject1	Object
    //   41	433	6	localDirContext	DirContext
    //   169	218	7	localObject2	Object
    //   57	491	8	localHashSet	HashSet
    //   81	275	9	localSearchControls	javax.naming.directory.SearchControls
    //   133	311	10	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   62	68	483	finally
    //   74	83	483	finally
    //   89	95	483	finally
    //   101	107	483	finally
    //   116	123	483	finally
    //   129	135	483	finally
    //   149	156	483	finally
    //   162	171	483	finally
    //   177	186	483	finally
    //   192	200	483	finally
    //   206	215	483	finally
    //   221	231	483	finally
    //   237	246	483	finally
    //   252	259	483	finally
    //   270	279	483	finally
    //   285	294	483	finally
    //   300	310	483	finally
    //   316	325	483	finally
    //   331	338	483	finally
    //   344	364	483	finally
    //   370	380	483	finally
    //   386	419	483	finally
    //   425	435	483	finally
    //   441	456	483	finally
    //   490	499	483	finally
    //   501	510	483	finally
    //   512	519	483	finally
    //   521	534	483	finally
    //   62	68	487	java/lang/Exception
    //   74	83	487	java/lang/Exception
    //   89	95	487	java/lang/Exception
    //   101	107	487	java/lang/Exception
    //   116	123	487	java/lang/Exception
    //   129	135	487	java/lang/Exception
    //   149	156	487	java/lang/Exception
    //   162	171	487	java/lang/Exception
    //   177	186	487	java/lang/Exception
    //   192	200	487	java/lang/Exception
    //   206	215	487	java/lang/Exception
    //   221	231	487	java/lang/Exception
    //   237	246	487	java/lang/Exception
    //   252	259	487	java/lang/Exception
    //   270	279	487	java/lang/Exception
    //   285	294	487	java/lang/Exception
    //   300	310	487	java/lang/Exception
    //   316	325	487	java/lang/Exception
    //   331	338	487	java/lang/Exception
    //   344	364	487	java/lang/Exception
    //   370	380	487	java/lang/Exception
    //   386	419	487	java/lang/Exception
    //   425	435	487	java/lang/Exception
    //   441	456	487	java/lang/Exception
    //   473	480	546	java/lang/Exception
    //   538	544	550	java/lang/Exception
  }
  
  public Collection engineGetCRLs(CRLSelector paramCRLSelector)
    throws CertStoreException
  {
    Object localObject2 = new String[1];
    localObject2[0] = this.params.getCertificateRevocationListAttribute();
    if ((paramCRLSelector instanceof X509CRLSelector))
    {
      X509CRLSelector localX509CRLSelector = (X509CRLSelector)paramCRLSelector;
      HashSet localHashSet1 = new HashSet();
      String str = this.params.getLdapCertificateRevocationListAttributeName();
      HashSet localHashSet2 = new HashSet();
      Object localObject1;
      if (localX509CRLSelector.getIssuerNames() != null)
      {
        Iterator localIterator = localX509CRLSelector.getIssuerNames().iterator();
        while (localIterator.hasNext())
        {
          paramCRLSelector = localIterator.next();
          if ((paramCRLSelector instanceof String))
          {
            localObject1 = this.params.getCertificateRevocationListIssuerAttributeName();
            paramCRLSelector = (String)paramCRLSelector;
          }
          else
          {
            localObject1 = this.params.getCertificateRevocationListIssuerAttributeName();
            paramCRLSelector = new X500Principal((byte[])paramCRLSelector).getName("RFC1779");
          }
          paramCRLSelector = parseDN(paramCRLSelector, (String)localObject1);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("*");
          ((StringBuilder)localObject1).append(paramCRLSelector);
          ((StringBuilder)localObject1).append("*");
          localHashSet2.addAll(search(str, ((StringBuilder)localObject1).toString(), (String[])localObject2));
        }
      }
      localHashSet2.addAll(search(str, "*", (String[])localObject2));
      localHashSet2.addAll(search(null, "*", (String[])localObject2));
      paramCRLSelector = localHashSet2.iterator();
      try
      {
        localObject1 = CertificateFactory.getInstance("X.509", "BC");
        while (paramCRLSelector.hasNext())
        {
          localObject2 = ((CertificateFactory)localObject1).generateCRL(new ByteArrayInputStream((byte[])paramCRLSelector.next()));
          if (localX509CRLSelector.match((CRL)localObject2)) {
            localHashSet1.add(localObject2);
          }
        }
        return localHashSet1;
      }
      catch (Exception paramCRLSelector)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("CRL cannot be constructed from LDAP result ");
        ((StringBuilder)localObject1).append(paramCRLSelector);
        throw new CertStoreException(((StringBuilder)localObject1).toString());
      }
    }
    throw new CertStoreException("selector is not a X509CRLSelector");
  }
  
  public Collection engineGetCertificates(CertSelector paramCertSelector)
    throws CertStoreException
  {
    Object localObject1;
    Object localObject2;
    if ((paramCertSelector instanceof X509CertSelector))
    {
      paramCertSelector = (X509CertSelector)paramCertSelector;
      localObject1 = new HashSet();
      localObject2 = getEndCertificates(paramCertSelector);
      ((Set)localObject2).addAll(getCACertificates(paramCertSelector));
      ((Set)localObject2).addAll(getCrossCertificates(paramCertSelector));
      localObject2 = ((Set)localObject2).iterator();
    }
    for (;;)
    {
      try
      {
        localCertificateFactory = CertificateFactory.getInstance("X.509", "BC");
        if (((Iterator)localObject2).hasNext())
        {
          localObject4 = (byte[])((Iterator)localObject2).next();
          if ((localObject4 == null) || (localObject4.length == 0)) {
            continue;
          }
          localObject3 = new ArrayList();
          ((List)localObject3).add(localObject4);
        }
      }
      catch (Exception paramCertSelector)
      {
        CertificateFactory localCertificateFactory;
        Object localObject4;
        Object localObject3;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("certificate cannot be constructed from LDAP result: ");
        ((StringBuilder)localObject1).append(paramCertSelector);
        throw new CertStoreException(((StringBuilder)localObject1).toString());
      }
      try
      {
        localObject4 = CertificatePair.getInstance(new ASN1InputStream((byte[])localObject4).readObject());
        ((List)localObject3).clear();
        if (((CertificatePair)localObject4).getForward() != null) {
          ((List)localObject3).add(((CertificatePair)localObject4).getForward().getEncoded());
        }
        if (((CertificatePair)localObject4).getReverse() != null) {
          ((List)localObject3).add(((CertificatePair)localObject4).getReverse().getEncoded());
        }
      }
      catch (IOException|IllegalArgumentException localIOException)
      {
        continue;
      }
    }
    localObject3 = ((List)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = new ByteArrayInputStream((byte[])((Iterator)localObject3).next());
      try
      {
        localObject4 = localCertificateFactory.generateCertificate((InputStream)localObject4);
        if (paramCertSelector.match((java.security.cert.Certificate)localObject4)) {
          ((Set)localObject1).add(localObject4);
        }
      }
      catch (Exception localException) {}
    }
    return (Collection)localObject1;
    throw new CertStoreException("selector is not a X509CertSelector");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\provider\X509LDAPCertStoreSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */