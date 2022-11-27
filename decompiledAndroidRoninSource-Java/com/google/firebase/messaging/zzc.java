package com.google.firebase.messaging;

import android.content.Context;
import java.util.concurrent.Executor;

final class zzc
{
  private final Executor zza;
  private final Context zzb;
  private final zzt zzc;
  
  public zzc(Context paramContext, zzt paramzzt, Executor paramExecutor)
  {
    this.zza = paramExecutor;
    this.zzb = paramContext;
    this.zzc = paramzzt;
  }
  
  /* Error */
  final boolean zza()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 21	com/google/firebase/messaging/zzc:zzc	Lcom/google/firebase/messaging/zzt;
    //   4: ldc 31
    //   6: invokevirtual 36	com/google/firebase/messaging/zzt:zzb	(Ljava/lang/String;)Z
    //   9: ifeq +5 -> 14
    //   12: iconst_1
    //   13: ireturn
    //   14: aload_0
    //   15: getfield 19	com/google/firebase/messaging/zzc:zzb	Landroid/content/Context;
    //   18: ldc 38
    //   20: invokevirtual 44	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   23: checkcast 46	android/app/KeyguardManager
    //   26: invokevirtual 49	android/app/KeyguardManager:inKeyguardRestrictedInputMode	()Z
    //   29: ifne +87 -> 116
    //   32: invokestatic 54	com/google/android/gms/common/util/PlatformVersion:isAtLeastLollipop	()Z
    //   35: ifne +9 -> 44
    //   38: ldc2_w 55
    //   41: invokestatic 62	android/os/SystemClock:sleep	(J)V
    //   44: invokestatic 68	android/os/Process:myPid	()I
    //   47: istore_1
    //   48: aload_0
    //   49: getfield 19	com/google/firebase/messaging/zzc:zzb	Landroid/content/Context;
    //   52: ldc 70
    //   54: invokevirtual 44	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   57: checkcast 72	android/app/ActivityManager
    //   60: invokevirtual 76	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   63: astore_2
    //   64: aload_2
    //   65: ifnull +51 -> 116
    //   68: aload_2
    //   69: invokeinterface 82 1 0
    //   74: astore_2
    //   75: aload_2
    //   76: invokeinterface 87 1 0
    //   81: ifeq +35 -> 116
    //   84: aload_2
    //   85: invokeinterface 91 1 0
    //   90: checkcast 93	android/app/ActivityManager$RunningAppProcessInfo
    //   93: astore_3
    //   94: aload_3
    //   95: getfield 97	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   98: iload_1
    //   99: if_icmpne -24 -> 75
    //   102: aload_3
    //   103: getfield 100	android/app/ActivityManager$RunningAppProcessInfo:importance	I
    //   106: bipush 100
    //   108: if_icmpne +8 -> 116
    //   111: iconst_1
    //   112: istore_1
    //   113: goto +5 -> 118
    //   116: iconst_0
    //   117: istore_1
    //   118: iload_1
    //   119: ifeq +5 -> 124
    //   122: iconst_0
    //   123: ireturn
    //   124: aload_0
    //   125: getfield 21	com/google/firebase/messaging/zzc:zzc	Lcom/google/firebase/messaging/zzt;
    //   128: ldc 102
    //   130: invokevirtual 105	com/google/firebase/messaging/zzt:zza	(Ljava/lang/String;)Ljava/lang/String;
    //   133: invokestatic 110	com/google/firebase/messaging/zzq:zza	(Ljava/lang/String;)Lcom/google/firebase/messaging/zzq;
    //   136: astore_3
    //   137: aload_3
    //   138: ifnull +11 -> 149
    //   141: aload_3
    //   142: aload_0
    //   143: getfield 17	com/google/firebase/messaging/zzc:zza	Ljava/util/concurrent/Executor;
    //   146: invokevirtual 113	com/google/firebase/messaging/zzq:zza	(Ljava/util/concurrent/Executor;)V
    //   149: aload_0
    //   150: getfield 19	com/google/firebase/messaging/zzc:zzb	Landroid/content/Context;
    //   153: aload_0
    //   154: getfield 21	com/google/firebase/messaging/zzc:zzc	Lcom/google/firebase/messaging/zzt;
    //   157: invokestatic 118	com/google/firebase/messaging/zzb:zza	(Landroid/content/Context;Lcom/google/firebase/messaging/zzt;)Lcom/google/firebase/messaging/zza;
    //   160: astore_2
    //   161: aload_2
    //   162: getfield 123	com/google/firebase/messaging/zza:zza	Landroidx/core/app/NotificationCompat$Builder;
    //   165: astore 4
    //   167: aload_3
    //   168: ifnull +144 -> 312
    //   171: aload_3
    //   172: invokevirtual 126	com/google/firebase/messaging/zzq:zza	()Lcom/google/android/gms/tasks/Task;
    //   175: ldc2_w 127
    //   178: getstatic 134	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   181: invokestatic 140	com/google/android/gms/tasks/Tasks:await	(Lcom/google/android/gms/tasks/Task;JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
    //   184: checkcast 142	android/graphics/Bitmap
    //   187: astore 5
    //   189: aload 4
    //   191: aload 5
    //   193: invokevirtual 148	androidx/core/app/NotificationCompat$Builder:setLargeIcon	(Landroid/graphics/Bitmap;)Landroidx/core/app/NotificationCompat$Builder;
    //   196: pop
    //   197: aload 4
    //   199: new 150	androidx/core/app/NotificationCompat$BigPictureStyle
    //   202: dup
    //   203: invokespecial 151	androidx/core/app/NotificationCompat$BigPictureStyle:<init>	()V
    //   206: aload 5
    //   208: invokevirtual 155	androidx/core/app/NotificationCompat$BigPictureStyle:bigPicture	(Landroid/graphics/Bitmap;)Landroidx/core/app/NotificationCompat$BigPictureStyle;
    //   211: aconst_null
    //   212: invokevirtual 158	androidx/core/app/NotificationCompat$BigPictureStyle:bigLargeIcon	(Landroid/graphics/Bitmap;)Landroidx/core/app/NotificationCompat$BigPictureStyle;
    //   215: invokevirtual 162	androidx/core/app/NotificationCompat$Builder:setStyle	(Landroidx/core/app/NotificationCompat$Style;)Landroidx/core/app/NotificationCompat$Builder;
    //   218: pop
    //   219: goto +93 -> 312
    //   222: ldc -92
    //   224: ldc -90
    //   226: invokestatic 172	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   229: pop
    //   230: aload_3
    //   231: invokevirtual 175	com/google/firebase/messaging/zzq:close	()V
    //   234: goto +78 -> 312
    //   237: ldc -92
    //   239: ldc -79
    //   241: invokestatic 172	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   244: pop
    //   245: aload_3
    //   246: invokevirtual 175	com/google/firebase/messaging/zzq:close	()V
    //   249: invokestatic 183	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   252: invokevirtual 186	java/lang/Thread:interrupt	()V
    //   255: goto +57 -> 312
    //   258: astore_3
    //   259: aload_3
    //   260: invokevirtual 190	java/util/concurrent/ExecutionException:getCause	()Ljava/lang/Throwable;
    //   263: invokestatic 196	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   266: astore_3
    //   267: new 198	java/lang/StringBuilder
    //   270: dup
    //   271: aload_3
    //   272: invokestatic 196	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   275: invokevirtual 201	java/lang/String:length	()I
    //   278: bipush 26
    //   280: iadd
    //   281: invokespecial 204	java/lang/StringBuilder:<init>	(I)V
    //   284: astore 4
    //   286: aload 4
    //   288: ldc -50
    //   290: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload 4
    //   296: aload_3
    //   297: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: ldc -92
    //   303: aload 4
    //   305: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokestatic 172	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   311: pop
    //   312: ldc -92
    //   314: iconst_3
    //   315: invokestatic 218	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   318: ifeq +11 -> 329
    //   321: ldc -92
    //   323: ldc -36
    //   325: invokestatic 223	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   328: pop
    //   329: aload_0
    //   330: getfield 19	com/google/firebase/messaging/zzc:zzb	Landroid/content/Context;
    //   333: ldc -31
    //   335: invokevirtual 44	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   338: checkcast 227	android/app/NotificationManager
    //   341: aload_2
    //   342: getfield 230	com/google/firebase/messaging/zza:zzb	Ljava/lang/String;
    //   345: iconst_0
    //   346: aload_2
    //   347: getfield 123	com/google/firebase/messaging/zza:zza	Landroidx/core/app/NotificationCompat$Builder;
    //   350: invokevirtual 234	androidx/core/app/NotificationCompat$Builder:build	()Landroid/app/Notification;
    //   353: invokevirtual 238	android/app/NotificationManager:notify	(Ljava/lang/String;ILandroid/app/Notification;)V
    //   356: iconst_1
    //   357: ireturn
    //   358: astore 4
    //   360: goto -123 -> 237
    //   363: astore 4
    //   365: goto -143 -> 222
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	368	0	this	zzc
    //   47	72	1	i	int
    //   63	284	2	localObject1	Object
    //   93	153	3	localObject2	Object
    //   258	2	3	localExecutionException	java.util.concurrent.ExecutionException
    //   266	31	3	str	String
    //   165	139	4	localObject3	Object
    //   358	1	4	localInterruptedException	InterruptedException
    //   363	1	4	localTimeoutException	java.util.concurrent.TimeoutException
    //   187	20	5	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   171	219	258	java/util/concurrent/ExecutionException
    //   171	219	358	java/lang/InterruptedException
    //   171	219	363	java/util/concurrent/TimeoutException
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\messaging\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */