package net.mnsam.core

import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class CoroutineDispatchersImpl @Inject constructor() : CoroutineDispatchers {
    override fun main() = Dispatchers.Main

    override fun io() = Dispatchers.IO

    override fun default() = Dispatchers.Default
}
