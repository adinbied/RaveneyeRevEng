package com.google.firebase.installations;

import com.google.android.gms.tasks.Task;

public abstract interface FirebaseInstallationsApi
{
  public abstract Task<Void> delete();
  
  public abstract Task<String> getId();
  
  public abstract Task<InstallationTokenResult> getToken(boolean paramBoolean);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\installations\FirebaseInstallationsApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */