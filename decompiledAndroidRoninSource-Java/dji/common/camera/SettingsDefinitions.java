package dji.common.camera;

import dji.midware.data.model.P3.DataCameraSetPhoto.TYPE;

public class SettingsDefinitions
{
  public static enum AntiFlickerFrequency
  {
    private final int value;
    
    static
    {
      MANUAL_50HZ = new AntiFlickerFrequency("MANUAL_50HZ", 2, 2);
      AntiFlickerFrequency localAntiFlickerFrequency = new AntiFlickerFrequency("UNKNOWN", 3, 255);
      UNKNOWN = localAntiFlickerFrequency;
      $VALUES = new AntiFlickerFrequency[] { AUTO, MANUAL_60HZ, MANUAL_50HZ, localAntiFlickerFrequency };
    }
    
    private AntiFlickerFrequency(int paramInt)
    {
      this.value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public static AntiFlickerFrequency find(int paramInt)
    {
      AntiFlickerFrequency localAntiFlickerFrequency = UNKNOWN;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localAntiFlickerFrequency;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum Aperture
  {
    private final int value;
    
    static
    {
      F_10 = new Aperture("F_10", 22, 1000);
      F_11 = new Aperture("F_11", 23, 1100);
      F_13 = new Aperture("F_13", 24, 1300);
      F_14 = new Aperture("F_14", 25, 1400);
      F_16 = new Aperture("F_16", 26, 1600);
      F_18 = new Aperture("F_18", 27, 1800);
      F_20 = new Aperture("F_20", 28, 2000);
      F_22 = new Aperture("F_22", 29, 2200);
      Aperture localAperture = new Aperture("UNKNOWN", 30, 255);
      UNKNOWN = localAperture;
      $VALUES = new Aperture[] { F_1_DOT_6, F_1_DOT_7, F_1_DOT_8, F_2, F_2_DOT_2, F_2_DOT_4, F_2_DOT_5, F_2_DOT_8, F_3_DOT_2, F_3_DOT_4, F_3_DOT_5, F_4, F_4_DOT_5, F_4_DOT_8, F_5, F_5_DOT_6, F_6_DOT_3, F_6_DOT_8, F_7_DOT_1, F_8, F_9, F_9_DOT_6, F_10, F_11, F_13, F_14, F_16, F_18, F_20, F_22, localAperture };
    }
    
    private Aperture(int paramInt)
    {
      this.value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public static Aperture find(int paramInt)
    {
      Aperture localAperture = UNKNOWN;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localAperture;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum CameraMode
  {
    private final int value;
    
    static
    {
      RECORD_VIDEO = new CameraMode("RECORD_VIDEO", 1, 1);
      PLAYBACK = new CameraMode("PLAYBACK", 2, 2);
      MEDIA_DOWNLOAD = new CameraMode("MEDIA_DOWNLOAD", 3, 4);
      BROADCAST = new CameraMode("BROADCAST", 4, 5);
      CameraMode localCameraMode = new CameraMode("UNKNOWN", 5, 255);
      UNKNOWN = localCameraMode;
      $VALUES = new CameraMode[] { SHOOT_PHOTO, RECORD_VIDEO, PLAYBACK, MEDIA_DOWNLOAD, BROADCAST, localCameraMode };
    }
    
    private CameraMode(int paramInt)
    {
      this.value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public static CameraMode find(int paramInt)
    {
      CameraMode localCameraMode = UNKNOWN;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localCameraMode;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static class CameraPhotoAEBParam
  {
    public int captureCount;
    public int exposureOffset;
  }
  
  public static enum CameraPhotoQuality
  {
    private int value;
    
    static
    {
      Fine = new CameraPhotoQuality("Fine", 1, 1);
      Excellent = new CameraPhotoQuality("Excellent", 2, 2);
      CameraPhotoQuality localCameraPhotoQuality = new CameraPhotoQuality("Unknown", 3, 255);
      Unknown = localCameraPhotoQuality;
      $VALUES = new CameraPhotoQuality[] { Normal, Fine, Excellent, localCameraPhotoQuality };
    }
    
    private CameraPhotoQuality(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static CameraPhotoQuality find(int paramInt)
    {
      CameraPhotoQuality localCameraPhotoQuality = Unknown;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localCameraPhotoQuality;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum CustomSettingsProfile
  {
    private final int value;
    
    static
    {
      CustomSettingsProfile localCustomSettingsProfile = new CustomSettingsProfile("UNKNOWN", 5, 255);
      UNKNOWN = localCustomSettingsProfile;
      $VALUES = new CustomSettingsProfile[] { DEFAULT, PROFILE_1, PROFILE_2, PROFILE_3, PROFILE_4, localCustomSettingsProfile };
    }
    
    private CustomSettingsProfile(int paramInt)
    {
      this.value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public static CustomSettingsProfile find(int paramInt)
    {
      CustomSettingsProfile localCustomSettingsProfile = UNKNOWN;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localCustomSettingsProfile;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum DigitalFilter
  {
    private final int value;
    
    static
    {
      ART = new DigitalFilter("ART", 1, 1);
      BLACK_AND_WHITE = new DigitalFilter("BLACK_AND_WHITE", 2, 4);
      BRIGHT = new DigitalFilter("BRIGHT", 3, 5);
      D_CINELIKE = new DigitalFilter("D_CINELIKE", 4, 6);
      PORTRAIT = new DigitalFilter("PORTRAIT", 5, 7);
      M_31 = new DigitalFilter("M_31", 6, 14);
      DELTA = new DigitalFilter("DELTA", 7, 15);
      K_DX = new DigitalFilter("K_DX", 8, 16);
      DK79 = new DigitalFilter("DK79", 9, 17);
      PRISMO = new DigitalFilter("PRISMO", 10, 18);
      JUGO = new DigitalFilter("JUGO", 11, 19);
      VISION_4 = new DigitalFilter("VISION_4", 12, 20);
      VISION_6 = new DigitalFilter("VISION_6", 13, 21);
      D_LOG = new DigitalFilter("D_LOG", 14, 23);
      REMINISCENCE = new DigitalFilter("REMINISCENCE", 15, 2);
      INVERSE = new DigitalFilter("INVERSE", 16, 3);
      SOLARIZE = new DigitalFilter("SOLARIZE", 17, 38);
      POSTERIZE = new DigitalFilter("POSTERIZE", 18, 39);
      WHITEBOARD = new DigitalFilter("WHITEBOARD", 19, 40);
      BLACKBOARD = new DigitalFilter("BLACKBOARD", 20, 41);
      AQUA = new DigitalFilter("AQUA", 21, 42);
      TRUE_COLOR = new DigitalFilter("TRUE_COLOR", 22, 22);
      TRUE_COLOR_EXT = new DigitalFilter("TRUE_COLOR_EXT", 23, 43);
      FILM_A = new DigitalFilter("FILM_A", 24, 45);
      FILM_B = new DigitalFilter("FILM_B", 25, 46);
      FILM_C = new DigitalFilter("FILM_C", 26, 47);
      FILM_D = new DigitalFilter("FILM_D", 27, 48);
      FILM_E = new DigitalFilter("FILM_E", 28, 49);
      FILM_F = new DigitalFilter("FILM_F", 29, 50);
      FILM_G = new DigitalFilter("FILM_G", 30, 51);
      FILM_H = new DigitalFilter("FILM_H", 31, 52);
      FILM_I = new DigitalFilter("FILM_I", 32, 53);
      DigitalFilter localDigitalFilter = new DigitalFilter("UNKNOWN", 33, 255);
      UNKNOWN = localDigitalFilter;
      $VALUES = new DigitalFilter[] { NONE, ART, BLACK_AND_WHITE, BRIGHT, D_CINELIKE, PORTRAIT, M_31, DELTA, K_DX, DK79, PRISMO, JUGO, VISION_4, VISION_6, D_LOG, REMINISCENCE, INVERSE, SOLARIZE, POSTERIZE, WHITEBOARD, BLACKBOARD, AQUA, TRUE_COLOR, TRUE_COLOR_EXT, FILM_A, FILM_B, FILM_C, FILM_D, FILM_E, FILM_F, FILM_G, FILM_H, FILM_I, localDigitalFilter };
    }
    
    private DigitalFilter(int paramInt)
    {
      this.value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public static DigitalFilter find(int paramInt)
    {
      DigitalFilter localDigitalFilter = UNKNOWN;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localDigitalFilter;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum ExposureCompensation
  {
    private final int value;
    
    static
    {
      N_4_7 = new ExposureCompensation("N_4_7", 1, 2);
      N_4_3 = new ExposureCompensation("N_4_3", 2, 3);
      N_4_0 = new ExposureCompensation("N_4_0", 3, 4);
      N_3_7 = new ExposureCompensation("N_3_7", 4, 5);
      N_3_3 = new ExposureCompensation("N_3_3", 5, 6);
      N_3_0 = new ExposureCompensation("N_3_0", 6, 7);
      N_2_7 = new ExposureCompensation("N_2_7", 7, 8);
      N_2_3 = new ExposureCompensation("N_2_3", 8, 9);
      N_2_0 = new ExposureCompensation("N_2_0", 9, 10);
      N_1_7 = new ExposureCompensation("N_1_7", 10, 11);
      N_1_3 = new ExposureCompensation("N_1_3", 11, 12);
      N_1_0 = new ExposureCompensation("N_1_0", 12, 13);
      N_0_7 = new ExposureCompensation("N_0_7", 13, 14);
      N_0_3 = new ExposureCompensation("N_0_3", 14, 15);
      N_0_0 = new ExposureCompensation("N_0_0", 15, 16);
      P_0_3 = new ExposureCompensation("P_0_3", 16, 17);
      P_0_7 = new ExposureCompensation("P_0_7", 17, 18);
      P_1_0 = new ExposureCompensation("P_1_0", 18, 19);
      P_1_3 = new ExposureCompensation("P_1_3", 19, 20);
      P_1_7 = new ExposureCompensation("P_1_7", 20, 21);
      P_2_0 = new ExposureCompensation("P_2_0", 21, 22);
      P_2_3 = new ExposureCompensation("P_2_3", 22, 23);
      P_2_7 = new ExposureCompensation("P_2_7", 23, 24);
      P_3_0 = new ExposureCompensation("P_3_0", 24, 25);
      P_3_3 = new ExposureCompensation("P_3_3", 25, 26);
      P_3_7 = new ExposureCompensation("P_3_7", 26, 27);
      P_4_0 = new ExposureCompensation("P_4_0", 27, 28);
      P_4_3 = new ExposureCompensation("P_4_3", 28, 29);
      P_4_7 = new ExposureCompensation("P_4_7", 29, 30);
      P_5_0 = new ExposureCompensation("P_5_0", 30, 31);
      ExposureCompensation localExposureCompensation = new ExposureCompensation("UNKNOWN", 31, 255);
      UNKNOWN = localExposureCompensation;
      $VALUES = new ExposureCompensation[] { N_5_0, N_4_7, N_4_3, N_4_0, N_3_7, N_3_3, N_3_0, N_2_7, N_2_3, N_2_0, N_1_7, N_1_3, N_1_0, N_0_7, N_0_3, N_0_0, P_0_3, P_0_7, P_1_0, P_1_3, P_1_7, P_2_0, P_2_3, P_2_7, P_3_0, P_3_3, P_3_7, P_4_0, P_4_3, P_4_7, P_5_0, localExposureCompensation };
    }
    
    private ExposureCompensation(int paramInt)
    {
      this.value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public static ExposureCompensation find(int paramInt)
    {
      ExposureCompensation localExposureCompensation = UNKNOWN;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localExposureCompensation;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum ExposureMode
  {
    private final int value;
    
    static
    {
      APERTURE_PRIORITY = new ExposureMode("APERTURE_PRIORITY", 2, 3);
      MANUAL = new ExposureMode("MANUAL", 3, 4);
      CINE = new ExposureMode("CINE", 4, 7);
      ExposureMode localExposureMode = new ExposureMode("UNKNOWN", 5, 255);
      UNKNOWN = localExposureMode;
      $VALUES = new ExposureMode[] { PROGRAM, SHUTTER_PRIORITY, APERTURE_PRIORITY, MANUAL, CINE, localExposureMode };
    }
    
    private ExposureMode(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static ExposureMode find(int paramInt)
    {
      ExposureMode localExposureMode = UNKNOWN;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localExposureMode;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum FileIndexMode
  {
    private final int value;
    
    static
    {
      FileIndexMode localFileIndexMode = new FileIndexMode("UNKNOWN", 2, 255);
      UNKNOWN = localFileIndexMode;
      $VALUES = new FileIndexMode[] { RESET, SEQUENCE, localFileIndexMode };
    }
    
    private FileIndexMode(int paramInt)
    {
      this.value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public static FileIndexMode find(int paramInt)
    {
      FileIndexMode localFileIndexMode = UNKNOWN;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localFileIndexMode;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum FileType
  {
    private final int value;
    
    static
    {
      DNG = new FileType("DNG", 1, 1);
      VIDEO = new FileType("VIDEO", 2, 2);
      FileType localFileType = new FileType("UNKNOWN", 3, 255);
      UNKNOWN = localFileType;
      $VALUES = new FileType[] { JPEG, DNG, VIDEO, localFileType };
    }
    
    private FileType(int paramInt)
    {
      this.value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public static FileType find(int paramInt)
    {
      FileType localFileType = UNKNOWN;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localFileType;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum FocusMode
  {
    private final int value;
    
    static
    {
      AUTO = new FocusMode("AUTO", 1, 1);
      AFC = new FocusMode("AFC", 2, 2);
      FocusMode localFocusMode = new FocusMode("UNKNOWN", 3, 255);
      UNKNOWN = localFocusMode;
      $VALUES = new FocusMode[] { MANUAL, AUTO, AFC, localFocusMode };
    }
    
    private FocusMode(int paramInt)
    {
      this.value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public static FocusMode find(int paramInt)
    {
      FocusMode localFocusMode = UNKNOWN;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localFocusMode;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum FocusStatus
  {
    private final int value;
    
    static
    {
      FOCUSING = new FocusStatus("FOCUSING", 1, 1);
      SUCCESSFUL = new FocusStatus("SUCCESSFUL", 2, 2);
      FAILED = new FocusStatus("FAILED", 3, 3);
      FocusStatus localFocusStatus = new FocusStatus("UNKNOWN", 4, 255);
      UNKNOWN = localFocusStatus;
      $VALUES = new FocusStatus[] { IDLE, FOCUSING, SUCCESSFUL, FAILED, localFocusStatus };
    }
    
    private FocusStatus(int paramInt)
    {
      this.value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public static FocusStatus find(int paramInt)
    {
      FocusStatus localFocusStatus = UNKNOWN;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localFocusStatus;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum ISO
  {
    private final int value;
    
    static
    {
      ISO_1600 = new ISO("ISO_1600", 5, 7);
      ISO_3200 = new ISO("ISO_3200", 6, 8);
      ISO_6400 = new ISO("ISO_6400", 7, 9);
      ISO_12800 = new ISO("ISO_12800", 8, 10);
      ISO_25600 = new ISO("ISO_25600", 9, 11);
      ISO localISO = new ISO("UNKNOWN", 10, 255);
      UNKNOWN = localISO;
      $VALUES = new ISO[] { AUTO, ISO_100, ISO_200, ISO_400, ISO_800, ISO_1600, ISO_3200, ISO_6400, ISO_12800, ISO_25600, localISO };
    }
    
    private ISO(int paramInt)
    {
      this.value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public static ISO find(int paramInt)
    {
      ISO localISO = UNKNOWN;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localISO;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum MeteringMode
  {
    private final int value;
    
    static
    {
      AVERAGE = new MeteringMode("AVERAGE", 1, 1);
      SPOT = new MeteringMode("SPOT", 2, 2);
      MeteringMode localMeteringMode = new MeteringMode("UNKNOWN", 3, 255);
      UNKNOWN = localMeteringMode;
      $VALUES = new MeteringMode[] { CENTER, AVERAGE, SPOT, localMeteringMode };
    }
    
    private MeteringMode(int paramInt)
    {
      this.value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public static MeteringMode find(int paramInt)
    {
      MeteringMode localMeteringMode = UNKNOWN;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localMeteringMode;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static class OpticalZoomSpec
  {
    private final int focalLengthStep;
    private final int maxFocalLength;
    private final int minFocalLength;
    
    public OpticalZoomSpec(int paramInt1, int paramInt2, int paramInt3)
    {
      this.maxFocalLength = paramInt1;
      this.minFocalLength = paramInt2;
      this.focalLengthStep = paramInt3;
    }
    
    public int getFocalLengthStep()
    {
      return this.focalLengthStep;
    }
    
    public int getMaxFocalLength()
    {
      return this.maxFocalLength;
    }
    
    public int getMinFocalLength()
    {
      return this.minFocalLength;
    }
  }
  
  public static enum Orientation
  {
    private final int value;
    
    static
    {
      Orientation localOrientation = new Orientation("UNKNOWN", 2, 255);
      UNKNOWN = localOrientation;
      $VALUES = new Orientation[] { LANDSCAPE, PORTRAIT, localOrientation };
    }
    
    private Orientation(int paramInt)
    {
      this.value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public static Orientation find(int paramInt)
    {
      Orientation localOrientation = UNKNOWN;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localOrientation;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum PhotoAEBCount
  {
    private final int value;
    
    static
    {
      PhotoAEBCount localPhotoAEBCount = new PhotoAEBCount("UNKNOWN", 3, 255);
      UNKNOWN = localPhotoAEBCount;
      $VALUES = new PhotoAEBCount[] { AEB_COUNT_3, AEB_COUNT_5, AEB_COUNT_7, localPhotoAEBCount };
    }
    
    private PhotoAEBCount(int paramInt)
    {
      this.value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public static PhotoAEBCount find(int paramInt)
    {
      PhotoAEBCount localPhotoAEBCount = UNKNOWN;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localPhotoAEBCount;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum PhotoAspectRatio
  {
    private final int cmdValue;
    private final int ordinalValue;
    
    static
    {
      RATIO_16_9 = new PhotoAspectRatio("RATIO_16_9", 1, 1, 1);
      RATIO_3_2 = new PhotoAspectRatio("RATIO_3_2", 2, 2, 2);
      PhotoAspectRatio localPhotoAspectRatio = new PhotoAspectRatio("UNKNOWN", 3, 255, 6);
      UNKNOWN = localPhotoAspectRatio;
      $VALUES = new PhotoAspectRatio[] { RATIO_4_3, RATIO_16_9, RATIO_3_2, localPhotoAspectRatio };
    }
    
    private PhotoAspectRatio(int paramInt1, int paramInt2)
    {
      this.ordinalValue = paramInt1;
      this.cmdValue = paramInt2;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.cmdValue == paramInt;
    }
    
    public static PhotoAspectRatio find(int paramInt)
    {
      PhotoAspectRatio localPhotoAspectRatio = UNKNOWN;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localPhotoAspectRatio;
    }
    
    public int value()
    {
      return this.cmdValue;
    }
  }
  
  public static enum PhotoBurstCount
  {
    private final int value;
    
    static
    {
      BURST_COUNT_10 = new PhotoBurstCount("BURST_COUNT_10", 3, 10);
      BURST_COUNT_14 = new PhotoBurstCount("BURST_COUNT_14", 4, 14);
      CONTINUOUS = new PhotoBurstCount("CONTINUOUS", 5, 255);
      PhotoBurstCount localPhotoBurstCount = new PhotoBurstCount("UNKNOWN", 6, 241);
      UNKNOWN = localPhotoBurstCount;
      $VALUES = new PhotoBurstCount[] { BURST_COUNT_3, BURST_COUNT_5, BURST_COUNT_7, BURST_COUNT_10, BURST_COUNT_14, CONTINUOUS, localPhotoBurstCount };
    }
    
    private PhotoBurstCount(int paramInt)
    {
      this.value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public static PhotoBurstCount find(int paramInt)
    {
      PhotoBurstCount localPhotoBurstCount = UNKNOWN;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localPhotoBurstCount;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum PhotoFileFormat
  {
    private final int value;
    
    static
    {
      JPEG = new PhotoFileFormat("JPEG", 1, 1);
      RAW_AND_JPEG = new PhotoFileFormat("RAW_AND_JPEG", 2, 2);
      TIFF_14_BIT = new PhotoFileFormat("TIFF_14_BIT", 3, 4);
      RADIOMETRIC_JPEG = new PhotoFileFormat("RADIOMETRIC_JPEG", 4, 5);
      TIFF_14_BIT_LINEAR_LOW_TEMP_RESOLUTION = new PhotoFileFormat("TIFF_14_BIT_LINEAR_LOW_TEMP_RESOLUTION", 5, 6);
      TIFF_14_BIT_LINEAR_HIGH_TEMP_RESOLUTION = new PhotoFileFormat("TIFF_14_BIT_LINEAR_HIGH_TEMP_RESOLUTION", 6, 7);
      PhotoFileFormat localPhotoFileFormat = new PhotoFileFormat("UNKNOWN", 7, 255);
      UNKNOWN = localPhotoFileFormat;
      $VALUES = new PhotoFileFormat[] { RAW, JPEG, RAW_AND_JPEG, TIFF_14_BIT, RADIOMETRIC_JPEG, TIFF_14_BIT_LINEAR_LOW_TEMP_RESOLUTION, TIFF_14_BIT_LINEAR_HIGH_TEMP_RESOLUTION, localPhotoFileFormat };
    }
    
    private PhotoFileFormat(int paramInt)
    {
      this.value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public static PhotoFileFormat find(int paramInt)
    {
      PhotoFileFormat localPhotoFileFormat = UNKNOWN;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localPhotoFileFormat;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static class PhotoTimeIntervalSettings
  {
    private final int captureCount;
    private final int timeIntervalInSeconds;
    
    public PhotoTimeIntervalSettings(int paramInt1, int paramInt2)
    {
      this.captureCount = paramInt1;
      this.timeIntervalInSeconds = paramInt2;
    }
    
    public int getCaptureCount()
    {
      return this.captureCount;
    }
    
    public int getTimeIntervalInSeconds()
    {
      return this.timeIntervalInSeconds;
    }
    
    public String toString()
    {
      return null;
    }
  }
  
  public static enum PhotoTimeLapseFileFormat
  {
    private final int value;
    
    static
    {
      JPEG_AND_VIDEO = new PhotoTimeLapseFileFormat("JPEG_AND_VIDEO", 1, 1);
      PhotoTimeLapseFileFormat localPhotoTimeLapseFileFormat = new PhotoTimeLapseFileFormat("UNKNOWN", 2, 255);
      UNKNOWN = localPhotoTimeLapseFileFormat;
      $VALUES = new PhotoTimeLapseFileFormat[] { VIDEO, JPEG_AND_VIDEO, localPhotoTimeLapseFileFormat };
    }
    
    private PhotoTimeLapseFileFormat(int paramInt)
    {
      this.value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public static PhotoTimeLapseFileFormat find(int paramInt)
    {
      PhotoTimeLapseFileFormat localPhotoTimeLapseFileFormat = UNKNOWN;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localPhotoTimeLapseFileFormat;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static class PictureStylePreset
  {
    private final int contrast;
    private final int saturation;
    private final int sharpness;
    
    private PictureStylePreset(Builder paramBuilder)
    {
      this.saturation = paramBuilder.saturation;
      this.sharpness = paramBuilder.sharpness;
      this.contrast = paramBuilder.contrast;
    }
    
    public boolean equals(Object paramObject)
    {
      return false;
    }
    
    public int getContrast()
    {
      return this.contrast;
    }
    
    public int getSaturation()
    {
      return this.saturation;
    }
    
    public int getSharpness()
    {
      return this.sharpness;
    }
    
    public SettingsDefinitions.PictureStylePresetType presetType()
    {
      return null;
    }
    
    public static final class Builder
    {
      private int contrast;
      private int saturation;
      private int sharpness;
      
      public SettingsDefinitions.PictureStylePreset build()
      {
        return new SettingsDefinitions.PictureStylePreset(this, null);
      }
      
      public Builder contrast(int paramInt)
      {
        this.contrast = paramInt;
        return this;
      }
      
      public Builder saturation(int paramInt)
      {
        this.saturation = paramInt;
        return this;
      }
      
      public Builder sharpness(int paramInt)
      {
        this.sharpness = paramInt;
        return this;
      }
    }
  }
  
  public static enum PictureStylePresetType
  {
    private int value;
    
    static
    {
      LANDSCAPE = new PictureStylePresetType("LANDSCAPE", 1, 1);
      SOFT = new PictureStylePresetType("SOFT", 2, 2);
      CUSTOM = new PictureStylePresetType("CUSTOM", 3, 3);
      PictureStylePresetType localPictureStylePresetType = new PictureStylePresetType("UNKNOWN", 4, 255);
      UNKNOWN = localPictureStylePresetType;
      $VALUES = new PictureStylePresetType[] { STANDARD, LANDSCAPE, SOFT, CUSTOM, localPictureStylePresetType };
    }
    
    private PictureStylePresetType(int paramInt)
    {
      this.value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public static PictureStylePresetType find(int paramInt)
    {
      PictureStylePresetType localPictureStylePresetType = UNKNOWN;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localPictureStylePresetType;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum PlaybackDeletionState
  {
    private final int value;
    
    static
    {
      FAILED = new PlaybackDeletionState("FAILED", 1, 1);
      DELETING = new PlaybackDeletionState("DELETING", 2, 2);
      SUCCESSFUL = new PlaybackDeletionState("SUCCESSFUL", 3, 3);
      PlaybackDeletionState localPlaybackDeletionState = new PlaybackDeletionState("UNKNOWN", 4, 255);
      UNKNOWN = localPlaybackDeletionState;
      $VALUES = new PlaybackDeletionState[] { NONE, FAILED, DELETING, SUCCESSFUL, localPlaybackDeletionState };
    }
    
    private PlaybackDeletionState(int paramInt)
    {
      this.value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public static PlaybackDeletionState find(int paramInt)
    {
      PlaybackDeletionState localPlaybackDeletionState = UNKNOWN;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localPlaybackDeletionState;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum PlaybackMode
  {
    private final int value;
    
    static
    {
      SINGLE_VIDEO_PLAYBACK_PAUSED = new PlaybackMode("SINGLE_VIDEO_PLAYBACK_PAUSED", 2, 3);
      MULTIPLE_FILES_EDIT = new PlaybackMode("MULTIPLE_FILES_EDIT", 3, 4);
      MULTIPLE_MEDIA_FILE_PREVIEW = new PlaybackMode("MULTIPLE_MEDIA_FILE_PREVIEW", 4, 5);
      MEDIA_FILE_DOWNLOAD = new PlaybackMode("MEDIA_FILE_DOWNLOAD", 5, 6);
      PlaybackMode localPlaybackMode = new PlaybackMode("UNKNOWN", 6, 255);
      UNKNOWN = localPlaybackMode;
      $VALUES = new PlaybackMode[] { SINGLE_PHOTO_PREVIEW, SINGLE_VIDEO_PLAYBACK_START, SINGLE_VIDEO_PLAYBACK_PAUSED, MULTIPLE_FILES_EDIT, MULTIPLE_MEDIA_FILE_PREVIEW, MEDIA_FILE_DOWNLOAD, localPlaybackMode };
    }
    
    private PlaybackMode(int paramInt)
    {
      this.value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public static PlaybackMode find(int paramInt)
    {
      PlaybackMode localPlaybackMode = UNKNOWN;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localPlaybackMode;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum SSDVideoDigitalFilter
  {
    private final int value;
    
    static
    {
      D_CINELIKE = new SSDVideoDigitalFilter("D_CINELIKE", 1, 44);
      D_LOG = new SSDVideoDigitalFilter("D_LOG", 2, 45);
      D_COLOR_1 = new SSDVideoDigitalFilter("D_COLOR_1", 3, 46);
      D_Color_2 = new SSDVideoDigitalFilter("D_Color_2", 4, 47);
      D_COLOR_3 = new SSDVideoDigitalFilter("D_COLOR_3", 5, 48);
      SSDVideoDigitalFilter localSSDVideoDigitalFilter = new SSDVideoDigitalFilter("UNKNOWN", 6, 255);
      UNKNOWN = localSSDVideoDigitalFilter;
      $VALUES = new SSDVideoDigitalFilter[] { NONE, D_CINELIKE, D_LOG, D_COLOR_1, D_Color_2, D_COLOR_3, localSSDVideoDigitalFilter };
    }
    
    private SSDVideoDigitalFilter(int paramInt)
    {
      this.value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public static SSDVideoDigitalFilter find(int paramInt)
    {
      SSDVideoDigitalFilter localSSDVideoDigitalFilter = UNKNOWN;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localSSDVideoDigitalFilter;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum ShootPhotoMode
  {
    private final DataCameraSetPhoto.TYPE type;
    private final int value;
    
    static
    {
      HDR = new ShootPhotoMode("HDR", 1, 1, DataCameraSetPhoto.TYPE.HDR);
      BURST = new ShootPhotoMode("BURST", 2, 2, DataCameraSetPhoto.TYPE.BURST);
      AEB = new ShootPhotoMode("AEB", 3, 3, DataCameraSetPhoto.TYPE.AEB);
      INTERVAL = new ShootPhotoMode("INTERVAL", 4, 4, DataCameraSetPhoto.TYPE.TIME);
      TIME_LAPSE = new ShootPhotoMode("TIME_LAPSE", 5, 5, DataCameraSetPhoto.TYPE.TIME);
      PANORAMA = new ShootPhotoMode("PANORAMA", 6, 6, DataCameraSetPhoto.TYPE.APP_FULLVIEW);
      RAW_BURST = new ShootPhotoMode("RAW_BURST", 7, 7, DataCameraSetPhoto.TYPE.RAWBURST);
      ShootPhotoMode localShootPhotoMode = new ShootPhotoMode("UNKNOWN", 8, 255, DataCameraSetPhoto.TYPE.OTHER);
      UNKNOWN = localShootPhotoMode;
      $VALUES = new ShootPhotoMode[] { SINGLE, HDR, BURST, AEB, INTERVAL, TIME_LAPSE, PANORAMA, RAW_BURST, localShootPhotoMode };
    }
    
    private ShootPhotoMode(int paramInt, DataCameraSetPhoto.TYPE paramTYPE)
    {
      this.value = paramInt;
      this.type = paramTYPE;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public static ShootPhotoMode find(int paramInt)
    {
      ShootPhotoMode localShootPhotoMode = INTERVAL;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localShootPhotoMode;
    }
    
    public static ShootPhotoMode find(DataCameraSetPhoto.TYPE paramTYPE)
    {
      if (paramTYPE == null) {
        return SINGLE;
      }
      ShootPhotoMode localShootPhotoMode = SINGLE;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i].getInternalTypeValue() == paramTYPE.value()) {
          return values()[i];
        }
        i += 1;
      }
      return localShootPhotoMode;
    }
    
    public int getInternalTypeValue()
    {
      DataCameraSetPhoto.TYPE localTYPE = this.type;
      if (localTYPE != null) {
        return localTYPE.value();
      }
      return -1;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum ShutterSpeed
  {
    private final float shutterSpeed;
    
    static
    {
      SHUTTER_SPEED_1_6400 = new ShutterSpeed("SHUTTER_SPEED_1_6400", 1, 1.5625E-4F);
      SHUTTER_SPEED_1_6000 = new ShutterSpeed("SHUTTER_SPEED_1_6000", 2, 1.6666666E-4F);
      SHUTTER_SPEED_1_5000 = new ShutterSpeed("SHUTTER_SPEED_1_5000", 3, 2.0E-4F);
      SHUTTER_SPEED_1_4000 = new ShutterSpeed("SHUTTER_SPEED_1_4000", 4, 2.5E-4F);
      SHUTTER_SPEED_1_3200 = new ShutterSpeed("SHUTTER_SPEED_1_3200", 5, 3.125E-4F);
      SHUTTER_SPEED_1_3000 = new ShutterSpeed("SHUTTER_SPEED_1_3000", 6, 3.3333333E-4F);
      SHUTTER_SPEED_1_2500 = new ShutterSpeed("SHUTTER_SPEED_1_2500", 7, 4.0E-4F);
      SHUTTER_SPEED_1_2000 = new ShutterSpeed("SHUTTER_SPEED_1_2000", 8, 5.0E-4F);
      SHUTTER_SPEED_1_1600 = new ShutterSpeed("SHUTTER_SPEED_1_1600", 9, 6.25E-4F);
      SHUTTER_SPEED_1_1500 = new ShutterSpeed("SHUTTER_SPEED_1_1500", 10, 6.6666666E-4F);
      SHUTTER_SPEED_1_1250 = new ShutterSpeed("SHUTTER_SPEED_1_1250", 11, 8.0E-4F);
      SHUTTER_SPEED_1_1000 = new ShutterSpeed("SHUTTER_SPEED_1_1000", 12, 0.001F);
      SHUTTER_SPEED_1_800 = new ShutterSpeed("SHUTTER_SPEED_1_800", 13, 0.00125F);
      SHUTTER_SPEED_1_725 = new ShutterSpeed("SHUTTER_SPEED_1_725", 14, 0.0013793104F);
      SHUTTER_SPEED_1_640 = new ShutterSpeed("SHUTTER_SPEED_1_640", 15, 0.0015625F);
      SHUTTER_SPEED_1_500 = new ShutterSpeed("SHUTTER_SPEED_1_500", 16, 0.002F);
      SHUTTER_SPEED_1_400 = new ShutterSpeed("SHUTTER_SPEED_1_400", 17, 0.0025F);
      SHUTTER_SPEED_1_350 = new ShutterSpeed("SHUTTER_SPEED_1_350", 18, 0.0028571428F);
      SHUTTER_SPEED_1_320 = new ShutterSpeed("SHUTTER_SPEED_1_320", 19, 0.003125F);
      SHUTTER_SPEED_1_250 = new ShutterSpeed("SHUTTER_SPEED_1_250", 20, 0.004F);
      SHUTTER_SPEED_1_240 = new ShutterSpeed("SHUTTER_SPEED_1_240", 21, 0.004166667F);
      SHUTTER_SPEED_1_200 = new ShutterSpeed("SHUTTER_SPEED_1_200", 22, 0.005F);
      SHUTTER_SPEED_1_180 = new ShutterSpeed("SHUTTER_SPEED_1_180", 23, 0.0055555557F);
      SHUTTER_SPEED_1_160 = new ShutterSpeed("SHUTTER_SPEED_1_160", 24, 0.00625F);
      SHUTTER_SPEED_1_125 = new ShutterSpeed("SHUTTER_SPEED_1_125", 25, 0.008F);
      SHUTTER_SPEED_1_120 = new ShutterSpeed("SHUTTER_SPEED_1_120", 26, 0.008333334F);
      SHUTTER_SPEED_1_100 = new ShutterSpeed("SHUTTER_SPEED_1_100", 27, 0.01F);
      SHUTTER_SPEED_1_90 = new ShutterSpeed("SHUTTER_SPEED_1_90", 28, 0.011111111F);
      SHUTTER_SPEED_1_80 = new ShutterSpeed("SHUTTER_SPEED_1_80", 29, 0.0125F);
      SHUTTER_SPEED_1_60 = new ShutterSpeed("SHUTTER_SPEED_1_60", 30, 0.016666668F);
      SHUTTER_SPEED_1_50 = new ShutterSpeed("SHUTTER_SPEED_1_50", 31, 0.02F);
      SHUTTER_SPEED_1_40 = new ShutterSpeed("SHUTTER_SPEED_1_40", 32, 0.025F);
      SHUTTER_SPEED_1_30 = new ShutterSpeed("SHUTTER_SPEED_1_30", 33, 0.033333335F);
      SHUTTER_SPEED_1_25 = new ShutterSpeed("SHUTTER_SPEED_1_25", 34, 0.04F);
      SHUTTER_SPEED_1_20 = new ShutterSpeed("SHUTTER_SPEED_1_20", 35, 0.05F);
      SHUTTER_SPEED_1_15 = new ShutterSpeed("SHUTTER_SPEED_1_15", 36, 0.06666667F);
      SHUTTER_SPEED_1_12_DOT_5 = new ShutterSpeed("SHUTTER_SPEED_1_12_DOT_5", 37, 0.08F);
      SHUTTER_SPEED_1_10 = new ShutterSpeed("SHUTTER_SPEED_1_10", 38, 0.1F);
      SHUTTER_SPEED_1_8 = new ShutterSpeed("SHUTTER_SPEED_1_8", 39, 0.125F);
      SHUTTER_SPEED_1_6_DOT_25 = new ShutterSpeed("SHUTTER_SPEED_1_6_DOT_25", 40, 0.16F);
      SHUTTER_SPEED_1_5 = new ShutterSpeed("SHUTTER_SPEED_1_5", 41, 0.2F);
      SHUTTER_SPEED_1_4 = new ShutterSpeed("SHUTTER_SPEED_1_4", 42, 0.25F);
      SHUTTER_SPEED_1_3 = new ShutterSpeed("SHUTTER_SPEED_1_3", 43, 0.33333334F);
      SHUTTER_SPEED_1_2_DOT_5 = new ShutterSpeed("SHUTTER_SPEED_1_2_DOT_5", 44, 0.4F);
      SHUTTER_SPEED_1_2 = new ShutterSpeed("SHUTTER_SPEED_1_2", 45, 0.5F);
      SHUTTER_SPEED_1_1_DOT_67 = new ShutterSpeed("SHUTTER_SPEED_1_1_DOT_67", 46, 0.5988024F);
      SHUTTER_SPEED_1_1_DOT_25 = new ShutterSpeed("SHUTTER_SPEED_1_1_DOT_25", 47, 0.8F);
      SHUTTER_SPEED_1 = new ShutterSpeed("SHUTTER_SPEED_1", 48, 1.0F);
      SHUTTER_SPEED_1_DOT_3 = new ShutterSpeed("SHUTTER_SPEED_1_DOT_3", 49, 1.3F);
      SHUTTER_SPEED_1_DOT_6 = new ShutterSpeed("SHUTTER_SPEED_1_DOT_6", 50, 1.6F);
      SHUTTER_SPEED_2 = new ShutterSpeed("SHUTTER_SPEED_2", 51, 2.0F);
      SHUTTER_SPEED_2_DOT_5 = new ShutterSpeed("SHUTTER_SPEED_2_DOT_5", 52, 2.5F);
      SHUTTER_SPEED_3 = new ShutterSpeed("SHUTTER_SPEED_3", 53, 3.0F);
      SHUTTER_SPEED_3_DOT_2 = new ShutterSpeed("SHUTTER_SPEED_3_DOT_2", 54, 3.2F);
      SHUTTER_SPEED_4 = new ShutterSpeed("SHUTTER_SPEED_4", 55, 4.0F);
      SHUTTER_SPEED_5 = new ShutterSpeed("SHUTTER_SPEED_5", 56, 5.0F);
      SHUTTER_SPEED_6 = new ShutterSpeed("SHUTTER_SPEED_6", 57, 6.0F);
      SHUTTER_SPEED_7 = new ShutterSpeed("SHUTTER_SPEED_7", 58, 7.0F);
      SHUTTER_SPEED_8 = new ShutterSpeed("SHUTTER_SPEED_8", 59, 8.0F);
      SHUTTER_SPEED_9 = new ShutterSpeed("SHUTTER_SPEED_9", 60, 9.0F);
      SHUTTER_SPEED_10 = new ShutterSpeed("SHUTTER_SPEED_10", 61, 10.0F);
      SHUTTER_SPEED_13 = new ShutterSpeed("SHUTTER_SPEED_13", 62, 13.0F);
      SHUTTER_SPEED_15 = new ShutterSpeed("SHUTTER_SPEED_15", 63, 15.0F);
      SHUTTER_SPEED_20 = new ShutterSpeed("SHUTTER_SPEED_20", 64, 20.0F);
      SHUTTER_SPEED_25 = new ShutterSpeed("SHUTTER_SPEED_25", 65, 25.0F);
      SHUTTER_SPEED_30 = new ShutterSpeed("SHUTTER_SPEED_30", 66, 30.0F);
      ShutterSpeed localShutterSpeed = new ShutterSpeed("UNKNOWN", 67, 255.0F);
      UNKNOWN = localShutterSpeed;
      $VALUES = new ShutterSpeed[] { SHUTTER_SPEED_1_8000, SHUTTER_SPEED_1_6400, SHUTTER_SPEED_1_6000, SHUTTER_SPEED_1_5000, SHUTTER_SPEED_1_4000, SHUTTER_SPEED_1_3200, SHUTTER_SPEED_1_3000, SHUTTER_SPEED_1_2500, SHUTTER_SPEED_1_2000, SHUTTER_SPEED_1_1600, SHUTTER_SPEED_1_1500, SHUTTER_SPEED_1_1250, SHUTTER_SPEED_1_1000, SHUTTER_SPEED_1_800, SHUTTER_SPEED_1_725, SHUTTER_SPEED_1_640, SHUTTER_SPEED_1_500, SHUTTER_SPEED_1_400, SHUTTER_SPEED_1_350, SHUTTER_SPEED_1_320, SHUTTER_SPEED_1_250, SHUTTER_SPEED_1_240, SHUTTER_SPEED_1_200, SHUTTER_SPEED_1_180, SHUTTER_SPEED_1_160, SHUTTER_SPEED_1_125, SHUTTER_SPEED_1_120, SHUTTER_SPEED_1_100, SHUTTER_SPEED_1_90, SHUTTER_SPEED_1_80, SHUTTER_SPEED_1_60, SHUTTER_SPEED_1_50, SHUTTER_SPEED_1_40, SHUTTER_SPEED_1_30, SHUTTER_SPEED_1_25, SHUTTER_SPEED_1_20, SHUTTER_SPEED_1_15, SHUTTER_SPEED_1_12_DOT_5, SHUTTER_SPEED_1_10, SHUTTER_SPEED_1_8, SHUTTER_SPEED_1_6_DOT_25, SHUTTER_SPEED_1_5, SHUTTER_SPEED_1_4, SHUTTER_SPEED_1_3, SHUTTER_SPEED_1_2_DOT_5, SHUTTER_SPEED_1_2, SHUTTER_SPEED_1_1_DOT_67, SHUTTER_SPEED_1_1_DOT_25, SHUTTER_SPEED_1, SHUTTER_SPEED_1_DOT_3, SHUTTER_SPEED_1_DOT_6, SHUTTER_SPEED_2, SHUTTER_SPEED_2_DOT_5, SHUTTER_SPEED_3, SHUTTER_SPEED_3_DOT_2, SHUTTER_SPEED_4, SHUTTER_SPEED_5, SHUTTER_SPEED_6, SHUTTER_SPEED_7, SHUTTER_SPEED_8, SHUTTER_SPEED_9, SHUTTER_SPEED_10, SHUTTER_SPEED_13, SHUTTER_SPEED_15, SHUTTER_SPEED_20, SHUTTER_SPEED_25, SHUTTER_SPEED_30, localShutterSpeed };
    }
    
    private ShutterSpeed(float paramFloat)
    {
      this.shutterSpeed = paramFloat;
    }
    
    public static ShutterSpeed find(float paramFloat)
    {
      ShutterSpeed[] arrayOfShutterSpeed = values();
      int j = arrayOfShutterSpeed.length;
      int i = 0;
      while (i < j)
      {
        ShutterSpeed localShutterSpeed = arrayOfShutterSpeed[i];
        if (localShutterSpeed.shutterSpeed == paramFloat) {
          return localShutterSpeed;
        }
        i += 1;
      }
      return null;
    }
    
    public float value()
    {
      return this.shutterSpeed;
    }
  }
  
  public static enum StreamQuality
  {
    static
    {
      StreamQuality localStreamQuality = new StreamQuality("HIGH_QUALITY", 1);
      HIGH_QUALITY = localStreamQuality;
      $VALUES = new StreamQuality[] { NORMAL, localStreamQuality };
    }
    
    private StreamQuality() {}
  }
  
  public static enum ThermalCustomExternalSceneSettingsProfile
  {
    private final int value;
    
    static
    {
      ThermalCustomExternalSceneSettingsProfile localThermalCustomExternalSceneSettingsProfile = new ThermalCustomExternalSceneSettingsProfile("UNKNOWN", 3, 99);
      UNKNOWN = localThermalCustomExternalSceneSettingsProfile;
      $VALUES = new ThermalCustomExternalSceneSettingsProfile[] { PROFILE_1, PROFILE_2, PROFILE_3, localThermalCustomExternalSceneSettingsProfile };
    }
    
    private ThermalCustomExternalSceneSettingsProfile(int paramInt)
    {
      this.value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public static ThermalCustomExternalSceneSettingsProfile find(int paramInt)
    {
      ThermalCustomExternalSceneSettingsProfile localThermalCustomExternalSceneSettingsProfile = UNKNOWN;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localThermalCustomExternalSceneSettingsProfile;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum ThermalDigitalZoomFactor
  {
    private final int value;
    
    static
    {
      ThermalDigitalZoomFactor localThermalDigitalZoomFactor = new ThermalDigitalZoomFactor("UNKNOWN", 4, 255);
      UNKNOWN = localThermalDigitalZoomFactor;
      $VALUES = new ThermalDigitalZoomFactor[] { X_1, X_2, X_4, X_8, localThermalDigitalZoomFactor };
    }
    
    private ThermalDigitalZoomFactor(int paramInt)
    {
      this.value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum ThermalFFCMode
  {
    private final int value;
    
    static
    {
      ThermalFFCMode localThermalFFCMode = new ThermalFFCMode("UNKNOWN", 2, 255);
      UNKNOWN = localThermalFFCMode;
      $VALUES = new ThermalFFCMode[] { AUTO, MANUAL, localThermalFFCMode };
    }
    
    private ThermalFFCMode(int paramInt)
    {
      this.value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public static ThermalFFCMode find(int paramInt)
    {
      ThermalFFCMode localThermalFFCMode = UNKNOWN;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localThermalFFCMode;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum ThermalFrameRateUpperBound
  {
    private final int value;
    
    static
    {
      UPPER_BOUND_30_HZ = new ThermalFrameRateUpperBound("UPPER_BOUND_30_HZ", 1, 4);
      ThermalFrameRateUpperBound localThermalFrameRateUpperBound = new ThermalFrameRateUpperBound("UNKNOWN", 2, 255);
      UNKNOWN = localThermalFrameRateUpperBound;
      $VALUES = new ThermalFrameRateUpperBound[] { UPPER_BOUND_8_DOT_3_HZ, UPPER_BOUND_30_HZ, localThermalFrameRateUpperBound };
    }
    
    private ThermalFrameRateUpperBound(int paramInt)
    {
      this.value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public static ThermalFrameRateUpperBound find(int paramInt)
    {
      ThermalFrameRateUpperBound localThermalFrameRateUpperBound = UNKNOWN;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localThermalFrameRateUpperBound;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum ThermalGainMode
  {
    private final int value;
    
    static
    {
      HIGH = new ThermalGainMode("HIGH", 2, 2);
      ThermalGainMode localThermalGainMode = new ThermalGainMode("UNKNOWN", 3, 100);
      UNKNOWN = localThermalGainMode;
      $VALUES = new ThermalGainMode[] { AUTO, LOW, HIGH, localThermalGainMode };
    }
    
    private ThermalGainMode(int paramInt)
    {
      this.value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public static ThermalGainMode find(int paramInt)
    {
      ThermalGainMode localThermalGainMode = UNKNOWN;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localThermalGainMode;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum ThermalIsothermUnit
  {
    private final int value;
    
    static
    {
      CELSIUS = new ThermalIsothermUnit("CELSIUS", 1, 1);
      ThermalIsothermUnit localThermalIsothermUnit = new ThermalIsothermUnit("UNKNOWN", 2, 255);
      UNKNOWN = localThermalIsothermUnit;
      $VALUES = new ThermalIsothermUnit[] { PERCENTAGE, CELSIUS, localThermalIsothermUnit };
    }
    
    private ThermalIsothermUnit(int paramInt)
    {
      this.value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum ThermalLensFocalLength
  {
    private final int value;
    
    static
    {
      LENGTH_13_MM = new ThermalLensFocalLength("LENGTH_13_MM", 3, 3);
      LENGTH_19_MM = new ThermalLensFocalLength("LENGTH_19_MM", 4, 4);
      ThermalLensFocalLength localThermalLensFocalLength = new ThermalLensFocalLength("UNKNOWN", 5, 255);
      UNKNOWN = localThermalLensFocalLength;
      $VALUES = new ThermalLensFocalLength[] { LENGTH_6_DOT_8_MM, LENGTH_7_DOT_5_MM, LENGTH_9_MM, LENGTH_13_MM, LENGTH_19_MM, localThermalLensFocalLength };
    }
    
    private ThermalLensFocalLength(int paramInt)
    {
      this.value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum ThermalPalette
  {
    private final int innerValue;
    private final int value;
    
    static
    {
      BLACK_HOT = new ThermalPalette("BLACK_HOT", 1, 1, 25);
      FUSION = new ThermalPalette("FUSION", 2, 2, 26);
      RAINBOW = new ThermalPalette("RAINBOW", 3, 3, 27);
      IRONBOW_1 = new ThermalPalette("IRONBOW_1", 4, 4, 28);
      ICE_FIRE = new ThermalPalette("ICE_FIRE", 5, 5, 29);
      SEPIA = new ThermalPalette("SEPIA", 6, 6, 30);
      GLOWBOW = new ThermalPalette("GLOWBOW", 7, 7, 31);
      IRONBOW_2 = new ThermalPalette("IRONBOW_2", 8, 8, 32);
      COLOR_1 = new ThermalPalette("COLOR_1", 9, 9, 33);
      COLOR_2 = new ThermalPalette("COLOR_2", 10, 10, 34);
      RAIN = new ThermalPalette("RAIN", 11, 11, 35);
      RED_HOT = new ThermalPalette("RED_HOT", 12, 12, 36);
      GREEN_HOT = new ThermalPalette("GREEN_HOT", 13, 13, 37);
      ThermalPalette localThermalPalette = new ThermalPalette("UNKNOWN", 14, 255, 255);
      UNKNOWN = localThermalPalette;
      $VALUES = new ThermalPalette[] { WHITE_HOT, BLACK_HOT, FUSION, RAINBOW, IRONBOW_1, ICE_FIRE, SEPIA, GLOWBOW, IRONBOW_2, COLOR_1, COLOR_2, RAIN, RED_HOT, GREEN_HOT, localThermalPalette };
    }
    
    private ThermalPalette(int paramInt1, int paramInt2)
    {
      this.value = paramInt1;
      this.innerValue = paramInt2;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public static ThermalPalette find(int paramInt)
    {
      ThermalPalette localThermalPalette = UNKNOWN;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localThermalPalette;
    }
    
    public int getInnerValue()
    {
      return this.innerValue;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static class ThermalProfile
  {
    private final SettingsDefinitions.ThermalLensFocalLength focalLength;
    private final SettingsDefinitions.ThermalFrameRateUpperBound frameRateUpperBound;
    private final SettingsDefinitions.ThermalResolution resolution;
    private final ThermalVersion version;
    
    public ThermalProfile(Builder paramBuilder)
    {
      this.resolution = paramBuilder.resolution;
      this.frameRateUpperBound = paramBuilder.frameRateUpperBound;
      this.focalLength = paramBuilder.focalLength;
      this.version = paramBuilder.version;
    }
    
    public SettingsDefinitions.ThermalLensFocalLength getFocalLength()
    {
      return this.focalLength;
    }
    
    public SettingsDefinitions.ThermalFrameRateUpperBound getFrameRateUpperBound()
    {
      return this.frameRateUpperBound;
    }
    
    public SettingsDefinitions.ThermalResolution getResolution()
    {
      return this.resolution;
    }
    
    public ThermalVersion getVersion()
    {
      return this.version;
    }
    
    public String toString()
    {
      return null;
    }
    
    public static final class Builder
    {
      private SettingsDefinitions.ThermalLensFocalLength focalLength;
      private SettingsDefinitions.ThermalFrameRateUpperBound frameRateUpperBound;
      private SettingsDefinitions.ThermalResolution resolution;
      private ThermalVersion version;
      
      public SettingsDefinitions.ThermalProfile build()
      {
        return new SettingsDefinitions.ThermalProfile(this);
      }
      
      public Builder focalLength(SettingsDefinitions.ThermalLensFocalLength paramThermalLensFocalLength)
      {
        this.focalLength = paramThermalLensFocalLength;
        return this;
      }
      
      public Builder frameRateUpperBound(SettingsDefinitions.ThermalFrameRateUpperBound paramThermalFrameRateUpperBound)
      {
        this.frameRateUpperBound = paramThermalFrameRateUpperBound;
        return this;
      }
      
      public Builder resolution(SettingsDefinitions.ThermalResolution paramThermalResolution)
      {
        this.resolution = paramThermalResolution;
        return this;
      }
      
      public Builder version(ThermalVersion paramThermalVersion)
      {
        this.version = paramThermalVersion;
        return this;
      }
    }
  }
  
  public static enum ThermalROI
  {
    private final int innerValue;
    private final int value;
    
    static
    {
      ThermalROI localThermalROI = new ThermalROI("UNKNOWN", 3, 255, 100);
      UNKNOWN = localThermalROI;
      $VALUES = new ThermalROI[] { FULL, SKY_EXCLUDED_33, SKY_EXCLUDED_50, localThermalROI };
    }
    
    private ThermalROI(int paramInt1, int paramInt2)
    {
      this.value = paramInt1;
      this.innerValue = paramInt2;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.innerValue == paramInt;
    }
    
    public static ThermalROI find(int paramInt)
    {
      ThermalROI localThermalROI = UNKNOWN;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localThermalROI;
    }
    
    public int getInnerValue()
    {
      return this.innerValue;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum ThermalResolution
  {
    private final int value;
    
    static
    {
      ThermalResolution localThermalResolution = new ThermalResolution("UNKNOWN", 2, 255);
      UNKNOWN = localThermalResolution;
      $VALUES = new ThermalResolution[] { RESOLUTION_336x256, RESOLUTION_640x512, localThermalResolution };
    }
    
    private ThermalResolution(int paramInt)
    {
      this.value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum ThermalScene
  {
    private final int innerValue;
    private final int value;
    
    static
    {
      DEFAULT = new ThermalScene("DEFAULT", 1, 1, 1);
      SEA_SKY = new ThermalScene("SEA_SKY", 2, 2, 2);
      OUTDOOR = new ThermalScene("OUTDOOR", 3, 3, 3);
      INDOOR = new ThermalScene("INDOOR", 4, 4, 4);
      MANUAL = new ThermalScene("MANUAL", 5, 5, 5);
      PROFILE_1 = new ThermalScene("PROFILE_1", 6, 6, 6);
      PROFILE_2 = new ThermalScene("PROFILE_2", 7, 7, 7);
      PROFILE_3 = new ThermalScene("PROFILE_3", 8, 8, 8);
      ThermalScene localThermalScene = new ThermalScene("UNKNOWN", 9, 255, 100);
      UNKNOWN = localThermalScene;
      $VALUES = new ThermalScene[] { LINEAR, DEFAULT, SEA_SKY, OUTDOOR, INDOOR, MANUAL, PROFILE_1, PROFILE_2, PROFILE_3, localThermalScene };
    }
    
    private ThermalScene(int paramInt1, int paramInt2)
    {
      this.value = paramInt1;
      this.innerValue = paramInt2;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.innerValue == paramInt;
    }
    
    public static ThermalScene find(int paramInt)
    {
      ThermalScene localThermalScene = UNKNOWN;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localThermalScene;
    }
    
    public int getInnerValue()
    {
      return this.innerValue;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum VideoFileCompressionStandard
  {
    private final int ordinalValue;
    private final int value;
    
    static
    {
      VideoFileCompressionStandard localVideoFileCompressionStandard = new VideoFileCompressionStandard("Unknown", 2, 255, 100);
      Unknown = localVideoFileCompressionStandard;
      $VALUES = new VideoFileCompressionStandard[] { H264, H265, localVideoFileCompressionStandard };
    }
    
    private VideoFileCompressionStandard(int paramInt1, int paramInt2)
    {
      this.ordinalValue = paramInt1;
      this.value = paramInt2;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public static VideoFileCompressionStandard find(int paramInt)
    {
      VideoFileCompressionStandard localVideoFileCompressionStandard = Unknown;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localVideoFileCompressionStandard;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum VideoFileFormat
  {
    private final int value;
    
    static
    {
      VideoFileFormat localVideoFileFormat = new VideoFileFormat("UNKNOWN", 2, 255);
      UNKNOWN = localVideoFileFormat;
      $VALUES = new VideoFileFormat[] { MOV, MP4, localVideoFileFormat };
    }
    
    private VideoFileFormat(int paramInt)
    {
      this.value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public static VideoFileFormat find(int paramInt)
    {
      VideoFileFormat localVideoFileFormat = UNKNOWN;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localVideoFileFormat;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum VideoFrameRate
  {
    private final int cmdValue;
    private final int value;
    
    static
    {
      FRAME_RATE_100_FPS = new VideoFrameRate("FRAME_RATE_100_FPS", 12, 11, 10);
      FRAME_RATE_120_FPS = new VideoFrameRate("FRAME_RATE_120_FPS", 13, 12, 7);
      VideoFrameRate localVideoFrameRate = new VideoFrameRate("UNKNOWN", 14, 255, 255);
      UNKNOWN = localVideoFrameRate;
      $VALUES = new VideoFrameRate[] { FRAME_RATE_23_DOT_976_FPS, FRAME_RATE_24_FPS, FRAME_RATE_25_FPS, FRAME_RATE_29_DOT_970_FPS, FRAME_RATE_30_FPS, FRAME_RATE_47_DOT_950_FPS, FRAME_RATE_48_FPS, FRAME_RATE_50_FPS, FRAME_RATE_59_DOT_940_FPS, FRAME_RATE_60_FPS, FRAME_RATE_90_FPS, FRAME_RATE_96_FPS, FRAME_RATE_100_FPS, FRAME_RATE_120_FPS, localVideoFrameRate };
    }
    
    private VideoFrameRate(int paramInt1, int paramInt2)
    {
      this.value = paramInt1;
      this.cmdValue = paramInt2;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public static VideoFrameRate find(int paramInt)
    {
      VideoFrameRate localVideoFrameRate = UNKNOWN;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localVideoFrameRate;
    }
    
    public int cmdValue()
    {
      return this.cmdValue;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum VideoResolution
  {
    private final int value;
    
    static
    {
      RESOLUTION_1280x720 = new VideoResolution("RESOLUTION_1280x720", 2, 2);
      RESOLUTION_1920x1080 = new VideoResolution("RESOLUTION_1920x1080", 3, 3);
      RESOLUTION_2704x1520 = new VideoResolution("RESOLUTION_2704x1520", 4, 4);
      RESOLUTION_2720x1530 = new VideoResolution("RESOLUTION_2720x1530", 5, 5);
      RESOLUTION_3840x1572 = new VideoResolution("RESOLUTION_3840x1572", 6, 6);
      RESOLUTION_3840x2160 = new VideoResolution("RESOLUTION_3840x2160", 7, 7);
      RESOLUTION_4096x2160 = new VideoResolution("RESOLUTION_4096x2160", 8, 8);
      RESOLUTION_4608x2160 = new VideoResolution("RESOLUTION_4608x2160", 9, 9);
      RESOLUTION_4608x2592 = new VideoResolution("RESOLUTION_4608x2592", 10, 10);
      RESOLUTION_5280x2160 = new VideoResolution("RESOLUTION_5280x2160", 11, 11);
      RESOLUTION_MAX = new VideoResolution("RESOLUTION_MAX", 12, 12);
      NO_SSD_VIDEO = new VideoResolution("NO_SSD_VIDEO", 13, 13);
      VideoResolution localVideoResolution = new VideoResolution("UNKNOWN", 14, 255);
      UNKNOWN = localVideoResolution;
      $VALUES = new VideoResolution[] { RESOLUTION_640x480, RESOLUTION_640x512, RESOLUTION_1280x720, RESOLUTION_1920x1080, RESOLUTION_2704x1520, RESOLUTION_2720x1530, RESOLUTION_3840x1572, RESOLUTION_3840x2160, RESOLUTION_4096x2160, RESOLUTION_4608x2160, RESOLUTION_4608x2592, RESOLUTION_5280x2160, RESOLUTION_MAX, NO_SSD_VIDEO, localVideoResolution };
    }
    
    private VideoResolution(int paramInt)
    {
      this.value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public static VideoResolution find(int paramInt)
    {
      VideoResolution localVideoResolution = UNKNOWN;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localVideoResolution;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum VideoStandard
  {
    private final int value;
    
    static
    {
      NTSC = new VideoStandard("NTSC", 1, 1);
      VideoStandard localVideoStandard = new VideoStandard("UNKNOWN", 2, 255);
      UNKNOWN = localVideoStandard;
      $VALUES = new VideoStandard[] { PAL, NTSC, localVideoStandard };
    }
    
    private VideoStandard(int paramInt)
    {
      this.value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public static VideoStandard find(int paramInt)
    {
      VideoStandard localVideoStandard = UNKNOWN;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localVideoStandard;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum WhiteBalancePreset
  {
    private final int value;
    
    static
    {
      CLOUDY = new WhiteBalancePreset("CLOUDY", 2, 2);
      WATER_SURFACE = new WhiteBalancePreset("WATER_SURFACE", 3, 3);
      INDOOR_INCANDESCENT = new WhiteBalancePreset("INDOOR_INCANDESCENT", 4, 4);
      INDOOR_FLUORESCENT = new WhiteBalancePreset("INDOOR_FLUORESCENT", 5, 5);
      CUSTOM = new WhiteBalancePreset("CUSTOM", 6, 6);
      WhiteBalancePreset localWhiteBalancePreset = new WhiteBalancePreset("UNKNOWN", 7, 255);
      UNKNOWN = localWhiteBalancePreset;
      $VALUES = new WhiteBalancePreset[] { AUTO, SUNNY, CLOUDY, WATER_SURFACE, INDOOR_INCANDESCENT, INDOOR_FLUORESCENT, CUSTOM, localWhiteBalancePreset };
    }
    
    private WhiteBalancePreset(int paramInt)
    {
      this.value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public static WhiteBalancePreset find(int paramInt)
    {
      WhiteBalancePreset localWhiteBalancePreset = UNKNOWN;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localWhiteBalancePreset;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum ZoomDirection
  {
    private final int value;
    
    static
    {
      ZOOM_IN = new ZoomDirection("ZOOM_IN", 1, 1);
      ZoomDirection localZoomDirection = new ZoomDirection("UNKNOWN", 2, 255);
      UNKNOWN = localZoomDirection;
      $VALUES = new ZoomDirection[] { ZOOM_OUT, ZOOM_IN, localZoomDirection };
    }
    
    private ZoomDirection(int paramInt)
    {
      this.value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public static ZoomDirection find(int paramInt)
    {
      ZoomDirection localZoomDirection = UNKNOWN;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localZoomDirection;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum ZoomSpeed
  {
    private final int value;
    
    static
    {
      SLOW = new ZoomSpeed("SLOW", 1, 73);
      MODERATELY_SLOW = new ZoomSpeed("MODERATELY_SLOW", 2, 74);
      NORMAL = new ZoomSpeed("NORMAL", 3, 75);
      MODERATELY_FAST = new ZoomSpeed("MODERATELY_FAST", 4, 76);
      FAST = new ZoomSpeed("FAST", 5, 77);
      ZoomSpeed localZoomSpeed = new ZoomSpeed("FASTEST", 6, 78);
      FASTEST = localZoomSpeed;
      $VALUES = new ZoomSpeed[] { SLOWEST, SLOW, MODERATELY_SLOW, NORMAL, MODERATELY_FAST, FAST, localZoomSpeed };
    }
    
    private ZoomSpeed(int paramInt)
    {
      this.value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public int value()
    {
      return this.value;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\camera\SettingsDefinitions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */