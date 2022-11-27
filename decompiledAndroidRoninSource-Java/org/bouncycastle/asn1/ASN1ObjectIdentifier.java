package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.bouncycastle.util.Arrays;

public class ASN1ObjectIdentifier
  extends ASN1Primitive
{
  private static final long LONG_LIMIT = 72057594037927808L;
  private static final ConcurrentMap<OidHandle, ASN1ObjectIdentifier> pool = new ConcurrentHashMap();
  private byte[] body;
  private final String identifier;
  
  public ASN1ObjectIdentifier(String paramString)
  {
    if (paramString != null)
    {
      if (isValidIdentifier(paramString))
      {
        this.identifier = paramString;
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("string ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" not an OID");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    throw new IllegalArgumentException("'identifier' cannot be null");
  }
  
  ASN1ObjectIdentifier(ASN1ObjectIdentifier paramASN1ObjectIdentifier, String paramString)
  {
    if (isValidBranchID(paramString, 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramASN1ObjectIdentifier.getId());
      localStringBuilder.append(".");
      localStringBuilder.append(paramString);
      this.identifier = localStringBuilder.toString();
      return;
    }
    paramASN1ObjectIdentifier = new StringBuilder();
    paramASN1ObjectIdentifier.append("string ");
    paramASN1ObjectIdentifier.append(paramString);
    paramASN1ObjectIdentifier.append(" not a valid OID branch");
    throw new IllegalArgumentException(paramASN1ObjectIdentifier.toString());
  }
  
  ASN1ObjectIdentifier(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 1;
    long l1 = 0L;
    int k = 0;
    Object localObject1 = null;
    while (k != paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[k] & 0xFF;
      if (l1 <= 72057594037927808L)
      {
        l1 += (j & 0x7F);
        if ((j & 0x80) == 0)
        {
          j = i;
          long l2 = l1;
          if (i != 0)
          {
            if (l1 < 40L)
            {
              localStringBuffer.append('0');
            }
            else if (l1 < 80L)
            {
              localStringBuffer.append('1');
              l1 -= 40L;
            }
            else
            {
              localStringBuffer.append('2');
              l1 -= 80L;
            }
            j = 0;
            l2 = l1;
          }
          localStringBuffer.append('.');
          localStringBuffer.append(l2);
          l1 = 0L;
          i = j;
        }
        else
        {
          l1 <<= 7;
        }
      }
      else
      {
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = BigInteger.valueOf(l1);
        }
        localObject2 = ((BigInteger)localObject2).or(BigInteger.valueOf(j & 0x7F));
        if ((j & 0x80) == 0)
        {
          j = i;
          localObject1 = localObject2;
          if (i != 0)
          {
            localStringBuffer.append('2');
            localObject1 = ((BigInteger)localObject2).subtract(BigInteger.valueOf(80L));
            j = 0;
          }
          localStringBuffer.append('.');
          localStringBuffer.append(localObject1);
          l1 = 0L;
          localObject1 = null;
          i = j;
        }
        else
        {
          localObject1 = ((BigInteger)localObject2).shiftLeft(7);
        }
      }
      k += 1;
    }
    this.identifier = localStringBuffer.toString();
    this.body = Arrays.clone(paramArrayOfByte);
  }
  
  private void doOutput(ByteArrayOutputStream paramByteArrayOutputStream)
  {
    OIDTokenizer localOIDTokenizer = new OIDTokenizer(this.identifier);
    int i = Integer.parseInt(localOIDTokenizer.nextToken()) * 40;
    String str = localOIDTokenizer.nextToken();
    if (str.length() <= 18) {
      writeField(paramByteArrayOutputStream, i + Long.parseLong(str));
    } else {
      writeField(paramByteArrayOutputStream, new BigInteger(str).add(BigInteger.valueOf(i)));
    }
    while (localOIDTokenizer.hasMoreTokens())
    {
      str = localOIDTokenizer.nextToken();
      if (str.length() <= 18) {
        writeField(paramByteArrayOutputStream, Long.parseLong(str));
      } else {
        writeField(paramByteArrayOutputStream, new BigInteger(str));
      }
    }
  }
  
  static ASN1ObjectIdentifier fromOctetString(byte[] paramArrayOfByte)
  {
    Object localObject = new OidHandle(paramArrayOfByte);
    ASN1ObjectIdentifier localASN1ObjectIdentifier = (ASN1ObjectIdentifier)pool.get(localObject);
    localObject = localASN1ObjectIdentifier;
    if (localASN1ObjectIdentifier == null) {
      localObject = new ASN1ObjectIdentifier(paramArrayOfByte);
    }
    return (ASN1ObjectIdentifier)localObject;
  }
  
  private byte[] getBody()
  {
    try
    {
      if (this.body == null)
      {
        localObject1 = new ByteArrayOutputStream();
        doOutput((ByteArrayOutputStream)localObject1);
        this.body = ((ByteArrayOutputStream)localObject1).toByteArray();
      }
      Object localObject1 = this.body;
      return (byte[])localObject1;
    }
    finally {}
  }
  
  public static ASN1ObjectIdentifier getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof ASN1ObjectIdentifier)))
    {
      if ((paramObject instanceof ASN1Encodable))
      {
        localObject = (ASN1Encodable)paramObject;
        if ((((ASN1Encodable)localObject).toASN1Primitive() instanceof ASN1ObjectIdentifier)) {
          return (ASN1ObjectIdentifier)((ASN1Encodable)localObject).toASN1Primitive();
        }
      }
      if ((paramObject instanceof byte[]))
      {
        paramObject = (byte[])paramObject;
        try
        {
          paramObject = (ASN1ObjectIdentifier)fromByteArray((byte[])paramObject);
          return (ASN1ObjectIdentifier)paramObject;
        }
        catch (IOException paramObject)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("failed to construct object identifier from byte[]: ");
          ((StringBuilder)localObject).append(((IOException)paramObject).getMessage());
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("illegal object in getInstance: ");
      ((StringBuilder)localObject).append(paramObject.getClass().getName());
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    return (ASN1ObjectIdentifier)paramObject;
  }
  
  public static ASN1ObjectIdentifier getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    ASN1Primitive localASN1Primitive = paramASN1TaggedObject.getObject();
    if ((!paramBoolean) && (!(localASN1Primitive instanceof ASN1ObjectIdentifier))) {
      return fromOctetString(ASN1OctetString.getInstance(paramASN1TaggedObject.getObject()).getOctets());
    }
    return getInstance(localASN1Primitive);
  }
  
  private static boolean isValidBranchID(String paramString, int paramInt)
  {
    int i = paramString.length();
    boolean bool;
    int j;
    do
    {
      for (bool = false;; bool = true)
      {
        i -= 1;
        if (i < paramInt) {
          break label54;
        }
        j = paramString.charAt(i);
        if ((48 > j) || (j > 57)) {
          break;
        }
      }
    } while ((j == 46) && (bool));
    return false;
    label54:
    return bool;
  }
  
  private static boolean isValidIdentifier(String paramString)
  {
    if (paramString.length() >= 3)
    {
      if (paramString.charAt(1) != '.') {
        return false;
      }
      int i = paramString.charAt(0);
      if (i >= 48)
      {
        if (i > 50) {
          return false;
        }
        return isValidBranchID(paramString, 2);
      }
    }
    return false;
  }
  
  private void writeField(ByteArrayOutputStream paramByteArrayOutputStream, long paramLong)
  {
    byte[] arrayOfByte = new byte[9];
    int i = (byte)((int)paramLong & 0x7F);
    int j = 8;
    arrayOfByte[8] = i;
    while (paramLong >= 128L)
    {
      paramLong >>= 7;
      j -= 1;
      arrayOfByte[j] = ((byte)((int)paramLong & 0x7F | 0x80));
    }
    paramByteArrayOutputStream.write(arrayOfByte, j, 9 - j);
  }
  
  private void writeField(ByteArrayOutputStream paramByteArrayOutputStream, BigInteger paramBigInteger)
  {
    int k = (paramBigInteger.bitLength() + 6) / 7;
    if (k == 0)
    {
      paramByteArrayOutputStream.write(0);
      return;
    }
    byte[] arrayOfByte = new byte[k];
    int j = k - 1;
    int i = j;
    while (i >= 0)
    {
      arrayOfByte[i] = ((byte)(paramBigInteger.intValue() & 0x7F | 0x80));
      paramBigInteger = paramBigInteger.shiftRight(7);
      i -= 1;
    }
    arrayOfByte[j] = ((byte)(arrayOfByte[j] & 0x7F));
    paramByteArrayOutputStream.write(arrayOfByte, 0, k);
  }
  
  boolean asn1Equals(ASN1Primitive paramASN1Primitive)
  {
    if (paramASN1Primitive == this) {
      return true;
    }
    if (!(paramASN1Primitive instanceof ASN1ObjectIdentifier)) {
      return false;
    }
    return this.identifier.equals(((ASN1ObjectIdentifier)paramASN1Primitive).identifier);
  }
  
  public ASN1ObjectIdentifier branch(String paramString)
  {
    return new ASN1ObjectIdentifier(this, paramString);
  }
  
  void encode(ASN1OutputStream paramASN1OutputStream)
    throws IOException
  {
    byte[] arrayOfByte = getBody();
    paramASN1OutputStream.write(6);
    paramASN1OutputStream.writeLength(arrayOfByte.length);
    paramASN1OutputStream.write(arrayOfByte);
  }
  
  int encodedLength()
    throws IOException
  {
    int i = getBody().length;
    return StreamUtil.calculateBodyLength(i) + 1 + i;
  }
  
  public String getId()
  {
    return this.identifier;
  }
  
  public int hashCode()
  {
    return this.identifier.hashCode();
  }
  
  public ASN1ObjectIdentifier intern()
  {
    OidHandle localOidHandle = new OidHandle(getBody());
    ASN1ObjectIdentifier localASN1ObjectIdentifier2 = (ASN1ObjectIdentifier)pool.get(localOidHandle);
    ASN1ObjectIdentifier localASN1ObjectIdentifier1 = localASN1ObjectIdentifier2;
    if (localASN1ObjectIdentifier2 == null)
    {
      localASN1ObjectIdentifier2 = (ASN1ObjectIdentifier)pool.putIfAbsent(localOidHandle, this);
      localASN1ObjectIdentifier1 = localASN1ObjectIdentifier2;
      if (localASN1ObjectIdentifier2 == null) {
        localASN1ObjectIdentifier1 = this;
      }
    }
    return localASN1ObjectIdentifier1;
  }
  
  boolean isConstructed()
  {
    return false;
  }
  
  public boolean on(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    String str = getId();
    paramASN1ObjectIdentifier = paramASN1ObjectIdentifier.getId();
    return (str.length() > paramASN1ObjectIdentifier.length()) && (str.charAt(paramASN1ObjectIdentifier.length()) == '.') && (str.startsWith(paramASN1ObjectIdentifier));
  }
  
  public String toString()
  {
    return getId();
  }
  
  private static class OidHandle
  {
    private final byte[] enc;
    private final int key;
    
    OidHandle(byte[] paramArrayOfByte)
    {
      this.key = Arrays.hashCode(paramArrayOfByte);
      this.enc = paramArrayOfByte;
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof OidHandle)) {
        return Arrays.areEqual(this.enc, ((OidHandle)paramObject).enc);
      }
      return false;
    }
    
    public int hashCode()
    {
      return this.key;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ASN1ObjectIdentifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */