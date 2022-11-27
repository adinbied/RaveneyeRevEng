package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import java.util.concurrent.atomic.AtomicBoolean;

class CrashlyticsUncaughtExceptionHandler
  implements Thread.UncaughtExceptionHandler
{
  private final CrashListener crashListener;
  private final Thread.UncaughtExceptionHandler defaultHandler;
  private final AtomicBoolean isHandlingException;
  private final SettingsDataProvider settingsDataProvider;
  
  public CrashlyticsUncaughtExceptionHandler(CrashListener paramCrashListener, SettingsDataProvider paramSettingsDataProvider, Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler)
  {
    this.crashListener = paramCrashListener;
    this.settingsDataProvider = paramSettingsDataProvider;
    this.defaultHandler = paramUncaughtExceptionHandler;
    this.isHandlingException = new AtomicBoolean(false);
  }
  
  boolean isHandlingException()
  {
    return this.isHandlingException.get();
  }
  
  /* Error */
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 35	com/google/firebase/crashlytics/internal/common/CrashlyticsUncaughtExceptionHandler:isHandlingException	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4: iconst_1
    //   5: invokevirtual 47	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   8: aload_1
    //   9: ifnonnull +14 -> 23
    //   12: invokestatic 53	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   15: ldc 55
    //   17: invokevirtual 59	com/google/firebase/crashlytics/internal/Logger:e	(Ljava/lang/String;)V
    //   20: goto +33 -> 53
    //   23: aload_2
    //   24: ifnonnull +14 -> 38
    //   27: invokestatic 53	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   30: ldc 61
    //   32: invokevirtual 59	com/google/firebase/crashlytics/internal/Logger:e	(Ljava/lang/String;)V
    //   35: goto +18 -> 53
    //   38: aload_0
    //   39: getfield 24	com/google/firebase/crashlytics/internal/common/CrashlyticsUncaughtExceptionHandler:crashListener	Lcom/google/firebase/crashlytics/internal/common/CrashlyticsUncaughtExceptionHandler$CrashListener;
    //   42: aload_0
    //   43: getfield 26	com/google/firebase/crashlytics/internal/common/CrashlyticsUncaughtExceptionHandler:settingsDataProvider	Lcom/google/firebase/crashlytics/internal/settings/SettingsDataProvider;
    //   46: aload_1
    //   47: aload_2
    //   48: invokeinterface 65 4 0
    //   53: invokestatic 53	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   56: ldc 67
    //   58: invokevirtual 70	com/google/firebase/crashlytics/internal/Logger:d	(Ljava/lang/String;)V
    //   61: aload_0
    //   62: getfield 28	com/google/firebase/crashlytics/internal/common/CrashlyticsUncaughtExceptionHandler:defaultHandler	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   65: aload_1
    //   66: aload_2
    //   67: invokeinterface 72 3 0
    //   72: aload_0
    //   73: getfield 35	com/google/firebase/crashlytics/internal/common/CrashlyticsUncaughtExceptionHandler:isHandlingException	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   76: iconst_0
    //   77: invokevirtual 47	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   80: return
    //   81: invokestatic 53	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   84: ldc 74
    //   86: aload_3
    //   87: invokevirtual 77	com/google/firebase/crashlytics/internal/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   90: goto -37 -> 53
    //   93: invokestatic 53	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   96: ldc 67
    //   98: invokevirtual 70	com/google/firebase/crashlytics/internal/Logger:d	(Ljava/lang/String;)V
    //   101: aload_0
    //   102: getfield 28	com/google/firebase/crashlytics/internal/common/CrashlyticsUncaughtExceptionHandler:defaultHandler	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   105: aload_1
    //   106: aload_2
    //   107: invokeinterface 72 3 0
    //   112: aload_0
    //   113: getfield 35	com/google/firebase/crashlytics/internal/common/CrashlyticsUncaughtExceptionHandler:isHandlingException	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   116: iconst_0
    //   117: invokevirtual 47	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   120: aload_3
    //   121: athrow
    //   122: astore_3
    //   123: goto -30 -> 93
    //   126: astore_3
    //   127: goto -46 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	CrashlyticsUncaughtExceptionHandler
    //   0	130	1	paramThread	Thread
    //   0	130	2	paramThrowable	Throwable
    //   86	35	3	localThrowable	Throwable
    //   122	1	3	localObject	Object
    //   126	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   12	20	122	finally
    //   27	35	122	finally
    //   38	53	122	finally
    //   81	90	122	finally
    //   12	20	126	java/lang/Exception
    //   27	35	126	java/lang/Exception
    //   38	53	126	java/lang/Exception
  }
  
  static abstract interface CrashListener
  {
    public abstract void onUncaughtException(SettingsDataProvider paramSettingsDataProvider, Thread paramThread, Throwable paramThrowable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\common\CrashlyticsUncaughtExceptionHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */