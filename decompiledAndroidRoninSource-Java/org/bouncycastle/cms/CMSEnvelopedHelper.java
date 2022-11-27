package org.bouncycastle.cms;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.cms.KEKRecipientInfo;
import org.bouncycastle.asn1.cms.KeyAgreeRecipientInfo;
import org.bouncycastle.asn1.cms.KeyTransRecipientInfo;
import org.bouncycastle.asn1.cms.PasswordRecipientInfo;
import org.bouncycastle.asn1.cms.RecipientInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.operator.DigestCalculator;

class CMSEnvelopedHelper
{
  static RecipientInformationStore buildRecipientInformationStore(ASN1Set paramASN1Set, AlgorithmIdentifier paramAlgorithmIdentifier, CMSSecureReadable paramCMSSecureReadable)
  {
    return buildRecipientInformationStore(paramASN1Set, paramAlgorithmIdentifier, paramCMSSecureReadable, null);
  }
  
  static RecipientInformationStore buildRecipientInformationStore(ASN1Set paramASN1Set, AlgorithmIdentifier paramAlgorithmIdentifier, CMSSecureReadable paramCMSSecureReadable, AuthAttributesProvider paramAuthAttributesProvider)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i != paramASN1Set.size())
    {
      readRecipientInfo(localArrayList, RecipientInfo.getInstance(paramASN1Set.getObjectAt(i)), paramAlgorithmIdentifier, paramCMSSecureReadable, paramAuthAttributesProvider);
      i += 1;
    }
    return new RecipientInformationStore(localArrayList);
  }
  
  private static void readRecipientInfo(List paramList, RecipientInfo paramRecipientInfo, AlgorithmIdentifier paramAlgorithmIdentifier, CMSSecureReadable paramCMSSecureReadable, AuthAttributesProvider paramAuthAttributesProvider)
  {
    paramRecipientInfo = paramRecipientInfo.getInfo();
    if ((paramRecipientInfo instanceof KeyTransRecipientInfo)) {
      paramRecipientInfo = new KeyTransRecipientInformation((KeyTransRecipientInfo)paramRecipientInfo, paramAlgorithmIdentifier, paramCMSSecureReadable, paramAuthAttributesProvider);
    }
    for (;;)
    {
      paramList.add(paramRecipientInfo);
      return;
      if ((paramRecipientInfo instanceof KEKRecipientInfo))
      {
        paramRecipientInfo = new KEKRecipientInformation((KEKRecipientInfo)paramRecipientInfo, paramAlgorithmIdentifier, paramCMSSecureReadable, paramAuthAttributesProvider);
      }
      else
      {
        if ((paramRecipientInfo instanceof KeyAgreeRecipientInfo))
        {
          KeyAgreeRecipientInformation.readRecipientInfo(paramList, (KeyAgreeRecipientInfo)paramRecipientInfo, paramAlgorithmIdentifier, paramCMSSecureReadable, paramAuthAttributesProvider);
          return;
        }
        if (!(paramRecipientInfo instanceof PasswordRecipientInfo)) {
          break;
        }
        paramRecipientInfo = new PasswordRecipientInformation((PasswordRecipientInfo)paramRecipientInfo, paramAlgorithmIdentifier, paramCMSSecureReadable, paramAuthAttributesProvider);
      }
    }
  }
  
  static class CMSAuthenticatedSecureReadable
    implements CMSSecureReadable
  {
    private AlgorithmIdentifier algorithm;
    private CMSReadable readable;
    
    CMSAuthenticatedSecureReadable(AlgorithmIdentifier paramAlgorithmIdentifier, CMSReadable paramCMSReadable)
    {
      this.algorithm = paramAlgorithmIdentifier;
      this.readable = paramCMSReadable;
    }
    
    public InputStream getInputStream()
      throws IOException, CMSException
    {
      return this.readable.getInputStream();
    }
  }
  
  static class CMSDigestAuthenticatedSecureReadable
    implements CMSSecureReadable
  {
    private DigestCalculator digestCalculator;
    private CMSReadable readable;
    
    public CMSDigestAuthenticatedSecureReadable(DigestCalculator paramDigestCalculator, CMSReadable paramCMSReadable)
    {
      this.digestCalculator = paramDigestCalculator;
      this.readable = paramCMSReadable;
    }
    
    public byte[] getDigest()
    {
      return this.digestCalculator.getDigest();
    }
    
    public InputStream getInputStream()
      throws IOException, CMSException
    {
      new FilterInputStream(this.readable.getInputStream())
      {
        public int read()
          throws IOException
        {
          int i = this.in.read();
          if (i >= 0) {
            CMSEnvelopedHelper.CMSDigestAuthenticatedSecureReadable.this.digestCalculator.getOutputStream().write(i);
          }
          return i;
        }
        
        public int read(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
          throws IOException
        {
          paramAnonymousInt2 = this.in.read(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
          if (paramAnonymousInt2 >= 0) {
            CMSEnvelopedHelper.CMSDigestAuthenticatedSecureReadable.this.digestCalculator.getOutputStream().write(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
          }
          return paramAnonymousInt2;
        }
      };
    }
  }
  
  static class CMSEnvelopedSecureReadable
    implements CMSSecureReadable
  {
    private AlgorithmIdentifier algorithm;
    private CMSReadable readable;
    
    CMSEnvelopedSecureReadable(AlgorithmIdentifier paramAlgorithmIdentifier, CMSReadable paramCMSReadable)
    {
      this.algorithm = paramAlgorithmIdentifier;
      this.readable = paramCMSReadable;
    }
    
    public InputStream getInputStream()
      throws IOException, CMSException
    {
      return this.readable.getInputStream();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\CMSEnvelopedHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */