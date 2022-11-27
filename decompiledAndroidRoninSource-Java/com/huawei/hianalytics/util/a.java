package com.huawei.hianalytics.util;

public class a
{
  private byte[] a = null;
  private int b = 1024;
  private int c = 0;
  
  public a()
  {
    this.a = new byte['Ѐ'];
  }
  
  public a(int paramInt)
  {
    this.b = paramInt;
    this.a = new byte[paramInt];
  }
  
  public int a()
  {
    return this.c;
  }
  
  /* Error */
  public void a(byte[] arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public byte[] b()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytic\\util\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */