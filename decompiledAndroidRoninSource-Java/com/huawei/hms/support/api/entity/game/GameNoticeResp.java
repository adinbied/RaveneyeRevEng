package com.huawei.hms.support.api.entity.game;

import android.content.Intent;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class GameNoticeResp
  implements IMessageEntity
{
  @a
  private Intent noticeIntent;
  @a
  public int retCode;
  
  public Intent getNoticeIntent()
  {
    return this.noticeIntent;
  }
  
  public void setNoticeIntent(Intent paramIntent)
  {
    this.noticeIntent = paramIntent;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\game\GameNoticeResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */