package com.xiaomi.push;

import android.os.SystemClock;
import com.xiaomi.push.service.XMPushService;
import java.net.Socket;

public abstract class gb
  extends fu
{
  protected Exception a;
  protected Socket a;
  protected XMPushService b;
  private int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString;
  private String d;
  protected volatile long e = 0L;
  protected volatile long f = 0L;
  protected volatile long g = 0L;
  
  public gb(XMPushService paramXMPushService, fv paramfv)
  {
    super(paramXMPushService, paramfv);
    this.jdField_a_of_type_JavaLangException = null;
    this.c = null;
    this.b = paramXMPushService;
  }
  
  /* Error */
  private void a(fv arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void a(String arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  cx a(String paramString)
  {
    return null;
  }
  
  public String a()
  {
    return this.d;
  }
  
  public Socket a()
  {
    return new Socket();
  }
  
  protected void a() {}
  
  /* Error */
  protected void a(int arg1, Exception arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  /* Error */
  protected void a(Exception arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void a(String arg1, long arg2, Exception arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected abstract void a(boolean paramBoolean);
  
  public void a(fn[] paramArrayOffn)
  {
    throw new gf("Don't support send Blob");
  }
  
  /* Error */
  public void b(int arg1, Exception arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void b(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public String c()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  /* Error */
  public void c(int arg1, Exception arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void e()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void f()
  {
    this.e = SystemClock.elapsedRealtime();
  }
  
  public void g()
  {
    this.f = SystemClock.elapsedRealtime();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\gb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */