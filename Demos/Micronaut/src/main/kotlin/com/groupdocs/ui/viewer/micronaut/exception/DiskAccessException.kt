package com.groupdocs.ui.viewer.micronaut.exception

/**
 * Wrapper for disk access exceptions
 */
class DiskAccessException(message: String, path: String) : RuntimeException("Can not $message. Path is $path")