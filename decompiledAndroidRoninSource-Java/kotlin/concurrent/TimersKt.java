package kotlin.concurrent;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={"\0004\n\000\n\002\030\002\n\000\n\002\020\016\n\000\n\002\020\013\n\000\n\002\030\002\n\000\n\002\020\t\n\000\n\002\030\002\n\002\030\002\n\002\020\002\n\002\030\002\n\002\b\b\032J\020\000\032\0020\0012\n\b\002\020\002\032\004\030\0010\0032\b\b\002\020\004\032\0020\0052\006\020\006\032\0020\0072\006\020\b\032\0020\t2\031\b\004\020\n\032\023\022\004\022\0020\f\022\004\022\0020\r0\013¢\006\002\b\016H\b\032L\020\000\032\0020\0012\n\b\002\020\002\032\004\030\0010\0032\b\b\002\020\004\032\0020\0052\b\b\002\020\017\032\0020\t2\006\020\b\032\0020\t2\031\b\004\020\n\032\023\022\004\022\0020\f\022\004\022\0020\r0\013¢\006\002\b\016H\b\032\032\020\020\032\0020\0012\b\020\002\032\004\030\0010\0032\006\020\004\032\0020\005H\001\032J\020\020\032\0020\0012\n\b\002\020\002\032\004\030\0010\0032\b\b\002\020\004\032\0020\0052\006\020\006\032\0020\0072\006\020\b\032\0020\t2\031\b\004\020\n\032\023\022\004\022\0020\f\022\004\022\0020\r0\013¢\006\002\b\016H\b\032L\020\020\032\0020\0012\n\b\002\020\002\032\004\030\0010\0032\b\b\002\020\004\032\0020\0052\b\b\002\020\017\032\0020\t2\006\020\b\032\0020\t2\031\b\004\020\n\032\023\022\004\022\0020\f\022\004\022\0020\r0\013¢\006\002\b\016H\b\032$\020\021\032\0020\f2\031\b\004\020\n\032\023\022\004\022\0020\f\022\004\022\0020\r0\013¢\006\002\b\016H\b\0320\020\022\032\0020\f*\0020\0012\006\020\023\032\0020\0072\031\b\004\020\n\032\023\022\004\022\0020\f\022\004\022\0020\r0\013¢\006\002\b\016H\b\0328\020\022\032\0020\f*\0020\0012\006\020\023\032\0020\0072\006\020\b\032\0020\t2\031\b\004\020\n\032\023\022\004\022\0020\f\022\004\022\0020\r0\013¢\006\002\b\016H\b\0320\020\022\032\0020\f*\0020\0012\006\020\024\032\0020\t2\031\b\004\020\n\032\023\022\004\022\0020\f\022\004\022\0020\r0\013¢\006\002\b\016H\b\0328\020\022\032\0020\f*\0020\0012\006\020\024\032\0020\t2\006\020\b\032\0020\t2\031\b\004\020\n\032\023\022\004\022\0020\f\022\004\022\0020\r0\013¢\006\002\b\016H\b\0328\020\025\032\0020\f*\0020\0012\006\020\023\032\0020\0072\006\020\b\032\0020\t2\031\b\004\020\n\032\023\022\004\022\0020\f\022\004\022\0020\r0\013¢\006\002\b\016H\b\0328\020\025\032\0020\f*\0020\0012\006\020\024\032\0020\t2\006\020\b\032\0020\t2\031\b\004\020\n\032\023\022\004\022\0020\f\022\004\022\0020\r0\013¢\006\002\b\016H\b¨\006\026"}, d2={"fixedRateTimer", "Ljava/util/Timer;", "name", "", "daemon", "", "startAt", "Ljava/util/Date;", "period", "", "action", "Lkotlin/Function1;", "Ljava/util/TimerTask;", "", "Lkotlin/ExtensionFunctionType;", "initialDelay", "timer", "timerTask", "schedule", "time", "delay", "scheduleAtFixedRate", "kotlin-stdlib"}, k=2, mv={1, 1, 15})
public final class TimersKt
{
  private static final Timer fixedRateTimer(String paramString, boolean paramBoolean, long paramLong1, long paramLong2, Function1<? super TimerTask, Unit> paramFunction1)
  {
    paramString = timer(paramString, paramBoolean);
    paramString.scheduleAtFixedRate((TimerTask)new TimerTask()
    {
      public void run()
      {
        this.$action.invoke(this);
      }
    }, paramLong1, paramLong2);
    return paramString;
  }
  
  private static final Timer fixedRateTimer(String paramString, boolean paramBoolean, Date paramDate, long paramLong, Function1<? super TimerTask, Unit> paramFunction1)
  {
    paramString = timer(paramString, paramBoolean);
    paramString.scheduleAtFixedRate((TimerTask)new TimerTask()
    {
      public void run()
      {
        this.$action.invoke(this);
      }
    }, paramDate, paramLong);
    return paramString;
  }
  
  private static final TimerTask schedule(Timer paramTimer, long paramLong1, long paramLong2, Function1<? super TimerTask, Unit> paramFunction1)
  {
    paramFunction1 = (TimerTask)new TimerTask()
    {
      public void run()
      {
        this.$action.invoke(this);
      }
    };
    paramTimer.schedule(paramFunction1, paramLong1, paramLong2);
    return paramFunction1;
  }
  
  private static final TimerTask schedule(Timer paramTimer, long paramLong, Function1<? super TimerTask, Unit> paramFunction1)
  {
    paramFunction1 = (TimerTask)new TimerTask()
    {
      public void run()
      {
        this.$action.invoke(this);
      }
    };
    paramTimer.schedule(paramFunction1, paramLong);
    return paramFunction1;
  }
  
  private static final TimerTask schedule(Timer paramTimer, Date paramDate, long paramLong, Function1<? super TimerTask, Unit> paramFunction1)
  {
    paramFunction1 = (TimerTask)new TimerTask()
    {
      public void run()
      {
        this.$action.invoke(this);
      }
    };
    paramTimer.schedule(paramFunction1, paramDate, paramLong);
    return paramFunction1;
  }
  
  private static final TimerTask schedule(Timer paramTimer, Date paramDate, Function1<? super TimerTask, Unit> paramFunction1)
  {
    paramFunction1 = (TimerTask)new TimerTask()
    {
      public void run()
      {
        this.$action.invoke(this);
      }
    };
    paramTimer.schedule(paramFunction1, paramDate);
    return paramFunction1;
  }
  
  private static final TimerTask scheduleAtFixedRate(Timer paramTimer, long paramLong1, long paramLong2, Function1<? super TimerTask, Unit> paramFunction1)
  {
    paramFunction1 = (TimerTask)new TimerTask()
    {
      public void run()
      {
        this.$action.invoke(this);
      }
    };
    paramTimer.scheduleAtFixedRate(paramFunction1, paramLong1, paramLong2);
    return paramFunction1;
  }
  
  private static final TimerTask scheduleAtFixedRate(Timer paramTimer, Date paramDate, long paramLong, Function1<? super TimerTask, Unit> paramFunction1)
  {
    paramFunction1 = (TimerTask)new TimerTask()
    {
      public void run()
      {
        this.$action.invoke(this);
      }
    };
    paramTimer.scheduleAtFixedRate(paramFunction1, paramDate, paramLong);
    return paramFunction1;
  }
  
  public static final Timer timer(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return new Timer(paramBoolean);
    }
    return new Timer(paramString, paramBoolean);
  }
  
  private static final Timer timer(String paramString, boolean paramBoolean, long paramLong1, long paramLong2, Function1<? super TimerTask, Unit> paramFunction1)
  {
    paramString = timer(paramString, paramBoolean);
    paramString.schedule((TimerTask)new TimerTask()
    {
      public void run()
      {
        this.$action.invoke(this);
      }
    }, paramLong1, paramLong2);
    return paramString;
  }
  
  private static final Timer timer(String paramString, boolean paramBoolean, Date paramDate, long paramLong, Function1<? super TimerTask, Unit> paramFunction1)
  {
    paramString = timer(paramString, paramBoolean);
    paramString.schedule((TimerTask)new TimerTask()
    {
      public void run()
      {
        this.$action.invoke(this);
      }
    }, paramDate, paramLong);
    return paramString;
  }
  
  private static final TimerTask timerTask(Function1<? super TimerTask, Unit> paramFunction1)
  {
    (TimerTask)new TimerTask()
    {
      public void run()
      {
        this.$action.invoke(this);
      }
    };
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\concurrent\TimersKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */