package org.bouncycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import org.bouncycastle.util.Integers;

public class TlsExtensionsUtils
{
  public static final Integer EXT_encrypt_then_mac = Integers.valueOf(22);
  public static final Integer EXT_extended_master_secret = Integers.valueOf(23);
  public static final Integer EXT_heartbeat = Integers.valueOf(15);
  public static final Integer EXT_max_fragment_length = Integers.valueOf(1);
  public static final Integer EXT_padding = Integers.valueOf(21);
  public static final Integer EXT_server_name = Integers.valueOf(0);
  public static final Integer EXT_status_request = Integers.valueOf(5);
  public static final Integer EXT_truncated_hmac = Integers.valueOf(4);
  
  public static void addEncryptThenMACExtension(Hashtable paramHashtable)
  {
    paramHashtable.put(EXT_encrypt_then_mac, createEncryptThenMACExtension());
  }
  
  public static void addExtendedMasterSecretExtension(Hashtable paramHashtable)
  {
    paramHashtable.put(EXT_extended_master_secret, createExtendedMasterSecretExtension());
  }
  
  public static void addHeartbeatExtension(Hashtable paramHashtable, HeartbeatExtension paramHeartbeatExtension)
    throws IOException
  {
    paramHashtable.put(EXT_heartbeat, createHeartbeatExtension(paramHeartbeatExtension));
  }
  
  public static void addMaxFragmentLengthExtension(Hashtable paramHashtable, short paramShort)
    throws IOException
  {
    paramHashtable.put(EXT_max_fragment_length, createMaxFragmentLengthExtension(paramShort));
  }
  
  public static void addPaddingExtension(Hashtable paramHashtable, int paramInt)
    throws IOException
  {
    paramHashtable.put(EXT_padding, createPaddingExtension(paramInt));
  }
  
  public static void addServerNameExtension(Hashtable paramHashtable, ServerNameList paramServerNameList)
    throws IOException
  {
    paramHashtable.put(EXT_server_name, createServerNameExtension(paramServerNameList));
  }
  
  public static void addStatusRequestExtension(Hashtable paramHashtable, CertificateStatusRequest paramCertificateStatusRequest)
    throws IOException
  {
    paramHashtable.put(EXT_status_request, createStatusRequestExtension(paramCertificateStatusRequest));
  }
  
  public static void addTruncatedHMacExtension(Hashtable paramHashtable)
  {
    paramHashtable.put(EXT_truncated_hmac, createTruncatedHMacExtension());
  }
  
  public static byte[] createEmptyExtensionData()
  {
    return TlsUtils.EMPTY_BYTES;
  }
  
  public static byte[] createEncryptThenMACExtension()
  {
    return createEmptyExtensionData();
  }
  
  public static byte[] createExtendedMasterSecretExtension()
  {
    return createEmptyExtensionData();
  }
  
  public static byte[] createHeartbeatExtension(HeartbeatExtension paramHeartbeatExtension)
    throws IOException
  {
    if (paramHeartbeatExtension != null)
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramHeartbeatExtension.encode(localByteArrayOutputStream);
      return localByteArrayOutputStream.toByteArray();
    }
    throw new TlsFatalAlert((short)80);
  }
  
  public static byte[] createMaxFragmentLengthExtension(short paramShort)
    throws IOException
  {
    TlsUtils.checkUint8(paramShort);
    byte[] arrayOfByte = new byte[1];
    TlsUtils.writeUint8(paramShort, arrayOfByte, 0);
    return arrayOfByte;
  }
  
  public static byte[] createPaddingExtension(int paramInt)
    throws IOException
  {
    TlsUtils.checkUint16(paramInt);
    return new byte[paramInt];
  }
  
  public static byte[] createServerNameExtension(ServerNameList paramServerNameList)
    throws IOException
  {
    if (paramServerNameList != null)
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramServerNameList.encode(localByteArrayOutputStream);
      return localByteArrayOutputStream.toByteArray();
    }
    throw new TlsFatalAlert((short)80);
  }
  
  public static byte[] createStatusRequestExtension(CertificateStatusRequest paramCertificateStatusRequest)
    throws IOException
  {
    if (paramCertificateStatusRequest != null)
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramCertificateStatusRequest.encode(localByteArrayOutputStream);
      return localByteArrayOutputStream.toByteArray();
    }
    throw new TlsFatalAlert((short)80);
  }
  
  public static byte[] createTruncatedHMacExtension()
  {
    return createEmptyExtensionData();
  }
  
  public static Hashtable ensureExtensionsInitialised(Hashtable paramHashtable)
  {
    Hashtable localHashtable = paramHashtable;
    if (paramHashtable == null) {
      localHashtable = new Hashtable();
    }
    return localHashtable;
  }
  
  public static HeartbeatExtension getHeartbeatExtension(Hashtable paramHashtable)
    throws IOException
  {
    paramHashtable = TlsUtils.getExtensionData(paramHashtable, EXT_heartbeat);
    if (paramHashtable == null) {
      return null;
    }
    return readHeartbeatExtension(paramHashtable);
  }
  
  public static short getMaxFragmentLengthExtension(Hashtable paramHashtable)
    throws IOException
  {
    paramHashtable = TlsUtils.getExtensionData(paramHashtable, EXT_max_fragment_length);
    if (paramHashtable == null) {
      return -1;
    }
    return readMaxFragmentLengthExtension(paramHashtable);
  }
  
  public static int getPaddingExtension(Hashtable paramHashtable)
    throws IOException
  {
    paramHashtable = TlsUtils.getExtensionData(paramHashtable, EXT_padding);
    if (paramHashtable == null) {
      return -1;
    }
    return readPaddingExtension(paramHashtable);
  }
  
  public static ServerNameList getServerNameExtension(Hashtable paramHashtable)
    throws IOException
  {
    paramHashtable = TlsUtils.getExtensionData(paramHashtable, EXT_server_name);
    if (paramHashtable == null) {
      return null;
    }
    return readServerNameExtension(paramHashtable);
  }
  
  public static CertificateStatusRequest getStatusRequestExtension(Hashtable paramHashtable)
    throws IOException
  {
    paramHashtable = TlsUtils.getExtensionData(paramHashtable, EXT_status_request);
    if (paramHashtable == null) {
      return null;
    }
    return readStatusRequestExtension(paramHashtable);
  }
  
  public static boolean hasEncryptThenMACExtension(Hashtable paramHashtable)
    throws IOException
  {
    paramHashtable = TlsUtils.getExtensionData(paramHashtable, EXT_encrypt_then_mac);
    if (paramHashtable == null) {
      return false;
    }
    return readEncryptThenMACExtension(paramHashtable);
  }
  
  public static boolean hasExtendedMasterSecretExtension(Hashtable paramHashtable)
    throws IOException
  {
    paramHashtable = TlsUtils.getExtensionData(paramHashtable, EXT_extended_master_secret);
    if (paramHashtable == null) {
      return false;
    }
    return readExtendedMasterSecretExtension(paramHashtable);
  }
  
  public static boolean hasTruncatedHMacExtension(Hashtable paramHashtable)
    throws IOException
  {
    paramHashtable = TlsUtils.getExtensionData(paramHashtable, EXT_truncated_hmac);
    if (paramHashtable == null) {
      return false;
    }
    return readTruncatedHMacExtension(paramHashtable);
  }
  
  private static boolean readEmptyExtensionData(byte[] paramArrayOfByte)
    throws IOException
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return true;
      }
      throw new TlsFatalAlert((short)47);
    }
    throw new IllegalArgumentException("'extensionData' cannot be null");
  }
  
  public static boolean readEncryptThenMACExtension(byte[] paramArrayOfByte)
    throws IOException
  {
    return readEmptyExtensionData(paramArrayOfByte);
  }
  
  public static boolean readExtendedMasterSecretExtension(byte[] paramArrayOfByte)
    throws IOException
  {
    return readEmptyExtensionData(paramArrayOfByte);
  }
  
  public static HeartbeatExtension readHeartbeatExtension(byte[] paramArrayOfByte)
    throws IOException
  {
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
      HeartbeatExtension localHeartbeatExtension = HeartbeatExtension.parse(paramArrayOfByte);
      TlsProtocol.assertEmpty(paramArrayOfByte);
      return localHeartbeatExtension;
    }
    throw new IllegalArgumentException("'extensionData' cannot be null");
  }
  
  public static short readMaxFragmentLengthExtension(byte[] paramArrayOfByte)
    throws IOException
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 1) {
        return TlsUtils.readUint8(paramArrayOfByte, 0);
      }
      throw new TlsFatalAlert((short)50);
    }
    throw new IllegalArgumentException("'extensionData' cannot be null");
  }
  
  public static int readPaddingExtension(byte[] paramArrayOfByte)
    throws IOException
  {
    if (paramArrayOfByte != null)
    {
      int i = 0;
      while (i < paramArrayOfByte.length) {
        if (paramArrayOfByte[i] == 0) {
          i += 1;
        } else {
          throw new TlsFatalAlert((short)47);
        }
      }
      return paramArrayOfByte.length;
    }
    throw new IllegalArgumentException("'extensionData' cannot be null");
  }
  
  public static ServerNameList readServerNameExtension(byte[] paramArrayOfByte)
    throws IOException
  {
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
      ServerNameList localServerNameList = ServerNameList.parse(paramArrayOfByte);
      TlsProtocol.assertEmpty(paramArrayOfByte);
      return localServerNameList;
    }
    throw new IllegalArgumentException("'extensionData' cannot be null");
  }
  
  public static CertificateStatusRequest readStatusRequestExtension(byte[] paramArrayOfByte)
    throws IOException
  {
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
      CertificateStatusRequest localCertificateStatusRequest = CertificateStatusRequest.parse(paramArrayOfByte);
      TlsProtocol.assertEmpty(paramArrayOfByte);
      return localCertificateStatusRequest;
    }
    throw new IllegalArgumentException("'extensionData' cannot be null");
  }
  
  public static boolean readTruncatedHMacExtension(byte[] paramArrayOfByte)
    throws IOException
  {
    return readEmptyExtensionData(paramArrayOfByte);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsExtensionsUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */