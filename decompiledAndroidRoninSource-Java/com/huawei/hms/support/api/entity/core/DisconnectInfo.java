package com.huawei.hms.support.api.entity.core;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.List;

public class DisconnectInfo
  implements IMessageEntity
{
  @a
  public List<String> apiNameList;
  @a
  public List<Scope> scopeList;
  
  public DisconnectInfo() {}
  
  public DisconnectInfo(List<Scope> paramList, List<String> paramList1)
  {
    this.scopeList = paramList;
    this.apiNameList = paramList1;
  }
  
  public List<String> getApiNameList()
  {
    return this.apiNameList;
  }
  
  public List<Scope> getScopeList()
  {
    return this.scopeList;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\core\DisconnectInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */