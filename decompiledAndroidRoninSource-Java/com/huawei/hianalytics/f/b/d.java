package com.huawei.hianalytics.f.b;

public class d
{
  private String a;
  
  public String a()
  {
    return this.a;
  }
  
  /* Error */
  public void a(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void a(org.json.JSONObject arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\f\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */