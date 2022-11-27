package com.huawei.hms.api;

import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.Collections;
import java.util.List;

public class Api<O extends ApiOptions>
{
  private final String a;
  private final Options<O> b;
  
  public Api(String paramString)
  {
    this.a = paramString;
    this.b = null;
  }
  
  public Api(String paramString, Options<O> paramOptions)
  {
    this.a = paramString;
    this.b = paramOptions;
  }
  
  public String getApiName()
  {
    return this.a;
  }
  
  public Options<O> getOptions()
  {
    return this.b;
  }
  
  public static abstract interface ApiOptions
  {
    public static abstract interface HasOptions
      extends Api.ApiOptions
    {}
    
    public static final class NoOptions
      implements Api.ApiOptions.NotRequiredOptions
    {}
    
    public static abstract interface NotRequiredOptions
      extends Api.ApiOptions
    {}
    
    public static abstract interface Optional
      extends Api.ApiOptions.HasOptions, Api.ApiOptions.NotRequiredOptions
    {}
  }
  
  public static abstract class Options<O>
  {
    public List<PermissionInfo> getPermissionInfoList(O paramO)
    {
      return Collections.emptyList();
    }
    
    public List<Scope> getScopeList(O paramO)
    {
      return Collections.emptyList();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\api\Api.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */