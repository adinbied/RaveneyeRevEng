package com.huawei.hms.support.api.entity.game;

import android.content.Intent;
import android.os.Bundle;

public class ProtocolIntentResult
{
  private int a;
  private int b;
  
  public ProtocolIntentResult(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public static ProtocolIntentResult build(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    return new ProtocolIntentResult(paramIntent.getIntExtra("key_code", -1), paramIntent.getIntExtra("intent.extra.protocol.type", 0));
  }
  
  public int getCode()
  {
    return this.a;
  }
  
  public int getProtocolType()
  {
    return this.b;
  }
  
  public Bundle toBundle()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\game\ProtocolIntentResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */