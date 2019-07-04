package win.regin.coroutine

import android.net.ParseException
import android.util.Log
import androidx.lifecycle.*
import com.google.gson.JsonParseException
import org.json.JSONException
import retrofit2.HttpException
import win.regin.coroutine.net.ViewState
import java.io.InterruptedIOException
import java.net.ConnectException
import java.net.UnknownHostException

/**
 * @author :Reginer in  2018/12/7 16:47.
 * 联系方式:QQ:282921012
 * 功能描述:
 */
open class BaseViewModel : ViewModel() {


    fun <T> launchWork(block: BaseEntity<T>, viewState: MutableLiveData<ViewState<T>>) {
        //TODO 改进
        runCatching {
            block
        }.onSuccess {
            paresResult(viewState, it)
            Log.d("success", it.toString())
        }.onFailure {
            paresException(it, viewState)
            Log.d("error", it.toString())
        }
    }


    /**
     * 处理返回值
     */
    fun <T> paresResult(viewState: MutableLiveData<ViewState<T>>, result: BaseEntity<T>) {
        when (result.errorCode ) {
            0-> if (result.data != null) {
                viewState.value = ViewState.result(result.data)
            } else {
                viewState.value = ViewState.empty()
            }
            -10->{
                viewState.value = ViewState.tokenError()
            }
            else ->{
                viewState.value = ViewState.error(result.errorMsg ?: "")
            }
        }
    }


    /**
     * 异常转换异常处理
     *
     * @param e
     */
    fun <T> paresException(e: Throwable, viewState: MutableLiveData<ViewState<T>>) {
        viewState.value = ViewState.error("判断异常返回异常提示")
    }

}
