package com.google.android.gms.common;

import java.util.concurrent.Callable;

final class zzo
  extends zzm
{
  private final Callable<String> zzaf;
  
  private zzo(Callable<String> paramCallable)
  {
    super(false, null, null);
    this.zzaf = paramCallable;
  }
  
  final String getErrorMessage()
  {
    try
    {
      String str = (String)this.zzaf.call();
      return str;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\zzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */