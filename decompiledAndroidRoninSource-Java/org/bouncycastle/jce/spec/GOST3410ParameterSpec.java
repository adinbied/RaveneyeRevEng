package org.bouncycastle.jce.spec;

import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.cryptopro.GOST3410NamedParameters;
import org.bouncycastle.asn1.cryptopro.GOST3410ParamSetParameters;
import org.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.bouncycastle.jce.interfaces.GOST3410Params;

public class GOST3410ParameterSpec
  implements AlgorithmParameterSpec, GOST3410Params
{
  private String digestParamSetOID;
  private String encryptionParamSetOID;
  private String keyParamSetOID;
  private GOST3410PublicKeyParameterSetSpec keyParameters;
  
  public GOST3410ParameterSpec(String paramString)
  {
    this(paramString, CryptoProObjectIdentifiers.gostR3411_94_CryptoProParamSet.getId(), null);
  }
  
  public GOST3410ParameterSpec(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, null);
  }
  
  public GOST3410ParameterSpec(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      localObject = GOST3410NamedParameters.getByOID(new ASN1ObjectIdentifier(paramString1));
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      Object localObject;
      for (;;) {}
    }
    localObject = GOST3410NamedParameters.getOID(paramString1);
    if (localObject != null)
    {
      paramString1 = ((ASN1ObjectIdentifier)localObject).getId();
      localObject = GOST3410NamedParameters.getByOID((ASN1ObjectIdentifier)localObject);
    }
    else
    {
      localObject = null;
    }
    if (localObject != null)
    {
      this.keyParameters = new GOST3410PublicKeyParameterSetSpec(((GOST3410ParamSetParameters)localObject).getP(), ((GOST3410ParamSetParameters)localObject).getQ(), ((GOST3410ParamSetParameters)localObject).getA());
      this.keyParamSetOID = paramString1;
      this.digestParamSetOID = paramString2;
      this.encryptionParamSetOID = paramString3;
      return;
    }
    throw new IllegalArgumentException("no key parameter set for passed in name/OID.");
  }
  
  public GOST3410ParameterSpec(GOST3410PublicKeyParameterSetSpec paramGOST3410PublicKeyParameterSetSpec)
  {
    this.keyParameters = paramGOST3410PublicKeyParameterSetSpec;
    this.digestParamSetOID = CryptoProObjectIdentifiers.gostR3411_94_CryptoProParamSet.getId();
    this.encryptionParamSetOID = null;
  }
  
  public static GOST3410ParameterSpec fromPublicKeyAlg(GOST3410PublicKeyAlgParameters paramGOST3410PublicKeyAlgParameters)
  {
    if (paramGOST3410PublicKeyAlgParameters.getEncryptionParamSet() != null) {
      return new GOST3410ParameterSpec(paramGOST3410PublicKeyAlgParameters.getPublicKeyParamSet().getId(), paramGOST3410PublicKeyAlgParameters.getDigestParamSet().getId(), paramGOST3410PublicKeyAlgParameters.getEncryptionParamSet().getId());
    }
    return new GOST3410ParameterSpec(paramGOST3410PublicKeyAlgParameters.getPublicKeyParamSet().getId(), paramGOST3410PublicKeyAlgParameters.getDigestParamSet().getId());
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof GOST3410ParameterSpec;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      Object localObject = (GOST3410ParameterSpec)paramObject;
      bool1 = bool2;
      if (this.keyParameters.equals(((GOST3410ParameterSpec)localObject).keyParameters))
      {
        bool1 = bool2;
        if (this.digestParamSetOID.equals(((GOST3410ParameterSpec)localObject).digestParamSetOID))
        {
          paramObject = this.encryptionParamSetOID;
          localObject = ((GOST3410ParameterSpec)localObject).encryptionParamSetOID;
          if (paramObject != localObject)
          {
            bool1 = bool2;
            if (paramObject != null)
            {
              bool1 = bool2;
              if (!((String)paramObject).equals(localObject)) {}
            }
          }
          else
          {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public String getDigestParamSetOID()
  {
    return this.digestParamSetOID;
  }
  
  public String getEncryptionParamSetOID()
  {
    return this.encryptionParamSetOID;
  }
  
  public String getPublicKeyParamSetOID()
  {
    return this.keyParamSetOID;
  }
  
  public GOST3410PublicKeyParameterSetSpec getPublicKeyParameters()
  {
    return this.keyParameters;
  }
  
  public int hashCode()
  {
    int j = this.keyParameters.hashCode();
    int k = this.digestParamSetOID.hashCode();
    String str = this.encryptionParamSetOID;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return j ^ k ^ i;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\spec\GOST3410ParameterSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */