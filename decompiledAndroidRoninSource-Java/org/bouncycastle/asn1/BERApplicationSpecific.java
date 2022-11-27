package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class BERApplicationSpecific
  extends ASN1ApplicationSpecific
{
  public BERApplicationSpecific(int paramInt, ASN1Encodable paramASN1Encodable)
    throws IOException
  {
    this(true, paramInt, paramASN1Encodable);
  }
  
  public BERApplicationSpecific(int paramInt, ASN1EncodableVector paramASN1EncodableVector)
  {
    super(true, paramInt, getEncodedVector(paramASN1EncodableVector));
  }
  
  public BERApplicationSpecific(boolean paramBoolean, int paramInt, ASN1Encodable paramASN1Encodable)
    throws IOException
  {
    super(bool, paramInt, getEncoding(paramBoolean, paramASN1Encodable));
  }
  
  BERApplicationSpecific(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte)
  {
    super(paramBoolean, paramInt, paramArrayOfByte);
  }
  
  private static byte[] getEncodedVector(ASN1EncodableVector paramASN1EncodableVector)
  {
    Object localObject = new ByteArrayOutputStream();
    int i = 0;
    while (i != paramASN1EncodableVector.size()) {
      try
      {
        ((ByteArrayOutputStream)localObject).write(((ASN1Object)paramASN1EncodableVector.get(i)).getEncoded("BER"));
        i += 1;
      }
      catch (IOException paramASN1EncodableVector)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("malformed object: ");
        ((StringBuilder)localObject).append(paramASN1EncodableVector);
        throw new ASN1ParsingException(((StringBuilder)localObject).toString(), paramASN1EncodableVector);
      }
    }
    return ((ByteArrayOutputStream)localObject).toByteArray();
  }
  
  private static byte[] getEncoding(boolean paramBoolean, ASN1Encodable paramASN1Encodable)
    throws IOException
  {
    paramASN1Encodable = paramASN1Encodable.toASN1Primitive().getEncoded("BER");
    if (paramBoolean) {
      return paramASN1Encodable;
    }
    int i = getLengthOfHeader(paramASN1Encodable);
    int j = paramASN1Encodable.length - i;
    byte[] arrayOfByte = new byte[j];
    System.arraycopy(paramASN1Encodable, i, arrayOfByte, 0, j);
    return arrayOfByte;
  }
  
  void encode(ASN1OutputStream paramASN1OutputStream)
    throws IOException
  {
    int i;
    if (this.isConstructed) {
      i = 96;
    } else {
      i = 64;
    }
    paramASN1OutputStream.writeTag(i, this.tag);
    paramASN1OutputStream.write(128);
    paramASN1OutputStream.write(this.octets);
    paramASN1OutputStream.write(0);
    paramASN1OutputStream.write(0);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\BERApplicationSpecific.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */