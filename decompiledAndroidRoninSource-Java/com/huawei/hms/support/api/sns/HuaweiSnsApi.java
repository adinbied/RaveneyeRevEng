package com.huawei.hms.support.api.sns;

import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.entity.sns.SnsMsg;

public abstract interface HuaweiSnsApi
{
  public abstract PendingResult<AddFriendResult> addFriend(HuaweiApiClient paramHuaweiApiClient, long paramLong, String paramString);
  
  public abstract PendingResult<IntentResult> getContactSelectorIntent(HuaweiApiClient paramHuaweiApiClient, boolean paramBoolean);
  
  public abstract PendingResult<FriendListResult> getFriendList(HuaweiApiClient paramHuaweiApiClient);
  
  public abstract PendingResult<IntentResult> getFriendSelectorIntent(HuaweiApiClient paramHuaweiApiClient, boolean paramBoolean);
  
  public abstract PendingResult<IntentResult> getGroupCreatorIntent(HuaweiApiClient paramHuaweiApiClient);
  
  public abstract PendingResult<GroupListResult> getGroupList(HuaweiApiClient paramHuaweiApiClient, int paramInt);
  
  public abstract PendingResult<GroupMemListResult> getGroupMemList(HuaweiApiClient paramHuaweiApiClient, long paramLong);
  
  public abstract PendingResult<IntentResult> getGroupSelectorIntent(HuaweiApiClient paramHuaweiApiClient, int paramInt);
  
  public abstract PendingResult<IMStatusResult> getIMStatus(HuaweiApiClient paramHuaweiApiClient);
  
  public abstract PendingResult<IntentResult> getMsgSendIntent(HuaweiApiClient paramHuaweiApiClient, SnsMsg paramSnsMsg, int paramInt, boolean paramBoolean);
  
  public abstract PendingResult<IntentResult> getMsgSendIntent(HuaweiApiClient paramHuaweiApiClient, SnsMsg paramSnsMsg, boolean paramBoolean);
  
  public abstract PendingResult<IntentResult> getUiIntent(HuaweiApiClient paramHuaweiApiClient, int paramInt, long paramLong);
  
  public abstract PendingResult<UnreadMsgCountResult> getUnreadMsgCount(HuaweiApiClient paramHuaweiApiClient);
  
  public abstract PendingResult<UserUnreadMsgCountResult> getUserCount(HuaweiApiClient paramHuaweiApiClient, long paramLong);
  
  public abstract PendingResult<UserDataResult> getUserData(HuaweiApiClient paramHuaweiApiClient, long paramLong);
  
  public abstract PendingResult<UserSearchResult> searchUser(HuaweiApiClient paramHuaweiApiClient, String paramString);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\sns\HuaweiSnsApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */