package com.esraa.kodecokotlincoroutinesfundamentals.ContentProvider

import kotlin.coroutines.CoroutineContext

class CoroutineContextProviderImp(
    private val context: CoroutineContext
):CoroutineContextProvider {
    override fun context(): CoroutineContext = context
}