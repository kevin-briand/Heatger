package fr.firedream.heatger.bo.Network;


import fr.firedream.heatger.exception.HeatgerException;

public class User {
    private String name;
    private int[] ip;

    public User(String name, int[] ip) throws Exception {
        if(ip.length != 4) throw new HeatgerException(NetworkErrors.ERROR_IP_LENGTH);

        this.name = name;
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public int[] getIp() {
        return ip;
    }
}
