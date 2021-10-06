package com.vchichvarin.cloudnotesbsc.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import com.vchichvarin.cloudnotesbsc.App
import com.vchichvarin.cloudnotesbsc.R
import com.vchichvarin.cloudnotesbsc.databinding.ActivityMainBinding
import com.vchichvarin.cloudnotesbsc.domain.di.factory.ViewModelFactory
import com.vchichvarin.cloudnotesbsc.domain.model.State
import com.vchichvarin.cloudnotesbsc.ui.viewmodels.MainActivityViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory : ViewModelFactory
    lateinit var viewModel : MainActivityViewModel

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        App.appComponent.inject(this)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel::class.java)

        viewModel.infoState.observe(this, {
            when (it) {
                is State.Success -> {
                    Snackbar.make(binding.root, getString(R.string.snackbar_success_save_note), BaseTransientBottomBar.LENGTH_SHORT).show()
                    viewModel.infoState.postValue(State.Waiting)
                }
                is State.Loading -> {
                    Snackbar.make(binding.root, getString(R.string.snackbar_loading_save_note), BaseTransientBottomBar.LENGTH_SHORT).show()
                    viewModel.infoState.postValue(State.Waiting)
                }
            }
        })

        binding.save.setOnClickListener {
            viewModel.saveNote(binding.edittext.text.toString())
        }

    }
}