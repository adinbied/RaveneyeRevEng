package dji.common.airlink;

public class FrequencyInterference
{
  public float frequencyFrom;
  public float frequencyTo;
  public byte rssi;
  
  public FrequencyInterference(float paramFloat1, float paramFloat2, byte paramByte)
  {
    this.frequencyFrom = paramFloat1;
    this.frequencyTo = paramFloat2;
    this.rssi = paramByte;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\airlink\FrequencyInterference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */