package org.bouncycastle.pqc.crypto.mceliece;

import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;
import org.bouncycastle.pqc.math.linearalgebra.GF2Vector;
import org.bouncycastle.pqc.math.linearalgebra.GF2mField;
import org.bouncycastle.pqc.math.linearalgebra.GoppaCode;
import org.bouncycastle.pqc.math.linearalgebra.Permutation;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;
import org.bouncycastle.pqc.math.linearalgebra.Vector;

final class McElieceCCA2Primitives
{
  public static GF2Vector[] decryptionPrimitive(McElieceCCA2PrivateKeyParameters paramMcElieceCCA2PrivateKeyParameters, GF2Vector paramGF2Vector)
  {
    int i = paramMcElieceCCA2PrivateKeyParameters.getK();
    Permutation localPermutation = paramMcElieceCCA2PrivateKeyParameters.getP();
    GF2mField localGF2mField = paramMcElieceCCA2PrivateKeyParameters.getField();
    PolynomialGF2mSmallM localPolynomialGF2mSmallM = paramMcElieceCCA2PrivateKeyParameters.getGoppaPoly();
    GF2Matrix localGF2Matrix = paramMcElieceCCA2PrivateKeyParameters.getH();
    paramMcElieceCCA2PrivateKeyParameters = paramMcElieceCCA2PrivateKeyParameters.getQInv();
    paramGF2Vector = (GF2Vector)paramGF2Vector.multiply(localPermutation.computeInverse());
    paramMcElieceCCA2PrivateKeyParameters = GoppaCode.syndromeDecode((GF2Vector)localGF2Matrix.rightMultiply(paramGF2Vector), localGF2mField, localPolynomialGF2mSmallM, paramMcElieceCCA2PrivateKeyParameters);
    paramGF2Vector = (GF2Vector)((GF2Vector)paramGF2Vector.add(paramMcElieceCCA2PrivateKeyParameters)).multiply(localPermutation);
    paramMcElieceCCA2PrivateKeyParameters = (GF2Vector)paramMcElieceCCA2PrivateKeyParameters.multiply(localPermutation);
    return new GF2Vector[] { paramGF2Vector.extractRightVector(i), paramMcElieceCCA2PrivateKeyParameters };
  }
  
  public static GF2Vector encryptionPrimitive(McElieceCCA2PublicKeyParameters paramMcElieceCCA2PublicKeyParameters, GF2Vector paramGF2Vector1, GF2Vector paramGF2Vector2)
  {
    return (GF2Vector)paramMcElieceCCA2PublicKeyParameters.getG().leftMultiplyLeftCompactForm(paramGF2Vector1).add(paramGF2Vector2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\mceliece\McElieceCCA2Primitives.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */