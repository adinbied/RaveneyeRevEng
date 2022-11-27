package dji.midware.stat;

public final class LinuxUtils
{
  private static final int FIRST_SYS_CPU_COLUMN_INDEX = 2;
  private static final int IDLE_SYS_CPU_COLUMN_INDEX = 5;
  
  public float getProcessCpuUsage(String paramString1, String paramString2, long paramLong)
  {
    return 0.0F;
  }
  
  public long getProcessIdleTime(String[] paramArrayOfString)
  {
    return 277715137L;
  }
  
  public long getProcessUptime(String[] paramArrayOfString)
  {
    return 277715143L;
  }
  
  public float getSystemCpuUsage(String paramString1, String paramString2)
  {
    return 0.0F;
  }
  
  public long getSystemIdleTime(String[] paramArrayOfString)
  {
    return 277715160L;
  }
  
  public long getSystemUptime(String[] paramArrayOfString)
  {
    return 277715167L;
  }
  
  public String readProcessStat(int paramInt)
  {
    return null;
  }
  
  public String readSystemStat()
  {
    return null;
  }
  
  public float syncGetProcessCpuUsage(int paramInt, long paramLong)
  {
    return 0.0F;
  }
  
  public float syncGetSystemCpuUsage(long paramLong)
  {
    return 0.0F;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\stat\LinuxUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */