package com.huawei.hms.support.api.push;

import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.entity.push.TagsResp;

public class HandleTagsResult
  extends Result
{
  protected TagsResp resp;
  
  public TagsResp getTagsRes()
  {
    return this.resp;
  }
  
  public void setTagsRes(TagsResp paramTagsResp)
  {
    this.resp = paramTagsResp;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\push\HandleTagsResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */