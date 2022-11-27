package org.bouncycastle.x509.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.Principal;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.asn1.x509.CertificatePair;
import org.bouncycastle.jce.X509LDAPCertStoreParameters;
import org.bouncycastle.jce.provider.X509AttrCertParser;
import org.bouncycastle.jce.provider.X509CRLParser;
import org.bouncycastle.jce.provider.X509CertPairParser;
import org.bouncycastle.jce.provider.X509CertParser;
import org.bouncycastle.util.StoreException;
import org.bouncycastle.x509.AttributeCertificateHolder;
import org.bouncycastle.x509.AttributeCertificateIssuer;
import org.bouncycastle.x509.X509AttributeCertStoreSelector;
import org.bouncycastle.x509.X509AttributeCertificate;
import org.bouncycastle.x509.X509CRLStoreSelector;
import org.bouncycastle.x509.X509CertPairStoreSelector;
import org.bouncycastle.x509.X509CertStoreSelector;
import org.bouncycastle.x509.X509CertificatePair;

public class LDAPStoreHelper
{
  private static String LDAP_PROVIDER = "com.sun.jndi.ldap.LdapCtxFactory";
  private static String REFERRALS_IGNORE = "ignore";
  private static final String SEARCH_SECURITY_LEVEL = "none";
  private static final String URL_CONTEXT_PREFIX = "com.sun.jndi.url";
  private static int cacheSize = 32;
  private static long lifeTime = 60000L;
  private Map cacheMap = new HashMap(cacheSize);
  private X509LDAPCertStoreParameters params;
  
  public LDAPStoreHelper(X509LDAPCertStoreParameters paramX509LDAPCertStoreParameters)
  {
    this.params = paramX509LDAPCertStoreParameters;
  }
  
  private void addToCache(String paramString, List paramList)
  {
    try
    {
      Object localObject = new Date(System.currentTimeMillis());
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localObject);
      localArrayList.add(paramList);
      if (this.cacheMap.containsKey(paramString)) {}
      for (paramList = this.cacheMap;; paramList = this.cacheMap)
      {
        paramList.put(paramString, localArrayList);
        break;
        if (this.cacheMap.size() >= cacheSize)
        {
          Iterator localIterator = this.cacheMap.entrySet().iterator();
          long l1 = ((Date)localObject).getTime();
          paramList = null;
          while (localIterator.hasNext())
          {
            localObject = (Map.Entry)localIterator.next();
            long l2 = ((Date)((List)((Map.Entry)localObject).getValue()).get(0)).getTime();
            if (l2 < l1)
            {
              paramList = ((Map.Entry)localObject).getKey();
              l1 = l2;
            }
          }
          this.cacheMap.remove(paramList);
        }
      }
      return;
    }
    finally {}
  }
  
  private List attrCertSubjectSerialSearch(X509AttributeCertStoreSelector paramX509AttributeCertStoreSelector, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3)
    throws StoreException
  {
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Object localObject1 = paramX509AttributeCertStoreSelector.getHolder();
    Object localObject3 = null;
    if (localObject1 != null)
    {
      if (paramX509AttributeCertStoreSelector.getHolder().getSerialNumber() != null) {
        localHashSet.add(paramX509AttributeCertStoreSelector.getHolder().getSerialNumber().toString());
      }
      if (paramX509AttributeCertStoreSelector.getHolder().getEntityNames() != null)
      {
        localObject1 = paramX509AttributeCertStoreSelector.getHolder().getEntityNames();
        break label85;
      }
    }
    localObject1 = null;
    label85:
    Object localObject2 = localObject1;
    if (paramX509AttributeCertStoreSelector.getAttributeCert() != null)
    {
      if (paramX509AttributeCertStoreSelector.getAttributeCert().getHolder().getEntityNames() != null) {
        localObject1 = paramX509AttributeCertStoreSelector.getAttributeCert().getHolder().getEntityNames();
      }
      localHashSet.add(paramX509AttributeCertStoreSelector.getAttributeCert().getSerialNumber().toString());
      localObject2 = localObject1;
    }
    int i = 0;
    localObject1 = localObject3;
    if (localObject2 != null) {
      if ((localObject2[0] instanceof X500Principal)) {
        localObject1 = ((X500Principal)localObject2[0]).getName("RFC1779");
      } else {
        localObject1 = localObject2[0].getName();
      }
    }
    if (paramX509AttributeCertStoreSelector.getSerialNumber() != null) {
      localHashSet.add(paramX509AttributeCertStoreSelector.getSerialNumber().toString());
    }
    if (localObject1 != null) {
      while (i < paramArrayOfString3.length)
      {
        paramX509AttributeCertStoreSelector = parseDN((String)localObject1, paramArrayOfString3[i]);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("*");
        ((StringBuilder)localObject2).append(paramX509AttributeCertStoreSelector);
        ((StringBuilder)localObject2).append("*");
        localArrayList.addAll(search(paramArrayOfString2, ((StringBuilder)localObject2).toString(), paramArrayOfString1));
        i += 1;
      }
    }
    if ((localHashSet.size() > 0) && (this.params.getSearchForSerialNumberIn() != null))
    {
      paramX509AttributeCertStoreSelector = localHashSet.iterator();
      while (paramX509AttributeCertStoreSelector.hasNext())
      {
        paramArrayOfString3 = (String)paramX509AttributeCertStoreSelector.next();
        localArrayList.addAll(search(splitString(this.params.getSearchForSerialNumberIn()), paramArrayOfString3, paramArrayOfString1));
      }
    }
    if ((localHashSet.size() == 0) && (localObject1 == null)) {
      localArrayList.addAll(search(paramArrayOfString2, "*", paramArrayOfString1));
    }
    return localArrayList;
  }
  
  private List cRLIssuerSearch(X509CRLStoreSelector paramX509CRLStoreSelector, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3)
    throws StoreException
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new HashSet();
    if (paramX509CRLStoreSelector.getIssuers() != null) {
      ((Collection)localObject).addAll(paramX509CRLStoreSelector.getIssuers());
    }
    if (paramX509CRLStoreSelector.getCertificateChecking() != null) {
      ((Collection)localObject).add(getCertificateIssuer(paramX509CRLStoreSelector.getCertificateChecking()));
    }
    int i;
    if (paramX509CRLStoreSelector.getAttrCertificateChecking() != null)
    {
      paramX509CRLStoreSelector = paramX509CRLStoreSelector.getAttrCertificateChecking().getIssuer().getPrincipals();
      i = 0;
      while (i < paramX509CRLStoreSelector.length)
      {
        if ((paramX509CRLStoreSelector[i] instanceof X500Principal)) {
          ((Collection)localObject).add(paramX509CRLStoreSelector[i]);
        }
        i += 1;
      }
    }
    Iterator localIterator = ((Collection)localObject).iterator();
    paramX509CRLStoreSelector = null;
    if (localIterator.hasNext())
    {
      localObject = ((X500Principal)localIterator.next()).getName("RFC1779");
      i = 0;
      for (;;)
      {
        paramX509CRLStoreSelector = (X509CRLStoreSelector)localObject;
        if (i >= paramArrayOfString3.length) {
          break;
        }
        paramX509CRLStoreSelector = parseDN((String)localObject, paramArrayOfString3[i]);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("*");
        localStringBuilder.append(paramX509CRLStoreSelector);
        localStringBuilder.append("*");
        localArrayList.addAll(search(paramArrayOfString2, localStringBuilder.toString(), paramArrayOfString1));
        i += 1;
      }
    }
    if (paramX509CRLStoreSelector == null) {
      localArrayList.addAll(search(paramArrayOfString2, "*", paramArrayOfString1));
    }
    return localArrayList;
  }
  
  private List certSubjectSerialSearch(X509CertStoreSelector paramX509CertStoreSelector, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3)
    throws StoreException
  {
    ArrayList localArrayList = new ArrayList();
    String str2 = getSubjectAsString(paramX509CertStoreSelector);
    String str1;
    if (paramX509CertStoreSelector.getSerialNumber() != null) {
      str1 = paramX509CertStoreSelector.getSerialNumber().toString();
    } else {
      str1 = null;
    }
    if (paramX509CertStoreSelector.getCertificate() != null)
    {
      str2 = paramX509CertStoreSelector.getCertificate().getSubjectX500Principal().getName("RFC1779");
      str1 = paramX509CertStoreSelector.getCertificate().getSerialNumber().toString();
    }
    if (str2 != null)
    {
      int i = 0;
      while (i < paramArrayOfString3.length)
      {
        paramX509CertStoreSelector = parseDN(str2, paramArrayOfString3[i]);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("*");
        localStringBuilder.append(paramX509CertStoreSelector);
        localStringBuilder.append("*");
        localArrayList.addAll(search(paramArrayOfString2, localStringBuilder.toString(), paramArrayOfString1));
        i += 1;
      }
    }
    if ((str1 != null) && (this.params.getSearchForSerialNumberIn() != null)) {
      localArrayList.addAll(search(splitString(this.params.getSearchForSerialNumberIn()), str1, paramArrayOfString1));
    }
    if ((str1 == null) && (str2 == null)) {
      localArrayList.addAll(search(paramArrayOfString2, "*", paramArrayOfString1));
    }
    return localArrayList;
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
  
  private Set createAttributeCertificates(List paramList, X509AttributeCertStoreSelector paramX509AttributeCertStoreSelector)
    throws StoreException
  {
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    X509AttrCertParser localX509AttrCertParser = new X509AttrCertParser();
    while (paramList.hasNext()) {
      try
      {
        localX509AttrCertParser.engineInit(new ByteArrayInputStream((byte[])paramList.next()));
        X509AttributeCertificate localX509AttributeCertificate = (X509AttributeCertificate)localX509AttrCertParser.engineRead();
        if (paramX509AttributeCertStoreSelector.match(localX509AttributeCertificate)) {
          localHashSet.add(localX509AttributeCertificate);
        }
      }
      catch (StreamParsingException localStreamParsingException)
      {
        for (;;) {}
      }
    }
    return localHashSet;
  }
  
  private Set createCRLs(List paramList, X509CRLStoreSelector paramX509CRLStoreSelector)
    throws StoreException
  {
    HashSet localHashSet = new HashSet();
    X509CRLParser localX509CRLParser = new X509CRLParser();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      try
      {
        localX509CRLParser.engineInit(new ByteArrayInputStream((byte[])paramList.next()));
        X509CRL localX509CRL = (X509CRL)localX509CRLParser.engineRead();
        if (paramX509CRLStoreSelector.match(localX509CRL)) {
          localHashSet.add(localX509CRL);
        }
      }
      catch (StreamParsingException localStreamParsingException)
      {
        for (;;) {}
      }
    }
    return localHashSet;
  }
  
  private Set createCerts(List paramList, X509CertStoreSelector paramX509CertStoreSelector)
    throws StoreException
  {
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    X509CertParser localX509CertParser = new X509CertParser();
    while (paramList.hasNext()) {
      try
      {
        localX509CertParser.engineInit(new ByteArrayInputStream((byte[])paramList.next()));
        X509Certificate localX509Certificate = (X509Certificate)localX509CertParser.engineRead();
        if (paramX509CertStoreSelector.match(localX509Certificate)) {
          localHashSet.add(localX509Certificate);
        }
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
    return localHashSet;
  }
  
  private Set createCrossCertificatePairs(List paramList, X509CertPairStoreSelector paramX509CertPairStoreSelector)
    throws StoreException
  {
    HashSet localHashSet = new HashSet();
    for (int i = 0; i < paramList.size(); i = k + 1)
    {
      j = i;
      try
      {
        localObject = new X509CertPairParser();
        j = i;
        ((X509CertPairParser)localObject).engineInit(new ByteArrayInputStream((byte[])paramList.get(i)));
        j = i;
        localObject = (X509CertificatePair)((X509CertPairParser)localObject).engineRead();
      }
      catch (StreamParsingException localStreamParsingException)
      {
        Object localObject;
        byte[] arrayOfByte;
        for (;;) {}
      }
      catch (CertificateParsingException|IOException localCertificateParsingException)
      {
        int k = j;
        continue;
      }
      j = i;
      localObject = (byte[])paramList.get(i);
      k = i + 1;
      j = i;
      arrayOfByte = (byte[])paramList.get(k);
      j = i;
      localObject = new X509CertificatePair(new CertificatePair(Certificate.getInstance(new ASN1InputStream((byte[])localObject).readObject()), Certificate.getInstance(new ASN1InputStream(arrayOfByte).readObject())));
      i = k;
      k = i;
      j = i;
      if (paramX509CertPairStoreSelector.match(localObject))
      {
        j = i;
        localHashSet.add(localObject);
        k = i;
      }
    }
    return localHashSet;
  }
  
  private List crossCertificatePairSubjectSearch(X509CertPairStoreSelector paramX509CertPairStoreSelector, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3)
    throws StoreException
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    if (paramX509CertPairStoreSelector.getForwardSelector() != null) {
      localObject1 = getSubjectAsString(paramX509CertPairStoreSelector.getForwardSelector());
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (paramX509CertPairStoreSelector.getCertPair() != null)
    {
      localObject2 = localObject1;
      if (paramX509CertPairStoreSelector.getCertPair().getForward() != null) {
        localObject2 = paramX509CertPairStoreSelector.getCertPair().getForward().getSubjectX500Principal().getName("RFC1779");
      }
    }
    if (localObject2 != null)
    {
      int i = 0;
      while (i < paramArrayOfString3.length)
      {
        paramX509CertPairStoreSelector = parseDN((String)localObject2, paramArrayOfString3[i]);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("*");
        ((StringBuilder)localObject1).append(paramX509CertPairStoreSelector);
        ((StringBuilder)localObject1).append("*");
        localArrayList.addAll(search(paramArrayOfString2, ((StringBuilder)localObject1).toString(), paramArrayOfString1));
        i += 1;
      }
    }
    if (localObject2 == null) {
      localArrayList.addAll(search(paramArrayOfString2, "*", paramArrayOfString1));
    }
    return localArrayList;
  }
  
  private X500Principal getCertificateIssuer(X509Certificate paramX509Certificate)
  {
    return paramX509Certificate.getIssuerX500Principal();
  }
  
  private List getFromCache(String paramString)
  {
    paramString = (List)this.cacheMap.get(paramString);
    long l = System.currentTimeMillis();
    if (paramString != null)
    {
      if (((Date)paramString.get(0)).getTime() < l - lifeTime) {
        return null;
      }
      return (List)paramString.get(1);
    }
    return null;
  }
  
  private String getSubjectAsString(X509CertStoreSelector paramX509CertStoreSelector)
  {
    try
    {
      paramX509CertStoreSelector = paramX509CertStoreSelector.getSubjectAsBytes();
      if (paramX509CertStoreSelector != null)
      {
        paramX509CertStoreSelector = new X500Principal(paramX509CertStoreSelector).getName("RFC1779");
        return paramX509CertStoreSelector;
      }
      return null;
    }
    catch (IOException paramX509CertStoreSelector)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("exception processing name: ");
      localStringBuilder.append(paramX509CertStoreSelector.getMessage());
      throw new StoreException(localStringBuilder.toString(), paramX509CertStoreSelector);
    }
  }
  
  private String parseDN(String paramString1, String paramString2)
  {
    String str = paramString1.toLowerCase();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2.toLowerCase());
    localStringBuilder.append("=");
    int i = str.indexOf(localStringBuilder.toString());
    if (i == -1) {
      return "";
    }
    paramString1 = paramString1.substring(i + paramString2.length());
    int j = paramString1.indexOf(',');
    i = j;
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
  private List search(String[] paramArrayOfString1, String paramString, String[] paramArrayOfString2)
    throws StoreException
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 7
    //   9: aload_1
    //   10: ifnonnull +8 -> 18
    //   13: aconst_null
    //   14: astore_1
    //   15: goto +145 -> 160
    //   18: aload_2
    //   19: astore 6
    //   21: aload_2
    //   22: ldc_w 455
    //   25: invokevirtual 458	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   28: ifeq +7 -> 35
    //   31: ldc -74
    //   33: astore 6
    //   35: ldc_w 424
    //   38: astore_2
    //   39: iconst_0
    //   40: istore 4
    //   42: iload 4
    //   44: aload_1
    //   45: arraylength
    //   46: if_icmpge +79 -> 125
    //   49: new 179	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   56: astore 9
    //   58: aload 9
    //   60: aload_2
    //   61: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload 9
    //   67: ldc_w 460
    //   70: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload 9
    //   76: aload_1
    //   77: iload 4
    //   79: aaload
    //   80: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload 9
    //   86: ldc_w 418
    //   89: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload 9
    //   95: aload 6
    //   97: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload 9
    //   103: ldc_w 462
    //   106: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload 9
    //   112: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: astore_2
    //   116: iload 4
    //   118: iconst_1
    //   119: iadd
    //   120: istore 4
    //   122: goto -80 -> 42
    //   125: new 179	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   132: astore_1
    //   133: aload_1
    //   134: ldc_w 464
    //   137: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload_1
    //   142: aload_2
    //   143: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload_1
    //   148: ldc_w 462
    //   151: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload_1
    //   156: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: astore_1
    //   160: ldc_w 424
    //   163: astore_2
    //   164: iload 5
    //   166: istore 4
    //   168: iload 4
    //   170: aload_3
    //   171: arraylength
    //   172: if_icmpge +62 -> 234
    //   175: new 179	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   182: astore 6
    //   184: aload 6
    //   186: aload_2
    //   187: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload 6
    //   193: ldc_w 460
    //   196: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload 6
    //   202: aload_3
    //   203: iload 4
    //   205: aaload
    //   206: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: aload 6
    //   212: ldc_w 466
    //   215: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload 6
    //   221: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: astore_2
    //   225: iload 4
    //   227: iconst_1
    //   228: iadd
    //   229: istore 4
    //   231: goto -63 -> 168
    //   234: new 179	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   241: astore 6
    //   243: aload 6
    //   245: ldc_w 464
    //   248: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload 6
    //   254: aload_2
    //   255: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: aload 6
    //   261: ldc_w 462
    //   264: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: pop
    //   268: aload 6
    //   270: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: astore 6
    //   275: new 179	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   282: astore_2
    //   283: aload_2
    //   284: ldc_w 468
    //   287: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload_2
    //   292: aload_1
    //   293: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: aload_2
    //   298: ldc_w 424
    //   301: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload_2
    //   306: aload 6
    //   308: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload_2
    //   313: ldc_w 462
    //   316: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload_2
    //   321: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: astore_2
    //   325: aload_1
    //   326: ifnonnull +6 -> 332
    //   329: goto +6 -> 335
    //   332: aload_2
    //   333: astore 6
    //   335: aload_0
    //   336: aload 6
    //   338: invokespecial 470	org/bouncycastle/x509/util/LDAPStoreHelper:getFromCache	(Ljava/lang/String;)Ljava/util/List;
    //   341: astore_1
    //   342: aload_1
    //   343: ifnull +5 -> 348
    //   346: aload_1
    //   347: areturn
    //   348: new 61	java/util/ArrayList
    //   351: dup
    //   352: invokespecial 62	java/util/ArrayList:<init>	()V
    //   355: astore 9
    //   357: aload 8
    //   359: astore_1
    //   360: aload_0
    //   361: invokespecial 472	org/bouncycastle/x509/util/LDAPStoreHelper:connectLDAP	()Ljavax/naming/directory/DirContext;
    //   364: astore_2
    //   365: aload_2
    //   366: astore 7
    //   368: aload_2
    //   369: astore_1
    //   370: new 474	javax/naming/directory/SearchControls
    //   373: dup
    //   374: invokespecial 475	javax/naming/directory/SearchControls:<init>	()V
    //   377: astore 8
    //   379: aload_2
    //   380: astore 7
    //   382: aload_2
    //   383: astore_1
    //   384: aload 8
    //   386: iconst_2
    //   387: invokevirtual 478	javax/naming/directory/SearchControls:setSearchScope	(I)V
    //   390: aload_2
    //   391: astore 7
    //   393: aload_2
    //   394: astore_1
    //   395: aload 8
    //   397: lconst_0
    //   398: invokevirtual 481	javax/naming/directory/SearchControls:setCountLimit	(J)V
    //   401: aload_2
    //   402: astore 7
    //   404: aload_2
    //   405: astore_1
    //   406: aload 8
    //   408: aload_3
    //   409: invokevirtual 485	javax/naming/directory/SearchControls:setReturningAttributes	([Ljava/lang/String;)V
    //   412: aload_2
    //   413: astore 7
    //   415: aload_2
    //   416: astore_1
    //   417: aload_2
    //   418: aload_0
    //   419: getfield 46	org/bouncycastle/x509/util/LDAPStoreHelper:params	Lorg/bouncycastle/jce/X509LDAPCertStoreParameters;
    //   422: invokevirtual 488	org/bouncycastle/jce/X509LDAPCertStoreParameters:getBaseDN	()Ljava/lang/String;
    //   425: aload 6
    //   427: aload 8
    //   429: invokeinterface 493 4 0
    //   434: astore_3
    //   435: aload_2
    //   436: astore 7
    //   438: aload_2
    //   439: astore_1
    //   440: aload_3
    //   441: invokeinterface 498 1 0
    //   446: ifeq +78 -> 524
    //   449: aload_2
    //   450: astore 7
    //   452: aload_2
    //   453: astore_1
    //   454: aload_3
    //   455: invokeinterface 499 1 0
    //   460: checkcast 501	javax/naming/directory/SearchResult
    //   463: invokevirtual 505	javax/naming/directory/SearchResult:getAttributes	()Ljavax/naming/directory/Attributes;
    //   466: invokeinterface 511 1 0
    //   471: invokeinterface 499 1 0
    //   476: checkcast 513	javax/naming/directory/Attribute
    //   479: invokeinterface 514 1 0
    //   484: astore 8
    //   486: aload_2
    //   487: astore 7
    //   489: aload_2
    //   490: astore_1
    //   491: aload 8
    //   493: invokeinterface 517 1 0
    //   498: ifeq -63 -> 435
    //   501: aload_2
    //   502: astore 7
    //   504: aload_2
    //   505: astore_1
    //   506: aload 9
    //   508: aload 8
    //   510: invokeinterface 499 1 0
    //   515: invokeinterface 68 2 0
    //   520: pop
    //   521: goto -35 -> 486
    //   524: aload_2
    //   525: astore 7
    //   527: aload_2
    //   528: astore_1
    //   529: aload_0
    //   530: aload 6
    //   532: aload 9
    //   534: invokespecial 519	org/bouncycastle/x509/util/LDAPStoreHelper:addToCache	(Ljava/lang/String;Ljava/util/List;)V
    //   537: aload_2
    //   538: ifnull +36 -> 574
    //   541: aload_2
    //   542: astore_1
    //   543: aload_1
    //   544: invokeinterface 522 1 0
    //   549: aload 9
    //   551: areturn
    //   552: astore_1
    //   553: aload 7
    //   555: ifnull +10 -> 565
    //   558: aload 7
    //   560: invokeinterface 522 1 0
    //   565: aload_1
    //   566: athrow
    //   567: aload_1
    //   568: ifnull +6 -> 574
    //   571: goto -28 -> 543
    //   574: aload 9
    //   576: areturn
    //   577: astore_2
    //   578: goto -11 -> 567
    //   581: astore_1
    //   582: aload 9
    //   584: areturn
    //   585: astore_2
    //   586: goto -21 -> 565
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	589	0	this	LDAPStoreHelper
    //   0	589	1	paramArrayOfString1	String[]
    //   0	589	2	paramString	String
    //   0	589	3	paramArrayOfString2	String[]
    //   40	190	4	i	int
    //   1	164	5	j	int
    //   19	512	6	localObject1	Object
    //   7	552	7	str	String
    //   4	505	8	localObject2	Object
    //   56	527	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   360	365	552	finally
    //   370	379	552	finally
    //   384	390	552	finally
    //   395	401	552	finally
    //   406	412	552	finally
    //   417	435	552	finally
    //   440	449	552	finally
    //   454	486	552	finally
    //   491	501	552	finally
    //   506	521	552	finally
    //   529	537	552	finally
    //   360	365	577	javax/naming/NamingException
    //   370	379	577	javax/naming/NamingException
    //   384	390	577	javax/naming/NamingException
    //   395	401	577	javax/naming/NamingException
    //   406	412	577	javax/naming/NamingException
    //   417	435	577	javax/naming/NamingException
    //   440	449	577	javax/naming/NamingException
    //   454	486	577	javax/naming/NamingException
    //   491	501	577	javax/naming/NamingException
    //   506	521	577	javax/naming/NamingException
    //   529	537	577	javax/naming/NamingException
    //   543	549	581	java/lang/Exception
    //   558	565	585	java/lang/Exception
  }
  
  private String[] splitString(String paramString)
  {
    return paramString.split("\\s+");
  }
  
  public Collection getAACertificates(X509AttributeCertStoreSelector paramX509AttributeCertStoreSelector)
    throws StoreException
  {
    String[] arrayOfString1 = splitString(this.params.getAACertificateAttribute());
    String[] arrayOfString2 = splitString(this.params.getLdapAACertificateAttributeName());
    String[] arrayOfString3 = splitString(this.params.getAACertificateSubjectAttributeName());
    Set localSet = createAttributeCertificates(attrCertSubjectSerialSearch(paramX509AttributeCertStoreSelector, arrayOfString1, arrayOfString2, arrayOfString3), paramX509AttributeCertStoreSelector);
    if (localSet.size() == 0) {
      localSet.addAll(createAttributeCertificates(attrCertSubjectSerialSearch(new X509AttributeCertStoreSelector(), arrayOfString1, arrayOfString2, arrayOfString3), paramX509AttributeCertStoreSelector));
    }
    return localSet;
  }
  
  public Collection getAttributeAuthorityRevocationLists(X509CRLStoreSelector paramX509CRLStoreSelector)
    throws StoreException
  {
    String[] arrayOfString1 = splitString(this.params.getAttributeAuthorityRevocationListAttribute());
    String[] arrayOfString2 = splitString(this.params.getLdapAttributeAuthorityRevocationListAttributeName());
    String[] arrayOfString3 = splitString(this.params.getAttributeAuthorityRevocationListIssuerAttributeName());
    Set localSet = createCRLs(cRLIssuerSearch(paramX509CRLStoreSelector, arrayOfString1, arrayOfString2, arrayOfString3), paramX509CRLStoreSelector);
    if (localSet.size() == 0) {
      localSet.addAll(createCRLs(cRLIssuerSearch(new X509CRLStoreSelector(), arrayOfString1, arrayOfString2, arrayOfString3), paramX509CRLStoreSelector));
    }
    return localSet;
  }
  
  public Collection getAttributeCertificateAttributes(X509AttributeCertStoreSelector paramX509AttributeCertStoreSelector)
    throws StoreException
  {
    String[] arrayOfString1 = splitString(this.params.getAttributeCertificateAttributeAttribute());
    String[] arrayOfString2 = splitString(this.params.getLdapAttributeCertificateAttributeAttributeName());
    String[] arrayOfString3 = splitString(this.params.getAttributeCertificateAttributeSubjectAttributeName());
    Set localSet = createAttributeCertificates(attrCertSubjectSerialSearch(paramX509AttributeCertStoreSelector, arrayOfString1, arrayOfString2, arrayOfString3), paramX509AttributeCertStoreSelector);
    if (localSet.size() == 0) {
      localSet.addAll(createAttributeCertificates(attrCertSubjectSerialSearch(new X509AttributeCertStoreSelector(), arrayOfString1, arrayOfString2, arrayOfString3), paramX509AttributeCertStoreSelector));
    }
    return localSet;
  }
  
  public Collection getAttributeCertificateRevocationLists(X509CRLStoreSelector paramX509CRLStoreSelector)
    throws StoreException
  {
    String[] arrayOfString1 = splitString(this.params.getAttributeCertificateRevocationListAttribute());
    String[] arrayOfString2 = splitString(this.params.getLdapAttributeCertificateRevocationListAttributeName());
    String[] arrayOfString3 = splitString(this.params.getAttributeCertificateRevocationListIssuerAttributeName());
    Set localSet = createCRLs(cRLIssuerSearch(paramX509CRLStoreSelector, arrayOfString1, arrayOfString2, arrayOfString3), paramX509CRLStoreSelector);
    if (localSet.size() == 0) {
      localSet.addAll(createCRLs(cRLIssuerSearch(new X509CRLStoreSelector(), arrayOfString1, arrayOfString2, arrayOfString3), paramX509CRLStoreSelector));
    }
    return localSet;
  }
  
  public Collection getAttributeDescriptorCertificates(X509AttributeCertStoreSelector paramX509AttributeCertStoreSelector)
    throws StoreException
  {
    String[] arrayOfString1 = splitString(this.params.getAttributeDescriptorCertificateAttribute());
    String[] arrayOfString2 = splitString(this.params.getLdapAttributeDescriptorCertificateAttributeName());
    String[] arrayOfString3 = splitString(this.params.getAttributeDescriptorCertificateSubjectAttributeName());
    Set localSet = createAttributeCertificates(attrCertSubjectSerialSearch(paramX509AttributeCertStoreSelector, arrayOfString1, arrayOfString2, arrayOfString3), paramX509AttributeCertStoreSelector);
    if (localSet.size() == 0) {
      localSet.addAll(createAttributeCertificates(attrCertSubjectSerialSearch(new X509AttributeCertStoreSelector(), arrayOfString1, arrayOfString2, arrayOfString3), paramX509AttributeCertStoreSelector));
    }
    return localSet;
  }
  
  public Collection getAuthorityRevocationLists(X509CRLStoreSelector paramX509CRLStoreSelector)
    throws StoreException
  {
    String[] arrayOfString1 = splitString(this.params.getAuthorityRevocationListAttribute());
    String[] arrayOfString2 = splitString(this.params.getLdapAuthorityRevocationListAttributeName());
    String[] arrayOfString3 = splitString(this.params.getAuthorityRevocationListIssuerAttributeName());
    Set localSet = createCRLs(cRLIssuerSearch(paramX509CRLStoreSelector, arrayOfString1, arrayOfString2, arrayOfString3), paramX509CRLStoreSelector);
    if (localSet.size() == 0) {
      localSet.addAll(createCRLs(cRLIssuerSearch(new X509CRLStoreSelector(), arrayOfString1, arrayOfString2, arrayOfString3), paramX509CRLStoreSelector));
    }
    return localSet;
  }
  
  public Collection getCACertificates(X509CertStoreSelector paramX509CertStoreSelector)
    throws StoreException
  {
    String[] arrayOfString1 = splitString(this.params.getCACertificateAttribute());
    String[] arrayOfString2 = splitString(this.params.getLdapCACertificateAttributeName());
    String[] arrayOfString3 = splitString(this.params.getCACertificateSubjectAttributeName());
    Set localSet = createCerts(certSubjectSerialSearch(paramX509CertStoreSelector, arrayOfString1, arrayOfString2, arrayOfString3), paramX509CertStoreSelector);
    if (localSet.size() == 0) {
      localSet.addAll(createCerts(certSubjectSerialSearch(new X509CertStoreSelector(), arrayOfString1, arrayOfString2, arrayOfString3), paramX509CertStoreSelector));
    }
    return localSet;
  }
  
  public Collection getCertificateRevocationLists(X509CRLStoreSelector paramX509CRLStoreSelector)
    throws StoreException
  {
    String[] arrayOfString1 = splitString(this.params.getCertificateRevocationListAttribute());
    String[] arrayOfString2 = splitString(this.params.getLdapCertificateRevocationListAttributeName());
    String[] arrayOfString3 = splitString(this.params.getCertificateRevocationListIssuerAttributeName());
    Set localSet = createCRLs(cRLIssuerSearch(paramX509CRLStoreSelector, arrayOfString1, arrayOfString2, arrayOfString3), paramX509CRLStoreSelector);
    if (localSet.size() == 0) {
      localSet.addAll(createCRLs(cRLIssuerSearch(new X509CRLStoreSelector(), arrayOfString1, arrayOfString2, arrayOfString3), paramX509CRLStoreSelector));
    }
    return localSet;
  }
  
  public Collection getCrossCertificatePairs(X509CertPairStoreSelector paramX509CertPairStoreSelector)
    throws StoreException
  {
    String[] arrayOfString1 = splitString(this.params.getCrossCertificateAttribute());
    String[] arrayOfString2 = splitString(this.params.getLdapCrossCertificateAttributeName());
    String[] arrayOfString3 = splitString(this.params.getCrossCertificateSubjectAttributeName());
    Set localSet = createCrossCertificatePairs(crossCertificatePairSubjectSearch(paramX509CertPairStoreSelector, arrayOfString1, arrayOfString2, arrayOfString3), paramX509CertPairStoreSelector);
    if (localSet.size() == 0)
    {
      X509CertStoreSelector localX509CertStoreSelector = new X509CertStoreSelector();
      X509CertPairStoreSelector localX509CertPairStoreSelector = new X509CertPairStoreSelector();
      localX509CertPairStoreSelector.setForwardSelector(localX509CertStoreSelector);
      localX509CertPairStoreSelector.setReverseSelector(localX509CertStoreSelector);
      localSet.addAll(createCrossCertificatePairs(crossCertificatePairSubjectSearch(localX509CertPairStoreSelector, arrayOfString1, arrayOfString2, arrayOfString3), paramX509CertPairStoreSelector));
    }
    return localSet;
  }
  
  public Collection getDeltaCertificateRevocationLists(X509CRLStoreSelector paramX509CRLStoreSelector)
    throws StoreException
  {
    String[] arrayOfString1 = splitString(this.params.getDeltaRevocationListAttribute());
    String[] arrayOfString2 = splitString(this.params.getLdapDeltaRevocationListAttributeName());
    String[] arrayOfString3 = splitString(this.params.getDeltaRevocationListIssuerAttributeName());
    Set localSet = createCRLs(cRLIssuerSearch(paramX509CRLStoreSelector, arrayOfString1, arrayOfString2, arrayOfString3), paramX509CRLStoreSelector);
    if (localSet.size() == 0) {
      localSet.addAll(createCRLs(cRLIssuerSearch(new X509CRLStoreSelector(), arrayOfString1, arrayOfString2, arrayOfString3), paramX509CRLStoreSelector));
    }
    return localSet;
  }
  
  public Collection getUserCertificates(X509CertStoreSelector paramX509CertStoreSelector)
    throws StoreException
  {
    String[] arrayOfString1 = splitString(this.params.getUserCertificateAttribute());
    String[] arrayOfString2 = splitString(this.params.getLdapUserCertificateAttributeName());
    String[] arrayOfString3 = splitString(this.params.getUserCertificateSubjectAttributeName());
    Set localSet = createCerts(certSubjectSerialSearch(paramX509CertStoreSelector, arrayOfString1, arrayOfString2, arrayOfString3), paramX509CertStoreSelector);
    if (localSet.size() == 0) {
      localSet.addAll(createCerts(certSubjectSerialSearch(new X509CertStoreSelector(), arrayOfString1, arrayOfString2, arrayOfString3), paramX509CertStoreSelector));
    }
    return localSet;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\x50\\util\LDAPStoreHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */