package net.sf.sevenzipjbinding;

/**
 * Index type parameter for {@link IArchiveExtractCallback#reportExtractResult(ReportExtractResultIndexType, int, ExtractOperationResult)}.
 * 
 * This enum corresponds to 7-zip's NEventIndexType namespace and indicates what kind of index
 * is being reported in extract result callbacks.
 * 
 * @author Boris Brodski
 * @since [version to be determined]
 */
public enum ReportExtractResultIndexType {
    /**
     * No index available or applicable.
     */
    NO_INDEX(0),
    
    /**
     * Index in the input (source) archive. Used when reporting errors for specific files 
     * within the archive being extracted.
     */
    IN_ARCHIVE_INDEX(1),
    
    /**
     * Block index. Used for multi-volume or compressed block-level operations.
     */
    BLOCK_INDEX(2),
    
    /**
     * Index in the output (destination) archive. Less commonly used.
     */
    OUT_ARCHIVE_INDEX(3);

    private final int value;

    ReportExtractResultIndexType(int value) {
        this.value = value;
    }

    /**
     * Get the integer value corresponding to this index type.
     * 
     * @return the integer value
     */
    public int getValue() {
        return value;
    }

    /**
     * Convert an integer index to its corresponding enumeration value.
     * 
     * @param index the integer index (typically from 7-zip native code)
     * @return the corresponding ReportExtractResultIndexType, or NO_INDEX if out of range
     */
    public static ReportExtractResultIndexType getIndexType(int index) {
        switch (index) {
            case 0: return NO_INDEX;
            case 1: return IN_ARCHIVE_INDEX;
            case 2: return BLOCK_INDEX;
            case 3: return OUT_ARCHIVE_INDEX;
            default: return NO_INDEX;
        }
    }
}
