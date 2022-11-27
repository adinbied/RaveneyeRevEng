package org.bouncycastle.crypto.tls;

import java.io.IOException;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.modes.AEADBlockCipher;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Arrays;

public class TlsAEADCipher
  implements TlsCipher
{
  static final int NONCE_DRAFT_CHACHA20_POLY1305 = 2;
  public static final int NONCE_RFC5288 = 1;
  protected TlsContext context;
  protected AEADBlockCipher decryptCipher;
  protected byte[] decryptImplicitNonce;
  protected AEADBlockCipher encryptCipher;
  protected byte[] encryptImplicitNonce;
  protected int macSize;
  protected int nonceMode;
  protected int record_iv_length;
  
  public TlsAEADCipher(TlsContext paramTlsContext, AEADBlockCipher paramAEADBlockCipher1, AEADBlockCipher paramAEADBlockCipher2, int paramInt1, int paramInt2)
    throws IOException
  {
    this(paramTlsContext, paramAEADBlockCipher1, paramAEADBlockCipher2, paramInt1, paramInt2, 1);
  }
  
  TlsAEADCipher(TlsContext paramTlsContext, AEADBlockCipher paramAEADBlockCipher1, AEADBlockCipher paramAEADBlockCipher2, int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    if (TlsUtils.isTLSv12(paramTlsContext))
    {
      this.nonceMode = paramInt3;
      if (paramInt3 != 1)
      {
        if (paramInt3 == 2)
        {
          paramInt3 = 12;
          this.record_iv_length = 0;
        }
        else
        {
          throw new TlsFatalAlert((short)80);
        }
      }
      else
      {
        paramInt3 = 4;
        this.record_iv_length = 8;
      }
      this.context = paramTlsContext;
      this.macSize = paramInt2;
      int i = paramInt1 * 2 + paramInt3 * 2;
      byte[] arrayOfByte2 = TlsUtils.calculateKeyBlock(paramTlsContext, i);
      Object localObject1 = new KeyParameter(arrayOfByte2, 0, paramInt1);
      int j = paramInt1 + 0;
      Object localObject2 = new KeyParameter(arrayOfByte2, j, paramInt1);
      j += paramInt1;
      paramInt1 = j + paramInt3;
      byte[] arrayOfByte1 = Arrays.copyOfRange(arrayOfByte2, j, paramInt1);
      j = paramInt1 + paramInt3;
      arrayOfByte2 = Arrays.copyOfRange(arrayOfByte2, paramInt1, j);
      if (j == i)
      {
        if (paramTlsContext.isServer())
        {
          this.encryptCipher = paramAEADBlockCipher2;
          this.decryptCipher = paramAEADBlockCipher1;
          this.encryptImplicitNonce = arrayOfByte2;
          this.decryptImplicitNonce = arrayOfByte1;
          paramTlsContext = (TlsContext)localObject1;
          localObject1 = localObject2;
          localObject2 = paramTlsContext;
        }
        else
        {
          this.encryptCipher = paramAEADBlockCipher1;
          this.decryptCipher = paramAEADBlockCipher2;
          this.encryptImplicitNonce = arrayOfByte1;
          this.decryptImplicitNonce = arrayOfByte2;
        }
        paramTlsContext = new byte[paramInt3 + this.record_iv_length];
        paramAEADBlockCipher1 = this.encryptCipher;
        paramInt1 = paramInt2 * 8;
        paramAEADBlockCipher1.init(true, new AEADParameters((KeyParameter)localObject1, paramInt1, paramTlsContext));
        this.decryptCipher.init(false, new AEADParameters((KeyParameter)localObject2, paramInt1, paramTlsContext));
        return;
      }
      throw new TlsFatalAlert((short)80);
    }
    throw new TlsFatalAlert((short)80);
  }
  
  public byte[] decodeCiphertext(long paramLong, short paramShort, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (getPlaintextLimit(paramInt2) >= 0)
    {
      byte[] arrayOfByte1 = this.decryptImplicitNonce;
      int i = arrayOfByte1.length + this.record_iv_length;
      Object localObject = new byte[i];
      int j = this.nonceMode;
      if (j != 1)
      {
        if (j == 2)
        {
          TlsUtils.writeUint64(paramLong, (byte[])localObject, i - 8);
          i = 0;
          for (;;)
          {
            arrayOfByte1 = this.decryptImplicitNonce;
            if (i >= arrayOfByte1.length) {
              break;
            }
            j = localObject[i];
            localObject[i] = ((byte)(arrayOfByte1[i] ^ j));
            i += 1;
          }
        }
        else
        {
          throw new TlsFatalAlert((short)80);
        }
      }
      else
      {
        System.arraycopy(arrayOfByte1, 0, localObject, 0, arrayOfByte1.length);
        j = this.record_iv_length;
        System.arraycopy(paramArrayOfByte, paramInt1, localObject, i - j, j);
      }
      i = this.record_iv_length;
      j = paramInt2 - i;
      paramInt2 = this.decryptCipher.getOutputSize(j);
      arrayOfByte1 = new byte[paramInt2];
      byte[] arrayOfByte2 = getAdditionalData(paramLong, paramShort, paramInt2);
      localObject = new AEADParameters(null, this.macSize * 8, (byte[])localObject, arrayOfByte2);
      try
      {
        this.decryptCipher.init(false, (CipherParameters)localObject);
        paramInt1 = this.decryptCipher.processBytes(paramArrayOfByte, paramInt1 + i, j, arrayOfByte1, 0) + 0;
        i = this.decryptCipher.doFinal(arrayOfByte1, paramInt1);
        if (paramInt1 + i == paramInt2) {
          return arrayOfByte1;
        }
        throw new TlsFatalAlert((short)80);
      }
      catch (Exception paramArrayOfByte)
      {
        throw new TlsFatalAlert((short)20, paramArrayOfByte);
      }
    }
    throw new TlsFatalAlert((short)50);
  }
  
  public byte[] encodePlaintext(long paramLong, short paramShort, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    byte[] arrayOfByte1 = this.encryptImplicitNonce;
    int j = arrayOfByte1.length + this.record_iv_length;
    Object localObject = new byte[j];
    int i = this.nonceMode;
    if (i != 1)
    {
      if (i == 2)
      {
        TlsUtils.writeUint64(paramLong, (byte[])localObject, j - 8);
        i = 0;
        for (;;)
        {
          arrayOfByte1 = this.encryptImplicitNonce;
          if (i >= arrayOfByte1.length) {
            break;
          }
          k = localObject[i];
          localObject[i] = ((byte)(arrayOfByte1[i] ^ k));
          i += 1;
        }
      }
      throw new TlsFatalAlert((short)80);
    }
    System.arraycopy(arrayOfByte1, 0, localObject, 0, arrayOfByte1.length);
    TlsUtils.writeUint64(paramLong, (byte[])localObject, this.encryptImplicitNonce.length);
    i = this.encryptCipher.getOutputSize(paramInt2);
    int k = this.record_iv_length;
    i = k + i;
    arrayOfByte1 = new byte[i];
    if (k != 0) {
      System.arraycopy(localObject, j - k, arrayOfByte1, 0, k);
    }
    j = this.record_iv_length;
    byte[] arrayOfByte2 = getAdditionalData(paramLong, paramShort, paramInt2);
    localObject = new AEADParameters(null, this.macSize * 8, (byte[])localObject, arrayOfByte2);
    try
    {
      this.encryptCipher.init(true, (CipherParameters)localObject);
      paramInt1 = j + this.encryptCipher.processBytes(paramArrayOfByte, paramInt1, paramInt2, arrayOfByte1, j);
      paramInt2 = this.encryptCipher.doFinal(arrayOfByte1, paramInt1);
      if (paramInt1 + paramInt2 == i) {
        return arrayOfByte1;
      }
      throw new TlsFatalAlert((short)80);
    }
    catch (Exception paramArrayOfByte)
    {
      throw new TlsFatalAlert((short)80, paramArrayOfByte);
    }
  }
  
  protected byte[] getAdditionalData(long paramLong, short paramShort, int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = new byte[13];
    TlsUtils.writeUint64(paramLong, arrayOfByte, 0);
    TlsUtils.writeUint8(paramShort, arrayOfByte, 8);
    TlsUtils.writeVersion(this.context.getServerVersion(), arrayOfByte, 9);
    TlsUtils.writeUint16(paramInt, arrayOfByte, 11);
    return arrayOfByte;
  }
  
  public int getPlaintextLimit(int paramInt)
  {
    return paramInt - this.macSize - this.record_iv_length;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsAEADCipher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */