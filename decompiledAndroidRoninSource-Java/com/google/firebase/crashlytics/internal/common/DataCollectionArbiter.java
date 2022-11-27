package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.internal.Logger;

public class DataCollectionArbiter
{
  private static final String FIREBASE_CRASHLYTICS_COLLECTION_ENABLED = "firebase_crashlytics_collection_enabled";
  private Boolean crashlyticsDataCollectionEnabled;
  TaskCompletionSource<Void> dataCollectionEnabledTask = new TaskCompletionSource();
  private TaskCompletionSource<Void> dataCollectionExplicitlyApproved = new TaskCompletionSource();
  private final FirebaseApp firebaseApp;
  private boolean setInManifest = false;
  private final SharedPreferences sharedPreferences;
  private final Object taskLock = new Object();
  boolean taskResolved = false;
  
  public DataCollectionArbiter(FirebaseApp arg1)
  {
    Context localContext = ???.getApplicationContext();
    this.firebaseApp = ???;
    this.sharedPreferences = CommonUtils.getSharedPrefs(localContext);
    Boolean localBoolean = getDataCollectionValueFromSharedPreferences();
    ??? = localBoolean;
    if (localBoolean == null) {
      ??? = getDataCollectionValueFromManifest(localContext);
    }
    this.crashlyticsDataCollectionEnabled = ???;
    synchronized (this.taskLock)
    {
      if (isAutomaticDataCollectionEnabled())
      {
        this.dataCollectionEnabledTask.trySetResult(null);
        this.taskResolved = true;
      }
      return;
    }
  }
  
  private Boolean getDataCollectionValueFromManifest(Context paramContext)
  {
    paramContext = readCrashlyticsDataCollectionEnabledFromManifest(paramContext);
    if (paramContext == null)
    {
      this.setInManifest = false;
      return null;
    }
    this.setInManifest = true;
    return Boolean.valueOf(Boolean.TRUE.equals(paramContext));
  }
  
  private Boolean getDataCollectionValueFromSharedPreferences()
  {
    if (this.sharedPreferences.contains("firebase_crashlytics_collection_enabled"))
    {
      this.setInManifest = false;
      return Boolean.valueOf(this.sharedPreferences.getBoolean("firebase_crashlytics_collection_enabled", true));
    }
    return null;
  }
  
  private void logDataCollectionState(boolean paramBoolean)
  {
    String str2;
    if (paramBoolean) {
      str2 = "ENABLED";
    } else {
      str2 = "DISABLED";
    }
    String str1;
    if (this.crashlyticsDataCollectionEnabled == null) {
      str1 = "global Firebase setting";
    } else if (this.setInManifest) {
      str1 = "firebase_crashlytics_collection_enabled manifest flag";
    } else {
      str1 = "API";
    }
    Logger.getLogger().d(String.format("Crashlytics automatic data collection %s by %s.", new Object[] { str2, str1 }));
  }
  
  private static Boolean readCrashlyticsDataCollectionEnabledFromManifest(Context paramContext)
  {
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      if (localPackageManager != null)
      {
        paramContext = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 128);
        if ((paramContext != null) && (paramContext.metaData != null) && (paramContext.metaData.containsKey("firebase_crashlytics_collection_enabled")))
        {
          boolean bool = paramContext.metaData.getBoolean("firebase_crashlytics_collection_enabled");
          return Boolean.valueOf(bool);
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Logger.getLogger().d("Unable to get PackageManager. Falling through", paramContext);
    }
    return null;
  }
  
  private static void storeDataCollectionValueInSharedPreferences(SharedPreferences paramSharedPreferences, Boolean paramBoolean)
  {
    paramSharedPreferences = paramSharedPreferences.edit();
    if (paramBoolean != null) {
      paramSharedPreferences.putBoolean("firebase_crashlytics_collection_enabled", paramBoolean.booleanValue());
    } else {
      paramSharedPreferences.remove("firebase_crashlytics_collection_enabled");
    }
    paramSharedPreferences.commit();
  }
  
  public void grantDataCollectionPermission(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.dataCollectionExplicitlyApproved.trySetResult(null);
      return;
    }
    throw new IllegalStateException("An invalid data collection token was used.");
  }
  
  public boolean isAutomaticDataCollectionEnabled()
  {
    try
    {
      boolean bool;
      if (this.crashlyticsDataCollectionEnabled != null) {
        bool = this.crashlyticsDataCollectionEnabled.booleanValue();
      } else {
        bool = this.firebaseApp.isDataCollectionDefaultEnabled();
      }
      logDataCollectionState(bool);
      return bool;
    }
    finally {}
  }
  
  public void setCrashlyticsDataCollectionEnabled(Boolean arg1)
  {
    if (??? != null) {
      try
      {
        this.setInManifest = false;
      }
      finally
      {
        Boolean localBoolean1;
        for (;;) {}
      }
    }
    Boolean localBoolean2;
    for (localBoolean1 = getDataCollectionValueFromManifest(this.firebaseApp.getApplicationContext());; localBoolean2 = ???)
    {
      this.crashlyticsDataCollectionEnabled = localBoolean1;
      storeDataCollectionValueInSharedPreferences(this.sharedPreferences, ???);
      synchronized (this.taskLock)
      {
        if (isAutomaticDataCollectionEnabled())
        {
          if (!this.taskResolved)
          {
            this.dataCollectionEnabledTask.trySetResult(null);
            this.taskResolved = true;
          }
        }
        else if (this.taskResolved)
        {
          this.dataCollectionEnabledTask = new TaskCompletionSource();
          this.taskResolved = false;
        }
        return;
      }
      throw ???;
      if (??? == null) {
        break;
      }
    }
  }
  
  public Task<Void> waitForAutomaticDataCollectionEnabled()
  {
    synchronized (this.taskLock)
    {
      Task localTask = this.dataCollectionEnabledTask.getTask();
      return localTask;
    }
  }
  
  public Task<Void> waitForDataCollectionPermission()
  {
    return Utils.race(this.dataCollectionExplicitlyApproved.getTask(), waitForAutomaticDataCollectionEnabled());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\common\DataCollectionArbiter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */