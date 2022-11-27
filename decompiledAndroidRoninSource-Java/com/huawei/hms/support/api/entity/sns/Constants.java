package com.huawei.hms.support.api.entity.sns;

public final class Constants
{
  public static final class AddFriendResult
  {
    public static final int ADD_FRIEND_ALREAD_FRIEND = 5;
    public static final int ADD_FRIEND_LIMITED = 3;
    public static final int ADD_FRIEND_LIMITED_OTHER = 4;
    public static final int ADD_FRIEND_MUCH_REQ = 2;
    public static final int ADD_FRIEND_SUCCESS = 0;
    public static final int ADD_FRIEND_VERIFY = 1;
  }
  
  public static class GroupType
  {
    public static final int GROUP_ALL = 2;
    public static final int GROUP_COMMON = 1;
    public static final int GROUP_FAMILY = 0;
  }
  
  public static class Key
  {
    public static final String KEY_CALL_FRIEND = "hms_sns_call_friend";
    public static final String KEY_CALL_MSG = "hms_sns_call_msg";
    public static final String KEY_GROUP_ID = "hms_sns_group_id";
    public static final String KEY_IDS_LIST = "hms_sns_ids_list";
    public static final String KEY_USER_ID = "hms_sns_user_id";
  }
  
  public static final class MessageType
  {
    public static final int LINK = 1;
  }
  
  public static final class OnlineStatus
  {
    public static final int OFF_LINE = 0;
    public static final int ON_LINE = 1;
  }
  
  public static class UiIntentType
  {
    public static final int UI_CHAT_ASSIST = 7;
    public static final int UI_CHAT_FRIEND = 5;
    public static final int UI_CHAT_GROUP = 6;
    public static final int UI_COMMON_GROUP = 9;
    public static final int UI_COMMON_GROUP_DETAIL = 3;
    public static final int UI_FAMILY_GROUP = 8;
    public static final int UI_FAMILY_GROUP_DETAIL = 2;
    public static final int UI_FRIEND = 1;
    public static final int UI_MSG = 0;
    public static final int UI_USER_DETAIL = 4;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\sns\Constants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */