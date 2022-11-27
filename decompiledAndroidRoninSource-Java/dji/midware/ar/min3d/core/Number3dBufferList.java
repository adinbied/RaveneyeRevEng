package dji.midware.ar.min3d.core;

import dji.midware.ar.min3d.vos.Number3d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class Number3dBufferList
{
  public static final int BYTES_PER_PROPERTY = 4;
  public static final int PROPERTIES_PER_ELEMENT = 3;
  private FloatBuffer _b;
  private int _numElements = 0;
  
  public Number3dBufferList(int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt * 3 * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this._b = localByteBuffer.asFloatBuffer();
  }
  
  public Number3dBufferList(FloatBuffer paramFloatBuffer, int paramInt)
  {
    Object localObject = ByteBuffer.allocateDirect(paramFloatBuffer.limit() * 4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    localObject = ((ByteBuffer)localObject).asFloatBuffer();
    this._b = ((FloatBuffer)localObject);
    ((FloatBuffer)localObject).put(paramFloatBuffer);
    this._numElements = paramInt;
  }
  
  /* Error */
  public void add(float arg1, float arg2, float arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore 4
    //   3: goto -3 -> 0
  }
  
  /* Error */
  public void add(Number3d arg1)
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
  
  public Number3dBufferList clone()
  {
    return null;
  }
  
  public Number3d getAsNumber3d(int paramInt)
  {
    return null;
  }
  
  public float getPropertyX(int paramInt)
  {
    return 0.0F;
  }
  
  public float getPropertyY(int paramInt)
  {
    return 0.0F;
  }
  
  public float getPropertyZ(int paramInt)
  {
    return 0.0F;
  }
  
  /* Error */
  public void overwrite(float[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void putInNumber3d(int arg1, Number3d arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void set(int arg1, float arg2, float arg3, float arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore 5
    //   3: goto -3 -> 0
  }
  
  /* Error */
  public void set(int arg1, Number3d arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setPropertyX(int arg1, float arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setPropertyY(int arg1, float arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setPropertyZ(int arg1, float arg2)
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\core\Number3dBufferList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */