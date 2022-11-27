package dji.midware.ar.min3d.core;

import dji.midware.ar.min3d.vos.Face;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public class FacesBufferedList
{
  public static final int BYTES_PER_PROPERTY = 2;
  public static final int PROPERTIES_PER_ELEMENT = 3;
  private ShortBuffer _b;
  private int _numElements;
  private boolean _renderSubsetEnabled = false;
  private int _renderSubsetLength = 1;
  private int _renderSubsetStartIndex = 0;
  
  public FacesBufferedList(int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt * 3 * 2);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this._b = localByteBuffer.asShortBuffer();
  }
  
  public FacesBufferedList(ShortBuffer paramShortBuffer, int paramInt)
  {
    Object localObject = ByteBuffer.allocateDirect(paramShortBuffer.limit() * 2);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    localObject = ((ByteBuffer)localObject).asShortBuffer();
    this._b = ((ShortBuffer)localObject);
    ((ShortBuffer)localObject).put(paramShortBuffer);
    this._numElements = paramInt;
  }
  
  public void add(int paramInt1, int paramInt2, int paramInt3)
  {
    add((short)paramInt1, (short)paramInt2, (short)paramInt3);
  }
  
  /* Error */
  public void add(Face arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void add(short arg1, short arg2, short arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore 4
    //   3: goto -3 -> 0
  }
  
  public ShortBuffer buffer()
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
  
  public FacesBufferedList clone()
  {
    return null;
  }
  
  public Face get(int paramInt)
  {
    return null;
  }
  
  public short getPropertyA(int paramInt)
  {
    return 0;
  }
  
  public short getPropertyB(int paramInt)
  {
    return 0;
  }
  
  public float getPropertyC(int paramInt)
  {
    return 0.0F;
  }
  
  /* Error */
  public void putInFace(int arg1, Face arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void renderSubsetEnabled(boolean paramBoolean)
  {
    this._renderSubsetEnabled = paramBoolean;
  }
  
  public boolean renderSubsetEnabled()
  {
    return this._renderSubsetEnabled;
  }
  
  public int renderSubsetLength()
  {
    return this._renderSubsetLength;
  }
  
  public void renderSubsetLength(int paramInt)
  {
    this._renderSubsetLength = paramInt;
  }
  
  public int renderSubsetStartIndex()
  {
    return this._renderSubsetStartIndex;
  }
  
  public void renderSubsetStartIndex(int paramInt)
  {
    this._renderSubsetStartIndex = paramInt;
  }
  
  /* Error */
  public void set(int arg1, Face arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void set(int arg1, short arg2, short arg3, short arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore 5
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
  public void setPropertyC(int arg1, short arg2)
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\core\FacesBufferedList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */