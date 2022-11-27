package dji.common.flightcontroller;

public class DJIMultiLEDControlMode
{
  private boolean backLEDs;
  private boolean frontLEDs;
  private boolean navigationLED;
  private boolean statusLED;
  
  public DJIMultiLEDControlMode(int paramInt)
  {
    boolean bool2 = false;
    if ((paramInt & 0x1) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.frontLEDs = bool1;
    if ((paramInt >> 1 & 0x1) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.backLEDs = bool1;
    if ((paramInt >> 2 & 0x1) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.navigationLED = bool1;
    boolean bool1 = bool2;
    if ((paramInt >> 3 & 0x1) == 1) {
      bool1 = true;
    }
    this.statusLED = bool1;
  }
  
  public byte getDate()
  {
    return 0;
  }
  
  public boolean isBackLEDs()
  {
    return this.backLEDs;
  }
  
  public boolean isFrontLEDs()
  {
    return this.frontLEDs;
  }
  
  public boolean isNavigationLED()
  {
    return this.navigationLED;
  }
  
  public boolean isStatusLED()
  {
    return this.statusLED;
  }
  
  public void setBackLEDs(boolean paramBoolean)
  {
    this.backLEDs = paramBoolean;
  }
  
  public void setFrontLEDs(boolean paramBoolean)
  {
    this.frontLEDs = paramBoolean;
  }
  
  public void setNavigationLED(boolean paramBoolean)
  {
    this.navigationLED = paramBoolean;
  }
  
  public void setStatusLED(boolean paramBoolean)
  {
    this.statusLED = paramBoolean;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\DJIMultiLEDControlMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */