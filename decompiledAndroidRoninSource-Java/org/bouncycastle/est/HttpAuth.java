package org.bouncycastle.est;

import java.io.IOException;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.operator.DefaultDigestAlgorithmIdentifierFinder;
import org.bouncycastle.operator.DigestAlgorithmIdentifierFinder;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Base64;
import org.bouncycastle.util.encoders.Hex;

public class HttpAuth
  implements ESTAuth
{
  private static final DigestAlgorithmIdentifierFinder digestAlgorithmIdentifierFinder = new DefaultDigestAlgorithmIdentifierFinder();
  private static final Set<String> validParts;
  private final DigestCalculatorProvider digestCalculatorProvider;
  private final SecureRandom nonceGenerator;
  private final char[] password;
  private final String realm;
  private final String username;
  
  static
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("realm");
    localHashSet.add("nonce");
    localHashSet.add("opaque");
    localHashSet.add("algorithm");
    localHashSet.add("qop");
    validParts = Collections.unmodifiableSet(localHashSet);
  }
  
  public HttpAuth(String paramString1, String paramString2, char[] paramArrayOfChar)
  {
    this(paramString1, paramString2, paramArrayOfChar, null, null);
  }
  
  public HttpAuth(String paramString1, String paramString2, char[] paramArrayOfChar, SecureRandom paramSecureRandom, DigestCalculatorProvider paramDigestCalculatorProvider)
  {
    this.realm = paramString1;
    this.username = paramString2;
    this.password = paramArrayOfChar;
    this.nonceGenerator = paramSecureRandom;
    this.digestCalculatorProvider = paramDigestCalculatorProvider;
  }
  
  public HttpAuth(String paramString, char[] paramArrayOfChar)
  {
    this(null, paramString, paramArrayOfChar, null, null);
  }
  
  public HttpAuth(String paramString, char[] paramArrayOfChar, SecureRandom paramSecureRandom, DigestCalculatorProvider paramDigestCalculatorProvider)
  {
    this(null, paramString, paramArrayOfChar, paramSecureRandom, paramDigestCalculatorProvider);
  }
  
  /* Error */
  private ESTResponse doDigestFunction(ESTResponse paramESTResponse)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 94	org/bouncycastle/est/ESTResponse:close	()V
    //   4: aload_1
    //   5: invokevirtual 98	org/bouncycastle/est/ESTResponse:getOriginalRequest	()Lorg/bouncycastle/est/ESTRequest;
    //   8: astore 7
    //   10: ldc 100
    //   12: aload_1
    //   13: ldc 102
    //   15: invokevirtual 106	org/bouncycastle/est/ESTResponse:getHeader	(Ljava/lang/String;)Ljava/lang/String;
    //   18: invokestatic 112	org/bouncycastle/est/HttpUtil:splitCSL	(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
    //   21: astore 12
    //   23: aload 7
    //   25: invokevirtual 118	org/bouncycastle/est/ESTRequest:getURL	()Ljava/net/URL;
    //   28: invokevirtual 124	java/net/URL:toURI	()Ljava/net/URI;
    //   31: invokevirtual 130	java/net/URI:getPath	()Ljava/lang/String;
    //   34: astore 8
    //   36: aload 12
    //   38: invokeinterface 136 1 0
    //   43: invokeinterface 142 1 0
    //   48: astore 4
    //   50: aload 4
    //   52: invokeinterface 148 1 0
    //   57: ifeq +71 -> 128
    //   60: aload 4
    //   62: invokeinterface 152 1 0
    //   67: astore_1
    //   68: getstatic 55	org/bouncycastle/est/HttpAuth:validParts	Ljava/util/Set;
    //   71: aload_1
    //   72: invokeinterface 155 2 0
    //   77: ifeq +6 -> 83
    //   80: goto -30 -> 50
    //   83: new 157	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   90: astore 4
    //   92: aload 4
    //   94: ldc -96
    //   96: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload 4
    //   102: aload_1
    //   103: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload 4
    //   109: ldc -87
    //   111: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: new 171	org/bouncycastle/est/ESTException
    //   118: dup
    //   119: aload 4
    //   121: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokespecial 177	org/bouncycastle/est/ESTException:<init>	(Ljava/lang/String;)V
    //   127: athrow
    //   128: aload 7
    //   130: invokevirtual 180	org/bouncycastle/est/ESTRequest:getMethod	()Ljava/lang/String;
    //   133: astore 14
    //   135: aload 12
    //   137: ldc 35
    //   139: invokeinterface 184 2 0
    //   144: checkcast 186	java/lang/String
    //   147: astore 9
    //   149: aload 12
    //   151: ldc 41
    //   153: invokeinterface 184 2 0
    //   158: checkcast 186	java/lang/String
    //   161: astore 10
    //   163: aload 12
    //   165: ldc 43
    //   167: invokeinterface 184 2 0
    //   172: checkcast 186	java/lang/String
    //   175: astore 11
    //   177: ldc 45
    //   179: astore 4
    //   181: aload 12
    //   183: ldc 45
    //   185: invokeinterface 184 2 0
    //   190: checkcast 186	java/lang/String
    //   193: astore 6
    //   195: ldc 47
    //   197: astore 5
    //   199: aload 12
    //   201: ldc 47
    //   203: invokeinterface 184 2 0
    //   208: checkcast 186	java/lang/String
    //   211: astore 15
    //   213: new 188	java/util/ArrayList
    //   216: dup
    //   217: invokespecial 189	java/util/ArrayList:<init>	()V
    //   220: astore 12
    //   222: aload_0
    //   223: getfield 63	org/bouncycastle/est/HttpAuth:realm	Ljava/lang/String;
    //   226: astore_1
    //   227: aload_1
    //   228: ifnull +77 -> 305
    //   231: aload_1
    //   232: aload 9
    //   234: invokevirtual 192	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   237: ifeq +6 -> 243
    //   240: goto +65 -> 305
    //   243: new 157	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   250: astore_1
    //   251: aload_1
    //   252: ldc -62
    //   254: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload_1
    //   259: aload_0
    //   260: getfield 63	org/bouncycastle/est/HttpAuth:realm	Ljava/lang/String;
    //   263: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload_1
    //   268: ldc -60
    //   270: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload_1
    //   275: aload 9
    //   277: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload_1
    //   282: ldc -87
    //   284: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: new 171	org/bouncycastle/est/ESTException
    //   291: dup
    //   292: aload_1
    //   293: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: aconst_null
    //   297: sipush 401
    //   300: aconst_null
    //   301: invokespecial 199	org/bouncycastle/est/ESTException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;ILjava/io/InputStream;)V
    //   304: athrow
    //   305: aload 6
    //   307: astore_1
    //   308: aload 6
    //   310: ifnonnull +6 -> 316
    //   313: ldc -55
    //   315: astore_1
    //   316: aload_1
    //   317: invokevirtual 205	java/lang/String:length	()I
    //   320: ifeq +1056 -> 1376
    //   323: aload_1
    //   324: invokestatic 210	org/bouncycastle/util/Strings:toUpperCase	(Ljava/lang/String;)Ljava/lang/String;
    //   327: astore 13
    //   329: aload 15
    //   331: ifnull +1034 -> 1365
    //   334: aload 15
    //   336: invokevirtual 205	java/lang/String:length	()I
    //   339: ifeq +1015 -> 1354
    //   342: aload 15
    //   344: invokestatic 213	org/bouncycastle/util/Strings:toLowerCase	(Ljava/lang/String;)Ljava/lang/String;
    //   347: ldc -41
    //   349: invokevirtual 219	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   352: astore 6
    //   354: iconst_0
    //   355: istore_2
    //   356: aload 5
    //   358: astore_1
    //   359: iload_2
    //   360: aload 6
    //   362: arraylength
    //   363: if_icmpeq +111 -> 474
    //   366: aload 6
    //   368: iload_2
    //   369: aaload
    //   370: ldc -35
    //   372: invokevirtual 192	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   375: ifne +58 -> 433
    //   378: aload 6
    //   380: iload_2
    //   381: aaload
    //   382: ldc -33
    //   384: invokevirtual 192	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   387: ifeq +6 -> 393
    //   390: goto +43 -> 433
    //   393: new 157	java/lang/StringBuilder
    //   396: dup
    //   397: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   400: astore_1
    //   401: aload_1
    //   402: ldc -31
    //   404: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: pop
    //   408: aload_1
    //   409: iload_2
    //   410: invokevirtual 228	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   413: pop
    //   414: aload_1
    //   415: ldc -87
    //   417: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: pop
    //   421: new 171	org/bouncycastle/est/ESTException
    //   424: dup
    //   425: aload_1
    //   426: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   429: invokespecial 177	org/bouncycastle/est/ESTException:<init>	(Ljava/lang/String;)V
    //   432: athrow
    //   433: aload 6
    //   435: iload_2
    //   436: aaload
    //   437: invokevirtual 231	java/lang/String:trim	()Ljava/lang/String;
    //   440: astore 5
    //   442: aload 12
    //   444: aload 5
    //   446: invokeinterface 234 2 0
    //   451: ifeq +6 -> 457
    //   454: goto +13 -> 467
    //   457: aload 12
    //   459: aload 5
    //   461: invokeinterface 235 2 0
    //   466: pop
    //   467: iload_2
    //   468: iconst_1
    //   469: iadd
    //   470: istore_2
    //   471: goto -112 -> 359
    //   474: aload_0
    //   475: aload 13
    //   477: invokespecial 239	org/bouncycastle/est/HttpAuth:lookupDigest	(Ljava/lang/String;)Lorg/bouncycastle/asn1/x509/AlgorithmIdentifier;
    //   480: astore 16
    //   482: aload 16
    //   484: ifnull +835 -> 1319
    //   487: aload 16
    //   489: invokevirtual 245	org/bouncycastle/asn1/x509/AlgorithmIdentifier:getAlgorithm	()Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;
    //   492: ifnull +827 -> 1319
    //   495: aload_0
    //   496: aload 13
    //   498: aload 16
    //   500: invokespecial 249	org/bouncycastle/est/HttpAuth:getDigestCalculator	(Ljava/lang/String;Lorg/bouncycastle/asn1/x509/AlgorithmIdentifier;)Lorg/bouncycastle/operator/DigestCalculator;
    //   503: astore 5
    //   505: aload 5
    //   507: invokeinterface 255 1 0
    //   512: astore 6
    //   514: aload_0
    //   515: bipush 10
    //   517: invokespecial 259	org/bouncycastle/est/HttpAuth:makeNonce	(I)Ljava/lang/String;
    //   520: astore 15
    //   522: aload_0
    //   523: aload 6
    //   525: aload_0
    //   526: getfield 65	org/bouncycastle/est/HttpAuth:username	Ljava/lang/String;
    //   529: invokespecial 263	org/bouncycastle/est/HttpAuth:update	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   532: aload_0
    //   533: aload 6
    //   535: ldc_w 265
    //   538: invokespecial 263	org/bouncycastle/est/HttpAuth:update	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   541: aload_0
    //   542: aload 6
    //   544: aload 9
    //   546: invokespecial 263	org/bouncycastle/est/HttpAuth:update	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   549: aload_0
    //   550: aload 6
    //   552: ldc_w 265
    //   555: invokespecial 263	org/bouncycastle/est/HttpAuth:update	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   558: aload_0
    //   559: aload 6
    //   561: aload_0
    //   562: getfield 67	org/bouncycastle/est/HttpAuth:password	[C
    //   565: invokespecial 268	org/bouncycastle/est/HttpAuth:update	(Ljava/io/OutputStream;[C)V
    //   568: aload 6
    //   570: invokevirtual 271	java/io/OutputStream:close	()V
    //   573: aload 5
    //   575: invokeinterface 275 1 0
    //   580: astore 6
    //   582: aload 6
    //   584: astore 5
    //   586: aload 13
    //   588: ldc_w 277
    //   591: invokevirtual 281	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   594: ifeq +81 -> 675
    //   597: aload_0
    //   598: aload 13
    //   600: aload 16
    //   602: invokespecial 249	org/bouncycastle/est/HttpAuth:getDigestCalculator	(Ljava/lang/String;Lorg/bouncycastle/asn1/x509/AlgorithmIdentifier;)Lorg/bouncycastle/operator/DigestCalculator;
    //   605: astore 5
    //   607: aload 5
    //   609: invokeinterface 255 1 0
    //   614: astore 17
    //   616: aload_0
    //   617: aload 17
    //   619: aload 6
    //   621: invokestatic 287	org/bouncycastle/util/encoders/Hex:toHexString	([B)Ljava/lang/String;
    //   624: invokespecial 263	org/bouncycastle/est/HttpAuth:update	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   627: aload_0
    //   628: aload 17
    //   630: ldc_w 265
    //   633: invokespecial 263	org/bouncycastle/est/HttpAuth:update	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   636: aload_0
    //   637: aload 17
    //   639: aload 10
    //   641: invokespecial 263	org/bouncycastle/est/HttpAuth:update	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   644: aload_0
    //   645: aload 17
    //   647: ldc_w 265
    //   650: invokespecial 263	org/bouncycastle/est/HttpAuth:update	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   653: aload_0
    //   654: aload 17
    //   656: aload 15
    //   658: invokespecial 263	org/bouncycastle/est/HttpAuth:update	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   661: aload 17
    //   663: invokevirtual 271	java/io/OutputStream:close	()V
    //   666: aload 5
    //   668: invokeinterface 275 1 0
    //   673: astore 5
    //   675: aload 5
    //   677: invokestatic 287	org/bouncycastle/util/encoders/Hex:toHexString	([B)Ljava/lang/String;
    //   680: astore 5
    //   682: aload_0
    //   683: aload 13
    //   685: aload 16
    //   687: invokespecial 249	org/bouncycastle/est/HttpAuth:getDigestCalculator	(Ljava/lang/String;Lorg/bouncycastle/asn1/x509/AlgorithmIdentifier;)Lorg/bouncycastle/operator/DigestCalculator;
    //   690: astore 6
    //   692: aload 6
    //   694: invokeinterface 255 1 0
    //   699: astore 17
    //   701: aload 12
    //   703: iconst_0
    //   704: invokeinterface 290 2 0
    //   709: checkcast 186	java/lang/String
    //   712: ldc -33
    //   714: invokevirtual 192	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   717: ifeq +91 -> 808
    //   720: aload_0
    //   721: aload 13
    //   723: aload 16
    //   725: invokespecial 249	org/bouncycastle/est/HttpAuth:getDigestCalculator	(Ljava/lang/String;Lorg/bouncycastle/asn1/x509/AlgorithmIdentifier;)Lorg/bouncycastle/operator/DigestCalculator;
    //   728: astore 18
    //   730: aload 18
    //   732: invokeinterface 255 1 0
    //   737: astore 19
    //   739: aload 7
    //   741: aload 19
    //   743: invokevirtual 294	org/bouncycastle/est/ESTRequest:writeData	(Ljava/io/OutputStream;)V
    //   746: aload 19
    //   748: invokevirtual 271	java/io/OutputStream:close	()V
    //   751: aload 18
    //   753: invokeinterface 275 1 0
    //   758: astore 18
    //   760: aload_0
    //   761: aload 17
    //   763: aload 14
    //   765: invokespecial 263	org/bouncycastle/est/HttpAuth:update	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   768: aload_0
    //   769: aload 17
    //   771: ldc_w 265
    //   774: invokespecial 263	org/bouncycastle/est/HttpAuth:update	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   777: aload_0
    //   778: aload 17
    //   780: aload 8
    //   782: invokespecial 263	org/bouncycastle/est/HttpAuth:update	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   785: aload_0
    //   786: aload 17
    //   788: ldc_w 265
    //   791: invokespecial 263	org/bouncycastle/est/HttpAuth:update	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   794: aload_0
    //   795: aload 17
    //   797: aload 18
    //   799: invokestatic 287	org/bouncycastle/util/encoders/Hex:toHexString	([B)Ljava/lang/String;
    //   802: invokespecial 263	org/bouncycastle/est/HttpAuth:update	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   805: goto +47 -> 852
    //   808: aload 12
    //   810: iconst_0
    //   811: invokeinterface 290 2 0
    //   816: checkcast 186	java/lang/String
    //   819: ldc -35
    //   821: invokevirtual 192	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   824: ifeq +28 -> 852
    //   827: aload_0
    //   828: aload 17
    //   830: aload 14
    //   832: invokespecial 263	org/bouncycastle/est/HttpAuth:update	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   835: aload_0
    //   836: aload 17
    //   838: ldc_w 265
    //   841: invokespecial 263	org/bouncycastle/est/HttpAuth:update	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   844: aload_0
    //   845: aload 17
    //   847: aload 8
    //   849: invokespecial 263	org/bouncycastle/est/HttpAuth:update	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   852: aload 17
    //   854: invokevirtual 271	java/io/OutputStream:close	()V
    //   857: aload 6
    //   859: invokeinterface 275 1 0
    //   864: invokestatic 287	org/bouncycastle/util/encoders/Hex:toHexString	([B)Ljava/lang/String;
    //   867: astore 6
    //   869: aload_0
    //   870: aload 13
    //   872: aload 16
    //   874: invokespecial 249	org/bouncycastle/est/HttpAuth:getDigestCalculator	(Ljava/lang/String;Lorg/bouncycastle/asn1/x509/AlgorithmIdentifier;)Lorg/bouncycastle/operator/DigestCalculator;
    //   877: astore 14
    //   879: aload 14
    //   881: invokeinterface 255 1 0
    //   886: astore 16
    //   888: aload 12
    //   890: ldc_w 296
    //   893: invokeinterface 234 2 0
    //   898: istore_3
    //   899: aload_0
    //   900: aload 16
    //   902: aload 5
    //   904: invokespecial 263	org/bouncycastle/est/HttpAuth:update	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   907: aload_0
    //   908: aload 16
    //   910: ldc_w 265
    //   913: invokespecial 263	org/bouncycastle/est/HttpAuth:update	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   916: aload_0
    //   917: aload 16
    //   919: aload 10
    //   921: invokespecial 263	org/bouncycastle/est/HttpAuth:update	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   924: aload_0
    //   925: aload 16
    //   927: ldc_w 265
    //   930: invokespecial 263	org/bouncycastle/est/HttpAuth:update	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   933: iload_3
    //   934: ifeq +14 -> 948
    //   937: aload_0
    //   938: aload 16
    //   940: aload 6
    //   942: invokespecial 263	org/bouncycastle/est/HttpAuth:update	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   945: goto +101 -> 1046
    //   948: aload_0
    //   949: aload 16
    //   951: ldc_w 298
    //   954: invokespecial 263	org/bouncycastle/est/HttpAuth:update	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   957: aload_0
    //   958: aload 16
    //   960: ldc_w 265
    //   963: invokespecial 263	org/bouncycastle/est/HttpAuth:update	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   966: aload_0
    //   967: aload 16
    //   969: aload 15
    //   971: invokespecial 263	org/bouncycastle/est/HttpAuth:update	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   974: aload_0
    //   975: aload 16
    //   977: ldc_w 265
    //   980: invokespecial 263	org/bouncycastle/est/HttpAuth:update	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   983: aload 12
    //   985: iconst_0
    //   986: invokeinterface 290 2 0
    //   991: checkcast 186	java/lang/String
    //   994: astore 5
    //   996: ldc -33
    //   998: astore 17
    //   1000: aload 5
    //   1002: aload 17
    //   1004: invokevirtual 192	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1007: ifeq +14 -> 1021
    //   1010: aload_0
    //   1011: aload 16
    //   1013: aload 17
    //   1015: invokespecial 263	org/bouncycastle/est/HttpAuth:update	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   1018: goto +11 -> 1029
    //   1021: aload_0
    //   1022: aload 16
    //   1024: ldc -35
    //   1026: invokespecial 263	org/bouncycastle/est/HttpAuth:update	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   1029: aload_0
    //   1030: aload 16
    //   1032: ldc_w 265
    //   1035: invokespecial 263	org/bouncycastle/est/HttpAuth:update	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   1038: aload_0
    //   1039: aload 16
    //   1041: aload 6
    //   1043: invokespecial 263	org/bouncycastle/est/HttpAuth:update	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   1046: ldc -33
    //   1048: astore 5
    //   1050: aload 16
    //   1052: invokevirtual 271	java/io/OutputStream:close	()V
    //   1055: aload 14
    //   1057: invokeinterface 275 1 0
    //   1062: invokestatic 287	org/bouncycastle/util/encoders/Hex:toHexString	([B)Ljava/lang/String;
    //   1065: astore 14
    //   1067: new 300	java/util/HashMap
    //   1070: dup
    //   1071: invokespecial 301	java/util/HashMap:<init>	()V
    //   1074: astore 6
    //   1076: aload 6
    //   1078: ldc_w 302
    //   1081: aload_0
    //   1082: getfield 65	org/bouncycastle/est/HttpAuth:username	Ljava/lang/String;
    //   1085: invokeinterface 306 3 0
    //   1090: pop
    //   1091: aload 6
    //   1093: ldc 35
    //   1095: aload 9
    //   1097: invokeinterface 306 3 0
    //   1102: pop
    //   1103: aload 6
    //   1105: ldc 41
    //   1107: aload 10
    //   1109: invokeinterface 306 3 0
    //   1114: pop
    //   1115: aload 6
    //   1117: ldc_w 308
    //   1120: aload 8
    //   1122: invokeinterface 306 3 0
    //   1127: pop
    //   1128: aload 6
    //   1130: ldc_w 310
    //   1133: aload 14
    //   1135: invokeinterface 306 3 0
    //   1140: pop
    //   1141: aload 12
    //   1143: iconst_0
    //   1144: invokeinterface 290 2 0
    //   1149: checkcast 186	java/lang/String
    //   1152: aload 5
    //   1154: invokevirtual 192	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1157: ifeq +44 -> 1201
    //   1160: aload 6
    //   1162: aload_1
    //   1163: aload 5
    //   1165: invokeinterface 306 3 0
    //   1170: pop
    //   1171: aload 6
    //   1173: ldc_w 312
    //   1176: ldc_w 298
    //   1179: invokeinterface 306 3 0
    //   1184: pop
    //   1185: aload 6
    //   1187: ldc_w 314
    //   1190: aload 15
    //   1192: invokeinterface 306 3 0
    //   1197: pop
    //   1198: goto +36 -> 1234
    //   1201: aload 12
    //   1203: iconst_0
    //   1204: invokeinterface 290 2 0
    //   1209: checkcast 186	java/lang/String
    //   1212: ldc -35
    //   1214: invokevirtual 192	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1217: ifeq +17 -> 1234
    //   1220: aload 6
    //   1222: aload_1
    //   1223: ldc -35
    //   1225: invokeinterface 306 3 0
    //   1230: pop
    //   1231: goto -60 -> 1171
    //   1234: aload 6
    //   1236: aload 4
    //   1238: aload 13
    //   1240: invokeinterface 306 3 0
    //   1245: pop
    //   1246: aload 11
    //   1248: ifnull +11 -> 1259
    //   1251: aload 11
    //   1253: invokevirtual 205	java/lang/String:length	()I
    //   1256: ifne +19 -> 1275
    //   1259: aload 6
    //   1261: ldc 43
    //   1263: aload_0
    //   1264: bipush 20
    //   1266: invokespecial 259	org/bouncycastle/est/HttpAuth:makeNonce	(I)Ljava/lang/String;
    //   1269: invokeinterface 306 3 0
    //   1274: pop
    //   1275: new 316	org/bouncycastle/est/ESTRequestBuilder
    //   1278: dup
    //   1279: aload 7
    //   1281: invokespecial 319	org/bouncycastle/est/ESTRequestBuilder:<init>	(Lorg/bouncycastle/est/ESTRequest;)V
    //   1284: aconst_null
    //   1285: invokevirtual 323	org/bouncycastle/est/ESTRequestBuilder:withHijacker	(Lorg/bouncycastle/est/ESTHijacker;)Lorg/bouncycastle/est/ESTRequestBuilder;
    //   1288: astore_1
    //   1289: aload_1
    //   1290: ldc_w 325
    //   1293: ldc 100
    //   1295: aload 6
    //   1297: invokestatic 329	org/bouncycastle/est/HttpUtil:mergeCSL	(Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    //   1300: invokevirtual 333	org/bouncycastle/est/ESTRequestBuilder:setHeader	(Ljava/lang/String;Ljava/lang/String;)Lorg/bouncycastle/est/ESTRequestBuilder;
    //   1303: pop
    //   1304: aload 7
    //   1306: invokevirtual 337	org/bouncycastle/est/ESTRequest:getClient	()Lorg/bouncycastle/est/ESTClient;
    //   1309: aload_1
    //   1310: invokevirtual 340	org/bouncycastle/est/ESTRequestBuilder:build	()Lorg/bouncycastle/est/ESTRequest;
    //   1313: invokeinterface 346 2 0
    //   1318: areturn
    //   1319: new 157	java/lang/StringBuilder
    //   1322: dup
    //   1323: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   1326: astore_1
    //   1327: aload_1
    //   1328: ldc_w 348
    //   1331: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1334: pop
    //   1335: aload_1
    //   1336: aload 13
    //   1338: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1341: pop
    //   1342: new 77	java/io/IOException
    //   1345: dup
    //   1346: aload_1
    //   1347: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1350: invokespecial 349	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   1353: athrow
    //   1354: new 171	org/bouncycastle/est/ESTException
    //   1357: dup
    //   1358: ldc_w 351
    //   1361: invokespecial 177	org/bouncycastle/est/ESTException:<init>	(Ljava/lang/String;)V
    //   1364: athrow
    //   1365: new 171	org/bouncycastle/est/ESTException
    //   1368: dup
    //   1369: ldc_w 353
    //   1372: invokespecial 177	org/bouncycastle/est/ESTException:<init>	(Ljava/lang/String;)V
    //   1375: athrow
    //   1376: new 171	org/bouncycastle/est/ESTException
    //   1379: dup
    //   1380: ldc_w 355
    //   1383: invokespecial 177	org/bouncycastle/est/ESTException:<init>	(Ljava/lang/String;)V
    //   1386: athrow
    //   1387: astore_1
    //   1388: new 157	java/lang/StringBuilder
    //   1391: dup
    //   1392: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   1395: astore 4
    //   1397: aload 4
    //   1399: ldc_w 357
    //   1402: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1405: pop
    //   1406: aload 4
    //   1408: aload_1
    //   1409: invokevirtual 360	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1412: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1415: pop
    //   1416: new 77	java/io/IOException
    //   1419: dup
    //   1420: aload 4
    //   1422: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1425: invokespecial 349	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   1428: athrow
    //   1429: astore 4
    //   1431: new 157	java/lang/StringBuilder
    //   1434: dup
    //   1435: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   1438: astore 5
    //   1440: aload 5
    //   1442: ldc_w 362
    //   1445: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1448: pop
    //   1449: aload 5
    //   1451: aload 4
    //   1453: invokevirtual 365	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1456: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1459: pop
    //   1460: new 171	org/bouncycastle/est/ESTException
    //   1463: dup
    //   1464: aload 5
    //   1466: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1469: aload 4
    //   1471: aload_1
    //   1472: invokevirtual 368	org/bouncycastle/est/ESTResponse:getStatusCode	()I
    //   1475: new 370	java/io/ByteArrayInputStream
    //   1478: dup
    //   1479: aload_1
    //   1480: ldc 102
    //   1482: invokevirtual 106	org/bouncycastle/est/ESTResponse:getHeader	(Ljava/lang/String;)Ljava/lang/String;
    //   1485: invokevirtual 373	java/lang/String:getBytes	()[B
    //   1488: invokespecial 376	java/io/ByteArrayInputStream:<init>	([B)V
    //   1491: invokespecial 199	org/bouncycastle/est/ESTException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;ILjava/io/InputStream;)V
    //   1494: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1495	0	this	HttpAuth
    //   0	1495	1	paramESTResponse	ESTResponse
    //   355	116	2	i	int
    //   898	36	3	bool	boolean
    //   48	1373	4	localObject1	Object
    //   1429	41	4	localThrowable	Throwable
    //   197	1268	5	localObject2	Object
    //   193	1103	6	localObject3	Object
    //   8	1297	7	localESTRequest	ESTRequest
    //   34	1087	8	str1	String
    //   147	949	9	str2	String
    //   161	947	10	str3	String
    //   175	1077	11	str4	String
    //   21	1181	12	localObject4	Object
    //   327	1010	13	str5	String
    //   133	1001	14	localObject5	Object
    //   211	980	15	str6	String
    //   480	571	16	localObject6	Object
    //   614	400	17	localObject7	Object
    //   728	70	18	localObject8	Object
    //   737	10	19	localOutputStream	OutputStream
    // Exception table:
    //   from	to	target	type
    //   23	36	1387	java/lang/Exception
    //   10	23	1429	finally
  }
  
  private DigestCalculator getDigestCalculator(String paramString, AlgorithmIdentifier paramAlgorithmIdentifier)
    throws IOException
  {
    try
    {
      paramAlgorithmIdentifier = this.digestCalculatorProvider.get(paramAlgorithmIdentifier);
      return paramAlgorithmIdentifier;
    }
    catch (OperatorCreationException paramAlgorithmIdentifier)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cannot create digest calculator for ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(": ");
      localStringBuilder.append(paramAlgorithmIdentifier.getMessage());
      throw new IOException(localStringBuilder.toString());
    }
  }
  
  private AlgorithmIdentifier lookupDigest(String paramString)
  {
    String str = paramString;
    if (paramString.endsWith("-SESS")) {
      str = paramString.substring(0, paramString.length() - 5);
    }
    if (str.equals("SHA-512-256")) {
      return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512_256, DERNull.INSTANCE);
    }
    return digestAlgorithmIdentifierFinder.find(str);
  }
  
  private String makeNonce(int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    this.nonceGenerator.nextBytes(arrayOfByte);
    return Hex.toHexString(arrayOfByte);
  }
  
  private void update(OutputStream paramOutputStream, String paramString)
    throws IOException
  {
    paramOutputStream.write(Strings.toUTF8ByteArray(paramString));
  }
  
  private void update(OutputStream paramOutputStream, char[] paramArrayOfChar)
    throws IOException
  {
    paramOutputStream.write(Strings.toUTF8ByteArray(paramArrayOfChar));
  }
  
  public void applyAuth(ESTRequestBuilder paramESTRequestBuilder)
  {
    paramESTRequestBuilder.withHijacker(new ESTHijacker()
    {
      public ESTResponse hijack(ESTRequest paramAnonymousESTRequest, Source paramAnonymousSource)
        throws IOException
      {
        paramAnonymousSource = new ESTResponse(paramAnonymousESTRequest, paramAnonymousSource);
        if (paramAnonymousSource.getStatusCode() == 401)
        {
          Object localObject = paramAnonymousSource.getHeader("WWW-Authenticate");
          if (localObject != null)
          {
            localObject = Strings.toLowerCase((String)localObject);
            if (((String)localObject).startsWith("digest")) {
              return HttpAuth.this.doDigestFunction(paramAnonymousSource);
            }
            if (((String)localObject).startsWith("basic"))
            {
              paramAnonymousSource.close();
              paramAnonymousSource = HttpUtil.splitCSL("Basic", paramAnonymousSource.getHeader("WWW-Authenticate"));
              if ((HttpAuth.this.realm != null) && (!HttpAuth.this.realm.equals(paramAnonymousSource.get("realm"))))
              {
                paramAnonymousESTRequest = new StringBuilder();
                paramAnonymousESTRequest.append("Supplied realm '");
                paramAnonymousESTRequest.append(HttpAuth.this.realm);
                paramAnonymousESTRequest.append("' does not match server realm '");
                paramAnonymousESTRequest.append((String)paramAnonymousSource.get("realm"));
                paramAnonymousESTRequest.append("'");
                throw new ESTException(paramAnonymousESTRequest.toString(), null, 401, null);
              }
              paramAnonymousSource = new ESTRequestBuilder(paramAnonymousESTRequest).withHijacker(null);
              if ((HttpAuth.this.realm != null) && (HttpAuth.this.realm.length() > 0))
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("Basic realm=\"");
                ((StringBuilder)localObject).append(HttpAuth.this.realm);
                ((StringBuilder)localObject).append("\"");
                paramAnonymousSource.setHeader("WWW-Authenticate", ((StringBuilder)localObject).toString());
              }
              if (!HttpAuth.this.username.contains(":"))
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(HttpAuth.this.username);
                ((StringBuilder)localObject).append(":");
                ((StringBuilder)localObject).append(new String(HttpAuth.this.password));
                localObject = ((StringBuilder)localObject).toString();
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("Basic ");
                localStringBuilder.append(Base64.toBase64String(((String)localObject).getBytes()));
                paramAnonymousSource.setHeader("Authorization", localStringBuilder.toString());
                return paramAnonymousESTRequest.getClient().doRequest(paramAnonymousSource.build());
              }
              throw new IllegalArgumentException("User must not contain a ':'");
            }
            paramAnonymousESTRequest = new StringBuilder();
            paramAnonymousESTRequest.append("Unknown auth mode: ");
            paramAnonymousESTRequest.append((String)localObject);
            throw new ESTException(paramAnonymousESTRequest.toString());
          }
          throw new ESTException("Status of 401 but no WWW-Authenticate header");
        }
        return paramAnonymousSource;
      }
    });
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\est\HttpAuth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */