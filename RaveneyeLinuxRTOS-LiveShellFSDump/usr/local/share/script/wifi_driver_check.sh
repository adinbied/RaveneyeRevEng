#!/bin/sh
echo "start check wifi driver"
while [ "1" == "1" ];
do
        #usb device exist
        status=`cat /proc/net/rtl88x2cu/wlan0/dji_driverstatus`
        if [ "${status}" == "1" ];then
		pkill hostapd
		ifconfig wlan0 down
		ifconfig wlan1 down
		pkill dji_wms_hg702
		sleep 0.5
		dji_wms_hg702 &
        fi
        sleep 1
done
echo "end check wifi driver"

