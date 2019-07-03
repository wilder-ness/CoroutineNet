package win.regin.coroutine.net

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author :Reginer in  2017/9/7 23:19.
 * 联系方式:QQ:282921012
 * 功能描述:请求
 */
object NetApi {
    private fun getApi(): NetApiService {
        return Retrofit.Builder().baseUrl(Urls.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .client(getOkHttpClient(getLoggingInterceptor())).build().create(NetApiService::class.java)
    }

    private fun getOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder().apply { addInterceptor(interceptor) }.build()
    }

    private fun getLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    }

    fun getWeChatSubscription() = getApi().getWeChatSubscription()
}