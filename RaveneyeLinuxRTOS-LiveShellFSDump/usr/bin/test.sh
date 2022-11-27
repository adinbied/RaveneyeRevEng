#!/bin/sh
sleep 20
echo 4 > /proc/net/rtl88x2cu/log_level
echo "start check wifi driver"
while [ "1" == "1" ];
do
        #usb device exist
        status=`cat /proc/net/rtl88x2cu/wlan0/dji_driverstatus`
        if [ "${status}" == "1" ];then
        rmmod ehci_ambarella ehci_hcd
        break
        fi
        sleep 1
done
echo "end check wifi driver"
