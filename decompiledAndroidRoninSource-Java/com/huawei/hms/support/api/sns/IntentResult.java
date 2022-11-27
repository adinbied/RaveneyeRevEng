package com.huawei.hms.support.api.sns;

import android.content.Intent;
import com.huawei.hms.support.api.client.Result;

public class IntentResult
  extends Result
{
  private Intent a;
  
  public Intent getIntent()
  {
    return this.a;
  }
  
  public void setIntent(Intent paramIntent)
  {
    this.a = paramIntent;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\sns\IntentResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */