package dji.thirdparty.okio;

final class Segment
{
  static final int SHARE_MINIMUM = 1024;
  static final int SIZE = 8192;
  final byte[] data;
  int limit;
  Segment next;
  boolean owner;
  int pos;
  Segment prev;
  boolean shared;
  
  Segment()
  {
    this.data = new byte[' '];
    this.owner = true;
    this.shared = false;
  }
  
  Segment(Segment paramSegment)
  {
    this(paramSegment.data, paramSegment.pos, paramSegment.limit);
    paramSegment.shared = true;
  }
  
  Segment(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.data = paramArrayOfByte;
    this.pos = paramInt1;
    this.limit = paramInt2;
    this.owner = false;
    this.shared = true;
  }
  
  /* Error */
  public void compact()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public Segment pop()
  {
    return null;
  }
  
  public Segment push(Segment paramSegment)
  {
    return null;
  }
  
  public Segment split(int paramInt)
  {
    return null;
  }
  
  /* Error */
  public void writeTo(Segment arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okio\Segment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */