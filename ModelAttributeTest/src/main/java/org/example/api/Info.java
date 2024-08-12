package org.example.api;

import org.springframework.stereotype.Service;

@Service
public class Info {
    private String serverIp = "127.0.0.1";

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }
}
