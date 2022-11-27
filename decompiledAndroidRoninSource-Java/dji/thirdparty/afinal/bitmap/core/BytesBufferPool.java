package dji.thirdparty.afinal.bitmap.core;

import java.util.ArrayList;

public class BytesBufferPool
{
  private final int mBufferSize;
  private final ArrayList<BytesBuffer> mList;
  private final int mPoolSize;
  
  public BytesBufferPool(int paramInt1, int paramInt2)
  {
    this.mList = new ArrayList(paramInt1);
    this.mPoolSize = paramInt1;
    this.mBufferSize = paramInt2;
  }
  
  /* Error */
  public void clear()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public BytesBuffer get()
  {
    return null;
  }
  
  /* Error */
  public void recycle(BytesBuffer arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public static class BytesBuffer
  {
    public byte[] data;
    public int length;
    public int offset;
    
    private BytesBuffer(int paramInt)
    {
      this.data = new byte[paramInt];
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afinal\bitmap\core\BytesBufferPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */