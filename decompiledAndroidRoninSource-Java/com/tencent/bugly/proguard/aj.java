package com.tencent.bugly.proguard;

public final class aj
  extends k
  implements Cloneable
{
  private static byte[] d;
  private byte a = 0;
  private String b = "";
  private byte[] c = null;
  
  public aj() {}
  
  public aj(byte paramByte, String paramString, byte[] paramArrayOfByte)
  {
    this.a = paramByte;
    this.b = paramString;
    this.c = paramArrayOfByte;
  }
  
  public final void a(i parami)
  {
    this.a = parami.a(this.a, 0, true);
    this.b = parami.b(1, true);
    if (d == null)
    {
      byte[] arrayOfByte = (byte[])new byte[1];
      d = arrayOfByte;
      ((byte[])arrayOfByte)[0] = 0;
    }
    this.c = ((byte[])parami.c(2, false));
  }
  
  public final void a(j paramj)
  {
    paramj.a(this.a, 0);
    paramj.a(this.b, 1);
    byte[] arrayOfByte = this.c;
    if (arrayOfByte != null) {
      paramj.a(arrayOfByte, 2);
    }
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\proguard\aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */