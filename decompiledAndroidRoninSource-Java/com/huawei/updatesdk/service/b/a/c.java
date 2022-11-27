package com.huawei.updatesdk.service.b.a;

import com.huawei.updatesdk.framework.bean.StoreRequestBean;
import com.huawei.updatesdk.framework.bean.startup.StartupRequest;
import com.huawei.updatesdk.framework.bean.startup.StartupResponse;
import com.huawei.updatesdk.sdk.service.storekit.b;
import com.huawei.updatesdk.sdk.service.storekit.bean.RequestBean;
import com.huawei.updatesdk.sdk.service.storekit.bean.ResponseBean;
import com.huawei.updatesdk.sdk.service.storekit.bean.a;
import com.huawei.updatesdk.service.a.a.a;

public class c
  extends b
{
  private int g = 0;
  
  public c(RequestBean paramRequestBean, a parama)
  {
    super(paramRequestBean, parama);
  }
  
  /* Error */
  private void e()
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
  
  /* Error */
  public void b(ResponseBean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected String d()
  {
    return null;
  }
  
  private static class a
  {
    public static boolean a()
    {
      Object localObject = StartupRequest.newInstance();
      c localc = new c((RequestBean)localObject, null);
      ((StartupRequest)localObject).setUrl(a.a.b());
      localObject = c.a(localc);
      if (((localObject instanceof StartupResponse)) && (((ResponseBean)localObject).getRtnCode_() == 0))
      {
        ((StartupResponse)localObject).saveParams();
        return true;
      }
      return false;
    }
    
    public static boolean a(RequestBean paramRequestBean, ResponseBean paramResponseBean)
    {
      return ((paramRequestBean instanceof StoreRequestBean)) && ((paramResponseBean.getRtnCode_() != 0) || (paramResponseBean.getResponseCode() != 0));
    }
    
    private static boolean b(int paramInt)
    {
      return (paramInt == 1022) || (paramInt == 1021) || (paramInt == 1012) || (paramInt == 1011);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\service\b\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */