package com.google.firebase.crashlytics.internal.ndk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import com.google.firebase.crashlytics.internal.Logger;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class BinaryImagesConverter
{
  private static final String DATA_DIR = "/data";
  private final Context context;
  private final FileIdStrategy fileIdStrategy;
  
  BinaryImagesConverter(Context paramContext, FileIdStrategy paramFileIdStrategy)
  {
    this.context = paramContext;
    this.fileIdStrategy = paramFileIdStrategy;
  }
  
  private File correctDataPath(File paramFile)
  {
    if (Build.VERSION.SDK_INT < 9) {
      return paramFile;
    }
    if (paramFile.getAbsolutePath().startsWith("/data")) {
      try
      {
        File localFile = new File(this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 0).nativeLibraryDir, paramFile.getName());
        return localFile;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        Logger.getLogger().e("Error getting ApplicationInfo", localNameNotFoundException);
      }
    }
    return paramFile;
  }
  
  private static JSONObject createBinaryImageJson(String paramString, ProcMapEntry paramProcMapEntry)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("base_address", paramProcMapEntry.address);
    localJSONObject.put("size", paramProcMapEntry.size);
    localJSONObject.put("name", paramProcMapEntry.path);
    localJSONObject.put("uuid", paramString);
    return localJSONObject;
  }
  
  private static byte[] generateBinaryImagesJsonString(JSONArray paramJSONArray)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("binary_images", paramJSONArray);
      return localJSONObject.toString().getBytes(Charset.forName("UTF-8"));
    }
    catch (JSONException paramJSONArray)
    {
      Logger.getLogger().w("Binary images string is null", paramJSONArray);
    }
    return new byte[0];
  }
  
  private File getLibraryFile(String paramString)
  {
    File localFile = new File(paramString);
    paramString = localFile;
    if (!localFile.exists()) {
      paramString = correctDataPath(localFile);
    }
    return paramString;
  }
  
  private static boolean isRelevant(ProcMapEntry paramProcMapEntry)
  {
    return (paramProcMapEntry.perms.indexOf('x') != -1) && (paramProcMapEntry.path.indexOf('/') != -1);
  }
  
  private static String joinMapsEntries(JSONArray paramJSONArray)
    throws JSONException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      localStringBuilder.append(paramJSONArray.getString(i));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private JSONObject jsonFromMapEntryString(String paramString)
  {
    paramString = ProcMapEntryParser.parse(paramString);
    if (paramString != null)
    {
      if (!isRelevant(paramString)) {
        return null;
      }
      Object localObject = getLibraryFile(paramString.path);
      try
      {
        localObject = this.fileIdStrategy.createId((File)localObject);
        try
        {
          paramString = createBinaryImageJson((String)localObject, paramString);
          return paramString;
        }
        catch (JSONException paramString)
        {
          Logger.getLogger().d("Could not create a binary image json string", paramString);
          return null;
        }
        Logger localLogger;
        StringBuilder localStringBuilder;
        return null;
      }
      catch (IOException localIOException)
      {
        localLogger = Logger.getLogger();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Could not generate ID for file ");
        localStringBuilder.append(paramString.path);
        localLogger.d(localStringBuilder.toString(), localIOException);
      }
    }
  }
  
  private JSONArray parseProcMapsJsonFromStream(BufferedReader paramBufferedReader)
    throws IOException
  {
    JSONArray localJSONArray = new JSONArray();
    for (;;)
    {
      Object localObject = paramBufferedReader.readLine();
      if (localObject == null) {
        break;
      }
      localObject = jsonFromMapEntryString((String)localObject);
      if (localObject != null) {
        localJSONArray.put(localObject);
      }
    }
    return localJSONArray;
  }
  
  private JSONArray parseProcMapsJsonFromString(String paramString)
  {
    JSONArray localJSONArray = new JSONArray();
    try
    {
      paramString = joinMapsEntries(new JSONObject(paramString).getJSONArray("maps"));
      paramString = paramString.split("\\|");
      int i = 0;
      while (i < paramString.length)
      {
        JSONObject localJSONObject = jsonFromMapEntryString(paramString[i]);
        if (localJSONObject != null) {
          localJSONArray.put(localJSONObject);
        }
        i += 1;
      }
      return localJSONArray;
    }
    catch (JSONException paramString)
    {
      Logger.getLogger().w("Unable to parse proc maps string", paramString);
    }
    return localJSONArray;
  }
  
  byte[] convert(BufferedReader paramBufferedReader)
    throws IOException
  {
    return generateBinaryImagesJsonString(parseProcMapsJsonFromStream(paramBufferedReader));
  }
  
  byte[] convert(String paramString)
    throws IOException
  {
    return generateBinaryImagesJsonString(parseProcMapsJsonFromString(paramString));
  }
  
  static abstract interface FileIdStrategy
  {
    public abstract String createId(File paramFile)
      throws IOException;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\ndk\BinaryImagesConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */