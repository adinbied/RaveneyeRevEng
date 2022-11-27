package org.bouncycastle.pqc.jcajce.provider.sphincs;

import java.io.IOException;
import java.security.PrivateKey;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.asn1.SPHINCS256KeyParams;
import org.bouncycastle.pqc.crypto.sphincs.SPHINCSPrivateKeyParameters;
import org.bouncycastle.pqc.jcajce.interfaces.SPHINCSKey;
import org.bouncycastle.util.Arrays;

public class BCSphincs256PrivateKey
  implements PrivateKey, SPHINCSKey
{
  private static final long serialVersionUID = 1L;
  private final SPHINCSPrivateKeyParameters params;
  private final ASN1ObjectIdentifier treeDigest;
  
  public BCSphincs256PrivateKey(ASN1ObjectIdentifier paramASN1ObjectIdentifier, SPHINCSPrivateKeyParameters paramSPHINCSPrivateKeyParameters)
  {
    this.treeDigest = paramASN1ObjectIdentifier;
    this.params = paramSPHINCSPrivateKeyParameters;
  }
  
  public BCSphincs256PrivateKey(PrivateKeyInfo paramPrivateKeyInfo)
    throws IOException
  {
    this.treeDigest = SPHINCS256KeyParams.getInstance(paramPrivateKeyInfo.getPrivateKeyAlgorithm().getParameters()).getTreeDigest().getAlgorithm();
    this.params = new SPHINCSPrivateKeyParameters(ASN1OctetString.getInstance(paramPrivateKeyInfo.parsePrivateKey()).getOctets());
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      if (!(paramObject instanceof BCSphincs256PrivateKey)) {
        return false;
      }
      paramObject = (BCSphincs256PrivateKey)paramObject;
      bool1 = bool2;
      if (this.treeDigest.equals(((BCSphincs256PrivateKey)paramObject).treeDigest))
      {
        bool1 = bool2;
        if (Arrays.areEqual(this.params.getKeyData(), ((BCSphincs256PrivateKey)paramObject).params.getKeyData())) {
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
      byte[] arrayOfByte = new PrivateKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.sphincs256, new SPHINCS256KeyParams(new AlgorithmIdentifier(this.treeDigest))), new DEROctetString(this.params.getKeyData())).getEncoded();
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
    return "PKCS#8";
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\jcajce\provider\sphincs\BCSphincs256PrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */