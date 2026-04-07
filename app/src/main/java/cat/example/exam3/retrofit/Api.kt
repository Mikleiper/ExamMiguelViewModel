package cat.example.exam3.retrofit

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Api {

    companion object {
        private var mItemAPI: Service? = null

        @Synchronized
        fun API(): Service {
            if (mItemAPI == null) {

                val gsondateformat = GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                    .create()

                mItemAPI = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create(gsondateformat))
                    .baseUrl("https://oracleitic.mooo.com/")
                    .build()
                    .create(Service::class.java)
            }
            return mItemAPI!!
        }
    }
}
