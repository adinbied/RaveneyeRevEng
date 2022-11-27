package com.google.firebase.crashlytics.internal.settings.network;

import com.google.firebase.crashlytics.internal.network.HttpMethod;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;

public class CreateAppSpiCall
  extends AbstractAppSpiCall
{
  public CreateAppSpiCall(String paramString1, String paramString2, HttpRequestFactory paramHttpRequestFactory, String paramString3)
  {
    super(paramString1, paramString2, paramHttpRequestFactory, HttpMethod.POST, paramString3);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\settings\network\CreateAppSpiCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */