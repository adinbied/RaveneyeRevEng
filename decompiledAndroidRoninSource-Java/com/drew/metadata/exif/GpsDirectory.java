package com.drew.metadata.exif;

import com.drew.lang.GeoLocation;
import java.util.Date;
import java.util.HashMap;

public class GpsDirectory
  extends ExifDirectoryBase
{
  public static final int TAG_ALTITUDE = 6;
  public static final int TAG_ALTITUDE_REF = 5;
  public static final int TAG_AREA_INFORMATION = 28;
  public static final int TAG_DATE_STAMP = 29;
  public static final int TAG_DEST_BEARING = 24;
  public static final int TAG_DEST_BEARING_REF = 23;
  public static final int TAG_DEST_DISTANCE = 26;
  public static final int TAG_DEST_DISTANCE_REF = 25;
  public static final int TAG_DEST_LATITUDE = 20;
  public static final int TAG_DEST_LATITUDE_REF = 19;
  public static final int TAG_DEST_LONGITUDE = 22;
  public static final int TAG_DEST_LONGITUDE_REF = 21;
  public static final int TAG_DIFFERENTIAL = 30;
  public static final int TAG_DOP = 11;
  public static final int TAG_IMG_DIRECTION = 17;
  public static final int TAG_IMG_DIRECTION_REF = 16;
  public static final int TAG_LATITUDE = 2;
  public static final int TAG_LATITUDE_REF = 1;
  public static final int TAG_LONGITUDE = 4;
  public static final int TAG_LONGITUDE_REF = 3;
  public static final int TAG_MAP_DATUM = 18;
  public static final int TAG_MEASURE_MODE = 10;
  public static final int TAG_PROCESSING_METHOD = 27;
  public static final int TAG_SATELLITES = 8;
  public static final int TAG_SPEED = 13;
  public static final int TAG_SPEED_REF = 12;
  public static final int TAG_STATUS = 9;
  public static final int TAG_TIME_STAMP = 7;
  public static final int TAG_TRACK = 15;
  public static final int TAG_TRACK_REF = 14;
  public static final int TAG_VERSION_ID = 0;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    addExifTagNames(localHashMap);
    _tagNameMap.put(Integer.valueOf(0), "GPS Version ID");
    _tagNameMap.put(Integer.valueOf(1), "GPS Latitude Ref");
    _tagNameMap.put(Integer.valueOf(2), "GPS Latitude");
    _tagNameMap.put(Integer.valueOf(3), "GPS Longitude Ref");
    _tagNameMap.put(Integer.valueOf(4), "GPS Longitude");
    _tagNameMap.put(Integer.valueOf(5), "GPS Altitude Ref");
    _tagNameMap.put(Integer.valueOf(6), "GPS Altitude");
    _tagNameMap.put(Integer.valueOf(7), "GPS Time-Stamp");
    _tagNameMap.put(Integer.valueOf(8), "GPS Satellites");
    _tagNameMap.put(Integer.valueOf(9), "GPS Status");
    _tagNameMap.put(Integer.valueOf(10), "GPS Measure Mode");
    _tagNameMap.put(Integer.valueOf(11), "GPS DOP");
    _tagNameMap.put(Integer.valueOf(12), "GPS Speed Ref");
    _tagNameMap.put(Integer.valueOf(13), "GPS Speed");
    _tagNameMap.put(Integer.valueOf(14), "GPS Track Ref");
    _tagNameMap.put(Integer.valueOf(15), "GPS Track");
    _tagNameMap.put(Integer.valueOf(16), "GPS Img Direction Ref");
    _tagNameMap.put(Integer.valueOf(17), "GPS Img Direction");
    _tagNameMap.put(Integer.valueOf(18), "GPS Map Datum");
    _tagNameMap.put(Integer.valueOf(19), "GPS Dest Latitude Ref");
    _tagNameMap.put(Integer.valueOf(20), "GPS Dest Latitude");
    _tagNameMap.put(Integer.valueOf(21), "GPS Dest Longitude Ref");
    _tagNameMap.put(Integer.valueOf(22), "GPS Dest Longitude");
    _tagNameMap.put(Integer.valueOf(23), "GPS Dest Bearing Ref");
    _tagNameMap.put(Integer.valueOf(24), "GPS Dest Bearing");
    _tagNameMap.put(Integer.valueOf(25), "GPS Dest Distance Ref");
    _tagNameMap.put(Integer.valueOf(26), "GPS Dest Distance");
    _tagNameMap.put(Integer.valueOf(27), "GPS Processing Method");
    _tagNameMap.put(Integer.valueOf(28), "GPS Area Information");
    _tagNameMap.put(Integer.valueOf(29), "GPS Date Stamp");
    _tagNameMap.put(Integer.valueOf(30), "GPS Differential");
  }
  
  public GpsDirectory()
  {
    setDescriptor(new GpsDescriptor(this));
  }
  
  public GeoLocation getGeoLocation()
  {
    return null;
  }
  
  public Date getGpsDate()
  {
    return null;
  }
  
  public String getName()
  {
    return "GPS";
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\GpsDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */