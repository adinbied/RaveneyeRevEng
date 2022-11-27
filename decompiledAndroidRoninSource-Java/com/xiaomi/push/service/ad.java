package com.xiaomi.push.service;

import android.os.Process;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.cz;
import com.xiaomi.push.el.a;
import com.xiaomi.push.hg;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class ad
{
  private static long jdField_a_of_type_Long = 0L;
  private static ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = new ThreadPoolExecutor(1, 1, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue());
  private static final Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})");
  
  /* Error */
  private static String a(String paramString)
  {
    // Byte code:
    //   0: new 48	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 51	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: new 53	java/io/BufferedReader
    //   12: dup
    //   13: new 55	java/io/FileReader
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 58	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   21: invokespecial 61	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   24: astore_0
    //   25: new 63	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   32: astore_1
    //   33: aload_0
    //   34: invokevirtual 68	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   37: astore_2
    //   38: aload_2
    //   39: ifnull +19 -> 58
    //   42: aload_1
    //   43: ldc 70
    //   45: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload_1
    //   50: aload_2
    //   51: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: goto -22 -> 33
    //   58: aload_1
    //   59: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: astore_1
    //   63: aload_0
    //   64: invokestatic 82	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   67: aload_1
    //   68: areturn
    //   69: astore_1
    //   70: goto +6 -> 76
    //   73: astore_1
    //   74: aconst_null
    //   75: astore_0
    //   76: aload_0
    //   77: invokestatic 82	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   80: aload_1
    //   81: athrow
    //   82: aconst_null
    //   83: astore_0
    //   84: aload_0
    //   85: invokestatic 82	com/xiaomi/push/y:a	(Ljava/io/Closeable;)V
    //   88: aconst_null
    //   89: areturn
    //   90: astore_0
    //   91: goto -9 -> 82
    //   94: astore_1
    //   95: goto -11 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	paramString	String
    //   32	36	1	localObject1	Object
    //   69	1	1	localObject2	Object
    //   73	8	1	localObject3	Object
    //   94	1	1	localException	Exception
    //   37	14	2	str	String
    // Exception table:
    //   from	to	target	type
    //   25	33	69	finally
    //   33	38	69	finally
    //   42	55	69	finally
    //   58	63	69	finally
    //   9	25	73	finally
    //   9	25	90	java/lang/Exception
    //   25	33	94	java/lang/Exception
    //   33	38	94	java/lang/Exception
    //   42	55	94	java/lang/Exception
    //   58	63	94	java/lang/Exception
  }
  
  public static void a()
  {
    long l = System.currentTimeMillis();
    if ((jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.getActiveCount() > 0) && (l - jdField_a_of_type_Long < 1800000L)) {
      return;
    }
    if (hg.a().a())
    {
      el.a locala = bb.a().a();
      if ((locala != null) && (locala.e() > 0))
      {
        jdField_a_of_type_Long = l;
        a(locala.a(), true);
      }
    }
  }
  
  public static void a(List<String> paramList, boolean paramBoolean)
  {
    jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.execute(new ae(paramList, paramBoolean));
  }
  
  public static void b()
  {
    String str = a("/proc/self/net/tcp");
    StringBuilder localStringBuilder;
    if (!TextUtils.isEmpty(str))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("dump tcp for uid = ");
      localStringBuilder.append(Process.myUid());
      b.a(localStringBuilder.toString());
      b.a(str);
    }
    str = a("/proc/self/net/tcp6");
    if (!TextUtils.isEmpty(str))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("dump tcp6 for uid = ");
      localStringBuilder.append(Process.myUid());
      b.a(localStringBuilder.toString());
      b.a(str);
    }
  }
  
  private static boolean b(String paramString)
  {
    long l1 = System.currentTimeMillis();
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ConnectivityTest: begin to connect to ");
      ((StringBuilder)localObject1).append(paramString);
      b.a(((StringBuilder)localObject1).toString());
      localObject1 = new Socket();
      ((Socket)localObject1).connect(cz.a(paramString, 5222), 5000);
      ((Socket)localObject1).setTcpNoDelay(true);
      long l2 = System.currentTimeMillis();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ConnectivityTest: connect to ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" in ");
      localStringBuilder.append(l2 - l1);
      b.a(localStringBuilder.toString());
      ((Socket)localObject1).close();
      return true;
    }
    finally
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ConnectivityTest: could not connect to:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" exception: ");
      localStringBuilder.append(localObject2.getClass().getSimpleName());
      localStringBuilder.append(" description: ");
      localStringBuilder.append(((Throwable)localObject2).getMessage());
      b.d(localStringBuilder.toString());
    }
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\service\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */