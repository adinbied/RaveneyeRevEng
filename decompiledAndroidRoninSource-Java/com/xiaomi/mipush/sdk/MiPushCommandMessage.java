package com.xiaomi.mipush.sdk;

import android.os.Bundle;
import java.util.List;

public class MiPushCommandMessage
  implements PushMessageHandler.a
{
  private static final String KEY_CATEGORY = "category";
  private static final String KEY_COMMAND = "command";
  private static final String KEY_COMMAND_ARGUMENTS = "commandArguments";
  private static final String KEY_REASON = "reason";
  private static final String KEY_RESULT_CODE = "resultCode";
  private static final long serialVersionUID = 1L;
  private String category;
  private String command;
  private List<String> commandArguments;
  private String reason;
  private long resultCode;
  
  public static MiPushCommandMessage fromBundle(Bundle paramBundle)
  {
    MiPushCommandMessage localMiPushCommandMessage = new MiPushCommandMessage();
    localMiPushCommandMessage.command = paramBundle.getString("command");
    localMiPushCommandMessage.resultCode = paramBundle.getLong("resultCode");
    localMiPushCommandMessage.reason = paramBundle.getString("reason");
    localMiPushCommandMessage.commandArguments = paramBundle.getStringArrayList("commandArguments");
    localMiPushCommandMessage.category = paramBundle.getString("category");
    return localMiPushCommandMessage;
  }
  
  public String getCategory()
  {
    return this.category;
  }
  
  public String getCommand()
  {
    return this.command;
  }
  
  public List<String> getCommandArguments()
  {
    return this.commandArguments;
  }
  
  public String getReason()
  {
    return this.reason;
  }
  
  public long getResultCode()
  {
    return this.resultCode;
  }
  
  public void setCategory(String paramString)
  {
    this.category = paramString;
  }
  
  public void setCommand(String paramString)
  {
    this.command = paramString;
  }
  
  public void setCommandArguments(List<String> paramList)
  {
    this.commandArguments = paramList;
  }
  
  public void setReason(String paramString)
  {
    this.reason = paramString;
  }
  
  public void setResultCode(long paramLong)
  {
    this.resultCode = paramLong;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\mipush\sdk\MiPushCommandMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */