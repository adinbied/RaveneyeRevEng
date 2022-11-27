#!/bin/sh
pcapfile="/tmp/SD0/tcpdump-"
i=0
while [ "${i}" -le 2000 ];
do
	filename=$pcapfile$i".pcap"
	if [ ! -f "$filename" ]; then
#		tcpdump -C 5 -s 0 -w /tmp/SD0/tcpdump.pcap &
		tcpdump -G 300 -z root -s 0 -w /tmp/SD0/dji_%Y%m%d_%H%M_%S.pcap &
		break
	fi
	let i++
done
#tcpdump -C 5 -s 0 -w /tmp/SD0/tcpdump.pacap &
