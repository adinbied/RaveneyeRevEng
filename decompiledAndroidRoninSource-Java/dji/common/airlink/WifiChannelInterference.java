package dji.common.airlink;

public class WifiChannelInterference
{
  private WiFiFrequencyBand band;
  private int channel;
  private int power;
  
  public WifiChannelInterference(WiFiFrequencyBand paramWiFiFrequencyBand, int paramInt1, int paramInt2)
  {
    this.band = paramWiFiFrequencyBand;
    this.power = paramInt1;
    this.channel = paramInt2;
  }
  
  public WiFiFrequencyBand getBand()
  {
    return this.band;
  }
  
  public int getChannel()
  {
    return this.channel;
  }
  
  public int getPower()
  {
    return this.power;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\airlink\WifiChannelInterference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */