package edu.wpi.first.networktables;
import java.util.function.Consumer;

/**
 * NetworkTables Entry.
 */
public final class NetworkTableEntry {
    /**
     * Construct from native handle.
     *
     * @param inst Instance
     * @param handle Native handle
     */
    public NetworkTableEntry(NetworkTableInstance inst, int handle) {
        m_inst = inst;
        m_handle = handle;
    }

    /**
     * Sets the entry's value.  If the value is of different type, the type is
     * changed to match the new value.
     *
     * @param value the value to set
     */
    public void forceSetBoolean(boolean value) {
    }

    /**
     * Sets the entry's value.  If the value is of different type, the type is
     * changed to match the new value.
     *
     * @param value the value to set
     */
    public void forceSetDouble(double value) {
    }

    /**
     * Sets the entry's value.  If the value is of different type, the type is
     * changed to match the new value.
     *
     * @param value the value to set
     */
    public void forceSetNumber(Number value) {
    }

    /**
     * Sets the entry's value.  If the value is of different type, the type is
     * changed to match the new value.
     *
     * @param value the value to set
     */
    public void forceSetString(String value) {
    }

    /**
     * Sets the entry's value.  If the value is of different type, the type is
     * changed to match the new value.
     *
     * @param value the value to set
     */
    public void forceSetRaw(byte[] value) {
    }

    /**
     * Sets the entry's value.  If the value is of different type, the type is
     * changed to match the new value.
     *
     * @param value the value to set
     */
    public void forceSetBooleanArray(boolean[] value) {
    }

    /**
     * Sets the entry's value.  If the value is of different type, the type is
     * changed to match the new value.
     *
     * @param value the value to set
     */
    public void forceSetBooleanArray(Boolean[] value) {
    }

    /**
     * Sets the entry's value.  If the value is of different type, the type is
     * changed to match the new value.
     *
     * @param value the value to set
     */
    public void forceSetDoubleArray(double[] value) {
    }

    /**
     * Sets the entry's value.  If the value is of different type, the type is
     * changed to match the new value.
     *
     * @param value the value to set
     */
    public void forceSetNumberArray(Number[] value) {
    }

    /**
     * Sets the entry's value.  If the value is of different type, the type is
     * changed to match the new value.
     *
     * @param value the value to set
     */
    public void forceSetStringArray(String[] value) {
    }

    /**
     * Sets flags.
     *
     * @param flags the flags to set (bitmask)
     */
    public void setFlags(int flags) {
    }


    private NetworkTableInstance m_inst;
    private int m_handle;

    public boolean setBoolean(boolean value) {
        return true;
    }

    public boolean setDouble(double value) {
        return true;
    }

    public boolean setString(String value) {
        return true;
    }
}
