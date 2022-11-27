package dji.midware.media.datacontainer;

import java.nio.ByteBuffer;

public class DynamicByteBuffer
{
  private static final String TAG = "DynamicByteBuffer";
  private ByteBuffer buffer;
  private boolean direct;
  private Object lockSync = new Object();
  private Thread lockThread = null;
  private int size = 0;
  
  public DynamicByteBuffer(int paramInt, boolean paramBoolean)
  {
    this.direct = paramBoolean;
    if (paramBoolean)
    {
      this.buffer = ByteBuffer.allocateDirect(paramInt);
      return;
    }
    this.buffer = ByteBuffer.allocate(paramInt);
  }
  
  public int capacity()
  {
    return this.buffer.capacity();
  }
  
  /* Error */
  public void lock()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public ByteBuffer lockAndGetStaticBuffer()
  {
    lock();
    return this.buffer;
  }
  
  public ByteBuffer lockAndReadData()
  {
    lock();
    return this.buffer;
  }
  
  /* Error */
  public void setData(ByteBuffer arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setData(byte[] arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setSize(int paramInt)
  {
    this.size = paramInt;
  }
  
  public int size()
  {
    return this.size;
  }
  
  /* Error */
  public void unLock()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\datacontainer\DynamicByteBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */