package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

public class BERConstructedOctetString
  extends BEROctetString
{
  private static final int MAX_LENGTH = 1000;
  private Vector octs;
  
  public BERConstructedOctetString(Vector paramVector)
  {
    super(toBytes(paramVector));
    this.octs = paramVector;
  }
  
  public BERConstructedOctetString(ASN1Encodable paramASN1Encodable)
  {
    this(paramASN1Encodable.toASN1Primitive());
  }
  
  public BERConstructedOctetString(ASN1Primitive paramASN1Primitive)
  {
    super(toByteArray(paramASN1Primitive));
  }
  
  public BERConstructedOctetString(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
  }
  
  public static BEROctetString fromSequence(ASN1Sequence paramASN1Sequence)
  {
    Vector localVector = new Vector();
    paramASN1Sequence = paramASN1Sequence.getObjects();
    while (paramASN1Sequence.hasMoreElements()) {
      localVector.addElement(paramASN1Sequence.nextElement());
    }
    return new BERConstructedOctetString(localVector);
  }
  
  private Vector generateOcts()
  {
    Vector localVector = new Vector();
    int j;
    for (int i = 0; i < this.string.length; i = j)
    {
      j = i + 1000;
      int k;
      if (j > this.string.length) {
        k = this.string.length;
      } else {
        k = j;
      }
      k -= i;
      byte[] arrayOfByte = new byte[k];
      System.arraycopy(this.string, i, arrayOfByte, 0, k);
      localVector.addElement(new DEROctetString(arrayOfByte));
    }
    return localVector;
  }
  
  private static byte[] toByteArray(ASN1Primitive paramASN1Primitive)
  {
    try
    {
      paramASN1Primitive = paramASN1Primitive.getEncoded();
      return paramASN1Primitive;
    }
    catch (IOException paramASN1Primitive)
    {
      for (;;) {}
    }
    throw new IllegalArgumentException("Unable to encode object");
  }
  
  private static byte[] toBytes(Vector paramVector)
  {
    Object localObject = new ByteArrayOutputStream();
    int i = 0;
    for (;;)
    {
      if (i != paramVector.size()) {}
      try
      {
        ((ByteArrayOutputStream)localObject).write(((DEROctetString)paramVector.elementAt(i)).getOctets());
        i += 1;
      }
      catch (IOException paramVector)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("exception converting octets ");
        ((StringBuilder)localObject).append(paramVector.toString());
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramVector.elementAt(i).getClass().getName());
        ((StringBuilder)localObject).append(" found in input should only contain DEROctetString");
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        return ((ByteArrayOutputStream)localObject).toByteArray();
      }
      catch (ClassCastException localClassCastException)
      {
        for (;;) {}
      }
    }
  }
  
  public Enumeration getObjects()
  {
    Vector localVector = this.octs;
    if (localVector == null) {
      return generateOcts().elements();
    }
    return localVector.elements();
  }
  
  public byte[] getOctets()
  {
    return this.string;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\BERConstructedOctetString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */