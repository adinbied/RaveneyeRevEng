package com.huawei.updatesdk.sdk.service.storekit;

import com.huawei.updatesdk.sdk.service.storekit.bean.ResponseBean;
import java.util.HashMap;
import java.util.Map;

public class a
{
  private static final Map<String, Class> a = new HashMap();
  
  public static ResponseBean a(String paramString)
    throws InstantiationException, IllegalAccessException
  {
    Object localObject = (Class)a.get(paramString);
    if (localObject != null) {
      return (ResponseBean)((Class)localObject).newInstance();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ResponseBean class not found, method:");
    ((StringBuilder)localObject).append(paramString);
    throw new InstantiationException(((StringBuilder)localObject).toString());
  }
  
  public static void a(String paramString, Class paramClass)
  {
    a.put(paramString, paramClass);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\sdk\service\storekit\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */