package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.util.Map;

public final class a
  implements NativeExceptionHandler
{
  private final Context a;
  private final com.tencent.bugly.crashreport.crash.b b;
  private final com.tencent.bugly.crashreport.common.info.a c;
  private final com.tencent.bugly.crashreport.common.strategy.a d;
  
  public a(Context paramContext, com.tencent.bugly.crashreport.common.info.a parama, com.tencent.bugly.crashreport.crash.b paramb, com.tencent.bugly.crashreport.common.strategy.a parama1)
  {
    this.a = paramContext;
    this.b = paramb;
    this.c = parama;
    this.d = parama1;
  }
  
  public final void handleNativeException(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3, String paramString5, int paramInt4, int paramInt5, int paramInt6, String paramString6, String paramString7)
  {
    x.a("Native Crash Happen v1", new Object[0]);
    handleNativeException2(paramInt1, paramInt2, paramLong1, paramLong2, paramString1, paramString2, paramString3, paramString4, paramInt3, paramString5, paramInt4, paramInt5, paramInt6, paramString6, paramString7, null);
  }
  
  /* Error */
  public final void handleNativeException2(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3, String paramString5, int paramInt4, int paramInt5, int paramInt6, String paramString6, String paramString7, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: ldc 43
    //   2: iconst_0
    //   3: anewarray 4	java/lang/Object
    //   6: invokestatic 37	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   9: pop
    //   10: aload 9
    //   12: invokestatic 48	com/tencent/bugly/crashreport/crash/jni/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   15: astore 22
    //   17: ldc 50
    //   19: astore 9
    //   21: iload 11
    //   23: ifle +62 -> 85
    //   26: new 52	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   33: astore 9
    //   35: aload 9
    //   37: aload 7
    //   39: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload 9
    //   45: ldc 59
    //   47: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload 9
    //   53: aload 12
    //   55: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload 9
    //   61: ldc 61
    //   63: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload 9
    //   69: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: astore 12
    //   74: ldc 50
    //   76: astore 21
    //   78: ldc 67
    //   80: astore 16
    //   82: goto +79 -> 161
    //   85: iload 13
    //   87: ifle +10 -> 97
    //   90: iload 13
    //   92: invokestatic 72	com/tencent/bugly/crashreport/common/info/AppInfo:a	(I)Ljava/lang/String;
    //   95: astore 9
    //   97: aload 9
    //   99: iload 13
    //   101: invokestatic 77	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   104: invokevirtual 81	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   107: ifne +944 -> 1051
    //   110: new 52	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   117: astore 16
    //   119: aload 16
    //   121: aload 9
    //   123: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload 16
    //   129: ldc 59
    //   131: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload 16
    //   137: iload 13
    //   139: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload 16
    //   145: ldc 61
    //   147: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload 16
    //   153: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: astore 9
    //   158: goto +893 -> 1051
    //   161: new 86	java/util/HashMap
    //   164: dup
    //   165: invokespecial 87	java/util/HashMap:<init>	()V
    //   168: astore 23
    //   170: aload 18
    //   172: ifnull +98 -> 270
    //   175: iconst_0
    //   176: istore_1
    //   177: iload_1
    //   178: aload 18
    //   180: arraylength
    //   181: if_icmpge +99 -> 280
    //   184: aload 18
    //   186: iload_1
    //   187: aaload
    //   188: astore 7
    //   190: aload 7
    //   192: ifnull +874 -> 1066
    //   195: ldc 89
    //   197: iconst_2
    //   198: anewarray 4	java/lang/Object
    //   201: dup
    //   202: iconst_0
    //   203: iload_1
    //   204: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   207: aastore
    //   208: dup
    //   209: iconst_1
    //   210: aload 7
    //   212: aastore
    //   213: invokestatic 37	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   216: pop
    //   217: aload 7
    //   219: ldc 96
    //   221: invokevirtual 100	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   224: astore 9
    //   226: aload 9
    //   228: arraylength
    //   229: iconst_2
    //   230: if_icmpne +22 -> 252
    //   233: aload 23
    //   235: aload 9
    //   237: iconst_0
    //   238: aaload
    //   239: aload 9
    //   241: iconst_1
    //   242: aaload
    //   243: invokeinterface 106 3 0
    //   248: pop
    //   249: goto +817 -> 1066
    //   252: ldc 108
    //   254: iconst_1
    //   255: anewarray 4	java/lang/Object
    //   258: dup
    //   259: iconst_0
    //   260: aload 7
    //   262: aastore
    //   263: invokestatic 110	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   266: pop
    //   267: goto +799 -> 1066
    //   270: ldc 112
    //   272: iconst_0
    //   273: anewarray 4	java/lang/Object
    //   276: invokestatic 114	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   279: pop
    //   280: aload 23
    //   282: ldc 116
    //   284: invokeinterface 120 2 0
    //   289: checkcast 74	java/lang/String
    //   292: astore 7
    //   294: aload 7
    //   296: ifnull +777 -> 1073
    //   299: aload 7
    //   301: ldc 122
    //   303: invokevirtual 81	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   306: ifeq +767 -> 1073
    //   309: ldc 124
    //   311: iconst_0
    //   312: anewarray 4	java/lang/Object
    //   315: invokestatic 37	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   318: pop
    //   319: iconst_1
    //   320: istore 19
    //   322: goto +3 -> 325
    //   325: aload 23
    //   327: ldc 126
    //   329: invokeinterface 120 2 0
    //   334: checkcast 74	java/lang/String
    //   337: astore 18
    //   339: aload 18
    //   341: ifnull +32 -> 373
    //   344: aload 18
    //   346: invokevirtual 130	java/lang/String:length	()I
    //   349: ifne +6 -> 355
    //   352: goto +21 -> 373
    //   355: ldc -124
    //   357: iconst_1
    //   358: anewarray 4	java/lang/Object
    //   361: dup
    //   362: iconst_0
    //   363: aload 18
    //   365: aastore
    //   366: invokestatic 114	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   369: pop
    //   370: goto +12 -> 382
    //   373: aload_0
    //   374: getfield 25	com/tencent/bugly/crashreport/crash/jni/a:c	Lcom/tencent/bugly/crashreport/common/info/a;
    //   377: getfield 137	com/tencent/bugly/crashreport/common/info/a:d	Ljava/lang/String;
    //   380: astore 18
    //   382: aload 23
    //   384: ldc -117
    //   386: invokeinterface 120 2 0
    //   391: checkcast 74	java/lang/String
    //   394: astore 9
    //   396: aload 9
    //   398: ifnull +193 -> 591
    //   401: aload 9
    //   403: invokevirtual 130	java/lang/String:length	()I
    //   406: ifne +6 -> 412
    //   409: goto +182 -> 591
    //   412: ldc -115
    //   414: iconst_1
    //   415: anewarray 4	java/lang/Object
    //   418: dup
    //   419: iconst_0
    //   420: aload 9
    //   422: aastore
    //   423: invokestatic 114	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   426: pop
    //   427: invokestatic 147	java/lang/Thread:getAllStackTraces	()Ljava/util/Map;
    //   430: invokeinterface 151 1 0
    //   435: invokeinterface 157 1 0
    //   440: astore 24
    //   442: aload 24
    //   444: invokeinterface 163 1 0
    //   449: ifeq +630 -> 1079
    //   452: aload 24
    //   454: invokeinterface 167 1 0
    //   459: checkcast 143	java/lang/Thread
    //   462: astore 7
    //   464: aload 7
    //   466: invokevirtual 170	java/lang/Thread:getName	()Ljava/lang/String;
    //   469: aload 9
    //   471: invokevirtual 81	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   474: ifeq -32 -> 442
    //   477: new 52	java/lang/StringBuilder
    //   480: dup
    //   481: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   484: astore 24
    //   486: aload 24
    //   488: aload 9
    //   490: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: pop
    //   494: aload 24
    //   496: ldc 59
    //   498: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: pop
    //   502: aload 24
    //   504: aload 7
    //   506: invokevirtual 174	java/lang/Thread:getId	()J
    //   509: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   512: pop
    //   513: aload 24
    //   515: ldc 61
    //   517: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: pop
    //   521: aload 24
    //   523: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   526: astore 9
    //   528: iconst_1
    //   529: istore_1
    //   530: goto +3 -> 533
    //   533: aload 9
    //   535: astore 7
    //   537: iload_1
    //   538: ifne +112 -> 650
    //   541: new 52	java/lang/StringBuilder
    //   544: dup
    //   545: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   548: astore 7
    //   550: aload 7
    //   552: aload 9
    //   554: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: pop
    //   558: aload 7
    //   560: ldc 59
    //   562: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: pop
    //   566: aload 7
    //   568: iload_2
    //   569: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   572: pop
    //   573: aload 7
    //   575: ldc 61
    //   577: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: pop
    //   581: aload 7
    //   583: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   586: astore 7
    //   588: goto +62 -> 650
    //   591: invokestatic 181	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   594: astore 7
    //   596: new 52	java/lang/StringBuilder
    //   599: dup
    //   600: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   603: astore 9
    //   605: aload 9
    //   607: aload 7
    //   609: invokevirtual 170	java/lang/Thread:getName	()Ljava/lang/String;
    //   612: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: pop
    //   616: aload 9
    //   618: ldc 59
    //   620: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: pop
    //   624: aload 9
    //   626: aload 7
    //   628: invokevirtual 174	java/lang/Thread:getId	()J
    //   631: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   634: pop
    //   635: aload 9
    //   637: ldc 61
    //   639: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: pop
    //   643: aload 9
    //   645: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   648: astore 7
    //   650: lload 5
    //   652: ldc2_w 182
    //   655: ldiv
    //   656: lstore 5
    //   658: aload 23
    //   660: ldc -71
    //   662: invokeinterface 120 2 0
    //   667: checkcast 74	java/lang/String
    //   670: astore 9
    //   672: aload 23
    //   674: ldc -69
    //   676: invokeinterface 120 2 0
    //   681: checkcast 74	java/lang/String
    //   684: astore 23
    //   686: aload_0
    //   687: getfield 27	com/tencent/bugly/crashreport/crash/jni/a:d	Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   690: invokevirtual 191	com/tencent/bugly/crashreport/common/strategy/a:b	()Z
    //   693: ifne +13 -> 706
    //   696: ldc -63
    //   698: iconst_0
    //   699: anewarray 4	java/lang/Object
    //   702: invokestatic 110	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   705: pop
    //   706: aload_0
    //   707: getfield 27	com/tencent/bugly/crashreport/crash/jni/a:d	Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   710: invokevirtual 196	com/tencent/bugly/crashreport/common/strategy/a:c	()Lcom/tencent/bugly/crashreport/common/strategy/StrategyBean;
    //   713: getfield 202	com/tencent/bugly/crashreport/common/strategy/StrategyBean:e	Z
    //   716: istore 20
    //   718: iload 20
    //   720: ifne +100 -> 820
    //   723: aload_0
    //   724: getfield 27	com/tencent/bugly/crashreport/crash/jni/a:d	Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   727: invokevirtual 191	com/tencent/bugly/crashreport/common/strategy/a:b	()Z
    //   730: ifeq +90 -> 820
    //   733: ldc -52
    //   735: iconst_0
    //   736: anewarray 4	java/lang/Object
    //   739: invokestatic 206	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   742: pop
    //   743: invokestatic 210	com/tencent/bugly/proguard/z:a	()Ljava/lang/String;
    //   746: astore 9
    //   748: new 52	java/lang/StringBuilder
    //   751: dup
    //   752: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   755: astore 16
    //   757: aload 16
    //   759: aload 12
    //   761: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: pop
    //   765: aload 16
    //   767: ldc -44
    //   769: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   772: pop
    //   773: aload 16
    //   775: aload 8
    //   777: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   780: pop
    //   781: aload 16
    //   783: ldc -44
    //   785: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: pop
    //   789: aload 16
    //   791: aload 22
    //   793: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: pop
    //   797: ldc -42
    //   799: aload 9
    //   801: aload 18
    //   803: aload 7
    //   805: aload 16
    //   807: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   810: aconst_null
    //   811: invokestatic 219	com/tencent/bugly/crashreport/crash/b:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;)V
    //   814: aload 10
    //   816: invokestatic 222	com/tencent/bugly/proguard/z:b	(Ljava/lang/String;)V
    //   819: return
    //   820: aload_0
    //   821: aload 18
    //   823: aload 7
    //   825: lload_3
    //   826: ldc2_w 182
    //   829: lmul
    //   830: lload 5
    //   832: ladd
    //   833: aload 12
    //   835: aload 8
    //   837: aload 22
    //   839: aload 16
    //   841: aload 21
    //   843: aload 10
    //   845: aload 9
    //   847: aload 23
    //   849: aload 17
    //   851: aconst_null
    //   852: aconst_null
    //   853: iconst_1
    //   854: iload 19
    //   856: invokevirtual 226	com/tencent/bugly/crashreport/crash/jni/a:packageCrashDatas	(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BLjava/util/Map;ZZ)Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;
    //   859: astore 9
    //   861: aload 9
    //   863: ifnonnull +14 -> 877
    //   866: ldc -28
    //   868: iconst_0
    //   869: anewarray 4	java/lang/Object
    //   872: invokestatic 206	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   875: pop
    //   876: return
    //   877: invokestatic 210	com/tencent/bugly/proguard/z:a	()Ljava/lang/String;
    //   880: astore 10
    //   882: new 52	java/lang/StringBuilder
    //   885: dup
    //   886: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   889: astore 16
    //   891: aload 16
    //   893: aload 12
    //   895: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   898: pop
    //   899: aload 16
    //   901: ldc -44
    //   903: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   906: pop
    //   907: aload 16
    //   909: aload 8
    //   911: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   914: pop
    //   915: aload 16
    //   917: ldc -44
    //   919: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   922: pop
    //   923: aload 16
    //   925: aload 22
    //   927: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   930: pop
    //   931: ldc -42
    //   933: aload 10
    //   935: aload 18
    //   937: aload 7
    //   939: aload 16
    //   941: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   944: aload 9
    //   946: invokestatic 219	com/tencent/bugly/crashreport/crash/b:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;)V
    //   949: aload_0
    //   950: getfield 23	com/tencent/bugly/crashreport/crash/jni/a:b	Lcom/tencent/bugly/crashreport/crash/b;
    //   953: aload 9
    //   955: invokevirtual 231	com/tencent/bugly/crashreport/crash/b:b	(Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;)Z
    //   958: ifne +126 -> 1084
    //   961: iconst_1
    //   962: istore_1
    //   963: goto +3 -> 966
    //   966: aconst_null
    //   967: astore 7
    //   969: invokestatic 237	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:getInstance	()Lcom/tencent/bugly/crashreport/crash/jni/NativeCrashHandler;
    //   972: astore 8
    //   974: aload 8
    //   976: ifnull +10 -> 986
    //   979: aload 8
    //   981: invokevirtual 240	com/tencent/bugly/crashreport/crash/jni/NativeCrashHandler:getDumpFilePath	()Ljava/lang/String;
    //   984: astore 7
    //   986: iconst_1
    //   987: aload 7
    //   989: invokestatic 243	com/tencent/bugly/crashreport/crash/jni/b:a	(ZLjava/lang/String;)V
    //   992: iload_1
    //   993: ifeq +16 -> 1009
    //   996: aload_0
    //   997: getfield 23	com/tencent/bugly/crashreport/crash/jni/a:b	Lcom/tencent/bugly/crashreport/crash/b;
    //   1000: aload 9
    //   1002: ldc2_w 244
    //   1005: iconst_1
    //   1006: invokevirtual 248	com/tencent/bugly/crashreport/crash/b:a	(Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;JZ)V
    //   1009: aload_0
    //   1010: getfield 23	com/tencent/bugly/crashreport/crash/jni/a:b	Lcom/tencent/bugly/crashreport/crash/b;
    //   1013: aload 9
    //   1015: invokevirtual 251	com/tencent/bugly/crashreport/crash/b:c	(Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;)V
    //   1018: invokestatic 256	com/tencent/bugly/crashreport/crash/c:a	()Lcom/tencent/bugly/crashreport/crash/c;
    //   1021: invokevirtual 258	com/tencent/bugly/crashreport/crash/c:e	()V
    //   1024: return
    //   1025: astore 7
    //   1027: goto +10 -> 1037
    //   1030: astore 7
    //   1032: goto +5 -> 1037
    //   1035: astore 7
    //   1037: aload 7
    //   1039: invokestatic 261	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   1042: ifne +8 -> 1050
    //   1045: aload 7
    //   1047: invokevirtual 266	java/lang/Throwable:printStackTrace	()V
    //   1050: return
    //   1051: aload 12
    //   1053: astore 16
    //   1055: aload 9
    //   1057: astore 21
    //   1059: aload 7
    //   1061: astore 12
    //   1063: goto -902 -> 161
    //   1066: iload_1
    //   1067: iconst_1
    //   1068: iadd
    //   1069: istore_1
    //   1070: goto -893 -> 177
    //   1073: iconst_0
    //   1074: istore 19
    //   1076: goto -751 -> 325
    //   1079: iconst_0
    //   1080: istore_1
    //   1081: goto -548 -> 533
    //   1084: iconst_0
    //   1085: istore_1
    //   1086: goto -120 -> 966
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1089	0	this	a
    //   0	1089	1	paramInt1	int
    //   0	1089	2	paramInt2	int
    //   0	1089	3	paramLong1	long
    //   0	1089	5	paramLong2	long
    //   0	1089	7	paramString1	String
    //   0	1089	8	paramString2	String
    //   0	1089	9	paramString3	String
    //   0	1089	10	paramString4	String
    //   0	1089	11	paramInt3	int
    //   0	1089	12	paramString5	String
    //   0	1089	13	paramInt4	int
    //   0	1089	14	paramInt5	int
    //   0	1089	15	paramInt6	int
    //   0	1089	16	paramString6	String
    //   0	1089	17	paramString7	String
    //   0	1089	18	paramArrayOfString	String[]
    //   320	755	19	bool1	boolean
    //   716	3	20	bool2	boolean
    //   76	982	21	str1	String
    //   15	911	22	str2	String
    //   168	680	23	localObject1	Object
    //   440	82	24	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   949	961	1025	finally
    //   969	974	1025	finally
    //   979	986	1025	finally
    //   986	992	1025	finally
    //   996	1009	1025	finally
    //   1009	1024	1025	finally
    //   820	861	1030	finally
    //   866	876	1030	finally
    //   877	949	1030	finally
    //   10	17	1035	finally
    //   26	74	1035	finally
    //   90	97	1035	finally
    //   97	158	1035	finally
    //   161	170	1035	finally
    //   177	184	1035	finally
    //   195	249	1035	finally
    //   252	267	1035	finally
    //   270	280	1035	finally
    //   280	294	1035	finally
    //   299	319	1035	finally
    //   325	339	1035	finally
    //   344	352	1035	finally
    //   355	370	1035	finally
    //   373	382	1035	finally
    //   382	396	1035	finally
    //   401	409	1035	finally
    //   412	442	1035	finally
    //   442	528	1035	finally
    //   541	588	1035	finally
    //   591	650	1035	finally
    //   650	706	1035	finally
    //   706	718	1035	finally
    //   723	819	1035	finally
  }
  
  public final CrashDetailBean packageCrashDatas(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, byte[] paramArrayOfByte, Map<String, String> paramMap, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramBoolean2 = c.a().m();
    if (paramBoolean2) {
      x.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
    }
    CrashDetailBean localCrashDetailBean = new CrashDetailBean();
    localCrashDetailBean.b = 1;
    localCrashDetailBean.e = this.c.h();
    localCrashDetailBean.f = this.c.j;
    localCrashDetailBean.g = this.c.r();
    localCrashDetailBean.m = this.c.g();
    localCrashDetailBean.n = paramString3;
    String str = "";
    if (paramBoolean2) {
      paramString3 = " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]";
    } else {
      paramString3 = "";
    }
    localCrashDetailBean.o = paramString3;
    localCrashDetailBean.p = paramString4;
    if (paramString5 == null) {
      paramString5 = str;
    }
    localCrashDetailBean.q = paramString5;
    localCrashDetailBean.r = paramLong;
    localCrashDetailBean.u = z.a(localCrashDetailBean.q.getBytes());
    localCrashDetailBean.A = paramString1;
    localCrashDetailBean.B = paramString2;
    localCrashDetailBean.I = this.c.t();
    localCrashDetailBean.h = this.c.q();
    localCrashDetailBean.i = this.c.C();
    localCrashDetailBean.v = paramString8;
    paramString2 = NativeCrashHandler.getInstance();
    if (paramString2 != null) {
      paramString2 = paramString2.getDumpFilePath();
    } else {
      paramString2 = null;
    }
    paramString3 = b.a(paramString2, paramString8);
    if (!z.a(paramString3)) {
      localCrashDetailBean.V = paramString3;
    }
    localCrashDetailBean.W = b.b(paramString2);
    localCrashDetailBean.w = b.a(paramString9, c.e, null, false);
    localCrashDetailBean.x = b.a(paramString10, c.e, null, true);
    localCrashDetailBean.J = paramString7;
    localCrashDetailBean.K = paramString6;
    localCrashDetailBean.L = paramString11;
    localCrashDetailBean.F = this.c.l();
    localCrashDetailBean.G = this.c.k();
    localCrashDetailBean.H = this.c.m();
    if (paramBoolean1)
    {
      localCrashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.g();
      localCrashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.e();
      localCrashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.i();
      if (localCrashDetailBean.w == null) {
        localCrashDetailBean.w = z.a(this.a, c.e, null);
      }
      localCrashDetailBean.y = y.a();
      localCrashDetailBean.M = this.c.a;
      localCrashDetailBean.N = this.c.a();
      localCrashDetailBean.z = z.a(c.f, false);
      int i = localCrashDetailBean.q.indexOf("java:\n");
      if (i > 0)
      {
        i += 6;
        if (i < localCrashDetailBean.q.length())
        {
          paramString2 = localCrashDetailBean.q.substring(i, localCrashDetailBean.q.length() - 1);
          if ((paramString2.length() > 0) && (localCrashDetailBean.z.containsKey(localCrashDetailBean.B)))
          {
            paramString3 = (String)localCrashDetailBean.z.get(localCrashDetailBean.B);
            int j = paramString3.indexOf(paramString2);
            if (j > 0)
            {
              paramString2 = paramString3.substring(j);
              localCrashDetailBean.z.put(localCrashDetailBean.B, paramString2);
              localCrashDetailBean.q = localCrashDetailBean.q.substring(0, i);
              paramString3 = new StringBuilder();
              paramString3.append(localCrashDetailBean.q);
              paramString3.append(paramString2);
              localCrashDetailBean.q = paramString3.toString();
            }
          }
        }
      }
      if (paramString1 == null) {
        localCrashDetailBean.A = this.c.d;
      }
      this.b.d(localCrashDetailBean);
      localCrashDetailBean.Q = this.c.A();
      localCrashDetailBean.R = this.c.B();
      localCrashDetailBean.S = this.c.u();
      localCrashDetailBean.T = this.c.z();
      return localCrashDetailBean;
    }
    localCrashDetailBean.C = -1L;
    localCrashDetailBean.D = -1L;
    localCrashDetailBean.E = -1L;
    if (localCrashDetailBean.w == null) {
      localCrashDetailBean.w = "this crash is occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc.";
    }
    localCrashDetailBean.M = -1L;
    localCrashDetailBean.Q = -1;
    localCrashDetailBean.R = -1;
    localCrashDetailBean.S = paramMap;
    localCrashDetailBean.T = this.c.z();
    localCrashDetailBean.z = null;
    if (paramString1 == null) {
      localCrashDetailBean.A = "unknown(record)";
    }
    if (paramArrayOfByte != null) {
      localCrashDetailBean.y = paramArrayOfByte;
    }
    return localCrashDetailBean;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\crashreport\crash\jni\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */