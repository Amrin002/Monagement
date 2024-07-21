package com.lctproduction.monagement.config
import android.content.Context
import io.appwrite.Client
import io.appwrite.services.Account
import io.appwrite.services.Databases


class AppWrite (context: Context){


    private val client = Client(context)
        .setEndpoint(ENDPOINT)
        .setProject(PROJECTID)
        .setSelfSigned(true)
    val account: Account = Account(client)
    val databases: Databases = Databases(client)
    companion object {
        const val PROJECTID = "669cb0e1003964bb6999"
        const val ENDPOINT = "https://cloud.appwrite.io/v1"

        const val DATABASEID = "669cb53400106ebf9c6c"

        const val COLLECTIONUSERS = "669cb53a002bf98fe121"
        const val COLLECTIONTRANSACTIONS = "669cb9b5003c41f67f67"
        const val COLLECTIONWALLETS = "669cb83d0007b6c0b47a"

    }
}