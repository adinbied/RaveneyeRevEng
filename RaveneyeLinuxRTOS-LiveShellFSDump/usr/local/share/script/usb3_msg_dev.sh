#!/bin/sh
#
# Init S2 IPCAM...
#

if [ -f /etc/ambarella.conf ]; then
	. /etc/ambarella.conf
fi

start()
{
	kernel_ver=$(uname -r)

	echo device > /proc/ambarella/usbphy0

	# Install USB module
	modprobe usb_common
	modprobe udc-core
	modprobe dwc3-ambarella
	modprobe dwc3

	# Create and format a temp device for USB MSG.
	dd if=/dev/zero of=/tmp/usb bs=1M count=10M
	mkfs.vfat -n a9evkusb /tmp/usb
	mkdir -p /tmp/usb_msg
	mount /tmp/usb /tmp/usb_msg
	mkdir /tmp/usb_msg/usb_test
	umount /tmp/usb_msg

	# Probe the MSG module.
	modprobe g_mass_storage stall=0 removable=1 file=/tmp/usb
}

stop()
{
	kernel_ver=$(uname -r)
}

restart()
{
	stop
	start
}

case "$1" in
	start)
		start
		;;
	stop)
		stop
		;;
	restart|reload)
		restart
		;;
	*)
		echo "Usage: $0 {start|stop|restart}"
		exit 1
esac

exit $?
