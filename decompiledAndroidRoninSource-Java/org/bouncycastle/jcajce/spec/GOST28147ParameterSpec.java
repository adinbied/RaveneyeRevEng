package org.bouncycastle.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.crypto.engines.GOST28147Engine;
import org.bouncycastle.util.Arrays;

public class GOST28147ParameterSpec
  implements AlgorithmParameterSpec
{
  private static Map oidMappings;
  private byte[] iv = null;
  private byte[] sBox = null;
  
  static
  {
    HashMap localHashMap = new HashMap();
    oidMappings = localHashMap;
    localHashMap.put(CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_A_ParamSet, "E-A");
    oidMappings.put(CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_B_ParamSet, "E-B");
    oidMappings.put(CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_C_ParamSet, "E-C");
    oidMappings.put(CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_D_ParamSet, "E-D");
  }
  
  public GOST28147ParameterSpec(String paramString)
  {
    this.sBox = GOST28147Engine.getSBox(paramString);
  }
  
  public GOST28147ParameterSpec(String paramString, byte[] paramArrayOfByte)
  {
    this(paramString);
    paramString = new byte[paramArrayOfByte.length];
    System.arraycopy(paramArrayOfByte, 0, paramString, 0, paramArrayOfByte.length);
  }
  
  public GOST28147ParameterSpec(ASN1ObjectIdentifier paramASN1ObjectIdentifier, byte[] paramArrayOfByte)
  {
    this(getName(paramASN1ObjectIdentifier));
  }
  
  public GOST28147ParameterSpec(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte.length];
    this.sBox = arrayOfByte;
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public GOST28147ParameterSpec(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this(paramArrayOfByte1);
    paramArrayOfByte1 = new byte[paramArrayOfByte2.length];
    System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, 0, paramArrayOfByte2.length);
  }
  
  private static String getName(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    Object localObject = (String)oidMappings.get(paramASN1ObjectIdentifier);
    if (localObject != null) {
      return (String)localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("unknown OID: ");
    ((StringBuilder)localObject).append(paramASN1ObjectIdentifier);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public byte[] getIV()
  {
    return Arrays.clone(this.iv);
  }
  
  public byte[] getSbox()
  {
    return Arrays.clone(this.sBox);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\spec\GOST28147ParameterSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */