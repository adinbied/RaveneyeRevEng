package com.huawei.updatesdk.service.deamon.download;

import com.huawei.updatesdk.sdk.service.download.b.a;
import com.huawei.updatesdk.sdk.service.download.bean.DownloadTask;

public class b
  extends com.huawei.updatesdk.sdk.service.download.b
{
  public static final String a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(com.huawei.updatesdk.support.a.a.a());
    localStringBuilder.append(".DownloadDiskSpacePolicy");
    a = localStringBuilder.toString();
  }
  
  public b.a a(DownloadTask paramDownloadTask)
  {
    return null;
  }
  
  public void a(DownloadTask paramDownloadTask, b.a parama)
  {
    com.huawei.updatesdk.sdk.a.c.a.a.a.d("DownloadDiskSpacePolicy", "onSpaceNotEnough");
  }
  
  public void a(DownloadTask paramDownloadTask, String paramString)
  {
    com.huawei.updatesdk.sdk.a.c.a.a.a.d("DownloadDiskSpacePolicy", "onWriteEnd");
  }
  
  protected boolean a(long paramLong1, long paramLong2)
  {
    return false;
  }
  
  public boolean a(DownloadTask paramDownloadTask, b.a parama, long paramLong, boolean paramBoolean)
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\service\deamon\download\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */