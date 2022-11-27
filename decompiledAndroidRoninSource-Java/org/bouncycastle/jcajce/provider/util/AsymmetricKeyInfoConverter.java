package org.bouncycastle.jcajce.provider.util;

import java.io.IOException;
import java.security.PrivateKey;
import java.security.PublicKey;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;

public abstract interface AsymmetricKeyInfoConverter
{
  public abstract PrivateKey generatePrivate(PrivateKeyInfo paramPrivateKeyInfo)
    throws IOException;
  
  public abstract PublicKey generatePublic(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
    throws IOException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provide\\util\AsymmetricKeyInfoConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */