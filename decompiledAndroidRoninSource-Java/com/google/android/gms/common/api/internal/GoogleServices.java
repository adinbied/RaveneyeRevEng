package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.R.string;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.internal.zzp;

@Deprecated
public final class GoogleServices
{
  private static final Object sLock = new Object();
  private static GoogleServices zzay;
  private final String zzaz;
  private final Status zzba;
  private final boolean zzbb;
  private final boolean zzbc;
  
  GoogleServices(Context paramContext)
  {
    Object localObject = paramContext.getResources();
    int i = ((Resources)localObject).getIdentifier("google_app_measurement_enable", "integer", ((Resources)localObject).getResourcePackageName(R.string.common_google_play_services_unknown_issue));
    boolean bool1 = false;
    boolean bool2 = true;
    if (i != 0)
    {
      if (((Resources)localObject).getInteger(i) != 0) {
        bool1 = true;
      }
      this.zzbc = (bool1 ^ true);
    }
    else
    {
      this.zzbc = false;
      bool1 = bool2;
    }
    this.zzbb = bool1;
    String str = zzp.zzc(paramContext);
    localObject = str;
    if (str == null) {
      localObject = new StringResourceValueReader(paramContext).getString("google_app_id");
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      this.zzba = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
      this.zzaz = null;
      return;
    }
    this.zzaz = ((String)localObject);
    this.zzba = Status.RESULT_SUCCESS;
  }
  
  GoogleServices(String paramString, boolean paramBoolean)
  {
    this.zzaz = paramString;
    this.zzba = Status.RESULT_SUCCESS;
    this.zzbb = paramBoolean;
    this.zzbc = (paramBoolean ^ true);
  }
  
  private static GoogleServices checkInitialized(String paramString)
  {
    synchronized (sLock)
    {
      if (zzay != null)
      {
        paramString = zzay;
        return paramString;
      }
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString).length() + 34);
      localStringBuilder.append("Initialize must be called before ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(".");
      throw new IllegalStateException(localStringBuilder.toString());
    }
  }
  
  static void clearInstanceForTest()
  {
    synchronized (sLock)
    {
      zzay = null;
      return;
    }
  }
  
  public static String getGoogleAppId()
  {
    return checkInitialized("getGoogleAppId").zzaz;
  }
  
  public static Status initialize(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext, "Context must not be null.");
    synchronized (sLock)
    {
      if (zzay == null) {
        zzay = new GoogleServices(paramContext);
      }
      paramContext = zzay.zzba;
      return paramContext;
    }
  }
  
  public static Status initialize(Context arg0, String paramString, boolean paramBoolean)
  {
    Preconditions.checkNotNull(???, "Context must not be null.");
    Preconditions.checkNotEmpty(paramString, "App ID must be nonempty.");
    synchronized (sLock)
    {
      if (zzay != null)
      {
        paramString = zzay.checkGoogleAppId(paramString);
        return paramString;
      }
      paramString = new GoogleServices(paramString, paramBoolean);
      zzay = paramString;
      paramString = paramString.zzba;
      return paramString;
    }
  }
  
  public static boolean isMeasurementEnabled()
  {
    GoogleServices localGoogleServices = checkInitialized("isMeasurementEnabled");
    return (localGoogleServices.zzba.isSuccess()) && (localGoogleServices.zzbb);
  }
  
  public static boolean isMeasurementExplicitlyDisabled()
  {
    return checkInitialized("isMeasurementExplicitlyDisabled").zzbc;
  }
  
  final Status checkGoogleAppId(String paramString)
  {
    Object localObject = this.zzaz;
    if ((localObject != null) && (!((String)localObject).equals(paramString)))
    {
      paramString = this.zzaz;
      localObject = new StringBuilder(String.valueOf(paramString).length() + 97);
      ((StringBuilder)localObject).append("Initialize was called with two different Google App IDs.  Only the first app ID will be used: '");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("'.");
      return new Status(10, ((StringBuilder)localObject).toString());
    }
    return Status.RESULT_SUCCESS;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\GoogleServices.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */