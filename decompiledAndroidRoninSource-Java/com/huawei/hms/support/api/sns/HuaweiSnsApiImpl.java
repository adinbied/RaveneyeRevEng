package com.huawei.hms.support.api.sns;

import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.entity.sns.SnsMsg;
import com.huawei.hms.support.api.entity.sns.internal.AddFriendReq;
import com.huawei.hms.support.api.entity.sns.internal.AddFriendResp;
import com.huawei.hms.support.api.entity.sns.internal.FriendSelectorIntentReq;
import com.huawei.hms.support.api.entity.sns.internal.GetContactSelectorIntentReq;
import com.huawei.hms.support.api.entity.sns.internal.GetFriendListResp;
import com.huawei.hms.support.api.entity.sns.internal.GetGroupListResp;
import com.huawei.hms.support.api.entity.sns.internal.GetGroupMemListResp;
import com.huawei.hms.support.api.entity.sns.internal.GetIMStatusResp;
import com.huawei.hms.support.api.entity.sns.internal.GetUnreadMsgResp;
import com.huawei.hms.support.api.entity.sns.internal.GetUserUnreadMsgResp;
import com.huawei.hms.support.api.entity.sns.internal.GroupListReq;
import com.huawei.hms.support.api.entity.sns.internal.GroupMemListReq;
import com.huawei.hms.support.api.entity.sns.internal.GroupSelectorIntentReq;
import com.huawei.hms.support.api.entity.sns.internal.SNSIntentResp;
import com.huawei.hms.support.api.entity.sns.internal.SNSVoidEntity;
import com.huawei.hms.support.api.entity.sns.internal.SnsSendMsgIntentReq;
import com.huawei.hms.support.api.entity.sns.internal.UiIntentReq;
import com.huawei.hms.support.api.entity.sns.internal.UserDataReq;
import com.huawei.hms.support.api.entity.sns.internal.UserDataResp;
import com.huawei.hms.support.api.entity.sns.internal.UserSearchReq;
import com.huawei.hms.support.api.entity.sns.internal.UserSearchResp;
import com.huawei.hms.support.api.entity.sns.internal.UserUnreadMsgReq;

public class HuaweiSnsApiImpl
  implements HuaweiSnsApi
{
  private static com.huawei.hms.support.api.c<FriendListResult, GetFriendListResp> a(HuaweiApiClient paramHuaweiApiClient)
  {
    return new a(paramHuaweiApiClient, "sns.getfriendlist", new SNSVoidEntity());
  }
  
  private static com.huawei.hms.support.api.c<AddFriendResult, AddFriendResp> a(HuaweiApiClient paramHuaweiApiClient, AddFriendReq paramAddFriendReq)
  {
    return new e(paramHuaweiApiClient, "sns.addfriend", paramAddFriendReq);
  }
  
  private static com.huawei.hms.support.api.c<IntentResult, SNSIntentResp> a(HuaweiApiClient paramHuaweiApiClient, FriendSelectorIntentReq paramFriendSelectorIntentReq)
  {
    return new m(paramHuaweiApiClient, "sns.getfriendselectorintent", paramFriendSelectorIntentReq);
  }
  
  private static com.huawei.hms.support.api.c<IntentResult, SNSIntentResp> a(HuaweiApiClient paramHuaweiApiClient, GetContactSelectorIntentReq paramGetContactSelectorIntentReq)
  {
    return new o(paramHuaweiApiClient, "sns.getcontactselectorintent", paramGetContactSelectorIntentReq);
  }
  
  private static com.huawei.hms.support.api.c<GroupListResult, GetGroupListResp> a(HuaweiApiClient paramHuaweiApiClient, GroupListReq paramGroupListReq)
  {
    return new h(paramHuaweiApiClient, "sns.getgrouplist", paramGroupListReq);
  }
  
  private static com.huawei.hms.support.api.c<GroupMemListResult, GetGroupMemListResp> a(HuaweiApiClient paramHuaweiApiClient, GroupMemListReq paramGroupMemListReq)
  {
    return new i(paramHuaweiApiClient, "sns.getgroupmemlist", paramGroupMemListReq);
  }
  
  private static com.huawei.hms.support.api.c<IntentResult, SNSIntentResp> a(HuaweiApiClient paramHuaweiApiClient, GroupSelectorIntentReq paramGroupSelectorIntentReq)
  {
    return new n(paramHuaweiApiClient, "sns.getgroupselectorintent", paramGroupSelectorIntentReq);
  }
  
  private static com.huawei.hms.support.api.c<UnreadMsgCountResult, GetUnreadMsgResp> a(HuaweiApiClient paramHuaweiApiClient, SNSVoidEntity paramSNSVoidEntity)
  {
    return new k(paramHuaweiApiClient, "sns.getunreadmsgcount", paramSNSVoidEntity);
  }
  
  private static com.huawei.hms.support.api.c<IntentResult, SNSIntentResp> a(HuaweiApiClient paramHuaweiApiClient, SnsSendMsgIntentReq paramSnsSendMsgIntentReq)
  {
    return new d(paramHuaweiApiClient, "sns.getmsgsendintent", paramSnsSendMsgIntentReq);
  }
  
  private static com.huawei.hms.support.api.c<IntentResult, SNSIntentResp> a(HuaweiApiClient paramHuaweiApiClient, UiIntentReq paramUiIntentReq)
  {
    return new c(paramHuaweiApiClient, "sns.getuiintent", paramUiIntentReq);
  }
  
  private static com.huawei.hms.support.api.c<UserDataResult, UserDataResp> a(HuaweiApiClient paramHuaweiApiClient, UserDataReq paramUserDataReq)
  {
    return new j(paramHuaweiApiClient, "sns.getuserdata", paramUserDataReq);
  }
  
  private static com.huawei.hms.support.api.c<UserSearchResult, UserSearchResp> a(HuaweiApiClient paramHuaweiApiClient, UserSearchReq paramUserSearchReq)
  {
    return new f(paramHuaweiApiClient, "sns.searchuser", paramUserSearchReq);
  }
  
  private static com.huawei.hms.support.api.c<UserUnreadMsgCountResult, GetUserUnreadMsgResp> a(HuaweiApiClient paramHuaweiApiClient, UserUnreadMsgReq paramUserUnreadMsgReq)
  {
    return new l(paramHuaweiApiClient, "sns.getusercount", paramUserUnreadMsgReq);
  }
  
  private static com.huawei.hms.support.api.c<IMStatusResult, GetIMStatusResp> b(HuaweiApiClient paramHuaweiApiClient)
  {
    return new g(paramHuaweiApiClient, "sns.getimstatus", new SNSVoidEntity());
  }
  
  private static com.huawei.hms.support.api.c<IntentResult, SNSIntentResp> b(HuaweiApiClient paramHuaweiApiClient, SNSVoidEntity paramSNSVoidEntity)
  {
    return new b(paramHuaweiApiClient, "sns.getgroupcreatorintent", paramSNSVoidEntity);
  }
  
  public PendingResult<AddFriendResult> addFriend(HuaweiApiClient paramHuaweiApiClient, long paramLong, String paramString)
  {
    return null;
  }
  
  public PendingResult<IntentResult> getContactSelectorIntent(HuaweiApiClient paramHuaweiApiClient, boolean paramBoolean)
  {
    return null;
  }
  
  public PendingResult<FriendListResult> getFriendList(HuaweiApiClient paramHuaweiApiClient)
  {
    return null;
  }
  
  public PendingResult<IntentResult> getFriendSelectorIntent(HuaweiApiClient paramHuaweiApiClient, boolean paramBoolean)
  {
    return null;
  }
  
  public PendingResult<IntentResult> getGroupCreatorIntent(HuaweiApiClient paramHuaweiApiClient)
  {
    return null;
  }
  
  public PendingResult<GroupListResult> getGroupList(HuaweiApiClient paramHuaweiApiClient, int paramInt)
  {
    return null;
  }
  
  public PendingResult<GroupMemListResult> getGroupMemList(HuaweiApiClient paramHuaweiApiClient, long paramLong)
  {
    return null;
  }
  
  public PendingResult<IntentResult> getGroupSelectorIntent(HuaweiApiClient paramHuaweiApiClient, int paramInt)
  {
    return null;
  }
  
  public PendingResult<IMStatusResult> getIMStatus(HuaweiApiClient paramHuaweiApiClient)
  {
    return null;
  }
  
  public PendingResult<IntentResult> getMsgSendIntent(HuaweiApiClient paramHuaweiApiClient, SnsMsg paramSnsMsg, int paramInt, boolean paramBoolean)
  {
    return null;
  }
  
  public PendingResult<IntentResult> getMsgSendIntent(HuaweiApiClient paramHuaweiApiClient, SnsMsg paramSnsMsg, boolean paramBoolean)
  {
    return null;
  }
  
  public PendingResult<IntentResult> getUiIntent(HuaweiApiClient paramHuaweiApiClient, int paramInt, long paramLong)
  {
    return null;
  }
  
  public PendingResult<UnreadMsgCountResult> getUnreadMsgCount(HuaweiApiClient paramHuaweiApiClient)
  {
    return null;
  }
  
  public PendingResult<UserUnreadMsgCountResult> getUserCount(HuaweiApiClient paramHuaweiApiClient, long paramLong)
  {
    return null;
  }
  
  public PendingResult<UserDataResult> getUserData(HuaweiApiClient paramHuaweiApiClient, long paramLong)
  {
    return null;
  }
  
  public PendingResult<UserSearchResult> searchUser(HuaweiApiClient paramHuaweiApiClient, String paramString)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\sns\HuaweiSnsApiImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */