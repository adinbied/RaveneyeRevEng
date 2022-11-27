package dji.midware.media.opengl.surface;

import java.util.ArrayList;
import java.util.List;

public class CacheContainer
{
  private List<Object> recyleList = new ArrayList();
  private List<Object> usedList = new ArrayList();
  
  public CacheContainer(Object[] paramArrayOfObject)
  {
    int j = paramArrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramArrayOfObject[i];
      this.recyleList.add(localObject);
      i += 1;
    }
  }
  
  public int getSize()
  {
    return this.usedList.size();
  }
  
  public Object obtain()
  {
    return null;
  }
  
  public Object peak()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\opengl\surface\CacheContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */