package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.GoogleApiAvailabilityCache;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.SimpleClientAdapter;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.base.zap;
import com.google.android.gms.signin.zad;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class GoogleApiManager
  implements Handler.Callback
{
  private static final Object lock = new Object();
  public static final Status zahx = new Status(4, "Sign-out occurred while this API call was in progress.");
  private static final Status zahy = new Status(4, "The user must be signed in to make this API call.");
  private static GoogleApiManager zaic;
  private final Handler handler;
  private long zahz = 5000L;
  private long zaia = 120000L;
  private long zaib = 10000L;
  private final Context zaid;
  private final GoogleApiAvailability zaie;
  private final GoogleApiAvailabilityCache zaif;
  private final AtomicInteger zaig = new AtomicInteger(1);
  private final AtomicInteger zaih = new AtomicInteger(0);
  private final Map<zai<?>, zaa<?>> zaii = new ConcurrentHashMap(5, 0.75F, 1);
  private zaae zaij = null;
  private final Set<zai<?>> zaik = new ArraySet();
  private final Set<zai<?>> zail = new ArraySet();
  
  private GoogleApiManager(Context paramContext, Looper paramLooper, GoogleApiAvailability paramGoogleApiAvailability)
  {
    this.zaid = paramContext;
    this.handler = new zap(paramLooper, this);
    this.zaie = paramGoogleApiAvailability;
    this.zaif = new GoogleApiAvailabilityCache(paramGoogleApiAvailability);
    paramContext = this.handler;
    paramContext.sendMessage(paramContext.obtainMessage(6));
  }
  
  public static void reportSignOut()
  {
    synchronized (lock)
    {
      if (zaic != null)
      {
        GoogleApiManager localGoogleApiManager = zaic;
        localGoogleApiManager.zaih.incrementAndGet();
        localGoogleApiManager.handler.sendMessageAtFrontOfQueue(localGoogleApiManager.handler.obtainMessage(10));
      }
      return;
    }
  }
  
  public static GoogleApiManager zab(Context paramContext)
  {
    synchronized (lock)
    {
      if (zaic == null)
      {
        Object localObject2 = new HandlerThread("GoogleApiHandler", 9);
        ((HandlerThread)localObject2).start();
        localObject2 = ((HandlerThread)localObject2).getLooper();
        zaic = new GoogleApiManager(paramContext.getApplicationContext(), (Looper)localObject2, GoogleApiAvailability.getInstance());
      }
      paramContext = zaic;
      return paramContext;
    }
  }
  
  private final void zab(GoogleApi<?> paramGoogleApi)
  {
    zai localzai = paramGoogleApi.zak();
    zaa localzaa2 = (zaa)this.zaii.get(localzai);
    zaa localzaa1 = localzaa2;
    if (localzaa2 == null)
    {
      localzaa1 = new zaa(paramGoogleApi);
      this.zaii.put(localzai, localzaa1);
    }
    if (localzaa1.requiresSignIn()) {
      this.zail.add(localzai);
    }
    localzaa1.connect();
  }
  
  public static GoogleApiManager zabc()
  {
    synchronized (lock)
    {
      Preconditions.checkNotNull(zaic, "Must guarantee manager is non-null before using getInstance");
      GoogleApiManager localGoogleApiManager = zaic;
      return localGoogleApiManager;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    long l = 300000L;
    Object localObject1 = null;
    Object localObject2;
    Object localObject3;
    switch (i)
    {
    default: 
      i = paramMessage.what;
      paramMessage = new StringBuilder(31);
      paramMessage.append("Unknown message id: ");
      paramMessage.append(i);
      Log.w("GoogleApiManager", paramMessage.toString());
      return false;
    case 16: 
      paramMessage = (zab)paramMessage.obj;
      if (this.zaii.containsKey(zab.zac(paramMessage)))
      {
        zaa.zab((zaa)this.zaii.get(zab.zac(paramMessage)), paramMessage);
        return true;
      }
      break;
    case 15: 
      paramMessage = (zab)paramMessage.obj;
      if (this.zaii.containsKey(zab.zac(paramMessage)))
      {
        zaa.zaa((zaa)this.zaii.get(zab.zac(paramMessage)), paramMessage);
        return true;
      }
      break;
    case 14: 
      paramMessage = (zaaf)paramMessage.obj;
      localObject1 = paramMessage.zak();
      if (!this.zaii.containsKey(localObject1))
      {
        paramMessage.zaal().setResult(Boolean.valueOf(false));
        return true;
      }
      boolean bool = zaa.zaa((zaa)this.zaii.get(localObject1), false);
      paramMessage.zaal().setResult(Boolean.valueOf(bool));
      return true;
    case 12: 
      if (this.zaii.containsKey(paramMessage.obj))
      {
        ((zaa)this.zaii.get(paramMessage.obj)).zabp();
        return true;
      }
      break;
    case 11: 
      if (this.zaii.containsKey(paramMessage.obj))
      {
        ((zaa)this.zaii.get(paramMessage.obj)).zaav();
        return true;
      }
      break;
    case 10: 
      paramMessage = this.zail.iterator();
      while (paramMessage.hasNext())
      {
        localObject1 = (zai)paramMessage.next();
        ((zaa)this.zaii.remove(localObject1)).zabj();
      }
      this.zail.clear();
      return true;
    case 9: 
      if (this.zaii.containsKey(paramMessage.obj))
      {
        ((zaa)this.zaii.get(paramMessage.obj)).resume();
        return true;
      }
      break;
    case 7: 
      zab((GoogleApi)paramMessage.obj);
      return true;
    case 6: 
      if ((PlatformVersion.isAtLeastIceCreamSandwich()) && ((this.zaid.getApplicationContext() instanceof Application)))
      {
        BackgroundDetector.initialize((Application)this.zaid.getApplicationContext());
        BackgroundDetector.getInstance().addListener(new zabi(this));
        if (!BackgroundDetector.getInstance().readCurrentStateIfPossible(true))
        {
          this.zaib = 300000L;
          return true;
        }
      }
      break;
    case 5: 
      i = paramMessage.arg1;
      localObject2 = (ConnectionResult)paramMessage.obj;
      localObject3 = this.zaii.values().iterator();
      do
      {
        paramMessage = (Message)localObject1;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        paramMessage = (zaa)((Iterator)localObject3).next();
      } while (paramMessage.getInstanceId() != i);
      if (paramMessage != null)
      {
        localObject1 = this.zaie.getErrorString(((ConnectionResult)localObject2).getErrorCode());
        localObject2 = ((ConnectionResult)localObject2).getErrorMessage();
        localObject3 = new StringBuilder(String.valueOf(localObject1).length() + 69 + String.valueOf(localObject2).length());
        ((StringBuilder)localObject3).append("Error resolution was canceled by the user, original error message: ");
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append(": ");
        ((StringBuilder)localObject3).append((String)localObject2);
        paramMessage.zac(new Status(17, ((StringBuilder)localObject3).toString()));
        return true;
      }
      paramMessage = new StringBuilder(76);
      paramMessage.append("Could not find API instance ");
      paramMessage.append(i);
      paramMessage.append(" while trying to fail enqueued calls.");
      Log.wtf("GoogleApiManager", paramMessage.toString(), new Exception());
      return true;
    case 4: 
    case 8: 
    case 13: 
      localObject2 = (zabv)paramMessage.obj;
      localObject1 = (zaa)this.zaii.get(((zabv)localObject2).zajt.zak());
      paramMessage = (Message)localObject1;
      if (localObject1 == null)
      {
        zab(((zabv)localObject2).zajt);
        paramMessage = (zaa)this.zaii.get(((zabv)localObject2).zajt.zak());
      }
      if ((paramMessage.requiresSignIn()) && (this.zaih.get() != ((zabv)localObject2).zajs))
      {
        ((zabv)localObject2).zajr.zaa(zahx);
        paramMessage.zabj();
        return true;
      }
      paramMessage.zaa(((zabv)localObject2).zajr);
      return true;
    case 3: 
      paramMessage = this.zaii.values().iterator();
    case 2: 
    case 1: 
      while (paramMessage.hasNext())
      {
        localObject1 = (zaa)paramMessage.next();
        ((zaa)localObject1).zabl();
        ((zaa)localObject1).connect();
        continue;
        paramMessage = (zak)paramMessage.obj;
        localObject1 = paramMessage.zap().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (zai)((Iterator)localObject1).next();
          localObject3 = (zaa)this.zaii.get(localObject2);
          if (localObject3 == null)
          {
            paramMessage.zaa((zai)localObject2, new ConnectionResult(13), null);
            return true;
          }
          if (((zaa)localObject3).isConnected())
          {
            paramMessage.zaa((zai)localObject2, ConnectionResult.RESULT_SUCCESS, ((zaa)localObject3).zaab().getEndpointPackageName());
          }
          else if (((zaa)localObject3).zabm() != null)
          {
            paramMessage.zaa((zai)localObject2, ((zaa)localObject3).zabm(), null);
          }
          else
          {
            ((zaa)localObject3).zaa(paramMessage);
            ((zaa)localObject3).connect();
            continue;
            if (((Boolean)paramMessage.obj).booleanValue()) {
              l = 10000L;
            }
            this.zaib = l;
            this.handler.removeMessages(12);
            paramMessage = this.zaii.keySet().iterator();
            while (paramMessage.hasNext())
            {
              localObject1 = (zai)paramMessage.next();
              localObject2 = this.handler;
              ((Handler)localObject2).sendMessageDelayed(((Handler)localObject2).obtainMessage(12, localObject1), this.zaib);
            }
          }
        }
      }
    }
    return true;
  }
  
  final void maybeSignOut()
  {
    this.zaih.incrementAndGet();
    Handler localHandler = this.handler;
    localHandler.sendMessage(localHandler.obtainMessage(10));
  }
  
  final PendingIntent zaa(zai<?> paramzai, int paramInt)
  {
    paramzai = (zaa)this.zaii.get(paramzai);
    if (paramzai == null) {
      return null;
    }
    paramzai = paramzai.zabq();
    if (paramzai == null) {
      return null;
    }
    return PendingIntent.getActivity(this.zaid, paramInt, paramzai.getSignInIntent(), 134217728);
  }
  
  public final <O extends Api.ApiOptions> Task<Boolean> zaa(GoogleApi<O> paramGoogleApi, ListenerHolder.ListenerKey<?> paramListenerKey)
  {
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    paramListenerKey = new zah(paramListenerKey, localTaskCompletionSource);
    Handler localHandler = this.handler;
    localHandler.sendMessage(localHandler.obtainMessage(13, new zabv(paramListenerKey, this.zaih.get(), paramGoogleApi)));
    return localTaskCompletionSource.getTask();
  }
  
  public final <O extends Api.ApiOptions> Task<Void> zaa(GoogleApi<O> paramGoogleApi, RegisterListenerMethod<Api.AnyClient, ?> paramRegisterListenerMethod, UnregisterListenerMethod<Api.AnyClient, ?> paramUnregisterListenerMethod)
  {
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    paramRegisterListenerMethod = new zaf(new zabw(paramRegisterListenerMethod, paramUnregisterListenerMethod), localTaskCompletionSource);
    paramUnregisterListenerMethod = this.handler;
    paramUnregisterListenerMethod.sendMessage(paramUnregisterListenerMethod.obtainMessage(8, new zabv(paramRegisterListenerMethod, this.zaih.get(), paramGoogleApi)));
    return localTaskCompletionSource.getTask();
  }
  
  public final Task<Map<zai<?>, String>> zaa(Iterable<? extends GoogleApi<?>> paramIterable)
  {
    paramIterable = new zak(paramIterable);
    Handler localHandler = this.handler;
    localHandler.sendMessage(localHandler.obtainMessage(2, paramIterable));
    return paramIterable.getTask();
  }
  
  public final void zaa(ConnectionResult paramConnectionResult, int paramInt)
  {
    if (!zac(paramConnectionResult, paramInt))
    {
      Handler localHandler = this.handler;
      localHandler.sendMessage(localHandler.obtainMessage(5, paramInt, 0, paramConnectionResult));
    }
  }
  
  public final void zaa(GoogleApi<?> paramGoogleApi)
  {
    Handler localHandler = this.handler;
    localHandler.sendMessage(localHandler.obtainMessage(7, paramGoogleApi));
  }
  
  public final <O extends Api.ApiOptions> void zaa(GoogleApi<O> paramGoogleApi, int paramInt, BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient> paramApiMethodImpl)
  {
    paramApiMethodImpl = new zae(paramInt, paramApiMethodImpl);
    Handler localHandler = this.handler;
    localHandler.sendMessage(localHandler.obtainMessage(4, new zabv(paramApiMethodImpl, this.zaih.get(), paramGoogleApi)));
  }
  
  public final <O extends Api.ApiOptions, ResultT> void zaa(GoogleApi<O> paramGoogleApi, int paramInt, TaskApiCall<Api.AnyClient, ResultT> paramTaskApiCall, TaskCompletionSource<ResultT> paramTaskCompletionSource, StatusExceptionMapper paramStatusExceptionMapper)
  {
    paramTaskApiCall = new zag(paramInt, paramTaskApiCall, paramTaskCompletionSource, paramStatusExceptionMapper);
    paramTaskCompletionSource = this.handler;
    paramTaskCompletionSource.sendMessage(paramTaskCompletionSource.obtainMessage(4, new zabv(paramTaskApiCall, this.zaih.get(), paramGoogleApi)));
  }
  
  public final void zaa(zaae paramzaae)
  {
    synchronized (lock)
    {
      if (this.zaij != paramzaae)
      {
        this.zaij = paramzaae;
        this.zaik.clear();
      }
      this.zaik.addAll(paramzaae.zaaj());
      return;
    }
  }
  
  final void zab(zaae paramzaae)
  {
    synchronized (lock)
    {
      if (this.zaij == paramzaae)
      {
        this.zaij = null;
        this.zaik.clear();
      }
      return;
    }
  }
  
  public final int zabd()
  {
    return this.zaig.getAndIncrement();
  }
  
  public final Task<Boolean> zac(GoogleApi<?> paramGoogleApi)
  {
    paramGoogleApi = new zaaf(paramGoogleApi.zak());
    Handler localHandler = this.handler;
    localHandler.sendMessage(localHandler.obtainMessage(14, paramGoogleApi));
    return paramGoogleApi.zaal().getTask();
  }
  
  final boolean zac(ConnectionResult paramConnectionResult, int paramInt)
  {
    return this.zaie.zaa(this.zaid, paramConnectionResult, paramInt);
  }
  
  public final void zao()
  {
    Handler localHandler = this.handler;
    localHandler.sendMessage(localHandler.obtainMessage(3));
  }
  
  public final class zaa<O extends Api.ApiOptions>
    implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, zar
  {
    private final zai<O> zafq;
    private final Queue<zab> zain = new LinkedList();
    private final Api.Client zaio;
    private final Api.AnyClient zaip;
    private final zaab zaiq;
    private final Set<zak> zair = new HashSet();
    private final Map<ListenerHolder.ListenerKey<?>, zabw> zais = new HashMap();
    private final int zait;
    private final zace zaiu;
    private boolean zaiv;
    private final List<GoogleApiManager.zab> zaiw = new ArrayList();
    private ConnectionResult zaix = null;
    
    public zaa()
    {
      Object localObject;
      Api.Client localClient = ((GoogleApi)localObject).zaa(GoogleApiManager.zaa(GoogleApiManager.this).getLooper(), this);
      this.zaio = localClient;
      if ((localClient instanceof SimpleClientAdapter)) {
        this.zaip = ((SimpleClientAdapter)localClient).getClient();
      } else {
        this.zaip = localClient;
      }
      this.zafq = ((GoogleApi)localObject).zak();
      this.zaiq = new zaab();
      this.zait = ((GoogleApi)localObject).getInstanceId();
      if (this.zaio.requiresSignIn())
      {
        this.zaiu = ((GoogleApi)localObject).zaa(GoogleApiManager.zab(GoogleApiManager.this), GoogleApiManager.zaa(GoogleApiManager.this));
        return;
      }
      this.zaiu = null;
    }
    
    private final Feature zaa(Feature[] paramArrayOfFeature)
    {
      if (paramArrayOfFeature != null)
      {
        if (paramArrayOfFeature.length == 0) {
          return null;
        }
        Object localObject2 = this.zaio.getAvailableFeatures();
        int j = 0;
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new Feature[0];
        }
        localObject2 = new ArrayMap(localObject1.length);
        int k = localObject1.length;
        int i = 0;
        while (i < k)
        {
          Object localObject3 = localObject1[i];
          ((Map)localObject2).put(((Feature)localObject3).getName(), Long.valueOf(((Feature)localObject3).getVersion()));
          i += 1;
        }
        k = paramArrayOfFeature.length;
        i = j;
        while (i < k)
        {
          localObject1 = paramArrayOfFeature[i];
          if (((Map)localObject2).containsKey(((Feature)localObject1).getName()))
          {
            if (((Long)((Map)localObject2).get(((Feature)localObject1).getName())).longValue() < ((Feature)localObject1).getVersion()) {
              return (Feature)localObject1;
            }
            i += 1;
          }
          else
          {
            return (Feature)localObject1;
          }
        }
      }
      return null;
    }
    
    private final void zaa(GoogleApiManager.zab paramzab)
    {
      if (!this.zaiw.contains(paramzab)) {
        return;
      }
      if (!this.zaiv)
      {
        if (!this.zaio.isConnected())
        {
          connect();
          return;
        }
        zabi();
      }
    }
    
    private final void zab(GoogleApiManager.zab paramzab)
    {
      if (this.zaiw.remove(paramzab))
      {
        GoogleApiManager.zaa(GoogleApiManager.this).removeMessages(15, paramzab);
        GoogleApiManager.zaa(GoogleApiManager.this).removeMessages(16, paramzab);
        paramzab = GoogleApiManager.zab.zad(paramzab);
        ArrayList localArrayList = new ArrayList(this.zain.size());
        Object localObject = this.zain.iterator();
        while (((Iterator)localObject).hasNext())
        {
          zab localzab = (zab)((Iterator)localObject).next();
          if ((localzab instanceof zac))
          {
            Feature[] arrayOfFeature = ((zac)localzab).zab(this);
            if ((arrayOfFeature != null) && (ArrayUtils.contains(arrayOfFeature, paramzab))) {
              localArrayList.add(localzab);
            }
          }
        }
        localArrayList = (ArrayList)localArrayList;
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          localObject = localArrayList.get(i);
          i += 1;
          localObject = (zab)localObject;
          this.zain.remove(localObject);
          ((zab)localObject).zaa(new UnsupportedApiCallException(paramzab));
        }
      }
    }
    
    private final boolean zab(zab paramzab)
    {
      if (!(paramzab instanceof zac))
      {
        zac(paramzab);
        return true;
      }
      zac localzac = (zac)paramzab;
      Feature localFeature = zaa(localzac.zab(this));
      if (localFeature == null)
      {
        zac(paramzab);
        return true;
      }
      if (localzac.zac(this))
      {
        paramzab = new GoogleApiManager.zab(this.zafq, localFeature, null);
        int i = this.zaiw.indexOf(paramzab);
        if (i >= 0)
        {
          paramzab = (GoogleApiManager.zab)this.zaiw.get(i);
          GoogleApiManager.zaa(GoogleApiManager.this).removeMessages(15, paramzab);
          GoogleApiManager.zaa(GoogleApiManager.this).sendMessageDelayed(Message.obtain(GoogleApiManager.zaa(GoogleApiManager.this), 15, paramzab), GoogleApiManager.zac(GoogleApiManager.this));
        }
        else
        {
          this.zaiw.add(paramzab);
          GoogleApiManager.zaa(GoogleApiManager.this).sendMessageDelayed(Message.obtain(GoogleApiManager.zaa(GoogleApiManager.this), 15, paramzab), GoogleApiManager.zac(GoogleApiManager.this));
          GoogleApiManager.zaa(GoogleApiManager.this).sendMessageDelayed(Message.obtain(GoogleApiManager.zaa(GoogleApiManager.this), 16, paramzab), GoogleApiManager.zad(GoogleApiManager.this));
          paramzab = new ConnectionResult(2, null);
          if (!zah(paramzab)) {
            GoogleApiManager.this.zac(paramzab, this.zait);
          }
        }
      }
      else
      {
        localzac.zaa(new UnsupportedApiCallException(localFeature));
      }
      return false;
    }
    
    private final void zabg()
    {
      zabl();
      zai(ConnectionResult.RESULT_SUCCESS);
      zabn();
      Iterator localIterator = this.zais.values().iterator();
      while (localIterator.hasNext())
      {
        zabw localzabw = (zabw)localIterator.next();
        if (zaa(localzabw.zajx.getRequiredFeatures()) != null) {
          localIterator.remove();
        }
        try
        {
          localzabw.zajx.registerListener(this.zaip, new TaskCompletionSource());
        }
        catch (DeadObjectException localDeadObjectException)
        {
          for (;;) {}
        }
        catch (RemoteException localRemoteException)
        {
          for (;;) {}
        }
        localIterator.remove();
        continue;
        onConnectionSuspended(1);
        this.zaio.disconnect();
      }
      zabi();
      zabo();
    }
    
    private final void zabh()
    {
      zabl();
      this.zaiv = true;
      this.zaiq.zaai();
      GoogleApiManager.zaa(GoogleApiManager.this).sendMessageDelayed(Message.obtain(GoogleApiManager.zaa(GoogleApiManager.this), 9, this.zafq), GoogleApiManager.zac(GoogleApiManager.this));
      GoogleApiManager.zaa(GoogleApiManager.this).sendMessageDelayed(Message.obtain(GoogleApiManager.zaa(GoogleApiManager.this), 11, this.zafq), GoogleApiManager.zad(GoogleApiManager.this));
      GoogleApiManager.zae(GoogleApiManager.this).flush();
    }
    
    private final void zabi()
    {
      ArrayList localArrayList = (ArrayList)new ArrayList(this.zain);
      int k = localArrayList.size();
      int i = 0;
      while (i < k)
      {
        Object localObject = localArrayList.get(i);
        int j = i + 1;
        localObject = (zab)localObject;
        if (!this.zaio.isConnected()) {
          break;
        }
        i = j;
        if (zab((zab)localObject))
        {
          this.zain.remove(localObject);
          i = j;
        }
      }
    }
    
    private final void zabn()
    {
      if (this.zaiv)
      {
        GoogleApiManager.zaa(GoogleApiManager.this).removeMessages(11, this.zafq);
        GoogleApiManager.zaa(GoogleApiManager.this).removeMessages(9, this.zafq);
        this.zaiv = false;
      }
    }
    
    private final void zabo()
    {
      GoogleApiManager.zaa(GoogleApiManager.this).removeMessages(12, this.zafq);
      GoogleApiManager.zaa(GoogleApiManager.this).sendMessageDelayed(GoogleApiManager.zaa(GoogleApiManager.this).obtainMessage(12, this.zafq), GoogleApiManager.zai(GoogleApiManager.this));
    }
    
    private final void zac(zab paramzab)
    {
      paramzab.zaa(this.zaiq, requiresSignIn());
      try
      {
        paramzab.zaa(this);
        return;
      }
      catch (DeadObjectException paramzab)
      {
        for (;;) {}
      }
      onConnectionSuspended(1);
      this.zaio.disconnect();
    }
    
    private final boolean zac(boolean paramBoolean)
    {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(GoogleApiManager.this));
      if ((this.zaio.isConnected()) && (this.zais.size() == 0))
      {
        if (this.zaiq.zaag())
        {
          if (paramBoolean) {
            zabo();
          }
          return false;
        }
        this.zaio.disconnect();
        return true;
      }
      return false;
    }
    
    private final boolean zah(ConnectionResult paramConnectionResult)
    {
      synchronized ()
      {
        if ((GoogleApiManager.zaf(GoogleApiManager.this) != null) && (GoogleApiManager.zag(GoogleApiManager.this).contains(this.zafq)))
        {
          GoogleApiManager.zaf(GoogleApiManager.this).zab(paramConnectionResult, this.zait);
          return true;
        }
        return false;
      }
    }
    
    private final void zai(ConnectionResult paramConnectionResult)
    {
      Iterator localIterator = this.zair.iterator();
      while (localIterator.hasNext())
      {
        zak localzak = (zak)localIterator.next();
        String str = null;
        if (Objects.equal(paramConnectionResult, ConnectionResult.RESULT_SUCCESS)) {
          str = this.zaio.getEndpointPackageName();
        }
        localzak.zaa(this.zafq, paramConnectionResult, str);
      }
      this.zair.clear();
    }
    
    public final void connect()
    {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(GoogleApiManager.this));
      if (!this.zaio.isConnected())
      {
        if (this.zaio.isConnecting()) {
          return;
        }
        int i = GoogleApiManager.zae(GoogleApiManager.this).getClientAvailability(GoogleApiManager.zab(GoogleApiManager.this), this.zaio);
        if (i != 0)
        {
          onConnectionFailed(new ConnectionResult(i, null));
          return;
        }
        GoogleApiManager.zac localzac = new GoogleApiManager.zac(GoogleApiManager.this, this.zaio, this.zafq);
        if (this.zaio.requiresSignIn()) {
          this.zaiu.zaa(localzac);
        }
        this.zaio.connect(localzac);
      }
    }
    
    public final int getInstanceId()
    {
      return this.zait;
    }
    
    final boolean isConnected()
    {
      return this.zaio.isConnected();
    }
    
    public final void onConnected(Bundle paramBundle)
    {
      if (Looper.myLooper() == GoogleApiManager.zaa(GoogleApiManager.this).getLooper())
      {
        zabg();
        return;
      }
      GoogleApiManager.zaa(GoogleApiManager.this).post(new zabj(this));
    }
    
    public final void onConnectionFailed(ConnectionResult paramConnectionResult)
    {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(GoogleApiManager.this));
      Object localObject = this.zaiu;
      if (localObject != null) {
        ((zace)localObject).zabs();
      }
      zabl();
      GoogleApiManager.zae(GoogleApiManager.this).flush();
      zai(paramConnectionResult);
      if (paramConnectionResult.getErrorCode() == 4)
      {
        zac(GoogleApiManager.zabf());
        return;
      }
      if (this.zain.isEmpty())
      {
        this.zaix = paramConnectionResult;
        return;
      }
      if (zah(paramConnectionResult)) {
        return;
      }
      if (!GoogleApiManager.this.zac(paramConnectionResult, this.zait))
      {
        if (paramConnectionResult.getErrorCode() == 18) {
          this.zaiv = true;
        }
        if (this.zaiv)
        {
          GoogleApiManager.zaa(GoogleApiManager.this).sendMessageDelayed(Message.obtain(GoogleApiManager.zaa(GoogleApiManager.this), 9, this.zafq), GoogleApiManager.zac(GoogleApiManager.this));
          return;
        }
        paramConnectionResult = this.zafq.zan();
        localObject = new StringBuilder(String.valueOf(paramConnectionResult).length() + 38);
        ((StringBuilder)localObject).append("API: ");
        ((StringBuilder)localObject).append(paramConnectionResult);
        ((StringBuilder)localObject).append(" is not available on this device.");
        zac(new Status(17, ((StringBuilder)localObject).toString()));
      }
    }
    
    public final void onConnectionSuspended(int paramInt)
    {
      if (Looper.myLooper() == GoogleApiManager.zaa(GoogleApiManager.this).getLooper())
      {
        zabh();
        return;
      }
      GoogleApiManager.zaa(GoogleApiManager.this).post(new zabk(this));
    }
    
    public final boolean requiresSignIn()
    {
      return this.zaio.requiresSignIn();
    }
    
    public final void resume()
    {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(GoogleApiManager.this));
      if (this.zaiv) {
        connect();
      }
    }
    
    public final void zaa(ConnectionResult paramConnectionResult, Api<?> paramApi, boolean paramBoolean)
    {
      if (Looper.myLooper() == GoogleApiManager.zaa(GoogleApiManager.this).getLooper())
      {
        onConnectionFailed(paramConnectionResult);
        return;
      }
      GoogleApiManager.zaa(GoogleApiManager.this).post(new zabl(this, paramConnectionResult));
    }
    
    public final void zaa(zab paramzab)
    {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(GoogleApiManager.this));
      if (this.zaio.isConnected())
      {
        if (zab(paramzab))
        {
          zabo();
          return;
        }
        this.zain.add(paramzab);
        return;
      }
      this.zain.add(paramzab);
      paramzab = this.zaix;
      if ((paramzab != null) && (paramzab.hasResolution()))
      {
        onConnectionFailed(this.zaix);
        return;
      }
      connect();
    }
    
    public final void zaa(zak paramzak)
    {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(GoogleApiManager.this));
      this.zair.add(paramzak);
    }
    
    public final Api.Client zaab()
    {
      return this.zaio;
    }
    
    public final void zaav()
    {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(GoogleApiManager.this));
      if (this.zaiv)
      {
        zabn();
        Status localStatus;
        if (GoogleApiManager.zah(GoogleApiManager.this).isGooglePlayServicesAvailable(GoogleApiManager.zab(GoogleApiManager.this)) == 18) {
          localStatus = new Status(8, "Connection timed out while waiting for Google Play services update to complete.");
        } else {
          localStatus = new Status(8, "API failed to connect while resuming due to an unknown error.");
        }
        zac(localStatus);
        this.zaio.disconnect();
      }
    }
    
    public final void zabj()
    {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(GoogleApiManager.this));
      zac(GoogleApiManager.zahx);
      this.zaiq.zaah();
      ListenerHolder.ListenerKey[] arrayOfListenerKey = (ListenerHolder.ListenerKey[])this.zais.keySet().toArray(new ListenerHolder.ListenerKey[this.zais.size()]);
      int j = arrayOfListenerKey.length;
      int i = 0;
      while (i < j)
      {
        zaa(new zah(arrayOfListenerKey[i], new TaskCompletionSource()));
        i += 1;
      }
      zai(new ConnectionResult(4));
      if (this.zaio.isConnected()) {
        this.zaio.onUserSignOut(new zabm(this));
      }
    }
    
    public final Map<ListenerHolder.ListenerKey<?>, zabw> zabk()
    {
      return this.zais;
    }
    
    public final void zabl()
    {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(GoogleApiManager.this));
      this.zaix = null;
    }
    
    public final ConnectionResult zabm()
    {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(GoogleApiManager.this));
      return this.zaix;
    }
    
    public final boolean zabp()
    {
      return zac(true);
    }
    
    final zad zabq()
    {
      zace localzace = this.zaiu;
      if (localzace == null) {
        return null;
      }
      return localzace.zabq();
    }
    
    public final void zac(Status paramStatus)
    {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(GoogleApiManager.this));
      Iterator localIterator = this.zain.iterator();
      while (localIterator.hasNext()) {
        ((zab)localIterator.next()).zaa(paramStatus);
      }
      this.zain.clear();
    }
    
    public final void zag(ConnectionResult paramConnectionResult)
    {
      Preconditions.checkHandlerThread(GoogleApiManager.zaa(GoogleApiManager.this));
      this.zaio.disconnect();
      onConnectionFailed(paramConnectionResult);
    }
  }
  
  private static final class zab
  {
    private final zai<?> zajb;
    private final Feature zajc;
    
    private zab(zai<?> paramzai, Feature paramFeature)
    {
      this.zajb = paramzai;
      this.zajc = paramFeature;
    }
    
    public final boolean equals(Object paramObject)
    {
      if ((paramObject != null) && ((paramObject instanceof zab)))
      {
        paramObject = (zab)paramObject;
        if ((Objects.equal(this.zajb, ((zab)paramObject).zajb)) && (Objects.equal(this.zajc, ((zab)paramObject).zajc))) {
          return true;
        }
      }
      return false;
    }
    
    public final int hashCode()
    {
      return Objects.hashCode(new Object[] { this.zajb, this.zajc });
    }
    
    public final String toString()
    {
      return Objects.toStringHelper(this).add("key", this.zajb).add("feature", this.zajc).toString();
    }
  }
  
  private final class zac
    implements zach, BaseGmsClient.ConnectionProgressReportCallbacks
  {
    private final zai<?> zafq;
    private final Api.Client zaio;
    private IAccountAccessor zajd = null;
    private Set<Scope> zaje = null;
    private boolean zajf = false;
    
    public zac(zai<?> paramzai)
    {
      this.zaio = paramzai;
      zai localzai;
      this.zafq = localzai;
    }
    
    private final void zabr()
    {
      if (this.zajf)
      {
        IAccountAccessor localIAccountAccessor = this.zajd;
        if (localIAccountAccessor != null) {
          this.zaio.getRemoteService(localIAccountAccessor, this.zaje);
        }
      }
    }
    
    public final void onReportServiceBinding(ConnectionResult paramConnectionResult)
    {
      GoogleApiManager.zaa(GoogleApiManager.this).post(new zabo(this, paramConnectionResult));
    }
    
    public final void zaa(IAccountAccessor paramIAccountAccessor, Set<Scope> paramSet)
    {
      if ((paramIAccountAccessor != null) && (paramSet != null))
      {
        this.zajd = paramIAccountAccessor;
        this.zaje = paramSet;
        zabr();
        return;
      }
      Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
      zag(new ConnectionResult(4));
    }
    
    public final void zag(ConnectionResult paramConnectionResult)
    {
      ((GoogleApiManager.zaa)GoogleApiManager.zaj(GoogleApiManager.this).get(this.zafq)).zag(paramConnectionResult);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\GoogleApiManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */