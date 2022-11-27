package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.ContactsContract.Contacts;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public class LocalContentUriFetchProducer
  extends LocalFetchProducer
{
  public static final String PRODUCER_NAME = "LocalContentUriFetchProducer";
  private static final String[] PROJECTION = { "_id", "_data" };
  private final ContentResolver mContentResolver;
  
  public LocalContentUriFetchProducer(Executor paramExecutor, PooledByteBufferFactory paramPooledByteBufferFactory, ContentResolver paramContentResolver)
  {
    super(paramExecutor, paramPooledByteBufferFactory);
    this.mContentResolver = paramContentResolver;
  }
  
  @Nullable
  private EncodedImage getCameraImage(Uri paramUri)
    throws IOException
  {
    Cursor localCursor = this.mContentResolver.query(paramUri, PROJECTION, null, null, null);
    if (localCursor == null) {
      return null;
    }
    try
    {
      int i = localCursor.getCount();
      if (i == 0) {
        return null;
      }
      localCursor.moveToFirst();
      String str = localCursor.getString(localCursor.getColumnIndex("_data"));
      if (str != null)
      {
        paramUri = getEncodedImage(new FileInputStream(this.mContentResolver.openFileDescriptor(paramUri, "r").getFileDescriptor()), getLength(str));
        return paramUri;
      }
      return null;
    }
    finally
    {
      localCursor.close();
    }
  }
  
  private static int getLength(String paramString)
  {
    if (paramString == null) {
      return -1;
    }
    return (int)new File(paramString).length();
  }
  
  protected EncodedImage getEncodedImage(ImageRequest paramImageRequest)
    throws IOException
  {
    Uri localUri = paramImageRequest.getSourceUri();
    if (UriUtil.isLocalContactUri(localUri)) {
      if (localUri.toString().endsWith("/photo")) {
        paramImageRequest = this.mContentResolver.openInputStream(localUri);
      } else if (!localUri.toString().endsWith("/display_photo")) {}
    }
    try
    {
      paramImageRequest = this.mContentResolver.openAssetFileDescriptor(localUri, "r").createInputStream();
    }
    catch (IOException paramImageRequest)
    {
      for (;;) {}
    }
    paramImageRequest = new StringBuilder();
    paramImageRequest.append("Contact photo does not exist: ");
    paramImageRequest.append(localUri);
    throw new IOException(paramImageRequest.toString());
    paramImageRequest = ContactsContract.Contacts.openContactPhotoInputStream(this.mContentResolver, localUri);
    if (paramImageRequest != null) {
      return getEncodedImage(paramImageRequest, -1);
    }
    paramImageRequest = new StringBuilder();
    paramImageRequest.append("Contact photo does not exist: ");
    paramImageRequest.append(localUri);
    throw new IOException(paramImageRequest.toString());
    if (UriUtil.isLocalCameraUri(localUri))
    {
      paramImageRequest = getCameraImage(localUri);
      if (paramImageRequest != null) {
        return paramImageRequest;
      }
    }
    return getEncodedImage(this.mContentResolver.openInputStream(localUri), -1);
  }
  
  protected String getProducerName()
  {
    return "LocalContentUriFetchProducer";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\LocalContentUriFetchProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */