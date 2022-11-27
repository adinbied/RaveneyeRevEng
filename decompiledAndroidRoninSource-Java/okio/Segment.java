package okio;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000*\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\022\n\000\n\002\020\b\n\002\b\002\n\002\020\013\n\002\b\005\n\002\020\002\n\002\b\013\b\000\030\000 \0312\0020\001:\001\031B\007\b\026¢\006\002\020\002B/\b\026\022\006\020\003\032\0020\004\022\006\020\005\032\0020\006\022\006\020\007\032\0020\006\022\006\020\b\032\0020\t\022\006\020\n\032\0020\t¢\006\002\020\013J\006\020\016\032\0020\017J\b\020\020\032\004\030\0010\000J\016\020\021\032\0020\0002\006\020\022\032\0020\000J\006\020\023\032\0020\000J\016\020\024\032\0020\0002\006\020\025\032\0020\006J\006\020\026\032\0020\000J\026\020\027\032\0020\0172\006\020\030\032\0020\0002\006\020\025\032\0020\006R\020\020\003\032\0020\0048\006X\004¢\006\002\n\000R\022\020\007\032\0020\0068\006@\006X\016¢\006\002\n\000R\024\020\f\032\004\030\0010\0008\006@\006X\016¢\006\002\n\000R\022\020\n\032\0020\t8\006@\006X\016¢\006\002\n\000R\022\020\005\032\0020\0068\006@\006X\016¢\006\002\n\000R\024\020\r\032\004\030\0010\0008\006@\006X\016¢\006\002\n\000R\022\020\b\032\0020\t8\006@\006X\016¢\006\002\n\000¨\006\032"}, d2={"Lokio/Segment;", "", "()V", "data", "", "pos", "", "limit", "shared", "", "owner", "([BIIZZ)V", "next", "prev", "compact", "", "pop", "push", "segment", "sharedCopy", "split", "byteCount", "unsharedCopy", "writeTo", "sink", "Companion", "okio"}, k=1, mv={1, 1, 16})
public final class Segment
{
  public static final Companion Companion = new Companion(null);
  public static final int SHARE_MINIMUM = 1024;
  public static final int SIZE = 8192;
  public final byte[] data;
  public int limit;
  public Segment next;
  public boolean owner;
  public int pos;
  public Segment prev;
  public boolean shared;
  
  public Segment()
  {
    this.data = new byte[' '];
    this.owner = true;
    this.shared = false;
  }
  
  public Segment(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.data = paramArrayOfByte;
    this.pos = paramInt1;
    this.limit = paramInt2;
    this.shared = paramBoolean1;
    this.owner = paramBoolean2;
  }
  
  public final void compact()
  {
    Segment localSegment1 = this.prev;
    Segment localSegment2 = (Segment)this;
    int j = 0;
    int i;
    if (localSegment1 != localSegment2) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      localSegment1 = this.prev;
      if (localSegment1 == null) {
        Intrinsics.throwNpe();
      }
      if (!localSegment1.owner) {
        return;
      }
      int k = this.limit - this.pos;
      localSegment1 = this.prev;
      if (localSegment1 == null) {
        Intrinsics.throwNpe();
      }
      int m = localSegment1.limit;
      localSegment1 = this.prev;
      if (localSegment1 == null) {
        Intrinsics.throwNpe();
      }
      if (localSegment1.shared)
      {
        i = j;
      }
      else
      {
        localSegment1 = this.prev;
        if (localSegment1 == null) {
          Intrinsics.throwNpe();
        }
        i = localSegment1.pos;
      }
      if (k > 8192 - m + i) {
        return;
      }
      localSegment1 = this.prev;
      if (localSegment1 == null) {
        Intrinsics.throwNpe();
      }
      writeTo(localSegment1, k);
      pop();
      SegmentPool.INSTANCE.recycle(this);
      return;
    }
    throw ((Throwable)new IllegalStateException("cannot compact".toString()));
  }
  
  public final Segment pop()
  {
    Segment localSegment1 = this.next;
    if (localSegment1 == (Segment)this) {
      localSegment1 = null;
    }
    Segment localSegment2 = this.prev;
    if (localSegment2 == null) {
      Intrinsics.throwNpe();
    }
    localSegment2.next = this.next;
    localSegment2 = this.next;
    if (localSegment2 == null) {
      Intrinsics.throwNpe();
    }
    localSegment2.prev = this.prev;
    localSegment2 = (Segment)null;
    this.next = localSegment2;
    this.prev = localSegment2;
    return localSegment1;
  }
  
  public final Segment push(Segment paramSegment)
  {
    Intrinsics.checkParameterIsNotNull(paramSegment, "segment");
    paramSegment.prev = ((Segment)this);
    paramSegment.next = this.next;
    Segment localSegment = this.next;
    if (localSegment == null) {
      Intrinsics.throwNpe();
    }
    localSegment.prev = paramSegment;
    this.next = paramSegment;
    return paramSegment;
  }
  
  public final Segment sharedCopy()
  {
    this.shared = true;
    return new Segment(this.data, this.pos, this.limit, true, false);
  }
  
  public final Segment split(int paramInt)
  {
    int i;
    if ((paramInt > 0) && (paramInt <= this.limit - this.pos)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      Segment localSegment;
      if (paramInt >= 1024)
      {
        localSegment = sharedCopy();
      }
      else
      {
        localSegment = SegmentPool.INSTANCE.take();
        localObject = this.data;
        byte[] arrayOfByte = localSegment.data;
        i = this.pos;
        ArraysKt.copyInto$default((byte[])localObject, arrayOfByte, 0, i, i + paramInt, 2, null);
      }
      localSegment.limit = (localSegment.pos + paramInt);
      this.pos += paramInt;
      Object localObject = this.prev;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      ((Segment)localObject).push(localSegment);
      return localSegment;
    }
    throw ((Throwable)new IllegalArgumentException("byteCount out of range".toString()));
  }
  
  public final Segment unsharedCopy()
  {
    byte[] arrayOfByte = this.data;
    arrayOfByte = Arrays.copyOf(arrayOfByte, arrayOfByte.length);
    Intrinsics.checkExpressionValueIsNotNull(arrayOfByte, "java.util.Arrays.copyOf(this, size)");
    return new Segment(arrayOfByte, this.pos, this.limit, false, true);
  }
  
  public final void writeTo(Segment paramSegment, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramSegment, "sink");
    if (paramSegment.owner)
    {
      int i = paramSegment.limit;
      if (i + paramInt > 8192) {
        if (!paramSegment.shared)
        {
          j = paramSegment.pos;
          if (i + paramInt - j <= 8192)
          {
            arrayOfByte1 = paramSegment.data;
            ArraysKt.copyInto$default(arrayOfByte1, arrayOfByte1, 0, j, i, 2, null);
            paramSegment.limit -= paramSegment.pos;
            paramSegment.pos = 0;
          }
          else
          {
            throw ((Throwable)new IllegalArgumentException());
          }
        }
        else
        {
          throw ((Throwable)new IllegalArgumentException());
        }
      }
      byte[] arrayOfByte1 = this.data;
      byte[] arrayOfByte2 = paramSegment.data;
      i = paramSegment.limit;
      int j = this.pos;
      ArraysKt.copyInto(arrayOfByte1, arrayOfByte2, i, j, j + paramInt);
      paramSegment.limit += paramInt;
      this.pos += paramInt;
      return;
    }
    throw ((Throwable)new IllegalStateException("only owner can write".toString()));
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\024\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\b\n\002\b\002\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\016\020\003\032\0020\004XT¢\006\002\n\000R\016\020\005\032\0020\004XT¢\006\002\n\000¨\006\006"}, d2={"Lokio/Segment$Companion;", "", "()V", "SHARE_MINIMUM", "", "SIZE", "okio"}, k=1, mv={1, 1, 16})
  public static final class Companion {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okio\Segment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */