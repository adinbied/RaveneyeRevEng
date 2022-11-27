#!/bin/sh
pkill hostapd
rmmod 88x2cu
insmod /usr/local/rtl8821cu/88x2cu.ko rtw_initmac=60:60:1F:48:DF:0B rtw_country_code=ff rtw_vht_enable=2 rtw_phy_file_path=/tmp/rtw_path/ rtw_tx_pwr_lmt_enable=1 rtw_adaptivity_en=0 rtw_drv_log_level=0
ifconfig wlan0 up
iw dev wlan0 scan freq 2412 2417 2422 2427 2432 2437 2442 >> /dev/null 
iw dev wlan0 scan trigger freq 2447 2452 2457 2462 5745 5765 5785 5805 5825
