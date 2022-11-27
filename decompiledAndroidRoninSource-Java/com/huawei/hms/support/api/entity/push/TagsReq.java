package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;

public class TagsReq
  implements IMessageEntity
{
  @a
  private String apkVersion;
  @a
  private String content = "";
  @a
  private long cycle = 0L;
  @a
  private int operType;
  @a
  private String pkgName;
  @a
  private int plusType;
  @a
  private String token;
  
  public String getApkVersion()
  {
    return this.apkVersion;
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public long getCycle()
  {
    return this.cycle;
  }
  
  public int getOperType()
  {
    return this.operType;
  }
  
  public String getPkgName()
  {
    return this.pkgName;
  }
  
  public int getPlusType()
  {
    return this.plusType;
  }
  
  public String getToken()
  {
    return this.token;
  }
  
  public void setApkVersion(String paramString)
  {
    this.apkVersion = paramString;
  }
  
  public void setContent(String paramString)
  {
    this.content = paramString;
  }
  
  public void setCycle(long paramLong)
  {
    this.cycle = paramLong;
  }
  
  public void setOperType(int paramInt)
  {
    this.operType = paramInt;
  }
  
  public void setPkgName(String paramString)
  {
    this.pkgName = paramString;
  }
  
  public void setPlusType(int paramInt)
  {
    this.plusType = paramInt;
  }
  
  public void setToken(String paramString)
  {
    this.token = paramString;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\push\TagsReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */