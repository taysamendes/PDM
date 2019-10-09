package com.example.servicos

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    private lateinit var botaoHtml : Button
    private lateinit var botaoDiscar: Button
    private lateinit var botaoLigar : Button
    private lateinit var botaoEmail : Button
    private lateinit var botaoSms : Button
    private lateinit var botaoCompartilhar : Button
    private lateinit var botaoPonto : Button
    private lateinit var botaoRota : Button
    private lateinit var botaoYoutube : Button
    private lateinit var botaoFoto : Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.botaoHtml = findViewById(R.id.btHtml)
        this.botaoHtml.setOnClickListener({OnClickHtml(it)})

        this.botaoDiscar = findViewById(R.id.btDiscar)
        this.botaoDiscar.setOnClickListener({OnClickDiscar(it)})

        this.botaoLigar = findViewById(R.id.btLigar)
        this.botaoLigar.setOnClickListener({OnClickLigar(it)})

        this.botaoEmail = findViewById(R.id.btEmail)
        this.botaoEmail.setOnClickListener({OnClickEmail(it)})

        this.botaoSms = findViewById(R.id.btSms)
        this.botaoSms.setOnClickListener({OnClickSms(it)})

        this.botaoCompartilhar = findViewById(R.id.btCompartilhar)
        this.botaoCompartilhar.setOnClickListener({OnClickCompartilhar(it)})

        this.botaoPonto = findViewById(R.id.btPonto)
        this.botaoPonto.setOnClickListener({OnClickPonto(it)})

        this.botaoRota = findViewById(R.id.btRota)
        this.botaoRota.setOnClickListener({OnClickRota(it)})

        this.botaoYoutube = findViewById(R.id.btYoutube)
        this.botaoYoutube.setOnClickListener({OnClickYoutube(it)})

        this.botaoFoto = findViewById(R.id.btFoto)
        this.botaoFoto.setOnClickListener({OnClickFoto(it)})

    }

    fun OnClickHtml(view : View){
        val uri = Uri.parse("http://pdm.valeriacavalcanti.com.br")
        val it = Intent(Intent.ACTION_VIEW, uri)
        startActivity(it)
    }

    fun OnClickDiscar(view : View){
        val uri = Uri.parse("tel: 36121392")
        val it = Intent(Intent.ACTION_DIAL, uri)
        startActivity(it)
    }

    fun OnClickLigar(view : View){
        val uri = Uri.parse("tel: 32121392")
        val it = Intent(Intent.ACTION_CALL, uri)
        val call = Manifest.permission.CALL_PHONE
        val granted = PackageManager.PERMISSION_GRANTED

        if(ContextCompat.checkSelfPermission(this,call) == granted){
            startActivity(it)
        }
    }

    fun OnClickEmail(view : View){
        val uri = Uri.parse("mailto:valeria.cavalcanti@ifpb.edu.br")
        val it = Intent(Intent.ACTION_SENDTO, uri)
        it.putExtra(Intent.EXTRA_SUBJECT, "Assunto")
        it.putExtra(Intent.EXTRA_TEXT,"Texto")
        startActivity(it)
    }

    fun OnClickSms(view : View){
        val uri = Uri.parse("sms:36121392")
        val it = Intent(Intent.ACTION_SENDTO, uri)
        it.putExtra("sms_body", "Mensagem")
        startActivity(it)

    }

    fun OnClickCompartilhar(view : View){
        val it = Intent(Intent.ACTION_SEND)
        it.setType("text/plain")
        it.putExtra(Intent.EXTRA_TEXT,"Texto para compartilhar")

        startActivity(Intent.createChooser(it,"Compartilhar"))

    }

    fun OnClickPonto(view : View){
        val uri = Uri.parse("geo:-7.1356496,-34.8760932")
        val it = Intent(Intent.ACTION_VIEW, uri)
        startActivity(it)

    }

    fun OnClickRota(view : View){
        val origem = "-7.1356496,-34.8760932"
        val destino = "-7.1181836 , -34.8730402"
        val url = "https://www.google.com/maps"


    }

    fun OnClickYoutube(view : View){

    }

    fun OnClickFoto(view : View){

    }
}
