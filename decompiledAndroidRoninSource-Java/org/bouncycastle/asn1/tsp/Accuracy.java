package org.bouncycastle.asn1.tsp;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class Accuracy
  extends ASN1Object
{
  protected static final int MAX_MICROS = 999;
  protected static final int MAX_MILLIS = 999;
  protected static final int MIN_MICROS = 1;
  protected static final int MIN_MILLIS = 1;
  ASN1Integer micros;
  ASN1Integer millis;
  ASN1Integer seconds;
  
  protected Accuracy() {}
  
  public Accuracy(ASN1Integer paramASN1Integer1, ASN1Integer paramASN1Integer2, ASN1Integer paramASN1Integer3)
  {
    this.seconds = paramASN1Integer1;
    if ((paramASN1Integer2 != null) && ((paramASN1Integer2.getValue().intValue() < 1) || (paramASN1Integer2.getValue().intValue() > 999))) {
      throw new IllegalArgumentException("Invalid millis field : not in (1..999)");
    }
    this.millis = paramASN1Integer2;
    if ((paramASN1Integer3 != null) && ((paramASN1Integer3.getValue().intValue() < 1) || (paramASN1Integer3.getValue().intValue() > 999))) {
      throw new IllegalArgumentException("Invalid micros field : not in (1..999)");
    }
    this.micros = paramASN1Integer3;
  }
  
  private Accuracy(ASN1Sequence paramASN1Sequence)
  {
    this.seconds = null;
    this.millis = null;
    this.micros = null;
    int i = 0;
    while (i < paramASN1Sequence.size())
    {
      if ((paramASN1Sequence.getObjectAt(i) instanceof ASN1Integer))
      {
        this.seconds = ((ASN1Integer)paramASN1Sequence.getObjectAt(i));
      }
      else if ((paramASN1Sequence.getObjectAt(i) instanceof ASN1TaggedObject))
      {
        Object localObject = (ASN1TaggedObject)paramASN1Sequence.getObjectAt(i);
        int j = ((ASN1TaggedObject)localObject).getTagNo();
        if (j != 0)
        {
          if (j == 1)
          {
            localObject = ASN1Integer.getInstance((ASN1TaggedObject)localObject, false);
            this.micros = ((ASN1Integer)localObject);
            if ((((ASN1Integer)localObject).getValue().intValue() < 1) || (this.micros.getValue().intValue() > 999)) {
              throw new IllegalArgumentException("Invalid micros field : not in (1..999).");
            }
          }
          else
          {
            throw new IllegalArgumentException("Invalig tag number");
          }
        }
        else
        {
          localObject = ASN1Integer.getInstance((ASN1TaggedObject)localObject, false);
          this.millis = ((ASN1Integer)localObject);
          if ((((ASN1Integer)localObject).getValue().intValue() < 1) || (this.millis.getValue().intValue() > 999)) {
            throw new IllegalArgumentException("Invalid millis field : not in (1..999).");
          }
        }
      }
      i += 1;
    }
  }
  
  public static Accuracy getInstance(Object paramObject)
  {
    if ((paramObject instanceof Accuracy)) {
      return (Accuracy)paramObject;
    }
    if (paramObject != null) {
      return new Accuracy(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public ASN1Integer getMicros()
  {
    return this.micros;
  }
  
  public ASN1Integer getMillis()
  {
    return this.millis;
  }
  
  public ASN1Integer getSeconds()
  {
    return this.seconds;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    ASN1Integer localASN1Integer = this.seconds;
    if (localASN1Integer != null) {
      localASN1EncodableVector.add(localASN1Integer);
    }
    localASN1Integer = this.millis;
    if (localASN1Integer != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 0, localASN1Integer));
    }
    localASN1Integer = this.micros;
    if (localASN1Integer != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 1, localASN1Integer));
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\tsp\Accuracy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */