package org.bouncycastle.math.ec.tools;

import java.io.PrintStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import org.bouncycastle.asn1.x9.ECNamedCurveTable;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.ec.CustomNamedCurves;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;

public class F2mSqrtOptimizer
{
  private static ArrayList enumToList(Enumeration paramEnumeration)
  {
    ArrayList localArrayList = new ArrayList();
    while (paramEnumeration.hasMoreElements()) {
      localArrayList.add(paramEnumeration.nextElement());
    }
    return localArrayList;
  }
  
  private static void implPrintRootZ(X9ECParameters paramX9ECParameters)
  {
    paramX9ECParameters = paramX9ECParameters.getCurve().fromBigInteger(BigInteger.valueOf(2L));
    ECFieldElement localECFieldElement = paramX9ECParameters.sqrt();
    System.out.println(localECFieldElement.toBigInteger().toString(16).toUpperCase());
    if (localECFieldElement.square().equals(paramX9ECParameters)) {
      return;
    }
    throw new IllegalStateException("Optimized-sqrt sanity check failed");
  }
  
  public static void main(String[] paramArrayOfString)
  {
    paramArrayOfString = new TreeSet(enumToList(ECNamedCurveTable.getNames()));
    paramArrayOfString.addAll(enumToList(CustomNamedCurves.getNames()));
    Iterator localIterator = paramArrayOfString.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = CustomNamedCurves.getByName(str);
      paramArrayOfString = (String[])localObject;
      if (localObject == null) {
        paramArrayOfString = ECNamedCurveTable.getByName(str);
      }
      if ((paramArrayOfString != null) && (ECAlgorithms.isF2mCurve(paramArrayOfString.getCurve())))
      {
        localObject = System.out;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(":");
        ((PrintStream)localObject).print(localStringBuilder.toString());
        implPrintRootZ(paramArrayOfString);
      }
    }
  }
  
  public static void printRootZ(X9ECParameters paramX9ECParameters)
  {
    if (ECAlgorithms.isF2mCurve(paramX9ECParameters.getCurve()))
    {
      implPrintRootZ(paramX9ECParameters);
      return;
    }
    throw new IllegalArgumentException("Sqrt optimization only defined over characteristic-2 fields");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\tools\F2mSqrtOptimizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */