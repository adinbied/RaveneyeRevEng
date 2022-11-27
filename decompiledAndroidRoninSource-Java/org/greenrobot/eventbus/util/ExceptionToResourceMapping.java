package org.greenrobot.eventbus.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import org.greenrobot.eventbus.Logger;
import org.greenrobot.eventbus.Logger.Default;

public class ExceptionToResourceMapping
{
  public final Map<Class<? extends Throwable>, Integer> throwableToMsgIdMap = new HashMap();
  
  public ExceptionToResourceMapping addMapping(Class<? extends Throwable> paramClass, int paramInt)
  {
    this.throwableToMsgIdMap.put(paramClass, Integer.valueOf(paramInt));
    return this;
  }
  
  public Integer mapThrowable(Throwable paramThrowable)
  {
    int i = 20;
    Object localObject1 = paramThrowable;
    do
    {
      localObject2 = mapThrowableFlat((Throwable)localObject1);
      if (localObject2 != null) {
        return (Integer)localObject2;
      }
      localObject2 = ((Throwable)localObject1).getCause();
      i -= 1;
      if ((i <= 0) || (localObject2 == paramThrowable)) {
        break;
      }
      localObject1 = localObject2;
    } while (localObject2 != null);
    localObject1 = Logger.Default.get();
    Object localObject2 = Level.FINE;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("No specific message resource ID found for ");
    localStringBuilder.append(paramThrowable);
    ((Logger)localObject1).log((Level)localObject2, localStringBuilder.toString());
    return null;
  }
  
  protected Integer mapThrowableFlat(Throwable paramThrowable)
  {
    Class localClass = paramThrowable.getClass();
    paramThrowable = (Integer)this.throwableToMsgIdMap.get(localClass);
    Object localObject2 = paramThrowable;
    if (paramThrowable == null)
    {
      Object localObject1 = null;
      Iterator localIterator = this.throwableToMsgIdMap.entrySet().iterator();
      for (;;)
      {
        localObject2 = paramThrowable;
        if (!localIterator.hasNext()) {
          break;
        }
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localObject2 = (Class)localEntry.getKey();
        if ((((Class)localObject2).isAssignableFrom(localClass)) && ((localObject1 == null) || (((Class)localObject1).isAssignableFrom((Class)localObject2))))
        {
          paramThrowable = (Integer)localEntry.getValue();
          localObject1 = localObject2;
        }
      }
    }
    return (Integer)localObject2;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\greenrobot\eventbu\\util\ExceptionToResourceMapping.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */