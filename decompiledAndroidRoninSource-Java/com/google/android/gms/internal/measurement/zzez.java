package com.google.android.gms.internal.measurement;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzez
{
  static int zza(int paramInt)
  {
    return (int)(Integer.rotateLeft((int)(paramInt * -862048943L), 15) * 461845907L);
  }
  
  static int zza(@NullableDecl Object paramObject)
  {
    int i;
    if (paramObject == null) {
      i = 0;
    } else {
      i = paramObject.hashCode();
    }
    return zza(i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzez.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */