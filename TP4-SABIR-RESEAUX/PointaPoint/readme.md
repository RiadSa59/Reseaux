# Point-à-point :

### Question 1 :

<p>
On utilise un câble croisé.
</p> 

### Question 2 : 

<p>

La commande `ethtool eth1 | less ` permet de vérifier l'interface eth1 est bien connectée.

</p>

### Question 3 : 

<p>

 `sudo ip address add 127.0.0.8/24 dev eth1` 

</p>

<br>
<p>

permet d'associer l'adresse IP `127.0.0.8/24` à l'interface eth1
</p>

### Question 4 : 

<p>

 `ip route` nous donne la table de routage 
 
 
 ```

    default via 192.168.5.1 dev eth1 proto dhcp src 192.168.5.67 metric 100 
    127.0.0.0/24 dev eth1 proto kernel scope link src 127.0.0.8 
    192.168.5.0/24 dev eth1 proto kernel scope link src 192.168.5.67 metric 100 
    192.168.5.1 dev eth1 proto dhcp scope link src 192.168.5.67 metric 100 
    194.254.129.92 via 192.168.5.1 dev eth1 proto dhcp src 192.168.5.67 metric 100 
    194.254.129.93 via 192.168.5.1 dev eth1 proto dhcp src 192.168.5.67 metric 100 
    
 
 ```


</p>

### Question 5 : 

<p> 

Afin de tester la connectivité avec une autre machine du réseau on procède comme suit :
`ping IP Address de la machine du voisin`

<br>

On aura comme résultat ce qui suit : 

```

ping 192.168.5.72
PING 192.168.5.72 (192.168.5.72) 56(84) bytes of data.
64 bytes from 192.168.5.72: icmp_seq=1 ttl=64 time=0.647 ms
64 bytes from 192.168.5.72: icmp_seq=2 ttl=64 time=0.610 ms
64 bytes from 192.168.5.72: icmp_seq=3 ttl=64 time=0.771 ms

--- 192.168.5.72 ping statistics ---
8 packets transmitted, 8 received, 0% packet loss, time 7155ms
rtt min/avg/max/mdev = 0.524/0.670/0.771/0.079 ms




```


</p>