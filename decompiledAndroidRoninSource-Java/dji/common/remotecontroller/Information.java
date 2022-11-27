package dji.common.remotecontroller;

public class Information
{
  private boolean hasGimbalControlPermission;
  private int id;
  private String name;
  private String password;
  private short signalQuality;
  
  private Information(Builder paramBuilder)
  {
    this.id = paramBuilder.id;
    this.name = paramBuilder.name;
    this.password = paramBuilder.password;
    this.signalQuality = paramBuilder.signalQuality;
    this.hasGimbalControlPermission = paramBuilder.hasGimbalControlPermission;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public short getSignalQuality()
  {
    return this.signalQuality;
  }
  
  public boolean hasGimbalControlPermission()
  {
    return this.hasGimbalControlPermission;
  }
  
  public static final class Builder
  {
    private boolean hasGimbalControlPermission;
    private int id;
    private String name;
    private String password;
    private short signalQuality;
    
    public Information build()
    {
      return new Information(this, null);
    }
    
    public Builder hasGimbalControlPermission(boolean paramBoolean)
    {
      this.hasGimbalControlPermission = paramBoolean;
      return this;
    }
    
    public Builder identifier(int paramInt)
    {
      this.id = paramInt;
      return this;
    }
    
    public Builder name(String paramString)
    {
      this.name = paramString;
      return this;
    }
    
    public Builder password(String paramString)
    {
      this.password = paramString;
      return this;
    }
    
    public Builder signalQuality(short paramShort)
    {
      this.signalQuality = paramShort;
      return this;
    }
  }
  
  public static abstract interface ControlRequestCallback
  {
    public abstract void onReceive(Information paramInformation);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\remotecontroller\Information.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */