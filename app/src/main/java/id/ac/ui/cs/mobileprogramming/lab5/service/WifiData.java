package id.ac.ui.cs.mobileprogramming.lab5.service;

public class WifiData {

    private String SSID;

    private String BSSID;

    private int frequency;

    public WifiData(String SSID, String BSSID, int frequency) {
        this.SSID = SSID;
        this.BSSID = BSSID;
        this.frequency = frequency;
    }
}
