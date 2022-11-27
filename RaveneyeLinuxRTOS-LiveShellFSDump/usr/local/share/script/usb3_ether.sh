#!/bin/sh

echo device > /proc/ambarella/usbphy0
modprobe usbcore
modprobe udc-core
modprobe dwc3-ambarella
modprobe dwc3
modprobe libcomposite
modprobe g_ether
ifconfig usb0 up

echo "\"ifconfig usb0 your_ip\" after host detects usb ethernet device."

