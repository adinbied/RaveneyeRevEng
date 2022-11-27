package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ai;
import com.xiaomi.push.bc;
import com.xiaomi.push.hs;
import com.xiaomi.push.p;
import java.util.Arrays;

public class bg
{
  public static final Object a = new Object();
  
  public static void a(Context paramContext, hs paramhs)
  {
    if (!bf.a(paramhs.e())) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TinyData TinyDataStorage.cacheTinyData cache data to file begin item:");
    localStringBuilder.append(paramhs.d());
    localStringBuilder.append("  ts:");
    localStringBuilder.append(System.currentTimeMillis());
    b.a(localStringBuilder.toString());
    ai.a(paramContext).a(new bh(paramContext, paramhs));
  }
  
  public static byte[] a(Context paramContext)
  {
    String str2 = p.a(paramContext).a("mipush", "td_key", "");
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str1 = com.xiaomi.push.bf.a(20);
      p.a(paramContext).a("mipush", "td_key", str1);
    }
    return a(str1);
  }
  
  private static byte[] a(String paramString)
  {
    paramString = Arrays.copyOf(bc.a(paramString), 16);
    paramString[0] = 68;
    paramString[15] = 84;
    return paramString;
  }
  
  /* Error */
  private static void c(Context paramContext, hs paramhs)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 120	com/xiaomi/push/service/bg:a	(Landroid/content/Context;)[B
    //   4: astore_2
    //   5: aload_2
    //   6: aload_1
    //   7: invokestatic 125	com/xiaomi/push/iy:a	(Lcom/xiaomi/push/iz;)[B
    //   10: invokestatic 130	com/xiaomi/push/h:b	([B[B)[B
    //   13: astore_2
    //   14: aload_2
    //   15: ifnull +195 -> 210
    //   18: aload_2
    //   19: arraylength
    //   20: iconst_1
    //   21: if_icmpge +6 -> 27
    //   24: goto +186 -> 210
    //   27: aload_2
    //   28: arraylength
    //   29: sipush 10240
    //   32: if_icmple +60 -> 92
    //   35: new 28	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   42: astore_0
    //   43: aload_0
    //   44: ldc -124
    //   46: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 38	com/xiaomi/push/hs:d	()Ljava/lang/String;
    //   55: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload_0
    //   60: ldc 40
    //   62: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload_0
    //   67: invokestatic 46	java/lang/System:currentTimeMillis	()J
    //   70: invokevirtual 49	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload_0
    //   75: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: astore_0
    //   79: aload_0
    //   80: invokestatic 57	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;)V
    //   83: aconst_null
    //   84: invokestatic 137	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   87: aconst_null
    //   88: invokestatic 137	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   91: return
    //   92: new 139	java/io/BufferedOutputStream
    //   95: dup
    //   96: new 141	java/io/FileOutputStream
    //   99: dup
    //   100: new 143	java/io/File
    //   103: dup
    //   104: aload_0
    //   105: invokevirtual 149	android/content/Context:getFilesDir	()Ljava/io/File;
    //   108: ldc -105
    //   110: invokespecial 154	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   113: iconst_1
    //   114: invokespecial 157	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   117: invokespecial 160	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   120: astore_0
    //   121: aload_0
    //   122: aload_2
    //   123: arraylength
    //   124: invokestatic 165	com/xiaomi/push/ac:a	(I)[B
    //   127: invokevirtual 169	java/io/BufferedOutputStream:write	([B)V
    //   130: aload_0
    //   131: aload_2
    //   132: invokevirtual 169	java/io/BufferedOutputStream:write	([B)V
    //   135: aload_0
    //   136: invokevirtual 172	java/io/BufferedOutputStream:flush	()V
    //   139: new 28	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   146: astore_2
    //   147: aload_2
    //   148: ldc -82
    //   150: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload_2
    //   155: aload_1
    //   156: invokevirtual 38	com/xiaomi/push/hs:d	()Ljava/lang/String;
    //   159: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload_2
    //   164: ldc 40
    //   166: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload_2
    //   171: invokestatic 46	java/lang/System:currentTimeMillis	()J
    //   174: invokevirtual 49	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload_2
    //   179: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 57	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;)V
    //   185: aconst_null
    //   186: invokestatic 137	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   189: aload_0
    //   190: invokestatic 137	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   193: return
    //   194: astore_1
    //   195: goto +173 -> 368
    //   198: astore_3
    //   199: aload_0
    //   200: astore_2
    //   201: goto +65 -> 266
    //   204: astore_3
    //   205: aload_0
    //   206: astore_2
    //   207: goto +103 -> 310
    //   210: new 28	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   217: astore_0
    //   218: aload_0
    //   219: ldc -80
    //   221: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload_0
    //   226: aload_1
    //   227: invokevirtual 38	com/xiaomi/push/hs:d	()Ljava/lang/String;
    //   230: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload_0
    //   235: ldc 40
    //   237: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: aload_0
    //   242: invokestatic 46	java/lang/System:currentTimeMillis	()J
    //   245: invokevirtual 49	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload_0
    //   250: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: astore_0
    //   254: goto -175 -> 79
    //   257: astore_1
    //   258: aconst_null
    //   259: astore_0
    //   260: goto +108 -> 368
    //   263: astore_3
    //   264: aconst_null
    //   265: astore_2
    //   266: aload_2
    //   267: astore_0
    //   268: new 28	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   275: astore 4
    //   277: aload_2
    //   278: astore_0
    //   279: aload 4
    //   281: ldc -78
    //   283: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload_2
    //   288: astore_0
    //   289: aload 4
    //   291: aload_1
    //   292: invokevirtual 38	com/xiaomi/push/hs:d	()Ljava/lang/String;
    //   295: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload_2
    //   300: astore_0
    //   301: aload 4
    //   303: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: astore_1
    //   307: goto +44 -> 351
    //   310: aload_2
    //   311: astore_0
    //   312: new 28	java/lang/StringBuilder
    //   315: dup
    //   316: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   319: astore 4
    //   321: aload_2
    //   322: astore_0
    //   323: aload 4
    //   325: ldc -76
    //   327: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload_2
    //   332: astore_0
    //   333: aload 4
    //   335: aload_1
    //   336: invokevirtual 38	com/xiaomi/push/hs:d	()Ljava/lang/String;
    //   339: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: pop
    //   343: aload_2
    //   344: astore_0
    //   345: aload 4
    //   347: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: astore_1
    //   351: aload_2
    //   352: astore_0
    //   353: aload_1
    //   354: aload_3
    //   355: invokestatic 183	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   358: aconst_null
    //   359: invokestatic 137	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   362: aload_2
    //   363: invokestatic 137	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   366: return
    //   367: astore_1
    //   368: aconst_null
    //   369: invokestatic 137	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   372: aload_0
    //   373: invokestatic 137	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   376: aload_1
    //   377: athrow
    //   378: astore_3
    //   379: aconst_null
    //   380: astore_2
    //   381: goto -71 -> 310
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	384	0	paramContext	Context
    //   0	384	1	paramhs	hs
    //   4	377	2	localObject	Object
    //   198	1	3	localException1	Exception
    //   204	1	3	localIOException1	java.io.IOException
    //   263	92	3	localException2	Exception
    //   378	1	3	localIOException2	java.io.IOException
    //   275	71	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   121	185	194	finally
    //   121	185	198	java/lang/Exception
    //   121	185	204	java/io/IOException
    //   5	14	257	finally
    //   18	24	257	finally
    //   27	79	257	finally
    //   79	83	257	finally
    //   92	121	257	finally
    //   210	254	257	finally
    //   5	14	263	java/lang/Exception
    //   18	24	263	java/lang/Exception
    //   27	79	263	java/lang/Exception
    //   79	83	263	java/lang/Exception
    //   92	121	263	java/lang/Exception
    //   210	254	263	java/lang/Exception
    //   268	277	367	finally
    //   279	287	367	finally
    //   289	299	367	finally
    //   301	307	367	finally
    //   312	321	367	finally
    //   323	331	367	finally
    //   333	343	367	finally
    //   345	351	367	finally
    //   353	358	367	finally
    //   5	14	378	java/io/IOException
    //   18	24	378	java/io/IOException
    //   27	79	378	java/io/IOException
    //   79	83	378	java/io/IOException
    //   92	121	378	java/io/IOException
    //   210	254	378	java/io/IOException
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\service\bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */