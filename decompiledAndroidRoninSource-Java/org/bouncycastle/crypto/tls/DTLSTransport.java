package org.bouncycastle.crypto.tls;

import java.io.IOException;

public class DTLSTransport
  implements DatagramTransport
{
  private final DTLSRecordLayer recordLayer;
  
  DTLSTransport(DTLSRecordLayer paramDTLSRecordLayer)
  {
    this.recordLayer = paramDTLSRecordLayer;
  }
  
  public void close()
    throws IOException
  {
    this.recordLayer.close();
  }
  
  public int getReceiveLimit()
    throws IOException
  {
    return this.recordLayer.getReceiveLimit();
  }
  
  public int getSendLimit()
    throws IOException
  {
    return this.recordLayer.getSendLimit();
  }
  
  public int receive(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    try
    {
      paramInt1 = this.recordLayer.receive(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
      return paramInt1;
    }
    catch (RuntimeException paramArrayOfByte)
    {
      this.recordLayer.fail((short)80);
      throw new TlsFatalAlert((short)80, paramArrayOfByte);
    }
    catch (IOException paramArrayOfByte)
    {
      this.recordLayer.fail((short)80);
      throw paramArrayOfByte;
    }
    catch (TlsFatalAlert paramArrayOfByte)
    {
      this.recordLayer.fail(paramArrayOfByte.getAlertDescription());
      throw paramArrayOfByte;
    }
  }
  
  public void send(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    try
    {
      this.recordLayer.send(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    catch (RuntimeException paramArrayOfByte)
    {
      this.recordLayer.fail((short)80);
      throw new TlsFatalAlert((short)80, paramArrayOfByte);
    }
    catch (IOException paramArrayOfByte)
    {
      this.recordLayer.fail((short)80);
      throw paramArrayOfByte;
    }
    catch (TlsFatalAlert paramArrayOfByte)
    {
      this.recordLayer.fail(paramArrayOfByte.getAlertDescription());
      throw paramArrayOfByte;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\DTLSTransport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */