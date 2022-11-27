package org.bouncycastle.crypto.tls;

import java.io.IOException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

public class TlsStreamCipher
  implements TlsCipher
{
  protected TlsContext context;
  protected StreamCipher decryptCipher;
  protected StreamCipher encryptCipher;
  protected TlsMac readMac;
  protected boolean usesNonce;
  protected TlsMac writeMac;
  
  public TlsStreamCipher(TlsContext paramTlsContext, StreamCipher paramStreamCipher1, StreamCipher paramStreamCipher2, Digest paramDigest1, Digest paramDigest2, int paramInt, boolean paramBoolean)
    throws IOException
  {
    boolean bool = paramTlsContext.isServer();
    this.context = paramTlsContext;
    this.usesNonce = paramBoolean;
    this.encryptCipher = paramStreamCipher1;
    this.decryptCipher = paramStreamCipher2;
    int i = paramInt * 2 + paramDigest1.getDigestSize() + paramDigest2.getDigestSize();
    byte[] arrayOfByte = TlsUtils.calculateKeyBlock(paramTlsContext, i);
    TlsMac localTlsMac1 = new TlsMac(paramTlsContext, paramDigest1, arrayOfByte, 0, paramDigest1.getDigestSize());
    int j = paramDigest1.getDigestSize() + 0;
    TlsMac localTlsMac2 = new TlsMac(paramTlsContext, paramDigest2, arrayOfByte, j, paramDigest2.getDigestSize());
    j += paramDigest2.getDigestSize();
    paramDigest1 = new KeyParameter(arrayOfByte, j, paramInt);
    j += paramInt;
    paramTlsContext = new KeyParameter(arrayOfByte, j, paramInt);
    if (j + paramInt == i)
    {
      if (bool)
      {
        this.writeMac = localTlsMac2;
        this.readMac = localTlsMac1;
        this.encryptCipher = paramStreamCipher2;
        this.decryptCipher = paramStreamCipher1;
        paramStreamCipher1 = paramTlsContext;
        paramTlsContext = paramDigest1;
      }
      else
      {
        this.writeMac = localTlsMac1;
        this.readMac = localTlsMac2;
        this.encryptCipher = paramStreamCipher1;
        this.decryptCipher = paramStreamCipher2;
        paramStreamCipher1 = paramDigest1;
      }
      paramDigest1 = paramStreamCipher1;
      paramStreamCipher2 = paramTlsContext;
      if (paramBoolean)
      {
        paramStreamCipher2 = new byte[8];
        paramDigest1 = new ParametersWithIV(paramStreamCipher1, paramStreamCipher2);
        paramStreamCipher2 = new ParametersWithIV(paramTlsContext, paramStreamCipher2);
      }
      this.encryptCipher.init(true, paramDigest1);
      this.decryptCipher.init(false, paramStreamCipher2);
      return;
    }
    throw new TlsFatalAlert((short)80);
  }
  
  protected void checkMAC(long paramLong, short paramShort, byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, int paramInt4)
    throws IOException
  {
    if (Arrays.constantTimeAreEqual(Arrays.copyOfRange(paramArrayOfByte1, paramInt1, paramInt2), this.readMac.calculateMac(paramLong, paramShort, paramArrayOfByte2, paramInt3, paramInt4))) {
      return;
    }
    throw new TlsFatalAlert((short)20);
  }
  
  public byte[] decodeCiphertext(long paramLong, short paramShort, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.usesNonce) {
      updateIV(this.decryptCipher, false, paramLong);
    }
    int i = this.readMac.getSize();
    if (paramInt2 >= i)
    {
      i = paramInt2 - i;
      byte[] arrayOfByte = new byte[paramInt2];
      this.decryptCipher.processBytes(paramArrayOfByte, paramInt1, paramInt2, arrayOfByte, 0);
      checkMAC(paramLong, paramShort, arrayOfByte, i, paramInt2, arrayOfByte, 0, i);
      return Arrays.copyOfRange(arrayOfByte, 0, i);
    }
    throw new TlsFatalAlert((short)50);
  }
  
  public byte[] encodePlaintext(long paramLong, short paramShort, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.usesNonce) {
      updateIV(this.encryptCipher, true, paramLong);
    }
    byte[] arrayOfByte = new byte[paramInt2 + this.writeMac.getSize()];
    this.encryptCipher.processBytes(paramArrayOfByte, paramInt1, paramInt2, arrayOfByte, 0);
    paramArrayOfByte = this.writeMac.calculateMac(paramLong, paramShort, paramArrayOfByte, paramInt1, paramInt2);
    this.encryptCipher.processBytes(paramArrayOfByte, 0, paramArrayOfByte.length, arrayOfByte, paramInt2);
    return arrayOfByte;
  }
  
  public int getPlaintextLimit(int paramInt)
  {
    return paramInt - this.writeMac.getSize();
  }
  
  protected void updateIV(StreamCipher paramStreamCipher, boolean paramBoolean, long paramLong)
  {
    byte[] arrayOfByte = new byte[8];
    TlsUtils.writeUint64(paramLong, arrayOfByte, 0);
    paramStreamCipher.init(paramBoolean, new ParametersWithIV(null, arrayOfByte));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsStreamCipher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */