package com.huawei.updatesdk.sdk.service.download;

import java.lang.reflect.Field;

public class i
{
  private static Object a(Object paramObject, String paramString)
    throws IllegalAccessException, IllegalArgumentException, NoSuchFieldException
  {
    for (Class localClass = paramObject.getClass(); localClass != null; localClass = localClass.getSuperclass()) {
      try
      {
        Object localObject = localClass.getDeclaredField(paramString);
        ((Field)localObject).setAccessible(true);
        localObject = ((Field)localObject).get(paramObject);
        return localObject;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        for (;;) {}
      }
    }
    throw new NoSuchFieldException();
  }
  
  /* Error */
  public static String a(java.net.HttpURLConnection paramHttpURLConnection)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +6 -> 7
    //   4: ldc 44
    //   6: areturn
    //   7: aload_0
    //   8: instanceof 46
    //   11: ifeq +16 -> 27
    //   14: aload_0
    //   15: ldc 48
    //   17: invokestatic 50	com/huawei/updatesdk/sdk/service/download/i:a	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   20: checkcast 52	java/net/HttpURLConnection
    //   23: invokestatic 54	com/huawei/updatesdk/sdk/service/download/i:a	(Ljava/net/HttpURLConnection;)Ljava/lang/String;
    //   26: areturn
    //   27: aload_0
    //   28: ldc 56
    //   30: invokestatic 50	com/huawei/updatesdk/sdk/service/download/i:a	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   33: astore_0
    //   34: aload_0
    //   35: ifnonnull +13 -> 48
    //   38: ldc 58
    //   40: ldc 60
    //   42: invokestatic 66	com/huawei/updatesdk/sdk/a/c/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: ldc 44
    //   47: areturn
    //   48: aload_0
    //   49: ldc 68
    //   51: invokestatic 50	com/huawei/updatesdk/sdk/service/download/i:a	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   54: astore_1
    //   55: aload_1
    //   56: ifnonnull +24 -> 80
    //   59: aload_0
    //   60: ldc 70
    //   62: invokestatic 50	com/huawei/updatesdk/sdk/service/download/i:a	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   65: ldc 72
    //   67: invokestatic 50	com/huawei/updatesdk/sdk/service/download/i:a	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   70: checkcast 74	java/net/InetSocketAddress
    //   73: invokevirtual 78	java/net/InetSocketAddress:getAddress	()Ljava/net/InetAddress;
    //   76: invokevirtual 84	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   79: areturn
    //   80: aload_1
    //   81: ldc 86
    //   83: invokestatic 50	com/huawei/updatesdk/sdk/service/download/i:a	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   86: checkcast 88	java/net/Socket
    //   89: invokevirtual 91	java/net/Socket:getInetAddress	()Ljava/net/InetAddress;
    //   92: invokevirtual 84	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   95: astore_0
    //   96: aload_0
    //   97: areturn
    //   98: astore_1
    //   99: new 93	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   106: astore_0
    //   107: aload_0
    //   108: ldc 96
    //   110: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload_1
    //   115: invokevirtual 105	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   118: astore_1
    //   119: goto +48 -> 167
    //   122: astore_1
    //   123: new 93	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   130: astore_0
    //   131: aload_0
    //   132: ldc 107
    //   134: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload_1
    //   139: invokevirtual 108	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   142: astore_1
    //   143: goto +24 -> 167
    //   146: astore_1
    //   147: new 93	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   154: astore_0
    //   155: aload_0
    //   156: ldc 110
    //   158: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload_1
    //   163: invokevirtual 111	java/lang/NoSuchFieldException:getMessage	()Ljava/lang/String;
    //   166: astore_1
    //   167: aload_0
    //   168: aload_1
    //   169: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: ldc 58
    //   175: aload_0
    //   176: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 66	com/huawei/updatesdk/sdk/a/c/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: ldc 44
    //   184: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	paramHttpURLConnection	java.net.HttpURLConnection
    //   54	27	1	localObject1	Object
    //   98	17	1	localObject2	Object
    //   118	1	1	str1	String
    //   122	17	1	localIllegalArgumentException	IllegalArgumentException
    //   142	1	1	str2	String
    //   146	17	1	localNoSuchFieldException	NoSuchFieldException
    //   166	3	1	str3	String
    // Exception table:
    //   from	to	target	type
    //   7	27	98	finally
    //   27	34	98	finally
    //   38	45	98	finally
    //   48	55	98	finally
    //   59	80	98	finally
    //   80	96	98	finally
    //   7	27	122	java/lang/IllegalArgumentException
    //   27	34	122	java/lang/IllegalArgumentException
    //   38	45	122	java/lang/IllegalArgumentException
    //   48	55	122	java/lang/IllegalArgumentException
    //   59	80	122	java/lang/IllegalArgumentException
    //   80	96	122	java/lang/IllegalArgumentException
    //   7	27	146	java/lang/NoSuchFieldException
    //   27	34	146	java/lang/NoSuchFieldException
    //   38	45	146	java/lang/NoSuchFieldException
    //   48	55	146	java/lang/NoSuchFieldException
    //   59	80	146	java/lang/NoSuchFieldException
    //   80	96	146	java/lang/NoSuchFieldException
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\sdk\service\download\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */