package com.tencent.bugly.crashreport.crash;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.bugly.BuglyStrategy.a;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.ah;
import com.tencent.bugly.proguard.aj;
import com.tencent.bugly.proguard.ak;
import com.tencent.bugly.proguard.al;
import com.tencent.bugly.proguard.am;
import com.tencent.bugly.proguard.k;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.t;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class b
{
  private static int a;
  private Context b;
  private u c;
  private p d;
  private com.tencent.bugly.crashreport.common.strategy.a e;
  private o f;
  private BuglyStrategy.a g;
  
  public b(int paramInt, Context paramContext, u paramu, p paramp, com.tencent.bugly.crashreport.common.strategy.a parama, BuglyStrategy.a parama1, o paramo)
  {
    a = paramInt;
    this.b = paramContext;
    this.c = paramu;
    this.d = paramp;
    this.e = parama;
    this.g = parama1;
    this.f = paramo;
  }
  
  private static CrashDetailBean a(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return null;
    }
    try
    {
      byte[] arrayOfByte = paramCursor.getBlob(paramCursor.getColumnIndex("_dt"));
      if (arrayOfByte == null) {
        return null;
      }
      long l = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
      paramCursor = (CrashDetailBean)z.a(arrayOfByte, CrashDetailBean.CREATOR);
      if (paramCursor != null) {
        paramCursor.a = l;
      }
      return paramCursor;
    }
    finally
    {
      if (!x.a(paramCursor)) {
        paramCursor.printStackTrace();
      }
    }
    return null;
  }
  
  private CrashDetailBean a(List<a> paramList, CrashDetailBean paramCrashDetailBean)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return paramCrashDetailBean;
      }
      Object localObject3 = null;
      Object localObject1 = null;
      Object localObject4 = new ArrayList(10);
      Object localObject2 = paramList.iterator();
      Object localObject5;
      while (((Iterator)localObject2).hasNext())
      {
        localObject5 = (a)((Iterator)localObject2).next();
        if (((a)localObject5).e) {
          ((List)localObject4).add(localObject5);
        }
      }
      localObject2 = localObject3;
      if (((List)localObject4).size() > 0)
      {
        localObject4 = b((List)localObject4);
        localObject2 = localObject3;
        if (localObject4 != null)
        {
          localObject2 = localObject3;
          if (((List)localObject4).size() > 0)
          {
            Collections.sort((List)localObject4);
            int i = 0;
            for (;;)
            {
              localObject2 = localObject1;
              if (i >= ((List)localObject4).size()) {
                break;
              }
              localObject3 = (CrashDetailBean)((List)localObject4).get(i);
              if (i == 0)
              {
                localObject2 = localObject3;
              }
              else
              {
                localObject2 = localObject1;
                if (((CrashDetailBean)localObject3).s != null)
                {
                  localObject3 = ((CrashDetailBean)localObject3).s.split("\n");
                  localObject2 = localObject1;
                  if (localObject3 != null)
                  {
                    int k = localObject3.length;
                    int j = 0;
                    for (;;)
                    {
                      localObject2 = localObject1;
                      if (j >= k) {
                        break;
                      }
                      localObject2 = localObject3[j];
                      localObject5 = ((CrashDetailBean)localObject1).s;
                      StringBuilder localStringBuilder = new StringBuilder();
                      localStringBuilder.append((String)localObject2);
                      if (!((String)localObject5).contains(localStringBuilder.toString()))
                      {
                        ((CrashDetailBean)localObject1).t += 1;
                        localObject5 = new StringBuilder();
                        ((StringBuilder)localObject5).append(((CrashDetailBean)localObject1).s);
                        ((StringBuilder)localObject5).append((String)localObject2);
                        ((StringBuilder)localObject5).append("\n");
                        ((CrashDetailBean)localObject1).s = ((StringBuilder)localObject5).toString();
                      }
                      j += 1;
                    }
                  }
                }
              }
              i += 1;
              localObject1 = localObject2;
            }
          }
        }
      }
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        paramCrashDetailBean.j = true;
        paramCrashDetailBean.t = 0;
        paramCrashDetailBean.s = "";
        localObject1 = paramCrashDetailBean;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject2 = (a)paramList.next();
        if ((!((a)localObject2).e) && (!((a)localObject2).d))
        {
          localObject3 = ((CrashDetailBean)localObject1).s;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(((a)localObject2).b);
          if (!((String)localObject3).contains(((StringBuilder)localObject4).toString()))
          {
            ((CrashDetailBean)localObject1).t += 1;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(((CrashDetailBean)localObject1).s);
            ((StringBuilder)localObject3).append(((a)localObject2).b);
            ((StringBuilder)localObject3).append("\n");
            ((CrashDetailBean)localObject1).s = ((StringBuilder)localObject3).toString();
          }
        }
      }
      if (((CrashDetailBean)localObject1).r != paramCrashDetailBean.r)
      {
        paramList = ((CrashDetailBean)localObject1).s;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramCrashDetailBean.r);
        if (!paramList.contains(((StringBuilder)localObject2).toString()))
        {
          ((CrashDetailBean)localObject1).t += 1;
          paramList = new StringBuilder();
          paramList.append(((CrashDetailBean)localObject1).s);
          paramList.append(paramCrashDetailBean.r);
          paramList.append("\n");
          ((CrashDetailBean)localObject1).s = paramList.toString();
        }
      }
      return (CrashDetailBean)localObject1;
    }
    return paramCrashDetailBean;
  }
  
  /* Error */
  private static aj a(String paramString1, Context paramContext, String paramString2)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +317 -> 318
    //   4: aload_1
    //   5: ifnonnull +6 -> 11
    //   8: goto +310 -> 318
    //   11: ldc -72
    //   13: iconst_1
    //   14: anewarray 4	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_2
    //   20: aastore
    //   21: invokestatic 187	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   24: pop
    //   25: new 189	java/io/File
    //   28: dup
    //   29: aload_2
    //   30: invokespecial 192	java/io/File:<init>	(Ljava/lang/String;)V
    //   33: astore 4
    //   35: new 189	java/io/File
    //   38: dup
    //   39: aload_1
    //   40: invokevirtual 198	android/content/Context:getCacheDir	()Ljava/io/File;
    //   43: aload_0
    //   44: invokespecial 201	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   47: astore_2
    //   48: aload 4
    //   50: aload_2
    //   51: sipush 5000
    //   54: invokestatic 204	com/tencent/bugly/proguard/z:a	(Ljava/io/File;Ljava/io/File;I)Z
    //   57: ifne +15 -> 72
    //   60: ldc -50
    //   62: iconst_0
    //   63: anewarray 4	java/lang/Object
    //   66: invokestatic 208	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   69: pop
    //   70: aconst_null
    //   71: areturn
    //   72: new 210	java/io/ByteArrayOutputStream
    //   75: dup
    //   76: invokespecial 211	java/io/ByteArrayOutputStream:<init>	()V
    //   79: astore_1
    //   80: new 213	java/io/FileInputStream
    //   83: dup
    //   84: aload_2
    //   85: invokespecial 216	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   88: astore_0
    //   89: sipush 4096
    //   92: newarray <illegal type>
    //   94: astore 4
    //   96: aload_0
    //   97: aload 4
    //   99: invokevirtual 220	java/io/FileInputStream:read	([B)I
    //   102: istore_3
    //   103: iload_3
    //   104: ifle +18 -> 122
    //   107: aload_1
    //   108: aload 4
    //   110: iconst_0
    //   111: iload_3
    //   112: invokevirtual 224	java/io/ByteArrayOutputStream:write	([BII)V
    //   115: aload_1
    //   116: invokevirtual 227	java/io/ByteArrayOutputStream:flush	()V
    //   119: goto -23 -> 96
    //   122: aload_1
    //   123: invokevirtual 231	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   126: astore_1
    //   127: ldc -23
    //   129: iconst_1
    //   130: anewarray 4	java/lang/Object
    //   133: dup
    //   134: iconst_0
    //   135: aload_1
    //   136: arraylength
    //   137: invokestatic 239	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   140: aastore
    //   141: invokestatic 187	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   144: pop
    //   145: new 241	com/tencent/bugly/proguard/aj
    //   148: dup
    //   149: iconst_2
    //   150: aload_2
    //   151: invokevirtual 244	java/io/File:getName	()Ljava/lang/String;
    //   154: aload_1
    //   155: invokespecial 247	com/tencent/bugly/proguard/aj:<init>	(BLjava/lang/String;[B)V
    //   158: astore_1
    //   159: aload_0
    //   160: invokevirtual 250	java/io/FileInputStream:close	()V
    //   163: goto +15 -> 178
    //   166: astore_0
    //   167: aload_0
    //   168: invokestatic 79	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   171: ifne +7 -> 178
    //   174: aload_0
    //   175: invokevirtual 251	java/io/IOException:printStackTrace	()V
    //   178: aload_2
    //   179: invokevirtual 254	java/io/File:exists	()Z
    //   182: ifeq +19 -> 201
    //   185: ldc_w 256
    //   188: iconst_0
    //   189: anewarray 4	java/lang/Object
    //   192: invokestatic 187	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   195: pop
    //   196: aload_2
    //   197: invokevirtual 259	java/io/File:delete	()Z
    //   200: pop
    //   201: aload_1
    //   202: areturn
    //   203: astore_1
    //   204: goto +6 -> 210
    //   207: astore_1
    //   208: aconst_null
    //   209: astore_0
    //   210: aload_1
    //   211: invokestatic 79	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   214: ifne +7 -> 221
    //   217: aload_1
    //   218: invokevirtual 84	java/lang/Throwable:printStackTrace	()V
    //   221: aload_0
    //   222: ifnull +22 -> 244
    //   225: aload_0
    //   226: invokevirtual 250	java/io/FileInputStream:close	()V
    //   229: goto +15 -> 244
    //   232: astore_0
    //   233: aload_0
    //   234: invokestatic 79	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   237: ifne +7 -> 244
    //   240: aload_0
    //   241: invokevirtual 251	java/io/IOException:printStackTrace	()V
    //   244: aload_2
    //   245: invokevirtual 254	java/io/File:exists	()Z
    //   248: ifeq +19 -> 267
    //   251: ldc_w 256
    //   254: iconst_0
    //   255: anewarray 4	java/lang/Object
    //   258: invokestatic 187	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   261: pop
    //   262: aload_2
    //   263: invokevirtual 259	java/io/File:delete	()Z
    //   266: pop
    //   267: aconst_null
    //   268: areturn
    //   269: astore_1
    //   270: aload_0
    //   271: ifnull +22 -> 293
    //   274: aload_0
    //   275: invokevirtual 250	java/io/FileInputStream:close	()V
    //   278: goto +15 -> 293
    //   281: astore_0
    //   282: aload_0
    //   283: invokestatic 79	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   286: ifne +7 -> 293
    //   289: aload_0
    //   290: invokevirtual 251	java/io/IOException:printStackTrace	()V
    //   293: aload_2
    //   294: invokevirtual 254	java/io/File:exists	()Z
    //   297: ifeq +19 -> 316
    //   300: ldc_w 256
    //   303: iconst_0
    //   304: anewarray 4	java/lang/Object
    //   307: invokestatic 187	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   310: pop
    //   311: aload_2
    //   312: invokevirtual 259	java/io/File:delete	()Z
    //   315: pop
    //   316: aload_1
    //   317: athrow
    //   318: ldc_w 261
    //   321: iconst_0
    //   322: anewarray 4	java/lang/Object
    //   325: invokestatic 208	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   328: pop
    //   329: aconst_null
    //   330: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	331	0	paramString1	String
    //   0	331	1	paramContext	Context
    //   0	331	2	paramString2	String
    //   102	10	3	i	int
    //   33	76	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   159	163	166	java/io/IOException
    //   89	96	203	finally
    //   96	103	203	finally
    //   107	119	203	finally
    //   122	159	203	finally
    //   80	89	207	finally
    //   225	229	232	java/io/IOException
    //   210	221	269	finally
    //   274	278	281	java/io/IOException
  }
  
  private static ak a(Context paramContext, CrashDetailBean paramCrashDetailBean, com.tencent.bugly.crashreport.common.info.a parama)
  {
    boolean bool1 = false;
    if ((paramContext != null) && (paramCrashDetailBean != null) && (parama != null))
    {
      ak localak = new ak();
      Object localObject1;
      switch (paramCrashDetailBean.b)
      {
      default: 
        x.e("crash type error! %d", new Object[] { Integer.valueOf(paramCrashDetailBean.b) });
        break;
      case 7: 
        if (paramCrashDetailBean.j) {
          localObject1 = "208";
        } else {
          localObject1 = "108";
        }
        localak.a = ((String)localObject1);
        break;
      case 6: 
        if (paramCrashDetailBean.j) {
          localObject1 = "206";
        } else {
          localObject1 = "106";
        }
        localak.a = ((String)localObject1);
        break;
      case 5: 
        if (paramCrashDetailBean.j) {
          localObject1 = "207";
        } else {
          localObject1 = "107";
        }
        localak.a = ((String)localObject1);
        break;
      case 4: 
        if (paramCrashDetailBean.j) {
          localObject1 = "204";
        } else {
          localObject1 = "104";
        }
        localak.a = ((String)localObject1);
        break;
      case 3: 
        if (paramCrashDetailBean.j) {
          localObject1 = "203";
        } else {
          localObject1 = "103";
        }
        localak.a = ((String)localObject1);
        break;
      case 2: 
        if (paramCrashDetailBean.j) {
          localObject1 = "202";
        } else {
          localObject1 = "102";
        }
        localak.a = ((String)localObject1);
        break;
      case 1: 
        if (paramCrashDetailBean.j) {
          localObject1 = "201";
        } else {
          localObject1 = "101";
        }
        localak.a = ((String)localObject1);
        break;
      case 0: 
        if (paramCrashDetailBean.j) {
          localObject1 = "200";
        } else {
          localObject1 = "100";
        }
        localak.a = ((String)localObject1);
      }
      localak.b = paramCrashDetailBean.r;
      localak.c = paramCrashDetailBean.n;
      localak.d = paramCrashDetailBean.o;
      localak.e = paramCrashDetailBean.p;
      localak.g = paramCrashDetailBean.q;
      localak.h = paramCrashDetailBean.z;
      localak.i = paramCrashDetailBean.c;
      localak.j = null;
      localak.l = paramCrashDetailBean.m;
      localak.m = paramCrashDetailBean.e;
      localak.f = paramCrashDetailBean.B;
      localak.n = null;
      x.c("libInfo %s", new Object[] { localak.o });
      Object localObject4;
      Object localObject5;
      if ((paramCrashDetailBean.h != null) && (paramCrashDetailBean.h.size() > 0))
      {
        localak.p = new ArrayList();
        localObject1 = paramCrashDetailBean.h.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject4 = (Map.Entry)((Iterator)localObject1).next();
          localObject5 = new ah();
          ((ah)localObject5).a = ((PlugInBean)((Map.Entry)localObject4).getValue()).a;
          ((ah)localObject5).b = ((PlugInBean)((Map.Entry)localObject4).getValue()).c;
          ((ah)localObject5).c = ((PlugInBean)((Map.Entry)localObject4).getValue()).b;
          localak.p.add(localObject5);
        }
      }
      if (paramCrashDetailBean.j)
      {
        localak.k = paramCrashDetailBean.t;
        if ((paramCrashDetailBean.s != null) && (paramCrashDetailBean.s.length() > 0))
        {
          if (localak.q == null) {
            localak.q = new ArrayList();
          }
          try
          {
            localak.q.add(new aj((byte)1, "alltimes.txt", paramCrashDetailBean.s.getBytes("utf-8")));
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException1)
          {
            localUnsupportedEncodingException1.printStackTrace();
            localak.q = null;
          }
        }
        int j = localak.k;
        int i;
        if (localak.q != null) {
          i = localak.q.size();
        } else {
          i = 0;
        }
        x.c("crashcount:%d sz:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      }
      if (paramCrashDetailBean.w != null)
      {
        if (localak.q == null) {
          localak.q = new ArrayList();
        }
        try
        {
          localak.q.add(new aj((byte)1, "log.txt", paramCrashDetailBean.w.getBytes("utf-8")));
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException2)
        {
          localUnsupportedEncodingException2.printStackTrace();
          localak.q = null;
        }
      }
      if (paramCrashDetailBean.x != null)
      {
        if (localak.q == null) {
          localak.q = new ArrayList();
        }
        try
        {
          localak.q.add(new aj((byte)1, "jniLog.txt", paramCrashDetailBean.x.getBytes("utf-8")));
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException3)
        {
          localUnsupportedEncodingException3.printStackTrace();
          localak.q = null;
        }
      }
      Object localObject2;
      if (!z.a(paramCrashDetailBean.V))
      {
        if (localak.q == null) {
          localak.q = new ArrayList();
        }
        try
        {
          aj localaj = new aj((byte)1, "crashInfos.txt", paramCrashDetailBean.V.getBytes("utf-8"));
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException4)
        {
          localUnsupportedEncodingException4.printStackTrace();
          localObject2 = null;
        }
        if (localObject2 != null)
        {
          x.c("attach crash infos", new Object[0]);
          localak.q.add(localObject2);
        }
      }
      if (paramCrashDetailBean.W != null)
      {
        if (localak.q == null) {
          localak.q = new ArrayList();
        }
        localObject2 = a("backupRecord.zip", paramContext, paramCrashDetailBean.W);
        if (localObject2 != null)
        {
          x.c("attach backup record", new Object[0]);
          localak.q.add(localObject2);
        }
      }
      if ((paramCrashDetailBean.y != null) && (paramCrashDetailBean.y.length > 0))
      {
        localObject2 = new aj((byte)2, "buglylog.zip", paramCrashDetailBean.y);
        x.c("attach user log", new Object[0]);
        if (localak.q == null) {
          localak.q = new ArrayList();
        }
        localak.q.add(localObject2);
      }
      if (paramCrashDetailBean.b == 3)
      {
        if (localak.q == null) {
          localak.q = new ArrayList();
        }
        x.c("crashBean.anrMessages:%s", new Object[] { paramCrashDetailBean.P });
        if ((paramCrashDetailBean.P != null) && (paramCrashDetailBean.P.containsKey("BUGLY_CR_01")))
        {
          try
          {
            if (!TextUtils.isEmpty((CharSequence)paramCrashDetailBean.P.get("BUGLY_CR_01")))
            {
              localak.q.add(new aj((byte)1, "anrMessage.txt", ((String)paramCrashDetailBean.P.get("BUGLY_CR_01")).getBytes("utf-8")));
              x.c("attach anr message", new Object[0]);
            }
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException5)
          {
            localUnsupportedEncodingException5.printStackTrace();
            localak.q = null;
          }
          paramCrashDetailBean.P.remove("BUGLY_CR_01");
        }
        if ((paramCrashDetailBean.v != null) && (NativeCrashHandler.getInstance().isEnableCatchAnrTrace()))
        {
          localObject3 = a("trace.zip", paramContext, paramCrashDetailBean.v);
          if (localObject3 != null)
          {
            x.c("attach traces", new Object[0]);
            localak.q.add(localObject3);
          }
        }
      }
      if (paramCrashDetailBean.b == 1)
      {
        if (localak.q == null) {
          localak.q = new ArrayList();
        }
        if (paramCrashDetailBean.v != null)
        {
          paramContext = a("tomb.zip", paramContext, paramCrashDetailBean.v);
          if (paramContext != null)
          {
            x.c("attach tombs", new Object[0]);
            localak.q.add(paramContext);
          }
        }
      }
      if ((parama.C != null) && (!parama.C.isEmpty()))
      {
        if (localak.q == null) {
          localak.q = new ArrayList();
        }
        paramContext = new StringBuilder();
        localObject3 = parama.C.iterator();
        while (((Iterator)localObject3).hasNext()) {
          paramContext.append((String)((Iterator)localObject3).next());
        }
        try
        {
          localak.q.add(new aj((byte)1, "martianlog.txt", paramContext.toString().getBytes("utf-8")));
          x.c("attach pageTracingList", new Object[0]);
        }
        catch (UnsupportedEncodingException paramContext)
        {
          paramContext.printStackTrace();
        }
      }
      if ((paramCrashDetailBean.U != null) && (paramCrashDetailBean.U.length > 0))
      {
        if (localak.q == null) {
          localak.q = new ArrayList();
        }
        localak.q.add(new aj((byte)1, "userExtraByteData", paramCrashDetailBean.U));
        x.c("attach extraData", new Object[0]);
      }
      localak.r = new HashMap();
      paramContext = localak.r;
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramCrashDetailBean.C);
      paramContext.put("A9", ((StringBuilder)localObject3).toString());
      paramContext = localak.r;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramCrashDetailBean.D);
      paramContext.put("A11", ((StringBuilder)localObject3).toString());
      paramContext = localak.r;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramCrashDetailBean.E);
      paramContext.put("A10", ((StringBuilder)localObject3).toString());
      paramContext = localak.r;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramCrashDetailBean.f);
      paramContext.put("A23", ((StringBuilder)localObject3).toString());
      paramContext = localak.r;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(parama.g);
      paramContext.put("A7", ((StringBuilder)localObject3).toString());
      paramContext = localak.r;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(parama.o());
      paramContext.put("A6", ((StringBuilder)localObject3).toString());
      paramContext = localak.r;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(parama.n());
      paramContext.put("A5", ((StringBuilder)localObject3).toString());
      paramContext = localak.r;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(parama.h());
      paramContext.put("A22", ((StringBuilder)localObject3).toString());
      paramContext = localak.r;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramCrashDetailBean.G);
      paramContext.put("A2", ((StringBuilder)localObject3).toString());
      paramContext = localak.r;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramCrashDetailBean.F);
      paramContext.put("A1", ((StringBuilder)localObject3).toString());
      paramContext = localak.r;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(parama.h);
      paramContext.put("A24", ((StringBuilder)localObject3).toString());
      paramContext = localak.r;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramCrashDetailBean.H);
      paramContext.put("A17", ((StringBuilder)localObject3).toString());
      paramContext = localak.r;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(parama.h());
      paramContext.put("A25", ((StringBuilder)localObject3).toString());
      paramContext = localak.r;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(parama.r());
      paramContext.put("A15", ((StringBuilder)localObject3).toString());
      paramContext = localak.r;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(parama.s());
      paramContext.put("A13", ((StringBuilder)localObject3).toString());
      paramContext = localak.r;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramCrashDetailBean.A);
      paramContext.put("A34", ((StringBuilder)localObject3).toString());
      if (parama.x != null)
      {
        paramContext = localak.r;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(parama.x);
        paramContext.put("productIdentify", ((StringBuilder)localObject3).toString());
      }
      try
      {
        paramContext = localak.r;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(URLEncoder.encode(paramCrashDetailBean.I, "utf-8"));
        paramContext.put("A26", ((StringBuilder)localObject3).toString());
      }
      catch (UnsupportedEncodingException paramContext)
      {
        paramContext.printStackTrace();
      }
      if (paramCrashDetailBean.b == 1)
      {
        paramContext = localak.r;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(paramCrashDetailBean.K);
        paramContext.put("A27", ((StringBuilder)localObject3).toString());
        paramContext = localak.r;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(paramCrashDetailBean.J);
        paramContext.put("A28", ((StringBuilder)localObject3).toString());
        paramContext = localak.r;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(paramCrashDetailBean.k);
        paramContext.put("A29", ((StringBuilder)localObject3).toString());
      }
      paramContext = localak.r;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramCrashDetailBean.L);
      paramContext.put("A30", ((StringBuilder)localObject3).toString());
      paramContext = localak.r;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramCrashDetailBean.M);
      paramContext.put("A18", ((StringBuilder)localObject3).toString());
      paramContext = localak.r;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramCrashDetailBean.N ^ true);
      paramContext.put("A36", ((StringBuilder)localObject3).toString());
      paramContext = localak.r;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(parama.q);
      paramContext.put("F02", ((StringBuilder)localObject3).toString());
      paramContext = localak.r;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(parama.r);
      paramContext.put("F03", ((StringBuilder)localObject3).toString());
      paramContext = localak.r;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(parama.e());
      paramContext.put("F04", ((StringBuilder)localObject3).toString());
      paramContext = localak.r;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(parama.s);
      paramContext.put("F05", ((StringBuilder)localObject3).toString());
      paramContext = localak.r;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(parama.p);
      paramContext.put("F06", ((StringBuilder)localObject3).toString());
      paramContext = localak.r;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(parama.v);
      paramContext.put("F08", ((StringBuilder)localObject3).toString());
      paramContext = localak.r;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(parama.w);
      paramContext.put("F09", ((StringBuilder)localObject3).toString());
      paramContext = localak.r;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(parama.t);
      paramContext.put("F10", ((StringBuilder)localObject3).toString());
      if (paramCrashDetailBean.Q >= 0)
      {
        paramContext = localak.r;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(paramCrashDetailBean.Q);
        paramContext.put("C01", ((StringBuilder)localObject3).toString());
      }
      if (paramCrashDetailBean.R >= 0)
      {
        paramContext = localak.r;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(paramCrashDetailBean.R);
        paramContext.put("C02", ((StringBuilder)localObject3).toString());
      }
      if ((paramCrashDetailBean.S != null) && (paramCrashDetailBean.S.size() > 0))
      {
        paramContext = paramCrashDetailBean.S.entrySet().iterator();
        while (paramContext.hasNext())
        {
          localObject3 = (Map.Entry)paramContext.next();
          localObject4 = localak.r;
          localObject5 = new StringBuilder("C03_");
          ((StringBuilder)localObject5).append((String)((Map.Entry)localObject3).getKey());
          ((Map)localObject4).put(((StringBuilder)localObject5).toString(), ((Map.Entry)localObject3).getValue());
        }
      }
      if ((paramCrashDetailBean.T != null) && (paramCrashDetailBean.T.size() > 0))
      {
        paramContext = paramCrashDetailBean.T.entrySet().iterator();
        while (paramContext.hasNext())
        {
          localObject3 = (Map.Entry)paramContext.next();
          localObject4 = localak.r;
          localObject5 = new StringBuilder("C04_");
          ((StringBuilder)localObject5).append((String)((Map.Entry)localObject3).getKey());
          ((Map)localObject4).put(((StringBuilder)localObject5).toString(), ((Map.Entry)localObject3).getValue());
        }
      }
      localak.s = null;
      if ((paramCrashDetailBean.O != null) && (paramCrashDetailBean.O.size() > 0))
      {
        localak.s = paramCrashDetailBean.O;
        x.a("setted message size %d", new Object[] { Integer.valueOf(localak.s.size()) });
      }
      paramContext = paramCrashDetailBean.n;
      localObject3 = paramCrashDetailBean.c;
      parama = parama.e();
      long l = (paramCrashDetailBean.r - paramCrashDetailBean.M) / 1000L;
      boolean bool2 = paramCrashDetailBean.k;
      boolean bool3 = paramCrashDetailBean.N;
      boolean bool4 = paramCrashDetailBean.j;
      if (paramCrashDetailBean.b == 1) {
        bool1 = true;
      }
      x.c("%s rid:%s sess:%s ls:%ds isR:%b isF:%b isM:%b isN:%b mc:%d ,%s ,isUp:%b ,vm:%d", new Object[] { paramContext, localObject3, parama, Long.valueOf(l), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool1), Integer.valueOf(paramCrashDetailBean.t), paramCrashDetailBean.s, Boolean.valueOf(paramCrashDetailBean.d), Integer.valueOf(localak.r.size()) });
      return localak;
    }
    x.d("enExp args == null", new Object[0]);
    return null;
  }
  
  private static List<a> a(List<a> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      long l = System.currentTimeMillis();
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        a locala = (a)paramList.next();
        if ((locala.d) && (locala.b <= l - 86400000L)) {
          localArrayList.add(locala);
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, CrashDetailBean paramCrashDetailBean)
  {
    com.tencent.bugly.crashreport.common.info.a locala = com.tencent.bugly.crashreport.common.info.a.b();
    if (locala == null) {
      return;
    }
    x.e("#++++++++++Record By Bugly++++++++++#", new Object[0]);
    x.e("# You can use Bugly(http:\\\\bugly.qq.com) to get more Crash Detail!", new Object[0]);
    x.e("# PKG NAME: %s", new Object[] { locala.c });
    x.e("# APP VER: %s", new Object[] { locala.j });
    x.e("# SDK VER: %s", new Object[] { locala.f });
    x.e("# LAUNCH TIME: %s", new Object[] { z.a(new Date(com.tencent.bugly.crashreport.common.info.a.b().a)) });
    x.e("# CRASH TYPE: %s", new Object[] { paramString1 });
    x.e("# CRASH TIME: %s", new Object[] { paramString2 });
    x.e("# CRASH PROCESS: %s", new Object[] { paramString3 });
    x.e("# CRASH THREAD: %s", new Object[] { paramString4 });
    if (paramCrashDetailBean != null)
    {
      x.e("# REPORT ID: %s", new Object[] { paramCrashDetailBean.c });
      paramString2 = locala.i();
      if (locala.s().booleanValue()) {
        paramString1 = "ROOTED";
      } else {
        paramString1 = "UNROOT";
      }
      x.e("# CRASH DEVICE: %s %s", new Object[] { paramString2, paramString1 });
      x.e("# RUNTIME AVAIL RAM:%d ROM:%d SD:%d", new Object[] { Long.valueOf(paramCrashDetailBean.C), Long.valueOf(paramCrashDetailBean.D), Long.valueOf(paramCrashDetailBean.E) });
      x.e("# RUNTIME TOTAL RAM:%d ROM:%d SD:%d", new Object[] { Long.valueOf(paramCrashDetailBean.F), Long.valueOf(paramCrashDetailBean.G), Long.valueOf(paramCrashDetailBean.H) });
      if (!z.a(paramCrashDetailBean.K))
      {
        x.e("# EXCEPTION FIRED BY %s %s", new Object[] { paramCrashDetailBean.K, paramCrashDetailBean.J });
      }
      else if (paramCrashDetailBean.b == 3)
      {
        if (paramCrashDetailBean.P == null)
        {
          paramString1 = "null";
        }
        else
        {
          paramString1 = new StringBuilder();
          paramString1.append((String)paramCrashDetailBean.P.get("BUGLY_CR_01"));
          paramString1 = paramString1.toString();
        }
        x.e("# EXCEPTION ANR MESSAGE:\n %s", new Object[] { paramString1 });
      }
    }
    if (!z.a(paramString5))
    {
      x.e("# CRASH STACK: ", new Object[0]);
      x.e(paramString5, new Object[0]);
    }
    x.e("#++++++++++++++++++++++++++++++++++++++++++#", new Object[0]);
  }
  
  public static void a(boolean paramBoolean, List<CrashDetailBean> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      x.c("up finish update state %b", new Object[] { Boolean.valueOf(paramBoolean) });
      Iterator localIterator = paramList.iterator();
      CrashDetailBean localCrashDetailBean;
      while (localIterator.hasNext())
      {
        localCrashDetailBean = (CrashDetailBean)localIterator.next();
        x.c("pre uid:%s uc:%d re:%b me:%b", new Object[] { localCrashDetailBean.c, Integer.valueOf(localCrashDetailBean.l), Boolean.valueOf(localCrashDetailBean.d), Boolean.valueOf(localCrashDetailBean.j) });
        localCrashDetailBean.l += 1;
        localCrashDetailBean.d = paramBoolean;
        x.c("set uid:%s uc:%d re:%b me:%b", new Object[] { localCrashDetailBean.c, Integer.valueOf(localCrashDetailBean.l), Boolean.valueOf(localCrashDetailBean.d), Boolean.valueOf(localCrashDetailBean.j) });
      }
      localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        localCrashDetailBean = (CrashDetailBean)localIterator.next();
        c.a().a(localCrashDetailBean);
      }
      x.c("update state size %d", new Object[] { Integer.valueOf(paramList.size()) });
    }
    if (!paramBoolean) {
      x.b("[crash] upload fail.", new Object[0]);
    }
  }
  
  private static a b(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        a locala = new a();
        locala.a = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
        locala.b = paramCursor.getLong(paramCursor.getColumnIndex("_tm"));
        locala.c = paramCursor.getString(paramCursor.getColumnIndex("_s1"));
        int i = paramCursor.getInt(paramCursor.getColumnIndex("_up"));
        boolean bool2 = false;
        if (i == 1)
        {
          bool1 = true;
          locala.d = bool1;
          bool1 = bool2;
          if (paramCursor.getInt(paramCursor.getColumnIndex("_me")) == 1) {
            bool1 = true;
          }
          locala.e = bool1;
          locala.f = paramCursor.getInt(paramCursor.getColumnIndex("_uc"));
          return locala;
        }
      }
      finally
      {
        if (!x.a(paramCursor)) {
          paramCursor.printStackTrace();
        }
        return null;
      }
      boolean bool1 = false;
    }
  }
  
  /* Error */
  private List<a> b()
  {
    // Byte code:
    //   0: new 93	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 368	java/util/ArrayList:<init>	()V
    //   7: astore 6
    //   9: aconst_null
    //   10: astore_3
    //   11: invokestatic 849	com/tencent/bugly/proguard/p:a	()Lcom/tencent/bugly/proguard/p;
    //   14: ldc_w 851
    //   17: bipush 6
    //   19: anewarray 140	java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: ldc 56
    //   26: aastore
    //   27: dup
    //   28: iconst_1
    //   29: ldc_w 824
    //   32: aastore
    //   33: dup
    //   34: iconst_2
    //   35: ldc_w 826
    //   38: aastore
    //   39: dup
    //   40: iconst_3
    //   41: ldc_w 833
    //   44: aastore
    //   45: dup
    //   46: iconst_4
    //   47: ldc_w 839
    //   50: aastore
    //   51: dup
    //   52: iconst_5
    //   53: ldc_w 841
    //   56: aastore
    //   57: aconst_null
    //   58: aconst_null
    //   59: aconst_null
    //   60: iconst_1
    //   61: invokevirtual 854	com/tencent/bugly/proguard/p:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/bugly/proguard/o;Z)Landroid/database/Cursor;
    //   64: astore 4
    //   66: aload 4
    //   68: ifnonnull +17 -> 85
    //   71: aload 4
    //   73: ifnull +10 -> 83
    //   76: aload 4
    //   78: invokeinterface 855 1 0
    //   83: aconst_null
    //   84: areturn
    //   85: aload 4
    //   87: invokeinterface 858 1 0
    //   92: istore_1
    //   93: iload_1
    //   94: ifgt +18 -> 112
    //   97: aload 4
    //   99: ifnull +10 -> 109
    //   102: aload 4
    //   104: invokeinterface 855 1 0
    //   109: aload 6
    //   111: areturn
    //   112: new 146	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   119: astore 5
    //   121: aload 5
    //   123: ldc_w 860
    //   126: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload 5
    //   132: ldc_w 862
    //   135: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: iconst_0
    //   140: istore_1
    //   141: aload 4
    //   143: invokeinterface 865 1 0
    //   148: istore_2
    //   149: iload_2
    //   150: ifeq +77 -> 227
    //   153: aload 4
    //   155: invokestatic 867	com/tencent/bugly/crashreport/crash/b:b	(Landroid/database/Cursor;)Lcom/tencent/bugly/crashreport/crash/a;
    //   158: astore_3
    //   159: aload_3
    //   160: ifnull +15 -> 175
    //   163: aload 6
    //   165: aload_3
    //   166: invokeinterface 119 2 0
    //   171: pop
    //   172: goto -31 -> 141
    //   175: aload 5
    //   177: aload 4
    //   179: aload 4
    //   181: ldc 56
    //   183: invokeinterface 50 2 0
    //   188: invokeinterface 60 2 0
    //   193: invokevirtual 174	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload 5
    //   199: ldc_w 869
    //   202: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: iload_1
    //   207: iconst_1
    //   208: iadd
    //   209: istore_1
    //   210: goto -69 -> 141
    //   213: ldc_w 871
    //   216: iconst_0
    //   217: anewarray 4	java/lang/Object
    //   220: invokestatic 208	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   223: pop
    //   224: goto -83 -> 141
    //   227: aload 5
    //   229: astore_3
    //   230: aload 5
    //   232: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: ldc_w 869
    //   238: invokevirtual 159	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   241: ifeq +25 -> 266
    //   244: new 146	java/lang/StringBuilder
    //   247: dup
    //   248: aload 5
    //   250: iconst_0
    //   251: aload 5
    //   253: ldc_w 869
    //   256: invokevirtual 874	java/lang/StringBuilder:lastIndexOf	(Ljava/lang/String;)I
    //   259: invokevirtual 878	java/lang/StringBuilder:substring	(II)Ljava/lang/String;
    //   262: invokespecial 688	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   265: astore_3
    //   266: aload_3
    //   267: ldc_w 880
    //   270: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload_3
    //   275: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: astore 5
    //   280: aload_3
    //   281: iconst_0
    //   282: invokevirtual 883	java/lang/StringBuilder:setLength	(I)V
    //   285: iload_1
    //   286: ifle +40 -> 326
    //   289: ldc_w 885
    //   292: iconst_2
    //   293: anewarray 4	java/lang/Object
    //   296: dup
    //   297: iconst_0
    //   298: ldc_w 851
    //   301: aastore
    //   302: dup
    //   303: iconst_1
    //   304: invokestatic 849	com/tencent/bugly/proguard/p:a	()Lcom/tencent/bugly/proguard/p;
    //   307: ldc_w 851
    //   310: aload 5
    //   312: aconst_null
    //   313: aconst_null
    //   314: iconst_1
    //   315: invokevirtual 888	com/tencent/bugly/proguard/p:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/bugly/proguard/o;Z)I
    //   318: invokestatic 239	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   321: aastore
    //   322: invokestatic 208	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   325: pop
    //   326: aload 4
    //   328: ifnull +10 -> 338
    //   331: aload 4
    //   333: invokeinterface 855 1 0
    //   338: aload 6
    //   340: areturn
    //   341: astore 5
    //   343: aload 4
    //   345: astore_3
    //   346: aload 5
    //   348: astore 4
    //   350: goto +5 -> 355
    //   353: astore 4
    //   355: aload 4
    //   357: invokestatic 79	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   360: ifne +8 -> 368
    //   363: aload 4
    //   365: invokevirtual 84	java/lang/Throwable:printStackTrace	()V
    //   368: aload_3
    //   369: ifnull +9 -> 378
    //   372: aload_3
    //   373: invokeinterface 855 1 0
    //   378: aload 6
    //   380: areturn
    //   381: astore 4
    //   383: aload_3
    //   384: ifnull +9 -> 393
    //   387: aload_3
    //   388: invokeinterface 855 1 0
    //   393: aload 4
    //   395: athrow
    //   396: astore_3
    //   397: goto -184 -> 213
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	400	0	this	b
    //   92	194	1	i	int
    //   148	2	2	bool	boolean
    //   10	378	3	localObject1	Object
    //   396	1	3	localObject2	Object
    //   64	285	4	localObject3	Object
    //   353	11	4	localThrowable	Throwable
    //   381	13	4	localObject4	Object
    //   119	192	5	localObject5	Object
    //   341	6	5	localObject6	Object
    //   7	372	6	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   85	93	341	finally
    //   112	139	341	finally
    //   141	149	341	finally
    //   153	159	341	finally
    //   163	172	341	finally
    //   213	224	341	finally
    //   230	266	341	finally
    //   266	285	341	finally
    //   289	326	341	finally
    //   11	66	353	finally
    //   355	368	381	finally
    //   175	206	396	finally
  }
  
  /* Error */
  private List<CrashDetailBean> b(List<a> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +428 -> 429
    //   4: aload_1
    //   5: invokeinterface 91 1 0
    //   10: ifne +5 -> 15
    //   13: aconst_null
    //   14: areturn
    //   15: new 146	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   22: astore_3
    //   23: aload_3
    //   24: ldc_w 860
    //   27: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload_3
    //   32: ldc_w 862
    //   35: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload_1
    //   40: invokeinterface 100 1 0
    //   45: astore_1
    //   46: aload_1
    //   47: invokeinterface 106 1 0
    //   52: ifeq +31 -> 83
    //   55: aload_3
    //   56: aload_1
    //   57: invokeinterface 110 1 0
    //   62: checkcast 112	com/tencent/bugly/crashreport/crash/a
    //   65: getfield 822	com/tencent/bugly/crashreport/crash/a:a	J
    //   68: invokevirtual 174	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload_3
    //   73: ldc_w 869
    //   76: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: goto -34 -> 46
    //   83: aload_3
    //   84: astore_1
    //   85: aload_3
    //   86: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: ldc_w 869
    //   92: invokevirtual 159	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   95: ifeq +23 -> 118
    //   98: new 146	java/lang/StringBuilder
    //   101: dup
    //   102: aload_3
    //   103: iconst_0
    //   104: aload_3
    //   105: ldc_w 869
    //   108: invokevirtual 874	java/lang/StringBuilder:lastIndexOf	(Ljava/lang/String;)I
    //   111: invokevirtual 878	java/lang/StringBuilder:substring	(II)Ljava/lang/String;
    //   114: invokespecial 688	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   117: astore_1
    //   118: aload_1
    //   119: ldc_w 880
    //   122: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload_1
    //   127: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: astore_3
    //   131: aload_1
    //   132: iconst_0
    //   133: invokevirtual 883	java/lang/StringBuilder:setLength	(I)V
    //   136: invokestatic 849	com/tencent/bugly/proguard/p:a	()Lcom/tencent/bugly/proguard/p;
    //   139: ldc_w 851
    //   142: aconst_null
    //   143: aload_3
    //   144: aconst_null
    //   145: aconst_null
    //   146: iconst_1
    //   147: invokevirtual 854	com/tencent/bugly/proguard/p:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/bugly/proguard/o;Z)Landroid/database/Cursor;
    //   150: astore 4
    //   152: aload 4
    //   154: ifnonnull +17 -> 171
    //   157: aload 4
    //   159: ifnull +10 -> 169
    //   162: aload 4
    //   164: invokeinterface 855 1 0
    //   169: aconst_null
    //   170: areturn
    //   171: new 93	java/util/ArrayList
    //   174: dup
    //   175: invokespecial 368	java/util/ArrayList:<init>	()V
    //   178: astore 5
    //   180: aload_1
    //   181: ldc_w 860
    //   184: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload_1
    //   189: ldc_w 862
    //   192: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: iconst_0
    //   197: istore_2
    //   198: aload 4
    //   200: invokeinterface 865 1 0
    //   205: ifeq +75 -> 280
    //   208: aload 4
    //   210: invokestatic 891	com/tencent/bugly/crashreport/crash/b:a	(Landroid/database/Cursor;)Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;
    //   213: astore_3
    //   214: aload_3
    //   215: ifnull +15 -> 230
    //   218: aload 5
    //   220: aload_3
    //   221: invokeinterface 119 2 0
    //   226: pop
    //   227: goto -29 -> 198
    //   230: aload_1
    //   231: aload 4
    //   233: aload 4
    //   235: ldc 56
    //   237: invokeinterface 50 2 0
    //   242: invokeinterface 60 2 0
    //   247: invokevirtual 174	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload_1
    //   252: ldc_w 869
    //   255: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: iload_2
    //   260: iconst_1
    //   261: iadd
    //   262: istore_2
    //   263: goto -65 -> 198
    //   266: ldc_w 871
    //   269: iconst_0
    //   270: anewarray 4	java/lang/Object
    //   273: invokestatic 208	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   276: pop
    //   277: goto -79 -> 198
    //   280: aload_1
    //   281: astore_3
    //   282: aload_1
    //   283: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: ldc_w 869
    //   289: invokevirtual 159	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   292: ifeq +23 -> 315
    //   295: new 146	java/lang/StringBuilder
    //   298: dup
    //   299: aload_1
    //   300: iconst_0
    //   301: aload_1
    //   302: ldc_w 869
    //   305: invokevirtual 874	java/lang/StringBuilder:lastIndexOf	(Ljava/lang/String;)I
    //   308: invokevirtual 878	java/lang/StringBuilder:substring	(II)Ljava/lang/String;
    //   311: invokespecial 688	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   314: astore_3
    //   315: aload_3
    //   316: ldc_w 880
    //   319: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload_3
    //   324: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: astore_1
    //   328: iload_2
    //   329: ifle +39 -> 368
    //   332: ldc_w 885
    //   335: iconst_2
    //   336: anewarray 4	java/lang/Object
    //   339: dup
    //   340: iconst_0
    //   341: ldc_w 851
    //   344: aastore
    //   345: dup
    //   346: iconst_1
    //   347: invokestatic 849	com/tencent/bugly/proguard/p:a	()Lcom/tencent/bugly/proguard/p;
    //   350: ldc_w 851
    //   353: aload_1
    //   354: aconst_null
    //   355: aconst_null
    //   356: iconst_1
    //   357: invokevirtual 888	com/tencent/bugly/proguard/p:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/bugly/proguard/o;Z)I
    //   360: invokestatic 239	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   363: aastore
    //   364: invokestatic 208	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   367: pop
    //   368: aload 4
    //   370: ifnull +10 -> 380
    //   373: aload 4
    //   375: invokeinterface 855 1 0
    //   380: aload 5
    //   382: areturn
    //   383: astore_3
    //   384: aload 4
    //   386: astore_1
    //   387: goto +6 -> 393
    //   390: astore_3
    //   391: aconst_null
    //   392: astore_1
    //   393: aload_3
    //   394: invokestatic 79	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   397: ifne +7 -> 404
    //   400: aload_3
    //   401: invokevirtual 84	java/lang/Throwable:printStackTrace	()V
    //   404: aload_1
    //   405: ifnull +9 -> 414
    //   408: aload_1
    //   409: invokeinterface 855 1 0
    //   414: aconst_null
    //   415: areturn
    //   416: astore_3
    //   417: aload_1
    //   418: ifnull +9 -> 427
    //   421: aload_1
    //   422: invokeinterface 855 1 0
    //   427: aload_3
    //   428: athrow
    //   429: aconst_null
    //   430: areturn
    //   431: astore_3
    //   432: goto -166 -> 266
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	435	0	this	b
    //   0	435	1	paramList	List<a>
    //   197	132	2	i	int
    //   22	302	3	localObject1	Object
    //   383	1	3	localObject2	Object
    //   390	11	3	localThrowable	Throwable
    //   416	12	3	localObject3	Object
    //   431	1	3	localObject4	Object
    //   150	235	4	localCursor	Cursor
    //   178	203	5	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   171	196	383	finally
    //   198	214	383	finally
    //   218	227	383	finally
    //   266	277	383	finally
    //   282	315	383	finally
    //   315	328	383	finally
    //   332	368	383	finally
    //   136	152	390	finally
    //   393	404	416	finally
    //   230	259	431	finally
  }
  
  private static void c(List<a> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("_id in ");
      ((StringBuilder)localObject).append("(");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ((StringBuilder)localObject).append(((a)paramList.next()).a);
        ((StringBuilder)localObject).append(",");
      }
      paramList = new StringBuilder(((StringBuilder)localObject).substring(0, ((StringBuilder)localObject).lastIndexOf(",")));
      paramList.append(")");
      localObject = paramList.toString();
      paramList.setLength(0);
      try
      {
        x.c("deleted %s data %d", new Object[] { "t_cr", Integer.valueOf(p.a().a("t_cr", (String)localObject, null, null, true)) });
        return;
      }
      finally
      {
        if (!x.a(paramList)) {
          paramList.printStackTrace();
        }
      }
    }
  }
  
  private static void d(List<CrashDetailBean> paramList)
  {
    if (paramList != null) {
      try
      {
        if (paramList.size() == 0) {
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (CrashDetailBean)paramList.next();
          localStringBuilder.append(" or _id");
          localStringBuilder.append(" = ");
          localStringBuilder.append(((CrashDetailBean)localObject).a);
        }
        Object localObject = localStringBuilder.toString();
        paramList = (List<CrashDetailBean>)localObject;
        if (((String)localObject).length() > 0) {
          paramList = ((String)localObject).substring(4);
        }
        localStringBuilder.setLength(0);
        x.c("deleted %s data %d", new Object[] { "t_cr", Integer.valueOf(p.a().a("t_cr", paramList, null, null, true)) });
        return;
      }
      finally
      {
        if (!x.a(paramList)) {
          paramList.printStackTrace();
        }
      }
    }
  }
  
  private static ContentValues f(CrashDetailBean paramCrashDetailBean)
  {
    if (paramCrashDetailBean == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        ContentValues localContentValues = new ContentValues();
        if (paramCrashDetailBean.a > 0L) {
          localContentValues.put("_id", Long.valueOf(paramCrashDetailBean.a));
        }
        localContentValues.put("_tm", Long.valueOf(paramCrashDetailBean.r));
        localContentValues.put("_s1", paramCrashDetailBean.u);
        boolean bool = paramCrashDetailBean.d;
        int j = 1;
        if (bool)
        {
          i = 1;
          localContentValues.put("_up", Integer.valueOf(i));
          if (!paramCrashDetailBean.j) {
            break label165;
          }
          i = j;
          localContentValues.put("_me", Integer.valueOf(i));
          localContentValues.put("_uc", Integer.valueOf(paramCrashDetailBean.l));
          localContentValues.put("_dt", z.a(paramCrashDetailBean));
          return localContentValues;
        }
      }
      finally
      {
        if (!x.a(paramCrashDetailBean)) {
          paramCrashDetailBean.printStackTrace();
        }
        return null;
      }
      int i = 0;
      continue;
      label165:
      i = 0;
    }
  }
  
  public final List<CrashDetailBean> a()
  {
    Object localObject1 = com.tencent.bugly.crashreport.common.strategy.a.a().c();
    if (localObject1 == null)
    {
      x.d("have not synced remote!", new Object[0]);
      return null;
    }
    if (!((StrategyBean)localObject1).e)
    {
      x.d("Crashreport remote closed, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
      x.b("[init] WARNING! Crashreport closed by server, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
      return null;
    }
    long l1 = System.currentTimeMillis();
    long l2 = z.b();
    List localList = b();
    x.c("Size of crash list loaded from DB: %s", new Object[] { Integer.valueOf(localList.size()) });
    if (localList != null)
    {
      if (localList.size() <= 0) {
        return null;
      }
      localObject1 = new ArrayList();
      ((List)localObject1).addAll(a(localList));
      localList.removeAll((Collection)localObject1);
      Object localObject2 = localList.iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (a)((Iterator)localObject2).next();
        if (((a)localObject3).b < l2 - c.g)
        {
          ((Iterator)localObject2).remove();
          ((List)localObject1).add(localObject3);
        }
        else if (((a)localObject3).d)
        {
          if (((a)localObject3).b >= l1 - 86400000L)
          {
            ((Iterator)localObject2).remove();
          }
          else if (!((a)localObject3).e)
          {
            ((Iterator)localObject2).remove();
            ((List)localObject1).add(localObject3);
          }
        }
        else if ((((a)localObject3).f >= 3L) && (((a)localObject3).b < l1 - 86400000L))
        {
          ((Iterator)localObject2).remove();
          ((List)localObject1).add(localObject3);
        }
      }
      if (((List)localObject1).size() > 0) {
        c((List)localObject1);
      }
      localObject1 = new ArrayList();
      localList = b(localList);
      if ((localList != null) && (localList.size() > 0))
      {
        localObject2 = com.tencent.bugly.crashreport.common.info.a.b().j;
        localObject3 = localList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          CrashDetailBean localCrashDetailBean = (CrashDetailBean)((Iterator)localObject3).next();
          if (!((String)localObject2).equals(localCrashDetailBean.f))
          {
            ((Iterator)localObject3).remove();
            ((List)localObject1).add(localCrashDetailBean);
          }
        }
      }
      if (((List)localObject1).size() > 0) {
        d((List)localObject1);
      }
      return localList;
    }
    return null;
  }
  
  public final void a(CrashDetailBean paramCrashDetailBean, long paramLong, boolean paramBoolean)
  {
    if (c.l)
    {
      x.a("try to upload right now", new Object[0]);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramCrashDetailBean);
      boolean bool;
      if (paramCrashDetailBean.b == 7) {
        bool = true;
      } else {
        bool = false;
      }
      a(localArrayList, 3000L, paramBoolean, bool, paramBoolean);
      return;
    }
    x.a("do not upload spot crash right now, crash would be uploaded when app next start", new Object[0]);
  }
  
  public final void a(final List<CrashDetailBean> paramList, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!com.tencent.bugly.crashreport.common.info.a.a(this.b).e)
    {
      x.d("warn: not upload process", new Object[0]);
      return;
    }
    Object localObject = this.c;
    if (localObject == null)
    {
      x.d("warn: upload manager is null", new Object[0]);
      return;
    }
    if ((!paramBoolean3) && (!((u)localObject).b(c.a)))
    {
      x.d("warn: not crashHappen or not should upload", new Object[0]);
      return;
    }
    localObject = this.e.c();
    if (!((StrategyBean)localObject).e)
    {
      x.d("remote report is disable!", new Object[0]);
      x.b("[crash] server closed bugly in this app. please check your appid if is correct, and re-install it", new Object[0]);
      return;
    }
    if ((paramList != null) && (paramList.size() != 0)) {
      try
      {
        String str1 = ((StrategyBean)localObject).q;
        String str2 = StrategyBean.b;
        Context localContext = this.b;
        com.tencent.bugly.crashreport.common.info.a locala = com.tencent.bugly.crashreport.common.info.a.b();
        if ((localContext != null) && (paramList != null) && (paramList.size() != 0) && (locala != null))
        {
          al localal = new al();
          localal.a = new ArrayList();
          Iterator localIterator = paramList.iterator();
          for (;;)
          {
            localObject = localal;
            if (!localIterator.hasNext()) {
              break;
            }
            localObject = (CrashDetailBean)localIterator.next();
            localal.a.add(a(localContext, (CrashDetailBean)localObject, locala));
          }
        }
        x.d("enEXPPkg args == null!", new Object[0]);
        localObject = null;
        if (localObject == null)
        {
          x.d("create eupPkg fail!", new Object[0]);
          return;
        }
        localObject = com.tencent.bugly.proguard.a.a((k)localObject);
        if (localObject == null)
        {
          x.d("send encode fail!", new Object[0]);
          return;
        }
        localObject = com.tencent.bugly.proguard.a.a(this.b, 830, (byte[])localObject);
        if (localObject == null)
        {
          x.d("request package is null.", new Object[0]);
          return;
        }
        paramList = new t()
        {
          public final void a(boolean paramAnonymousBoolean)
          {
            b.a(paramAnonymousBoolean, paramList);
          }
        };
        if (paramBoolean1)
        {
          this.c.a(a, (am)localObject, str1, str2, paramList, paramLong, paramBoolean2);
          return;
        }
        this.c.a(a, (am)localObject, str1, str2, paramList, false);
        return;
      }
      finally
      {
        x.e("req cr error %s", new Object[] { paramList.toString() });
        if (!x.b(paramList)) {
          paramList.printStackTrace();
        }
        return;
      }
    }
    x.d("warn: crashList is null or crashList num is 0", new Object[0]);
  }
  
  public final boolean a(CrashDetailBean paramCrashDetailBean)
  {
    return b(paramCrashDetailBean);
  }
  
  /* Error */
  public final boolean b(CrashDetailBean paramCrashDetailBean)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: iconst_1
    //   5: ireturn
    //   6: getstatic 1048	com/tencent/bugly/crashreport/crash/c:n	Ljava/lang/String;
    //   9: ifnull +55 -> 64
    //   12: getstatic 1048	com/tencent/bugly/crashreport/crash/c:n	Ljava/lang/String;
    //   15: invokevirtual 1049	java/lang/String:isEmpty	()Z
    //   18: ifne +46 -> 64
    //   21: ldc_w 1051
    //   24: iconst_1
    //   25: anewarray 4	java/lang/Object
    //   28: dup
    //   29: iconst_0
    //   30: getstatic 1048	com/tencent/bugly/crashreport/crash/c:n	Ljava/lang/String;
    //   33: aastore
    //   34: invokestatic 187	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   37: pop
    //   38: aload_1
    //   39: getfield 326	com/tencent/bugly/crashreport/crash/CrashDetailBean:q	Ljava/lang/String;
    //   42: getstatic 1048	com/tencent/bugly/crashreport/crash/c:n	Ljava/lang/String;
    //   45: invokevirtual 159	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   48: ifeq +16 -> 64
    //   51: ldc_w 1053
    //   54: iconst_0
    //   55: anewarray 4	java/lang/Object
    //   58: invokestatic 208	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   61: pop
    //   62: iconst_1
    //   63: ireturn
    //   64: getstatic 1054	com/tencent/bugly/crashreport/crash/c:o	Ljava/lang/String;
    //   67: ifnull +61 -> 128
    //   70: getstatic 1054	com/tencent/bugly/crashreport/crash/c:o	Ljava/lang/String;
    //   73: invokevirtual 1049	java/lang/String:isEmpty	()Z
    //   76: ifne +52 -> 128
    //   79: ldc_w 1056
    //   82: iconst_1
    //   83: anewarray 4	java/lang/Object
    //   86: dup
    //   87: iconst_0
    //   88: getstatic 1054	com/tencent/bugly/crashreport/crash/c:o	Ljava/lang/String;
    //   91: aastore
    //   92: invokestatic 187	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   95: pop
    //   96: getstatic 1054	com/tencent/bugly/crashreport/crash/c:o	Ljava/lang/String;
    //   99: invokestatic 1062	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   102: aload_1
    //   103: getfield 326	com/tencent/bugly/crashreport/crash/CrashDetailBean:q	Ljava/lang/String;
    //   106: invokevirtual 1066	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   109: invokevirtual 1071	java/util/regex/Matcher:find	()Z
    //   112: ifeq +16 -> 128
    //   115: ldc_w 1073
    //   118: iconst_0
    //   119: anewarray 4	java/lang/Object
    //   122: invokestatic 208	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   125: pop
    //   126: iconst_1
    //   127: ireturn
    //   128: aload_1
    //   129: getfield 269	com/tencent/bugly/crashreport/crash/CrashDetailBean:b	I
    //   132: iconst_2
    //   133: if_icmpeq +77 -> 210
    //   136: new 1075	com/tencent/bugly/proguard/r
    //   139: dup
    //   140: invokespecial 1076	com/tencent/bugly/proguard/r:<init>	()V
    //   143: astore 4
    //   145: aload 4
    //   147: iconst_1
    //   148: putfield 1077	com/tencent/bugly/proguard/r:b	I
    //   151: aload 4
    //   153: aload_1
    //   154: getfield 595	com/tencent/bugly/crashreport/crash/CrashDetailBean:A	Ljava/lang/String;
    //   157: putfield 1078	com/tencent/bugly/proguard/r:c	Ljava/lang/String;
    //   160: aload 4
    //   162: aload_1
    //   163: getfield 353	com/tencent/bugly/crashreport/crash/CrashDetailBean:B	Ljava/lang/String;
    //   166: putfield 1079	com/tencent/bugly/proguard/r:d	Ljava/lang/String;
    //   169: aload 4
    //   171: aload_1
    //   172: getfield 177	com/tencent/bugly/crashreport/crash/CrashDetailBean:r	J
    //   175: putfield 1081	com/tencent/bugly/proguard/r:e	J
    //   178: aload_0
    //   179: getfield 35	com/tencent/bugly/crashreport/crash/b:d	Lcom/tencent/bugly/proguard/p;
    //   182: iconst_1
    //   183: invokevirtual 1083	com/tencent/bugly/proguard/p:b	(I)V
    //   186: aload_0
    //   187: getfield 35	com/tencent/bugly/crashreport/crash/b:d	Lcom/tencent/bugly/proguard/p;
    //   190: aload 4
    //   192: invokevirtual 1086	com/tencent/bugly/proguard/p:a	(Lcom/tencent/bugly/proguard/r;)Z
    //   195: pop
    //   196: ldc_w 1088
    //   199: iconst_0
    //   200: anewarray 4	java/lang/Object
    //   203: invokestatic 818	com/tencent/bugly/proguard/x:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   206: pop
    //   207: goto +14 -> 221
    //   210: ldc_w 1090
    //   213: iconst_0
    //   214: anewarray 4	java/lang/Object
    //   217: invokestatic 818	com/tencent/bugly/proguard/x:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   220: pop
    //   221: aload_0
    //   222: invokespecial 945	com/tencent/bugly/crashreport/crash/b:b	()Ljava/util/List;
    //   225: astore 7
    //   227: aconst_null
    //   228: astore 5
    //   230: aload 5
    //   232: astore 4
    //   234: aload 7
    //   236: ifnull +482 -> 718
    //   239: aload 5
    //   241: astore 4
    //   243: aload 7
    //   245: invokeinterface 91 1 0
    //   250: ifle +468 -> 718
    //   253: new 93	java/util/ArrayList
    //   256: dup
    //   257: bipush 10
    //   259: invokespecial 96	java/util/ArrayList:<init>	(I)V
    //   262: astore 5
    //   264: new 93	java/util/ArrayList
    //   267: dup
    //   268: bipush 10
    //   270: invokespecial 96	java/util/ArrayList:<init>	(I)V
    //   273: astore 6
    //   275: aload 5
    //   277: aload 7
    //   279: invokestatic 949	com/tencent/bugly/crashreport/crash/b:a	(Ljava/util/List;)Ljava/util/List;
    //   282: invokeinterface 953 2 0
    //   287: pop
    //   288: aload 7
    //   290: aload 5
    //   292: invokeinterface 956 2 0
    //   297: pop
    //   298: aload 7
    //   300: invokeinterface 91 1 0
    //   305: i2l
    //   306: ldc2_w 1091
    //   309: lcmp
    //   310: ifle +143 -> 453
    //   313: new 146	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   320: astore 4
    //   322: aload 4
    //   324: ldc_w 860
    //   327: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload 4
    //   333: ldc_w 862
    //   336: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: aload 4
    //   342: ldc_w 1094
    //   345: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: pop
    //   349: aload 4
    //   351: ldc_w 1096
    //   354: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: aload 4
    //   360: ldc_w 1098
    //   363: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: pop
    //   367: aload 4
    //   369: ldc_w 1100
    //   372: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: aload 4
    //   378: ldc_w 880
    //   381: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: aload 4
    //   387: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: astore 8
    //   392: aload 4
    //   394: iconst_0
    //   395: invokevirtual 883	java/lang/StringBuilder:setLength	(I)V
    //   398: ldc_w 1102
    //   401: iconst_2
    //   402: anewarray 4	java/lang/Object
    //   405: dup
    //   406: iconst_0
    //   407: ldc_w 851
    //   410: aastore
    //   411: dup
    //   412: iconst_1
    //   413: invokestatic 849	com/tencent/bugly/proguard/p:a	()Lcom/tencent/bugly/proguard/p;
    //   416: ldc_w 851
    //   419: aload 8
    //   421: aconst_null
    //   422: aconst_null
    //   423: iconst_1
    //   424: invokevirtual 888	com/tencent/bugly/proguard/p:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/bugly/proguard/o;Z)I
    //   427: invokestatic 239	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   430: aastore
    //   431: invokestatic 187	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   434: pop
    //   435: goto +18 -> 453
    //   438: astore 4
    //   440: aload 4
    //   442: invokestatic 79	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   445: ifne +8 -> 453
    //   448: aload 4
    //   450: invokevirtual 84	java/lang/Throwable:printStackTrace	()V
    //   453: aload_1
    //   454: getfield 269	com/tencent/bugly/crashreport/crash/CrashDetailBean:b	I
    //   457: istore_3
    //   458: iload_3
    //   459: ifeq +16 -> 475
    //   462: iload_3
    //   463: iconst_1
    //   464: if_icmpne +6 -> 470
    //   467: goto +8 -> 475
    //   470: iconst_0
    //   471: istore_2
    //   472: goto +5 -> 477
    //   475: iconst_1
    //   476: istore_2
    //   477: iload_3
    //   478: iconst_3
    //   479: if_icmpne +8 -> 487
    //   482: iconst_1
    //   483: istore_3
    //   484: goto +5 -> 489
    //   487: iconst_0
    //   488: istore_3
    //   489: getstatic 1106	com/tencent/bugly/b:c	Z
    //   492: ifne +25 -> 517
    //   495: iload_3
    //   496: ifne +10 -> 506
    //   499: iload_2
    //   500: ifne +6 -> 506
    //   503: goto +9 -> 512
    //   506: getstatic 1107	com/tencent/bugly/crashreport/crash/c:d	Z
    //   509: ifeq +8 -> 517
    //   512: iconst_1
    //   513: istore_2
    //   514: goto +5 -> 519
    //   517: iconst_0
    //   518: istore_2
    //   519: aload 5
    //   521: astore 4
    //   523: iload_2
    //   524: ifeq +194 -> 718
    //   527: aload 7
    //   529: invokeinterface 100 1 0
    //   534: astore 4
    //   536: iconst_0
    //   537: istore_2
    //   538: aload 4
    //   540: invokeinterface 106 1 0
    //   545: ifeq +53 -> 598
    //   548: aload 4
    //   550: invokeinterface 110 1 0
    //   555: checkcast 112	com/tencent/bugly/crashreport/crash/a
    //   558: astore 7
    //   560: aload_1
    //   561: getfield 912	com/tencent/bugly/crashreport/crash/CrashDetailBean:u	Ljava/lang/String;
    //   564: aload 7
    //   566: getfield 831	com/tencent/bugly/crashreport/crash/a:c	Ljava/lang/String;
    //   569: invokevirtual 967	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   572: ifeq -34 -> 538
    //   575: aload 7
    //   577: getfield 115	com/tencent/bugly/crashreport/crash/a:e	Z
    //   580: ifeq +5 -> 585
    //   583: iconst_1
    //   584: istore_2
    //   585: aload 6
    //   587: aload 7
    //   589: invokeinterface 119 2 0
    //   594: pop
    //   595: goto -57 -> 538
    //   598: iload_2
    //   599: ifne +20 -> 619
    //   602: aload 5
    //   604: astore 4
    //   606: aload 6
    //   608: invokeinterface 91 1 0
    //   613: getstatic 1109	com/tencent/bugly/crashreport/crash/c:c	I
    //   616: if_icmplt +102 -> 718
    //   619: ldc_w 1111
    //   622: iconst_0
    //   623: anewarray 4	java/lang/Object
    //   626: invokestatic 705	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   629: pop
    //   630: aload_0
    //   631: aload 6
    //   633: aload_1
    //   634: invokespecial 1113	com/tencent/bugly/crashreport/crash/b:a	(Ljava/util/List;Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;)Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;
    //   637: astore_1
    //   638: aload 6
    //   640: invokeinterface 100 1 0
    //   645: astore 4
    //   647: aload 4
    //   649: invokeinterface 106 1 0
    //   654: ifeq +41 -> 695
    //   657: aload 4
    //   659: invokeinterface 110 1 0
    //   664: checkcast 112	com/tencent/bugly/crashreport/crash/a
    //   667: astore 6
    //   669: aload 6
    //   671: getfield 822	com/tencent/bugly/crashreport/crash/a:a	J
    //   674: aload_1
    //   675: getfield 74	com/tencent/bugly/crashreport/crash/CrashDetailBean:a	J
    //   678: lcmp
    //   679: ifeq -32 -> 647
    //   682: aload 5
    //   684: aload 6
    //   686: invokeinterface 119 2 0
    //   691: pop
    //   692: goto -45 -> 647
    //   695: aload_0
    //   696: aload_1
    //   697: invokevirtual 1115	com/tencent/bugly/crashreport/crash/b:e	(Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;)V
    //   700: aload 5
    //   702: invokestatic 964	com/tencent/bugly/crashreport/crash/b:c	(Ljava/util/List;)V
    //   705: ldc_w 1117
    //   708: iconst_0
    //   709: anewarray 4	java/lang/Object
    //   712: invokestatic 818	com/tencent/bugly/proguard/x:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   715: pop
    //   716: iconst_1
    //   717: ireturn
    //   718: aload_0
    //   719: aload_1
    //   720: invokevirtual 1115	com/tencent/bugly/crashreport/crash/b:e	(Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;)V
    //   723: aload 4
    //   725: ifnull +18 -> 743
    //   728: aload 4
    //   730: invokeinterface 507 1 0
    //   735: ifne +8 -> 743
    //   738: aload 4
    //   740: invokestatic 964	com/tencent/bugly/crashreport/crash/b:c	(Ljava/util/List;)V
    //   743: ldc_w 1119
    //   746: iconst_0
    //   747: anewarray 4	java/lang/Object
    //   750: invokestatic 818	com/tencent/bugly/proguard/x:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   753: pop
    //   754: iconst_0
    //   755: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	756	0	this	b
    //   0	756	1	paramCrashDetailBean	CrashDetailBean
    //   471	128	2	i	int
    //   457	39	3	j	int
    //   143	250	4	localObject1	Object
    //   438	11	4	localThrowable	Throwable
    //   521	218	4	localObject2	Object
    //   228	473	5	localArrayList	ArrayList
    //   273	412	6	localObject3	Object
    //   225	363	7	localObject4	Object
    //   390	30	8	str	String
    // Exception table:
    //   from	to	target	type
    //   398	435	438	finally
  }
  
  public final void c(CrashDetailBean paramCrashDetailBean)
  {
    int i = paramCrashDetailBean.b;
    if (i != 0)
    {
      if (i != 1)
      {
        if ((i != 3) || (c.a().r())) {}
      }
      else if (c.a().q()) {}
    }
    else if (!c.a().q()) {
      return;
    }
    if (this.f != null)
    {
      x.c("Calling 'onCrashHandleEnd' of RQD crash listener.", new Object[0]);
      i = paramCrashDetailBean.b;
    }
  }
  
  public final void d(CrashDetailBean paramCrashDetailBean)
  {
    if (paramCrashDetailBean == null) {
      return;
    }
    if ((this.g == null) && (this.f == null)) {
      return;
    }
    for (;;)
    {
      try
      {
        switch (paramCrashDetailBean.b)
        {
        case 6: 
          i = 6;
          if (!c.a().u()) {
            return;
          }
        case 5: 
          i = 5;
          if (!c.a().t()) {
            return;
          }
        case 4: 
          i = 3;
          if (!c.a().s()) {
            return;
          }
        case 3: 
          i = 4;
          if (!c.a().r()) {
            return;
          }
        case 1: 
          if (c.a().q()) {
            break label902;
          }
          return;
        case 0: 
          if (c.a().q()) {
            break label907;
          }
          return;
          int j = paramCrashDetailBean.b;
          localObject1 = paramCrashDetailBean.n;
          localObject1 = paramCrashDetailBean.p;
          localObject1 = paramCrashDetailBean.q;
          long l = paramCrashDetailBean.r;
          localObject1 = this.f;
          Object localObject3 = null;
          Object localObject2;
          if (localObject1 != null)
          {
            x.c("Calling 'onCrashHandleStart' of RQD crash listener.", new Object[0]);
            x.c("Calling 'getCrashExtraMessage' of RQD crash listener.", new Object[0]);
            localObject2 = this.f.b();
            if (localObject2 == null) {
              break label912;
            }
            localObject1 = new HashMap(1);
            ((Map)localObject1).put("userData", localObject2);
          }
          else
          {
            if (this.g == null) {
              break label912;
            }
            x.c("Calling 'onCrashHandleStart' of Bugly crash listener.", new Object[0]);
            localObject1 = this.g.onCrashHandleStart(i, paramCrashDetailBean.n, paramCrashDetailBean.o, paramCrashDetailBean.q);
          }
          if ((localObject1 != null) && (((Map)localObject1).size() > 0))
          {
            paramCrashDetailBean.O = new LinkedHashMap(((Map)localObject1).size());
            Iterator localIterator = ((Map)localObject1).entrySet().iterator();
            if (localIterator.hasNext())
            {
              Map.Entry localEntry = (Map.Entry)localIterator.next();
              if (z.a((String)localEntry.getKey())) {
                continue;
              }
              localObject2 = (String)localEntry.getKey();
              localObject1 = localObject2;
              if (((String)localObject2).length() > 100)
              {
                localObject1 = ((String)localObject2).substring(0, 100);
                x.d("setted key length is over limit %d substring to %s", new Object[] { Integer.valueOf(100), localObject1 });
              }
              if ((!z.a((String)localEntry.getValue())) && (((String)localEntry.getValue()).length() > 100000))
              {
                localObject2 = ((String)localEntry.getValue()).substring(((String)localEntry.getValue()).length() - 100000);
                x.d("setted %s value length is over limit %d substring", new Object[] { localObject1, Integer.valueOf(100000) });
              }
              else
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append((String)localEntry.getValue());
                localObject2 = ((StringBuilder)localObject2).toString();
              }
              paramCrashDetailBean.O.put(localObject1, localObject2);
              x.a("add setted key %s value size:%d", new Object[] { localObject1, Integer.valueOf(((String)localObject2).length()) });
              continue;
            }
          }
          x.a("[crash callback] start user's callback:onCrashHandleStart2GetExtraDatas()", new Object[0]);
          if (this.f != null)
          {
            x.c("Calling 'getCrashExtraData' of RQD crash listener.", new Object[0]);
            localObject1 = this.f.a();
          }
          else
          {
            localObject1 = localObject3;
            if (this.g != null)
            {
              x.c("Calling 'onCrashHandleStart2GetExtraDatas' of Bugly crash listener.", new Object[0]);
              localObject1 = this.g.onCrashHandleStart2GetExtraDatas(i, paramCrashDetailBean.n, paramCrashDetailBean.o, paramCrashDetailBean.q);
            }
          }
          paramCrashDetailBean.U = ((byte[])localObject1);
          if (localObject1 != null)
          {
            if (localObject1.length > 100000)
            {
              x.d("extra bytes size %d is over limit %d will drop over part", new Object[] { Integer.valueOf(localObject1.length), Integer.valueOf(100000) });
              paramCrashDetailBean.U = Arrays.copyOf((byte[])localObject1, 100000);
            }
            x.a("add extra bytes %d ", new Object[] { Integer.valueOf(localObject1.length) });
          }
          if (this.f != null)
          {
            x.c("Calling 'onCrashSaving' of RQD crash listener.", new Object[0]);
            localObject1 = this.f;
            localObject2 = paramCrashDetailBean.o;
            localObject2 = paramCrashDetailBean.m;
            localObject2 = paramCrashDetailBean.e;
            localObject2 = paramCrashDetailBean.c;
            localObject2 = paramCrashDetailBean.A;
            paramCrashDetailBean = paramCrashDetailBean.B;
            if (!((o)localObject1).c()) {
              x.d("Crash listener 'onCrashSaving' return 'false' thus will not handle this crash.", new Object[0]);
            }
          }
          return;
        }
      }
      finally
      {
        x.d("crash handle callback something wrong! %s", new Object[] { paramCrashDetailBean.getClass().getName() });
        if (!x.a(paramCrashDetailBean)) {
          paramCrashDetailBean.printStackTrace();
        }
        return;
      }
      return;
      int i = 7;
      continue;
      i = 1;
      continue;
      label902:
      i = 2;
      continue;
      label907:
      i = 0;
      continue;
      label912:
      Object localObject1 = null;
    }
  }
  
  public final void e(CrashDetailBean paramCrashDetailBean)
  {
    if (paramCrashDetailBean == null) {
      return;
    }
    ContentValues localContentValues = f(paramCrashDetailBean);
    if (localContentValues != null)
    {
      long l = p.a().a("t_cr", localContentValues, null, true);
      if (l >= 0L)
      {
        x.c("insert %s success!", new Object[] { "t_cr" });
        paramCrashDetailBean.a = l;
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\crashreport\crash\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */