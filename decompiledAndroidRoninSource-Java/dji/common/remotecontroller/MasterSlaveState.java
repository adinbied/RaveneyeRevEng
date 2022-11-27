package dji.common.remotecontroller;

public class MasterSlaveState
{
  private String authorizationCode;
  private String freqPoint;
  private boolean isConnected;
  private String masterId;
  private RCMode rcMode;
  private String receiveFreq;
  private String rssi;
  private String sendFreq;
  private String slaveId;
  
  private String getFreqPoint()
  {
    return this.freqPoint;
  }
  
  private String getReceiveFreq()
  {
    return this.receiveFreq;
  }
  
  private String getRssi()
  {
    return this.rssi;
  }
  
  private String getSendFreq()
  {
    return this.sendFreq;
  }
  
  public String getAuthorizationCode()
  {
    return this.authorizationCode;
  }
  
  public String getMasterId()
  {
    return this.masterId;
  }
  
  public RCMode getRcMode()
  {
    return this.rcMode;
  }
  
  public String getSlaveId()
  {
    return this.slaveId;
  }
  
  public boolean isConnected()
  {
    return this.isConnected;
  }
  
  public void setAuthorizationCode(String paramString)
  {
    this.authorizationCode = paramString;
  }
  
  public void setFreqPoint(String paramString)
  {
    this.freqPoint = paramString;
  }
  
  public void setIsConnected(boolean paramBoolean)
  {
    this.isConnected = paramBoolean;
  }
  
  public void setMasterId(String paramString)
  {
    this.masterId = paramString;
  }
  
  public void setRcMode(RCMode paramRCMode)
  {
    this.rcMode = paramRCMode;
  }
  
  public void setReceiveFreq(String paramString)
  {
    this.receiveFreq = paramString;
  }
  
  public void setRssi(String paramString)
  {
    this.rssi = paramString;
  }
  
  public void setSendFreq(String paramString)
  {
    this.sendFreq = paramString;
  }
  
  public void setSlaveId(String paramString)
  {
    this.slaveId = paramString;
  }
  
  public static abstract interface Callback
  {
    public abstract void onUpdate(MasterSlaveState paramMasterSlaveState);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\remotecontroller\MasterSlaveState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */