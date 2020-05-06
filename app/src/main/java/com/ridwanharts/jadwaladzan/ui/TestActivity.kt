package com.ridwanharts.jadwaladzan.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.ridwanharts.jadwaladzan.Coroutines
import com.ridwanharts.jadwaladzan.R
import com.ridwanharts.jadwaladzan.databinding.ActivityTestBinding
import kotlinx.android.synthetic.main.activity_test.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class TestActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()
    private val factory : TestViewModelFactory by instance<TestViewModelFactory>()

    private lateinit var viewModel: TestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_test)

        val testAdapter = TestAdapter()
        val binding: ActivityTestBinding = DataBindingUtil.setContentView(this, R.layout.activity_test)
        viewModel = ViewModelProvider(this, factory)[TestViewModel::class.java]
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        viewModel.data.observe(this, Observer {
            Toast.makeText(this, it.tanggal, Toast.LENGTH_LONG).show()
            testAdapter.setTimeAdzan(viewModel.filterTimeAdzan())
            testAdapter.notifyDataSetChanged()
        })

        with(rv_adzan){
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = testAdapter

        }

        Coroutines.main {
            val data = viewModel.getData.await()
            data.observe(this, Observer {
                //Toast.makeText(applicationContext, it.imsak , Toast.LENGTH_LONG).show()

            })
        }
    }

}
