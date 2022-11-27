package com.google.firebase.crashlytics.internal.proto;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

final class ByteString
{
  public static final ByteString EMPTY = new ByteString(new byte[0]);
  private final byte[] bytes;
  private volatile int hash = 0;
  
  private ByteString(byte[] paramArrayOfByte)
  {
    this.bytes = paramArrayOfByte;
  }
  
  public static ByteString copyFrom(String paramString1, String paramString2)
    throws UnsupportedEncodingException
  {
    return new ByteString(paramString1.getBytes(paramString2));
  }
  
  public static ByteString copyFrom(ByteBuffer paramByteBuffer)
  {
    return copyFrom(paramByteBuffer, paramByteBuffer.remaining());
  }
  
  public static ByteString copyFrom(ByteBuffer paramByteBuffer, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    paramByteBuffer.get(arrayOfByte);
    return new ByteString(arrayOfByte);
  }
  
  public static ByteString copyFrom(List<ByteString> paramList)
  {
    if (paramList.size() == 0) {
      return EMPTY;
    }
    if (paramList.size() == 1) {
      return (ByteString)paramList.get(0);
    }
    Object localObject = paramList.iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext()) {
      i += ((ByteString)((Iterator)localObject).next()).size();
    }
    localObject = new byte[i];
    paramList = paramList.iterator();
    i = 0;
    while (paramList.hasNext())
    {
      ByteString localByteString = (ByteString)paramList.next();
      System.arraycopy(localByteString.bytes, 0, localObject, i, localByteString.size());
      i += localByteString.size();
    }
    return new ByteString((byte[])localObject);
  }
  
  public static ByteString copyFrom(byte[] paramArrayOfByte)
  {
    return copyFrom(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static ByteString copyFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return new ByteString(arrayOfByte);
  }
  
  public static ByteString copyFromUtf8(String paramString)
  {
    try
    {
      paramString = new ByteString(paramString.getBytes("UTF-8"));
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("UTF-8 not supported.", paramString);
    }
  }
  
  static CodedBuilder newCodedBuilder(int paramInt)
  {
    return new CodedBuilder(paramInt, null);
  }
  
  public static Output newOutput()
  {
    return newOutput(32);
  }
  
  public static Output newOutput(int paramInt)
  {
    return new Output(new ByteArrayOutputStream(paramInt), null);
  }
  
  public ByteBuffer asReadOnlyByteBuffer()
  {
    return ByteBuffer.wrap(this.bytes).asReadOnlyBuffer();
  }
  
  public byte byteAt(int paramInt)
  {
    return this.bytes[paramInt];
  }
  
  public void copyTo(ByteBuffer paramByteBuffer)
  {
    byte[] arrayOfByte = this.bytes;
    paramByteBuffer.put(arrayOfByte, 0, arrayOfByte.length);
  }
  
  public void copyTo(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = this.bytes;
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte, paramInt, arrayOfByte.length);
  }
  
  public void copyTo(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    System.arraycopy(this.bytes, paramInt1, paramArrayOfByte, paramInt2, paramInt3);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof ByteString)) {
      return false;
    }
    Object localObject = (ByteString)paramObject;
    paramObject = this.bytes;
    int j = paramObject.length;
    localObject = ((ByteString)localObject).bytes;
    if (j != localObject.length) {
      return false;
    }
    int i = 0;
    while (i < j)
    {
      if (paramObject[i] != localObject[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public int hashCode()
  {
    int j = this.hash;
    int i = j;
    if (j == 0)
    {
      byte[] arrayOfByte = this.bytes;
      int k = arrayOfByte.length;
      j = 0;
      i = k;
      while (j < k)
      {
        i = i * 31 + arrayOfByte[j];
        j += 1;
      }
      if (i == 0) {
        i = 1;
      }
      this.hash = i;
    }
    return i;
  }
  
  public boolean isEmpty()
  {
    return this.bytes.length == 0;
  }
  
  public InputStream newInput()
  {
    return new ByteArrayInputStream(this.bytes);
  }
  
  public int size()
  {
    return this.bytes.length;
  }
  
  public byte[] toByteArray()
  {
    byte[] arrayOfByte1 = this.bytes;
    int i = arrayOfByte1.length;
    byte[] arrayOfByte2 = new byte[i];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i);
    return arrayOfByte2;
  }
  
  public String toString(String paramString)
    throws UnsupportedEncodingException
  {
    return new String(this.bytes, paramString);
  }
  
  public String toStringUtf8()
  {
    try
    {
      String str = new String(this.bytes, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException("UTF-8 not supported?", localUnsupportedEncodingException);
    }
  }
  
  static final class CodedBuilder
  {
    private final byte[] buffer;
    private final CodedOutputStream output;
    
    private CodedBuilder(int paramInt)
    {
      byte[] arrayOfByte = new byte[paramInt];
      this.buffer = arrayOfByte;
      this.output = CodedOutputStream.newInstance(arrayOfByte);
    }
    
    public ByteString build()
    {
      this.output.checkNoSpaceLeft();
      return new ByteString(this.buffer, null);
    }
    
    public CodedOutputStream getCodedOutput()
    {
      return this.output;
    }
  }
  
  static final class Output
    extends FilterOutputStream
  {
    private final ByteArrayOutputStream bout;
    
    private Output(ByteArrayOutputStream paramByteArrayOutputStream)
    {
      super();
      this.bout = paramByteArrayOutputStream;
    }
    
    public ByteString toByteString()
    {
      return new ByteString(this.bout.toByteArray(), null);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\proto\ByteString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */