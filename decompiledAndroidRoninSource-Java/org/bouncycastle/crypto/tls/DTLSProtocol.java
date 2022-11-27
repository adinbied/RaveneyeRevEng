package org.bouncycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.util.Arrays;

public abstract class DTLSProtocol
{
  protected final SecureRandom secureRandom;
  
  protected DTLSProtocol(SecureRandom paramSecureRandom)
  {
    if (paramSecureRandom != null)
    {
      this.secureRandom = paramSecureRandom;
      return;
    }
    throw new IllegalArgumentException("'secureRandom' cannot be null");
  }
  
  protected static void applyMaxFragmentLengthExtension(DTLSRecordLayer paramDTLSRecordLayer, short paramShort)
    throws IOException
  {
    if (paramShort >= 0)
    {
      if (MaxFragmentLength.isValid(paramShort))
      {
        paramDTLSRecordLayer.setPlaintextLimit(1 << paramShort + 8);
        return;
      }
      throw new TlsFatalAlert((short)80);
    }
  }
  
  protected static short evaluateMaxFragmentLengthExtension(boolean paramBoolean, Hashtable paramHashtable1, Hashtable paramHashtable2, short paramShort)
    throws IOException
  {
    short s = TlsExtensionsUtils.getMaxFragmentLengthExtension(paramHashtable2);
    if (s >= 0)
    {
      if (MaxFragmentLength.isValid(s))
      {
        if (paramBoolean) {
          break label44;
        }
        if (s == TlsExtensionsUtils.getMaxFragmentLengthExtension(paramHashtable1)) {
          return s;
        }
      }
      throw new TlsFatalAlert(paramShort);
    }
    label44:
    return s;
  }
  
  protected static byte[] generateCertificate(Certificate paramCertificate)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramCertificate.encode(localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  protected static byte[] generateSupplementalData(Vector paramVector)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    TlsProtocol.writeSupplementalData(localByteArrayOutputStream, paramVector);
    return localByteArrayOutputStream.toByteArray();
  }
  
  protected static void validateSelectedCipherSuite(int paramInt, short paramShort)
    throws IOException
  {
    paramInt = TlsUtils.getEncryptionAlgorithm(paramInt);
    if ((paramInt != 1) && (paramInt != 2)) {
      return;
    }
    throw new TlsFatalAlert(paramShort);
  }
  
  protected void processFinished(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws IOException
  {
    paramArrayOfByte1 = new ByteArrayInputStream(paramArrayOfByte1);
    byte[] arrayOfByte = TlsUtils.readFully(paramArrayOfByte2.length, paramArrayOfByte1);
    TlsProtocol.assertEmpty(paramArrayOfByte1);
    if (Arrays.constantTimeAreEqual(paramArrayOfByte2, arrayOfByte)) {
      return;
    }
    throw new TlsFatalAlert((short)40);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\DTLSProtocol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */