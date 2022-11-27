package dji.midware.ar.min3d.core;

import dji.midware.ar.min3d.vos.Uv;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class UvBufferList
{
  public static final int BYTES_PER_PROPERTY = 4;
  public static final int PROPERTIES_PER_ELEMENT = 2;
  private FloatBuffer _b;
  private int _numElements = 0;
  
  public UvBufferList(int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt * 2 * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this._b = localByteBuffer.asFloatBuffer();
  }
  
  public UvBufferList(FloatBuffer paramFloatBuffer, int paramInt)
  {
    Object localObject = ByteBuffer.allocateDirect(paramFloatBuffer.limit() * 4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    localObject = ((ByteBuffer)localObject).asFloatBuffer();
    this._b = ((FloatBuffer)localObject);
    ((FloatBuffer)localObject).put(paramFloatBuffer);
    this._numElements = paramInt;
  }
  
  /* Error */
  public void add(float arg1, float arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void add(Uv arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public FloatBuffer buffer()
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
  
  public UvBufferList clone()
  {
    return null;
  }
  
  public Uv getAsUv(int paramInt)
  {
    return null;
  }
  
  public float getPropertyU(int paramInt)
  {
    return 0.0F;
  }
  
  public float getPropertyV(int paramInt)
  {
    return 0.0F;
  }
  
  /* Error */
  public void putInUv(int arg1, Uv arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void set(int arg1, float arg2, float arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore 4
    //   3: goto -3 -> 0
  }
  
  /* Error */
  public void set(int arg1, Uv arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setPropertyU(int arg1, float arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setPropertyV(int arg1, float arg2)
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\core\UvBufferList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */