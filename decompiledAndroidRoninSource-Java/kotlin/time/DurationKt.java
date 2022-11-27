package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000.\n\000\n\002\030\002\n\002\b\005\n\002\030\002\n\002\020\006\n\002\b\004\n\002\020\b\n\002\b\002\n\002\020\t\n\002\b\034\n\002\030\002\n\002\b\004\032\037\020%\032\0020\007*\0020\b2\006\020&\032\0020\007H\nø\001\000¢\006\004\b'\020(\032\037\020%\032\0020\007*\0020\r2\006\020&\032\0020\007H\nø\001\000¢\006\004\b)\020*\032 \020+\032\0020\007*\0020\b2\n\020,\032\0060\001j\002`-H\007ø\001\000¢\006\002\020.\032 \020+\032\0020\007*\0020\r2\n\020,\032\0060\001j\002`-H\007ø\001\000¢\006\002\020/\032 \020+\032\0020\007*\0020\0202\n\020,\032\0060\001j\002`-H\007ø\001\000¢\006\002\0200\"\033\020\000\032\0020\0018Â\002X\004¢\006\f\022\004\b\002\020\003\032\004\b\004\020\005\"!\020\006\032\0020\007*\0020\b8FX\004ø\001\000¢\006\f\022\004\b\t\020\n\032\004\b\013\020\f\"!\020\006\032\0020\007*\0020\r8FX\004ø\001\000¢\006\f\022\004\b\t\020\016\032\004\b\013\020\017\"!\020\006\032\0020\007*\0020\0208FX\004ø\001\000¢\006\f\022\004\b\t\020\021\032\004\b\013\020\022\"!\020\023\032\0020\007*\0020\b8FX\004ø\001\000¢\006\f\022\004\b\024\020\n\032\004\b\025\020\f\"!\020\023\032\0020\007*\0020\r8FX\004ø\001\000¢\006\f\022\004\b\024\020\016\032\004\b\025\020\017\"!\020\023\032\0020\007*\0020\0208FX\004ø\001\000¢\006\f\022\004\b\024\020\021\032\004\b\025\020\022\"!\020\026\032\0020\007*\0020\b8FX\004ø\001\000¢\006\f\022\004\b\027\020\n\032\004\b\030\020\f\"!\020\026\032\0020\007*\0020\r8FX\004ø\001\000¢\006\f\022\004\b\027\020\016\032\004\b\030\020\017\"!\020\026\032\0020\007*\0020\0208FX\004ø\001\000¢\006\f\022\004\b\027\020\021\032\004\b\030\020\022\"!\020\031\032\0020\007*\0020\b8FX\004ø\001\000¢\006\f\022\004\b\032\020\n\032\004\b\033\020\f\"!\020\031\032\0020\007*\0020\r8FX\004ø\001\000¢\006\f\022\004\b\032\020\016\032\004\b\033\020\017\"!\020\031\032\0020\007*\0020\0208FX\004ø\001\000¢\006\f\022\004\b\032\020\021\032\004\b\033\020\022\"!\020\034\032\0020\007*\0020\b8FX\004ø\001\000¢\006\f\022\004\b\035\020\n\032\004\b\036\020\f\"!\020\034\032\0020\007*\0020\r8FX\004ø\001\000¢\006\f\022\004\b\035\020\016\032\004\b\036\020\017\"!\020\034\032\0020\007*\0020\0208FX\004ø\001\000¢\006\f\022\004\b\035\020\021\032\004\b\036\020\022\"!\020\037\032\0020\007*\0020\b8FX\004ø\001\000¢\006\f\022\004\b \020\n\032\004\b!\020\f\"!\020\037\032\0020\007*\0020\r8FX\004ø\001\000¢\006\f\022\004\b \020\016\032\004\b!\020\017\"!\020\037\032\0020\007*\0020\0208FX\004ø\001\000¢\006\f\022\004\b \020\021\032\004\b!\020\022\"!\020\"\032\0020\007*\0020\b8FX\004ø\001\000¢\006\f\022\004\b#\020\n\032\004\b$\020\f\"!\020\"\032\0020\007*\0020\r8FX\004ø\001\000¢\006\f\022\004\b#\020\016\032\004\b$\020\017\"!\020\"\032\0020\007*\0020\0208FX\004ø\001\000¢\006\f\022\004\b#\020\021\032\004\b$\020\022\002\004\n\002\b\031¨\0061"}, d2={"storageUnit", "Ljava/util/concurrent/TimeUnit;", "storageUnit$annotations", "()V", "getStorageUnit", "()Ljava/util/concurrent/TimeUnit;", "days", "Lkotlin/time/Duration;", "", "days$annotations", "(D)V", "getDays", "(D)D", "", "(I)V", "(I)D", "", "(J)V", "(J)D", "hours", "hours$annotations", "getHours", "microseconds", "microseconds$annotations", "getMicroseconds", "milliseconds", "milliseconds$annotations", "getMilliseconds", "minutes", "minutes$annotations", "getMinutes", "nanoseconds", "nanoseconds$annotations", "getNanoseconds", "seconds", "seconds$annotations", "getSeconds", "times", "duration", "times-kIfJnKk", "(DD)D", "times-mvk6XK0", "(ID)D", "toDuration", "unit", "Lkotlin/time/DurationUnit;", "(DLjava/util/concurrent/TimeUnit;)D", "(ILjava/util/concurrent/TimeUnit;)D", "(JLjava/util/concurrent/TimeUnit;)D", "kotlin-stdlib"}, k=2, mv={1, 1, 15})
public final class DurationKt
{
  public static final double getDays(double paramDouble)
  {
    return toDuration(paramDouble, TimeUnit.DAYS);
  }
  
  public static final double getDays(int paramInt)
  {
    return toDuration(paramInt, TimeUnit.DAYS);
  }
  
  public static final double getDays(long paramLong)
  {
    return toDuration(paramLong, TimeUnit.DAYS);
  }
  
  public static final double getHours(double paramDouble)
  {
    return toDuration(paramDouble, TimeUnit.HOURS);
  }
  
  public static final double getHours(int paramInt)
  {
    return toDuration(paramInt, TimeUnit.HOURS);
  }
  
  public static final double getHours(long paramLong)
  {
    return toDuration(paramLong, TimeUnit.HOURS);
  }
  
  public static final double getMicroseconds(double paramDouble)
  {
    return toDuration(paramDouble, TimeUnit.MICROSECONDS);
  }
  
  public static final double getMicroseconds(int paramInt)
  {
    return toDuration(paramInt, TimeUnit.MICROSECONDS);
  }
  
  public static final double getMicroseconds(long paramLong)
  {
    return toDuration(paramLong, TimeUnit.MICROSECONDS);
  }
  
  public static final double getMilliseconds(double paramDouble)
  {
    return toDuration(paramDouble, TimeUnit.MILLISECONDS);
  }
  
  public static final double getMilliseconds(int paramInt)
  {
    return toDuration(paramInt, TimeUnit.MILLISECONDS);
  }
  
  public static final double getMilliseconds(long paramLong)
  {
    return toDuration(paramLong, TimeUnit.MILLISECONDS);
  }
  
  public static final double getMinutes(double paramDouble)
  {
    return toDuration(paramDouble, TimeUnit.MINUTES);
  }
  
  public static final double getMinutes(int paramInt)
  {
    return toDuration(paramInt, TimeUnit.MINUTES);
  }
  
  public static final double getMinutes(long paramLong)
  {
    return toDuration(paramLong, TimeUnit.MINUTES);
  }
  
  public static final double getNanoseconds(double paramDouble)
  {
    return toDuration(paramDouble, TimeUnit.NANOSECONDS);
  }
  
  public static final double getNanoseconds(int paramInt)
  {
    return toDuration(paramInt, TimeUnit.NANOSECONDS);
  }
  
  public static final double getNanoseconds(long paramLong)
  {
    return toDuration(paramLong, TimeUnit.NANOSECONDS);
  }
  
  public static final double getSeconds(double paramDouble)
  {
    return toDuration(paramDouble, TimeUnit.SECONDS);
  }
  
  public static final double getSeconds(int paramInt)
  {
    return toDuration(paramInt, TimeUnit.SECONDS);
  }
  
  public static final double getSeconds(long paramLong)
  {
    return toDuration(paramLong, TimeUnit.SECONDS);
  }
  
  private static final TimeUnit getStorageUnit()
  {
    return TimeUnit.NANOSECONDS;
  }
  
  private static final double times-kIfJnKk(double paramDouble1, double paramDouble2)
  {
    return Duration.times-impl(paramDouble2, paramDouble1);
  }
  
  private static final double times-mvk6XK0(int paramInt, double paramDouble)
  {
    return Duration.times-impl(paramDouble, paramInt);
  }
  
  public static final double toDuration(double paramDouble, TimeUnit paramTimeUnit)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeUnit, "unit");
    return Duration.constructor-impl(DurationUnitKt.convertDurationUnit(paramDouble, paramTimeUnit, TimeUnit.NANOSECONDS));
  }
  
  public static final double toDuration(int paramInt, TimeUnit paramTimeUnit)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeUnit, "unit");
    return toDuration(paramInt, paramTimeUnit);
  }
  
  public static final double toDuration(long paramLong, TimeUnit paramTimeUnit)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeUnit, "unit");
    return toDuration(paramLong, paramTimeUnit);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\time\DurationKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */