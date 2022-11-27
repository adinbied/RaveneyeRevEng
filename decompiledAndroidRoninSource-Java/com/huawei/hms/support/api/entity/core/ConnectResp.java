package com.huawei.hms.support.api.entity.core;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;
import java.util.Arrays;
import java.util.List;

public class ConnectResp
  implements IMessageEntity
{
  @a
  public List<Integer> protocolVersion = Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2) });
  @a
  public String sessionId;
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\core\ConnectResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */