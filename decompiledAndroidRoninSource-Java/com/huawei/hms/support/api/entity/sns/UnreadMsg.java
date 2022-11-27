package com.huawei.hms.support.api.entity.sns;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class UnreadMsg
  implements IMessageEntity
{
  @a
  private int familyInvitation;
  @a
  private int friendInvitation;
  @a
  private int friendMsg;
  @a
  private int groupMsg;
  
  public int getFamilyInvitation()
  {
    return this.familyInvitation;
  }
  
  public int getFriendInvitation()
  {
    return this.friendInvitation;
  }
  
  public int getFriendMsg()
  {
    return this.friendMsg;
  }
  
  public int getGroupMsg()
  {
    return this.groupMsg;
  }
  
  public void setFamilyInvitation(int paramInt)
  {
    this.familyInvitation = paramInt;
  }
  
  public void setFriendInvitation(int paramInt)
  {
    this.friendInvitation = paramInt;
  }
  
  public void setFriendMsg(int paramInt)
  {
    this.friendMsg = paramInt;
  }
  
  public void setGroupMsg(int paramInt)
  {
    this.groupMsg = paramInt;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\sns\UnreadMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */