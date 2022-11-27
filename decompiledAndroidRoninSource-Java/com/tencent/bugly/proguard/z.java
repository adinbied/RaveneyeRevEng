package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.info.a;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class z
{
  private static Map<String, String> a;
  
  public static Context a(Context paramContext)
  {
    if (paramContext == null) {
      return paramContext;
    }
    Context localContext = paramContext.getApplicationContext();
    if (localContext == null) {
      return paramContext;
    }
    return localContext;
  }
  
  public static SharedPreferences a(String paramString, Context paramContext)
  {
    if (paramContext != null) {
      return paramContext.getSharedPreferences(paramString, 0);
    }
    return null;
  }
  
  private static BufferedReader a(File paramFile)
  {
    if ((paramFile != null) && (paramFile.exists()))
    {
      if (!paramFile.canRead()) {
        return null;
      }
      try
      {
        paramFile = new BufferedReader(new InputStreamReader(new FileInputStream(paramFile), "utf-8"));
        return paramFile;
      }
      finally
      {
        x.a(paramFile);
      }
    }
    return null;
  }
  
  public static BufferedReader a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    try
    {
      paramString1 = new File(paramString1, paramString2);
      if (paramString1.exists())
      {
        if (!paramString1.canRead()) {
          return null;
        }
        paramString1 = a(paramString1);
        return paramString1;
      }
      return null;
    }
    catch (NullPointerException paramString1)
    {
      x.a(paramString1);
    }
    return null;
  }
  
  public static Object a(String paramString1, String paramString2, Object paramObject, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    try
    {
      paramString1 = Class.forName(paramString1).getDeclaredMethod(paramString2, paramArrayOfClass);
      paramString1.setAccessible(true);
      paramString1 = paramString1.invoke(null, paramArrayOfObject);
      return paramString1;
    }
    catch (Exception paramString1) {}
    return null;
  }
  
  public static <T> T a(byte[] paramArrayOfByte, Parcelable.Creator<T> paramCreator)
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    try
    {
      paramArrayOfByte = paramCreator.createFromParcel(localParcel);
      if (localParcel != null) {
        localParcel.recycle();
      }
      return paramArrayOfByte;
    }
    finally
    {
      try
      {
        paramArrayOfByte.printStackTrace();
        return null;
      }
      finally
      {
        if (localParcel != null) {
          localParcel.recycle();
        }
      }
    }
  }
  
  public static String a()
  {
    return a(System.currentTimeMillis());
  }
  
  public static String a(long paramLong)
  {
    try
    {
      String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(paramLong));
      return str;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return new Date().toString();
  }
  
  public static String a(Context paramContext, int paramInt, String paramString)
  {
    boolean bool = AppInfo.a(paramContext, "android.permission.READ_LOGS");
    paramContext = null;
    if (!bool)
    {
      x.d("no read_log permission!", new Object[0]);
      return null;
    }
    if (paramString == null) {
      paramString = new String[] { "logcat", "-d", "-v", "threadtime" };
    } else {
      paramString = new String[] { "logcat", "-d", "-v", "threadtime", "-s", paramString };
    }
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      paramString = Runtime.getRuntime().exec(paramString);
      paramContext = paramString;
      localObject = new BufferedReader(new InputStreamReader(paramString.getInputStream()));
      for (;;)
      {
        paramContext = paramString;
        String str = ((BufferedReader)localObject).readLine();
        if (str == null) {
          break;
        }
        paramContext = paramString;
        localStringBuilder.append(str);
        paramContext = paramString;
        localStringBuilder.append("\n");
        if (paramInt > 0)
        {
          paramContext = paramString;
          if (localStringBuilder.length() > paramInt)
          {
            paramContext = paramString;
            localStringBuilder.delete(0, localStringBuilder.length() - paramInt);
          }
        }
      }
      paramContext = paramString;
      localObject = localStringBuilder.toString();
      if (paramString != null)
      {
        try
        {
          paramString.getOutputStream().close();
        }
        catch (IOException paramContext)
        {
          paramContext.printStackTrace();
        }
        try
        {
          paramString.getInputStream().close();
        }
        catch (IOException paramContext)
        {
          paramContext.printStackTrace();
        }
        try
        {
          paramString.getErrorStream().close();
          return (String)localObject;
        }
        catch (IOException paramContext)
        {
          paramContext.printStackTrace();
        }
      }
      return (String)localObject;
    }
    finally
    {
      try
      {
        if (!x.a(paramString)) {
          paramString.printStackTrace();
        }
        Object localObject = new StringBuilder("\n[error:");
        ((StringBuilder)localObject).append(paramString.toString());
        ((StringBuilder)localObject).append("]");
        localStringBuilder.append(((StringBuilder)localObject).toString());
        paramString = localStringBuilder.toString();
        if (paramContext != null)
        {
          try
          {
            paramContext.getOutputStream().close();
          }
          catch (IOException localIOException1)
          {
            localIOException1.printStackTrace();
          }
          try
          {
            paramContext.getInputStream().close();
          }
          catch (IOException localIOException2)
          {
            localIOException2.printStackTrace();
          }
          try
          {
            paramContext.getErrorStream().close();
            return paramString;
          }
          catch (IOException paramContext)
          {
            paramContext.printStackTrace();
          }
        }
        return paramString;
      }
      finally
      {
        if (paramContext != null)
        {
          try
          {
            paramContext.getOutputStream().close();
          }
          catch (IOException localIOException3)
          {
            localIOException3.printStackTrace();
          }
          try
          {
            paramContext.getInputStream().close();
          }
          catch (IOException localIOException4)
          {
            localIOException4.printStackTrace();
          }
          try
          {
            paramContext.getErrorStream().close();
          }
          catch (IOException paramContext)
          {
            paramContext.printStackTrace();
          }
        }
      }
    }
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if (paramString != null)
    {
      if (paramString.trim().equals("")) {
        return "";
      }
      if (a == null)
      {
        a = new HashMap();
        Object localObject = "/system/bin/sh";
        if ((!new File("/system/bin/sh").exists()) || (!new File("/system/bin/sh").canExecute())) {
          localObject = "sh";
        }
        localObject = a(paramContext, new String[] { localObject, "-c", "getprop" });
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          x.b(z.class, "Successfully get 'getprop' list.", new Object[0]);
          paramContext = Pattern.compile("\\[(.+)\\]: \\[(.*)\\]");
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            Matcher localMatcher = paramContext.matcher((String)((Iterator)localObject).next());
            if (localMatcher.find()) {
              a.put(localMatcher.group(1), localMatcher.group(2));
            }
          }
          x.b(z.class, "Systems properties number: %d.", new Object[] { Integer.valueOf(a.size()) });
        }
      }
      if (a.containsKey(paramString)) {
        return (String)a.get(paramString);
      }
      return "fail";
    }
    return "";
  }
  
  /* Error */
  public static String a(File paramFile, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +190 -> 191
    //   4: aload_0
    //   5: invokevirtual 32	java/io/File:exists	()Z
    //   8: ifeq +183 -> 191
    //   11: aload_0
    //   12: invokevirtual 35	java/io/File:canRead	()Z
    //   15: ifne +5 -> 20
    //   18: aconst_null
    //   19: areturn
    //   20: new 186	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   27: astore_3
    //   28: new 37	java/io/BufferedReader
    //   31: dup
    //   32: new 39	java/io/InputStreamReader
    //   35: dup
    //   36: new 41	java/io/FileInputStream
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 44	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   44: ldc 46
    //   46: invokespecial 49	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   49: invokespecial 52	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   52: astore_0
    //   53: aload_0
    //   54: invokevirtual 209	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   57: astore 4
    //   59: aload 4
    //   61: ifnull +61 -> 122
    //   64: aload_3
    //   65: aload 4
    //   67: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload_3
    //   72: ldc -41
    //   74: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: iload_1
    //   79: ifle -26 -> 53
    //   82: aload_3
    //   83: invokevirtual 219	java/lang/StringBuilder:length	()I
    //   86: iload_1
    //   87: if_icmple -34 -> 53
    //   90: iload_2
    //   91: ifeq +16 -> 107
    //   94: aload_3
    //   95: iload_1
    //   96: aload_3
    //   97: invokevirtual 219	java/lang/StringBuilder:length	()I
    //   100: invokevirtual 223	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: goto +18 -> 122
    //   107: aload_3
    //   108: iconst_0
    //   109: aload_3
    //   110: invokevirtual 219	java/lang/StringBuilder:length	()I
    //   113: iload_1
    //   114: isub
    //   115: invokevirtual 223	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: goto -66 -> 53
    //   122: aload_3
    //   123: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: astore_3
    //   127: aload_0
    //   128: invokevirtual 349	java/io/BufferedReader:close	()V
    //   131: aload_3
    //   132: areturn
    //   133: astore_0
    //   134: aload_0
    //   135: invokestatic 57	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   138: pop
    //   139: aload_3
    //   140: areturn
    //   141: astore_3
    //   142: goto +6 -> 148
    //   145: astore_3
    //   146: aconst_null
    //   147: astore_0
    //   148: aload_3
    //   149: invokestatic 57	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   152: pop
    //   153: aload_0
    //   154: ifnull +15 -> 169
    //   157: aload_0
    //   158: invokevirtual 349	java/io/BufferedReader:close	()V
    //   161: aconst_null
    //   162: areturn
    //   163: astore_0
    //   164: aload_0
    //   165: invokestatic 57	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   168: pop
    //   169: aconst_null
    //   170: areturn
    //   171: astore_3
    //   172: aload_0
    //   173: ifnull +16 -> 189
    //   176: aload_0
    //   177: invokevirtual 349	java/io/BufferedReader:close	()V
    //   180: goto +9 -> 189
    //   183: astore_0
    //   184: aload_0
    //   185: invokestatic 57	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   188: pop
    //   189: aload_3
    //   190: athrow
    //   191: aconst_null
    //   192: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	paramFile	File
    //   0	193	1	paramInt	int
    //   0	193	2	paramBoolean	boolean
    //   27	113	3	localObject1	Object
    //   141	1	3	localObject2	Object
    //   145	4	3	localThrowable	Throwable
    //   171	19	3	localObject3	Object
    //   57	9	4	str	String
    // Exception table:
    //   from	to	target	type
    //   127	131	133	java/lang/Exception
    //   53	59	141	finally
    //   64	78	141	finally
    //   82	90	141	finally
    //   94	104	141	finally
    //   107	119	141	finally
    //   122	127	141	finally
    //   20	53	145	finally
    //   157	161	163	java/lang/Exception
    //   148	153	171	finally
    //   176	180	183	java/lang/Exception
  }
  
  public static String a(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    try
    {
      StringWriter localStringWriter = new StringWriter();
      paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
      paramThrowable = localStringWriter.getBuffer().toString();
      return paramThrowable;
    }
    finally
    {
      if (!x.a(paramThrowable)) {
        paramThrowable.printStackTrace();
      }
    }
    return "fail";
  }
  
  public static String a(Date paramDate)
  {
    if (paramDate == null) {
      return null;
    }
    try
    {
      paramDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(paramDate);
      return paramDate;
    }
    catch (Exception paramDate)
    {
      for (;;) {}
    }
    return new Date().toString();
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0)) {
      try
      {
        Object localObject = MessageDigest.getInstance("SHA-1");
        ((MessageDigest)localObject).update(paramArrayOfByte);
        paramArrayOfByte = ((MessageDigest)localObject).digest();
        if (paramArrayOfByte == null) {
          return "";
        }
        localObject = new StringBuffer();
        int i = 0;
        while (i < paramArrayOfByte.length)
        {
          String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
          if (str.length() == 1) {
            ((StringBuffer)localObject).append("0");
          }
          ((StringBuffer)localObject).append(str);
          i += 1;
        }
        paramArrayOfByte = ((StringBuffer)localObject).toString().toUpperCase();
        return paramArrayOfByte;
      }
      finally
      {
        if (!x.a(paramArrayOfByte)) {
          paramArrayOfByte.printStackTrace();
        }
        return null;
      }
    }
    return "NULL";
  }
  
  public static Thread a(Runnable paramRunnable, String paramString)
  {
    try
    {
      paramRunnable = new Thread(paramRunnable);
      paramRunnable.setName(paramString);
      paramRunnable.start();
      return paramRunnable;
    }
    finally
    {
      x.e("[Util] Failed to start a thread to execute task with message: %s", new Object[] { paramRunnable.getMessage() });
    }
    return null;
  }
  
  /* Error */
  private static ArrayList<String> a(Context paramContext, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 423	com/tencent/bugly/crashreport/common/info/AppInfo:e	(Landroid/content/Context;)Z
    //   4: ifeq +24 -> 28
    //   7: new 425	java/util/ArrayList
    //   10: dup
    //   11: iconst_1
    //   12: anewarray 174	java/lang/String
    //   15: dup
    //   16: iconst_0
    //   17: ldc_w 427
    //   20: aastore
    //   21: invokestatic 433	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   24: invokespecial 436	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   27: areturn
    //   28: new 425	java/util/ArrayList
    //   31: dup
    //   32: invokespecial 437	java/util/ArrayList:<init>	()V
    //   35: astore_3
    //   36: invokestatic 193	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   39: aload_1
    //   40: invokevirtual 197	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   43: astore_0
    //   44: new 37	java/io/BufferedReader
    //   47: dup
    //   48: new 39	java/io/InputStreamReader
    //   51: dup
    //   52: aload_0
    //   53: invokevirtual 203	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   56: invokespecial 206	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   59: invokespecial 52	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   62: astore_2
    //   63: aload_2
    //   64: invokevirtual 209	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   67: astore_1
    //   68: aload_1
    //   69: ifnull +12 -> 81
    //   72: aload_3
    //   73: aload_1
    //   74: invokevirtual 440	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   77: pop
    //   78: goto -15 -> 63
    //   81: new 37	java/io/BufferedReader
    //   84: dup
    //   85: new 39	java/io/InputStreamReader
    //   88: dup
    //   89: aload_0
    //   90: invokevirtual 240	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   93: invokespecial 206	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   96: invokespecial 52	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   99: astore_0
    //   100: aload_0
    //   101: invokevirtual 209	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   104: astore_1
    //   105: aload_1
    //   106: ifnull +12 -> 118
    //   109: aload_3
    //   110: aload_1
    //   111: invokevirtual 440	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   114: pop
    //   115: goto -15 -> 100
    //   118: aload_2
    //   119: invokevirtual 349	java/io/BufferedReader:close	()V
    //   122: goto +8 -> 130
    //   125: astore_1
    //   126: aload_1
    //   127: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   130: aload_0
    //   131: invokevirtual 349	java/io/BufferedReader:close	()V
    //   134: aload_3
    //   135: areturn
    //   136: astore_0
    //   137: aload_0
    //   138: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   141: aload_3
    //   142: areturn
    //   143: astore_1
    //   144: goto +14 -> 158
    //   147: astore_1
    //   148: aconst_null
    //   149: astore_0
    //   150: goto +8 -> 158
    //   153: astore_1
    //   154: aconst_null
    //   155: astore_2
    //   156: aload_2
    //   157: astore_0
    //   158: aload_1
    //   159: invokestatic 57	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   162: ifne +7 -> 169
    //   165: aload_1
    //   166: invokevirtual 119	java/lang/Throwable:printStackTrace	()V
    //   169: aload_2
    //   170: ifnull +15 -> 185
    //   173: aload_2
    //   174: invokevirtual 349	java/io/BufferedReader:close	()V
    //   177: goto +8 -> 185
    //   180: astore_1
    //   181: aload_1
    //   182: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   185: aload_0
    //   186: ifnull +14 -> 200
    //   189: aload_0
    //   190: invokevirtual 349	java/io/BufferedReader:close	()V
    //   193: aconst_null
    //   194: areturn
    //   195: astore_0
    //   196: aload_0
    //   197: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   200: aconst_null
    //   201: areturn
    //   202: astore_1
    //   203: aload_2
    //   204: ifnull +15 -> 219
    //   207: aload_2
    //   208: invokevirtual 349	java/io/BufferedReader:close	()V
    //   211: goto +8 -> 219
    //   214: astore_2
    //   215: aload_2
    //   216: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   219: aload_0
    //   220: ifnull +15 -> 235
    //   223: aload_0
    //   224: invokevirtual 349	java/io/BufferedReader:close	()V
    //   227: goto +8 -> 235
    //   230: astore_0
    //   231: aload_0
    //   232: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   235: aload_1
    //   236: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	paramContext	Context
    //   0	237	1	paramArrayOfString	String[]
    //   62	146	2	localBufferedReader	BufferedReader
    //   214	2	2	localIOException	IOException
    //   35	107	3	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   118	122	125	java/io/IOException
    //   130	134	136	java/io/IOException
    //   100	105	143	finally
    //   109	115	143	finally
    //   63	68	147	finally
    //   72	78	147	finally
    //   81	100	147	finally
    //   36	63	153	finally
    //   173	177	180	java/io/IOException
    //   189	193	195	java/io/IOException
    //   158	169	202	finally
    //   207	211	214	java/io/IOException
    //   223	227	230	java/io/IOException
  }
  
  public static Map<String, String> a(int paramInt, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap(12);
    Object localObject2 = Thread.getAllStackTraces();
    if (localObject2 == null) {
      return null;
    }
    Object localObject1 = Looper.getMainLooper().getThread();
    if (!((Map)localObject2).containsKey(localObject1)) {
      ((Map)localObject2).put(localObject1, ((Thread)localObject1).getStackTrace());
    }
    Thread.currentThread().getId();
    localObject1 = new StringBuilder();
    localObject2 = ((Map)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      int i = 0;
      ((StringBuilder)localObject1).setLength(0);
      if ((localEntry.getValue() != null) && (((StackTraceElement[])localEntry.getValue()).length != 0))
      {
        Object localObject3 = (StackTraceElement[])localEntry.getValue();
        int j = localObject3.length;
        while (i < j)
        {
          Object localObject4 = localObject3[i];
          if ((paramInt > 0) && (((StringBuilder)localObject1).length() >= paramInt))
          {
            localObject3 = new StringBuilder("\n[Stack over limit size :");
            ((StringBuilder)localObject3).append(paramInt);
            ((StringBuilder)localObject3).append(" , has been cut!]");
            ((StringBuilder)localObject1).append(((StringBuilder)localObject3).toString());
            break;
          }
          ((StringBuilder)localObject1).append(((StackTraceElement)localObject4).toString());
          ((StringBuilder)localObject1).append("\n");
          i += 1;
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(((Thread)localEntry.getKey()).getName());
        ((StringBuilder)localObject3).append("(");
        ((StringBuilder)localObject3).append(((Thread)localEntry.getKey()).getId());
        ((StringBuilder)localObject3).append(")");
        localHashMap.put(((StringBuilder)localObject3).toString(), ((StringBuilder)localObject1).toString());
      }
    }
    return localHashMap;
  }
  
  public static Map<String, PlugInBean> a(Parcel paramParcel)
  {
    Object localObject1 = paramParcel.readBundle();
    paramParcel = null;
    if (localObject1 == null) {
      return null;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int k = ((Integer)((Bundle)localObject1).get("pluginNum")).intValue();
    int j = 0;
    int i = 0;
    Object localObject2;
    while (i < k)
    {
      localObject2 = new StringBuilder("pluginKey");
      ((StringBuilder)localObject2).append(i);
      localArrayList1.add(((Bundle)localObject1).getString(((StringBuilder)localObject2).toString()));
      i += 1;
    }
    i = 0;
    while (i < k)
    {
      localObject2 = new StringBuilder("pluginVal");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append("plugInId");
      localObject2 = ((Bundle)localObject1).getString(((StringBuilder)localObject2).toString());
      Object localObject3 = new StringBuilder("pluginVal");
      ((StringBuilder)localObject3).append(i);
      ((StringBuilder)localObject3).append("plugInUUID");
      localObject3 = ((Bundle)localObject1).getString(((StringBuilder)localObject3).toString());
      StringBuilder localStringBuilder = new StringBuilder("pluginVal");
      localStringBuilder.append(i);
      localStringBuilder.append("plugInVersion");
      localArrayList2.add(new PlugInBean((String)localObject2, ((Bundle)localObject1).getString(localStringBuilder.toString()), (String)localObject3));
      i += 1;
    }
    if (localArrayList1.size() == localArrayList2.size())
    {
      localObject1 = new HashMap(localArrayList1.size());
      i = j;
      for (;;)
      {
        paramParcel = (Parcel)localObject1;
        if (i >= localArrayList1.size()) {
          break;
        }
        ((HashMap)localObject1).put(localArrayList1.get(i), PlugInBean.class.cast(localArrayList2.get(i)));
        i += 1;
      }
    }
    x.e("map plugin parcel error!", new Object[0]);
    return paramParcel;
  }
  
  public static void a(Parcel paramParcel, Map<String, PlugInBean> paramMap)
  {
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      int i = paramMap.size();
      ArrayList localArrayList1 = new ArrayList(i);
      ArrayList localArrayList2 = new ArrayList(i);
      paramMap = paramMap.entrySet().iterator();
      Object localObject;
      while (paramMap.hasNext())
      {
        localObject = (Map.Entry)paramMap.next();
        localArrayList1.add(((Map.Entry)localObject).getKey());
        localArrayList2.add(((Map.Entry)localObject).getValue());
      }
      paramMap = new Bundle();
      paramMap.putInt("pluginNum", localArrayList1.size());
      int k = 0;
      i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= localArrayList1.size()) {
          break;
        }
        localObject = new StringBuilder("pluginKey");
        ((StringBuilder)localObject).append(i);
        paramMap.putString(((StringBuilder)localObject).toString(), (String)localArrayList1.get(i));
        i += 1;
      }
      while (j < localArrayList1.size())
      {
        localObject = new StringBuilder("pluginVal");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append("plugInId");
        paramMap.putString(((StringBuilder)localObject).toString(), ((PlugInBean)localArrayList2.get(j)).a);
        localObject = new StringBuilder("pluginVal");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append("plugInUUID");
        paramMap.putString(((StringBuilder)localObject).toString(), ((PlugInBean)localArrayList2.get(j)).c);
        localObject = new StringBuilder("pluginVal");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append("plugInVersion");
        paramMap.putString(((StringBuilder)localObject).toString(), ((PlugInBean)localArrayList2.get(j)).b);
        j += 1;
      }
      paramParcel.writeBundle(paramMap);
      return;
    }
    paramParcel.writeBundle(null);
  }
  
  public static void a(Class<?> paramClass, String paramString, Object paramObject1, Object paramObject2)
  {
    try
    {
      paramClass = paramClass.getDeclaredField(paramString);
      paramClass.setAccessible(true);
      paramClass.set(null, paramObject1);
      return;
    }
    catch (Exception paramClass) {}
  }
  
  public static boolean a(Context paramContext, String paramString, long paramLong)
  {
    x.c("[Util] Try to lock file:%s (pid=%d | tid=%d)", new Object[] { paramString, Integer.valueOf(android.os.Process.myPid()), Integer.valueOf(android.os.Process.myTid()) });
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext.getFilesDir());
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(paramString);
      localObject = new File(((StringBuilder)localObject).toString());
      if (((File)localObject).exists())
      {
        if (System.currentTimeMillis() - ((File)localObject).lastModified() < 10000L) {
          return false;
        }
        x.c("[Util] Lock file (%s) is expired, unlock it.", new Object[] { paramString });
        b(paramContext, paramString);
      }
      return ((File)localObject).createNewFile();
    }
    finally
    {
      x.a(paramContext);
    }
    return false;
  }
  
  /* Error */
  public static boolean a(File paramFile1, File paramFile2, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 634
    //   3: iconst_0
    //   4: anewarray 4	java/lang/Object
    //   7: invokestatic 605	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   10: pop
    //   11: aload_0
    //   12: ifnull +363 -> 375
    //   15: aload_1
    //   16: ifnull +359 -> 375
    //   19: aload_0
    //   20: aload_1
    //   21: invokevirtual 635	java/io/File:equals	(Ljava/lang/Object;)Z
    //   24: ifeq +6 -> 30
    //   27: goto +348 -> 375
    //   30: aload_0
    //   31: invokevirtual 32	java/io/File:exists	()Z
    //   34: ifeq +328 -> 362
    //   37: aload_0
    //   38: invokevirtual 35	java/io/File:canRead	()Z
    //   41: ifne +6 -> 47
    //   44: goto +318 -> 362
    //   47: aload_1
    //   48: invokevirtual 638	java/io/File:getParentFile	()Ljava/io/File;
    //   51: ifnull +21 -> 72
    //   54: aload_1
    //   55: invokevirtual 638	java/io/File:getParentFile	()Ljava/io/File;
    //   58: invokevirtual 32	java/io/File:exists	()Z
    //   61: ifne +11 -> 72
    //   64: aload_1
    //   65: invokevirtual 638	java/io/File:getParentFile	()Ljava/io/File;
    //   68: invokevirtual 641	java/io/File:mkdirs	()Z
    //   71: pop
    //   72: aload_1
    //   73: invokevirtual 32	java/io/File:exists	()Z
    //   76: ifne +23 -> 99
    //   79: aload_1
    //   80: invokevirtual 627	java/io/File:createNewFile	()Z
    //   83: pop
    //   84: goto +15 -> 99
    //   87: astore_3
    //   88: aload_3
    //   89: invokestatic 57	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   92: ifne +7 -> 99
    //   95: aload_3
    //   96: invokevirtual 119	java/lang/Throwable:printStackTrace	()V
    //   99: aload_1
    //   100: invokevirtual 32	java/io/File:exists	()Z
    //   103: ifeq +257 -> 360
    //   106: aload_1
    //   107: invokevirtual 35	java/io/File:canRead	()Z
    //   110: ifne +5 -> 115
    //   113: iconst_0
    //   114: ireturn
    //   115: aconst_null
    //   116: astore 4
    //   118: new 41	java/io/FileInputStream
    //   121: dup
    //   122: aload_0
    //   123: invokespecial 44	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   126: astore_3
    //   127: new 643	java/util/zip/ZipOutputStream
    //   130: dup
    //   131: new 645	java/io/BufferedOutputStream
    //   134: dup
    //   135: new 647	java/io/FileOutputStream
    //   138: dup
    //   139: aload_1
    //   140: invokespecial 648	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   143: invokespecial 651	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   146: invokespecial 652	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   149: astore_1
    //   150: aload_1
    //   151: bipush 8
    //   153: invokevirtual 655	java/util/zip/ZipOutputStream:setMethod	(I)V
    //   156: aload_1
    //   157: new 657	java/util/zip/ZipEntry
    //   160: dup
    //   161: aload_0
    //   162: invokevirtual 658	java/io/File:getName	()Ljava/lang/String;
    //   165: invokespecial 659	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   168: invokevirtual 663	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   171: sipush 5000
    //   174: newarray <illegal type>
    //   176: astore_0
    //   177: aload_3
    //   178: aload_0
    //   179: invokevirtual 667	java/io/FileInputStream:read	([B)I
    //   182: istore_2
    //   183: iload_2
    //   184: ifle +13 -> 197
    //   187: aload_1
    //   188: aload_0
    //   189: iconst_0
    //   190: iload_2
    //   191: invokevirtual 670	java/util/zip/ZipOutputStream:write	([BII)V
    //   194: goto -17 -> 177
    //   197: aload_1
    //   198: invokevirtual 673	java/util/zip/ZipOutputStream:flush	()V
    //   201: aload_1
    //   202: invokevirtual 676	java/util/zip/ZipOutputStream:closeEntry	()V
    //   205: aload_3
    //   206: invokevirtual 677	java/io/FileInputStream:close	()V
    //   209: goto +8 -> 217
    //   212: astore_0
    //   213: aload_0
    //   214: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   217: aload_1
    //   218: invokevirtual 678	java/util/zip/ZipOutputStream:close	()V
    //   221: goto +8 -> 229
    //   224: astore_0
    //   225: aload_0
    //   226: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   229: ldc_w 680
    //   232: iconst_0
    //   233: anewarray 4	java/lang/Object
    //   236: invokestatic 605	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   239: pop
    //   240: iconst_1
    //   241: ireturn
    //   242: astore_0
    //   243: goto +6 -> 249
    //   246: astore_0
    //   247: aconst_null
    //   248: astore_1
    //   249: goto +9 -> 258
    //   252: astore_0
    //   253: aconst_null
    //   254: astore_1
    //   255: aload 4
    //   257: astore_3
    //   258: aload_0
    //   259: invokestatic 57	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   262: ifne +7 -> 269
    //   265: aload_0
    //   266: invokevirtual 119	java/lang/Throwable:printStackTrace	()V
    //   269: aload_3
    //   270: ifnull +15 -> 285
    //   273: aload_3
    //   274: invokevirtual 677	java/io/FileInputStream:close	()V
    //   277: goto +8 -> 285
    //   280: astore_0
    //   281: aload_0
    //   282: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   285: aload_1
    //   286: ifnull +15 -> 301
    //   289: aload_1
    //   290: invokevirtual 678	java/util/zip/ZipOutputStream:close	()V
    //   293: goto +8 -> 301
    //   296: astore_0
    //   297: aload_0
    //   298: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   301: ldc_w 680
    //   304: iconst_0
    //   305: anewarray 4	java/lang/Object
    //   308: invokestatic 605	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   311: pop
    //   312: iconst_0
    //   313: ireturn
    //   314: astore_0
    //   315: aload_3
    //   316: ifnull +15 -> 331
    //   319: aload_3
    //   320: invokevirtual 677	java/io/FileInputStream:close	()V
    //   323: goto +8 -> 331
    //   326: astore_3
    //   327: aload_3
    //   328: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   331: aload_1
    //   332: ifnull +15 -> 347
    //   335: aload_1
    //   336: invokevirtual 678	java/util/zip/ZipOutputStream:close	()V
    //   339: goto +8 -> 347
    //   342: astore_1
    //   343: aload_1
    //   344: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   347: ldc_w 680
    //   350: iconst_0
    //   351: anewarray 4	java/lang/Object
    //   354: invokestatic 605	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   357: pop
    //   358: aload_0
    //   359: athrow
    //   360: iconst_0
    //   361: ireturn
    //   362: ldc_w 682
    //   365: iconst_0
    //   366: anewarray 4	java/lang/Object
    //   369: invokestatic 172	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   372: pop
    //   373: iconst_0
    //   374: ireturn
    //   375: ldc_w 684
    //   378: iconst_0
    //   379: anewarray 4	java/lang/Object
    //   382: invokestatic 172	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   385: pop
    //   386: iconst_0
    //   387: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	388	0	paramFile1	File
    //   0	388	1	paramFile2	File
    //   0	388	2	paramInt	int
    //   87	9	3	localThrowable	Throwable
    //   126	194	3	localObject1	Object
    //   326	2	3	localIOException	IOException
    //   116	140	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   47	72	87	finally
    //   72	84	87	finally
    //   205	209	212	java/io/IOException
    //   217	221	224	java/io/IOException
    //   150	177	242	finally
    //   177	183	242	finally
    //   187	194	242	finally
    //   197	205	242	finally
    //   127	150	246	finally
    //   118	127	252	finally
    //   273	277	280	java/io/IOException
    //   289	293	296	java/io/IOException
    //   258	269	314	finally
    //   319	323	326	java/io/IOException
    //   335	339	342	java/io/IOException
  }
  
  public static boolean a(Runnable paramRunnable)
  {
    if (paramRunnable != null)
    {
      Object localObject = w.a();
      if (localObject != null) {
        return ((w)localObject).a(paramRunnable);
      }
      localObject = paramRunnable.getClass().getName().split("\\.");
      if (a(paramRunnable, localObject[(localObject.length - 1)]) != null) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.trim().length() <= 0);
  }
  
  public static byte[] a(Parcelable paramParcelable)
  {
    Parcel localParcel = Parcel.obtain();
    paramParcelable.writeToParcel(localParcel, 0);
    paramParcelable = localParcel.marshall();
    localParcel.recycle();
    return paramParcelable;
  }
  
  /* Error */
  public static byte[] a(File paramFile, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +221 -> 222
    //   4: aload_1
    //   5: invokevirtual 390	java/lang/String:length	()I
    //   8: ifne +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: ldc_w 634
    //   16: iconst_0
    //   17: anewarray 4	java/lang/Object
    //   20: invokestatic 605	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   23: pop
    //   24: new 719	java/io/ByteArrayInputStream
    //   27: dup
    //   28: aload_1
    //   29: ldc_w 721
    //   32: invokevirtual 725	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   35: invokespecial 727	java/io/ByteArrayInputStream:<init>	([B)V
    //   38: astore_1
    //   39: new 729	java/io/ByteArrayOutputStream
    //   42: dup
    //   43: invokespecial 730	java/io/ByteArrayOutputStream:<init>	()V
    //   46: astore 4
    //   48: new 643	java/util/zip/ZipOutputStream
    //   51: dup
    //   52: aload 4
    //   54: invokespecial 652	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   57: astore_0
    //   58: aload_0
    //   59: bipush 8
    //   61: invokevirtual 655	java/util/zip/ZipOutputStream:setMethod	(I)V
    //   64: aload_0
    //   65: new 657	java/util/zip/ZipEntry
    //   68: dup
    //   69: aload_2
    //   70: invokespecial 659	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   73: invokevirtual 663	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   76: sipush 1024
    //   79: newarray <illegal type>
    //   81: astore_2
    //   82: aload_1
    //   83: aload_2
    //   84: invokevirtual 731	java/io/ByteArrayInputStream:read	([B)I
    //   87: istore_3
    //   88: iload_3
    //   89: ifle +13 -> 102
    //   92: aload_0
    //   93: aload_2
    //   94: iconst_0
    //   95: iload_3
    //   96: invokevirtual 670	java/util/zip/ZipOutputStream:write	([BII)V
    //   99: goto -17 -> 82
    //   102: aload_0
    //   103: invokevirtual 676	java/util/zip/ZipOutputStream:closeEntry	()V
    //   106: aload_0
    //   107: invokevirtual 673	java/util/zip/ZipOutputStream:flush	()V
    //   110: aload_0
    //   111: invokevirtual 734	java/util/zip/ZipOutputStream:finish	()V
    //   114: aload 4
    //   116: invokevirtual 737	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   119: astore_1
    //   120: aload_0
    //   121: invokevirtual 678	java/util/zip/ZipOutputStream:close	()V
    //   124: goto +8 -> 132
    //   127: astore_0
    //   128: aload_0
    //   129: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   132: ldc_w 680
    //   135: iconst_0
    //   136: anewarray 4	java/lang/Object
    //   139: invokestatic 605	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   142: pop
    //   143: aload_1
    //   144: areturn
    //   145: astore_1
    //   146: goto +6 -> 152
    //   149: astore_1
    //   150: aconst_null
    //   151: astore_0
    //   152: aload_1
    //   153: invokestatic 57	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   156: ifne +7 -> 163
    //   159: aload_1
    //   160: invokevirtual 119	java/lang/Throwable:printStackTrace	()V
    //   163: aload_0
    //   164: ifnull +15 -> 179
    //   167: aload_0
    //   168: invokevirtual 678	java/util/zip/ZipOutputStream:close	()V
    //   171: goto +8 -> 179
    //   174: astore_0
    //   175: aload_0
    //   176: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   179: ldc_w 680
    //   182: iconst_0
    //   183: anewarray 4	java/lang/Object
    //   186: invokestatic 605	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   189: pop
    //   190: aconst_null
    //   191: areturn
    //   192: astore_1
    //   193: aload_0
    //   194: ifnull +15 -> 209
    //   197: aload_0
    //   198: invokevirtual 678	java/util/zip/ZipOutputStream:close	()V
    //   201: goto +8 -> 209
    //   204: astore_0
    //   205: aload_0
    //   206: invokevirtual 234	java/io/IOException:printStackTrace	()V
    //   209: ldc_w 680
    //   212: iconst_0
    //   213: anewarray 4	java/lang/Object
    //   216: invokestatic 605	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   219: pop
    //   220: aload_1
    //   221: athrow
    //   222: aconst_null
    //   223: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	paramFile	File
    //   0	224	1	paramString1	String
    //   0	224	2	paramString2	String
    //   87	9	3	i	int
    //   46	69	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   120	124	127	java/io/IOException
    //   58	82	145	finally
    //   82	88	145	finally
    //   92	99	145	finally
    //   102	120	145	finally
    //   24	58	149	finally
    //   167	171	174	java/io/IOException
    //   152	163	192	finally
    //   197	201	204	java/io/IOException
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return paramArrayOfByte;
    }
    x.c("[Util] Zip %d bytes data with type %s", new Object[] { Integer.valueOf(paramArrayOfByte.length), "Gzip" });
    try
    {
      ae localae = ad.a(2);
      if (localae == null) {
        return null;
      }
      paramArrayOfByte = localae.a(paramArrayOfByte);
      return paramArrayOfByte;
    }
    finally
    {
      if (!x.a(paramArrayOfByte)) {
        paramArrayOfByte.printStackTrace();
      }
    }
    return null;
  }
  
  public static long b()
  {
    try
    {
      long l = (System.currentTimeMillis() + TimeZone.getDefault().getRawOffset()) / 86400000L;
      int i = TimeZone.getDefault().getRawOffset();
      return l * 86400000L - i;
    }
    finally
    {
      if (!x.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return -1L;
  }
  
  public static long b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return -1L;
    }
    try
    {
      long l = Long.parseLong(new String(paramArrayOfByte, "utf-8"));
      return l;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return -1L;
  }
  
  public static String b(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
    paramThrowable.printStackTrace(localPrintWriter);
    localPrintWriter.flush();
    return localStringWriter.toString();
  }
  
  public static Map<String, String> b(Parcel paramParcel)
  {
    Object localObject = paramParcel.readBundle();
    paramParcel = null;
    if (localObject == null) {
      return null;
    }
    ArrayList localArrayList1 = ((Bundle)localObject).getStringArrayList("keys");
    ArrayList localArrayList2 = ((Bundle)localObject).getStringArrayList("values");
    int i = 0;
    if ((localArrayList1 != null) && (localArrayList2 != null) && (localArrayList1.size() == localArrayList2.size()))
    {
      localObject = new HashMap(localArrayList1.size());
      for (;;)
      {
        paramParcel = (Parcel)localObject;
        if (i >= localArrayList1.size()) {
          break;
        }
        ((HashMap)localObject).put(localArrayList1.get(i), localArrayList2.get(i));
        i += 1;
      }
    }
    x.e("map parcel error!", new Object[0]);
    return paramParcel;
  }
  
  public static void b(long paramLong)
  {
    try
    {
      Thread.sleep(paramLong);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
  }
  
  public static void b(Parcel paramParcel, Map<String, String> paramMap)
  {
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      int i = paramMap.size();
      ArrayList localArrayList1 = new ArrayList(i);
      ArrayList localArrayList2 = new ArrayList(i);
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        localArrayList1.add(localEntry.getKey());
        localArrayList2.add(localEntry.getValue());
      }
      paramMap = new Bundle();
      paramMap.putStringArrayList("keys", localArrayList1);
      paramMap.putStringArrayList("values", localArrayList2);
      paramParcel.writeBundle(paramMap);
      return;
    }
    paramParcel.writeBundle(null);
  }
  
  public static void b(String paramString)
  {
    if (paramString == null) {
      return;
    }
    paramString = new File(paramString);
    if ((paramString.isFile()) && (paramString.exists()) && (paramString.canWrite())) {
      paramString.delete();
    }
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if ((a.b() != null) && (a.b().E != null)) {
      a.b().E.edit().putString(paramString1, paramString2).apply();
    }
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    x.c("[Util] Try to unlock file: %s (pid=%d | tid=%d)", new Object[] { paramString, Integer.valueOf(android.os.Process.myPid()), Integer.valueOf(android.os.Process.myTid()) });
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.getFilesDir());
      localStringBuilder.append(File.separator);
      localStringBuilder.append(paramString);
      paramContext = new File(localStringBuilder.toString());
      if (paramContext.exists()) {
        return paramContext.delete();
      }
      return true;
    }
    finally
    {
      x.a(paramContext);
    }
    return false;
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return paramArrayOfByte;
    }
    x.c("[Util] Unzip %d bytes data with type %s", new Object[] { Integer.valueOf(paramArrayOfByte.length), "Gzip" });
    try
    {
      ae localae = ad.a(2);
      if (localae == null) {
        return null;
      }
      paramArrayOfByte = localae.b(paramArrayOfByte);
      return paramArrayOfByte;
    }
    finally
    {
      if ((paramArrayOfByte.getMessage() != null) && (paramArrayOfByte.getMessage().contains("Not in GZIP format")))
      {
        x.d(paramArrayOfByte.getMessage(), new Object[0]);
        return null;
      }
      if (!x.a(paramArrayOfByte)) {
        paramArrayOfByte.printStackTrace();
      }
    }
    return null;
  }
  
  public static String c(String paramString1, String paramString2)
  {
    if ((a.b() != null) && (a.b().E != null)) {
      return a.b().E.getString(paramString1, paramString2);
    }
    return "";
  }
  
  public static boolean c(String paramString)
  {
    int i;
    if ((paramString != null) && (paramString.trim().length() > 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return false;
    }
    if (paramString.length() > 255)
    {
      x.a("URL(%s)'s length is larger than 255.", new Object[] { paramString });
      return false;
    }
    if (!paramString.toLowerCase().startsWith("http"))
    {
      x.a("URL(%s) is not start with \"http\".", new Object[] { paramString });
      return false;
    }
    return true;
  }
  
  public static byte[] c(long paramLong)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramLong);
      localObject = ((StringBuilder)localObject).toString().getBytes("utf-8");
      return (byte[])localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\proguard\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */