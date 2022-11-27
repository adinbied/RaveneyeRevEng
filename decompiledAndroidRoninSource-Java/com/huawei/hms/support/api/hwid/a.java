package com.huawei.hms.support.api.hwid;

import com.huawei.hms.api.Api.Options;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.List;

final class a
  extends Api.Options<HuaweiIdSignInOptions>
{
  public List<Scope> a(HuaweiIdSignInOptions paramHuaweiIdSignInOptions)
  {
    return paramHuaweiIdSignInOptions.getScopeList();
  }
  
  public List<PermissionInfo> b(HuaweiIdSignInOptions paramHuaweiIdSignInOptions)
  {
    return paramHuaweiIdSignInOptions.getPermissionInfos();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\hwid\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */