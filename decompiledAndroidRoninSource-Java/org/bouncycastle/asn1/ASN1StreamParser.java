package org.bouncycastle.asn1;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ASN1StreamParser
{
  private final InputStream _in;
  private final int _limit;
  private final byte[][] tmpBuffers;
  
  public ASN1StreamParser(InputStream paramInputStream)
  {
    this(paramInputStream, StreamUtil.findLimit(paramInputStream));
  }
  
  public ASN1StreamParser(InputStream paramInputStream, int paramInt)
  {
    this._in = paramInputStream;
    this._limit = paramInt;
    this.tmpBuffers = new byte[11][];
  }
  
  public ASN1StreamParser(byte[] paramArrayOfByte)
  {
    this(new ByteArrayInputStream(paramArrayOfByte), paramArrayOfByte.length);
  }
  
  private void set00Check(boolean paramBoolean)
  {
    InputStream localInputStream = this._in;
    if ((localInputStream instanceof IndefiniteLengthInputStream)) {
      ((IndefiniteLengthInputStream)localInputStream).setEofOn00(paramBoolean);
    }
  }
  
  ASN1Encodable readImplicit(boolean paramBoolean, int paramInt)
    throws IOException
  {
    InputStream localInputStream = this._in;
    if ((localInputStream instanceof IndefiniteLengthInputStream))
    {
      if (paramBoolean) {
        return readIndef(paramInt);
      }
      throw new IOException("indefinite-length primitive encoding encountered");
    }
    if (paramBoolean)
    {
      if (paramInt != 4)
      {
        if (paramInt != 16)
        {
          if (paramInt == 17) {
            return new DERSetParser(this);
          }
        }
        else {
          return new DERSequenceParser(this);
        }
      }
      else {
        return new BEROctetStringParser(this);
      }
    }
    else
    {
      if (paramInt == 4) {
        break label127;
      }
      if (paramInt == 16) {
        break label117;
      }
      if (paramInt == 17) {
        break label107;
      }
    }
    throw new ASN1Exception("implicit tagging not implemented");
    label107:
    throw new ASN1Exception("sequences must use constructed encoding (see X.690 8.9.1/8.10.1)");
    label117:
    throw new ASN1Exception("sets must use constructed encoding (see X.690 8.11.1/8.12.1)");
    label127:
    return new DEROctetStringParser((DefiniteLengthInputStream)localInputStream);
  }
  
  ASN1Encodable readIndef(int paramInt)
    throws IOException
  {
    if (paramInt != 4)
    {
      if (paramInt != 8)
      {
        if (paramInt != 16)
        {
          if (paramInt == 17) {
            return new BERSetParser(this);
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("unknown BER object encountered: 0x");
          localStringBuilder.append(Integer.toHexString(paramInt));
          throw new ASN1Exception(localStringBuilder.toString());
        }
        return new BERSequenceParser(this);
      }
      return new DERExternalParser(this);
    }
    return new BEROctetStringParser(this);
  }
  
  public ASN1Encodable readObject()
    throws IOException
  {
    int i = this._in.read();
    if (i == -1) {
      return null;
    }
    boolean bool = false;
    set00Check(false);
    int j = ASN1InputStream.readTagNumber(this._in, i);
    if ((i & 0x20) != 0) {
      bool = true;
    }
    int k = ASN1InputStream.readLength(this._in, this._limit);
    if (k < 0)
    {
      if (bool)
      {
        localObject = new ASN1StreamParser(new IndefiniteLengthInputStream(this._in, this._limit), this._limit);
        if ((i & 0x40) != 0) {
          return new BERApplicationSpecificParser(j, (ASN1StreamParser)localObject);
        }
        if ((i & 0x80) != 0) {
          return new BERTaggedObjectParser(true, j, (ASN1StreamParser)localObject);
        }
        return ((ASN1StreamParser)localObject).readIndef(j);
      }
      throw new IOException("indefinite-length primitive encoding encountered");
    }
    Object localObject = new DefiniteLengthInputStream(this._in, k);
    if ((i & 0x40) != 0) {
      return new DERApplicationSpecific(bool, j, ((DefiniteLengthInputStream)localObject).toByteArray());
    }
    if ((i & 0x80) != 0) {
      return new BERTaggedObjectParser(bool, j, new ASN1StreamParser((InputStream)localObject));
    }
    if (bool)
    {
      if (j != 4)
      {
        if (j != 8)
        {
          if (j != 16)
          {
            if (j == 17) {
              return new DERSetParser(new ASN1StreamParser((InputStream)localObject));
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("unknown tag ");
            ((StringBuilder)localObject).append(j);
            ((StringBuilder)localObject).append(" encountered");
            throw new IOException(((StringBuilder)localObject).toString());
          }
          return new DERSequenceParser(new ASN1StreamParser((InputStream)localObject));
        }
        return new DERExternalParser(new ASN1StreamParser((InputStream)localObject));
      }
      return new BEROctetStringParser(new ASN1StreamParser((InputStream)localObject));
    }
    if (j != 4) {
      try
      {
        localObject = ASN1InputStream.createPrimitiveDERObject(j, (DefiniteLengthInputStream)localObject, this.tmpBuffers);
        return (ASN1Encodable)localObject;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        throw new ASN1Exception("corrupted stream detected", localIllegalArgumentException);
      }
    }
    return new DEROctetStringParser(localIllegalArgumentException);
  }
  
  ASN1Primitive readTaggedObject(boolean paramBoolean, int paramInt)
    throws IOException
  {
    if (!paramBoolean) {
      return new DERTaggedObject(false, paramInt, new DEROctetString(((DefiniteLengthInputStream)this._in).toByteArray()));
    }
    ASN1EncodableVector localASN1EncodableVector = readVector();
    if ((this._in instanceof IndefiniteLengthInputStream))
    {
      if (localASN1EncodableVector.size() == 1) {
        return new BERTaggedObject(true, paramInt, localASN1EncodableVector.get(0));
      }
      return new BERTaggedObject(false, paramInt, BERFactory.createSequence(localASN1EncodableVector));
    }
    if (localASN1EncodableVector.size() == 1) {
      return new DERTaggedObject(true, paramInt, localASN1EncodableVector.get(0));
    }
    return new DERTaggedObject(false, paramInt, DERFactory.createSequence(localASN1EncodableVector));
  }
  
  ASN1EncodableVector readVector()
    throws IOException
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    for (;;)
    {
      Object localObject = readObject();
      if (localObject == null) {
        break;
      }
      if ((localObject instanceof InMemoryRepresentable)) {
        localObject = ((InMemoryRepresentable)localObject).getLoadedObject();
      } else {
        localObject = ((ASN1Encodable)localObject).toASN1Primitive();
      }
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    return localASN1EncodableVector;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ASN1StreamParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */