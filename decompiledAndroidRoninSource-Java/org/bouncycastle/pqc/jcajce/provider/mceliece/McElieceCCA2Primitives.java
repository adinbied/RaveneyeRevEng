package org.bouncycastle.pqc.jcajce.provider.mceliece;

import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2PrivateKeyParameters;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2PublicKeyParameters;
import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;
import org.bouncycastle.pqc.math.linearalgebra.GF2Vector;
import org.bouncycastle.pqc.math.linearalgebra.GF2mField;
import org.bouncycastle.pqc.math.linearalgebra.GoppaCode;
import org.bouncycastle.pqc.math.linearalgebra.Permutation;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;
import org.bouncycastle.pqc.math.linearalgebra.Vector;

public final class McElieceCCA2Primitives
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
  
  public static GF2Vector[] decryptionPrimitive(BCMcElieceCCA2PrivateKey paramBCMcElieceCCA2PrivateKey, GF2Vector paramGF2Vector)
  {
    int i = paramBCMcElieceCCA2PrivateKey.getK();
    Permutation localPermutation = paramBCMcElieceCCA2PrivateKey.getP();
    GF2mField localGF2mField = paramBCMcElieceCCA2PrivateKey.getField();
    PolynomialGF2mSmallM localPolynomialGF2mSmallM = paramBCMcElieceCCA2PrivateKey.getGoppaPoly();
    GF2Matrix localGF2Matrix = paramBCMcElieceCCA2PrivateKey.getH();
    paramBCMcElieceCCA2PrivateKey = paramBCMcElieceCCA2PrivateKey.getQInv();
    paramGF2Vector = (GF2Vector)paramGF2Vector.multiply(localPermutation.computeInverse());
    paramBCMcElieceCCA2PrivateKey = GoppaCode.syndromeDecode((GF2Vector)localGF2Matrix.rightMultiply(paramGF2Vector), localGF2mField, localPolynomialGF2mSmallM, paramBCMcElieceCCA2PrivateKey);
    paramGF2Vector = (GF2Vector)((GF2Vector)paramGF2Vector.add(paramBCMcElieceCCA2PrivateKey)).multiply(localPermutation);
    paramBCMcElieceCCA2PrivateKey = (GF2Vector)paramBCMcElieceCCA2PrivateKey.multiply(localPermutation);
    return new GF2Vector[] { paramGF2Vector.extractRightVector(i), paramBCMcElieceCCA2PrivateKey };
  }
  
  public static GF2Vector encryptionPrimitive(McElieceCCA2PublicKeyParameters paramMcElieceCCA2PublicKeyParameters, GF2Vector paramGF2Vector1, GF2Vector paramGF2Vector2)
  {
    return (GF2Vector)paramMcElieceCCA2PublicKeyParameters.getG().leftMultiplyLeftCompactForm(paramGF2Vector1).add(paramGF2Vector2);
  }
  
  public static GF2Vector encryptionPrimitive(BCMcElieceCCA2PublicKey paramBCMcElieceCCA2PublicKey, GF2Vector paramGF2Vector1, GF2Vector paramGF2Vector2)
  {
    return (GF2Vector)paramBCMcElieceCCA2PublicKey.getG().leftMultiplyLeftCompactForm(paramGF2Vector1).add(paramGF2Vector2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\jcajce\provider\mceliece\McElieceCCA2Primitives.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */