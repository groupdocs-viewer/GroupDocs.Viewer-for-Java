package com.groupdocs.ui.util

open class InternalServerException(override val message: String = "Internal server error", throwable: Throwable? = null) : Exception(message, throwable)