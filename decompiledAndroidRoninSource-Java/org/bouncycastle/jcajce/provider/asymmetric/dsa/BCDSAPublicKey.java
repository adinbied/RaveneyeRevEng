package org.bouncycastle.jcajce.provider.asymmetric.dsa;

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
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.bouncycastle.util.Strings;

public class BCDSAPublicKey
  implements DSAPublicKey
{
  private static BigInteger ZERO = BigInteger.valueOf(0L);
  private static final long serialVersionUID = 1752452449903495175L;
  private transient DSAParams dsaSpec;
  private transient DSAPublicKeyParameters lwKeyParams;
  private BigInteger y;
  
  BCDSAPublicKey(DSAPublicKey paramDSAPublicKey)
  {
    this.y = paramDSAPublicKey.getY();
    paramDSAPublicKey = paramDSAPublicKey.getParams();
    this.dsaSpec = paramDSAPublicKey;
    this.lwKeyParams = new DSAPublicKeyParameters(this.y, DSAUtil.toDSAParameters(paramDSAPublicKey));
  }
  
  BCDSAPublicKey(DSAPublicKeySpec paramDSAPublicKeySpec)
  {
    this.y = paramDSAPublicKeySpec.getY();
    paramDSAPublicKeySpec = new DSAParameterSpec(paramDSAPublicKeySpec.getP(), paramDSAPublicKeySpec.getQ(), paramDSAPublicKeySpec.getG());
    this.dsaSpec = paramDSAPublicKeySpec;
    this.lwKeyParams = new DSAPublicKeyParameters(this.y, DSAUtil.toDSAParameters(paramDSAPublicKeySpec));
  }
  
  public BCDSAPublicKey(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
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
      else
      {
        this.dsaSpec = null;
      }
      this.lwKeyParams = new DSAPublicKeyParameters(this.y, DSAUtil.toDSAParameters(this.dsaSpec));
      return;
    }
    catch (IOException paramSubjectPublicKeyInfo)
    {
      for (;;) {}
    }
    throw new IllegalArgumentException("invalid info structure in DSA public key");
  }
  
  BCDSAPublicKey(DSAPublicKeyParameters paramDSAPublicKeyParameters)
  {
    this.y = paramDSAPublicKeyParameters.getY();
    DSAParameterSpec localDSAParameterSpec;
    if (paramDSAPublicKeyParameters != null) {
      localDSAParameterSpec = new DSAParameterSpec(paramDSAPublicKeyParameters.getParameters().getP(), paramDSAPublicKeyParameters.getParameters().getQ(), paramDSAPublicKeyParameters.getParameters().getG());
    } else {
      localDSAParameterSpec = null;
    }
    this.dsaSpec = localDSAParameterSpec;
    this.lwKeyParams = paramDSAPublicKeyParameters;
  }
  
  private boolean isNotNull(ASN1Encodable paramASN1Encodable)
  {
    return (paramASN1Encodable != null) && (!DERNull.INSTANCE.equals(paramASN1Encodable.toASN1Primitive()));
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    BigInteger localBigInteger = (BigInteger)paramObjectInputStream.readObject();
    if (localBigInteger.equals(ZERO)) {
      this.dsaSpec = null;
    } else {
      this.dsaSpec = new DSAParameterSpec(localBigInteger, (BigInteger)paramObjectInputStream.readObject(), (BigInteger)paramObjectInputStream.readObject());
    }
    this.lwKeyParams = new DSAPublicKeyParameters(this.y, DSAUtil.toDSAParameters(this.dsaSpec));
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    Object localObject = this.dsaSpec;
    if (localObject == null)
    {
      localObject = ZERO;
    }
    else
    {
      paramObjectOutputStream.writeObject(((DSAParams)localObject).getP());
      paramObjectOutputStream.writeObject(this.dsaSpec.getQ());
      localObject = this.dsaSpec.getG();
    }
    paramObjectOutputStream.writeObject(localObject);
  }
  
  DSAPublicKeyParameters engineGetKeyParameters()
  {
    return this.lwKeyParams;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof DSAPublicKey;
    boolean bool3 = false;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (DSAPublicKey)paramObject;
    if (this.dsaSpec != null)
    {
      bool1 = bool2;
      if (getY().equals(((DSAPublicKey)paramObject).getY()))
      {
        bool1 = bool2;
        if (((DSAPublicKey)paramObject).getParams() != null)
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
      }
      return bool1;
    }
    bool1 = bool3;
    if (getY().equals(((DSAPublicKey)paramObject).getY()))
    {
      bool1 = bool3;
      if (((DSAPublicKey)paramObject).getParams() == null) {
        bool1 = true;
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
    AlgorithmIdentifier localAlgorithmIdentifier;
    if (this.dsaSpec == null) {
      localAlgorithmIdentifier = new AlgorithmIdentifier(X9ObjectIdentifiers.id_dsa);
    }
    for (ASN1Integer localASN1Integer = new ASN1Integer(this.y);; localASN1Integer = new ASN1Integer(this.y))
    {
      return KeyUtil.getEncodedSubjectPublicKeyInfo(localAlgorithmIdentifier, localASN1Integer);
      localAlgorithmIdentifier = new AlgorithmIdentifier(X9ObjectIdentifiers.id_dsa, new DSAParameter(this.dsaSpec.getP(), this.dsaSpec.getQ(), this.dsaSpec.getG()).toASN1Primitive());
    }
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
    if (this.dsaSpec != null) {
      return getY().hashCode() ^ getParams().getG().hashCode() ^ getParams().getP().hashCode() ^ getParams().getQ().hashCode();
    }
    return getY().hashCode();
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\dsa\BCDSAPublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */