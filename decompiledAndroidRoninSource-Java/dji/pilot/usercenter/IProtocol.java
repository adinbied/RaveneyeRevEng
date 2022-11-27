package dji.pilot.usercenter;

public abstract interface IProtocol
{
  public static final int CMDID_ACCOUNT_GET_FLIGHTS = 24576;
  public static final int CMDID_ALBUM_DEL_CLOUDS = 20483;
  public static final int CMDID_ALBUM_EDIT_CLOUD = 20482;
  public static final int CMDID_ALBUM_GET_CLOUDS = 20481;
  public static final int CMDID_ALBUM_GET_PAGECLOUDS = 20480;
  public static final int CMDID_PHOTO_GET_LASTEST = 4096;
  public static final int CMDID_PHOTO_GET_POPULAR = 4097;
  public static final int CMDID_PHOTO_GET_SEARCH = 4098;
  public static final int CMDID_PREVIEW_GET_COMMENTS = 12288;
  public static final int CMDID_PREVIEW_LIKE = 12290;
  public static final int CMDID_PREVIEW_LOOK = 12289;
  public static final int CMDID_PREVIEW_PRAISE = 12291;
  public static final int CMDID_VIDEO_GET_LASTEST = 8192;
  public static final int CMDID_VIDEO_GET_POPULAR = 8193;
  public static final int CMDID_VIDEO_GET_SEARCH = 8194;
  public static final int DEFAULT_PAGESIZE = 48;
  public static final int MSG_ID_FAIL = 65537;
  public static final int MSG_ID_START = 65538;
  public static final int MSG_ID_SUCCESS = 65536;
  public static final int MSG_ID_UPDATE = 65539;
  public static final int STATUS_CODE_OK = 0;
  public static final int STATUS_CODE_OTHER = 1;
  
  public static abstract interface OnDataResultListener
  {
    public abstract void onFail(int paramInt1, int paramInt2, int paramInt3, Object paramObject);
    
    public abstract void onStart(int paramInt1, boolean paramBoolean, int paramInt2, Object paramObject);
    
    public abstract void onSuccess(int paramInt1, int paramInt2, int paramInt3, Object paramObject1, Object paramObject2);
    
    public abstract void onUpate(int paramInt1, long paramLong1, long paramLong2, int paramInt2, Object paramObject);
  }
  
  public static class ProtocolResult
  {
    public int arg1 = 0;
    public int arg2 = 0;
    public Object mResult = null;
    public Object objArg = null;
    
    public static ProtocolResult generateResult(int paramInt1, int paramInt2, Object paramObject1, Object paramObject2)
    {
      ProtocolResult localProtocolResult = new ProtocolResult();
      localProtocolResult.arg1 = paramInt1;
      localProtocolResult.arg2 = paramInt2;
      localProtocolResult.objArg = paramObject1;
      localProtocolResult.mResult = paramObject2;
      return localProtocolResult;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\pilo\\usercenter\IProtocol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */