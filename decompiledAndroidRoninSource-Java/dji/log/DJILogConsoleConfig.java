package dji.log;

import android.content.Context;
import dji.log.impl.SimpleConsoleFormat;

public class DJILogConsoleConfig
{
  public IConsoleFormat consoleFormat;
  private int debuggablePriority;
  private int factoryPriority;
  private int innerPriority;
  public boolean open;
  private int releasePriority;
  
  public static class Builder
  {
    DJILogConsoleConfig config = new DJILogConsoleConfig();
    
    public Builder(Context paramContext)
    {
      setOpen(true);
      setDebuggablePriority(2);
      setInnerPriority(3);
      setFactoryPriority(3);
      setReleasePriority(6);
      setConsoleFormat(new SimpleConsoleFormat());
    }
    
    public DJILogConsoleConfig build()
    {
      return this.config;
    }
    
    public Builder setConsoleFormat(IConsoleFormat paramIConsoleFormat)
    {
      this.config.consoleFormat = paramIConsoleFormat;
      return this;
    }
    
    public Builder setDebuggablePriority(int paramInt)
    {
      DJILogConsoleConfig.access$002(this.config, paramInt);
      return this;
    }
    
    public Builder setFactoryPriority(int paramInt)
    {
      DJILogConsoleConfig.access$202(this.config, paramInt);
      return this;
    }
    
    public Builder setInnerPriority(int paramInt)
    {
      DJILogConsoleConfig.access$102(this.config, paramInt);
      return this;
    }
    
    public Builder setOpen(boolean paramBoolean)
    {
      this.config.open = paramBoolean;
      return this;
    }
    
    public Builder setReleasePriority(int paramInt)
    {
      DJILogConsoleConfig.access$302(this.config, paramInt);
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\log\DJILogConsoleConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */