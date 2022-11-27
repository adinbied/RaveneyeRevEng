package dji.utils;

import android.content.Context;
import android.net.Uri;
import dji.utils.storage.DJIFolder;

public class UriConverter
{
  private static final String SCHEME_NAME_CONTENT = "content";
  private static final String SCHEME_NAME_FILE = "file";
  private static final String TEMP_FILE_DIR = DJIFolder.SHARE_TEMP.relativePath();
  private Uri mContentUri = null;
  Context mContext;
  
  public UriConverter(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private String copyFileToInternalStorage(Uri paramUri, String paramString)
  {
    return null;
  }
  
  private String getDataColumn(Context paramContext, Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return null;
  }
  
  private String getFilePathForWhatsApp(Uri paramUri)
  {
    return copyFileToInternalStorage(paramUri, TEMP_FILE_DIR);
  }
  
  private String getGoogleDriveFilePath(Uri paramUri)
  {
    return null;
  }
  
  private String getPathFromExtSD(String[] paramArrayOfString)
  {
    return null;
  }
  
  private boolean isDownloadsDocument(Uri paramUri)
  {
    return false;
  }
  
  private boolean isExternalStorageDocument(Uri paramUri)
  {
    return false;
  }
  
  private boolean isGoogleDriveUri(Uri paramUri)
  {
    return false;
  }
  
  private static boolean isGooglePhotosUri(Uri paramUri)
  {
    return "com.google.android.apps.photos.content".equals(paramUri.getAuthority());
  }
  
  private boolean isMediaDocument(Uri paramUri)
  {
    return false;
  }
  
  public String getFilePathFromUri(Uri paramUri)
  {
    return null;
  }
  
  public boolean isWhatsAppFile(Uri paramUri)
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dj\\utils\UriConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */