package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;

public final class zaw<O extends Api.ApiOptions>
  extends GoogleApi<O>
{
  private final Api.AbstractClientBuilder<? extends zad, SignInOptions> zace;
  private final Api.Client zaer;
  private final zaq zaes;
  private final ClientSettings zaet;
  
  public zaw(Context paramContext, Api<O> paramApi, Looper paramLooper, Api.Client paramClient, zaq paramzaq, ClientSettings paramClientSettings, Api.AbstractClientBuilder<? extends zad, SignInOptions> paramAbstractClientBuilder)
  {
    super(paramContext, paramApi, paramLooper);
    this.zaer = paramClient;
    this.zaes = paramzaq;
    this.zaet = paramClientSettings;
    this.zace = paramAbstractClientBuilder;
    this.zabm.zaa(this);
  }
  
  public final Api.Client zaa(Looper paramLooper, GoogleApiManager.zaa<O> paramzaa)
  {
    this.zaes.zaa(paramzaa);
    return this.zaer;
  }
  
  public final zace zaa(Context paramContext, Handler paramHandler)
  {
    return new zace(paramContext, paramHandler, this.zaet, this.zace);
  }
  
  public final Api.Client zaab()
  {
    return this.zaer;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\zaw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */