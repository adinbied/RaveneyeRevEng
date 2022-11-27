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
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.DataUpdateListenerRegistrationRequest;
import com.google.android.gms.fitness.request.DataUpdateRequest;
import com.google.android.gms.fitness.result.DailyTotalResult;
import com.google.android.gms.fitness.result.DataReadResult;
import java.util.concurrent.TimeUnit;

public abstract interface HistoryApi
{
  public abstract PendingResult<Status> deleteData(GoogleApiClient paramGoogleApiClient, DataDeleteRequest paramDataDeleteRequest);
  
  public abstract PendingResult<Status> insertData(GoogleApiClient paramGoogleApiClient, DataSet paramDataSet);
  
  public abstract PendingResult<DailyTotalResult> readDailyTotal(GoogleApiClient paramGoogleApiClient, DataType paramDataType);
  
  public abstract PendingResult<DailyTotalResult> readDailyTotalFromLocalDevice(GoogleApiClient paramGoogleApiClient, DataType paramDataType);
  
  public abstract PendingResult<DataReadResult> readData(GoogleApiClient paramGoogleApiClient, DataReadRequest paramDataReadRequest);
  
  public abstract PendingResult<Status> registerDataUpdateListener(GoogleApiClient paramGoogleApiClient, DataUpdateListenerRegistrationRequest paramDataUpdateListenerRegistrationRequest);
  
  public abstract PendingResult<Status> unregisterDataUpdateListener(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent);
  
  public abstract PendingResult<Status> updateData(GoogleApiClient paramGoogleApiClient, DataUpdateRequest paramDataUpdateRequest);
  
  public static class ViewIntentBuilder
  {
    private final Context zzp;
    private final DataType zzq;
    private DataSource zzr;
    private long zzs;
    private long zzt;
    private String zzu;
    
    public ViewIntentBuilder(Context paramContext, DataType paramDataType)
    {
      this.zzp = paramContext;
      this.zzq = paramDataType;
    }
    
    public Intent build()
    {
      long l = this.zzs;
      boolean bool2 = true;
      boolean bool1;
      if (l > 0L) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      Preconditions.checkState(bool1, "Start time must be set");
      if (this.zzt > this.zzs) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      Preconditions.checkState(bool1, "End time must be set and after start time");
      Object localObject = new Intent("vnd.google.fitness.VIEW");
      ((Intent)localObject).setType(DataType.getMimeType(this.zzr.getDataType()));
      ((Intent)localObject).putExtra("vnd.google.fitness.start_time", this.zzs);
      ((Intent)localObject).putExtra("vnd.google.fitness.end_time", this.zzt);
      SafeParcelableSerializer.serializeToIntentExtra(this.zzr, (Intent)localObject, "vnd.google.fitness.data_source");
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
    
    public ViewIntentBuilder setDataSource(DataSource paramDataSource)
    {
      Preconditions.checkArgument(paramDataSource.getDataType().equals(this.zzq), "Data source %s is not for the data type %s", new Object[] { paramDataSource, this.zzq });
      this.zzr = paramDataSource;
      return this;
    }
    
    public ViewIntentBuilder setPreferredApplication(String paramString)
    {
      this.zzu = paramString;
      return this;
    }
    
    public ViewIntentBuilder setTimeInterval(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
    {
      this.zzs = paramTimeUnit.toMillis(paramLong1);
      this.zzt = paramTimeUnit.toMillis(paramLong2);
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\HistoryApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */