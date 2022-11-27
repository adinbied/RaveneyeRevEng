package org.bouncycastle.pqc.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;

public class SPHINCS256KeyGenParameterSpec
  implements AlgorithmParameterSpec
{
  public static final String SHA3_256 = "SHA3-256";
  public static final String SHA512_256 = "SHA512-256";
  private final String treeHash;
  
  public SPHINCS256KeyGenParameterSpec()
  {
    this("SHA512-256");
  }
  
  public SPHINCS256KeyGenParameterSpec(String paramString)
  {
    this.treeHash = paramString;
  }
  
  public String getTreeDigest()
  {
    return this.treeHash;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\jcajce\spec\SPHINCS256KeyGenParameterSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */