package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;

public enum DataTransportState
{
  static final int REPORT_UPLOAD_VARIANT_DATATRANSPORT = 2;
  static final int REPORT_UPLOAD_VARIANT_LEGACY = 1;
  
  static
  {
    JAVA_ONLY = new DataTransportState("JAVA_ONLY", 1);
    DataTransportState localDataTransportState = new DataTransportState("ALL", 2);
    ALL = localDataTransportState;
    $VALUES = new DataTransportState[] { NONE, JAVA_ONLY, localDataTransportState };
  }
  
  private DataTransportState() {}
  
  static DataTransportState getState(AppSettingsData paramAppSettingsData)
  {
    int i = paramAppSettingsData.reportUploadVariant;
    boolean bool2 = true;
    boolean bool1;
    if (i == 2) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (paramAppSettingsData.nativeReportUploadVariant != 2) {
      bool2 = false;
    }
    return getState(bool1, bool2);
  }
  
  static DataTransportState getState(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1) {
      return NONE;
    }
    if (!paramBoolean2) {
      return JAVA_ONLY;
    }
    return ALL;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\common\DataTransportState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */