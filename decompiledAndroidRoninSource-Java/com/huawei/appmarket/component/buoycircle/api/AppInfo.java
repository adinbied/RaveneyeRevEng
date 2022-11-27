package com.huawei.appmarket.component.buoycircle.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AppInfo
  implements Parcelable
{
  public static final Parcelable.Creator<AppInfo> CREATOR = new Parcelable.Creator()
  {
    public AppInfo createFromParcel(Parcel paramAnonymousParcel)
    {
      return new AppInfo(paramAnonymousParcel);
    }
    
    public AppInfo[] newArray(int paramAnonymousInt)
    {
      return new AppInfo[paramAnonymousInt];
    }
  };
  private static final String TAG = "AppInfo";
  private String appId;
  private String cpId;
  private String packageName;
  private String sdkVersionCode;
  
  protected AppInfo(Parcel paramParcel)
  {
    this.appId = paramParcel.readString();
    this.cpId = paramParcel.readString();
    this.packageName = paramParcel.readString();
    this.sdkVersionCode = paramParcel.readString();
  }
  
  private AppInfo(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.appId = paramString1;
    this.cpId = paramString2;
    this.packageName = paramString3;
    this.sdkVersionCode = paramString4;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAppId()
  {
    return this.appId;
  }
  
  public String getCpId()
  {
    return this.cpId;
  }
  
  public String getPackageName()
  {
    return this.packageName;
  }
  
  public String getSdkVersionCode()
  {
    return this.sdkVersionCode;
  }
  
  public void setPackageName(String paramString)
  {
    this.packageName = paramString;
  }
  
  public String toString()
  {
    return null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.cpId);
    paramParcel.writeString(this.packageName);
    paramParcel.writeString(this.sdkVersionCode);
  }
  
  public static final class Builder
  {
    private String appId;
    private String cpId;
    private String packageName;
    private String sdkVersionCode;
    
    public AppInfo build()
    {
      return null;
    }
    
    public Builder setAppId(String paramString)
    {
      this.appId = paramString;
      return this;
    }
    
    public Builder setCpId(String paramString)
    {
      this.cpId = paramString;
      return this;
    }
    
    public Builder setPackageName(String paramString)
    {
      this.packageName = paramString;
      return this;
    }
    
    public Builder setSdkVersionCode(String paramString)
    {
      this.sdkVersionCode = paramString;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\api\AppInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */