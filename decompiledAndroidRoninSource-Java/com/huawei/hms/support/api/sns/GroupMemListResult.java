package com.huawei.hms.support.api.sns;

import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.entity.sns.GroupMem;
import java.util.List;

public class GroupMemListResult
  extends Result
{
  private List<GroupMem> a;
  
  public List<GroupMem> getGroupMems()
  {
    return this.a;
  }
  
  public void setGroupMems(List<GroupMem> paramList)
  {
    this.a = paramList;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\sns\GroupMemListResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */