package com.google.android.gms.fitness.data;

import com.google.android.gms.internal.fitness.zzh;
import java.util.List;

final class zzg
  implements zzh<DataType>
{
  public static final zzg zzan = new zzg();
  
  private static Field zza(DataType paramDataType, int paramInt)
  {
    return (Field)paramDataType.getFields().get(paramInt);
  }
  
  public final boolean zzb(String paramString)
  {
    return zzm.zzc(paramString) != null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\data\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */