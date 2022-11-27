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
import org.bouncycastle.pqc.math.linearalgebra.PolynomialRingGF2m;

public class McElieceKeyPairGenerator
  implements AsymmetricCipherKeyPairGenerator
{
  private static final String OID = "1.3.6.1.4.1.8301.3.1.3.4.1";
  private int fieldPoly;
  private boolean initialized = false;
  private int m;
  private McElieceKeyGenerationParameters mcElieceParams;
  private int n;
  private SecureRandom random;
  private int t;
  
  private AsymmetricCipherKeyPair genKeyPair()
  {
    if (!this.initialized) {
      initializeDefault();
    }
    GF2mField localGF2mField = new GF2mField(this.m, this.fieldPoly);
    PolynomialGF2mSmallM localPolynomialGF2mSmallM = new PolynomialGF2mSmallM(localGF2mField, this.t, 'I', this.random);
    new PolynomialRingGF2m(localGF2mField, localPolynomialGF2mSmallM).getSquareRootMatrix();
    Object localObject1 = GoppaCode.computeSystematicForm(GoppaCode.createCanonicalCheckMatrix(localGF2mField, localPolynomialGF2mSmallM), this.random);
    GF2Matrix localGF2Matrix = ((GoppaCode.MaMaPe)localObject1).getSecondMatrix();
    localObject1 = ((GoppaCode.MaMaPe)localObject1).getPermutation();
    Object localObject2 = (GF2Matrix)localGF2Matrix.computeTranspose();
    localGF2Matrix = ((GF2Matrix)localObject2).extendLeftCompactForm();
    int i = ((GF2Matrix)localObject2).getNumRows();
    localObject2 = GF2Matrix.createRandomRegularMatrixAndItsInverse(i, this.random);
    Permutation localPermutation = new Permutation(this.n, this.random);
    localGF2Matrix = (GF2Matrix)((GF2Matrix)localObject2[0].rightMultiply(localGF2Matrix)).rightMultiply(localPermutation);
    return new AsymmetricCipherKeyPair(new McEliecePublicKeyParameters(this.n, this.t, localGF2Matrix), new McEliecePrivateKeyParameters(this.n, i, localGF2mField, localPolynomialGF2mSmallM, (Permutation)localObject1, localPermutation, localObject2[1]));
  }
  
  private void initialize(KeyGenerationParameters paramKeyGenerationParameters)
  {
    this.mcElieceParams = ((McElieceKeyGenerationParameters)paramKeyGenerationParameters);
    this.random = new SecureRandom();
    this.m = this.mcElieceParams.getParameters().getM();
    this.n = this.mcElieceParams.getParameters().getN();
    this.t = this.mcElieceParams.getParameters().getT();
    this.fieldPoly = this.mcElieceParams.getParameters().getFieldPoly();
    this.initialized = true;
  }
  
  private void initializeDefault()
  {
    initialize(new McElieceKeyGenerationParameters(new SecureRandom(), new McElieceParameters()));
  }
  
  public AsymmetricCipherKeyPair generateKeyPair()
  {
    return genKeyPair();
  }
  
  public void init(KeyGenerationParameters paramKeyGenerationParameters)
  {
    initialize(paramKeyGenerationParameters);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\mceliece\McElieceKeyPairGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */