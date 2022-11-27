package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ProgressBar;
import androidx.core.app.NotificationCompat.BigTextStyle;
import androidx.core.app.NotificationCompat.Builder;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.base.R.drawable;
import com.google.android.gms.base.R.string;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.api.internal.zabr;
import com.google.android.gms.common.api.internal.zabu;
import com.google.android.gms.common.api.internal.zal;
import com.google.android.gms.common.internal.ConnectionErrorMessages;
import com.google.android.gms.common.internal.DialogRedirect;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.base.zap;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class GoogleApiAvailability
  extends GoogleApiAvailabilityLight
{
  public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
  private static final Object mLock = new Object();
  private static final GoogleApiAvailability zaao = new GoogleApiAvailability();
  private String zaap;
  
  public static GoogleApiAvailability getInstance()
  {
    return zaao;
  }
  
  public static Dialog zaa(Activity paramActivity, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    Object localObject = new ProgressBar(paramActivity, null, 16842874);
    ((ProgressBar)localObject).setIndeterminate(true);
    ((ProgressBar)localObject).setVisibility(0);
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramActivity);
    localBuilder.setView((View)localObject);
    localBuilder.setMessage(ConnectionErrorMessages.getErrorMessage(paramActivity, 18));
    localBuilder.setPositiveButton("", null);
    localObject = localBuilder.create();
    zaa(paramActivity, (Dialog)localObject, "GooglePlayServicesUpdatingDialog", paramOnCancelListener);
    return (Dialog)localObject;
  }
  
  static Dialog zaa(Context paramContext, int paramInt, DialogRedirect paramDialogRedirect, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AlertDialog.Builder localBuilder = null;
    if (paramInt == 0) {
      return null;
    }
    Object localObject = new TypedValue();
    paramContext.getTheme().resolveAttribute(16843529, (TypedValue)localObject, true);
    if ("Theme.Dialog.Alert".equals(paramContext.getResources().getResourceEntryName(((TypedValue)localObject).resourceId))) {
      localBuilder = new AlertDialog.Builder(paramContext, 5);
    }
    localObject = localBuilder;
    if (localBuilder == null) {
      localObject = new AlertDialog.Builder(paramContext);
    }
    ((AlertDialog.Builder)localObject).setMessage(ConnectionErrorMessages.getErrorMessage(paramContext, paramInt));
    if (paramOnCancelListener != null) {
      ((AlertDialog.Builder)localObject).setOnCancelListener(paramOnCancelListener);
    }
    paramOnCancelListener = ConnectionErrorMessages.getErrorDialogButtonMessage(paramContext, paramInt);
    if (paramOnCancelListener != null) {
      ((AlertDialog.Builder)localObject).setPositiveButton(paramOnCancelListener, paramDialogRedirect);
    }
    paramContext = ConnectionErrorMessages.getErrorTitle(paramContext, paramInt);
    if (paramContext != null) {
      ((AlertDialog.Builder)localObject).setTitle(paramContext);
    }
    return ((AlertDialog.Builder)localObject).create();
  }
  
  static void zaa(Activity paramActivity, Dialog paramDialog, String paramString, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if ((paramActivity instanceof FragmentActivity))
    {
      paramActivity = ((FragmentActivity)paramActivity).getSupportFragmentManager();
      SupportErrorDialogFragment.newInstance(paramDialog, paramOnCancelListener).show(paramActivity, paramString);
      return;
    }
    paramActivity = paramActivity.getFragmentManager();
    ErrorDialogFragment.newInstance(paramDialog, paramOnCancelListener).show(paramActivity, paramString);
  }
  
  private final void zaa(Context paramContext, int paramInt, String paramString, PendingIntent paramPendingIntent)
  {
    if (paramInt == 18)
    {
      zaa(paramContext);
      return;
    }
    if (paramPendingIntent == null)
    {
      if (paramInt == 6) {
        Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
      }
      return;
    }
    Object localObject1 = ConnectionErrorMessages.getErrorNotificationTitle(paramContext, paramInt);
    paramString = ConnectionErrorMessages.getErrorNotificationMessage(paramContext, paramInt);
    Object localObject2 = paramContext.getResources();
    NotificationManager localNotificationManager = (NotificationManager)paramContext.getSystemService("notification");
    localObject1 = new NotificationCompat.Builder(paramContext).setLocalOnly(true).setAutoCancel(true).setContentTitle((CharSequence)localObject1).setStyle(new NotificationCompat.BigTextStyle().bigText(paramString));
    if (DeviceProperties.isWearable(paramContext))
    {
      Preconditions.checkState(PlatformVersion.isAtLeastKitKatWatch());
      ((NotificationCompat.Builder)localObject1).setSmallIcon(paramContext.getApplicationInfo().icon).setPriority(2);
      if (DeviceProperties.isWearableWithoutPlayStore(paramContext)) {
        ((NotificationCompat.Builder)localObject1).addAction(R.drawable.common_full_open_on_phone, ((Resources)localObject2).getString(R.string.common_open_on_phone), paramPendingIntent);
      } else {
        ((NotificationCompat.Builder)localObject1).setContentIntent(paramPendingIntent);
      }
    }
    else
    {
      ((NotificationCompat.Builder)localObject1).setSmallIcon(17301642).setTicker(((Resources)localObject2).getString(R.string.common_google_play_services_notification_ticker)).setWhen(System.currentTimeMillis()).setContentIntent(paramPendingIntent).setContentText(paramString);
    }
    if (PlatformVersion.isAtLeastO())
    {
      Preconditions.checkState(PlatformVersion.isAtLeastO());
      paramPendingIntent = zag();
      paramString = paramPendingIntent;
      if (paramPendingIntent == null)
      {
        paramPendingIntent = "com.google.android.gms.availability";
        localObject2 = localNotificationManager.getNotificationChannel("com.google.android.gms.availability");
        paramContext = ConnectionErrorMessages.getDefaultNotificationChannelName(paramContext);
        if (localObject2 == null)
        {
          localNotificationManager.createNotificationChannel(new NotificationChannel("com.google.android.gms.availability", paramContext, 4));
          paramString = paramPendingIntent;
        }
        else
        {
          paramString = paramPendingIntent;
          if (!paramContext.contentEquals(((NotificationChannel)localObject2).getName()))
          {
            ((NotificationChannel)localObject2).setName(paramContext);
            localNotificationManager.createNotificationChannel((NotificationChannel)localObject2);
            paramString = paramPendingIntent;
          }
        }
      }
      ((NotificationCompat.Builder)localObject1).setChannelId(paramString);
    }
    paramContext = ((NotificationCompat.Builder)localObject1).build();
    if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3))
    {
      paramInt = 39789;
    }
    else
    {
      paramInt = 10436;
      GooglePlayServicesUtilLight.sCanceledAvailabilityNotification.set(false);
    }
    localNotificationManager.notify(paramInt, paramContext);
  }
  
  private final String zag()
  {
    synchronized (mLock)
    {
      String str = this.zaap;
      return str;
    }
  }
  
  public Task<Void> checkApiAvailability(GoogleApi<?> paramGoogleApi, GoogleApi<?>... paramVarArgs)
  {
    Preconditions.checkNotNull(paramGoogleApi, "Requested API must not be null.");
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Preconditions.checkNotNull(paramVarArgs[i], "Requested API must not be null.");
      i += 1;
    }
    ArrayList localArrayList = new ArrayList(paramVarArgs.length + 1);
    localArrayList.add(paramGoogleApi);
    localArrayList.addAll(Arrays.asList(paramVarArgs));
    return GoogleApiManager.zabc().zaa(localArrayList).continueWith(new zaa(this));
  }
  
  public int getClientVersion(Context paramContext)
  {
    return super.getClientVersion(paramContext);
  }
  
  public Dialog getErrorDialog(Activity paramActivity, int paramInt1, int paramInt2)
  {
    return getErrorDialog(paramActivity, paramInt1, paramInt2, null);
  }
  
  public Dialog getErrorDialog(Activity paramActivity, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return zaa(paramActivity, paramInt1, DialogRedirect.getInstance(paramActivity, getErrorResolutionIntent(paramActivity, paramInt1, "d"), paramInt2), paramOnCancelListener);
  }
  
  public Intent getErrorResolutionIntent(Context paramContext, int paramInt, String paramString)
  {
    return super.getErrorResolutionIntent(paramContext, paramInt, paramString);
  }
  
  public PendingIntent getErrorResolutionPendingIntent(Context paramContext, int paramInt1, int paramInt2)
  {
    return super.getErrorResolutionPendingIntent(paramContext, paramInt1, paramInt2);
  }
  
  public PendingIntent getErrorResolutionPendingIntent(Context paramContext, ConnectionResult paramConnectionResult)
  {
    if (paramConnectionResult.hasResolution()) {
      return paramConnectionResult.getResolution();
    }
    return getErrorResolutionPendingIntent(paramContext, paramConnectionResult.getErrorCode(), 0);
  }
  
  public final String getErrorString(int paramInt)
  {
    return super.getErrorString(paramInt);
  }
  
  public int isGooglePlayServicesAvailable(Context paramContext)
  {
    return super.isGooglePlayServicesAvailable(paramContext);
  }
  
  public int isGooglePlayServicesAvailable(Context paramContext, int paramInt)
  {
    return super.isGooglePlayServicesAvailable(paramContext, paramInt);
  }
  
  public final boolean isUserResolvableError(int paramInt)
  {
    return super.isUserResolvableError(paramInt);
  }
  
  public Task<Void> makeGooglePlayServicesAvailable(Activity paramActivity)
  {
    int i = GOOGLE_PLAY_SERVICES_VERSION_CODE;
    Preconditions.checkMainThread("makeGooglePlayServicesAvailable must be called from the main thread");
    i = isGooglePlayServicesAvailable(paramActivity, i);
    if (i == 0) {
      return Tasks.forResult(null);
    }
    paramActivity = zabu.zac(paramActivity);
    paramActivity.zab(new ConnectionResult(i, null), 0);
    return paramActivity.getTask();
  }
  
  public void setDefaultNotificationChannelId(Context arg1, String paramString)
  {
    if (PlatformVersion.isAtLeastO()) {
      Preconditions.checkNotNull(((NotificationManager)???.getSystemService("notification")).getNotificationChannel(paramString));
    }
    synchronized (mLock)
    {
      this.zaap = paramString;
      return;
    }
  }
  
  public boolean showErrorDialogFragment(Activity paramActivity, int paramInt1, int paramInt2)
  {
    return showErrorDialogFragment(paramActivity, paramInt1, paramInt2, null);
  }
  
  public boolean showErrorDialogFragment(Activity paramActivity, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    Dialog localDialog = getErrorDialog(paramActivity, paramInt1, paramInt2, paramOnCancelListener);
    if (localDialog == null) {
      return false;
    }
    zaa(paramActivity, localDialog, "GooglePlayServicesErrorDialog", paramOnCancelListener);
    return true;
  }
  
  public void showErrorNotification(Context paramContext, int paramInt)
  {
    zaa(paramContext, paramInt, null, getErrorResolutionPendingIntent(paramContext, paramInt, 0, "n"));
  }
  
  public void showErrorNotification(Context paramContext, ConnectionResult paramConnectionResult)
  {
    PendingIntent localPendingIntent = getErrorResolutionPendingIntent(paramContext, paramConnectionResult);
    zaa(paramContext, paramConnectionResult.getErrorCode(), null, localPendingIntent);
  }
  
  public final zabq zaa(Context paramContext, zabr paramzabr)
  {
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addDataScheme("package");
    zabq localzabq = new zabq(paramzabr);
    paramContext.registerReceiver(localzabq, localIntentFilter);
    localzabq.zac(paramContext);
    if (!isUninstalledAppPossiblyUpdating(paramContext, "com.google.android.gms"))
    {
      paramzabr.zas();
      localzabq.unregister();
      return null;
    }
    return localzabq;
  }
  
  final void zaa(Context paramContext)
  {
    new zaa(paramContext).sendEmptyMessageDelayed(1, 120000L);
  }
  
  public final boolean zaa(Activity paramActivity, LifecycleFragment paramLifecycleFragment, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    paramLifecycleFragment = zaa(paramActivity, paramInt1, DialogRedirect.getInstance(paramLifecycleFragment, getErrorResolutionIntent(paramActivity, paramInt1, "d"), 2), paramOnCancelListener);
    if (paramLifecycleFragment == null) {
      return false;
    }
    zaa(paramActivity, paramLifecycleFragment, "GooglePlayServicesErrorDialog", paramOnCancelListener);
    return true;
  }
  
  public final boolean zaa(Context paramContext, ConnectionResult paramConnectionResult, int paramInt)
  {
    PendingIntent localPendingIntent = getErrorResolutionPendingIntent(paramContext, paramConnectionResult);
    if (localPendingIntent != null)
    {
      zaa(paramContext, paramConnectionResult.getErrorCode(), null, GoogleApiActivity.zaa(paramContext, localPendingIntent, paramInt));
      return true;
    }
    return false;
  }
  
  private final class zaa
    extends zap
  {
    private final Context zaaq;
    
    public zaa(Context paramContext)
    {
      super();
      this.zaaq = paramContext.getApplicationContext();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      if (paramMessage.what != 1)
      {
        i = paramMessage.what;
        paramMessage = new StringBuilder(50);
        paramMessage.append("Don't know how to handle this message: ");
        paramMessage.append(i);
        Log.w("GoogleApiAvailability", paramMessage.toString());
        return;
      }
      int i = GoogleApiAvailability.this.isGooglePlayServicesAvailable(this.zaaq);
      if (GoogleApiAvailability.this.isUserResolvableError(i)) {
        GoogleApiAvailability.this.showErrorNotification(this.zaaq, i);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\GoogleApiAvailability.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */