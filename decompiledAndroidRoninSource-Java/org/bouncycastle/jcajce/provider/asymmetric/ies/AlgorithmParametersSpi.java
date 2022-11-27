package org.bouncycastle.jcajce.provider.asymmetric.ies;

import java.io.IOException;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.jce.spec.IESParameterSpec;

public class AlgorithmParametersSpi
  extends java.security.AlgorithmParametersSpi
{
  IESParameterSpec currentSpec;
  
  protected byte[] engineGetEncoded()
  {
    try
    {
      Object localObject = new ASN1EncodableVector();
      if (this.currentSpec.getDerivationV() != null) {
        ((ASN1EncodableVector)localObject).add(new DERTaggedObject(false, 0, new DEROctetString(this.currentSpec.getDerivationV())));
      }
      if (this.currentSpec.getEncodingV() != null) {
        ((ASN1EncodableVector)localObject).add(new DERTaggedObject(false, 1, new DEROctetString(this.currentSpec.getEncodingV())));
      }
      ((ASN1EncodableVector)localObject).add(new ASN1Integer(this.currentSpec.getMacKeySize()));
      if (this.currentSpec.getNonce() != null)
      {
        ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
        localASN1EncodableVector.add(new ASN1Integer(this.currentSpec.getCipherKeySize()));
        localASN1EncodableVector.add(new ASN1Integer(this.currentSpec.getNonce()));
        ((ASN1EncodableVector)localObject).add(new DERSequence(localASN1EncodableVector));
      }
      localObject = new DERSequence((ASN1EncodableVector)localObject).getEncoded("DER");
      return (byte[])localObject;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    throw new RuntimeException("Error encoding IESParameters");
  }
  
  protected byte[] engineGetEncoded(String paramString)
  {
    if ((!isASN1FormatString(paramString)) && (!paramString.equalsIgnoreCase("X.509"))) {
      return null;
    }
    return engineGetEncoded();
  }
  
  protected AlgorithmParameterSpec engineGetParameterSpec(Class paramClass)
    throws InvalidParameterSpecException
  {
    if (paramClass != null) {
      return localEngineGetParameterSpec(paramClass);
    }
    throw new NullPointerException("argument to getParameterSpec must not be null");
  }
  
  protected void engineInit(AlgorithmParameterSpec paramAlgorithmParameterSpec)
    throws InvalidParameterSpecException
  {
    if ((paramAlgorithmParameterSpec instanceof IESParameterSpec))
    {
      this.currentSpec = ((IESParameterSpec)paramAlgorithmParameterSpec);
      return;
    }
    throw new InvalidParameterSpecException("IESParameterSpec required to initialise a IES algorithm parameters object");
  }
  
  protected void engineInit(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      paramArrayOfByte = (ASN1Sequence)ASN1Primitive.fromByteArray(paramArrayOfByte);
      if (paramArrayOfByte.size() == 1)
      {
        this.currentSpec = new IESParameterSpec(null, null, ASN1Integer.getInstance(paramArrayOfByte.getObjectAt(0)).getValue().intValue());
        return;
      }
      ASN1TaggedObject localASN1TaggedObject1;
      if (paramArrayOfByte.size() == 2)
      {
        localASN1TaggedObject1 = ASN1TaggedObject.getInstance(paramArrayOfByte.getObjectAt(0));
        if (localASN1TaggedObject1.getTagNo() == 0) {}
        for (paramArrayOfByte = new IESParameterSpec(ASN1OctetString.getInstance(localASN1TaggedObject1, false).getOctets(), null, ASN1Integer.getInstance(paramArrayOfByte.getObjectAt(1)).getValue().intValue());; paramArrayOfByte = new IESParameterSpec(null, ASN1OctetString.getInstance(localASN1TaggedObject1, false).getOctets(), ASN1Integer.getInstance(paramArrayOfByte.getObjectAt(1)).getValue().intValue()))
        {
          this.currentSpec = paramArrayOfByte;
          return;
        }
      }
      ASN1TaggedObject localASN1TaggedObject2;
      if (paramArrayOfByte.size() == 3)
      {
        localASN1TaggedObject1 = ASN1TaggedObject.getInstance(paramArrayOfByte.getObjectAt(0));
        localASN1TaggedObject2 = ASN1TaggedObject.getInstance(paramArrayOfByte.getObjectAt(1));
        this.currentSpec = new IESParameterSpec(ASN1OctetString.getInstance(localASN1TaggedObject1, false).getOctets(), ASN1OctetString.getInstance(localASN1TaggedObject2, false).getOctets(), ASN1Integer.getInstance(paramArrayOfByte.getObjectAt(2)).getValue().intValue());
        return;
      }
      if (paramArrayOfByte.size() == 4)
      {
        localASN1TaggedObject1 = ASN1TaggedObject.getInstance(paramArrayOfByte.getObjectAt(0));
        localASN1TaggedObject2 = ASN1TaggedObject.getInstance(paramArrayOfByte.getObjectAt(1));
        ASN1Sequence localASN1Sequence = ASN1Sequence.getInstance(paramArrayOfByte.getObjectAt(3));
        this.currentSpec = new IESParameterSpec(ASN1OctetString.getInstance(localASN1TaggedObject1, false).getOctets(), ASN1OctetString.getInstance(localASN1TaggedObject2, false).getOctets(), ASN1Integer.getInstance(paramArrayOfByte.getObjectAt(2)).getValue().intValue(), ASN1Integer.getInstance(localASN1Sequence.getObjectAt(0)).getValue().intValue(), ASN1OctetString.getInstance(localASN1Sequence.getObjectAt(1)).getOctets());
      }
      return;
    }
    catch (ClassCastException paramArrayOfByte)
    {
      for (;;) {}
    }
    catch (ArrayIndexOutOfBoundsException paramArrayOfByte)
    {
      for (;;) {}
    }
    throw new IOException("Not a valid IES Parameter encoding.");
    throw new IOException("Not a valid IES Parameter encoding.");
  }
  
  protected void engineInit(byte[] paramArrayOfByte, String paramString)
    throws IOException
  {
    if ((!isASN1FormatString(paramString)) && (!paramString.equalsIgnoreCase("X.509")))
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("Unknown parameter format ");
      paramArrayOfByte.append(paramString);
      throw new IOException(paramArrayOfByte.toString());
    }
    engineInit(paramArrayOfByte);
  }
  
  protected String engineToString()
  {
    return "IES Parameters";
  }
  
  protected boolean isASN1FormatString(String paramString)
  {
    return (paramString == null) || (paramString.equals("ASN.1"));
  }
  
  protected AlgorithmParameterSpec localEngineGetParameterSpec(Class paramClass)
    throws InvalidParameterSpecException
  {
    if ((paramClass != IESParameterSpec.class) && (paramClass != AlgorithmParameterSpec.class)) {
      throw new InvalidParameterSpecException("unknown parameter spec passed to ElGamal parameters object.");
    }
    return this.currentSpec;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\ies\AlgorithmParametersSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */