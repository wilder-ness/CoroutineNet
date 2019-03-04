package win.regin.coroutine

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import win.regin.coroutine.net.NetApi

/**
 * @author :Reginer in  2018/12/7 16:55.
 * 联系方式:QQ:282921012
 * 功能描述:
 */
class MainModel2 : ViewModel() {
    val mWxSubscription: MutableLiveData<BaseEntity<List<WeChatSubscriptionEntity>>> = MutableLiveData()
    fun getWxSubscription(onNetStart: () -> Unit, onNetComplete: () -> Unit) {

        viewModelScope.launch {
            runCatching {
                onNetStart()
                NetApi.getWeChatSubscription().await()
            }.onSuccess {
                mWxSubscription.value = it
            }.onFailure {
                Log.e("Reginer", Log.getStackTraceString(it))
            }
            onNetComplete()
        }

    }



}
