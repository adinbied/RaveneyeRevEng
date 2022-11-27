package org.greenrobot.eventbus;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;

public class EventBus
{
  private static final EventBusBuilder DEFAULT_BUILDER = new EventBusBuilder();
  public static String TAG = "EventBus";
  static volatile EventBus defaultInstance;
  private static final Map<Class<?>, List<Class<?>>> eventTypesCache = new HashMap();
  private final AsyncPoster asyncPoster;
  private final BackgroundPoster backgroundPoster;
  private final ThreadLocal<PostingThreadState> currentPostingThreadState = new ThreadLocal()
  {
    protected EventBus.PostingThreadState initialValue()
    {
      return new EventBus.PostingThreadState();
    }
  };
  private final boolean eventInheritance;
  private final ExecutorService executorService;
  private final int indexCount;
  private final boolean logNoSubscriberMessages;
  private final boolean logSubscriberExceptions;
  private final Logger logger;
  private final Poster mainThreadPoster;
  private final MainThreadSupport mainThreadSupport;
  private final boolean sendNoSubscriberEvent;
  private final boolean sendSubscriberExceptionEvent;
  private final Map<Class<?>, Object> stickyEvents;
  private final SubscriberMethodFinder subscriberMethodFinder;
  private final Map<Class<?>, CopyOnWriteArrayList<Subscription>> subscriptionsByEventType;
  private final boolean throwSubscriberException;
  private final Map<Object, List<Class<?>>> typesBySubscriber;
  
  public EventBus()
  {
    this(DEFAULT_BUILDER);
  }
  
  EventBus(EventBusBuilder paramEventBusBuilder)
  {
    this.logger = paramEventBusBuilder.getLogger();
    this.subscriptionsByEventType = new HashMap();
    this.typesBySubscriber = new HashMap();
    this.stickyEvents = new ConcurrentHashMap();
    Object localObject = paramEventBusBuilder.getMainThreadSupport();
    this.mainThreadSupport = ((MainThreadSupport)localObject);
    if (localObject != null) {
      localObject = ((MainThreadSupport)localObject).createPoster(this);
    } else {
      localObject = null;
    }
    this.mainThreadPoster = ((Poster)localObject);
    this.backgroundPoster = new BackgroundPoster(this);
    this.asyncPoster = new AsyncPoster(this);
    int i;
    if (paramEventBusBuilder.subscriberInfoIndexes != null) {
      i = paramEventBusBuilder.subscriberInfoIndexes.size();
    } else {
      i = 0;
    }
    this.indexCount = i;
    this.subscriberMethodFinder = new SubscriberMethodFinder(paramEventBusBuilder.subscriberInfoIndexes, paramEventBusBuilder.strictMethodVerification, paramEventBusBuilder.ignoreGeneratedIndex);
    this.logSubscriberExceptions = paramEventBusBuilder.logSubscriberExceptions;
    this.logNoSubscriberMessages = paramEventBusBuilder.logNoSubscriberMessages;
    this.sendSubscriberExceptionEvent = paramEventBusBuilder.sendSubscriberExceptionEvent;
    this.sendNoSubscriberEvent = paramEventBusBuilder.sendNoSubscriberEvent;
    this.throwSubscriberException = paramEventBusBuilder.throwSubscriberException;
    this.eventInheritance = paramEventBusBuilder.eventInheritance;
    this.executorService = paramEventBusBuilder.executorService;
  }
  
  static void addInterfaces(List<Class<?>> paramList, Class<?>[] paramArrayOfClass)
  {
    int j = paramArrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      Class<?> localClass = paramArrayOfClass[i];
      if (!paramList.contains(localClass))
      {
        paramList.add(localClass);
        addInterfaces(paramList, localClass.getInterfaces());
      }
      i += 1;
    }
  }
  
  public static EventBusBuilder builder()
  {
    return new EventBusBuilder();
  }
  
  private void checkPostStickyEventToSubscription(Subscription paramSubscription, Object paramObject)
  {
    if (paramObject != null) {
      postToSubscription(paramSubscription, paramObject, isMainThread());
    }
  }
  
  public static void clearCaches()
  {
    SubscriberMethodFinder.clearCaches();
    eventTypesCache.clear();
  }
  
  public static EventBus getDefault()
  {
    Object localObject = defaultInstance;
    if (localObject == null) {
      try
      {
        EventBus localEventBus2 = defaultInstance;
        localObject = localEventBus2;
        if (localEventBus2 == null)
        {
          localObject = new EventBus();
          defaultInstance = (EventBus)localObject;
        }
        return (EventBus)localObject;
      }
      finally {}
    }
    return localEventBus1;
  }
  
  private void handleSubscriberException(Subscription paramSubscription, Object paramObject, Throwable paramThrowable)
  {
    Object localObject;
    Level localLevel;
    StringBuilder localStringBuilder;
    if ((paramObject instanceof SubscriberExceptionEvent))
    {
      if (this.logSubscriberExceptions)
      {
        localObject = this.logger;
        localLevel = Level.SEVERE;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("SubscriberExceptionEvent subscriber ");
        localStringBuilder.append(paramSubscription.subscriber.getClass());
        localStringBuilder.append(" threw an exception");
        ((Logger)localObject).log(localLevel, localStringBuilder.toString(), paramThrowable);
        paramSubscription = (SubscriberExceptionEvent)paramObject;
        paramObject = this.logger;
        paramThrowable = Level.SEVERE;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Initial event ");
        ((StringBuilder)localObject).append(paramSubscription.causingEvent);
        ((StringBuilder)localObject).append(" caused exception in ");
        ((StringBuilder)localObject).append(paramSubscription.causingSubscriber);
        ((Logger)paramObject).log(paramThrowable, ((StringBuilder)localObject).toString(), paramSubscription.throwable);
      }
    }
    else
    {
      if (this.throwSubscriberException) {
        break label272;
      }
      if (this.logSubscriberExceptions)
      {
        localObject = this.logger;
        localLevel = Level.SEVERE;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Could not dispatch event: ");
        localStringBuilder.append(paramObject.getClass());
        localStringBuilder.append(" to subscribing class ");
        localStringBuilder.append(paramSubscription.subscriber.getClass());
        ((Logger)localObject).log(localLevel, localStringBuilder.toString(), paramThrowable);
      }
      if (this.sendSubscriberExceptionEvent) {
        post(new SubscriberExceptionEvent(this, paramThrowable, paramObject, paramSubscription.subscriber));
      }
    }
    return;
    label272:
    throw new EventBusException("Invoking subscriber failed", paramThrowable);
  }
  
  private boolean isMainThread()
  {
    MainThreadSupport localMainThreadSupport = this.mainThreadSupport;
    return (localMainThreadSupport == null) || (localMainThreadSupport.isMainThread());
  }
  
  private static List<Class<?>> lookupAllEventTypes(Class<?> paramClass)
  {
    synchronized (eventTypesCache)
    {
      Object localObject2 = (List)eventTypesCache.get(paramClass);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = new ArrayList();
        for (localObject1 = paramClass; localObject1 != null; localObject1 = ((Class)localObject1).getSuperclass())
        {
          ((List)localObject2).add(localObject1);
          addInterfaces((List)localObject2, ((Class)localObject1).getInterfaces());
        }
        eventTypesCache.put(paramClass, localObject2);
        localObject1 = localObject2;
      }
      return (List<Class<?>>)localObject1;
    }
  }
  
  private void postSingleEvent(Object paramObject, PostingThreadState paramPostingThreadState)
    throws Error
  {
    Class localClass = paramObject.getClass();
    Object localObject;
    if (this.eventInheritance)
    {
      localObject = lookupAllEventTypes(localClass);
      int j = ((List)localObject).size();
      int i = 0;
      boolean bool1 = false;
      for (;;)
      {
        bool2 = bool1;
        if (i >= j) {
          break;
        }
        bool1 |= postSingleEventForEventType(paramObject, paramPostingThreadState, (Class)((List)localObject).get(i));
        i += 1;
      }
    }
    boolean bool2 = postSingleEventForEventType(paramObject, paramPostingThreadState, localClass);
    if (!bool2)
    {
      if (this.logNoSubscriberMessages)
      {
        paramPostingThreadState = this.logger;
        localObject = Level.FINE;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("No subscribers registered for event ");
        localStringBuilder.append(localClass);
        paramPostingThreadState.log((Level)localObject, localStringBuilder.toString());
      }
      if ((this.sendNoSubscriberEvent) && (localClass != NoSubscriberEvent.class) && (localClass != SubscriberExceptionEvent.class)) {
        post(new NoSubscriberEvent(this, paramObject));
      }
    }
  }
  
  /* Error */
  private boolean postSingleEventForEventType(Object paramObject, PostingThreadState paramPostingThreadState, Class<?> paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 89	org/greenrobot/eventbus/EventBus:subscriptionsByEventType	Ljava/util/Map;
    //   6: aload_3
    //   7: invokeinterface 293 2 0
    //   12: checkcast 333	java/util/concurrent/CopyOnWriteArrayList
    //   15: astore_3
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_3
    //   19: ifnull +106 -> 125
    //   22: aload_3
    //   23: invokevirtual 336	java/util/concurrent/CopyOnWriteArrayList:isEmpty	()Z
    //   26: ifne +99 -> 125
    //   29: aload_3
    //   30: invokevirtual 340	java/util/concurrent/CopyOnWriteArrayList:iterator	()Ljava/util/Iterator;
    //   33: astore_3
    //   34: aload_3
    //   35: invokeinterface 345 1 0
    //   40: ifeq +83 -> 123
    //   43: aload_3
    //   44: invokeinterface 349 1 0
    //   49: checkcast 231	org/greenrobot/eventbus/Subscription
    //   52: astore 5
    //   54: aload_2
    //   55: aload_1
    //   56: putfield 352	org/greenrobot/eventbus/EventBus$PostingThreadState:event	Ljava/lang/Object;
    //   59: aload_2
    //   60: aload 5
    //   62: putfield 356	org/greenrobot/eventbus/EventBus$PostingThreadState:subscription	Lorg/greenrobot/eventbus/Subscription;
    //   65: aload_0
    //   66: aload 5
    //   68: aload_1
    //   69: aload_2
    //   70: getfield 358	org/greenrobot/eventbus/EventBus$PostingThreadState:isMainThread	Z
    //   73: invokespecial 197	org/greenrobot/eventbus/EventBus:postToSubscription	(Lorg/greenrobot/eventbus/Subscription;Ljava/lang/Object;Z)V
    //   76: aload_2
    //   77: getfield 361	org/greenrobot/eventbus/EventBus$PostingThreadState:canceled	Z
    //   80: istore 4
    //   82: aload_2
    //   83: aconst_null
    //   84: putfield 352	org/greenrobot/eventbus/EventBus$PostingThreadState:event	Ljava/lang/Object;
    //   87: aload_2
    //   88: aconst_null
    //   89: putfield 356	org/greenrobot/eventbus/EventBus$PostingThreadState:subscription	Lorg/greenrobot/eventbus/Subscription;
    //   92: aload_2
    //   93: iconst_0
    //   94: putfield 361	org/greenrobot/eventbus/EventBus$PostingThreadState:canceled	Z
    //   97: iload 4
    //   99: ifeq -65 -> 34
    //   102: goto +21 -> 123
    //   105: astore_1
    //   106: aload_2
    //   107: aconst_null
    //   108: putfield 352	org/greenrobot/eventbus/EventBus$PostingThreadState:event	Ljava/lang/Object;
    //   111: aload_2
    //   112: aconst_null
    //   113: putfield 356	org/greenrobot/eventbus/EventBus$PostingThreadState:subscription	Lorg/greenrobot/eventbus/Subscription;
    //   116: aload_2
    //   117: iconst_0
    //   118: putfield 361	org/greenrobot/eventbus/EventBus$PostingThreadState:canceled	Z
    //   121: aload_1
    //   122: athrow
    //   123: iconst_1
    //   124: ireturn
    //   125: iconst_0
    //   126: ireturn
    //   127: astore_1
    //   128: aload_0
    //   129: monitorexit
    //   130: aload_1
    //   131: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	EventBus
    //   0	132	1	paramObject	Object
    //   0	132	2	paramPostingThreadState	PostingThreadState
    //   0	132	3	paramClass	Class<?>
    //   80	18	4	bool	boolean
    //   52	15	5	localSubscription	Subscription
    // Exception table:
    //   from	to	target	type
    //   65	82	105	finally
    //   2	18	127	finally
    //   128	130	127	finally
  }
  
  private void postToSubscription(Subscription paramSubscription, Object paramObject, boolean paramBoolean)
  {
    int i = 2.$SwitchMap$org$greenrobot$eventbus$ThreadMode[paramSubscription.subscriberMethod.threadMode.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i == 5)
            {
              this.asyncPoster.enqueue(paramSubscription, paramObject);
              return;
            }
            paramObject = new StringBuilder();
            ((StringBuilder)paramObject).append("Unknown thread mode: ");
            ((StringBuilder)paramObject).append(paramSubscription.subscriberMethod.threadMode);
            throw new IllegalStateException(((StringBuilder)paramObject).toString());
          }
          if (paramBoolean)
          {
            this.backgroundPoster.enqueue(paramSubscription, paramObject);
            return;
          }
          invokeSubscriber(paramSubscription, paramObject);
          return;
        }
        Poster localPoster = this.mainThreadPoster;
        if (localPoster != null)
        {
          localPoster.enqueue(paramSubscription, paramObject);
          return;
        }
        invokeSubscriber(paramSubscription, paramObject);
        return;
      }
      if (paramBoolean)
      {
        invokeSubscriber(paramSubscription, paramObject);
        return;
      }
      this.mainThreadPoster.enqueue(paramSubscription, paramObject);
      return;
    }
    invokeSubscriber(paramSubscription, paramObject);
  }
  
  private void subscribe(Object paramObject, SubscriberMethod paramSubscriberMethod)
  {
    Class localClass = paramSubscriberMethod.eventType;
    Subscription localSubscription = new Subscription(paramObject, paramSubscriberMethod);
    Object localObject = (CopyOnWriteArrayList)this.subscriptionsByEventType.get(localClass);
    if (localObject == null)
    {
      localObject = new CopyOnWriteArrayList();
      this.subscriptionsByEventType.put(localClass, localObject);
    }
    else
    {
      if (((CopyOnWriteArrayList)localObject).contains(localSubscription)) {
        break label289;
      }
    }
    int j = ((CopyOnWriteArrayList)localObject).size();
    int i = 0;
    while (i <= j) {
      if ((i != j) && (paramSubscriberMethod.priority <= ((Subscription)((CopyOnWriteArrayList)localObject).get(i)).subscriberMethod.priority)) {
        i += 1;
      } else {
        ((CopyOnWriteArrayList)localObject).add(i, localSubscription);
      }
    }
    List localList = (List)this.typesBySubscriber.get(paramObject);
    localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.typesBySubscriber.put(paramObject, localObject);
    }
    ((List)localObject).add(localClass);
    if (paramSubscriberMethod.sticky)
    {
      if (this.eventInheritance)
      {
        paramObject = this.stickyEvents.entrySet().iterator();
        while (((Iterator)paramObject).hasNext())
        {
          paramSubscriberMethod = (Map.Entry)((Iterator)paramObject).next();
          if (localClass.isAssignableFrom((Class)paramSubscriberMethod.getKey())) {
            checkPostStickyEventToSubscription(localSubscription, paramSubscriberMethod.getValue());
          }
        }
      }
      checkPostStickyEventToSubscription(localSubscription, this.stickyEvents.get(localClass));
    }
    return;
    label289:
    paramSubscriberMethod = new StringBuilder();
    paramSubscriberMethod.append("Subscriber ");
    paramSubscriberMethod.append(paramObject.getClass());
    paramSubscriberMethod.append(" already registered to event ");
    paramSubscriberMethod.append(localClass);
    throw new EventBusException(paramSubscriberMethod.toString());
  }
  
  private void unsubscribeByEventType(Object paramObject, Class<?> paramClass)
  {
    paramClass = (List)this.subscriptionsByEventType.get(paramClass);
    if (paramClass != null)
    {
      int j = paramClass.size();
      int i = 0;
      while (i < j)
      {
        Subscription localSubscription = (Subscription)paramClass.get(i);
        int k = j;
        int m = i;
        if (localSubscription.subscriber == paramObject)
        {
          localSubscription.active = false;
          paramClass.remove(i);
          m = i - 1;
          k = j - 1;
        }
        i = m + 1;
        j = k;
      }
    }
  }
  
  public void cancelEventDelivery(Object paramObject)
  {
    PostingThreadState localPostingThreadState = (PostingThreadState)this.currentPostingThreadState.get();
    if (localPostingThreadState.isPosting)
    {
      if (paramObject != null)
      {
        if (localPostingThreadState.event == paramObject)
        {
          if (localPostingThreadState.subscription.subscriberMethod.threadMode == ThreadMode.POSTING)
          {
            localPostingThreadState.canceled = true;
            return;
          }
          throw new EventBusException(" event handlers may only abort the incoming event");
        }
        throw new EventBusException("Only the currently handled event may be aborted");
      }
      throw new EventBusException("Event may not be null");
    }
    throw new EventBusException("This method may only be called from inside event handling methods on the posting thread");
  }
  
  ExecutorService getExecutorService()
  {
    return this.executorService;
  }
  
  public Logger getLogger()
  {
    return this.logger;
  }
  
  public <T> T getStickyEvent(Class<T> paramClass)
  {
    synchronized (this.stickyEvents)
    {
      paramClass = paramClass.cast(this.stickyEvents.get(paramClass));
      return paramClass;
    }
  }
  
  public boolean hasSubscriberForEvent(Class<?> paramClass)
  {
    paramClass = lookupAllEventTypes(paramClass);
    if (paramClass != null)
    {
      int j = paramClass.size();
      int i = 0;
      while (i < j)
      {
        Object localObject = (Class)paramClass.get(i);
        try
        {
          localObject = (CopyOnWriteArrayList)this.subscriptionsByEventType.get(localObject);
          if ((localObject != null) && (!((CopyOnWriteArrayList)localObject).isEmpty())) {
            return true;
          }
          i += 1;
        }
        finally {}
      }
    }
    return false;
  }
  
  void invokeSubscriber(PendingPost paramPendingPost)
  {
    Object localObject = paramPendingPost.event;
    Subscription localSubscription = paramPendingPost.subscription;
    PendingPost.releasePendingPost(paramPendingPost);
    if (localSubscription.active) {
      invokeSubscriber(localSubscription, localObject);
    }
  }
  
  void invokeSubscriber(Subscription paramSubscription, Object paramObject)
  {
    try
    {
      paramSubscription.subscriberMethod.method.invoke(paramSubscription.subscriber, new Object[] { paramObject });
      return;
    }
    catch (IllegalAccessException paramSubscription)
    {
      throw new IllegalStateException("Unexpected exception", paramSubscription);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      handleSubscriberException(paramSubscription, paramObject, localInvocationTargetException.getCause());
    }
  }
  
  public boolean isRegistered(Object paramObject)
  {
    try
    {
      boolean bool = this.typesBySubscriber.containsKey(paramObject);
      return bool;
    }
    finally
    {
      paramObject = finally;
      throw ((Throwable)paramObject);
    }
  }
  
  public void post(Object paramObject)
  {
    PostingThreadState localPostingThreadState = (PostingThreadState)this.currentPostingThreadState.get();
    List localList = localPostingThreadState.eventQueue;
    localList.add(paramObject);
    if (!localPostingThreadState.isPosting)
    {
      localPostingThreadState.isMainThread = isMainThread();
      localPostingThreadState.isPosting = true;
      if (!localPostingThreadState.canceled) {
        try
        {
          while (!localList.isEmpty()) {
            postSingleEvent(localList.remove(0), localPostingThreadState);
          }
          return;
        }
        finally
        {
          localPostingThreadState.isPosting = false;
          localPostingThreadState.isMainThread = false;
        }
      }
      throw new EventBusException("Internal error. Abort state was not reset");
    }
  }
  
  public void postSticky(Object paramObject)
  {
    synchronized (this.stickyEvents)
    {
      this.stickyEvents.put(paramObject.getClass(), paramObject);
      post(paramObject);
      return;
    }
  }
  
  public void register(Object paramObject)
  {
    Object localObject = paramObject.getClass();
    localObject = this.subscriberMethodFinder.findSubscriberMethods((Class)localObject);
    try
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        subscribe(paramObject, (SubscriberMethod)((Iterator)localObject).next());
      }
      return;
    }
    finally {}
  }
  
  public void removeAllStickyEvents()
  {
    synchronized (this.stickyEvents)
    {
      this.stickyEvents.clear();
      return;
    }
  }
  
  public <T> T removeStickyEvent(Class<T> paramClass)
  {
    synchronized (this.stickyEvents)
    {
      paramClass = paramClass.cast(this.stickyEvents.remove(paramClass));
      return paramClass;
    }
  }
  
  public boolean removeStickyEvent(Object paramObject)
  {
    synchronized (this.stickyEvents)
    {
      Class localClass = paramObject.getClass();
      if (paramObject.equals(this.stickyEvents.get(localClass)))
      {
        this.stickyEvents.remove(localClass);
        return true;
      }
      return false;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EventBus[indexCount=");
    localStringBuilder.append(this.indexCount);
    localStringBuilder.append(", eventInheritance=");
    localStringBuilder.append(this.eventInheritance);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void unregister(Object paramObject)
  {
    try
    {
      Object localObject = (List)this.typesBySubscriber.get(paramObject);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          unsubscribeByEventType(paramObject, (Class)((Iterator)localObject).next());
        }
        this.typesBySubscriber.remove(paramObject);
      }
      else
      {
        localObject = this.logger;
        Level localLevel = Level.WARNING;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Subscriber to unregister was not registered before: ");
        localStringBuilder.append(paramObject.getClass());
        ((Logger)localObject).log(localLevel, localStringBuilder.toString());
      }
      return;
    }
    finally {}
  }
  
  static abstract interface PostCallback
  {
    public abstract void onPostCompleted(List<SubscriberExceptionEvent> paramList);
  }
  
  static final class PostingThreadState
  {
    boolean canceled;
    Object event;
    final List<Object> eventQueue = new ArrayList();
    boolean isMainThread;
    boolean isPosting;
    Subscription subscription;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\greenrobot\eventbus\EventBus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */