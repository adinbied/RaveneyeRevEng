package com.huawei.updatesdk.service.otaupdate;

import com.huawei.updatesdk.sdk.service.download.bean.DownloadTask;
import com.huawei.updatesdk.sdk.service.storekit.bean.RequestBean;
import com.huawei.updatesdk.sdk.service.storekit.bean.ResponseBean;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.appmgr.bean.UpgradeRequest;
import com.huawei.updatesdk.service.b.a.b;
import com.huawei.updatesdk.service.deamon.download.DownloadService;
import com.huawei.updatesdk.service.deamon.download.SecurityDownloadTask;
import com.huawei.updatesdk.service.deamon.download.c;
import java.util.Iterator;
import java.util.List;

public class d
{
  private static a a;
  
  public static void a()
  {
    b.a(UpgradeRequest.newInstance("com.huawei.appmarket"), new a(null));
  }
  
  public static void a(ApkUpgradeInfo paramApkUpgradeInfo)
  {
    Object localObject1 = c.b().e();
    if (localObject1 != null)
    {
      Object localObject2 = ((DownloadService)localObject1).b(paramApkUpgradeInfo.getPackage_());
      if (localObject2 == null)
      {
        localObject2 = new SecurityDownloadTask();
        ((DownloadTask)localObject2).a(0);
        ((DownloadTask)localObject2).g(paramApkUpgradeInfo.getDownurl_());
        ((DownloadTask)localObject2).f(paramApkUpgradeInfo.getName_());
        ((DownloadTask)localObject2).i(paramApkUpgradeInfo.getPackage_());
        ((DownloadTask)localObject2).b(paramApkUpgradeInfo.getId_());
        ((DownloadTask)localObject2).a(paramApkUpgradeInfo.getSize_());
        ((DownloadTask)localObject2).j(paramApkUpgradeInfo.getIcon_());
        ((DownloadTask)localObject2).a(paramApkUpgradeInfo.getDetailId_());
        ((DownloadTask)localObject2).e(paramApkUpgradeInfo.getSha256_());
        ((DownloadService)localObject1).a((DownloadTask)localObject2);
        localObject1 = a;
        if (localObject1 != null) {
          ((a)localObject1).b(paramApkUpgradeInfo);
        }
      }
      else if (((DownloadTask)localObject2).o() > 4)
      {
        ((DownloadService)localObject1).b((DownloadTask)localObject2);
      }
    }
    else
    {
      com.huawei.updatesdk.sdk.a.c.a.a.a.a("MarketDownloadManager", "downloadService == NULL");
    }
  }
  
  public static void a(a parama)
  {
    a = parama;
  }
  
  public static void a(String paramString)
  {
    c localc = c.b();
    if (localc != null)
    {
      if (localc.e() == null) {
        return;
      }
      localc.e().a(paramString);
    }
  }
  
  private static ApkUpgradeInfo b(List<ApkUpgradeInfo> paramList)
  {
    Object localObject = null;
    if (paramList == null) {
      return null;
    }
    Iterator localIterator = paramList.iterator();
    do
    {
      paramList = (List<ApkUpgradeInfo>)localObject;
      if (!localIterator.hasNext()) {
        break;
      }
      paramList = (ApkUpgradeInfo)localIterator.next();
    } while (!"com.huawei.appmarket".equals(paramList.getPackage_()));
    return paramList;
  }
  
  private static class a
    implements com.huawei.updatesdk.sdk.service.storekit.bean.a
  {
    public void a(RequestBean paramRequestBean, ResponseBean paramResponseBean) {}
    
    /* Error */
    public void b(RequestBean arg1, ResponseBean arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\service\otaupdate\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */