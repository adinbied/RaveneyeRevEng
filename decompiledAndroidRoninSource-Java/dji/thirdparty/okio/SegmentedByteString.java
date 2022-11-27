package dji.thirdparty.okio;

import java.nio.ByteBuffer;

final class SegmentedByteString
  extends ByteString
{
  final transient int[] directory;
  final transient byte[][] segments;
  
  SegmentedByteString(Buffer paramBuffer, int paramInt)
  {
    super(null);
    Util.checkOffsetAndCount(paramBuffer.size, 0L, paramInt);
    Object localObject = paramBuffer.head;
    int k = 0;
    int j = 0;
    int i = 0;
    while (j < paramInt) {
      if (((Segment)localObject).limit != ((Segment)localObject).pos)
      {
        j += ((Segment)localObject).limit - ((Segment)localObject).pos;
        i += 1;
        localObject = ((Segment)localObject).next;
      }
      else
      {
        throw new AssertionError("s.limit == s.pos");
      }
    }
    this.segments = new byte[i][];
    this.directory = new int[i * 2];
    paramBuffer = paramBuffer.head;
    j = 0;
    i = k;
    while (i < paramInt)
    {
      this.segments[j] = paramBuffer.data;
      k = i + (paramBuffer.limit - paramBuffer.pos);
      i = k;
      if (k > paramInt) {
        i = paramInt;
      }
      localObject = this.directory;
      localObject[j] = i;
      localObject[(this.segments.length + j)] = paramBuffer.pos;
      paramBuffer.shared = true;
      j += 1;
      paramBuffer = paramBuffer.next;
    }
  }
  
  private int segment(int paramInt)
  {
    return 0;
  }
  
  private ByteString toByteString()
  {
    return null;
  }
  
  private Object writeReplace()
  {
    return toByteString();
  }
  
  public ByteBuffer asByteBuffer()
  {
    return null;
  }
  
  public String base64()
  {
    return null;
  }
  
  public String base64Url()
  {
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public byte getByte(int paramInt)
  {
    return 0;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String hex()
  {
    return null;
  }
  
  byte[] internalArray()
  {
    return toByteArray();
  }
  
  public ByteString md5()
  {
    return null;
  }
  
  public boolean rangeEquals(int paramInt1, ByteString paramByteString, int paramInt2, int paramInt3)
  {
    return false;
  }
  
  public boolean rangeEquals(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    return false;
  }
  
  public ByteString sha256()
  {
    return null;
  }
  
  public int size()
  {
    return 0;
  }
  
  public ByteString substring(int paramInt)
  {
    return null;
  }
  
  public ByteString substring(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public ByteString toAsciiLowercase()
  {
    return null;
  }
  
  public ByteString toAsciiUppercase()
  {
    return null;
  }
  
  public byte[] toByteArray()
  {
    return null;
  }
  
  public String toString()
  {
    return null;
  }
  
  public String utf8()
  {
    return null;
  }
  
  /* Error */
  void write(Buffer arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void write(java.io.OutputStream arg1)
    throws java.io.IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okio\SegmentedByteString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */