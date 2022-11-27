package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.internal.Objects;

public final class zai<O extends Api.ApiOptions>
{
  private final Api<O> mApi;
  private final O zabh;
  private final boolean zacu;
  private final int zacv;
  
  private zai(Api<O> paramApi)
  {
    this.zacu = true;
    this.mApi = paramApi;
    this.zabh = null;
    this.zacv = System.identityHashCode(this);
  }
  
  private zai(Api<O> paramApi, O paramO)
  {
    this.zacu = false;
    this.mApi = paramApi;
    this.zabh = paramO;
    this.zacv = Objects.hashCode(new Object[] { paramApi, paramO });
  }
  
  public static <O extends Api.ApiOptions> zai<O> zaa(Api<O> paramApi)
  {
    return new zai(paramApi);
  }
  
  public static <O extends Api.ApiOptions> zai<O> zaa(Api<O> paramApi, O paramO)
  {
    return new zai(paramApi, paramO);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof zai)) {
      return false;
    }
    paramObject = (zai)paramObject;
    return (!this.zacu) && (!((zai)paramObject).zacu) && (Objects.equal(this.mApi, ((zai)paramObject).mApi)) && (Objects.equal(this.zabh, ((zai)paramObject).zabh));
  }
  
  public final int hashCode()
  {
    return this.zacv;
  }
  
  public final String zan()
  {
    return this.mApi.getName();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\zai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */