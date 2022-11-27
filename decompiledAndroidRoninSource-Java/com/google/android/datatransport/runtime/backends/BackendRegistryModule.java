package com.google.android.datatransport.runtime.backends;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class BackendRegistryModule
{
  @Binds
  abstract BackendRegistry backendRegistry(MetadataBackendRegistry paramMetadataBackendRegistry);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\backends\BackendRegistryModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */