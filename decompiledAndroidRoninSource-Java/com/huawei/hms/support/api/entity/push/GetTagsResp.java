package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;
import java.util.Map;

public class GetTagsResp
  implements IMessageEntity
{
  @a
  private Map<String, String> tags = null;
  
  public Map<String, String> getTags()
  {
    return this.tags;
  }
  
  public void setTags(Map<String, String> paramMap)
  {
    this.tags = paramMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\push\GetTagsResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */