package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public final class zae<A extends BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient>>
  extends zab
{
  private final A zaco;
  
  public zae(int paramInt, A paramA)
  {
    super(paramInt);
    this.zaco = paramA;
  }
  
  public final void zaa(Status paramStatus)
  {
    this.zaco.setFailedResult(paramStatus);
  }
  
  public final void zaa(GoogleApiManager.zaa<?> paramzaa)
    throws DeadObjectException
  {
    try
    {
      this.zaco.run(paramzaa.zaab());
      return;
    }
    catch (RuntimeException paramzaa)
    {
      zaa(paramzaa);
    }
  }
  
  public final void zaa(zaab paramzaab, boolean paramBoolean)
  {
    paramzaab.zaa(this.zaco, paramBoolean);
  }
  
  public final void zaa(RuntimeException paramRuntimeException)
  {
    String str = paramRuntimeException.getClass().getSimpleName();
    paramRuntimeException = paramRuntimeException.getLocalizedMessage();
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(paramRuntimeException).length());
    localStringBuilder.append(str);
    localStringBuilder.append(": ");
    localStringBuilder.append(paramRuntimeException);
    paramRuntimeException = new Status(10, localStringBuilder.toString());
    this.zaco.setFailedResult(paramRuntimeException);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\zae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */