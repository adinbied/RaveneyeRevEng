package org.bouncycastle.pqc.crypto.mceliece;

import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;
import org.bouncycastle.pqc.math.linearalgebra.GF2mField;
import org.bouncycastle.pqc.math.linearalgebra.GoppaCode;
import org.bouncycastle.pqc.math.linearalgebra.GoppaCode.MaMaPe;
import org.bouncycastle.pqc.math.linearalgebra.Permutation;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;

public class McElieceCCA2KeyPairGenerator
  implements AsymmetricCipherKeyPairGenerator
{
  public static final String OID = "1.3.6.1.4.1.8301.3.1.3.4.2";
  private int fieldPoly;
  private boolean initialized = false;
  private int m;
  private McElieceCCA2KeyGenerationParameters mcElieceCCA2Params;
  private int n;
  private SecureRandom random;
  private int t;
  
  private void initializeDefault()
  {
    init(new McElieceCCA2KeyGenerationParameters(new SecureRandom(), new McElieceCCA2Parameters()));
  }
  
  public AsymmetricCipherKeyPair generateKeyPair()
  {
    if (!this.initialized) {
      initializeDefault();
    }
    GF2mField localGF2mField = new GF2mField(this.m, this.fieldPoly);
    PolynomialGF2mSmallM localPolynomialGF2mSmallM = new PolynomialGF2mSmallM(localGF2mField, this.t, 'I', this.random);
    Object localObject = GoppaCode.computeSystematicForm(GoppaCode.createCanonicalCheckMatrix(localGF2mField, localPolynomialGF2mSmallM), this.random);
    GF2Matrix localGF2Matrix = ((GoppaCode.MaMaPe)localObject).getSecondMatrix();
    localObject = ((GoppaCode.MaMaPe)localObject).getPermutation();
    localGF2Matrix = (GF2Matrix)localGF2Matrix.computeTranspose();
    int i = localGF2Matrix.getNumRows();
    return new AsymmetricCipherKeyPair(new McElieceCCA2PublicKeyParameters(this.n, this.t, localGF2Matrix, this.mcElieceCCA2Params.getParameters().getDigest()), new McElieceCCA2PrivateKeyParameters(this.n, i, localGF2mField, localPolynomialGF2mSmallM, (Permutation)localObject, this.mcElieceCCA2Params.getParameters().getDigest()));
  }
  
  public void init(KeyGenerationParameters paramKeyGenerationParameters)
  {
    this.mcElieceCCA2Params = ((McElieceCCA2KeyGenerationParameters)paramKeyGenerationParameters);
    this.random = new SecureRandom();
    this.m = this.mcElieceCCA2Params.getParameters().getM();
    this.n = this.mcElieceCCA2Params.getParameters().getN();
    this.t = this.mcElieceCCA2Params.getParameters().getT();
    this.fieldPoly = this.mcElieceCCA2Params.getParameters().getFieldPoly();
    this.initialized = true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\mceliece\McElieceCCA2KeyPairGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */