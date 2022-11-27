package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public final class a
{
  private static a Z;
  public boolean A;
  public HashMap<String, String> B;
  public List<String> C;
  public com.tencent.bugly.crashreport.a D;
  public SharedPreferences E;
  private final Context F;
  private String G;
  private String H;
  private String I;
  private String J;
  private String K;
  private String L;
  private long M;
  private long N;
  private long O;
  private String P;
  private String Q;
  private Map<String, PlugInBean> R;
  private boolean S;
  private String T;
  private String U;
  private Boolean V;
  private String W;
  private Map<String, PlugInBean> X;
  private Map<String, PlugInBean> Y;
  public final long a;
  private int aa;
  private int ab;
  private Map<String, String> ac;
  private Map<String, String> ad;
  private Map<String, String> ae;
  private Boolean af;
  private Boolean ag;
  private final Object ah;
  private final Object ai;
  private final Object aj;
  private final Object ak;
  private final Object al;
  private final Object am;
  private final Object an;
  private int ao;
  public final byte b;
  public String c;
  public final String d;
  public boolean e;
  public String f;
  public final String g;
  public final String h;
  public long i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  public List<String> o;
  public String p;
  public long q;
  public long r;
  public long s;
  public long t;
  public boolean u;
  public String v;
  public String w;
  public String x;
  public String y;
  public boolean z;
  
  /* Error */
  private a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 92	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: iconst_1
    //   6: putfield 94	com/tencent/bugly/crashreport/common/info/a:e	Z
    //   9: aload_0
    //   10: ldc 96
    //   12: putfield 98	com/tencent/bugly/crashreport/common/info/a:f	Ljava/lang/String;
    //   15: aload_0
    //   16: ldc 100
    //   18: putfield 102	com/tencent/bugly/crashreport/common/info/a:J	Ljava/lang/String;
    //   21: aload_0
    //   22: ldc 104
    //   24: putfield 106	com/tencent/bugly/crashreport/common/info/a:K	Ljava/lang/String;
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield 108	com/tencent/bugly/crashreport/common/info/a:L	Ljava/lang/String;
    //   32: aload_0
    //   33: ldc2_w 109
    //   36: putfield 112	com/tencent/bugly/crashreport/common/info/a:M	J
    //   39: aload_0
    //   40: ldc2_w 109
    //   43: putfield 114	com/tencent/bugly/crashreport/common/info/a:N	J
    //   46: aload_0
    //   47: ldc2_w 109
    //   50: putfield 116	com/tencent/bugly/crashreport/common/info/a:O	J
    //   53: aload_0
    //   54: aconst_null
    //   55: putfield 118	com/tencent/bugly/crashreport/common/info/a:P	Ljava/lang/String;
    //   58: aload_0
    //   59: aconst_null
    //   60: putfield 120	com/tencent/bugly/crashreport/common/info/a:Q	Ljava/lang/String;
    //   63: aload_0
    //   64: aconst_null
    //   65: putfield 122	com/tencent/bugly/crashreport/common/info/a:R	Ljava/util/Map;
    //   68: aload_0
    //   69: iconst_0
    //   70: putfield 124	com/tencent/bugly/crashreport/common/info/a:S	Z
    //   73: aload_0
    //   74: aconst_null
    //   75: putfield 126	com/tencent/bugly/crashreport/common/info/a:T	Ljava/lang/String;
    //   78: aload_0
    //   79: aconst_null
    //   80: putfield 128	com/tencent/bugly/crashreport/common/info/a:j	Ljava/lang/String;
    //   83: aload_0
    //   84: aconst_null
    //   85: putfield 130	com/tencent/bugly/crashreport/common/info/a:k	Ljava/lang/String;
    //   88: aload_0
    //   89: aconst_null
    //   90: putfield 132	com/tencent/bugly/crashreport/common/info/a:U	Ljava/lang/String;
    //   93: aload_0
    //   94: aconst_null
    //   95: putfield 134	com/tencent/bugly/crashreport/common/info/a:l	Ljava/lang/String;
    //   98: aload_0
    //   99: aconst_null
    //   100: putfield 136	com/tencent/bugly/crashreport/common/info/a:V	Ljava/lang/Boolean;
    //   103: aload_0
    //   104: aconst_null
    //   105: putfield 138	com/tencent/bugly/crashreport/common/info/a:W	Ljava/lang/String;
    //   108: aload_0
    //   109: aconst_null
    //   110: putfield 140	com/tencent/bugly/crashreport/common/info/a:m	Ljava/lang/String;
    //   113: aload_0
    //   114: aconst_null
    //   115: putfield 142	com/tencent/bugly/crashreport/common/info/a:n	Ljava/lang/String;
    //   118: aload_0
    //   119: aconst_null
    //   120: putfield 144	com/tencent/bugly/crashreport/common/info/a:X	Ljava/util/Map;
    //   123: aload_0
    //   124: aconst_null
    //   125: putfield 146	com/tencent/bugly/crashreport/common/info/a:Y	Ljava/util/Map;
    //   128: aload_0
    //   129: aconst_null
    //   130: putfield 148	com/tencent/bugly/crashreport/common/info/a:o	Ljava/util/List;
    //   133: aload_0
    //   134: iconst_m1
    //   135: putfield 150	com/tencent/bugly/crashreport/common/info/a:aa	I
    //   138: aload_0
    //   139: iconst_m1
    //   140: putfield 152	com/tencent/bugly/crashreport/common/info/a:ab	I
    //   143: aload_0
    //   144: new 154	java/util/HashMap
    //   147: dup
    //   148: invokespecial 155	java/util/HashMap:<init>	()V
    //   151: putfield 157	com/tencent/bugly/crashreport/common/info/a:ac	Ljava/util/Map;
    //   154: aload_0
    //   155: new 154	java/util/HashMap
    //   158: dup
    //   159: invokespecial 155	java/util/HashMap:<init>	()V
    //   162: putfield 159	com/tencent/bugly/crashreport/common/info/a:ad	Ljava/util/Map;
    //   165: aload_0
    //   166: new 154	java/util/HashMap
    //   169: dup
    //   170: invokespecial 155	java/util/HashMap:<init>	()V
    //   173: putfield 161	com/tencent/bugly/crashreport/common/info/a:ae	Ljava/util/Map;
    //   176: aload_0
    //   177: ldc 100
    //   179: putfield 163	com/tencent/bugly/crashreport/common/info/a:p	Ljava/lang/String;
    //   182: aload_0
    //   183: lconst_0
    //   184: putfield 165	com/tencent/bugly/crashreport/common/info/a:q	J
    //   187: aload_0
    //   188: lconst_0
    //   189: putfield 167	com/tencent/bugly/crashreport/common/info/a:r	J
    //   192: aload_0
    //   193: lconst_0
    //   194: putfield 169	com/tencent/bugly/crashreport/common/info/a:s	J
    //   197: aload_0
    //   198: lconst_0
    //   199: putfield 171	com/tencent/bugly/crashreport/common/info/a:t	J
    //   202: aload_0
    //   203: iconst_0
    //   204: putfield 173	com/tencent/bugly/crashreport/common/info/a:u	Z
    //   207: aload_0
    //   208: aconst_null
    //   209: putfield 175	com/tencent/bugly/crashreport/common/info/a:v	Ljava/lang/String;
    //   212: aload_0
    //   213: aconst_null
    //   214: putfield 177	com/tencent/bugly/crashreport/common/info/a:w	Ljava/lang/String;
    //   217: aload_0
    //   218: aconst_null
    //   219: putfield 179	com/tencent/bugly/crashreport/common/info/a:x	Ljava/lang/String;
    //   222: aload_0
    //   223: ldc 104
    //   225: putfield 181	com/tencent/bugly/crashreport/common/info/a:y	Ljava/lang/String;
    //   228: aload_0
    //   229: iconst_0
    //   230: putfield 183	com/tencent/bugly/crashreport/common/info/a:z	Z
    //   233: aload_0
    //   234: iconst_0
    //   235: putfield 185	com/tencent/bugly/crashreport/common/info/a:A	Z
    //   238: aload_0
    //   239: aconst_null
    //   240: putfield 187	com/tencent/bugly/crashreport/common/info/a:af	Ljava/lang/Boolean;
    //   243: aload_0
    //   244: aconst_null
    //   245: putfield 189	com/tencent/bugly/crashreport/common/info/a:ag	Ljava/lang/Boolean;
    //   248: aload_0
    //   249: new 154	java/util/HashMap
    //   252: dup
    //   253: invokespecial 155	java/util/HashMap:<init>	()V
    //   256: putfield 191	com/tencent/bugly/crashreport/common/info/a:B	Ljava/util/HashMap;
    //   259: aload_0
    //   260: new 193	java/util/ArrayList
    //   263: dup
    //   264: invokespecial 194	java/util/ArrayList:<init>	()V
    //   267: putfield 196	com/tencent/bugly/crashreport/common/info/a:C	Ljava/util/List;
    //   270: aload_0
    //   271: aconst_null
    //   272: putfield 198	com/tencent/bugly/crashreport/common/info/a:D	Lcom/tencent/bugly/crashreport/a;
    //   275: aload_0
    //   276: new 4	java/lang/Object
    //   279: dup
    //   280: invokespecial 92	java/lang/Object:<init>	()V
    //   283: putfield 200	com/tencent/bugly/crashreport/common/info/a:ah	Ljava/lang/Object;
    //   286: aload_0
    //   287: new 4	java/lang/Object
    //   290: dup
    //   291: invokespecial 92	java/lang/Object:<init>	()V
    //   294: putfield 202	com/tencent/bugly/crashreport/common/info/a:ai	Ljava/lang/Object;
    //   297: aload_0
    //   298: new 4	java/lang/Object
    //   301: dup
    //   302: invokespecial 92	java/lang/Object:<init>	()V
    //   305: putfield 204	com/tencent/bugly/crashreport/common/info/a:aj	Ljava/lang/Object;
    //   308: aload_0
    //   309: new 4	java/lang/Object
    //   312: dup
    //   313: invokespecial 92	java/lang/Object:<init>	()V
    //   316: putfield 206	com/tencent/bugly/crashreport/common/info/a:ak	Ljava/lang/Object;
    //   319: aload_0
    //   320: new 4	java/lang/Object
    //   323: dup
    //   324: invokespecial 92	java/lang/Object:<init>	()V
    //   327: putfield 208	com/tencent/bugly/crashreport/common/info/a:al	Ljava/lang/Object;
    //   330: aload_0
    //   331: new 4	java/lang/Object
    //   334: dup
    //   335: invokespecial 92	java/lang/Object:<init>	()V
    //   338: putfield 210	com/tencent/bugly/crashreport/common/info/a:am	Ljava/lang/Object;
    //   341: aload_0
    //   342: new 4	java/lang/Object
    //   345: dup
    //   346: invokespecial 92	java/lang/Object:<init>	()V
    //   349: putfield 212	com/tencent/bugly/crashreport/common/info/a:an	Ljava/lang/Object;
    //   352: aload_0
    //   353: iconst_0
    //   354: putfield 214	com/tencent/bugly/crashreport/common/info/a:ao	I
    //   357: aload_0
    //   358: invokestatic 220	java/lang/System:currentTimeMillis	()J
    //   361: putfield 222	com/tencent/bugly/crashreport/common/info/a:a	J
    //   364: aload_0
    //   365: aload_1
    //   366: invokestatic 227	com/tencent/bugly/proguard/z:a	(Landroid/content/Context;)Landroid/content/Context;
    //   369: putfield 229	com/tencent/bugly/crashreport/common/info/a:F	Landroid/content/Context;
    //   372: aload_0
    //   373: iconst_1
    //   374: putfield 231	com/tencent/bugly/crashreport/common/info/a:b	B
    //   377: aload_1
    //   378: invokestatic 236	com/tencent/bugly/crashreport/common/info/AppInfo:b	(Landroid/content/Context;)Landroid/content/pm/PackageInfo;
    //   381: astore_2
    //   382: aload_2
    //   383: ifnull +44 -> 427
    //   386: aload_2
    //   387: getfield 241	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   390: astore_3
    //   391: aload_0
    //   392: aload_3
    //   393: putfield 128	com/tencent/bugly/crashreport/common/info/a:j	Ljava/lang/String;
    //   396: aload_0
    //   397: aload_3
    //   398: putfield 175	com/tencent/bugly/crashreport/common/info/a:v	Ljava/lang/String;
    //   401: aload_0
    //   402: aload_2
    //   403: getfield 244	android/content/pm/PackageInfo:versionCode	I
    //   406: invokestatic 250	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   409: putfield 177	com/tencent/bugly/crashreport/common/info/a:w	Ljava/lang/String;
    //   412: goto +15 -> 427
    //   415: astore_2
    //   416: aload_2
    //   417: invokestatic 255	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   420: ifne +7 -> 427
    //   423: aload_2
    //   424: invokevirtual 260	java/lang/Throwable:printStackTrace	()V
    //   427: aload_0
    //   428: aload_1
    //   429: invokestatic 263	com/tencent/bugly/crashreport/common/info/AppInfo:a	(Landroid/content/Context;)Ljava/lang/String;
    //   432: putfield 265	com/tencent/bugly/crashreport/common/info/a:c	Ljava/lang/String;
    //   435: aload_0
    //   436: invokestatic 271	android/os/Process:myPid	()I
    //   439: invokestatic 273	com/tencent/bugly/crashreport/common/info/AppInfo:a	(I)Ljava/lang/String;
    //   442: putfield 275	com/tencent/bugly/crashreport/common/info/a:d	Ljava/lang/String;
    //   445: aload_0
    //   446: invokestatic 280	com/tencent/bugly/crashreport/common/info/b:k	()Ljava/lang/String;
    //   449: putfield 282	com/tencent/bugly/crashreport/common/info/a:g	Ljava/lang/String;
    //   452: aload_0
    //   453: aload_1
    //   454: invokestatic 284	com/tencent/bugly/crashreport/common/info/AppInfo:c	(Landroid/content/Context;)Ljava/lang/String;
    //   457: putfield 130	com/tencent/bugly/crashreport/common/info/a:k	Ljava/lang/String;
    //   460: new 286	java/lang/StringBuilder
    //   463: dup
    //   464: ldc_w 288
    //   467: invokespecial 291	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   470: astore_2
    //   471: aload_2
    //   472: invokestatic 293	com/tencent/bugly/crashreport/common/info/b:b	()Ljava/lang/String;
    //   475: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: pop
    //   479: aload_2
    //   480: ldc_w 299
    //   483: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: pop
    //   487: aload_2
    //   488: invokestatic 301	com/tencent/bugly/crashreport/common/info/b:c	()I
    //   491: invokevirtual 304	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   494: pop
    //   495: aload_0
    //   496: aload_2
    //   497: invokevirtual 306	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   500: putfield 308	com/tencent/bugly/crashreport/common/info/a:h	Ljava/lang/String;
    //   503: aload_1
    //   504: invokestatic 311	com/tencent/bugly/crashreport/common/info/AppInfo:d	(Landroid/content/Context;)Ljava/util/Map;
    //   507: astore_2
    //   508: aload_2
    //   509: ifnull +197 -> 706
    //   512: aload_0
    //   513: aload_2
    //   514: invokestatic 314	com/tencent/bugly/crashreport/common/info/AppInfo:a	(Ljava/util/Map;)Ljava/util/List;
    //   517: putfield 148	com/tencent/bugly/crashreport/common/info/a:o	Ljava/util/List;
    //   520: aload_2
    //   521: ldc_w 316
    //   524: invokeinterface 322 2 0
    //   529: checkcast 324	java/lang/String
    //   532: astore_3
    //   533: aload_3
    //   534: ifnull +16 -> 550
    //   537: aload_0
    //   538: aload_3
    //   539: putfield 132	com/tencent/bugly/crashreport/common/info/a:U	Ljava/lang/String;
    //   542: aload_0
    //   543: ldc_w 326
    //   546: aload_3
    //   547: invokevirtual 329	com/tencent/bugly/crashreport/common/info/a:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   550: aload_2
    //   551: ldc_w 331
    //   554: invokeinterface 322 2 0
    //   559: checkcast 324	java/lang/String
    //   562: astore_3
    //   563: aload_3
    //   564: ifnull +8 -> 572
    //   567: aload_0
    //   568: aload_3
    //   569: putfield 128	com/tencent/bugly/crashreport/common/info/a:j	Ljava/lang/String;
    //   572: aload_2
    //   573: ldc_w 333
    //   576: invokeinterface 322 2 0
    //   581: checkcast 324	java/lang/String
    //   584: astore_3
    //   585: aload_3
    //   586: ifnull +8 -> 594
    //   589: aload_0
    //   590: aload_3
    //   591: putfield 134	com/tencent/bugly/crashreport/common/info/a:l	Ljava/lang/String;
    //   594: aload_2
    //   595: ldc_w 335
    //   598: invokeinterface 322 2 0
    //   603: checkcast 324	java/lang/String
    //   606: astore_3
    //   607: aload_3
    //   608: ifnull +14 -> 622
    //   611: aload_0
    //   612: aload_3
    //   613: ldc_w 337
    //   616: invokevirtual 341	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   619: putfield 173	com/tencent/bugly/crashreport/common/info/a:u	Z
    //   622: aload_2
    //   623: ldc_w 343
    //   626: invokeinterface 322 2 0
    //   631: checkcast 324	java/lang/String
    //   634: astore_3
    //   635: aload_3
    //   636: ifnull +8 -> 644
    //   639: aload_0
    //   640: aload_3
    //   641: putfield 179	com/tencent/bugly/crashreport/common/info/a:x	Ljava/lang/String;
    //   644: aload_2
    //   645: ldc_w 345
    //   648: invokeinterface 322 2 0
    //   653: checkcast 324	java/lang/String
    //   656: astore_3
    //   657: aload_3
    //   658: invokestatic 351	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   661: ifne +8 -> 669
    //   664: aload_3
    //   665: invokestatic 355	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   668: pop
    //   669: aload_2
    //   670: ldc_w 357
    //   673: invokeinterface 322 2 0
    //   678: checkcast 324	java/lang/String
    //   681: astore_2
    //   682: aload_2
    //   683: ifnull +23 -> 706
    //   686: aload_0
    //   687: aload_2
    //   688: putfield 181	com/tencent/bugly/crashreport/common/info/a:y	Ljava/lang/String;
    //   691: goto +15 -> 706
    //   694: astore_2
    //   695: aload_2
    //   696: invokestatic 255	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   699: ifne +7 -> 706
    //   702: aload_2
    //   703: invokevirtual 260	java/lang/Throwable:printStackTrace	()V
    //   706: aload_1
    //   707: ldc_w 359
    //   710: invokevirtual 365	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   713: invokevirtual 371	java/io/File:exists	()Z
    //   716: ifne +33 -> 749
    //   719: aload_0
    //   720: iconst_1
    //   721: putfield 185	com/tencent/bugly/crashreport/common/info/a:A	Z
    //   724: ldc_w 373
    //   727: iconst_0
    //   728: anewarray 4	java/lang/Object
    //   731: invokestatic 376	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   734: pop
    //   735: goto +14 -> 749
    //   738: astore_2
    //   739: getstatic 380	com/tencent/bugly/b:c	Z
    //   742: ifeq +7 -> 749
    //   745: aload_2
    //   746: invokevirtual 260	java/lang/Throwable:printStackTrace	()V
    //   749: aload_0
    //   750: ldc_w 382
    //   753: aload_1
    //   754: invokestatic 385	com/tencent/bugly/proguard/z:a	(Ljava/lang/String;Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   757: putfield 387	com/tencent/bugly/crashreport/common/info/a:E	Landroid/content/SharedPreferences;
    //   760: ldc_w 389
    //   763: iconst_0
    //   764: anewarray 4	java/lang/Object
    //   767: invokestatic 376	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   770: pop
    //   771: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	772	0	this	a
    //   0	772	1	paramContext	Context
    //   381	22	2	localPackageInfo	android.content.pm.PackageInfo
    //   415	9	2	localThrowable1	Throwable
    //   470	218	2	localObject1	Object
    //   694	9	2	localThrowable2	Throwable
    //   738	8	2	localObject2	Object
    //   390	275	3	str	String
    // Exception table:
    //   from	to	target	type
    //   386	412	415	finally
    //   512	533	694	finally
    //   537	550	694	finally
    //   550	563	694	finally
    //   567	572	694	finally
    //   572	585	694	finally
    //   589	594	694	finally
    //   594	607	694	finally
    //   611	622	694	finally
    //   622	635	694	finally
    //   639	644	694	finally
    //   644	669	694	finally
    //   669	682	694	finally
    //   686	691	694	finally
    //   706	735	738	finally
  }
  
  public static int D()
  {
    return b.c();
  }
  
  public static a a(Context paramContext)
  {
    try
    {
      if (Z == null) {
        Z = new a(paramContext);
      }
      paramContext = Z;
      return paramContext;
    }
    finally {}
  }
  
  public static a b()
  {
    try
    {
      a locala = Z;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final int A()
  {
    synchronized (this.al)
    {
      int i1 = this.aa;
      return i1;
    }
  }
  
  public final int B()
  {
    return this.ab;
  }
  
  public final Map<String, PlugInBean> C()
  {
    return null;
  }
  
  public final boolean E()
  {
    if (this.af == null)
    {
      this.af = Boolean.valueOf(b.e(this.F));
      StringBuilder localStringBuilder = new StringBuilder("Is it a virtual machine? ");
      localStringBuilder.append(this.af);
      x.a(localStringBuilder.toString(), new Object[0]);
    }
    return this.af.booleanValue();
  }
  
  public final boolean F()
  {
    if (this.ag == null)
    {
      this.ag = Boolean.valueOf(b.f(this.F));
      StringBuilder localStringBuilder = new StringBuilder("Does it has hook frame? ");
      localStringBuilder.append(this.ag);
      x.a(localStringBuilder.toString(), new Object[0]);
    }
    return this.ag.booleanValue();
  }
  
  public final void a(int paramInt)
  {
    synchronized (this.al)
    {
      int i1 = this.aa;
      if (i1 != paramInt)
      {
        this.aa = paramInt;
        x.a("user scene tag %d changed to tag %d", new Object[] { Integer.valueOf(i1), Integer.valueOf(this.aa) });
      }
      return;
    }
  }
  
  public final void a(String paramString)
  {
    this.U = paramString;
    c("APP_ID", paramString);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return;
      }
      synchronized (this.ai)
      {
        this.B.put(paramString1, paramString2);
        return;
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    boolean bool = true;
    if (paramBoolean) {
      this.ao += 1;
    } else {
      this.ao -= 1;
    }
    com.tencent.bugly.crashreport.a locala = this.D;
    if (locala != null)
    {
      if (this.ao > 0) {
        paramBoolean = bool;
      } else {
        paramBoolean = false;
      }
      locala.setNativeIsAppForeground(paramBoolean);
    }
  }
  
  public final boolean a()
  {
    return this.ao > 0;
  }
  
  public final void b(int paramInt)
  {
    paramInt = this.ab;
    if (paramInt != 24096)
    {
      this.ab = 24096;
      x.a("server scene tag %d changed to tag %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.ab) });
    }
  }
  
  public final void b(String paramString)
  {
    Object localObject = this.am;
    String str = paramString;
    if (paramString == null) {
      str = "10000";
    }
    try
    {
      paramString = new StringBuilder();
      paramString.append(str);
      this.J = paramString.toString();
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void b(String paramString1, String paramString2)
  {
    if ((!z.a(paramString1)) && (!z.a(paramString2))) {
      synchronized (this.aj)
      {
        this.ac.put(paramString1, paramString2);
        return;
      }
    }
    ??? = new StringBuilder();
    ((StringBuilder)???).append(paramString1);
    paramString1 = ((StringBuilder)???).toString();
    ??? = new StringBuilder();
    ((StringBuilder)???).append(paramString2);
    x.d("key&value should not be empty %s %s", new Object[] { paramString1, ((StringBuilder)???).toString() });
  }
  
  public final void b(boolean paramBoolean)
  {
    this.S = paramBoolean;
  }
  
  public final String c()
  {
    return this.f;
  }
  
  public final void c(String paramString)
  {
    this.I = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      z.b("deviceId", paramString);
    }
    synchronized (this.an)
    {
      this.ad.put("E8", paramString);
      return;
    }
  }
  
  public final void c(String paramString1, String paramString2)
  {
    if ((!z.a(paramString1)) && (!z.a(paramString2))) {
      synchronized (this.ak)
      {
        this.ae.put(paramString1, paramString2);
        return;
      }
    }
    ??? = new StringBuilder();
    ((StringBuilder)???).append(paramString1);
    paramString1 = ((StringBuilder)???).toString();
    ??? = new StringBuilder();
    ((StringBuilder)???).append(paramString2);
    x.d("server key&value should not be empty %s %s", new Object[] { paramString1, ((StringBuilder)???).toString() });
  }
  
  public final void d()
  {
    synchronized (this.ah)
    {
      this.G = UUID.randomUUID().toString();
      return;
    }
  }
  
  public final void d(String paramString)
  {
    x.a("change deviceModel，old:%s new:%s", new Object[] { this.H, paramString });
    this.H = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      z.b("deviceModel", paramString);
    }
  }
  
  public final String e()
  {
    synchronized (this.ah)
    {
      if (this.G == null) {
        synchronized (this.ah)
        {
          this.G = UUID.randomUUID().toString();
        }
      }
      ??? = this.G;
      return (String)???;
    }
  }
  
  public final void e(String paramString) {}
  
  public final String f()
  {
    if (!z.a(null)) {
      return null;
    }
    return this.U;
  }
  
  public final void f(String paramString)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      this.K = localStringBuilder.toString();
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final String g()
  {
    synchronized (this.am)
    {
      String str = this.J;
      return str;
    }
  }
  
  public final String g(String paramString)
  {
    if (z.a(paramString))
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append(paramString);
      x.d("key should not be empty %s", new Object[] { ((StringBuilder)???).toString() });
      return null;
    }
    synchronized (this.aj)
    {
      paramString = (String)this.ac.remove(paramString);
      return paramString;
    }
  }
  
  public final String h()
  {
    Object localObject = this.I;
    if (localObject != null) {
      return (String)localObject;
    }
    localObject = null;
    String str = z.c("deviceId", null);
    this.I = str;
    if (str != null) {
      return str;
    }
    if (TextUtils.isEmpty(this.L)) {
      this.L = z.c("androidid", null);
    }
    if (TextUtils.isEmpty(this.L))
    {
      if (!this.S) {
        break label108;
      }
      localObject = b.a(this.F);
      this.L = ((String)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        z.b("androidid", this.L);
      }
    }
    localObject = this.L;
    label108:
    this.I = ((String)localObject);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      str = UUID.randomUUID().toString();
      localObject = str;
      if (!z.a(str)) {
        localObject = str.replaceAll("-", "");
      }
      this.I = ((String)localObject);
    }
    localObject = this.I;
    if (localObject != null)
    {
      z.b("deviceId", (String)localObject);
      return this.I;
    }
    return "";
  }
  
  public final String h(String paramString)
  {
    if (z.a(paramString))
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append(paramString);
      x.d("key should not be empty %s", new Object[] { ((StringBuilder)???).toString() });
      return null;
    }
    synchronized (this.aj)
    {
      paramString = (String)this.ac.get(paramString);
      return paramString;
    }
  }
  
  public final String i()
  {
    String str = this.H;
    if (str != null) {
      return str;
    }
    str = z.c("deviceModel", null);
    this.H = str;
    if (str != null) {
      return str;
    }
    str = b.a();
    this.H = str;
    z.b("deviceModel", str);
    return this.H;
  }
  
  public final String j()
  {
    try
    {
      String str = this.K;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final long k()
  {
    if (this.M <= 0L) {
      this.M = b.d();
    }
    return this.M;
  }
  
  public final long l()
  {
    if (this.N <= 0L) {
      this.N = b.f();
    }
    return this.N;
  }
  
  public final long m()
  {
    if (this.O <= 0L) {
      this.O = b.h();
    }
    return this.O;
  }
  
  public final String n()
  {
    if (this.P == null) {
      this.P = b.a(this.F, true);
    }
    return this.P;
  }
  
  public final String o()
  {
    if (this.Q == null) {
      this.Q = b.d(this.F);
    }
    return this.Q;
  }
  
  /* Error */
  public final String p()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 229	com/tencent/bugly/crashreport/common/info/a:F	Landroid/content/Context;
    //   4: ldc_w 507
    //   7: iconst_0
    //   8: invokevirtual 511	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   11: invokeinterface 516 1 0
    //   16: astore_2
    //   17: aload_2
    //   18: invokeinterface 518 1 0
    //   23: ifne +92 -> 115
    //   26: aload_0
    //   27: getfield 202	com/tencent/bugly/crashreport/common/info/a:ai	Ljava/lang/Object;
    //   30: astore_1
    //   31: aload_1
    //   32: monitorenter
    //   33: aload_2
    //   34: invokeinterface 522 1 0
    //   39: invokeinterface 528 1 0
    //   44: astore_2
    //   45: aload_2
    //   46: invokeinterface 533 1 0
    //   51: ifeq +48 -> 99
    //   54: aload_2
    //   55: invokeinterface 537 1 0
    //   60: checkcast 539	java/util/Map$Entry
    //   63: astore_3
    //   64: aload_0
    //   65: getfield 191	com/tencent/bugly/crashreport/common/info/a:B	Ljava/util/HashMap;
    //   68: aload_3
    //   69: invokeinterface 542 1 0
    //   74: aload_3
    //   75: invokeinterface 545 1 0
    //   80: invokevirtual 546	java/lang/Object:toString	()Ljava/lang/String;
    //   83: invokevirtual 431	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   86: pop
    //   87: goto -42 -> 45
    //   90: astore_3
    //   91: aload_3
    //   92: invokestatic 255	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   95: pop
    //   96: goto -51 -> 45
    //   99: aload_1
    //   100: monitorexit
    //   101: goto +14 -> 115
    //   104: astore_2
    //   105: aload_1
    //   106: monitorexit
    //   107: aload_2
    //   108: athrow
    //   109: astore_1
    //   110: aload_1
    //   111: invokestatic 255	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   114: pop
    //   115: aload_0
    //   116: getfield 191	com/tencent/bugly/crashreport/common/info/a:B	Ljava/util/HashMap;
    //   119: invokevirtual 547	java/util/HashMap:isEmpty	()Z
    //   122: ifne +132 -> 254
    //   125: new 286	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 443	java/lang/StringBuilder:<init>	()V
    //   132: astore_1
    //   133: aload_0
    //   134: getfield 191	com/tencent/bugly/crashreport/common/info/a:B	Ljava/util/HashMap;
    //   137: invokevirtual 548	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   140: invokeinterface 528 1 0
    //   145: astore_2
    //   146: aload_2
    //   147: invokeinterface 533 1 0
    //   152: ifeq +68 -> 220
    //   155: aload_2
    //   156: invokeinterface 537 1 0
    //   161: checkcast 539	java/util/Map$Entry
    //   164: astore_3
    //   165: aload_1
    //   166: ldc_w 550
    //   169: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload_1
    //   174: aload_3
    //   175: invokeinterface 542 1 0
    //   180: checkcast 324	java/lang/String
    //   183: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload_1
    //   188: ldc_w 552
    //   191: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload_1
    //   196: aload_3
    //   197: invokeinterface 545 1 0
    //   202: checkcast 324	java/lang/String
    //   205: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload_1
    //   210: ldc_w 554
    //   213: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: goto -71 -> 146
    //   220: ldc_w 556
    //   223: iconst_1
    //   224: anewarray 4	java/lang/Object
    //   227: dup
    //   228: iconst_0
    //   229: aload_1
    //   230: invokevirtual 306	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: aastore
    //   234: invokestatic 376	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   237: pop
    //   238: aload_0
    //   239: ldc_w 558
    //   242: aload_1
    //   243: invokevirtual 306	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokevirtual 329	com/tencent/bugly/crashreport/common/info/a:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   249: aload_1
    //   250: invokevirtual 306	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: areturn
    //   254: ldc_w 560
    //   257: iconst_0
    //   258: anewarray 4	java/lang/Object
    //   261: invokestatic 376	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   264: pop
    //   265: aconst_null
    //   266: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	this	a
    //   30	76	1	localObject1	Object
    //   109	2	1	localThrowable1	Throwable
    //   132	118	1	localStringBuilder	StringBuilder
    //   16	39	2	localObject2	Object
    //   104	4	2	localObject3	Object
    //   145	11	2	localIterator	java.util.Iterator
    //   63	12	3	localEntry1	java.util.Map.Entry
    //   90	2	3	localThrowable2	Throwable
    //   164	33	3	localEntry2	java.util.Map.Entry
    // Exception table:
    //   from	to	target	type
    //   64	87	90	finally
    //   33	45	104	finally
    //   45	64	104	finally
    //   91	96	104	finally
    //   99	101	104	finally
    //   0	33	109	finally
    //   105	109	109	finally
  }
  
  public final Map<String, PlugInBean> q()
  {
    return null;
  }
  
  public final String r()
  {
    if (this.T == null) {
      this.T = b.j();
    }
    return this.T;
  }
  
  public final Boolean s()
  {
    if (this.V == null) {
      this.V = Boolean.valueOf(b.l());
    }
    return this.V;
  }
  
  public final String t()
  {
    if (this.W == null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(b.c(this.F));
      localObject = ((StringBuilder)localObject).toString();
      this.W = ((String)localObject);
      x.a("ROM ID: %s", new Object[] { localObject });
    }
    return this.W;
  }
  
  public final Map<String, String> u()
  {
    synchronized (this.aj)
    {
      if (this.ac.size() <= 0) {
        return null;
      }
      HashMap localHashMap = new HashMap(this.ac);
      return localHashMap;
    }
  }
  
  public final void v()
  {
    synchronized (this.aj)
    {
      this.ac.clear();
      return;
    }
  }
  
  public final int w()
  {
    synchronized (this.aj)
    {
      int i1 = this.ac.size();
      return i1;
    }
  }
  
  public final Set<String> x()
  {
    synchronized (this.aj)
    {
      Set localSet = this.ac.keySet();
      return localSet;
    }
  }
  
  public final Map<String, String> y()
  {
    synchronized (this.an)
    {
      if (this.ad.size() <= 0) {
        return null;
      }
      HashMap localHashMap = new HashMap(this.ad);
      return localHashMap;
    }
  }
  
  public final Map<String, String> z()
  {
    synchronized (this.ak)
    {
      if (this.ae.size() <= 0) {
        return null;
      }
      HashMap localHashMap = new HashMap(this.ae);
      return localHashMap;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\crashreport\common\info\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */