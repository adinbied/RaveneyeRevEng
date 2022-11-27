package com.huawei.hms.api;

import java.util.List;

public class ProtocolNegotiate
{
  private static ProtocolNegotiate b = new ProtocolNegotiate();
  private int a = 1;
  
  public static ProtocolNegotiate getInstance()
  {
    return b;
  }
  
  public int getVersion()
  {
    return this.a;
  }
  
  public int negotiate(List<Integer> paramList)
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\api\ProtocolNegotiate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */