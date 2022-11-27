package org.bouncycastle.jcajce.provider.asymmetric.elgamal;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.oiw.ElGamalParameter;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.params.ElGamalParameters;
import org.bouncycastle.crypto.params.ElGamalPublicKeyParameters;
import org.bouncycastle.jce.interfaces.ElGamalPublicKey;
import org.bouncycastle.jce.spec.ElGamalParameterSpec;
import org.bouncycastle.jce.spec.ElGamalPublicKeySpec;

public class BCElGamalPublicKey
  implements ElGamalPublicKey, DHPublicKey
{
  static final long serialVersionUID = 8712728417091216948L;
  private transient ElGamalParameterSpec elSpec;
  private BigInteger y;
  
  BCElGamalPublicKey(BigInteger paramBigInteger, ElGamalParameterSpec paramElGamalParameterSpec)
  {
    this.y = paramBigInteger;
    this.elSpec = paramElGamalParameterSpec;
  }
  
  BCElGamalPublicKey(DHPublicKey paramDHPublicKey)
  {
    this.y = paramDHPublicKey.getY();
    this.elSpec = new ElGamalParameterSpec(paramDHPublicKey.getParams().getP(), paramDHPublicKey.getParams().getG());
  }
  
  BCElGamalPublicKey(DHPublicKeySpec paramDHPublicKeySpec)
  {
    this.y = paramDHPublicKeySpec.getY();
    this.elSpec = new ElGamalParameterSpec(paramDHPublicKeySpec.getP(), paramDHPublicKeySpec.getG());
  }
  
  BCElGamalPublicKey(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
  {
    ElGamalParameter localElGamalParameter = ElGamalParameter.getInstance(paramSubjectPublicKeyInfo.getAlgorithm().getParameters());
    try
    {
      paramSubjectPublicKeyInfo = (ASN1Integer)paramSubjectPublicKeyInfo.parsePublicKey();
      this.y = paramSubjectPublicKeyInfo.getValue();
      this.elSpec = new ElGamalParameterSpec(localElGamalParameter.getP(), localElGamalParameter.getG());
      return;
    }
    catch (IOException paramSubjectPublicKeyInfo)
    {
      for (;;) {}
    }
    throw new IllegalArgumentException("invalid info structure in DSA public key");
  }
  
  BCElGamalPublicKey(ElGamalPublicKeyParameters paramElGamalPublicKeyParameters)
  {
    this.y = paramElGamalPublicKeyParameters.getY();
    this.elSpec = new ElGamalParameterSpec(paramElGamalPublicKeyParameters.getParameters().getP(), paramElGamalPublicKeyParameters.getParameters().getG());
  }
  
  BCElGamalPublicKey(ElGamalPublicKey paramElGamalPublicKey)
  {
    this.y = paramElGamalPublicKey.getY();
    this.elSpec = paramElGamalPublicKey.getParameters();
  }
  
  BCElGamalPublicKey(ElGamalPublicKeySpec paramElGamalPublicKeySpec)
  {
    this.y = paramElGamalPublicKeySpec.getY();
    this.elSpec = new ElGamalParameterSpec(paramElGamalPublicKeySpec.getParams().getP(), paramElGamalPublicKeySpec.getParams().getG());
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    this.elSpec = new ElGamalParameterSpec((BigInteger)paramObjectInputStream.readObject(), (BigInteger)paramObjectInputStream.readObject());
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeObject(this.elSpec.getP());
    paramObjectOutputStream.writeObject(this.elSpec.getG());
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof DHPublicKey;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (DHPublicKey)paramObject;
    bool1 = bool2;
    if (getY().equals(((DHPublicKey)paramObject).getY()))
    {
      bool1 = bool2;
      if (getParams().getG().equals(((DHPublicKey)paramObject).getParams().getG()))
      {
        bool1 = bool2;
        if (getParams().getP().equals(((DHPublicKey)paramObject).getParams().getP()))
        {
          bool1 = bool2;
          if (getParams().getL() == ((DHPublicKey)paramObject).getParams().getL()) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public String getAlgorithm()
  {
    return "ElGamal";
  }
  
  public byte[] getEncoded()
  {
    try
    {
      byte[] arrayOfByte = new SubjectPublicKeyInfo(new AlgorithmIdentifier(OIWObjectIdentifiers.elGamalAlgorithm, new ElGamalParameter(this.elSpec.getP(), this.elSpec.getG())), new ASN1Integer(this.y)).getEncoded("DER");
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    return null;
  }
  
  public String getFormat()
  {
    return "X.509";
  }
  
  public ElGamalParameterSpec getParameters()
  {
    return this.elSpec;
  }
  
  public DHParameterSpec getParams()
  {
    return new DHParameterSpec(this.elSpec.getP(), this.elSpec.getG());
  }
  
  public BigInteger getY()
  {
    return this.y;
  }
  
  public int hashCode()
  {
    return getY().hashCode() ^ getParams().getG().hashCode() ^ getParams().getP().hashCode() ^ getParams().getL();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\elgamal\BCElGamalPublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */