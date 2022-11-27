package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Result;

public final class zabp<O extends Api.ApiOptions>
  extends zaag
{
  private final GoogleApi<O> zajh;
  
  public zabp(GoogleApi<O> paramGoogleApi)
  {
    super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
    this.zajh = paramGoogleApi;
  }
  
  public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T paramT)
  {
    return this.zajh.doRead(paramT);
  }
  
  public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T paramT)
  {
    return this.zajh.doWrite(paramT);
  }
  
  public final Context getContext()
  {
    return this.zajh.getApplicationContext();
  }
  
  public final Looper getLooper()
  {
    return this.zajh.getLooper();
  }
  
  public final void zaa(zacm paramzacm) {}
  
  public final void zab(zacm paramzacm) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\zabp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */