package org.bouncycastle.jcajce.provider.symmetric;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.cms.GCMParameters;
import org.bouncycastle.util.Integers;

class GcmSpecUtil
{
  static final Class gcmSpecClass = lookup("javax.crypto.spec.GCMParameterSpec");
  
  static GCMParameters extractGcmParameters(AlgorithmParameterSpec paramAlgorithmParameterSpec)
    throws InvalidParameterSpecException
  {
    try
    {
      Method localMethod = gcmSpecClass.getDeclaredMethod("getTLen", new Class[0]);
      paramAlgorithmParameterSpec = new GCMParameters((byte[])gcmSpecClass.getDeclaredMethod("getIV", new Class[0]).invoke(paramAlgorithmParameterSpec, new Object[0]), ((Integer)localMethod.invoke(paramAlgorithmParameterSpec, new Object[0])).intValue() / 8);
      return paramAlgorithmParameterSpec;
    }
    catch (Exception paramAlgorithmParameterSpec)
    {
      for (;;) {}
    }
    throw new InvalidParameterSpecException("Cannot process GCMParameterSpec");
  }
  
  static AlgorithmParameterSpec extractGcmSpec(ASN1Primitive paramASN1Primitive)
    throws InvalidParameterSpecException
  {
    try
    {
      paramASN1Primitive = GCMParameters.getInstance(paramASN1Primitive);
      paramASN1Primitive = (AlgorithmParameterSpec)gcmSpecClass.getConstructor(new Class[] { Integer.TYPE, byte[].class }).newInstance(new Object[] { Integers.valueOf(paramASN1Primitive.getIcvLen() * 8), paramASN1Primitive.getNonce() });
      return paramASN1Primitive;
    }
    catch (Exception paramASN1Primitive)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Construction failed: ");
      localStringBuilder.append(paramASN1Primitive.getMessage());
      throw new InvalidParameterSpecException(localStringBuilder.toString());
      throw new InvalidParameterSpecException("No constructor found!");
    }
    catch (NoSuchMethodException paramASN1Primitive)
    {
      for (;;) {}
    }
  }
  
  static boolean gcmSpecExists()
  {
    return gcmSpecClass != null;
  }
  
  static boolean isGcmSpec(Class paramClass)
  {
    return gcmSpecClass == paramClass;
  }
  
  static boolean isGcmSpec(AlgorithmParameterSpec paramAlgorithmParameterSpec)
  {
    Class localClass = gcmSpecClass;
    return (localClass != null) && (localClass.isInstance(paramAlgorithmParameterSpec));
  }
  
  private static Class lookup(String paramString)
  {
    try
    {
      paramString = GcmSpecUtil.class.getClassLoader().loadClass(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\symmetric\GcmSpecUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */