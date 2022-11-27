package org.bouncycastle.math.ec.tools;

import java.io.PrintStream;
import java.math.BigInteger;
import java.security.SecureRandom;
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
import org.bouncycastle.util.Integers;

public class TraceOptimizer
{
  private static final BigInteger ONE = BigInteger.valueOf(1L);
  private static final SecureRandom R = new SecureRandom();
  
  private static int calculateTrace(ECFieldElement paramECFieldElement)
  {
    int j = paramECFieldElement.getFieldSize();
    ECFieldElement localECFieldElement = paramECFieldElement;
    int i = 1;
    while (i < j)
    {
      localECFieldElement = localECFieldElement.square();
      paramECFieldElement = paramECFieldElement.add(localECFieldElement);
      i += 1;
    }
    paramECFieldElement = paramECFieldElement.toBigInteger();
    if (paramECFieldElement.bitLength() <= 1) {
      return paramECFieldElement.intValue();
    }
    throw new IllegalStateException();
  }
  
  private static ArrayList enumToList(Enumeration paramEnumeration)
  {
    ArrayList localArrayList = new ArrayList();
    while (paramEnumeration.hasMoreElements()) {
      localArrayList.add(paramEnumeration.nextElement());
    }
    return localArrayList;
  }
  
  public static void implPrintNonZeroTraceBits(X9ECParameters paramX9ECParameters)
  {
    paramX9ECParameters = paramX9ECParameters.getCurve();
    int n = paramX9ECParameters.getFieldSize();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    Object localObject;
    while (i < n)
    {
      if (calculateTrace(paramX9ECParameters.fromBigInteger(ONE.shiftLeft(i))) != 0)
      {
        localArrayList.add(Integers.valueOf(i));
        localObject = System.out;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" ");
        localStringBuilder.append(i);
        ((PrintStream)localObject).print(localStringBuilder.toString());
      }
      i += 1;
    }
    System.out.println();
    i = 0;
    while (i < 1000)
    {
      localObject = new BigInteger(n, R);
      int i1 = calculateTrace(paramX9ECParameters.fromBigInteger((BigInteger)localObject));
      int j = 0;
      int m;
      for (int k = 0; j < localArrayList.size(); k = m)
      {
        m = k;
        if (((BigInteger)localObject).testBit(((Integer)localArrayList.get(j)).intValue())) {
          m = k ^ 0x1;
        }
        j += 1;
      }
      if (i1 == k) {
        i += 1;
      } else {
        throw new IllegalStateException("Optimized-trace sanity check failed");
      }
    }
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
        implPrintNonZeroTraceBits(paramArrayOfString);
      }
    }
  }
  
  public static void printNonZeroTraceBits(X9ECParameters paramX9ECParameters)
  {
    if (ECAlgorithms.isF2mCurve(paramX9ECParameters.getCurve()))
    {
      implPrintNonZeroTraceBits(paramX9ECParameters);
      return;
    }
    throw new IllegalArgumentException("Trace only defined over characteristic-2 fields");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\tools\TraceOptimizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */