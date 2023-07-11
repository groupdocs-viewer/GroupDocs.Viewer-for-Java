package com.groupdocs.ui.viewer.javalin.util

open class InternalServerException(
    override val message: String = "Internal server error",
    throwable: Throwable? = null
) : Exception(message, throwable)