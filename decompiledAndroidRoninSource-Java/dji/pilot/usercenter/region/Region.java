package dji.pilot.usercenter.region;

import java.io.Serializable;

public class Region
  implements Serializable
{
  private static final long serialVersionUID = 7680360453111304240L;
  public boolean hasChild = false;
  public String mCode = null;
  protected long mFilePointer = 0L;
  public String mName = null;
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\pilo\\usercenter\region\Region.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */