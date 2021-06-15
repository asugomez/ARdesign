package com.ec.ardesign.ui.main


import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.ec.ardesign.R
import com.ec.ardesign.ui.main.viewmodel.MainViewModel

//login
class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var pseudo: EditText?= null
    private var mdp: EditText?= null
    private var btnOK: Button?= null

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialize()
        btnOK!!.setOnClickListener(this)
    }

    fun initialize(){
        pseudo = findViewById(R.id.EditUser)
        mdp = findViewById(R.id.EditMdp)
        btnOK = findViewById(R.id.buttonOk)
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.buttonOk ->
            {
                login()
            }
        }
    }

    fun login(){
        viewModel.connexion(pseudo?.text.toString(), mdp?.text.toString())
        viewModel.user.observe(this){ viewState ->
            when(viewState){
                is MainViewModel.ViewState.Content ->{
                    Toast.makeText(this@MainActivity, "yes", Toast.LENGTH_SHORT)
                        .show()
                }
                is MainViewModel.ViewState.Error -> {
                    Toast.makeText(this@MainActivity, "${viewState.message} ", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }

    }
}