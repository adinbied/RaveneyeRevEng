package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import org.bouncycastle.util.Arrays;

public class ServerSRPParams
{
  protected BigInteger B;
  protected BigInteger N;
  protected BigInteger g;
  protected byte[] s;
  
  public ServerSRPParams(BigInteger paramBigInteger1, BigInteger paramBigInteger2, byte[] paramArrayOfByte, BigInteger paramBigInteger3)
  {
    this.N = paramBigInteger1;
    this.g = paramBigInteger2;
    this.s = Arrays.clone(paramArrayOfByte);
    this.B = paramBigInteger3;
  }
  
  public static ServerSRPParams parse(InputStream paramInputStream)
    throws IOException
  {
    return new ServerSRPParams(TlsSRPUtils.readSRPParameter(paramInputStream), TlsSRPUtils.readSRPParameter(paramInputStream), TlsUtils.readOpaque8(paramInputStream), TlsSRPUtils.readSRPParameter(paramInputStream));
  }
  
  public void encode(OutputStream paramOutputStream)
    throws IOException
  {
    TlsSRPUtils.writeSRPParameter(this.N, paramOutputStream);
    TlsSRPUtils.writeSRPParameter(this.g, paramOutputStream);
    TlsUtils.writeOpaque8(this.s, paramOutputStream);
    TlsSRPUtils.writeSRPParameter(this.B, paramOutputStream);
  }
  
  public BigInteger getB()
  {
    return this.B;
  }
  
  public BigInteger getG()
  {
    return this.g;
  }
  
  public BigInteger getN()
  {
    return this.N;
  }
  
  public byte[] getS()
  {
    return this.s;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\ServerSRPParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */