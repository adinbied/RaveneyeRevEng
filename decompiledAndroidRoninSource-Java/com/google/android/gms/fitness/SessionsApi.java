package com.google.android.gms.fitness;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.fitness.result.SessionStopResult;

public abstract interface SessionsApi
{
  public abstract PendingResult<Status> insertSession(GoogleApiClient paramGoogleApiClient, SessionInsertRequest paramSessionInsertRequest);
  
  public abstract PendingResult<SessionReadResult> readSession(GoogleApiClient paramGoogleApiClient, SessionReadRequest paramSessionReadRequest);
  
  public abstract PendingResult<Status> registerForSessions(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent);
  
  public abstract PendingResult<Status> startSession(GoogleApiClient paramGoogleApiClient, Session paramSession);
  
  public abstract PendingResult<SessionStopResult> stopSession(GoogleApiClient paramGoogleApiClient, String paramString);
  
  public abstract PendingResult<Status> unregisterForSessions(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent);
  
  public static class ViewIntentBuilder
  {
    private boolean zzaa = false;
    private final Context zzp;
    private String zzu;
    private Session zzz;
    
    public ViewIntentBuilder(Context paramContext)
    {
      this.zzp = paramContext;
    }
    
    public Intent build()
    {
      boolean bool;
      if (this.zzz != null) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkState(bool, "Session must be set");
      Object localObject = new Intent("vnd.google.fitness.VIEW");
      ((Intent)localObject).setType(Session.getMimeType(this.zzz.getActivity()));
      SafeParcelableSerializer.serializeToIntentExtra(this.zzz, (Intent)localObject, "vnd.google.fitness.session");
      if (!this.zzaa) {
        this.zzu = this.zzz.getAppPackageName();
      }
      if (this.zzu != null)
      {
        Intent localIntent = new Intent((Intent)localObject).setPackage(this.zzu);
        ResolveInfo localResolveInfo = this.zzp.getPackageManager().resolveActivity(localIntent, 0);
        if (localResolveInfo != null)
        {
          localObject = localResolveInfo.activityInfo.name;
          localIntent.setComponent(new ComponentName(this.zzu, (String)localObject));
          return localIntent;
        }
      }
      return (Intent)localObject;
    }
    
    public ViewIntentBuilder setPreferredApplication(String paramString)
    {
      this.zzu = paramString;
      this.zzaa = true;
      return this;
    }
    
    public ViewIntentBuilder setSession(Session paramSession)
    {
      this.zzz = paramSession;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\SessionsApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */