package org.bouncycastle.tsp;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.SimpleTimeZone;
import org.bouncycastle.asn1.ASN1Boolean;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.cms.AttributeTable;
import org.bouncycastle.asn1.ess.ESSCertID;
import org.bouncycastle.asn1.ess.ESSCertIDv2;
import org.bouncycastle.asn1.ess.SigningCertificate;
import org.bouncycastle.asn1.ess.SigningCertificateV2;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.tsp.Accuracy;
import org.bouncycastle.asn1.tsp.MessageImprint;
import org.bouncycastle.asn1.tsp.TSTInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.ExtensionsGenerator;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.IssuerSerial;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cms.CMSAttributeTableGenerationException;
import org.bouncycastle.cms.CMSAttributeTableGenerator;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.CMSProcessableByteArray;
import org.bouncycastle.cms.CMSSignedDataGenerator;
import org.bouncycastle.cms.SignerInfoGenerator;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.util.CollectionStore;
import org.bouncycastle.util.Store;

public class TimeStampTokenGenerator
{
  public static final int R_MICROSECONDS = 2;
  public static final int R_MILLISECONDS = 3;
  public static final int R_SECONDS = 0;
  public static final int R_TENTHS_OF_SECONDS = 1;
  private int accuracyMicros;
  private int accuracyMillis;
  private int accuracySeconds;
  private List attrCerts;
  private List certs;
  private List crls;
  private Locale locale;
  boolean ordering;
  private Map otherRevoc;
  private int resolution = 0;
  private SignerInfoGenerator signerInfoGen;
  GeneralName tsa;
  private ASN1ObjectIdentifier tsaPolicyOID;
  
  public TimeStampTokenGenerator(SignerInfoGenerator paramSignerInfoGenerator, DigestCalculator paramDigestCalculator, ASN1ObjectIdentifier paramASN1ObjectIdentifier)
    throws IllegalArgumentException, TSPException
  {
    this(paramSignerInfoGenerator, paramDigestCalculator, paramASN1ObjectIdentifier, false);
  }
  
  public TimeStampTokenGenerator(final SignerInfoGenerator paramSignerInfoGenerator, DigestCalculator paramDigestCalculator, ASN1ObjectIdentifier paramASN1ObjectIdentifier, boolean paramBoolean)
    throws IllegalArgumentException, TSPException
  {
    byte[] arrayOfByte = null;
    AlgorithmIdentifier localAlgorithmIdentifier = null;
    this.locale = null;
    this.accuracySeconds = -1;
    this.accuracyMillis = -1;
    this.accuracyMicros = -1;
    this.ordering = false;
    this.tsa = null;
    this.certs = new ArrayList();
    this.crls = new ArrayList();
    this.attrCerts = new ArrayList();
    this.otherRevoc = new HashMap();
    this.signerInfoGen = paramSignerInfoGenerator;
    this.tsaPolicyOID = paramASN1ObjectIdentifier;
    if (paramSignerInfoGenerator.hasAssociatedCertificate())
    {
      paramASN1ObjectIdentifier = paramSignerInfoGenerator.getAssociatedCertificate();
      TSPUtil.validateCertificate(paramASN1ObjectIdentifier);
      try
      {
        Object localObject = paramDigestCalculator.getOutputStream();
        ((OutputStream)localObject).write(paramASN1ObjectIdentifier.getEncoded());
        ((OutputStream)localObject).close();
        if (paramDigestCalculator.getAlgorithmIdentifier().getAlgorithm().equals(OIWObjectIdentifiers.idSHA1))
        {
          arrayOfByte = paramDigestCalculator.getDigest();
          paramDigestCalculator = localAlgorithmIdentifier;
          if (paramBoolean) {
            paramDigestCalculator = new IssuerSerial(new GeneralNames(new GeneralName(paramASN1ObjectIdentifier.getIssuer())), paramASN1ObjectIdentifier.getSerialNumber());
          }
        }
        for (paramSignerInfoGenerator = new SignerInfoGenerator(paramSignerInfoGenerator, new CMSAttributeTableGenerator()
            {
              public AttributeTable getAttributes(Map paramAnonymousMap)
                throws CMSAttributeTableGenerationException
              {
                AttributeTable localAttributeTable = paramSignerInfoGenerator.getSignedAttributeTableGenerator().getAttributes(paramAnonymousMap);
                paramAnonymousMap = localAttributeTable;
                if (localAttributeTable.get(PKCSObjectIdentifiers.id_aa_signingCertificate) == null) {
                  paramAnonymousMap = localAttributeTable.add(PKCSObjectIdentifiers.id_aa_signingCertificate, new SigningCertificate(this.val$essCertid));
                }
                return paramAnonymousMap;
              }
            }, paramSignerInfoGenerator.getUnsignedAttributeTableGenerator());; paramSignerInfoGenerator = new SignerInfoGenerator(paramSignerInfoGenerator, new CMSAttributeTableGenerator()
            {
              public AttributeTable getAttributes(Map paramAnonymousMap)
                throws CMSAttributeTableGenerationException
              {
                AttributeTable localAttributeTable = paramSignerInfoGenerator.getSignedAttributeTableGenerator().getAttributes(paramAnonymousMap);
                paramAnonymousMap = localAttributeTable;
                if (localAttributeTable.get(PKCSObjectIdentifiers.id_aa_signingCertificateV2) == null) {
                  paramAnonymousMap = localAttributeTable.add(PKCSObjectIdentifiers.id_aa_signingCertificateV2, new SigningCertificateV2(this.val$essCertid));
                }
                return paramAnonymousMap;
              }
            }, paramSignerInfoGenerator.getUnsignedAttributeTableGenerator()))
        {
          this.signerInfoGen = paramSignerInfoGenerator;
          return;
          localAlgorithmIdentifier = new AlgorithmIdentifier(paramDigestCalculator.getAlgorithmIdentifier().getAlgorithm());
          localObject = paramDigestCalculator.getDigest();
          paramDigestCalculator = arrayOfByte;
          if (paramBoolean) {
            paramDigestCalculator = new IssuerSerial(new GeneralNames(new GeneralName(paramASN1ObjectIdentifier.getIssuer())), new ASN1Integer(paramASN1ObjectIdentifier.getSerialNumber()));
          }
        }
        throw new IllegalArgumentException("SignerInfoGenerator must have an associated certificate");
      }
      catch (IOException paramSignerInfoGenerator)
      {
        throw new TSPException("Exception processing certificate.", paramSignerInfoGenerator);
      }
    }
  }
  
  private ASN1GeneralizedTime createGeneralizedTime(Date paramDate)
    throws TSPException
  {
    SimpleDateFormat localSimpleDateFormat;
    if (this.locale == null) {
      localSimpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss.SSS");
    } else {
      localSimpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss.SSS", this.locale);
    }
    localSimpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
    paramDate = new StringBuilder(localSimpleDateFormat.format(paramDate));
    int j = paramDate.indexOf(".");
    if (j < 0)
    {
      paramDate.append("Z");
      return new ASN1GeneralizedTime(paramDate.toString());
    }
    int i = this.resolution;
    int k;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          break label200;
        }
        paramDate = new StringBuilder();
        paramDate.append("unknown time-stamp resolution: ");
        paramDate.append(this.resolution);
        throw new TSPException(paramDate.toString());
      }
      k = paramDate.length();
      i = j + 3;
      if (k <= i) {
        break label200;
      }
    }
    else
    {
      k = paramDate.length();
      i = j + 2;
      if (k <= i) {
        break label200;
      }
    }
    paramDate.delete(i, paramDate.length());
    label200:
    while (paramDate.charAt(paramDate.length() - 1) == '0') {
      paramDate.deleteCharAt(paramDate.length() - 1);
    }
    if (paramDate.length() - 1 == j) {
      paramDate.deleteCharAt(paramDate.length() - 1);
    }
    paramDate.append("Z");
    return new ASN1GeneralizedTime(paramDate.toString());
  }
  
  public void addAttributeCertificates(Store paramStore)
  {
    this.attrCerts.addAll(paramStore.getMatches(null));
  }
  
  public void addCRLs(Store paramStore)
  {
    this.crls.addAll(paramStore.getMatches(null));
  }
  
  public void addCertificates(Store paramStore)
  {
    this.certs.addAll(paramStore.getMatches(null));
  }
  
  public void addOtherRevocationInfo(ASN1ObjectIdentifier paramASN1ObjectIdentifier, Store paramStore)
  {
    this.otherRevoc.put(paramASN1ObjectIdentifier, paramStore.getMatches(null));
  }
  
  public TimeStampToken generate(TimeStampRequest paramTimeStampRequest, BigInteger paramBigInteger, Date paramDate)
    throws TSPException
  {
    return generate(paramTimeStampRequest, paramBigInteger, paramDate, null);
  }
  
  public TimeStampToken generate(TimeStampRequest paramTimeStampRequest, BigInteger paramBigInteger, Date paramDate, Extensions paramExtensions)
    throws TSPException
  {
    MessageImprint localMessageImprint = new MessageImprint(new AlgorithmIdentifier(paramTimeStampRequest.getMessageImprintAlgOID(), DERNull.INSTANCE), paramTimeStampRequest.getMessageImprintDigest());
    Object localObject1;
    Object localObject2;
    ASN1Integer localASN1Integer;
    if ((this.accuracySeconds <= 0) && (this.accuracyMillis <= 0) && (this.accuracyMicros <= 0))
    {
      localObject1 = null;
    }
    else
    {
      int i = this.accuracySeconds;
      if (i > 0) {
        localObject1 = new ASN1Integer(i);
      } else {
        localObject1 = null;
      }
      i = this.accuracyMillis;
      if (i > 0) {
        localObject2 = new ASN1Integer(i);
      } else {
        localObject2 = null;
      }
      i = this.accuracyMicros;
      if (i > 0) {
        localASN1Integer = new ASN1Integer(i);
      } else {
        localASN1Integer = null;
      }
      localObject1 = new Accuracy((ASN1Integer)localObject1, (ASN1Integer)localObject2, localASN1Integer);
    }
    boolean bool = this.ordering;
    if (bool) {
      localObject2 = ASN1Boolean.getInstance(bool);
    } else {
      localObject2 = null;
    }
    if (paramTimeStampRequest.getNonce() != null) {
      localASN1Integer = new ASN1Integer(paramTimeStampRequest.getNonce());
    } else {
      localASN1Integer = null;
    }
    ASN1ObjectIdentifier localASN1ObjectIdentifier = this.tsaPolicyOID;
    if (paramTimeStampRequest.getReqPolicy() != null) {
      localASN1ObjectIdentifier = paramTimeStampRequest.getReqPolicy();
    }
    Object localObject3 = paramTimeStampRequest.getExtensions();
    if (paramExtensions != null)
    {
      ExtensionsGenerator localExtensionsGenerator = new ExtensionsGenerator();
      if (localObject3 != null)
      {
        Enumeration localEnumeration = ((Extensions)localObject3).oids();
        while (localEnumeration.hasMoreElements()) {
          localExtensionsGenerator.addExtension(((Extensions)localObject3).getExtension(ASN1ObjectIdentifier.getInstance(localEnumeration.nextElement())));
        }
      }
      localObject3 = paramExtensions.oids();
      while (((Enumeration)localObject3).hasMoreElements()) {
        localExtensionsGenerator.addExtension(paramExtensions.getExtension(ASN1ObjectIdentifier.getInstance(((Enumeration)localObject3).nextElement())));
      }
      paramExtensions = localExtensionsGenerator.generate();
    }
    else
    {
      paramExtensions = (Extensions)localObject3;
    }
    if (this.resolution == 0)
    {
      localObject3 = this.locale;
      if (localObject3 == null) {
        paramDate = new ASN1GeneralizedTime(paramDate);
      } else {
        paramDate = new ASN1GeneralizedTime(paramDate, (Locale)localObject3);
      }
    }
    else
    {
      paramDate = createGeneralizedTime(paramDate);
    }
    paramDate = new TSTInfo(localASN1ObjectIdentifier, localMessageImprint, new ASN1Integer(paramBigInteger), paramDate, (Accuracy)localObject1, (ASN1Boolean)localObject2, localASN1Integer, this.tsa, paramExtensions);
    try
    {
      paramBigInteger = new CMSSignedDataGenerator();
      if (paramTimeStampRequest.getCertReq())
      {
        paramBigInteger.addCertificates(new CollectionStore(this.certs));
        paramBigInteger.addAttributeCertificates(new CollectionStore(this.attrCerts));
      }
      paramBigInteger.addCRLs(new CollectionStore(this.crls));
      if (!this.otherRevoc.isEmpty())
      {
        paramTimeStampRequest = this.otherRevoc.keySet().iterator();
        while (paramTimeStampRequest.hasNext())
        {
          paramExtensions = (ASN1ObjectIdentifier)paramTimeStampRequest.next();
          paramBigInteger.addOtherRevocationInfo(paramExtensions, new CollectionStore((Collection)this.otherRevoc.get(paramExtensions)));
        }
      }
      paramBigInteger.addSignerInfoGenerator(this.signerInfoGen);
      paramTimeStampRequest = paramDate.getEncoded("DER");
      paramTimeStampRequest = new TimeStampToken(paramBigInteger.generate(new CMSProcessableByteArray(PKCSObjectIdentifiers.id_ct_TSTInfo, paramTimeStampRequest), true));
      return paramTimeStampRequest;
    }
    catch (IOException paramTimeStampRequest)
    {
      throw new TSPException("Exception encoding info", paramTimeStampRequest);
    }
    catch (CMSException paramTimeStampRequest)
    {
      throw new TSPException("Error generating time-stamp token", paramTimeStampRequest);
    }
  }
  
  public void setAccuracyMicros(int paramInt)
  {
    this.accuracyMicros = paramInt;
  }
  
  public void setAccuracyMillis(int paramInt)
  {
    this.accuracyMillis = paramInt;
  }
  
  public void setAccuracySeconds(int paramInt)
  {
    this.accuracySeconds = paramInt;
  }
  
  public void setLocale(Locale paramLocale)
  {
    this.locale = paramLocale;
  }
  
  public void setOrdering(boolean paramBoolean)
  {
    this.ordering = paramBoolean;
  }
  
  public void setResolution(int paramInt)
  {
    this.resolution = paramInt;
  }
  
  public void setTSA(GeneralName paramGeneralName)
  {
    this.tsa = paramGeneralName;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\tsp\TimeStampTokenGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */