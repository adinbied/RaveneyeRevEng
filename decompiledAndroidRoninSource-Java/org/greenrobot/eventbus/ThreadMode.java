package org.greenrobot.eventbus;

public enum ThreadMode
{
  static
  {
    MAIN = new ThreadMode("MAIN", 1);
    MAIN_ORDERED = new ThreadMode("MAIN_ORDERED", 2);
    BACKGROUND = new ThreadMode("BACKGROUND", 3);
    ThreadMode localThreadMode = new ThreadMode("ASYNC", 4);
    ASYNC = localThreadMode;
    $VALUES = new ThreadMode[] { POSTING, MAIN, MAIN_ORDERED, BACKGROUND, localThreadMode };
  }
  
  private ThreadMode() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\greenrobot\eventbus\ThreadMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */