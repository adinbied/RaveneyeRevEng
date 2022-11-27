package com.tencent.bugly.proguard;

import android.content.Context;
import java.util.Map;
import java.util.UUID;

public final class v
  implements Runnable
{
  private int a = 2;
  private int b = 30000;
  private final Context c;
  private final int d;
  private final byte[] e;
  private final com.tencent.bugly.crashreport.common.info.a f;
  private final com.tencent.bugly.crashreport.common.strategy.a g;
  private final s h;
  private final u i;
  private final int j;
  private final t k;
  private final t l;
  private String m = null;
  private final String n;
  private final Map<String, String> o;
  private int p = 0;
  private long q = 0L;
  private long r = 0L;
  private boolean s = false;
  
  public v(Context paramContext, int paramInt1, int paramInt2, byte[] paramArrayOfByte, String paramString1, String paramString2, t paramt, int paramInt3, int paramInt4, boolean paramBoolean, Map<String, String> paramMap)
  {
    this.c = paramContext;
    this.f = com.tencent.bugly.crashreport.common.info.a.a(paramContext);
    this.e = paramArrayOfByte;
    this.g = com.tencent.bugly.crashreport.common.strategy.a.a();
    this.h = s.a(paramContext);
    this.i = u.a();
    this.j = paramInt1;
    this.m = paramString1;
    this.n = paramString2;
    this.k = paramt;
    this.l = null;
    this.d = paramInt2;
    if (paramInt3 > 0) {
      this.a = paramInt3;
    }
    if (paramInt4 > 0) {
      this.b = paramInt4;
    }
    this.s = paramBoolean;
    this.o = paramMap;
  }
  
  public v(Context paramContext, int paramInt1, int paramInt2, byte[] paramArrayOfByte, String paramString1, String paramString2, t paramt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramContext, paramInt1, paramInt2, paramArrayOfByte, paramString1, paramString2, paramt, 2, 30000, paramBoolean2, null);
  }
  
  private static String a(String paramString)
  {
    if (z.a(paramString)) {
      return paramString;
    }
    try
    {
      String str = String.format("%s?aid=%s", new Object[] { paramString, UUID.randomUUID().toString() });
      return str;
    }
    finally
    {
      x.a(localThrowable);
    }
    return paramString;
  }
  
  private void a(an paraman, boolean paramBoolean, int paramInt, String paramString)
  {
    int i1 = this.d;
    if (i1 != 630)
    {
      if (i1 != 640)
      {
        if (i1 == 830) {
          break label53;
        }
        if (i1 != 840)
        {
          paraman = String.valueOf(i1);
          break label56;
        }
      }
      paraman = "userinfo";
      break label56;
    }
    label53:
    paraman = "crash";
    label56:
    if (paramBoolean) {
      x.a("[Upload] Success: %s", new Object[] { paraman });
    } else {
      x.e("[Upload] Failed to upload(%d) %s: %s", new Object[] { Integer.valueOf(paramInt), paraman, paramString });
    }
    if (this.q + this.r > 0L)
    {
      long l1 = this.i.a(this.s);
      long l2 = this.q;
      long l3 = this.r;
      this.i.a(l1 + l2 + l3, this.s);
    }
    paraman = this.k;
    if (paraman != null) {
      paraman.a(paramBoolean);
    }
    paraman = this.l;
    if (paraman != null) {
      paraman.a(paramBoolean);
    }
  }
  
  /* Error */
  private static boolean a(an paraman, com.tencent.bugly.crashreport.common.info.a parama, com.tencent.bugly.crashreport.common.strategy.a parama1)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +15 -> 16
    //   4: ldc -83
    //   6: iconst_0
    //   7: anewarray 4	java/lang/Object
    //   10: invokestatic 175	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   13: pop
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_0
    //   17: getfield 180	com/tencent/bugly/proguard/an:a	B
    //   20: ifeq +25 -> 45
    //   23: ldc -74
    //   25: iconst_1
    //   26: anewarray 4	java/lang/Object
    //   29: dup
    //   30: iconst_0
    //   31: aload_0
    //   32: getfield 180	com/tencent/bugly/proguard/an:a	B
    //   35: invokestatic 187	java/lang/Byte:valueOf	(B)Ljava/lang/Byte;
    //   38: aastore
    //   39: invokestatic 159	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   42: pop
    //   43: iconst_0
    //   44: ireturn
    //   45: aload_0
    //   46: getfield 189	com/tencent/bugly/proguard/an:e	Ljava/lang/String;
    //   49: invokestatic 113	com/tencent/bugly/proguard/z:a	(Ljava/lang/String;)Z
    //   52: ifne +59 -> 111
    //   55: invokestatic 192	com/tencent/bugly/crashreport/common/info/a:b	()Lcom/tencent/bugly/crashreport/common/info/a;
    //   58: invokevirtual 194	com/tencent/bugly/crashreport/common/info/a:j	()Ljava/lang/String;
    //   61: aload_0
    //   62: getfield 189	com/tencent/bugly/proguard/an:e	Ljava/lang/String;
    //   65: invokevirtual 198	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   68: ifne +43 -> 111
    //   71: invokestatic 203	com/tencent/bugly/proguard/p:a	()Lcom/tencent/bugly/proguard/p;
    //   74: getstatic 204	com/tencent/bugly/crashreport/common/strategy/a:a	I
    //   77: ldc -50
    //   79: aload_0
    //   80: getfield 189	com/tencent/bugly/proguard/an:e	Ljava/lang/String;
    //   83: ldc -48
    //   85: invokevirtual 212	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   88: aconst_null
    //   89: iconst_1
    //   90: invokevirtual 215	com/tencent/bugly/proguard/p:a	(ILjava/lang/String;[BLcom/tencent/bugly/proguard/o;Z)Z
    //   93: pop
    //   94: aload_1
    //   95: aload_0
    //   96: getfield 189	com/tencent/bugly/proguard/an:e	Ljava/lang/String;
    //   99: invokevirtual 218	com/tencent/bugly/crashreport/common/info/a:f	(Ljava/lang/String;)V
    //   102: goto +9 -> 111
    //   105: astore_3
    //   106: aload_3
    //   107: invokestatic 136	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   110: pop
    //   111: aload_1
    //   112: aload_0
    //   113: getfield 220	com/tencent/bugly/proguard/an:d	J
    //   116: putfield 222	com/tencent/bugly/crashreport/common/info/a:i	J
    //   119: aload_0
    //   120: getfield 223	com/tencent/bugly/proguard/an:b	I
    //   123: sipush 510
    //   126: if_icmpne +76 -> 202
    //   129: aload_0
    //   130: getfield 225	com/tencent/bugly/proguard/an:c	[B
    //   133: ifnonnull +25 -> 158
    //   136: ldc -29
    //   138: iconst_1
    //   139: anewarray 4	java/lang/Object
    //   142: dup
    //   143: iconst_0
    //   144: aload_0
    //   145: getfield 223	com/tencent/bugly/proguard/an:b	I
    //   148: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   151: aastore
    //   152: invokestatic 159	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   155: pop
    //   156: iconst_0
    //   157: ireturn
    //   158: aload_0
    //   159: getfield 225	com/tencent/bugly/proguard/an:c	[B
    //   162: ldc -27
    //   164: invokestatic 234	com/tencent/bugly/proguard/a:a	([BLjava/lang/Class;)Lcom/tencent/bugly/proguard/k;
    //   167: checkcast 229	com/tencent/bugly/proguard/ap
    //   170: astore_1
    //   171: aload_1
    //   172: ifnonnull +25 -> 197
    //   175: ldc -20
    //   177: iconst_1
    //   178: anewarray 4	java/lang/Object
    //   181: dup
    //   182: iconst_0
    //   183: aload_0
    //   184: getfield 223	com/tencent/bugly/proguard/an:b	I
    //   187: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   190: aastore
    //   191: invokestatic 159	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   194: pop
    //   195: iconst_0
    //   196: ireturn
    //   197: aload_2
    //   198: aload_1
    //   199: invokevirtual 239	com/tencent/bugly/crashreport/common/strategy/a:a	(Lcom/tencent/bugly/proguard/ap;)V
    //   202: iconst_1
    //   203: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	paraman	an
    //   0	204	1	parama	com.tencent.bugly.crashreport.common.info.a
    //   0	204	2	parama1	com.tencent.bugly.crashreport.common.strategy.a
    //   105	2	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   45	102	105	finally
  }
  
  public final void a(long paramLong)
  {
    this.p += 1;
    this.q += paramLong;
  }
  
  public final void b(long paramLong)
  {
    this.r += paramLong;
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc -13
    //   2: astore 7
    //   4: aload_0
    //   5: iconst_0
    //   6: putfield 51	com/tencent/bugly/proguard/v:p	I
    //   9: aload_0
    //   10: lconst_0
    //   11: putfield 53	com/tencent/bugly/proguard/v:q	J
    //   14: aload_0
    //   15: lconst_0
    //   16: putfield 55	com/tencent/bugly/proguard/v:r	J
    //   19: aload_0
    //   20: getfield 68	com/tencent/bugly/proguard/v:e	[B
    //   23: astore 8
    //   25: aload_0
    //   26: getfield 59	com/tencent/bugly/proguard/v:c	Landroid/content/Context;
    //   29: invokestatic 248	com/tencent/bugly/crashreport/common/info/b:b	(Landroid/content/Context;)Ljava/lang/String;
    //   32: ifnonnull +13 -> 45
    //   35: aload_0
    //   36: aconst_null
    //   37: iconst_0
    //   38: iconst_0
    //   39: ldc -6
    //   41: invokespecial 252	com/tencent/bugly/proguard/v:a	(Lcom/tencent/bugly/proguard/an;ZILjava/lang/String;)V
    //   44: return
    //   45: aload 8
    //   47: ifnull +1302 -> 1349
    //   50: aload 8
    //   52: arraylength
    //   53: ifne +6 -> 59
    //   56: goto +1293 -> 1349
    //   59: ldc -2
    //   61: iconst_1
    //   62: anewarray 4	java/lang/Object
    //   65: dup
    //   66: iconst_0
    //   67: aload_0
    //   68: getfield 99	com/tencent/bugly/proguard/v:d	I
    //   71: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   74: aastore
    //   75: invokestatic 256	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   78: pop
    //   79: aload_0
    //   80: getfield 59	com/tencent/bugly/proguard/v:c	Landroid/content/Context;
    //   83: ifnull +1255 -> 1338
    //   86: aload_0
    //   87: getfield 66	com/tencent/bugly/proguard/v:f	Lcom/tencent/bugly/crashreport/common/info/a;
    //   90: ifnull +1248 -> 1338
    //   93: aload_0
    //   94: getfield 75	com/tencent/bugly/proguard/v:g	Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   97: ifnull +1241 -> 1338
    //   100: aload_0
    //   101: getfield 82	com/tencent/bugly/proguard/v:h	Lcom/tencent/bugly/proguard/s;
    //   104: ifnonnull +6 -> 110
    //   107: goto +1231 -> 1338
    //   110: aload_0
    //   111: getfield 75	com/tencent/bugly/proguard/v:g	Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   114: invokevirtual 259	com/tencent/bugly/crashreport/common/strategy/a:c	()Lcom/tencent/bugly/crashreport/common/strategy/StrategyBean;
    //   117: astore 9
    //   119: aload 9
    //   121: ifnonnull +14 -> 135
    //   124: aload_0
    //   125: aconst_null
    //   126: iconst_0
    //   127: iconst_0
    //   128: ldc_w 261
    //   131: invokespecial 252	com/tencent/bugly/proguard/v:a	(Lcom/tencent/bugly/proguard/an;ZILjava/lang/String;)V
    //   134: return
    //   135: new 263	java/util/HashMap
    //   138: dup
    //   139: invokespecial 264	java/util/HashMap:<init>	()V
    //   142: astore 10
    //   144: aload 10
    //   146: ldc_w 266
    //   149: ldc_w 268
    //   152: invokeinterface 274 3 0
    //   157: pop
    //   158: aload 10
    //   160: ldc_w 276
    //   163: aload_0
    //   164: getfield 66	com/tencent/bugly/proguard/v:f	Lcom/tencent/bugly/crashreport/common/info/a;
    //   167: invokevirtual 278	com/tencent/bugly/crashreport/common/info/a:f	()Ljava/lang/String;
    //   170: invokeinterface 274 3 0
    //   175: pop
    //   176: aload 10
    //   178: ldc_w 280
    //   181: aload_0
    //   182: getfield 66	com/tencent/bugly/proguard/v:f	Lcom/tencent/bugly/crashreport/common/info/a;
    //   185: getfield 282	com/tencent/bugly/crashreport/common/info/a:c	Ljava/lang/String;
    //   188: invokeinterface 274 3 0
    //   193: pop
    //   194: aload 10
    //   196: ldc_w 284
    //   199: aload_0
    //   200: getfield 66	com/tencent/bugly/proguard/v:f	Lcom/tencent/bugly/crashreport/common/info/a;
    //   203: getfield 286	com/tencent/bugly/crashreport/common/info/a:j	Ljava/lang/String;
    //   206: invokeinterface 274 3 0
    //   211: pop
    //   212: aload_0
    //   213: getfield 101	com/tencent/bugly/proguard/v:o	Ljava/util/Map;
    //   216: ifnull +14 -> 230
    //   219: aload 10
    //   221: aload_0
    //   222: getfield 101	com/tencent/bugly/proguard/v:o	Ljava/util/Map;
    //   225: invokeinterface 290 2 0
    //   230: aload 10
    //   232: ldc_w 292
    //   235: aload_0
    //   236: getfield 99	com/tencent/bugly/proguard/v:d	I
    //   239: invokestatic 294	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   242: invokeinterface 274 3 0
    //   247: pop
    //   248: aload 10
    //   250: ldc_w 296
    //   253: iconst_1
    //   254: invokestatic 299	java/lang/Byte:toString	(B)Ljava/lang/String;
    //   257: invokeinterface 274 3 0
    //   262: pop
    //   263: aload 10
    //   265: ldc_w 301
    //   268: aload_0
    //   269: getfield 66	com/tencent/bugly/proguard/v:f	Lcom/tencent/bugly/crashreport/common/info/a;
    //   272: getfield 303	com/tencent/bugly/crashreport/common/info/a:f	Ljava/lang/String;
    //   275: invokeinterface 274 3 0
    //   280: pop
    //   281: aload 10
    //   283: ldc_w 305
    //   286: aload 9
    //   288: getfield 309	com/tencent/bugly/crashreport/common/strategy/StrategyBean:n	J
    //   291: invokestatic 314	java/lang/Long:toString	(J)Ljava/lang/String;
    //   294: invokeinterface 274 3 0
    //   299: pop
    //   300: iconst_2
    //   301: istore_2
    //   302: aload 8
    //   304: iconst_2
    //   305: invokestatic 317	com/tencent/bugly/proguard/z:a	([BI)[B
    //   308: astore 11
    //   310: aload 11
    //   312: ifnonnull +14 -> 326
    //   315: aload_0
    //   316: aconst_null
    //   317: iconst_0
    //   318: iconst_0
    //   319: ldc_w 319
    //   322: invokespecial 252	com/tencent/bugly/proguard/v:a	(Lcom/tencent/bugly/proguard/an;ZILjava/lang/String;)V
    //   325: return
    //   326: aload 11
    //   328: ifnonnull +14 -> 342
    //   331: aload_0
    //   332: aconst_null
    //   333: iconst_0
    //   334: iconst_0
    //   335: ldc_w 321
    //   338: invokespecial 252	com/tencent/bugly/proguard/v:a	(Lcom/tencent/bugly/proguard/an;ZILjava/lang/String;)V
    //   341: return
    //   342: aload_0
    //   343: getfield 89	com/tencent/bugly/proguard/v:i	Lcom/tencent/bugly/proguard/u;
    //   346: aload_0
    //   347: getfield 91	com/tencent/bugly/proguard/v:j	I
    //   350: invokestatic 327	java/lang/System:currentTimeMillis	()J
    //   353: invokevirtual 330	com/tencent/bugly/proguard/u:a	(IJ)V
    //   356: aload_0
    //   357: getfield 95	com/tencent/bugly/proguard/v:k	Lcom/tencent/bugly/proguard/t;
    //   360: astore 8
    //   362: aload_0
    //   363: getfield 97	com/tencent/bugly/proguard/v:l	Lcom/tencent/bugly/proguard/t;
    //   366: astore 8
    //   368: aload_0
    //   369: getfield 49	com/tencent/bugly/proguard/v:m	Ljava/lang/String;
    //   372: astore 8
    //   374: iconst_m1
    //   375: istore_1
    //   376: iconst_0
    //   377: istore_3
    //   378: iconst_0
    //   379: istore 4
    //   381: iload_3
    //   382: iconst_1
    //   383: iadd
    //   384: istore 5
    //   386: iload_3
    //   387: aload_0
    //   388: getfield 45	com/tencent/bugly/proguard/v:a	I
    //   391: if_icmpge +935 -> 1326
    //   394: aload 8
    //   396: astore 9
    //   398: iload 5
    //   400: iconst_1
    //   401: if_icmple +67 -> 468
    //   404: ldc_w 332
    //   407: iconst_1
    //   408: anewarray 4	java/lang/Object
    //   411: dup
    //   412: iconst_0
    //   413: iload 5
    //   415: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   418: aastore
    //   419: invokestatic 175	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   422: pop
    //   423: aload_0
    //   424: getfield 47	com/tencent/bugly/proguard/v:b	I
    //   427: i2l
    //   428: invokestatic 334	com/tencent/bugly/proguard/z:b	(J)V
    //   431: aload 8
    //   433: astore 9
    //   435: iload 5
    //   437: aload_0
    //   438: getfield 45	com/tencent/bugly/proguard/v:a	I
    //   441: if_icmpne +27 -> 468
    //   444: ldc_w 336
    //   447: iconst_1
    //   448: anewarray 4	java/lang/Object
    //   451: dup
    //   452: iconst_0
    //   453: aload_0
    //   454: getfield 93	com/tencent/bugly/proguard/v:n	Ljava/lang/String;
    //   457: aastore
    //   458: invokestatic 175	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   461: pop
    //   462: aload_0
    //   463: getfield 93	com/tencent/bugly/proguard/v:n	Ljava/lang/String;
    //   466: astore 9
    //   468: ldc_w 338
    //   471: iconst_1
    //   472: anewarray 4	java/lang/Object
    //   475: dup
    //   476: iconst_0
    //   477: aload 11
    //   479: arraylength
    //   480: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   483: aastore
    //   484: invokestatic 256	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   487: pop
    //   488: aload 9
    //   490: invokestatic 340	com/tencent/bugly/proguard/v:a	(Ljava/lang/String;)Ljava/lang/String;
    //   493: astore 8
    //   495: iconst_4
    //   496: anewarray 4	java/lang/Object
    //   499: astore 9
    //   501: aload 9
    //   503: iconst_0
    //   504: aload 8
    //   506: aastore
    //   507: aload 9
    //   509: iconst_1
    //   510: aload_0
    //   511: getfield 99	com/tencent/bugly/proguard/v:d	I
    //   514: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   517: aastore
    //   518: aload 9
    //   520: iload_2
    //   521: invokestatic 346	android/os/Process:myPid	()I
    //   524: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   527: aastore
    //   528: aload 9
    //   530: iconst_3
    //   531: invokestatic 349	android/os/Process:myTid	()I
    //   534: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   537: aastore
    //   538: ldc_w 351
    //   541: aload 9
    //   543: invokestatic 256	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   546: pop
    //   547: aload_0
    //   548: getfield 82	com/tencent/bugly/proguard/v:h	Lcom/tencent/bugly/proguard/s;
    //   551: aload 8
    //   553: aload 11
    //   555: aload_0
    //   556: aload 10
    //   558: invokevirtual 354	com/tencent/bugly/proguard/s:a	(Ljava/lang/String;[BLcom/tencent/bugly/proguard/v;Ljava/util/Map;)[B
    //   561: astore 9
    //   563: aload 9
    //   565: ifnonnull +36 -> 601
    //   568: iload_2
    //   569: anewarray 4	java/lang/Object
    //   572: astore 9
    //   574: aload 9
    //   576: iconst_0
    //   577: iconst_1
    //   578: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   581: aastore
    //   582: aload 9
    //   584: iconst_1
    //   585: ldc_w 356
    //   588: aastore
    //   589: ldc_w 358
    //   592: aload 9
    //   594: invokestatic 159	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   597: pop
    //   598: goto +788 -> 1386
    //   601: aload_0
    //   602: getfield 82	com/tencent/bugly/proguard/v:h	Lcom/tencent/bugly/proguard/s;
    //   605: getfield 360	com/tencent/bugly/proguard/s:a	Ljava/util/Map;
    //   608: astore 12
    //   610: aload 12
    //   612: ifnull +149 -> 761
    //   615: aload 12
    //   617: invokeinterface 363 1 0
    //   622: ifne +6 -> 628
    //   625: goto +136 -> 761
    //   628: aload 12
    //   630: ldc_w 365
    //   633: invokeinterface 368 2 0
    //   638: istore 6
    //   640: iload 6
    //   642: ifne +23 -> 665
    //   645: ldc_w 370
    //   648: iconst_1
    //   649: anewarray 4	java/lang/Object
    //   652: dup
    //   653: iconst_0
    //   654: ldc_w 365
    //   657: aastore
    //   658: invokestatic 175	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   661: pop
    //   662: goto +733 -> 1395
    //   665: aload 12
    //   667: aload 7
    //   669: invokeinterface 368 2 0
    //   674: ifne +22 -> 696
    //   677: ldc_w 370
    //   680: iconst_1
    //   681: anewarray 4	java/lang/Object
    //   684: dup
    //   685: iconst_0
    //   686: aload 7
    //   688: aastore
    //   689: invokestatic 175	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   692: pop
    //   693: goto +702 -> 1395
    //   696: aload 12
    //   698: aload 7
    //   700: invokeinterface 374 2 0
    //   705: checkcast 127	java/lang/String
    //   708: astore 13
    //   710: aload 13
    //   712: ldc_w 376
    //   715: invokevirtual 380	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   718: ifne +22 -> 740
    //   721: ldc_w 382
    //   724: iconst_1
    //   725: anewarray 4	java/lang/Object
    //   728: dup
    //   729: iconst_0
    //   730: aload 13
    //   732: aastore
    //   733: invokestatic 175	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   736: pop
    //   737: goto +658 -> 1395
    //   740: ldc_w 384
    //   743: iconst_1
    //   744: anewarray 4	java/lang/Object
    //   747: dup
    //   748: iconst_0
    //   749: aload 13
    //   751: aastore
    //   752: invokestatic 256	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   755: pop
    //   756: iconst_1
    //   757: istore_2
    //   758: goto +17 -> 775
    //   761: ldc_w 386
    //   764: iconst_0
    //   765: anewarray 4	java/lang/Object
    //   768: invokestatic 175	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   771: pop
    //   772: goto +623 -> 1395
    //   775: iload_2
    //   776: ifne +152 -> 928
    //   779: ldc_w 388
    //   782: iconst_2
    //   783: anewarray 4	java/lang/Object
    //   786: dup
    //   787: iconst_0
    //   788: invokestatic 346	android/os/Process:myPid	()I
    //   791: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   794: aastore
    //   795: dup
    //   796: iconst_1
    //   797: invokestatic 349	android/os/Process:myTid	()I
    //   800: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   803: aastore
    //   804: invokestatic 256	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   807: pop
    //   808: ldc_w 358
    //   811: iconst_2
    //   812: anewarray 4	java/lang/Object
    //   815: dup
    //   816: iconst_0
    //   817: iconst_1
    //   818: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   821: aastore
    //   822: dup
    //   823: iconst_1
    //   824: ldc_w 390
    //   827: aastore
    //   828: invokestatic 159	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   831: pop
    //   832: aload 12
    //   834: ifnull +80 -> 914
    //   837: aload 12
    //   839: invokeinterface 394 1 0
    //   844: invokeinterface 400 1 0
    //   849: astore 9
    //   851: aload 9
    //   853: invokeinterface 406 1 0
    //   858: ifeq +56 -> 914
    //   861: aload 9
    //   863: invokeinterface 410 1 0
    //   868: checkcast 412	java/util/Map$Entry
    //   871: astore 12
    //   873: ldc_w 414
    //   876: iconst_2
    //   877: anewarray 4	java/lang/Object
    //   880: dup
    //   881: iconst_0
    //   882: aload 12
    //   884: invokeinterface 417 1 0
    //   889: aastore
    //   890: dup
    //   891: iconst_1
    //   892: aload 12
    //   894: invokeinterface 420 1 0
    //   899: aastore
    //   900: invokestatic 131	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   903: iconst_0
    //   904: anewarray 4	java/lang/Object
    //   907: invokestatic 256	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   910: pop
    //   911: goto -60 -> 851
    //   914: ldc_w 390
    //   917: iconst_0
    //   918: anewarray 4	java/lang/Object
    //   921: invokestatic 256	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   924: pop
    //   925: goto +480 -> 1405
    //   928: aload 12
    //   930: ldc_w 365
    //   933: invokeinterface 374 2 0
    //   938: checkcast 127	java/lang/String
    //   941: invokestatic 424	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   944: istore_2
    //   945: ldc_w 426
    //   948: iconst_3
    //   949: anewarray 4	java/lang/Object
    //   952: dup
    //   953: iconst_0
    //   954: iload_2
    //   955: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   958: aastore
    //   959: dup
    //   960: iconst_1
    //   961: invokestatic 346	android/os/Process:myPid	()I
    //   964: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   967: aastore
    //   968: dup
    //   969: iconst_2
    //   970: invokestatic 349	android/os/Process:myTid	()I
    //   973: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   976: aastore
    //   977: invokestatic 256	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   980: pop
    //   981: iload_2
    //   982: ifeq +35 -> 1017
    //   985: new 428	java/lang/StringBuilder
    //   988: dup
    //   989: ldc_w 430
    //   992: invokespecial 432	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   995: astore 7
    //   997: aload 7
    //   999: iload_2
    //   1000: invokevirtual 436	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1003: pop
    //   1004: aload_0
    //   1005: aconst_null
    //   1006: iconst_0
    //   1007: iconst_1
    //   1008: aload 7
    //   1010: invokevirtual 437	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1013: invokespecial 252	com/tencent/bugly/proguard/v:a	(Lcom/tencent/bugly/proguard/an;ZILjava/lang/String;)V
    //   1016: return
    //   1017: ldc_w 439
    //   1020: iconst_1
    //   1021: anewarray 4	java/lang/Object
    //   1024: dup
    //   1025: iconst_0
    //   1026: aload 9
    //   1028: arraylength
    //   1029: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1032: aastore
    //   1033: invokestatic 256	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1036: pop
    //   1037: aload 9
    //   1039: arraylength
    //   1040: ifne +84 -> 1124
    //   1043: aload 12
    //   1045: invokeinterface 394 1 0
    //   1050: invokeinterface 400 1 0
    //   1055: astore 7
    //   1057: aload 7
    //   1059: invokeinterface 406 1 0
    //   1064: ifeq +49 -> 1113
    //   1067: aload 7
    //   1069: invokeinterface 410 1 0
    //   1074: checkcast 412	java/util/Map$Entry
    //   1077: astore 8
    //   1079: ldc_w 441
    //   1082: iconst_2
    //   1083: anewarray 4	java/lang/Object
    //   1086: dup
    //   1087: iconst_0
    //   1088: aload 8
    //   1090: invokeinterface 417 1 0
    //   1095: aastore
    //   1096: dup
    //   1097: iconst_1
    //   1098: aload 8
    //   1100: invokeinterface 420 1 0
    //   1105: aastore
    //   1106: invokestatic 256	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1109: pop
    //   1110: goto -53 -> 1057
    //   1113: aload_0
    //   1114: aconst_null
    //   1115: iconst_0
    //   1116: iconst_1
    //   1117: ldc_w 443
    //   1120: invokespecial 252	com/tencent/bugly/proguard/v:a	(Lcom/tencent/bugly/proguard/an;ZILjava/lang/String;)V
    //   1123: return
    //   1124: aload 9
    //   1126: ifnonnull +14 -> 1140
    //   1129: aload_0
    //   1130: aconst_null
    //   1131: iconst_0
    //   1132: iconst_1
    //   1133: ldc_w 445
    //   1136: invokespecial 252	com/tencent/bugly/proguard/v:a	(Lcom/tencent/bugly/proguard/an;ZILjava/lang/String;)V
    //   1139: return
    //   1140: aload 9
    //   1142: iconst_2
    //   1143: invokestatic 447	com/tencent/bugly/proguard/z:b	([BI)[B
    //   1146: astore 8
    //   1148: aload 9
    //   1150: astore 7
    //   1152: aload 8
    //   1154: ifnull +7 -> 1161
    //   1157: aload 8
    //   1159: astore 7
    //   1161: aload 7
    //   1163: invokestatic 450	com/tencent/bugly/proguard/a:b	([B)Lcom/tencent/bugly/proguard/an;
    //   1166: astore 7
    //   1168: aload 7
    //   1170: ifnonnull +14 -> 1184
    //   1173: aload_0
    //   1174: aconst_null
    //   1175: iconst_0
    //   1176: iconst_1
    //   1177: ldc_w 452
    //   1180: invokespecial 252	com/tencent/bugly/proguard/v:a	(Lcom/tencent/bugly/proguard/an;ZILjava/lang/String;)V
    //   1183: return
    //   1184: aload 7
    //   1186: getfield 223	com/tencent/bugly/proguard/an:b	I
    //   1189: istore_2
    //   1190: aload 7
    //   1192: getfield 225	com/tencent/bugly/proguard/an:c	[B
    //   1195: ifnonnull +8 -> 1203
    //   1198: iconst_0
    //   1199: istore_1
    //   1200: goto +10 -> 1210
    //   1203: aload 7
    //   1205: getfield 225	com/tencent/bugly/proguard/an:c	[B
    //   1208: arraylength
    //   1209: istore_1
    //   1210: ldc_w 454
    //   1213: iconst_2
    //   1214: anewarray 4	java/lang/Object
    //   1217: dup
    //   1218: iconst_0
    //   1219: iload_2
    //   1220: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1223: aastore
    //   1224: dup
    //   1225: iconst_1
    //   1226: iload_1
    //   1227: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1230: aastore
    //   1231: invokestatic 256	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1234: pop
    //   1235: aload 7
    //   1237: aload_0
    //   1238: getfield 66	com/tencent/bugly/proguard/v:f	Lcom/tencent/bugly/crashreport/common/info/a;
    //   1241: aload_0
    //   1242: getfield 75	com/tencent/bugly/proguard/v:g	Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   1245: invokestatic 456	com/tencent/bugly/proguard/v:a	(Lcom/tencent/bugly/proguard/an;Lcom/tencent/bugly/crashreport/common/info/a;Lcom/tencent/bugly/crashreport/common/strategy/a;)Z
    //   1248: ifne +15 -> 1263
    //   1251: aload_0
    //   1252: aload 7
    //   1254: iconst_0
    //   1255: iconst_2
    //   1256: ldc_w 458
    //   1259: invokespecial 252	com/tencent/bugly/proguard/v:a	(Lcom/tencent/bugly/proguard/an;ZILjava/lang/String;)V
    //   1262: return
    //   1263: aload_0
    //   1264: aload 7
    //   1266: iconst_1
    //   1267: iconst_2
    //   1268: ldc_w 460
    //   1271: invokespecial 252	com/tencent/bugly/proguard/v:a	(Lcom/tencent/bugly/proguard/an;ZILjava/lang/String;)V
    //   1274: return
    //   1275: new 428	java/lang/StringBuilder
    //   1278: dup
    //   1279: ldc_w 462
    //   1282: invokespecial 432	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1285: astore 9
    //   1287: aload 9
    //   1289: iload_1
    //   1290: invokestatic 294	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   1293: invokevirtual 465	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1296: pop
    //   1297: ldc_w 358
    //   1300: iconst_2
    //   1301: anewarray 4	java/lang/Object
    //   1304: dup
    //   1305: iconst_0
    //   1306: iconst_1
    //   1307: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1310: aastore
    //   1311: dup
    //   1312: iconst_1
    //   1313: aload 9
    //   1315: invokevirtual 437	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1318: aastore
    //   1319: invokestatic 159	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1322: pop
    //   1323: goto +82 -> 1405
    //   1326: aload_0
    //   1327: aconst_null
    //   1328: iconst_0
    //   1329: iload 4
    //   1331: ldc_w 467
    //   1334: invokespecial 252	com/tencent/bugly/proguard/v:a	(Lcom/tencent/bugly/proguard/an;ZILjava/lang/String;)V
    //   1337: return
    //   1338: aload_0
    //   1339: aconst_null
    //   1340: iconst_0
    //   1341: iconst_0
    //   1342: ldc_w 469
    //   1345: invokespecial 252	com/tencent/bugly/proguard/v:a	(Lcom/tencent/bugly/proguard/an;ZILjava/lang/String;)V
    //   1348: return
    //   1349: aload_0
    //   1350: aconst_null
    //   1351: iconst_0
    //   1352: iconst_0
    //   1353: ldc_w 471
    //   1356: invokespecial 252	com/tencent/bugly/proguard/v:a	(Lcom/tencent/bugly/proguard/an;ZILjava/lang/String;)V
    //   1359: return
    //   1360: astore 7
    //   1362: aload 7
    //   1364: invokestatic 136	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   1367: ifne +8 -> 1375
    //   1370: aload 7
    //   1372: invokevirtual 476	java/lang/Throwable:printStackTrace	()V
    //   1375: return
    //   1376: astore 9
    //   1378: goto -103 -> 1275
    //   1381: astore 9
    //   1383: goto +17 -> 1400
    //   1386: iload 5
    //   1388: istore_3
    //   1389: iconst_1
    //   1390: istore 4
    //   1392: goto -1011 -> 381
    //   1395: iconst_0
    //   1396: istore_2
    //   1397: goto -622 -> 775
    //   1400: iload_2
    //   1401: istore_1
    //   1402: goto -127 -> 1275
    //   1405: iconst_2
    //   1406: istore_2
    //   1407: goto -21 -> 1386
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1410	0	this	v
    //   375	1027	1	i1	int
    //   301	1106	2	i2	int
    //   377	1012	3	i3	int
    //   379	1012	4	i4	int
    //   384	1003	5	i5	int
    //   638	3	6	bool	boolean
    //   2	1263	7	localObject1	Object
    //   1360	11	7	localThrowable	Throwable
    //   23	1135	8	localObject2	Object
    //   117	1197	9	localObject3	Object
    //   1376	1	9	localObject4	Object
    //   1381	1	9	localObject5	Object
    //   142	415	10	localHashMap	java.util.HashMap
    //   308	246	11	arrayOfByte	byte[]
    //   608	436	12	localObject6	Object
    //   708	42	13	str	String
    // Exception table:
    //   from	to	target	type
    //   4	44	1360	finally
    //   50	56	1360	finally
    //   59	107	1360	finally
    //   110	119	1360	finally
    //   124	134	1360	finally
    //   135	230	1360	finally
    //   230	300	1360	finally
    //   302	310	1360	finally
    //   315	325	1360	finally
    //   331	341	1360	finally
    //   342	374	1360	finally
    //   386	394	1360	finally
    //   404	431	1360	finally
    //   435	468	1360	finally
    //   468	501	1360	finally
    //   507	563	1360	finally
    //   568	582	1360	finally
    //   589	598	1360	finally
    //   601	610	1360	finally
    //   615	625	1360	finally
    //   628	640	1360	finally
    //   645	662	1360	finally
    //   665	693	1360	finally
    //   696	737	1360	finally
    //   740	756	1360	finally
    //   761	772	1360	finally
    //   779	832	1360	finally
    //   837	851	1360	finally
    //   851	911	1360	finally
    //   914	925	1360	finally
    //   985	1016	1360	finally
    //   1017	1057	1360	finally
    //   1057	1110	1360	finally
    //   1113	1123	1360	finally
    //   1129	1139	1360	finally
    //   1140	1148	1360	finally
    //   1161	1168	1360	finally
    //   1173	1183	1360	finally
    //   1184	1198	1360	finally
    //   1203	1210	1360	finally
    //   1210	1262	1360	finally
    //   1263	1274	1360	finally
    //   1275	1323	1360	finally
    //   1326	1337	1360	finally
    //   1338	1348	1360	finally
    //   1349	1359	1360	finally
    //   928	945	1376	finally
    //   945	981	1381	finally
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\proguard\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */