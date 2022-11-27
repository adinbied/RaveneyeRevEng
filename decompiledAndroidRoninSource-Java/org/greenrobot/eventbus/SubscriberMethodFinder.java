package org.greenrobot.eventbus;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.greenrobot.eventbus.meta.SubscriberInfo;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;

class SubscriberMethodFinder
{
  private static final int BRIDGE = 64;
  private static final FindState[] FIND_STATE_POOL = new FindState[4];
  private static final Map<Class<?>, List<SubscriberMethod>> METHOD_CACHE = new ConcurrentHashMap();
  private static final int MODIFIERS_IGNORE = 5192;
  private static final int POOL_SIZE = 4;
  private static final int SYNTHETIC = 4096;
  private final boolean ignoreGeneratedIndex;
  private final boolean strictMethodVerification;
  private List<SubscriberInfoIndex> subscriberInfoIndexes;
  
  SubscriberMethodFinder(List<SubscriberInfoIndex> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.subscriberInfoIndexes = paramList;
    this.strictMethodVerification = paramBoolean1;
    this.ignoreGeneratedIndex = paramBoolean2;
  }
  
  static void clearCaches()
  {
    METHOD_CACHE.clear();
  }
  
  private List<SubscriberMethod> findUsingInfo(Class<?> paramClass)
  {
    FindState localFindState = prepareFindState();
    localFindState.initForSubscriber(paramClass);
    while (localFindState.clazz != null)
    {
      localFindState.subscriberInfo = getSubscriberInfo(localFindState);
      if (localFindState.subscriberInfo != null)
      {
        paramClass = localFindState.subscriberInfo.getSubscriberMethods();
        int j = paramClass.length;
        int i = 0;
        while (i < j)
        {
          Object localObject = paramClass[i];
          if (localFindState.checkAdd(((SubscriberMethod)localObject).method, ((SubscriberMethod)localObject).eventType)) {
            localFindState.subscriberMethods.add(localObject);
          }
          i += 1;
        }
      }
      findUsingReflectionInSingleClass(localFindState);
      localFindState.moveToSuperclass();
    }
    return getMethodsAndRelease(localFindState);
  }
  
  private List<SubscriberMethod> findUsingReflection(Class<?> paramClass)
  {
    FindState localFindState = prepareFindState();
    localFindState.initForSubscriber(paramClass);
    while (localFindState.clazz != null)
    {
      findUsingReflectionInSingleClass(localFindState);
      localFindState.moveToSuperclass();
    }
    return getMethodsAndRelease(localFindState);
  }
  
  private void findUsingReflectionInSingleClass(FindState paramFindState)
  {
    for (;;)
    {
      Object localObject1;
      int j;
      int i;
      Object localObject3;
      try
      {
        localObject1 = paramFindState.clazz.getDeclaredMethods();
      }
      finally {}
      try
      {
        localObject1 = paramFindState.clazz.getMethods();
        paramFindState.skipSuperClasses = true;
        j = localObject1.length;
        i = 0;
        if (i < j)
        {
          localObject3 = localObject1[i];
          int k = ((Method)localObject3).getModifiers();
          if (((k & 0x1) != 0) && ((k & 0x1448) == 0))
          {
            Object localObject4 = ((Method)localObject3).getParameterTypes();
            if (localObject4.length == 1)
            {
              Subscribe localSubscribe = (Subscribe)((Method)localObject3).getAnnotation(Subscribe.class);
              if (localSubscribe != null)
              {
                localObject4 = localObject4[0];
                if (paramFindState.checkAdd((Method)localObject3, (Class)localObject4))
                {
                  ThreadMode localThreadMode = localSubscribe.threadMode();
                  paramFindState.subscriberMethods.add(new SubscriberMethod((Method)localObject3, (Class)localObject4, localThreadMode, localSubscribe.priority(), localSubscribe.sticky()));
                }
              }
            }
            else if ((this.strictMethodVerification) && (((Method)localObject3).isAnnotationPresent(Subscribe.class)))
            {
              paramFindState = new StringBuilder();
              paramFindState.append(((Method)localObject3).getDeclaringClass().getName());
              paramFindState.append(".");
              paramFindState.append(((Method)localObject3).getName());
              paramFindState = paramFindState.toString();
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("@Subscribe method ");
              ((StringBuilder)localObject1).append(paramFindState);
              ((StringBuilder)localObject1).append("must have exactly 1 parameter but has ");
              ((StringBuilder)localObject1).append(localObject4.length);
              throw new EventBusException(((StringBuilder)localObject1).toString());
            }
          }
          else if ((this.strictMethodVerification) && (((Method)localObject3).isAnnotationPresent(Subscribe.class)))
          {
            paramFindState = new StringBuilder();
            paramFindState.append(((Method)localObject3).getDeclaringClass().getName());
            paramFindState.append(".");
            paramFindState.append(((Method)localObject3).getName());
            paramFindState = paramFindState.toString();
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramFindState);
            ((StringBuilder)localObject1).append(" is a illegal @Subscribe method: must be public, non-static, and non-abstract");
            throw new EventBusException(((StringBuilder)localObject1).toString());
          }
          i += 1;
          continue;
        }
        return;
      }
      catch (LinkageError localLinkageError)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("Could not inspect methods of ");
        ((StringBuilder)localObject3).append(paramFindState.clazz.getName());
        paramFindState = ((StringBuilder)localObject3).toString();
        if (this.ignoreGeneratedIndex)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(paramFindState);
          ((StringBuilder)localObject3).append(". Please consider using EventBus annotation processor to avoid reflection.");
          paramFindState = ((StringBuilder)localObject3).toString();
        }
        else
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(paramFindState);
          ((StringBuilder)localObject3).append(". Please make this class visible to EventBus annotation processor to avoid reflection.");
          paramFindState = ((StringBuilder)localObject3).toString();
        }
        throw new EventBusException(paramFindState, localLinkageError);
      }
    }
  }
  
  private List<SubscriberMethod> getMethodsAndRelease(FindState paramFindState)
  {
    ArrayList localArrayList = new ArrayList(paramFindState.subscriberMethods);
    paramFindState.recycle();
    FindState[] arrayOfFindState = FIND_STATE_POOL;
    int i = 0;
    for (;;)
    {
      if (i < 4) {}
      try
      {
        if (FIND_STATE_POOL[i] == null)
        {
          FIND_STATE_POOL[i] = paramFindState;
          return localArrayList;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  private SubscriberInfo getSubscriberInfo(FindState paramFindState)
  {
    if ((paramFindState.subscriberInfo != null) && (paramFindState.subscriberInfo.getSuperSubscriberInfo() != null))
    {
      localObject = paramFindState.subscriberInfo.getSuperSubscriberInfo();
      if (paramFindState.clazz == ((SubscriberInfo)localObject).getSubscriberClass()) {
        return (SubscriberInfo)localObject;
      }
    }
    Object localObject = this.subscriberInfoIndexes;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        SubscriberInfo localSubscriberInfo = ((SubscriberInfoIndex)((Iterator)localObject).next()).getSubscriberInfo(paramFindState.clazz);
        if (localSubscriberInfo != null) {
          return localSubscriberInfo;
        }
      }
    }
    return null;
  }
  
  private FindState prepareFindState()
  {
    FindState[] arrayOfFindState = FIND_STATE_POOL;
    int i = 0;
    for (;;)
    {
      if (i < 4) {}
      try
      {
        FindState localFindState = FIND_STATE_POOL[i];
        if (localFindState == null) {
          break label48;
        }
        FIND_STATE_POOL[i] = null;
        return localFindState;
      }
      finally {}
      return new FindState();
      label48:
      i += 1;
    }
  }
  
  List<SubscriberMethod> findSubscriberMethods(Class<?> paramClass)
  {
    Object localObject = (List)METHOD_CACHE.get(paramClass);
    if (localObject != null) {
      return (List<SubscriberMethod>)localObject;
    }
    if (this.ignoreGeneratedIndex) {
      localObject = findUsingReflection(paramClass);
    } else {
      localObject = findUsingInfo(paramClass);
    }
    if (!((List)localObject).isEmpty())
    {
      METHOD_CACHE.put(paramClass, localObject);
      return (List<SubscriberMethod>)localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Subscriber ");
    ((StringBuilder)localObject).append(paramClass);
    ((StringBuilder)localObject).append(" and its super classes have no public methods with the @Subscribe annotation");
    throw new EventBusException(((StringBuilder)localObject).toString());
  }
  
  static class FindState
  {
    final Map<Class, Object> anyMethodByEventType = new HashMap();
    Class<?> clazz;
    final StringBuilder methodKeyBuilder = new StringBuilder(128);
    boolean skipSuperClasses;
    Class<?> subscriberClass;
    final Map<String, Class> subscriberClassByMethodKey = new HashMap();
    SubscriberInfo subscriberInfo;
    final List<SubscriberMethod> subscriberMethods = new ArrayList();
    
    private boolean checkAddWithMethodSignature(Method paramMethod, Class<?> paramClass)
    {
      this.methodKeyBuilder.setLength(0);
      this.methodKeyBuilder.append(paramMethod.getName());
      Object localObject = this.methodKeyBuilder;
      ((StringBuilder)localObject).append('>');
      ((StringBuilder)localObject).append(paramClass.getName());
      paramClass = this.methodKeyBuilder.toString();
      paramMethod = paramMethod.getDeclaringClass();
      localObject = (Class)this.subscriberClassByMethodKey.put(paramClass, paramMethod);
      if ((localObject != null) && (!((Class)localObject).isAssignableFrom(paramMethod)))
      {
        this.subscriberClassByMethodKey.put(paramClass, localObject);
        return false;
      }
      return true;
    }
    
    boolean checkAdd(Method paramMethod, Class<?> paramClass)
    {
      Object localObject = this.anyMethodByEventType.put(paramClass, paramMethod);
      if (localObject == null) {
        return true;
      }
      if ((localObject instanceof Method)) {
        if (checkAddWithMethodSignature((Method)localObject, paramClass)) {
          this.anyMethodByEventType.put(paramClass, this);
        } else {
          throw new IllegalStateException();
        }
      }
      return checkAddWithMethodSignature(paramMethod, paramClass);
    }
    
    void initForSubscriber(Class<?> paramClass)
    {
      this.clazz = paramClass;
      this.subscriberClass = paramClass;
      this.skipSuperClasses = false;
      this.subscriberInfo = null;
    }
    
    void moveToSuperclass()
    {
      if (this.skipSuperClasses)
      {
        this.clazz = null;
        return;
      }
      Object localObject = this.clazz.getSuperclass();
      this.clazz = ((Class)localObject);
      localObject = ((Class)localObject).getName();
      if ((((String)localObject).startsWith("java.")) || (((String)localObject).startsWith("javax.")) || (((String)localObject).startsWith("android.")) || (((String)localObject).startsWith("androidx."))) {
        this.clazz = null;
      }
    }
    
    void recycle()
    {
      this.subscriberMethods.clear();
      this.anyMethodByEventType.clear();
      this.subscriberClassByMethodKey.clear();
      this.methodKeyBuilder.setLength(0);
      this.subscriberClass = null;
      this.clazz = null;
      this.skipSuperClasses = false;
      this.subscriberInfo = null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\greenrobot\eventbus\SubscriberMethodFinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */