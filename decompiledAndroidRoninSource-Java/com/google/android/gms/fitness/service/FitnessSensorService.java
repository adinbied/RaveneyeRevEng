package com.google.android.gms.fitness.service;

import android.app.AppOpsManager;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.result.DataSourcesResult;
import com.google.android.gms.internal.fitness.zzb;
import com.google.android.gms.internal.fitness.zzbk;
import com.google.android.gms.internal.fitness.zzcq;
import com.google.android.gms.internal.fitness.zzeu;
import com.google.android.gms.internal.fitness.zzew;
import com.google.android.gms.internal.fitness.zzez;
import java.util.List;

public abstract class FitnessSensorService
  extends Service
{
  public static final String SERVICE_INTERFACE = "com.google.android.gms.fitness.service.FitnessSensorService";
  private zza zzix;
  
  public IBinder onBind(Intent paramIntent)
  {
    if ("com.google.android.gms.fitness.service.FitnessSensorService".equals(paramIntent.getAction()))
    {
      if (Log.isLoggable("FitnessSensorService", 3))
      {
        paramIntent = String.valueOf(paramIntent);
        String str = getClass().getName();
        StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramIntent).length() + 20 + String.valueOf(str).length());
        localStringBuilder.append("Intent ");
        localStringBuilder.append(paramIntent);
        localStringBuilder.append(" received by ");
        localStringBuilder.append(str);
        Log.d("FitnessSensorService", localStringBuilder.toString());
      }
      return this.zzix.asBinder();
    }
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.zzix = new zza(this, null);
  }
  
  public abstract List<DataSource> onFindDataSources(List<DataType> paramList);
  
  public abstract boolean onRegister(FitnessSensorServiceRequest paramFitnessSensorServiceRequest);
  
  public abstract boolean onUnregister(DataSource paramDataSource);
  
  protected final void zzab()
    throws SecurityException
  {
    int i = Binder.getCallingUid();
    if (PlatformVersion.isAtLeastKitKat())
    {
      ((AppOpsManager)getSystemService("appops")).checkPackage(i, "com.google.android.gms");
      return;
    }
    String[] arrayOfString = getPackageManager().getPackagesForUid(i);
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equals("com.google.android.gms")) {
          return;
        }
        i += 1;
      }
    }
    throw new SecurityException("Unauthorized caller");
  }
  
  private static final class zza
    extends zzez
  {
    private final FitnessSensorService zziy;
    
    private zza(FitnessSensorService paramFitnessSensorService)
    {
      this.zziy = paramFitnessSensorService;
    }
    
    public final void zza(FitnessSensorServiceRequest paramFitnessSensorServiceRequest, zzcq paramzzcq)
      throws RemoteException
    {
      this.zziy.zzab();
      if (this.zziy.onRegister(paramFitnessSensorServiceRequest))
      {
        paramzzcq.onResult(Status.RESULT_SUCCESS);
        return;
      }
      paramzzcq.onResult(new Status(13));
    }
    
    public final void zza(zzeu paramzzeu, zzbk paramzzbk)
      throws RemoteException
    {
      this.zziy.zzab();
      paramzzbk.zza(new DataSourcesResult(this.zziy.onFindDataSources(paramzzeu.getDataTypes()), Status.RESULT_SUCCESS));
    }
    
    public final void zza(zzew paramzzew, zzcq paramzzcq)
      throws RemoteException
    {
      this.zziy.zzab();
      if (this.zziy.onUnregister(paramzzew.getDataSource()))
      {
        paramzzcq.onResult(Status.RESULT_SUCCESS);
        return;
      }
      paramzzcq.onResult(new Status(13));
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\service\FitnessSensorService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */