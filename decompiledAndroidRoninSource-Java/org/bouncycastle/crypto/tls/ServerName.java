package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ServerName
{
  protected Object name;
  protected short nameType;
  
  public ServerName(short paramShort, Object paramObject)
  {
    if (isCorrectType(paramShort, paramObject))
    {
      this.nameType = paramShort;
      this.name = paramObject;
      return;
    }
    throw new IllegalArgumentException("'name' is not an instance of the correct type");
  }
  
  protected static boolean isCorrectType(short paramShort, Object paramObject)
  {
    if (paramShort == 0) {
      return paramObject instanceof String;
    }
    throw new IllegalArgumentException("'name' is an unsupported value");
  }
  
  public static ServerName parse(InputStream paramInputStream)
    throws IOException
  {
    short s = TlsUtils.readUint8(paramInputStream);
    if (s == 0)
    {
      paramInputStream = TlsUtils.readOpaque16(paramInputStream);
      if (paramInputStream.length >= 1) {
        return new ServerName(s, new String(paramInputStream, "ASCII"));
      }
      throw new TlsFatalAlert((short)50);
    }
    throw new TlsFatalAlert((short)50);
  }
  
  public void encode(OutputStream paramOutputStream)
    throws IOException
  {
    TlsUtils.writeUint8(this.nameType, paramOutputStream);
    if (this.nameType == 0)
    {
      byte[] arrayOfByte = ((String)this.name).getBytes("ASCII");
      if (arrayOfByte.length >= 1)
      {
        TlsUtils.writeOpaque16(arrayOfByte, paramOutputStream);
        return;
      }
      throw new TlsFatalAlert((short)80);
    }
    throw new TlsFatalAlert((short)80);
  }
  
  public String getHostName()
  {
    if (isCorrectType(, this.name)) {
      return (String)this.name;
    }
    throw new IllegalStateException("'name' is not a HostName string");
  }
  
  public Object getName()
  {
    return this.name;
  }
  
  public short getNameType()
  {
    return this.nameType;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\ServerName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */