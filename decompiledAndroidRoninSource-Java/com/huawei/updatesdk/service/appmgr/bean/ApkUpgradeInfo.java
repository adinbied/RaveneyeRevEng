package com.huawei.updatesdk.service.appmgr.bean;

import com.huawei.updatesdk.sdk.service.storekit.bean.JsonBean;
import java.io.Serializable;

public class ApkUpgradeInfo
  extends JsonBean
  implements Serializable
{
  public static final int APP_MUST_UPDATE = 1;
  public static final int HUAWEI_OFFICIAL_APP = 1;
  public static final int NOT_AUTOUPDATE = 0;
  private static final String TAG = "ApkUpgradeInfo";
  public static final int UPGRADE_SAME_SIGNATURE = 0;
  private static final long serialVersionUID = 136275377334431721L;
  private String detailId_;
  private int devType_ = 0;
  private String diffHash_;
  private int diffSize_;
  private String downurl_;
  private String fullDownUrl_;
  private String hash_;
  private String icon_;
  private String id_;
  private int isAutoUpdate_ = 0;
  private int isCompulsoryUpdate_ = 0;
  private String name_;
  private String newFeatures_;
  private String notRcmReason_;
  private String oldHashCode;
  private int oldVersionCode_;
  private String oldVersionName_;
  private String package_;
  private String releaseDateDesc_;
  private String releaseDate_;
  private int sameS_ = 0;
  private String sha256_;
  private int size_;
  private int state_ = 2;
  private int versionCode_;
  private String version_;
  
  public String getDetailId_()
  {
    return this.detailId_;
  }
  
  public int getDevType_()
  {
    return this.devType_;
  }
  
  public String getDiffHash_()
  {
    return this.diffHash_;
  }
  
  public int getDiffSize_()
  {
    return this.diffSize_;
  }
  
  public String getDownurl_()
  {
    return this.downurl_;
  }
  
  public String getFullDownUrl_()
  {
    return this.fullDownUrl_;
  }
  
  public String getHash_()
  {
    return this.hash_;
  }
  
  public String getIcon_()
  {
    return this.icon_;
  }
  
  public String getId_()
  {
    return this.id_;
  }
  
  public int getIsAutoUpdate_()
  {
    return this.isAutoUpdate_;
  }
  
  public int getIsCompulsoryUpdate_()
  {
    return this.isCompulsoryUpdate_;
  }
  
  public String getName_()
  {
    return this.name_;
  }
  
  public String getNewFeatures_()
  {
    return this.newFeatures_;
  }
  
  public String getNotRcmReason_()
  {
    return this.notRcmReason_;
  }
  
  public String getOldHashCode()
  {
    return this.oldHashCode;
  }
  
  public int getOldVersionCode_()
  {
    return this.oldVersionCode_;
  }
  
  public String getOldVersionName_()
  {
    return this.oldVersionName_;
  }
  
  public String getPackage_()
  {
    return this.package_;
  }
  
  public String getReleaseDateDesc_()
  {
    return this.releaseDateDesc_;
  }
  
  public String getReleaseDate_()
  {
    return this.releaseDate_;
  }
  
  public int getSameS_()
  {
    return this.sameS_;
  }
  
  public String getSha256_()
  {
    return this.sha256_;
  }
  
  public int getSize_()
  {
    return this.size_;
  }
  
  public int getState_()
  {
    return this.state_;
  }
  
  public int getVersionCode_()
  {
    return this.versionCode_;
  }
  
  public String getVersion_()
  {
    return this.version_;
  }
  
  public void setDetailId_(String paramString)
  {
    this.detailId_ = paramString;
  }
  
  public void setDevType_(int paramInt)
  {
    this.devType_ = paramInt;
  }
  
  public void setDiffHash_(String paramString)
  {
    this.diffHash_ = paramString;
  }
  
  public void setDiffSize_(int paramInt)
  {
    this.diffSize_ = paramInt;
  }
  
  public void setDownurl_(String paramString)
  {
    this.downurl_ = paramString;
  }
  
  public void setFullDownUrl_(String paramString)
  {
    this.fullDownUrl_ = paramString;
  }
  
  public void setHash_(String paramString)
  {
    this.hash_ = paramString;
  }
  
  public void setIcon_(String paramString)
  {
    this.icon_ = paramString;
  }
  
  public void setId_(String paramString)
  {
    this.id_ = paramString;
  }
  
  public void setIsAutoUpdate_(int paramInt)
  {
    this.isAutoUpdate_ = paramInt;
  }
  
  public void setIsCompulsoryUpdate_(int paramInt)
  {
    this.isCompulsoryUpdate_ = paramInt;
  }
  
  public void setName_(String paramString)
  {
    this.name_ = paramString;
  }
  
  public void setNewFeatures_(String paramString)
  {
    this.newFeatures_ = paramString;
  }
  
  public void setNotRcmReason_(String paramString)
  {
    this.notRcmReason_ = paramString;
  }
  
  public void setOldHashCode(String paramString)
  {
    this.oldHashCode = paramString;
  }
  
  public void setOldVersionCode_(int paramInt)
  {
    this.oldVersionCode_ = paramInt;
  }
  
  public void setOldVersionName_(String paramString)
  {
    this.oldVersionName_ = paramString;
  }
  
  public void setPackage_(String paramString)
  {
    this.package_ = paramString;
  }
  
  public void setReleaseDateDesc_(String paramString)
  {
    this.releaseDateDesc_ = paramString;
  }
  
  public void setReleaseDate_(String paramString)
  {
    this.releaseDate_ = paramString;
  }
  
  public void setSameS_(int paramInt)
  {
    this.sameS_ = paramInt;
  }
  
  public void setSha256_(String paramString)
  {
    this.sha256_ = paramString;
  }
  
  public void setSize_(int paramInt)
  {
    this.size_ = paramInt;
  }
  
  public void setState_(int paramInt)
  {
    this.state_ = paramInt;
  }
  
  public void setVersionCode_(int paramInt)
  {
    this.versionCode_ = paramInt;
  }
  
  public void setVersion_(String paramString)
  {
    this.version_ = paramString;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\service\appmgr\bean\ApkUpgradeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */