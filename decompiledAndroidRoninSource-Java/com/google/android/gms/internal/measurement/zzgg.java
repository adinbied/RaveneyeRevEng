package com.google.android.gms.internal.measurement;

import java.io.IOException;

public abstract class zzgg<MessageType extends zzgh<MessageType, BuilderType>, BuilderType extends zzgg<MessageType, BuilderType>>
  implements zzjk
{
  private final String zza(String paramString)
  {
    String str = getClass().getName();
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 60 + String.valueOf(paramString).length());
    localStringBuilder.append("Reading ");
    localStringBuilder.append(str);
    localStringBuilder.append(" from a ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" threw an IOException (should never happen).");
    return localStringBuilder.toString();
  }
  
  protected abstract BuilderType zza(MessageType paramMessageType);
  
  public abstract BuilderType zza(zzhd paramzzhd, zzhm paramzzhm)
    throws IOException;
  
  public BuilderType zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws zzih
  {
    try
    {
      paramArrayOfByte = zzhd.zza(paramArrayOfByte, 0, paramInt2, false);
      zza(paramArrayOfByte, zzhm.zza());
      paramArrayOfByte.zza(0);
      return this;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new RuntimeException(zza("byte array"), paramArrayOfByte);
    }
    catch (zzih paramArrayOfByte)
    {
      throw paramArrayOfByte;
    }
  }
  
  public BuilderType zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2, zzhm paramzzhm)
    throws zzih
  {
    try
    {
      paramArrayOfByte = zzhd.zza(paramArrayOfByte, 0, paramInt2, false);
      zza(paramArrayOfByte, paramzzhm);
      paramArrayOfByte.zza(0);
      return this;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new RuntimeException(zza("byte array"), paramArrayOfByte);
    }
    catch (zzih paramArrayOfByte)
    {
      throw paramArrayOfByte;
    }
  }
  
  public abstract BuilderType zzt();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzgg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */