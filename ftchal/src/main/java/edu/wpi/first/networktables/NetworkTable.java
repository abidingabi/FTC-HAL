package edu.wpi.first.networktables;

public final class NetworkTable {
    public static final char PATH_SEPARATOR = '/';

    private final NetworkTableInstance m_inst;

    NetworkTable(NetworkTableInstance inst, String path) {
        m_inst = inst;
    }

    public NetworkTableInstance getInstance() {
        return m_inst;
    }

    public NetworkTableEntry getEntry(String key) {
        return new NetworkTableEntry(m_inst, 0);
    }


    public NetworkTable getSubTable(String key) {
        return this;
    }
}
