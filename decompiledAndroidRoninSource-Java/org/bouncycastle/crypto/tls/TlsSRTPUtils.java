package org.bouncycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import org.bouncycastle.util.Integers;

public class TlsSRTPUtils
{
  public static final Integer EXT_use_srtp = Integers.valueOf(14);
  
  public static void addUseSRTPExtension(Hashtable paramHashtable, UseSRTPData paramUseSRTPData)
    throws IOException
  {
    paramHashtable.put(EXT_use_srtp, createUseSRTPExtension(paramUseSRTPData));
  }
  
  public static byte[] createUseSRTPExtension(UseSRTPData paramUseSRTPData)
    throws IOException
  {
    if (paramUseSRTPData != null)
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      TlsUtils.writeUint16ArrayWithUint16Length(paramUseSRTPData.getProtectionProfiles(), localByteArrayOutputStream);
      TlsUtils.writeOpaque8(paramUseSRTPData.getMki(), localByteArrayOutputStream);
      return localByteArrayOutputStream.toByteArray();
    }
    throw new IllegalArgumentException("'useSRTPData' cannot be null");
  }
  
  public static UseSRTPData getUseSRTPExtension(Hashtable paramHashtable)
    throws IOException
  {
    paramHashtable = TlsUtils.getExtensionData(paramHashtable, EXT_use_srtp);
    if (paramHashtable == null) {
      return null;
    }
    return readUseSRTPExtension(paramHashtable);
  }
  
  public static UseSRTPData readUseSRTPExtension(byte[] paramArrayOfByte)
    throws IOException
  {
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
      int i = TlsUtils.readUint16(paramArrayOfByte);
      if ((i >= 2) && ((i & 0x1) == 0))
      {
        int[] arrayOfInt = TlsUtils.readUint16Array(i / 2, paramArrayOfByte);
        byte[] arrayOfByte = TlsUtils.readOpaque8(paramArrayOfByte);
        TlsProtocol.assertEmpty(paramArrayOfByte);
        return new UseSRTPData(arrayOfInt, arrayOfByte);
      }
      throw new TlsFatalAlert((short)50);
    }
    throw new IllegalArgumentException("'extensionData' cannot be null");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsSRTPUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */