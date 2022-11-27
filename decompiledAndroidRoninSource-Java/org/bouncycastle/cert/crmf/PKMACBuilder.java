package org.bouncycastle.cert.crmf;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.cmp.CMPObjectIdentifiers;
import org.bouncycastle.asn1.cmp.PBMParameter;
import org.bouncycastle.asn1.iana.IANAObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.MacCalculator;
import org.bouncycastle.operator.RuntimeOperatorException;
import org.bouncycastle.util.Strings;

public class PKMACBuilder
{
  private PKMACValuesCalculator calculator;
  private int iterationCount;
  private AlgorithmIdentifier mac;
  private int maxIterations;
  private AlgorithmIdentifier owf;
  private PBMParameter parameters;
  private SecureRandom random;
  private int saltLength = 20;
  
  private PKMACBuilder(AlgorithmIdentifier paramAlgorithmIdentifier1, int paramInt, AlgorithmIdentifier paramAlgorithmIdentifier2, PKMACValuesCalculator paramPKMACValuesCalculator)
  {
    this.owf = paramAlgorithmIdentifier1;
    this.iterationCount = paramInt;
    this.mac = paramAlgorithmIdentifier2;
    this.calculator = paramPKMACValuesCalculator;
  }
  
  public PKMACBuilder(PKMACValuesCalculator paramPKMACValuesCalculator)
  {
    this(new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1), 1000, new AlgorithmIdentifier(IANAObjectIdentifiers.hmacSHA1, DERNull.INSTANCE), paramPKMACValuesCalculator);
  }
  
  public PKMACBuilder(PKMACValuesCalculator paramPKMACValuesCalculator, int paramInt)
  {
    this.maxIterations = paramInt;
    this.calculator = paramPKMACValuesCalculator;
  }
  
  private void checkIterationCountCeiling(int paramInt)
  {
    int i = this.maxIterations;
    if (i > 0)
    {
      if (paramInt <= i) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("iteration count exceeds limit (");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" > ");
      localStringBuilder.append(this.maxIterations);
      localStringBuilder.append(")");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
  }
  
  private MacCalculator genCalculator(final PBMParameter paramPBMParameter, char[] paramArrayOfChar)
    throws CRMFException
  {
    final byte[] arrayOfByte1 = Strings.toUTF8ByteArray(paramArrayOfChar);
    byte[] arrayOfByte2 = paramPBMParameter.getSalt().getOctets();
    paramArrayOfChar = new byte[arrayOfByte1.length + arrayOfByte2.length];
    System.arraycopy(arrayOfByte1, 0, paramArrayOfChar, 0, arrayOfByte1.length);
    System.arraycopy(arrayOfByte2, 0, paramArrayOfChar, arrayOfByte1.length, arrayOfByte2.length);
    this.calculator.setup(paramPBMParameter.getOwf(), paramPBMParameter.getMac());
    int i = paramPBMParameter.getIterationCount().getValue().intValue();
    int j;
    do
    {
      arrayOfByte1 = this.calculator.calculateDigest(paramArrayOfChar);
      j = i - 1;
      paramArrayOfChar = arrayOfByte1;
      i = j;
    } while (j > 0);
    new MacCalculator()
    {
      ByteArrayOutputStream bOut = new ByteArrayOutputStream();
      
      public AlgorithmIdentifier getAlgorithmIdentifier()
      {
        return new AlgorithmIdentifier(CMPObjectIdentifiers.passwordBasedMac, paramPBMParameter);
      }
      
      public GenericKey getKey()
      {
        return new GenericKey(getAlgorithmIdentifier(), arrayOfByte1);
      }
      
      public byte[] getMac()
      {
        try
        {
          byte[] arrayOfByte = PKMACBuilder.this.calculator.calculateMac(arrayOfByte1, this.bOut.toByteArray());
          return arrayOfByte;
        }
        catch (CRMFException localCRMFException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("exception calculating mac: ");
          localStringBuilder.append(localCRMFException.getMessage());
          throw new RuntimeOperatorException(localStringBuilder.toString(), localCRMFException);
        }
      }
      
      public OutputStream getOutputStream()
      {
        return this.bOut;
      }
    };
  }
  
  public MacCalculator build(char[] paramArrayOfChar)
    throws CRMFException
  {
    Object localObject = this.parameters;
    if (localObject != null) {
      return genCalculator((PBMParameter)localObject, paramArrayOfChar);
    }
    localObject = new byte[this.saltLength];
    if (this.random == null) {
      this.random = new SecureRandom();
    }
    this.random.nextBytes((byte[])localObject);
    return genCalculator(new PBMParameter((byte[])localObject, this.owf, this.iterationCount, this.mac), paramArrayOfChar);
  }
  
  public PKMACBuilder setIterationCount(int paramInt)
  {
    if (paramInt >= 100)
    {
      checkIterationCountCeiling(paramInt);
      this.iterationCount = paramInt;
      return this;
    }
    throw new IllegalArgumentException("iteration count must be at least 100");
  }
  
  public PKMACBuilder setParameters(PBMParameter paramPBMParameter)
  {
    checkIterationCountCeiling(paramPBMParameter.getIterationCount().getValue().intValue());
    this.parameters = paramPBMParameter;
    return this;
  }
  
  public PKMACBuilder setSaltLength(int paramInt)
  {
    if (paramInt >= 8)
    {
      this.saltLength = paramInt;
      return this;
    }
    throw new IllegalArgumentException("salt length must be at least 8 bytes");
  }
  
  public PKMACBuilder setSecureRandom(SecureRandom paramSecureRandom)
  {
    this.random = paramSecureRandom;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\crmf\PKMACBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */