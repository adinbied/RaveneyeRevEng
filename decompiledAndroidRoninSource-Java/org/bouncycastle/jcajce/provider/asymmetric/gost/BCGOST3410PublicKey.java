package org.bouncycastle.jcajce.provider.asymmetric.gost;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.params.GOST3410PublicKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.bouncycastle.jce.interfaces.GOST3410Params;
import org.bouncycastle.jce.interfaces.GOST3410PublicKey;
import org.bouncycastle.jce.spec.GOST3410ParameterSpec;
import org.bouncycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;
import org.bouncycastle.jce.spec.GOST3410PublicKeySpec;
import org.bouncycastle.util.Strings;

public class BCGOST3410PublicKey
  implements GOST3410PublicKey
{
  static final long serialVersionUID = -6251023343619275990L;
  private transient GOST3410Params gost3410Spec;
  private BigInteger y;
  
  BCGOST3410PublicKey(BigInteger paramBigInteger, GOST3410ParameterSpec paramGOST3410ParameterSpec)
  {
    this.y = paramBigInteger;
    this.gost3410Spec = paramGOST3410ParameterSpec;
  }
  
  BCGOST3410PublicKey(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
  {
    GOST3410PublicKeyAlgParameters localGOST3410PublicKeyAlgParameters = new GOST3410PublicKeyAlgParameters((ASN1Sequence)paramSubjectPublicKeyInfo.getAlgorithmId().getParameters());
    try
    {
      paramSubjectPublicKeyInfo = ((DEROctetString)paramSubjectPublicKeyInfo.parsePublicKey()).getOctets();
      byte[] arrayOfByte = new byte[paramSubjectPublicKeyInfo.length];
      int i = 0;
      while (i != paramSubjectPublicKeyInfo.length)
      {
        arrayOfByte[i] = paramSubjectPublicKeyInfo[(paramSubjectPublicKeyInfo.length - 1 - i)];
        i += 1;
      }
      this.y = new BigInteger(1, arrayOfByte);
      this.gost3410Spec = GOST3410ParameterSpec.fromPublicKeyAlg(localGOST3410PublicKeyAlgParameters);
      return;
    }
    catch (IOException paramSubjectPublicKeyInfo)
    {
      for (;;) {}
    }
    throw new IllegalArgumentException("invalid info structure in GOST3410 public key");
  }
  
  BCGOST3410PublicKey(GOST3410PublicKeyParameters paramGOST3410PublicKeyParameters, GOST3410ParameterSpec paramGOST3410ParameterSpec)
  {
    this.y = paramGOST3410PublicKeyParameters.getY();
    this.gost3410Spec = paramGOST3410ParameterSpec;
  }
  
  BCGOST3410PublicKey(GOST3410PublicKey paramGOST3410PublicKey)
  {
    this.y = paramGOST3410PublicKey.getY();
    this.gost3410Spec = paramGOST3410PublicKey.getParameters();
  }
  
  BCGOST3410PublicKey(GOST3410PublicKeySpec paramGOST3410PublicKeySpec)
  {
    this.y = paramGOST3410PublicKeySpec.getY();
    this.gost3410Spec = new GOST3410ParameterSpec(new GOST3410PublicKeyParameterSetSpec(paramGOST3410PublicKeySpec.getP(), paramGOST3410PublicKeySpec.getQ(), paramGOST3410PublicKeySpec.getA()));
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    String str = (String)paramObjectInputStream.readObject();
    if (str != null)
    {
      this.gost3410Spec = new GOST3410ParameterSpec(str, (String)paramObjectInputStream.readObject(), (String)paramObjectInputStream.readObject());
      return;
    }
    this.gost3410Spec = new GOST3410ParameterSpec(new GOST3410PublicKeyParameterSetSpec((BigInteger)paramObjectInputStream.readObject(), (BigInteger)paramObjectInputStream.readObject(), (BigInteger)paramObjectInputStream.readObject()));
    paramObjectInputStream.readObject();
    paramObjectInputStream.readObject();
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    Object localObject;
    if (this.gost3410Spec.getPublicKeyParamSetOID() != null)
    {
      localObject = this.gost3410Spec.getPublicKeyParamSetOID();
    }
    else
    {
      paramObjectOutputStream.writeObject(null);
      paramObjectOutputStream.writeObject(this.gost3410Spec.getPublicKeyParameters().getP());
      paramObjectOutputStream.writeObject(this.gost3410Spec.getPublicKeyParameters().getQ());
      localObject = this.gost3410Spec.getPublicKeyParameters().getA();
    }
    paramObjectOutputStream.writeObject(localObject);
    paramObjectOutputStream.writeObject(this.gost3410Spec.getDigestParamSetOID());
    paramObjectOutputStream.writeObject(this.gost3410Spec.getEncryptionParamSetOID());
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof BCGOST3410PublicKey;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = (BCGOST3410PublicKey)paramObject;
      bool1 = bool2;
      if (this.y.equals(((BCGOST3410PublicKey)paramObject).y))
      {
        bool1 = bool2;
        if (this.gost3410Spec.equals(((BCGOST3410PublicKey)paramObject).gost3410Spec)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public String getAlgorithm()
  {
    return "GOST3410";
  }
  
  public byte[] getEncoded()
  {
    Object localObject = getY().toByteArray();
    int j = 0;
    if (localObject[0] == 0) {
      i = localObject.length - 1;
    } else {
      i = localObject.length;
    }
    byte[] arrayOfByte = new byte[i];
    int i = j;
    while (i != arrayOfByte.length)
    {
      arrayOfByte[i] = localObject[(localObject.length - 1 - i)];
      i += 1;
    }
    try
    {
      if ((this.gost3410Spec instanceof GOST3410ParameterSpec))
      {
        if (this.gost3410Spec.getEncryptionParamSetOID() != null) {
          localObject = new SubjectPublicKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_94, new GOST3410PublicKeyAlgParameters(new ASN1ObjectIdentifier(this.gost3410Spec.getPublicKeyParamSetOID()), new ASN1ObjectIdentifier(this.gost3410Spec.getDigestParamSetOID()), new ASN1ObjectIdentifier(this.gost3410Spec.getEncryptionParamSetOID()))), new DEROctetString(arrayOfByte));
        } else {
          localObject = new SubjectPublicKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_94, new GOST3410PublicKeyAlgParameters(new ASN1ObjectIdentifier(this.gost3410Spec.getPublicKeyParamSetOID()), new ASN1ObjectIdentifier(this.gost3410Spec.getDigestParamSetOID()))), new DEROctetString(arrayOfByte));
        }
      }
      else {
        localObject = new SubjectPublicKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_94), new DEROctetString(arrayOfByte));
      }
      localObject = KeyUtil.getEncodedSubjectPublicKeyInfo((SubjectPublicKeyInfo)localObject);
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
  
  public GOST3410Params getParameters()
  {
    return this.gost3410Spec;
  }
  
  public BigInteger getY()
  {
    return this.y;
  }
  
  public int hashCode()
  {
    return this.y.hashCode() ^ this.gost3410Spec.hashCode();
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str = Strings.lineSeparator();
    localStringBuffer.append("GOST3410 Public Key");
    localStringBuffer.append(str);
    localStringBuffer.append("            y: ");
    localStringBuffer.append(getY().toString(16));
    localStringBuffer.append(str);
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\gost\BCGOST3410PublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */