package com.google.firebase.emulators;

public final class EmulatedServiceSettings
{
  private final String host;
  private final int port;
  
  public EmulatedServiceSettings(String paramString, int paramInt)
  {
    this.host = paramString;
    this.port = paramInt;
  }
  
  public String getHost()
  {
    return this.host;
  }
  
  public int getPort()
  {
    return this.port;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\emulators\EmulatedServiceSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */