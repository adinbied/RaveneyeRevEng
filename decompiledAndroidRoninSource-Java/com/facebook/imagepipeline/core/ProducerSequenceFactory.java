package com.facebook.imagepipeline.core;

import android.content.ContentResolver;
import android.net.Uri;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.media.MediaUtils;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.DataFetchProducer;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.RemoveImageTransformMetaDataProducer;
import com.facebook.imagepipeline.producers.SwallowResultProducer;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.producers.ThumbnailProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import java.util.HashMap;
import java.util.Map;

public class ProducerSequenceFactory
{
  Producer<EncodedImage> mBackgroundLocalContentUriFetchToEncodedMemorySequence;
  Producer<EncodedImage> mBackgroundLocalFileFetchToEncodedMemorySequence;
  Producer<EncodedImage> mBackgroundNetworkFetchToEncodedMemorySequence;
  Map<Producer<CloseableReference<CloseableImage>>, Producer<CloseableReference<CloseableImage>>> mBitmapPrepareSequences;
  Map<Producer<CloseableReference<CloseableImage>>, Producer<Void>> mCloseableImagePrefetchSequences;
  private Producer<EncodedImage> mCommonNetworkFetchToEncodedMemorySequence;
  private final ContentResolver mContentResolver;
  Producer<CloseableReference<CloseableImage>> mDataFetchSequence;
  private final boolean mDiskCacheEnabled;
  private final boolean mDownsampleEnabled;
  private final ImageTranscoderFactory mImageTranscoderFactory;
  private final boolean mIsDiskCacheProbingEnabled;
  private final boolean mIsEncodedMemoryCacheProbingEnabled;
  Producer<CloseableReference<CloseableImage>> mLocalAssetFetchSequence;
  Producer<CloseableReference<PooledByteBuffer>> mLocalContentUriEncodedImageProducerSequence;
  Producer<CloseableReference<CloseableImage>> mLocalContentUriFetchSequence;
  Producer<CloseableReference<PooledByteBuffer>> mLocalFileEncodedImageProducerSequence;
  Producer<Void> mLocalFileFetchToEncodedMemoryPrefetchSequence;
  Producer<CloseableReference<CloseableImage>> mLocalImageFileFetchSequence;
  Producer<CloseableReference<CloseableImage>> mLocalResourceFetchSequence;
  Producer<CloseableReference<CloseableImage>> mLocalVideoFileFetchSequence;
  Producer<CloseableReference<PooledByteBuffer>> mNetworkEncodedImageProducerSequence;
  Producer<CloseableReference<CloseableImage>> mNetworkFetchSequence;
  Producer<Void> mNetworkFetchToEncodedMemoryPrefetchSequence;
  private final NetworkFetcher mNetworkFetcher;
  private final boolean mPartialImageCachingEnabled;
  Map<Producer<CloseableReference<CloseableImage>>, Producer<CloseableReference<CloseableImage>>> mPostprocessorSequences;
  private final ProducerFactory mProducerFactory;
  Producer<CloseableReference<CloseableImage>> mQualifiedResourceFetchSequence;
  private final boolean mResizeAndRotateEnabledForNetwork;
  private final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;
  private final boolean mUseBitmapPrepareToDraw;
  private final boolean mWebpSupportEnabled;
  
  public ProducerSequenceFactory(ContentResolver paramContentResolver, ProducerFactory paramProducerFactory, NetworkFetcher paramNetworkFetcher, boolean paramBoolean1, boolean paramBoolean2, ThreadHandoffProducerQueue paramThreadHandoffProducerQueue, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, ImageTranscoderFactory paramImageTranscoderFactory, boolean paramBoolean7, boolean paramBoolean8)
  {
    this.mContentResolver = paramContentResolver;
    this.mProducerFactory = paramProducerFactory;
    this.mNetworkFetcher = paramNetworkFetcher;
    this.mResizeAndRotateEnabledForNetwork = paramBoolean1;
    this.mWebpSupportEnabled = paramBoolean2;
    this.mPostprocessorSequences = new HashMap();
    this.mCloseableImagePrefetchSequences = new HashMap();
    this.mBitmapPrepareSequences = new HashMap();
    this.mThreadHandoffProducerQueue = paramThreadHandoffProducerQueue;
    this.mDownsampleEnabled = paramBoolean3;
    this.mUseBitmapPrepareToDraw = paramBoolean4;
    this.mPartialImageCachingEnabled = paramBoolean5;
    this.mDiskCacheEnabled = paramBoolean6;
    this.mImageTranscoderFactory = paramImageTranscoderFactory;
    this.mIsEncodedMemoryCacheProbingEnabled = paramBoolean7;
    this.mIsDiskCacheProbingEnabled = paramBoolean8;
  }
  
  private Producer<EncodedImage> getBackgroundLocalContentUriFetchToEncodeMemorySequence()
  {
    try
    {
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundLocalContentUriFetchToEncodeMemorySequence");
      }
      if (this.mBackgroundLocalContentUriFetchToEncodedMemorySequence == null)
      {
        if (FrescoSystrace.isTracing()) {
          FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundLocalContentUriFetchToEncodeMemorySequence:init");
        }
        localProducer = newEncodedCacheMultiplexToTranscodeSequence(this.mProducerFactory.newLocalContentUriFetchProducer());
        this.mBackgroundLocalContentUriFetchToEncodedMemorySequence = this.mProducerFactory.newBackgroundThreadHandoffProducer(localProducer, this.mThreadHandoffProducerQueue);
        if (FrescoSystrace.isTracing()) {
          FrescoSystrace.endSection();
        }
      }
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.endSection();
      }
      Producer localProducer = this.mBackgroundLocalContentUriFetchToEncodedMemorySequence;
      return localProducer;
    }
    finally {}
  }
  
  private Producer<EncodedImage> getBackgroundLocalFileFetchToEncodeMemorySequence()
  {
    try
    {
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundLocalFileFetchToEncodeMemorySequence");
      }
      if (this.mBackgroundLocalFileFetchToEncodedMemorySequence == null)
      {
        if (FrescoSystrace.isTracing()) {
          FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundLocalFileFetchToEncodeMemorySequence:init");
        }
        localProducer = newEncodedCacheMultiplexToTranscodeSequence(this.mProducerFactory.newLocalFileFetchProducer());
        this.mBackgroundLocalFileFetchToEncodedMemorySequence = this.mProducerFactory.newBackgroundThreadHandoffProducer(localProducer, this.mThreadHandoffProducerQueue);
        if (FrescoSystrace.isTracing()) {
          FrescoSystrace.endSection();
        }
      }
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.endSection();
      }
      Producer localProducer = this.mBackgroundLocalFileFetchToEncodedMemorySequence;
      return localProducer;
    }
    finally {}
  }
  
  private Producer<EncodedImage> getBackgroundNetworkFetchToEncodedMemorySequence()
  {
    try
    {
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundNetworkFetchToEncodedMemorySequence");
      }
      if (this.mBackgroundNetworkFetchToEncodedMemorySequence == null)
      {
        if (FrescoSystrace.isTracing()) {
          FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundNetworkFetchToEncodedMemorySequence:init");
        }
        this.mBackgroundNetworkFetchToEncodedMemorySequence = this.mProducerFactory.newBackgroundThreadHandoffProducer(getCommonNetworkFetchToEncodedMemorySequence(), this.mThreadHandoffProducerQueue);
        if (FrescoSystrace.isTracing()) {
          FrescoSystrace.endSection();
        }
      }
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.endSection();
      }
      Producer localProducer = this.mBackgroundNetworkFetchToEncodedMemorySequence;
      return localProducer;
    }
    finally {}
  }
  
  private Producer<CloseableReference<CloseableImage>> getBasicDecodedImageSequence(ImageRequest paramImageRequest)
  {
    for (;;)
    {
      try
      {
        if (FrescoSystrace.isTracing()) {
          FrescoSystrace.beginSection("ProducerSequenceFactory#getBasicDecodedImageSequence");
        }
        Preconditions.checkNotNull(paramImageRequest);
        Uri localUri = paramImageRequest.getSourceUri();
        Preconditions.checkNotNull(localUri, "Uri is null.");
        int i = paramImageRequest.getSourceUriType();
        if (i != 0) {}
        switch (i)
        {
        case 8: 
          paramImageRequest = new StringBuilder();
          paramImageRequest.append("Unsupported uri scheme! Uri is: ");
          paramImageRequest.append(getShortenedUriString(localUri));
          throw new IllegalArgumentException(paramImageRequest.toString());
          paramImageRequest = getQualifiedResourceFetchSequence();
          return paramImageRequest;
        case 7: 
          paramImageRequest = getDataFetchSequence();
          return paramImageRequest;
        case 6: 
          paramImageRequest = getLocalResourceFetchSequence();
          return paramImageRequest;
        case 5: 
          paramImageRequest = getLocalAssetFetchSequence();
          return paramImageRequest;
        case 4: 
          if (MediaUtils.isVideo(this.mContentResolver.getType(localUri)))
          {
            paramImageRequest = getLocalVideoFileFetchSequence();
            return paramImageRequest;
          }
          paramImageRequest = getLocalContentUriFetchSequence();
          return paramImageRequest;
        case 3: 
          paramImageRequest = getLocalImageFileFetchSequence();
          return paramImageRequest;
        case 2: 
          paramImageRequest = getLocalVideoFileFetchSequence();
          return paramImageRequest;
          paramImageRequest = getNetworkFetchSequence();
          return paramImageRequest;
        }
      }
      finally
      {
        if (FrescoSystrace.isTracing()) {
          FrescoSystrace.endSection();
        }
      }
    }
  }
  
  private Producer<CloseableReference<CloseableImage>> getBitmapPrepareSequence(Producer<CloseableReference<CloseableImage>> paramProducer)
  {
    try
    {
      Producer localProducer = (Producer)this.mBitmapPrepareSequences.get(paramProducer);
      Object localObject = localProducer;
      if (localProducer == null)
      {
        localObject = this.mProducerFactory.newBitmapPrepareProducer(paramProducer);
        this.mBitmapPrepareSequences.put(paramProducer, localObject);
      }
      return (Producer<CloseableReference<CloseableImage>>)localObject;
    }
    finally {}
  }
  
  private Producer<EncodedImage> getCommonNetworkFetchToEncodedMemorySequence()
  {
    for (;;)
    {
      try
      {
        if (FrescoSystrace.isTracing()) {
          FrescoSystrace.beginSection("ProducerSequenceFactory#getCommonNetworkFetchToEncodedMemorySequence");
        }
        if (this.mCommonNetworkFetchToEncodedMemorySequence == null)
        {
          if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ProducerSequenceFactory#getCommonNetworkFetchToEncodedMemorySequence:init");
          }
          localObject1 = ProducerFactory.newAddImageTransformMetaDataProducer(newEncodedCacheMultiplexToTranscodeSequence(this.mProducerFactory.newNetworkFetchProducer(this.mNetworkFetcher)));
          this.mCommonNetworkFetchToEncodedMemorySequence = ((Producer)localObject1);
          ProducerFactory localProducerFactory = this.mProducerFactory;
          if ((!this.mResizeAndRotateEnabledForNetwork) || (this.mDownsampleEnabled)) {
            break label125;
          }
          bool = true;
          this.mCommonNetworkFetchToEncodedMemorySequence = localProducerFactory.newResizeAndRotateProducer((Producer)localObject1, bool, this.mImageTranscoderFactory);
          if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
          }
        }
        if (FrescoSystrace.isTracing()) {
          FrescoSystrace.endSection();
        }
        Object localObject1 = this.mCommonNetworkFetchToEncodedMemorySequence;
        return (Producer<EncodedImage>)localObject1;
      }
      finally {}
      label125:
      boolean bool = false;
    }
  }
  
  private Producer<CloseableReference<CloseableImage>> getDataFetchSequence()
  {
    try
    {
      if (this.mDataFetchSequence == null)
      {
        DataFetchProducer localDataFetchProducer = this.mProducerFactory.newDataFetchProducer();
        localObject1 = localDataFetchProducer;
        if (WebpSupportStatus.sIsWebpSupportRequired) {
          if (this.mWebpSupportEnabled)
          {
            localObject1 = localDataFetchProducer;
            if (WebpSupportStatus.sWebpBitmapFactory != null) {}
          }
          else
          {
            localObject1 = this.mProducerFactory.newWebpTranscodeProducer(localDataFetchProducer);
          }
        }
        localObject1 = ProducerFactory.newAddImageTransformMetaDataProducer((Producer)localObject1);
        this.mDataFetchSequence = newBitmapCacheGetToDecodeSequence(this.mProducerFactory.newResizeAndRotateProducer((Producer)localObject1, true, this.mImageTranscoderFactory));
      }
      Object localObject1 = this.mDataFetchSequence;
      return (Producer<CloseableReference<CloseableImage>>)localObject1;
    }
    finally {}
  }
  
  private Producer<Void> getDecodedImagePrefetchSequence(Producer<CloseableReference<CloseableImage>> paramProducer)
  {
    try
    {
      if (!this.mCloseableImagePrefetchSequences.containsKey(paramProducer))
      {
        SwallowResultProducer localSwallowResultProducer = ProducerFactory.newSwallowResultProducer(paramProducer);
        this.mCloseableImagePrefetchSequences.put(paramProducer, localSwallowResultProducer);
      }
      paramProducer = (Producer)this.mCloseableImagePrefetchSequences.get(paramProducer);
      return paramProducer;
    }
    finally {}
  }
  
  private Producer<CloseableReference<CloseableImage>> getLocalAssetFetchSequence()
  {
    try
    {
      if (this.mLocalAssetFetchSequence == null) {
        this.mLocalAssetFetchSequence = newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newLocalAssetFetchProducer());
      }
      Producer localProducer = this.mLocalAssetFetchSequence;
      return localProducer;
    }
    finally {}
  }
  
  private Producer<CloseableReference<CloseableImage>> getLocalContentUriFetchSequence()
  {
    try
    {
      if (this.mLocalContentUriFetchSequence == null) {
        this.mLocalContentUriFetchSequence = newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newLocalContentUriFetchProducer(), new ThumbnailProducer[] { this.mProducerFactory.newLocalContentUriThumbnailFetchProducer(), this.mProducerFactory.newLocalExifThumbnailProducer() });
      }
      Producer localProducer = this.mLocalContentUriFetchSequence;
      return localProducer;
    }
    finally {}
  }
  
  private Producer<Void> getLocalFileFetchToEncodedMemoryPrefetchSequence()
  {
    try
    {
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalFileFetchToEncodedMemoryPrefetchSequence");
      }
      if (this.mLocalFileFetchToEncodedMemoryPrefetchSequence == null)
      {
        if (FrescoSystrace.isTracing()) {
          FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalFileFetchToEncodedMemoryPrefetchSequence:init");
        }
        this.mLocalFileFetchToEncodedMemoryPrefetchSequence = ProducerFactory.newSwallowResultProducer(getBackgroundLocalFileFetchToEncodeMemorySequence());
        if (FrescoSystrace.isTracing()) {
          FrescoSystrace.endSection();
        }
      }
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.endSection();
      }
      Producer localProducer = this.mLocalFileFetchToEncodedMemoryPrefetchSequence;
      return localProducer;
    }
    finally {}
  }
  
  private Producer<CloseableReference<CloseableImage>> getLocalImageFileFetchSequence()
  {
    try
    {
      if (this.mLocalImageFileFetchSequence == null) {
        this.mLocalImageFileFetchSequence = newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newLocalFileFetchProducer());
      }
      Producer localProducer = this.mLocalImageFileFetchSequence;
      return localProducer;
    }
    finally {}
  }
  
  private Producer<CloseableReference<CloseableImage>> getLocalResourceFetchSequence()
  {
    try
    {
      if (this.mLocalResourceFetchSequence == null) {
        this.mLocalResourceFetchSequence = newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newLocalResourceFetchProducer());
      }
      Producer localProducer = this.mLocalResourceFetchSequence;
      return localProducer;
    }
    finally {}
  }
  
  private Producer<CloseableReference<CloseableImage>> getLocalVideoFileFetchSequence()
  {
    try
    {
      if (this.mLocalVideoFileFetchSequence == null) {
        this.mLocalVideoFileFetchSequence = newBitmapCacheGetToBitmapCacheSequence(this.mProducerFactory.newLocalVideoThumbnailProducer());
      }
      Producer localProducer = this.mLocalVideoFileFetchSequence;
      return localProducer;
    }
    finally {}
  }
  
  private Producer<CloseableReference<CloseableImage>> getNetworkFetchSequence()
  {
    try
    {
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchSequence");
      }
      if (this.mNetworkFetchSequence == null)
      {
        if (FrescoSystrace.isTracing()) {
          FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchSequence:init");
        }
        this.mNetworkFetchSequence = newBitmapCacheGetToDecodeSequence(getCommonNetworkFetchToEncodedMemorySequence());
        if (FrescoSystrace.isTracing()) {
          FrescoSystrace.endSection();
        }
      }
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.endSection();
      }
      Producer localProducer = this.mNetworkFetchSequence;
      return localProducer;
    }
    finally {}
  }
  
  private Producer<Void> getNetworkFetchToEncodedMemoryPrefetchSequence()
  {
    try
    {
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchToEncodedMemoryPrefetchSequence");
      }
      if (this.mNetworkFetchToEncodedMemoryPrefetchSequence == null)
      {
        if (FrescoSystrace.isTracing()) {
          FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchToEncodedMemoryPrefetchSequence:init");
        }
        this.mNetworkFetchToEncodedMemoryPrefetchSequence = ProducerFactory.newSwallowResultProducer(getBackgroundNetworkFetchToEncodedMemorySequence());
        if (FrescoSystrace.isTracing()) {
          FrescoSystrace.endSection();
        }
      }
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.endSection();
      }
      Producer localProducer = this.mNetworkFetchToEncodedMemoryPrefetchSequence;
      return localProducer;
    }
    finally {}
  }
  
  private Producer<CloseableReference<CloseableImage>> getPostprocessorSequence(Producer<CloseableReference<CloseableImage>> paramProducer)
  {
    try
    {
      if (!this.mPostprocessorSequences.containsKey(paramProducer))
      {
        Object localObject = this.mProducerFactory.newPostprocessorProducer(paramProducer);
        localObject = this.mProducerFactory.newPostprocessorBitmapMemoryCacheProducer((Producer)localObject);
        this.mPostprocessorSequences.put(paramProducer, localObject);
      }
      paramProducer = (Producer)this.mPostprocessorSequences.get(paramProducer);
      return paramProducer;
    }
    finally {}
  }
  
  private Producer<CloseableReference<CloseableImage>> getQualifiedResourceFetchSequence()
  {
    try
    {
      if (this.mQualifiedResourceFetchSequence == null) {
        this.mQualifiedResourceFetchSequence = newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newQualifiedResourceFetchProducer());
      }
      Producer localProducer = this.mQualifiedResourceFetchSequence;
      return localProducer;
    }
    finally {}
  }
  
  private static String getShortenedUriString(Uri paramUri)
  {
    String str = String.valueOf(paramUri);
    paramUri = str;
    if (str.length() > 30)
    {
      paramUri = new StringBuilder();
      paramUri.append(str.substring(0, 30));
      paramUri.append("...");
      paramUri = paramUri.toString();
    }
    return paramUri;
  }
  
  private Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToBitmapCacheSequence(Producer<CloseableReference<CloseableImage>> paramProducer)
  {
    paramProducer = this.mProducerFactory.newBitmapMemoryCacheProducer(paramProducer);
    paramProducer = this.mProducerFactory.newBitmapMemoryCacheKeyMultiplexProducer(paramProducer);
    paramProducer = this.mProducerFactory.newBackgroundThreadHandoffProducer(paramProducer, this.mThreadHandoffProducerQueue);
    if ((!this.mIsEncodedMemoryCacheProbingEnabled) && (!this.mIsDiskCacheProbingEnabled)) {
      return this.mProducerFactory.newBitmapMemoryCacheGetProducer(paramProducer);
    }
    paramProducer = this.mProducerFactory.newBitmapMemoryCacheGetProducer(paramProducer);
    return this.mProducerFactory.newBitmapProbeProducer(paramProducer);
  }
  
  private Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToDecodeSequence(Producer<EncodedImage> paramProducer)
  {
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.beginSection("ProducerSequenceFactory#newBitmapCacheGetToDecodeSequence");
    }
    paramProducer = newBitmapCacheGetToBitmapCacheSequence(this.mProducerFactory.newDecodeProducer(paramProducer));
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.endSection();
    }
    return paramProducer;
  }
  
  private Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToLocalTransformSequence(Producer<EncodedImage> paramProducer)
  {
    return newBitmapCacheGetToLocalTransformSequence(paramProducer, new ThumbnailProducer[] { this.mProducerFactory.newLocalExifThumbnailProducer() });
  }
  
  private Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToLocalTransformSequence(Producer<EncodedImage> paramProducer, ThumbnailProducer<EncodedImage>[] paramArrayOfThumbnailProducer)
  {
    return newBitmapCacheGetToDecodeSequence(newLocalTransformationsSequence(newEncodedCacheMultiplexToTranscodeSequence(paramProducer), paramArrayOfThumbnailProducer));
  }
  
  private Producer<EncodedImage> newDiskCacheSequence(Producer<EncodedImage> paramProducer)
  {
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.beginSection("ProducerSequenceFactory#newDiskCacheSequence");
    }
    if (this.mPartialImageCachingEnabled)
    {
      paramProducer = this.mProducerFactory.newPartialDiskCacheProducer(paramProducer);
      paramProducer = this.mProducerFactory.newDiskCacheWriteProducer(paramProducer);
    }
    else
    {
      paramProducer = this.mProducerFactory.newDiskCacheWriteProducer(paramProducer);
    }
    paramProducer = this.mProducerFactory.newDiskCacheReadProducer(paramProducer);
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.endSection();
    }
    return paramProducer;
  }
  
  private Producer<EncodedImage> newEncodedCacheMultiplexToTranscodeSequence(Producer<EncodedImage> paramProducer)
  {
    Object localObject = paramProducer;
    if (WebpSupportStatus.sIsWebpSupportRequired) {
      if (this.mWebpSupportEnabled)
      {
        localObject = paramProducer;
        if (WebpSupportStatus.sWebpBitmapFactory != null) {}
      }
      else
      {
        localObject = this.mProducerFactory.newWebpTranscodeProducer(paramProducer);
      }
    }
    paramProducer = (Producer<EncodedImage>)localObject;
    if (this.mDiskCacheEnabled) {
      paramProducer = newDiskCacheSequence((Producer)localObject);
    }
    paramProducer = this.mProducerFactory.newEncodedMemoryCacheProducer(paramProducer);
    if (this.mIsDiskCacheProbingEnabled)
    {
      paramProducer = this.mProducerFactory.newEncodedProbeProducer(paramProducer);
      return this.mProducerFactory.newEncodedCacheKeyMultiplexProducer(paramProducer);
    }
    return this.mProducerFactory.newEncodedCacheKeyMultiplexProducer(paramProducer);
  }
  
  private Producer<EncodedImage> newLocalThumbnailProducer(ThumbnailProducer<EncodedImage>[] paramArrayOfThumbnailProducer)
  {
    paramArrayOfThumbnailProducer = this.mProducerFactory.newThumbnailBranchProducer(paramArrayOfThumbnailProducer);
    return this.mProducerFactory.newResizeAndRotateProducer(paramArrayOfThumbnailProducer, true, this.mImageTranscoderFactory);
  }
  
  private Producer<EncodedImage> newLocalTransformationsSequence(Producer<EncodedImage> paramProducer, ThumbnailProducer<EncodedImage>[] paramArrayOfThumbnailProducer)
  {
    paramProducer = ProducerFactory.newAddImageTransformMetaDataProducer(paramProducer);
    paramProducer = this.mProducerFactory.newResizeAndRotateProducer(paramProducer, true, this.mImageTranscoderFactory);
    paramProducer = this.mProducerFactory.newThrottlingProducer(paramProducer);
    return ProducerFactory.newBranchOnSeparateImagesProducer(newLocalThumbnailProducer(paramArrayOfThumbnailProducer), paramProducer);
  }
  
  private static void validateEncodedImageRequest(ImageRequest paramImageRequest)
  {
    Preconditions.checkNotNull(paramImageRequest);
    boolean bool;
    if (paramImageRequest.getLowestPermittedRequestLevel().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
  }
  
  public Producer<Void> getDecodedImagePrefetchProducerSequence(ImageRequest paramImageRequest)
  {
    Producer localProducer = getBasicDecodedImageSequence(paramImageRequest);
    paramImageRequest = localProducer;
    if (this.mUseBitmapPrepareToDraw) {
      paramImageRequest = getBitmapPrepareSequence(localProducer);
    }
    return getDecodedImagePrefetchSequence(paramImageRequest);
  }
  
  public Producer<CloseableReference<CloseableImage>> getDecodedImageProducerSequence(ImageRequest paramImageRequest)
  {
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.beginSection("ProducerSequenceFactory#getDecodedImageProducerSequence");
    }
    Producer localProducer2 = getBasicDecodedImageSequence(paramImageRequest);
    Producer localProducer1 = localProducer2;
    if (paramImageRequest.getPostprocessor() != null) {
      localProducer1 = getPostprocessorSequence(localProducer2);
    }
    paramImageRequest = localProducer1;
    if (this.mUseBitmapPrepareToDraw) {
      paramImageRequest = getBitmapPrepareSequence(localProducer1);
    }
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.endSection();
    }
    return paramImageRequest;
  }
  
  public Producer<Void> getEncodedImagePrefetchProducerSequence(ImageRequest paramImageRequest)
  {
    validateEncodedImageRequest(paramImageRequest);
    int i = paramImageRequest.getSourceUriType();
    if (i != 0)
    {
      if ((i != 2) && (i != 3))
      {
        paramImageRequest = paramImageRequest.getSourceUri();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unsupported uri scheme for encoded image fetch! Uri is: ");
        localStringBuilder.append(getShortenedUriString(paramImageRequest));
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      return getLocalFileFetchToEncodedMemoryPrefetchSequence();
    }
    return getNetworkFetchToEncodedMemoryPrefetchSequence();
  }
  
  public Producer<CloseableReference<PooledByteBuffer>> getEncodedImageProducerSequence(ImageRequest paramImageRequest)
  {
    try
    {
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.beginSection("ProducerSequenceFactory#getEncodedImageProducerSequence");
      }
      validateEncodedImageRequest(paramImageRequest);
      Uri localUri = paramImageRequest.getSourceUri();
      int i = paramImageRequest.getSourceUriType();
      if (i != 0)
      {
        if ((i != 2) && (i != 3))
        {
          if (i == 4)
          {
            paramImageRequest = getLocalContentUriFetchEncodedImageProducerSequence();
            return paramImageRequest;
          }
          paramImageRequest = new StringBuilder();
          paramImageRequest.append("Unsupported uri scheme for encoded image fetch! Uri is: ");
          paramImageRequest.append(getShortenedUriString(localUri));
          throw new IllegalArgumentException(paramImageRequest.toString());
        }
        paramImageRequest = getLocalFileFetchEncodedImageProducerSequence();
        return paramImageRequest;
      }
      paramImageRequest = getNetworkFetchEncodedImageProducerSequence();
      return paramImageRequest;
    }
    finally
    {
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.endSection();
      }
    }
  }
  
  public Producer<CloseableReference<PooledByteBuffer>> getLocalContentUriFetchEncodedImageProducerSequence()
  {
    try
    {
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalContentUriFetchEncodedImageProducerSequence");
      }
      if (this.mLocalContentUriEncodedImageProducerSequence == null)
      {
        if (FrescoSystrace.isTracing()) {
          FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalContentUriFetchEncodedImageProducerSequence:init");
        }
        this.mLocalContentUriEncodedImageProducerSequence = new RemoveImageTransformMetaDataProducer(getBackgroundLocalContentUriFetchToEncodeMemorySequence());
        if (FrescoSystrace.isTracing()) {
          FrescoSystrace.endSection();
        }
      }
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.endSection();
      }
      return this.mLocalContentUriEncodedImageProducerSequence;
    }
    finally {}
  }
  
  public Producer<CloseableReference<PooledByteBuffer>> getLocalFileFetchEncodedImageProducerSequence()
  {
    try
    {
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalFileFetchEncodedImageProducerSequence");
      }
      if (this.mLocalFileEncodedImageProducerSequence == null)
      {
        if (FrescoSystrace.isTracing()) {
          FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalFileFetchEncodedImageProducerSequence:init");
        }
        this.mLocalFileEncodedImageProducerSequence = new RemoveImageTransformMetaDataProducer(getBackgroundLocalFileFetchToEncodeMemorySequence());
        if (FrescoSystrace.isTracing()) {
          FrescoSystrace.endSection();
        }
      }
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.endSection();
      }
      return this.mLocalFileEncodedImageProducerSequence;
    }
    finally {}
  }
  
  public Producer<CloseableReference<PooledByteBuffer>> getNetworkFetchEncodedImageProducerSequence()
  {
    try
    {
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchEncodedImageProducerSequence");
      }
      if (this.mNetworkEncodedImageProducerSequence == null)
      {
        if (FrescoSystrace.isTracing()) {
          FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchEncodedImageProducerSequence:init");
        }
        this.mNetworkEncodedImageProducerSequence = new RemoveImageTransformMetaDataProducer(getBackgroundNetworkFetchToEncodedMemorySequence());
        if (FrescoSystrace.isTracing()) {
          FrescoSystrace.endSection();
        }
      }
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.endSection();
      }
      return this.mNetworkEncodedImageProducerSequence;
    }
    finally {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\core\ProducerSequenceFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */