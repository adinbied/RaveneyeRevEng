package org.bouncycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.Hashtable;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.Integers;

public class TlsSRPUtils
{
  public static final Integer EXT_SRP = Integers.valueOf(12);
  
  public static void addSRPExtension(Hashtable paramHashtable, byte[] paramArrayOfByte)
    throws IOException
  {
    paramHashtable.put(EXT_SRP, createSRPExtension(paramArrayOfByte));
  }
  
  public static byte[] createSRPExtension(byte[] paramArrayOfByte)
    throws IOException
  {
    if (paramArrayOfByte != null) {
      return TlsUtils.encodeOpaque8(paramArrayOfByte);
    }
    throw new TlsFatalAlert((short)80);
  }
  
  public static byte[] getSRPExtension(Hashtable paramHashtable)
    throws IOException
  {
    paramHashtable = TlsUtils.getExtensionData(paramHashtable, EXT_SRP);
    if (paramHashtable == null) {
      return null;
    }
    return readSRPExtension(paramHashtable);
  }
  
  public static boolean isSRPCipherSuite(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static byte[] readSRPExtension(byte[] paramArrayOfByte)
    throws IOException
  {
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
      byte[] arrayOfByte = TlsUtils.readOpaque8(paramArrayOfByte);
      TlsProtocol.assertEmpty(paramArrayOfByte);
      return arrayOfByte;
    }
    throw new IllegalArgumentException("'extensionData' cannot be null");
  }
  
  public static BigInteger readSRPParameter(InputStream paramInputStream)
    throws IOException
  {
    return new BigInteger(1, TlsUtils.readOpaque16(paramInputStream));
  }
  
  public static void writeSRPParameter(BigInteger paramBigInteger, OutputStream paramOutputStream)
    throws IOException
  {
    TlsUtils.writeOpaque16(BigIntegers.asUnsignedByteArray(paramBigInteger), paramOutputStream);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsSRPUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */