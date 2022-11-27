package org.bouncycastle.openssl.jcajce;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.Provider;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.pkix.jcajce.JcaPKIXIdentity;

public class JcaPKIXIdentityBuilder
{
  private JcaX509CertificateConverter certConverter = new JcaX509CertificateConverter();
  private JcaPEMKeyConverter keyConverter = new JcaPEMKeyConverter();
  
  private void checkFile(File paramFile)
    throws IOException
  {
    if (paramFile.canRead())
    {
      if (paramFile.exists())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unable to open file ");
        localStringBuilder.append(paramFile.getPath());
        localStringBuilder.append(" for reading.");
        throw new IOException(localStringBuilder.toString());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to open ");
      localStringBuilder.append(paramFile.getPath());
      localStringBuilder.append(": it does not exist.");
      throw new FileNotFoundException(localStringBuilder.toString());
    }
  }
  
  public JcaPKIXIdentity build(File paramFile1, File paramFile2)
    throws IOException, CertificateException
  {
    checkFile(paramFile1);
    checkFile(paramFile2);
    paramFile1 = new FileInputStream(paramFile1);
    paramFile2 = new FileInputStream(paramFile2);
    JcaPKIXIdentity localJcaPKIXIdentity = build(paramFile1, paramFile2);
    paramFile1.close();
    paramFile2.close();
    return localJcaPKIXIdentity;
  }
  
  public JcaPKIXIdentity build(InputStream paramInputStream1, InputStream paramInputStream2)
    throws IOException, CertificateException
  {
    Object localObject1 = new PEMParser(new InputStreamReader(paramInputStream1)).readObject();
    if ((localObject1 instanceof PEMKeyPair))
    {
      localObject1 = (PEMKeyPair)localObject1;
      paramInputStream1 = this.keyConverter;
    }
    for (localObject1 = ((PEMKeyPair)localObject1).getPrivateKeyInfo();; localObject1 = (PrivateKeyInfo)localObject1)
    {
      paramInputStream1 = paramInputStream1.getPrivateKey((PrivateKeyInfo)localObject1);
      break;
      if (!(localObject1 instanceof PrivateKeyInfo)) {
        break label157;
      }
      paramInputStream1 = this.keyConverter;
    }
    paramInputStream2 = new PEMParser(new InputStreamReader(paramInputStream2));
    localObject1 = new ArrayList();
    for (;;)
    {
      Object localObject2 = paramInputStream2.readObject();
      if (localObject2 == null) {
        break;
      }
      ((List)localObject1).add(this.certConverter.getCertificate((X509CertificateHolder)localObject2));
    }
    return new JcaPKIXIdentity(paramInputStream1, (X509Certificate[])((List)localObject1).toArray(new X509Certificate[((List)localObject1).size()]));
    label157:
    throw new IOException("unrecognised private key file");
  }
  
  public JcaPKIXIdentityBuilder setProvider(String paramString)
  {
    this.keyConverter = this.keyConverter.setProvider(paramString);
    this.certConverter = this.certConverter.setProvider(paramString);
    return this;
  }
  
  public JcaPKIXIdentityBuilder setProvider(Provider paramProvider)
  {
    this.keyConverter = this.keyConverter.setProvider(paramProvider);
    this.certConverter = this.certConverter.setProvider(paramProvider);
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\openssl\jcajce\JcaPKIXIdentityBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */