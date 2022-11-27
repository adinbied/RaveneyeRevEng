package com.huawei.gamebox.plugin.gameservice.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class RequestInfo
  implements Parcelable
{
  public static final Parcelable.Creator<RequestInfo> CREATOR = new Parcelable.Creator()
  {
    public RequestInfo createFromParcel(Parcel paramAnonymousParcel)
    {
      return null;
    }
    
    public RequestInfo[] newArray(int paramAnonymousInt)
    {
      return new RequestInfo[paramAnonymousInt];
    }
  };
  private static final String GAMESERVICE_SDK_VERSION_CODE = "70301300";
  private static final String GAMESERVICE_SDK_VERSION_NAME = "7.3.1.300";
  private String appId;
  private String cpId;
  private String gameSign;
  private String gameTs;
  private int gameType;
  private String method;
  private int needAuth;
  private String packageName;
  private String params;
  private String sdkVersionCode;
  private String sdkVersionName;
  private String versionCode;
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAppID()
  {
    return this.appId;
  }
  
  public String getCpID()
  {
    return this.cpId;
  }
  
  public String getGameSign()
  {
    return this.gameSign;
  }
  
  public String getGameTs()
  {
    return this.gameTs;
  }
  
  public int getGameType()
  {
    return this.gameType;
  }
  
  public String getMethod()
  {
    return this.method;
  }
  
  public int getNeedAuth()
  {
    return this.needAuth;
  }
  
  public String getPackageName()
  {
    return this.packageName;
  }
  
  public String getParams()
  {
    return this.params;
  }
  
  public String getSdkVersionCode()
  {
    return this.sdkVersionCode;
  }
  
  public String getSdkVersionName()
  {
    return this.sdkVersionName;
  }
  
  public String getVersionCode()
  {
    return this.versionCode;
  }
  
  public void init(String paramString1, String paramString2)
  {
    this.appId = paramString1;
    this.cpId = paramString2;
    this.sdkVersionCode = "70301300";
    this.sdkVersionName = "7.3.1.300";
    this.params = "";
    this.gameSign = "";
    this.gameTs = "";
  }
  
  /* Error */
  public void readFromParcel(Parcel arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setAppId(String paramString)
  {
    this.appId = paramString;
  }
  
  public void setCpId(String paramString)
  {
    this.cpId = paramString;
  }
  
  public void setGameSign(String paramString)
  {
    this.gameSign = paramString;
  }
  
  public void setGameTs(String paramString)
  {
    this.gameTs = paramString;
  }
  
  public void setGameType(int paramInt)
  {
    this.gameType = paramInt;
  }
  
  public void setMethod(String paramString)
  {
    this.method = paramString;
  }
  
  public void setNeedAuth(int paramInt)
  {
    this.needAuth = paramInt;
  }
  
  public void setPackageName(String paramString)
  {
    this.packageName = paramString;
  }
  
  public void setParams(String paramString)
  {
    this.params = paramString;
  }
  
  public void setSdkVersionCode(String paramString)
  {
    this.sdkVersionCode = paramString;
  }
  
  public void setSdkVersionName(String paramString)
  {
    this.sdkVersionName = paramString;
  }
  
  public void setVersionCode(String paramString)
  {
    this.versionCode = paramString;
  }
  
  public String toString()
  {
    return null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.method);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.cpId);
    paramParcel.writeString(this.sdkVersionCode);
    paramParcel.writeString(this.sdkVersionName);
    paramParcel.writeString(this.packageName);
    paramParcel.writeString(this.gameSign);
    paramParcel.writeString(this.gameTs);
    paramParcel.writeString(this.versionCode);
    paramParcel.writeString(this.params);
    paramParcel.writeInt(this.gameType);
    paramParcel.writeInt(this.needAuth);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\gamebox\plugin\gameservice\service\RequestInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */