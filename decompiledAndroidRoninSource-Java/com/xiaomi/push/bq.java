package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.b;
import java.text.SimpleDateFormat;
import java.util.Date;

class bq
  implements fx
{
  bq(bp parambp) {}
  
  /* Error */
  public void a(fu arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void a(fu paramfu, int paramInt, Exception paramException)
  {
    paramfu = new StringBuilder();
    paramfu.append("[Slim] ");
    paramfu.append(bp.a(this.a).format(new Date()));
    paramfu.append(" Connection closed (");
    paramfu.append(bp.a(this.a).hashCode());
    paramfu.append(")");
    b.c(paramfu.toString());
  }
  
  /* Error */
  public void a(fu arg1, Exception arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void b(fu arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */