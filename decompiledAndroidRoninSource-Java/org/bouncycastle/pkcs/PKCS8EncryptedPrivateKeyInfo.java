package org.bouncycastle.pkcs;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.pkcs.EncryptedPrivateKeyInfo;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.operator.InputDecryptor;
import org.bouncycastle.operator.InputDecryptorProvider;
import org.bouncycastle.util.io.Streams;

public class PKCS8EncryptedPrivateKeyInfo
{
  private EncryptedPrivateKeyInfo encryptedPrivateKeyInfo;
  
  public PKCS8EncryptedPrivateKeyInfo(EncryptedPrivateKeyInfo paramEncryptedPrivateKeyInfo)
  {
    this.encryptedPrivateKeyInfo = paramEncryptedPrivateKeyInfo;
  }
  
  public PKCS8EncryptedPrivateKeyInfo(byte[] paramArrayOfByte)
    throws IOException
  {
    this(parseBytes(paramArrayOfByte));
  }
  
  private static EncryptedPrivateKeyInfo parseBytes(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      paramArrayOfByte = EncryptedPrivateKeyInfo.getInstance(ASN1Primitive.fromByteArray(paramArrayOfByte));
      return paramArrayOfByte;
    }
    catch (IllegalArgumentException paramArrayOfByte)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("malformed data: ");
      localStringBuilder.append(paramArrayOfByte.getMessage());
      throw new PKCSIOException(localStringBuilder.toString(), paramArrayOfByte);
    }
    catch (ClassCastException paramArrayOfByte)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("malformed data: ");
      localStringBuilder.append(paramArrayOfByte.getMessage());
      throw new PKCSIOException(localStringBuilder.toString(), paramArrayOfByte);
    }
  }
  
  public PrivateKeyInfo decryptPrivateKeyInfo(InputDecryptorProvider paramInputDecryptorProvider)
    throws PKCSException
  {
    try
    {
      paramInputDecryptorProvider = PrivateKeyInfo.getInstance(Streams.readAll(paramInputDecryptorProvider.get(this.encryptedPrivateKeyInfo.getEncryptionAlgorithm()).getInputStream(new ByteArrayInputStream(this.encryptedPrivateKeyInfo.getEncryptedData()))));
      return paramInputDecryptorProvider;
    }
    catch (Exception paramInputDecryptorProvider)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unable to read encrypted data: ");
      localStringBuilder.append(paramInputDecryptorProvider.getMessage());
      throw new PKCSException(localStringBuilder.toString(), paramInputDecryptorProvider);
    }
  }
  
  public byte[] getEncoded()
    throws IOException
  {
    return this.encryptedPrivateKeyInfo.getEncoded();
  }
  
  public EncryptedPrivateKeyInfo toASN1Structure()
  {
    return this.encryptedPrivateKeyInfo;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pkcs\PKCS8EncryptedPrivateKeyInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */