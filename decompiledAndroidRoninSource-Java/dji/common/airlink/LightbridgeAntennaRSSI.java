package dji.common.airlink;

public class LightbridgeAntennaRSSI
{
  private final int antenna1;
  private final int antenna2;
  
  public LightbridgeAntennaRSSI(int paramInt1, int paramInt2)
  {
    this.antenna1 = paramInt1;
    this.antenna2 = paramInt2;
  }
  
  public int getAntenna1()
  {
    return this.antenna1;
  }
  
  public int getAntenna2()
  {
    return this.antenna2;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\airlink\LightbridgeAntennaRSSI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */