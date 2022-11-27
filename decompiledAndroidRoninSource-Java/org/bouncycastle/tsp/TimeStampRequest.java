package org.bouncycastle.tsp;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.bouncycastle.asn1.ASN1Boolean;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.tsp.MessageImprint;
import org.bouncycastle.asn1.tsp.TimeStampReq;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.Extensions;

public class TimeStampRequest
{
  private static Set EMPTY_SET = Collections.unmodifiableSet(new HashSet());
  private Extensions extensions;
  private TimeStampReq req;
  
  public TimeStampRequest(InputStream paramInputStream)
    throws IOException
  {
    this(loadRequest(paramInputStream));
  }
  
  public TimeStampRequest(TimeStampReq paramTimeStampReq)
  {
    this.req = paramTimeStampReq;
    this.extensions = paramTimeStampReq.getExtensions();
  }
  
  public TimeStampRequest(byte[] paramArrayOfByte)
    throws IOException
  {
    this(new ByteArrayInputStream(paramArrayOfByte));
  }
  
  private Set convert(Set paramSet)
  {
    if (paramSet == null) {
      return paramSet;
    }
    HashSet localHashSet = new HashSet(paramSet.size());
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      Object localObject = paramSet.next();
      if ((localObject instanceof String)) {
        localHashSet.add(new ASN1ObjectIdentifier((String)localObject));
      } else {
        localHashSet.add(localObject);
      }
    }
    return localHashSet;
  }
  
  private static TimeStampReq loadRequest(InputStream paramInputStream)
    throws IOException
  {
    try
    {
      paramInputStream = TimeStampReq.getInstance(new ASN1InputStream(paramInputStream).readObject());
      return paramInputStream;
    }
    catch (IllegalArgumentException paramInputStream)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("malformed request: ");
      localStringBuilder.append(paramInputStream);
      throw new IOException(localStringBuilder.toString());
    }
    catch (ClassCastException paramInputStream)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("malformed request: ");
      localStringBuilder.append(paramInputStream);
      throw new IOException(localStringBuilder.toString());
    }
  }
  
  public boolean getCertReq()
  {
    if (this.req.getCertReq() != null) {
      return this.req.getCertReq().isTrue();
    }
    return false;
  }
  
  public Set getCriticalExtensionOIDs()
  {
    if (this.extensions == null) {
      return EMPTY_SET;
    }
    return Collections.unmodifiableSet(new HashSet(Arrays.asList(this.extensions.getCriticalExtensionOIDs())));
  }
  
  public byte[] getEncoded()
    throws IOException
  {
    return this.req.getEncoded();
  }
  
  public Extension getExtension(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    Extensions localExtensions = this.extensions;
    if (localExtensions != null) {
      return localExtensions.getExtension(paramASN1ObjectIdentifier);
    }
    return null;
  }
  
  public List getExtensionOIDs()
  {
    return TSPUtil.getExtensionOIDs(this.extensions);
  }
  
  Extensions getExtensions()
  {
    return this.extensions;
  }
  
  public ASN1ObjectIdentifier getMessageImprintAlgOID()
  {
    return this.req.getMessageImprint().getHashAlgorithm().getAlgorithm();
  }
  
  public byte[] getMessageImprintDigest()
  {
    return this.req.getMessageImprint().getHashedMessage();
  }
  
  public Set getNonCriticalExtensionOIDs()
  {
    if (this.extensions == null) {
      return EMPTY_SET;
    }
    return Collections.unmodifiableSet(new HashSet(Arrays.asList(this.extensions.getNonCriticalExtensionOIDs())));
  }
  
  public BigInteger getNonce()
  {
    if (this.req.getNonce() != null) {
      return this.req.getNonce().getValue();
    }
    return null;
  }
  
  public ASN1ObjectIdentifier getReqPolicy()
  {
    if (this.req.getReqPolicy() != null) {
      return this.req.getReqPolicy();
    }
    return null;
  }
  
  public int getVersion()
  {
    return this.req.getVersion().getValue().intValue();
  }
  
  public boolean hasExtensions()
  {
    return this.extensions != null;
  }
  
  public void validate(Set paramSet1, Set paramSet2, Set paramSet3)
    throws TSPException
  {
    paramSet1 = convert(paramSet1);
    paramSet2 = convert(paramSet2);
    paramSet3 = convert(paramSet3);
    if (paramSet1.contains(getMessageImprintAlgOID()))
    {
      if ((paramSet2 != null) && (getReqPolicy() != null) && (!paramSet2.contains(getReqPolicy()))) {
        throw new TSPValidationException("request contains unknown policy", 256);
      }
      if ((getExtensions() != null) && (paramSet3 != null))
      {
        paramSet1 = getExtensions().oids();
        while (paramSet1.hasMoreElements()) {
          if (!paramSet3.contains((ASN1ObjectIdentifier)paramSet1.nextElement())) {
            throw new TSPValidationException("request contains unknown extension", 8388608);
          }
        }
      }
      if (TSPUtil.getDigestLength(getMessageImprintAlgOID().getId()) == getMessageImprintDigest().length) {
        return;
      }
      throw new TSPValidationException("imprint digest the wrong length", 4);
    }
    throw new TSPValidationException("request contains unknown algorithm", 128);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\tsp\TimeStampRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */