package com.google.android.gms.internal.measurement;

final class zzlc
{
  private static void zzb(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, char[] paramArrayOfChar, int paramInt)
    throws zzih
  {
    if ((!zzg(paramByte2)) && ((paramByte1 << 28) + (paramByte2 + 112) >> 30 == 0) && (!zzg(paramByte3)) && (!zzg(paramByte4)))
    {
      paramByte1 = (paramByte1 & 0x7) << 18 | (paramByte2 & 0x3F) << 12 | (paramByte3 & 0x3F) << 6 | paramByte4 & 0x3F;
      paramArrayOfChar[paramInt] = ((char)((paramByte1 >>> 10) + 55232));
      paramArrayOfChar[(paramInt + 1)] = ((char)((paramByte1 & 0x3FF) + 56320));
      return;
    }
    throw zzih.zzh();
  }
  
  private static void zzb(byte paramByte1, byte paramByte2, byte paramByte3, char[] paramArrayOfChar, int paramInt)
    throws zzih
  {
    if ((!zzg(paramByte2)) && ((paramByte1 != -32) || (paramByte2 >= -96)) && ((paramByte1 != -19) || (paramByte2 < -96)) && (!zzg(paramByte3)))
    {
      paramArrayOfChar[paramInt] = ((char)((paramByte1 & 0xF) << 12 | (paramByte2 & 0x3F) << 6 | paramByte3 & 0x3F));
      return;
    }
    throw zzih.zzh();
  }
  
  private static void zzb(byte paramByte1, byte paramByte2, char[] paramArrayOfChar, int paramInt)
    throws zzih
  {
    if ((paramByte1 >= -62) && (!zzg(paramByte2)))
    {
      paramArrayOfChar[paramInt] = ((char)((paramByte1 & 0x1F) << 6 | paramByte2 & 0x3F));
      return;
    }
    throw zzih.zzh();
  }
  
  private static void zzb(byte paramByte, char[] paramArrayOfChar, int paramInt)
  {
    paramArrayOfChar[paramInt] = ((char)paramByte);
  }
  
  private static boolean zzd(byte paramByte)
  {
    return paramByte >= 0;
  }
  
  private static boolean zze(byte paramByte)
  {
    return paramByte < -32;
  }
  
  private static boolean zzf(byte paramByte)
  {
    return paramByte < -16;
  }
  
  private static boolean zzg(byte paramByte)
  {
    return paramByte > -65;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzlc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */