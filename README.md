IPv6Con - Sample Applications
=============================

This project contains sample classes (source snippets) used in the Talk
"'''Java Anwendungen für IPv6 fit machen'''" given by Bernd Eckenfels on 2013-06-07
at the IPV6-Kongress Frankfurt/Main Germany.

Sample 1
--------
    C:\IPv6Con> set CP=-cp target\classes\
    C:\IPv6Con> java %CP% net.eckenfels.ipv6con.Sample1 www.kame.net
    Looking up www.kame.net
     -> www.kame.net/203.178.141.194
        class java.net.Inet4Address

    C:\IPv6Con> java %CP% -Djava.net.preferIPv6Addresses=true ^
                     net.eckenfels.ipv6con.Sample1 www.kame.net
    Looking up www.kame.net
     -> www.kame.net/2001:200:dff:fff1:216:3eff:feb1:44d7
        class java.net.Inet6Address

Sample 2
--------
    C:\IPv6Con> java %CP% net.eckenfels.ipv6con.Sample2 ::1
    Looking up ::1 -> /0:0:0:0:0:0:0:1 class java.net.Inet6Address isLoop=true
        
    C:\IPv6Con> java %CP% net.eckenfels.ipv6con.Sample2 127.0.0.1
    Looking up 127.0.0.1 -> /127.0.0.1 class java.net.Inet6Address isLoop=true
    
    C:\IPv6Con> java %CP% net.eckenfels.ipv6con.Sample2 192.0.2.16
    Looking up 192.0.2.16 -> /192.0.2.16 class java.net.Inet4Address isLoop=false
    
    C:\IPv6Con> java %CP% net.eckenfels.ipv6con.Sample2 localhost
    Looking up localhost -> localhost/127.0.0.1 class java.net.Inet4Address isLoop=true

Sample 3
--------
    C:\IPv6Con> java %CP% net.eckenfels.ipv6con.Sample3
    URL1 toString=http://[2001:DB8::1234:ABCD%13]:80 host=[2001:DB8::1234:ABCD%13] port=80
    URL2 toString=https://[2001:DB8::1234:ABCD%13]/test host=[2001:DB8::1234:ABCD%13] port=-1
    
Sample 4
--------
    C:\IPv6Con> java %CP% net.eckenfels.ipv6con.Sample4 www.heise.de
    - 193.99.144.85 www.heise.de
    - 2a02:2e0:3fe:100:0:0:0:7 www.heise.de
    
    C:\IPv6Con> java %CP% -Djava.net.preferIPv6Addresses=true ^
                     net.eckenfels.ipv6con.Sample4 www.heise.de
    - 2a02:2e0:3fe:100:0:0:0:7 www.heise.de
    - 193.99.144.85 www.heise.de  
    
    C:\IPv6Con> java %CP% net.eckenfels.ipv6con.Sample4 www.kame.net
    - 203.178.141.194 orange.kame.net
    - 2001:200:dff:fff1:216:3eff:feb1:44d7 2001:200:dff:fff1:216:3eff:feb1:44d7
    
    C:\IPv6Con> java %CP% -Djava.net.preferIPv4Stack=true net.eckenfels.ipv6con.Sample4 www.kame.net
    - 203.178.141.194 orange.kame.net
     
    C:\IPv6Con> java %CP% net.eckenfels.ipv6con.Sample4 ipv6.google.com
    - 2a00:1450:4016:802:0:0:0:1013 muc03s07-in-x13.1e100.net
    
Sample 5
--------
    C:\IPv6Con> java %CP% net.eckenfels.ipv6con.Sample5
    Connected /10.0.0.24#56850 -> www.heise.de/193.99.144.85#80
    Connected /10.0.0.24#56851 -> www.heise.de/193.99.144.85#80
    Connected /10.0.0.24#56852 -> www.heise.de/193.99.144.85#80
    
    C:\IPv6Con> java %CP% -Djava.net.preferIPv6Addresses=true net.eckenfels.ipv6con.Sample5
    Connected /2001:0:5ef4:79fd:6c:1cde:6a53:c2bb#57258 -> www.heise.de/2a02:2e0:3fe:100:0:0:0:7#80
    Connected /2001:0:5ef4:79fd:6c:1cde:6a53:c2bb#57259 -> www.heise.de/2a02:2e0:3fe:100:0:0:0:7#80
    Connected /2001:0:5ef4:79fd:6c:1cde:6a53:c2bb#57260 -> www.heise.de/2a02:2e0:3fe:100:0:0:0:7#80

Sample 6
--------
    C:\IPv6Con> java %CP% net.eckenfels.ipv6con.Sample6
    Listening on 0.0.0.0/0.0.0.0:1234
    Connected /0:0:0:0:0:0:0:1#1234 -> /0:0:0:0:0:0:0:1#56185
    Connected /127.0.0.1#1234 -> /127.0.0.1#56188
    
    C:\IPv6Con> java %CP% –Djava.net.preferIPv6Addresses=true net.eckenfels.ipv6con.Sample6
    Listening on ::/0:0:0:0:0:0:0:0:1234

Sample 7
--------
    C:\IPv6Con> java %CP% net.eckenfels.ipv6con.Sample7
    lo %1 Software Loopback Interface 1 mtu:-1
      addr 127.0.0.1 /8
      addr 0:0:0:0:0:0:0:1 /128
    eth3 %10 Bluetooth-Ger?t (PAN mtu:1500
      addr fe80:0:0:0:a491:4bb3:e0a0:144e%10 /64
    net4 %0 Intel(R) Centrino(R) Advanced-N 6200 AGN mtu:1500
      addr 10.0.0.24 /-1
    net9 %19 Microsoft-Teredo-Tunneling-Adapter mtu:1280
      addr 2001:0:5ef5:79fd:3042:1a7f:6a53:c2bb /0
      addr fe80:0:0:0:3042:1a7f:6a53:c2bb%19 /32

Sample 8
--------
    C:\IPv6Con> java %CP% net.eckenfels.ipv6con.Sample8 www.heise.de 80
    connected /2001:0:5ef5:79fd:3044:1a7f:6a53:c2bb:56522 -> www.heise.de/2a02:2e0:3fe:100:0:0:0:7:80
    is www.heise.de/2a02:2e0:3fe:100:0:0:0:7 pingable? True


    

