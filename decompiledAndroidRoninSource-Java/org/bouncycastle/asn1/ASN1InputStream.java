package org.bouncycastle.asn1;

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.util.io.Streams;

public class ASN1InputStream
  extends FilterInputStream
  implements BERTags
{
  private final boolean lazyEvaluate;
  private final int limit;
  private final byte[][] tmpBuffers;
  
  public ASN1InputStream(InputStream paramInputStream)
  {
    this(paramInputStream, StreamUtil.findLimit(paramInputStream));
  }
  
  public ASN1InputStream(InputStream paramInputStream, int paramInt)
  {
    this(paramInputStream, paramInt, false);
  }
  
  public ASN1InputStream(InputStream paramInputStream, int paramInt, boolean paramBoolean)
  {
    super(paramInputStream);
    this.limit = paramInt;
    this.lazyEvaluate = paramBoolean;
    this.tmpBuffers = new byte[11][];
  }
  
  public ASN1InputStream(InputStream paramInputStream, boolean paramBoolean)
  {
    this(paramInputStream, StreamUtil.findLimit(paramInputStream), paramBoolean);
  }
  
  public ASN1InputStream(byte[] paramArrayOfByte)
  {
    this(new ByteArrayInputStream(paramArrayOfByte), paramArrayOfByte.length);
  }
  
  public ASN1InputStream(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    this(new ByteArrayInputStream(paramArrayOfByte), paramArrayOfByte.length, paramBoolean);
  }
  
  static ASN1Primitive createPrimitiveDERObject(int paramInt, DefiniteLengthInputStream paramDefiniteLengthInputStream, byte[][] paramArrayOfByte)
    throws IOException
  {
    if (paramInt != 10)
    {
      if (paramInt != 12)
      {
        if (paramInt != 30)
        {
          switch (paramInt)
          {
          default: 
            switch (paramInt)
            {
            default: 
              paramDefiniteLengthInputStream = new StringBuilder();
              paramDefiniteLengthInputStream.append("unknown tag ");
              paramDefiniteLengthInputStream.append(paramInt);
              paramDefiniteLengthInputStream.append(" encountered");
              throw new IOException(paramDefiniteLengthInputStream.toString());
            case 28: 
              return new DERUniversalString(paramDefiniteLengthInputStream.toByteArray());
            case 27: 
              return new DERGeneralString(paramDefiniteLengthInputStream.toByteArray());
            case 26: 
              return new DERVisibleString(paramDefiniteLengthInputStream.toByteArray());
            case 25: 
              return new DERGraphicString(paramDefiniteLengthInputStream.toByteArray());
            case 24: 
              return new ASN1GeneralizedTime(paramDefiniteLengthInputStream.toByteArray());
            case 23: 
              return new ASN1UTCTime(paramDefiniteLengthInputStream.toByteArray());
            case 22: 
              return new DERIA5String(paramDefiniteLengthInputStream.toByteArray());
            case 21: 
              return new DERVideotexString(paramDefiniteLengthInputStream.toByteArray());
            case 20: 
              return new DERT61String(paramDefiniteLengthInputStream.toByteArray());
            case 19: 
              return new DERPrintableString(paramDefiniteLengthInputStream.toByteArray());
            }
            return new DERNumericString(paramDefiniteLengthInputStream.toByteArray());
          case 6: 
            return ASN1ObjectIdentifier.fromOctetString(getBuffer(paramDefiniteLengthInputStream, paramArrayOfByte));
          case 5: 
            return DERNull.INSTANCE;
          case 4: 
            return new DEROctetString(paramDefiniteLengthInputStream.toByteArray());
          case 3: 
            return ASN1BitString.fromInputStream(paramDefiniteLengthInputStream.getRemaining(), paramDefiniteLengthInputStream);
          case 2: 
            return new ASN1Integer(paramDefiniteLengthInputStream.toByteArray(), false);
          }
          return ASN1Boolean.fromOctetString(getBuffer(paramDefiniteLengthInputStream, paramArrayOfByte));
        }
        return new DERBMPString(getBMPCharBuffer(paramDefiniteLengthInputStream));
      }
      return new DERUTF8String(paramDefiniteLengthInputStream.toByteArray());
    }
    return ASN1Enumerated.fromOctetString(getBuffer(paramDefiniteLengthInputStream, paramArrayOfByte));
  }
  
  private static char[] getBMPCharBuffer(DefiniteLengthInputStream paramDefiniteLengthInputStream)
    throws IOException
  {
    int j = paramDefiniteLengthInputStream.getRemaining() / 2;
    char[] arrayOfChar = new char[j];
    int i = 0;
    while (i < j)
    {
      int k = paramDefiniteLengthInputStream.read();
      if (k < 0) {
        return arrayOfChar;
      }
      int m = paramDefiniteLengthInputStream.read();
      if (m < 0) {
        return arrayOfChar;
      }
      arrayOfChar[i] = ((char)(k << 8 | m & 0xFF));
      i += 1;
    }
    return arrayOfChar;
  }
  
  private static byte[] getBuffer(DefiniteLengthInputStream paramDefiniteLengthInputStream, byte[][] paramArrayOfByte)
    throws IOException
  {
    int i = paramDefiniteLengthInputStream.getRemaining();
    if (paramDefiniteLengthInputStream.getRemaining() < paramArrayOfByte.length)
    {
      byte[] arrayOfByte2 = paramArrayOfByte[i];
      byte[] arrayOfByte1 = arrayOfByte2;
      if (arrayOfByte2 == null)
      {
        arrayOfByte1 = new byte[i];
        paramArrayOfByte[i] = arrayOfByte1;
      }
      Streams.readFully(paramDefiniteLengthInputStream, arrayOfByte1);
      return arrayOfByte1;
    }
    return paramDefiniteLengthInputStream.toByteArray();
  }
  
  static int readLength(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    int i = paramInputStream.read();
    if (i >= 0)
    {
      if (i == 128) {
        return -1;
      }
      if (i > 127)
      {
        int k = i & 0x7F;
        if (k <= 4)
        {
          int j = 0;
          i = 0;
          while (i < k)
          {
            int m = paramInputStream.read();
            if (m >= 0)
            {
              j = (j << 8) + m;
              i += 1;
            }
            else
            {
              throw new EOFException("EOF found reading length");
            }
          }
          if (j >= 0)
          {
            if (j < paramInt) {
              return j;
            }
            throw new IOException("corrupted stream - out of bounds length found");
          }
          throw new IOException("corrupted stream - negative length found");
        }
        paramInputStream = new StringBuilder();
        paramInputStream.append("DER length more than 4 bytes: ");
        paramInputStream.append(k);
        throw new IOException(paramInputStream.toString());
      }
      return i;
    }
    throw new EOFException("EOF found when length expected");
  }
  
  static int readTagNumber(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    paramInt &= 0x1F;
    if (paramInt == 31)
    {
      int i = 0;
      paramInt = paramInputStream.read();
      if ((paramInt & 0x7F) != 0)
      {
        while ((paramInt >= 0) && ((paramInt & 0x80) != 0))
        {
          i = (i | paramInt & 0x7F) << 7;
          paramInt = paramInputStream.read();
        }
        if (paramInt >= 0) {
          return i | paramInt & 0x7F;
        }
        throw new EOFException("EOF found inside tag value.");
      }
      throw new IOException("corrupted stream - invalid high tag number found");
    }
    return paramInt;
  }
  
  ASN1EncodableVector buildDEREncodableVector(DefiniteLengthInputStream paramDefiniteLengthInputStream)
    throws IOException
  {
    return new ASN1InputStream(paramDefiniteLengthInputStream).buildEncodableVector();
  }
  
  ASN1EncodableVector buildEncodableVector()
    throws IOException
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    for (;;)
    {
      ASN1Primitive localASN1Primitive = readObject();
      if (localASN1Primitive == null) {
        break;
      }
      localASN1EncodableVector.add(localASN1Primitive);
    }
    return localASN1EncodableVector;
  }
  
  protected ASN1Primitive buildObject(int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    int i = 0;
    boolean bool;
    if ((paramInt1 & 0x20) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject = new DefiniteLengthInputStream(this, paramInt3);
    if ((paramInt1 & 0x40) != 0) {
      return new DERApplicationSpecific(bool, paramInt2, ((DefiniteLengthInputStream)localObject).toByteArray());
    }
    if ((paramInt1 & 0x80) != 0) {
      return new ASN1StreamParser((InputStream)localObject).readTaggedObject(bool, paramInt2);
    }
    if (bool)
    {
      if (paramInt2 != 4)
      {
        if (paramInt2 != 8)
        {
          if (paramInt2 != 16)
          {
            if (paramInt2 == 17) {
              return DERFactory.createSet(buildDEREncodableVector((DefiniteLengthInputStream)localObject));
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("unknown tag ");
            ((StringBuilder)localObject).append(paramInt2);
            ((StringBuilder)localObject).append(" encountered");
            throw new IOException(((StringBuilder)localObject).toString());
          }
          if (this.lazyEvaluate) {
            return new LazyEncodedSequence(((DefiniteLengthInputStream)localObject).toByteArray());
          }
          return DERFactory.createSequence(buildDEREncodableVector((DefiniteLengthInputStream)localObject));
        }
        return new DERExternal(buildDEREncodableVector((DefiniteLengthInputStream)localObject));
      }
      localObject = buildDEREncodableVector((DefiniteLengthInputStream)localObject);
      paramInt2 = ((ASN1EncodableVector)localObject).size();
      ASN1OctetString[] arrayOfASN1OctetString = new ASN1OctetString[paramInt2];
      paramInt1 = i;
      while (paramInt1 != paramInt2)
      {
        arrayOfASN1OctetString[paramInt1] = ((ASN1OctetString)((ASN1EncodableVector)localObject).get(paramInt1));
        paramInt1 += 1;
      }
      return new BEROctetString(arrayOfASN1OctetString);
    }
    return createPrimitiveDERObject(paramInt2, (DefiniteLengthInputStream)localObject, this.tmpBuffers);
  }
  
  int getLimit()
  {
    return this.limit;
  }
  
  protected void readFully(byte[] paramArrayOfByte)
    throws IOException
  {
    if (Streams.readFully(this, paramArrayOfByte) == paramArrayOfByte.length) {
      return;
    }
    throw new EOFException("EOF encountered in middle of object");
  }
  
  protected int readLength()
    throws IOException
  {
    return readLength(this, this.limit);
  }
  
  public ASN1Primitive readObject()
    throws IOException
  {
    int j = read();
    if (j <= 0)
    {
      if (j != 0) {
        return null;
      }
      throw new IOException("unexpected end-of-contents marker");
    }
    int k = readTagNumber(this, j);
    int i;
    if ((j & 0x20) != 0) {
      i = 1;
    } else {
      i = 0;
    }
    int m = readLength();
    Object localObject;
    if (m < 0)
    {
      if (i != 0)
      {
        localObject = new ASN1StreamParser(new IndefiniteLengthInputStream(this, this.limit), this.limit);
        if ((j & 0x40) != 0) {
          return new BERApplicationSpecificParser(k, (ASN1StreamParser)localObject).getLoadedObject();
        }
        if ((j & 0x80) != 0) {
          return new BERTaggedObjectParser(true, k, (ASN1StreamParser)localObject).getLoadedObject();
        }
        if (k != 4)
        {
          if (k != 8)
          {
            if (k != 16)
            {
              if (k == 17) {
                return new BERSetParser((ASN1StreamParser)localObject).getLoadedObject();
              }
              throw new IOException("unknown BER object encountered");
            }
            return new BERSequenceParser((ASN1StreamParser)localObject).getLoadedObject();
          }
          return new DERExternalParser((ASN1StreamParser)localObject).getLoadedObject();
        }
        return new BEROctetStringParser((ASN1StreamParser)localObject).getLoadedObject();
      }
      throw new IOException("indefinite-length primitive encoding encountered");
    }
    try
    {
      localObject = buildObject(j, k, m);
      return (ASN1Primitive)localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new ASN1Exception("corrupted stream detected", localIllegalArgumentException);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ASN1InputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */