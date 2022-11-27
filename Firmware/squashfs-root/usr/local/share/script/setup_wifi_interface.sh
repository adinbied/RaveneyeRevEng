#!/bin/sh
i=0
j=0
while [ "${i}" -le 2000 ];
do
     wlan=`ifconfig -a | grep wlan0 | awk '{print $1}'`
     if [ "${wlan}" != "" ];then
          ifconfig wlan0 192.168.2.1 up 
          ifconfig wlan1 up&
#          while [ "${j}" -le 2000 ];
#          do
#              wlan=`ifconfig | grep wlan0 | awk '{print $1}'`
#              if [ "${wlan}" != "" ];then
#                  ifconfig wlan0 192.168.2.1 &
#                  break
#              fi
#              let j++
#              sleep 0.001
#          done
          break
     fi
     let i++
     sleep 0.001
done

