package com.drew.metadata;

import java.util.HashMap;

public final class ErrorDirectory
  extends Directory
{
  public ErrorDirectory() {}
  
  public ErrorDirectory(String paramString)
  {
    super.addError(paramString);
  }
  
  public String getName()
  {
    return "Error";
  }
  
  public String getTagName(int paramInt)
  {
    return "";
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return new HashMap();
  }
  
  public boolean hasTagName(int paramInt)
  {
    return false;
  }
  
  /* Error */
  public void setObject(int arg1, Object arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\ErrorDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */