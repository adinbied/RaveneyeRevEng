package com.huawei.hms.support.api.client;

import android.content.Context;

public abstract interface ApiClient
{
  public abstract String getAppID();
  
  public abstract Context getContext();
  
  public abstract String getCpID();
  
  public abstract String getPackageName();
  
  public abstract String getSessionId();
  
  public abstract SubAppInfo getSubAppInfo();
  
  public abstract String getTransportName();
  
  public abstract boolean isConnected();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\client\ApiClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */