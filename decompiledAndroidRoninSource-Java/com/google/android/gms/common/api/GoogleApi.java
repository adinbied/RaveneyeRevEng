package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.GoogleApiManager.zaa;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.common.api.internal.zaae;
import com.google.android.gms.common.api.internal.zabp;
import com.google.android.gms.common.api.internal.zace;
import com.google.android.gms.common.api.internal.zai;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.ClientSettings.Builder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collection;
import java.util.Collections;

public class GoogleApi<O extends Api.ApiOptions>
{
  private final Api<O> mApi;
  private final Context mContext;
  private final int mId;
  private final O zabh;
  private final zai<O> zabi;
  private final Looper zabj;
  private final GoogleApiClient zabk;
  private final StatusExceptionMapper zabl;
  protected final GoogleApiManager zabm;
  
  public GoogleApi(Activity paramActivity, Api<O> paramApi, O paramO, Settings paramSettings)
  {
    Preconditions.checkNotNull(paramActivity, "Null activity is not permitted.");
    Preconditions.checkNotNull(paramApi, "Api must not be null.");
    Preconditions.checkNotNull(paramSettings, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
    this.mContext = paramActivity.getApplicationContext();
    this.mApi = paramApi;
    this.zabh = paramO;
    this.zabj = paramSettings.zabo;
    this.zabi = zai.zaa(this.mApi, this.zabh);
    this.zabk = new zabp(this);
    paramApi = GoogleApiManager.zab(this.mContext);
    this.zabm = paramApi;
    this.mId = paramApi.zabd();
    this.zabl = paramSettings.zabn;
    if (!(paramActivity instanceof GoogleApiActivity)) {
      zaae.zaa(paramActivity, this.zabm, this.zabi);
    }
    this.zabm.zaa(this);
  }
  
  @Deprecated
  public GoogleApi(Activity paramActivity, Api<O> paramApi, O paramO, StatusExceptionMapper paramStatusExceptionMapper)
  {
    this(paramActivity, paramApi, paramO, new GoogleApi.Settings.Builder().setMapper(paramStatusExceptionMapper).setLooper(paramActivity.getMainLooper()).build());
  }
  
  protected GoogleApi(Context paramContext, Api<O> paramApi, Looper paramLooper)
  {
    Preconditions.checkNotNull(paramContext, "Null context is not permitted.");
    Preconditions.checkNotNull(paramApi, "Api must not be null.");
    Preconditions.checkNotNull(paramLooper, "Looper must not be null.");
    this.mContext = paramContext.getApplicationContext();
    this.mApi = paramApi;
    this.zabh = null;
    this.zabj = paramLooper;
    this.zabi = zai.zaa(paramApi);
    this.zabk = new zabp(this);
    paramContext = GoogleApiManager.zab(this.mContext);
    this.zabm = paramContext;
    this.mId = paramContext.zabd();
    this.zabl = new ApiExceptionMapper();
  }
  
  @Deprecated
  public GoogleApi(Context paramContext, Api<O> paramApi, O paramO, Looper paramLooper, StatusExceptionMapper paramStatusExceptionMapper)
  {
    this(paramContext, paramApi, paramO, new GoogleApi.Settings.Builder().setLooper(paramLooper).setMapper(paramStatusExceptionMapper).build());
  }
  
  public GoogleApi(Context paramContext, Api<O> paramApi, O paramO, Settings paramSettings)
  {
    Preconditions.checkNotNull(paramContext, "Null context is not permitted.");
    Preconditions.checkNotNull(paramApi, "Api must not be null.");
    Preconditions.checkNotNull(paramSettings, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
    this.mContext = paramContext.getApplicationContext();
    this.mApi = paramApi;
    this.zabh = paramO;
    this.zabj = paramSettings.zabo;
    this.zabi = zai.zaa(this.mApi, this.zabh);
    this.zabk = new zabp(this);
    paramContext = GoogleApiManager.zab(this.mContext);
    this.zabm = paramContext;
    this.mId = paramContext.zabd();
    this.zabl = paramSettings.zabn;
    this.zabm.zaa(this);
  }
  
  @Deprecated
  public GoogleApi(Context paramContext, Api<O> paramApi, O paramO, StatusExceptionMapper paramStatusExceptionMapper)
  {
    this(paramContext, paramApi, paramO, new GoogleApi.Settings.Builder().setMapper(paramStatusExceptionMapper).build());
  }
  
  private final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T zaa(int paramInt, T paramT)
  {
    paramT.zau();
    this.zabm.zaa(this, paramInt, paramT);
    return paramT;
  }
  
  private final <TResult, A extends Api.AnyClient> Task<TResult> zaa(int paramInt, TaskApiCall<A, TResult> paramTaskApiCall)
  {
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    this.zabm.zaa(this, paramInt, paramTaskApiCall, localTaskCompletionSource, this.zabl);
    return localTaskCompletionSource.getTask();
  }
  
  public GoogleApiClient asGoogleApiClient()
  {
    return this.zabk;
  }
  
  protected ClientSettings.Builder createClientSettingsBuilder()
  {
    ClientSettings.Builder localBuilder = new ClientSettings.Builder();
    Object localObject = this.zabh;
    if ((localObject instanceof Api.ApiOptions.HasGoogleSignInAccountOptions))
    {
      localObject = ((Api.ApiOptions.HasGoogleSignInAccountOptions)localObject).getGoogleSignInAccount();
      if (localObject != null)
      {
        localObject = ((GoogleSignInAccount)localObject).getAccount();
        break label69;
      }
    }
    localObject = this.zabh;
    if ((localObject instanceof Api.ApiOptions.HasAccountOptions)) {
      localObject = ((Api.ApiOptions.HasAccountOptions)localObject).getAccount();
    } else {
      localObject = null;
    }
    label69:
    localBuilder = localBuilder.setAccount((Account)localObject);
    localObject = this.zabh;
    if ((localObject instanceof Api.ApiOptions.HasGoogleSignInAccountOptions))
    {
      localObject = ((Api.ApiOptions.HasGoogleSignInAccountOptions)localObject).getGoogleSignInAccount();
      if (localObject != null)
      {
        localObject = ((GoogleSignInAccount)localObject).getRequestedScopes();
        break label113;
      }
    }
    localObject = Collections.emptySet();
    label113:
    return localBuilder.addAllRequiredScopes((Collection)localObject).setRealClientClassName(this.mContext.getClass().getName()).setRealClientPackageName(this.mContext.getPackageName());
  }
  
  protected Task<Boolean> disconnectService()
  {
    return this.zabm.zac(this);
  }
  
  public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doBestEffortWrite(T paramT)
  {
    return zaa(2, paramT);
  }
  
  public <TResult, A extends Api.AnyClient> Task<TResult> doBestEffortWrite(TaskApiCall<A, TResult> paramTaskApiCall)
  {
    return zaa(2, paramTaskApiCall);
  }
  
  public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doRead(T paramT)
  {
    return zaa(0, paramT);
  }
  
  public <TResult, A extends Api.AnyClient> Task<TResult> doRead(TaskApiCall<A, TResult> paramTaskApiCall)
  {
    return zaa(0, paramTaskApiCall);
  }
  
  @Deprecated
  public <A extends Api.AnyClient, T extends RegisterListenerMethod<A, ?>, U extends UnregisterListenerMethod<A, ?>> Task<Void> doRegisterEventListener(T paramT, U paramU)
  {
    Preconditions.checkNotNull(paramT);
    Preconditions.checkNotNull(paramU);
    Preconditions.checkNotNull(paramT.getListenerKey(), "Listener has already been released.");
    Preconditions.checkNotNull(paramU.getListenerKey(), "Listener has already been released.");
    Preconditions.checkArgument(paramT.getListenerKey().equals(paramU.getListenerKey()), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
    return this.zabm.zaa(this, paramT, paramU);
  }
  
  public <A extends Api.AnyClient> Task<Void> doRegisterEventListener(RegistrationMethods<A, ?> paramRegistrationMethods)
  {
    Preconditions.checkNotNull(paramRegistrationMethods);
    Preconditions.checkNotNull(paramRegistrationMethods.zajz.getListenerKey(), "Listener has already been released.");
    Preconditions.checkNotNull(paramRegistrationMethods.zaka.getListenerKey(), "Listener has already been released.");
    return this.zabm.zaa(this, paramRegistrationMethods.zajz, paramRegistrationMethods.zaka);
  }
  
  public Task<Boolean> doUnregisterEventListener(ListenerHolder.ListenerKey<?> paramListenerKey)
  {
    Preconditions.checkNotNull(paramListenerKey, "Listener key cannot be null.");
    return this.zabm.zaa(this, paramListenerKey);
  }
  
  public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doWrite(T paramT)
  {
    return zaa(1, paramT);
  }
  
  public <TResult, A extends Api.AnyClient> Task<TResult> doWrite(TaskApiCall<A, TResult> paramTaskApiCall)
  {
    return zaa(1, paramTaskApiCall);
  }
  
  public final Api<O> getApi()
  {
    return this.mApi;
  }
  
  public O getApiOptions()
  {
    return this.zabh;
  }
  
  public Context getApplicationContext()
  {
    return this.mContext;
  }
  
  public final int getInstanceId()
  {
    return this.mId;
  }
  
  public Looper getLooper()
  {
    return this.zabj;
  }
  
  public <L> ListenerHolder<L> registerListener(L paramL, String paramString)
  {
    return ListenerHolders.createListenerHolder(paramL, this.zabj, paramString);
  }
  
  public Api.Client zaa(Looper paramLooper, GoogleApiManager.zaa<O> paramzaa)
  {
    ClientSettings localClientSettings = createClientSettingsBuilder().build();
    return this.mApi.zai().buildClient(this.mContext, paramLooper, localClientSettings, this.zabh, paramzaa, paramzaa);
  }
  
  public zace zaa(Context paramContext, Handler paramHandler)
  {
    return new zace(paramContext, paramHandler, createClientSettingsBuilder().build());
  }
  
  public final zai<O> zak()
  {
    return this.zabi;
  }
  
  public static class Settings
  {
    public static final Settings DEFAULT_SETTINGS = new Builder().build();
    public final StatusExceptionMapper zabn;
    public final Looper zabo;
    
    private Settings(StatusExceptionMapper paramStatusExceptionMapper, Account paramAccount, Looper paramLooper)
    {
      this.zabn = paramStatusExceptionMapper;
      this.zabo = paramLooper;
    }
    
    public static class Builder
    {
      private Looper zabj;
      private StatusExceptionMapper zabl;
      
      public GoogleApi.Settings build()
      {
        if (this.zabl == null) {
          this.zabl = new ApiExceptionMapper();
        }
        if (this.zabj == null) {
          this.zabj = Looper.getMainLooper();
        }
        return new GoogleApi.Settings(this.zabl, null, this.zabj, null);
      }
      
      public Builder setLooper(Looper paramLooper)
      {
        Preconditions.checkNotNull(paramLooper, "Looper must not be null.");
        this.zabj = paramLooper;
        return this;
      }
      
      public Builder setMapper(StatusExceptionMapper paramStatusExceptionMapper)
      {
        Preconditions.checkNotNull(paramStatusExceptionMapper, "StatusExceptionMapper must not be null.");
        this.zabl = paramStatusExceptionMapper;
        return this;
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\GoogleApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */