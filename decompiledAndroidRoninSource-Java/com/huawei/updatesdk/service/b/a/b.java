package com.huawei.updatesdk.service.b.a;

import com.huawei.updatesdk.framework.bean.StoreRequestBean;
import com.huawei.updatesdk.sdk.service.storekit.bean.RequestBean;
import com.huawei.updatesdk.sdk.service.storekit.bean.ResponseBean;
import java.util.concurrent.ThreadPoolExecutor;

public class b
{
  public static ResponseBean a(RequestBean paramRequestBean)
  {
    return new c(paramRequestBean, null).a();
  }
  
  public static c a(StoreRequestBean paramStoreRequestBean, com.huawei.updatesdk.sdk.service.storekit.bean.a parama)
  {
    parama = new c(paramStoreRequestBean, parama);
    a(parama, paramStoreRequestBean);
    return parama;
  }
  
  private static void a(c paramc, StoreRequestBean paramStoreRequestBean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("executeTask, ActiveCount:");
    localStringBuilder.append(com.huawei.updatesdk.support.b.c.a.getActiveCount());
    localStringBuilder.append(", TaskCount:");
    localStringBuilder.append(com.huawei.updatesdk.support.b.c.a.getTaskCount());
    com.huawei.updatesdk.sdk.a.c.a.a.a.a("StoreAgent", localStringBuilder.toString());
    if (paramStoreRequestBean.isSerial()) {
      paramStoreRequestBean = com.huawei.updatesdk.support.b.c.c;
    } else {
      paramStoreRequestBean = com.huawei.updatesdk.support.b.c.a;
    }
    paramc.a(paramStoreRequestBean);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\service\b\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */