package org.bouncycastle.jcajce.provider.asymmetric.gost;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.params.GOST3410PrivateKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.bouncycastle.jce.interfaces.GOST3410Params;
import org.bouncycastle.jce.interfaces.GOST3410PrivateKey;
import org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.bouncycastle.jce.spec.GOST3410ParameterSpec;
import org.bouncycastle.jce.spec.GOST3410PrivateKeySpec;
import org.bouncycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;

public class BCGOST3410PrivateKey
  implements GOST3410PrivateKey, PKCS12BagAttributeCarrier
{
  static final long serialVersionUID = 8581661527592305464L;
  private transient PKCS12BagAttributeCarrier attrCarrier = new PKCS12BagAttributeCarrierImpl();
  private transient GOST3410Params gost3410Spec;
  private BigInteger x;
  
  protected BCGOST3410PrivateKey() {}
  
  BCGOST3410PrivateKey(PrivateKeyInfo paramPrivateKeyInfo)
    throws IOException
  {
    GOST3410PublicKeyAlgParameters localGOST3410PublicKeyAlgParameters = new GOST3410PublicKeyAlgParameters((ASN1Sequence)paramPrivateKeyInfo.getAlgorithmId().getParameters());
    paramPrivateKeyInfo = ASN1OctetString.getInstance(paramPrivateKeyInfo.parsePrivateKey()).getOctets();
    byte[] arrayOfByte = new byte[paramPrivateKeyInfo.length];
    int i = 0;
    while (i != paramPrivateKeyInfo.length)
    {
      arrayOfByte[i] = paramPrivateKeyInfo[(paramPrivateKeyInfo.length - 1 - i)];
      i += 1;
    }
    this.x = new BigInteger(1, arrayOfByte);
    this.gost3410Spec = GOST3410ParameterSpec.fromPublicKeyAlg(localGOST3410PublicKeyAlgParameters);
  }
  
  BCGOST3410PrivateKey(GOST3410PrivateKeyParameters paramGOST3410PrivateKeyParameters, GOST3410ParameterSpec paramGOST3410ParameterSpec)
  {
    this.x = paramGOST3410PrivateKeyParameters.getX();
    this.gost3410Spec = paramGOST3410ParameterSpec;
    if (paramGOST3410ParameterSpec != null) {
      return;
    }
    throw new IllegalArgumentException("spec is null");
  }
  
  BCGOST3410PrivateKey(GOST3410PrivateKey paramGOST3410PrivateKey)
  {
    this.x = paramGOST3410PrivateKey.getX();
    this.gost3410Spec = paramGOST3410PrivateKey.getParameters();
  }
  
  BCGOST3410PrivateKey(GOST3410PrivateKeySpec paramGOST3410PrivateKeySpec)
  {
    this.x = paramGOST3410PrivateKeySpec.getX();
    this.gost3410Spec = new GOST3410ParameterSpec(new GOST3410PublicKeyParameterSetSpec(paramGOST3410PrivateKeySpec.getP(), paramGOST3410PrivateKeySpec.getQ(), paramGOST3410PrivateKeySpec.getA()));
  }
  
  private boolean compareObj(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == paramObject2) {
      return true;
    }
    if (paramObject1 == null) {
      return false;
    }
    return paramObject1.equals(paramObject2);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    String str = (String)paramObjectInputStream.readObject();
    if (str != null)
    {
      this.gost3410Spec = new GOST3410ParameterSpec(str, (String)paramObjectInputStream.readObject(), (String)paramObjectInputStream.readObject());
    }
    else
    {
      this.gost3410Spec = new GOST3410ParameterSpec(new GOST3410PublicKeyParameterSetSpec((BigInteger)paramObjectInputStream.readObject(), (BigInteger)paramObjectInputStream.readObject(), (BigInteger)paramObjectInputStream.readObject()));
      paramObjectInputStream.readObject();
      paramObjectInputStream.readObject();
    }
    this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
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
    boolean bool1 = paramObject instanceof GOST3410PrivateKey;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (GOST3410PrivateKey)paramObject;
    bool1 = bool2;
    if (getX().equals(((GOST3410PrivateKey)paramObject).getX()))
    {
      bool1 = bool2;
      if (getParameters().getPublicKeyParameters().equals(((GOST3410PrivateKey)paramObject).getParameters().getPublicKeyParameters()))
      {
        bool1 = bool2;
        if (getParameters().getDigestParamSetOID().equals(((GOST3410PrivateKey)paramObject).getParameters().getDigestParamSetOID()))
        {
          bool1 = bool2;
          if (compareObj(getParameters().getEncryptionParamSetOID(), ((GOST3410PrivateKey)paramObject).getParameters().getEncryptionParamSetOID())) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public String getAlgorithm()
  {
    return "GOST3410";
  }
  
  public ASN1Encodable getBagAttribute(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    return this.attrCarrier.getBagAttribute(paramASN1ObjectIdentifier);
  }
  
  public Enumeration getBagAttributeKeys()
  {
    return this.attrCarrier.getBagAttributeKeys();
  }
  
  public byte[] getEncoded()
  {
    Object localObject = getX().toByteArray();
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
      if ((this.gost3410Spec instanceof GOST3410ParameterSpec)) {
        localObject = new PrivateKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_94, new GOST3410PublicKeyAlgParameters(new ASN1ObjectIdentifier(this.gost3410Spec.getPublicKeyParamSetOID()), new ASN1ObjectIdentifier(this.gost3410Spec.getDigestParamSetOID()))), new DEROctetString(arrayOfByte));
      } else {
        localObject = new PrivateKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3410_94), new DEROctetString(arrayOfByte));
      }
      localObject = ((PrivateKeyInfo)localObject).getEncoded("DER");
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
    return "PKCS#8";
  }
  
  public GOST3410Params getParameters()
  {
    return this.gost3410Spec;
  }
  
  public BigInteger getX()
  {
    return this.x;
  }
  
  public int hashCode()
  {
    return getX().hashCode() ^ this.gost3410Spec.hashCode();
  }
  
  public void setBagAttribute(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Encodable paramASN1Encodable)
  {
    this.attrCarrier.setBagAttribute(paramASN1ObjectIdentifier, paramASN1Encodable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\gost\BCGOST3410PrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */