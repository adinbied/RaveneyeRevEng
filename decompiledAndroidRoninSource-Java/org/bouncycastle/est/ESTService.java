package org.bouncycastle.est;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cmc.CMCException;
import org.bouncycastle.cmc.SimplePKIResponse;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;
import org.bouncycastle.pkcs.PKCS10CertificationRequestBuilder;
import org.bouncycastle.util.Selector;
import org.bouncycastle.util.Store;
import org.bouncycastle.util.encoders.Base64;

public class ESTService
{
  protected static final String CACERTS = "/cacerts";
  protected static final String CSRATTRS = "/csrattrs";
  protected static final String FULLCMC = "/fullcmc";
  protected static final String SERVERGEN = "/serverkeygen";
  protected static final String SIMPLE_ENROLL = "/simpleenroll";
  protected static final String SIMPLE_REENROLL = "/simplereenroll";
  protected static final Set<String> illegalParts;
  private static final Pattern pathInvalid = Pattern.compile("^[0-9a-zA-Z_\\-.~!$&'()*+,;=]+");
  private final ESTClientProvider clientProvider;
  private final String server;
  
  static
  {
    HashSet localHashSet = new HashSet();
    illegalParts = localHashSet;
    localHashSet.add("cacerts");
    illegalParts.add("simpleenroll");
    illegalParts.add("simplereenroll");
    illegalParts.add("fullcmc");
    illegalParts.add("serverkeygen");
    illegalParts.add("csrattrs");
  }
  
  ESTService(String paramString1, String paramString2, ESTClientProvider paramESTClientProvider)
  {
    paramString1 = verifyServer(paramString1);
    if (paramString2 != null)
    {
      paramString2 = verifyLabel(paramString2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("https://");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("/.well-known/est/");
      localStringBuilder.append(paramString2);
      paramString1 = localStringBuilder.toString();
    }
    else
    {
      paramString2 = new StringBuilder();
      paramString2.append("https://");
      paramString2.append(paramString1);
      paramString2.append("/.well-known/est");
      paramString1 = paramString2.toString();
    }
    this.server = paramString1;
    this.clientProvider = paramESTClientProvider;
  }
  
  private String annotateRequest(byte[] paramArrayOfByte)
  {
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
    int j = 0;
    int i;
    do
    {
      i = j + 48;
      if (i < paramArrayOfByte.length)
      {
        localPrintWriter.print(Base64.toBase64String(paramArrayOfByte, j, 48));
      }
      else
      {
        localPrintWriter.print(Base64.toBase64String(paramArrayOfByte, j, paramArrayOfByte.length - j));
        i = paramArrayOfByte.length;
      }
      localPrintWriter.print('\n');
      j = i;
    } while (i < paramArrayOfByte.length);
    localPrintWriter.flush();
    return localStringWriter.toString();
  }
  
  public static X509CertificateHolder[] storeToArray(Store<X509CertificateHolder> paramStore)
  {
    return storeToArray(paramStore, null);
  }
  
  public static X509CertificateHolder[] storeToArray(Store<X509CertificateHolder> paramStore, Selector<X509CertificateHolder> paramSelector)
  {
    paramStore = paramStore.getMatches(paramSelector);
    return (X509CertificateHolder[])paramStore.toArray(new X509CertificateHolder[paramStore.size()]);
  }
  
  private String verifyLabel(String paramString)
  {
    String str;
    for (;;)
    {
      str = paramString;
      if (!paramString.endsWith("/")) {
        break;
      }
      str = paramString;
      if (paramString.length() <= 0) {
        break;
      }
      paramString = paramString.substring(0, paramString.length() - 1);
    }
    while ((str.startsWith("/")) && (str.length() > 0)) {
      str = str.substring(1);
    }
    if (str.length() != 0)
    {
      if (pathInvalid.matcher(str).matches())
      {
        if (!illegalParts.contains(str)) {
          return str;
        }
        paramString = new StringBuilder();
        paramString.append("Label ");
        paramString.append(str);
        paramString.append(" is a reserved path segment.");
        throw new IllegalArgumentException(paramString.toString());
      }
      paramString = new StringBuilder();
      paramString.append("Server path ");
      paramString.append(str);
      paramString.append(" contains invalid characters");
      throw new IllegalArgumentException(paramString.toString());
    }
    throw new IllegalArgumentException("Label set but after trimming '/' is not zero length string.");
  }
  
  private String verifyServer(String paramString)
  {
    try
    {
      while ((paramString.endsWith("/")) && (paramString.length() > 0)) {
        paramString = paramString.substring(0, paramString.length() - 1);
      }
      if (!paramString.contains("://"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("https://");
        ((StringBuilder)localObject).append(paramString);
        localObject = new URL(((StringBuilder)localObject).toString());
        if (((URL)localObject).getPath().length() != 0)
        {
          if (((URL)localObject).getPath().equals("/")) {
            return paramString;
          }
          throw new IllegalArgumentException("Server contains path, must only be <dnsname/ipaddress>:port, a path of '/.well-known/est/<label>' will be added arbitrarily.");
        }
      }
      else
      {
        throw new IllegalArgumentException("Server contains scheme, must only be <dnsname/ipaddress>:port, https:// will be added arbitrarily.");
      }
    }
    catch (Exception paramString)
    {
      if ((paramString instanceof IllegalArgumentException)) {
        throw ((IllegalArgumentException)paramString);
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Scheme and host is invalid: ");
      ((StringBuilder)localObject).append(paramString.getMessage());
      throw new IllegalArgumentException(((StringBuilder)localObject).toString(), paramString);
    }
    return paramString;
  }
  
  /* Error */
  public CACertsResponse getCACerts()
    throws Exception
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 82	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   9: astore_3
    //   10: aload_3
    //   11: aload_0
    //   12: getfield 99	org/bouncycastle/est/ESTService:server	Ljava/lang/String;
    //   15: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: pop
    //   19: aload_3
    //   20: ldc 10
    //   22: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: new 217	java/net/URL
    //   29: dup
    //   30: aload_3
    //   31: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokespecial 218	java/net/URL:<init>	(Ljava/lang/String;)V
    //   37: astore 6
    //   39: aload_0
    //   40: getfield 101	org/bouncycastle/est/ESTService:clientProvider	Lorg/bouncycastle/est/ESTClientProvider;
    //   43: invokeinterface 244 1 0
    //   48: astore_3
    //   49: new 246	org/bouncycastle/est/ESTRequestBuilder
    //   52: dup
    //   53: ldc -8
    //   55: aload 6
    //   57: invokespecial 251	org/bouncycastle/est/ESTRequestBuilder:<init>	(Ljava/lang/String;Ljava/net/URL;)V
    //   60: aload_3
    //   61: invokevirtual 255	org/bouncycastle/est/ESTRequestBuilder:withClient	(Lorg/bouncycastle/est/ESTClient;)Lorg/bouncycastle/est/ESTRequestBuilder;
    //   64: invokevirtual 259	org/bouncycastle/est/ESTRequestBuilder:build	()Lorg/bouncycastle/est/ESTRequest;
    //   67: astore 7
    //   69: aload_3
    //   70: aload 7
    //   72: invokeinterface 265 2 0
    //   77: astore 5
    //   79: aload 5
    //   81: invokevirtual 270	org/bouncycastle/est/ESTResponse:getStatusCode	()I
    //   84: istore_1
    //   85: iload_1
    //   86: sipush 200
    //   89: if_icmpne +280 -> 369
    //   92: ldc_w 272
    //   95: aload 5
    //   97: invokevirtual 276	org/bouncycastle/est/ESTResponse:getHeaders	()Lorg/bouncycastle/est/HttpUtil$Headers;
    //   100: ldc_w 278
    //   103: invokevirtual 283	org/bouncycastle/est/HttpUtil$Headers:getFirstValue	(Ljava/lang/String;)Ljava/lang/String;
    //   106: invokevirtual 224	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   109: ifne +120 -> 229
    //   112: aload 5
    //   114: invokevirtual 276	org/bouncycastle/est/ESTResponse:getHeaders	()Lorg/bouncycastle/est/HttpUtil$Headers;
    //   117: ldc_w 278
    //   120: invokevirtual 283	org/bouncycastle/est/HttpUtil$Headers:getFirstValue	(Ljava/lang/String;)Ljava/lang/String;
    //   123: ifnull +467 -> 590
    //   126: new 82	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   133: astore_2
    //   134: aload_2
    //   135: ldc_w 285
    //   138: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload_2
    //   143: aload 5
    //   145: invokevirtual 276	org/bouncycastle/est/ESTResponse:getHeaders	()Lorg/bouncycastle/est/HttpUtil$Headers;
    //   148: ldc_w 278
    //   151: invokevirtual 283	org/bouncycastle/est/HttpUtil$Headers:getFirstValue	(Ljava/lang/String;)Ljava/lang/String;
    //   154: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload_2
    //   159: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: astore_2
    //   163: goto +3 -> 166
    //   166: new 82	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   173: astore_3
    //   174: aload_3
    //   175: ldc_w 287
    //   178: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload_3
    //   183: aload 6
    //   185: invokevirtual 288	java/net/URL:toString	()Ljava/lang/String;
    //   188: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload_3
    //   193: ldc_w 290
    //   196: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload_3
    //   201: aload_2
    //   202: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: new 292	org/bouncycastle/est/ESTException
    //   209: dup
    //   210: aload_3
    //   211: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: aconst_null
    //   215: aload 5
    //   217: invokevirtual 270	org/bouncycastle/est/ESTResponse:getStatusCode	()I
    //   220: aload 5
    //   222: invokevirtual 296	org/bouncycastle/est/ESTResponse:getInputStream	()Ljava/io/InputStream;
    //   225: invokespecial 299	org/bouncycastle/est/ESTException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;ILjava/io/InputStream;)V
    //   228: athrow
    //   229: aload 5
    //   231: invokevirtual 303	org/bouncycastle/est/ESTResponse:getContentLength	()Ljava/lang/Long;
    //   234: ifnull +58 -> 292
    //   237: aload 5
    //   239: invokevirtual 303	org/bouncycastle/est/ESTResponse:getContentLength	()Ljava/lang/Long;
    //   242: invokevirtual 309	java/lang/Long:longValue	()J
    //   245: lconst_0
    //   246: lcmp
    //   247: ifle +45 -> 292
    //   250: new 311	org/bouncycastle/cmc/SimplePKIResponse
    //   253: dup
    //   254: new 313	org/bouncycastle/asn1/ASN1InputStream
    //   257: dup
    //   258: aload 5
    //   260: invokevirtual 296	org/bouncycastle/est/ESTResponse:getInputStream	()Ljava/io/InputStream;
    //   263: invokespecial 316	org/bouncycastle/asn1/ASN1InputStream:<init>	(Ljava/io/InputStream;)V
    //   266: invokevirtual 320	org/bouncycastle/asn1/ASN1InputStream:readObject	()Lorg/bouncycastle/asn1/ASN1Primitive;
    //   269: checkcast 322	org/bouncycastle/asn1/ASN1Sequence
    //   272: invokestatic 328	org/bouncycastle/asn1/cms/ContentInfo:getInstance	(Ljava/lang/Object;)Lorg/bouncycastle/asn1/cms/ContentInfo;
    //   275: invokespecial 331	org/bouncycastle/cmc/SimplePKIResponse:<init>	(Lorg/bouncycastle/asn1/cms/ContentInfo;)V
    //   278: astore_2
    //   279: aload_2
    //   280: invokevirtual 335	org/bouncycastle/cmc/SimplePKIResponse:getCertificates	()Lorg/bouncycastle/util/Store;
    //   283: astore_3
    //   284: aload_2
    //   285: invokevirtual 338	org/bouncycastle/cmc/SimplePKIResponse:getCRLs	()Lorg/bouncycastle/util/Store;
    //   288: astore_2
    //   289: goto +7 -> 296
    //   292: aconst_null
    //   293: astore_3
    //   294: aload_3
    //   295: astore_2
    //   296: aload_2
    //   297: astore 4
    //   299: goto +88 -> 387
    //   302: astore_2
    //   303: new 82	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   310: astore_3
    //   311: aload_3
    //   312: ldc_w 340
    //   315: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload_3
    //   320: aload 6
    //   322: invokevirtual 288	java/net/URL:toString	()Ljava/lang/String;
    //   325: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: aload_3
    //   330: ldc_w 342
    //   333: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: pop
    //   337: aload_3
    //   338: aload_2
    //   339: invokevirtual 345	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   342: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: new 292	org/bouncycastle/est/ESTException
    //   349: dup
    //   350: aload_3
    //   351: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: aload_2
    //   355: aload 5
    //   357: invokevirtual 270	org/bouncycastle/est/ESTResponse:getStatusCode	()I
    //   360: aload 5
    //   362: invokevirtual 296	org/bouncycastle/est/ESTResponse:getInputStream	()Ljava/io/InputStream;
    //   365: invokespecial 299	org/bouncycastle/est/ESTException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;ILjava/io/InputStream;)V
    //   368: athrow
    //   369: aload 5
    //   371: invokevirtual 270	org/bouncycastle/est/ESTResponse:getStatusCode	()I
    //   374: sipush 204
    //   377: if_icmpne +116 -> 493
    //   380: aconst_null
    //   381: astore_2
    //   382: aload_2
    //   383: astore 4
    //   385: aload_2
    //   386: astore_3
    //   387: new 347	org/bouncycastle/est/CACertsResponse
    //   390: dup
    //   391: aload_3
    //   392: aload 4
    //   394: aload 7
    //   396: aload 5
    //   398: invokevirtual 351	org/bouncycastle/est/ESTResponse:getSource	()Lorg/bouncycastle/est/Source;
    //   401: aload_0
    //   402: getfield 101	org/bouncycastle/est/ESTService:clientProvider	Lorg/bouncycastle/est/ESTClientProvider;
    //   405: invokeinterface 354 1 0
    //   410: invokespecial 357	org/bouncycastle/est/CACertsResponse:<init>	(Lorg/bouncycastle/util/Store;Lorg/bouncycastle/util/Store;Lorg/bouncycastle/est/ESTRequest;Lorg/bouncycastle/est/Source;Z)V
    //   413: astore_3
    //   414: aload 5
    //   416: ifnull +15 -> 431
    //   419: aload 5
    //   421: invokevirtual 360	org/bouncycastle/est/ESTResponse:close	()V
    //   424: goto +7 -> 431
    //   427: astore_2
    //   428: goto +5 -> 433
    //   431: aconst_null
    //   432: astore_2
    //   433: aload_2
    //   434: ifnull +57 -> 491
    //   437: aload_2
    //   438: instanceof 292
    //   441: ifeq +5 -> 446
    //   444: aload_2
    //   445: athrow
    //   446: new 82	java/lang/StringBuilder
    //   449: dup
    //   450: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   453: astore_3
    //   454: aload_3
    //   455: ldc_w 362
    //   458: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: pop
    //   462: aload_3
    //   463: aload 6
    //   465: invokevirtual 288	java/net/URL:toString	()Ljava/lang/String;
    //   468: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: pop
    //   472: new 292	org/bouncycastle/est/ESTException
    //   475: dup
    //   476: aload_3
    //   477: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   480: aload_2
    //   481: aload 5
    //   483: invokevirtual 270	org/bouncycastle/est/ESTResponse:getStatusCode	()I
    //   486: aconst_null
    //   487: invokespecial 299	org/bouncycastle/est/ESTException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;ILjava/io/InputStream;)V
    //   490: athrow
    //   491: aload_3
    //   492: areturn
    //   493: new 82	java/lang/StringBuilder
    //   496: dup
    //   497: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   500: astore_2
    //   501: aload_2
    //   502: ldc_w 362
    //   505: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: pop
    //   509: aload_2
    //   510: aload 6
    //   512: invokevirtual 288	java/net/URL:toString	()Ljava/lang/String;
    //   515: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: pop
    //   519: new 292	org/bouncycastle/est/ESTException
    //   522: dup
    //   523: aload_2
    //   524: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   527: aconst_null
    //   528: aload 5
    //   530: invokevirtual 270	org/bouncycastle/est/ESTResponse:getStatusCode	()I
    //   533: aload 5
    //   535: invokevirtual 296	org/bouncycastle/est/ESTResponse:getInputStream	()Ljava/io/InputStream;
    //   538: invokespecial 299	org/bouncycastle/est/ESTException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;ILjava/io/InputStream;)V
    //   541: athrow
    //   542: astore_3
    //   543: aload 5
    //   545: astore_2
    //   546: goto +4 -> 550
    //   549: astore_3
    //   550: aload_3
    //   551: instanceof 292
    //   554: ifeq +8 -> 562
    //   557: aload_3
    //   558: checkcast 292	org/bouncycastle/est/ESTException
    //   561: athrow
    //   562: new 292	org/bouncycastle/est/ESTException
    //   565: dup
    //   566: aload_3
    //   567: invokevirtual 345	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   570: aload_3
    //   571: invokespecial 363	org/bouncycastle/est/ESTException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   574: athrow
    //   575: astore_3
    //   576: aload_2
    //   577: ifnull +7 -> 584
    //   580: aload_2
    //   581: invokevirtual 360	org/bouncycastle/est/ESTResponse:close	()V
    //   584: aload_3
    //   585: athrow
    //   586: astore_2
    //   587: goto -3 -> 584
    //   590: ldc_w 365
    //   593: astore_2
    //   594: goto -428 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	597	0	this	ESTService
    //   84	6	1	i	int
    //   1	296	2	localObject1	Object
    //   302	53	2	localThrowable1	Throwable
    //   381	5	2	localObject2	Object
    //   427	1	2	localException1	Exception
    //   432	149	2	localObject3	Object
    //   586	1	2	localException2	Exception
    //   593	1	2	str	String
    //   9	483	3	localObject4	Object
    //   542	1	3	localObject5	Object
    //   549	22	3	localThrowable2	Throwable
    //   575	10	3	localObject6	Object
    //   297	96	4	localObject7	Object
    //   77	467	5	localESTResponse	ESTResponse
    //   37	474	6	localURL	URL
    //   67	328	7	localESTRequest	ESTRequest
    // Exception table:
    //   from	to	target	type
    //   229	289	302	finally
    //   419	424	427	java/lang/Exception
    //   79	85	542	finally
    //   92	163	542	finally
    //   166	229	542	finally
    //   303	369	542	finally
    //   369	380	542	finally
    //   387	414	542	finally
    //   493	542	542	finally
    //   2	79	549	finally
    //   550	562	575	finally
    //   562	575	575	finally
    //   580	584	586	java/lang/Exception
  }
  
  /* Error */
  public CSRRequestResponse getCSRAttributes()
    throws ESTException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 101	org/bouncycastle/est/ESTService:clientProvider	Lorg/bouncycastle/est/ESTClientProvider;
    //   4: invokeinterface 354 1 0
    //   9: ifeq +401 -> 410
    //   12: new 82	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   19: astore_2
    //   20: aload_2
    //   21: aload_0
    //   22: getfield 99	org/bouncycastle/est/ESTService:server	Ljava/lang/String;
    //   25: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload_2
    //   30: ldc 13
    //   32: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: new 217	java/net/URL
    //   39: dup
    //   40: aload_2
    //   41: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokespecial 218	java/net/URL:<init>	(Ljava/lang/String;)V
    //   47: astore_3
    //   48: aload_0
    //   49: getfield 101	org/bouncycastle/est/ESTService:clientProvider	Lorg/bouncycastle/est/ESTClientProvider;
    //   52: invokeinterface 244 1 0
    //   57: astore 4
    //   59: new 246	org/bouncycastle/est/ESTRequestBuilder
    //   62: dup
    //   63: ldc -8
    //   65: aload_3
    //   66: invokespecial 251	org/bouncycastle/est/ESTRequestBuilder:<init>	(Ljava/lang/String;Ljava/net/URL;)V
    //   69: aload 4
    //   71: invokevirtual 255	org/bouncycastle/est/ESTRequestBuilder:withClient	(Lorg/bouncycastle/est/ESTClient;)Lorg/bouncycastle/est/ESTRequestBuilder;
    //   74: invokevirtual 259	org/bouncycastle/est/ESTRequestBuilder:build	()Lorg/bouncycastle/est/ESTRequest;
    //   77: astore_2
    //   78: aload 4
    //   80: aload_2
    //   81: invokeinterface 265 2 0
    //   86: astore 4
    //   88: aload 4
    //   90: invokevirtual 270	org/bouncycastle/est/ESTResponse:getStatusCode	()I
    //   93: istore_1
    //   94: iload_1
    //   95: sipush 200
    //   98: if_icmpeq +76 -> 174
    //   101: iload_1
    //   102: sipush 204
    //   105: if_icmpeq +64 -> 169
    //   108: iload_1
    //   109: sipush 404
    //   112: if_icmpne +6 -> 118
    //   115: goto +54 -> 169
    //   118: new 82	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   125: astore_3
    //   126: aload_3
    //   127: ldc_w 370
    //   130: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload_3
    //   135: aload_2
    //   136: invokevirtual 376	org/bouncycastle/est/ESTRequest:getURL	()Ljava/net/URL;
    //   139: invokevirtual 288	java/net/URL:toString	()Ljava/lang/String;
    //   142: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: new 292	org/bouncycastle/est/ESTException
    //   149: dup
    //   150: aload_3
    //   151: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: aconst_null
    //   155: aload 4
    //   157: invokevirtual 270	org/bouncycastle/est/ESTResponse:getStatusCode	()I
    //   160: aload 4
    //   162: invokevirtual 296	org/bouncycastle/est/ESTResponse:getInputStream	()Ljava/io/InputStream;
    //   165: invokespecial 299	org/bouncycastle/est/ESTException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;ILjava/io/InputStream;)V
    //   168: athrow
    //   169: aconst_null
    //   170: astore_2
    //   171: goto +53 -> 224
    //   174: aload 4
    //   176: invokevirtual 303	org/bouncycastle/est/ESTResponse:getContentLength	()Ljava/lang/Long;
    //   179: ifnull -10 -> 169
    //   182: aload 4
    //   184: invokevirtual 303	org/bouncycastle/est/ESTResponse:getContentLength	()Ljava/lang/Long;
    //   187: invokevirtual 309	java/lang/Long:longValue	()J
    //   190: lconst_0
    //   191: lcmp
    //   192: ifle -23 -> 169
    //   195: new 378	org/bouncycastle/est/CSRAttributesResponse
    //   198: dup
    //   199: new 313	org/bouncycastle/asn1/ASN1InputStream
    //   202: dup
    //   203: aload 4
    //   205: invokevirtual 296	org/bouncycastle/est/ESTResponse:getInputStream	()Ljava/io/InputStream;
    //   208: invokespecial 316	org/bouncycastle/asn1/ASN1InputStream:<init>	(Ljava/io/InputStream;)V
    //   211: invokevirtual 320	org/bouncycastle/asn1/ASN1InputStream:readObject	()Lorg/bouncycastle/asn1/ASN1Primitive;
    //   214: checkcast 322	org/bouncycastle/asn1/ASN1Sequence
    //   217: invokestatic 383	org/bouncycastle/asn1/est/CsrAttrs:getInstance	(Ljava/lang/Object;)Lorg/bouncycastle/asn1/est/CsrAttrs;
    //   220: invokespecial 386	org/bouncycastle/est/CSRAttributesResponse:<init>	(Lorg/bouncycastle/asn1/est/CsrAttrs;)V
    //   223: astore_2
    //   224: aload 4
    //   226: ifnull +15 -> 241
    //   229: aload 4
    //   231: invokevirtual 360	org/bouncycastle/est/ESTResponse:close	()V
    //   234: goto +7 -> 241
    //   237: astore_3
    //   238: goto +5 -> 243
    //   241: aconst_null
    //   242: astore_3
    //   243: aload_3
    //   244: ifnull +34 -> 278
    //   247: aload_3
    //   248: instanceof 292
    //   251: ifeq +8 -> 259
    //   254: aload_3
    //   255: checkcast 292	org/bouncycastle/est/ESTException
    //   258: athrow
    //   259: new 292	org/bouncycastle/est/ESTException
    //   262: dup
    //   263: aload_3
    //   264: invokevirtual 233	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   267: aload_3
    //   268: aload 4
    //   270: invokevirtual 270	org/bouncycastle/est/ESTResponse:getStatusCode	()I
    //   273: aconst_null
    //   274: invokespecial 299	org/bouncycastle/est/ESTException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;ILjava/io/InputStream;)V
    //   277: athrow
    //   278: new 388	org/bouncycastle/est/CSRRequestResponse
    //   281: dup
    //   282: aload_2
    //   283: aload 4
    //   285: invokevirtual 351	org/bouncycastle/est/ESTResponse:getSource	()Lorg/bouncycastle/est/Source;
    //   288: invokespecial 391	org/bouncycastle/est/CSRRequestResponse:<init>	(Lorg/bouncycastle/est/CSRAttributesResponse;Lorg/bouncycastle/est/Source;)V
    //   291: areturn
    //   292: astore_2
    //   293: new 82	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   300: astore 5
    //   302: aload 5
    //   304: ldc_w 340
    //   307: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload 5
    //   313: aload_3
    //   314: invokevirtual 288	java/net/URL:toString	()Ljava/lang/String;
    //   317: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: aload 5
    //   323: ldc_w 342
    //   326: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: aload 5
    //   332: aload_2
    //   333: invokevirtual 345	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   336: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: new 292	org/bouncycastle/est/ESTException
    //   343: dup
    //   344: aload 5
    //   346: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: aload_2
    //   350: aload 4
    //   352: invokevirtual 270	org/bouncycastle/est/ESTResponse:getStatusCode	()I
    //   355: aload 4
    //   357: invokevirtual 296	org/bouncycastle/est/ESTResponse:getInputStream	()Ljava/io/InputStream;
    //   360: invokespecial 299	org/bouncycastle/est/ESTException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;ILjava/io/InputStream;)V
    //   363: athrow
    //   364: astore_3
    //   365: aload 4
    //   367: astore_2
    //   368: goto +6 -> 374
    //   371: astore_3
    //   372: aconst_null
    //   373: astore_2
    //   374: aload_3
    //   375: instanceof 292
    //   378: ifeq +8 -> 386
    //   381: aload_3
    //   382: checkcast 292	org/bouncycastle/est/ESTException
    //   385: athrow
    //   386: new 292	org/bouncycastle/est/ESTException
    //   389: dup
    //   390: aload_3
    //   391: invokevirtual 345	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   394: aload_3
    //   395: invokespecial 363	org/bouncycastle/est/ESTException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   398: athrow
    //   399: astore_3
    //   400: aload_2
    //   401: ifnull +7 -> 408
    //   404: aload_2
    //   405: invokevirtual 360	org/bouncycastle/est/ESTResponse:close	()V
    //   408: aload_3
    //   409: athrow
    //   410: new 393	java/lang/IllegalStateException
    //   413: dup
    //   414: ldc_w 395
    //   417: invokespecial 396	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   420: athrow
    //   421: astore_2
    //   422: goto -14 -> 408
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	425	0	this	ESTService
    //   93	20	1	i	int
    //   19	264	2	localObject1	Object
    //   292	58	2	localThrowable1	Throwable
    //   367	38	2	localObject2	Object
    //   421	1	2	localException1	Exception
    //   47	104	3	localObject3	Object
    //   237	1	3	localException2	Exception
    //   242	72	3	localThrowable2	Throwable
    //   364	1	3	localObject4	Object
    //   371	24	3	localThrowable3	Throwable
    //   399	10	3	localObject5	Object
    //   57	309	4	localObject6	Object
    //   300	45	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   229	234	237	java/lang/Exception
    //   174	224	292	finally
    //   88	94	364	finally
    //   118	169	364	finally
    //   293	364	364	finally
    //   12	88	371	finally
    //   374	386	399	finally
    //   386	399	399	finally
    //   404	408	421	java/lang/Exception
  }
  
  protected EnrollmentResponse handleEnrollResponse(ESTResponse paramESTResponse)
    throws IOException
  {
    Object localObject1 = paramESTResponse.getOriginalRequest();
    if (paramESTResponse.getStatusCode() == 202)
    {
      String str = paramESTResponse.getHeader("Retry-After");
      if (str != null) {
        for (;;)
        {
          try
          {
            l1 = System.currentTimeMillis();
            long l2 = Long.parseLong(str);
            l1 += l2 * 1000L;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            long l1;
            Object localObject2;
            StringBuilder localStringBuilder;
            continue;
          }
          try
          {
            localObject2 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
            ((SimpleDateFormat)localObject2).setTimeZone(TimeZone.getTimeZone("GMT"));
            l1 = ((SimpleDateFormat)localObject2).parse(str).getTime();
            return new EnrollmentResponse(null, l1, (ESTRequest)localObject1, paramESTResponse.getSource());
          }
          catch (Exception localException)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("Unable to parse Retry-After header:");
            ((StringBuilder)localObject2).append(((ESTRequest)localObject1).getURL().toString());
            ((StringBuilder)localObject2).append(" ");
            ((StringBuilder)localObject2).append(localException.getMessage());
            throw new ESTException(((StringBuilder)localObject2).toString(), null, paramESTResponse.getStatusCode(), paramESTResponse.getInputStream());
          }
        }
      }
      paramESTResponse = new StringBuilder();
      paramESTResponse.append("Got Status 202 but not Retry-After header from: ");
      paramESTResponse.append(((ESTRequest)localObject1).getURL().toString());
      throw new ESTException(paramESTResponse.toString());
    }
    if (paramESTResponse.getStatusCode() == 200)
    {
      localObject1 = new ASN1InputStream(paramESTResponse.getInputStream());
      try
      {
        localObject1 = new SimplePKIResponse(ContentInfo.getInstance(((ASN1InputStream)localObject1).readObject()));
        return new EnrollmentResponse(((SimplePKIResponse)localObject1).getCertificates(), -1L, null, paramESTResponse.getSource());
      }
      catch (CMCException paramESTResponse)
      {
        throw new ESTException(paramESTResponse.getMessage(), paramESTResponse.getCause());
      }
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Simple Enroll: ");
    localStringBuilder.append(((ESTRequest)localObject1).getURL().toString());
    throw new ESTException(localStringBuilder.toString(), null, paramESTResponse.getStatusCode(), paramESTResponse.getInputStream());
  }
  
  public EnrollmentResponse simpleEnroll(EnrollmentResponse paramEnrollmentResponse)
    throws Exception
  {
    EnrollmentResponse localEnrollmentResponse1;
    if (this.clientProvider.isTrusted())
    {
      EnrollmentResponse localEnrollmentResponse2 = null;
      localEnrollmentResponse1 = localEnrollmentResponse2;
      try
      {
        ESTClient localESTClient = this.clientProvider.makeClient();
        localEnrollmentResponse1 = localEnrollmentResponse2;
        paramEnrollmentResponse = localESTClient.doRequest(new ESTRequestBuilder(paramEnrollmentResponse.getRequestToRetry()).withClient(localESTClient).build());
        localEnrollmentResponse1 = paramEnrollmentResponse;
        localEnrollmentResponse2 = handleEnrollResponse(paramEnrollmentResponse);
        if (paramEnrollmentResponse != null) {
          paramEnrollmentResponse.close();
        }
        return localEnrollmentResponse2;
      }
      finally {}
    }
    try
    {
      if ((paramEnrollmentResponse instanceof ESTException)) {
        throw ((ESTException)paramEnrollmentResponse);
      }
      throw new ESTException(paramEnrollmentResponse.getMessage(), paramEnrollmentResponse);
    }
    finally
    {
      if (localEnrollmentResponse1 != null) {
        localEnrollmentResponse1.close();
      }
    }
  }
  
  public EnrollmentResponse simpleEnroll(boolean paramBoolean, PKCS10CertificationRequest paramPKCS10CertificationRequest, ESTAuth paramESTAuth)
    throws IOException
  {
    Object localObject1;
    if (this.clientProvider.isTrusted())
    {
      Object localObject2 = null;
      localObject1 = localObject2;
      try
      {
        byte[] arrayOfByte = annotateRequest(paramPKCS10CertificationRequest.getEncoded()).getBytes();
        localObject1 = localObject2;
        Object localObject3 = new StringBuilder();
        localObject1 = localObject2;
        ((StringBuilder)localObject3).append(this.server);
        if (paramBoolean)
        {
          paramPKCS10CertificationRequest = "/simplereenroll";
          localObject1 = localObject2;
          ((StringBuilder)localObject3).append(paramPKCS10CertificationRequest);
          localObject1 = localObject2;
          localObject3 = new URL(((StringBuilder)localObject3).toString());
          localObject1 = localObject2;
          paramPKCS10CertificationRequest = this.clientProvider.makeClient();
          localObject1 = localObject2;
          localObject3 = new ESTRequestBuilder("POST", (URL)localObject3).withData(arrayOfByte).withClient(paramPKCS10CertificationRequest);
          localObject1 = localObject2;
          ((ESTRequestBuilder)localObject3).addHeader("Content-Type", "application/pkcs10");
          localObject1 = localObject2;
          StringBuilder localStringBuilder = new StringBuilder();
          localObject1 = localObject2;
          localStringBuilder.append("");
          localObject1 = localObject2;
          localStringBuilder.append(arrayOfByte.length);
          localObject1 = localObject2;
          ((ESTRequestBuilder)localObject3).addHeader("Content-Length", localStringBuilder.toString());
          localObject1 = localObject2;
          ((ESTRequestBuilder)localObject3).addHeader("Content-Transfer-Encoding", "base64");
          if (paramESTAuth != null)
          {
            localObject1 = localObject2;
            paramESTAuth.applyAuth((ESTRequestBuilder)localObject3);
          }
          localObject1 = localObject2;
          paramPKCS10CertificationRequest = paramPKCS10CertificationRequest.doRequest(((ESTRequestBuilder)localObject3).build());
          localObject1 = paramPKCS10CertificationRequest;
          paramESTAuth = handleEnrollResponse(paramPKCS10CertificationRequest);
          if (paramPKCS10CertificationRequest != null) {
            paramPKCS10CertificationRequest.close();
          }
          return paramESTAuth;
        }
      }
      finally {}
    }
    try
    {
      if ((paramPKCS10CertificationRequest instanceof ESTException)) {
        throw ((ESTException)paramPKCS10CertificationRequest);
      }
      throw new ESTException(paramPKCS10CertificationRequest.getMessage(), paramPKCS10CertificationRequest);
    }
    finally
    {
      if (localObject1 != null) {
        ((ESTResponse)localObject1).close();
      }
      throw paramPKCS10CertificationRequest;
      throw new IllegalStateException("No trust anchors.");
    }
  }
  
  public EnrollmentResponse simpleEnrollPoP(boolean paramBoolean, final PKCS10CertificationRequestBuilder paramPKCS10CertificationRequestBuilder, final ContentSigner paramContentSigner, ESTAuth paramESTAuth)
    throws IOException
  {
    Object localObject1;
    Object localObject2;
    if (this.clientProvider.isTrusted())
    {
      Object localObject3 = null;
      localObject1 = localObject3;
      try
      {
        Object localObject4 = new StringBuilder();
        localObject1 = localObject3;
        ((StringBuilder)localObject4).append(this.server);
        if (paramBoolean)
        {
          localObject2 = "/simplereenroll";
          localObject1 = localObject3;
          ((StringBuilder)localObject4).append((String)localObject2);
          localObject1 = localObject3;
          localObject4 = new URL(((StringBuilder)localObject4).toString());
          localObject1 = localObject3;
          localObject2 = this.clientProvider.makeClient();
          localObject1 = localObject3;
          paramPKCS10CertificationRequestBuilder = new ESTRequestBuilder("POST", (URL)localObject4).withClient((ESTClient)localObject2).withConnectionListener(new ESTSourceConnectionListener()
          {
            public ESTRequest onConnection(Source paramAnonymousSource, ESTRequest paramAnonymousESTRequest)
              throws IOException
            {
              if ((paramAnonymousSource instanceof TLSUniqueProvider))
              {
                Object localObject = (TLSUniqueProvider)paramAnonymousSource;
                if (((TLSUniqueProvider)localObject).isTLSUniqueAvailable())
                {
                  PKCS10CertificationRequestBuilder localPKCS10CertificationRequestBuilder = new PKCS10CertificationRequestBuilder(paramPKCS10CertificationRequestBuilder);
                  paramAnonymousSource = new ByteArrayOutputStream();
                  localObject = ((TLSUniqueProvider)localObject).getTLSUnique();
                  localPKCS10CertificationRequestBuilder.setAttribute(PKCSObjectIdentifiers.pkcs_9_at_challengePassword, new DERPrintableString(Base64.toBase64String((byte[])localObject)));
                  paramAnonymousSource.write(ESTService.this.annotateRequest(localPKCS10CertificationRequestBuilder.build(paramContentSigner).getEncoded()).getBytes());
                  paramAnonymousSource.flush();
                  paramAnonymousESTRequest = new ESTRequestBuilder(paramAnonymousESTRequest).withData(paramAnonymousSource.toByteArray());
                  paramAnonymousESTRequest.setHeader("Content-Type", "application/pkcs10");
                  paramAnonymousESTRequest.setHeader("Content-Transfer-Encoding", "base64");
                  paramAnonymousESTRequest.setHeader("Content-Length", Long.toString(paramAnonymousSource.size()));
                  return paramAnonymousESTRequest.build();
                }
              }
              throw new IOException("Source does not supply TLS unique.");
            }
          });
          if (paramESTAuth != null)
          {
            localObject1 = localObject3;
            paramESTAuth.applyAuth(paramPKCS10CertificationRequestBuilder);
          }
          localObject1 = localObject3;
          paramPKCS10CertificationRequestBuilder = ((ESTClient)localObject2).doRequest(paramPKCS10CertificationRequestBuilder.build());
          localObject1 = paramPKCS10CertificationRequestBuilder;
          paramContentSigner = handleEnrollResponse(paramPKCS10CertificationRequestBuilder);
          if (paramPKCS10CertificationRequestBuilder != null) {
            paramPKCS10CertificationRequestBuilder.close();
          }
          return paramContentSigner;
        }
      }
      finally {}
    }
    try
    {
      if ((paramPKCS10CertificationRequestBuilder instanceof ESTException)) {
        throw ((ESTException)paramPKCS10CertificationRequestBuilder);
      }
      throw new ESTException(paramPKCS10CertificationRequestBuilder.getMessage(), paramPKCS10CertificationRequestBuilder);
    }
    finally
    {
      if (localObject1 != null) {
        ((ESTResponse)localObject1).close();
      }
      throw paramPKCS10CertificationRequestBuilder;
      throw new IllegalStateException("No trust anchors.");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\est\ESTService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */