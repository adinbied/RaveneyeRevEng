package org.bouncycastle.x509;

import java.security.cert.CertPath;
import java.util.List;
import org.bouncycastle.i18n.ErrorBundle;
import org.bouncycastle.i18n.LocalizedException;

public class CertPathReviewerException
  extends LocalizedException
{
  private CertPath certPath = null;
  private int index = -1;
  
  public CertPathReviewerException(ErrorBundle paramErrorBundle)
  {
    super(paramErrorBundle);
  }
  
  public CertPathReviewerException(ErrorBundle paramErrorBundle, Throwable paramThrowable)
  {
    super(paramErrorBundle, paramThrowable);
  }
  
  public CertPathReviewerException(ErrorBundle paramErrorBundle, Throwable paramThrowable, CertPath paramCertPath, int paramInt)
  {
    super(paramErrorBundle, paramThrowable);
    if ((paramCertPath != null) && (paramInt != -1))
    {
      if ((paramInt >= -1) && ((paramCertPath == null) || (paramInt < paramCertPath.getCertificates().size())))
      {
        this.certPath = paramCertPath;
        this.index = paramInt;
        return;
      }
      throw new IndexOutOfBoundsException();
    }
    throw new IllegalArgumentException();
  }
  
  public CertPathReviewerException(ErrorBundle paramErrorBundle, CertPath paramCertPath, int paramInt)
  {
    super(paramErrorBundle);
    if ((paramCertPath != null) && (paramInt != -1))
    {
      if ((paramInt >= -1) && ((paramCertPath == null) || (paramInt < paramCertPath.getCertificates().size())))
      {
        this.certPath = paramCertPath;
        this.index = paramInt;
        return;
      }
      throw new IndexOutOfBoundsException();
    }
    throw new IllegalArgumentException();
  }
  
  public CertPath getCertPath()
  {
    return this.certPath;
  }
  
  public int getIndex()
  {
    return this.index;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\x509\CertPathReviewerException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */