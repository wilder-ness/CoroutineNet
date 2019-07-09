package win.regin.coroutine

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import win.regin.coroutine.net.NetApi
import win.regin.coroutine.net.ViewState

/**
 * @author :Reginer in  2018/12/7 16:55.
 * 联系方式:QQ:282921012
 * 功能描述:
 */
class MainModel : BaseViewModel() {
    val mWxSubscription: MutableLiveData<ViewState<List<WeChatSubscriptionEntity>>> = MutableLiveData()
    fun getWxSubscription() {
        viewModelScope.launch {
            //TODO 改进
            runCatching {
                NetApi.getWeChatSubscription()
            }.onSuccess {
                paresResult(mWxSubscription, it)
                Log.d("success", it.toString())
            }.onFailure {
                paresException(it, mWxSubscription)
                Log.d("error", it.toString())
            }
        }
    }

}
