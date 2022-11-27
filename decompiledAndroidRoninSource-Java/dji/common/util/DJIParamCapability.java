package dji.common.util;

public class DJIParamCapability
{
  protected boolean isSupported;
  
  public DJIParamCapability(boolean paramBoolean)
  {
    this.isSupported = paramBoolean;
  }
  
  public boolean isSupported()
  {
    return this.isSupported;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\commo\\util\DJIParamCapability.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */