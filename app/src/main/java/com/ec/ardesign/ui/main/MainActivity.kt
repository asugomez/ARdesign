package com.ec.ardesign.ui.main


import android.content.Intent
import android.os.Bundle
import android.util.Log
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
                val pseudoTxt = pseudo?.text.toString()
                val mdpTxt = mdp?.text.toString()
                if(pseudoTxt.isEmpty() or mdpTxt.isEmpty()) {
                    Toast.makeText(
                        this@MainActivity, "Data is missing", Toast.LENGTH_LONG
                    ).show()
                }
                else{
                    login(pseudoTxt, mdpTxt)
                }
            }
        }
    }

    fun login(pseudo: String, mdp:String){
        Toast.makeText(this@MainActivity,mdp, Toast.LENGTH_SHORT)
            .show()

        viewModel.connexion(pseudo, mdp)
        Log.i("PMR", "here in main activity login")
        Toast.makeText(this@MainActivity,viewModel.user.toString(), Toast.LENGTH_SHORT)
            .show()
        viewModel.user.observe(this){ viewState ->
            when(viewState){

                is MainViewModel.ViewState.Content -> {
                    Toast.makeText(this@MainActivity,"im here in content ", Toast.LENGTH_SHORT)
                        .show()
                    val versAccueil = Intent(this, AccueilActivity::class.java)
                    //intent.flags =
                    //    Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    //versAccueil.putExtra("hash",  )
                    startActivity(versAccueil)
                }
                is MainViewModel.ViewState.Error -> {
                    Toast.makeText(this@MainActivity,"Something wrong happened", Toast.LENGTH_SHORT)
                        .show()
                    Toast.makeText(this@MainActivity, "${viewState.message} ", Toast.LENGTH_SHORT)
                        .show()
                }

            }
        }

    }
}

/*
is MainViewModel.ViewState.Content ->{
                    Toast.makeText(this@MainActivity, "yes", Toast.LENGTH_SHORT)
                        .show()
                }
                is MainViewModel.ViewState.Error -> {
                    Toast.makeText(this@MainActivity, "${viewState.message} ", Toast.LENGTH_SHORT)
                        .show()
                }
 */