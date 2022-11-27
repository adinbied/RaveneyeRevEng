package com.google.firebase.crashlytics.internal.report.model;

import java.io.File;
import java.util.Map;

public abstract interface Report
{
  public abstract Map<String, String> getCustomHeaders();
  
  public abstract File getFile();
  
  public abstract String getFileName();
  
  public abstract File[] getFiles();
  
  public abstract String getIdentifier();
  
  public abstract Type getType();
  
  public abstract void remove();
  
  public static enum Type
  {
    static
    {
      Type localType = new Type("NATIVE", 1);
      NATIVE = localType;
      $VALUES = new Type[] { JAVA, localType };
    }
    
    private Type() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\report\model\Report.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */