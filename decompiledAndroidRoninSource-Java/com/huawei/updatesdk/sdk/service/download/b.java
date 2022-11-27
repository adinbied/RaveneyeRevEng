package com.huawei.updatesdk.sdk.service.download;

import com.huawei.updatesdk.sdk.service.download.bean.DownloadTask;

public abstract class b
{
  public abstract a a(DownloadTask paramDownloadTask);
  
  public void a(DownloadTask paramDownloadTask, a parama) {}
  
  public void a(DownloadTask paramDownloadTask, String paramString) {}
  
  public static class a
  {
    private boolean a;
    private long b;
    private long c;
    private String d;
    
    public void a(long paramLong)
    {
      this.b = paramLong;
    }
    
    public void a(String paramString)
    {
      this.d = paramString;
    }
    
    public void a(boolean paramBoolean)
    {
      this.a = paramBoolean;
    }
    
    public boolean a()
    {
      return this.a;
    }
    
    public long b()
    {
      return this.b;
    }
    
    public String c()
    {
      return this.d;
    }
    
    public String toString()
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\sdk\service\download\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */