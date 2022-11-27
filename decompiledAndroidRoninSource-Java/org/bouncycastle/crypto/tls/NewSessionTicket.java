package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class NewSessionTicket
{
  protected byte[] ticket;
  protected long ticketLifetimeHint;
  
  public NewSessionTicket(long paramLong, byte[] paramArrayOfByte)
  {
    this.ticketLifetimeHint = paramLong;
    this.ticket = paramArrayOfByte;
  }
  
  public static NewSessionTicket parse(InputStream paramInputStream)
    throws IOException
  {
    return new NewSessionTicket(TlsUtils.readUint32(paramInputStream), TlsUtils.readOpaque16(paramInputStream));
  }
  
  public void encode(OutputStream paramOutputStream)
    throws IOException
  {
    TlsUtils.writeUint32(this.ticketLifetimeHint, paramOutputStream);
    TlsUtils.writeOpaque16(this.ticket, paramOutputStream);
  }
  
  public byte[] getTicket()
  {
    return this.ticket;
  }
  
  public long getTicketLifetimeHint()
  {
    return this.ticketLifetimeHint;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\NewSessionTicket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */