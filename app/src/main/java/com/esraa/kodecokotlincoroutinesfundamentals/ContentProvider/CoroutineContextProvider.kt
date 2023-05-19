package com.esraa.kodecokotlincoroutinesfundamentals.ContentProvider

import kotlin.coroutines.CoroutineContext

interface CoroutineContextProvider {
    fun context():CoroutineContext
}