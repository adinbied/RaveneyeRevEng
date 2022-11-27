package com.xiaomi.push;

import android.net.TrafficStats;
import android.os.Process;
import com.xiaomi.push.service.XMPushService;

public class hf
  implements fx
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  fu jdField_a_of_type_ComXiaomiPushFu;
  XMPushService jdField_a_of_type_ComXiaomiPushServiceXMPushService;
  private Exception jdField_a_of_type_JavaLangException;
  private String jdField_a_of_type_JavaLangString;
  private long b = 0L;
  private long c = 0L;
  private long d = 0L;
  private long e = 0L;
  private long f = 0L;
  
  hf(XMPushService paramXMPushService)
  {
    this.jdField_a_of_type_ComXiaomiPushServiceXMPushService = paramXMPushService;
    this.jdField_a_of_type_JavaLangString = "";
    b();
    int i = Process.myUid();
    this.f = TrafficStats.getUidRxBytes(i);
    this.e = TrafficStats.getUidTxBytes(i);
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  Exception a()
  {
    return this.jdField_a_of_type_JavaLangException;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void a(fu arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void a(fu arg1, int arg2, Exception arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\hf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */