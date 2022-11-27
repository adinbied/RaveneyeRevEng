package com.squareup.wire;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import okio.BufferedSource;
import okio.ByteString;

public final class ProtoReader
{
  private static final int FIELD_ENCODING_MASK = 7;
  private static final int RECURSION_LIMIT = 65;
  private static final int STATE_END_GROUP = 4;
  private static final int STATE_FIXED32 = 5;
  private static final int STATE_FIXED64 = 1;
  private static final int STATE_LENGTH_DELIMITED = 2;
  private static final int STATE_PACKED_TAG = 7;
  private static final int STATE_START_GROUP = 3;
  private static final int STATE_TAG = 6;
  private static final int STATE_VARINT = 0;
  static final int TAG_FIELD_ENCODING_BITS = 3;
  private long limit = Long.MAX_VALUE;
  private FieldEncoding nextFieldEncoding;
  private long pos = 0L;
  private long pushedLimit = -1L;
  private int recursionDepth;
  private final BufferedSource source;
  private int state = 2;
  private int tag = -1;
  
  public ProtoReader(BufferedSource paramBufferedSource)
  {
    this.source = paramBufferedSource;
  }
  
  private void afterPackableScalar(int paramInt)
    throws IOException
  {
    if (this.state == paramInt)
    {
      this.state = 6;
      return;
    }
    long l1 = this.pos;
    long l2 = this.limit;
    if (l1 <= l2)
    {
      if (l1 == l2)
      {
        this.limit = this.pushedLimit;
        this.pushedLimit = -1L;
        this.state = 6;
        return;
      }
      this.state = 7;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expected to end at ");
    localStringBuilder.append(this.limit);
    localStringBuilder.append(" but was ");
    localStringBuilder.append(this.pos);
    throw new IOException(localStringBuilder.toString());
  }
  
  private long beforeLengthDelimitedScalar()
    throws IOException
  {
    if (this.state == 2)
    {
      long l = this.limit - this.pos;
      this.source.require(l);
      this.state = 6;
      this.pos = this.limit;
      this.limit = this.pushedLimit;
      this.pushedLimit = -1L;
      return l;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expected LENGTH_DELIMITED but was ");
    localStringBuilder.append(this.state);
    throw new ProtocolException(localStringBuilder.toString());
  }
  
  private int internalReadVarint32()
    throws IOException
  {
    this.pos += 1L;
    int i = this.source.readByte();
    if (i >= 0) {
      return i;
    }
    i &= 0x7F;
    this.pos += 1L;
    int j = this.source.readByte();
    if (j >= 0) {
      j <<= 7;
    }
    for (;;)
    {
      return i | j;
      i |= (j & 0x7F) << 7;
      this.pos += 1L;
      j = this.source.readByte();
      if (j >= 0)
      {
        j <<= 14;
      }
      else
      {
        i |= (j & 0x7F) << 14;
        this.pos += 1L;
        j = this.source.readByte();
        if (j < 0) {
          break;
        }
        j <<= 21;
      }
    }
    this.pos += 1L;
    int k = this.source.readByte();
    j = i | (j & 0x7F) << 21 | k << 28;
    if (k < 0)
    {
      i = 0;
      while (i < 5)
      {
        this.pos += 1L;
        if (this.source.readByte() >= 0) {
          return j;
        }
        i += 1;
      }
      throw new ProtocolException("Malformed VARINT");
    }
    return j;
  }
  
  private void skipGroup(int paramInt)
    throws IOException
  {
    while ((this.pos < this.limit) && (!this.source.exhausted()))
    {
      int j = internalReadVarint32();
      if (j != 0)
      {
        int i = j >> 3;
        j &= 0x7;
        if (j != 0)
        {
          if (j != 1)
          {
            if (j != 2)
            {
              if (j != 3)
              {
                if (j != 4)
                {
                  if (j == 5)
                  {
                    this.state = 5;
                    readFixed32();
                  }
                  else
                  {
                    StringBuilder localStringBuilder = new StringBuilder();
                    localStringBuilder.append("Unexpected field encoding: ");
                    localStringBuilder.append(j);
                    throw new ProtocolException(localStringBuilder.toString());
                  }
                }
                else
                {
                  if (i == paramInt) {
                    return;
                  }
                  throw new ProtocolException("Unexpected end group");
                }
              }
              else {
                skipGroup(i);
              }
            }
            else
            {
              i = internalReadVarint32();
              long l1 = this.pos;
              long l2 = i;
              this.pos = (l1 + l2);
              this.source.skip(l2);
            }
          }
          else
          {
            this.state = 1;
            readFixed64();
          }
        }
        else
        {
          this.state = 0;
          readVarint64();
        }
      }
      else
      {
        throw new ProtocolException("Unexpected tag 0");
      }
    }
    throw new EOFException();
  }
  
  public long beginMessage()
    throws IOException
  {
    if (this.state == 2)
    {
      int i = this.recursionDepth + 1;
      this.recursionDepth = i;
      if (i <= 65)
      {
        long l = this.pushedLimit;
        this.pushedLimit = -1L;
        this.state = 6;
        return l;
      }
      throw new IOException("Wire recursion limit exceeded");
    }
    throw new IllegalStateException("Unexpected call to beginMessage()");
  }
  
  public void endMessage(long paramLong)
    throws IOException
  {
    if (this.state == 6)
    {
      int i = this.recursionDepth - 1;
      this.recursionDepth = i;
      if ((i >= 0) && (this.pushedLimit == -1L))
      {
        if ((this.pos != this.limit) && (i != 0))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Expected to end at ");
          localStringBuilder.append(this.limit);
          localStringBuilder.append(" but was ");
          localStringBuilder.append(this.pos);
          throw new IOException(localStringBuilder.toString());
        }
        this.limit = paramLong;
        return;
      }
      throw new IllegalStateException("No corresponding call to beginMessage()");
    }
    throw new IllegalStateException("Unexpected call to endMessage()");
  }
  
  public int nextTag()
    throws IOException
  {
    int i = this.state;
    if (i == 7)
    {
      this.state = 2;
      return this.tag;
    }
    if (i == 6)
    {
      while ((this.pos < this.limit) && (!this.source.exhausted()))
      {
        int j = internalReadVarint32();
        if (j != 0)
        {
          i = j >> 3;
          this.tag = i;
          j &= 0x7;
          if (j != 0)
          {
            if (j != 1)
            {
              StringBuilder localStringBuilder;
              if (j != 2)
              {
                if (j != 3)
                {
                  if (j != 4)
                  {
                    if (j == 5)
                    {
                      this.nextFieldEncoding = FieldEncoding.FIXED32;
                      this.state = 5;
                      return this.tag;
                    }
                    localStringBuilder = new StringBuilder();
                    localStringBuilder.append("Unexpected field encoding: ");
                    localStringBuilder.append(j);
                    throw new ProtocolException(localStringBuilder.toString());
                  }
                  throw new ProtocolException("Unexpected end group");
                }
                skipGroup(i);
              }
              else
              {
                this.nextFieldEncoding = FieldEncoding.LENGTH_DELIMITED;
                this.state = 2;
                i = internalReadVarint32();
                if (i >= 0)
                {
                  if (this.pushedLimit == -1L)
                  {
                    long l1 = this.limit;
                    this.pushedLimit = l1;
                    long l2 = this.pos + i;
                    this.limit = l2;
                    if (l2 <= l1) {
                      return this.tag;
                    }
                    throw new EOFException();
                  }
                  throw new IllegalStateException();
                }
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("Negative length: ");
                localStringBuilder.append(i);
                throw new ProtocolException(localStringBuilder.toString());
              }
            }
            else
            {
              this.nextFieldEncoding = FieldEncoding.FIXED64;
              this.state = 1;
              return this.tag;
            }
          }
          else
          {
            this.nextFieldEncoding = FieldEncoding.VARINT;
            this.state = 0;
            return this.tag;
          }
        }
        else
        {
          throw new ProtocolException("Unexpected tag 0");
        }
      }
      return -1;
    }
    throw new IllegalStateException("Unexpected call to nextTag()");
  }
  
  public FieldEncoding peekFieldEncoding()
  {
    return this.nextFieldEncoding;
  }
  
  public ByteString readBytes()
    throws IOException
  {
    long l = beforeLengthDelimitedScalar();
    return this.source.readByteString(l);
  }
  
  public int readFixed32()
    throws IOException
  {
    int i = this.state;
    if ((i != 5) && (i != 2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Expected FIXED32 or LENGTH_DELIMITED but was ");
      localStringBuilder.append(this.state);
      throw new ProtocolException(localStringBuilder.toString());
    }
    this.source.require(4L);
    this.pos += 4L;
    i = this.source.readIntLe();
    afterPackableScalar(5);
    return i;
  }
  
  public long readFixed64()
    throws IOException
  {
    int i = this.state;
    if ((i != 1) && (i != 2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Expected FIXED64 or LENGTH_DELIMITED but was ");
      localStringBuilder.append(this.state);
      throw new ProtocolException(localStringBuilder.toString());
    }
    this.source.require(8L);
    this.pos += 8L;
    long l = this.source.readLongLe();
    afterPackableScalar(1);
    return l;
  }
  
  public String readString()
    throws IOException
  {
    long l = beforeLengthDelimitedScalar();
    return this.source.readUtf8(l);
  }
  
  public int readVarint32()
    throws IOException
  {
    int i = this.state;
    if ((i != 0) && (i != 2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Expected VARINT or LENGTH_DELIMITED but was ");
      localStringBuilder.append(this.state);
      throw new ProtocolException(localStringBuilder.toString());
    }
    i = internalReadVarint32();
    afterPackableScalar(0);
    return i;
  }
  
  public long readVarint64()
    throws IOException
  {
    int i = this.state;
    if ((i != 0) && (i != 2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Expected VARINT or LENGTH_DELIMITED but was ");
      localStringBuilder.append(this.state);
      throw new ProtocolException(localStringBuilder.toString());
    }
    long l = 0L;
    i = 0;
    while (i < 64)
    {
      this.pos += 1L;
      int j = this.source.readByte();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0)
      {
        afterPackableScalar(0);
        return l;
      }
      i += 7;
    }
    throw new ProtocolException("WireInput encountered a malformed varint");
  }
  
  public void skip()
    throws IOException
  {
    int i = this.state;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 5)
          {
            readFixed32();
            return;
          }
          throw new IllegalStateException("Unexpected call to skip()");
        }
        long l = beforeLengthDelimitedScalar();
        this.source.skip(l);
        return;
      }
      readFixed64();
      return;
    }
    readVarint64();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\squareup\wire\ProtoReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */