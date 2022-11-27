package com.google.android.datatransport.cct;

import com.google.android.datatransport.runtime.backends.BackendFactory;
import com.google.android.datatransport.runtime.backends.CreationContext;
import com.google.android.datatransport.runtime.backends.TransportBackend;

public class CctBackendFactory
  implements BackendFactory
{
  public TransportBackend create(CreationContext paramCreationContext)
  {
    return new zzc(paramCreationContext.getApplicationContext(), paramCreationContext.getWallClock(), paramCreationContext.getMonotonicClock());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\cct\CctBackendFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */