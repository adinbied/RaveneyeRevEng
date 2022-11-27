package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;

public class iy
{
  public static short a(Context paramContext, ik paramik)
  {
    int k = g.a(paramContext, paramik.b).a();
    int j = 0;
    int i;
    if (ah.b(paramContext)) {
      i = 4;
    } else {
      i = 0;
    }
    if (ah.a(paramContext)) {
      j = 8;
    }
    return (short)(k + 0 + i + j);
  }
  
  public static <T extends iz<T, ?>> void a(T paramT, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      new jd(new jq.a(true, true, paramArrayOfByte.length)).a(paramT, paramArrayOfByte);
      return;
    }
    throw new je("the message byte is empty.");
  }
  
  public static <T extends iz<T, ?>> byte[] a(T paramT)
  {
    if (paramT == null) {
      return null;
    }
    try
    {
      paramT = new jf(new jg.a()).a(paramT);
      return paramT;
    }
    catch (je paramT)
    {
      b.a("convertThriftObjectToBytes catch TException.", paramT);
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\iy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */