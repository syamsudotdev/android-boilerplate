package net.mnsam.core

import kotlinx.coroutines.CoroutineDispatcher

interface CoroutineDispatchers {

    fun main(): CoroutineDispatcher

    fun io(): CoroutineDispatcher

    fun default(): CoroutineDispatcher
}
