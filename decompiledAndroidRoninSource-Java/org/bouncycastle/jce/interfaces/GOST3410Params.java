package org.bouncycastle.jce.interfaces;

import org.bouncycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;

public abstract interface GOST3410Params
{
  public abstract String getDigestParamSetOID();
  
  public abstract String getEncryptionParamSetOID();
  
  public abstract String getPublicKeyParamSetOID();
  
  public abstract GOST3410PublicKeyParameterSetSpec getPublicKeyParameters();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\interfaces\GOST3410Params.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */