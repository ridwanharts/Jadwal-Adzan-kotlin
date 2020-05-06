package com.ridwanharts.jadwaladzan

import android.app.Application
import com.ridwanharts.jadwaladzan.data.db.AppDatabase
import com.ridwanharts.jadwaladzan.data.network.ApiAdzan
import com.ridwanharts.jadwaladzan.data.network.NetConInterceptor
import com.ridwanharts.jadwaladzan.data.repository.AdzanRepository
import com.ridwanharts.jadwaladzan.ui.TestViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MVVMApplication : Application(), KodeinAware{

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@MVVMApplication))

        bind() from singleton { NetConInterceptor(instance()) }
        bind() from singleton { ApiAdzan(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { AdzanRepository(instance(), instance()) }
        bind() from provider { TestViewModelFactory(instance()) }
    }

}