package org.bouncycastle.crypto.tls;

import java.io.IOException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.engines.ChaCha7539Engine;
import org.bouncycastle.crypto.macs.Poly1305;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

public class Chacha20Poly1305
  implements TlsCipher
{
  private static final byte[] ZEROES = new byte[15];
  protected TlsContext context;
  protected ChaCha7539Engine decryptCipher;
  protected byte[] decryptIV;
  protected ChaCha7539Engine encryptCipher;
  protected byte[] encryptIV;
  
  public Chacha20Poly1305(TlsContext paramTlsContext)
    throws IOException
  {
    if (TlsUtils.isTLSv12(paramTlsContext))
    {
      this.context = paramTlsContext;
      byte[] arrayOfByte2 = TlsUtils.calculateKeyBlock(paramTlsContext, 88);
      KeyParameter localKeyParameter1 = new KeyParameter(arrayOfByte2, 0, 32);
      KeyParameter localKeyParameter2 = new KeyParameter(arrayOfByte2, 32, 32);
      byte[] arrayOfByte1 = Arrays.copyOfRange(arrayOfByte2, 64, 76);
      arrayOfByte2 = Arrays.copyOfRange(arrayOfByte2, 76, 88);
      this.encryptCipher = new ChaCha7539Engine();
      this.decryptCipher = new ChaCha7539Engine();
      if (paramTlsContext.isServer())
      {
        this.encryptIV = arrayOfByte2;
        this.decryptIV = arrayOfByte1;
        paramTlsContext = localKeyParameter2;
        localKeyParameter2 = localKeyParameter1;
      }
      else
      {
        this.encryptIV = arrayOfByte1;
        this.decryptIV = arrayOfByte2;
        paramTlsContext = localKeyParameter1;
      }
      this.encryptCipher.init(true, new ParametersWithIV(paramTlsContext, this.encryptIV));
      this.decryptCipher.init(false, new ParametersWithIV(localKeyParameter2, this.decryptIV));
      return;
    }
    throw new TlsFatalAlert((short)80);
  }
  
  protected byte[] calculateNonce(long paramLong, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[12];
    TlsUtils.writeUint64(paramLong, arrayOfByte, 4);
    int i = 0;
    while (i < 12)
    {
      arrayOfByte[i] = ((byte)(arrayOfByte[i] ^ paramArrayOfByte[i]));
      i += 1;
    }
    return arrayOfByte;
  }
  
  protected byte[] calculateRecordMAC(KeyParameter paramKeyParameter, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    Poly1305 localPoly1305 = new Poly1305();
    localPoly1305.init(paramKeyParameter);
    updateRecordMACText(localPoly1305, paramArrayOfByte1, 0, paramArrayOfByte1.length);
    updateRecordMACText(localPoly1305, paramArrayOfByte2, paramInt1, paramInt2);
    updateRecordMACLength(localPoly1305, paramArrayOfByte1.length);
    updateRecordMACLength(localPoly1305, paramInt2);
    paramKeyParameter = new byte[localPoly1305.getMacSize()];
    localPoly1305.doFinal(paramKeyParameter, 0);
    return paramKeyParameter;
  }
  
  public byte[] decodeCiphertext(long paramLong, short paramShort, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (getPlaintextLimit(paramInt2) >= 0)
    {
      Object localObject = initRecord(this.decryptCipher, false, paramLong, this.decryptIV);
      int i = paramInt2 - 16;
      if (Arrays.constantTimeAreEqual(calculateRecordMAC((KeyParameter)localObject, getAdditionalData(paramLong, paramShort, i), paramArrayOfByte, paramInt1, i), Arrays.copyOfRange(paramArrayOfByte, paramInt1 + i, paramInt1 + paramInt2)))
      {
        localObject = new byte[i];
        this.decryptCipher.processBytes(paramArrayOfByte, paramInt1, i, (byte[])localObject, 0);
        return (byte[])localObject;
      }
      throw new TlsFatalAlert((short)20);
    }
    throw new TlsFatalAlert((short)50);
  }
  
  public byte[] encodePlaintext(long paramLong, short paramShort, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    KeyParameter localKeyParameter = initRecord(this.encryptCipher, true, paramLong, this.encryptIV);
    byte[] arrayOfByte = new byte[paramInt2 + 16];
    this.encryptCipher.processBytes(paramArrayOfByte, paramInt1, paramInt2, arrayOfByte, 0);
    paramArrayOfByte = calculateRecordMAC(localKeyParameter, getAdditionalData(paramLong, paramShort, paramInt2), arrayOfByte, 0, paramInt2);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, paramInt2, paramArrayOfByte.length);
    return arrayOfByte;
  }
  
  protected KeyParameter generateRecordMACKey(StreamCipher paramStreamCipher)
  {
    byte[] arrayOfByte = new byte[64];
    paramStreamCipher.processBytes(arrayOfByte, 0, 64, arrayOfByte, 0);
    paramStreamCipher = new KeyParameter(arrayOfByte, 0, 32);
    Arrays.fill(arrayOfByte, (byte)0);
    return paramStreamCipher;
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
    return paramInt - 16;
  }
  
  protected KeyParameter initRecord(StreamCipher paramStreamCipher, boolean paramBoolean, long paramLong, byte[] paramArrayOfByte)
  {
    paramStreamCipher.init(paramBoolean, new ParametersWithIV(null, calculateNonce(paramLong, paramArrayOfByte)));
    return generateRecordMACKey(paramStreamCipher);
  }
  
  protected void updateRecordMACLength(Mac paramMac, int paramInt)
  {
    byte[] arrayOfByte = Pack.longToLittleEndian(paramInt & 0xFFFFFFFF);
    paramMac.update(arrayOfByte, 0, arrayOfByte.length);
  }
  
  protected void updateRecordMACText(Mac paramMac, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramMac.update(paramArrayOfByte, paramInt1, paramInt2);
    paramInt1 = paramInt2 % 16;
    if (paramInt1 != 0) {
      paramMac.update(ZEROES, 0, 16 - paramInt1);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\Chacha20Poly1305.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */