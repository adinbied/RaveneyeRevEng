package dji.midware.data.packages.P3;

import java.util.ArrayList;
import java.util.Iterator;

public class PackBufferObject
{
  private static ArrayList<PackBufferObject> list = new ArrayList();
  private byte[] buffer;
  private boolean isRepeat;
  private volatile boolean isUsing = true;
  
  private PackBufferObject(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 100) {
      i = 100;
    }
    this.buffer = new byte[i];
  }
  
  static PackBufferObject getPackBufferObject(int paramInt)
  {
    try
    {
      Object localObject1 = list.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        PackBufferObject localPackBufferObject = (PackBufferObject)((Iterator)localObject1).next();
        if ((!localPackBufferObject.isUsing) && (localPackBufferObject.getBuffer().length >= paramInt))
        {
          localPackBufferObject.isUsing = true;
          return localPackBufferObject;
        }
      }
      localObject1 = new PackBufferObject(paramInt);
      list.add(localObject1);
      return (PackBufferObject)localObject1;
    }
    finally {}
  }
  
  public byte[] getBuffer()
  {
    return this.buffer;
  }
  
  public void noUsed()
  {
    if (!this.isRepeat) {
      this.isUsing = false;
    }
  }
  
  public void willRepeat(boolean paramBoolean)
  {
    this.isRepeat = paramBoolean;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\packages\P3\PackBufferObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */