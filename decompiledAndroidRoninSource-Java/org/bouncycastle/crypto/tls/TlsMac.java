package org.bouncycastle.crypto.tls;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.digests.LongDigest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Arrays;

public class TlsMac
{
  protected TlsContext context;
  protected int digestBlockSize;
  protected int digestOverhead;
  protected Mac mac;
  protected int macLength;
  protected byte[] secret;
  
  public TlsMac(TlsContext paramTlsContext, Digest paramDigest, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.context = paramTlsContext;
    paramArrayOfByte = new KeyParameter(paramArrayOfByte, paramInt1, paramInt2);
    this.secret = Arrays.clone(paramArrayOfByte.getKey());
    if ((paramDigest instanceof LongDigest))
    {
      this.digestBlockSize = 128;
      paramInt1 = 16;
    }
    else
    {
      this.digestBlockSize = 64;
      paramInt1 = 8;
    }
    this.digestOverhead = paramInt1;
    if (TlsUtils.isSSL(paramTlsContext))
    {
      this.mac = new SSL3Mac(paramDigest);
      if (paramDigest.getDigestSize() == 20) {
        this.digestOverhead = 4;
      }
    }
    else
    {
      this.mac = new HMac(paramDigest);
    }
    this.mac.init(paramArrayOfByte);
    this.macLength = this.mac.getMacSize();
    if (paramTlsContext.getSecurityParameters().truncatedHMac) {
      this.macLength = Math.min(this.macLength, 10);
    }
  }
  
  public byte[] calculateMac(long paramLong, short paramShort, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    ProtocolVersion localProtocolVersion = this.context.getServerVersion();
    boolean bool = localProtocolVersion.isSSL();
    int i;
    if (bool) {
      i = 11;
    } else {
      i = 13;
    }
    byte[] arrayOfByte = new byte[i];
    TlsUtils.writeUint64(paramLong, arrayOfByte, 0);
    TlsUtils.writeUint8(paramShort, arrayOfByte, 8);
    if (!bool) {
      TlsUtils.writeVersion(localProtocolVersion, arrayOfByte, 9);
    }
    TlsUtils.writeUint16(paramInt2, arrayOfByte, i - 2);
    this.mac.update(arrayOfByte, 0, i);
    this.mac.update(paramArrayOfByte, paramInt1, paramInt2);
    paramArrayOfByte = new byte[this.mac.getMacSize()];
    this.mac.doFinal(paramArrayOfByte, 0);
    return truncate(paramArrayOfByte);
  }
  
  public byte[] calculateMacConstantTime(long paramLong, short paramShort, byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte2)
  {
    paramArrayOfByte1 = calculateMac(paramLong, paramShort, paramArrayOfByte1, paramInt1, paramInt2);
    if (TlsUtils.isSSL(this.context)) {
      paramInt1 = 11;
    } else {
      paramInt1 = 13;
    }
    paramInt1 = getDigestBlockCount(paramInt3 + paramInt1) - getDigestBlockCount(paramInt1 + paramInt2);
    for (;;)
    {
      paramInt1 -= 1;
      if (paramInt1 < 0) {
        break;
      }
      this.mac.update(paramArrayOfByte2, 0, this.digestBlockSize);
    }
    this.mac.update(paramArrayOfByte2[0]);
    this.mac.reset();
    return paramArrayOfByte1;
  }
  
  protected int getDigestBlockCount(int paramInt)
  {
    return (paramInt + this.digestOverhead) / this.digestBlockSize;
  }
  
  public byte[] getMACSecret()
  {
    return this.secret;
  }
  
  public int getSize()
  {
    return this.macLength;
  }
  
  protected byte[] truncate(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    int j = this.macLength;
    if (i <= j) {
      return paramArrayOfByte;
    }
    return Arrays.copyOf(paramArrayOfByte, j);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsMac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */