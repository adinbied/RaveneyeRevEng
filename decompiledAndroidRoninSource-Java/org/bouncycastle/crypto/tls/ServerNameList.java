package org.bouncycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.io.Streams;

public class ServerNameList
{
  protected Vector serverNameList;
  
  public ServerNameList(Vector paramVector)
  {
    if (paramVector != null)
    {
      this.serverNameList = paramVector;
      return;
    }
    throw new IllegalArgumentException("'serverNameList' must not be null");
  }
  
  private static short[] checkNameType(short[] paramArrayOfShort, short paramShort)
  {
    if ((NameType.isValid(paramShort)) && (!Arrays.contains(paramArrayOfShort, paramShort))) {
      return Arrays.append(paramArrayOfShort, paramShort);
    }
    return null;
  }
  
  public static ServerNameList parse(InputStream paramInputStream)
    throws IOException
  {
    int i = TlsUtils.readUint16(paramInputStream);
    if (i >= 1)
    {
      ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(TlsUtils.readFully(i, paramInputStream));
      paramInputStream = new short[0];
      Vector localVector = new Vector();
      while (localByteArrayInputStream.available() > 0)
      {
        ServerName localServerName = ServerName.parse(localByteArrayInputStream);
        paramInputStream = checkNameType(paramInputStream, localServerName.getNameType());
        if (paramInputStream != null) {
          localVector.addElement(localServerName);
        } else {
          throw new TlsFatalAlert((short)47);
        }
      }
      return new ServerNameList(localVector);
    }
    throw new TlsFatalAlert((short)50);
  }
  
  public void encode(OutputStream paramOutputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int i = 0;
    short[] arrayOfShort = new short[0];
    while (i < this.serverNameList.size())
    {
      ServerName localServerName = (ServerName)this.serverNameList.elementAt(i);
      arrayOfShort = checkNameType(arrayOfShort, localServerName.getNameType());
      if (arrayOfShort != null)
      {
        localServerName.encode(localByteArrayOutputStream);
        i += 1;
      }
      else
      {
        throw new TlsFatalAlert((short)80);
      }
    }
    TlsUtils.checkUint16(localByteArrayOutputStream.size());
    TlsUtils.writeUint16(localByteArrayOutputStream.size(), paramOutputStream);
    Streams.writeBufTo(localByteArrayOutputStream, paramOutputStream);
  }
  
  public Vector getServerNameList()
  {
    return this.serverNameList;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\ServerNameList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */