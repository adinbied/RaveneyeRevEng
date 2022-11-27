#!/bin/sh
cd /
if [ -e /tmp/SD0/NO_HIBER ]; then
	echo -e "\nfound /tmp/SD0/NO_HIBER, skip hibernation"
	exit 0
fi
echo -e "\ntouch /tmp/SD0/NO_HIBER if you want to skip hibernation"

sync
echo 3 > /proc/sys/vm/drop_caches

echo disk > /sys/power/state
echo $0 > /sys/module/rpmsg_echo/parameters/example_printk
/usr/local/share/script/wowlan.sh resume
/usr/local/share/script/sync_rtc.sh
