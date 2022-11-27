package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Sets;
import com.facebook.common.util.TriState;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.Nullable;

public abstract class MultiplexProducer<K, T extends Closeable>
  implements Producer<T>
{
  public static final String EXTRAS_STARTED_AS_PREFETCH = "started_as_prefetch";
  private final String mDedupedRequestsCountKey;
  private final Producer<T> mInputProducer;
  private final boolean mKeepCancelledFetchAsLowPriority;
  final Map<K, MultiplexProducer<K, T>.Multiplexer> mMultiplexers;
  private final String mProducerName;
  
  protected MultiplexProducer(Producer<T> paramProducer, String paramString1, String paramString2)
  {
    this(paramProducer, paramString1, paramString2, false);
  }
  
  protected MultiplexProducer(Producer<T> paramProducer, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.mInputProducer = paramProducer;
    this.mMultiplexers = new HashMap();
    this.mKeepCancelledFetchAsLowPriority = paramBoolean;
    this.mProducerName = paramString1;
    this.mDedupedRequestsCountKey = paramString2;
  }
  
  private MultiplexProducer<K, T>.Multiplexer createAndPutNewMultiplexer(K paramK)
  {
    try
    {
      Multiplexer localMultiplexer = new Multiplexer(paramK);
      this.mMultiplexers.put(paramK, localMultiplexer);
      return localMultiplexer;
    }
    finally
    {
      paramK = finally;
      throw paramK;
    }
  }
  
  protected abstract T cloneOrNull(T paramT);
  
  protected MultiplexProducer<K, T>.Multiplexer getExistingMultiplexer(K paramK)
  {
    try
    {
      paramK = (Multiplexer)this.mMultiplexers.get(paramK);
      return paramK;
    }
    finally
    {
      paramK = finally;
      throw paramK;
    }
  }
  
  protected abstract K getKey(ProducerContext paramProducerContext);
  
  /* Error */
  public void produceResults(Consumer<T> paramConsumer, ProducerContext paramProducerContext)
  {
    // Byte code:
    //   0: invokestatic 92	com/facebook/imagepipeline/systrace/FrescoSystrace:isTracing	()Z
    //   3: ifeq +8 -> 11
    //   6: ldc 94
    //   8: invokestatic 98	com/facebook/imagepipeline/systrace/FrescoSystrace:beginSection	(Ljava/lang/String;)V
    //   11: aload_2
    //   12: invokeinterface 104 1 0
    //   17: aload_2
    //   18: aload_0
    //   19: getfield 53	com/facebook/imagepipeline/producers/MultiplexProducer:mProducerName	Ljava/lang/String;
    //   22: invokeinterface 110 3 0
    //   27: aload_0
    //   28: aload_2
    //   29: invokevirtual 112	com/facebook/imagepipeline/producers/MultiplexProducer:getKey	(Lcom/facebook/imagepipeline/producers/ProducerContext;)Ljava/lang/Object;
    //   32: astore 6
    //   34: iconst_0
    //   35: istore_3
    //   36: aload_0
    //   37: monitorenter
    //   38: aload_0
    //   39: aload 6
    //   41: invokevirtual 114	com/facebook/imagepipeline/producers/MultiplexProducer:getExistingMultiplexer	(Ljava/lang/Object;)Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer;
    //   44: astore 5
    //   46: aload 5
    //   48: astore 4
    //   50: aload 5
    //   52: ifnonnull +13 -> 65
    //   55: aload_0
    //   56: aload 6
    //   58: invokespecial 116	com/facebook/imagepipeline/producers/MultiplexProducer:createAndPutNewMultiplexer	(Ljava/lang/Object;)Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer;
    //   61: astore 4
    //   63: iconst_1
    //   64: istore_3
    //   65: aload_0
    //   66: monitorexit
    //   67: aload 4
    //   69: aload_1
    //   70: aload_2
    //   71: invokevirtual 120	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:addNewConsumer	(Lcom/facebook/imagepipeline/producers/Consumer;Lcom/facebook/imagepipeline/producers/ProducerContext;)Z
    //   74: ifeq -40 -> 34
    //   77: iload_3
    //   78: ifeq +17 -> 95
    //   81: aload 4
    //   83: aload_2
    //   84: invokeinterface 123 1 0
    //   89: invokestatic 129	com/facebook/common/util/TriState:valueOf	(Z)Lcom/facebook/common/util/TriState;
    //   92: invokestatic 133	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:access$000	(Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer;Lcom/facebook/common/util/TriState;)V
    //   95: invokestatic 92	com/facebook/imagepipeline/systrace/FrescoSystrace:isTracing	()Z
    //   98: ifeq +6 -> 104
    //   101: invokestatic 136	com/facebook/imagepipeline/systrace/FrescoSystrace:endSection	()V
    //   104: return
    //   105: astore_1
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_1
    //   109: athrow
    //   110: astore_1
    //   111: invokestatic 92	com/facebook/imagepipeline/systrace/FrescoSystrace:isTracing	()Z
    //   114: ifeq +6 -> 120
    //   117: invokestatic 136	com/facebook/imagepipeline/systrace/FrescoSystrace:endSection	()V
    //   120: aload_1
    //   121: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	MultiplexProducer
    //   0	122	1	paramConsumer	Consumer<T>
    //   0	122	2	paramProducerContext	ProducerContext
    //   35	43	3	i	int
    //   48	34	4	localMultiplexer1	Multiplexer
    //   44	7	5	localMultiplexer2	Multiplexer
    //   32	25	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   38	46	105	finally
    //   55	63	105	finally
    //   65	67	105	finally
    //   106	108	105	finally
    //   0	11	110	finally
    //   11	34	110	finally
    //   36	38	110	finally
    //   67	77	110	finally
    //   81	95	110	finally
    //   108	110	110	finally
  }
  
  protected void removeMultiplexer(K paramK, MultiplexProducer<K, T>.Multiplexer paramMultiplexProducer)
  {
    try
    {
      if (this.mMultiplexers.get(paramK) == paramMultiplexProducer) {
        this.mMultiplexers.remove(paramK);
      }
      return;
    }
    finally
    {
      paramK = finally;
      throw paramK;
    }
  }
  
  class Multiplexer
  {
    private final CopyOnWriteArraySet<Pair<Consumer<T>, ProducerContext>> mConsumerContextPairs = Sets.newCopyOnWriteArraySet();
    @Nullable
    private MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer mForwardingConsumer;
    private final K mKey;
    @Nullable
    private T mLastIntermediateResult;
    private float mLastProgress;
    private int mLastStatus;
    @Nullable
    private BaseProducerContext mMultiplexProducerContext;
    
    public Multiplexer()
    {
      Object localObject;
      this.mKey = localObject;
    }
    
    private void addCallbacks(final Pair<Consumer<T>, ProducerContext> paramPair, ProducerContext paramProducerContext)
    {
      paramProducerContext.addCallbacks(new BaseProducerContextCallbacks()
      {
        public void onCancellationRequested()
        {
          for (;;)
          {
            synchronized (MultiplexProducer.Multiplexer.this)
            {
              boolean bool = MultiplexProducer.Multiplexer.this.mConsumerContextPairs.remove(paramPair);
              List localList1 = null;
              if (bool)
              {
                if (MultiplexProducer.Multiplexer.this.mConsumerContextPairs.isEmpty())
                {
                  localBaseProducerContext = MultiplexProducer.Multiplexer.this.mMultiplexProducerContext;
                  break label171;
                }
                localList1 = MultiplexProducer.Multiplexer.this.updateIsPrefetch();
                localList2 = MultiplexProducer.Multiplexer.this.updatePriority();
                localList3 = MultiplexProducer.Multiplexer.this.updateIsIntermediateResultExpected();
                BaseProducerContext localBaseProducerContext = null;
                BaseProducerContext.callOnIsPrefetchChanged(localList1);
                BaseProducerContext.callOnPriorityChanged(localList2);
                BaseProducerContext.callOnIsIntermediateResultExpectedChanged(localList3);
                if (localBaseProducerContext != null) {
                  if ((MultiplexProducer.this.mKeepCancelledFetchAsLowPriority) && (!localBaseProducerContext.isPrefetch())) {
                    BaseProducerContext.callOnPriorityChanged(localBaseProducerContext.setPriorityNoCallbacks(Priority.LOW));
                  } else {
                    localBaseProducerContext.cancel();
                  }
                }
                if (bool) {
                  ((Consumer)paramPair.first).onCancellation();
                }
                return;
              }
            }
            Object localObject2 = null;
            label171:
            List localList2 = null;
            List localList3 = null;
          }
        }
        
        public void onIsIntermediateResultExpectedChanged()
        {
          BaseProducerContext.callOnIsIntermediateResultExpectedChanged(MultiplexProducer.Multiplexer.this.updateIsIntermediateResultExpected());
        }
        
        public void onIsPrefetchChanged()
        {
          BaseProducerContext.callOnIsPrefetchChanged(MultiplexProducer.Multiplexer.this.updateIsPrefetch());
        }
        
        public void onPriorityChanged()
        {
          BaseProducerContext.callOnPriorityChanged(MultiplexProducer.Multiplexer.this.updatePriority());
        }
      });
    }
    
    private void closeSafely(Closeable paramCloseable)
    {
      if (paramCloseable != null) {
        try
        {
          paramCloseable.close();
          return;
        }
        catch (IOException paramCloseable)
        {
          throw new RuntimeException(paramCloseable);
        }
      }
    }
    
    private boolean computeIsIntermediateResultExpected()
    {
      try
      {
        Iterator localIterator = this.mConsumerContextPairs.iterator();
        while (localIterator.hasNext())
        {
          boolean bool = ((ProducerContext)((Pair)localIterator.next()).second).isIntermediateResultExpected();
          if (bool) {
            return true;
          }
        }
        return false;
      }
      finally {}
    }
    
    private boolean computeIsPrefetch()
    {
      try
      {
        Iterator localIterator = this.mConsumerContextPairs.iterator();
        while (localIterator.hasNext())
        {
          boolean bool = ((ProducerContext)((Pair)localIterator.next()).second).isPrefetch();
          if (!bool) {
            return false;
          }
        }
        return true;
      }
      finally {}
    }
    
    private Priority computePriority()
    {
      try
      {
        Priority localPriority = Priority.LOW;
        Iterator localIterator = this.mConsumerContextPairs.iterator();
        while (localIterator.hasNext()) {
          localPriority = Priority.getHigherPriority(localPriority, ((ProducerContext)((Pair)localIterator.next()).second).getPriority());
        }
        return localPriority;
      }
      finally {}
    }
    
    private void startInputProducerIfHasAttachedConsumers(TriState paramTriState)
    {
      for (;;)
      {
        try
        {
          Object localObject = this.mMultiplexProducerContext;
          boolean bool2 = true;
          if (localObject == null)
          {
            bool1 = true;
            Preconditions.checkArgument(bool1);
            if (this.mForwardingConsumer != null) {
              break label241;
            }
            bool1 = bool2;
            Preconditions.checkArgument(bool1);
            if (this.mConsumerContextPairs.isEmpty())
            {
              MultiplexProducer.this.removeMultiplexer(this.mKey, this);
              return;
            }
            localObject = (ProducerContext)((Pair)this.mConsumerContextPairs.iterator().next()).second;
            BaseProducerContext localBaseProducerContext = new BaseProducerContext(((ProducerContext)localObject).getImageRequest(), ((ProducerContext)localObject).getId(), ((ProducerContext)localObject).getProducerListener(), ((ProducerContext)localObject).getCallerContext(), ((ProducerContext)localObject).getLowestPermittedRequestLevel(), computeIsPrefetch(), computeIsIntermediateResultExpected(), computePriority(), ((ProducerContext)localObject).getImagePipelineConfig());
            this.mMultiplexProducerContext = localBaseProducerContext;
            localBaseProducerContext.putExtras(((ProducerContext)localObject).getExtras());
            if (paramTriState.isSet()) {
              this.mMultiplexProducerContext.setExtra("started_as_prefetch", Boolean.valueOf(paramTriState.asBoolean()));
            }
            paramTriState = new ForwardingConsumer(null);
            this.mForwardingConsumer = paramTriState;
            localObject = this.mMultiplexProducerContext;
            MultiplexProducer.this.mInputProducer.produceResults(paramTriState, (ProducerContext)localObject);
            return;
          }
        }
        finally {}
        boolean bool1 = false;
        continue;
        label241:
        bool1 = false;
      }
    }
    
    @Nullable
    private List<ProducerContextCallbacks> updateIsIntermediateResultExpected()
    {
      try
      {
        Object localObject1 = this.mMultiplexProducerContext;
        if (localObject1 == null) {
          return null;
        }
        localObject1 = this.mMultiplexProducerContext.setIsIntermediateResultExpectedNoCallbacks(computeIsIntermediateResultExpected());
        return (List<ProducerContextCallbacks>)localObject1;
      }
      finally {}
    }
    
    @Nullable
    private List<ProducerContextCallbacks> updateIsPrefetch()
    {
      try
      {
        Object localObject1 = this.mMultiplexProducerContext;
        if (localObject1 == null) {
          return null;
        }
        localObject1 = this.mMultiplexProducerContext.setIsPrefetchNoCallbacks(computeIsPrefetch());
        return (List<ProducerContextCallbacks>)localObject1;
      }
      finally {}
    }
    
    @Nullable
    private List<ProducerContextCallbacks> updatePriority()
    {
      try
      {
        Object localObject1 = this.mMultiplexProducerContext;
        if (localObject1 == null) {
          return null;
        }
        localObject1 = this.mMultiplexProducerContext.setPriorityNoCallbacks(computePriority());
        return (List<ProducerContextCallbacks>)localObject1;
      }
      finally {}
    }
    
    /* Error */
    public boolean addNewConsumer(Consumer<T> paramConsumer, ProducerContext paramProducerContext)
    {
      // Byte code:
      //   0: aload_1
      //   1: aload_2
      //   2: invokestatic 257	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
      //   5: astore 7
      //   7: aload_0
      //   8: monitorenter
      //   9: aload_0
      //   10: getfield 37	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:this$0	Lcom/facebook/imagepipeline/producers/MultiplexProducer;
      //   13: aload_0
      //   14: getfield 50	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:mKey	Ljava/lang/Object;
      //   17: invokevirtual 261	com/facebook/imagepipeline/producers/MultiplexProducer:getExistingMultiplexer	(Ljava/lang/Object;)Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer;
      //   20: aload_0
      //   21: if_acmpeq +7 -> 28
      //   24: aload_0
      //   25: monitorexit
      //   26: iconst_0
      //   27: ireturn
      //   28: aload_0
      //   29: getfield 48	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:mConsumerContextPairs	Ljava/util/concurrent/CopyOnWriteArraySet;
      //   32: aload 7
      //   34: invokevirtual 265	java/util/concurrent/CopyOnWriteArraySet:add	(Ljava/lang/Object;)Z
      //   37: pop
      //   38: aload_0
      //   39: invokespecial 71	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:updateIsPrefetch	()Ljava/util/List;
      //   42: astore 5
      //   44: aload_0
      //   45: invokespecial 75	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:updatePriority	()Ljava/util/List;
      //   48: astore 8
      //   50: aload_0
      //   51: invokespecial 79	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:updateIsIntermediateResultExpected	()Ljava/util/List;
      //   54: astore 9
      //   56: aload_0
      //   57: getfield 267	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:mLastIntermediateResult	Ljava/io/Closeable;
      //   60: astore 6
      //   62: aload_0
      //   63: getfield 269	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:mLastProgress	F
      //   66: fstore_3
      //   67: aload_0
      //   68: getfield 271	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:mLastStatus	I
      //   71: istore 4
      //   73: aload_0
      //   74: monitorexit
      //   75: aload 5
      //   77: invokestatic 275	com/facebook/imagepipeline/producers/BaseProducerContext:callOnIsPrefetchChanged	(Ljava/util/List;)V
      //   80: aload 8
      //   82: invokestatic 278	com/facebook/imagepipeline/producers/BaseProducerContext:callOnPriorityChanged	(Ljava/util/List;)V
      //   85: aload 9
      //   87: invokestatic 281	com/facebook/imagepipeline/producers/BaseProducerContext:callOnIsIntermediateResultExpectedChanged	(Ljava/util/List;)V
      //   90: aload 7
      //   92: monitorenter
      //   93: aload_0
      //   94: monitorenter
      //   95: aload 6
      //   97: aload_0
      //   98: getfield 267	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:mLastIntermediateResult	Ljava/io/Closeable;
      //   101: if_acmpeq +9 -> 110
      //   104: aconst_null
      //   105: astore 5
      //   107: goto +23 -> 130
      //   110: aload 6
      //   112: astore 5
      //   114: aload 6
      //   116: ifnull +14 -> 130
      //   119: aload_0
      //   120: getfield 37	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:this$0	Lcom/facebook/imagepipeline/producers/MultiplexProducer;
      //   123: aload 6
      //   125: invokevirtual 285	com/facebook/imagepipeline/producers/MultiplexProducer:cloneOrNull	(Ljava/io/Closeable;)Ljava/io/Closeable;
      //   128: astore 5
      //   130: aload_0
      //   131: monitorexit
      //   132: aload 5
      //   134: ifnull +32 -> 166
      //   137: fload_3
      //   138: fconst_0
      //   139: fcmpl
      //   140: ifle +10 -> 150
      //   143: aload_1
      //   144: fload_3
      //   145: invokeinterface 291 2 0
      //   150: aload_1
      //   151: aload 5
      //   153: iload 4
      //   155: invokeinterface 295 3 0
      //   160: aload_0
      //   161: aload 5
      //   163: invokespecial 297	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:closeSafely	(Ljava/io/Closeable;)V
      //   166: aload 7
      //   168: monitorexit
      //   169: aload_0
      //   170: aload 7
      //   172: aload_2
      //   173: invokespecial 299	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:addCallbacks	(Landroid/util/Pair;Lcom/facebook/imagepipeline/producers/ProducerContext;)V
      //   176: iconst_1
      //   177: ireturn
      //   178: astore_1
      //   179: aload_0
      //   180: monitorexit
      //   181: aload_1
      //   182: athrow
      //   183: astore_1
      //   184: aload 7
      //   186: monitorexit
      //   187: aload_1
      //   188: athrow
      //   189: astore_1
      //   190: aload_0
      //   191: monitorexit
      //   192: aload_1
      //   193: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	194	0	this	Multiplexer
      //   0	194	1	paramConsumer	Consumer<T>
      //   0	194	2	paramProducerContext	ProducerContext
      //   66	79	3	f	float
      //   71	83	4	i	int
      //   42	120	5	localObject	Object
      //   60	64	6	localCloseable	Closeable
      //   5	180	7	localPair	Pair
      //   48	33	8	localList1	List
      //   54	32	9	localList2	List
      // Exception table:
      //   from	to	target	type
      //   95	104	178	finally
      //   119	130	178	finally
      //   130	132	178	finally
      //   179	181	178	finally
      //   93	95	183	finally
      //   143	150	183	finally
      //   150	166	183	finally
      //   166	169	183	finally
      //   181	183	183	finally
      //   184	187	183	finally
      //   9	26	189	finally
      //   28	75	189	finally
      //   190	192	189	finally
    }
    
    public void onCancelled(MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer paramMultiplexProducer)
    {
      try
      {
        if (this.mForwardingConsumer != paramMultiplexProducer) {
          return;
        }
        this.mForwardingConsumer = null;
        this.mMultiplexProducerContext = null;
        closeSafely(this.mLastIntermediateResult);
        this.mLastIntermediateResult = null;
        startInputProducerIfHasAttachedConsumers(TriState.UNSET);
        return;
      }
      finally {}
    }
    
    public void onFailure(MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer arg1, Throwable paramThrowable)
    {
      try
      {
        if (this.mForwardingConsumer != ???) {
          return;
        }
        Iterator localIterator = this.mConsumerContextPairs.iterator();
        this.mConsumerContextPairs.clear();
        MultiplexProducer.this.removeMultiplexer(this.mKey, this);
        closeSafely(this.mLastIntermediateResult);
        this.mLastIntermediateResult = null;
        while (localIterator.hasNext()) {
          synchronized ((Pair)localIterator.next())
          {
            ((ProducerContext)???.second).getProducerListener().onProducerFinishWithFailure((ProducerContext)???.second, MultiplexProducer.this.mProducerName, paramThrowable, null);
            ((Consumer)???.first).onFailure(paramThrowable);
          }
        }
        return;
      }
      finally {}
    }
    
    public void onNextResult(MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer arg1, T paramT, int paramInt)
    {
      try
      {
        if (this.mForwardingConsumer != ???) {
          return;
        }
        closeSafely(this.mLastIntermediateResult);
        this.mLastIntermediateResult = null;
        Iterator localIterator = this.mConsumerContextPairs.iterator();
        int i = this.mConsumerContextPairs.size();
        if (BaseConsumer.isNotLast(paramInt))
        {
          this.mLastIntermediateResult = MultiplexProducer.this.cloneOrNull(paramT);
          this.mLastStatus = paramInt;
        }
        else
        {
          this.mConsumerContextPairs.clear();
          MultiplexProducer.this.removeMultiplexer(this.mKey, this);
        }
        while (localIterator.hasNext()) {
          synchronized ((Pair)localIterator.next())
          {
            if (BaseConsumer.isLast(paramInt))
            {
              ((ProducerContext)???.second).getProducerListener().onProducerFinishWithSuccess((ProducerContext)???.second, MultiplexProducer.this.mProducerName, null);
              if (this.mMultiplexProducerContext != null) {
                ((ProducerContext)???.second).putExtras(this.mMultiplexProducerContext.getExtras());
              }
              ((ProducerContext)???.second).setExtra(MultiplexProducer.this.mDedupedRequestsCountKey, Integer.valueOf(i));
            }
            ((Consumer)???.first).onNewResult(paramT, paramInt);
          }
        }
        return;
      }
      finally {}
    }
    
    public void onProgressUpdate(MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer arg1, float paramFloat)
    {
      try
      {
        if (this.mForwardingConsumer != ???) {
          return;
        }
        this.mLastProgress = paramFloat;
        Iterator localIterator = this.mConsumerContextPairs.iterator();
        while (localIterator.hasNext()) {
          synchronized ((Pair)localIterator.next())
          {
            ((Consumer)???.first).onProgressUpdate(paramFloat);
          }
        }
        return;
      }
      finally {}
    }
    
    private class ForwardingConsumer
      extends BaseConsumer<T>
    {
      private ForwardingConsumer() {}
      
      protected void onCancellationImpl()
      {
        try
        {
          if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("MultiplexProducer#onCancellation");
          }
          MultiplexProducer.Multiplexer.this.onCancelled(this);
          return;
        }
        finally
        {
          if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
          }
        }
      }
      
      protected void onFailureImpl(Throwable paramThrowable)
      {
        try
        {
          if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("MultiplexProducer#onFailure");
          }
          MultiplexProducer.Multiplexer.this.onFailure(this, paramThrowable);
          return;
        }
        finally
        {
          if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
          }
        }
      }
      
      protected void onNewResultImpl(T paramT, int paramInt)
      {
        try
        {
          if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("MultiplexProducer#onNewResult");
          }
          MultiplexProducer.Multiplexer.this.onNextResult(this, paramT, paramInt);
          return;
        }
        finally
        {
          if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
          }
        }
      }
      
      protected void onProgressUpdateImpl(float paramFloat)
      {
        try
        {
          if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("MultiplexProducer#onProgressUpdate");
          }
          MultiplexProducer.Multiplexer.this.onProgressUpdate(this, paramFloat);
          return;
        }
        finally
        {
          if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
          }
        }
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\MultiplexProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */