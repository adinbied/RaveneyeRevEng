package com.drew.metadata.exif.makernotes;

import com.drew.metadata.TagDescriptor;
import java.util.HashMap;

public class CanonMakernoteDescriptor
  extends TagDescriptor<CanonMakernoteDirectory>
{
  private static final HashMap<Integer, String> _lensTypeById;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _lensTypeById = localHashMap;
    localHashMap.put(Integer.valueOf(1), "Canon EF 50mm f/1.8");
    _lensTypeById.put(Integer.valueOf(2), "Canon EF 28mm f/2.8");
    _lensTypeById.put(Integer.valueOf(3), "Canon EF 135mm f/2.8 Soft");
    _lensTypeById.put(Integer.valueOf(4), "Canon EF 35-105mm f/3.5-4.5 or Sigma Lens");
    _lensTypeById.put(Integer.valueOf(5), "Canon EF 35-70mm f/3.5-4.5");
    _lensTypeById.put(Integer.valueOf(6), "Canon EF 28-70mm f/3.5-4.5 or Sigma or Tokina Lens");
    _lensTypeById.put(Integer.valueOf(7), "Canon EF 100-300mm f/5.6L");
    _lensTypeById.put(Integer.valueOf(8), "Canon EF 100-300mm f/5.6 or Sigma or Tokina Lens");
    _lensTypeById.put(Integer.valueOf(9), "Canon EF 70-210mm f/4");
    _lensTypeById.put(Integer.valueOf(10), "Canon EF 50mm f/2.5 Macro or Sigma Lens");
    _lensTypeById.put(Integer.valueOf(11), "Canon EF 35mm f/2");
    _lensTypeById.put(Integer.valueOf(13), "Canon EF 15mm f/2.8 Fisheye");
    _lensTypeById.put(Integer.valueOf(14), "Canon EF 50-200mm f/3.5-4.5L");
    _lensTypeById.put(Integer.valueOf(15), "Canon EF 50-200mm f/3.5-4.5");
    _lensTypeById.put(Integer.valueOf(16), "Canon EF 35-135mm f/3.5-4.5");
    _lensTypeById.put(Integer.valueOf(17), "Canon EF 35-70mm f/3.5-4.5A");
    _lensTypeById.put(Integer.valueOf(18), "Canon EF 28-70mm f/3.5-4.5");
    _lensTypeById.put(Integer.valueOf(20), "Canon EF 100-200mm f/4.5A");
    _lensTypeById.put(Integer.valueOf(21), "Canon EF 80-200mm f/2.8L");
    _lensTypeById.put(Integer.valueOf(22), "Canon EF 20-35mm f/2.8L or Tokina Lens");
    _lensTypeById.put(Integer.valueOf(23), "Canon EF 35-105mm f/3.5-4.5");
    _lensTypeById.put(Integer.valueOf(24), "Canon EF 35-80mm f/4-5.6 Power Zoom");
    _lensTypeById.put(Integer.valueOf(25), "Canon EF 35-80mm f/4-5.6 Power Zoom");
    _lensTypeById.put(Integer.valueOf(26), "Canon EF 100mm f/2.8 Macro or Other Lens");
    _lensTypeById.put(Integer.valueOf(27), "Canon EF 35-80mm f/4-5.6");
    _lensTypeById.put(Integer.valueOf(28), "Canon EF 80-200mm f/4.5-5.6 or Tamron Lens");
    _lensTypeById.put(Integer.valueOf(29), "Canon EF 50mm f/1.8 II");
    _lensTypeById.put(Integer.valueOf(30), "Canon EF 35-105mm f/4.5-5.6");
    _lensTypeById.put(Integer.valueOf(31), "Canon EF 75-300mm f/4-5.6 or Tamron Lens");
    _lensTypeById.put(Integer.valueOf(32), "Canon EF 24mm f/2.8 or Sigma Lens");
    _lensTypeById.put(Integer.valueOf(33), "Voigtlander or Carl Zeiss Lens");
    _lensTypeById.put(Integer.valueOf(35), "Canon EF 35-80mm f/4-5.6");
    _lensTypeById.put(Integer.valueOf(36), "Canon EF 38-76mm f/4.5-5.6");
    _lensTypeById.put(Integer.valueOf(37), "Canon EF 35-80mm f/4-5.6 or Tamron Lens");
    _lensTypeById.put(Integer.valueOf(38), "Canon EF 80-200mm f/4.5-5.6");
    _lensTypeById.put(Integer.valueOf(39), "Canon EF 75-300mm f/4-5.6");
    _lensTypeById.put(Integer.valueOf(40), "Canon EF 28-80mm f/3.5-5.6");
    _lensTypeById.put(Integer.valueOf(41), "Canon EF 28-90mm f/4-5.6");
    _lensTypeById.put(Integer.valueOf(42), "Canon EF 28-200mm f/3.5-5.6 or Tamron Lens");
    _lensTypeById.put(Integer.valueOf(43), "Canon EF 28-105mm f/4-5.6");
    _lensTypeById.put(Integer.valueOf(44), "Canon EF 90-300mm f/4.5-5.6");
    _lensTypeById.put(Integer.valueOf(45), "Canon EF-S 18-55mm f/3.5-5.6 [II]");
    _lensTypeById.put(Integer.valueOf(46), "Canon EF 28-90mm f/4-5.6");
    _lensTypeById.put(Integer.valueOf(47), "Zeiss Milvus 35mm f/2 or 50mm f/2");
    _lensTypeById.put(Integer.valueOf(48), "Canon EF-S 18-55mm f/3.5-5.6 IS");
    _lensTypeById.put(Integer.valueOf(49), "Canon EF-S 55-250mm f/4-5.6 IS");
    _lensTypeById.put(Integer.valueOf(50), "Canon EF-S 18-200mm f/3.5-5.6 IS");
    _lensTypeById.put(Integer.valueOf(51), "Canon EF-S 18-135mm f/3.5-5.6 IS");
    _lensTypeById.put(Integer.valueOf(52), "Canon EF-S 18-55mm f/3.5-5.6 IS II");
    _lensTypeById.put(Integer.valueOf(53), "Canon EF-S 18-55mm f/3.5-5.6 III");
    _lensTypeById.put(Integer.valueOf(54), "Canon EF-S 55-250mm f/4-5.6 IS II");
    _lensTypeById.put(Integer.valueOf(94), "Canon TS-E 17mm f/4L");
    _lensTypeById.put(Integer.valueOf(95), "Canon TS-E 24.0mm f/3.5 L II");
    _lensTypeById.put(Integer.valueOf(124), "Canon MP-E 65mm f/2.8 1-5x Macro Photo");
    _lensTypeById.put(Integer.valueOf(125), "Canon TS-E 24mm f/3.5L");
    _lensTypeById.put(Integer.valueOf(126), "Canon TS-E 45mm f/2.8");
    _lensTypeById.put(Integer.valueOf(127), "Canon TS-E 90mm f/2.8");
    _lensTypeById.put(Integer.valueOf(129), "Canon EF 300mm f/2.8L");
    _lensTypeById.put(Integer.valueOf(130), "Canon EF 50mm f/1.0L");
    _lensTypeById.put(Integer.valueOf(131), "Canon EF 28-80mm f/2.8-4L or Sigma Lens");
    _lensTypeById.put(Integer.valueOf(132), "Canon EF 1200mm f/5.6L");
    _lensTypeById.put(Integer.valueOf(134), "Canon EF 600mm f/4L IS");
    _lensTypeById.put(Integer.valueOf(135), "Canon EF 200mm f/1.8L");
    _lensTypeById.put(Integer.valueOf(136), "Canon EF 300mm f/2.8L");
    _lensTypeById.put(Integer.valueOf(137), "Canon EF 85mm f/1.2L or Sigma or Tamron Lens");
    _lensTypeById.put(Integer.valueOf(138), "Canon EF 28-80mm f/2.8-4L");
    _lensTypeById.put(Integer.valueOf(139), "Canon EF 400mm f/2.8L");
    _lensTypeById.put(Integer.valueOf(140), "Canon EF 500mm f/4.5L");
    _lensTypeById.put(Integer.valueOf(141), "Canon EF 500mm f/4.5L");
    _lensTypeById.put(Integer.valueOf(142), "Canon EF 300mm f/2.8L IS");
    _lensTypeById.put(Integer.valueOf(143), "Canon EF 500mm f/4L IS or Sigma Lens");
    _lensTypeById.put(Integer.valueOf(144), "Canon EF 35-135mm f/4-5.6 USM");
    _lensTypeById.put(Integer.valueOf(145), "Canon EF 100-300mm f/4.5-5.6 USM");
    _lensTypeById.put(Integer.valueOf(146), "Canon EF 70-210mm f/3.5-4.5 USM");
    _lensTypeById.put(Integer.valueOf(147), "Canon EF 35-135mm f/4-5.6 USM");
    _lensTypeById.put(Integer.valueOf(148), "Canon EF 28-80mm f/3.5-5.6 USM");
    _lensTypeById.put(Integer.valueOf(149), "Canon EF 100mm f/2 USM");
    _lensTypeById.put(Integer.valueOf(150), "Canon EF 14mm f/2.8L or Sigma Lens");
    _lensTypeById.put(Integer.valueOf(151), "Canon EF 200mm f/2.8L");
    _lensTypeById.put(Integer.valueOf(152), "Canon EF 300mm f/4L IS or Sigma Lens");
    _lensTypeById.put(Integer.valueOf(153), "Canon EF 35-350mm f/3.5-5.6L or Sigma or Tamron Lens");
    _lensTypeById.put(Integer.valueOf(154), "Canon EF 20mm f/2.8 USM or Zeiss Lens");
    _lensTypeById.put(Integer.valueOf(155), "Canon EF 85mm f/1.8 USM");
    _lensTypeById.put(Integer.valueOf(156), "Canon EF 28-105mm f/3.5-4.5 USM or Tamron Lens");
    _lensTypeById.put(Integer.valueOf(160), "Canon EF 20-35mm f/3.5-4.5 USM or Tamron or Tokina Lens");
    _lensTypeById.put(Integer.valueOf(161), "Canon EF 28-70mm f/2.8L or Sigma or Tamron Lens");
    _lensTypeById.put(Integer.valueOf(162), "Canon EF 200mm f/2.8L");
    _lensTypeById.put(Integer.valueOf(163), "Canon EF 300mm f/4L");
    _lensTypeById.put(Integer.valueOf(164), "Canon EF 400mm f/5.6L");
    _lensTypeById.put(Integer.valueOf(165), "Canon EF 70-200mm f/2.8 L");
    _lensTypeById.put(Integer.valueOf(166), "Canon EF 70-200mm f/2.8 L + 1.4x");
    _lensTypeById.put(Integer.valueOf(167), "Canon EF 70-200mm f/2.8 L + 2x");
    _lensTypeById.put(Integer.valueOf(168), "Canon EF 28mm f/1.8 USM or Sigma Lens");
    _lensTypeById.put(Integer.valueOf(169), "Canon EF 17-35mm f/2.8L or Sigma Lens");
    _lensTypeById.put(Integer.valueOf(170), "Canon EF 200mm f/2.8L II");
    _lensTypeById.put(Integer.valueOf(171), "Canon EF 300mm f/4L");
    _lensTypeById.put(Integer.valueOf(172), "Canon EF 400mm f/5.6L or Sigma Lens");
    _lensTypeById.put(Integer.valueOf(173), "Canon EF 180mm Macro f/3.5L or Sigma Lens");
    _lensTypeById.put(Integer.valueOf(174), "Canon EF 135mm f/2L or Other Lens");
    _lensTypeById.put(Integer.valueOf(175), "Canon EF 400mm f/2.8L");
    _lensTypeById.put(Integer.valueOf(176), "Canon EF 24-85mm f/3.5-4.5 USM");
    _lensTypeById.put(Integer.valueOf(177), "Canon EF 300mm f/4L IS");
    _lensTypeById.put(Integer.valueOf(178), "Canon EF 28-135mm f/3.5-5.6 IS");
    _lensTypeById.put(Integer.valueOf(179), "Canon EF 24mm f/1.4L");
    _lensTypeById.put(Integer.valueOf(180), "Canon EF 35mm f/1.4L or Other Lens");
    _lensTypeById.put(Integer.valueOf(181), "Canon EF 100-400mm f/4.5-5.6L IS + 1.4x or Sigma Lens");
    _lensTypeById.put(Integer.valueOf(182), "Canon EF 100-400mm f/4.5-5.6L IS + 2x or Sigma Lens");
    _lensTypeById.put(Integer.valueOf(183), "Canon EF 100-400mm f/4.5-5.6L IS or Sigma Lens");
    _lensTypeById.put(Integer.valueOf(184), "Canon EF 400mm f/2.8L + 2x");
    _lensTypeById.put(Integer.valueOf(185), "Canon EF 600mm f/4L IS");
    _lensTypeById.put(Integer.valueOf(186), "Canon EF 70-200mm f/4L");
    _lensTypeById.put(Integer.valueOf(187), "Canon EF 70-200mm f/4L + 1.4x");
    _lensTypeById.put(Integer.valueOf(188), "Canon EF 70-200mm f/4L + 2x");
    _lensTypeById.put(Integer.valueOf(189), "Canon EF 70-200mm f/4L + 2.8x");
    _lensTypeById.put(Integer.valueOf(190), "Canon EF 100mm f/2.8 Macro USM");
    _lensTypeById.put(Integer.valueOf(191), "Canon EF 400mm f/4 DO IS");
    _lensTypeById.put(Integer.valueOf(193), "Canon EF 35-80mm f/4-5.6 USM");
    _lensTypeById.put(Integer.valueOf(194), "Canon EF 80-200mm f/4.5-5.6 USM");
    _lensTypeById.put(Integer.valueOf(195), "Canon EF 35-105mm f/4.5-5.6 USM");
    _lensTypeById.put(Integer.valueOf(196), "Canon EF 75-300mm f/4-5.6 USM");
    _lensTypeById.put(Integer.valueOf(197), "Canon EF 75-300mm f/4-5.6 IS USM");
    _lensTypeById.put(Integer.valueOf(198), "Canon EF 50mm f/1.4 USM or Zeiss Lens");
    _lensTypeById.put(Integer.valueOf(199), "Canon EF 28-80mm f/3.5-5.6 USM");
    _lensTypeById.put(Integer.valueOf(200), "Canon EF 75-300mm f/4-5.6 USM");
    _lensTypeById.put(Integer.valueOf(201), "Canon EF 28-80mm f/3.5-5.6 USM");
    _lensTypeById.put(Integer.valueOf(202), "Canon EF 28-80mm f/3.5-5.6 USM IV");
    _lensTypeById.put(Integer.valueOf(208), "Canon EF 22-55mm f/4-5.6 USM");
    _lensTypeById.put(Integer.valueOf(209), "Canon EF 55-200mm f/4.5-5.6");
    _lensTypeById.put(Integer.valueOf(210), "Canon EF 28-90mm f/4-5.6 USM");
    _lensTypeById.put(Integer.valueOf(211), "Canon EF 28-200mm f/3.5-5.6 USM");
    _lensTypeById.put(Integer.valueOf(212), "Canon EF 28-105mm f/4-5.6 USM");
    _lensTypeById.put(Integer.valueOf(213), "Canon EF 90-300mm f/4.5-5.6 USM or Tamron Lens");
    _lensTypeById.put(Integer.valueOf(214), "Canon EF-S 18-55mm f/3.5-5.6 USM");
    _lensTypeById.put(Integer.valueOf(215), "Canon EF 55-200mm f/4.5-5.6 II USM");
    _lensTypeById.put(Integer.valueOf(217), "Tamron AF 18-270mm f/3.5-6.3 Di II VC PZD");
    _lensTypeById.put(Integer.valueOf(224), "Canon EF 70-200mm f/2.8L IS");
    _lensTypeById.put(Integer.valueOf(225), "Canon EF 70-200mm f/2.8L IS + 1.4x");
    _lensTypeById.put(Integer.valueOf(226), "Canon EF 70-200mm f/2.8L IS + 2x");
    _lensTypeById.put(Integer.valueOf(227), "Canon EF 70-200mm f/2.8L IS + 2.8x");
    _lensTypeById.put(Integer.valueOf(228), "Canon EF 28-105mm f/3.5-4.5 USM");
    _lensTypeById.put(Integer.valueOf(229), "Canon EF 16-35mm f/2.8L");
    _lensTypeById.put(Integer.valueOf(230), "Canon EF 24-70mm f/2.8L");
    _lensTypeById.put(Integer.valueOf(231), "Canon EF 17-40mm f/4L");
    _lensTypeById.put(Integer.valueOf(232), "Canon EF 70-300mm f/4.5-5.6 DO IS USM");
    _lensTypeById.put(Integer.valueOf(233), "Canon EF 28-300mm f/3.5-5.6L IS");
    _lensTypeById.put(Integer.valueOf(234), "Canon EF-S 17-85mm f/4-5.6 IS USM or Tokina Lens");
    _lensTypeById.put(Integer.valueOf(235), "Canon EF-S 10-22mm f/3.5-4.5 USM");
    _lensTypeById.put(Integer.valueOf(236), "Canon EF-S 60mm f/2.8 Macro USM");
    _lensTypeById.put(Integer.valueOf(237), "Canon EF 24-105mm f/4L IS");
    _lensTypeById.put(Integer.valueOf(238), "Canon EF 70-300mm f/4-5.6 IS USM");
    _lensTypeById.put(Integer.valueOf(239), "Canon EF 85mm f/1.2L II");
    _lensTypeById.put(Integer.valueOf(240), "Canon EF-S 17-55mm f/2.8 IS USM");
    _lensTypeById.put(Integer.valueOf(241), "Canon EF 50mm f/1.2L");
    _lensTypeById.put(Integer.valueOf(242), "Canon EF 70-200mm f/4L IS");
    _lensTypeById.put(Integer.valueOf(243), "Canon EF 70-200mm f/4L IS + 1.4x");
    _lensTypeById.put(Integer.valueOf(244), "Canon EF 70-200mm f/4L IS + 2x");
    _lensTypeById.put(Integer.valueOf(245), "Canon EF 70-200mm f/4L IS + 2.8x");
    _lensTypeById.put(Integer.valueOf(246), "Canon EF 16-35mm f/2.8L II");
    _lensTypeById.put(Integer.valueOf(247), "Canon EF 14mm f/2.8L II USM");
    _lensTypeById.put(Integer.valueOf(248), "Canon EF 200mm f/2L IS or Sigma Lens");
    _lensTypeById.put(Integer.valueOf(249), "Canon EF 800mm f/5.6L IS");
    _lensTypeById.put(Integer.valueOf(250), "Canon EF 24mm f/1.4L II or Sigma Lens");
    _lensTypeById.put(Integer.valueOf(251), "Canon EF 70-200mm f/2.8L IS II USM");
    _lensTypeById.put(Integer.valueOf(252), "Canon EF 70-200mm f/2.8L IS II USM + 1.4x");
    _lensTypeById.put(Integer.valueOf(253), "Canon EF 70-200mm f/2.8L IS II USM + 2x");
    _lensTypeById.put(Integer.valueOf(254), "Canon EF 100mm f/2.8L Macro IS USM");
    _lensTypeById.put(Integer.valueOf(255), "Sigma 24-105mm f/4 DG OS HSM | A or Other Sigma Lens");
    _lensTypeById.put(Integer.valueOf(488), "Canon EF-S 15-85mm f/3.5-5.6 IS USM");
    _lensTypeById.put(Integer.valueOf(489), "Canon EF 70-300mm f/4-5.6L IS USM");
    _lensTypeById.put(Integer.valueOf(490), "Canon EF 8-15mm f/4L Fisheye USM");
    _lensTypeById.put(Integer.valueOf(491), "Canon EF 300mm f/2.8L IS II USM");
    _lensTypeById.put(Integer.valueOf(492), "Canon EF 400mm f/2.8L IS II USM");
    _lensTypeById.put(Integer.valueOf(493), "Canon EF 500mm f/4L IS II USM or EF 24-105mm f4L IS USM");
    _lensTypeById.put(Integer.valueOf(494), "Canon EF 600mm f/4.0L IS II USM");
    _lensTypeById.put(Integer.valueOf(495), "Canon EF 24-70mm f/2.8L II USM");
    _lensTypeById.put(Integer.valueOf(496), "Canon EF 200-400mm f/4L IS USM");
    _lensTypeById.put(Integer.valueOf(499), "Canon EF 200-400mm f/4L IS USM + 1.4x");
    _lensTypeById.put(Integer.valueOf(502), "Canon EF 28mm f/2.8 IS USM");
    _lensTypeById.put(Integer.valueOf(503), "Canon EF 24mm f/2.8 IS USM");
    _lensTypeById.put(Integer.valueOf(504), "Canon EF 24-70mm f/4L IS USM");
    _lensTypeById.put(Integer.valueOf(505), "Canon EF 35mm f/2 IS USM");
    _lensTypeById.put(Integer.valueOf(506), "Canon EF 400mm f/4 DO IS II USM");
    _lensTypeById.put(Integer.valueOf(507), "Canon EF 16-35mm f/4L IS USM");
    _lensTypeById.put(Integer.valueOf(508), "Canon EF 11-24mm f/4L USM");
    _lensTypeById.put(Integer.valueOf(747), "Canon EF 100-400mm f/4.5-5.6L IS II USM");
    _lensTypeById.put(Integer.valueOf(750), "Canon EF 35mm f/1.4L II USM");
    _lensTypeById.put(Integer.valueOf(4142), "Canon EF-S 18-135mm f/3.5-5.6 IS STM");
    _lensTypeById.put(Integer.valueOf(4143), "Canon EF-M 18-55mm f/3.5-5.6 IS STM or Tamron Lens");
    _lensTypeById.put(Integer.valueOf(4144), "Canon EF 40mm f/2.8 STM");
    _lensTypeById.put(Integer.valueOf(4145), "Canon EF-M 22mm f/2 STM");
    _lensTypeById.put(Integer.valueOf(4146), "Canon EF-S 18-55mm f/3.5-5.6 IS STM");
    _lensTypeById.put(Integer.valueOf(4147), "Canon EF-M 11-22mm f/4-5.6 IS STM");
    _lensTypeById.put(Integer.valueOf(4148), "Canon EF-S 55-250mm f/4-5.6 IS STM");
    _lensTypeById.put(Integer.valueOf(4149), "Canon EF-M 55-200mm f/4.5-6.3 IS STM");
    _lensTypeById.put(Integer.valueOf(4150), "Canon EF-S 10-18mm f/4.5-5.6 IS STM");
    _lensTypeById.put(Integer.valueOf(4152), "Canon EF 24-105mm f/3.5-5.6 IS STM");
    _lensTypeById.put(Integer.valueOf(4153), "Canon EF-M 15-45mm f/3.5-6.3 IS STM");
    _lensTypeById.put(Integer.valueOf(4154), "Canon EF-S 24mm f/2.8 STM");
    _lensTypeById.put(Integer.valueOf(4156), "Canon EF 50mm f/1.8 STM");
    _lensTypeById.put(Integer.valueOf(36912), "Canon EF-S 18-135mm f/3.5-5.6 IS USM");
    _lensTypeById.put(Integer.valueOf(65535), "N/A");
  }
  
  public CanonMakernoteDescriptor(CanonMakernoteDirectory paramCanonMakernoteDirectory)
  {
    super(paramCanonMakernoteDirectory);
  }
  
  private double decodeCanonEv(int paramInt)
  {
    return 4.973507417E-315D;
  }
  
  public String getAESettingDescription()
  {
    return null;
  }
  
  public String getAfPointSelectedDescription()
  {
    return null;
  }
  
  public String getAfPointUsedDescription()
  {
    return null;
  }
  
  public String getColorToneDescription()
  {
    return null;
  }
  
  public String getContinuousDriveModeDescription()
  {
    return null;
  }
  
  public String getContrastDescription()
  {
    return null;
  }
  
  public String getDescription(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          switch (paramInt)
          {
          default: 
            switch (paramInt)
            {
            default: 
              switch (paramInt)
              {
              default: 
                return super.getDescription(paramInt);
              case 49679: 
                return getFlashBiasDescription();
              }
              return getAfPointUsedDescription();
            case 49447: 
              return getManualFlashOutputDescription();
            case 49446: 
              return getPhotoEffectDescription();
            }
            return getSpotMeteringModeDescription();
          case 49441: 
            return getDisplayApertureDescription();
          case 49440: 
            return getFocusMode2Description();
          case 49439: 
            return getAESettingDescription();
          case 49438: 
            return getFocusContinuousDescription();
          case 49437: 
            return getFlashDetailsDescription();
          case 49436: 
            return getFlashActivityDescription();
          case 49435: 
            return getMinApertureDescription();
          case 49434: 
            return getMaxApertureDescription();
          case 49433: 
            return getFocalUnitsPerMillimetreDescription();
          case 49432: 
            return getShortFocalLengthDescription();
          case 49431: 
            return getLongFocalLengthDescription();
          }
          return getLensTypeDescription();
        case 49428: 
          return getExposureModeDescription();
        case 49427: 
          return getAfPointSelectedDescription();
        case 49426: 
          return getFocusTypeDescription();
        case 49425: 
          return getMeteringModeDescription();
        case 49424: 
          return getIsoDescription();
        case 49423: 
          return getSharpnessDescription();
        case 49422: 
          return getSaturationDescription();
        case 49421: 
          return getContrastDescription();
        case 49420: 
          return getDigitalZoomDescription();
        case 49419: 
          return getEasyShootingModeDescription();
        case 49418: 
          return getImageSizeDescription();
        }
        return getRecordModeDescription();
      case 49413: 
        return getContinuousDriveModeDescription();
      case 49412: 
        return getFlashModeDescription();
      case 49411: 
        return getQualityDescription();
      case 49410: 
        return getSelfTimerDelayDescription();
      }
      return getMacroModeDescription();
    case 53770: 
      return getTagAfPointsInFocus();
    case 49671: 
      return getWhiteBalanceDescription();
    case 49453: 
      return getSRawQualityDescription();
    case 49449: 
      return getColorToneDescription();
    case 49415: 
      return getFocusMode1Description();
    }
    return getSerialNumberDescription();
  }
  
  public String getDigitalZoomDescription()
  {
    return null;
  }
  
  public String getDisplayApertureDescription()
  {
    return null;
  }
  
  public String getEasyShootingModeDescription()
  {
    return null;
  }
  
  public String getExposureModeDescription()
  {
    return null;
  }
  
  public String getFlashActivityDescription()
  {
    return null;
  }
  
  public String getFlashBiasDescription()
  {
    return null;
  }
  
  public String getFlashDetailsDescription()
  {
    return null;
  }
  
  public String getFlashModeDescription()
  {
    return null;
  }
  
  public String getFocalUnitsPerMillimetreDescription()
  {
    return null;
  }
  
  public String getFocusContinuousDescription()
  {
    return null;
  }
  
  public String getFocusMode1Description()
  {
    return null;
  }
  
  public String getFocusMode2Description()
  {
    return null;
  }
  
  public String getFocusTypeDescription()
  {
    return null;
  }
  
  public String getImageSizeDescription()
  {
    return null;
  }
  
  public String getIsoDescription()
  {
    return null;
  }
  
  public String getLensTypeDescription()
  {
    return null;
  }
  
  public String getLongFocalLengthDescription()
  {
    return null;
  }
  
  public String getMacroModeDescription()
  {
    return null;
  }
  
  public String getManualFlashOutputDescription()
  {
    return null;
  }
  
  public String getMaxApertureDescription()
  {
    return null;
  }
  
  public String getMeteringModeDescription()
  {
    return null;
  }
  
  public String getMinApertureDescription()
  {
    return null;
  }
  
  public String getPhotoEffectDescription()
  {
    return null;
  }
  
  public String getQualityDescription()
  {
    return null;
  }
  
  public String getRecordModeDescription()
  {
    return null;
  }
  
  public String getSRawQualityDescription()
  {
    return null;
  }
  
  public String getSaturationDescription()
  {
    return null;
  }
  
  public String getSelfTimerDelayDescription()
  {
    return null;
  }
  
  public String getSerialNumberDescription()
  {
    return null;
  }
  
  public String getSharpnessDescription()
  {
    return null;
  }
  
  public String getShortFocalLengthDescription()
  {
    return null;
  }
  
  public String getSpotMeteringModeDescription()
  {
    return null;
  }
  
  public String getTagAfPointsInFocus()
  {
    return null;
  }
  
  public String getWhiteBalanceDescription()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\exif\makernotes\CanonMakernoteDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */