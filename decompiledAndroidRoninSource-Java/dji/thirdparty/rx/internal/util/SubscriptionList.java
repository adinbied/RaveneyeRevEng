package dji.thirdparty.rx.internal.util;

import dji.thirdparty.rx.Subscription;
import java.util.Arrays;
import java.util.LinkedList;

public final class SubscriptionList
  implements Subscription
{
  private LinkedList<Subscription> subscriptions;
  private volatile boolean unsubscribed;
  
  public SubscriptionList() {}
  
  public SubscriptionList(Subscription paramSubscription)
  {
    LinkedList localLinkedList = new LinkedList();
    this.subscriptions = localLinkedList;
    localLinkedList.add(paramSubscription);
  }
  
  public SubscriptionList(Subscription... paramVarArgs)
  {
    this.subscriptions = new LinkedList(Arrays.asList(paramVarArgs));
  }
  
  /* Error */
  private static void unsubscribeFromAll(java.util.Collection<Subscription> paramCollection)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aconst_null
    //   6: astore_1
    //   7: aload_0
    //   8: invokeinterface 43 1 0
    //   13: astore_2
    //   14: aload_1
    //   15: astore_0
    //   16: aload_2
    //   17: invokeinterface 49 1 0
    //   22: ifeq +50 -> 72
    //   25: aload_2
    //   26: invokeinterface 53 1 0
    //   31: checkcast 6	dji/thirdparty/rx/Subscription
    //   34: astore_1
    //   35: aload_1
    //   36: invokeinterface 56 1 0
    //   41: goto -25 -> 16
    //   44: astore_3
    //   45: aload_0
    //   46: astore_1
    //   47: aload_0
    //   48: ifnonnull +11 -> 59
    //   51: new 58	java/util/ArrayList
    //   54: dup
    //   55: invokespecial 59	java/util/ArrayList:<init>	()V
    //   58: astore_1
    //   59: aload_1
    //   60: aload_3
    //   61: invokeinterface 62 2 0
    //   66: pop
    //   67: aload_1
    //   68: astore_0
    //   69: goto -53 -> 16
    //   72: aload_0
    //   73: invokestatic 68	dji/thirdparty/rx/exceptions/Exceptions:throwIfAny	(Ljava/util/List;)V
    //   76: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	paramCollection	java.util.Collection<Subscription>
    //   6	62	1	localObject1	Object
    //   13	13	2	localIterator	java.util.Iterator
    //   44	17	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   35	41	44	finally
  }
  
  /* Error */
  public void add(Subscription arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void clear()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public boolean hasSubscriptions()
  {
    return false;
  }
  
  public boolean isUnsubscribed()
  {
    return this.unsubscribed;
  }
  
  /* Error */
  public void remove(Subscription arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void unsubscribe()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\interna\\util\SubscriptionList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */