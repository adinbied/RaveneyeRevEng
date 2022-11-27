package com.google.firebase.messaging;

import java.util.Locale;

public final class SendException
  extends Exception
{
  public static final int ERROR_INVALID_PARAMETERS = 1;
  public static final int ERROR_SIZE = 2;
  public static final int ERROR_TOO_MANY_MESSAGES = 4;
  public static final int ERROR_TTL_EXCEEDED = 3;
  public static final int ERROR_UNKNOWN = 0;
  private final int zza;
  
  SendException(String paramString)
  {
    super(paramString);
    int j = 0;
    int i = j;
    if (paramString != null)
    {
      paramString = paramString.toLowerCase(Locale.US);
      i = -1;
      switch (paramString.hashCode())
      {
      default: 
        break;
      case -95047692: 
        if (paramString.equals("missing_to")) {
          i = 1;
        }
        break;
      case -617027085: 
        if (paramString.equals("messagetoobig")) {
          i = 2;
        }
        break;
      case -920906446: 
        if (paramString.equals("invalid_parameters")) {
          i = 0;
        }
        break;
      case -1290953729: 
        if (paramString.equals("toomanymessages")) {
          i = 4;
        }
        break;
      case -1743242157: 
        if (paramString.equals("service_not_available")) {
          i = 3;
        }
        break;
      }
      if ((i != 0) && (i != 1))
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              i = j;
            } else {
              i = 4;
            }
          }
          else {
            i = 3;
          }
        }
        else {
          i = 2;
        }
      }
      else {
        i = 1;
      }
    }
    this.zza = i;
  }
  
  public final int getErrorCode()
  {
    return this.zza;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\messaging\SendException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */