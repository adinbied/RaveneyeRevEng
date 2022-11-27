package com.xiaomi.channel.commonutils.logger;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class b
{
  private static int jdField_a_of_type_Int = 2;
  private static LoggerInterface jdField_a_of_type_ComXiaomiChannelCommonutilsLoggerLoggerInterface = new a();
  private static final Integer jdField_a_of_type_JavaLangInteger = Integer.valueOf(-1);
  private static final HashMap<Integer, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
  private static final HashMap<Integer, String> b = new HashMap();
  
  public static int a()
  {
    return jdField_a_of_type_Int;
  }
  
  public static Integer a(String paramString)
  {
    if (jdField_a_of_type_Int <= 1)
    {
      Integer localInteger = Integer.valueOf(jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet());
      jdField_a_of_type_JavaUtilHashMap.put(localInteger, Long.valueOf(System.currentTimeMillis()));
      b.put(localInteger, paramString);
      LoggerInterface localLoggerInterface = jdField_a_of_type_ComXiaomiChannelCommonutilsLoggerLoggerInterface;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" starts");
      localLoggerInterface.log(localStringBuilder.toString());
      return localInteger;
    }
    return jdField_a_of_type_JavaLangInteger;
  }
  
  public static void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 5))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("set log level as ");
      localStringBuilder.append(paramInt);
      a(2, localStringBuilder.toString());
    }
    jdField_a_of_type_Int = paramInt;
  }
  
  public static void a(int paramInt, String paramString)
  {
    if (paramInt >= jdField_a_of_type_Int) {
      jdField_a_of_type_ComXiaomiChannelCommonutilsLoggerLoggerInterface.log(paramString);
    }
  }
  
  public static void a(int paramInt, String paramString, Throwable paramThrowable)
  {
    if (paramInt >= jdField_a_of_type_Int) {
      jdField_a_of_type_ComXiaomiChannelCommonutilsLoggerLoggerInterface.log(paramString, paramThrowable);
    }
  }
  
  public static void a(int paramInt, Throwable paramThrowable)
  {
    if (paramInt >= jdField_a_of_type_Int) {
      jdField_a_of_type_ComXiaomiChannelCommonutilsLoggerLoggerInterface.log("", paramThrowable);
    }
  }
  
  public static void a(LoggerInterface paramLoggerInterface)
  {
    jdField_a_of_type_ComXiaomiChannelCommonutilsLoggerLoggerInterface = paramLoggerInterface;
  }
  
  public static void a(Integer paramInteger)
  {
    if (jdField_a_of_type_Int <= 1)
    {
      if (!jdField_a_of_type_JavaUtilHashMap.containsKey(paramInteger)) {
        return;
      }
      long l1 = ((Long)jdField_a_of_type_JavaUtilHashMap.remove(paramInteger)).longValue();
      paramInteger = (String)b.remove(paramInteger);
      long l2 = System.currentTimeMillis();
      LoggerInterface localLoggerInterface = jdField_a_of_type_ComXiaomiChannelCommonutilsLoggerLoggerInterface;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInteger);
      localStringBuilder.append(" ends in ");
      localStringBuilder.append(l2 - l1);
      localStringBuilder.append(" ms");
      localLoggerInterface.log(localStringBuilder.toString());
    }
  }
  
  public static void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Thread:");
    localStringBuilder.append(Thread.currentThread().getId());
    localStringBuilder.append("] ");
    localStringBuilder.append(paramString);
    a(2, localStringBuilder.toString());
  }
  
  public static void a(String paramString, Throwable paramThrowable)
  {
    a(4, paramString, paramThrowable);
  }
  
  public static void a(Throwable paramThrowable)
  {
    a(4, paramThrowable);
  }
  
  public static void b(String paramString)
  {
    a(0, paramString);
  }
  
  public static void c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Thread:");
    localStringBuilder.append(Thread.currentThread().getId());
    localStringBuilder.append("] ");
    localStringBuilder.append(paramString);
    a(1, localStringBuilder.toString());
  }
  
  public static void d(String paramString)
  {
    a(4, paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\channel\commonutils\logger\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */