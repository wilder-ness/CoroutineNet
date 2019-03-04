package win.regin.coroutine

import android.util.Log
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import win.regin.coroutine.net.NetApi

/**
 * @author :Reginer in  2018/12/7 16:55.
 * 联系方式:QQ:282921012
 * 功能描述:
 */
class MainModel : BaseViewModel() {
    val mWxSubscription: MutableLiveData<BaseEntity<List<WeChatSubscriptionEntity>>> = MutableLiveData()
    fun getWxSubscription(onNetStart: () -> Unit, onNetComplete: () -> Unit) {
        launchOnUITryCatch({
            onNetStart()
            mWxSubscription.value = withContext(IO) { NetApi.getWeChatSubscription() }.await()
        }, {
            Log.e("Reginer", Log.getStackTraceString(it))
        }, {
            onNetComplete()
        }, BuildConfig.DEBUG)
    }

}
