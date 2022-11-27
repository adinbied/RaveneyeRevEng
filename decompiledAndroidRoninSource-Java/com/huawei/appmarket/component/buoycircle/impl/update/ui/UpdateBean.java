package com.huawei.appmarket.component.buoycircle.impl.update.ui;

import java.io.Serializable;
import java.util.ArrayList;

public class UpdateBean
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String clientAppId;
  private String clientAppName;
  private String clientPackageName;
  private int clientVersionCode;
  private boolean isHmsOrApkUpgrade;
  private boolean needConfirm = true;
  private String sdkVersionCode;
  private ArrayList typeList;
  
  private static <T> T get(T paramT)
  {
    return paramT;
  }
  
  public String getClientAppId()
  {
    return null;
  }
  
  public String getClientAppName()
  {
    return null;
  }
  
  public String getClientPackageName()
  {
    return null;
  }
  
  public int getClientVersionCode()
  {
    return 0;
  }
  
  public String getSdkVersionCode()
  {
    return this.sdkVersionCode;
  }
  
  public ArrayList getTypeList()
  {
    return null;
  }
  
  public boolean isHmsOrApkUpgrade()
  {
    return false;
  }
  
  public boolean isNeedConfirm()
  {
    return false;
  }
  
  public void setClientAppId(String paramString)
  {
    this.clientAppId = paramString;
  }
  
  public void setClientAppName(String paramString)
  {
    this.clientAppName = paramString;
  }
  
  public void setClientPackageName(String paramString)
  {
    this.clientPackageName = paramString;
  }
  
  public void setClientVersionCode(int paramInt)
  {
    this.clientVersionCode = paramInt;
  }
  
  public void setHmsOrApkUpgrade(boolean paramBoolean)
  {
    this.isHmsOrApkUpgrade = paramBoolean;
  }
  
  public void setNeedConfirm(boolean paramBoolean)
  {
    this.needConfirm = paramBoolean;
  }
  
  public void setSdkVersionCode(String paramString)
  {
    this.sdkVersionCode = paramString;
  }
  
  public void setTypeList(ArrayList paramArrayList)
  {
    this.typeList = paramArrayList;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\imp\\updat\\ui\UpdateBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */