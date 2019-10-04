# Source: https://pymotw.com/2/socket/udp.html

import socket, sys, time
import random


host = sys.argv[1]
textport = sys.argv[2]
#host = "localhost"
#textport = "8081"

s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
port = int(textport)
server_address = (host, port)

for i in range (10):
    #print ("Enter data to transmit: ENTER to quit")
    data = str(random.randint(1,100))
    print(" sending "+ data)

    s.sendto(data.encode('utf-8'), server_address)

s.shutdown(1)


