package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File;
import java.io.InputStream;

abstract interface NativeSessionFile
{
  public abstract CrashlyticsReport.FilesPayload.File asFilePayload();
  
  public abstract String getReportsEndpointFilename();
  
  public abstract InputStream getStream();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\common\NativeSessionFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */