package com.huawei.hms.support.api.sns;

import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.entity.sns.Friend;
import java.util.List;

public class FriendListResult
  extends Result
{
  private List<Friend> a;
  
  public List<Friend> getFriends()
  {
    return this.a;
  }
  
  public void setFriends(List<Friend> paramList)
  {
    this.a = paramList;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\sns\FriendListResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */