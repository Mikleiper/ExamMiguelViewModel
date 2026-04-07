package cat.example.exam3.vm

import android.R.attr.password
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cat.example.exam3.data.LoginRequest
import cat.example.exam3.data.UsuariData
import cat.example.exam3.retrofit.Api
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class LoginViewModel : ViewModel() {
    val loginResult = MutableLiveData<Int?>()

    fun ferLogin(nom: String, pass: String){
        viewModelScope.launch(Dispatchers.IO){
            try{
                val peticio = LoginRequest(nom, pass)
                val resposta = Api.API().login(peticio)
                loginResult.postValue(resposta.id)
            }catch (e: Exception){
                Log.e("API", "Error fent login: ${e.message}")
                loginResult.postValue(null)
            }
        }
    }
}