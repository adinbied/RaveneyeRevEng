package dji.common.flightcontroller;

import dji.midware.data.model.P3.DataOnBoardSdkSetIOState.GPIOMode;

public class IOStateOnBoard
{
  private int dutyRatioOfPWM = -1;
  private int frequencyOfPWM = 0;
  private GPIOWorkModeOnBoard gpioWorkModeOnBoard = GPIOWorkModeOnBoard.OTHER;
  private boolean initiated = false;
  private IOMode ioMode = IOMode.OTHER;
  private boolean isInHighElectricLevel = false;
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public int getDutyRatioOfPWM()
  {
    return this.dutyRatioOfPWM;
  }
  
  public int getFrequencyOfPWM()
  {
    return this.frequencyOfPWM;
  }
  
  public GPIOWorkModeOnBoard getGpioWorkModeOnBoard()
  {
    return this.gpioWorkModeOnBoard;
  }
  
  public IOMode getIoMode()
  {
    return this.ioMode;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean isInHighElectricLevel()
  {
    return this.isInHighElectricLevel;
  }
  
  public boolean isInitiated()
  {
    return this.initiated;
  }
  
  public static class Builder
  {
    public static IOStateOnBoard createInitiateParams(int paramInt1, int paramInt2)
    {
      IOStateOnBoard localIOStateOnBoard = new IOStateOnBoard(null);
      IOStateOnBoard.access$102(localIOStateOnBoard, IOMode.PWM);
      IOStateOnBoard.access$602(localIOStateOnBoard, paramInt1);
      IOStateOnBoard.access$502(localIOStateOnBoard, paramInt2);
      return localIOStateOnBoard;
    }
    
    public static IOStateOnBoard createInitiateParams(GPIOWorkModeOnBoard paramGPIOWorkModeOnBoard)
    {
      IOStateOnBoard localIOStateOnBoard = new IOStateOnBoard(null);
      IOStateOnBoard.access$102(localIOStateOnBoard, IOMode.GPIO);
      IOStateOnBoard.access$202(localIOStateOnBoard, paramGPIOWorkModeOnBoard);
      return localIOStateOnBoard;
    }
    
    public static IOStateOnBoard createReturnValue(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      IOStateOnBoard localIOStateOnBoard = new IOStateOnBoard(null);
      IOStateOnBoard.access$102(localIOStateOnBoard, IOMode.PWM);
      IOStateOnBoard.access$502(localIOStateOnBoard, paramInt2);
      IOStateOnBoard.access$302(localIOStateOnBoard, paramBoolean);
      IOStateOnBoard.access$602(localIOStateOnBoard, paramInt1);
      return localIOStateOnBoard;
    }
    
    public static IOStateOnBoard createReturnValue(boolean paramBoolean1, DataOnBoardSdkSetIOState.GPIOMode paramGPIOMode, boolean paramBoolean2)
    {
      IOStateOnBoard localIOStateOnBoard = new IOStateOnBoard(null);
      IOStateOnBoard.access$102(localIOStateOnBoard, IOMode.GPIO);
      IOStateOnBoard.access$202(localIOStateOnBoard, GPIOWorkModeOnBoard.find(paramGPIOMode.value()));
      IOStateOnBoard.access$302(localIOStateOnBoard, paramBoolean2);
      IOStateOnBoard.access$402(localIOStateOnBoard, paramBoolean1);
      return localIOStateOnBoard;
    }
    
    public static IOStateOnBoard createSetParams(int paramInt)
    {
      IOStateOnBoard localIOStateOnBoard = new IOStateOnBoard(null);
      IOStateOnBoard.access$102(localIOStateOnBoard, IOMode.PWM);
      IOStateOnBoard.access$602(localIOStateOnBoard, paramInt);
      return localIOStateOnBoard;
    }
    
    public static IOStateOnBoard createSetParams(boolean paramBoolean)
    {
      IOStateOnBoard localIOStateOnBoard = new IOStateOnBoard(null);
      IOStateOnBoard.access$102(localIOStateOnBoard, IOMode.GPIO);
      IOStateOnBoard.access$402(localIOStateOnBoard, paramBoolean);
      return localIOStateOnBoard;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\IOStateOnBoard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */