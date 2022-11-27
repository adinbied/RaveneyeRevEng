package com.google.android.gms.internal.firebase_messaging;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

final class zzl
  extends FilterInputStream
{
  private long zza;
  private long zzb = -1L;
  
  zzl(InputStream paramInputStream, long paramLong)
  {
    super(paramInputStream);
    zzg.zza(paramInputStream);
    this.zza = 1048577L;
  }
  
  public final int available()
    throws IOException
  {
    return (int)Math.min(this.in.available(), this.zza);
  }
  
  public final void mark(int paramInt)
  {
    try
    {
      this.in.mark(paramInt);
      this.zzb = this.zza;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final int read()
    throws IOException
  {
    if (this.zza == 0L) {
      return -1;
    }
    int i = this.in.read();
    if (i != -1) {
      this.zza -= 1L;
    }
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    long l = this.zza;
    if (l == 0L) {
      return -1;
    }
    paramInt2 = (int)Math.min(paramInt2, l);
    paramInt1 = this.in.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 != -1) {
      this.zza -= paramInt1;
    }
    return paramInt1;
  }
  
  public final void reset()
    throws IOException
  {
    try
    {
      if (this.in.markSupported())
      {
        if (this.zzb != -1L)
        {
          this.in.reset();
          this.zza = this.zzb;
          return;
        }
        throw new IOException("Mark not set");
      }
      throw new IOException("Mark not supported");
    }
    finally {}
  }
  
  public final long skip(long paramLong)
    throws IOException
  {
    paramLong = Math.min(paramLong, this.zza);
    paramLong = this.in.skip(paramLong);
    this.zza -= paramLong;
    return paramLong;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\firebase_messaging\zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */