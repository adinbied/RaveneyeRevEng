package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.common.zze;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BaseGmsClient<T extends IInterface>
{
  public static final int CONNECT_STATE_CONNECTED = 4;
  public static final int CONNECT_STATE_DISCONNECTED = 1;
  public static final int CONNECT_STATE_DISCONNECTING = 5;
  public static final String DEFAULT_ACCOUNT = "<<default account>>";
  public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = { "service_esmobile", "service_googleme" };
  public static final String KEY_PENDING_INTENT = "pendingIntent";
  private static final Feature[] zzbt = new Feature[0];
  private final Context mContext;
  final Handler mHandler;
  private final Object mLock = new Object();
  private int zzbu;
  private long zzbv;
  private long zzbw;
  private int zzbx;
  private long zzby;
  private zzh zzbz;
  private final Looper zzca;
  private final GmsClientSupervisor zzcb;
  private final GoogleApiAvailabilityLight zzcc;
  private final Object zzcd = new Object();
  private IGmsServiceBroker zzce;
  protected ConnectionProgressReportCallbacks zzcf;
  private T zzcg;
  private final ArrayList<zzc<?>> zzch = new ArrayList();
  private zze zzci;
  private int zzcj = 1;
  private final BaseConnectionCallbacks zzck;
  private final BaseOnConnectionFailedListener zzcl;
  private final int zzcm;
  private final String zzcn;
  private ConnectionResult zzco = null;
  private boolean zzcp = false;
  private volatile zzb zzcq = null;
  protected AtomicInteger zzcr = new AtomicInteger(0);
  
  protected BaseGmsClient(Context paramContext, Handler paramHandler, GmsClientSupervisor paramGmsClientSupervisor, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, int paramInt, BaseConnectionCallbacks paramBaseConnectionCallbacks, BaseOnConnectionFailedListener paramBaseOnConnectionFailedListener)
  {
    this.mContext = ((Context)Preconditions.checkNotNull(paramContext, "Context must not be null"));
    this.mHandler = ((Handler)Preconditions.checkNotNull(paramHandler, "Handler must not be null"));
    this.zzca = paramHandler.getLooper();
    this.zzcb = ((GmsClientSupervisor)Preconditions.checkNotNull(paramGmsClientSupervisor, "Supervisor must not be null"));
    this.zzcc = ((GoogleApiAvailabilityLight)Preconditions.checkNotNull(paramGoogleApiAvailabilityLight, "API availability must not be null"));
    this.zzcm = paramInt;
    this.zzck = paramBaseConnectionCallbacks;
    this.zzcl = paramBaseOnConnectionFailedListener;
    this.zzcn = null;
  }
  
  protected BaseGmsClient(Context paramContext, Looper paramLooper, int paramInt, BaseConnectionCallbacks paramBaseConnectionCallbacks, BaseOnConnectionFailedListener paramBaseOnConnectionFailedListener, String paramString)
  {
    this(paramContext, paramLooper, GmsClientSupervisor.getInstance(paramContext), GoogleApiAvailabilityLight.getInstance(), paramInt, (BaseConnectionCallbacks)Preconditions.checkNotNull(paramBaseConnectionCallbacks), (BaseOnConnectionFailedListener)Preconditions.checkNotNull(paramBaseOnConnectionFailedListener), paramString);
  }
  
  protected BaseGmsClient(Context paramContext, Looper paramLooper, GmsClientSupervisor paramGmsClientSupervisor, GoogleApiAvailabilityLight paramGoogleApiAvailabilityLight, int paramInt, BaseConnectionCallbacks paramBaseConnectionCallbacks, BaseOnConnectionFailedListener paramBaseOnConnectionFailedListener, String paramString)
  {
    this.mContext = ((Context)Preconditions.checkNotNull(paramContext, "Context must not be null"));
    this.zzca = ((Looper)Preconditions.checkNotNull(paramLooper, "Looper must not be null"));
    this.zzcb = ((GmsClientSupervisor)Preconditions.checkNotNull(paramGmsClientSupervisor, "Supervisor must not be null"));
    this.zzcc = ((GoogleApiAvailabilityLight)Preconditions.checkNotNull(paramGoogleApiAvailabilityLight, "API availability must not be null"));
    this.mHandler = new zzb(paramLooper);
    this.zzcm = paramInt;
    this.zzck = paramBaseConnectionCallbacks;
    this.zzcl = paramBaseOnConnectionFailedListener;
    this.zzcn = paramString;
  }
  
  private final void zza(int paramInt, T paramT)
  {
    int i;
    if (paramInt == 4) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (paramT != null) {
      j = 1;
    } else {
      j = 0;
    }
    boolean bool;
    if (i == j) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    synchronized (this.mLock)
    {
      this.zzcj = paramInt;
      this.zzcg = paramT;
      onSetConnectState(paramInt, paramT);
      if (paramInt != 1)
      {
        if ((paramInt != 2) && (paramInt != 3))
        {
          if (paramInt == 4) {
            onConnectedLocked(paramT);
          }
        }
        else
        {
          if ((this.zzci != null) && (this.zzbz != null))
          {
            paramT = this.zzbz.zzt();
            localObject2 = this.zzbz.getPackageName();
            localObject3 = new StringBuilder(String.valueOf(paramT).length() + 70 + String.valueOf(localObject2).length());
            ((StringBuilder)localObject3).append("Calling connect() while still connected, missing disconnect() for ");
            ((StringBuilder)localObject3).append(paramT);
            ((StringBuilder)localObject3).append(" on ");
            ((StringBuilder)localObject3).append((String)localObject2);
            Log.e("GmsClient", ((StringBuilder)localObject3).toString());
            this.zzcb.zza(this.zzbz.zzt(), this.zzbz.getPackageName(), this.zzbz.zzq(), this.zzci, zzj());
            this.zzcr.incrementAndGet();
          }
          this.zzci = new zze(this.zzcr.get());
          if ((this.zzcj == 3) && (getLocalStartServiceAction() != null)) {
            paramT = new zzh(getContext().getPackageName(), getLocalStartServiceAction(), true, 129);
          } else {
            paramT = new zzh(getStartServicePackage(), getStartServiceAction(), false, 129);
          }
          this.zzbz = paramT;
          Object localObject2 = this.zzcb;
          paramT = paramT.zzt();
          Object localObject3 = this.zzbz.getPackageName();
          paramInt = this.zzbz.zzq();
          zze localzze = this.zzci;
          String str = zzj();
          if (!((GmsClientSupervisor)localObject2).zza(new GmsClientSupervisor.zza(paramT, (String)localObject3, paramInt), localzze, str))
          {
            paramT = this.zzbz.zzt();
            localObject2 = this.zzbz.getPackageName();
            localObject3 = new StringBuilder(String.valueOf(paramT).length() + 34 + String.valueOf(localObject2).length());
            ((StringBuilder)localObject3).append("unable to connect to service: ");
            ((StringBuilder)localObject3).append(paramT);
            ((StringBuilder)localObject3).append(" on ");
            ((StringBuilder)localObject3).append((String)localObject2);
            Log.e("GmsClient", ((StringBuilder)localObject3).toString());
            zza(16, null, this.zzcr.get());
          }
        }
      }
      else if (this.zzci != null)
      {
        this.zzcb.zza(this.zzbz.zzt(), this.zzbz.getPackageName(), this.zzbz.zzq(), this.zzci, zzj());
        this.zzci = null;
      }
      return;
    }
  }
  
  private final void zza(zzb paramzzb)
  {
    this.zzcq = paramzzb;
  }
  
  private final boolean zza(int paramInt1, int paramInt2, T paramT)
  {
    synchronized (this.mLock)
    {
      if (this.zzcj != paramInt1) {
        return false;
      }
      zza(paramInt2, paramT);
      return true;
    }
  }
  
  private final void zzb(int paramInt)
  {
    if (zzk())
    {
      paramInt = 5;
      this.zzcp = true;
    }
    else
    {
      paramInt = 4;
    }
    Handler localHandler = this.mHandler;
    localHandler.sendMessage(localHandler.obtainMessage(paramInt, this.zzcr.get(), 16));
  }
  
  private final String zzj()
  {
    String str2 = this.zzcn;
    String str1 = str2;
    if (str2 == null) {
      str1 = this.mContext.getClass().getName();
    }
    return str1;
  }
  
  private final boolean zzk()
  {
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (this.zzcj == 3)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  private final boolean zzl()
  {
    if (this.zzcp) {
      return false;
    }
    if (TextUtils.isEmpty(getServiceDescriptor())) {
      return false;
    }
    if (TextUtils.isEmpty(getLocalStartServiceAction())) {
      return false;
    }
    try
    {
      Class.forName(getServiceDescriptor());
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return false;
  }
  
  public void checkAvailabilityAndConnect()
  {
    int i = this.zzcc.isGooglePlayServicesAvailable(this.mContext, getMinApkVersion());
    if (i != 0)
    {
      zza(1, null);
      triggerNotAvailable(new LegacyClientCallbackAdapter(), i, null);
      return;
    }
    connect(new LegacyClientCallbackAdapter());
  }
  
  protected final void checkConnected()
  {
    if (isConnected()) {
      return;
    }
    throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
  }
  
  public void connect(ConnectionProgressReportCallbacks paramConnectionProgressReportCallbacks)
  {
    this.zzcf = ((ConnectionProgressReportCallbacks)Preconditions.checkNotNull(paramConnectionProgressReportCallbacks, "Connection progress callbacks cannot be null."));
    zza(2, null);
  }
  
  protected abstract T createServiceInterface(IBinder paramIBinder);
  
  public void disconnect()
  {
    this.zzcr.incrementAndGet();
    synchronized (this.zzch)
    {
      int j = this.zzch.size();
      int i = 0;
      while (i < j)
      {
        ((zzc)this.zzch.get(i)).removeListener();
        i += 1;
      }
      this.zzch.clear();
      synchronized (this.zzcd)
      {
        this.zzce = null;
        zza(1, null);
        return;
      }
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] arg4)
  {
    synchronized (this.mLock)
    {
      int i = this.zzcj;
      paramFileDescriptor = this.zzcg;
      synchronized (this.zzcd)
      {
        Object localObject = this.zzce;
        paramPrintWriter.append(paramString).append("mConnectState=");
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 4)
              {
                if (i != 5) {
                  paramPrintWriter.print("UNKNOWN");
                } else {
                  paramPrintWriter.print("DISCONNECTING");
                }
              }
              else {
                paramPrintWriter.print("CONNECTED");
              }
            }
            else {
              paramPrintWriter.print("LOCAL_CONNECTING");
            }
          }
          else {
            paramPrintWriter.print("REMOTE_CONNECTING");
          }
        }
        else {
          paramPrintWriter.print("DISCONNECTED");
        }
        paramPrintWriter.append(" mService=");
        if (paramFileDescriptor == null) {
          paramPrintWriter.append("null");
        } else {
          paramPrintWriter.append(getServiceDescriptor()).append("@").append(Integer.toHexString(System.identityHashCode(paramFileDescriptor.asBinder())));
        }
        paramPrintWriter.append(" mServiceBroker=");
        if (localObject == null) {
          paramPrintWriter.println("null");
        } else {
          paramPrintWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(((IGmsServiceBroker)localObject).asBinder())));
        }
        paramFileDescriptor = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        long l;
        StringBuilder localStringBuilder;
        if (this.zzbw > 0L)
        {
          ??? = paramPrintWriter.append(paramString).append("lastConnectedTime=");
          l = this.zzbw;
          localObject = paramFileDescriptor.format(new Date(this.zzbw));
          localStringBuilder = new StringBuilder(String.valueOf(localObject).length() + 21);
          localStringBuilder.append(l);
          localStringBuilder.append(" ");
          localStringBuilder.append((String)localObject);
          ???.println(localStringBuilder.toString());
        }
        if (this.zzbv > 0L)
        {
          paramPrintWriter.append(paramString).append("lastSuspendedCause=");
          i = this.zzbu;
          if (i != 1)
          {
            if (i != 2) {
              paramPrintWriter.append(String.valueOf(i));
            } else {
              paramPrintWriter.append("CAUSE_NETWORK_LOST");
            }
          }
          else {
            paramPrintWriter.append("CAUSE_SERVICE_DISCONNECTED");
          }
          ??? = paramPrintWriter.append(" lastSuspendedTime=");
          l = this.zzbv;
          localObject = paramFileDescriptor.format(new Date(this.zzbv));
          localStringBuilder = new StringBuilder(String.valueOf(localObject).length() + 21);
          localStringBuilder.append(l);
          localStringBuilder.append(" ");
          localStringBuilder.append((String)localObject);
          ???.println(localStringBuilder.toString());
        }
        if (this.zzby > 0L)
        {
          paramPrintWriter.append(paramString).append("lastFailedStatus=").append(CommonStatusCodes.getStatusCodeString(this.zzbx));
          paramString = paramPrintWriter.append(" lastFailedTime=");
          l = this.zzby;
          paramFileDescriptor = paramFileDescriptor.format(new Date(this.zzby));
          paramPrintWriter = new StringBuilder(String.valueOf(paramFileDescriptor).length() + 21);
          paramPrintWriter.append(l);
          paramPrintWriter.append(" ");
          paramPrintWriter.append(paramFileDescriptor);
          paramString.println(paramPrintWriter.toString());
        }
        return;
      }
    }
  }
  
  protected boolean enableLocalFallback()
  {
    return false;
  }
  
  public Account getAccount()
  {
    return null;
  }
  
  public Feature[] getApiFeatures()
  {
    return zzbt;
  }
  
  public final Feature[] getAvailableFeatures()
  {
    zzb localzzb = this.zzcq;
    if (localzzb == null) {
      return null;
    }
    return localzzb.zzdb;
  }
  
  public Bundle getConnectionHint()
  {
    return null;
  }
  
  public final Context getContext()
  {
    return this.mContext;
  }
  
  public String getEndpointPackageName()
  {
    if (isConnected())
    {
      zzh localzzh = this.zzbz;
      if (localzzh != null) {
        return localzzh.getPackageName();
      }
    }
    throw new RuntimeException("Failed to connect when checking package");
  }
  
  protected Bundle getGetServiceRequestExtraArgs()
  {
    return new Bundle();
  }
  
  protected String getLocalStartServiceAction()
  {
    return null;
  }
  
  public final Looper getLooper()
  {
    return this.zzca;
  }
  
  public int getMinApkVersion()
  {
    return GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
  }
  
  public void getRemoteService(IAccountAccessor arg1, Set<Scope> paramSet)
  {
    Bundle localBundle = getGetServiceRequestExtraArgs();
    GetServiceRequest localGetServiceRequest = new GetServiceRequest(this.zzcm);
    localGetServiceRequest.zzy = this.mContext.getPackageName();
    localGetServiceRequest.zzdk = localBundle;
    if (paramSet != null) {
      localGetServiceRequest.zzdj = ((Scope[])paramSet.toArray(new Scope[paramSet.size()]));
    }
    if (requiresSignIn())
    {
      if (getAccount() != null) {
        paramSet = getAccount();
      } else {
        paramSet = new Account("<<default account>>", "com.google");
      }
      localGetServiceRequest.zzdl = paramSet;
      if (??? != null) {
        localGetServiceRequest.zzdi = ???.asBinder();
      }
    }
    else if (requiresAccount())
    {
      localGetServiceRequest.zzdl = getAccount();
    }
    localGetServiceRequest.zzdm = zzbt;
    localGetServiceRequest.zzdn = getApiFeatures();
    try
    {
      try
      {
        synchronized (this.zzcd)
        {
          if (this.zzce != null) {
            this.zzce.getService(new zzd(this, this.zzcr.get()), localGetServiceRequest);
          } else {
            Log.w("GmsClient", "mServiceBroker is null, client disconnected");
          }
          return;
        }
        Log.w("GmsClient", "IGmsServiceBroker.getService failed", ???);
      }
      catch (RuntimeException ???) {}catch (RemoteException ???) {}
      onPostInitHandler(8, null, null, this.zzcr.get());
      return;
    }
    catch (SecurityException ???)
    {
      throw ???;
    }
    catch (DeadObjectException ???)
    {
      Log.w("GmsClient", "IGmsServiceBroker.getService failed", ???);
      triggerConnectionSuspended(1);
    }
  }
  
  protected Set<Scope> getScopes()
  {
    return Collections.EMPTY_SET;
  }
  
  public final T getService()
    throws DeadObjectException
  {
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (this.zzcj != 5)
        {
          checkConnected();
          if (this.zzcg != null)
          {
            bool = true;
            Preconditions.checkState(bool, "Client is connected but service is null");
            IInterface localIInterface = this.zzcg;
            return localIInterface;
          }
        }
        else
        {
          throw new DeadObjectException();
        }
      }
      boolean bool = false;
    }
  }
  
  public IBinder getServiceBrokerBinder()
  {
    synchronized (this.zzcd)
    {
      if (this.zzce == null) {
        return null;
      }
      IBinder localIBinder = this.zzce.asBinder();
      return localIBinder;
    }
  }
  
  protected abstract String getServiceDescriptor();
  
  public Intent getSignInIntent()
  {
    throw new UnsupportedOperationException("Not a sign in API");
  }
  
  protected abstract String getStartServiceAction();
  
  protected String getStartServicePackage()
  {
    return "com.google.android.gms";
  }
  
  public boolean isConnected()
  {
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (this.zzcj == 4)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public boolean isConnecting()
  {
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (this.zzcj == 2) {
          break label40;
        }
        if (this.zzcj == 3)
        {
          break label40;
          return bool;
        }
      }
      boolean bool = false;
      continue;
      label40:
      bool = true;
    }
  }
  
  protected void onConnectedLocked(T paramT)
  {
    this.zzbw = System.currentTimeMillis();
  }
  
  protected void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    this.zzbx = paramConnectionResult.getErrorCode();
    this.zzby = System.currentTimeMillis();
  }
  
  protected void onConnectionSuspended(int paramInt)
  {
    this.zzbu = paramInt;
    this.zzbv = System.currentTimeMillis();
  }
  
  protected void onPostInitHandler(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2)
  {
    Handler localHandler = this.mHandler;
    localHandler.sendMessage(localHandler.obtainMessage(1, paramInt2, -1, new zzf(paramInt1, paramIBinder, paramBundle)));
  }
  
  void onSetConnectState(int paramInt, T paramT) {}
  
  public void onUserSignOut(SignOutCallbacks paramSignOutCallbacks)
  {
    paramSignOutCallbacks.onSignOutComplete();
  }
  
  public boolean providesSignIn()
  {
    return false;
  }
  
  public boolean requiresAccount()
  {
    return false;
  }
  
  public boolean requiresGooglePlayServices()
  {
    return true;
  }
  
  public boolean requiresSignIn()
  {
    return false;
  }
  
  public void triggerConnectionSuspended(int paramInt)
  {
    Handler localHandler = this.mHandler;
    localHandler.sendMessage(localHandler.obtainMessage(6, this.zzcr.get(), paramInt));
  }
  
  protected void triggerNotAvailable(ConnectionProgressReportCallbacks paramConnectionProgressReportCallbacks, int paramInt, PendingIntent paramPendingIntent)
  {
    this.zzcf = ((ConnectionProgressReportCallbacks)Preconditions.checkNotNull(paramConnectionProgressReportCallbacks, "Connection progress callbacks cannot be null."));
    paramConnectionProgressReportCallbacks = this.mHandler;
    paramConnectionProgressReportCallbacks.sendMessage(paramConnectionProgressReportCallbacks.obtainMessage(3, this.zzcr.get(), paramInt, paramPendingIntent));
  }
  
  protected final void zza(int paramInt1, Bundle paramBundle, int paramInt2)
  {
    paramBundle = this.mHandler;
    paramBundle.sendMessage(paramBundle.obtainMessage(7, paramInt2, -1, new zzg(paramInt1, null)));
  }
  
  public static abstract interface BaseConnectionCallbacks
  {
    public abstract void onConnected(Bundle paramBundle);
    
    public abstract void onConnectionSuspended(int paramInt);
  }
  
  public static abstract interface BaseOnConnectionFailedListener
  {
    public abstract void onConnectionFailed(ConnectionResult paramConnectionResult);
  }
  
  public static abstract interface ConnectionProgressReportCallbacks
  {
    public abstract void onReportServiceBinding(ConnectionResult paramConnectionResult);
  }
  
  protected class LegacyClientCallbackAdapter
    implements BaseGmsClient.ConnectionProgressReportCallbacks
  {
    public LegacyClientCallbackAdapter() {}
    
    public void onReportServiceBinding(ConnectionResult paramConnectionResult)
    {
      if (paramConnectionResult.isSuccess())
      {
        paramConnectionResult = BaseGmsClient.this;
        paramConnectionResult.getRemoteService(null, paramConnectionResult.getScopes());
        return;
      }
      if (BaseGmsClient.zzg(BaseGmsClient.this) != null) {
        BaseGmsClient.zzg(BaseGmsClient.this).onConnectionFailed(paramConnectionResult);
      }
    }
  }
  
  public static abstract interface SignOutCallbacks
  {
    public abstract void onSignOutComplete();
  }
  
  private abstract class zza
    extends BaseGmsClient.zzc<Boolean>
  {
    private final int statusCode;
    private final Bundle zzcs;
    
    protected zza(int paramInt, Bundle paramBundle)
    {
      super(Boolean.valueOf(true));
      this.statusCode = paramInt;
      this.zzcs = paramBundle;
    }
    
    protected abstract void zza(ConnectionResult paramConnectionResult);
    
    protected abstract boolean zzm();
    
    protected final void zzn() {}
  }
  
  final class zzb
    extends zze
  {
    public zzb(Looper paramLooper)
    {
      super();
    }
    
    private static void zza(Message paramMessage)
    {
      paramMessage = (BaseGmsClient.zzc)paramMessage.obj;
      paramMessage.zzn();
      paramMessage.unregister();
    }
    
    private static boolean zzb(Message paramMessage)
    {
      if ((paramMessage.what != 2) && (paramMessage.what != 1)) {
        return paramMessage.what == 7;
      }
      return true;
    }
    
    public final void handleMessage(Message paramMessage)
    {
      if (BaseGmsClient.this.zzcr.get() != paramMessage.arg1)
      {
        if (zzb(paramMessage)) {
          zza(paramMessage);
        }
        return;
      }
      if (((paramMessage.what == 1) || (paramMessage.what == 7) || ((paramMessage.what == 4) && (!BaseGmsClient.this.enableLocalFallback())) || (paramMessage.what == 5)) && (!BaseGmsClient.this.isConnecting()))
      {
        zza(paramMessage);
        return;
      }
      int i = paramMessage.what;
      PendingIntent localPendingIntent = null;
      if (i == 4)
      {
        BaseGmsClient.zza(BaseGmsClient.this, new ConnectionResult(paramMessage.arg2));
        if ((BaseGmsClient.zzb(BaseGmsClient.this)) && (!BaseGmsClient.zzc(BaseGmsClient.this)))
        {
          BaseGmsClient.zza(BaseGmsClient.this, 3, null);
          return;
        }
        if (BaseGmsClient.zzd(BaseGmsClient.this) != null) {
          paramMessage = BaseGmsClient.zzd(BaseGmsClient.this);
        } else {
          paramMessage = new ConnectionResult(8);
        }
        BaseGmsClient.this.zzcf.onReportServiceBinding(paramMessage);
        BaseGmsClient.this.onConnectionFailed(paramMessage);
        return;
      }
      if (paramMessage.what == 5)
      {
        if (BaseGmsClient.zzd(BaseGmsClient.this) != null) {
          paramMessage = BaseGmsClient.zzd(BaseGmsClient.this);
        } else {
          paramMessage = new ConnectionResult(8);
        }
        BaseGmsClient.this.zzcf.onReportServiceBinding(paramMessage);
        BaseGmsClient.this.onConnectionFailed(paramMessage);
        return;
      }
      if (paramMessage.what == 3)
      {
        if ((paramMessage.obj instanceof PendingIntent)) {
          localPendingIntent = (PendingIntent)paramMessage.obj;
        }
        paramMessage = new ConnectionResult(paramMessage.arg2, localPendingIntent);
        BaseGmsClient.this.zzcf.onReportServiceBinding(paramMessage);
        BaseGmsClient.this.onConnectionFailed(paramMessage);
        return;
      }
      if (paramMessage.what == 6)
      {
        BaseGmsClient.zza(BaseGmsClient.this, 5, null);
        if (BaseGmsClient.zze(BaseGmsClient.this) != null) {
          BaseGmsClient.zze(BaseGmsClient.this).onConnectionSuspended(paramMessage.arg2);
        }
        BaseGmsClient.this.onConnectionSuspended(paramMessage.arg2);
        BaseGmsClient.zza(BaseGmsClient.this, 5, 1, null);
        return;
      }
      if ((paramMessage.what == 2) && (!BaseGmsClient.this.isConnected()))
      {
        zza(paramMessage);
        return;
      }
      if (zzb(paramMessage))
      {
        ((BaseGmsClient.zzc)paramMessage.obj).zzo();
        return;
      }
      i = paramMessage.what;
      paramMessage = new StringBuilder(45);
      paramMessage.append("Don't know how to handle message: ");
      paramMessage.append(i);
      Log.wtf("GmsClient", paramMessage.toString(), new Exception());
    }
  }
  
  protected abstract class zzc<TListener>
  {
    private TListener zzcu;
    private boolean zzcv;
    
    public zzc()
    {
      Object localObject;
      this.zzcu = localObject;
      this.zzcv = false;
    }
    
    public final void removeListener()
    {
      try
      {
        this.zzcu = null;
        return;
      }
      finally {}
    }
    
    public final void unregister()
    {
      removeListener();
      synchronized (BaseGmsClient.zzf(BaseGmsClient.this))
      {
        BaseGmsClient.zzf(BaseGmsClient.this).remove(this);
        return;
      }
    }
    
    protected abstract void zza(TListener paramTListener);
    
    protected abstract void zzn();
    
    /* Error */
    public final void zzo()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 24	com/google/android/gms/common/internal/BaseGmsClient$zzc:zzcu	Ljava/lang/Object;
      //   6: astore_1
      //   7: aload_0
      //   8: getfield 26	com/google/android/gms/common/internal/BaseGmsClient$zzc:zzcv	Z
      //   11: ifeq +56 -> 67
      //   14: aload_0
      //   15: invokestatic 55	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   18: astore_2
      //   19: new 57	java/lang/StringBuilder
      //   22: dup
      //   23: aload_2
      //   24: invokestatic 55	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   27: invokevirtual 61	java/lang/String:length	()I
      //   30: bipush 47
      //   32: iadd
      //   33: invokespecial 64	java/lang/StringBuilder:<init>	(I)V
      //   36: astore_3
      //   37: aload_3
      //   38: ldc 66
      //   40: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   43: pop
      //   44: aload_3
      //   45: aload_2
      //   46: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   49: pop
      //   50: aload_3
      //   51: ldc 72
      //   53: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   56: pop
      //   57: ldc 74
      //   59: aload_3
      //   60: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   63: invokestatic 84	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
      //   66: pop
      //   67: aload_0
      //   68: monitorexit
      //   69: aload_1
      //   70: ifnull +18 -> 88
      //   73: aload_0
      //   74: aload_1
      //   75: invokevirtual 86	com/google/android/gms/common/internal/BaseGmsClient$zzc:zza	(Ljava/lang/Object;)V
      //   78: goto +14 -> 92
      //   81: astore_1
      //   82: aload_0
      //   83: invokevirtual 88	com/google/android/gms/common/internal/BaseGmsClient$zzc:zzn	()V
      //   86: aload_1
      //   87: athrow
      //   88: aload_0
      //   89: invokevirtual 88	com/google/android/gms/common/internal/BaseGmsClient$zzc:zzn	()V
      //   92: aload_0
      //   93: monitorenter
      //   94: aload_0
      //   95: iconst_1
      //   96: putfield 26	com/google/android/gms/common/internal/BaseGmsClient$zzc:zzcv	Z
      //   99: aload_0
      //   100: monitorexit
      //   101: aload_0
      //   102: invokevirtual 90	com/google/android/gms/common/internal/BaseGmsClient$zzc:unregister	()V
      //   105: return
      //   106: astore_1
      //   107: aload_0
      //   108: monitorexit
      //   109: aload_1
      //   110: athrow
      //   111: astore_1
      //   112: aload_0
      //   113: monitorexit
      //   114: aload_1
      //   115: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	116	0	this	zzc
      //   6	69	1	localObject1	Object
      //   81	6	1	localRuntimeException	RuntimeException
      //   106	4	1	localObject2	Object
      //   111	4	1	localObject3	Object
      //   18	28	2	str	String
      //   36	24	3	localStringBuilder	StringBuilder
      // Exception table:
      //   from	to	target	type
      //   73	78	81	java/lang/RuntimeException
      //   94	101	106	finally
      //   107	109	106	finally
      //   2	67	111	finally
      //   67	69	111	finally
      //   112	114	111	finally
    }
  }
  
  public static final class zzd
    extends IGmsCallbacks.zza
  {
    private BaseGmsClient zzcw;
    private final int zzcx;
    
    public zzd(BaseGmsClient paramBaseGmsClient, int paramInt)
    {
      this.zzcw = paramBaseGmsClient;
      this.zzcx = paramInt;
    }
    
    public final void onPostInitComplete(int paramInt, IBinder paramIBinder, Bundle paramBundle)
    {
      Preconditions.checkNotNull(this.zzcw, "onPostInitComplete can be called only once per call to getRemoteService");
      this.zzcw.onPostInitHandler(paramInt, paramIBinder, paramBundle, this.zzcx);
      this.zzcw = null;
    }
    
    public final void zza(int paramInt, Bundle paramBundle)
    {
      Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }
    
    public final void zza(int paramInt, IBinder paramIBinder, zzb paramzzb)
    {
      Preconditions.checkNotNull(this.zzcw, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
      Preconditions.checkNotNull(paramzzb);
      BaseGmsClient.zza(this.zzcw, paramzzb);
      onPostInitComplete(paramInt, paramIBinder, paramzzb.zzda);
    }
  }
  
  public final class zze
    implements ServiceConnection
  {
    private final int zzcx;
    
    public zze(int paramInt)
    {
      this.zzcx = paramInt;
    }
    
    public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      if (paramIBinder == null)
      {
        BaseGmsClient.zza(BaseGmsClient.this, 16);
        return;
      }
      synchronized (BaseGmsClient.zza(BaseGmsClient.this))
      {
        BaseGmsClient localBaseGmsClient = BaseGmsClient.this;
        if (paramIBinder == null)
        {
          paramComponentName = null;
        }
        else
        {
          paramComponentName = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
          if ((paramComponentName != null) && ((paramComponentName instanceof IGmsServiceBroker))) {
            paramComponentName = (IGmsServiceBroker)paramComponentName;
          } else {
            paramComponentName = new IGmsServiceBroker.Stub.zza(paramIBinder);
          }
        }
        BaseGmsClient.zza(localBaseGmsClient, paramComponentName);
        BaseGmsClient.this.zza(0, null, this.zzcx);
        return;
      }
    }
    
    public final void onServiceDisconnected(ComponentName arg1)
    {
      synchronized (BaseGmsClient.zza(BaseGmsClient.this))
      {
        BaseGmsClient.zza(BaseGmsClient.this, null);
        BaseGmsClient.this.mHandler.sendMessage(BaseGmsClient.this.mHandler.obtainMessage(6, this.zzcx, 1));
        return;
      }
    }
  }
  
  protected final class zzf
    extends BaseGmsClient.zza
  {
    private final IBinder zzcy;
    
    public zzf(int paramInt, IBinder paramIBinder, Bundle paramBundle)
    {
      super(paramInt, paramBundle);
      this.zzcy = paramIBinder;
    }
    
    protected final void zza(ConnectionResult paramConnectionResult)
    {
      if (BaseGmsClient.zzg(BaseGmsClient.this) != null) {
        BaseGmsClient.zzg(BaseGmsClient.this).onConnectionFailed(paramConnectionResult);
      }
      BaseGmsClient.this.onConnectionFailed(paramConnectionResult);
    }
    
    protected final boolean zzm()
    {
      try
      {
        Object localObject = this.zzcy.getInterfaceDescriptor();
        if (!BaseGmsClient.this.getServiceDescriptor().equals(localObject))
        {
          String str = BaseGmsClient.this.getServiceDescriptor();
          StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(localObject).length());
          localStringBuilder.append("service descriptor mismatch: ");
          localStringBuilder.append(str);
          localStringBuilder.append(" vs. ");
          localStringBuilder.append((String)localObject);
          Log.e("GmsClient", localStringBuilder.toString());
          return false;
        }
        localObject = BaseGmsClient.this.createServiceInterface(this.zzcy);
        if ((localObject != null) && ((BaseGmsClient.zza(BaseGmsClient.this, 2, 4, (IInterface)localObject)) || (BaseGmsClient.zza(BaseGmsClient.this, 3, 4, (IInterface)localObject))))
        {
          BaseGmsClient.zza(BaseGmsClient.this, null);
          localObject = BaseGmsClient.this.getConnectionHint();
          if (BaseGmsClient.zze(BaseGmsClient.this) != null) {
            BaseGmsClient.zze(BaseGmsClient.this).onConnected((Bundle)localObject);
          }
          return true;
        }
        return false;
      }
      catch (RemoteException localRemoteException)
      {
        for (;;) {}
      }
      Log.w("GmsClient", "service probably died");
      return false;
    }
  }
  
  protected final class zzg
    extends BaseGmsClient.zza
  {
    public zzg(int paramInt, Bundle paramBundle)
    {
      super(paramInt, null);
    }
    
    protected final void zza(ConnectionResult paramConnectionResult)
    {
      if ((BaseGmsClient.this.enableLocalFallback()) && (BaseGmsClient.zzb(BaseGmsClient.this)))
      {
        BaseGmsClient.zza(BaseGmsClient.this, 16);
        return;
      }
      BaseGmsClient.this.zzcf.onReportServiceBinding(paramConnectionResult);
      BaseGmsClient.this.onConnectionFailed(paramConnectionResult);
    }
    
    protected final boolean zzm()
    {
      BaseGmsClient.this.zzcf.onReportServiceBinding(ConnectionResult.RESULT_SUCCESS);
      return true;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\internal\BaseGmsClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */