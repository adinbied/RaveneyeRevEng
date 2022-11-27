package com.google.firebase.installations;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.installations.local.PersistedInstallationEntry;

class GetIdListener
  implements StateListener
{
  final TaskCompletionSource<String> taskCompletionSource;
  
  public GetIdListener(TaskCompletionSource<String> paramTaskCompletionSource)
  {
    this.taskCompletionSource = paramTaskCompletionSource;
  }
  
  public boolean onException(PersistedInstallationEntry paramPersistedInstallationEntry, Exception paramException)
  {
    return false;
  }
  
  public boolean onStateReached(PersistedInstallationEntry paramPersistedInstallationEntry)
  {
    if ((!paramPersistedInstallationEntry.isUnregistered()) && (!paramPersistedInstallationEntry.isRegistered()) && (!paramPersistedInstallationEntry.isErrored())) {
      return false;
    }
    this.taskCompletionSource.trySetResult(paramPersistedInstallationEntry.getFirebaseInstallationId());
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\installations\GetIdListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */