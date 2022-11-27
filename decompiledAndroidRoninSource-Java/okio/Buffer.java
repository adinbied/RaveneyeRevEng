package okio;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import okio.internal.BufferKt;

@Metadata(bv={1, 0, 3}, d1={"\000ª\001\n\002\030\002\n\002\030\002\n\002\030\002\n\002\020\032\n\002\030\002\n\002\b\005\n\002\030\002\n\000\n\002\020\t\n\002\b\005\n\002\020\002\n\002\b\006\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\020\016\n\002\b\003\n\002\020\013\n\000\n\002\020\000\n\002\b\003\n\002\020\005\n\002\b\005\n\002\020\b\n\002\b\r\n\002\030\002\n\002\b\b\n\002\030\002\n\002\020\022\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\017\n\002\020\n\n\002\b\003\n\002\030\002\n\002\b\n\n\002\030\002\n\002\b\007\n\002\030\002\n\002\b\007\n\002\030\002\n\002\b\027\030\0002\0020\0012\0020\0022\0020\0032\0020\004:\002\001B\005¢\006\002\020\005J\b\020\006\032\0020\000H\026J\006\020\021\032\0020\022J\b\020\023\032\0020\000H\026J\b\020\024\032\0020\022H\026J\006\020\025\032\0020\fJ\006\020\026\032\0020\000J$\020\027\032\0020\0002\006\020\030\032\0020\0312\b\b\002\020\032\032\0020\f2\b\b\002\020\033\032\0020\fH\007J\030\020\027\032\0020\0002\006\020\030\032\0020\0002\b\b\002\020\032\032\0020\fJ \020\027\032\0020\0002\006\020\030\032\0020\0002\b\b\002\020\032\032\0020\f2\006\020\033\032\0020\fJ\020\020\034\032\0020\0352\006\020\036\032\0020\037H\002J\b\020 \032\0020\000H\026J\b\020!\032\0020\000H\026J\023\020\"\032\0020#2\b\020$\032\004\030\0010%H\002J\b\020&\032\0020#H\026J\b\020'\032\0020\022H\026J\026\020(\032\0020)2\006\020*\032\0020\fH\002¢\006\002\b+J\025\020+\032\0020)2\006\020,\032\0020\fH\007¢\006\002\b-J\b\020.\032\0020/H\026J\030\0200\032\0020\0352\006\020\036\032\0020\0372\006\0201\032\0020\035H\002J\016\0202\032\0020\0352\006\0201\032\0020\035J\016\0203\032\0020\0352\006\0201\032\0020\035J\016\0204\032\0020\0352\006\0201\032\0020\035J\020\0205\032\0020\f2\006\0206\032\0020)H\026J\030\0205\032\0020\f2\006\0206\032\0020)2\006\0207\032\0020\fH\026J \0205\032\0020\f2\006\0206\032\0020)2\006\0207\032\0020\f2\006\0208\032\0020\fH\026J\020\0205\032\0020\f2\006\0209\032\0020\035H\026J\030\0205\032\0020\f2\006\0209\032\0020\0352\006\0207\032\0020\fH\026J\020\020:\032\0020\f2\006\020;\032\0020\035H\026J\030\020:\032\0020\f2\006\020;\032\0020\0352\006\0207\032\0020\fH\026J\b\020<\032\0020=H\026J\b\020>\032\0020#H\026J\006\020?\032\0020\035J\b\020@\032\0020\031H\026J\b\020A\032\0020\001H\026J\030\020B\032\0020#2\006\020\032\032\0020\f2\006\0209\032\0020\035H\026J(\020B\032\0020#2\006\020\032\032\0020\f2\006\0209\032\0020\0352\006\020C\032\0020/2\006\020\033\032\0020/H\026J\020\020D\032\0020/2\006\020E\032\0020FH\026J\020\020D\032\0020/2\006\020E\032\0020GH\026J \020D\032\0020/2\006\020E\032\0020G2\006\020\032\032\0020/2\006\020\033\032\0020/H\026J\030\020D\032\0020\f2\006\020E\032\0020\0002\006\020\033\032\0020\fH\026J\020\020H\032\0020\f2\006\020E\032\0020IH\026J\022\020J\032\0020K2\b\b\002\020L\032\0020KH\007J\b\020M\032\0020)H\026J\b\020N\032\0020GH\026J\020\020N\032\0020G2\006\020\033\032\0020\fH\026J\b\020O\032\0020\035H\026J\020\020O\032\0020\0352\006\020\033\032\0020\fH\026J\b\020P\032\0020\fH\026J\016\020Q\032\0020\0002\006\020R\032\0020=J\026\020Q\032\0020\0002\006\020R\032\0020=2\006\020\033\032\0020\fJ \020Q\032\0020\0222\006\020R\032\0020=2\006\020\033\032\0020\f2\006\020S\032\0020#H\002J\020\020T\032\0020\0222\006\020E\032\0020GH\026J\030\020T\032\0020\0222\006\020E\032\0020\0002\006\020\033\032\0020\fH\026J\b\020U\032\0020\fH\026J\b\020V\032\0020/H\026J\b\020W\032\0020/H\026J\b\020X\032\0020\fH\026J\b\020Y\032\0020\fH\026J\b\020Z\032\0020[H\026J\b\020\\\032\0020[H\026J\020\020]\032\0020\0372\006\020^\032\0020_H\026J\030\020]\032\0020\0372\006\020\033\032\0020\f2\006\020^\032\0020_H\026J\022\020`\032\0020K2\b\b\002\020L\032\0020KH\007J\b\020a\032\0020\037H\026J\020\020a\032\0020\0372\006\020\033\032\0020\fH\026J\b\020b\032\0020/H\026J\n\020c\032\004\030\0010\037H\026J\b\020d\032\0020\037H\026J\020\020d\032\0020\0372\006\020e\032\0020\fH\026J\020\020f\032\0020#2\006\020\033\032\0020\fH\026J\020\020g\032\0020\0222\006\020\033\032\0020\fH\026J\020\020h\032\0020/2\006\020i\032\0020jH\026J\006\020k\032\0020\035J\006\020l\032\0020\035J\006\020m\032\0020\035J\r\020\r\032\0020\fH\007¢\006\002\bnJ\020\020o\032\0020\0222\006\020\033\032\0020\fH\026J\006\020p\032\0020\035J\016\020p\032\0020\0352\006\020\033\032\0020/J\b\020q\032\0020rH\026J\b\020s\032\0020\037H\026J\025\020t\032\0020\n2\006\020u\032\0020/H\000¢\006\002\bvJ\020\020w\032\0020/2\006\020x\032\0020FH\026J\020\020w\032\0020\0002\006\020x\032\0020GH\026J \020w\032\0020\0002\006\020x\032\0020G2\006\020\032\032\0020/2\006\020\033\032\0020/H\026J\030\020w\032\0020\0222\006\020x\032\0020\0002\006\020\033\032\0020\fH\026J\020\020w\032\0020\0002\006\020y\032\0020\035H\026J \020w\032\0020\0002\006\020y\032\0020\0352\006\020\032\032\0020/2\006\020\033\032\0020/H\026J\030\020w\032\0020\0002\006\020x\032\0020z2\006\020\033\032\0020\fH\026J\020\020{\032\0020\f2\006\020x\032\0020zH\026J\020\020|\032\0020\0002\006\0206\032\0020/H\026J\020\020}\032\0020\0002\006\020~\032\0020\fH\026J\020\020\032\0020\0002\006\020~\032\0020\fH\026J\022\020\001\032\0020\0002\007\020\001\032\0020/H\026J\022\020\001\032\0020\0002\007\020\001\032\0020/H\026J\021\020\001\032\0020\0002\006\020~\032\0020\fH\026J\021\020\001\032\0020\0002\006\020~\032\0020\fH\026J\022\020\001\032\0020\0002\007\020\001\032\0020/H\026J\022\020\001\032\0020\0002\007\020\001\032\0020/H\026J\032\020\001\032\0020\0002\007\020\001\032\0020\0372\006\020^\032\0020_H\026J,\020\001\032\0020\0002\007\020\001\032\0020\0372\007\020\001\032\0020/2\007\020\001\032\0020/2\006\020^\032\0020_H\026J\033\020\001\032\0020\0002\006\020\030\032\0020\0312\b\b\002\020\033\032\0020\fH\007J\022\020\001\032\0020\0002\007\020\001\032\0020\037H\026J$\020\001\032\0020\0002\007\020\001\032\0020\0372\007\020\001\032\0020/2\007\020\001\032\0020/H\026J\022\020\001\032\0020\0002\007\020\001\032\0020/H\026R\024\020\006\032\0020\0008VX\004¢\006\006\032\004\b\007\020\bR\024\020\t\032\004\030\0010\n8\000@\000X\016¢\006\002\n\000R&\020\r\032\0020\f2\006\020\013\032\0020\f8G@@X\016¢\006\016\n\000\032\004\b\r\020\016\"\004\b\017\020\020¨\006\001"}, d2={"Lokio/Buffer;", "Lokio/BufferedSource;", "Lokio/BufferedSink;", "", "Ljava/nio/channels/ByteChannel;", "()V", "buffer", "getBuffer", "()Lokio/Buffer;", "head", "Lokio/Segment;", "<set-?>", "", "size", "()J", "setSize$okio", "(J)V", "clear", "", "clone", "close", "completeSegmentByteCount", "copy", "copyTo", "out", "Ljava/io/OutputStream;", "offset", "byteCount", "digest", "Lokio/ByteString;", "algorithm", "", "emit", "emitCompleteSegments", "equals", "", "other", "", "exhausted", "flush", "get", "", "pos", "getByte", "index", "-deprecated_getByte", "hashCode", "", "hmac", "key", "hmacSha1", "hmacSha256", "hmacSha512", "indexOf", "b", "fromIndex", "toIndex", "bytes", "indexOfElement", "targetBytes", "inputStream", "Ljava/io/InputStream;", "isOpen", "md5", "outputStream", "peek", "rangeEquals", "bytesOffset", "read", "sink", "Ljava/nio/ByteBuffer;", "", "readAll", "Lokio/Sink;", "readAndWriteUnsafe", "Lokio/Buffer$UnsafeCursor;", "unsafeCursor", "readByte", "readByteArray", "readByteString", "readDecimalLong", "readFrom", "input", "forever", "readFully", "readHexadecimalUnsignedLong", "readInt", "readIntLe", "readLong", "readLongLe", "readShort", "", "readShortLe", "readString", "charset", "Ljava/nio/charset/Charset;", "readUnsafe", "readUtf8", "readUtf8CodePoint", "readUtf8Line", "readUtf8LineStrict", "limit", "request", "require", "select", "options", "Lokio/Options;", "sha1", "sha256", "sha512", "-deprecated_size", "skip", "snapshot", "timeout", "Lokio/Timeout;", "toString", "writableSegment", "minimumCapacity", "writableSegment$okio", "write", "source", "byteString", "Lokio/Source;", "writeAll", "writeByte", "writeDecimalLong", "v", "writeHexadecimalUnsignedLong", "writeInt", "i", "writeIntLe", "writeLong", "writeLongLe", "writeShort", "s", "writeShortLe", "writeString", "string", "beginIndex", "endIndex", "writeTo", "writeUtf8", "writeUtf8CodePoint", "codePoint", "UnsafeCursor", "okio"}, k=1, mv={1, 1, 16})
public final class Buffer
  implements BufferedSource, BufferedSink, Cloneable, ByteChannel
{
  public Segment head;
  private long size;
  
  private final ByteString digest(String paramString)
  {
    MessageDigest localMessageDigest = MessageDigest.getInstance(paramString);
    Segment localSegment2 = this.head;
    if (localSegment2 != null)
    {
      localMessageDigest.update(localSegment2.data, localSegment2.pos, localSegment2.limit - localSegment2.pos);
      Segment localSegment1 = localSegment2.next;
      paramString = localSegment1;
      if (localSegment1 == null)
      {
        Intrinsics.throwNpe();
        paramString = localSegment1;
      }
      while (paramString != localSegment2)
      {
        localMessageDigest.update(paramString.data, paramString.pos, paramString.limit - paramString.pos);
        localSegment1 = paramString.next;
        paramString = localSegment1;
        if (localSegment1 == null)
        {
          Intrinsics.throwNpe();
          paramString = localSegment1;
        }
      }
    }
    paramString = localMessageDigest.digest();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "messageDigest.digest()");
    return new ByteString(paramString);
  }
  
  private final ByteString hmac(String paramString, ByteString paramByteString)
  {
    try
    {
      Mac localMac = Mac.getInstance(paramString);
      localMac.init((Key)new SecretKeySpec(paramByteString.internalArray$okio(), paramString));
      Segment localSegment = this.head;
      if (localSegment != null)
      {
        localMac.update(localSegment.data, localSegment.pos, localSegment.limit - localSegment.pos);
        paramByteString = localSegment.next;
        paramString = paramByteString;
        if (paramByteString == null)
        {
          Intrinsics.throwNpe();
          paramString = paramByteString;
        }
        while (paramString != localSegment)
        {
          localMac.update(paramString.data, paramString.pos, paramString.limit - paramString.pos);
          paramByteString = paramString.next;
          paramString = paramByteString;
          if (paramByteString == null)
          {
            Intrinsics.throwNpe();
            paramString = paramByteString;
          }
        }
      }
      paramString = localMac.doFinal();
      Intrinsics.checkExpressionValueIsNotNull(paramString, "mac.doFinal()");
      paramString = new ByteString(paramString);
      return paramString;
    }
    catch (InvalidKeyException paramString)
    {
      throw ((Throwable)new IllegalArgumentException((Throwable)paramString));
    }
  }
  
  private final void readFrom(InputStream paramInputStream, long paramLong, boolean paramBoolean)
    throws IOException
  {
    for (;;)
    {
      if ((paramLong <= 0L) && (!paramBoolean)) {
        return;
      }
      Segment localSegment = writableSegment$okio(1);
      int i = (int)Math.min(paramLong, 8192 - localSegment.limit);
      i = paramInputStream.read(localSegment.data, localSegment.limit, i);
      if (i == -1)
      {
        if (localSegment.pos == localSegment.limit)
        {
          this.head = localSegment.pop();
          SegmentPool.INSTANCE.recycle(localSegment);
        }
        if (paramBoolean) {
          return;
        }
        throw ((Throwable)new EOFException());
      }
      localSegment.limit += i;
      long l1 = this.size;
      long l2 = i;
      this.size = (l1 + l2);
      paramLong -= l2;
    }
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to operator function", replaceWith=@ReplaceWith(expression="this[index]", imports={}))
  public final byte -deprecated_getByte(long paramLong)
  {
    return getByte(paramLong);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="size", imports={}))
  public final long -deprecated_size()
  {
    return this.size;
  }
  
  public Buffer buffer()
  {
    return this;
  }
  
  public final void clear()
  {
    skip(size());
  }
  
  public Buffer clone()
  {
    return copy();
  }
  
  public void close() {}
  
  public final long completeSegmentByteCount()
  {
    long l2 = size();
    if (l2 == 0L) {
      return 0L;
    }
    Segment localSegment = this.head;
    if (localSegment == null) {
      Intrinsics.throwNpe();
    }
    localSegment = localSegment.prev;
    if (localSegment == null) {
      Intrinsics.throwNpe();
    }
    long l1 = l2;
    if (localSegment.limit < 8192)
    {
      l1 = l2;
      if (localSegment.owner) {
        l1 = l2 - (localSegment.limit - localSegment.pos);
      }
    }
    return l1;
  }
  
  public final Buffer copy()
  {
    Buffer localBuffer = new Buffer();
    if (size() == 0L) {
      return localBuffer;
    }
    Segment localSegment2 = this.head;
    if (localSegment2 == null) {
      Intrinsics.throwNpe();
    }
    Segment localSegment3 = localSegment2.sharedCopy();
    localBuffer.head = localSegment3;
    localSegment3.prev = localSegment3;
    localSegment3.next = localSegment3.prev;
    for (Segment localSegment1 = localSegment2.next; localSegment1 != localSegment2; localSegment1 = localSegment1.next)
    {
      Segment localSegment4 = localSegment3.prev;
      if (localSegment4 == null) {
        Intrinsics.throwNpe();
      }
      if (localSegment1 == null) {
        Intrinsics.throwNpe();
      }
      localSegment4.push(localSegment1.sharedCopy());
    }
    localBuffer.setSize$okio(size());
    return localBuffer;
  }
  
  public final Buffer copyTo(OutputStream paramOutputStream)
    throws IOException
  {
    return copyTo$default(this, paramOutputStream, 0L, 0L, 6, null);
  }
  
  public final Buffer copyTo(OutputStream paramOutputStream, long paramLong)
    throws IOException
  {
    return copyTo$default(this, paramOutputStream, paramLong, 0L, 4, null);
  }
  
  public final Buffer copyTo(OutputStream paramOutputStream, long paramLong1, long paramLong2)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramOutputStream, "out");
    -Util.checkOffsetAndCount(this.size, paramLong1, paramLong2);
    if (paramLong2 == 0L) {
      return this;
    }
    Segment localSegment2;
    long l1;
    long l2;
    for (Segment localSegment1 = this.head;; localSegment1 = localSegment1.next)
    {
      if (localSegment1 == null) {
        Intrinsics.throwNpe();
      }
      localSegment2 = localSegment1;
      l1 = paramLong1;
      l2 = paramLong2;
      if (paramLong1 < localSegment1.limit - localSegment1.pos) {
        break;
      }
      paramLong1 -= localSegment1.limit - localSegment1.pos;
    }
    while (l2 > 0L)
    {
      if (localSegment2 == null) {
        Intrinsics.throwNpe();
      }
      int i = (int)(localSegment2.pos + l1);
      int j = (int)Math.min(localSegment2.limit - i, l2);
      paramOutputStream.write(localSegment2.data, i, j);
      l2 -= j;
      localSegment2 = localSegment2.next;
      l1 = 0L;
    }
    return this;
  }
  
  public final Buffer copyTo(Buffer paramBuffer, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "out");
    return copyTo(paramBuffer, paramLong, this.size - paramLong);
  }
  
  public final Buffer copyTo(Buffer paramBuffer, long paramLong1, long paramLong2)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "out");
    -Util.checkOffsetAndCount(size(), paramLong1, paramLong2);
    if (paramLong2 == 0L) {
      return this;
    }
    paramBuffer.setSize$okio(paramBuffer.size() + paramLong2);
    Segment localSegment2;
    long l1;
    long l2;
    for (Segment localSegment1 = this.head;; localSegment1 = localSegment1.next)
    {
      if (localSegment1 == null) {
        Intrinsics.throwNpe();
      }
      localSegment2 = localSegment1;
      l1 = paramLong1;
      l2 = paramLong2;
      if (paramLong1 < localSegment1.limit - localSegment1.pos) {
        break;
      }
      paramLong1 -= localSegment1.limit - localSegment1.pos;
    }
    while (l2 > 0L)
    {
      if (localSegment2 == null) {
        Intrinsics.throwNpe();
      }
      localSegment1 = localSegment2.sharedCopy();
      localSegment1.pos += (int)l1;
      localSegment1.limit = Math.min(localSegment1.pos + (int)l2, localSegment1.limit);
      Segment localSegment3 = paramBuffer.head;
      if (localSegment3 == null)
      {
        localSegment1.prev = localSegment1;
        localSegment1.next = localSegment1.prev;
        paramBuffer.head = localSegment1.next;
      }
      else
      {
        if (localSegment3 == null) {
          Intrinsics.throwNpe();
        }
        localSegment3 = localSegment3.prev;
        if (localSegment3 == null) {
          Intrinsics.throwNpe();
        }
        localSegment3.push(localSegment1);
      }
      l2 -= localSegment1.limit - localSegment1.pos;
      localSegment2 = localSegment2.next;
      l1 = 0L;
    }
    return this;
  }
  
  public Buffer emit()
  {
    return this;
  }
  
  public Buffer emitCompleteSegments()
  {
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    for (;;)
    {
      return true;
      if (!(paramObject instanceof Buffer)) {
        return false;
      }
      long l1 = size();
      paramObject = (Buffer)paramObject;
      if (l1 != ((Buffer)paramObject).size()) {
        return false;
      }
      if (size() != 0L)
      {
        Object localObject2 = this.head;
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        paramObject = ((Buffer)paramObject).head;
        if (paramObject == null) {
          Intrinsics.throwNpe();
        }
        int j = ((Segment)localObject2).pos;
        int i = ((Segment)paramObject).pos;
        l1 = 0L;
        while (l1 < size())
        {
          long l3 = Math.min(((Segment)localObject2).limit - j, ((Segment)paramObject).limit - i);
          long l2 = 0L;
          int k = j;
          while (l2 < l3)
          {
            if (localObject2.data[k] != paramObject.data[i]) {
              return false;
            }
            l2 += 1L;
            k += 1;
            i += 1;
          }
          Object localObject1 = localObject2;
          j = k;
          if (k == ((Segment)localObject2).limit)
          {
            localObject1 = ((Segment)localObject2).next;
            if (localObject1 == null) {
              Intrinsics.throwNpe();
            }
            j = ((Segment)localObject1).pos;
          }
          localObject2 = paramObject;
          k = i;
          if (i == ((Segment)paramObject).limit)
          {
            localObject2 = ((Segment)paramObject).next;
            if (localObject2 == null) {
              Intrinsics.throwNpe();
            }
            k = ((Segment)localObject2).pos;
          }
          l1 += l3;
          paramObject = localObject2;
          localObject2 = localObject1;
          i = k;
        }
      }
    }
  }
  
  public boolean exhausted()
  {
    return this.size == 0L;
  }
  
  public void flush() {}
  
  public Buffer getBuffer()
  {
    return this;
  }
  
  public final byte getByte(long paramLong)
  {
    -Util.checkOffsetAndCount(size(), paramLong, 1L);
    Segment localSegment = this.head;
    if (localSegment != null)
    {
      if (size() - paramLong < paramLong)
      {
        for (l1 = size(); l1 > paramLong; l1 -= localSegment.limit - localSegment.pos)
        {
          localSegment = localSegment.prev;
          if (localSegment == null) {
            Intrinsics.throwNpe();
          }
        }
        if (localSegment == null) {
          Intrinsics.throwNpe();
        }
        return localSegment.data[((int)(localSegment.pos + paramLong - l1))];
      }
      long l2;
      for (long l1 = 0L;; l1 = l2)
      {
        l2 = localSegment.limit - localSegment.pos + l1;
        if (l2 > paramLong)
        {
          if (localSegment == null) {
            Intrinsics.throwNpe();
          }
          return localSegment.data[((int)(localSegment.pos + paramLong - l1))];
        }
        localSegment = localSegment.next;
        if (localSegment == null) {
          Intrinsics.throwNpe();
        }
      }
    }
    localSegment = (Segment)null;
    Intrinsics.throwNpe();
    return localSegment.data[((int)(localSegment.pos + paramLong + 1L))];
  }
  
  public int hashCode()
  {
    Object localObject = this.head;
    if (localObject != null)
    {
      int i = 1;
      int j;
      Segment localSegment;
      do
      {
        int k = ((Segment)localObject).pos;
        int m = ((Segment)localObject).limit;
        j = i;
        while (k < m)
        {
          j = j * 31 + localObject.data[k];
          k += 1;
        }
        localSegment = ((Segment)localObject).next;
        if (localSegment == null) {
          Intrinsics.throwNpe();
        }
        localObject = localSegment;
        i = j;
      } while (localSegment != this.head);
      return j;
    }
    return 0;
  }
  
  public final ByteString hmacSha1(ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "key");
    return hmac("HmacSHA1", paramByteString);
  }
  
  public final ByteString hmacSha256(ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "key");
    return hmac("HmacSHA256", paramByteString);
  }
  
  public final ByteString hmacSha512(ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "key");
    return hmac("HmacSHA512", paramByteString);
  }
  
  public long indexOf(byte paramByte)
  {
    return indexOf(paramByte, 0L, Long.MAX_VALUE);
  }
  
  public long indexOf(byte paramByte, long paramLong)
  {
    return indexOf(paramByte, paramLong, Long.MAX_VALUE);
  }
  
  public long indexOf(byte paramByte, long paramLong1, long paramLong2)
  {
    long l2 = 0L;
    int i;
    if ((0L <= paramLong1) && (paramLong2 >= paramLong1)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      long l1 = paramLong2;
      if (paramLong2 > size()) {
        l1 = size();
      }
      if (paramLong1 == l1) {
        return -1L;
      }
      Object localObject2 = this.head;
      if (localObject2 != null)
      {
        paramLong2 = l2;
        localObject1 = localObject2;
        int j;
        if (size() - paramLong1 < paramLong1)
        {
          paramLong2 = size();
          localObject1 = localObject2;
          while (paramLong2 > paramLong1)
          {
            localObject1 = ((Segment)localObject1).prev;
            if (localObject1 == null) {
              Intrinsics.throwNpe();
            }
            paramLong2 -= ((Segment)localObject1).limit - ((Segment)localObject1).pos;
          }
          if (localObject1 != null) {
            while (paramLong2 < l1)
            {
              localObject2 = ((Segment)localObject1).data;
              j = (int)Math.min(((Segment)localObject1).limit, ((Segment)localObject1).pos + l1 - paramLong2);
              i = (int)(((Segment)localObject1).pos + paramLong1 - paramLong2);
              while (i < j)
              {
                if (localObject2[i] == paramByte) {
                  return i - ((Segment)localObject1).pos + paramLong2;
                }
                i += 1;
              }
              paramLong2 += ((Segment)localObject1).limit - ((Segment)localObject1).pos;
              localObject1 = ((Segment)localObject1).next;
              if (localObject1 == null) {
                Intrinsics.throwNpe();
              }
              paramLong1 = paramLong2;
            }
          }
        }
        else
        {
          for (;;)
          {
            l2 = ((Segment)localObject1).limit - ((Segment)localObject1).pos + paramLong2;
            if (l2 > paramLong1)
            {
              if (localObject1 == null) {
                break label456;
              }
              for (;;)
              {
                if (paramLong2 >= l1) {
                  break label456;
                }
                localObject2 = ((Segment)localObject1).data;
                j = (int)Math.min(((Segment)localObject1).limit, ((Segment)localObject1).pos + l1 - paramLong2);
                i = (int)(((Segment)localObject1).pos + paramLong1 - paramLong2);
                for (;;)
                {
                  if (i >= j) {
                    break label390;
                  }
                  if (localObject2[i] == paramByte) {
                    break;
                  }
                  i += 1;
                }
                label390:
                paramLong2 += ((Segment)localObject1).limit - ((Segment)localObject1).pos;
                localObject1 = ((Segment)localObject1).next;
                if (localObject1 == null) {
                  Intrinsics.throwNpe();
                }
                paramLong1 = paramLong2;
              }
            }
            localObject1 = ((Segment)localObject1).next;
            if (localObject1 == null) {
              Intrinsics.throwNpe();
            }
            paramLong2 = l2;
          }
        }
      }
      else
      {
        localObject1 = (Segment)null;
      }
      label456:
      return -1L;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("size=");
    ((StringBuilder)localObject1).append(size());
    ((StringBuilder)localObject1).append(" fromIndex=");
    ((StringBuilder)localObject1).append(paramLong1);
    ((StringBuilder)localObject1).append(" toIndex=");
    ((StringBuilder)localObject1).append(paramLong2);
    throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject1).toString().toString()));
  }
  
  public long indexOf(ByteString paramByteString)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "bytes");
    return indexOf(paramByteString, 0L);
  }
  
  public long indexOf(ByteString paramByteString, long paramLong)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "bytes");
    int i;
    if (paramByteString.size() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      long l1 = 0L;
      if (paramLong >= 0L) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        Object localObject2 = this.head;
        if (localObject2 != null)
        {
          Object localObject1 = localObject2;
          int j;
          int k;
          long l2;
          long l3;
          int m;
          if (size() - paramLong < paramLong)
          {
            l1 = size();
            localObject1 = localObject2;
            while (l1 > paramLong)
            {
              localObject1 = ((Segment)localObject1).prev;
              if (localObject1 == null) {
                Intrinsics.throwNpe();
              }
              l1 -= ((Segment)localObject1).limit - ((Segment)localObject1).pos;
            }
            if (localObject1 != null)
            {
              localObject2 = paramByteString.internalArray$okio();
              j = localObject2[0];
              k = paramByteString.size();
              l2 = size() - k + 1L;
              while (l1 < l2)
              {
                paramByteString = ((Segment)localObject1).data;
                i = ((Segment)localObject1).limit;
                l3 = ((Segment)localObject1).pos;
                m = (int)Math.min(i, l3 + l2 - l1);
                i = (int)(((Segment)localObject1).pos + paramLong - l1);
                while (i < m)
                {
                  if ((paramByteString[i] == j) && (BufferKt.rangeEquals((Segment)localObject1, i + 1, (byte[])localObject2, 1, k))) {
                    return i - ((Segment)localObject1).pos + l1;
                  }
                  i += 1;
                }
                l1 += ((Segment)localObject1).limit - ((Segment)localObject1).pos;
                localObject1 = ((Segment)localObject1).next;
                if (localObject1 == null) {
                  Intrinsics.throwNpe();
                }
                paramLong = l1;
              }
            }
          }
          else
          {
            for (;;)
            {
              l2 = ((Segment)localObject1).limit - ((Segment)localObject1).pos + l1;
              if (l2 > paramLong)
              {
                if (localObject1 == null) {
                  break;
                }
                localObject2 = paramByteString.internalArray$okio();
                j = localObject2[0];
                k = paramByteString.size();
                l2 = size() - k + 1L;
                while (l1 < l2)
                {
                  paramByteString = ((Segment)localObject1).data;
                  i = ((Segment)localObject1).limit;
                  l3 = ((Segment)localObject1).pos;
                  m = (int)Math.min(i, l3 + l2 - l1);
                  i = (int)(((Segment)localObject1).pos + paramLong - l1);
                  while (i < m)
                  {
                    if ((paramByteString[i] == j) && (BufferKt.rangeEquals((Segment)localObject1, i + 1, (byte[])localObject2, 1, k))) {
                      return i - ((Segment)localObject1).pos + l1;
                    }
                    i += 1;
                  }
                  l1 += ((Segment)localObject1).limit - ((Segment)localObject1).pos;
                  localObject1 = ((Segment)localObject1).next;
                  if (localObject1 == null) {
                    Intrinsics.throwNpe();
                  }
                  paramLong = l1;
                }
              }
              localObject1 = ((Segment)localObject1).next;
              if (localObject1 == null) {
                Intrinsics.throwNpe();
              }
              l1 = l2;
            }
          }
        }
        else
        {
          paramByteString = (Segment)null;
        }
        return -1L;
      }
      paramByteString = new StringBuilder();
      paramByteString.append("fromIndex < 0: ");
      paramByteString.append(paramLong);
      throw ((Throwable)new IllegalArgumentException(paramByteString.toString().toString()));
    }
    throw ((Throwable)new IllegalArgumentException("bytes is empty".toString()));
  }
  
  public long indexOfElement(ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "targetBytes");
    return indexOfElement(paramByteString, 0L);
  }
  
  public long indexOfElement(ByteString paramByteString, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "targetBytes");
    long l1 = 0L;
    int i;
    if (paramLong >= 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      Object localObject2 = this.head;
      if (localObject2 != null)
      {
        Object localObject1 = localObject2;
        int k;
        int m;
        int j;
        int n;
        int i1;
        if (size() - paramLong < paramLong)
        {
          l1 = size();
          localObject1 = localObject2;
          while (l1 > paramLong)
          {
            localObject1 = ((Segment)localObject1).prev;
            if (localObject1 == null) {
              Intrinsics.throwNpe();
            }
            l1 -= ((Segment)localObject1).limit - ((Segment)localObject1).pos;
          }
          if (localObject1 != null)
          {
            if (paramByteString.size() == 2)
            {
              k = paramByteString.getByte(0);
              m = paramByteString.getByte(1);
              while (l1 < size())
              {
                localObject2 = ((Segment)localObject1).data;
                j = (int)(((Segment)localObject1).pos + paramLong - l1);
                n = ((Segment)localObject1).limit;
                while (j < n)
                {
                  i1 = localObject2[j];
                  paramLong = l1;
                  paramByteString = (ByteString)localObject1;
                  i = j;
                  if (i1 != k) {
                    if (i1 == m)
                    {
                      paramLong = l1;
                      paramByteString = (ByteString)localObject1;
                      i = j;
                    }
                    else
                    {
                      j += 1;
                      continue;
                    }
                  }
                  j = paramByteString.pos;
                  return i - j + paramLong;
                }
                l1 += ((Segment)localObject1).limit - ((Segment)localObject1).pos;
                localObject1 = ((Segment)localObject1).next;
                if (localObject1 == null) {
                  Intrinsics.throwNpe();
                }
                paramLong = l1;
              }
            }
            paramByteString = paramByteString.internalArray$okio();
            for (;;)
            {
              if (l1 >= size()) {
                break label788;
              }
              localObject2 = ((Segment)localObject1).data;
              i = (int)(((Segment)localObject1).pos + paramLong - l1);
              k = ((Segment)localObject1).limit;
              for (;;)
              {
                if (i >= k) {
                  break label397;
                }
                m = localObject2[i];
                n = paramByteString.length;
                j = 0;
                for (;;)
                {
                  if (j >= n) {
                    break label388;
                  }
                  if (m == paramByteString[j])
                  {
                    j = ((Segment)localObject1).pos;
                    paramLong = l1;
                    break;
                  }
                  j += 1;
                }
                label388:
                i += 1;
              }
              label397:
              l1 += ((Segment)localObject1).limit - ((Segment)localObject1).pos;
              localObject1 = ((Segment)localObject1).next;
              if (localObject1 == null) {
                Intrinsics.throwNpe();
              }
              paramLong = l1;
            }
          }
        }
        else
        {
          for (;;)
          {
            long l2 = ((Segment)localObject1).limit - ((Segment)localObject1).pos + l1;
            if (l2 > paramLong)
            {
              if (localObject1 == null) {
                break label788;
              }
              if (paramByteString.size() == 2)
              {
                k = paramByteString.getByte(0);
                m = paramByteString.getByte(1);
                for (;;)
                {
                  if (l1 >= size()) {
                    break label788;
                  }
                  localObject2 = ((Segment)localObject1).data;
                  j = (int)(((Segment)localObject1).pos + paramLong - l1);
                  n = ((Segment)localObject1).limit;
                  for (;;)
                  {
                    if (j >= n) {
                      break label584;
                    }
                    i1 = localObject2[j];
                    paramLong = l1;
                    paramByteString = (ByteString)localObject1;
                    i = j;
                    if (i1 == k) {
                      break;
                    }
                    if (i1 == m)
                    {
                      paramLong = l1;
                      paramByteString = (ByteString)localObject1;
                      i = j;
                      break;
                    }
                    j += 1;
                  }
                  label584:
                  l1 += ((Segment)localObject1).limit - ((Segment)localObject1).pos;
                  localObject1 = ((Segment)localObject1).next;
                  if (localObject1 == null) {
                    Intrinsics.throwNpe();
                  }
                  paramLong = l1;
                }
              }
              paramByteString = paramByteString.internalArray$okio();
              for (;;)
              {
                if (l1 >= size()) {
                  break label788;
                }
                localObject2 = ((Segment)localObject1).data;
                i = (int)(((Segment)localObject1).pos + paramLong - l1);
                k = ((Segment)localObject1).limit;
                for (;;)
                {
                  if (i >= k) {
                    break label723;
                  }
                  m = localObject2[i];
                  n = paramByteString.length;
                  j = 0;
                  for (;;)
                  {
                    if (j >= n) {
                      break label714;
                    }
                    if (m == paramByteString[j]) {
                      break;
                    }
                    j += 1;
                  }
                  label714:
                  i += 1;
                }
                label723:
                l1 += ((Segment)localObject1).limit - ((Segment)localObject1).pos;
                localObject1 = ((Segment)localObject1).next;
                if (localObject1 == null) {
                  Intrinsics.throwNpe();
                }
                paramLong = l1;
              }
            }
            localObject1 = ((Segment)localObject1).next;
            if (localObject1 == null) {
              Intrinsics.throwNpe();
            }
            l1 = l2;
          }
        }
      }
      else
      {
        paramByteString = (Segment)null;
      }
      label788:
      return -1L;
    }
    paramByteString = new StringBuilder();
    paramByteString.append("fromIndex < 0: ");
    paramByteString.append(paramLong);
    throw ((Throwable)new IllegalArgumentException(paramByteString.toString().toString()));
  }
  
  public InputStream inputStream()
  {
    (InputStream)new InputStream()
    {
      public int available()
      {
        return (int)Math.min(this.this$0.size(), Integer.MAX_VALUE);
      }
      
      public void close() {}
      
      public int read()
      {
        if (this.this$0.size() > 0L) {
          return this.this$0.readByte() & 0xFF;
        }
        return -1;
      }
      
      public int read(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        Intrinsics.checkParameterIsNotNull(paramAnonymousArrayOfByte, "sink");
        return this.this$0.read(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.this$0);
        localStringBuilder.append(".inputStream()");
        return localStringBuilder.toString();
      }
    };
  }
  
  public boolean isOpen()
  {
    return true;
  }
  
  public final ByteString md5()
  {
    return digest("MD5");
  }
  
  public OutputStream outputStream()
  {
    (OutputStream)new OutputStream()
    {
      public void close() {}
      
      public void flush() {}
      
      public String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.this$0);
        localStringBuilder.append(".outputStream()");
        return localStringBuilder.toString();
      }
      
      public void write(int paramAnonymousInt)
      {
        this.this$0.writeByte(paramAnonymousInt);
      }
      
      public void write(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        Intrinsics.checkParameterIsNotNull(paramAnonymousArrayOfByte, "data");
        this.this$0.write(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
      }
    };
  }
  
  public BufferedSource peek()
  {
    return Okio.buffer((Source)new PeekSource((BufferedSource)this));
  }
  
  public boolean rangeEquals(long paramLong, ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "bytes");
    return rangeEquals(paramLong, paramByteString, 0, paramByteString.size());
  }
  
  public boolean rangeEquals(long paramLong, ByteString paramByteString, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "bytes");
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramLong >= 0L)
    {
      bool1 = bool2;
      if (paramInt1 >= 0)
      {
        bool1 = bool2;
        if (paramInt2 >= 0)
        {
          bool1 = bool2;
          if (size() - paramLong >= paramInt2)
          {
            if (paramByteString.size() - paramInt1 < paramInt2) {
              return false;
            }
            int i = 0;
            while (i < paramInt2)
            {
              if (getByte(i + paramLong) != paramByteString.getByte(paramInt1 + i)) {
                return false;
              }
              i += 1;
            }
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public int read(ByteBuffer paramByteBuffer)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramByteBuffer, "sink");
    Segment localSegment = this.head;
    if (localSegment != null)
    {
      int i = Math.min(paramByteBuffer.remaining(), localSegment.limit - localSegment.pos);
      paramByteBuffer.put(localSegment.data, localSegment.pos, i);
      localSegment.pos += i;
      this.size -= i;
      if (localSegment.pos == localSegment.limit)
      {
        this.head = localSegment.pop();
        SegmentPool.INSTANCE.recycle(localSegment);
      }
      return i;
    }
    return -1;
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "sink");
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "sink");
    -Util.checkOffsetAndCount(paramArrayOfByte.length, paramInt1, paramInt2);
    Segment localSegment = this.head;
    if (localSegment != null)
    {
      paramInt2 = Math.min(paramInt2, localSegment.limit - localSegment.pos);
      ArraysKt.copyInto(localSegment.data, paramArrayOfByte, paramInt1, localSegment.pos, localSegment.pos + paramInt2);
      localSegment.pos += paramInt2;
      setSize$okio(size() - paramInt2);
      paramInt1 = paramInt2;
      if (localSegment.pos == localSegment.limit)
      {
        this.head = localSegment.pop();
        SegmentPool.INSTANCE.recycle(localSegment);
        return paramInt2;
      }
    }
    else
    {
      paramInt1 = -1;
    }
    return paramInt1;
  }
  
  public long read(Buffer paramBuffer, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "sink");
    int i;
    if (paramLong >= 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (size() == 0L) {
        return -1L;
      }
      long l = paramLong;
      if (paramLong > size()) {
        l = size();
      }
      paramBuffer.write(this, l);
      return l;
    }
    paramBuffer = new StringBuilder();
    paramBuffer.append("byteCount < 0: ");
    paramBuffer.append(paramLong);
    throw ((Throwable)new IllegalArgumentException(paramBuffer.toString().toString()));
  }
  
  public long readAll(Sink paramSink)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramSink, "sink");
    long l = size();
    if (l > 0L) {
      paramSink.write(this, l);
    }
    return l;
  }
  
  public final UnsafeCursor readAndWriteUnsafe()
  {
    return readAndWriteUnsafe$default(this, null, 1, null);
  }
  
  public final UnsafeCursor readAndWriteUnsafe(UnsafeCursor paramUnsafeCursor)
  {
    Intrinsics.checkParameterIsNotNull(paramUnsafeCursor, "unsafeCursor");
    int i;
    if (paramUnsafeCursor.buffer == null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      paramUnsafeCursor.buffer = ((Buffer)this);
      paramUnsafeCursor.readWrite = true;
      return paramUnsafeCursor;
    }
    throw ((Throwable)new IllegalStateException("already attached to a buffer".toString()));
  }
  
  public byte readByte()
    throws EOFException
  {
    if (size() != 0L)
    {
      Segment localSegment = this.head;
      if (localSegment == null) {
        Intrinsics.throwNpe();
      }
      int i = localSegment.pos;
      int j = localSegment.limit;
      byte[] arrayOfByte = localSegment.data;
      int k = i + 1;
      byte b = arrayOfByte[i];
      setSize$okio(size() - 1L);
      if (k == j)
      {
        this.head = localSegment.pop();
        SegmentPool.INSTANCE.recycle(localSegment);
        return b;
      }
      localSegment.pos = k;
      return b;
    }
    throw ((Throwable)new EOFException());
  }
  
  public byte[] readByteArray()
  {
    return readByteArray(size());
  }
  
  public byte[] readByteArray(long paramLong)
    throws EOFException
  {
    int i;
    if ((paramLong >= 0L) && (paramLong <= Integer.MAX_VALUE)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (size() >= paramLong)
      {
        localObject = new byte[(int)paramLong];
        readFully((byte[])localObject);
        return (byte[])localObject;
      }
      throw ((Throwable)new EOFException());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("byteCount: ");
    ((StringBuilder)localObject).append(paramLong);
    throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString().toString()));
  }
  
  public ByteString readByteString()
  {
    return readByteString(size());
  }
  
  public ByteString readByteString(long paramLong)
    throws EOFException
  {
    int i;
    if ((paramLong >= 0L) && (paramLong <= Integer.MAX_VALUE)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (size() >= paramLong)
      {
        if (paramLong >= 'က')
        {
          localObject = snapshot((int)paramLong);
          skip(paramLong);
          return (ByteString)localObject;
        }
        return new ByteString(readByteArray(paramLong));
      }
      throw ((Throwable)new EOFException());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("byteCount: ");
    ((StringBuilder)localObject).append(paramLong);
    throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString().toString()));
  }
  
  public long readDecimalLong()
    throws EOFException
  {
    long l1 = size();
    long l2 = 0L;
    if (l1 != 0L)
    {
      long l3 = -7L;
      boolean bool2 = false;
      int i1 = 0;
      int j = 0;
      int m;
      int k;
      label268:
      do
      {
        Object localObject1 = this.head;
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        Object localObject2 = ((Segment)localObject1).data;
        int n = ((Segment)localObject1).pos;
        int i2 = ((Segment)localObject1).limit;
        m = i1;
        boolean bool1 = bool2;
        l1 = l2;
        l2 = l3;
        while (n < i2)
        {
          int i = localObject2[n];
          i1 = (byte)48;
          if ((i >= i1) && (i <= (byte)57))
          {
            i1 -= i;
            bool2 = l1 < -922337203685477580L;
            if ((!bool2) && ((bool2) || (i1 >= l2)))
            {
              l1 = l1 * 10L + i1;
            }
            else
            {
              localObject1 = new Buffer().writeDecimalLong(l1).writeByte(i);
              if (m == 0) {
                ((Buffer)localObject1).readByte();
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("Number too large: ");
              ((StringBuilder)localObject2).append(((Buffer)localObject1).readUtf8());
              throw ((Throwable)new NumberFormatException(((StringBuilder)localObject2).toString()));
            }
          }
          else
          {
            if ((i != (byte)45) || (bool1)) {
              break label268;
            }
            l2 -= 1L;
            m = 1;
          }
          n += 1;
          bool1 += true;
          continue;
          if (k != 0)
          {
            j = 1;
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("Expected leading [0-9] or '-' character but was 0x");
            ((StringBuilder)localObject1).append(-Util.toHexString(i));
            throw ((Throwable)new NumberFormatException(((StringBuilder)localObject1).toString()));
          }
        }
        if (n == i2)
        {
          this.head = ((Segment)localObject1).pop();
          SegmentPool.INSTANCE.recycle((Segment)localObject1);
        }
        else
        {
          ((Segment)localObject1).pos = n;
        }
        if (j != 0) {
          break;
        }
        l3 = l2;
        l2 = l1;
        bool2 = k;
        i1 = m;
      } while (this.head != null);
      setSize$okio(size() - k);
      if (m != 0) {
        return l1;
      }
      return -l1;
    }
    throw ((Throwable)new EOFException());
  }
  
  public final Buffer readFrom(InputStream paramInputStream)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramInputStream, "input");
    readFrom(paramInputStream, Long.MAX_VALUE, true);
    return this;
  }
  
  public final Buffer readFrom(InputStream paramInputStream, long paramLong)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramInputStream, "input");
    int i;
    if (paramLong >= 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      readFrom(paramInputStream, paramLong, false);
      return this;
    }
    paramInputStream = new StringBuilder();
    paramInputStream.append("byteCount < 0: ");
    paramInputStream.append(paramLong);
    throw ((Throwable)new IllegalArgumentException(paramInputStream.toString().toString()));
  }
  
  public void readFully(Buffer paramBuffer, long paramLong)
    throws EOFException
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "sink");
    if (size() >= paramLong)
    {
      paramBuffer.write(this, paramLong);
      return;
    }
    paramBuffer.write(this, size());
    throw ((Throwable)new EOFException());
  }
  
  public void readFully(byte[] paramArrayOfByte)
    throws EOFException
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "sink");
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = read(paramArrayOfByte, i, paramArrayOfByte.length - i);
      if (j != -1) {
        i += j;
      } else {
        throw ((Throwable)new EOFException());
      }
    }
  }
  
  public long readHexadecimalUnsignedLong()
    throws EOFException
  {
    if (size() != 0L)
    {
      int n = 0;
      long l1 = 0L;
      int j = 0;
      long l2;
      int k;
      label250:
      label304:
      do
      {
        Object localObject1 = this.head;
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        Object localObject2 = ((Segment)localObject1).data;
        int m = ((Segment)localObject1).pos;
        int i2 = ((Segment)localObject1).limit;
        l2 = l1;
        k = n;
        int i1;
        int i;
        for (;;)
        {
          i1 = j;
          if (m >= i2) {
            break label304;
          }
          i = localObject2[m];
          n = (byte)48;
          if ((i >= n) && (i <= (byte)57))
          {
            n = i - n;
          }
          else
          {
            n = (byte)97;
            if ((i >= n) && (i <= (byte)102)) {}
            for (;;)
            {
              n = i - n + 10;
              break;
              n = (byte)65;
              if ((i < n) || (i > (byte)70)) {
                break label250;
              }
            }
          }
          if ((0xF000000000000000 & l2) != 0L) {
            break;
          }
          l2 = l2 << 4 | n;
          m += 1;
          k += 1;
        }
        localObject1 = new Buffer().writeHexadecimalUnsignedLong(l2).writeByte(i);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Number too large: ");
        ((StringBuilder)localObject2).append(((Buffer)localObject1).readUtf8());
        throw ((Throwable)new NumberFormatException(((StringBuilder)localObject2).toString()));
        if (k != 0)
        {
          i1 = 1;
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Expected leading [0-9a-fA-F] character but was 0x");
          ((StringBuilder)localObject1).append(-Util.toHexString(i));
          throw ((Throwable)new NumberFormatException(((StringBuilder)localObject1).toString()));
        }
        if (m == i2)
        {
          this.head = ((Segment)localObject1).pop();
          SegmentPool.INSTANCE.recycle((Segment)localObject1);
        }
        else
        {
          ((Segment)localObject1).pos = m;
        }
        if (i1 != 0) {
          break;
        }
        n = k;
        j = i1;
        l1 = l2;
      } while (this.head != null);
      setSize$okio(size() - k);
      return l2;
    }
    throw ((Throwable)new EOFException());
  }
  
  public int readInt()
    throws EOFException
  {
    if (size() >= 4L)
    {
      Segment localSegment = this.head;
      if (localSegment == null) {
        Intrinsics.throwNpe();
      }
      int j = localSegment.pos;
      int i = localSegment.limit;
      if (i - j < 4L) {
        return (readByte() & 0xFF) << 24 | (readByte() & 0xFF) << 16 | (readByte() & 0xFF) << 8 | readByte() & 0xFF;
      }
      byte[] arrayOfByte = localSegment.data;
      int k = j + 1;
      j = arrayOfByte[j];
      int n = k + 1;
      k = arrayOfByte[k];
      int m = n + 1;
      n = arrayOfByte[n];
      int i1 = m + 1;
      m = arrayOfByte[m];
      setSize$okio(size() - 4L);
      if (i1 == i)
      {
        this.head = localSegment.pop();
        SegmentPool.INSTANCE.recycle(localSegment);
      }
      else
      {
        localSegment.pos = i1;
      }
      return (j & 0xFF) << 24 | (k & 0xFF) << 16 | (n & 0xFF) << 8 | m & 0xFF;
    }
    throw ((Throwable)new EOFException());
  }
  
  public int readIntLe()
    throws EOFException
  {
    return -Util.reverseBytes(readInt());
  }
  
  public long readLong()
    throws EOFException
  {
    if (size() >= 8L)
    {
      Segment localSegment = this.head;
      if (localSegment == null) {
        Intrinsics.throwNpe();
      }
      int k = localSegment.pos;
      int i = localSegment.limit;
      if (i - k < 8L) {
        return (readInt() & 0xFFFFFFFF) << 32 | 0xFFFFFFFF & readInt();
      }
      byte[] arrayOfByte = localSegment.data;
      int j = k + 1;
      long l1 = arrayOfByte[k];
      k = j + 1;
      long l2 = arrayOfByte[j];
      j = k + 1;
      long l3 = arrayOfByte[k];
      k = j + 1;
      long l4 = arrayOfByte[j];
      j = k + 1;
      long l5 = arrayOfByte[k];
      k = j + 1;
      long l6 = arrayOfByte[j];
      j = k + 1;
      long l7 = arrayOfByte[k];
      k = j + 1;
      long l8 = arrayOfByte[j];
      setSize$okio(size() - 8L);
      if (k == i)
      {
        this.head = localSegment.pop();
        SegmentPool.INSTANCE.recycle(localSegment);
      }
      else
      {
        localSegment.pos = k;
      }
      return (l4 & 0xFF) << 32 | (l1 & 0xFF) << 56 | (l2 & 0xFF) << 48 | (l3 & 0xFF) << 40 | (l5 & 0xFF) << 24 | (l6 & 0xFF) << 16 | (l7 & 0xFF) << 8 | l8 & 0xFF;
    }
    throw ((Throwable)new EOFException());
  }
  
  public long readLongLe()
    throws EOFException
  {
    return -Util.reverseBytes(readLong());
  }
  
  public short readShort()
    throws EOFException
  {
    if (size() >= 2L)
    {
      Segment localSegment = this.head;
      if (localSegment == null) {
        Intrinsics.throwNpe();
      }
      int k = localSegment.pos;
      int i = localSegment.limit;
      if (i - k < 2) {
        return (short)((readByte() & 0xFF) << 8 | readByte() & 0xFF);
      }
      byte[] arrayOfByte = localSegment.data;
      int j = k + 1;
      k = arrayOfByte[k];
      int m = j + 1;
      j = arrayOfByte[j];
      setSize$okio(size() - 2L);
      if (m == i)
      {
        this.head = localSegment.pop();
        SegmentPool.INSTANCE.recycle(localSegment);
      }
      else
      {
        localSegment.pos = m;
      }
      return (short)((k & 0xFF) << 8 | j & 0xFF);
    }
    throw ((Throwable)new EOFException());
  }
  
  public short readShortLe()
    throws EOFException
  {
    return -Util.reverseBytes(readShort());
  }
  
  public String readString(long paramLong, Charset paramCharset)
    throws EOFException
  {
    Intrinsics.checkParameterIsNotNull(paramCharset, "charset");
    boolean bool = paramLong < 0L;
    int i;
    if ((!bool) && (paramLong <= Integer.MAX_VALUE)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (this.size >= paramLong)
      {
        if (!bool) {
          return "";
        }
        Segment localSegment = this.head;
        if (localSegment == null) {
          Intrinsics.throwNpe();
        }
        if (localSegment.pos + paramLong > localSegment.limit) {
          return new String(readByteArray(paramLong), paramCharset);
        }
        byte[] arrayOfByte = localSegment.data;
        i = localSegment.pos;
        int j = (int)paramLong;
        paramCharset = new String(arrayOfByte, i, j, paramCharset);
        localSegment.pos += j;
        this.size -= paramLong;
        if (localSegment.pos == localSegment.limit)
        {
          this.head = localSegment.pop();
          SegmentPool.INSTANCE.recycle(localSegment);
        }
        return paramCharset;
      }
      throw ((Throwable)new EOFException());
    }
    paramCharset = new StringBuilder();
    paramCharset.append("byteCount: ");
    paramCharset.append(paramLong);
    throw ((Throwable)new IllegalArgumentException(paramCharset.toString().toString()));
  }
  
  public String readString(Charset paramCharset)
  {
    Intrinsics.checkParameterIsNotNull(paramCharset, "charset");
    return readString(this.size, paramCharset);
  }
  
  public final UnsafeCursor readUnsafe()
  {
    return readUnsafe$default(this, null, 1, null);
  }
  
  public final UnsafeCursor readUnsafe(UnsafeCursor paramUnsafeCursor)
  {
    Intrinsics.checkParameterIsNotNull(paramUnsafeCursor, "unsafeCursor");
    int i;
    if (paramUnsafeCursor.buffer == null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      paramUnsafeCursor.buffer = ((Buffer)this);
      paramUnsafeCursor.readWrite = false;
      return paramUnsafeCursor;
    }
    throw ((Throwable)new IllegalStateException("already attached to a buffer".toString()));
  }
  
  public String readUtf8()
  {
    return readString(this.size, Charsets.UTF_8);
  }
  
  public String readUtf8(long paramLong)
    throws EOFException
  {
    return readString(paramLong, Charsets.UTF_8);
  }
  
  public int readUtf8CodePoint()
    throws EOFException
  {
    if (size() != 0L)
    {
      int i = getByte(0L);
      int n = 1;
      int j;
      int k;
      int m;
      if ((i & 0x80) == 0)
      {
        j = i & 0x7F;
        k = 1;
        m = 0;
      }
      else if ((i & 0xE0) == 192)
      {
        j = i & 0x1F;
        k = 2;
        m = 128;
      }
      else if ((i & 0xF0) == 224)
      {
        j = i & 0xF;
        k = 3;
        m = 2048;
      }
      else
      {
        if ((i & 0xF8) != 240) {
          break label330;
        }
        j = i & 0x7;
        k = 4;
        m = 65536;
      }
      long l2 = size();
      long l1 = k;
      if (l2 >= l1)
      {
        while (n < k)
        {
          l2 = n;
          int i1 = getByte(l2);
          if ((i1 & 0xC0) == 128)
          {
            j = j << 6 | i1 & 0x3F;
            n += 1;
          }
          else
          {
            skip(l2);
            return 65533;
          }
        }
        skip(l1);
        if (j > 1114111) {
          return 65533;
        }
        if ((55296 <= j) && (57343 >= j)) {
          return 65533;
        }
        if (j < m) {
          return 65533;
        }
        return j;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("size < ");
      localStringBuilder.append(k);
      localStringBuilder.append(": ");
      localStringBuilder.append(size());
      localStringBuilder.append(" (to read code point prefixed 0x");
      localStringBuilder.append(-Util.toHexString(i));
      localStringBuilder.append(')');
      throw ((Throwable)new EOFException(localStringBuilder.toString()));
      label330:
      skip(1L);
      return 65533;
    }
    throw ((Throwable)new EOFException());
  }
  
  public String readUtf8Line()
    throws EOFException
  {
    long l = indexOf((byte)10);
    if (l != -1L) {
      return BufferKt.readUtf8Line(this, l);
    }
    if (size() != 0L) {
      return readUtf8(size());
    }
    return null;
  }
  
  public String readUtf8LineStrict()
    throws EOFException
  {
    return readUtf8LineStrict(Long.MAX_VALUE);
  }
  
  public String readUtf8LineStrict(long paramLong)
    throws EOFException
  {
    int i;
    if (paramLong >= 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      long l1 = Long.MAX_VALUE;
      if (paramLong != Long.MAX_VALUE) {
        l1 = paramLong + 1L;
      }
      byte b = (byte)10;
      long l2 = indexOf(b, 0L, l1);
      if (l2 != -1L) {
        return BufferKt.readUtf8Line(this, l2);
      }
      if ((l1 < size()) && (getByte(l1 - 1L) == (byte)13) && (getByte(l1) == b)) {
        return BufferKt.readUtf8Line(this, l1);
      }
      localObject = new Buffer();
      l1 = size();
      copyTo((Buffer)localObject, 0L, Math.min(32, l1));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("\\n not found: limit=");
      localStringBuilder.append(Math.min(size(), paramLong));
      localStringBuilder.append(" content=");
      localStringBuilder.append(((Buffer)localObject).readByteString().hex());
      localStringBuilder.append('…');
      throw ((Throwable)new EOFException(localStringBuilder.toString()));
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("limit < 0: ");
    ((StringBuilder)localObject).append(paramLong);
    throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString().toString()));
  }
  
  public boolean request(long paramLong)
  {
    return this.size >= paramLong;
  }
  
  public void require(long paramLong)
    throws EOFException
  {
    if (this.size >= paramLong) {
      return;
    }
    throw ((Throwable)new EOFException());
  }
  
  public int select(Options paramOptions)
  {
    Intrinsics.checkParameterIsNotNull(paramOptions, "options");
    int i = BufferKt.selectPrefix$default(this, paramOptions, false, 2, null);
    if (i == -1) {
      return -1;
    }
    skip(paramOptions.getByteStrings$okio()[i].size());
    return i;
  }
  
  public final void setSize$okio(long paramLong)
  {
    this.size = paramLong;
  }
  
  public final ByteString sha1()
  {
    return digest("SHA-1");
  }
  
  public final ByteString sha256()
  {
    return digest("SHA-256");
  }
  
  public final ByteString sha512()
  {
    return digest("SHA-512");
  }
  
  public final long size()
  {
    return this.size;
  }
  
  public void skip(long paramLong)
    throws EOFException
  {
    while (paramLong > 0L)
    {
      Segment localSegment = this.head;
      if (localSegment != null)
      {
        int i = (int)Math.min(paramLong, localSegment.limit - localSegment.pos);
        long l1 = size();
        long l2 = i;
        setSize$okio(l1 - l2);
        l1 = paramLong - l2;
        localSegment.pos += i;
        paramLong = l1;
        if (localSegment.pos == localSegment.limit)
        {
          this.head = localSegment.pop();
          SegmentPool.INSTANCE.recycle(localSegment);
          paramLong = l1;
        }
      }
      else
      {
        throw ((Throwable)new EOFException());
      }
    }
  }
  
  public final ByteString snapshot()
  {
    int i;
    if (size() <= Integer.MAX_VALUE) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return snapshot((int)size());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("size > Int.MAX_VALUE: ");
    localStringBuilder.append(size());
    throw ((Throwable)new IllegalStateException(localStringBuilder.toString().toString()));
  }
  
  public final ByteString snapshot(int paramInt)
  {
    if (paramInt == 0) {
      return ByteString.EMPTY;
    }
    -Util.checkOffsetAndCount(size(), 0L, paramInt);
    Segment localSegment = this.head;
    int k = 0;
    int j = 0;
    int i = 0;
    while (j < paramInt)
    {
      if (localSegment == null) {
        Intrinsics.throwNpe();
      }
      if (localSegment.limit != localSegment.pos)
      {
        j += localSegment.limit - localSegment.pos;
        i += 1;
        localSegment = localSegment.next;
      }
      else
      {
        throw ((Throwable)new AssertionError("s.limit == s.pos"));
      }
    }
    byte[][] arrayOfByte = new byte[i][];
    int[] arrayOfInt = new int[i * 2];
    localSegment = this.head;
    i = 0;
    j = k;
    while (j < paramInt)
    {
      if (localSegment == null) {
        Intrinsics.throwNpe();
      }
      arrayOfByte[i] = localSegment.data;
      j += localSegment.limit - localSegment.pos;
      arrayOfInt[i] = Math.min(j, paramInt);
      arrayOfInt[(((Object[])arrayOfByte).length + i)] = localSegment.pos;
      localSegment.shared = true;
      i += 1;
      localSegment = localSegment.next;
    }
    return (ByteString)new SegmentedByteString((byte[][])arrayOfByte, arrayOfInt);
  }
  
  public Timeout timeout()
  {
    return Timeout.NONE;
  }
  
  public String toString()
  {
    return snapshot().toString();
  }
  
  public final Segment writableSegment$okio(int paramInt)
  {
    int i = 1;
    if ((paramInt < 1) || (paramInt > 8192)) {
      i = 0;
    }
    if (i != 0)
    {
      Segment localSegment = this.head;
      if (localSegment == null)
      {
        localSegment = SegmentPool.INSTANCE.take();
        this.head = localSegment;
        localSegment.prev = localSegment;
        localSegment.next = localSegment;
        return localSegment;
      }
      if (localSegment == null) {
        Intrinsics.throwNpe();
      }
      localSegment = localSegment.prev;
      if (localSegment == null) {
        Intrinsics.throwNpe();
      }
      if ((localSegment.limit + paramInt <= 8192) && (localSegment.owner)) {
        return localSegment;
      }
      return localSegment.push(SegmentPool.INSTANCE.take());
    }
    throw ((Throwable)new IllegalArgumentException("unexpected capacity".toString()));
  }
  
  public int write(ByteBuffer paramByteBuffer)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramByteBuffer, "source");
    int j = paramByteBuffer.remaining();
    int i = j;
    while (i > 0)
    {
      Segment localSegment = writableSegment$okio(1);
      int k = Math.min(i, 8192 - localSegment.limit);
      paramByteBuffer.get(localSegment.data, localSegment.limit, k);
      i -= k;
      localSegment.limit += k;
    }
    this.size += j;
    return j;
  }
  
  public Buffer write(ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "byteString");
    paramByteString.write$okio(this, 0, paramByteString.size());
    return this;
  }
  
  public Buffer write(ByteString paramByteString, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "byteString");
    paramByteString.write$okio(this, paramInt1, paramInt2);
    return this;
  }
  
  public Buffer write(Source paramSource, long paramLong)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramSource, "source");
    while (paramLong > 0L)
    {
      long l = paramSource.read(this, paramLong);
      if (l != -1L) {
        paramLong -= l;
      } else {
        throw ((Throwable)new EOFException());
      }
    }
    return this;
  }
  
  public Buffer write(byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "source");
    return write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public Buffer write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "source");
    long l1 = paramArrayOfByte.length;
    long l2 = paramInt1;
    long l3 = paramInt2;
    -Util.checkOffsetAndCount(l1, l2, l3);
    int i = paramInt2 + paramInt1;
    while (paramInt1 < i)
    {
      Segment localSegment = writableSegment$okio(1);
      int j = Math.min(i - paramInt1, 8192 - localSegment.limit);
      byte[] arrayOfByte = localSegment.data;
      int k = localSegment.limit;
      paramInt2 = paramInt1 + j;
      ArraysKt.copyInto(paramArrayOfByte, arrayOfByte, k, paramInt1, paramInt2);
      localSegment.limit += j;
      paramInt1 = paramInt2;
    }
    setSize$okio(size() + l3);
    return this;
  }
  
  public void write(Buffer paramBuffer, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "source");
    int i;
    if (paramBuffer != this) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      -Util.checkOffsetAndCount(paramBuffer.size(), 0L, paramLong);
      while (paramLong > 0L)
      {
        Segment localSegment1 = paramBuffer.head;
        if (localSegment1 == null) {
          Intrinsics.throwNpe();
        }
        i = localSegment1.limit;
        localSegment1 = paramBuffer.head;
        if (localSegment1 == null) {
          Intrinsics.throwNpe();
        }
        if (paramLong < i - localSegment1.pos)
        {
          localSegment1 = this.head;
          if (localSegment1 != null)
          {
            if (localSegment1 == null) {
              Intrinsics.throwNpe();
            }
            localSegment1 = localSegment1.prev;
          }
          else
          {
            localSegment1 = null;
          }
          if ((localSegment1 != null) && (localSegment1.owner))
          {
            l = localSegment1.limit;
            if (localSegment1.shared) {
              i = 0;
            } else {
              i = localSegment1.pos;
            }
            if (l + paramLong - i <= ' ')
            {
              localSegment2 = paramBuffer.head;
              if (localSegment2 == null) {
                Intrinsics.throwNpe();
              }
              localSegment2.writeTo(localSegment1, (int)paramLong);
              paramBuffer.setSize$okio(paramBuffer.size() - paramLong);
              setSize$okio(size() + paramLong);
              return;
            }
          }
          localSegment1 = paramBuffer.head;
          if (localSegment1 == null) {
            Intrinsics.throwNpe();
          }
          paramBuffer.head = localSegment1.split((int)paramLong);
        }
        localSegment1 = paramBuffer.head;
        if (localSegment1 == null) {
          Intrinsics.throwNpe();
        }
        long l = localSegment1.limit - localSegment1.pos;
        paramBuffer.head = localSegment1.pop();
        Segment localSegment2 = this.head;
        if (localSegment2 == null)
        {
          this.head = localSegment1;
          localSegment1.prev = localSegment1;
          localSegment1.next = localSegment1.prev;
        }
        else
        {
          if (localSegment2 == null) {
            Intrinsics.throwNpe();
          }
          localSegment2 = localSegment2.prev;
          if (localSegment2 == null) {
            Intrinsics.throwNpe();
          }
          localSegment2.push(localSegment1).compact();
        }
        paramBuffer.setSize$okio(paramBuffer.size() - l);
        setSize$okio(size() + l);
        paramLong -= l;
      }
      return;
    }
    throw ((Throwable)new IllegalArgumentException("source == this".toString()));
  }
  
  public long writeAll(Source paramSource)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramSource, "source");
    long l2;
    for (long l1 = 0L;; l1 += l2)
    {
      l2 = paramSource.read(this, ' ');
      if (l2 == -1L) {
        return l1;
      }
    }
  }
  
  public Buffer writeByte(int paramInt)
  {
    Segment localSegment = writableSegment$okio(1);
    byte[] arrayOfByte = localSegment.data;
    int i = localSegment.limit;
    localSegment.limit = (i + 1);
    arrayOfByte[i] = ((byte)paramInt);
    setSize$okio(size() + 1L);
    return this;
  }
  
  public Buffer writeDecimalLong(long paramLong)
  {
    boolean bool = paramLong < 0L;
    if (!bool) {
      return writeByte(48);
    }
    int j = 0;
    int i = 1;
    long l = paramLong;
    if (bool)
    {
      l = -paramLong;
      if (l < 0L) {
        return writeUtf8("-9223372036854775808");
      }
      j = 1;
    }
    if (l < 100000000L)
    {
      if (l < 10000L)
      {
        if (l < 100L)
        {
          if (l >= 10L) {
            i = 2;
          }
        }
        else if (l < 1000L) {
          i = 3;
        } else {
          i = 4;
        }
      }
      else if (l < 1000000L)
      {
        if (l < 100000L) {
          i = 5;
        } else {
          i = 6;
        }
      }
      else if (l < 10000000L) {
        i = 7;
      } else {
        i = 8;
      }
    }
    else if (l < 1000000000000L)
    {
      if (l < 10000000000L)
      {
        if (l < 1000000000L) {
          i = 9;
        } else {
          i = 10;
        }
      }
      else if (l < 100000000000L) {
        i = 11;
      } else {
        i = 12;
      }
    }
    else if (l < 1000000000000000L)
    {
      if (l < 10000000000000L) {
        i = 13;
      } else if (l < 100000000000000L) {
        i = 14;
      } else {
        i = 15;
      }
    }
    else if (l < 100000000000000000L)
    {
      if (l < 10000000000000000L) {
        i = 16;
      } else {
        i = 17;
      }
    }
    else if (l < 1000000000000000000L) {
      i = 18;
    } else {
      i = 19;
    }
    bool = i;
    int k;
    if (j != 0) {
      k = i + 1;
    }
    Segment localSegment = writableSegment$okio(k);
    byte[] arrayOfByte = localSegment.data;
    i = localSegment.limit + k;
    while (l != 0L)
    {
      paramLong = 10;
      int m = (int)(l % paramLong);
      i -= 1;
      arrayOfByte[i] = BufferKt.getHEX_DIGIT_BYTES()[m];
      l /= paramLong;
    }
    if (j != 0) {
      arrayOfByte[(i - 1)] = ((byte)45);
    }
    localSegment.limit += k;
    setSize$okio(size() + k);
    return this;
  }
  
  public Buffer writeHexadecimalUnsignedLong(long paramLong)
  {
    if (paramLong == 0L) {
      return writeByte(48);
    }
    long l = paramLong >>> 1 | paramLong;
    l |= l >>> 2;
    l |= l >>> 4;
    l |= l >>> 8;
    l |= l >>> 16;
    l |= l >>> 32;
    l -= (l >>> 1 & 0x5555555555555555);
    l = (l >>> 2 & 0x3333333333333333) + (l & 0x3333333333333333);
    l = (l >>> 4) + l & 0xF0F0F0F0F0F0F0F;
    l += (l >>> 8);
    l += (l >>> 16);
    int j = (int)(((l & 0x3F) + (l >>> 32 & 0x3F) + 3) / 4);
    Segment localSegment = writableSegment$okio(j);
    byte[] arrayOfByte = localSegment.data;
    int i = localSegment.limit + j - 1;
    int k = localSegment.limit;
    while (i >= k)
    {
      arrayOfByte[i] = BufferKt.getHEX_DIGIT_BYTES()[((int)(0xF & paramLong))];
      paramLong >>>= 4;
      i -= 1;
    }
    localSegment.limit += j;
    setSize$okio(size() + j);
    return this;
  }
  
  public Buffer writeInt(int paramInt)
  {
    Segment localSegment = writableSegment$okio(4);
    byte[] arrayOfByte = localSegment.data;
    int j = localSegment.limit;
    int i = j + 1;
    arrayOfByte[j] = ((byte)(paramInt >>> 24 & 0xFF));
    j = i + 1;
    arrayOfByte[i] = ((byte)(paramInt >>> 16 & 0xFF));
    i = j + 1;
    arrayOfByte[j] = ((byte)(paramInt >>> 8 & 0xFF));
    arrayOfByte[i] = ((byte)(paramInt & 0xFF));
    localSegment.limit = (i + 1);
    setSize$okio(size() + 4L);
    return this;
  }
  
  public Buffer writeIntLe(int paramInt)
  {
    return writeInt(-Util.reverseBytes(paramInt));
  }
  
  public Buffer writeLong(long paramLong)
  {
    Segment localSegment = writableSegment$okio(8);
    byte[] arrayOfByte = localSegment.data;
    int j = localSegment.limit;
    int i = j + 1;
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 56 & 0xFF));
    j = i + 1;
    arrayOfByte[i] = ((byte)(int)(paramLong >>> 48 & 0xFF));
    i = j + 1;
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 40 & 0xFF));
    j = i + 1;
    arrayOfByte[i] = ((byte)(int)(paramLong >>> 32 & 0xFF));
    i = j + 1;
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 24 & 0xFF));
    j = i + 1;
    arrayOfByte[i] = ((byte)(int)(paramLong >>> 16 & 0xFF));
    i = j + 1;
    arrayOfByte[j] = ((byte)(int)(paramLong >>> 8 & 0xFF));
    arrayOfByte[i] = ((byte)(int)(paramLong & 0xFF));
    localSegment.limit = (i + 1);
    setSize$okio(size() + 8L);
    return this;
  }
  
  public Buffer writeLongLe(long paramLong)
  {
    return writeLong(-Util.reverseBytes(paramLong));
  }
  
  public Buffer writeShort(int paramInt)
  {
    Segment localSegment = writableSegment$okio(2);
    byte[] arrayOfByte = localSegment.data;
    int i = localSegment.limit;
    int j = i + 1;
    arrayOfByte[i] = ((byte)(paramInt >>> 8 & 0xFF));
    arrayOfByte[j] = ((byte)(paramInt & 0xFF));
    localSegment.limit = (j + 1);
    setSize$okio(size() + 2L);
    return this;
  }
  
  public Buffer writeShortLe(int paramInt)
  {
    return writeShort(-Util.reverseBytes((short)paramInt));
  }
  
  public Buffer writeString(String paramString, int paramInt1, int paramInt2, Charset paramCharset)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "string");
    Intrinsics.checkParameterIsNotNull(paramCharset, "charset");
    int j = 1;
    int i;
    if (paramInt1 >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (paramInt2 >= paramInt1) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (paramInt2 <= paramString.length()) {
          i = j;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          if (Intrinsics.areEqual(paramCharset, Charsets.UTF_8)) {
            return writeUtf8(paramString, paramInt1, paramInt2);
          }
          paramString = paramString.substring(paramInt1, paramInt2);
          Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          if (paramString != null)
          {
            paramString = paramString.getBytes(paramCharset);
            Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).getBytes(charset)");
            return write(paramString, 0, paramString.length);
          }
          throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        paramCharset = new StringBuilder();
        paramCharset.append("endIndex > string.length: ");
        paramCharset.append(paramInt2);
        paramCharset.append(" > ");
        paramCharset.append(paramString.length());
        throw ((Throwable)new IllegalArgumentException(paramCharset.toString().toString()));
      }
      paramString = new StringBuilder();
      paramString.append("endIndex < beginIndex: ");
      paramString.append(paramInt2);
      paramString.append(" < ");
      paramString.append(paramInt1);
      throw ((Throwable)new IllegalArgumentException(paramString.toString().toString()));
    }
    paramString = new StringBuilder();
    paramString.append("beginIndex < 0: ");
    paramString.append(paramInt1);
    throw ((Throwable)new IllegalArgumentException(paramString.toString().toString()));
  }
  
  public Buffer writeString(String paramString, Charset paramCharset)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "string");
    Intrinsics.checkParameterIsNotNull(paramCharset, "charset");
    return writeString(paramString, 0, paramString.length(), paramCharset);
  }
  
  public final Buffer writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    return writeTo$default(this, paramOutputStream, 0L, 2, null);
  }
  
  public final Buffer writeTo(OutputStream paramOutputStream, long paramLong)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramOutputStream, "out");
    -Util.checkOffsetAndCount(this.size, 0L, paramLong);
    Object localObject = this.head;
    while (paramLong > 0L)
    {
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      int i = (int)Math.min(paramLong, ((Segment)localObject).limit - ((Segment)localObject).pos);
      paramOutputStream.write(((Segment)localObject).data, ((Segment)localObject).pos, i);
      ((Segment)localObject).pos += i;
      long l1 = this.size;
      long l2 = i;
      this.size = (l1 - l2);
      l1 = paramLong - l2;
      paramLong = l1;
      if (((Segment)localObject).pos == ((Segment)localObject).limit)
      {
        Segment localSegment = ((Segment)localObject).pop();
        this.head = localSegment;
        SegmentPool.INSTANCE.recycle((Segment)localObject);
        localObject = localSegment;
        paramLong = l1;
      }
    }
    return this;
  }
  
  public Buffer writeUtf8(String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "string");
    return writeUtf8(paramString, 0, paramString.length());
  }
  
  public Buffer writeUtf8(String paramString, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "string");
    int i;
    if (paramInt1 >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (paramInt2 >= paramInt1) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (paramInt2 <= paramString.length()) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          while (paramInt1 < paramInt2)
          {
            int k = paramString.charAt(paramInt1);
            int j;
            if (k < 128)
            {
              localObject = writableSegment$okio(1);
              byte[] arrayOfByte = ((Segment)localObject).data;
              j = ((Segment)localObject).limit - paramInt1;
              int m = Math.min(paramInt2, 8192 - j);
              i = paramInt1 + 1;
              arrayOfByte[(paramInt1 + j)] = ((byte)k);
              paramInt1 = i;
              while (paramInt1 < m)
              {
                i = paramString.charAt(paramInt1);
                if (i >= 128) {
                  break;
                }
                arrayOfByte[(paramInt1 + j)] = ((byte)i);
                paramInt1 += 1;
              }
              i = j + paramInt1 - ((Segment)localObject).limit;
              ((Segment)localObject).limit += i;
              setSize$okio(size() + i);
            }
            else
            {
              label217:
              if (k < 2048)
              {
                localObject = writableSegment$okio(2);
                ((Segment)localObject).data[localObject.limit] = ((byte)(k >> 6 | 0xC0));
                ((Segment)localObject).data[(localObject.limit + 1)] = ((byte)(k & 0x3F | 0x80));
                ((Segment)localObject).limit += 2;
                setSize$okio(size() + 2L);
              }
              for (;;)
              {
                paramInt1 += 1;
                break;
                if ((k >= 55296) && (k <= 57343))
                {
                  j = paramInt1 + 1;
                  if (j < paramInt2) {
                    i = paramString.charAt(j);
                  } else {
                    i = 0;
                  }
                  if ((k <= 56319) && (56320 <= i) && (57343 >= i))
                  {
                    i = ((k & 0x3FF) << 10 | i & 0x3FF) + 65536;
                    localObject = writableSegment$okio(4);
                    ((Segment)localObject).data[localObject.limit] = ((byte)(i >> 18 | 0xF0));
                    ((Segment)localObject).data[(localObject.limit + 1)] = ((byte)(i >> 12 & 0x3F | 0x80));
                    ((Segment)localObject).data[(localObject.limit + 2)] = ((byte)(i >> 6 & 0x3F | 0x80));
                    ((Segment)localObject).data[(localObject.limit + 3)] = ((byte)(i & 0x3F | 0x80));
                    ((Segment)localObject).limit += 4;
                    setSize$okio(size() + 4L);
                    paramInt1 += 2;
                    break;
                  }
                  writeByte(63);
                  paramInt1 = j;
                  break label217;
                }
                localObject = writableSegment$okio(3);
                ((Segment)localObject).data[localObject.limit] = ((byte)(k >> 12 | 0xE0));
                ((Segment)localObject).data[(localObject.limit + 1)] = ((byte)(0x3F & k >> 6 | 0x80));
                ((Segment)localObject).data[(localObject.limit + 2)] = ((byte)(k & 0x3F | 0x80));
                ((Segment)localObject).limit += 3;
                setSize$okio(size() + 3L);
              }
            }
          }
          return this;
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("endIndex > string.length: ");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append(" > ");
        ((StringBuilder)localObject).append(paramString.length());
        throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString().toString()));
      }
      paramString = new StringBuilder();
      paramString.append("endIndex < beginIndex: ");
      paramString.append(paramInt2);
      paramString.append(" < ");
      paramString.append(paramInt1);
      throw ((Throwable)new IllegalArgumentException(paramString.toString().toString()));
    }
    paramString = new StringBuilder();
    paramString.append("beginIndex < 0: ");
    paramString.append(paramInt1);
    throw ((Throwable)new IllegalArgumentException(paramString.toString().toString()));
  }
  
  public Buffer writeUtf8CodePoint(int paramInt)
  {
    if (paramInt < 128)
    {
      writeByte(paramInt);
      return this;
    }
    if (paramInt < 2048)
    {
      localObject = writableSegment$okio(2);
      ((Segment)localObject).data[localObject.limit] = ((byte)(paramInt >> 6 | 0xC0));
      ((Segment)localObject).data[(localObject.limit + 1)] = ((byte)(paramInt & 0x3F | 0x80));
      ((Segment)localObject).limit += 2;
      setSize$okio(size() + 2L);
      return this;
    }
    if ((55296 <= paramInt) && (57343 >= paramInt))
    {
      writeByte(63);
      return this;
    }
    if (paramInt < 65536)
    {
      localObject = writableSegment$okio(3);
      ((Segment)localObject).data[localObject.limit] = ((byte)(paramInt >> 12 | 0xE0));
      ((Segment)localObject).data[(localObject.limit + 1)] = ((byte)(paramInt >> 6 & 0x3F | 0x80));
      ((Segment)localObject).data[(localObject.limit + 2)] = ((byte)(paramInt & 0x3F | 0x80));
      ((Segment)localObject).limit += 3;
      setSize$okio(size() + 3L);
      return this;
    }
    if (paramInt <= 1114111)
    {
      localObject = writableSegment$okio(4);
      ((Segment)localObject).data[localObject.limit] = ((byte)(paramInt >> 18 | 0xF0));
      ((Segment)localObject).data[(localObject.limit + 1)] = ((byte)(paramInt >> 12 & 0x3F | 0x80));
      ((Segment)localObject).data[(localObject.limit + 2)] = ((byte)(paramInt >> 6 & 0x3F | 0x80));
      ((Segment)localObject).data[(localObject.limit + 3)] = ((byte)(paramInt & 0x3F | 0x80));
      ((Segment)localObject).limit += 4;
      setSize$okio(size() + 4L);
      return this;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unexpected code point: 0x");
    ((StringBuilder)localObject).append(-Util.toHexString(paramInt));
    throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString()));
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000:\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\022\n\000\n\002\020\b\n\000\n\002\020\t\n\000\n\002\020\013\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\007\030\0002\0020\001B\005¢\006\002\020\002J\b\020\020\032\0020\021H\026J\016\020\022\032\0020\n2\006\020\023\032\0020\bJ\006\020\024\032\0020\bJ\016\020\025\032\0020\n2\006\020\026\032\0020\nJ\016\020\027\032\0020\b2\006\020\t\032\0020\nR\024\020\003\032\004\030\0010\0048\006@\006X\016¢\006\002\n\000R\024\020\005\032\004\030\0010\0068\006@\006X\016¢\006\002\n\000R\022\020\007\032\0020\b8\006@\006X\016¢\006\002\n\000R\022\020\t\032\0020\n8\006@\006X\016¢\006\002\n\000R\022\020\013\032\0020\f8\006@\006X\016¢\006\002\n\000R\020\020\r\032\004\030\0010\016X\016¢\006\002\n\000R\022\020\017\032\0020\b8\006@\006X\016¢\006\002\n\000¨\006\030"}, d2={"Lokio/Buffer$UnsafeCursor;", "Ljava/io/Closeable;", "()V", "buffer", "Lokio/Buffer;", "data", "", "end", "", "offset", "", "readWrite", "", "segment", "Lokio/Segment;", "start", "close", "", "expandBuffer", "minByteCount", "next", "resizeBuffer", "newSize", "seek", "okio"}, k=1, mv={1, 1, 16})
  public static final class UnsafeCursor
    implements Closeable
  {
    public Buffer buffer;
    public byte[] data;
    public int end = -1;
    public long offset = -1L;
    public boolean readWrite;
    private Segment segment;
    public int start = -1;
    
    public void close()
    {
      int i;
      if (this.buffer != null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        this.buffer = ((Buffer)null);
        this.segment = ((Segment)null);
        this.offset = -1L;
        this.data = ((byte[])null);
        this.start = -1;
        this.end = -1;
        return;
      }
      throw ((Throwable)new IllegalStateException("not attached to a buffer".toString()));
    }
    
    public final long expandBuffer(int paramInt)
    {
      int j = 1;
      int i;
      if (paramInt > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (paramInt <= 8192) {
          i = j;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          localObject = this.buffer;
          if (localObject != null)
          {
            if (this.readWrite)
            {
              long l1 = ((Buffer)localObject).size();
              Segment localSegment = ((Buffer)localObject).writableSegment$okio(paramInt);
              paramInt = 8192 - localSegment.limit;
              localSegment.limit = 8192;
              long l2 = paramInt;
              ((Buffer)localObject).setSize$okio(l1 + l2);
              this.segment = localSegment;
              this.offset = l1;
              this.data = localSegment.data;
              this.start = (8192 - paramInt);
              this.end = 8192;
              return l2;
            }
            throw ((Throwable)new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString()));
          }
          throw ((Throwable)new IllegalStateException("not attached to a buffer".toString()));
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("minByteCount > Segment.SIZE: ");
        ((StringBuilder)localObject).append(paramInt);
        throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString().toString()));
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("minByteCount <= 0: ");
      ((StringBuilder)localObject).append(paramInt);
      throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString().toString()));
    }
    
    public final int next()
    {
      long l = this.offset;
      Buffer localBuffer = this.buffer;
      if (localBuffer == null) {
        Intrinsics.throwNpe();
      }
      int i;
      if (l != localBuffer.size()) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        l = this.offset;
        if (l == -1L) {
          l = 0L;
        } else {
          l += this.end - this.start;
        }
        return seek(l);
      }
      throw ((Throwable)new IllegalStateException("no more bytes".toString()));
    }
    
    public final long resizeBuffer(long paramLong)
    {
      Object localObject = this.buffer;
      if (localObject != null)
      {
        if (this.readWrite)
        {
          long l2 = ((Buffer)localObject).size();
          boolean bool1 = paramLong < l2;
          long l1;
          Segment localSegment;
          if (!bool1)
          {
            if (paramLong >= 0L) {
              bool1 = true;
            } else {
              bool1 = false;
            }
            if (bool1)
            {
              l1 = l2 - paramLong;
              while (l1 > 0L)
              {
                localSegment = ((Buffer)localObject).head;
                if (localSegment == null) {
                  Intrinsics.throwNpe();
                }
                localSegment = localSegment.prev;
                if (localSegment == null) {
                  Intrinsics.throwNpe();
                }
                long l3 = localSegment.limit - localSegment.pos;
                if (l3 <= l1)
                {
                  ((Buffer)localObject).head = localSegment.pop();
                  SegmentPool.INSTANCE.recycle(localSegment);
                  l1 -= l3;
                }
                else
                {
                  localSegment.limit -= (int)l1;
                }
              }
              this.segment = ((Segment)null);
              this.offset = paramLong;
              this.data = ((byte[])null);
              this.start = -1;
              this.end = -1;
            }
            else
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("newSize < 0: ");
              ((StringBuilder)localObject).append(paramLong);
              throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString().toString()));
            }
          }
          else if (bool1)
          {
            l1 = paramLong - l2;
            boolean bool2;
            for (bool1 = true; l1 > 0L; bool1 = bool2)
            {
              localSegment = ((Buffer)localObject).writableSegment$okio(1);
              int i = (int)Math.min(l1, 8192 - localSegment.limit);
              localSegment.limit += i;
              l1 -= i;
              bool2 = bool1;
              if (bool1)
              {
                this.segment = localSegment;
                this.offset = l2;
                this.data = localSegment.data;
                this.start = (localSegment.limit - i);
                this.end = localSegment.limit;
                bool2 = false;
              }
            }
          }
          ((Buffer)localObject).setSize$okio(paramLong);
          return l2;
        }
        throw ((Throwable)new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString()));
      }
      throw ((Throwable)new IllegalStateException("not attached to a buffer".toString()));
    }
    
    public final int seek(long paramLong)
    {
      Buffer localBuffer = this.buffer;
      if (localBuffer != null)
      {
        if ((paramLong >= -1) && (paramLong <= localBuffer.size()))
        {
          if ((paramLong != -1L) && (paramLong != localBuffer.size()))
          {
            long l3 = 0L;
            long l4 = localBuffer.size();
            Segment localSegment1 = localBuffer.head;
            Segment localSegment2 = localBuffer.head;
            Segment localSegment3 = this.segment;
            long l1 = l3;
            long l2 = l4;
            localObject1 = localSegment1;
            Object localObject2 = localSegment2;
            if (localSegment3 != null)
            {
              l1 = this.offset;
              i = this.start;
              if (localSegment3 == null) {
                Intrinsics.throwNpe();
              }
              l1 -= i - localSegment3.pos;
              if (l1 > paramLong)
              {
                localObject2 = this.segment;
                l2 = l1;
                l1 = l3;
                localObject1 = localSegment1;
              }
              else
              {
                localObject1 = this.segment;
                localObject2 = localSegment2;
                l2 = l4;
              }
            }
            l3 = l2;
            if (l2 - paramLong > paramLong - l1) {
              for (localObject2 = localObject1;; localObject2 = ((Segment)localObject2).next)
              {
                if (localObject2 == null) {
                  Intrinsics.throwNpe();
                }
                l2 = l1;
                localObject1 = localObject2;
                if (paramLong < ((Segment)localObject2).limit - ((Segment)localObject2).pos + l1) {
                  break;
                }
                l1 += ((Segment)localObject2).limit - ((Segment)localObject2).pos;
              }
            }
            while (l3 > paramLong)
            {
              if (localObject2 == null) {
                Intrinsics.throwNpe();
              }
              localObject2 = ((Segment)localObject2).prev;
              if (localObject2 == null) {
                Intrinsics.throwNpe();
              }
              l3 -= ((Segment)localObject2).limit - ((Segment)localObject2).pos;
            }
            l2 = l3;
            localObject1 = localObject2;
            localObject2 = localObject1;
            if (this.readWrite)
            {
              if (localObject1 == null) {
                Intrinsics.throwNpe();
              }
              localObject2 = localObject1;
              if (((Segment)localObject1).shared)
              {
                localObject2 = ((Segment)localObject1).unsharedCopy();
                if (localBuffer.head == localObject1) {
                  localBuffer.head = ((Segment)localObject2);
                }
                localObject2 = ((Segment)localObject1).push((Segment)localObject2);
                localObject1 = ((Segment)localObject2).prev;
                if (localObject1 == null) {
                  Intrinsics.throwNpe();
                }
                ((Segment)localObject1).pop();
              }
            }
            this.segment = ((Segment)localObject2);
            this.offset = paramLong;
            if (localObject2 == null) {
              Intrinsics.throwNpe();
            }
            this.data = ((Segment)localObject2).data;
            this.start = (((Segment)localObject2).pos + (int)(paramLong - l2));
            int i = ((Segment)localObject2).limit;
            this.end = i;
            return i - this.start;
          }
          this.segment = ((Segment)null);
          this.offset = paramLong;
          this.data = ((byte[])null);
          this.start = -1;
          this.end = -1;
          return -1;
        }
        Object localObject1 = StringCompanionObject.INSTANCE;
        localObject1 = String.format("offset=%s > size=%s", Arrays.copyOf(new Object[] { Long.valueOf(paramLong), Long.valueOf(localBuffer.size()) }, 2));
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "java.lang.String.format(format, *args)");
        throw ((Throwable)new ArrayIndexOutOfBoundsException((String)localObject1));
      }
      throw ((Throwable)new IllegalStateException("not attached to a buffer".toString()));
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okio\Buffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */