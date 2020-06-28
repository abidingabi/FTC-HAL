package edu.wpi.first.networktables;

public final class NetworkTableInstance implements AutoCloseable {
    public static final int kNetModeNone = 0x00;
    public static final int kNetModeServer = 0x01;
    public static final int kNetModeClient = 0x02;
    public static final int kNetModeStarting = 0x04;
    public static final int kNetModeFailure = 0x08;
    public static final int kNetModeLocal = 0x10;

    /**
     * The default port that network tables operates on.
     */
    public static final int kDefaultPort = 1735;

    @Override
    public synchronized void close() {

    }

    /* The default instance. */
    private static NetworkTableInstance s_defaultInstance;

    /**
     * Get global default instance.
     *
     * @return Global default instance
     */
    public static synchronized NetworkTableInstance getDefault() {
        if (s_defaultInstance == null) {
            s_defaultInstance = new NetworkTableInstance();
        }
        return s_defaultInstance;
    }

    /**
     * Set the network identity of this node.
     * This is the name used during the initial connection handshake, and is
     * visible through ConnectionInfo on the remote node.
     *
     * @param name      identity to advertise
     */
    public void setNetworkIdentity(String name) {

    }

    /**
     * Starts a server using the networktables.ini as the persistent file,
     * using the default listening address and port.
     */
    public void startServer() {
        startServer("networktables.ini");
    }

    /**
     * Starts a server using the specified persistent filename, using the default
     * listening address and port.
     *
     * @param persistFilename  the name of the persist file to use
     */
    public void startServer(String persistFilename) {
        startServer(persistFilename, "");
    }

    /**
     * Starts a server using the specified filename and listening address,
     * using the default port.
     *
     * @param persistFilename  the name of the persist file to use
     * @param listenAddress    the address to listen on, or empty to listen on any
     *                         address
     */
    public void startServer(String persistFilename, String listenAddress) {
        startServer(persistFilename, listenAddress, kDefaultPort);
    }

    /**
     * Starts a server using the specified filename, listening address, and port.
     *
     * @param persistFilename  the name of the persist file to use
     * @param listenAddress    the address to listen on, or empty to listen on any
     *                         address
     * @param port             port to communicate over
     */
    public void startServer(String persistFilename, String listenAddress, int port) {

    }

    /**
     * Gets the table with the specified key.
     *
     * @param key the key name
     * @return The network table
     */
    public NetworkTable getTable(String key) {
        // prepend leading / if not present
        String theKey;
        if (key.isEmpty() || key.equals("/")) {
            theKey = "";
        } else if (key.charAt(0) == NetworkTable.PATH_SEPARATOR) {
            theKey = key;
        } else {
            theKey = NetworkTable.PATH_SEPARATOR + key;
        }

        return new NetworkTable(this, theKey);
    }

    public NetworkTableEntry getEntry(String name) {
        return new NetworkTableEntry(this, 0);
    }
}