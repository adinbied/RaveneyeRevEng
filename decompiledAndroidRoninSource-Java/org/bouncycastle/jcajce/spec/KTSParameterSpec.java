package org.bouncycastle.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.util.Arrays;

public class KTSParameterSpec
  implements AlgorithmParameterSpec
{
  private final AlgorithmIdentifier kdfAlgorithm;
  private final int keySizeInBits;
  private byte[] otherInfo;
  private final AlgorithmParameterSpec parameterSpec;
  private final String wrappingKeyAlgorithm;
  
  private KTSParameterSpec(String paramString, int paramInt, AlgorithmParameterSpec paramAlgorithmParameterSpec, AlgorithmIdentifier paramAlgorithmIdentifier, byte[] paramArrayOfByte)
  {
    this.wrappingKeyAlgorithm = paramString;
    this.keySizeInBits = paramInt;
    this.parameterSpec = paramAlgorithmParameterSpec;
    this.kdfAlgorithm = paramAlgorithmIdentifier;
    this.otherInfo = paramArrayOfByte;
  }
  
  public AlgorithmIdentifier getKdfAlgorithm()
  {
    return this.kdfAlgorithm;
  }
  
  public String getKeyAlgorithmName()
  {
    return this.wrappingKeyAlgorithm;
  }
  
  public int getKeySize()
  {
    return this.keySizeInBits;
  }
  
  public byte[] getOtherInfo()
  {
    return Arrays.clone(this.otherInfo);
  }
  
  public AlgorithmParameterSpec getParameterSpec()
  {
    return this.parameterSpec;
  }
  
  public static final class Builder
  {
    private final String algorithmName;
    private AlgorithmIdentifier kdfAlgorithm;
    private final int keySizeInBits;
    private byte[] otherInfo;
    private AlgorithmParameterSpec parameterSpec;
    
    public Builder(String paramString, int paramInt)
    {
      this(paramString, paramInt, null);
    }
    
    public Builder(String paramString, int paramInt, byte[] paramArrayOfByte)
    {
      this.algorithmName = paramString;
      this.keySizeInBits = paramInt;
      this.kdfAlgorithm = new AlgorithmIdentifier(X9ObjectIdentifiers.id_kdf_kdf3, new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256));
      if (paramArrayOfByte == null) {
        paramString = new byte[0];
      } else {
        paramString = Arrays.clone(paramArrayOfByte);
      }
      this.otherInfo = paramString;
    }
    
    public KTSParameterSpec build()
    {
      return new KTSParameterSpec(this.algorithmName, this.keySizeInBits, this.parameterSpec, this.kdfAlgorithm, this.otherInfo, null);
    }
    
    public Builder withKdfAlgorithm(AlgorithmIdentifier paramAlgorithmIdentifier)
    {
      this.kdfAlgorithm = paramAlgorithmIdentifier;
      return this;
    }
    
    public Builder withParameterSpec(AlgorithmParameterSpec paramAlgorithmParameterSpec)
    {
      this.parameterSpec = paramAlgorithmParameterSpec;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\spec\KTSParameterSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */