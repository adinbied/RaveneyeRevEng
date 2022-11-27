package org.bouncycastle.pqc.jcajce.provider.sphincs;

import java.io.IOException;
import java.security.PublicKey;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.asn1.SPHINCS256KeyParams;
import org.bouncycastle.pqc.crypto.sphincs.SPHINCSPublicKeyParameters;
import org.bouncycastle.pqc.jcajce.interfaces.SPHINCSKey;
import org.bouncycastle.util.Arrays;

public class BCSphincs256PublicKey
  implements PublicKey, SPHINCSKey
{
  private static final long serialVersionUID = 1L;
  private final SPHINCSPublicKeyParameters params;
  private final ASN1ObjectIdentifier treeDigest;
  
  public BCSphincs256PublicKey(ASN1ObjectIdentifier paramASN1ObjectIdentifier, SPHINCSPublicKeyParameters paramSPHINCSPublicKeyParameters)
  {
    this.treeDigest = paramASN1ObjectIdentifier;
    this.params = paramSPHINCSPublicKeyParameters;
  }
  
  public BCSphincs256PublicKey(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
  {
    this.treeDigest = SPHINCS256KeyParams.getInstance(paramSubjectPublicKeyInfo.getAlgorithm().getParameters()).getTreeDigest().getAlgorithm();
    this.params = new SPHINCSPublicKeyParameters(paramSubjectPublicKeyInfo.getPublicKeyData().getBytes());
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      if (!(paramObject instanceof BCSphincs256PublicKey)) {
        return false;
      }
      paramObject = (BCSphincs256PublicKey)paramObject;
      bool1 = bool2;
      if (this.treeDigest.equals(((BCSphincs256PublicKey)paramObject).treeDigest))
      {
        bool1 = bool2;
        if (Arrays.areEqual(this.params.getKeyData(), ((BCSphincs256PublicKey)paramObject).params.getKeyData())) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final String getAlgorithm()
  {
    return "SPHINCS-256";
  }
  
  public byte[] getEncoded()
  {
    try
    {
      byte[] arrayOfByte = new SubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.sphincs256, new SPHINCS256KeyParams(new AlgorithmIdentifier(this.treeDigest))), this.params.getKeyData()).getEncoded();
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
  
  public byte[] getKeyData()
  {
    return this.params.getKeyData();
  }
  
  CipherParameters getKeyParams()
  {
    return this.params;
  }
  
  public int hashCode()
  {
    return this.treeDigest.hashCode() + Arrays.hashCode(this.params.getKeyData()) * 37;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\jcajce\provider\sphincs\BCSphincs256PublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */