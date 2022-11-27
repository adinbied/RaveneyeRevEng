package com.xiaomi.push;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import java.util.concurrent.LinkedBlockingQueue;

final class j
{
  /* Error */
  public static a a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 22	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   3: invokestatic 25	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   6: if_acmpeq +121 -> 127
    //   9: aload_0
    //   10: invokevirtual 31	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   13: ldc 33
    //   15: iconst_0
    //   16: invokevirtual 39	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   19: pop
    //   20: new 9	com/xiaomi/push/j$b
    //   23: dup
    //   24: aconst_null
    //   25: invokespecial 43	com/xiaomi/push/j$b:<init>	(Lcom/xiaomi/push/k;)V
    //   28: astore_1
    //   29: new 45	android/content/Intent
    //   32: dup
    //   33: ldc 47
    //   35: invokespecial 50	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   38: astore_2
    //   39: aload_2
    //   40: ldc 52
    //   42: invokevirtual 56	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   45: pop
    //   46: aload_0
    //   47: aload_2
    //   48: aload_1
    //   49: iconst_1
    //   50: invokevirtual 60	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   53: ifeq +61 -> 114
    //   56: aload_1
    //   57: invokevirtual 63	com/xiaomi/push/j$b:a	()Landroid/os/IBinder;
    //   60: astore_2
    //   61: aload_2
    //   62: ifnull +30 -> 92
    //   65: new 6	com/xiaomi/push/j$a
    //   68: dup
    //   69: new 12	com/xiaomi/push/j$c
    //   72: dup
    //   73: aload_2
    //   74: invokespecial 66	com/xiaomi/push/j$c:<init>	(Landroid/os/IBinder;)V
    //   77: invokevirtual 69	com/xiaomi/push/j$c:a	()Ljava/lang/String;
    //   80: iconst_0
    //   81: invokespecial 72	com/xiaomi/push/j$a:<init>	(Ljava/lang/String;Z)V
    //   84: astore_2
    //   85: aload_0
    //   86: aload_1
    //   87: invokevirtual 76	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   90: aload_2
    //   91: areturn
    //   92: aload_0
    //   93: aload_1
    //   94: invokevirtual 76	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   97: goto +17 -> 114
    //   100: astore_2
    //   101: goto +6 -> 107
    //   104: astore_2
    //   105: aload_2
    //   106: athrow
    //   107: aload_0
    //   108: aload_1
    //   109: invokevirtual 76	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   112: aload_2
    //   113: athrow
    //   114: new 78	java/io/IOException
    //   117: dup
    //   118: ldc 80
    //   120: invokespecial 81	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   123: athrow
    //   124: astore_0
    //   125: aload_0
    //   126: athrow
    //   127: new 83	java/lang/IllegalStateException
    //   130: dup
    //   131: ldc 85
    //   133: invokespecial 86	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   136: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	paramContext	android.content.Context
    //   28	81	1	localb	b
    //   38	53	2	localObject1	Object
    //   100	1	2	localObject2	Object
    //   104	9	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   56	61	100	finally
    //   65	85	100	finally
    //   105	107	100	finally
    //   56	61	104	java/lang/Exception
    //   65	85	104	java/lang/Exception
    //   9	20	124	java/lang/Exception
  }
  
  static final class a
  {
    private final String jdField_a_of_type_JavaLangString;
    private final boolean jdField_a_of_type_Boolean;
    
    a(String paramString, boolean paramBoolean)
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_Boolean = paramBoolean;
    }
    
    public String a()
    {
      return this.jdField_a_of_type_JavaLangString;
    }
  }
  
  private static final class b
    implements ServiceConnection
  {
    private final LinkedBlockingQueue<IBinder> jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue = new LinkedBlockingQueue(1);
    boolean jdField_a_of_type_Boolean = false;
    
    public IBinder a()
    {
      return null;
    }
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      try
      {
        this.jdField_a_of_type_JavaUtilConcurrentLinkedBlockingQueue.put(paramIBinder);
        return;
      }
      catch (InterruptedException paramComponentName) {}
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName) {}
  }
  
  private static final class c
    implements IInterface
  {
    private IBinder a;
    
    public c(IBinder paramIBinder)
    {
      this.a = paramIBinder;
    }
    
    public String a()
    {
      return null;
    }
    
    public IBinder asBinder()
    {
      return this.a;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */