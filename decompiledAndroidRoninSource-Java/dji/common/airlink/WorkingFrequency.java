package dji.common.airlink;

public enum WorkingFrequency
{
  public int value = 0;
  
  static
  {
    WorkingFrequency localWorkingFrequency = new WorkingFrequency("FREQUENCY_5_8G", 2, 2);
    FREQUENCY_5_8G = localWorkingFrequency;
    $VALUES = new WorkingFrequency[] { FREQUENCY_2_4G, FREQUENCY_5_1G, localWorkingFrequency };
  }
  
  private WorkingFrequency(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static WorkingFrequency find(int paramInt)
  {
    WorkingFrequency[] arrayOfWorkingFrequency = values();
    int j = arrayOfWorkingFrequency.length;
    int i = 0;
    while (i < j)
    {
      WorkingFrequency localWorkingFrequency = arrayOfWorkingFrequency[i];
      if (localWorkingFrequency.value == paramInt) {
        return localWorkingFrequency;
      }
      i += 1;
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\airlink\WorkingFrequency.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */