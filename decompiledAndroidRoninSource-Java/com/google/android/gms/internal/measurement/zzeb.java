package com.google.android.gms.internal.measurement;

import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class zzeb
{
  public static int zza(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt1 < paramInt2)) {
      return paramInt1;
    }
    Object localObject;
    if (paramInt1 >= 0)
    {
      if (paramInt2 < 0)
      {
        localObject = new StringBuilder(26);
        ((StringBuilder)localObject).append("negative size: ");
        ((StringBuilder)localObject).append(paramInt2);
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
      localObject = zzed.zza("%s (%s) must be less than size (%s)", new Object[] { "index", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    else
    {
      localObject = zzed.zza("%s (%s) must not be negative", new Object[] { "index", Integer.valueOf(paramInt1) });
    }
    throw new IndexOutOfBoundsException((String)localObject);
  }
  
  @NonNullDecl
  public static <T> T zza(@NonNullDecl T paramT)
  {
    if (paramT != null) {
      return paramT;
    }
    throw null;
  }
  
  @NonNullDecl
  public static <T> T zza(@NonNullDecl T paramT, @NullableDecl Object paramObject)
  {
    if (paramT != null) {
      return paramT;
    }
    throw new NullPointerException(String.valueOf(paramObject));
  }
  
  private static String zza(int paramInt1, int paramInt2, @NullableDecl String paramString)
  {
    if (paramInt1 < 0) {
      return zzed.zza("%s (%s) must not be negative", new Object[] { paramString, Integer.valueOf(paramInt1) });
    }
    if (paramInt2 >= 0) {
      return zzed.zza("%s (%s) must not be greater than size (%s)", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    paramString = new StringBuilder(26);
    paramString.append("negative size: ");
    paramString.append(paramInt2);
    throw new IllegalArgumentException(paramString.toString());
  }
  
  public static void zza(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= 0) && (paramInt2 >= paramInt1) && (paramInt2 <= paramInt3)) {
      return;
    }
    String str;
    if ((paramInt1 >= 0) && (paramInt1 <= paramInt3))
    {
      if ((paramInt2 >= 0) && (paramInt2 <= paramInt3)) {
        str = zzed.zza("end index (%s) must not be less than start index (%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      } else {
        str = zza(paramInt2, paramInt3, "end index");
      }
    }
    else {
      str = zza(paramInt1, paramInt3, "start index");
    }
    throw new IndexOutOfBoundsException(str);
  }
  
  public static void zza(boolean paramBoolean, @NullableDecl Object paramObject)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException(String.valueOf(paramObject));
  }
  
  public static int zzb(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt1 <= paramInt2)) {
      return paramInt1;
    }
    throw new IndexOutOfBoundsException(zza(paramInt1, paramInt2, "index"));
  }
  
  public static void zzb(boolean paramBoolean, @NullableDecl Object paramObject)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalStateException(String.valueOf(paramObject));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzeb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */