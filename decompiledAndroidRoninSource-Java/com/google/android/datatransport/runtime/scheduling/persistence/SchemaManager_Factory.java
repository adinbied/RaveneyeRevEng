package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class SchemaManager_Factory
  implements Factory<SchemaManager>
{
  private final Provider<Context> contextProvider;
  private final Provider<String> dbNameProvider;
  private final Provider<Integer> schemaVersionProvider;
  
  public SchemaManager_Factory(Provider<Context> paramProvider, Provider<String> paramProvider1, Provider<Integer> paramProvider2)
  {
    this.contextProvider = paramProvider;
    this.dbNameProvider = paramProvider1;
    this.schemaVersionProvider = paramProvider2;
  }
  
  public static SchemaManager_Factory create(Provider<Context> paramProvider, Provider<String> paramProvider1, Provider<Integer> paramProvider2)
  {
    return new SchemaManager_Factory(paramProvider, paramProvider1, paramProvider2);
  }
  
  public static SchemaManager newInstance(Context paramContext, String paramString, int paramInt)
  {
    return new SchemaManager(paramContext, paramString, paramInt);
  }
  
  public SchemaManager get()
  {
    return new SchemaManager((Context)this.contextProvider.get(), (String)this.dbNameProvider.get(), ((Integer)this.schemaVersionProvider.get()).intValue());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\scheduling\persistence\SchemaManager_Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */