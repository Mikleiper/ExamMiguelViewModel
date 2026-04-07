package cat.example.exam3

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import cat.example.exam3.vm.LoginViewModel

class LoginActivity: AppCompatActivity() {
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etNom =findViewById<EditText>(R.id.etUsuari)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        viewModel.loginResult.observe(this) { idUsuari ->
            if(idUsuari != null){
                //val intent = Intent(this, ReservesActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        btnLogin.setOnClickListener{
            val nom = etNom.text.toString()
            val password = etPassword.text.toString()
            if(nom.isNotEmpty() && password.isNotEmpty()){
                viewModel.ferLogin(nom, password)
            }
        }
    }

}