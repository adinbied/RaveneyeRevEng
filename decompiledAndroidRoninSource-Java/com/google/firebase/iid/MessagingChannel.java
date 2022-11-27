package com.google.firebase.iid;

import com.google.android.gms.tasks.Task;
import javax.annotation.Nullable;

public abstract interface MessagingChannel
{
  public abstract Task<Void> ackMessage(String paramString);
  
  public abstract Task<Void> buildChannel(String paramString1, @Nullable String paramString2);
  
  public abstract Task<Void> deleteInstanceId(String paramString);
  
  public abstract Task<Void> deleteToken(String paramString1, @Nullable String paramString2, String paramString3, String paramString4);
  
  public abstract Task<String> getToken(String paramString1, @Nullable String paramString2, String paramString3, String paramString4);
  
  public abstract boolean isAvailable();
  
  public abstract boolean isChannelBuilt();
  
  public abstract boolean needsRefresh();
  
  public abstract Task<Void> subscribeToTopic(String paramString1, String paramString2, String paramString3);
  
  public abstract Task<Void> unsubscribeFromTopic(String paramString1, String paramString2, String paramString3);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\iid\MessagingChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */