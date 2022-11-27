package com.huawei.hms.support.api.entity.sns.internal;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;
import com.huawei.hms.support.api.entity.sns.Friend;
import java.util.List;

public class GetFriendListResp
  implements IMessageEntity
{
  @a
  private List<Friend> friends;
  
  public List<Friend> getFriends()
  {
    return this.friends;
  }
  
  public void setFriends(List<Friend> paramList)
  {
    this.friends = paramList;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\sns\internal\GetFriendListResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */