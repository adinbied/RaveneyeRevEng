package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

public class BEROctetString
  extends ASN1OctetString
{
  private static final int MAX_LENGTH = 1000;
  private ASN1OctetString[] octs;
  
  public BEROctetString(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
  }
  
  public BEROctetString(ASN1OctetString[] paramArrayOfASN1OctetString)
  {
    super(toBytes(paramArrayOfASN1OctetString));
    this.octs = paramArrayOfASN1OctetString;
  }
  
  static BEROctetString fromSequence(ASN1Sequence paramASN1Sequence)
  {
    ASN1OctetString[] arrayOfASN1OctetString = new ASN1OctetString[paramASN1Sequence.size()];
    paramASN1Sequence = paramASN1Sequence.getObjects();
    int i = 0;
    while (paramASN1Sequence.hasMoreElements())
    {
      arrayOfASN1OctetString[i] = ((ASN1OctetString)paramASN1Sequence.nextElement());
      i += 1;
    }
    return new BEROctetString(arrayOfASN1OctetString);
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
  
  private static byte[] toBytes(ASN1OctetString[] paramArrayOfASN1OctetString)
  {
    Object localObject = new ByteArrayOutputStream();
    int i = 0;
    for (;;)
    {
      if (i != paramArrayOfASN1OctetString.length) {}
      try
      {
        ((ByteArrayOutputStream)localObject).write(((DEROctetString)paramArrayOfASN1OctetString[i]).getOctets());
        i += 1;
      }
      catch (IOException paramArrayOfASN1OctetString)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("exception converting octets ");
        ((StringBuilder)localObject).append(paramArrayOfASN1OctetString.toString());
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramArrayOfASN1OctetString[i].getClass().getName());
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
  
  public void encode(ASN1OutputStream paramASN1OutputStream)
    throws IOException
  {
    paramASN1OutputStream.write(36);
    paramASN1OutputStream.write(128);
    Enumeration localEnumeration = getObjects();
    while (localEnumeration.hasMoreElements()) {
      paramASN1OutputStream.writeObject((ASN1Encodable)localEnumeration.nextElement());
    }
    paramASN1OutputStream.write(0);
    paramASN1OutputStream.write(0);
  }
  
  int encodedLength()
    throws IOException
  {
    Enumeration localEnumeration = getObjects();
    int i = 0;
    while (localEnumeration.hasMoreElements()) {
      i += ((ASN1Encodable)localEnumeration.nextElement()).toASN1Primitive().encodedLength();
    }
    return i + 2 + 2;
  }
  
  public Enumeration getObjects()
  {
    if (this.octs == null) {
      return generateOcts().elements();
    }
    new Enumeration()
    {
      int counter = 0;
      
      public boolean hasMoreElements()
      {
        return this.counter < BEROctetString.this.octs.length;
      }
      
      public Object nextElement()
      {
        ASN1OctetString[] arrayOfASN1OctetString = BEROctetString.this.octs;
        int i = this.counter;
        this.counter = (i + 1);
        return arrayOfASN1OctetString[i];
      }
    };
  }
  
  public byte[] getOctets()
  {
    return this.string;
  }
  
  boolean isConstructed()
  {
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\BEROctetString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */