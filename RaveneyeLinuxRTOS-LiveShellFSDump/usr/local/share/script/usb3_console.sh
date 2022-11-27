#!/bin/sh -x
killall syslogd
echo device > /proc/ambarella/usbphy0
modprobe usbcore
modprobe udc-core
modprobe dwc3-ambarella
modprobe dwc3
modprobe libcomposite
modprobe g_serial
/sbin/getty -n -L 115200 /dev/ttyGS0 &
klogd
syslogd -O /dev/ttyGS0
