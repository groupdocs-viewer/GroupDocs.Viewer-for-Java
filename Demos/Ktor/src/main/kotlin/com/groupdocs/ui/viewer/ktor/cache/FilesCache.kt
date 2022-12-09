package com.groupdocs.ui.viewer.ktor.cache

interface FilesCache {
    fun createEntry(guid: String, entry: MemoryFilesCacheEntry)
    fun readEntry(guid: String): MemoryFilesCacheEntry
    fun isEntryExist(guid: String): Boolean
}

class MemoryFilesCacheImpl : FilesCache {
    private val maxCacheEntries: Int = defaultMaxCacheEntries
    private val cacheEntries: MutableMap<String, MemoryFilesCacheEntry> = mutableMapOf()

    override fun createEntry(guid: String, entry: MemoryFilesCacheEntry) {
        synchronized(sync) {
            if (cacheEntries.size >= maxCacheEntries) {
                val oldestEntry = cacheEntries.entries.minByOrNull { it.value.lastAccess }!!
                cacheEntries.remove(oldestEntry.key)
            }
            cacheEntries[guid] = entry.copy(
                lastAccess = System.currentTimeMillis()
            )
        }
    }

    override fun readEntry(guid: String): MemoryFilesCacheEntry {
        synchronized(sync) {
            cacheEntries[guid]?.let {
                cacheEntries[guid] = it.copy(
                    lastAccess = System.currentTimeMillis()
                )
                return it
            } ?: throw IllegalStateException("Entry with key $guid does not exist")
        }
    }

    override fun isEntryExist(guid: String): Boolean {
        synchronized(sync) {
            return cacheEntries.containsKey(guid)
        }
    }

    companion object {
        private val sync: Any = Any()
        const val defaultMaxCacheEntries = 16
    }
}

data class MemoryFilesCacheEntry(val lastAccess: Long = 0, val pages: List<MemoryFilesCachePage> = emptyList())
data class MemoryFilesCachePage(val pageNumber: Int, val angle: Int, val width: Int, val height: Int, val data: String?)