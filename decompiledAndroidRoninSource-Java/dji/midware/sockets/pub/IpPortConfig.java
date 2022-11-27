package dji.midware.sockets.pub;

public class IpPortConfig
{
  public String ip;
  public int port;
  public ConnectType type = ConnectType.UNKNOWN;
  
  public IpPortConfig(String paramString, int paramInt, ConnectType paramConnectType)
  {
    this.ip = paramString;
    this.port = paramInt;
    this.type = paramConnectType;
  }
  
  public boolean isDrone()
  {
    return false;
  }
  
  public boolean isRc()
  {
    return false;
  }
  
  public static enum ConnectType
  {
    int value;
    
    static
    {
      ConnectType localConnectType = new ConnectType("UNKNOWN", 2, -1);
      UNKNOWN = localConnectType;
      $VALUES = new ConnectType[] { DRONE, RC, localConnectType };
    }
    
    private ConnectType(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\sockets\pub\IpPortConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */