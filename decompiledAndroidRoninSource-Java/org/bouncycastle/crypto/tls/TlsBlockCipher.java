package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.security.SecureRandom;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.prng.RandomGenerator;
import org.bouncycastle.util.Arrays;

public class TlsBlockCipher
  implements TlsCipher
{
  protected TlsContext context;
  protected BlockCipher decryptCipher;
  protected BlockCipher encryptCipher;
  protected boolean encryptThenMAC;
  protected byte[] randomData;
  protected TlsMac readMac;
  protected boolean useExplicitIV;
  protected TlsMac writeMac;
  
  public TlsBlockCipher(TlsContext paramTlsContext, BlockCipher paramBlockCipher1, BlockCipher paramBlockCipher2, Digest paramDigest1, Digest paramDigest2, int paramInt)
    throws IOException
  {
    this.context = paramTlsContext;
    this.randomData = new byte['Ā'];
    paramTlsContext.getNonceRandomGenerator().nextBytes(this.randomData);
    this.useExplicitIV = TlsUtils.isTLSv11(paramTlsContext);
    this.encryptThenMAC = paramTlsContext.getSecurityParameters().encryptThenMAC;
    int j = paramInt * 2 + paramDigest1.getDigestSize() + paramDigest2.getDigestSize();
    int i = j;
    if (!this.useExplicitIV) {
      i = j + (paramBlockCipher1.getBlockSize() + paramBlockCipher2.getBlockSize());
    }
    byte[] arrayOfByte = TlsUtils.calculateKeyBlock(paramTlsContext, i);
    TlsMac localTlsMac1 = new TlsMac(paramTlsContext, paramDigest1, arrayOfByte, 0, paramDigest1.getDigestSize());
    j = paramDigest1.getDigestSize() + 0;
    TlsMac localTlsMac2 = new TlsMac(paramTlsContext, paramDigest2, arrayOfByte, j, paramDigest2.getDigestSize());
    j += paramDigest2.getDigestSize();
    KeyParameter localKeyParameter1 = new KeyParameter(arrayOfByte, j, paramInt);
    j += paramInt;
    KeyParameter localKeyParameter2 = new KeyParameter(arrayOfByte, j, paramInt);
    paramInt = j + paramInt;
    if (this.useExplicitIV)
    {
      paramDigest1 = new byte[paramBlockCipher1.getBlockSize()];
      paramDigest2 = new byte[paramBlockCipher2.getBlockSize()];
    }
    else
    {
      paramDigest1 = Arrays.copyOfRange(arrayOfByte, paramInt, paramBlockCipher1.getBlockSize() + paramInt);
      paramInt += paramBlockCipher1.getBlockSize();
      paramDigest2 = Arrays.copyOfRange(arrayOfByte, paramInt, paramBlockCipher2.getBlockSize() + paramInt);
      paramInt += paramBlockCipher2.getBlockSize();
    }
    if (paramInt == i)
    {
      if (paramTlsContext.isServer())
      {
        this.writeMac = localTlsMac2;
        this.readMac = localTlsMac1;
        this.encryptCipher = paramBlockCipher2;
        this.decryptCipher = paramBlockCipher1;
        paramBlockCipher1 = new ParametersWithIV(localKeyParameter2, paramDigest2);
        paramTlsContext = new ParametersWithIV(localKeyParameter1, paramDigest1);
      }
      else
      {
        this.writeMac = localTlsMac1;
        this.readMac = localTlsMac2;
        this.encryptCipher = paramBlockCipher1;
        this.decryptCipher = paramBlockCipher2;
        paramBlockCipher1 = new ParametersWithIV(localKeyParameter1, paramDigest1);
        paramTlsContext = new ParametersWithIV(localKeyParameter2, paramDigest2);
      }
      this.encryptCipher.init(true, paramBlockCipher1);
      this.decryptCipher.init(false, paramTlsContext);
      return;
    }
    throw new TlsFatalAlert((short)80);
  }
  
  protected int checkPaddingConstantTime(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k = paramInt1 + paramInt2;
    int j = paramArrayOfByte[(k - 1)];
    int i = (j & 0xFF) + 1;
    if (((TlsUtils.isSSL(this.context)) && (i > paramInt3)) || (paramInt4 + i > paramInt2))
    {
      paramInt2 = 0;
      paramInt1 = 0;
      i = 0;
      paramInt4 = paramInt1;
    }
    else
    {
      paramInt2 = k - i;
      paramInt1 = 0;
    }
    for (;;)
    {
      paramInt3 = paramInt2 + 1;
      paramInt1 = (byte)(paramArrayOfByte[paramInt2] ^ j | paramInt1);
      if (paramInt3 >= k)
      {
        paramInt3 = i;
        paramInt2 = paramInt3;
        paramInt4 = paramInt1;
        if (paramInt1 != 0)
        {
          paramInt2 = paramInt3;
          break;
        }
        paramArrayOfByte = this.randomData;
        while (paramInt2 < 256)
        {
          paramInt4 = (byte)(paramArrayOfByte[paramInt2] ^ j | paramInt4);
          paramInt2 += 1;
        }
        paramArrayOfByte[0] = ((byte)(paramArrayOfByte[0] ^ paramInt4));
        return i;
      }
      paramInt2 = paramInt3;
    }
  }
  
  protected int chooseExtraPadBlocks(SecureRandom paramSecureRandom, int paramInt)
  {
    return Math.min(lowestBitSet(paramSecureRandom.nextInt()), paramInt);
  }
  
  public byte[] decodeCiphertext(long paramLong, short paramShort, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int k = paramInt1;
    int n = this.decryptCipher.getBlockSize();
    int m = this.readMac.getSize();
    int i;
    if (this.encryptThenMAC) {
      i = n + m;
    } else {
      i = Math.max(n, m + 1);
    }
    int j = i;
    if (this.useExplicitIV) {
      j = i + n;
    }
    if (paramInt2 >= j)
    {
      if (this.encryptThenMAC) {
        i = paramInt2 - m;
      } else {
        i = paramInt2;
      }
      if (i % n == 0)
      {
        Object localObject;
        if (this.encryptThenMAC)
        {
          j = k + paramInt2;
          localObject = Arrays.copyOfRange(paramArrayOfByte, j - m, j);
          if ((Arrays.constantTimeAreEqual(this.readMac.calculateMac(paramLong, paramShort, paramArrayOfByte, paramInt1, paramInt2 - m), (byte[])localObject) ^ true)) {
            throw new TlsFatalAlert((short)20);
          }
        }
        paramInt1 = k;
        j = i;
        if (this.useExplicitIV)
        {
          this.decryptCipher.init(false, new ParametersWithIV(null, paramArrayOfByte, k, n));
          paramInt1 = k + n;
          j = i - n;
        }
        paramInt2 = 0;
        while (paramInt2 < j)
        {
          localObject = this.decryptCipher;
          i = paramInt1 + paramInt2;
          ((BlockCipher)localObject).processBlock(paramArrayOfByte, i, paramArrayOfByte, i);
          paramInt2 += n;
        }
        if (this.encryptThenMAC) {
          paramInt2 = 0;
        } else {
          paramInt2 = m;
        }
        i = checkPaddingConstantTime(paramArrayOfByte, paramInt1, j, n, paramInt2);
        if (i == 0) {
          paramInt2 = 1;
        } else {
          paramInt2 = 0;
        }
        k = j - i;
        if (!this.encryptThenMAC)
        {
          i = k - m;
          k = paramInt1 + i;
          localObject = Arrays.copyOfRange(paramArrayOfByte, k, k + m);
          j = paramInt2 | Arrays.constantTimeAreEqual(this.readMac.calculateMacConstantTime(paramLong, paramShort, paramArrayOfByte, paramInt1, i, j - m, this.randomData), (byte[])localObject) ^ true;
          paramInt2 = i;
          i = j;
        }
        else
        {
          i = paramInt2;
          paramInt2 = k;
        }
        if (i == 0) {
          return Arrays.copyOfRange(paramArrayOfByte, paramInt1, paramInt1 + paramInt2);
        }
        throw new TlsFatalAlert((short)20);
      }
      throw new TlsFatalAlert((short)21);
    }
    throw new TlsFatalAlert((short)50);
  }
  
  public byte[] encodePlaintext(long paramLong, short paramShort, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int n = this.encryptCipher.getBlockSize();
    int j = this.writeMac.getSize();
    Object localObject = this.context.getServerVersion();
    if (!this.encryptThenMAC) {
      i = paramInt2 + j;
    } else {
      i = paramInt2;
    }
    int i = n - 1 - i % n;
    int k = i;
    if (!((ProtocolVersion)localObject).isDTLS())
    {
      k = i;
      if (!((ProtocolVersion)localObject).isSSL())
      {
        k = (255 - i) / n;
        k = i + chooseExtraPadBlocks(this.context.getSecureRandom(), k) * n;
      }
    }
    j = j + paramInt2 + k + 1;
    i = j;
    if (this.useExplicitIV) {
      i = j + n;
    }
    localObject = new byte[i];
    if (this.useExplicitIV)
    {
      byte[] arrayOfByte = new byte[n];
      this.context.getNonceRandomGenerator().nextBytes(arrayOfByte);
      this.encryptCipher.init(true, new ParametersWithIV(null, arrayOfByte));
      System.arraycopy(arrayOfByte, 0, localObject, 0, n);
      i = n + 0;
    }
    else
    {
      i = 0;
    }
    System.arraycopy(paramArrayOfByte, paramInt1, localObject, i, paramInt2);
    int m = i + paramInt2;
    j = m;
    if (!this.encryptThenMAC)
    {
      paramArrayOfByte = this.writeMac.calculateMac(paramLong, paramShort, paramArrayOfByte, paramInt1, paramInt2);
      System.arraycopy(paramArrayOfByte, 0, localObject, m, paramArrayOfByte.length);
      j = m + paramArrayOfByte.length;
    }
    paramInt1 = j;
    paramInt2 = 0;
    for (;;)
    {
      j = i;
      if (paramInt2 > k) {
        break;
      }
      localObject[paramInt1] = ((byte)k);
      paramInt2 += 1;
      paramInt1 += 1;
    }
    while (j < paramInt1)
    {
      this.encryptCipher.processBlock((byte[])localObject, j, (byte[])localObject, j);
      j += n;
    }
    if (this.encryptThenMAC)
    {
      paramArrayOfByte = this.writeMac.calculateMac(paramLong, paramShort, (byte[])localObject, 0, paramInt1);
      System.arraycopy(paramArrayOfByte, 0, localObject, paramInt1, paramArrayOfByte.length);
      paramInt1 = paramArrayOfByte.length;
      return (byte[])localObject;
    }
    return (byte[])localObject;
  }
  
  public int getPlaintextLimit(int paramInt)
  {
    int j = this.encryptCipher.getBlockSize();
    int k = this.writeMac.getSize();
    int i = paramInt;
    if (this.useExplicitIV) {
      i = paramInt - j;
    }
    if (this.encryptThenMAC)
    {
      paramInt = i - k;
      paramInt -= paramInt % j;
    }
    else
    {
      paramInt = i - i % j - k;
    }
    return paramInt - 1;
  }
  
  public TlsMac getReadMac()
  {
    return this.readMac;
  }
  
  public TlsMac getWriteMac()
  {
    return this.writeMac;
  }
  
  protected int lowestBitSet(int paramInt)
  {
    if (paramInt == 0) {
      return 32;
    }
    int i = 0;
    while ((paramInt & 0x1) == 0)
    {
      i += 1;
      paramInt >>= 1;
    }
    return i;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsBlockCipher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */