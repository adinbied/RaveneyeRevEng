package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.Arrays;

public class ASN1Boolean
  extends ASN1Primitive
{
  public static final ASN1Boolean FALSE = new ASN1Boolean(false);
  private static final byte[] FALSE_VALUE;
  public static final ASN1Boolean TRUE = new ASN1Boolean(true);
  private static final byte[] TRUE_VALUE = { -1 };
  private final byte[] value;
  
  static
  {
    FALSE_VALUE = new byte[] { 0 };
  }
  
  public ASN1Boolean(boolean paramBoolean)
  {
    byte[] arrayOfByte;
    if (paramBoolean) {
      arrayOfByte = TRUE_VALUE;
    } else {
      arrayOfByte = FALSE_VALUE;
    }
    this.value = arrayOfByte;
  }
  
  ASN1Boolean(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length == 1)
    {
      if (paramArrayOfByte[0] == 0)
      {
        this.value = FALSE_VALUE;
        return;
      }
      if ((paramArrayOfByte[0] & 0xFF) == 255)
      {
        this.value = TRUE_VALUE;
        return;
      }
      this.value = Arrays.clone(paramArrayOfByte);
      return;
    }
    throw new IllegalArgumentException("byte value should have 1 byte in it");
  }
  
  static ASN1Boolean fromOctetString(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length == 1)
    {
      if (paramArrayOfByte[0] == 0) {
        return FALSE;
      }
      if ((paramArrayOfByte[0] & 0xFF) == 255) {
        return TRUE;
      }
      return new ASN1Boolean(paramArrayOfByte);
    }
    throw new IllegalArgumentException("BOOLEAN value should have 1 byte in it");
  }
  
  public static ASN1Boolean getInstance(int paramInt)
  {
    if (paramInt != 0) {
      return TRUE;
    }
    return FALSE;
  }
  
  public static ASN1Boolean getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof ASN1Boolean)))
    {
      if ((paramObject instanceof byte[]))
      {
        paramObject = (byte[])paramObject;
        try
        {
          paramObject = (ASN1Boolean)fromByteArray((byte[])paramObject);
          return (ASN1Boolean)paramObject;
        }
        catch (IOException paramObject)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("failed to construct boolean from byte[]: ");
          localStringBuilder.append(((IOException)paramObject).getMessage());
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("illegal object in getInstance: ");
      localStringBuilder.append(paramObject.getClass().getName());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return (ASN1Boolean)paramObject;
  }
  
  public static ASN1Boolean getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    paramASN1TaggedObject = paramASN1TaggedObject.getObject();
    if ((!paramBoolean) && (!(paramASN1TaggedObject instanceof ASN1Boolean))) {
      return fromOctetString(((ASN1OctetString)paramASN1TaggedObject).getOctets());
    }
    return getInstance(paramASN1TaggedObject);
  }
  
  public static ASN1Boolean getInstance(boolean paramBoolean)
  {
    if (paramBoolean) {
      return TRUE;
    }
    return FALSE;
  }
  
  protected boolean asn1Equals(ASN1Primitive paramASN1Primitive)
  {
    boolean bool3 = paramASN1Primitive instanceof ASN1Boolean;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (this.value[0] == ((ASN1Boolean)paramASN1Primitive).value[0]) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  void encode(ASN1OutputStream paramASN1OutputStream)
    throws IOException
  {
    paramASN1OutputStream.writeEncoded(1, this.value);
  }
  
  int encodedLength()
  {
    return 3;
  }
  
  public int hashCode()
  {
    return this.value[0];
  }
  
  boolean isConstructed()
  {
    return false;
  }
  
  public boolean isTrue()
  {
    byte[] arrayOfByte = this.value;
    boolean bool = false;
    if (arrayOfByte[0] != 0) {
      bool = true;
    }
    return bool;
  }
  
  public String toString()
  {
    if (this.value[0] != 0) {
      return "TRUE";
    }
    return "FALSE";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ASN1Boolean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */