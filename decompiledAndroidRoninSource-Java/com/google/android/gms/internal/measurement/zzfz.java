package com.google.android.gms.internal.measurement;

public final class zzfz
  extends zzfy
{
  public static int zza(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 <= 1073741823) {
      paramInt3 = 1;
    } else {
      paramInt3 = 0;
    }
    if (paramInt3 != 0) {
      return Math.min(Math.max(paramInt1, paramInt2), 1073741823);
    }
    throw new IllegalArgumentException(zzed.zza("min (%s) must be less than or equal to max (%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(1073741823) }));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzfz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */