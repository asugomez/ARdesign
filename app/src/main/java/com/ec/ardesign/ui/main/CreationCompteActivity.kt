package com.ec.ardesign.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.ec.ardesign.R
import com.ec.ardesign.data.UserRepository
import com.ec.ardesign.data.model.User

class CreationCompteActivity : AppCompatActivity(), View.OnClickListener {

    private var pseudo: EditText?= null
    private var mdp: EditText?= null
    private var mail: EditText?= null
    private var btn: Button?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creation_compte)
        initialize()
        btn!!.setOnClickListener(this)
    }

    fun initialize(){
        pseudo = findViewById(R.id.EditUserCreation)
        mdp = findViewById(R.id.EditMdpCreation)
        mail = findViewById(R.id.EditMail)
        btn = findViewById(R.id.buttonCréer)

    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.buttonCréer ->
            {
                //call api
            }
        }
    }
}