# Source: https://pymotw.com/2/socket/udp.html

import socket, sys, time, json

host = sys.argv[1]
textport = sys.argv[2]

r = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
portSend = int(textport)
server_address = (host, portSend)
data = {
        "name": "John",
        "age": 30,
        "city": "New York"
        }

#    s.sendall(data.encode('utf-8'))

for i in range(10):
    y = json.dumps(data)
    print(y)
    s.sendto(y.encode('utf-8'), server_address)
    data['age'] = data['age'] +1
    # reciever_address = ('10.0.0.21', port)
    # r.bind(reciever_address)
s.shutdown(1)

