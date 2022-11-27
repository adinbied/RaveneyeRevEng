package org.bouncycastle.pqc.asn1;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.pqc.crypto.rainbow.Layer;
import org.bouncycastle.pqc.crypto.rainbow.util.RainbowUtil;

public class RainbowPrivateKey
  extends ASN1Object
{
  private byte[] b1;
  private byte[] b2;
  private byte[][] invA1;
  private byte[][] invA2;
  private Layer[] layers;
  private ASN1ObjectIdentifier oid;
  private ASN1Integer version;
  private byte[] vi;
  
  private RainbowPrivateKey(ASN1Sequence paramASN1Sequence)
  {
    if ((paramASN1Sequence.getObjectAt(0) instanceof ASN1Integer)) {
      this.version = ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(0));
    } else {
      this.oid = ASN1ObjectIdentifier.getInstance(paramASN1Sequence.getObjectAt(0));
    }
    Object localObject1 = (ASN1Sequence)paramASN1Sequence.getObjectAt(1);
    this.invA1 = new byte[((ASN1Sequence)localObject1).size()][];
    int i = 0;
    while (i < ((ASN1Sequence)localObject1).size())
    {
      this.invA1[i] = ((ASN1OctetString)((ASN1Sequence)localObject1).getObjectAt(i)).getOctets();
      i += 1;
    }
    this.b1 = ((ASN1OctetString)((ASN1Sequence)paramASN1Sequence.getObjectAt(2)).getObjectAt(0)).getOctets();
    localObject1 = (ASN1Sequence)paramASN1Sequence.getObjectAt(3);
    this.invA2 = new byte[((ASN1Sequence)localObject1).size()][];
    i = 0;
    while (i < ((ASN1Sequence)localObject1).size())
    {
      this.invA2[i] = ((ASN1OctetString)((ASN1Sequence)localObject1).getObjectAt(i)).getOctets();
      i += 1;
    }
    this.b2 = ((ASN1OctetString)((ASN1Sequence)paramASN1Sequence.getObjectAt(4)).getObjectAt(0)).getOctets();
    this.vi = ((ASN1OctetString)((ASN1Sequence)paramASN1Sequence.getObjectAt(5)).getObjectAt(0)).getOctets();
    Object localObject2 = (ASN1Sequence)paramASN1Sequence.getObjectAt(6);
    paramASN1Sequence = new byte[((ASN1Sequence)localObject2).size()][][][];
    localObject1 = new byte[((ASN1Sequence)localObject2).size()][][][];
    byte[][][] arrayOfByte = new byte[((ASN1Sequence)localObject2).size()][][];
    byte[][] arrayOfByte1 = new byte[((ASN1Sequence)localObject2).size()][];
    i = 0;
    int j;
    while (i < ((ASN1Sequence)localObject2).size())
    {
      ASN1Sequence localASN1Sequence1 = (ASN1Sequence)((ASN1Sequence)localObject2).getObjectAt(i);
      ASN1Sequence localASN1Sequence2 = (ASN1Sequence)localASN1Sequence1.getObjectAt(0);
      paramASN1Sequence[i] = new byte[localASN1Sequence2.size()][][];
      j = 0;
      ASN1Sequence localASN1Sequence3;
      while (j < localASN1Sequence2.size())
      {
        localASN1Sequence3 = (ASN1Sequence)localASN1Sequence2.getObjectAt(j);
        paramASN1Sequence[i][j] = new byte[localASN1Sequence3.size()][];
        k = 0;
        while (k < localASN1Sequence3.size())
        {
          paramASN1Sequence[i][j][k] = ((ASN1OctetString)localASN1Sequence3.getObjectAt(k)).getOctets();
          k += 1;
        }
        j += 1;
      }
      localASN1Sequence2 = (ASN1Sequence)localASN1Sequence1.getObjectAt(1);
      localObject1[i] = new byte[localASN1Sequence2.size()][][];
      j = 0;
      while (j < localASN1Sequence2.size())
      {
        localASN1Sequence3 = (ASN1Sequence)localASN1Sequence2.getObjectAt(j);
        localObject1[i][j] = new byte[localASN1Sequence3.size()][];
        k = 0;
        while (k < localASN1Sequence3.size())
        {
          localObject1[i][j][k] = ((ASN1OctetString)localASN1Sequence3.getObjectAt(k)).getOctets();
          k += 1;
        }
        j += 1;
      }
      localASN1Sequence2 = (ASN1Sequence)localASN1Sequence1.getObjectAt(2);
      arrayOfByte[i] = new byte[localASN1Sequence2.size()][];
      j = 0;
      while (j < localASN1Sequence2.size())
      {
        arrayOfByte[i][j] = ((ASN1OctetString)localASN1Sequence2.getObjectAt(j)).getOctets();
        j += 1;
      }
      arrayOfByte1[i] = ((ASN1OctetString)localASN1Sequence1.getObjectAt(3)).getOctets();
      i += 1;
    }
    int k = this.vi.length - 1;
    this.layers = new Layer[k];
    for (i = 0; i < k; i = j)
    {
      localObject2 = this.vi;
      byte b = localObject2[i];
      j = i + 1;
      localObject2 = new Layer(b, localObject2[j], RainbowUtil.convertArray(paramASN1Sequence[i]), RainbowUtil.convertArray(localObject1[i]), RainbowUtil.convertArray(arrayOfByte[i]), RainbowUtil.convertArray(arrayOfByte1[i]));
      this.layers[i] = localObject2;
    }
  }
  
  public RainbowPrivateKey(short[][] paramArrayOfShort1, short[] paramArrayOfShort2, short[][] paramArrayOfShort3, short[] paramArrayOfShort4, int[] paramArrayOfInt, Layer[] paramArrayOfLayer)
  {
    this.version = new ASN1Integer(1L);
    this.invA1 = RainbowUtil.convertArray(paramArrayOfShort1);
    this.b1 = RainbowUtil.convertArray(paramArrayOfShort2);
    this.invA2 = RainbowUtil.convertArray(paramArrayOfShort3);
    this.b2 = RainbowUtil.convertArray(paramArrayOfShort4);
    this.vi = RainbowUtil.convertIntArray(paramArrayOfInt);
    this.layers = paramArrayOfLayer;
  }
  
  public static RainbowPrivateKey getInstance(Object paramObject)
  {
    if ((paramObject instanceof RainbowPrivateKey)) {
      return (RainbowPrivateKey)paramObject;
    }
    if (paramObject != null) {
      return new RainbowPrivateKey(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public short[] getB1()
  {
    return RainbowUtil.convertArray(this.b1);
  }
  
  public short[] getB2()
  {
    return RainbowUtil.convertArray(this.b2);
  }
  
  public short[][] getInvA1()
  {
    return RainbowUtil.convertArray(this.invA1);
  }
  
  public short[][] getInvA2()
  {
    return RainbowUtil.convertArray(this.invA2);
  }
  
  public Layer[] getLayers()
  {
    return this.layers;
  }
  
  public ASN1Integer getVersion()
  {
    return this.version;
  }
  
  public int[] getVi()
  {
    return RainbowUtil.convertArraytoInt(this.vi);
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector1 = new ASN1EncodableVector();
    Object localObject1 = this.version;
    if (localObject1 == null) {
      localObject1 = this.oid;
    }
    localASN1EncodableVector1.add((ASN1Encodable)localObject1);
    localObject1 = new ASN1EncodableVector();
    int i = 0;
    Object localObject2;
    for (;;)
    {
      localObject2 = this.invA1;
      if (i >= localObject2.length) {
        break;
      }
      ((ASN1EncodableVector)localObject1).add(new DEROctetString(localObject2[i]));
      i += 1;
    }
    localASN1EncodableVector1.add(new DERSequence((ASN1EncodableVector)localObject1));
    localObject1 = new ASN1EncodableVector();
    ((ASN1EncodableVector)localObject1).add(new DEROctetString(this.b1));
    localASN1EncodableVector1.add(new DERSequence((ASN1EncodableVector)localObject1));
    localObject1 = new ASN1EncodableVector();
    i = 0;
    for (;;)
    {
      localObject2 = this.invA2;
      if (i >= localObject2.length) {
        break;
      }
      ((ASN1EncodableVector)localObject1).add(new DEROctetString(localObject2[i]));
      i += 1;
    }
    localASN1EncodableVector1.add(new DERSequence((ASN1EncodableVector)localObject1));
    localObject1 = new ASN1EncodableVector();
    ((ASN1EncodableVector)localObject1).add(new DEROctetString(this.b2));
    localASN1EncodableVector1.add(new DERSequence((ASN1EncodableVector)localObject1));
    localObject1 = new ASN1EncodableVector();
    ((ASN1EncodableVector)localObject1).add(new DEROctetString(this.vi));
    localASN1EncodableVector1.add(new DERSequence((ASN1EncodableVector)localObject1));
    localObject1 = new ASN1EncodableVector();
    i = 0;
    while (i < this.layers.length)
    {
      localObject2 = new ASN1EncodableVector();
      Object localObject3 = RainbowUtil.convertArray(this.layers[i].getCoeffAlpha());
      ASN1EncodableVector localASN1EncodableVector2 = new ASN1EncodableVector();
      int j = 0;
      ASN1EncodableVector localASN1EncodableVector3;
      int k;
      while (j < localObject3.length)
      {
        localASN1EncodableVector3 = new ASN1EncodableVector();
        k = 0;
        while (k < localObject3[j].length)
        {
          localASN1EncodableVector3.add(new DEROctetString(localObject3[j][k]));
          k += 1;
        }
        localASN1EncodableVector2.add(new DERSequence(localASN1EncodableVector3));
        j += 1;
      }
      ((ASN1EncodableVector)localObject2).add(new DERSequence(localASN1EncodableVector2));
      localObject3 = RainbowUtil.convertArray(this.layers[i].getCoeffBeta());
      localASN1EncodableVector2 = new ASN1EncodableVector();
      j = 0;
      while (j < localObject3.length)
      {
        localASN1EncodableVector3 = new ASN1EncodableVector();
        k = 0;
        while (k < localObject3[j].length)
        {
          localASN1EncodableVector3.add(new DEROctetString(localObject3[j][k]));
          k += 1;
        }
        localASN1EncodableVector2.add(new DERSequence(localASN1EncodableVector3));
        j += 1;
      }
      ((ASN1EncodableVector)localObject2).add(new DERSequence(localASN1EncodableVector2));
      localObject3 = RainbowUtil.convertArray(this.layers[i].getCoeffGamma());
      localASN1EncodableVector2 = new ASN1EncodableVector();
      j = 0;
      while (j < localObject3.length)
      {
        localASN1EncodableVector2.add(new DEROctetString(localObject3[j]));
        j += 1;
      }
      ((ASN1EncodableVector)localObject2).add(new DERSequence(localASN1EncodableVector2));
      ((ASN1EncodableVector)localObject2).add(new DEROctetString(RainbowUtil.convertArray(this.layers[i].getCoeffEta())));
      ((ASN1EncodableVector)localObject1).add(new DERSequence((ASN1EncodableVector)localObject2));
      i += 1;
    }
    localASN1EncodableVector1.add(new DERSequence((ASN1EncodableVector)localObject1));
    return new DERSequence(localASN1EncodableVector1);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\asn1\RainbowPrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */