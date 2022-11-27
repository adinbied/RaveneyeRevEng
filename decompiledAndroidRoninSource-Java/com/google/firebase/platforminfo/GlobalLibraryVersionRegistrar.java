package com.google.firebase.platforminfo;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class GlobalLibraryVersionRegistrar
{
  private static volatile GlobalLibraryVersionRegistrar INSTANCE;
  private final Set<LibraryVersion> infos = new HashSet();
  
  public static GlobalLibraryVersionRegistrar getInstance()
  {
    Object localObject = INSTANCE;
    if (localObject == null) {
      try
      {
        GlobalLibraryVersionRegistrar localGlobalLibraryVersionRegistrar2 = INSTANCE;
        localObject = localGlobalLibraryVersionRegistrar2;
        if (localGlobalLibraryVersionRegistrar2 == null)
        {
          localObject = new GlobalLibraryVersionRegistrar();
          INSTANCE = (GlobalLibraryVersionRegistrar)localObject;
        }
        return (GlobalLibraryVersionRegistrar)localObject;
      }
      finally {}
    }
    return localGlobalLibraryVersionRegistrar1;
  }
  
  Set<LibraryVersion> getRegisteredVersions()
  {
    synchronized (this.infos)
    {
      Set localSet2 = Collections.unmodifiableSet(this.infos);
      return localSet2;
    }
  }
  
  public void registerVersion(String paramString1, String paramString2)
  {
    synchronized (this.infos)
    {
      this.infos.add(LibraryVersion.create(paramString1, paramString2));
      return;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\platforminfo\GlobalLibraryVersionRegistrar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */