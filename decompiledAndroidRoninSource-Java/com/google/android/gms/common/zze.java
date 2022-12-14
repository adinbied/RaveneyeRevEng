package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

abstract class zze
  extends zzj
{
  private int zzt;
  
  protected zze(byte[] paramArrayOfByte)
  {
    boolean bool;
    if (paramArrayOfByte.length == 25) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    this.zzt = Arrays.hashCode(paramArrayOfByte);
  }
  
  protected static byte[] zza(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("ISO-8859-1");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new AssertionError(paramString);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof zzi)) {
        return false;
      }
      try
      {
        paramObject = (zzi)paramObject;
        if (((zzi)paramObject).zzc() != hashCode()) {
          return false;
        }
        paramObject = ((zzi)paramObject).zzb();
        if (paramObject == null) {
          return false;
        }
        paramObject = (byte[])ObjectWrapper.unwrap((IObjectWrapper)paramObject);
        boolean bool = Arrays.equals(getBytes(), (byte[])paramObject);
        return bool;
      }
      catch (RemoteException paramObject)
      {
        Log.e("GoogleCertificates", "Failed to get Google certificates from remote", (Throwable)paramObject);
      }
    }
    return false;
  }
  
  abstract byte[] getBytes();
  
  public int hashCode()
  {
    return this.zzt;
  }
  
  public final IObjectWrapper zzb()
  {
    return ObjectWrapper.wrap(getBytes());
  }
  
  public final int zzc()
  {
    return hashCode();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */