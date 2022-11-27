package dji.logic.album.model;

public enum DJIAlbumPullErrorType
{
  static
  {
    DATA_NOMATCH = new DJIAlbumPullErrorType("DATA_NOMATCH", 2);
    TIMEOUT = new DJIAlbumPullErrorType("TIMEOUT", 3);
    CLIENT_ABORT = new DJIAlbumPullErrorType("CLIENT_ABORT", 4);
    SERVER_ABORT = new DJIAlbumPullErrorType("SERVER_ABORT", 5);
    DISCONNECT = new DJIAlbumPullErrorType("DISCONNECT", 6);
    DJIAlbumPullErrorType localDJIAlbumPullErrorType = new DJIAlbumPullErrorType("UNKNOW", 7);
    UNKNOW = localDJIAlbumPullErrorType;
    $VALUES = new DJIAlbumPullErrorType[] { ERROR_REQ, NO_SUCH_FILE, DATA_NOMATCH, TIMEOUT, CLIENT_ABORT, SERVER_ABORT, DISCONNECT, localDJIAlbumPullErrorType };
  }
  
  private DJIAlbumPullErrorType() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\logic\album\model\DJIAlbumPullErrorType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */