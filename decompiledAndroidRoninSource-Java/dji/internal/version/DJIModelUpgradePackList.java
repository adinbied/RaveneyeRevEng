package dji.internal.version;

import dji.midware.data.config.P3.ProductType;
import java.util.ArrayList;

public class DJIModelUpgradePackList
{
  public DJIUpgradeAnnouncement announcement;
  public DJIUpgradeAnnouncement announcementAndroid;
  public DJIUpgradeAppVersion application;
  public ArrayList<DJIUpgradePack> versionlist;
  public ArrayList<DJIUpgradePack> versionlistc;
  public ArrayList<DJIUpgradePack> versionlistcv600;
  public ArrayList<DJIUpgradePack> versionlisthg;
  public ArrayList<DJIUpgradePack> versionlisthgX5;
  public ArrayList<DJIUpgradePack> versionlisthgX5R;
  public ArrayList<DJIUpgradePack> versionlistlb2;
  public ArrayList<DJIUpgradePack> versionlistm100;
  public ArrayList<DJIUpgradePack> versionlistm600;
  public ArrayList<DJIUpgradePack> versionlistp4p;
  public ArrayList<DJIUpgradePack> versionlists;
  public ArrayList<DJIUpgradePack> versionlistx;
  public ArrayList<DJIUpgradePack> versionlistx5;
  public ArrayList<DJIUpgradePack> versionlistx5r;
  public ArrayList<DJIUpgradePack> versionlistxt;
  public ArrayList<DJIUpgradePack> versionlistz3;
  
  public ArrayList<DJIUpgradePack> getVersionList(ProductType paramProductType)
  {
    return null;
  }
  
  public static class DJIUpgradeAnnouncement
  {
    public String en;
    public String guid;
    public String jp;
    public String zh;
  }
  
  public static class DJIUpgradeAppVersion
  {
    public String android;
    public int significant1;
  }
  
  public static class DJIUpgradeDevice
  {
    public int isLock;
    public String name;
    public String version;
  }
  
  public static class DJIUpgradePack
  {
    public int android_ignore;
    public long date;
    public String m0100;
    public String m0101;
    public String m0104;
    public String m0106;
    public String m0305;
    public String m0306;
    public String m0400;
    public String m0407;
    public String m0500;
    public String m0700;
    public String m0800;
    public String m0801;
    public String m0807;
    public String m0900;
    public String m1100;
    public String m1101;
    public String m1102;
    public String m1103;
    public String m1104;
    public String m1105;
    public String m1106;
    public String m1200;
    public String m1201;
    public String m1202;
    public String m1203;
    public String m1204;
    public String m1205;
    public String m1300;
    public String m1301;
    public String m1400;
    public String m1401;
    public String m1405;
    public String m1500;
    public String m1501;
    public String m1600;
    public String m1601;
    public String m1700;
    public String m1701;
    public String m1900;
    public String m2000;
    public String m2001;
    public String m2002;
    public String m2500;
    public String m2501;
    public String m2700;
    public String m2900;
    public String packurl;
    public int priority;
    public String rc1url;
    public String rcurl;
    public String rcversion;
    public DJIModelUpgradePackList.ReleaseNote release_note;
    public String version;
    
    public static int getFlag(String paramString)
    {
      return Integer.parseInt(paramString.split("&")[1]);
    }
    
    public static String getVersion(String paramString)
    {
      return paramString.split("&")[0];
    }
  }
  
  public static class ReleaseNote
  {
    public String cn;
    public String en;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\version\DJIModelUpgradePackList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */