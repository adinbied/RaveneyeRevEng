package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;

public final class zzih
{
  /* Error */
  public static Object zza(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 12	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: invokespecial 16	java/io/ByteArrayOutputStream:<init>	()V
    //   13: astore_1
    //   14: new 18	java/io/ObjectOutputStream
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 21	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   22: astore_2
    //   23: aload_2
    //   24: aload_0
    //   25: invokevirtual 25	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   28: aload_2
    //   29: invokevirtual 28	java/io/ObjectOutputStream:flush	()V
    //   32: new 30	java/io/ObjectInputStream
    //   35: dup
    //   36: new 32	java/io/ByteArrayInputStream
    //   39: dup
    //   40: aload_1
    //   41: invokevirtual 36	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   44: invokespecial 39	java/io/ByteArrayInputStream:<init>	([B)V
    //   47: invokespecial 42	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   50: astore_1
    //   51: aload_1
    //   52: invokevirtual 46	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   55: astore_0
    //   56: aload_2
    //   57: invokevirtual 49	java/io/ObjectOutputStream:close	()V
    //   60: aload_1
    //   61: invokevirtual 50	java/io/ObjectInputStream:close	()V
    //   64: aload_0
    //   65: areturn
    //   66: aload_2
    //   67: ifnull +7 -> 74
    //   70: aload_2
    //   71: invokevirtual 49	java/io/ObjectOutputStream:close	()V
    //   74: aload_1
    //   75: ifnull +7 -> 82
    //   78: aload_1
    //   79: invokevirtual 50	java/io/ObjectInputStream:close	()V
    //   82: aload_0
    //   83: athrow
    //   84: astore_0
    //   85: aconst_null
    //   86: areturn
    //   87: astore_0
    //   88: goto -22 -> 66
    //   91: astore_0
    //   92: aconst_null
    //   93: astore_1
    //   94: goto -28 -> 66
    //   97: astore_0
    //   98: aconst_null
    //   99: astore_1
    //   100: aload_1
    //   101: astore_2
    //   102: goto -36 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	paramObject	Object
    //   13	88	1	localObject1	Object
    //   22	80	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   56	64	84	java/io/IOException
    //   56	64	84	java/lang/ClassNotFoundException
    //   70	74	84	java/io/IOException
    //   70	74	84	java/lang/ClassNotFoundException
    //   78	82	84	java/io/IOException
    //   78	82	84	java/lang/ClassNotFoundException
    //   82	84	84	java/io/IOException
    //   82	84	84	java/lang/ClassNotFoundException
    //   51	56	87	finally
    //   23	51	91	finally
    //   6	23	97	finally
  }
  
  public static String zza(Context paramContext, String paramString)
  {
    try
    {
      paramContext = new StringResourceValueReader(paramContext).getString(paramString);
      return paramContext;
    }
    catch (Resources.NotFoundException paramContext)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static String zza(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    Preconditions.checkNotNull(paramArrayOfString1);
    Preconditions.checkNotNull(paramArrayOfString2);
    int j = Math.min(paramArrayOfString1.length, paramArrayOfString2.length);
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString1[i];
      boolean bool;
      if ((paramString == null) && (str == null)) {
        bool = true;
      } else if (paramString == null) {
        bool = false;
      } else {
        bool = paramString.equals(str);
      }
      if (bool) {
        return paramArrayOfString2[i];
      }
      i += 1;
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzih.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */