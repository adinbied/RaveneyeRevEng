package org.bouncycastle.crypto.tls;

import java.io.IOException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.Arrays;

public class TlsNullCipher
  implements TlsCipher
{
  protected TlsContext context;
  protected TlsMac readMac;
  protected TlsMac writeMac;
  
  public TlsNullCipher(TlsContext paramTlsContext)
  {
    this.context = paramTlsContext;
    this.writeMac = null;
    this.readMac = null;
  }
  
  public TlsNullCipher(TlsContext paramTlsContext, Digest paramDigest1, Digest paramDigest2)
    throws IOException
  {
    int j = 1;
    int i;
    if (paramDigest1 == null) {
      i = 1;
    } else {
      i = 0;
    }
    if (paramDigest2 != null) {
      j = 0;
    }
    if (i == j)
    {
      this.context = paramTlsContext;
      TlsMac localTlsMac = null;
      if (paramDigest1 != null)
      {
        i = paramDigest1.getDigestSize() + paramDigest2.getDigestSize();
        Object localObject = TlsUtils.calculateKeyBlock(paramTlsContext, i);
        localTlsMac = new TlsMac(paramTlsContext, paramDigest1, (byte[])localObject, 0, paramDigest1.getDigestSize());
        j = paramDigest1.getDigestSize() + 0;
        localObject = new TlsMac(paramTlsContext, paramDigest2, (byte[])localObject, j, paramDigest2.getDigestSize());
        if (j + paramDigest2.getDigestSize() == i)
        {
          paramDigest1 = localTlsMac;
          paramDigest2 = (Digest)localObject;
        }
        else
        {
          throw new TlsFatalAlert((short)80);
        }
      }
      else
      {
        paramDigest2 = null;
        paramDigest1 = localTlsMac;
      }
      if (paramTlsContext.isServer())
      {
        this.writeMac = paramDigest2;
        this.readMac = paramDigest1;
        return;
      }
      this.writeMac = paramDigest1;
      this.readMac = paramDigest2;
      return;
    }
    throw new TlsFatalAlert((short)80);
  }
  
  public byte[] decodeCiphertext(long paramLong, short paramShort, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    TlsMac localTlsMac = this.readMac;
    if (localTlsMac == null) {
      return Arrays.copyOfRange(paramArrayOfByte, paramInt1, paramInt2 + paramInt1);
    }
    int i = localTlsMac.getSize();
    if (paramInt2 >= i)
    {
      i = paramInt2 - i;
      int j = paramInt1 + i;
      if (Arrays.constantTimeAreEqual(Arrays.copyOfRange(paramArrayOfByte, j, paramInt2 + paramInt1), this.readMac.calculateMac(paramLong, paramShort, paramArrayOfByte, paramInt1, i))) {
        return Arrays.copyOfRange(paramArrayOfByte, paramInt1, j);
      }
      throw new TlsFatalAlert((short)20);
    }
    throw new TlsFatalAlert((short)50);
  }
  
  public byte[] encodePlaintext(long paramLong, short paramShort, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    Object localObject = this.writeMac;
    if (localObject == null) {
      return Arrays.copyOfRange(paramArrayOfByte, paramInt1, paramInt2 + paramInt1);
    }
    localObject = ((TlsMac)localObject).calculateMac(paramLong, paramShort, paramArrayOfByte, paramInt1, paramInt2);
    byte[] arrayOfByte = new byte[localObject.length + paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    System.arraycopy(localObject, 0, arrayOfByte, paramInt2, localObject.length);
    return arrayOfByte;
  }
  
  public int getPlaintextLimit(int paramInt)
  {
    TlsMac localTlsMac = this.writeMac;
    int i = paramInt;
    if (localTlsMac != null) {
      i = paramInt - localTlsMac.getSize();
    }
    return i;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsNullCipher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */