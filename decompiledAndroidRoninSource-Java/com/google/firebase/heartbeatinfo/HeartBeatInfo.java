package com.google.firebase.heartbeatinfo;

public abstract interface HeartBeatInfo
{
  public abstract HeartBeat getHeartBeatCode(String paramString);
  
  public static enum HeartBeat
  {
    private final int code;
    
    static
    {
      GLOBAL = new HeartBeat("GLOBAL", 2, 2);
      HeartBeat localHeartBeat = new HeartBeat("COMBINED", 3, 3);
      COMBINED = localHeartBeat;
      $VALUES = new HeartBeat[] { NONE, SDK, GLOBAL, localHeartBeat };
    }
    
    private HeartBeat(int paramInt)
    {
      this.code = paramInt;
    }
    
    public int getCode()
    {
      return this.code;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\heartbeatinfo\HeartBeatInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */