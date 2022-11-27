package dji.common.mission.panorama;

public class PanoramaMissionExecutionState
{
  private int currentSavedNumber;
  private int currentShotNumber;
  private int totalNumber;
  
  public PanoramaMissionExecutionState(int paramInt1, int paramInt2, int paramInt3)
  {
    this.totalNumber = paramInt1;
    this.currentShotNumber = paramInt2;
    this.currentSavedNumber = paramInt3;
  }
  
  public int getCurrentSavedNumber()
  {
    return this.currentSavedNumber;
  }
  
  public int getCurrentShotNumber()
  {
    return this.currentShotNumber;
  }
  
  public int getTotalNumber()
  {
    return this.totalNumber;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\mission\panorama\PanoramaMissionExecutionState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */