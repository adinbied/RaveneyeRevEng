package com.huawei.hms.support.api.entity.auth;

import com.huawei.hms.core.aidl.IMessageEntity;

public class Scope
  implements IMessageEntity
{
  private final String mScopeUri;
  
  public Scope()
  {
    this.mScopeUri = null;
  }
  
  public Scope(String paramString)
  {
    this.mScopeUri = paramString;
  }
  
  public boolean equeals(Object paramObject)
  {
    return false;
  }
  
  public String getScopeUri()
  {
    return this.mScopeUri;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\auth\Scope.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */