package com.huawei.updatesdk.service.appmgr.bean;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import com.huawei.updatesdk.framework.bean.StoreRequestBean;
import com.huawei.updatesdk.sdk.a.d.c;
import com.huawei.updatesdk.sdk.service.storekit.bean.JsonBean;
import com.huawei.updatesdk.support.b.d;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UpgradeRequest
  extends StoreRequestBean
{
  public static final String APIMETHOD = "client.https.diffUpgrade";
  public static final int DEFAULT_UPGRADE_RESULT = 0;
  public static final int FULL_UPGRADE_RESULT = 1;
  public static final int INSTALL_CHECK_DEFAULT = 0;
  public static final int PRE_DOWNLOAD_CLOSE = 0;
  private static final String TAG = "UpgradeRequest";
  private static final int TYPE_NOT_PREINSTALL = 0;
  private static final int TYPE_PREINSTALL = 2;
  private static final int TYPE_PREINSTALL_REMOVABLE = 1;
  private String cmp_ = "1";
  private int installCheck_ = 0;
  private int isFullUpgrade_ = 0;
  private int isUpdateSdk_ = 1;
  private int isWlanIdle_ = 0;
  private Json json_;
  private String maxMem_;
  
  private static int getPreInstallType(PackageInfo paramPackageInfo)
  {
    if ((paramPackageInfo.applicationInfo.flags & 0x1) == 0) {
      return 0;
    }
    if (isDelApp(paramPackageInfo.applicationInfo)) {
      return 1;
    }
    return 2;
  }
  
  private static boolean isDelApp(ApplicationInfo paramApplicationInfo)
  {
    int i = paramApplicationInfo.flags;
    Object localObject = com.huawei.updatesdk.support.c.a.a();
    if ((localObject != null) && ((i & ((Integer)localObject).intValue()) != 0)) {
      return true;
    }
    localObject = com.huawei.updatesdk.support.c.a.b();
    if (localObject != null)
    {
      String str2;
      try
      {
        i = ((Field)localObject).getInt(paramApplicationInfo);
        if ((i & 0x2000000) == 0) {
          break label107;
        }
        return true;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        paramApplicationInfo = new StringBuilder();
        paramApplicationInfo.append("can not get hwflags");
        String str1 = localIllegalArgumentException.toString();
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        paramApplicationInfo = new StringBuilder();
        paramApplicationInfo.append("can not get hwflags");
        str2 = localIllegalAccessException.toString();
      }
      paramApplicationInfo.append(str2);
      com.huawei.updatesdk.sdk.a.c.a.a.a.a("UpgradeRequest", paramApplicationInfo.toString());
    }
    label107:
    return false;
  }
  
  public static UpgradeRequest newInstance(String paramString)
  {
    PackageInfo localPackageInfo = new PackageInfo();
    localPackageInfo.packageName = paramString;
    localPackageInfo.versionName = "1.0";
    localPackageInfo.versionCode = 1;
    paramString = new ApplicationInfo();
    paramString.targetSdkVersion = 19;
    localPackageInfo.applicationInfo = paramString;
    paramString = new ArrayList();
    paramString.add(localPackageInfo);
    paramString = newInstance(paramString);
    paramString.setIsFullUpgrade_(1);
    return paramString;
  }
  
  public static UpgradeRequest newInstance(List<PackageInfo> paramList)
  {
    UpgradeRequest localUpgradeRequest = new UpgradeRequest();
    localUpgradeRequest.setStoreApi("tlsApis");
    localUpgradeRequest.setMethod_("client.https.diffUpgrade");
    localUpgradeRequest.setMaxMem_(String.valueOf(com.huawei.updatesdk.sdk.a.d.b.a.b(com.huawei.updatesdk.sdk.service.a.a.a().b()) / 1024L));
    localUpgradeRequest.setVer_("1.2");
    localUpgradeRequest.setIsWlanIdle_(0);
    Json localJson = new Json();
    localUpgradeRequest.setJson_(localJson);
    ArrayList localArrayList = new ArrayList();
    localJson.setParams_(localArrayList);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new Param((PackageInfo)paramList.next()));
    }
    return localUpgradeRequest;
  }
  
  public int getInstallCheck_()
  {
    return this.installCheck_;
  }
  
  public int getIsFullUpgrade_()
  {
    return this.isFullUpgrade_;
  }
  
  public int getIsUpdateSdk_()
  {
    return this.isUpdateSdk_;
  }
  
  public int getIsWlanIdle_()
  {
    return this.isWlanIdle_;
  }
  
  public Json getJson_()
  {
    return this.json_;
  }
  
  public String getMaxMem_()
  {
    return this.maxMem_;
  }
  
  public void setInstallCheck_(int paramInt)
  {
    this.installCheck_ = paramInt;
  }
  
  public void setIsFullUpgrade_(int paramInt)
  {
    this.isFullUpgrade_ = paramInt;
  }
  
  public void setIsUpdateSdk_(int paramInt)
  {
    this.isUpdateSdk_ = paramInt;
  }
  
  public void setIsWlanIdle_(int paramInt)
  {
    this.isWlanIdle_ = paramInt;
  }
  
  public void setJson_(Json paramJson)
  {
    this.json_ = paramJson;
  }
  
  public void setMaxMem_(String paramString)
  {
    this.maxMem_ = paramString;
  }
  
  public static class Json
    extends JsonBean
  {
    private List<UpgradeRequest.Param> params_;
    
    public List<UpgradeRequest.Param> getParams_()
    {
      return this.params_;
    }
    
    public void setParams_(List<UpgradeRequest.Param> paramList)
    {
      this.params_ = paramList;
    }
  }
  
  public static class Param
    extends JsonBean
  {
    private String fSha2_;
    private int isPre_;
    private String oldVersion_;
    private String package_;
    private String sSha2_;
    private int targetSdkVersion_;
    private int versionCode_;
    
    public Param() {}
    
    public Param(PackageInfo paramPackageInfo)
    {
      this.package_ = paramPackageInfo.packageName;
      this.versionCode_ = paramPackageInfo.versionCode;
      String str;
      if (paramPackageInfo.versionName == null) {
        str = "null";
      } else {
        str = paramPackageInfo.versionName;
      }
      this.oldVersion_ = str;
      this.targetSdkVersion_ = paramPackageInfo.applicationInfo.targetSdkVersion;
      this.isPre_ = UpgradeRequest.getPreInstallType(paramPackageInfo);
      if (paramPackageInfo.signatures != null) {
        this.sSha2_ = com.huawei.updatesdk.sdk.a.d.a.a.b(com.huawei.updatesdk.sdk.a.d.a.a(d.a(paramPackageInfo.signatures[0].toCharsString())));
      }
      this.fSha2_ = c.a(paramPackageInfo.applicationInfo.sourceDir, "SHA-256");
    }
    
    public String getPackage_()
    {
      return this.package_;
    }
    
    public String getfSha2_()
    {
      return this.fSha2_;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\service\appmgr\bean\UpgradeRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */