package com.facebook.imagepipeline.producers;

import com.facebook.common.logging.FLog;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.image.EncodedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

public class PriorityNetworkFetcher<FETCH_STATE extends FetchState>
  implements NetworkFetcher<PriorityFetchState<FETCH_STATE>>
{
  public static final String TAG = PriorityNetworkFetcher.class.getSimpleName();
  private final MonotonicClock mClock;
  private final HashSet<PriorityFetchState<FETCH_STATE>> mCurrentlyFetching = new HashSet();
  private final NetworkFetcher<FETCH_STATE> mDelegate;
  private final LinkedList<PriorityFetchState<FETCH_STATE>> mHiPriQueue = new LinkedList();
  private final boolean mIsHiPriFifo;
  private final Object mLock = new Object();
  private final LinkedList<PriorityFetchState<FETCH_STATE>> mLowPriQueue = new LinkedList();
  private final int mMaxOutstandingHiPri;
  private final int mMaxOutstandingLowPri;
  
  public PriorityNetworkFetcher(NetworkFetcher<FETCH_STATE> paramNetworkFetcher, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this(paramNetworkFetcher, paramBoolean, paramInt1, paramInt2, RealtimeSinceBootClock.get());
  }
  
  public PriorityNetworkFetcher(NetworkFetcher<FETCH_STATE> paramNetworkFetcher, boolean paramBoolean, int paramInt1, int paramInt2, MonotonicClock paramMonotonicClock)
  {
    this.mDelegate = paramNetworkFetcher;
    this.mIsHiPriFifo = paramBoolean;
    this.mMaxOutstandingHiPri = paramInt1;
    this.mMaxOutstandingLowPri = paramInt2;
    if (paramInt1 > paramInt2)
    {
      this.mClock = paramMonotonicClock;
      return;
    }
    throw new IllegalArgumentException("maxOutstandingHiPri should be > maxOutstandingLowPri");
  }
  
  private void changePriority(PriorityFetchState<FETCH_STATE> paramPriorityFetchState, boolean paramBoolean)
  {
    Object localObject2 = this.mLock;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        localObject1 = this.mLowPriQueue;
        boolean bool = ((LinkedList)localObject1).remove(paramPriorityFetchState);
        continue;
        localObject1 = this.mHiPriQueue;
        continue;
        if (!bool) {
          return;
        }
        String str = TAG;
        if (paramBoolean)
        {
          localObject1 = "HIPRI";
          FLog.v(str, "change-pri: %s %s", localObject1, paramPriorityFetchState.getUri());
          putInQueue(paramPriorityFetchState, paramBoolean);
          dequeueIfAvailableSlots();
          return;
        }
      }
      finally {}
      Object localObject1 = "LOWPRI";
    }
  }
  
  private void delegateFetch(final PriorityFetchState<FETCH_STATE> paramPriorityFetchState)
  {
    try
    {
      NetworkFetcher.Callback local2 = new NetworkFetcher.Callback()
      {
        public void onCancellation()
        {
          PriorityNetworkFetcher.this.removeFromQueue(paramPriorityFetchState, "CANCEL");
          paramPriorityFetchState.callback.onCancellation();
        }
        
        public void onFailure(Throwable paramAnonymousThrowable)
        {
          PriorityNetworkFetcher.this.removeFromQueue(paramPriorityFetchState, "FAIL");
          paramPriorityFetchState.callback.onFailure(paramAnonymousThrowable);
        }
        
        public void onResponse(InputStream paramAnonymousInputStream, int paramAnonymousInt)
          throws IOException
        {
          paramPriorityFetchState.callback.onResponse(paramAnonymousInputStream, paramAnonymousInt);
        }
      };
      this.mDelegate.fetch(paramPriorityFetchState.delegatedState, local2);
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    removeFromQueue(paramPriorityFetchState, "FAIL");
  }
  
  private void dequeueIfAvailableSlots()
  {
    for (;;)
    {
      synchronized (this.mLock)
      {
        int i = this.mCurrentlyFetching.size();
        if (i < this.mMaxOutstandingHiPri)
        {
          PriorityFetchState localPriorityFetchState1 = (PriorityFetchState)this.mHiPriQueue.pollFirst();
          PriorityFetchState localPriorityFetchState2 = localPriorityFetchState1;
          if (localPriorityFetchState1 == null)
          {
            localPriorityFetchState2 = localPriorityFetchState1;
            if (i < this.mMaxOutstandingLowPri) {
              localPriorityFetchState2 = (PriorityFetchState)this.mLowPriQueue.pollFirst();
            }
          }
          if (localPriorityFetchState2 == null) {
            return;
          }
          localPriorityFetchState2.dequeuedTimestamp = this.mClock.now();
          this.mCurrentlyFetching.add(localPriorityFetchState2);
          FLog.v(TAG, "fetching: %s (concurrent: %s hi-pri queue: %s low-pri queue: %s)", localPriorityFetchState2.getUri(), Integer.valueOf(i), Integer.valueOf(this.mHiPriQueue.size()), Integer.valueOf(this.mLowPriQueue.size()));
          delegateFetch(localPriorityFetchState2);
          return;
        }
      }
      Object localObject2 = null;
    }
  }
  
  private void putInQueue(PriorityFetchState<FETCH_STATE> paramPriorityFetchState, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.mIsHiPriFifo)
      {
        this.mHiPriQueue.addLast(paramPriorityFetchState);
        return;
      }
      this.mHiPriQueue.addFirst(paramPriorityFetchState);
      return;
    }
    this.mLowPriQueue.addLast(paramPriorityFetchState);
  }
  
  private void removeFromQueue(PriorityFetchState<FETCH_STATE> paramPriorityFetchState, String paramString)
  {
    synchronized (this.mLock)
    {
      FLog.v(TAG, "remove: %s %s", paramString, paramPriorityFetchState.getUri());
      this.mCurrentlyFetching.remove(paramPriorityFetchState);
      if (!this.mHiPriQueue.remove(paramPriorityFetchState)) {
        this.mLowPriQueue.remove(paramPriorityFetchState);
      }
      dequeueIfAvailableSlots();
      return;
    }
  }
  
  public PriorityFetchState<FETCH_STATE> createFetchState(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    return new PriorityFetchState(paramConsumer, paramProducerContext, this.mDelegate.createFetchState(paramConsumer, paramProducerContext), this.mClock.now(), this.mHiPriQueue.size(), this.mLowPriQueue.size(), null);
  }
  
  public void fetch(final PriorityFetchState<FETCH_STATE> paramPriorityFetchState, final NetworkFetcher.Callback paramCallback)
  {
    paramPriorityFetchState.getContext().addCallbacks(new BaseProducerContextCallbacks()
    {
      public void onCancellationRequested()
      {
        PriorityNetworkFetcher.this.removeFromQueue(paramPriorityFetchState, "CANCEL");
        paramCallback.onCancellation();
      }
      
      public void onPriorityChanged()
      {
        PriorityNetworkFetcher localPriorityNetworkFetcher = PriorityNetworkFetcher.this;
        PriorityNetworkFetcher.PriorityFetchState localPriorityFetchState = paramPriorityFetchState;
        boolean bool;
        if (localPriorityFetchState.getContext().getPriority() == Priority.HIGH) {
          bool = true;
        } else {
          bool = false;
        }
        localPriorityNetworkFetcher.changePriority(localPriorityFetchState, bool);
      }
    });
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (this.mCurrentlyFetching.contains(paramPriorityFetchState))
        {
          paramCallback = TAG;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("fetch state was enqueued twice: ");
          ((StringBuilder)localObject1).append(paramPriorityFetchState);
          FLog.e(paramCallback, ((StringBuilder)localObject1).toString());
          return;
        }
        if (paramPriorityFetchState.getContext().getPriority() == Priority.HIGH)
        {
          bool = true;
          String str = TAG;
          if (!bool) {
            break label161;
          }
          localObject1 = "HI-PRI";
          FLog.v(str, "enqueue: %s %s", localObject1, paramPriorityFetchState.getUri());
          paramPriorityFetchState.callback = paramCallback;
          putInQueue(paramPriorityFetchState, bool);
          dequeueIfAvailableSlots();
          return;
        }
      }
      boolean bool = false;
      continue;
      label161:
      Object localObject1 = "LOW-PRI";
    }
  }
  
  HashSet<PriorityFetchState<FETCH_STATE>> getCurrentlyFetching()
  {
    return this.mCurrentlyFetching;
  }
  
  @Nullable
  public Map<String, String> getExtraMap(PriorityFetchState<FETCH_STATE> paramPriorityFetchState, int paramInt)
  {
    Object localObject = this.mDelegate.getExtraMap(paramPriorityFetchState.delegatedState, paramInt);
    if (localObject != null) {
      localObject = new HashMap((Map)localObject);
    } else {
      localObject = new HashMap();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramPriorityFetchState.dequeuedTimestamp - paramPriorityFetchState.enqueuedTimestamp);
    ((HashMap)localObject).put("pri_queue_time", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramPriorityFetchState.hiPriCountWhenCreated);
    ((HashMap)localObject).put("hipri_queue_size", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramPriorityFetchState.lowPriCountWhenCreated);
    ((HashMap)localObject).put("lowpri_queue_size", localStringBuilder.toString());
    return (Map<String, String>)localObject;
  }
  
  List<PriorityFetchState<FETCH_STATE>> getHiPriQueue()
  {
    return this.mHiPriQueue;
  }
  
  List<PriorityFetchState<FETCH_STATE>> getLowPriQueue()
  {
    return this.mLowPriQueue;
  }
  
  public void onFetchCompletion(PriorityFetchState<FETCH_STATE> paramPriorityFetchState, int paramInt)
  {
    removeFromQueue(paramPriorityFetchState, "SUCCESS");
    this.mDelegate.onFetchCompletion(paramPriorityFetchState.delegatedState, paramInt);
  }
  
  public boolean shouldPropagate(PriorityFetchState<FETCH_STATE> paramPriorityFetchState)
  {
    return this.mDelegate.shouldPropagate(paramPriorityFetchState.delegatedState);
  }
  
  public static class PriorityFetchState<FETCH_STATE extends FetchState>
    extends FetchState
  {
    NetworkFetcher.Callback callback;
    public final FETCH_STATE delegatedState;
    long dequeuedTimestamp;
    final long enqueuedTimestamp;
    final int hiPriCountWhenCreated;
    final int lowPriCountWhenCreated;
    
    private PriorityFetchState(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext, FETCH_STATE paramFETCH_STATE, long paramLong, int paramInt1, int paramInt2)
    {
      super(paramProducerContext);
      this.delegatedState = paramFETCH_STATE;
      this.enqueuedTimestamp = paramLong;
      this.hiPriCountWhenCreated = paramInt1;
      this.lowPriCountWhenCreated = paramInt2;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\PriorityNetworkFetcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */