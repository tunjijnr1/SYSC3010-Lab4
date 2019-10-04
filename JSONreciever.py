# Source: https://pymotw.com/2/socket/udp.html

import socket, sys, time, json

textport = sys.argv[1]

s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
port = int(textport)
server_address = ('134.117.58.163', port)
s.bind(server_address)

while True:

    print ("Waiting to receive on port %d : press Ctrl-C or Ctrl-Break to stop " % port)
    
    buf, address = s.recvfrom(port)
    y= json.loads(buf.decode('utf-8'))
    #When it is printed, there is a 'u' before the key, this is just the type 
    print ("Received %s bytes from %s %s: " % (len(y), address, y))
s.shutdown(1)
