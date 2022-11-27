package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAParameterSpec;
import java.security.spec.DSAPublicKeySpec;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.DSAParameter;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.crypto.params.DSAPublicKeyParameters;
import org.bouncycastle.util.Strings;

public class JDKDSAPublicKey
  implements DSAPublicKey
{
  private static final long serialVersionUID = 1752452449903495175L;
  private DSAParams dsaSpec;
  private BigInteger y;
  
  JDKDSAPublicKey(BigInteger paramBigInteger, DSAParameterSpec paramDSAParameterSpec)
  {
    this.y = paramBigInteger;
    this.dsaSpec = paramDSAParameterSpec;
  }
  
  JDKDSAPublicKey(DSAPublicKey paramDSAPublicKey)
  {
    this.y = paramDSAPublicKey.getY();
    this.dsaSpec = paramDSAPublicKey.getParams();
  }
  
  JDKDSAPublicKey(DSAPublicKeySpec paramDSAPublicKeySpec)
  {
    this.y = paramDSAPublicKeySpec.getY();
    this.dsaSpec = new DSAParameterSpec(paramDSAPublicKeySpec.getP(), paramDSAPublicKeySpec.getQ(), paramDSAPublicKeySpec.getG());
  }
  
  JDKDSAPublicKey(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
  {
    try
    {
      ASN1Integer localASN1Integer = (ASN1Integer)paramSubjectPublicKeyInfo.parsePublicKey();
      this.y = localASN1Integer.getValue();
      if (isNotNull(paramSubjectPublicKeyInfo.getAlgorithm().getParameters()))
      {
        paramSubjectPublicKeyInfo = DSAParameter.getInstance(paramSubjectPublicKeyInfo.getAlgorithm().getParameters());
        this.dsaSpec = new DSAParameterSpec(paramSubjectPublicKeyInfo.getP(), paramSubjectPublicKeyInfo.getQ(), paramSubjectPublicKeyInfo.getG());
      }
      return;
    }
    catch (IOException paramSubjectPublicKeyInfo)
    {
      for (;;) {}
    }
    throw new IllegalArgumentException("invalid info structure in DSA public key");
  }
  
  JDKDSAPublicKey(DSAPublicKeyParameters paramDSAPublicKeyParameters)
  {
    this.y = paramDSAPublicKeyParameters.getY();
    this.dsaSpec = new DSAParameterSpec(paramDSAPublicKeyParameters.getParameters().getP(), paramDSAPublicKeyParameters.getParameters().getQ(), paramDSAPublicKeyParameters.getParameters().getG());
  }
  
  private boolean isNotNull(ASN1Encodable paramASN1Encodable)
  {
    return (paramASN1Encodable != null) && (!DERNull.INSTANCE.equals(paramASN1Encodable));
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    this.y = ((BigInteger)paramObjectInputStream.readObject());
    this.dsaSpec = new DSAParameterSpec((BigInteger)paramObjectInputStream.readObject(), (BigInteger)paramObjectInputStream.readObject(), (BigInteger)paramObjectInputStream.readObject());
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeObject(this.y);
    paramObjectOutputStream.writeObject(this.dsaSpec.getP());
    paramObjectOutputStream.writeObject(this.dsaSpec.getQ());
    paramObjectOutputStream.writeObject(this.dsaSpec.getG());
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof DSAPublicKey;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (DSAPublicKey)paramObject;
    bool1 = bool2;
    if (getY().equals(((DSAPublicKey)paramObject).getY()))
    {
      bool1 = bool2;
      if (getParams().getG().equals(((DSAPublicKey)paramObject).getParams().getG()))
      {
        bool1 = bool2;
        if (getParams().getP().equals(((DSAPublicKey)paramObject).getParams().getP()))
        {
          bool1 = bool2;
          if (getParams().getQ().equals(((DSAPublicKey)paramObject).getParams().getQ())) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public String getAlgorithm()
  {
    return "DSA";
  }
  
  public byte[] getEncoded()
  {
    try
    {
      Object localObject = this.dsaSpec;
      if (localObject == null) {
        return new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_dsa), new ASN1Integer(this.y)).getEncoded("DER");
      }
      localObject = new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_dsa, new DSAParameter(this.dsaSpec.getP(), this.dsaSpec.getQ(), this.dsaSpec.getG())), new ASN1Integer(this.y)).getEncoded("DER");
      return (byte[])localObject;
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
  
  public DSAParams getParams()
  {
    return this.dsaSpec;
  }
  
  public BigInteger getY()
  {
    return this.y;
  }
  
  public int hashCode()
  {
    return getY().hashCode() ^ getParams().getG().hashCode() ^ getParams().getP().hashCode() ^ getParams().getQ().hashCode();
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str = Strings.lineSeparator();
    localStringBuffer.append("DSA Public Key");
    localStringBuffer.append(str);
    localStringBuffer.append("            y: ");
    localStringBuffer.append(getY().toString(16));
    localStringBuffer.append(str);
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\provider\JDKDSAPublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */