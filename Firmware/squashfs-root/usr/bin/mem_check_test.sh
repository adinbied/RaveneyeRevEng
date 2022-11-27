#!/bin/sh

n=0
while true
do
    n=`expr $n + 1`
	sleep 2
    echo "#####################${n}#############################"
	ps -eo pid,ppid,cmd,%mem,%cpu --sort=-%mem | head -20
    echo
    echo
done
