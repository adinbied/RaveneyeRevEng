package com.huawei.hms.support.api.push;

import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.entity.push.GetTagsResp;
import java.util.Map;

public class GetTagResult
  extends Result
{
  protected GetTagsResp resp = null;
  
  public Map<String, String> getTags()
  {
    return null;
  }
  
  public GetTagsResp getTagsRes()
  {
    return this.resp;
  }
  
  public void setTagsRes(GetTagsResp paramGetTagsResp)
  {
    this.resp = paramGetTagsResp;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\push\GetTagResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */