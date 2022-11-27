package com.facebook.drawee.controller;

import android.content.Context;
import android.graphics.drawable.Animatable;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Objects.ToStringHelper;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.datasource.FirstAvailableDataSourceSupplier;
import com.facebook.datasource.IncreasingQualityDataSourceSupplier;
import com.facebook.drawee.components.RetryManager;
import com.facebook.drawee.gestures.GestureDetector;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder;
import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.fresco.ui.common.LoggingListener;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;

public abstract class AbstractDraweeControllerBuilder<BUILDER extends AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO>
  implements SimpleDraweeControllerBuilder
{
  private static final NullPointerException NO_REQUEST_EXCEPTION = new NullPointerException("No image request was specified!");
  private static final ControllerListener<Object> sAutoPlayAnimationsListener = new BaseControllerListener()
  {
    public void onFinalImageSet(String paramAnonymousString, @Nullable Object paramAnonymousObject, @Nullable Animatable paramAnonymousAnimatable)
    {
      if (paramAnonymousAnimatable != null) {
        paramAnonymousAnimatable.start();
      }
    }
  };
  private static final AtomicLong sIdCounter = new AtomicLong();
  private boolean mAutoPlayAnimations;
  private final Set<ControllerListener> mBoundControllerListeners;
  private final Set<ControllerListener2> mBoundControllerListeners2;
  @Nullable
  private Object mCallerContext;
  private String mContentDescription;
  private final Context mContext;
  @Nullable
  private ControllerListener<? super INFO> mControllerListener;
  @Nullable
  private ControllerViewportVisibilityListener mControllerViewportVisibilityListener;
  @Nullable
  private Supplier<DataSource<IMAGE>> mDataSourceSupplier;
  @Nullable
  private REQUEST mImageRequest;
  @Nullable
  private LoggingListener mLoggingListener;
  @Nullable
  private REQUEST mLowResImageRequest;
  @Nullable
  private REQUEST[] mMultiImageRequests;
  @Nullable
  private DraweeController mOldController;
  private boolean mRetainImageOnFailure;
  private boolean mTapToRetryEnabled;
  private boolean mTryCacheOnlyFirst;
  
  protected AbstractDraweeControllerBuilder(Context paramContext, Set<ControllerListener> paramSet, Set<ControllerListener2> paramSet1)
  {
    this.mContext = paramContext;
    this.mBoundControllerListeners = paramSet;
    this.mBoundControllerListeners2 = paramSet1;
    init();
  }
  
  protected static String generateUniqueControllerId()
  {
    return String.valueOf(sIdCounter.getAndIncrement());
  }
  
  private void init()
  {
    this.mCallerContext = null;
    this.mImageRequest = null;
    this.mLowResImageRequest = null;
    this.mMultiImageRequests = null;
    this.mTryCacheOnlyFirst = true;
    this.mControllerListener = null;
    this.mLoggingListener = null;
    this.mControllerViewportVisibilityListener = null;
    this.mTapToRetryEnabled = false;
    this.mAutoPlayAnimations = false;
    this.mOldController = null;
    this.mContentDescription = null;
  }
  
  public AbstractDraweeController build()
  {
    validate();
    if ((this.mImageRequest == null) && (this.mMultiImageRequests == null))
    {
      Object localObject = this.mLowResImageRequest;
      if (localObject != null)
      {
        this.mImageRequest = localObject;
        this.mLowResImageRequest = null;
      }
    }
    return buildController();
  }
  
  protected AbstractDraweeController buildController()
  {
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.beginSection("AbstractDraweeControllerBuilder#buildController");
    }
    AbstractDraweeController localAbstractDraweeController = obtainController();
    localAbstractDraweeController.setRetainImageOnFailure(getRetainImageOnFailure());
    localAbstractDraweeController.setContentDescription(getContentDescription());
    localAbstractDraweeController.setControllerViewportVisibilityListener(getControllerViewportVisibilityListener());
    maybeBuildAndSetRetryManager(localAbstractDraweeController);
    maybeAttachListeners(localAbstractDraweeController);
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.endSection();
    }
    return localAbstractDraweeController;
  }
  
  public boolean getAutoPlayAnimations()
  {
    return this.mAutoPlayAnimations;
  }
  
  @Nullable
  public Object getCallerContext()
  {
    return this.mCallerContext;
  }
  
  @Nullable
  public String getContentDescription()
  {
    return this.mContentDescription;
  }
  
  protected Context getContext()
  {
    return this.mContext;
  }
  
  @Nullable
  public ControllerListener<? super INFO> getControllerListener()
  {
    return this.mControllerListener;
  }
  
  @Nullable
  public ControllerViewportVisibilityListener getControllerViewportVisibilityListener()
  {
    return this.mControllerViewportVisibilityListener;
  }
  
  protected abstract DataSource<IMAGE> getDataSourceForRequest(DraweeController paramDraweeController, String paramString, REQUEST paramREQUEST, Object paramObject, CacheLevel paramCacheLevel);
  
  @Nullable
  public Supplier<DataSource<IMAGE>> getDataSourceSupplier()
  {
    return this.mDataSourceSupplier;
  }
  
  protected Supplier<DataSource<IMAGE>> getDataSourceSupplierForRequest(DraweeController paramDraweeController, String paramString, REQUEST paramREQUEST)
  {
    return getDataSourceSupplierForRequest(paramDraweeController, paramString, paramREQUEST, CacheLevel.FULL_FETCH);
  }
  
  protected Supplier<DataSource<IMAGE>> getDataSourceSupplierForRequest(final DraweeController paramDraweeController, final String paramString, final REQUEST paramREQUEST, final CacheLevel paramCacheLevel)
  {
    new Supplier()
    {
      public DataSource<IMAGE> get()
      {
        return AbstractDraweeControllerBuilder.this.getDataSourceForRequest(paramDraweeController, paramString, paramREQUEST, this.val$callerContext, paramCacheLevel);
      }
      
      public String toString()
      {
        return Objects.toStringHelper(this).add("request", paramREQUEST.toString()).toString();
      }
    };
  }
  
  protected Supplier<DataSource<IMAGE>> getFirstAvailableDataSourceSupplier(DraweeController paramDraweeController, String paramString, REQUEST[] paramArrayOfREQUEST, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfREQUEST.length * 2);
    int k = 0;
    int j = k;
    if (paramBoolean)
    {
      int i = 0;
      for (;;)
      {
        j = k;
        if (i >= paramArrayOfREQUEST.length) {
          break;
        }
        localArrayList.add(getDataSourceSupplierForRequest(paramDraweeController, paramString, paramArrayOfREQUEST[i], CacheLevel.BITMAP_MEMORY_CACHE));
        i += 1;
      }
    }
    while (j < paramArrayOfREQUEST.length)
    {
      localArrayList.add(getDataSourceSupplierForRequest(paramDraweeController, paramString, paramArrayOfREQUEST[j]));
      j += 1;
    }
    return FirstAvailableDataSourceSupplier.create(localArrayList);
  }
  
  @Nullable
  public REQUEST[] getFirstAvailableImageRequests()
  {
    return this.mMultiImageRequests;
  }
  
  @Nullable
  public REQUEST getImageRequest()
  {
    return (REQUEST)this.mImageRequest;
  }
  
  @Nullable
  public LoggingListener getLoggingListener()
  {
    return this.mLoggingListener;
  }
  
  @Nullable
  public REQUEST getLowResImageRequest()
  {
    return (REQUEST)this.mLowResImageRequest;
  }
  
  @Nullable
  public DraweeController getOldController()
  {
    return this.mOldController;
  }
  
  public boolean getRetainImageOnFailure()
  {
    return this.mRetainImageOnFailure;
  }
  
  public boolean getTapToRetryEnabled()
  {
    return this.mTapToRetryEnabled;
  }
  
  protected final BUILDER getThis()
  {
    return this;
  }
  
  protected void maybeAttachListeners(AbstractDraweeController paramAbstractDraweeController)
  {
    Object localObject = this.mBoundControllerListeners;
    if (localObject != null)
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramAbstractDraweeController.addControllerListener((ControllerListener)((Iterator)localObject).next());
      }
    }
    localObject = this.mBoundControllerListeners2;
    if (localObject != null)
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramAbstractDraweeController.addControllerListener2((ControllerListener2)((Iterator)localObject).next());
      }
    }
    localObject = this.mControllerListener;
    if (localObject != null) {
      paramAbstractDraweeController.addControllerListener((ControllerListener)localObject);
    }
    if (this.mAutoPlayAnimations) {
      paramAbstractDraweeController.addControllerListener(sAutoPlayAnimationsListener);
    }
  }
  
  protected void maybeBuildAndSetGestureDetector(AbstractDraweeController paramAbstractDraweeController)
  {
    if (paramAbstractDraweeController.getGestureDetector() == null) {
      paramAbstractDraweeController.setGestureDetector(GestureDetector.newInstance(this.mContext));
    }
  }
  
  protected void maybeBuildAndSetRetryManager(AbstractDraweeController paramAbstractDraweeController)
  {
    if (!this.mTapToRetryEnabled) {
      return;
    }
    paramAbstractDraweeController.getRetryManager().setTapToRetryEnabled(this.mTapToRetryEnabled);
    maybeBuildAndSetGestureDetector(paramAbstractDraweeController);
  }
  
  protected abstract AbstractDraweeController obtainController();
  
  protected Supplier<DataSource<IMAGE>> obtainDataSourceSupplier(DraweeController paramDraweeController, String paramString)
  {
    Supplier localSupplier = this.mDataSourceSupplier;
    if (localSupplier != null) {
      return localSupplier;
    }
    localSupplier = null;
    Object localObject = this.mImageRequest;
    if (localObject != null)
    {
      localSupplier = getDataSourceSupplierForRequest(paramDraweeController, paramString, localObject);
    }
    else
    {
      localObject = this.mMultiImageRequests;
      if (localObject != null) {
        localSupplier = getFirstAvailableDataSourceSupplier(paramDraweeController, paramString, (Object[])localObject, this.mTryCacheOnlyFirst);
      }
    }
    localObject = localSupplier;
    if (localSupplier != null)
    {
      localObject = localSupplier;
      if (this.mLowResImageRequest != null)
      {
        localObject = new ArrayList(2);
        ((List)localObject).add(localSupplier);
        ((List)localObject).add(getDataSourceSupplierForRequest(paramDraweeController, paramString, this.mLowResImageRequest));
        localObject = IncreasingQualityDataSourceSupplier.create((List)localObject, false);
      }
    }
    paramDraweeController = (DraweeController)localObject;
    if (localObject == null) {
      paramDraweeController = DataSources.getFailedDataSourceSupplier(NO_REQUEST_EXCEPTION);
    }
    return paramDraweeController;
  }
  
  public BUILDER reset()
  {
    init();
    return getThis();
  }
  
  public BUILDER setAutoPlayAnimations(boolean paramBoolean)
  {
    this.mAutoPlayAnimations = paramBoolean;
    return getThis();
  }
  
  public BUILDER setCallerContext(Object paramObject)
  {
    this.mCallerContext = paramObject;
    return getThis();
  }
  
  public BUILDER setContentDescription(String paramString)
  {
    this.mContentDescription = paramString;
    return getThis();
  }
  
  public BUILDER setControllerListener(@Nullable ControllerListener<? super INFO> paramControllerListener)
  {
    this.mControllerListener = paramControllerListener;
    return getThis();
  }
  
  public BUILDER setControllerViewportVisibilityListener(@Nullable ControllerViewportVisibilityListener paramControllerViewportVisibilityListener)
  {
    this.mControllerViewportVisibilityListener = paramControllerViewportVisibilityListener;
    return getThis();
  }
  
  public BUILDER setDataSourceSupplier(@Nullable Supplier<DataSource<IMAGE>> paramSupplier)
  {
    this.mDataSourceSupplier = paramSupplier;
    return getThis();
  }
  
  public BUILDER setFirstAvailableImageRequests(REQUEST[] paramArrayOfREQUEST)
  {
    return setFirstAvailableImageRequests(paramArrayOfREQUEST, true);
  }
  
  public BUILDER setFirstAvailableImageRequests(REQUEST[] paramArrayOfREQUEST, boolean paramBoolean)
  {
    boolean bool;
    if ((paramArrayOfREQUEST != null) && (paramArrayOfREQUEST.length <= 0)) {
      bool = false;
    } else {
      bool = true;
    }
    Preconditions.checkArgument(bool, "No requests specified!");
    this.mMultiImageRequests = paramArrayOfREQUEST;
    this.mTryCacheOnlyFirst = paramBoolean;
    return getThis();
  }
  
  public BUILDER setImageRequest(REQUEST paramREQUEST)
  {
    this.mImageRequest = paramREQUEST;
    return getThis();
  }
  
  public BUILDER setLoggingListener(@Nullable LoggingListener paramLoggingListener)
  {
    this.mLoggingListener = paramLoggingListener;
    return getThis();
  }
  
  public BUILDER setLowResImageRequest(REQUEST paramREQUEST)
  {
    this.mLowResImageRequest = paramREQUEST;
    return getThis();
  }
  
  public BUILDER setOldController(@Nullable DraweeController paramDraweeController)
  {
    this.mOldController = paramDraweeController;
    return getThis();
  }
  
  public BUILDER setRetainImageOnFailure(boolean paramBoolean)
  {
    this.mRetainImageOnFailure = paramBoolean;
    return getThis();
  }
  
  public BUILDER setTapToRetryEnabled(boolean paramBoolean)
  {
    this.mTapToRetryEnabled = paramBoolean;
    return getThis();
  }
  
  protected void validate()
  {
    Object[] arrayOfObject = this.mMultiImageRequests;
    boolean bool2 = false;
    boolean bool1;
    if ((arrayOfObject != null) && (this.mImageRequest != null)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    Preconditions.checkState(bool1, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
    if (this.mDataSourceSupplier != null)
    {
      bool1 = bool2;
      if (this.mMultiImageRequests == null)
      {
        bool1 = bool2;
        if (this.mImageRequest == null)
        {
          bool1 = bool2;
          if (this.mLowResImageRequest != null) {}
        }
      }
    }
    else
    {
      bool1 = true;
    }
    Preconditions.checkState(bool1, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
  }
  
  public static enum CacheLevel
  {
    static
    {
      DISK_CACHE = new CacheLevel("DISK_CACHE", 1);
      CacheLevel localCacheLevel = new CacheLevel("BITMAP_MEMORY_CACHE", 2);
      BITMAP_MEMORY_CACHE = localCacheLevel;
      $VALUES = new CacheLevel[] { FULL_FETCH, DISK_CACHE, localCacheLevel };
    }
    
    private CacheLevel() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\controller\AbstractDraweeControllerBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */