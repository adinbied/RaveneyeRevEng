package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Objects.ToStringHelper;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.time.AwakeTimeSinceBootClock;
import com.facebook.datasource.DataSource;
import com.facebook.drawable.base.DrawableWithCaches;
import com.facebook.drawee.backends.pipeline.debug.DebugOverlayImageOriginColor;
import com.facebook.drawee.backends.pipeline.debug.DebugOverlayImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.ForwardingImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.ImageOriginRequestListener;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.drawee.backends.pipeline.info.ImagePerfDataListener;
import com.facebook.drawee.backends.pipeline.info.ImagePerfMonitor;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
import com.facebook.drawee.debug.listener.ImageLoadingTimeControllerListener;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.fresco.ui.common.MultiUriHelper;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public class PipelineDraweeController
  extends AbstractDraweeController<CloseableReference<CloseableImage>, ImageInfo>
{
  private static final Class<?> TAG = PipelineDraweeController.class;
  private CacheKey mCacheKey;
  @Nullable
  private ImmutableList<DrawableFactory> mCustomDrawableFactories;
  private Supplier<DataSource<CloseableReference<CloseableImage>>> mDataSourceSupplier;
  private DebugOverlayImageOriginListener mDebugOverlayImageOriginListener;
  private final DrawableFactory mDefaultDrawableFactory;
  private boolean mDrawDebugOverlay;
  @Nullable
  private ImageRequest[] mFirstAvailableImageRequests;
  @Nullable
  private final ImmutableList<DrawableFactory> mGlobalDrawableFactories;
  @Nullable
  private ImageOriginListener mImageOriginListener;
  @Nullable
  private ImagePerfMonitor mImagePerfMonitor;
  @Nullable
  private ImageRequest mImageRequest;
  @Nullable
  private ImageRequest mLowResImageRequest;
  @Nullable
  private final MemoryCache<CacheKey, CloseableImage> mMemoryCache;
  @Nullable
  private Set<RequestListener> mRequestListeners;
  private final Resources mResources;
  
  public PipelineDraweeController(Resources paramResources, DeferredReleaser paramDeferredReleaser, DrawableFactory paramDrawableFactory, Executor paramExecutor, @Nullable MemoryCache<CacheKey, CloseableImage> paramMemoryCache, @Nullable ImmutableList<DrawableFactory> paramImmutableList)
  {
    super(paramDeferredReleaser, paramExecutor, null, null);
    this.mResources = paramResources;
    this.mDefaultDrawableFactory = new DefaultDrawableFactory(paramResources, paramDrawableFactory);
    this.mGlobalDrawableFactories = paramImmutableList;
    this.mMemoryCache = paramMemoryCache;
  }
  
  private void init(Supplier<DataSource<CloseableReference<CloseableImage>>> paramSupplier)
  {
    this.mDataSourceSupplier = paramSupplier;
    maybeUpdateDebugOverlay(null);
  }
  
  @Nullable
  private Drawable maybeCreateDrawableFromFactories(@Nullable ImmutableList<DrawableFactory> paramImmutableList, CloseableImage paramCloseableImage)
  {
    if (paramImmutableList == null) {
      return null;
    }
    paramImmutableList = paramImmutableList.iterator();
    while (paramImmutableList.hasNext())
    {
      Object localObject = (DrawableFactory)paramImmutableList.next();
      if (((DrawableFactory)localObject).supportsImageType(paramCloseableImage))
      {
        localObject = ((DrawableFactory)localObject).createDrawable(paramCloseableImage);
        if (localObject != null) {
          return (Drawable)localObject;
        }
      }
    }
    return null;
  }
  
  private void maybeUpdateDebugOverlay(@Nullable CloseableImage paramCloseableImage)
  {
    if (!this.mDrawDebugOverlay) {
      return;
    }
    if (getControllerOverlay() == null)
    {
      DebugControllerOverlayDrawable localDebugControllerOverlayDrawable = new DebugControllerOverlayDrawable();
      ImageLoadingTimeControllerListener localImageLoadingTimeControllerListener = new ImageLoadingTimeControllerListener(localDebugControllerOverlayDrawable);
      this.mDebugOverlayImageOriginListener = new DebugOverlayImageOriginListener();
      addControllerListener(localImageLoadingTimeControllerListener);
      setControllerOverlay(localDebugControllerOverlayDrawable);
    }
    if (this.mImageOriginListener == null) {
      addImageOriginListener(this.mDebugOverlayImageOriginListener);
    }
    if ((getControllerOverlay() instanceof DebugControllerOverlayDrawable)) {
      updateDebugOverlay(paramCloseableImage, (DebugControllerOverlayDrawable)getControllerOverlay());
    }
  }
  
  public void addImageOriginListener(ImageOriginListener paramImageOriginListener)
  {
    try
    {
      if ((this.mImageOriginListener instanceof ForwardingImageOriginListener)) {
        ((ForwardingImageOriginListener)this.mImageOriginListener).addImageOriginListener(paramImageOriginListener);
      } else if (this.mImageOriginListener != null) {
        this.mImageOriginListener = new ForwardingImageOriginListener(new ImageOriginListener[] { this.mImageOriginListener, paramImageOriginListener });
      } else {
        this.mImageOriginListener = paramImageOriginListener;
      }
      return;
    }
    finally {}
  }
  
  public void addRequestListener(RequestListener paramRequestListener)
  {
    try
    {
      if (this.mRequestListeners == null) {
        this.mRequestListeners = new HashSet();
      }
      this.mRequestListeners.add(paramRequestListener);
      return;
    }
    finally {}
  }
  
  protected void clearImageOriginListeners()
  {
    try
    {
      this.mImageOriginListener = null;
      return;
    }
    finally {}
  }
  
  protected Drawable createDrawable(CloseableReference<CloseableImage> paramCloseableReference)
  {
    try
    {
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.beginSection("PipelineDraweeController#createDrawable");
      }
      Preconditions.checkState(CloseableReference.isValid(paramCloseableReference));
      paramCloseableReference = (CloseableImage)paramCloseableReference.get();
      maybeUpdateDebugOverlay(paramCloseableReference);
      Object localObject = maybeCreateDrawableFromFactories(this.mCustomDrawableFactories, paramCloseableReference);
      if (localObject != null) {
        return (Drawable)localObject;
      }
      localObject = maybeCreateDrawableFromFactories(this.mGlobalDrawableFactories, paramCloseableReference);
      if (localObject != null) {
        return (Drawable)localObject;
      }
      localObject = this.mDefaultDrawableFactory.createDrawable(paramCloseableReference);
      if (localObject != null) {
        return (Drawable)localObject;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unrecognized image class: ");
      ((StringBuilder)localObject).append(paramCloseableReference);
      throw new UnsupportedOperationException(((StringBuilder)localObject).toString());
    }
    finally
    {
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.endSection();
      }
    }
  }
  
  protected CacheKey getCacheKey()
  {
    return this.mCacheKey;
  }
  
  @Nullable
  protected CloseableReference<CloseableImage> getCachedImage()
  {
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.beginSection("PipelineDraweeController#getCachedImage");
    }
    try
    {
      if ((this.mMemoryCache != null) && (this.mCacheKey != null))
      {
        CloseableReference localCloseableReference = this.mMemoryCache.get(this.mCacheKey);
        if ((localCloseableReference != null) && (!((CloseableImage)localCloseableReference.get()).getQualityInfo().isOfFullQuality()))
        {
          localCloseableReference.close();
          return null;
        }
        return localCloseableReference;
      }
      return null;
    }
    finally
    {
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.endSection();
      }
    }
  }
  
  protected DataSource<CloseableReference<CloseableImage>> getDataSource()
  {
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.beginSection("PipelineDraweeController#getDataSource");
    }
    if (FLog.isLoggable(2)) {
      FLog.v(TAG, "controller %x: getDataSource", Integer.valueOf(System.identityHashCode(this)));
    }
    DataSource localDataSource = (DataSource)this.mDataSourceSupplier.get();
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.endSection();
    }
    return localDataSource;
  }
  
  protected Supplier<DataSource<CloseableReference<CloseableImage>>> getDataSourceSupplier()
  {
    return this.mDataSourceSupplier;
  }
  
  protected int getImageHash(@Nullable CloseableReference<CloseableImage> paramCloseableReference)
  {
    if (paramCloseableReference != null) {
      return paramCloseableReference.getValueHash();
    }
    return 0;
  }
  
  protected ImageInfo getImageInfo(CloseableReference<CloseableImage> paramCloseableReference)
  {
    Preconditions.checkState(CloseableReference.isValid(paramCloseableReference));
    return (ImageInfo)paramCloseableReference.get();
  }
  
  @Nullable
  protected Uri getMainUri()
  {
    return MultiUriHelper.getMainUri(this.mImageRequest, this.mLowResImageRequest, this.mFirstAvailableImageRequests, ImageRequest.REQUEST_TO_URI_FN);
  }
  
  @Nullable
  public RequestListener getRequestListener()
  {
    ImageOriginRequestListener localImageOriginRequestListener = null;
    try
    {
      if (this.mImageOriginListener != null) {
        localImageOriginRequestListener = new ImageOriginRequestListener(getId(), this.mImageOriginListener);
      }
      if (this.mRequestListeners != null)
      {
        ForwardingRequestListener localForwardingRequestListener = new ForwardingRequestListener(this.mRequestListeners);
        if (localImageOriginRequestListener != null) {
          localForwardingRequestListener.addRequestListener(localImageOriginRequestListener);
        }
        return localForwardingRequestListener;
      }
      return localImageOriginRequestListener;
    }
    finally {}
  }
  
  protected Resources getResources()
  {
    return this.mResources;
  }
  
  public void initialize(Supplier<DataSource<CloseableReference<CloseableImage>>> paramSupplier, String paramString, CacheKey paramCacheKey, Object paramObject, @Nullable ImmutableList<DrawableFactory> paramImmutableList, @Nullable ImageOriginListener paramImageOriginListener)
  {
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.beginSection("PipelineDraweeController#initialize");
    }
    super.initialize(paramString, paramObject);
    init(paramSupplier);
    this.mCacheKey = paramCacheKey;
    setCustomDrawableFactories(paramImmutableList);
    clearImageOriginListeners();
    maybeUpdateDebugOverlay(null);
    addImageOriginListener(paramImageOriginListener);
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.endSection();
    }
  }
  
  protected void initializePerformanceMonitoring(@Nullable ImagePerfDataListener paramImagePerfDataListener, AbstractDraweeControllerBuilder<PipelineDraweeControllerBuilder, ImageRequest, CloseableReference<CloseableImage>, ImageInfo> paramAbstractDraweeControllerBuilder, Supplier<Boolean> paramSupplier)
  {
    try
    {
      if (this.mImagePerfMonitor != null) {
        this.mImagePerfMonitor.reset();
      }
      if (paramImagePerfDataListener != null)
      {
        if (this.mImagePerfMonitor == null) {
          this.mImagePerfMonitor = new ImagePerfMonitor(AwakeTimeSinceBootClock.get(), this, paramSupplier);
        }
        this.mImagePerfMonitor.addImagePerfDataListener(paramImagePerfDataListener);
        this.mImagePerfMonitor.setEnabled(true);
        this.mImagePerfMonitor.updateImageRequestData(paramAbstractDraweeControllerBuilder);
      }
      this.mImageRequest = ((ImageRequest)paramAbstractDraweeControllerBuilder.getImageRequest());
      this.mFirstAvailableImageRequests = ((ImageRequest[])paramAbstractDraweeControllerBuilder.getFirstAvailableImageRequests());
      this.mLowResImageRequest = ((ImageRequest)paramAbstractDraweeControllerBuilder.getLowResImageRequest());
      return;
    }
    finally {}
  }
  
  public boolean isSameImageRequest(@Nullable DraweeController paramDraweeController)
  {
    CacheKey localCacheKey = this.mCacheKey;
    if ((localCacheKey != null) && ((paramDraweeController instanceof PipelineDraweeController))) {
      return Objects.equal(localCacheKey, ((PipelineDraweeController)paramDraweeController).getCacheKey());
    }
    return false;
  }
  
  @Nullable
  public Map<String, Object> obtainExtrasFromImage(ImageInfo paramImageInfo)
  {
    if (paramImageInfo == null) {
      return null;
    }
    return paramImageInfo.getExtras();
  }
  
  protected void onImageLoadedFromCacheImmediately(String paramString, CloseableReference<CloseableImage> paramCloseableReference)
  {
    super.onImageLoadedFromCacheImmediately(paramString, paramCloseableReference);
    try
    {
      if (this.mImageOriginListener != null) {
        this.mImageOriginListener.onImageLoaded(paramString, 6, true, "PipelineDraweeController");
      }
      return;
    }
    finally {}
  }
  
  protected void releaseDrawable(@Nullable Drawable paramDrawable)
  {
    if ((paramDrawable instanceof DrawableWithCaches)) {
      ((DrawableWithCaches)paramDrawable).dropCaches();
    }
  }
  
  protected void releaseImage(@Nullable CloseableReference<CloseableImage> paramCloseableReference)
  {
    CloseableReference.closeSafely(paramCloseableReference);
  }
  
  public void removeImageOriginListener(ImageOriginListener paramImageOriginListener)
  {
    try
    {
      if ((this.mImageOriginListener instanceof ForwardingImageOriginListener))
      {
        ((ForwardingImageOriginListener)this.mImageOriginListener).removeImageOriginListener(paramImageOriginListener);
        return;
      }
      if (this.mImageOriginListener == paramImageOriginListener) {
        this.mImageOriginListener = null;
      }
      return;
    }
    finally {}
  }
  
  public void removeRequestListener(RequestListener paramRequestListener)
  {
    try
    {
      Set localSet = this.mRequestListeners;
      if (localSet == null) {
        return;
      }
      this.mRequestListeners.remove(paramRequestListener);
      return;
    }
    finally {}
  }
  
  public void setCustomDrawableFactories(@Nullable ImmutableList<DrawableFactory> paramImmutableList)
  {
    this.mCustomDrawableFactories = paramImmutableList;
  }
  
  public void setDrawDebugOverlay(boolean paramBoolean)
  {
    this.mDrawDebugOverlay = paramBoolean;
  }
  
  public void setHierarchy(@Nullable DraweeHierarchy paramDraweeHierarchy)
  {
    super.setHierarchy(paramDraweeHierarchy);
    maybeUpdateDebugOverlay(null);
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).add("super", super.toString()).add("dataSourceSupplier", this.mDataSourceSupplier).toString();
  }
  
  protected void updateDebugOverlay(@Nullable CloseableImage paramCloseableImage, DebugControllerOverlayDrawable paramDebugControllerOverlayDrawable)
  {
    paramDebugControllerOverlayDrawable.setControllerId(getId());
    Object localObject3 = getHierarchy();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ScalingUtils.getActiveScaleTypeDrawable(((DraweeHierarchy)localObject3).getTopLevelDrawable());
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((ScaleTypeDrawable)localObject3).getScaleType();
      }
    }
    paramDebugControllerOverlayDrawable.setScaleType((ScalingUtils.ScaleType)localObject1);
    int i = this.mDebugOverlayImageOriginListener.getImageOrigin();
    paramDebugControllerOverlayDrawable.setOrigin(ImageOriginUtils.toString(i), DebugOverlayImageOriginColor.getImageOriginColor(i));
    if (paramCloseableImage != null)
    {
      paramDebugControllerOverlayDrawable.setDimensions(paramCloseableImage.getWidth(), paramCloseableImage.getHeight());
      paramDebugControllerOverlayDrawable.setImageSize(paramCloseableImage.getSizeInBytes());
      return;
    }
    paramDebugControllerOverlayDrawable.reset();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\backends\pipeline\PipelineDraweeController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */