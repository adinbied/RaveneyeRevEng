package com.xiaomi.mipush.sdk;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;

public class MiPushMessage
  implements PushMessageHandler.a
{
  private static final String KEY_ALIAS = "alias";
  private static final String KEY_CATEGORY = "category";
  private static final String KEY_CONTENT = "content";
  private static final String KEY_DESC = "description";
  private static final String KEY_EXTRA = "extra";
  private static final String KEY_MESSAGE_ID = "messageId";
  private static final String KEY_MESSAGE_TYPE = "messageType";
  private static final String KEY_NOTIFIED = "isNotified";
  private static final String KEY_NOTIFY_ID = "notifyId";
  private static final String KEY_NOTIFY_TYPE = "notifyType";
  private static final String KEY_PASS_THROUGH = "passThrough";
  private static final String KEY_TITLE = "title";
  private static final String KEY_TOPIC = "topic";
  private static final String KEY_USER_ACCOUNT = "user_account";
  public static final int MESSAGE_TYPE_ACCOUNT = 3;
  public static final int MESSAGE_TYPE_ALIAS = 1;
  public static final int MESSAGE_TYPE_REG = 0;
  public static final int MESSAGE_TYPE_TOPIC = 2;
  private static final long serialVersionUID = 1L;
  private String alias;
  private boolean arrived = false;
  private String category;
  private String content;
  private String description;
  private HashMap<String, String> extra = new HashMap();
  private boolean isNotified;
  private String messageId;
  private int messageType;
  private int notifyId;
  private int notifyType;
  private int passThrough;
  private String title;
  private String topic;
  private String userAccount;
  
  public static MiPushMessage fromBundle(Bundle paramBundle)
  {
    MiPushMessage localMiPushMessage = new MiPushMessage();
    localMiPushMessage.messageId = paramBundle.getString("messageId");
    localMiPushMessage.messageType = paramBundle.getInt("messageType");
    localMiPushMessage.passThrough = paramBundle.getInt("passThrough");
    localMiPushMessage.alias = paramBundle.getString("alias");
    localMiPushMessage.userAccount = paramBundle.getString("user_account");
    localMiPushMessage.topic = paramBundle.getString("topic");
    localMiPushMessage.content = paramBundle.getString("content");
    localMiPushMessage.description = paramBundle.getString("description");
    localMiPushMessage.title = paramBundle.getString("title");
    localMiPushMessage.isNotified = paramBundle.getBoolean("isNotified");
    localMiPushMessage.notifyId = paramBundle.getInt("notifyId");
    localMiPushMessage.notifyType = paramBundle.getInt("notifyType");
    localMiPushMessage.category = paramBundle.getString("category");
    localMiPushMessage.extra = ((HashMap)paramBundle.getSerializable("extra"));
    return localMiPushMessage;
  }
  
  public String getAlias()
  {
    return this.alias;
  }
  
  public String getCategory()
  {
    return this.category;
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public Map<String, String> getExtra()
  {
    return this.extra;
  }
  
  public String getMessageId()
  {
    return this.messageId;
  }
  
  public int getMessageType()
  {
    return this.messageType;
  }
  
  public int getNotifyId()
  {
    return this.notifyId;
  }
  
  public int getNotifyType()
  {
    return this.notifyType;
  }
  
  public int getPassThrough()
  {
    return this.passThrough;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public String getTopic()
  {
    return this.topic;
  }
  
  public String getUserAccount()
  {
    return this.userAccount;
  }
  
  public boolean isArrivedMessage()
  {
    return this.arrived;
  }
  
  public boolean isNotified()
  {
    return this.isNotified;
  }
  
  public void setAlias(String paramString)
  {
    this.alias = paramString;
  }
  
  public void setArrivedMessage(boolean paramBoolean)
  {
    this.arrived = paramBoolean;
  }
  
  public void setCategory(String paramString)
  {
    this.category = paramString;
  }
  
  public void setContent(String paramString)
  {
    this.content = paramString;
  }
  
  public void setDescription(String paramString)
  {
    this.description = paramString;
  }
  
  /* Error */
  public void setExtra(Map<String, String> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setMessageId(String paramString)
  {
    this.messageId = paramString;
  }
  
  public void setMessageType(int paramInt)
  {
    this.messageType = paramInt;
  }
  
  public void setNotified(boolean paramBoolean)
  {
    this.isNotified = paramBoolean;
  }
  
  public void setNotifyId(int paramInt)
  {
    this.notifyId = paramInt;
  }
  
  public void setNotifyType(int paramInt)
  {
    this.notifyType = paramInt;
  }
  
  public void setPassThrough(int paramInt)
  {
    this.passThrough = paramInt;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setTopic(String paramString)
  {
    this.topic = paramString;
  }
  
  public void setUserAccount(String paramString)
  {
    this.userAccount = paramString;
  }
  
  public Bundle toBundle()
  {
    return null;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\mipush\sdk\MiPushMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */