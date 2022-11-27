package org.bouncycastle.cms;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.cms.DigestedData;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Encodable;

public class CMSDigestedData
  implements Encodable
{
  private ContentInfo contentInfo;
  private DigestedData digestedData;
  
  public CMSDigestedData(InputStream paramInputStream)
    throws CMSException
  {
    this(CMSUtils.readContentInfo(paramInputStream));
  }
  
  public CMSDigestedData(ContentInfo paramContentInfo)
    throws CMSException
  {
    this.contentInfo = paramContentInfo;
    try
    {
      this.digestedData = DigestedData.getInstance(paramContentInfo.getContent());
      return;
    }
    catch (IllegalArgumentException paramContentInfo)
    {
      throw new CMSException("Malformed content.", paramContentInfo);
    }
    catch (ClassCastException paramContentInfo)
    {
      throw new CMSException("Malformed content.", paramContentInfo);
    }
  }
  
  public CMSDigestedData(byte[] paramArrayOfByte)
    throws CMSException
  {
    this(CMSUtils.readContentInfo(paramArrayOfByte));
  }
  
  public ASN1ObjectIdentifier getContentType()
  {
    return this.contentInfo.getContentType();
  }
  
  public AlgorithmIdentifier getDigestAlgorithm()
  {
    return this.digestedData.getDigestAlgorithm();
  }
  
  public CMSProcessable getDigestedContent()
    throws CMSException
  {
    Object localObject = this.digestedData.getEncapContentInfo();
    try
    {
      localObject = new CMSProcessableByteArray(((ContentInfo)localObject).getContentType(), ((ASN1OctetString)((ContentInfo)localObject).getContent()).getOctets());
      return (CMSProcessable)localObject;
    }
    catch (Exception localException)
    {
      throw new CMSException("exception reading digested stream.", localException);
    }
  }
  
  public byte[] getEncoded()
    throws IOException
  {
    return this.contentInfo.getEncoded();
  }
  
  public ContentInfo toASN1Structure()
  {
    return this.contentInfo;
  }
  
  public boolean verify(DigestCalculatorProvider paramDigestCalculatorProvider)
    throws CMSException
  {
    try
    {
      localObject = this.digestedData.getEncapContentInfo();
      paramDigestCalculatorProvider = paramDigestCalculatorProvider.get(this.digestedData.getDigestAlgorithm());
      paramDigestCalculatorProvider.getOutputStream().write(((ASN1OctetString)((ContentInfo)localObject).getContent()).getOctets());
      boolean bool = Arrays.areEqual(this.digestedData.getDigest(), paramDigestCalculatorProvider.getDigest());
      return bool;
    }
    catch (IOException paramDigestCalculatorProvider)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unable process content: ");
      ((StringBuilder)localObject).append(paramDigestCalculatorProvider.getMessage());
      throw new CMSException(((StringBuilder)localObject).toString(), paramDigestCalculatorProvider);
    }
    catch (OperatorCreationException paramDigestCalculatorProvider)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unable to create digest calculator: ");
      ((StringBuilder)localObject).append(paramDigestCalculatorProvider.getMessage());
      throw new CMSException(((StringBuilder)localObject).toString(), paramDigestCalculatorProvider);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\CMSDigestedData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */