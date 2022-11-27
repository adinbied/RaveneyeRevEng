package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(bv={1, 0, 3}, d1={"\000^\n\002\030\002\n\002\020\017\n\000\n\002\020\006\n\002\b\005\n\002\020\b\n\002\b&\n\002\020\013\n\002\020\000\n\002\b\025\n\002\030\002\n\002\030\002\n\002\b\b\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\020\t\n\002\b\003\n\002\030\002\n\002\030\002\n\002\b\006\n\002\020\016\n\002\b\022\b@\030\000 s2\b\022\004\022\0020\0000\001:\001sB\024\b\000\022\006\020\002\032\0020\003ø\001\000¢\006\004\b\004\020\005J\033\020%\032\0020\t2\006\020&\032\0020\000H\002ø\001\000¢\006\004\b'\020(J\033\020)\032\0020\0002\006\020*\032\0020\003H\002ø\001\000¢\006\004\b+\020,J\033\020)\032\0020\0002\006\020*\032\0020\tH\002ø\001\000¢\006\004\b+\020-J\033\020)\032\0020\0032\006\020&\032\0020\000H\002ø\001\000¢\006\004\b.\020,J\023\020/\032\002002\b\020&\032\004\030\00101HÖ\003J\t\0202\032\0020\tHÖ\001J\r\0203\032\00200¢\006\004\b4\0205J\r\0206\032\00200¢\006\004\b7\0205J\r\0208\032\00200¢\006\004\b9\0205J\r\020:\032\00200¢\006\004\b;\0205J\033\020<\032\0020\0002\006\020&\032\0020\000H\002ø\001\000¢\006\004\b=\020,J\033\020>\032\0020\0002\006\020&\032\0020\000H\002ø\001\000¢\006\004\b?\020,J\027\020@\032\0020\t2\006\020\002\032\0020\003H\002¢\006\004\bA\020(J\033\020B\032\0020\0002\006\020*\032\0020\003H\002ø\001\000¢\006\004\bC\020,J\033\020B\032\0020\0002\006\020*\032\0020\tH\002ø\001\000¢\006\004\bC\020-J\001\020D\032\002HE\"\004\b\000\020E2u\020F\032q\022\023\022\0210\t¢\006\f\bH\022\b\bI\022\004\b\b(J\022\023\022\0210\t¢\006\f\bH\022\b\bI\022\004\b\b(K\022\023\022\0210\t¢\006\f\bH\022\b\bI\022\004\b\b(L\022\023\022\0210\t¢\006\f\bH\022\b\bI\022\004\b\b(M\022\023\022\0210\t¢\006\f\bH\022\b\bI\022\004\b\b(N\022\004\022\002HE0GH\b¢\006\004\bO\020PJx\020D\032\002HE\"\004\b\000\020E2`\020F\032\\\022\023\022\0210\t¢\006\f\bH\022\b\bI\022\004\b\b(K\022\023\022\0210\t¢\006\f\bH\022\b\bI\022\004\b\b(L\022\023\022\0210\t¢\006\f\bH\022\b\bI\022\004\b\b(M\022\023\022\0210\t¢\006\f\bH\022\b\bI\022\004\b\b(N\022\004\022\002HE0QH\b¢\006\004\bO\020RJc\020D\032\002HE\"\004\b\000\020E2K\020F\032G\022\023\022\0210\t¢\006\f\bH\022\b\bI\022\004\b\b(L\022\023\022\0210\t¢\006\f\bH\022\b\bI\022\004\b\b(M\022\023\022\0210\t¢\006\f\bH\022\b\bI\022\004\b\b(N\022\004\022\002HE0SH\b¢\006\004\bO\020TJN\020D\032\002HE\"\004\b\000\020E26\020F\0322\022\023\022\0210V¢\006\f\bH\022\b\bI\022\004\b\b(M\022\023\022\0210\t¢\006\f\bH\022\b\bI\022\004\b\b(N\022\004\022\002HE0UH\b¢\006\004\bO\020WJ\031\020X\032\0020\0032\n\020Y\032\0060Zj\002`[¢\006\004\b\\\020]J\031\020^\032\0020\t2\n\020Y\032\0060Zj\002`[¢\006\004\b_\020`J\r\020a\032\0020b¢\006\004\bc\020dJ\031\020e\032\0020V2\n\020Y\032\0060Zj\002`[¢\006\004\bf\020gJ\r\020h\032\0020V¢\006\004\bi\020jJ\r\020k\032\0020V¢\006\004\bl\020jJ\017\020m\032\0020bH\026¢\006\004\bn\020dJ#\020m\032\0020b2\n\020Y\032\0060Zj\002`[2\b\b\002\020o\032\0020\t¢\006\004\bn\020pJ\023\020q\032\0020\000H\002ø\001\000¢\006\004\br\020\005R\024\020\006\032\0020\0008Fø\001\000¢\006\006\032\004\b\007\020\005R\032\020\b\032\0020\t8@X\004¢\006\f\022\004\b\n\020\013\032\004\b\f\020\rR\021\020\016\032\0020\0038F¢\006\006\032\004\b\017\020\005R\021\020\020\032\0020\0038F¢\006\006\032\004\b\021\020\005R\021\020\022\032\0020\0038F¢\006\006\032\004\b\023\020\005R\021\020\024\032\0020\0038F¢\006\006\032\004\b\025\020\005R\021\020\026\032\0020\0038F¢\006\006\032\004\b\027\020\005R\021\020\030\032\0020\0038F¢\006\006\032\004\b\031\020\005R\021\020\032\032\0020\0038F¢\006\006\032\004\b\033\020\005R\032\020\034\032\0020\t8@X\004¢\006\f\022\004\b\035\020\013\032\004\b\036\020\rR\032\020\037\032\0020\t8@X\004¢\006\f\022\004\b \020\013\032\004\b!\020\rR\032\020\"\032\0020\t8@X\004¢\006\f\022\004\b#\020\013\032\004\b$\020\rR\016\020\002\032\0020\003X\004¢\006\002\n\000ø\001\000\002\004\n\002\b\031¨\006t"}, d2={"Lkotlin/time/Duration;", "", "value", "", "constructor-impl", "(D)D", "absoluteValue", "getAbsoluteValue-impl", "hoursComponent", "", "hoursComponent$annotations", "()V", "getHoursComponent-impl", "(D)I", "inDays", "getInDays-impl", "inHours", "getInHours-impl", "inMicroseconds", "getInMicroseconds-impl", "inMilliseconds", "getInMilliseconds-impl", "inMinutes", "getInMinutes-impl", "inNanoseconds", "getInNanoseconds-impl", "inSeconds", "getInSeconds-impl", "minutesComponent", "minutesComponent$annotations", "getMinutesComponent-impl", "nanosecondsComponent", "nanosecondsComponent$annotations", "getNanosecondsComponent-impl", "secondsComponent", "secondsComponent$annotations", "getSecondsComponent-impl", "compareTo", "other", "compareTo-LRDsOJo", "(DD)I", "div", "scale", "div-impl", "(DD)D", "(DI)D", "div-LRDsOJo", "equals", "", "", "hashCode", "isFinite", "isFinite-impl", "(D)Z", "isInfinite", "isInfinite-impl", "isNegative", "isNegative-impl", "isPositive", "isPositive-impl", "minus", "minus-LRDsOJo", "plus", "plus-LRDsOJo", "precision", "precision-impl", "times", "times-impl", "toComponents", "T", "action", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "days", "hours", "minutes", "seconds", "nanoseconds", "toComponents-impl", "(DLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "Lkotlin/Function4;", "(DLkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "Lkotlin/Function3;", "(DLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lkotlin/Function2;", "", "(DLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "toDouble", "unit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "toDouble-impl", "(DLjava/util/concurrent/TimeUnit;)D", "toInt", "toInt-impl", "(DLjava/util/concurrent/TimeUnit;)I", "toIsoString", "", "toIsoString-impl", "(D)Ljava/lang/String;", "toLong", "toLong-impl", "(DLjava/util/concurrent/TimeUnit;)J", "toLongMilliseconds", "toLongMilliseconds-impl", "(D)J", "toLongNanoseconds", "toLongNanoseconds-impl", "toString", "toString-impl", "decimals", "(DLjava/util/concurrent/TimeUnit;I)Ljava/lang/String;", "unaryMinus", "unaryMinus-impl", "Companion", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public final class Duration
  implements Comparable<Duration>
{
  public static final Companion Companion = new Companion(null);
  private static final double INFINITE = constructor-impl(DoubleCompanionObject.INSTANCE.getPOSITIVE_INFINITY());
  private static final double ZERO = constructor-impl(0.0D);
  private final double value;
  
  public static int compareTo-LRDsOJo(double paramDouble1, double paramDouble2)
  {
    return Double.compare(paramDouble1, paramDouble2);
  }
  
  public static double constructor-impl(double paramDouble)
  {
    return paramDouble;
  }
  
  public static final double div-LRDsOJo(double paramDouble1, double paramDouble2)
  {
    return paramDouble1 / paramDouble2;
  }
  
  public static final double div-impl(double paramDouble1, double paramDouble2)
  {
    return constructor-impl(paramDouble1 / paramDouble2);
  }
  
  public static final double div-impl(double paramDouble, int paramInt)
  {
    return constructor-impl(paramDouble / paramInt);
  }
  
  public static boolean equals-impl(double paramDouble, Object paramObject)
  {
    return ((paramObject instanceof Duration)) && (Double.compare(paramDouble, ((Duration)paramObject).unbox-impl()) == 0);
  }
  
  public static final boolean equals-impl0(double paramDouble1, double paramDouble2)
  {
    throw null;
  }
  
  public static final double getAbsoluteValue-impl(double paramDouble)
  {
    double d = paramDouble;
    if (isNegative-impl(paramDouble)) {
      d = unaryMinus-impl(paramDouble);
    }
    return d;
  }
  
  public static final int getHoursComponent-impl(double paramDouble)
  {
    return (int)(getInHours-impl(paramDouble) % 24);
  }
  
  public static final double getInDays-impl(double paramDouble)
  {
    return toDouble-impl(paramDouble, TimeUnit.DAYS);
  }
  
  public static final double getInHours-impl(double paramDouble)
  {
    return toDouble-impl(paramDouble, TimeUnit.HOURS);
  }
  
  public static final double getInMicroseconds-impl(double paramDouble)
  {
    return toDouble-impl(paramDouble, TimeUnit.MICROSECONDS);
  }
  
  public static final double getInMilliseconds-impl(double paramDouble)
  {
    return toDouble-impl(paramDouble, TimeUnit.MILLISECONDS);
  }
  
  public static final double getInMinutes-impl(double paramDouble)
  {
    return toDouble-impl(paramDouble, TimeUnit.MINUTES);
  }
  
  public static final double getInNanoseconds-impl(double paramDouble)
  {
    return toDouble-impl(paramDouble, TimeUnit.NANOSECONDS);
  }
  
  public static final double getInSeconds-impl(double paramDouble)
  {
    return toDouble-impl(paramDouble, TimeUnit.SECONDS);
  }
  
  public static final int getMinutesComponent-impl(double paramDouble)
  {
    return (int)(getInMinutes-impl(paramDouble) % 60);
  }
  
  public static final int getNanosecondsComponent-impl(double paramDouble)
  {
    return (int)(getInNanoseconds-impl(paramDouble) % 1.0E9D);
  }
  
  public static final int getSecondsComponent-impl(double paramDouble)
  {
    return (int)(getInSeconds-impl(paramDouble) % 60);
  }
  
  public static int hashCode-impl(double paramDouble)
  {
    long l = Double.doubleToLongBits(paramDouble);
    return (int)(l ^ l >>> 32);
  }
  
  public static final boolean isFinite-impl(double paramDouble)
  {
    return (!Double.isInfinite(paramDouble)) && (!Double.isNaN(paramDouble));
  }
  
  public static final boolean isInfinite-impl(double paramDouble)
  {
    return Double.isInfinite(paramDouble);
  }
  
  public static final boolean isNegative-impl(double paramDouble)
  {
    boolean bool = false;
    if (paramDouble < 0) {
      bool = true;
    }
    return bool;
  }
  
  public static final boolean isPositive-impl(double paramDouble)
  {
    boolean bool = false;
    if (paramDouble > 0) {
      bool = true;
    }
    return bool;
  }
  
  public static final double minus-LRDsOJo(double paramDouble1, double paramDouble2)
  {
    return constructor-impl(paramDouble1 - paramDouble2);
  }
  
  public static final double plus-LRDsOJo(double paramDouble1, double paramDouble2)
  {
    return constructor-impl(paramDouble1 + paramDouble2);
  }
  
  private static final int precision-impl(double paramDouble1, double paramDouble2)
  {
    if (paramDouble2 < 1) {
      return 3;
    }
    if (paramDouble2 < 10) {
      return 2;
    }
    if (paramDouble2 < 100) {
      return 1;
    }
    return 0;
  }
  
  public static final double times-impl(double paramDouble1, double paramDouble2)
  {
    return constructor-impl(paramDouble1 * paramDouble2);
  }
  
  public static final double times-impl(double paramDouble, int paramInt)
  {
    return constructor-impl(paramDouble * paramInt);
  }
  
  public static final <T> T toComponents-impl(double paramDouble, Function2<? super Long, ? super Integer, ? extends T> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "action");
    return (T)paramFunction2.invoke(Long.valueOf(getInSeconds-impl(paramDouble)), Integer.valueOf(getNanosecondsComponent-impl(paramDouble)));
  }
  
  public static final <T> T toComponents-impl(double paramDouble, Function3<? super Integer, ? super Integer, ? super Integer, ? extends T> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction3, "action");
    return (T)paramFunction3.invoke(Integer.valueOf((int)getInMinutes-impl(paramDouble)), Integer.valueOf(getSecondsComponent-impl(paramDouble)), Integer.valueOf(getNanosecondsComponent-impl(paramDouble)));
  }
  
  public static final <T> T toComponents-impl(double paramDouble, Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> paramFunction4)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction4, "action");
    return (T)paramFunction4.invoke(Integer.valueOf((int)getInHours-impl(paramDouble)), Integer.valueOf(getMinutesComponent-impl(paramDouble)), Integer.valueOf(getSecondsComponent-impl(paramDouble)), Integer.valueOf(getNanosecondsComponent-impl(paramDouble)));
  }
  
  public static final <T> T toComponents-impl(double paramDouble, Function5<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> paramFunction5)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction5, "action");
    return (T)paramFunction5.invoke(Integer.valueOf((int)getInDays-impl(paramDouble)), Integer.valueOf(getHoursComponent-impl(paramDouble)), Integer.valueOf(getMinutesComponent-impl(paramDouble)), Integer.valueOf(getSecondsComponent-impl(paramDouble)), Integer.valueOf(getNanosecondsComponent-impl(paramDouble)));
  }
  
  public static final double toDouble-impl(double paramDouble, TimeUnit paramTimeUnit)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeUnit, "unit");
    return DurationUnitKt.convertDurationUnit(paramDouble, DurationKt.access$getStorageUnit$p(), paramTimeUnit);
  }
  
  public static final int toInt-impl(double paramDouble, TimeUnit paramTimeUnit)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeUnit, "unit");
    return (int)toDouble-impl(paramDouble, paramTimeUnit);
  }
  
  public static final String toIsoString-impl(double paramDouble)
  {
    Object localObject = new StringBuilder();
    if (isNegative-impl(paramDouble)) {
      ((StringBuilder)localObject).append('-');
    }
    ((StringBuilder)localObject).append("PT");
    paramDouble = getAbsoluteValue-impl(paramDouble);
    int n = (int)getInHours-impl(paramDouble);
    int i1 = getMinutesComponent-impl(paramDouble);
    int i2 = getSecondsComponent-impl(paramDouble);
    int i3 = getNanosecondsComponent-impl(paramDouble);
    int m = 1;
    int i;
    if (n != 0) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if ((i2 == 0) && (i3 == 0)) {
      j = 0;
    } else {
      j = 1;
    }
    int k = m;
    if (i1 == 0) {
      if ((j != 0) && (i != 0)) {
        k = m;
      } else {
        k = 0;
      }
    }
    if (i != 0)
    {
      ((StringBuilder)localObject).append(n);
      ((StringBuilder)localObject).append('H');
    }
    if (k != 0)
    {
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append('M');
    }
    if ((j != 0) || ((i == 0) && (k == 0)))
    {
      ((StringBuilder)localObject).append(i2);
      if (i3 != 0)
      {
        ((StringBuilder)localObject).append('.');
        String str = StringsKt.padStart(String.valueOf(i3), 9, '0');
        if (i3 % 1000000 == 0) {
          ((StringBuilder)localObject).append((CharSequence)str, 0, 3);
        } else if (i3 % 1000 == 0) {
          ((StringBuilder)localObject).append((CharSequence)str, 0, 6);
        } else {
          ((StringBuilder)localObject).append(str);
        }
      }
      ((StringBuilder)localObject).append('S');
    }
    localObject = ((StringBuilder)localObject).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "StringBuilder().apply(builderAction).toString()");
    return (String)localObject;
  }
  
  public static final long toLong-impl(double paramDouble, TimeUnit paramTimeUnit)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeUnit, "unit");
    return toDouble-impl(paramDouble, paramTimeUnit);
  }
  
  public static final long toLongMilliseconds-impl(double paramDouble)
  {
    return toLong-impl(paramDouble, TimeUnit.MILLISECONDS);
  }
  
  public static final long toLongNanoseconds-impl(double paramDouble)
  {
    return toLong-impl(paramDouble, TimeUnit.NANOSECONDS);
  }
  
  public static String toString-impl(double paramDouble)
  {
    if (isInfinite-impl(paramDouble)) {
      return String.valueOf(paramDouble);
    }
    if (paramDouble == 0.0D) {
      return "0s";
    }
    double d = getInNanoseconds-impl(getAbsoluteValue-impl(paramDouble));
    int j = 0;
    if (d < 1.0E-6D) {}
    int i;
    for (TimeUnit localTimeUnit = TimeUnit.SECONDS;; localTimeUnit = TimeUnit.DAYS)
    {
      i = 0;
      j = 1;
      break;
      if (d < 1)
      {
        localTimeUnit = TimeUnit.NANOSECONDS;
        i = 7;
        break;
      }
      if (d < 1000.0D) {
        localTimeUnit = TimeUnit.NANOSECONDS;
      }
      for (;;)
      {
        i = 0;
        break label197;
        if (d < 1000000.0D)
        {
          localTimeUnit = TimeUnit.MICROSECONDS;
        }
        else if (d < 1.0E9D)
        {
          localTimeUnit = TimeUnit.MILLISECONDS;
        }
        else if (d < 1.0E12D)
        {
          localTimeUnit = TimeUnit.SECONDS;
        }
        else if (d < 6.0E13D)
        {
          localTimeUnit = TimeUnit.MINUTES;
        }
        else if (d < 3.6E15D)
        {
          localTimeUnit = TimeUnit.HOURS;
        }
        else
        {
          if (d >= 8.64E20D) {
            break;
          }
          localTimeUnit = TimeUnit.DAYS;
        }
      }
    }
    label197:
    d = toDouble-impl(paramDouble, localTimeUnit);
    StringBuilder localStringBuilder = new StringBuilder();
    String str;
    if (j != 0) {
      str = FormatToDecimalsKt.formatScientific(d);
    } else if (i > 0) {
      str = FormatToDecimalsKt.formatUpToDecimals(d, i);
    } else {
      str = FormatToDecimalsKt.formatToExactDecimals(d, precision-impl(paramDouble, Math.abs(d)));
    }
    localStringBuilder.append(str);
    localStringBuilder.append(DurationUnitKt.shortName(localTimeUnit));
    return localStringBuilder.toString();
  }
  
  public static final String toString-impl(double paramDouble, TimeUnit paramTimeUnit, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeUnit, "unit");
    int i;
    if (paramInt >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (isInfinite-impl(paramDouble)) {
        return String.valueOf(paramDouble);
      }
      paramDouble = toDouble-impl(paramDouble, paramTimeUnit);
      StringBuilder localStringBuilder = new StringBuilder();
      String str;
      if (Math.abs(paramDouble) < 1.0E14D) {
        str = FormatToDecimalsKt.formatToExactDecimals(paramDouble, RangesKt.coerceAtMost(paramInt, 12));
      } else {
        str = FormatToDecimalsKt.formatScientific(paramDouble);
      }
      localStringBuilder.append(str);
      localStringBuilder.append(DurationUnitKt.shortName(paramTimeUnit));
      return localStringBuilder.toString();
    }
    paramTimeUnit = new StringBuilder();
    paramTimeUnit.append("decimals must be not negative, but was ");
    paramTimeUnit.append(paramInt);
    throw ((Throwable)new IllegalArgumentException(paramTimeUnit.toString().toString()));
  }
  
  public static final double unaryMinus-impl(double paramDouble)
  {
    return constructor-impl(-paramDouble);
  }
  
  public int compareTo-LRDsOJo(double paramDouble)
  {
    return compareTo-LRDsOJo(this.value, paramDouble);
  }
  
  public boolean equals(Object paramObject)
  {
    return equals-impl(this.value, paramObject);
  }
  
  public int hashCode()
  {
    return hashCode-impl(this.value);
  }
  
  public String toString()
  {
    return toString-impl(this.value);
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000(\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\006\n\002\020\006\n\002\b\002\n\002\030\002\n\002\030\002\n\002\b\002\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J&\020\n\032\0020\0132\006\020\f\032\0020\0132\n\020\r\032\0060\016j\002`\0172\n\020\020\032\0060\016j\002`\017R\026\020\003\032\0020\004ø\001\000¢\006\n\n\002\020\007\032\004\b\005\020\006R\026\020\b\032\0020\004ø\001\000¢\006\n\n\002\020\007\032\004\b\t\020\006\002\004\n\002\b\031¨\006\021"}, d2={"Lkotlin/time/Duration$Companion;", "", "()V", "INFINITE", "Lkotlin/time/Duration;", "getINFINITE", "()D", "D", "ZERO", "getZERO", "convert", "", "value", "sourceUnit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "targetUnit", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
  public static final class Companion
  {
    public final double convert(double paramDouble, TimeUnit paramTimeUnit1, TimeUnit paramTimeUnit2)
    {
      Intrinsics.checkParameterIsNotNull(paramTimeUnit1, "sourceUnit");
      Intrinsics.checkParameterIsNotNull(paramTimeUnit2, "targetUnit");
      return DurationUnitKt.convertDurationUnit(paramDouble, paramTimeUnit1, paramTimeUnit2);
    }
    
    public final double getINFINITE()
    {
      return Duration.access$getINFINITE$cp();
    }
    
    public final double getZERO()
    {
      return Duration.access$getZERO$cp();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\time\Duration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */