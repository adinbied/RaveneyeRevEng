package com.google.firebase.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.events.Event;
import com.google.firebase.events.Publisher;

public class DataCollectionConfigStorage
{
  public static final String DATA_COLLECTION_DEFAULT_ENABLED = "firebase_data_collection_default_enabled";
  private static final String FIREBASE_APP_PREFS = "com.google.firebase.common.prefs:";
  private boolean dataCollectionDefaultEnabled;
  private final Context deviceProtectedContext;
  private final Publisher publisher;
  private final SharedPreferences sharedPreferences;
  
  public DataCollectionConfigStorage(Context paramContext, String paramString, Publisher paramPublisher)
  {
    paramContext = directBootSafe(paramContext);
    this.deviceProtectedContext = paramContext;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.google.firebase.common.prefs:");
    localStringBuilder.append(paramString);
    this.sharedPreferences = paramContext.getSharedPreferences(localStringBuilder.toString(), 0);
    this.publisher = paramPublisher;
    this.dataCollectionDefaultEnabled = readAutoDataCollectionEnabled();
  }
  
  private static Context directBootSafe(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 24) {
      return paramContext;
    }
    return ContextCompat.createDeviceProtectedStorageContext(paramContext);
  }
  
  private boolean readAutoDataCollectionEnabled()
  {
    if (this.sharedPreferences.contains("firebase_data_collection_default_enabled")) {
      return this.sharedPreferences.getBoolean("firebase_data_collection_default_enabled", true);
    }
    return readManifestDataCollectionEnabled();
  }
  
  private boolean readManifestDataCollectionEnabled()
  {
    try
    {
      Object localObject = this.deviceProtectedContext.getPackageManager();
      if (localObject != null)
      {
        localObject = ((PackageManager)localObject).getApplicationInfo(this.deviceProtectedContext.getPackageName(), 128);
        if ((localObject != null) && (((ApplicationInfo)localObject).metaData != null) && (((ApplicationInfo)localObject).metaData.containsKey("firebase_data_collection_default_enabled")))
        {
          boolean bool = ((ApplicationInfo)localObject).metaData.getBoolean("firebase_data_collection_default_enabled");
          return bool;
        }
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;) {}
    }
    return true;
  }
  
  private void updateDataCollectionDefaultEnabled(boolean paramBoolean)
  {
    try
    {
      if (this.dataCollectionDefaultEnabled != paramBoolean)
      {
        this.dataCollectionDefaultEnabled = paramBoolean;
        this.publisher.publish(new Event(DataCollectionDefaultChange.class, new DataCollectionDefaultChange(paramBoolean)));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isEnabled()
  {
    try
    {
      boolean bool = this.dataCollectionDefaultEnabled;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setEnabled(Boolean paramBoolean)
  {
    if (paramBoolean == null) {}
    try
    {
      this.sharedPreferences.edit().remove("firebase_data_collection_default_enabled").apply();
      updateDataCollectionDefaultEnabled(readManifestDataCollectionEnabled());
      break label73;
      boolean bool = Boolean.TRUE.equals(paramBoolean);
      this.sharedPreferences.edit().putBoolean("firebase_data_collection_default_enabled", bool).apply();
      updateDataCollectionDefaultEnabled(bool);
      label73:
      return;
    }
    finally {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\internal\DataCollectionConfigStorage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */