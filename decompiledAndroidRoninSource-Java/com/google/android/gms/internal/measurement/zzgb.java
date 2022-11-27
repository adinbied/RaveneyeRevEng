package com.google.android.gms.internal.measurement;

import java.io.PrintStream;
import java.lang.reflect.Field;

public final class zzgb
{
  private static final zzga zza;
  private static final int zzb;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_0
    //   2: invokestatic 15	com/google/android/gms/internal/measurement/zzgb:zza	()Ljava/lang/Integer;
    //   5: astore_2
    //   6: aload_2
    //   7: ifnull +23 -> 30
    //   10: aload_2
    //   11: invokevirtual 21	java/lang/Integer:intValue	()I
    //   14: bipush 19
    //   16: if_icmplt +14 -> 30
    //   19: new 23	com/google/android/gms/internal/measurement/zzgf
    //   22: dup
    //   23: invokespecial 26	com/google/android/gms/internal/measurement/zzgf:<init>	()V
    //   26: astore_1
    //   27: goto +122 -> 149
    //   30: ldc 28
    //   32: invokestatic 34	java/lang/Boolean:getBoolean	(Ljava/lang/String;)Z
    //   35: iconst_1
    //   36: ixor
    //   37: ifeq +14 -> 51
    //   40: new 36	com/google/android/gms/internal/measurement/zzge
    //   43: dup
    //   44: invokespecial 37	com/google/android/gms/internal/measurement/zzge:<init>	()V
    //   47: astore_1
    //   48: goto +101 -> 149
    //   51: new 6	com/google/android/gms/internal/measurement/zzgb$zza
    //   54: dup
    //   55: invokespecial 38	com/google/android/gms/internal/measurement/zzgb$zza:<init>	()V
    //   58: astore_1
    //   59: goto +90 -> 149
    //   62: astore_1
    //   63: goto +6 -> 69
    //   66: astore_1
    //   67: aconst_null
    //   68: astore_2
    //   69: getstatic 44	java/lang/System:err	Ljava/io/PrintStream;
    //   72: astore_3
    //   73: ldc 6
    //   75: invokevirtual 50	java/lang/Class:getName	()Ljava/lang/String;
    //   78: astore 4
    //   80: new 52	java/lang/StringBuilder
    //   83: dup
    //   84: aload 4
    //   86: invokestatic 58	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   89: invokevirtual 61	java/lang/String:length	()I
    //   92: sipush 133
    //   95: iadd
    //   96: invokespecial 64	java/lang/StringBuilder:<init>	(I)V
    //   99: astore 5
    //   101: aload 5
    //   103: ldc 66
    //   105: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload 5
    //   111: aload 4
    //   113: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload 5
    //   119: ldc 72
    //   121: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload_3
    //   126: aload 5
    //   128: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokevirtual 81	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   134: aload_1
    //   135: getstatic 44	java/lang/System:err	Ljava/io/PrintStream;
    //   138: invokevirtual 87	java/lang/Throwable:printStackTrace	(Ljava/io/PrintStream;)V
    //   141: new 6	com/google/android/gms/internal/measurement/zzgb$zza
    //   144: dup
    //   145: invokespecial 38	com/google/android/gms/internal/measurement/zzgb$zza:<init>	()V
    //   148: astore_1
    //   149: aload_1
    //   150: putstatic 89	com/google/android/gms/internal/measurement/zzgb:zza	Lcom/google/android/gms/internal/measurement/zzga;
    //   153: aload_2
    //   154: ifnonnull +6 -> 160
    //   157: goto +8 -> 165
    //   160: aload_2
    //   161: invokevirtual 21	java/lang/Integer:intValue	()I
    //   164: istore_0
    //   165: iload_0
    //   166: putstatic 91	com/google/android/gms/internal/measurement/zzgb:zzb	I
    //   169: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	165	0	i	int
    //   26	33	1	localObject1	Object
    //   62	1	1	localObject2	Object
    //   66	69	1	localObject3	Object
    //   148	2	1	localzza	zza
    //   5	156	2	localInteger	Integer
    //   72	54	3	localPrintStream	PrintStream
    //   78	34	4	str	String
    //   99	28	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   10	27	62	finally
    //   30	48	62	finally
    //   51	59	62	finally
    //   2	6	66	finally
  }
  
  private static Integer zza()
  {
    try
    {
      Integer localInteger = (Integer)Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
      return localInteger;
    }
    catch (Exception localException)
    {
      System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
      localException.printStackTrace(System.err);
    }
    return null;
  }
  
  public static void zza(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    zza.zza(paramThrowable1, paramThrowable2);
  }
  
  static final class zza
    extends zzga
  {
    public final void zza(Throwable paramThrowable1, Throwable paramThrowable2) {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzgb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */