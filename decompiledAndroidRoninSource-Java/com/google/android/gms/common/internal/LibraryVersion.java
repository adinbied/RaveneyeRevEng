package com.google.android.gms.common.internal;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class LibraryVersion
{
  private static final GmsLogger zzel = new GmsLogger("LibraryVersion", "");
  private static LibraryVersion zzem = new LibraryVersion();
  private ConcurrentHashMap<String, String> zzen = new ConcurrentHashMap();
  
  public static LibraryVersion getInstance()
  {
    return zzem;
  }
  
  public String getVersion(String paramString)
  {
    Preconditions.checkNotEmpty(paramString, "Please provide a valid libraryName");
    if (this.zzen.containsKey(paramString)) {
      return (String)this.zzen.get(paramString);
    }
    Object localObject2 = new Properties();
    Object localObject3 = null;
    GmsLogger localGmsLogger = null;
    Object localObject1 = localGmsLogger;
    try
    {
      Object localObject4 = LibraryVersion.class.getResourceAsStream(String.format("/%s.properties", new Object[] { paramString }));
      if (localObject4 != null)
      {
        localObject1 = localGmsLogger;
        ((Properties)localObject2).load((InputStream)localObject4);
        localObject1 = localGmsLogger;
        localObject2 = ((Properties)localObject2).getProperty("version", null);
        localObject1 = localObject2;
        localGmsLogger = zzel;
        localObject1 = localObject2;
        localObject3 = new StringBuilder(String.valueOf(paramString).length() + 12 + String.valueOf(localObject2).length());
        localObject1 = localObject2;
        ((StringBuilder)localObject3).append(paramString);
        localObject1 = localObject2;
        ((StringBuilder)localObject3).append(" version is ");
        localObject1 = localObject2;
        ((StringBuilder)localObject3).append((String)localObject2);
        localObject1 = localObject2;
        localGmsLogger.v("LibraryVersion", ((StringBuilder)localObject3).toString());
        localObject1 = localObject2;
      }
      else
      {
        localObject1 = localGmsLogger;
        localObject4 = zzel;
        localObject1 = localGmsLogger;
        localObject2 = String.valueOf(paramString);
        localObject1 = localGmsLogger;
        if (((String)localObject2).length() != 0)
        {
          localObject1 = localGmsLogger;
          localObject2 = "Failed to get app version for libraryName: ".concat((String)localObject2);
        }
        else
        {
          localObject1 = localGmsLogger;
          localObject2 = new String("Failed to get app version for libraryName: ");
        }
        localObject1 = localGmsLogger;
        ((GmsLogger)localObject4).e("LibraryVersion", (String)localObject2);
        localObject1 = localObject3;
      }
    }
    catch (IOException localIOException)
    {
      localObject3 = zzel;
      localObject2 = String.valueOf(paramString);
      if (((String)localObject2).length() != 0) {
        localObject2 = "Failed to get app version for libraryName: ".concat((String)localObject2);
      } else {
        localObject2 = new String("Failed to get app version for libraryName: ");
      }
      ((GmsLogger)localObject3).e("LibraryVersion", (String)localObject2, localIOException);
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      zzel.d("LibraryVersion", ".properties file is dropped during release process. Failure to read app version isexpected druing Google internal testing where locally-built libraries are used");
      localObject2 = "UNKNOWN";
    }
    this.zzen.put(paramString, localObject2);
    return (String)localObject2;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\internal\LibraryVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */