package com.huawei.updatesdk.sdk.a.d.c;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.huawei.updatesdk.sdk.a.d.b.a.b;

public class a
{
  private static final Uri a = Uri.parse("content://telephony/carriers/preferapn");
  private static final Uri b = Uri.parse("content://telephony/carriers/preferapn/0");
  private static final Uri c = Uri.parse("content://telephony/carriers/preferapn/1");
  
  /* Error */
  public static a a(Context paramContext)
    throws SecurityException
  {
    // Byte code:
    //   0: new 6	com/huawei/updatesdk/sdk/a/d/c/a$a
    //   3: dup
    //   4: invokespecial 39	com/huawei/updatesdk/sdk/a/d/c/a$a:<init>	()V
    //   7: astore_2
    //   8: aconst_null
    //   9: astore_3
    //   10: aconst_null
    //   11: astore 4
    //   13: aload 4
    //   15: astore_1
    //   16: invokestatic 44	com/huawei/updatesdk/sdk/a/d/b/a/b:b	()Z
    //   19: ifeq +14 -> 33
    //   22: aload 4
    //   24: astore_1
    //   25: aload_0
    //   26: invokestatic 48	com/huawei/updatesdk/sdk/a/d/c/a:d	(Landroid/content/Context;)Landroid/database/Cursor;
    //   29: astore_0
    //   30: goto +11 -> 41
    //   33: aload 4
    //   35: astore_1
    //   36: aload_0
    //   37: invokestatic 50	com/huawei/updatesdk/sdk/a/d/c/a:c	(Landroid/content/Context;)Landroid/database/Cursor;
    //   40: astore_0
    //   41: aload_0
    //   42: ifnonnull +15 -> 57
    //   45: aload_0
    //   46: ifnull +9 -> 55
    //   49: aload_0
    //   50: invokeinterface 55 1 0
    //   55: aconst_null
    //   56: areturn
    //   57: aload_0
    //   58: invokeinterface 58 1 0
    //   63: ifeq +66 -> 129
    //   66: aload_2
    //   67: aload_0
    //   68: aload_0
    //   69: ldc 60
    //   71: invokeinterface 64 2 0
    //   76: invokeinterface 68 2 0
    //   81: invokevirtual 71	com/huawei/updatesdk/sdk/a/d/c/a$a:a	(Ljava/lang/String;)V
    //   84: aload_2
    //   85: aload_0
    //   86: aload_0
    //   87: ldc 73
    //   89: invokeinterface 64 2 0
    //   94: invokeinterface 68 2 0
    //   99: invokevirtual 75	com/huawei/updatesdk/sdk/a/d/c/a$a:c	(Ljava/lang/String;)V
    //   102: aload_2
    //   103: aload_0
    //   104: aload_0
    //   105: ldc 77
    //   107: invokeinterface 64 2 0
    //   112: invokeinterface 68 2 0
    //   117: invokestatic 83	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   120: invokevirtual 89	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   123: invokevirtual 91	com/huawei/updatesdk/sdk/a/d/c/a$a:b	(Ljava/lang/String;)V
    //   126: goto -69 -> 57
    //   129: aload_0
    //   130: ifnull +53 -> 183
    //   133: aload_0
    //   134: invokeinterface 55 1 0
    //   139: goto +44 -> 183
    //   142: astore_2
    //   143: aload_0
    //   144: astore_1
    //   145: aload_2
    //   146: astore_0
    //   147: goto +74 -> 221
    //   150: astore_1
    //   151: goto +14 -> 165
    //   154: astore_2
    //   155: goto +52 -> 207
    //   158: astore_0
    //   159: goto +62 -> 221
    //   162: astore_1
    //   163: aconst_null
    //   164: astore_0
    //   165: ldc 93
    //   167: ldc 95
    //   169: aload_1
    //   170: invokestatic 100	com/huawei/updatesdk/sdk/a/c/a/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   173: aload_0
    //   174: ifnull +9 -> 183
    //   177: aload_0
    //   178: invokeinterface 55 1 0
    //   183: aload_2
    //   184: astore_0
    //   185: aload_2
    //   186: invokevirtual 103	com/huawei/updatesdk/sdk/a/d/c/a$a:a	()Ljava/lang/String;
    //   189: ifnonnull +5 -> 194
    //   192: aconst_null
    //   193: astore_0
    //   194: aload_0
    //   195: areturn
    //   196: astore_2
    //   197: aload_0
    //   198: astore_1
    //   199: aload_2
    //   200: astore_0
    //   201: goto +20 -> 221
    //   204: astore_2
    //   205: aload_3
    //   206: astore_0
    //   207: aload_0
    //   208: astore_1
    //   209: ldc 93
    //   211: ldc 105
    //   213: aload_2
    //   214: invokestatic 100	com/huawei/updatesdk/sdk/a/c/a/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   217: aload_0
    //   218: astore_1
    //   219: aload_2
    //   220: athrow
    //   221: aload_1
    //   222: ifnull +9 -> 231
    //   225: aload_1
    //   226: invokeinterface 55 1 0
    //   231: aload_0
    //   232: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	paramContext	Context
    //   15	130	1	localObject1	Object
    //   150	1	1	localException1	Exception
    //   162	8	1	localException2	Exception
    //   198	28	1	localContext	Context
    //   7	96	2	locala	a
    //   142	4	2	localObject2	Object
    //   154	32	2	localSecurityException1	SecurityException
    //   196	4	2	localObject3	Object
    //   204	16	2	localSecurityException2	SecurityException
    //   9	197	3	localObject4	Object
    //   11	23	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   57	126	142	finally
    //   57	126	150	java/lang/Exception
    //   57	126	154	java/lang/SecurityException
    //   16	22	158	finally
    //   25	30	158	finally
    //   36	41	158	finally
    //   209	217	158	finally
    //   219	221	158	finally
    //   16	22	162	java/lang/Exception
    //   25	30	162	java/lang/Exception
    //   36	41	162	java/lang/Exception
    //   165	173	196	finally
    //   16	22	204	java/lang/SecurityException
    //   25	30	204	java/lang/SecurityException
    //   36	41	204	java/lang/SecurityException
  }
  
  public static boolean b(Context paramContext)
  {
    try
    {
      paramContext = a(paramContext);
      if (paramContext != null) {
        if (paramContext.b() != null)
        {
          boolean bool = paramContext.b().contains("wap");
          if (bool) {}
        }
        else
        {
          return false;
        }
      }
      return true;
    }
    catch (SecurityException paramContext)
    {
      com.huawei.updatesdk.sdk.a.c.a.a.a.a("ApnUtil", "isWap(), SecurityException: ", paramContext);
    }
    return false;
  }
  
  private static Cursor c(Context paramContext)
  {
    return paramContext.getContentResolver().query(a, null, null, null, null);
  }
  
  private static Cursor d(Context paramContext)
  {
    Object localObject1;
    if (b.a().a() == 0)
    {
      localObject2 = f(paramContext);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = e(paramContext);
      }
    }
    else
    {
      localObject2 = e(paramContext);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = f(paramContext);
      }
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = c(paramContext);
    }
    return (Cursor)localObject2;
  }
  
  private static Cursor e(Context paramContext)
  {
    return paramContext.getContentResolver().query(c, null, null, null, null);
  }
  
  private static Cursor f(Context paramContext)
  {
    return paramContext.getContentResolver().query(b, null, null, null, null);
  }
  
  public static class a
  {
    private String a;
    private String b;
    private String c;
    
    public String a()
    {
      return this.a;
    }
    
    public void a(String paramString)
    {
      this.a = paramString;
    }
    
    public String b()
    {
      return this.b;
    }
    
    public void b(String paramString)
    {
      this.b = paramString;
    }
    
    public void c(String paramString)
    {
      this.c = paramString;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\sdk\a\d\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */