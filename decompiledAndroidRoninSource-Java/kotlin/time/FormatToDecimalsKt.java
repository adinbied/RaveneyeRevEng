package kotlin.time;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000.\n\000\n\002\020\021\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\004\n\002\020\b\n\000\n\002\020\016\n\000\n\002\020\006\n\002\b\003\032\020\020\t\032\0020\0032\006\020\n\032\0020\013H\002\032\020\020\f\032\0020\r2\006\020\016\032\0020\017H\000\032\030\020\020\032\0020\r2\006\020\016\032\0020\0172\006\020\n\032\0020\013H\000\032\030\020\021\032\0020\r2\006\020\016\032\0020\0172\006\020\n\032\0020\013H\000\"\034\020\000\032\016\022\n\022\b\022\004\022\0020\0030\0020\001X\004¢\006\004\n\002\020\004\"\016\020\005\032\0020\006X\004¢\006\002\n\000\"\016\020\007\032\0020\006X\004¢\006\002\n\000\"\024\020\b\032\b\022\004\022\0020\0030\002X\004¢\006\002\n\000¨\006\022"}, d2={"precisionFormats", "", "Ljava/lang/ThreadLocal;", "Ljava/text/DecimalFormat;", "[Ljava/lang/ThreadLocal;", "rootNegativeExpFormatSymbols", "Ljava/text/DecimalFormatSymbols;", "rootPositiveExpFormatSymbols", "scientificFormat", "createFormatForDecimals", "decimals", "", "formatScientific", "", "value", "", "formatToExactDecimals", "formatUpToDecimals", "kotlin-stdlib"}, k=2, mv={1, 1, 15})
public final class FormatToDecimalsKt
{
  private static final ThreadLocal<DecimalFormat>[] precisionFormats;
  private static final DecimalFormatSymbols rootNegativeExpFormatSymbols;
  private static final DecimalFormatSymbols rootPositiveExpFormatSymbols;
  private static final ThreadLocal<DecimalFormat> scientificFormat = new ThreadLocal();
  
  static
  {
    Object localObject = new DecimalFormatSymbols(Locale.ROOT);
    ((DecimalFormatSymbols)localObject).setExponentSeparator("e");
    rootNegativeExpFormatSymbols = (DecimalFormatSymbols)localObject;
    localObject = new DecimalFormatSymbols(Locale.ROOT);
    ((DecimalFormatSymbols)localObject).setExponentSeparator("e+");
    rootPositiveExpFormatSymbols = (DecimalFormatSymbols)localObject;
    localObject = new ThreadLocal[4];
    int i = 0;
    while (i < 4)
    {
      localObject[i] = new ThreadLocal();
      i += 1;
    }
    precisionFormats = (ThreadLocal[])localObject;
  }
  
  private static final DecimalFormat createFormatForDecimals(int paramInt)
  {
    DecimalFormat localDecimalFormat = new DecimalFormat("0", rootNegativeExpFormatSymbols);
    if (paramInt > 0) {
      localDecimalFormat.setMinimumFractionDigits(paramInt);
    }
    localDecimalFormat.setRoundingMode(RoundingMode.HALF_UP);
    return localDecimalFormat;
  }
  
  public static final String formatScientific(double paramDouble)
  {
    Object localObject2 = scientificFormat;
    Object localObject1 = ((ThreadLocal)localObject2).get();
    if (localObject1 == null)
    {
      localObject1 = new DecimalFormat("0E0", rootNegativeExpFormatSymbols);
      ((DecimalFormat)localObject1).setMinimumFractionDigits(2);
      ((ThreadLocal)localObject2).set(localObject1);
    }
    localObject2 = (DecimalFormat)localObject1;
    if ((paramDouble < 1) && (paramDouble > -1)) {
      localObject1 = rootNegativeExpFormatSymbols;
    } else {
      localObject1 = rootPositiveExpFormatSymbols;
    }
    ((DecimalFormat)localObject2).setDecimalFormatSymbols((DecimalFormatSymbols)localObject1);
    localObject1 = ((DecimalFormat)localObject2).format(paramDouble);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "scientificFormat.getOrSe… }\n        .format(value)");
    return (String)localObject1;
  }
  
  public static final String formatToExactDecimals(double paramDouble, int paramInt)
  {
    Object localObject1 = precisionFormats;
    if (paramInt < localObject1.length)
    {
      Object localObject2 = localObject1[paramInt];
      localObject1 = ((ThreadLocal)localObject2).get();
      if (localObject1 == null)
      {
        localObject1 = createFormatForDecimals(paramInt);
        ((ThreadLocal)localObject2).set(localObject1);
      }
      localObject1 = (DecimalFormat)localObject1;
    }
    else
    {
      localObject1 = createFormatForDecimals(paramInt);
    }
    localObject1 = ((DecimalFormat)localObject1).format(paramDouble);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "format.format(value)");
    return (String)localObject1;
  }
  
  public static final String formatUpToDecimals(double paramDouble, int paramInt)
  {
    Object localObject = createFormatForDecimals(0);
    ((DecimalFormat)localObject).setMaximumFractionDigits(paramInt);
    localObject = ((DecimalFormat)localObject).format(paramDouble);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "createFormatForDecimals(… }\n        .format(value)");
    return (String)localObject;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\time\FormatToDecimalsKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */