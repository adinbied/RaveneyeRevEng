package org.bouncycastle.crypto.util;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.util.Arrays;

class DerUtil
{
  static ASN1OctetString getOctetString(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return new DEROctetString(new byte[0]);
    }
    return new DEROctetString(Arrays.clone(paramArrayOfByte));
  }
  
  static byte[] toByteArray(final ASN1Primitive paramASN1Primitive)
  {
    try
    {
      paramASN1Primitive = paramASN1Primitive.getEncoded();
      return paramASN1Primitive;
    }
    catch (IOException paramASN1Primitive)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Cannot get encoding: ");
      localStringBuilder.append(paramASN1Primitive.getMessage());
      throw new IllegalStateException(localStringBuilder.toString())
      {
        public Throwable getCause()
        {
          return paramASN1Primitive;
        }
      };
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypt\\util\DerUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */