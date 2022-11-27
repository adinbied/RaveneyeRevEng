package com.huawei.hms.support.api.entity.core;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.List;

public class ConnectInfo
  implements IMessageEntity
{
  @a
  private List<String> apiNameList;
  @a
  private String fingerprint;
  @a
  private List<Scope> scopeList;
  @a
  private String subAppID;
  
  public ConnectInfo() {}
  
  public ConnectInfo(List<String> paramList, List<Scope> paramList1, String paramString1, String paramString2)
  {
    this.apiNameList = paramList;
    this.scopeList = paramList1;
    this.fingerprint = paramString1;
    this.subAppID = paramString2;
  }
  
  public List<String> getApiNameList()
  {
    return this.apiNameList;
  }
  
  public String getFingerprint()
  {
    return this.fingerprint;
  }
  
  public List<Scope> getScopeList()
  {
    return this.scopeList;
  }
  
  public String getSubAppID()
  {
    return this.subAppID;
  }
  
  public void setApiNameList(List<String> paramList)
  {
    this.apiNameList = paramList;
  }
  
  public void setFingerprint(String paramString)
  {
    this.fingerprint = paramString;
  }
  
  public void setScopeList(List<Scope> paramList)
  {
    this.scopeList = paramList;
  }
  
  public void setSubAppID(String paramString)
  {
    this.subAppID = paramString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\core\ConnectInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */