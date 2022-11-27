package dji.midware.ar.min3d.core;

import dji.midware.ar.min3d.vos.Color4;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Color4BufferList
{
  public static final int BYTES_PER_PROPERTY = 1;
  public static final int PROPERTIES_PER_ELEMENT = 4;
  private ByteBuffer _b;
  private int _numElements;
  
  public Color4BufferList(int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt * 4 * 1);
    this._b = localByteBuffer;
    localByteBuffer.order(ByteOrder.nativeOrder());
  }
  
  public Color4BufferList(ByteBuffer paramByteBuffer, int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramByteBuffer.limit() * 1);
    this._b = localByteBuffer;
    localByteBuffer.put(paramByteBuffer);
    this._numElements = paramInt;
  }
  
  /* Error */
  public void add(Color4 arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void add(short arg1, short arg2, short arg3, short arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore 5
    //   3: goto -3 -> 0
  }
  
  public ByteBuffer buffer()
  {
    return this._b;
  }
  
  public int capacity()
  {
    return 0;
  }
  
  public void clear()
  {
    this._b.clear();
  }
  
  public Color4BufferList clone()
  {
    return null;
  }
  
  public Color4 getAsColor4(int paramInt)
  {
    return null;
  }
  
  public float getPropertyA(int paramInt)
  {
    return 0.0F;
  }
  
  public float getPropertyB(int paramInt)
  {
    return 0.0F;
  }
  
  public short getPropertyG(int paramInt)
  {
    return 0;
  }
  
  public short getPropertyR(int paramInt)
  {
    return 0;
  }
  
  /* Error */
  public void putInColor4(int arg1, Color4 arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void set(int arg1, Color4 arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void set(int arg1, short arg2, short arg3, short arg4, short arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore 6
    //   3: goto -3 -> 0
  }
  
  /* Error */
  public void setPropertyA(int arg1, short arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setPropertyB(int arg1, short arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setPropertyG(int arg1, short arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setPropertyR(int arg1, short arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public int size()
  {
    return this._numElements;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\core\Color4BufferList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */