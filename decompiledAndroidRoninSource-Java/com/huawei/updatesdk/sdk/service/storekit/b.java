package com.huawei.updatesdk.sdk.service.storekit;

import android.os.AsyncTask;
import com.huawei.updatesdk.sdk.service.storekit.bean.RequestBean;
import com.huawei.updatesdk.sdk.service.storekit.bean.ResponseBean;
import com.huawei.updatesdk.sdk.service.storekit.bean.ResponseBean.a;

public class b
  extends AsyncTask<RequestBean, Void, ResponseBean>
{
  protected RequestBean a = null;
  protected ResponseBean b = null;
  protected com.huawei.updatesdk.sdk.service.storekit.bean.a c = null;
  protected a d;
  protected com.huawei.updatesdk.sdk.a.b.a e = null;
  protected int f = 0;
  
  public b(RequestBean paramRequestBean, com.huawei.updatesdk.sdk.service.storekit.bean.a parama)
  {
    this.a = paramRequestBean;
    this.c = parama;
  }
  
  private ResponseBean a(String paramString1, String paramString2, ResponseBean paramResponseBean)
  {
    return null;
  }
  
  private void a(ResponseBean paramResponseBean, int paramInt, ResponseBean.a parama, Throwable paramThrowable)
  {
    if (paramResponseBean != null)
    {
      paramResponseBean.setResponseCode(paramInt);
      paramResponseBean.setErrCause(parama);
      paramResponseBean.setReason(paramThrowable.toString());
    }
  }
  
  /* Error */
  private void a(String arg1, String arg2, String arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void a(String arg1, Throwable arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean e(ResponseBean paramResponseBean)
  {
    return false;
  }
  
  public final ResponseBean a()
  {
    return null;
  }
  
  protected ResponseBean a(RequestBean... paramVarArgs)
  {
    return null;
  }
  
  /* Error */
  public final void a(java.util.concurrent.Executor arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected boolean a(ResponseBean paramResponseBean)
  {
    return false;
  }
  
  protected ResponseBean b()
  {
    return null;
  }
  
  public void b(ResponseBean paramResponseBean) {}
  
  public void c()
  {
    c(this.b);
  }
  
  /* Error */
  protected void c(ResponseBean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  protected String d()
  {
    return "Android/1.0";
  }
  
  /* Error */
  protected void d(ResponseBean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onCancelled()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static abstract interface a
  {
    public abstract void a(b paramb);
    
    public abstract void b(b paramb);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\sdk\service\storekit\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */