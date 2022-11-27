package org.bouncycastle.cert.dane;

import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.operator.DigestCalculator;

public class DANEEntryFactory
{
  private final DANEEntrySelectorFactory selectorFactory;
  
  public DANEEntryFactory(DigestCalculator paramDigestCalculator)
  {
    this.selectorFactory = new DANEEntrySelectorFactory(paramDigestCalculator);
  }
  
  public DANEEntry createEntry(String paramString, int paramInt, X509CertificateHolder paramX509CertificateHolder)
    throws DANEException
  {
    if ((paramInt >= 0) && (paramInt <= 3))
    {
      paramString = this.selectorFactory.createSelector(paramString);
      int i = (byte)paramInt;
      return new DANEEntry(paramString.getDomainName(), new byte[] { i, 0, 0 }, paramX509CertificateHolder);
    }
    paramString = new StringBuilder();
    paramString.append("unknown certificate usage: ");
    paramString.append(paramInt);
    throw new DANEException(paramString.toString());
  }
  
  public DANEEntry createEntry(String paramString, X509CertificateHolder paramX509CertificateHolder)
    throws DANEException
  {
    return createEntry(paramString, 3, paramX509CertificateHolder);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\dane\DANEEntryFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */