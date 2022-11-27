package org.greenrobot.eventbus;

import android.os.Looper;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.android.AndroidLogger;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;

public class EventBusBuilder
{
  private static final ExecutorService DEFAULT_EXECUTOR_SERVICE = ;
  boolean eventInheritance = true;
  ExecutorService executorService = DEFAULT_EXECUTOR_SERVICE;
  boolean ignoreGeneratedIndex;
  boolean logNoSubscriberMessages = true;
  boolean logSubscriberExceptions = true;
  Logger logger;
  MainThreadSupport mainThreadSupport;
  boolean sendNoSubscriberEvent = true;
  boolean sendSubscriberExceptionEvent = true;
  List<Class<?>> skipMethodVerificationForClasses;
  boolean strictMethodVerification;
  List<SubscriberInfoIndex> subscriberInfoIndexes;
  boolean throwSubscriberException;
  
  static Object getAndroidMainLooperOrNull()
  {
    try
    {
      Looper localLooper = Looper.getMainLooper();
      return localLooper;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;) {}
    }
    return null;
  }
  
  public EventBusBuilder addIndex(SubscriberInfoIndex paramSubscriberInfoIndex)
  {
    if (this.subscriberInfoIndexes == null) {
      this.subscriberInfoIndexes = new ArrayList();
    }
    this.subscriberInfoIndexes.add(paramSubscriberInfoIndex);
    return this;
  }
  
  public EventBus build()
  {
    return new EventBus(this);
  }
  
  public EventBusBuilder eventInheritance(boolean paramBoolean)
  {
    this.eventInheritance = paramBoolean;
    return this;
  }
  
  public EventBusBuilder executorService(ExecutorService paramExecutorService)
  {
    this.executorService = paramExecutorService;
    return this;
  }
  
  Logger getLogger()
  {
    Logger localLogger = this.logger;
    if (localLogger != null) {
      return localLogger;
    }
    return Logger.Default.get();
  }
  
  MainThreadSupport getMainThreadSupport()
  {
    Object localObject = this.mainThreadSupport;
    if (localObject != null) {
      return (MainThreadSupport)localObject;
    }
    boolean bool = AndroidLogger.isAndroidLogAvailable();
    localObject = null;
    if (bool)
    {
      localObject = getAndroidMainLooperOrNull();
      if (localObject == null) {
        return null;
      }
      localObject = new MainThreadSupport.AndroidHandlerMainThreadSupport((Looper)localObject);
    }
    return (MainThreadSupport)localObject;
  }
  
  public EventBusBuilder ignoreGeneratedIndex(boolean paramBoolean)
  {
    this.ignoreGeneratedIndex = paramBoolean;
    return this;
  }
  
  public EventBus installDefaultEventBus()
  {
    try
    {
      if (EventBus.defaultInstance == null)
      {
        EventBus.defaultInstance = build();
        EventBus localEventBus = EventBus.defaultInstance;
        return localEventBus;
      }
      throw new EventBusException("Default instance already exists. It may be only set once before it's used the first time to ensure consistent behavior.");
    }
    finally {}
  }
  
  public EventBusBuilder logNoSubscriberMessages(boolean paramBoolean)
  {
    this.logNoSubscriberMessages = paramBoolean;
    return this;
  }
  
  public EventBusBuilder logSubscriberExceptions(boolean paramBoolean)
  {
    this.logSubscriberExceptions = paramBoolean;
    return this;
  }
  
  public EventBusBuilder logger(Logger paramLogger)
  {
    this.logger = paramLogger;
    return this;
  }
  
  public EventBusBuilder sendNoSubscriberEvent(boolean paramBoolean)
  {
    this.sendNoSubscriberEvent = paramBoolean;
    return this;
  }
  
  public EventBusBuilder sendSubscriberExceptionEvent(boolean paramBoolean)
  {
    this.sendSubscriberExceptionEvent = paramBoolean;
    return this;
  }
  
  public EventBusBuilder skipMethodVerificationFor(Class<?> paramClass)
  {
    if (this.skipMethodVerificationForClasses == null) {
      this.skipMethodVerificationForClasses = new ArrayList();
    }
    this.skipMethodVerificationForClasses.add(paramClass);
    return this;
  }
  
  public EventBusBuilder strictMethodVerification(boolean paramBoolean)
  {
    this.strictMethodVerification = paramBoolean;
    return this;
  }
  
  public EventBusBuilder throwSubscriberException(boolean paramBoolean)
  {
    this.throwSubscriberException = paramBoolean;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\greenrobot\eventbus\EventBusBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */