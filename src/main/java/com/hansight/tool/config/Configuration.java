package com.hansight.tool.config;

import org.springframework.beans.factory.annotation.Value;

/**
 * Configuration
 *
 * @author liufenglin
 * @email fenglin_liu@hansight.com
 * @date 17/4/5
 */
@org.springframework.context.annotation.Configuration
public class Configuration {

    @Value("${src.server}")
    private String srcServer;

    @Value("${src.port}")
    private int srcPort;

    @Value("${src.export-location}")
    private String exportLocation;

    @Value("${dst.server}")
    private String dstServer;

    @Value("${dst.port}")
    private int dstPort;

    public int getDstPort() {
        return dstPort;
    }

    public void setDstPort(int dstPort) {
        this.dstPort = dstPort;
    }

    public String getDstServer() {
        return dstServer;
    }

    public void setDstServer(String dstServer) {
        this.dstServer = dstServer;
    }

    public String getExportLocation() {
        return exportLocation;
    }

    public void setExportLocation(String exportLocation) {
        this.exportLocation = exportLocation;
    }

    public int getSrcPort() {
        return srcPort;
    }

    public void setSrcPort(int srcPort) {
        this.srcPort = srcPort;
    }

    public String getSrcServer() {
        return srcServer;
    }

    public void setSrcServer(String srcServer) {
        this.srcServer = srcServer;
    }
}
