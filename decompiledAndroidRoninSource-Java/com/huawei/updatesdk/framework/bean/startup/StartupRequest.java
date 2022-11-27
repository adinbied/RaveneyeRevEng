package com.huawei.updatesdk.framework.bean.startup;

import android.os.SystemProperties;
import com.huawei.updatesdk.framework.bean.StoreRequestBean;
import com.huawei.updatesdk.sdk.a.c.a.a.a;

public final class StartupRequest
  extends StoreRequestBean
{
  public static final String APIMETHOD = "client.https.front";
  public static final int SYSTEM_32 = 1;
  public static final int SYSTEM_64 = 2;
  private String accountZone_;
  private String buildNumber_;
  private String density_;
  private int emuiApiLevel_ = 0;
  private String emuiVer_ = null;
  private String firmwareVersion_;
  private int gmsSupport_;
  private int isSubUser_ = 0;
  private String packageName_;
  private String phoneType_;
  private String resolution_;
  private String screen_;
  private int sysBits_ = 1;
  private String theme_;
  private int versionCode_;
  private String version_;
  private int zone_;
  
  private static int getSysteBit()
  {
    int i;
    if (SystemProperties.get("ro.product.cpu.abi", "").contains("arm64")) {
      i = 2;
    } else {
      i = 1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("systeAbi:");
    localStringBuilder.append(i);
    a.a("StartupRequest", localStringBuilder.toString());
    return i;
  }
  
  public static StartupRequest newInstance()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public String getAccountZone_()
  {
    return this.accountZone_;
  }
  
  public String getBuildNumber_()
  {
    return this.buildNumber_;
  }
  
  public String getDensity_()
  {
    return this.density_;
  }
  
  public int getEmuiApiLevel_()
  {
    return this.emuiApiLevel_;
  }
  
  public String getEmuiVer_()
  {
    return this.emuiVer_;
  }
  
  public String getFirmwareVersion_()
  {
    return this.firmwareVersion_;
  }
  
  public int getGmsSupport_()
  {
    return this.gmsSupport_;
  }
  
  public int getIsSubUser_()
  {
    return this.isSubUser_;
  }
  
  public String getPackageName_()
  {
    return this.packageName_;
  }
  
  public String getPhoneType_()
  {
    return this.phoneType_;
  }
  
  public String getResolution_()
  {
    return this.resolution_;
  }
  
  public String getScreen_()
  {
    return this.screen_;
  }
  
  public int getSysBits_()
  {
    return this.sysBits_;
  }
  
  public String getTheme_()
  {
    return this.theme_;
  }
  
  public int getVersionCode_()
  {
    return this.versionCode_;
  }
  
  public String getVersion_()
  {
    return this.version_;
  }
  
  public int getZone_()
  {
    return this.zone_;
  }
  
  public void setAccountZone_(String paramString)
  {
    this.accountZone_ = paramString;
  }
  
  public void setBuildNumber_(String paramString)
  {
    this.buildNumber_ = paramString;
  }
  
  public void setDensity_(String paramString)
  {
    this.density_ = paramString;
  }
  
  public void setEmuiApiLevel_(int paramInt)
  {
    this.emuiApiLevel_ = paramInt;
  }
  
  public void setEmuiVer_(String paramString)
  {
    this.emuiVer_ = paramString;
  }
  
  public void setFirmwareVersion_(String paramString)
  {
    this.firmwareVersion_ = paramString;
  }
  
  public void setGmsSupport_(int paramInt)
  {
    this.gmsSupport_ = paramInt;
  }
  
  public void setIsSubUser_(int paramInt)
  {
    this.isSubUser_ = paramInt;
  }
  
  public void setPackageName_(String paramString)
  {
    this.packageName_ = paramString;
  }
  
  public void setPhoneType_(String paramString)
  {
    this.phoneType_ = paramString;
  }
  
  public void setResolution_(String paramString)
  {
    this.resolution_ = paramString;
  }
  
  public void setScreen_(String paramString)
  {
    this.screen_ = paramString;
  }
  
  public void setSysBits_(int paramInt)
  {
    this.sysBits_ = paramInt;
  }
  
  public void setTheme_(String paramString)
  {
    this.theme_ = paramString;
  }
  
  public void setVersionCode_(int paramInt)
  {
    this.versionCode_ = paramInt;
  }
  
  public void setVersion_(String paramString)
  {
    this.version_ = paramString;
  }
  
  public void setZone_(int paramInt)
  {
    this.zone_ = paramInt;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\framework\bean\startup\StartupRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */