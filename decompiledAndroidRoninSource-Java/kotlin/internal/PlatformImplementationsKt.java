package kotlin.internal;

import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000\036\n\000\n\002\030\002\n\000\n\002\020\013\n\000\n\002\020\b\n\002\b\004\n\002\020\000\n\002\b\004\032 \020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\0052\006\020\007\032\0020\005H\001\032\"\020\b\032\002H\t\"\n\b\000\020\t\030\001*\0020\n2\006\020\013\032\0020\nH\b¢\006\002\020\f\032\b\020\r\032\0020\005H\002\"\020\020\000\032\0020\0018\000X\004¢\006\002\n\000¨\006\016"}, d2={"IMPLEMENTATIONS", "Lkotlin/internal/PlatformImplementations;", "apiVersionIsAtLeast", "", "major", "", "minor", "patch", "castToBaseType", "T", "", "instance", "(Ljava/lang/Object;)Ljava/lang/Object;", "getJavaVersion", "kotlin-stdlib"}, k=2, mv={1, 1, 15})
public final class PlatformImplementationsKt
{
  public static final PlatformImplementations IMPLEMENTATIONS;
  
  static
  {
    int i = getJavaVersion();
    if (i >= 65544) {}
    for (;;)
    {
      try
      {
        localObject2 = Class.forName("kotlin.internal.jdk8.JDK8PlatformImplementations").newInstance();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "Class.forName(\"kotlin.in…entations\").newInstance()");
        if (localObject2 == null) {}
      }
      catch (ClassNotFoundException localClassNotFoundException1)
      {
        Object localObject2;
        Object localObject1;
        ClassLoader localClassLoader;
        StringBuilder localStringBuilder;
        continue;
      }
      try
      {
        localObject1 = (PlatformImplementations)localObject2;
      }
      catch (ClassCastException localClassCastException1) {}
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
    localObject2 = localObject2.getClass().getClassLoader();
    localClassLoader = PlatformImplementations.class.getClassLoader();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Instance classloader: ");
    localStringBuilder.append(localObject2);
    localStringBuilder.append(", base type classloader: ");
    localStringBuilder.append(localClassLoader);
    localObject1 = new ClassCastException(localStringBuilder.toString()).initCause((Throwable)localObject1);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
    throw ((Throwable)localObject1);
    for (;;)
    {
      try
      {
        localObject2 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "Class.forName(\"kotlin.in…entations\").newInstance()");
        if (localObject2 == null) {}
      }
      catch (ClassNotFoundException localClassNotFoundException2)
      {
        continue;
      }
      try
      {
        localObject1 = (PlatformImplementations)localObject2;
      }
      catch (ClassCastException localClassCastException2) {}
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
    localObject2 = localObject2.getClass().getClassLoader();
    localClassLoader = PlatformImplementations.class.getClassLoader();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Instance classloader: ");
    localStringBuilder.append(localObject2);
    localStringBuilder.append(", base type classloader: ");
    localStringBuilder.append(localClassLoader);
    localObject1 = new ClassCastException(localStringBuilder.toString()).initCause((Throwable)localObject1);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
    throw ((Throwable)localObject1);
    if (i >= 65543) {}
    for (;;)
    {
      try
      {
        localObject2 = Class.forName("kotlin.internal.jdk7.JDK7PlatformImplementations").newInstance();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "Class.forName(\"kotlin.in…entations\").newInstance()");
        if (localObject2 == null) {}
      }
      catch (ClassNotFoundException localClassNotFoundException3)
      {
        continue;
      }
      try
      {
        localObject1 = (PlatformImplementations)localObject2;
      }
      catch (ClassCastException localClassCastException3) {}
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
    localObject2 = localObject2.getClass().getClassLoader();
    localClassLoader = PlatformImplementations.class.getClassLoader();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Instance classloader: ");
    localStringBuilder.append(localObject2);
    localStringBuilder.append(", base type classloader: ");
    localStringBuilder.append(localClassLoader);
    localObject1 = new ClassCastException(localStringBuilder.toString()).initCause((Throwable)localObject1);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
    throw ((Throwable)localObject1);
    for (;;)
    {
      try
      {
        localObject2 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "Class.forName(\"kotlin.in…entations\").newInstance()");
        if (localObject2 == null) {}
      }
      catch (ClassNotFoundException localClassNotFoundException4)
      {
        continue;
      }
      try
      {
        localObject1 = (PlatformImplementations)localObject2;
      }
      catch (ClassCastException localClassCastException4) {}
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
    localObject2 = localObject2.getClass().getClassLoader();
    localClassLoader = PlatformImplementations.class.getClassLoader();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Instance classloader: ");
    localStringBuilder.append(localObject2);
    localStringBuilder.append(", base type classloader: ");
    localStringBuilder.append(localClassLoader);
    localObject1 = new ClassCastException(localStringBuilder.toString()).initCause((Throwable)localObject1);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
    throw ((Throwable)localObject1);
    localObject1 = new PlatformImplementations();
    IMPLEMENTATIONS = (PlatformImplementations)localObject1;
  }
  
  public static final boolean apiVersionIsAtLeast(int paramInt1, int paramInt2, int paramInt3)
  {
    return KotlinVersion.CURRENT.isAtLeast(paramInt1, paramInt2, paramInt3);
  }
  
  /* Error */
  private static final int getJavaVersion()
  {
    // Byte code:
    //   0: ldc -119
    //   2: invokestatic 143	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   5: astore 4
    //   7: aload 4
    //   9: ifnull +147 -> 156
    //   12: aload 4
    //   14: checkcast 145	java/lang/CharSequence
    //   17: astore 5
    //   19: aload 5
    //   21: bipush 46
    //   23: iconst_0
    //   24: iconst_0
    //   25: bipush 6
    //   27: aconst_null
    //   28: invokestatic 151	kotlin/text/StringsKt:indexOf$default	(Ljava/lang/CharSequence;CIZILjava/lang/Object;)I
    //   31: istore_2
    //   32: iload_2
    //   33: ifge +14 -> 47
    //   36: aload 4
    //   38: invokestatic 157	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   41: istore_0
    //   42: iload_0
    //   43: ldc -98
    //   45: imul
    //   46: ireturn
    //   47: iload_2
    //   48: iconst_1
    //   49: iadd
    //   50: istore_3
    //   51: aload 5
    //   53: bipush 46
    //   55: iload_3
    //   56: iconst_0
    //   57: iconst_4
    //   58: aconst_null
    //   59: invokestatic 151	kotlin/text/StringsKt:indexOf$default	(Ljava/lang/CharSequence;CIZILjava/lang/Object;)I
    //   62: istore_1
    //   63: iload_1
    //   64: istore_0
    //   65: iload_1
    //   66: ifge +9 -> 75
    //   69: aload 4
    //   71: invokevirtual 163	java/lang/String:length	()I
    //   74: istore_0
    //   75: aload 4
    //   77: ifnull +69 -> 146
    //   80: aload 4
    //   82: iconst_0
    //   83: iload_2
    //   84: invokevirtual 167	java/lang/String:substring	(II)Ljava/lang/String;
    //   87: astore 5
    //   89: aload 5
    //   91: ldc -87
    //   93: invokestatic 59	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   96: aload 4
    //   98: ifnull +38 -> 136
    //   101: aload 4
    //   103: iload_3
    //   104: iload_0
    //   105: invokevirtual 167	java/lang/String:substring	(II)Ljava/lang/String;
    //   108: astore 4
    //   110: aload 4
    //   112: ldc -87
    //   114: invokestatic 59	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   117: aload 5
    //   119: invokestatic 157	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   122: istore_0
    //   123: aload 4
    //   125: invokestatic 157	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   128: istore_1
    //   129: iload_0
    //   130: ldc -98
    //   132: imul
    //   133: iload_1
    //   134: iadd
    //   135: ireturn
    //   136: new 63	kotlin/TypeCastException
    //   139: dup
    //   140: ldc -85
    //   142: invokespecial 69	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
    //   145: athrow
    //   146: new 63	kotlin/TypeCastException
    //   149: dup
    //   150: ldc -85
    //   152: invokespecial 69	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
    //   155: athrow
    //   156: ldc -84
    //   158: ireturn
    //   159: astore 4
    //   161: ldc -84
    //   163: ireturn
    //   164: astore 4
    //   166: ldc -84
    //   168: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   41	92	0	i	int
    //   62	73	1	j	int
    //   31	53	2	k	int
    //   50	54	3	m	int
    //   5	119	4	str	String
    //   159	1	4	localNumberFormatException1	NumberFormatException
    //   164	1	4	localNumberFormatException2	NumberFormatException
    //   17	101	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   36	42	159	java/lang/NumberFormatException
    //   117	129	164	java/lang/NumberFormatException
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\internal\PlatformImplementationsKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */