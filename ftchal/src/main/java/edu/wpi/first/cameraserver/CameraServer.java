package edu.wpi.first.cameraserver;

public class CameraServer {
    private static CameraServer server;

    /**
     * Get the CameraServer instance.
     */
    public static synchronized CameraServer getInstance() {
        if (server == null) {
            server = new CameraServer();
        }
        return server;
    }
}
